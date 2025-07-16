package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0002\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\u00102\b\b\u0002\u00109\u001a\u00020:2\u001c\u0010;\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b=H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u0002\u0010@\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u00109\u001a\u00020:2\u001c\u0010;\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b=H\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aÆ\u0001\u0010E\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00105\u001a\u00020F2\b\b\u0002\u00109\u001a\u00020:H\u0003¢\u0006\u0002\u0010G\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u0010X\u0004¢\u0006\n\n\u0002\u0010\u0013\u0012\u0004\b\u0019\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0013\"\u0010\u0010\u001c\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0013\"\u0016\u0010\u001d\u001a\u00020\u0010X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012\"\u0016\u0010\u001f\u001a\u00020\u0010X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b \u0010\u0012\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\n\u0010I\u001a\u00020)X\u0002²\u0006\n\u0010J\u001a\u00020)X\u0002"}, d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "DockedActiveTableMaxHeightScreenRatio", "DockedActiveTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedActiveTableMinHeight", "()F", "F", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "DockedSearchBar", "", "query", "", "onQueryChange", "Lkotlin/Function1;", "onSearch", "active", "", "onActiveChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "shadowElevation", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarInputField", "Landroidx/compose/material3/TextFieldColors;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "material3_release", "useFullScreenShape", "showResults"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
public final class SearchBar_androidKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final float DockedActiveTableMaxHeightScreenRatio = 0.6666667f;
    private static final float DockedActiveTableMinHeight = Dp.m6614constructorimpl((float) 240);
    /* access modifiers changed from: private */
    public static final EnterTransition DockedEnterTransition;
    /* access modifiers changed from: private */
    public static final ExitTransition DockedExitTransition;
    /* access modifiers changed from: private */
    public static final float SearchBarCornerRadius = Dp.m6614constructorimpl(SearchBarDefaults.INSTANCE.m2111getInputFieldHeightD9Ej5fM() / ((float) 2));
    /* access modifiers changed from: private */
    public static final float SearchBarIconOffsetX = Dp.m6614constructorimpl((float) 4);
    /* access modifiers changed from: private */
    public static final float SearchBarMaxWidth = Dp.m6614constructorimpl((float) 720);
    private static final float SearchBarMinWidth = Dp.m6614constructorimpl((float) 360);
    private static final float SearchBarVerticalPadding = Dp.m6614constructorimpl((float) 8);

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x068b  */
    /* JADX WARNING: Removed duplicated region for block: B:324:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0127  */
    /* renamed from: SearchBar-WuY5d9Q  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2117SearchBarWuY5d9Q(java.lang.String r42, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r43, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r44, boolean r45, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r46, androidx.compose.ui.Modifier r47, boolean r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.ui.graphics.Shape r52, androidx.compose.material3.SearchBarColors r53, float r54, float r55, androidx.compose.foundation.layout.WindowInsets r56, androidx.compose.foundation.interaction.MutableInteractionSource r57, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, androidx.compose.runtime.Composer r59, int r60, int r61, int r62) {
        /*
            r15 = r45
            r14 = r46
            r13 = r60
            r12 = r61
            r11 = r62
            r0 = 1001512593(0x3bb1de91, float:0.0054281433)
            r1 = r59
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(SearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,16,4)170@8780L15,171@8845L8,174@9026L12,175@9090L39,178@9226L160,183@9429L7,184@9468L7,186@9528L15,187@9595L15,188@9641L101,191@9767L578,211@10793L34,212@10849L179,222@11136L38,227@11355L112,231@11539L1082,219@11034L2762,284@13836L25,286@13943L292,286@13920L315,295@14271L37,295@14241L67:SearchBar.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r13 | 6
            r2 = r0
            r0 = r42
            goto L_0x0036
        L_0x0022:
            r0 = r13 & 6
            if (r0 != 0) goto L_0x0033
            r0 = r42
            boolean r2 = r10.changed((java.lang.Object) r0)
            if (r2 == 0) goto L_0x0030
            r2 = 4
            goto L_0x0031
        L_0x0030:
            r2 = 2
        L_0x0031:
            r2 = r2 | r13
            goto L_0x0036
        L_0x0033:
            r0 = r42
            r2 = r13
        L_0x0036:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x003f
            r2 = r2 | 48
            r8 = r43
            goto L_0x0051
        L_0x003f:
            r3 = r13 & 48
            r8 = r43
            if (r3 != 0) goto L_0x0051
            boolean r3 = r10.changedInstance(r8)
            if (r3 == 0) goto L_0x004e
            r3 = 32
            goto L_0x0050
        L_0x004e:
            r3 = 16
        L_0x0050:
            r2 = r2 | r3
        L_0x0051:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x0058
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0058:
            r3 = r13 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x006c
            r3 = r44
            boolean r16 = r10.changedInstance(r3)
            if (r16 == 0) goto L_0x0067
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r2 = r2 | r16
            goto L_0x006e
        L_0x006c:
            r3 = r44
        L_0x006e:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0079
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0079:
            r1 = r13 & 3072(0xc00, float:4.305E-42)
            if (r1 != 0) goto L_0x0089
            boolean r1 = r10.changed((boolean) r15)
            if (r1 == 0) goto L_0x0086
            r1 = r17
            goto L_0x0088
        L_0x0086:
            r1 = r18
        L_0x0088:
            r2 = r2 | r1
        L_0x0089:
            r1 = r11 & 16
            r16 = 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0092
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x0092:
            r1 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r1 != 0) goto L_0x00a2
            boolean r1 = r10.changedInstance(r14)
            if (r1 == 0) goto L_0x009f
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r1 = r16
        L_0x00a1:
            r2 = r2 | r1
        L_0x00a2:
            r1 = r11 & 32
            r20 = 65536(0x10000, float:9.18355E-41)
            r21 = 196608(0x30000, float:2.75506E-40)
            if (r1 == 0) goto L_0x00af
            r2 = r2 | r21
            r4 = r47
            goto L_0x00c2
        L_0x00af:
            r22 = r13 & r21
            r4 = r47
            if (r22 != 0) goto L_0x00c2
            boolean r23 = r10.changed((java.lang.Object) r4)
            if (r23 == 0) goto L_0x00be
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r23 = r20
        L_0x00c0:
            r2 = r2 | r23
        L_0x00c2:
            r23 = r11 & 64
            r24 = 1572864(0x180000, float:2.204052E-39)
            if (r23 == 0) goto L_0x00cd
            r2 = r2 | r24
            r5 = r48
            goto L_0x00e0
        L_0x00cd:
            r25 = r13 & r24
            r5 = r48
            if (r25 != 0) goto L_0x00e0
            boolean r26 = r10.changed((boolean) r5)
            if (r26 == 0) goto L_0x00dc
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r2 = r2 | r26
        L_0x00e0:
            r6 = r11 & 128(0x80, float:1.794E-43)
            r27 = 12582912(0xc00000, float:1.7632415E-38)
            if (r6 == 0) goto L_0x00eb
            r2 = r2 | r27
            r7 = r49
            goto L_0x00fe
        L_0x00eb:
            r27 = r13 & r27
            r7 = r49
            if (r27 != 0) goto L_0x00fe
            boolean r28 = r10.changedInstance(r7)
            if (r28 == 0) goto L_0x00fa
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fc
        L_0x00fa:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fc:
            r2 = r2 | r28
        L_0x00fe:
            r9 = r11 & 256(0x100, float:3.59E-43)
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            if (r9 == 0) goto L_0x0109
            r2 = r2 | r29
            r0 = r50
            goto L_0x011c
        L_0x0109:
            r29 = r13 & r29
            r0 = r50
            if (r29 != 0) goto L_0x011c
            boolean r29 = r10.changedInstance(r0)
            if (r29 == 0) goto L_0x0118
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011a
        L_0x0118:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011a:
            r2 = r2 | r29
        L_0x011c:
            r0 = r11 & 512(0x200, float:7.175E-43)
            r29 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0127
            r2 = r2 | r29
            r3 = r51
            goto L_0x013a
        L_0x0127:
            r29 = r13 & r29
            r3 = r51
            if (r29 != 0) goto L_0x013a
            boolean r29 = r10.changedInstance(r3)
            if (r29 == 0) goto L_0x0136
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0138
        L_0x0136:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0138:
            r2 = r2 | r29
        L_0x013a:
            r29 = r12 & 6
            if (r29 != 0) goto L_0x0154
            r3 = r11 & 1024(0x400, float:1.435E-42)
            if (r3 != 0) goto L_0x014d
            r3 = r52
            boolean r29 = r10.changed((java.lang.Object) r3)
            if (r29 == 0) goto L_0x014f
            r29 = 4
            goto L_0x0151
        L_0x014d:
            r3 = r52
        L_0x014f:
            r29 = 2
        L_0x0151:
            r29 = r12 | r29
            goto L_0x0158
        L_0x0154:
            r3 = r52
            r29 = r12
        L_0x0158:
            r30 = r12 & 48
            if (r30 != 0) goto L_0x0172
            r3 = r11 & 2048(0x800, float:2.87E-42)
            if (r3 != 0) goto L_0x016b
            r3 = r53
            boolean r30 = r10.changed((java.lang.Object) r3)
            if (r30 == 0) goto L_0x016d
            r22 = 32
            goto L_0x016f
        L_0x016b:
            r3 = r53
        L_0x016d:
            r22 = 16
        L_0x016f:
            r29 = r29 | r22
            goto L_0x0174
        L_0x0172:
            r3 = r53
        L_0x0174:
            r3 = r29
            r8 = r11 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x017d
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0191
        L_0x017d:
            r4 = r12 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0191
            r4 = r54
            boolean r22 = r10.changed((float) r4)
            if (r22 == 0) goto L_0x018c
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x018e
        L_0x018c:
            r27 = 128(0x80, float:1.794E-43)
        L_0x018e:
            r3 = r3 | r27
            goto L_0x0193
        L_0x0191:
            r4 = r54
        L_0x0193:
            r22 = r8
            r8 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x019c
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x01ae
        L_0x019c:
            r4 = r12 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x01ae
            r4 = r55
            boolean r25 = r10.changed((float) r4)
            if (r25 == 0) goto L_0x01a9
            goto L_0x01ab
        L_0x01a9:
            r17 = r18
        L_0x01ab:
            r3 = r3 | r17
            goto L_0x01b0
        L_0x01ae:
            r4 = r55
        L_0x01b0:
            r4 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r4 != 0) goto L_0x01c8
            r4 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r4 != 0) goto L_0x01c3
            r4 = r56
            boolean r17 = r10.changed((java.lang.Object) r4)
            if (r17 == 0) goto L_0x01c5
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x01c5
        L_0x01c3:
            r4 = r56
        L_0x01c5:
            r3 = r3 | r16
            goto L_0x01ca
        L_0x01c8:
            r4 = r56
        L_0x01ca:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r11 & r16
            if (r16 == 0) goto L_0x01d4
            r3 = r3 | r21
            goto L_0x01ea
        L_0x01d4:
            r17 = r12 & r21
            if (r17 != 0) goto L_0x01ea
            r17 = r8
            r8 = r57
            boolean r18 = r10.changed((java.lang.Object) r8)
            if (r18 == 0) goto L_0x01e5
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01e7
        L_0x01e5:
            r18 = r20
        L_0x01e7:
            r3 = r3 | r18
            goto L_0x01ee
        L_0x01ea:
            r17 = r8
            r8 = r57
        L_0x01ee:
            r18 = r11 & r20
            if (r18 == 0) goto L_0x01f7
            r3 = r3 | r24
            r8 = r58
            goto L_0x020a
        L_0x01f7:
            r18 = r12 & r24
            r8 = r58
            if (r18 != 0) goto L_0x020a
            boolean r18 = r10.changedInstance(r8)
            if (r18 == 0) goto L_0x0206
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0208
        L_0x0206:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x0208:
            r3 = r3 | r18
        L_0x020a:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r4 = r2 & r18
            r59 = r2
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r4 != r2) goto L_0x0242
            r2 = 599187(0x92493, float:8.3964E-40)
            r2 = r2 & r3
            r4 = 599186(0x92492, float:8.39638E-40)
            if (r2 != r4) goto L_0x0242
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x0226
            goto L_0x0242
        L_0x0226:
            r10.skipToGroupEnd()
            r6 = r47
            r9 = r50
            r11 = r52
            r12 = r53
            r13 = r54
            r19 = r55
            r16 = r57
            r8 = r7
            r4 = r15
            r15 = r56
            r7 = r5
            r5 = r14
            r14 = r10
            r10 = r51
            goto L_0x0685
        L_0x0242:
            r10.startDefaults()
            r2 = r13 & 1
            java.lang.String r8 = "CC(remember):SearchBar.android.kt#9igjgp"
            r18 = r8
            r8 = 6
            r4 = 1
            if (r2 == 0) goto L_0x028c
            boolean r2 = r10.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0256
            goto L_0x028c
        L_0x0256:
            r10.skipToGroupEnd()
            r0 = r11 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x025f
            r3 = r3 & -15
        L_0x025f:
            r0 = r11 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0265
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0265:
            r0 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x026d
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r3 = r3 & r0
        L_0x026d:
            r25 = r50
            r16 = r51
            r17 = r53
            r19 = r55
            r6 = r56
            r20 = r57
            r31 = r59
            r4 = r3
            r23 = r5
            r24 = r7
            r5 = r8
            r9 = r18
            r0 = 4
            r8 = r47
            r7 = r52
            r18 = r54
            goto L_0x036d
        L_0x028c:
            if (r1 == 0) goto L_0x0295
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r21 = r1
            goto L_0x0297
        L_0x0295:
            r21 = r47
        L_0x0297:
            if (r23 == 0) goto L_0x029c
            r23 = r4
            goto L_0x029e
        L_0x029c:
            r23 = r5
        L_0x029e:
            if (r6 == 0) goto L_0x02a3
            r24 = 0
            goto L_0x02a5
        L_0x02a3:
            r24 = r7
        L_0x02a5:
            if (r9 == 0) goto L_0x02aa
            r25 = 0
            goto L_0x02ac
        L_0x02aa:
            r25 = r50
        L_0x02ac:
            if (r0 == 0) goto L_0x02b0
            r0 = 0
            goto L_0x02b2
        L_0x02b0:
            r0 = r51
        L_0x02b2:
            r1 = r11 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x02c1
            androidx.compose.material3.SearchBarDefaults r1 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r1 = r1.getInputFieldShape(r10, r8)
            r3 = r3 & -15
            r26 = r1
            goto L_0x02c3
        L_0x02c1:
            r26 = r52
        L_0x02c3:
            r27 = r3
            r1 = r11 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x02ec
            androidx.compose.material3.SearchBarDefaults r1 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r9 = 3072(0xc00, float:4.305E-42)
            r29 = 7
            r2 = 0
            r5 = 0
            r7 = 0
            r31 = r59
            r4 = r5
            r6 = r7
            r7 = r10
            r33 = r18
            r18 = r17
            r17 = r22
            r8 = r9
            r47 = r0
            r0 = 4
            r9 = r29
            androidx.compose.material3.SearchBarColors r1 = r1.m2109colorsKlgxPg(r2, r4, r6, r7, r8, r9)
            r27 = r27 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02f9
        L_0x02ec:
            r31 = r59
            r47 = r0
            r33 = r18
            r0 = 4
            r18 = r17
            r17 = r22
            r1 = r53
        L_0x02f9:
            if (r17 == 0) goto L_0x0302
            androidx.compose.material3.SearchBarDefaults r2 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r2 = r2.m2113getTonalElevationD9Ej5fM()
            goto L_0x0304
        L_0x0302:
            r2 = r54
        L_0x0304:
            if (r18 == 0) goto L_0x030d
            androidx.compose.material3.SearchBarDefaults r3 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r3 = r3.m2112getShadowElevationD9Ej5fM()
            goto L_0x030f
        L_0x030d:
            r3 = r55
        L_0x030f:
            r4 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x0322
            androidx.compose.material3.SearchBarDefaults r4 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r5 = 6
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r10, r5)
            r6 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = r27 & r6
            r27 = r6
            goto L_0x0325
        L_0x0322:
            r5 = 6
            r4 = r56
        L_0x0325:
            if (r16 == 0) goto L_0x035a
            r6 = 851477946(0x32c085ba, float:2.2412554E-8)
            r10.startReplaceableGroup(r6)
            r9 = r33
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            java.lang.Object r6 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r6 != r7) goto L_0x0345
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r6)
        L_0x0345:
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = (androidx.compose.foundation.interaction.MutableInteractionSource) r6
            r10.endReplaceableGroup()
            r16 = r47
            r17 = r1
            r18 = r2
            r19 = r3
            r20 = r6
            r8 = r21
            r7 = r26
            r6 = r4
            goto L_0x036b
        L_0x035a:
            r9 = r33
            r16 = r47
            r20 = r57
            r17 = r1
            r18 = r2
            r19 = r3
            r6 = r4
            r8 = r21
            r7 = r26
        L_0x036b:
            r4 = r27
        L_0x036d:
            r10.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0381
            r1 = 1001512593(0x3bb1de91, float:0.0054281433)
            java.lang.String r2 = "androidx.compose.material3.SearchBar (SearchBar.android.kt:177)"
            r3 = r31
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r3, r4, r2)
            goto L_0x0383
        L_0x0381:
            r3 = r31
        L_0x0383:
            if (r15 == 0) goto L_0x0388
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0389
        L_0x0388:
            r1 = 0
        L_0x0389:
            if (r15 == 0) goto L_0x038e
            androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r2 = AnimationEnterFloatSpec
            goto L_0x0390
        L_0x038e:
            androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r2 = AnimationExitFloatSpec
        L_0x0390:
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r21 = 0
            r22 = 28
            r26 = 0
            r27 = 0
            r28 = 0
            r47 = r1
            r48 = r2
            r49 = r26
            r50 = r27
            r51 = r28
            r52 = r10
            r53 = r21
            r54 = r22
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r47, r48, r49, r50, r51, r52, r53, r54)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r0, r5)
            java.lang.Object r0 = r10.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r5 = r0
            androidx.compose.ui.focus.FocusManager r5 = (androidx.compose.ui.focus.FocusManager) r5
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            r31 = r3
            java.lang.String r3 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r3)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.material3.SearchBarDefaults r1 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r3 = 6
            androidx.compose.ui.graphics.Shape r1 = r1.getInputFieldShape(r10, r3)
            r47 = r5
            androidx.compose.material3.SearchBarDefaults r5 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r5 = r5.getFullScreenShape(r10, r3)
            r3 = 851478497(0x32c087e1, float:2.2413532E-8)
            r10.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            java.lang.Object r3 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r48 = r5
            java.lang.Object r5 = r22.getEmpty()
            if (r3 != r5) goto L_0x0419
            androidx.compose.runtime.SnapshotMutationPolicy r3 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            androidx.compose.material3.SearchBar_androidKt$SearchBar$useFullScreenShape$2$1 r5 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$useFullScreenShape$2$1
            r5.<init>(r2)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r3, r5)
            r10.updateRememberedValue(r3)
        L_0x0419:
            androidx.compose.runtime.State r3 = (androidx.compose.runtime.State) r3
            r10.endReplaceableGroup()
            boolean r5 = SearchBar_WuY5d9Q$lambda$2(r3)
            r11 = 851478623(0x32c0885f, float:2.2413756E-8)
            r10.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            boolean r5 = r10.changed((boolean) r5)
            r11 = r4 & 14
            r22 = 6
            r11 = r11 ^ 6
            r15 = 4
            if (r11 <= r15) goto L_0x043e
            boolean r11 = r10.changed((java.lang.Object) r7)
            if (r11 != 0) goto L_0x0442
        L_0x043e:
            r11 = r4 & 6
            if (r11 != r15) goto L_0x0444
        L_0x0442:
            r11 = 1
            goto L_0x0445
        L_0x0444:
            r11 = 0
        L_0x0445:
            r5 = r5 | r11
            java.lang.Object r11 = r10.rememberedValue()
            if (r5 != 0) goto L_0x0454
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r11 != r5) goto L_0x0478
        L_0x0454:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x046a
            androidx.compose.foundation.shape.GenericShape r1 = new androidx.compose.foundation.shape.GenericShape
            androidx.compose.material3.SearchBar_androidKt$SearchBar$animatedShape$1$1 r3 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$animatedShape$1$1
            r3.<init>(r0, r2)
            kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
            r1.<init>(r3)
            r5 = r1
            androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
            goto L_0x0474
        L_0x046a:
            boolean r1 = SearchBar_WuY5d9Q$lambda$2(r3)
            if (r1 == 0) goto L_0x0473
            r5 = r48
            goto L_0x0474
        L_0x0473:
            r5 = r7
        L_0x0474:
            r10.updateRememberedValue(r5)
            r11 = r5
        L_0x0478:
            r15 = r11
            androidx.compose.ui.graphics.Shape r15 = (androidx.compose.ui.graphics.Shape) r15
            r10.endReplaceableGroup()
            r1 = 851479649(0x32c08c61, float:2.2415579E-8)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            java.lang.Object r1 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r1 != r3) goto L_0x049e
            androidx.compose.material3.MutableWindowInsets r1 = new androidx.compose.material3.MutableWindowInsets
            r5 = 1
            r11 = 0
            r1.<init>(r11, r5, r11)
            r10.updateRememberedValue(r1)
            goto L_0x04a0
        L_0x049e:
            r5 = 1
            r11 = 0
        L_0x04a0:
            androidx.compose.material3.MutableWindowInsets r1 = (androidx.compose.material3.MutableWindowInsets) r1
            r10.endReplaceableGroup()
            r3 = 851479705(0x32c08c99, float:2.2415678E-8)
            r10.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            boolean r3 = r10.changed((java.lang.Object) r0)
            java.lang.Object r5 = r10.rememberedValue()
            if (r3 != 0) goto L_0x04c0
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x04ce
        L_0x04c0:
            androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1 r3 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
            r3.<init>(r1, r0)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r3)
            r10.updateRememberedValue(r5)
        L_0x04ce:
            androidx.compose.runtime.State r5 = (androidx.compose.runtime.State) r5
            r10.endReplaceableGroup()
            long r21 = r17.m2106getContainerColor0d7_KjU()
            long r11 = r17.m2106getContainerColor0d7_KjU()
            r3 = 0
            long r26 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r11, r10, r3)
            r0 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ZIndexModifierKt.zIndex(r8, r0)
            r11 = 851480211(0x32c08e93, float:2.2416577E-8)
            r10.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r4
            r11 = r11 ^ 24576(0x6000, float:3.4438E-41)
            r12 = 16384(0x4000, float:2.2959E-41)
            if (r11 <= r12) goto L_0x04ff
            boolean r11 = r10.changed((java.lang.Object) r6)
            if (r11 != 0) goto L_0x0503
        L_0x04ff:
            r11 = r4 & 24576(0x6000, float:3.4438E-41)
            if (r11 != r12) goto L_0x0505
        L_0x0503:
            r11 = 1
            goto L_0x0506
        L_0x0505:
            r11 = r3
        L_0x0506:
            java.lang.Object r3 = r10.rememberedValue()
            if (r11 != 0) goto L_0x0514
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r3 != r11) goto L_0x051e
        L_0x0514:
            androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1 r3 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
            r3.<init>(r1, r6)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r10.updateRememberedValue(r3)
        L_0x051e:
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(r0, r3)
            androidx.compose.foundation.layout.WindowInsets r1 = (androidx.compose.foundation.layout.WindowInsets) r1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.WindowInsetsPaddingKt.consumeWindowInsets((androidx.compose.ui.Modifier) r0, (androidx.compose.foundation.layout.WindowInsets) r1)
            r1 = 851480395(0x32c08f4b, float:2.2416904E-8)
            r10.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            boolean r1 = r10.changed((java.lang.Object) r5)
            boolean r3 = r10.changed((java.lang.Object) r2)
            r1 = r1 | r3
            java.lang.Object r3 = r10.rememberedValue()
            if (r1 != 0) goto L_0x054d
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x0558
        L_0x054d:
            androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1 r1 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
            r1.<init>(r5, r2)
            r3 = r1
            kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
            r10.updateRememberedValue(r3)
        L_0x0558:
            kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier r28 = androidx.compose.ui.layout.LayoutModifierKt.layout(r0, r3)
            androidx.compose.material3.SearchBar_androidKt$SearchBar$4 r11 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$4
            r0 = r11
            r1 = r42
            r29 = r2
            r2 = r43
            r30 = r31
            r31 = 0
            r3 = r44
            r33 = r4
            r4 = r45
            r36 = r47
            r32 = r5
            r47 = r15
            r15 = 1
            r5 = r46
            r34 = r6
            r6 = r23
            r35 = r7
            r7 = r24
            r37 = r8
            r8 = r25
            r38 = r9
            r9 = r16
            r39 = r10
            r10 = r17
            r40 = r11
            r11 = r20
            r12 = r29
            r13 = r32
            r14 = r58
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = 483163116(0x1ccc7bec, float:1.3531621E-21)
            r14 = r39
            r1 = r40
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r15, r1)
            r10 = r0
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            int r0 = r33 << 6
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r0
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r2
            r12 = r1 | r0
            r13 = 64
            r9 = 0
            r1 = r28
            r2 = r47
            r3 = r21
            r5 = r26
            r7 = r18
            r8 = r19
            r11 = r14
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13)
            r0 = r20
            androidx.compose.foundation.interaction.InteractionSource r0 = (androidx.compose.foundation.interaction.InteractionSource) r0
            int r1 = r33 >> 15
            r1 = r1 & 14
            androidx.compose.runtime.State r0 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r0, r14, r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r4 = r45
            r1 = r31
            if (r4 != 0) goto L_0x05ed
            if (r0 == 0) goto L_0x05ed
            r0 = r15
            goto L_0x05ee
        L_0x05ed:
            r0 = r1
        L_0x05ee:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r45)
            r3 = 851482799(0x32c098af, float:2.2421174E-8)
            r14.startReplaceableGroup(r3)
            r3 = r38
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r3)
            boolean r5 = r14.changed((boolean) r0)
            r6 = r36
            boolean r7 = r14.changedInstance(r6)
            r5 = r5 | r7
            java.lang.Object r7 = r14.rememberedValue()
            if (r5 != 0) goto L_0x0616
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r7 != r5) goto L_0x0622
        L_0x0616:
            androidx.compose.material3.SearchBar_androidKt$SearchBar$5$1 r5 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$5$1
            r7 = 0
            r5.<init>(r0, r6, r7)
            r7 = r5
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r14.updateRememberedValue(r7)
        L_0x0622:
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r14.endReplaceableGroup()
            int r0 = r30 >> 9
            r0 = r0 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r2, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r7, (androidx.compose.runtime.Composer) r14, (int) r0)
            r2 = 851483127(0x32c099f7, float:2.2421757E-8)
            r14.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r3)
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r30 & r2
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r2 != r3) goto L_0x0641
            goto L_0x0642
        L_0x0641:
            r15 = r1
        L_0x0642:
            java.lang.Object r2 = r14.rememberedValue()
            if (r15 != 0) goto L_0x0654
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0651
            goto L_0x0654
        L_0x0651:
            r5 = r46
            goto L_0x0660
        L_0x0654:
            androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1 r2 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
            r5 = r46
            r2.<init>(r5)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r14.updateRememberedValue(r2)
        L_0x0660:
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r14.endReplaceableGroup()
            androidx.activity.compose.BackHandlerKt.BackHandler(r4, r2, r14, r0, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0671
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0671:
            r10 = r16
            r12 = r17
            r13 = r18
            r16 = r20
            r7 = r23
            r8 = r24
            r9 = r25
            r15 = r34
            r11 = r35
            r6 = r37
        L_0x0685:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 == 0) goto L_0x06b1
            androidx.compose.material3.SearchBar_androidKt$SearchBar$7 r21 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$7
            r0 = r21
            r1 = r42
            r2 = r43
            r3 = r44
            r4 = r45
            r5 = r46
            r41 = r14
            r14 = r19
            r17 = r58
            r18 = r60
            r19 = r61
            r20 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r41
            r1.updateScope(r0)
        L_0x06b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2117SearchBarWuY5d9Q(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0124  */
    /* renamed from: DockedSearchBar-eWTbjVg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2116DockedSearchBareWTbjVg(java.lang.String r45, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r46, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r47, boolean r48, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r49, androidx.compose.ui.Modifier r50, boolean r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.ui.graphics.Shape r55, androidx.compose.material3.SearchBarColors r56, float r57, float r58, androidx.compose.foundation.interaction.MutableInteractionSource r59, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, androidx.compose.runtime.Composer r61, int r62, int r63, int r64) {
        /*
            r13 = r48
            r14 = r49
            r15 = r62
            r12 = r63
            r11 = r64
            r0 = 1299054533(0x4d6dffc5, float:2.49560144E8)
            r1 = r61
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,4)358@17745L11,359@17806L8,362@17986L39,365@18121L7,370@18228L38,367@18134L1617,413@19791L25,415@19898L292,415@19875L315,424@20226L37,424@20196L67:SearchBar.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x0021
            r1 = r15 | 6
            r9 = r45
            goto L_0x0033
        L_0x0021:
            r1 = r15 & 6
            r9 = r45
            if (r1 != 0) goto L_0x0032
            boolean r1 = r10.changed((java.lang.Object) r9)
            if (r1 == 0) goto L_0x002f
            r1 = 4
            goto L_0x0030
        L_0x002f:
            r1 = 2
        L_0x0030:
            r1 = r1 | r15
            goto L_0x0033
        L_0x0032:
            r1 = r15
        L_0x0033:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x003c
            r1 = r1 | 48
            r8 = r46
            goto L_0x004e
        L_0x003c:
            r4 = r15 & 48
            r8 = r46
            if (r4 != 0) goto L_0x004e
            boolean r4 = r10.changedInstance(r8)
            if (r4 == 0) goto L_0x004b
            r4 = 32
            goto L_0x004d
        L_0x004b:
            r4 = 16
        L_0x004d:
            r1 = r1 | r4
        L_0x004e:
            r4 = r11 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0057
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0057:
            r4 = r15 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x006b
            r4 = r47
            boolean r17 = r10.changedInstance(r4)
            if (r17 == 0) goto L_0x0066
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r17 = r16
        L_0x0068:
            r1 = r1 | r17
            goto L_0x006d
        L_0x006b:
            r4 = r47
        L_0x006d:
            r17 = r11 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0078
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0078:
            r2 = r15 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0088
            boolean r2 = r10.changed((boolean) r13)
            if (r2 == 0) goto L_0x0085
            r2 = r18
            goto L_0x0087
        L_0x0085:
            r2 = r19
        L_0x0087:
            r1 = r1 | r2
        L_0x0088:
            r2 = r11 & 16
            r17 = 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0091
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x0091:
            r2 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x00a1
            boolean r2 = r10.changedInstance(r14)
            if (r2 == 0) goto L_0x009e
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r2 = r17
        L_0x00a0:
            r1 = r1 | r2
        L_0x00a1:
            r2 = r11 & 32
            r21 = 196608(0x30000, float:2.75506E-40)
            if (r2 == 0) goto L_0x00ac
            r1 = r1 | r21
            r0 = r50
            goto L_0x00bf
        L_0x00ac:
            r22 = r15 & r21
            r0 = r50
            if (r22 != 0) goto L_0x00bf
            boolean r23 = r10.changed((java.lang.Object) r0)
            if (r23 == 0) goto L_0x00bb
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r1 = r1 | r23
        L_0x00bf:
            r23 = r11 & 64
            r24 = 1572864(0x180000, float:2.204052E-39)
            if (r23 == 0) goto L_0x00ca
            r1 = r1 | r24
            r3 = r51
            goto L_0x00dd
        L_0x00ca:
            r24 = r15 & r24
            r3 = r51
            if (r24 != 0) goto L_0x00dd
            boolean r25 = r10.changed((boolean) r3)
            if (r25 == 0) goto L_0x00d9
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r1 = r1 | r25
        L_0x00dd:
            r5 = r11 & 128(0x80, float:1.794E-43)
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            if (r5 == 0) goto L_0x00e8
            r1 = r1 | r26
            r6 = r52
            goto L_0x00fb
        L_0x00e8:
            r27 = r15 & r26
            r6 = r52
            if (r27 != 0) goto L_0x00fb
            boolean r28 = r10.changedInstance(r6)
            if (r28 == 0) goto L_0x00f7
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r1 = r1 | r28
        L_0x00fb:
            r7 = r11 & 256(0x100, float:3.59E-43)
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            if (r7 == 0) goto L_0x0106
            r1 = r1 | r29
            r0 = r53
            goto L_0x0119
        L_0x0106:
            r29 = r15 & r29
            r0 = r53
            if (r29 != 0) goto L_0x0119
            boolean r29 = r10.changedInstance(r0)
            if (r29 == 0) goto L_0x0115
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r1 = r1 | r29
        L_0x0119:
            r0 = r11 & 512(0x200, float:7.175E-43)
            r29 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0124
            r1 = r1 | r29
            r3 = r54
            goto L_0x0137
        L_0x0124:
            r29 = r15 & r29
            r3 = r54
            if (r29 != 0) goto L_0x0137
            boolean r29 = r10.changedInstance(r3)
            if (r29 == 0) goto L_0x0133
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0135
        L_0x0133:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0135:
            r1 = r1 | r29
        L_0x0137:
            r29 = r12 & 6
            if (r29 != 0) goto L_0x0151
            r3 = r11 & 1024(0x400, float:1.435E-42)
            if (r3 != 0) goto L_0x014a
            r3 = r55
            boolean r29 = r10.changed((java.lang.Object) r3)
            if (r29 == 0) goto L_0x014c
            r24 = 4
            goto L_0x014e
        L_0x014a:
            r3 = r55
        L_0x014c:
            r24 = 2
        L_0x014e:
            r24 = r12 | r24
            goto L_0x0155
        L_0x0151:
            r3 = r55
            r24 = r12
        L_0x0155:
            r29 = r12 & 48
            if (r29 != 0) goto L_0x016f
            r3 = r11 & 2048(0x800, float:2.87E-42)
            if (r3 != 0) goto L_0x0168
            r3 = r56
            boolean r29 = r10.changed((java.lang.Object) r3)
            if (r29 == 0) goto L_0x016a
            r25 = 32
            goto L_0x016c
        L_0x0168:
            r3 = r56
        L_0x016a:
            r25 = 16
        L_0x016c:
            r24 = r24 | r25
            goto L_0x0171
        L_0x016f:
            r3 = r56
        L_0x0171:
            r3 = r24
            r9 = r11 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x017a
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x018e
        L_0x017a:
            r4 = r12 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x018e
            r4 = r57
            boolean r24 = r10.changed((float) r4)
            if (r24 == 0) goto L_0x0189
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x018b
        L_0x0189:
            r28 = r16
        L_0x018b:
            r3 = r3 | r28
            goto L_0x0190
        L_0x018e:
            r4 = r57
        L_0x0190:
            r16 = r9
            r9 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x0199
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x01ab
        L_0x0199:
            r4 = r12 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x01ab
            r4 = r58
            boolean r24 = r10.changed((float) r4)
            if (r24 == 0) goto L_0x01a6
            goto L_0x01a8
        L_0x01a6:
            r18 = r19
        L_0x01a8:
            r3 = r3 | r18
            goto L_0x01ad
        L_0x01ab:
            r4 = r58
        L_0x01ad:
            r18 = r9
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01b6
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01c7
        L_0x01b6:
            r4 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r4 != 0) goto L_0x01c7
            r4 = r59
            boolean r19 = r10.changed((java.lang.Object) r4)
            if (r19 == 0) goto L_0x01c4
            r17 = 16384(0x4000, float:2.2959E-41)
        L_0x01c4:
            r3 = r3 | r17
            goto L_0x01c9
        L_0x01c7:
            r4 = r59
        L_0x01c9:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x01d3
            r3 = r3 | r21
            goto L_0x01e9
        L_0x01d3:
            r17 = r12 & r21
            if (r17 != 0) goto L_0x01e9
            r17 = r9
            r9 = r60
            boolean r19 = r10.changedInstance(r9)
            if (r19 == 0) goto L_0x01e4
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01e6
        L_0x01e4:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x01e6:
            r3 = r3 | r19
            goto L_0x01ed
        L_0x01e9:
            r17 = r9
            r9 = r60
        L_0x01ed:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r4 = r1 & r19
            r61 = r1
            r1 = 306783378(0x12492492, float:6.3469493E-28)
            if (r4 != r1) goto L_0x0224
            r1 = 74899(0x12493, float:1.04956E-40)
            r1 = r1 & r3
            r4 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r4) goto L_0x0224
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x0209
            goto L_0x0224
        L_0x0209:
            r10.skipToGroupEnd()
            r7 = r51
            r9 = r53
            r11 = r55
            r12 = r56
            r15 = r59
            r8 = r6
            r1 = r10
            r4 = r13
            r5 = r14
            r6 = r50
            r10 = r54
            r13 = r57
            r14 = r58
            goto L_0x0485
        L_0x0224:
            r10.startDefaults()
            r1 = r15 & 1
            java.lang.String r4 = "CC(remember):SearchBar.android.kt#9igjgp"
            r9 = 1
            if (r1 == 0) goto L_0x025f
            boolean r1 = r10.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0235
            goto L_0x025f
        L_0x0235:
            r10.skipToGroupEnd()
            r0 = r11 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x023e
            r3 = r3 & -15
        L_0x023e:
            r0 = r11 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0244
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0244:
            r8 = r50
            r29 = r51
            r32 = r53
            r33 = r54
            r34 = r55
            r35 = r56
            r36 = r57
            r37 = r58
            r38 = r59
            r31 = r61
            r7 = r3
            r30 = r6
            r15 = r9
            r9 = r4
            goto L_0x032f
        L_0x025f:
            if (r2 == 0) goto L_0x0268
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r21 = r1
            goto L_0x026a
        L_0x0268:
            r21 = r50
        L_0x026a:
            if (r23 == 0) goto L_0x026f
            r23 = r9
            goto L_0x0271
        L_0x026f:
            r23 = r51
        L_0x0271:
            if (r5 == 0) goto L_0x0276
            r24 = 0
            goto L_0x0278
        L_0x0276:
            r24 = r6
        L_0x0278:
            if (r7 == 0) goto L_0x027d
            r25 = 0
            goto L_0x027f
        L_0x027d:
            r25 = r53
        L_0x027f:
            if (r0 == 0) goto L_0x0283
            r0 = 0
            goto L_0x0285
        L_0x0283:
            r0 = r54
        L_0x0285:
            r1 = r11 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0295
            androidx.compose.material3.SearchBarDefaults r1 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r2 = 6
            androidx.compose.ui.graphics.Shape r1 = r1.getDockedShape(r10, r2)
            r3 = r3 & -15
            r27 = r1
            goto L_0x0297
        L_0x0295:
            r27 = r55
        L_0x0297:
            r28 = r3
            r1 = r11 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x02c2
            androidx.compose.material3.SearchBarDefaults r1 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r29 = 3072(0xc00, float:4.305E-42)
            r30 = 7
            r2 = 0
            r5 = 0
            r7 = 0
            r31 = r61
            r32 = r4
            r4 = r5
            r6 = r7
            r7 = r10
            r8 = r29
            r15 = r9
            r44 = r18
            r18 = r17
            r17 = r44
            r9 = r30
            androidx.compose.material3.SearchBarColors r1 = r1.m2109colorsKlgxPg(r2, r4, r6, r7, r8, r9)
            r2 = r28 & -113(0xffffffffffffff8f, float:NaN)
            r3 = r2
            goto L_0x02d1
        L_0x02c2:
            r31 = r61
            r32 = r4
            r15 = r9
            r44 = r18
            r18 = r17
            r17 = r44
            r1 = r56
            r3 = r28
        L_0x02d1:
            if (r16 == 0) goto L_0x02da
            androidx.compose.material3.SearchBarDefaults r2 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r2 = r2.m2113getTonalElevationD9Ej5fM()
            goto L_0x02dc
        L_0x02da:
            r2 = r57
        L_0x02dc:
            if (r17 == 0) goto L_0x02e5
            androidx.compose.material3.SearchBarDefaults r4 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r4 = r4.m2112getShadowElevationD9Ej5fM()
            goto L_0x02e7
        L_0x02e5:
            r4 = r58
        L_0x02e7:
            if (r18 == 0) goto L_0x0318
            r5 = -32072212(0xfffffffffe169dec, float:-5.0051044E37)
            r10.startReplaceableGroup(r5)
            r9 = r32
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            java.lang.Object r5 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x0307
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r5)
        L_0x0307:
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            r10.endReplaceableGroup()
            r33 = r0
            r35 = r1
            r36 = r2
            r7 = r3
            r37 = r4
            r38 = r5
            goto L_0x0325
        L_0x0318:
            r9 = r32
            r38 = r59
            r33 = r0
            r35 = r1
            r36 = r2
            r7 = r3
            r37 = r4
        L_0x0325:
            r8 = r21
            r29 = r23
            r30 = r24
            r32 = r25
            r34 = r27
        L_0x032f:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0343
            java.lang.String r0 = "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:364)"
            r6 = r31
            r1 = 1299054533(0x4d6dffc5, float:2.49560144E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r6, r7, r0)
            goto L_0x0345
        L_0x0343:
            r6 = r31
        L_0x0345:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r2)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r5 = r0
            androidx.compose.ui.focus.FocusManager r5 = (androidx.compose.ui.focus.FocusManager) r5
            long r18 = r35.m2106getContainerColor0d7_KjU()
            long r0 = r35.m2106getContainerColor0d7_KjU()
            r4 = 0
            long r20 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r0, r10, r4)
            r0 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ZIndexModifierKt.zIndex(r8, r0)
            float r1 = SearchBarMinWidth
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.SizeKt.m747width3ABfNKs(r0, r1)
            androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2 r3 = new androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
            r2 = 16384(0x4000, float:2.2959E-41)
            r0 = r3
            r1 = r45
            r2 = r46
            r14 = r3
            r3 = r47
            r4 = r48
            r39 = r5
            r5 = r49
            r31 = r6
            r6 = r29
            r40 = r7
            r7 = r30
            r41 = r8
            r8 = r32
            r42 = r9
            r9 = r33
            r13 = r10
            r10 = r35
            r11 = r38
            r12 = r60
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = 1088676554(0x40e3e2ca, float:7.121434)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r15, r14)
            r25 = r0
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            int r0 = r40 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r26
            int r1 = r40 << 6
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r2
            r27 = r0 | r1
            r28 = 64
            r24 = 0
            r17 = r34
            r22 = r36
            r23 = r37
            r26 = r13
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r16, r17, r18, r20, r22, r23, r24, r25, r26, r27, r28)
            r0 = r38
            androidx.compose.foundation.interaction.InteractionSource r0 = (androidx.compose.foundation.interaction.InteractionSource) r0
            int r1 = r40 >> 12
            r1 = r1 & 14
            androidx.compose.runtime.State r0 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r0, r13, r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = r13
            if (r4 != 0) goto L_0x03eb
            if (r0 == 0) goto L_0x03eb
            r9 = r15
            goto L_0x03ec
        L_0x03eb:
            r9 = 0
        L_0x03ec:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r48)
            r2 = -32070300(0xfffffffffe16a564, float:-5.006074E37)
            r1.startReplaceableGroup(r2)
            r2 = r42
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            boolean r3 = r1.changed((boolean) r9)
            r5 = r39
            boolean r6 = r1.changedInstance(r5)
            r3 = r3 | r6
            java.lang.Object r6 = r1.rememberedValue()
            if (r3 != 0) goto L_0x0414
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x0420
        L_0x0414:
            androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$3$1 r3 = new androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$3$1
            r6 = 0
            r3.<init>(r9, r5, r6)
            r6 = r3
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r1.updateRememberedValue(r6)
        L_0x0420:
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r1.endReplaceableGroup()
            int r3 = r31 >> 9
            r3 = r3 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r6, (androidx.compose.runtime.Composer) r1, (int) r3)
            r0 = -32069972(0xfffffffffe16a6ac, float:-5.00624E37)
            r1.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r0 = 57344(0xe000, float:8.0356E-41)
            r0 = r31 & r0
            r2 = 16384(0x4000, float:2.2959E-41)
            if (r0 != r2) goto L_0x0440
            r9 = r15
            goto L_0x0441
        L_0x0440:
            r9 = 0
        L_0x0441:
            java.lang.Object r0 = r1.rememberedValue()
            if (r9 != 0) goto L_0x0453
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x0450
            goto L_0x0453
        L_0x0450:
            r5 = r49
            goto L_0x045f
        L_0x0453:
            androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1 r0 = new androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
            r5 = r49
            r0.<init>(r5)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1.updateRememberedValue(r0)
        L_0x045f:
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1.endReplaceableGroup()
            r2 = 0
            androidx.activity.compose.BackHandlerKt.BackHandler(r4, r0, r1, r3, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0471
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0471:
            r7 = r29
            r8 = r30
            r9 = r32
            r10 = r33
            r11 = r34
            r12 = r35
            r13 = r36
            r14 = r37
            r15 = r38
            r6 = r41
        L_0x0485:
            androidx.compose.runtime.ScopeUpdateScope r3 = r1.endRestartGroup()
            if (r3 == 0) goto L_0x04af
            androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$5 r20 = new androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$5
            r0 = r20
            r1 = r45
            r2 = r46
            r43 = r3
            r3 = r47
            r4 = r48
            r5 = r49
            r16 = r60
            r17 = r62
            r18 = r63
            r19 = r64
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r43
            r1.updateScope(r0)
        L_0x04af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2116DockedSearchBareWTbjVg(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:213:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SearchBarInputField(java.lang.String r82, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r83, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r84, boolean r85, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r86, androidx.compose.ui.Modifier r87, boolean r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r90, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r91, androidx.compose.material3.TextFieldColors r92, androidx.compose.foundation.interaction.MutableInteractionSource r93, androidx.compose.runtime.Composer r94, int r95, int r96, int r97) {
        /*
            r13 = r82
            r6 = r84
            r5 = r85
            r3 = r86
            r2 = r95
            r1 = r97
            r0 = 496394889(0x1d966289, float:3.9806552E-21)
            r4 = r94
            androidx.compose.runtime.Composer r12 = r4.startRestartGroup(r0)
            java.lang.String r4 = "C(SearchBarInputField)P(10,7,8!1,6,5,2,9,4,11)442@20766L18,443@20836L39,445@20906L29,446@20962L34,447@21037L39,459@21490L42,460@21556L304,472@21951L7,473@22036L28,475@22199L19,452@21246L2004:SearchBar.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            r4 = r1 & 1
            if (r4 == 0) goto L_0x0021
            r4 = r2 | 6
            goto L_0x0031
        L_0x0021:
            r4 = r2 & 6
            if (r4 != 0) goto L_0x0030
            boolean r4 = r12.changed((java.lang.Object) r13)
            if (r4 == 0) goto L_0x002d
            r4 = 4
            goto L_0x002e
        L_0x002d:
            r4 = 2
        L_0x002e:
            r4 = r4 | r2
            goto L_0x0031
        L_0x0030:
            r4 = r2
        L_0x0031:
            r9 = r1 & 2
            if (r9 == 0) goto L_0x0038
            r4 = r4 | 48
            goto L_0x004b
        L_0x0038:
            r9 = r2 & 48
            if (r9 != 0) goto L_0x004b
            r9 = r83
            boolean r14 = r12.changedInstance(r9)
            if (r14 == 0) goto L_0x0047
            r14 = 32
            goto L_0x0049
        L_0x0047:
            r14 = 16
        L_0x0049:
            r4 = r4 | r14
            goto L_0x004d
        L_0x004b:
            r9 = r83
        L_0x004d:
            r14 = r1 & 4
            if (r14 == 0) goto L_0x0054
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0054:
            r14 = r2 & 384(0x180, float:5.38E-43)
            if (r14 != 0) goto L_0x0064
            boolean r14 = r12.changedInstance(r6)
            if (r14 == 0) goto L_0x0061
            r14 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r14 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r14
        L_0x0064:
            r14 = r1 & 8
            if (r14 == 0) goto L_0x006b
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x006b:
            r14 = r2 & 3072(0xc00, float:4.305E-42)
            if (r14 != 0) goto L_0x007b
            boolean r14 = r12.changed((boolean) r5)
            if (r14 == 0) goto L_0x0078
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r4 = r4 | r14
        L_0x007b:
            r14 = r1 & 16
            if (r14 == 0) goto L_0x0082
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0092
        L_0x0082:
            r14 = r2 & 24576(0x6000, float:3.4438E-41)
            if (r14 != 0) goto L_0x0092
            boolean r14 = r12.changedInstance(r3)
            if (r14 == 0) goto L_0x008f
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0091
        L_0x008f:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0091:
            r4 = r4 | r14
        L_0x0092:
            r14 = r1 & 32
            r46 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x009d
            r4 = r4 | r46
            r11 = r87
            goto L_0x00b0
        L_0x009d:
            r17 = r2 & r46
            r11 = r87
            if (r17 != 0) goto L_0x00b0
            boolean r18 = r12.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x00ac
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ae
        L_0x00ac:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00ae:
            r4 = r4 | r18
        L_0x00b0:
            r18 = r1 & 64
            r19 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00bb
            r4 = r4 | r19
            r15 = r88
            goto L_0x00ce
        L_0x00bb:
            r19 = r2 & r19
            r15 = r88
            if (r19 != 0) goto L_0x00ce
            boolean r20 = r12.changed((boolean) r15)
            if (r20 == 0) goto L_0x00ca
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00ca:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00cc:
            r4 = r4 | r20
        L_0x00ce:
            r8 = r1 & 128(0x80, float:1.794E-43)
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            if (r8 == 0) goto L_0x00d9
            r4 = r4 | r20
            r7 = r89
            goto L_0x00ec
        L_0x00d9:
            r20 = r2 & r20
            r7 = r89
            if (r20 != 0) goto L_0x00ec
            boolean r20 = r12.changedInstance(r7)
            if (r20 == 0) goto L_0x00e8
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00e8:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ea:
            r4 = r4 | r20
        L_0x00ec:
            r10 = r1 & 256(0x100, float:3.59E-43)
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            if (r10 == 0) goto L_0x00f7
            r4 = r4 | r20
            r0 = r90
            goto L_0x010a
        L_0x00f7:
            r20 = r2 & r20
            r0 = r90
            if (r20 != 0) goto L_0x010a
            boolean r20 = r12.changedInstance(r0)
            if (r20 == 0) goto L_0x0106
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0108
        L_0x0106:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0108:
            r4 = r4 | r20
        L_0x010a:
            r0 = r1 & 512(0x200, float:7.175E-43)
            r20 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0115
            r4 = r4 | r20
            r7 = r91
            goto L_0x0128
        L_0x0115:
            r20 = r2 & r20
            r7 = r91
            if (r20 != 0) goto L_0x0128
            boolean r20 = r12.changedInstance(r7)
            if (r20 == 0) goto L_0x0124
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0126
        L_0x0124:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0126:
            r4 = r4 | r20
        L_0x0128:
            r20 = r96 & 6
            if (r20 != 0) goto L_0x0142
            r7 = r1 & 1024(0x400, float:1.435E-42)
            if (r7 != 0) goto L_0x013b
            r7 = r92
            boolean r20 = r12.changed((java.lang.Object) r7)
            if (r20 == 0) goto L_0x013d
            r20 = 4
            goto L_0x013f
        L_0x013b:
            r7 = r92
        L_0x013d:
            r20 = 2
        L_0x013f:
            r20 = r96 | r20
            goto L_0x0146
        L_0x0142:
            r7 = r92
            r20 = r96
        L_0x0146:
            r15 = r1 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0153
            r20 = r20 | 48
            r21 = r15
            r47 = r20
            r15 = r93
            goto L_0x016f
        L_0x0153:
            r21 = r96 & 48
            if (r21 != 0) goto L_0x0169
            r21 = r15
            r15 = r93
            boolean r22 = r12.changed((java.lang.Object) r15)
            if (r22 == 0) goto L_0x0164
            r16 = 32
            goto L_0x0166
        L_0x0164:
            r16 = 16
        L_0x0166:
            r20 = r20 | r16
            goto L_0x016d
        L_0x0169:
            r21 = r15
            r15 = r93
        L_0x016d:
            r47 = r20
        L_0x016f:
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r7 = r4 & r16
            r9 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r9) goto L_0x0199
            r7 = r47 & 19
            r9 = 18
            if (r7 != r9) goto L_0x0199
            boolean r7 = r12.getSkipping()
            if (r7 != 0) goto L_0x0186
            goto L_0x0199
        L_0x0186:
            r12.skipToGroupEnd()
            r7 = r88
            r8 = r89
            r9 = r90
            r10 = r91
            r6 = r11
            r28 = r12
            r12 = r15
            r11 = r92
            goto L_0x04ea
        L_0x0199:
            r12.startDefaults()
            r7 = r2 & 1
            java.lang.String r9 = "CC(remember):SearchBar.android.kt#9igjgp"
            r15 = 1
            if (r7 == 0) goto L_0x01c5
            boolean r7 = r12.getDefaultsInvalid()
            if (r7 == 0) goto L_0x01aa
            goto L_0x01c5
        L_0x01aa:
            r12.skipToGroupEnd()
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01b3
            r47 = r47 & -15
        L_0x01b3:
            r20 = r88
            r21 = r89
            r22 = r90
            r23 = r91
            r24 = r93
            r0 = r11
            r8 = r47
            r1 = 0
            r11 = r92
            goto L_0x025d
        L_0x01c5:
            if (r14 == 0) goto L_0x01cc
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            goto L_0x01cd
        L_0x01cc:
            r7 = r11
        L_0x01cd:
            if (r18 == 0) goto L_0x01d1
            r11 = r15
            goto L_0x01d3
        L_0x01d1:
            r11 = r88
        L_0x01d3:
            if (r8 == 0) goto L_0x01d7
            r8 = 0
            goto L_0x01d9
        L_0x01d7:
            r8 = r89
        L_0x01d9:
            if (r10 == 0) goto L_0x01dd
            r10 = 0
            goto L_0x01df
        L_0x01dd:
            r10 = r90
        L_0x01df:
            if (r0 == 0) goto L_0x01e3
            r0 = 0
            goto L_0x01e5
        L_0x01e3:
            r0 = r91
        L_0x01e5:
            r14 = r1 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x021e
            androidx.compose.material3.SearchBarDefaults r14 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            r44 = 24576(0x6000, float:3.4438E-41)
            r45 = 16383(0x3fff, float:2.2957E-41)
            r16 = 0
            r87 = r0
            r0 = r15
            r48 = r21
            r1 = 0
            r15 = r16
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r43 = 0
            r42 = r12
            androidx.compose.material3.TextFieldColors r14 = r14.m2115inputFieldColorsITpI4ow(r15, r17, r19, r21, r23, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r43, r44, r45)
            r47 = r47 & -15
            goto L_0x0226
        L_0x021e:
            r87 = r0
            r0 = r15
            r48 = r21
            r1 = 0
            r14 = r92
        L_0x0226:
            if (r48 == 0) goto L_0x024f
            r15 = 462567468(0x1b92382c, float:2.4189974E-22)
            r12.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            java.lang.Object r15 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r16.getEmpty()
            if (r15 != r0) goto L_0x0244
            androidx.compose.foundation.interaction.MutableInteractionSource r15 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r15)
        L_0x0244:
            r0 = r15
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r12.endReplaceableGroup()
            r23 = r87
            r24 = r0
            goto L_0x0253
        L_0x024f:
            r23 = r87
            r24 = r93
        L_0x0253:
            r0 = r7
            r21 = r8
            r22 = r10
            r20 = r11
            r11 = r14
            r8 = r47
        L_0x025d:
            r12.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x026e
            java.lang.String r7 = "androidx.compose.material3.SearchBarInputField (SearchBar.android.kt:444)"
            r10 = 496394889(0x1d966289, float:3.9806552E-21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r4, r8, r7)
        L_0x026e:
            r7 = 462567538(0x1b923872, float:2.419015E-22)
            r12.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            java.lang.Object r7 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r7 != r10) goto L_0x028b
            androidx.compose.ui.focus.FocusRequester r7 = new androidx.compose.ui.focus.FocusRequester
            r7.<init>()
            r12.updateRememberedValue(r7)
        L_0x028b:
            androidx.compose.ui.focus.FocusRequester r7 = (androidx.compose.ui.focus.FocusRequester) r7
            r12.endReplaceableGroup()
            androidx.compose.material3.Strings$Companion r10 = androidx.compose.material3.Strings.Companion
            int r10 = androidx.compose.material3.R.string.m3c_search_bar_search
            int r10 = androidx.compose.material3.Strings.m2224constructorimpl(r10)
            r15 = 0
            java.lang.String r10 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r10, r12, r15)
            androidx.compose.material3.Strings$Companion r14 = androidx.compose.material3.Strings.Companion
            int r14 = androidx.compose.material3.R.string.m3c_suggestions_available
            int r14 = androidx.compose.material3.Strings.m2224constructorimpl(r14)
            java.lang.String r14 = androidx.compose.material3.Strings_androidKt.m2293getStringNWtq28(r14, r12, r15)
            r15 = 462567758(0x1b92394e, float:2.4190706E-22)
            r12.startReplaceableGroup(r15)
            java.lang.String r15 = "*448@21112L7,449@21154L74"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r2)
            java.lang.Object r1 = r12.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.text.TextStyle r1 = (androidx.compose.ui.text.TextStyle) r1
            long r1 = r1.m6072getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r15 = androidx.compose.ui.graphics.Color.Companion
            long r15 = r15.m3852getUnspecified0d7_KjU()
            int r15 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r15 == 0) goto L_0x02da
            goto L_0x0309
        L_0x02da:
            r1 = r24
            androidx.compose.foundation.interaction.InteractionSource r1 = (androidx.compose.foundation.interaction.InteractionSource) r1
            int r2 = r4 >> 18
            r2 = r2 & 14
            r2 = r2 | 48
            int r15 = r8 << 3
            r15 = r15 & 896(0x380, float:1.256E-42)
            r2 = r2 | r15
            int r15 = r8 << 9
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r15
            r15 = 0
            r87 = r11
            r88 = r20
            r89 = r15
            r90 = r1
            r91 = r12
            r92 = r2
            androidx.compose.runtime.State r1 = r87.textColor$material3_release(r88, r89, r90, r91, r92)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m3826unboximpl()
        L_0x0309:
            r50 = r1
            r12.endReplaceableGroup()
            androidx.compose.material3.SearchBarDefaults r1 = androidx.compose.material3.SearchBarDefaults.INSTANCE
            float r1 = r1.m2111getInputFieldHeightD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m728height3ABfNKs(r0, r1)
            r2 = 0
            r16 = r0
            r0 = 1
            r15 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r2, r0, r15)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r1, r7)
            r1 = 462568122(0x1b923aba, float:2.4191625E-22)
            r12.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r4
            r2 = 16384(0x4000, float:2.2959E-41)
            if (r1 != r2) goto L_0x0338
            r15 = 1
            goto L_0x0339
        L_0x0338:
            r15 = 0
        L_0x0339:
            java.lang.Object r1 = r12.rememberedValue()
            if (r15 != 0) goto L_0x0347
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0351
        L_0x0347:
            androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$2$1 r1 = new androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$2$1
            r1.<init>(r3)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r12.updateRememberedValue(r1)
        L_0x0351:
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r12.endReplaceableGroup()
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.focus.FocusChangedModifierKt.onFocusChanged(r0, r1)
            r1 = 462568188(0x1b923afc, float:2.4191792E-22)
            r12.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            boolean r1 = r12.changed((java.lang.Object) r10)
            r2 = r4 & 7168(0x1c00, float:1.0045E-41)
            r15 = 2048(0x800, float:2.87E-42)
            if (r2 != r15) goto L_0x036f
            r15 = 1
            goto L_0x0370
        L_0x036f:
            r15 = 0
        L_0x0370:
            r1 = r1 | r15
            boolean r2 = r12.changed((java.lang.Object) r14)
            r1 = r1 | r2
            java.lang.Object r2 = r12.rememberedValue()
            if (r1 != 0) goto L_0x0384
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x038f
        L_0x0384:
            androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1 r1 = new androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1
            r1.<init>(r10, r5, r14, r7)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.updateRememberedValue(r2)
        L_0x038f:
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.endReplaceableGroup()
            r1 = 0
            r7 = 0
            r10 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r0, r7, r2, r10, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material3.TextKt.getLocalTextStyle()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r7)
            java.lang.Object r0 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            androidx.compose.ui.text.TextStyle r1 = new androidx.compose.ui.text.TextStyle
            r49 = r1
            r79 = 16777214(0xfffffe, float:2.3509884E-38)
            r80 = 0
            r52 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = 0
            r66 = 0
            r67 = 0
            r68 = 0
            r69 = 0
            r70 = 0
            r71 = 0
            r73 = 0
            r74 = 0
            r75 = 0
            r76 = 0
            r77 = 0
            r78 = 0
            r49.<init>((long) r50, (long) r52, (androidx.compose.ui.text.font.FontWeight) r54, (androidx.compose.ui.text.font.FontStyle) r55, (androidx.compose.ui.text.font.FontSynthesis) r56, (androidx.compose.ui.text.font.FontFamily) r57, (java.lang.String) r58, (long) r59, (androidx.compose.ui.text.style.BaselineShift) r61, (androidx.compose.ui.text.style.TextGeometricTransform) r62, (androidx.compose.ui.text.intl.LocaleList) r63, (long) r64, (androidx.compose.ui.text.style.TextDecoration) r66, (androidx.compose.ui.graphics.Shadow) r67, (androidx.compose.ui.graphics.drawscope.DrawStyle) r68, (int) r69, (int) r70, (long) r71, (androidx.compose.ui.text.style.TextIndent) r73, (androidx.compose.ui.text.PlatformTextStyle) r74, (androidx.compose.ui.text.style.LineHeightStyle) r75, (int) r76, (int) r77, (androidx.compose.ui.text.style.TextMotion) r78, (int) r79, (kotlin.jvm.internal.DefaultConstructorMarker) r80)
            androidx.compose.ui.text.TextStyle r25 = r0.merge((androidx.compose.ui.text.TextStyle) r1)
            androidx.compose.ui.graphics.SolidColor r0 = new androidx.compose.ui.graphics.SolidColor
            int r1 = r8 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            r7 = 0
            androidx.compose.runtime.State r1 = r11.cursorColor$material3_release(r7, r12, r1)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r14 = r1.m3826unboximpl()
            r1 = 0
            r0.<init>(r14, r1)
            androidx.compose.foundation.text.KeyboardOptions r26 = new androidx.compose.foundation.text.KeyboardOptions
            androidx.compose.ui.text.input.ImeAction$Companion r1 = androidx.compose.ui.text.input.ImeAction.Companion
            int r1 = r1.m6243getSearcheUduSuo()
            r10 = 23
            r14 = 0
            r15 = 0
            r18 = 0
            r19 = 0
            r27 = 0
            r87 = r26
            r88 = r15
            r89 = r18
            r90 = r19
            r91 = r1
            r92 = r27
            r93 = r10
            r94 = r14
            r87.<init>(r88, r89, r90, r91, r92, r93, r94)
            r1 = 462568831(0x1b923d7f, float:2.4193415E-22)
            r12.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            r1 = r4 & 896(0x380, float:1.256E-42)
            r9 = 256(0x100, float:3.59E-43)
            if (r1 != r9) goto L_0x0441
            r15 = 1
            goto L_0x0442
        L_0x0441:
            r15 = r7
        L_0x0442:
            r1 = r4 & 14
            r9 = 4
            if (r1 != r9) goto L_0x0448
            r7 = 1
        L_0x0448:
            r7 = r7 | r15
            java.lang.Object r9 = r12.rememberedValue()
            if (r7 != 0) goto L_0x0457
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r9 != r7) goto L_0x0462
        L_0x0457:
            androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$4$1 r7 = new androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$4$1
            r7.<init>(r6, r13)
            r9 = r7
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r12.updateRememberedValue(r9)
        L_0x0462:
            r32 = r9
            kotlin.jvm.functions.Function1 r32 = (kotlin.jvm.functions.Function1) r32
            r12.endReplaceableGroup()
            androidx.compose.foundation.text.KeyboardActions r27 = new androidx.compose.foundation.text.KeyboardActions
            r7 = r27
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 0
            r34 = 47
            r35 = 0
            r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35)
            r14 = r0
            androidx.compose.ui.graphics.Brush r14 = (androidx.compose.ui.graphics.Brush) r14
            androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5 r0 = new androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5
            r87 = r0
            r88 = r82
            r89 = r20
            r90 = r24
            r91 = r21
            r92 = r22
            r93 = r23
            r94 = r11
            r87.<init>(r88, r89, r90, r91, r92, r93, r94)
            r9 = -951844929(0xffffffffc743ffbf, float:-50175.746)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r9, r10, r0)
            r15 = r0
            kotlin.jvm.functions.Function3 r15 = (kotlin.jvm.functions.Function3) r15
            r0 = 102236160(0x6180000, float:2.8588023E-35)
            r0 = r0 | r1
            r1 = r4 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r4 >> 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r17 = r0 | r1
            int r0 = r8 << 6
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r18 = r0 | r46
            r19 = 7696(0x1e10, float:1.0784E-41)
            r4 = 0
            r8 = 1
            r9 = 0
            r10 = 0
            r0 = 0
            r27 = r11
            r11 = r0
            r28 = r12
            r12 = r0
            r29 = r16
            r0 = r82
            r1 = r83
            r3 = r20
            r5 = r25
            r6 = r26
            r13 = r24
            r16 = r28
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((java.lang.String) r0, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r1, (androidx.compose.ui.Modifier) r2, (boolean) r3, (boolean) r4, (androidx.compose.ui.text.TextStyle) r5, (androidx.compose.foundation.text.KeyboardOptions) r6, (androidx.compose.foundation.text.KeyboardActions) r7, (boolean) r8, (int) r9, (int) r10, (androidx.compose.ui.text.input.VisualTransformation) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r12, (androidx.compose.foundation.interaction.MutableInteractionSource) r13, (androidx.compose.ui.graphics.Brush) r14, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18, (int) r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04dc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04dc:
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r12 = r24
            r11 = r27
            r6 = r29
        L_0x04ea:
            androidx.compose.runtime.ScopeUpdateScope r15 = r28.endRestartGroup()
            if (r15 == 0) goto L_0x0512
            androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$6 r16 = new androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$6
            r0 = r16
            r1 = r82
            r2 = r83
            r3 = r84
            r4 = r85
            r5 = r86
            r13 = r95
            r14 = r96
            r81 = r15
            r15 = r97
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r81
            r1.updateScope(r0)
        L_0x0512:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.SearchBarInputField(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    static {
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        FiniteAnimationSpec<Float> tween = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tween;
        FiniteAnimationSpec<Float> tween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tween2;
        FiniteAnimationSpec<IntSize> tween3 = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tween3;
        FiniteAnimationSpec<IntSize> tween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tween, 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.expandVertically$default(tween3, (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tween2, 0.0f, 2, (Object) null).plus(EnterExitTransitionKt.shrinkVertically$default(tween4, (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null));
    }

    public static final float getDockedActiveTableMinHeight() {
        return DockedActiveTableMinHeight;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }

    private static final boolean SearchBar_WuY5d9Q$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
