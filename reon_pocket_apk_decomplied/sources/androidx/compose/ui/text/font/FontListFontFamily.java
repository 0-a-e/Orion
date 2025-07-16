package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0003J\u0017\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0003J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0011\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J\t\u0010\u0019\u001a\u00020\rH\u0001J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0003J\u0011\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H\u0001J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0001J\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u0016\u001a\u00020\tH\u0001J\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0001J\b\u0010\"\u001a\u00020#H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamily;", "Landroidx/compose/ui/text/font/FileBasedFontFamily;", "", "Landroidx/compose/ui/text/font/Font;", "fonts", "(Ljava/util/List;)V", "getFonts", "()Ljava/util/List;", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FontFamily.kt */
public final class FontListFontFamily extends FileBasedFontFamily implements List<Font>, KMappedMarker {
    public static final int $stable = 0;
    private final /* synthetic */ List<Font> $$delegate_0;
    private final List<Font> fonts;

    public void add(int i, Font font) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Font font) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection<? extends Font> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends Font> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Font font) {
        return this.$$delegate_0.contains(font);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return this.$$delegate_0.containsAll(collection);
    }

    public Font get(int i) {
        return this.$$delegate_0.get(i);
    }

    public int getSize() {
        return this.$$delegate_0.size();
    }

    public int indexOf(Font font) {
        return this.$$delegate_0.indexOf(font);
    }

    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    public Iterator<Font> iterator() {
        return this.$$delegate_0.iterator();
    }

    public int lastIndexOf(Font font) {
        return this.$$delegate_0.lastIndexOf(font);
    }

    public ListIterator<Font> listIterator() {
        return this.$$delegate_0.listIterator();
    }

    public ListIterator<Font> listIterator(int i) {
        return this.$$delegate_0.listIterator(i);
    }

    public Font remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator<Font> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Font set(int i, Font font) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void sort(Comparator<? super Font> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<Font> subList(int i, int i2) {
        return this.$$delegate_0.subList(i, i2);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray(this, tArr);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Font)) {
            return false;
        }
        return contains((Font) obj);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Font)) {
            return -1;
        }
        return indexOf((Font) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Font)) {
            return -1;
        }
        return lastIndexOf((Font) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public FontListFontFamily(List<? extends Font> list) {
        super((DefaultConstructorMarker) null);
        this.$$delegate_0 = list;
        Collection collection = list;
        if (!collection.isEmpty()) {
            this.fonts = new ArrayList(collection);
            return;
        }
        throw new IllegalStateException("At least one font should be passed to FontFamily".toString());
    }

    public final List<Font> getFonts() {
        return this.fonts;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FontListFontFamily) && Intrinsics.areEqual((Object) this.fonts, (Object) ((FontListFontFamily) obj).fonts);
    }

    public int hashCode() {
        return this.fonts.hashCode();
    }

    public String toString() {
        return "FontListFontFamily(fonts=" + this.fonts + ')';
    }
}
