package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0004\b$\u0010%J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0004\b'\u0010%J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0004\b)\u0010*J\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00100\u001a\u000201H\u0016R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001d\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Landroidx/compose/material3/CheckboxColors;", "", "checkedCheckmarkColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledUncheckedBorderColor", "disabledIndeterminateBorderColor", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCheckedBorderColor-0d7_KjU", "()J", "J", "getCheckedBoxColor-0d7_KjU", "getCheckedCheckmarkColor-0d7_KjU", "getDisabledBorderColor-0d7_KjU", "getDisabledCheckedBoxColor-0d7_KjU", "getDisabledIndeterminateBorderColor-0d7_KjU", "getDisabledIndeterminateBoxColor-0d7_KjU", "getDisabledUncheckedBorderColor-0d7_KjU", "getDisabledUncheckedBoxColor-0d7_KjU", "getUncheckedBorderColor-0d7_KjU", "getUncheckedBoxColor-0d7_KjU", "getUncheckedCheckmarkColor-0d7_KjU", "borderColor", "Landroidx/compose/runtime/State;", "enabled", "", "state", "Landroidx/compose/ui/state/ToggleableState;", "borderColor$material3_release", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "boxColor", "boxColor$material3_release", "checkmarkColor", "checkmarkColor$material3_release", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/CheckboxColors;", "equals", "other", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxColors {
    public static final int $stable = 0;
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBorderColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.ui.state.ToggleableState[] r0 = androidx.compose.ui.state.ToggleableState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.On     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Indeterminate     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Off     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxColors.WhenMappings.<clinit>():void");
        }
    }

    public /* synthetic */ CheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12);
    }

    private CheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        this.checkedCheckmarkColor = j;
        this.uncheckedCheckmarkColor = j2;
        this.checkedBoxColor = j3;
        this.uncheckedBoxColor = j4;
        this.disabledCheckedBoxColor = j5;
        this.disabledUncheckedBoxColor = j6;
        this.disabledIndeterminateBoxColor = j7;
        this.checkedBorderColor = j8;
        this.uncheckedBorderColor = j9;
        this.disabledBorderColor = j10;
        this.disabledUncheckedBorderColor = j11;
        this.disabledIndeterminateBorderColor = j12;
    }

    /* renamed from: getCheckedCheckmarkColor-0d7_KjU  reason: not valid java name */
    public final long m1590getCheckedCheckmarkColor0d7_KjU() {
        return this.checkedCheckmarkColor;
    }

    /* renamed from: getUncheckedCheckmarkColor-0d7_KjU  reason: not valid java name */
    public final long m1599getUncheckedCheckmarkColor0d7_KjU() {
        return this.uncheckedCheckmarkColor;
    }

    /* renamed from: getCheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1589getCheckedBoxColor0d7_KjU() {
        return this.checkedBoxColor;
    }

    /* renamed from: getUncheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1598getUncheckedBoxColor0d7_KjU() {
        return this.uncheckedBoxColor;
    }

    /* renamed from: getDisabledCheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1592getDisabledCheckedBoxColor0d7_KjU() {
        return this.disabledCheckedBoxColor;
    }

    /* renamed from: getDisabledUncheckedBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1596getDisabledUncheckedBoxColor0d7_KjU() {
        return this.disabledUncheckedBoxColor;
    }

    /* renamed from: getDisabledIndeterminateBoxColor-0d7_KjU  reason: not valid java name */
    public final long m1594getDisabledIndeterminateBoxColor0d7_KjU() {
        return this.disabledIndeterminateBoxColor;
    }

    /* renamed from: getCheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1588getCheckedBorderColor0d7_KjU() {
        return this.checkedBorderColor;
    }

    /* renamed from: getUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1597getUncheckedBorderColor0d7_KjU() {
        return this.uncheckedBorderColor;
    }

    /* renamed from: getDisabledBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1591getDisabledBorderColor0d7_KjU() {
        return this.disabledBorderColor;
    }

    /* renamed from: getDisabledUncheckedBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1595getDisabledUncheckedBorderColor0d7_KjU() {
        return this.disabledUncheckedBorderColor;
    }

    /* renamed from: getDisabledIndeterminateBorderColor-0d7_KjU  reason: not valid java name */
    public final long m1593getDisabledIndeterminateBorderColor0d7_KjU() {
        return this.disabledIndeterminateBorderColor;
    }

    /* renamed from: copy-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ CheckboxColors m1586copy2qZNXz8$default(CheckboxColors checkboxColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long j13;
        CheckboxColors checkboxColors2 = checkboxColors;
        int i2 = i;
        long j14 = (i2 & 1) != 0 ? checkboxColors2.checkedCheckmarkColor : j;
        long j15 = (i2 & 2) != 0 ? checkboxColors2.uncheckedCheckmarkColor : j2;
        long j16 = (i2 & 4) != 0 ? checkboxColors2.checkedBoxColor : j3;
        long j17 = (i2 & 8) != 0 ? checkboxColors2.uncheckedBoxColor : j4;
        long j18 = (i2 & 16) != 0 ? checkboxColors2.disabledCheckedBoxColor : j5;
        long j19 = (i2 & 32) != 0 ? checkboxColors2.disabledUncheckedBoxColor : j6;
        long j20 = (i2 & 64) != 0 ? checkboxColors2.disabledIndeterminateBoxColor : j7;
        long j21 = (i2 & 128) != 0 ? checkboxColors2.checkedBorderColor : j8;
        long j22 = (i2 & 256) != 0 ? checkboxColors2.uncheckedBorderColor : j9;
        long j23 = (i2 & 512) != 0 ? checkboxColors2.disabledBorderColor : j10;
        long j24 = (i2 & 1024) != 0 ? checkboxColors2.disabledUncheckedBorderColor : j11;
        if ((i2 & 2048) != 0) {
            j13 = checkboxColors2.disabledIndeterminateBorderColor;
        } else {
            j13 = j12;
        }
        return checkboxColors.m1587copy2qZNXz8(j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j13);
    }

    public final State<Color> checkmarkColor$material3_release(ToggleableState toggleableState, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-507585681);
        ComposerKt.sourceInformation(composer, "C(checkmarkColor)484@21111L61:Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-507585681, i, -1, "androidx.compose.material3.CheckboxColors.checkmarkColor (Checkbox.kt:476)");
        }
        if (toggleableState == ToggleableState.Off) {
            j = this.uncheckedCheckmarkColor;
        } else {
            j = this.checkedCheckmarkColor;
        }
        State<Color> r11 = SingleValueAnimationKt.m105animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(toggleableState == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r11;
    }

    public final State<Color> boxColor$material3_release(boolean z, ToggleableState toggleableState, Composer composer, int i) {
        long j;
        State<Color> state;
        composer.startReplaceableGroup(360729865);
        ComposerKt.sourceInformation(composer, "C(boxColor):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(360729865, i, -1, "androidx.compose.material3.CheckboxColors.boxColor (Checkbox.kt:495)");
        }
        if (z) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i2 == 1 || i2 == 2) {
                j = this.checkedBoxColor;
            } else if (i2 == 3) {
                j = this.uncheckedBoxColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            int i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i3 == 1) {
                j = this.disabledCheckedBoxColor;
            } else if (i3 == 2) {
                j = this.disabledIndeterminateBoxColor;
            } else if (i3 == 3) {
                j = this.disabledUncheckedBoxColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        long j2 = j;
        if (z) {
            composer.startReplaceableGroup(1143723294);
            ComposerKt.sourceInformation(composer, "513@22299L61");
            state = SingleValueAnimationKt.m105animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(toggleableState == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer, 0, 12);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1143723480);
            ComposerKt.sourceInformation(composer, "515@22390L28");
            state = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j2), composer, 0);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return state;
    }

    public final State<Color> borderColor$material3_release(boolean z, ToggleableState toggleableState, Composer composer, int i) {
        long j;
        State<Color> state;
        composer.startReplaceableGroup(1009643462);
        ComposerKt.sourceInformation(composer, "C(borderColor):Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009643462, i, -1, "androidx.compose.material3.CheckboxColors.borderColor (Checkbox.kt:526)");
        }
        if (z) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i2 == 1 || i2 == 2) {
                j = this.checkedBorderColor;
            } else if (i2 == 3) {
                j = this.uncheckedBorderColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            int i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i3 == 1) {
                j = this.disabledBorderColor;
            } else if (i3 == 2) {
                j = this.disabledIndeterminateBorderColor;
            } else if (i3 == 3) {
                j = this.disabledUncheckedBorderColor;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        long j2 = j;
        if (z) {
            composer.startReplaceableGroup(1209374481);
            ComposerKt.sourceInformation(composer, "544@23549L61");
            state = SingleValueAnimationKt.m105animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(toggleableState == ToggleableState.Off ? 100 : 50, 0, (Easing) null, 6, (Object) null), (String) null, (Function1<? super Color, Unit>) null, composer, 0, 12);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1209374667);
            ComposerKt.sourceInformation(composer, "546@23640L28");
            state = SnapshotStateKt.rememberUpdatedState(Color.m3806boximpl(j2), composer, 0);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return state;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CheckboxColors)) {
            return false;
        }
        CheckboxColors checkboxColors = (CheckboxColors) obj;
        return Color.m3817equalsimpl0(this.checkedCheckmarkColor, checkboxColors.checkedCheckmarkColor) && Color.m3817equalsimpl0(this.uncheckedCheckmarkColor, checkboxColors.uncheckedCheckmarkColor) && Color.m3817equalsimpl0(this.checkedBoxColor, checkboxColors.checkedBoxColor) && Color.m3817equalsimpl0(this.uncheckedBoxColor, checkboxColors.uncheckedBoxColor) && Color.m3817equalsimpl0(this.disabledCheckedBoxColor, checkboxColors.disabledCheckedBoxColor) && Color.m3817equalsimpl0(this.disabledUncheckedBoxColor, checkboxColors.disabledUncheckedBoxColor) && Color.m3817equalsimpl0(this.disabledIndeterminateBoxColor, checkboxColors.disabledIndeterminateBoxColor) && Color.m3817equalsimpl0(this.checkedBorderColor, checkboxColors.checkedBorderColor) && Color.m3817equalsimpl0(this.uncheckedBorderColor, checkboxColors.uncheckedBorderColor) && Color.m3817equalsimpl0(this.disabledBorderColor, checkboxColors.disabledBorderColor) && Color.m3817equalsimpl0(this.disabledUncheckedBorderColor, checkboxColors.disabledUncheckedBorderColor) && Color.m3817equalsimpl0(this.disabledIndeterminateBorderColor, checkboxColors.disabledIndeterminateBorderColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.m3823hashCodeimpl(this.checkedCheckmarkColor) * 31) + Color.m3823hashCodeimpl(this.uncheckedCheckmarkColor)) * 31) + Color.m3823hashCodeimpl(this.checkedBoxColor)) * 31) + Color.m3823hashCodeimpl(this.uncheckedBoxColor)) * 31) + Color.m3823hashCodeimpl(this.disabledCheckedBoxColor)) * 31) + Color.m3823hashCodeimpl(this.disabledUncheckedBoxColor)) * 31) + Color.m3823hashCodeimpl(this.disabledIndeterminateBoxColor)) * 31) + Color.m3823hashCodeimpl(this.checkedBorderColor)) * 31) + Color.m3823hashCodeimpl(this.uncheckedBorderColor)) * 31) + Color.m3823hashCodeimpl(this.disabledBorderColor)) * 31) + Color.m3823hashCodeimpl(this.disabledUncheckedBorderColor)) * 31) + Color.m3823hashCodeimpl(this.disabledIndeterminateBorderColor);
    }

    /* renamed from: copy-2qZNXz8  reason: not valid java name */
    public final CheckboxColors m1587copy2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new CheckboxColors(j != Color.Companion.m3852getUnspecified0d7_KjU() ? j : this.checkedCheckmarkColor, j2 != Color.Companion.m3852getUnspecified0d7_KjU() ? j2 : this.uncheckedCheckmarkColor, j3 != Color.Companion.m3852getUnspecified0d7_KjU() ? j3 : this.checkedBoxColor, j4 != Color.Companion.m3852getUnspecified0d7_KjU() ? j4 : this.uncheckedBoxColor, j5 != Color.Companion.m3852getUnspecified0d7_KjU() ? j5 : this.disabledCheckedBoxColor, j6 != Color.Companion.m3852getUnspecified0d7_KjU() ? j6 : this.disabledUncheckedBoxColor, j7 != Color.Companion.m3852getUnspecified0d7_KjU() ? j7 : this.disabledIndeterminateBoxColor, j8 != Color.Companion.m3852getUnspecified0d7_KjU() ? j8 : this.checkedBorderColor, j9 != Color.Companion.m3852getUnspecified0d7_KjU() ? j9 : this.uncheckedBorderColor, j10 != Color.Companion.m3852getUnspecified0d7_KjU() ? j10 : this.disabledBorderColor, j11 != Color.Companion.m3852getUnspecified0d7_KjU() ? j11 : this.disabledUncheckedBorderColor, j12 != Color.Companion.m3852getUnspecified0d7_KjU() ? j12 : this.disabledIndeterminateBorderColor, (DefaultConstructorMarker) null);
    }
}
