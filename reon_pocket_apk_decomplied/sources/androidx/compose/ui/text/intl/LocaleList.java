package androidx.compose.ui.text.intl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002¢\u0006\u0002\u0010\bB\u0013\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0016\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\u0013\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0011\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0004H\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/intl/LocaleList;", "", "Landroidx/compose/ui/text/intl/Locale;", "languageTags", "", "(Ljava/lang/String;)V", "locales", "", "([Landroidx/compose/ui/text/intl/Locale;)V", "localeList", "", "(Ljava/util/List;)V", "getLocaleList", "()Ljava/util/List;", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "equals", "other", "", "get", "i", "hashCode", "isEmpty", "iterator", "", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LocaleList.kt */
public final class LocaleList implements Collection<Locale>, KMappedMarker {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<Locale> localeList;
    private final int size;

    public boolean add(Locale locale) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends Locale> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeIf(Predicate<? super Locale> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray(this, tArr);
    }

    public LocaleList(List<Locale> list) {
        this.localeList = list;
        this.size = list.size();
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Locale)) {
            return false;
        }
        return contains((Locale) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/intl/LocaleList$Companion;", "", "()V", "current", "Landroidx/compose/ui/text/intl/LocaleList;", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LocaleList.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LocaleList getCurrent() {
            return PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent();
        }
    }

    public final List<Locale> getLocaleList() {
        return this.localeList;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocaleList(java.lang.String r7) {
        /*
            r6 = this;
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r7 = ","
            java.lang.String[] r1 = new java.lang.String[]{r7}
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            java.util.List r7 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r0, (java.lang.String[]) r1, (boolean) r2, (int) r3, (int) r4, (java.lang.Object) r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            int r1 = r7.size()
            r3 = r2
        L_0x001f:
            if (r3 >= r1) goto L_0x003a
            java.lang.Object r4 = r7.get(r3)
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.String r4 = (java.lang.String) r4
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r4 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r4)
            java.lang.String r4 = r4.toString()
            r5.add(r4)
            int r3 = r3 + 1
            goto L_0x001f
        L_0x003a:
            java.util.List r0 = (java.util.List) r0
            java.util.ArrayList r7 = new java.util.ArrayList
            int r1 = r0.size()
            r7.<init>(r1)
            int r1 = r0.size()
        L_0x0049:
            if (r2 >= r1) goto L_0x005f
            java.lang.Object r3 = r0.get(r2)
            r4 = r7
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.String r3 = (java.lang.String) r3
            androidx.compose.ui.text.intl.Locale r5 = new androidx.compose.ui.text.intl.Locale
            r5.<init>((java.lang.String) r3)
            r4.add(r5)
            int r2 = r2 + 1
            goto L_0x0049
        L_0x005f:
            java.util.List r7 = (java.util.List) r7
            r6.<init>((java.util.List<androidx.compose.ui.text.intl.Locale>) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.intl.LocaleList.<init>(java.lang.String):void");
    }

    public LocaleList(Locale... localeArr) {
        this((List<Locale>) ArraysKt.toList((T[]) localeArr));
    }

    public final Locale get(int i) {
        return this.localeList.get(i);
    }

    public int getSize() {
        return this.size;
    }

    public boolean contains(Locale locale) {
        return this.localeList.contains(locale);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return this.localeList.containsAll(collection);
    }

    public boolean isEmpty() {
        return this.localeList.isEmpty();
    }

    public Iterator<Locale> iterator() {
        return this.localeList.iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocaleList) && Intrinsics.areEqual((Object) this.localeList, (Object) ((LocaleList) obj).localeList);
    }

    public int hashCode() {
        return this.localeList.hashCode();
    }

    public String toString() {
        return "LocaleList(localeList=" + this.localeList + ')';
    }
}
