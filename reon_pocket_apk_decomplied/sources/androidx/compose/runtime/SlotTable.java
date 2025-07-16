package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0015J\u000e\u00105\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0007J\u0006\u00106\u001a\u000207J=\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2&\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'\u0018\u00010&j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'\u0018\u0001`(H\u0000¢\u0006\u0002\b<J\u00108\u001a\u0002092\u0006\u00101\u001a\u00020=2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2&\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'\u0018\u00010&j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'\u0018\u0001`(H\u0000¢\u0006\u0004\b<\u0010>J\u0006\u0010?\u001a\u00020\u001aJ\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00150AH\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010\u00032\u0006\u0010C\u001a\u00020\u001eH\u0016J\u0012\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u0015H\u0002J\u0016\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0007J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00150AH\u0002J\u001d\u0010J\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010A2\u0006\u0010K\u001a\u00020\u0015H\u0000¢\u0006\u0002\bLJ\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00030NH\u0002J\u000e\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00150AH\u0002J\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00150AH\u0002J\u0006\u0010Q\u001a\u00020;J\u0006\u0010R\u001a\u00020=J\u000e\u0010S\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u0007J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00150AH\u0002J7\u0010U\u001a\u0002HV\"\u0004\b\u0000\u0010V2!\u0010W\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\bY\u0012\b\bZ\u0012\u0004\b\b(:\u0012\u0004\u0012\u0002HV0XH\b¢\u0006\u0002\u0010[Jw\u0010\\\u001a\u0002092\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2&\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'\u0018\u00010&j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'\u0018\u0001`(H\u0000¢\u0006\u0004\b]\u0010^J\u001f\u0010_\u001a\u0004\u0018\u00010\u001e2\u0006\u0010F\u001a\u00020\u00152\u0006\u0010`\u001a\u00020\u0015H\u0000¢\u0006\u0002\baJ\u001d\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0A2\u0006\u0010F\u001a\u00020\u0015H\u0000¢\u0006\u0002\bcJ\u0010\u0010d\u001a\u0004\u0018\u00010'2\u0006\u0010F\u001a\u00020\u0015J\u0010\u0010e\u001a\u0004\u0018\u00010\u00072\u0006\u00104\u001a\u00020\u0015J\u0006\u0010f\u001a\u000209J7\u0010g\u001a\u0002HV\"\u0004\b\u0000\u0010V2!\u0010W\u001a\u001d\u0012\u0013\u0012\u00110=¢\u0006\f\bY\u0012\b\bZ\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002HV0XH\b¢\u0006\u0002\u0010[J \u0010h\u001a\u00020\u0015*\u00060ij\u0002`j2\u0006\u00104\u001a\u00020\u00152\u0006\u0010k\u001a\u00020\u0015H\u0002R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R0\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d@BX\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R:\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'\u0018\u00010&j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'\u0018\u0001`(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u00100R\u001e\u00101\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001b¨\u0006l"}, d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "()V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime_release", "()Ljava/util/ArrayList;", "setAnchors$runtime_release", "(Ljava/util/ArrayList;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "<set-?>", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "isEmpty", "", "()Z", "readers", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "getSourceInformationMap$runtime_release", "()Ljava/util/HashMap;", "setSourceInformationMap$runtime_release", "(Ljava/util/HashMap;)V", "version", "getVersion$runtime_release", "setVersion$runtime_release", "(I)V", "writer", "getWriter$runtime_release", "anchor", "index", "anchorIndex", "asString", "", "close", "", "reader", "Landroidx/compose/runtime/SlotReader;", "close$runtime_release", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;)V", "containsMark", "dataIndexes", "", "find", "identityToFind", "findEffectiveRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "group", "groupContainsAnchor", "groupIndex", "groupSizes", "invalidateGroupsWithKey", "target", "invalidateGroupsWithKey$runtime_release", "iterator", "", "keys", "nodes", "openReader", "openWriter", "ownsAnchor", "parentIndexes", "read", "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setTo", "setTo$runtime_release", "([II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;)V", "slot", "slotIndex", "slot$runtime_release", "slotsOf", "slotsOf$runtime_release", "sourceInformationOf", "tryAnchor", "verifyWellFormed", "write", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    public static final int $stable = 8;
    private ArrayList<Anchor> anchors = new ArrayList<>();
    private int[] groups = new int[0];
    private int groupsSize;
    private int readers;
    private Object[] slots = new Object[0];
    private int slotsSize;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private int version;
    private boolean writer;

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final boolean getWriter$runtime_release() {
        return this.writer;
    }

    public final int getVersion$runtime_release() {
        return this.version;
    }

    public final void setVersion$runtime_release(int i) {
        this.version = i;
    }

    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    public final void setAnchors$runtime_release(ArrayList<Anchor> arrayList) {
        this.anchors = arrayList;
    }

    public final HashMap<Anchor, GroupSourceInformation> getSourceInformationMap$runtime_release() {
        return this.sourceInformationMap;
    }

    public final void setSourceInformationMap$runtime_release(HashMap<Anchor, GroupSourceInformation> hashMap) {
        this.sourceInformationMap = hashMap;
    }

    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    public final <T> T read(Function1<? super SlotReader, ? extends T> function1) {
        SlotReader openReader = openReader();
        try {
            return function1.invoke(openReader);
        } finally {
            InlineMarker.finallyStart(1);
            openReader.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final <T> T write(Function1<? super SlotWriter, ? extends T> function1) {
        SlotWriter openWriter = openWriter();
        try {
            return function1.invoke(openWriter);
        } finally {
            InlineMarker.finallyStart(1);
            openWriter.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final SlotReader openReader() {
        if (!this.writer) {
            this.readers++;
            return new SlotReader(this);
        }
        throw new IllegalStateException("Cannot read while a writer is pending".toString());
    }

    public final SlotWriter openWriter() {
        if (!this.writer) {
            if (this.readers <= 0) {
                this.writer = true;
                this.version++;
                return new SlotWriter(this);
            }
            ComposerKt.composeRuntimeError("Cannot start a writer when a reader is pending".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Cannot start a writer when another writer is pending".toString());
        throw new KotlinNothingValueException();
    }

    public final Anchor anchor(int i) {
        int i2;
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("use active SlotWriter to create an anchor location instead".toString());
            throw new KotlinNothingValueException();
        } else if (i < 0 || i >= (i2 = this.groupsSize)) {
            throw new IllegalArgumentException("Parameter index is out of range".toString());
        } else {
            ArrayList<Anchor> arrayList = this.anchors;
            int access$search = SlotTableKt.search(arrayList, i, i2);
            if (access$search >= 0) {
                return arrayList.get(access$search);
            }
            Anchor anchor = new Anchor(i);
            arrayList.add(-(access$search + 1), anchor);
            return anchor;
        }
    }

    public final Anchor tryAnchor(int i) {
        int i2;
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("use active SlotWriter to crate an anchor for location instead".toString());
            throw new KotlinNothingValueException();
        } else if (i < 0 || i >= (i2 = this.groupsSize)) {
            return null;
        } else {
            return SlotTableKt.find(this.anchors, i, i2);
        }
    }

    public final int anchorIndex(Anchor anchor) {
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Use active SlotWriter to determine anchor location instead".toString());
            throw new KotlinNothingValueException();
        } else if (anchor.getValid()) {
            return anchor.getLocation$runtime_release();
        } else {
            throw new IllegalArgumentException("Anchor refers to a group that was removed".toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.compose.runtime.SlotTableKt.access$search(r3.anchors, r4.getLocation$runtime_release(), r3.groupsSize);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean ownsAnchor(androidx.compose.runtime.Anchor r4) {
        /*
            r3 = this;
            boolean r0 = r4.getValid()
            if (r0 == 0) goto L_0x0022
            java.util.ArrayList<androidx.compose.runtime.Anchor> r0 = r3.anchors
            int r1 = r4.getLocation$runtime_release()
            int r2 = r3.groupsSize
            int r0 = androidx.compose.runtime.SlotTableKt.search(r0, r1, r2)
            if (r0 < 0) goto L_0x0022
            java.util.ArrayList<androidx.compose.runtime.Anchor> r1 = r3.anchors
            java.lang.Object r0 = r1.get(r0)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0022
            r4 = 1
            goto L_0x0023
        L_0x0022:
            r4 = 0
        L_0x0023:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotTable.ownsAnchor(androidx.compose.runtime.Anchor):boolean");
    }

    public final boolean groupContainsAnchor(int i, Anchor anchor) {
        if (!this.writer) {
            if (i >= 0 && i < this.groupsSize) {
                if (ownsAnchor(anchor)) {
                    int access$groupSize = SlotTableKt.groupSize(this.groups, i) + i;
                    int location$runtime_release = anchor.getLocation$runtime_release();
                    if (i <= location$runtime_release && location$runtime_release < access$groupSize) {
                        return true;
                    }
                }
                return false;
            }
            ComposerKt.composeRuntimeError("Invalid group index".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Writer is active".toString());
        throw new KotlinNothingValueException();
    }

    public final void close$runtime_release(SlotReader slotReader, HashMap<Anchor, GroupSourceInformation> hashMap) {
        if (slotReader.getTable$runtime_release() == this && this.readers > 0) {
            this.readers--;
            if (hashMap != null) {
                synchronized (this) {
                    HashMap<Anchor, GroupSourceInformation> hashMap2 = this.sourceInformationMap;
                    if (hashMap2 != null) {
                        hashMap2.putAll(hashMap);
                    } else {
                        this.sourceInformationMap = hashMap;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("Unexpected reader close()".toString());
        throw new KotlinNothingValueException();
    }

    public final void close$runtime_release(SlotWriter slotWriter, int[] iArr, int i, Object[] objArr, int i2, ArrayList<Anchor> arrayList, HashMap<Anchor, GroupSourceInformation> hashMap) {
        if (slotWriter.getTable$runtime_release() != this || !this.writer) {
            throw new IllegalArgumentException("Unexpected writer close()".toString());
        }
        this.writer = false;
        setTo$runtime_release(iArr, i, objArr, i2, arrayList, hashMap);
    }

    public final void setTo$runtime_release(int[] iArr, int i, Object[] objArr, int i2, ArrayList<Anchor> arrayList, HashMap<Anchor, GroupSourceInformation> hashMap) {
        this.groups = iArr;
        this.groupsSize = i;
        this.slots = objArr;
        this.slotsSize = i2;
        this.anchors = arrayList;
        this.sourceInformationMap = hashMap;
    }

    /* JADX INFO: finally extract failed */
    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release(int i) {
        List arrayList = new ArrayList();
        List<RecomposeScopeImpl> arrayList2 = new ArrayList<>();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        SlotReader openReader = openReader();
        try {
            invalidateGroupsWithKey$lambda$16$scanGroup(openReader, i, arrayList, booleanRef, this, arrayList2);
            Unit unit = Unit.INSTANCE;
            openReader.close();
            SlotWriter openWriter = openWriter();
            try {
                openWriter.startGroup();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Anchor anchor = (Anchor) arrayList.get(i2);
                    if (anchor.toIndexFor(openWriter) >= openWriter.getCurrentGroup()) {
                        openWriter.seek(anchor);
                        openWriter.bashCurrentGroup();
                    }
                }
                openWriter.skipToGroupEnd();
                openWriter.endGroup();
                openWriter.close();
                if (booleanRef.element) {
                    return arrayList2;
                }
                return null;
            } catch (Throwable th) {
                openWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            openReader.close();
            throw th2;
        }
    }

    private static final void invalidateGroupsWithKey$lambda$16$scanGroup(SlotReader slotReader, int i, List<Anchor> list, Ref.BooleanRef booleanRef, SlotTable slotTable, List<RecomposeScopeImpl> list2) {
        int groupKey = slotReader.getGroupKey();
        if (groupKey == i || groupKey == -3) {
            if (groupKey != -3) {
                list.add(SlotReader.anchor$default(slotReader, 0, 1, (Object) null));
            }
            if (booleanRef.element) {
                RecomposeScopeImpl findEffectiveRecomposeScope = slotTable.findEffectiveRecomposeScope(slotReader.getCurrentGroup());
                if (findEffectiveRecomposeScope != null) {
                    list2.add(findEffectiveRecomposeScope);
                } else {
                    booleanRef.element = false;
                    list2.clear();
                }
            }
            slotReader.skipGroup();
            return;
        }
        slotReader.startGroup();
        while (!slotReader.isGroupEnd()) {
            invalidateGroupsWithKey$lambda$16$scanGroup(slotReader, i, list, booleanRef, slotTable, list2);
        }
        slotReader.endGroup();
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && SlotTableKt.containsMark(this.groups, 0);
    }

    public final GroupSourceInformation sourceInformationOf(int i) {
        Anchor tryAnchor;
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null || (tryAnchor = tryAnchor(i)) == null) {
            return null;
        }
        return hashMap.get(tryAnchor);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int i) {
        int i2 = i;
        while (i2 > 0) {
            Iterator<Object> it = new DataIterator(this, i2).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) next;
                    if (recomposeScopeImpl.getUsed() && i2 != i) {
                        return recomposeScopeImpl;
                    }
                    recomposeScopeImpl.setForcedRecompose(true);
                }
            }
            i2 = SlotTableKt.parentAnchor(this.groups, i2);
        }
        return null;
    }

    public final void verifyWellFormed() {
        Ref.IntRef intRef = new Ref.IntRef();
        int i = -1;
        if (this.groupsSize > 0) {
            while (intRef.element < this.groupsSize) {
                verifyWellFormed$validateGroup(intRef, this, -1, intRef.element + SlotTableKt.groupSize(this.groups, intRef.element));
            }
            if (intRef.element != this.groupsSize) {
                throw new IllegalStateException(("Incomplete group at root " + intRef.element + " expected to be " + this.groupsSize).toString());
            }
        }
        int i2 = this.slotsSize;
        int length = this.slots.length;
        while (i2 < length) {
            if (this.slots[i2] == null) {
                i2++;
            } else {
                throw new IllegalStateException(("Non null value in the slot gap at index " + i2).toString());
            }
        }
        List list = this.anchors;
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            int indexFor = ((Anchor) list.get(i3)).toIndexFor(this);
            if (indexFor < 0 || indexFor > this.groupsSize) {
                throw new IllegalArgumentException("Invalid anchor, location out of bound".toString());
            } else if (i < indexFor) {
                i3++;
                i = indexFor;
            } else {
                throw new IllegalArgumentException("Anchor is out of order".toString());
            }
        }
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                Anchor anchor = (Anchor) entry.getKey();
                GroupSourceInformation groupSourceInformation = (GroupSourceInformation) entry.getValue();
                if (!anchor.getValid()) {
                    throw new IllegalArgumentException("Source map contains invalid anchor".toString());
                } else if (ownsAnchor(anchor)) {
                    verifyWellFormed$verifySourceGroup(this, groupSourceInformation);
                } else {
                    throw new IllegalArgumentException("Source map anchor is not owned by the slot table".toString());
                }
            }
        }
    }

    private static final int verifyWellFormed$validateGroup(Ref.IntRef intRef, SlotTable slotTable, int i, int i2) {
        int i3 = intRef.element;
        int i4 = i3 + 1;
        intRef.element = i4;
        int access$parentAnchor = SlotTableKt.parentAnchor(slotTable.groups, i3);
        if (access$parentAnchor == i) {
            int access$groupSize = SlotTableKt.groupSize(slotTable.groups, i3) + i3;
            if (access$groupSize > slotTable.groupsSize) {
                throw new IllegalStateException(("A group extends past the end of the table at " + i3).toString());
            } else if (access$groupSize <= i2) {
                int access$dataAnchor = SlotTableKt.dataAnchor(slotTable.groups, i3);
                int access$dataAnchor2 = i3 >= slotTable.groupsSize - 1 ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i4);
                if (access$dataAnchor2 > slotTable.slots.length) {
                    throw new IllegalStateException(("Slots for " + i3 + " extend past the end of the slot table").toString());
                } else if (access$dataAnchor > access$dataAnchor2) {
                    throw new IllegalStateException(("Invalid data anchor at " + i3).toString());
                } else if (SlotTableKt.slotAnchor(slotTable.groups, i3) <= access$dataAnchor2) {
                    if (access$dataAnchor2 - access$dataAnchor >= (SlotTableKt.isNode(slotTable.groups, i3) ? 1 : 0) + (SlotTableKt.hasObjectKey(slotTable.groups, i3) ? 1 : 0) + (SlotTableKt.hasAux(slotTable.groups, i3) ? 1 : 0)) {
                        boolean access$isNode = SlotTableKt.isNode(slotTable.groups, i3);
                        if (!access$isNode || slotTable.slots[SlotTableKt.nodeIndex(slotTable.groups, i3)] != null) {
                            int i5 = 0;
                            while (intRef.element < access$groupSize) {
                                i5 += verifyWellFormed$validateGroup(intRef, slotTable, i3, access$groupSize);
                            }
                            int access$nodeCount = SlotTableKt.nodeCount(slotTable.groups, i3);
                            int access$groupSize2 = SlotTableKt.groupSize(slotTable.groups, i3);
                            if (access$nodeCount == i5) {
                                int i6 = intRef.element - i3;
                                if (access$groupSize2 != i6) {
                                    throw new IllegalStateException(("Incorrect slot count detected at " + i3 + ", expected " + access$groupSize2 + ", received " + i6).toString());
                                } else if (SlotTableKt.containsAnyMark(slotTable.groups, i3) && i3 > 0 && !SlotTableKt.containsMark(slotTable.groups, i)) {
                                    throw new IllegalStateException(("Expected group " + i + " to record it contains a mark because " + i3 + " does").toString());
                                } else if (access$isNode) {
                                    return 1;
                                } else {
                                    return i5;
                                }
                            } else {
                                throw new IllegalStateException(("Incorrect node count detected at " + i3 + ", expected " + access$nodeCount + ", received " + i5).toString());
                            }
                        } else {
                            throw new IllegalStateException(("No node recorded for a node group at " + i3).toString());
                        }
                    } else {
                        throw new IllegalStateException(("Not enough slots added for group " + i3).toString());
                    }
                } else {
                    throw new IllegalStateException(("Slots start out of range at " + i3).toString());
                }
            } else {
                throw new IllegalStateException(("A group extends past its parent group at " + i3).toString());
            }
        } else {
            throw new IllegalStateException(("Invalid parent index detected at " + i3 + ", expected parent index to be " + i + " found " + access$parentAnchor).toString());
        }
    }

    private static final void verifyWellFormed$verifySourceGroup(SlotTable slotTable, GroupSourceInformation groupSourceInformation) {
        ArrayList<Object> groups2 = groupSourceInformation.getGroups();
        if (groups2 != null) {
            List list = groups2;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                if (obj instanceof Anchor) {
                    Anchor anchor = (Anchor) obj;
                    if (!anchor.getValid()) {
                        throw new IllegalArgumentException("Source map contains invalid anchor".toString());
                    } else if (!slotTable.ownsAnchor(anchor)) {
                        throw new IllegalArgumentException("Source map anchor is not owned by the slot table".toString());
                    }
                } else if (obj instanceof GroupSourceInformation) {
                    verifyWellFormed$verifySourceGroup(slotTable, (GroupSourceInformation) obj);
                }
            }
        }
    }

    public final String asString() {
        if (this.writer) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(10);
        int i = this.groupsSize;
        if (i > 0) {
            int i2 = 0;
            while (i2 < i) {
                i2 += emitGroup(sb, i2, 0);
            }
        } else {
            sb.append("<EMPTY>");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final int emitGroup(StringBuilder sb, int i, int i2) {
        HashMap<Anchor, GroupSourceInformation> hashMap;
        GroupSourceInformation groupSourceInformation;
        String sourceInformation;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
        sb.append("Group(");
        sb.append(i);
        sb.append(")");
        Anchor tryAnchor = tryAnchor(i);
        if (!(tryAnchor == null || (hashMap = this.sourceInformationMap) == null || (groupSourceInformation = hashMap.get(tryAnchor)) == null || (sourceInformation = groupSourceInformation.getSourceInformation()) == null || (!StringsKt.startsWith$default(sourceInformation, "C(", false, 2, (Object) null) && !StringsKt.startsWith$default(sourceInformation, "CC(", false, 2, (Object) null)))) {
            CharSequence charSequence = sourceInformation;
            int indexOf$default = StringsKt.indexOf$default(charSequence, "(", 0, false, 6, (Object) null) + 1;
            int indexOf$default2 = StringsKt.indexOf$default(charSequence, ')', 0, false, 6, (Object) null);
            sb.append(" ");
            String substring = sourceInformation.substring(indexOf$default, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append("()");
        }
        sb.append(" key=");
        sb.append(SlotTableKt.key(this.groups, i));
        int access$groupSize = SlotTableKt.groupSize(this.groups, i);
        sb.append(", nodes=");
        sb.append(SlotTableKt.nodeCount(this.groups, i));
        sb.append(", size=");
        sb.append(access$groupSize);
        if (SlotTableKt.hasMark(this.groups, i)) {
            sb.append(", mark");
        }
        if (SlotTableKt.containsMark(this.groups, i)) {
            sb.append(", contains mark");
        }
        int emitGroup$dataIndex = emitGroup$dataIndex(this, i);
        int i4 = i + 1;
        int emitGroup$dataIndex2 = emitGroup$dataIndex(this, i4);
        if (emitGroup$dataIndex < 0 || emitGroup$dataIndex > emitGroup$dataIndex2 || emitGroup$dataIndex2 > this.slotsSize) {
            sb.append(", *invalid data offsets " + emitGroup$dataIndex + '-' + emitGroup$dataIndex2 + '*');
        } else {
            if (SlotTableKt.hasObjectKey(this.groups, i)) {
                sb.append(" objectKey=" + this.slots[SlotTableKt.objectKeyIndex(this.groups, i)]);
            }
            if (SlotTableKt.isNode(this.groups, i)) {
                sb.append(" node=" + this.slots[SlotTableKt.nodeIndex(this.groups, i)]);
            }
            if (SlotTableKt.hasAux(this.groups, i)) {
                sb.append(" aux=" + this.slots[SlotTableKt.auxIndex(this.groups, i)]);
            }
            int access$slotAnchor = SlotTableKt.slotAnchor(this.groups, i);
            if (access$slotAnchor < emitGroup$dataIndex2) {
                sb.append(", slots=[");
                sb.append(access$slotAnchor);
                sb.append(": ");
                for (int i5 = access$slotAnchor; i5 < emitGroup$dataIndex2; i5++) {
                    if (i5 != access$slotAnchor) {
                        sb.append(", ");
                    }
                    sb.append(String.valueOf(this.slots[i5]));
                }
                sb.append("]");
            }
        }
        sb.append(10);
        int i6 = i + access$groupSize;
        while (i4 < i6) {
            i4 += emitGroup(sb, i4, i2 + 1);
        }
        return access$groupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i) {
        return i >= slotTable.groupsSize ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i);
    }

    private final List<Integer> keys() {
        return SlotTableKt.keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> dataIndexes() {
        return SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
    }

    public final List<Object> slotsOf$runtime_release(int i) {
        int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, i);
        int i2 = i + 1;
        return ArraysKt.toList((T[]) this.slots).subList(access$dataAnchor, i2 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i2) : this.slots.length);
    }

    public final Object slot$runtime_release(int i, int i2) {
        int access$slotAnchor = SlotTableKt.slotAnchor(this.groups, i);
        int i3 = i + 1;
        return (i2 < 0 || i2 >= (i3 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i3) : this.slots.length) - access$slotAnchor) ? Composer.Companion.getEmpty() : this.slots[access$slotAnchor + i2];
    }

    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public CompositionGroup find(Object obj) {
        return new SlotTableGroup(this, 0, 0, 4, (DefaultConstructorMarker) null).find(obj);
    }
}
