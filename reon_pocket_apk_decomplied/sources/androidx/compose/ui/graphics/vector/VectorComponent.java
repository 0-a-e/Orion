package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00106\u001a\u00020\u000eH\u0002J\b\u00107\u001a\u00020\"H\u0016J\f\u00108\u001a\u00020\u000e*\u00020\rH\u0016J\u001c\u00108\u001a\u00020\u000e*\u00020\r2\u0006\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010\u0011R\u001a\u0010\u0005\u001a\u00020\u00068@X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fX\u0004¢\u0006\u0002\n\u0000R/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118@@@X\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020(X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R1\u00100\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020(8@@@X\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b5\u0010\u0018\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "cacheBitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getCacheBitmapConfig-_sVssgQ$ui_release", "()I", "cacheDrawScope", "Landroidx/compose/ui/graphics/vector/DrawCache;", "drawVectorBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "<set-?>", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicColorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "invalidateCallback", "Lkotlin/Function0;", "getInvalidateCallback$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateCallback$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isDirty", "", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "previousDrawSize", "Landroidx/compose/ui/geometry/Size;", "J", "getRoot", "()Landroidx/compose/ui/graphics/vector/GroupComponent;", "rootScaleX", "", "rootScaleY", "tintFilter", "viewportSize", "getViewportSize-NH-jbRc$ui_release", "()J", "setViewportSize-uvyYCjk$ui_release", "(J)V", "viewportSize$delegate", "doInvalidate", "toString", "draw", "alpha", "colorFilter", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Vector.kt */
public final class VectorComponent extends VNode {
    public static final int $stable = 8;
    private final DrawCache cacheDrawScope = new DrawCache();
    private final Function1<DrawScope, Unit> drawVectorBlock = new VectorComponent$drawVectorBlock$1(this);
    private final MutableState intrinsicColorFilter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private Function0<Unit> invalidateCallback = VectorComponent$invalidateCallback$1.INSTANCE;
    private boolean isDirty = true;
    private String name = "";
    private long previousDrawSize = Size.Companion.m3639getUnspecifiedNHjbRc();
    private final GroupComponent root;
    /* access modifiers changed from: private */
    public float rootScaleX = 1.0f;
    /* access modifiers changed from: private */
    public float rootScaleY = 1.0f;
    private ColorFilter tintFilter;
    private final MutableState viewportSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3619boximpl(Size.Companion.m3640getZeroNHjbRc()), (SnapshotMutationPolicy) null, 2, (Object) null);

    public VectorComponent(GroupComponent groupComponent) {
        super((DefaultConstructorMarker) null);
        this.root = groupComponent;
        groupComponent.setInvalidateListener$ui_release(new Function1<VNode, Unit>(this) {
            final /* synthetic */ VectorComponent this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((VNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(VNode vNode) {
                this.this$0.doInvalidate();
            }
        });
    }

    public final GroupComponent getRoot() {
        return this.root;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    /* access modifiers changed from: private */
    public final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    /* renamed from: getCacheBitmapConfig-_sVssgQ$ui_release  reason: not valid java name */
    public final int m4588getCacheBitmapConfig_sVssgQ$ui_release() {
        ImageBitmap mCachedImage = this.cacheDrawScope.getMCachedImage();
        return mCachedImage != null ? mCachedImage.m4037getConfig_sVssgQ() : ImageBitmapConfig.Companion.m4046getArgb8888_sVssgQ();
    }

    public final Function0<Unit> getInvalidateCallback$ui_release() {
        return this.invalidateCallback;
    }

    public final void setInvalidateCallback$ui_release(Function0<Unit> function0) {
        this.invalidateCallback = function0;
    }

    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return (ColorFilter) this.intrinsicColorFilter$delegate.getValue();
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter colorFilter) {
        this.intrinsicColorFilter$delegate.setValue(colorFilter);
    }

    /* renamed from: getViewportSize-NH-jbRc$ui_release  reason: not valid java name */
    public final long m4589getViewportSizeNHjbRc$ui_release() {
        return ((Size) this.viewportSize$delegate.getValue()).m3636unboximpl();
    }

    /* renamed from: setViewportSize-uvyYCjk$ui_release  reason: not valid java name */
    public final void m4590setViewportSizeuvyYCjk$ui_release(long j) {
        this.viewportSize$delegate.setValue(Size.m3619boximpl(j));
    }

    public final void draw(DrawScope drawScope, float f, ColorFilter colorFilter) {
        int i;
        if (!this.root.isTintable() || this.root.m4573getTintColor0d7_KjU() == Color.Companion.m3852getUnspecified0d7_KjU() || !VectorKt.tintableWithAlphaMask(getIntrinsicColorFilter$ui_release()) || !VectorKt.tintableWithAlphaMask(colorFilter)) {
            i = ImageBitmapConfig.Companion.m4046getArgb8888_sVssgQ();
        } else {
            i = ImageBitmapConfig.Companion.m4045getAlpha8_sVssgQ();
        }
        int i2 = i;
        if (this.isDirty || !Size.m3627equalsimpl0(this.previousDrawSize, drawScope.m4434getSizeNHjbRc()) || !ImageBitmapConfig.m4041equalsimpl0(i2, m4588getCacheBitmapConfig_sVssgQ$ui_release())) {
            this.tintFilter = ImageBitmapConfig.m4041equalsimpl0(i2, ImageBitmapConfig.Companion.m4045getAlpha8_sVssgQ()) ? ColorFilter.Companion.m3857tintxETnrds$default(ColorFilter.Companion, this.root.m4573getTintColor0d7_KjU(), 0, 2, (Object) null) : null;
            this.rootScaleX = Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc()) / Size.m3631getWidthimpl(m4589getViewportSizeNHjbRc$ui_release());
            this.rootScaleY = Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc()) / Size.m3628getHeightimpl(m4589getViewportSizeNHjbRc$ui_release());
            this.cacheDrawScope.m4571drawCachedImageFqjB98A(i2, IntSizeKt.IntSize((int) ((float) Math.ceil((double) Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc()))), (int) ((float) Math.ceil((double) Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc())))), drawScope, drawScope.getLayoutDirection(), this.drawVectorBlock);
            this.isDirty = false;
            this.previousDrawSize = drawScope.m4434getSizeNHjbRc();
        }
        if (colorFilter == null) {
            if (getIntrinsicColorFilter$ui_release() != null) {
                colorFilter = getIntrinsicColorFilter$ui_release();
            } else {
                colorFilter = this.tintFilter;
            }
        }
        this.cacheDrawScope.drawInto(drawScope, f, colorFilter);
    }

    public void draw(DrawScope drawScope) {
        draw(drawScope, 1.0f, (ColorFilter) null);
    }

    public String toString() {
        String str = "Params: \tname: " + this.name + "\n\tviewportWidth: " + Size.m3631getWidthimpl(m4589getViewportSizeNHjbRc$ui_release()) + "\n\tviewportHeight: " + Size.m3628getHeightimpl(m4589getViewportSizeNHjbRc$ui_release()) + "\n";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }
}
