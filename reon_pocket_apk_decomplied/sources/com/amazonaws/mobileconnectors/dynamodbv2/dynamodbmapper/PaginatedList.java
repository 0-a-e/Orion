package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public abstract class PaginatedList<T> implements List<T> {
    private static final String ITERATION_ONLY_UNSUPPORTED_OPERATION_MESSAGE = " is not supported when using ITERATION_ONLY configuration.";
    private static final String UNMODIFIABLE_MESSAGE = "This is an unmodifiable list";
    protected final List<T> allResults;
    protected boolean allResultsLoaded;
    protected final Class<T> clazz;
    protected final AmazonDynamoDB dynamo;
    /* access modifiers changed from: private */
    public boolean iterationStarted;
    protected final DynamoDBMapper mapper;
    protected final List<T> nextResults;
    private final DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy;

    /* access modifiers changed from: protected */
    public abstract boolean atEndOfResults();

    /* access modifiers changed from: protected */
    public abstract List<T> fetchNextPage();

    public PaginatedList(DynamoDBMapper dynamoDBMapper, Class<T> cls, AmazonDynamoDB amazonDynamoDB) {
        this(dynamoDBMapper, cls, amazonDynamoDB, (DynamoDBMapperConfig.PaginationLoadingStrategy) null);
    }

    public PaginatedList(DynamoDBMapper dynamoDBMapper, Class<T> cls, AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy2) {
        this.allResultsLoaded = false;
        this.nextResults = new LinkedList();
        this.iterationStarted = false;
        this.mapper = dynamoDBMapper;
        this.clazz = cls;
        this.dynamo = amazonDynamoDB;
        this.paginationLoadingStrategy = paginationLoadingStrategy2 == null ? DynamoDBMapperConfig.PaginationLoadingStrategy.LAZY_LOADING : paginationLoadingStrategy2;
        this.allResults = new ArrayList();
    }

    public synchronized void loadAllResults() {
        checkUnsupportedOperationForIterationOnlyMode("loadAllResults()");
        if (!this.allResultsLoaded) {
            while (nextResultsAvailable()) {
                moveNextResults(false);
            }
            this.allResultsLoaded = true;
        }
    }

    /* access modifiers changed from: private */
    public boolean nextResultsAvailable() {
        return !this.nextResults.isEmpty() || loadNextResults();
    }

    private synchronized boolean loadNextResults() {
        if (atEndOfResults()) {
            return false;
        }
        do {
            this.nextResults.addAll(fetchNextPage());
            if (atEndOfResults() || !this.nextResults.isEmpty()) {
            }
            this.nextResults.addAll(fetchNextPage());
            break;
        } while (!this.nextResults.isEmpty());
        return !this.nextResults.isEmpty();
    }

    /* access modifiers changed from: private */
    public void moveNextResults(boolean z) {
        if (z) {
            this.allResults.clear();
        }
        this.allResults.addAll(this.nextResults);
        this.nextResults.clear();
    }

    public Iterator<T> iterator() {
        return new PaginatedListIterator(this.paginationLoadingStrategy == DynamoDBMapperConfig.PaginationLoadingStrategy.ITERATION_ONLY);
    }

    private class PaginatedListIterator implements Iterator<T> {
        private final List<T> allResultsCopy;
        private Iterator<T> innerIterator;
        private final boolean iterationOnly;
        private int pos = 0;

        public PaginatedListIterator(boolean z) {
            this.iterationOnly = z;
            if (z) {
                synchronized (PaginatedList.this) {
                    if (!PaginatedList.this.iterationStarted) {
                        boolean unused = PaginatedList.this.iterationStarted = true;
                    } else {
                        throw new UnsupportedOperationException("The list could only be iterated once in ITERATION_ONLY mode.");
                    }
                }
                this.allResultsCopy = null;
                this.innerIterator = PaginatedList.this.allResults.iterator();
                return;
            }
            ArrayList arrayList = new ArrayList();
            this.allResultsCopy = arrayList;
            arrayList.addAll(PaginatedList.this.allResults);
            this.innerIterator = arrayList.iterator();
        }

        public boolean hasNext() {
            return this.innerIterator.hasNext() || PaginatedList.this.nextResultsAvailable();
        }

        public T next() {
            if (!this.innerIterator.hasNext()) {
                if (this.iterationOnly || PaginatedList.this.allResults.size() == this.allResultsCopy.size()) {
                    if (PaginatedList.this.nextResultsAvailable()) {
                        PaginatedList.this.moveNextResults(this.iterationOnly);
                    } else {
                        throw new NoSuchElementException();
                    }
                }
                if (this.iterationOnly) {
                    this.innerIterator = PaginatedList.this.allResults.iterator();
                } else {
                    if (PaginatedList.this.allResults.size() > this.allResultsCopy.size()) {
                        this.allResultsCopy.addAll(PaginatedList.this.allResults.subList(this.allResultsCopy.size(), PaginatedList.this.allResults.size()));
                    }
                    this.innerIterator = this.allResultsCopy.listIterator(this.pos);
                }
            }
            this.pos++;
            return this.innerIterator.next();
        }

        public void remove() {
            throw new UnsupportedOperationException(PaginatedList.UNMODIFIABLE_MESSAGE);
        }
    }

    public boolean isEmpty() {
        checkUnsupportedOperationForIterationOnlyMode("isEmpty()");
        return !iterator().hasNext();
    }

    public T get(int i) {
        checkUnsupportedOperationForIterationOnlyMode("get(int n)");
        while (this.allResults.size() <= i && nextResultsAvailable()) {
            moveNextResults(false);
        }
        return this.allResults.get(i);
    }

    public boolean contains(Object obj) {
        checkUnsupportedOperationForIterationOnlyMode("contains(Object arg0)");
        if (this.allResults.contains(obj)) {
            return true;
        }
        while (nextResultsAvailable()) {
            boolean contains = this.nextResults.contains(obj);
            moveNextResults(false);
            if (contains) {
                return true;
            }
        }
        return false;
    }

    public List<T> subList(int i, int i2) {
        checkUnsupportedOperationForIterationOnlyMode("subList(int arg0, int arg1)");
        while (this.allResults.size() < i2 && nextResultsAvailable()) {
            moveNextResults(false);
        }
        return Collections.unmodifiableList(this.allResults.subList(i, i2));
    }

    public int indexOf(Object obj) {
        checkUnsupportedOperationForIterationOnlyMode("indexOf(Object org0)");
        int indexOf = this.allResults.indexOf(obj);
        if (indexOf >= 0) {
            return indexOf;
        }
        while (nextResultsAvailable()) {
            int indexOf2 = this.nextResults.indexOf(obj);
            int size = this.allResults.size();
            moveNextResults(false);
            if (indexOf2 >= 0) {
                return indexOf2 + size;
            }
        }
        return -1;
    }

    public int size() {
        loadAllResults();
        return this.allResults.size();
    }

    public boolean containsAll(Collection<?> collection) {
        loadAllResults();
        return this.allResults.containsAll(collection);
    }

    public int lastIndexOf(Object obj) {
        loadAllResults();
        return this.allResults.lastIndexOf(obj);
    }

    public Object[] toArray() {
        loadAllResults();
        return this.allResults.toArray();
    }

    public <X> X[] toArray(X[] xArr) {
        loadAllResults();
        return this.allResults.toArray(xArr);
    }

    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("ListIterators are not supported for this list");
    }

    public ListIterator<T> listIterator(int i) {
        throw new UnsupportedOperationException("ListIterators are not supported for this list");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public T remove(int i) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public T set(int i, T t) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public void add(int i, T t) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    public void clear() {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    /* access modifiers changed from: package-private */
    public void checkUnsupportedOperationForIterationOnlyMode(String str) {
        if (this.paginationLoadingStrategy == DynamoDBMapperConfig.PaginationLoadingStrategy.ITERATION_ONLY) {
            throw new UnsupportedOperationException(str + ITERATION_ONLY_UNSUPPORTED_OPERATION_MESSAGE);
        }
    }
}
