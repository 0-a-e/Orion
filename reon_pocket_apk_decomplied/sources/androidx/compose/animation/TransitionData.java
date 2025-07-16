package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e0\r¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u001d\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e0\rHÆ\u0003Ja\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e0\rHÆ\u0001J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R%\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Landroidx/compose/animation/TransitionData;", "", "fade", "Landroidx/compose/animation/Fade;", "slide", "Landroidx/compose/animation/Slide;", "changeSize", "Landroidx/compose/animation/ChangeSize;", "scale", "Landroidx/compose/animation/Scale;", "hold", "", "effectsMap", "", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/animation/Fade;Landroidx/compose/animation/Slide;Landroidx/compose/animation/ChangeSize;Landroidx/compose/animation/Scale;ZLjava/util/Map;)V", "getChangeSize", "()Landroidx/compose/animation/ChangeSize;", "getEffectsMap", "()Ljava/util/Map;", "getFade", "()Landroidx/compose/animation/Fade;", "getHold", "()Z", "getScale", "()Landroidx/compose/animation/Scale;", "getSlide", "()Landroidx/compose/animation/Slide;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
public final class TransitionData {
    public static final int $stable = 0;
    private final ChangeSize changeSize;
    private final Map<Object, ModifierNodeElement<? extends Modifier.Node>> effectsMap;
    private final Fade fade;
    private final boolean hold;
    private final Scale scale;
    private final Slide slide;

    public TransitionData() {
        this((Fade) null, (Slide) null, (ChangeSize) null, (Scale) null, false, (Map) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TransitionData copy$default(TransitionData transitionData, Fade fade2, Slide slide2, ChangeSize changeSize2, Scale scale2, boolean z, Map<Object, ModifierNodeElement<? extends Modifier.Node>> map, int i, Object obj) {
        if ((i & 1) != 0) {
            fade2 = transitionData.fade;
        }
        if ((i & 2) != 0) {
            slide2 = transitionData.slide;
        }
        Slide slide3 = slide2;
        if ((i & 4) != 0) {
            changeSize2 = transitionData.changeSize;
        }
        ChangeSize changeSize3 = changeSize2;
        if ((i & 8) != 0) {
            scale2 = transitionData.scale;
        }
        Scale scale3 = scale2;
        if ((i & 16) != 0) {
            z = transitionData.hold;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            map = transitionData.effectsMap;
        }
        return transitionData.copy(fade2, slide3, changeSize3, scale3, z2, map);
    }

    public final Fade component1() {
        return this.fade;
    }

    public final Slide component2() {
        return this.slide;
    }

    public final ChangeSize component3() {
        return this.changeSize;
    }

    public final Scale component4() {
        return this.scale;
    }

    public final boolean component5() {
        return this.hold;
    }

    public final Map<Object, ModifierNodeElement<? extends Modifier.Node>> component6() {
        return this.effectsMap;
    }

    public final TransitionData copy(Fade fade2, Slide slide2, ChangeSize changeSize2, Scale scale2, boolean z, Map<Object, ? extends ModifierNodeElement<? extends Modifier.Node>> map) {
        return new TransitionData(fade2, slide2, changeSize2, scale2, z, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransitionData)) {
            return false;
        }
        TransitionData transitionData = (TransitionData) obj;
        return Intrinsics.areEqual((Object) this.fade, (Object) transitionData.fade) && Intrinsics.areEqual((Object) this.slide, (Object) transitionData.slide) && Intrinsics.areEqual((Object) this.changeSize, (Object) transitionData.changeSize) && Intrinsics.areEqual((Object) this.scale, (Object) transitionData.scale) && this.hold == transitionData.hold && Intrinsics.areEqual((Object) this.effectsMap, (Object) transitionData.effectsMap);
    }

    public int hashCode() {
        Fade fade2 = this.fade;
        int i = 0;
        int hashCode = (fade2 == null ? 0 : fade2.hashCode()) * 31;
        Slide slide2 = this.slide;
        int hashCode2 = (hashCode + (slide2 == null ? 0 : slide2.hashCode())) * 31;
        ChangeSize changeSize2 = this.changeSize;
        int hashCode3 = (hashCode2 + (changeSize2 == null ? 0 : changeSize2.hashCode())) * 31;
        Scale scale2 = this.scale;
        if (scale2 != null) {
            i = scale2.hashCode();
        }
        return ((((hashCode3 + i) * 31) + UByte$$ExternalSyntheticBackport0.m(this.hold)) * 31) + this.effectsMap.hashCode();
    }

    public String toString() {
        return "TransitionData(fade=" + this.fade + ", slide=" + this.slide + ", changeSize=" + this.changeSize + ", scale=" + this.scale + ", hold=" + this.hold + ", effectsMap=" + this.effectsMap + ')';
    }

    public TransitionData(Fade fade2, Slide slide2, ChangeSize changeSize2, Scale scale2, boolean z, Map<Object, ? extends ModifierNodeElement<? extends Modifier.Node>> map) {
        this.fade = fade2;
        this.slide = slide2;
        this.changeSize = changeSize2;
        this.scale = scale2;
        this.hold = z;
        this.effectsMap = map;
    }

    public final Fade getFade() {
        return this.fade;
    }

    public final Slide getSlide() {
        return this.slide;
    }

    public final ChangeSize getChangeSize() {
        return this.changeSize;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final boolean getHold() {
        return this.hold;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TransitionData(androidx.compose.animation.Fade r5, androidx.compose.animation.Slide r6, androidx.compose.animation.ChangeSize r7, androidx.compose.animation.Scale r8, boolean r9, java.util.Map r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0007
            r12 = r0
            goto L_0x0008
        L_0x0007:
            r12 = r5
        L_0x0008:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r8
        L_0x001c:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0021
            r9 = 0
        L_0x0021:
            r3 = r9
            r5 = r11 & 32
            if (r5 == 0) goto L_0x002a
            java.util.Map r10 = kotlin.collections.MapsKt.emptyMap()
        L_0x002a:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r9 = r0
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.TransitionData.<init>(androidx.compose.animation.Fade, androidx.compose.animation.Slide, androidx.compose.animation.ChangeSize, androidx.compose.animation.Scale, boolean, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Map<Object, ModifierNodeElement<? extends Modifier.Node>> getEffectsMap() {
        return this.effectsMap;
    }
}
