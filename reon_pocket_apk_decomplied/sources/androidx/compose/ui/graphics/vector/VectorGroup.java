package androidx.compose.ui.graphics.vector;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010(\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002Bw\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\u0010\u0011J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0011\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0016J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010*H\u0002R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017¨\u0006+"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorGroup;", "Landroidx/compose/ui/graphics/vector/VectorNode;", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getClipPathData", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getPivotX", "()F", "getPivotY", "getRotation", "getScaleX", "getScaleY", "size", "", "getSize", "()I", "getTranslationX", "getTranslationY", "equals", "", "other", "", "get", "index", "hashCode", "iterator", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ImageVector.kt */
public final class VectorGroup extends VectorNode implements Iterable<VectorNode>, KMappedMarker {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public final List<VectorNode> children;
    private final List<PathNode> clipPathData;
    private final String name;
    private final float pivotX;
    private final float pivotY;
    private final float rotation;
    private final float scaleX;
    private final float scaleY;
    private final float translationX;
    private final float translationY;

    public VectorGroup() {
        this((String) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (List) null, (List) null, 1023, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VectorGroup(java.lang.String r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18, java.util.List r19, java.util.List r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r10 = this;
            r0 = r21
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0011
            r2 = r3
            goto L_0x0012
        L_0x0011:
            r2 = r12
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r3
            goto L_0x0019
        L_0x0018:
            r4 = r13
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r3
            goto L_0x0020
        L_0x001f:
            r5 = r14
        L_0x0020:
            r6 = r0 & 16
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L_0x0028
            r6 = r7
            goto L_0x0029
        L_0x0028:
            r6 = r15
        L_0x0029:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r7 = r16
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            r8 = r3
            goto L_0x0038
        L_0x0036:
            r8 = r17
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r3 = r18
        L_0x003f:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0048
            java.util.List r9 = androidx.compose.ui.graphics.vector.VectorKt.getEmptyPath()
            goto L_0x004a
        L_0x0048:
            r9 = r19
        L_0x004a:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0053
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0055
        L_0x0053:
            r0 = r20
        L_0x0055:
            r11 = r10
            r12 = r1
            r13 = r2
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r3
            r20 = r9
            r21 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorGroup.<init>(java.lang.String, float, float, float, float, float, float, float, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getName() {
        return this.name;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final List<PathNode> getClipPathData() {
        return this.clipPathData;
    }

    public VectorGroup(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, List<? extends VectorNode> list2) {
        super((DefaultConstructorMarker) null);
        this.name = str;
        this.rotation = f;
        this.pivotX = f2;
        this.pivotY = f3;
        this.scaleX = f4;
        this.scaleY = f5;
        this.translationX = f6;
        this.translationY = f7;
        this.clipPathData = list;
        this.children = list2;
    }

    public final int getSize() {
        return this.children.size();
    }

    public final VectorNode get(int i) {
        return this.children.get(i);
    }

    public Iterator<VectorNode> iterator() {
        return new VectorGroup$iterator$1(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof VectorGroup)) {
            VectorGroup vectorGroup = (VectorGroup) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) vectorGroup.name) && this.rotation == vectorGroup.rotation && this.pivotX == vectorGroup.pivotX && this.pivotY == vectorGroup.pivotY && this.scaleX == vectorGroup.scaleX && this.scaleY == vectorGroup.scaleY && this.translationX == vectorGroup.translationX && this.translationY == vectorGroup.translationY && Intrinsics.areEqual((Object) this.clipPathData, (Object) vectorGroup.clipPathData) && Intrinsics.areEqual((Object) this.children, (Object) vectorGroup.children);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.name.hashCode() * 31) + Float.floatToIntBits(this.rotation)) * 31) + Float.floatToIntBits(this.pivotX)) * 31) + Float.floatToIntBits(this.pivotY)) * 31) + Float.floatToIntBits(this.scaleX)) * 31) + Float.floatToIntBits(this.scaleY)) * 31) + Float.floatToIntBits(this.translationX)) * 31) + Float.floatToIntBits(this.translationY)) * 31) + this.clipPathData.hashCode()) * 31) + this.children.hashCode();
    }
}
