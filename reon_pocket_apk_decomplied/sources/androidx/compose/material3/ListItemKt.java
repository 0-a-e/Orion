package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a©\u0001\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0015\b\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001at\u0010'\u001a\u00020\u00172\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001a2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0013\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001aH\u0003¢\u0006\u0002\u0010-\u001a5\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a`\u00106\u001a\u000207*\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010:2\b\u0010>\u001a\u0004\u0018\u00010:2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a`\u0010G\u001a\u000207*\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010:2\b\u0010>\u001a\u0004\u0018\u00010:2\u0006\u0010H\u001a\u00020I2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001af\u0010L\u001a\u00020M*\u0002082\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010:2\b\u0010>\u001a\u0004\u0018\u00010:2\u0006\u0010P\u001a\u00020Q2\u0006\u0010H\u001a\u00020I2\u0006\u0010A\u001a\u00020BH\u0002\"\u001e\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001e\u0010\u0007\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u001e\u0010\n\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005\"\u001e\u0010\r\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0005\"\u001e\u0010\u0010\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0005\"\u001e\u0010\u0013\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006R"}, d2 = {"LeadingContentEndPadding", "Landroidx/compose/ui/unit/Dp;", "getLeadingContentEndPadding$annotations", "()V", "getLeadingContentEndPadding", "()F", "F", "ListItemEndPadding", "getListItemEndPadding$annotations", "getListItemEndPadding", "ListItemStartPadding", "getListItemStartPadding$annotations", "getListItemStartPadding", "ListItemThreeLineVerticalPadding", "getListItemThreeLineVerticalPadding$annotations", "getListItemThreeLineVerticalPadding", "ListItemVerticalPadding", "getListItemVerticalPadding$annotations", "getListItemVerticalPadding", "TrailingContentStartPadding", "getTrailingContentStartPadding$annotations", "getTrailingContentStartPadding", "ListItem", "", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "ListItemLayout", "leading", "trailing", "headline", "overline", "supporting", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ProvideTextStyleFromToken", "color", "Landroidx/compose/ui/graphics/Color;", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "content", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "", "Landroidx/compose/ui/layout/MeasureScope;", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "headlinePlaceable", "overlinePlaceable", "supportingPlaceable", "listItemType", "Landroidx/compose/material3/ListItemType;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "calculateHeight-N4Jib3Y", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;ILandroidx/compose/foundation/layout/PaddingValues;J)I", "calculateWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateWidth-xygx4p4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/layout/PaddingValues;J)I", "place", "Landroidx/compose/ui/layout/MeasureResult;", "width", "height", "isThreeLine", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
public final class ListItemKt {
    private static final float LeadingContentEndPadding;
    private static final float ListItemEndPadding;
    private static final float ListItemStartPadding;
    private static final float ListItemThreeLineVerticalPadding = Dp.m6614constructorimpl((float) 12);
    private static final float ListItemVerticalPadding = Dp.m6614constructorimpl((float) 8);
    private static final float TrailingContentStartPadding;

    public static /* synthetic */ void getLeadingContentEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemStartPadding$annotations() {
    }

    public static /* synthetic */ void getListItemThreeLineVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getListItemVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getTrailingContentStartPadding$annotations() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0100  */
    /* renamed from: ListItem-HXNGIdc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1944ListItemHXNGIdc(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.material3.ListItemColors r44, float r45, float r46, androidx.compose.runtime.Composer r47, int r48, int r49) {
        /*
            r1 = r38
            r10 = r48
            r11 = r49
            r0 = -1647707763(0xffffffff9dc9f98d, float:-5.3462286E-21)
            r2 = r47
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            java.lang.String r3 = "C(ListItem)P(1,3,4,6,2,8!1,7:c#ui.unit.Dp,5:c#ui.unit.Dp)89@4308L8,144@6169L5,140@6019L637:ListItem.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r11 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r10 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r10 & 6
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changedInstance(r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r10
            goto L_0x002b
        L_0x002a:
            r3 = r10
        L_0x002b:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x0045
            r5 = r39
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r39
        L_0x0047:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0061
            r7 = r40
            boolean r8 = r2.changedInstance(r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r40
        L_0x0063:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x006a
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r9 = r10 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x007d
            r9 = r41
            boolean r12 = r2.changedInstance(r9)
            if (r12 == 0) goto L_0x0079
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r3 = r3 | r12
            goto L_0x007f
        L_0x007d:
            r9 = r41
        L_0x007f:
            r12 = r11 & 16
            if (r12 == 0) goto L_0x0086
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r13 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r13 != 0) goto L_0x0099
            r13 = r42
            boolean r14 = r2.changedInstance(r13)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r3 = r3 | r14
            goto L_0x009b
        L_0x0099:
            r13 = r42
        L_0x009b:
            r14 = r11 & 32
            r15 = 196608(0x30000, float:2.75506E-40)
            if (r14 == 0) goto L_0x00a3
            r3 = r3 | r15
            goto L_0x00b6
        L_0x00a3:
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00b6
            r15 = r43
            boolean r16 = r2.changedInstance(r15)
            if (r16 == 0) goto L_0x00b1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00b1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r3 = r3 | r16
            goto L_0x00b8
        L_0x00b6:
            r15 = r43
        L_0x00b8:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00d2
            r16 = r11 & 64
            r0 = r44
            if (r16 != 0) goto L_0x00cd
            boolean r16 = r2.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x00cd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00cd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00cf:
            r3 = r3 | r16
            goto L_0x00d4
        L_0x00d2:
            r0 = r44
        L_0x00d4:
            r15 = r11 & 128(0x80, float:1.794E-43)
            r34 = 12582912(0xc00000, float:1.7632415E-38)
            if (r15 == 0) goto L_0x00dd
            r3 = r3 | r34
            goto L_0x00f3
        L_0x00dd:
            r16 = r10 & r34
            if (r16 != 0) goto L_0x00f3
            r16 = r15
            r15 = r45
            boolean r17 = r2.changed((float) r15)
            if (r17 == 0) goto L_0x00ee
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f0
        L_0x00ee:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f0:
            r3 = r3 | r17
            goto L_0x00f7
        L_0x00f3:
            r16 = r15
            r15 = r45
        L_0x00f7:
            r15 = r11 & 256(0x100, float:3.59E-43)
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            if (r15 == 0) goto L_0x0100
            r3 = r3 | r17
            goto L_0x0116
        L_0x0100:
            r17 = r10 & r17
            if (r17 != 0) goto L_0x0116
            r17 = r15
            r15 = r46
            boolean r18 = r2.changed((float) r15)
            if (r18 == 0) goto L_0x0111
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0111:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0113:
            r3 = r3 | r18
            goto L_0x011a
        L_0x0116:
            r17 = r15
            r15 = r46
        L_0x011a:
            r18 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r3 & r18
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r5) goto L_0x013a
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x012b
            goto L_0x013a
        L_0x012b:
            r2.skipToGroupEnd()
            r3 = r39
            r6 = r43
            r8 = r44
            r4 = r9
            r5 = r13
            r9 = r45
            goto L_0x02b6
        L_0x013a:
            r2.startDefaults()
            r0 = r10 & 1
            r5 = -3670017(0xffffffffffc7ffff, float:NaN)
            r35 = 0
            if (r0 == 0) goto L_0x0162
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x014d
            goto L_0x0162
        L_0x014d:
            r2.skipToGroupEnd()
            r0 = r11 & 64
            if (r0 == 0) goto L_0x0155
            r3 = r3 & r5
        L_0x0155:
            r0 = r39
            r6 = r43
            r5 = r45
            r12 = r3
            r4 = r13
            r8 = r15
            r3 = r44
            goto L_0x01cb
        L_0x0162:
            if (r4 == 0) goto L_0x0169
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x016b
        L_0x0169:
            r0 = r39
        L_0x016b:
            if (r6 == 0) goto L_0x016f
            r7 = r35
        L_0x016f:
            if (r8 == 0) goto L_0x0173
            r9 = r35
        L_0x0173:
            if (r12 == 0) goto L_0x0178
            r4 = r35
            goto L_0x0179
        L_0x0178:
            r4 = r13
        L_0x0179:
            if (r14 == 0) goto L_0x017e
            r6 = r35
            goto L_0x0180
        L_0x017e:
            r6 = r43
        L_0x0180:
            r8 = r11 & 64
            if (r8 == 0) goto L_0x01aa
            androidx.compose.material3.ListItemDefaults r12 = androidx.compose.material3.ListItemDefaults.INSTANCE
            r32 = 805306368(0x30000000, float:4.656613E-10)
            r33 = 511(0x1ff, float:7.16E-43)
            r13 = 0
            r18 = 0
            r8 = r16
            r36 = r17
            r15 = r18
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = r2
            androidx.compose.material3.ListItemColors r12 = r12.m1942colorsJ08w3E(r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r32, r33)
            r3 = r3 & r5
            goto L_0x01b0
        L_0x01aa:
            r8 = r16
            r36 = r17
            r12 = r44
        L_0x01b0:
            if (r8 == 0) goto L_0x01b9
            androidx.compose.material3.ListItemDefaults r5 = androidx.compose.material3.ListItemDefaults.INSTANCE
            float r5 = r5.m1943getElevationD9Ej5fM()
            goto L_0x01bb
        L_0x01b9:
            r5 = r45
        L_0x01bb:
            if (r36 == 0) goto L_0x01c4
            androidx.compose.material3.ListItemDefaults r8 = androidx.compose.material3.ListItemDefaults.INSTANCE
            float r8 = r8.m1943getElevationD9Ej5fM()
            goto L_0x01c6
        L_0x01c4:
            r8 = r46
        L_0x01c6:
            r37 = r12
            r12 = r3
            r3 = r37
        L_0x01cb:
            r2.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01dd
            r13 = -1
            java.lang.String r14 = "androidx.compose.material3.ListItem (ListItem.kt:92)"
            r15 = -1647707763(0xffffffff9dc9f98d, float:-5.3462286E-21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r12, r13, r14)
        L_0x01dd:
            androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1 r13 = new androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
            r13.<init>(r3, r1)
            r14 = -403249643(0xffffffffe7f6e615, float:-2.3318928E24)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r13 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r14, r15, r13)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            if (r9 == 0) goto L_0x01fd
            androidx.compose.material3.ListItemKt$ListItem$decoratedSupportingContent$1$1 r14 = new androidx.compose.material3.ListItemKt$ListItem$decoratedSupportingContent$1$1
            r14.<init>(r3, r9)
            r1 = -1020860251(0xffffffffc326e8a5, float:-166.90877)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r1, r15, r14)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            goto L_0x01ff
        L_0x01fd:
            r1 = r35
        L_0x01ff:
            if (r7 == 0) goto L_0x0212
            androidx.compose.material3.ListItemKt$ListItem$decoratedOverlineContent$1$1 r14 = new androidx.compose.material3.ListItemKt$ListItem$decoratedOverlineContent$1$1
            r14.<init>(r3, r7)
            r45 = r7
            r7 = -764441232(0xffffffffd26f8d70, float:-2.57217528E11)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r7, r15, r14)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            goto L_0x0216
        L_0x0212:
            r45 = r7
            r7 = r35
        L_0x0216:
            if (r4 == 0) goto L_0x0229
            androidx.compose.material3.ListItemKt$ListItem$decoratedLeadingContent$1$1 r14 = new androidx.compose.material3.ListItemKt$ListItem$decoratedLeadingContent$1$1
            r14.<init>(r3, r4)
            r46 = r4
            r4 = 1400509200(0x537a1310, float:1.07406164E12)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r4, r15, r14)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            goto L_0x022d
        L_0x0229:
            r46 = r4
            r4 = r35
        L_0x022d:
            if (r6 == 0) goto L_0x0242
            androidx.compose.material3.ListItemKt$ListItem$decoratedTrailingContent$1$1 r14 = new androidx.compose.material3.ListItemKt$ListItem$decoratedTrailingContent$1$1
            r14.<init>(r3, r6)
            r47 = r6
            r6 = 1512306332(0x5a23f69c, float:1.15378928E16)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r6, r15, r14)
            r35 = r6
            kotlin.jvm.functions.Function2 r35 = (kotlin.jvm.functions.Function2) r35
            goto L_0x0244
        L_0x0242:
            r47 = r6
        L_0x0244:
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.material3.ListItemKt$ListItem$1 r14 = androidx.compose.material3.ListItemKt$ListItem$1.INSTANCE
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r6, r15, r14)
            androidx.compose.ui.Modifier r6 = r6.then(r0)
            androidx.compose.material3.ListItemDefaults r14 = androidx.compose.material3.ListItemDefaults.INSTANCE
            r15 = 6
            androidx.compose.ui.graphics.Shape r14 = r14.getShape(r2, r15)
            long r17 = r3.m1927containerColor0d7_KjU$material3_release()
            r15 = 1
            long r19 = r3.m1937headlineColorvNxB06k$material3_release(r15)
            androidx.compose.material3.ListItemKt$ListItem$2 r15 = new androidx.compose.material3.ListItemKt$ListItem$2
            r39 = r15
            r40 = r4
            r41 = r35
            r42 = r13
            r43 = r7
            r44 = r1
            r39.<init>(r40, r41, r42, r43, r44)
            r1 = 1502590376(0x598fb5a8, float:5.0563319E15)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r1, r4, r15)
            r21 = r1
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
            int r1 = r12 >> 9
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r1
            r4 = r4 | r34
            r7 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r7
            r23 = r4 | r1
            r24 = 64
            r1 = 0
            r12 = r6
            r13 = r14
            r14 = r17
            r16 = r19
            r18 = r5
            r19 = r8
            r20 = r1
            r22 = r2
            androidx.compose.material3.SurfaceKt.m2303SurfaceT9BRK9s(r12, r13, r14, r16, r18, r19, r20, r21, r22, r23, r24)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x02ab
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02ab:
            r7 = r45
            r6 = r47
            r15 = r8
            r4 = r9
            r8 = r3
            r9 = r5
            r5 = r46
            r3 = r0
        L_0x02b6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r2.endRestartGroup()
            if (r12 == 0) goto L_0x02d2
            androidx.compose.material3.ListItemKt$ListItem$3 r13 = new androidx.compose.material3.ListItemKt$ListItem$3
            r0 = r13
            r1 = r38
            r2 = r3
            r3 = r7
            r7 = r8
            r8 = r9
            r9 = r15
            r10 = r48
            r11 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x02d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ListItemKt.m1944ListItemHXNGIdc(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.ListItemColors, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ListItemLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2052297037);
        ComposerKt.sourceInformation(startRestartGroup, "C(ListItemLayout)P(1,4)168@6954L7,177@7152L3807,169@6966L3993:ListItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((i & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 16384 : 8192;
        }
        if ((i2 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052297037, i2, -1, "androidx.compose.material3.ListItemLayout (ListItem.kt:167)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume;
            Function2[] function2Arr = new Function2[5];
            function2Arr[0] = function23;
            function2Arr[1] = function24 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1710getLambda1$material3_release() : function24;
            function2Arr[2] = function25 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1711getLambda2$material3_release() : function25;
            function2Arr[3] = function2 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1712getLambda3$material3_release() : function2;
            function2Arr[4] = function22 == null ? ComposableSingletons$ListItemKt.INSTANCE.m1713getLambda4$material3_release() : function22;
            List listOf = CollectionsKt.listOf(function2Arr);
            startRestartGroup.startReplaceableGroup(1361340338);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ListItem.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) layoutDirection);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ListItemKt$ListItemLayout$1$1(layoutDirection);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1399185516);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
            Modifier modifier = Modifier.Companion;
            Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed((Object) multiContentMeasurePolicy);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer r6 = Updater.m3282constructorimpl(startRestartGroup);
            Updater.m3289setimpl(r6, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3289setimpl(r6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (r6.getInserting() || !Intrinsics.areEqual(r6.rememberedValue(), (Object) Integer.valueOf(currentCompositeKeyHash))) {
                r6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                r6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3273boximpl(SkippableUpdater.m3274constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            combineAsVirtualLayouts.invoke(startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$ListItemLayout$2(function2, function22, function23, function24, function25, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-xygx4p4  reason: not valid java name */
    public static final int m1950calculateWidthxygx4p4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, LayoutDirection layoutDirection, PaddingValues paddingValues, long j) {
        if (Constraints.m6522getHasBoundedWidthimpl(j)) {
            return Constraints.m6526getMaxWidthimpl(j);
        }
        int r1 = measureScope.m6545roundToPx0680j_4(Dp.m6614constructorimpl(paddingValues.m685calculateLeftPaddingu2uoSUM(layoutDirection) + paddingValues.m686calculateRightPaddingu2uoSUM(layoutDirection)));
        return r1 + TextFieldImplKt.widthOrZero(placeable) + Math.max(TextFieldImplKt.widthOrZero(placeable3), Math.max(TextFieldImplKt.widthOrZero(placeable4), TextFieldImplKt.widthOrZero(placeable5))) + TextFieldImplKt.widthOrZero(placeable2);
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-N4Jib3Y  reason: not valid java name */
    public static final int m1949calculateHeightN4Jib3Y(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, int i, PaddingValues paddingValues, long j) {
        float f;
        if (ListItemType.m1956equalsimpl0(i, ListItemType.Companion.m1962getOneLineAlXitO8())) {
            f = ListTokens.INSTANCE.m2956getListItemOneLineContainerHeightD9Ej5fM();
        } else if (ListItemType.m1956equalsimpl0(i, ListItemType.Companion.m1964getTwoLineAlXitO8())) {
            f = ListTokens.INSTANCE.m2960getListItemTwoLineContainerHeightD9Ej5fM();
        } else {
            f = ListTokens.INSTANCE.m2958getListItemThreeLineContainerHeightD9Ej5fM();
        }
        return RangesKt.coerceAtMost(Math.max(Math.max(Constraints.m6527getMinHeightimpl(j), measureScope.m6545roundToPx0680j_4(f)), measureScope.m6545roundToPx0680j_4(Dp.m6614constructorimpl(paddingValues.m687calculateTopPaddingD9Ej5fM() + paddingValues.m684calculateBottomPaddingD9Ej5fM())) + Math.max(TextFieldImplKt.heightOrZero(placeable), Math.max(TextFieldImplKt.heightOrZero(placeable3) + TextFieldImplKt.heightOrZero(placeable4) + TextFieldImplKt.heightOrZero(placeable5), TextFieldImplKt.heightOrZero(placeable2)))), Constraints.m6525getMaxHeightimpl(j));
    }

    /* access modifiers changed from: private */
    public static final MeasureResult place(MeasureScope measureScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        return MeasureScope.CC.layout$default(measureScope, i, i2, (Map) null, new ListItemKt$place$1(measureScope, paddingValues, layoutDirection, placeable, placeable2, z, placeable3, placeable4, placeable5, i2, i), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: ProvideTextStyleFromToken-3J-VO9M  reason: not valid java name */
    public static final void m1945ProvideTextStyleFromToken3JVO9M(long j, TypographyKeyTokens typographyKeyTokens, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1133967795);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyleFromToken)P(0:c#ui.graphics.Color,2)520@20833L10,518@20747L142:ListItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) typographyKeyTokens) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133967795, i2, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:518)");
            }
            ProvideContentColorTextStyleKt.m2082ProvideContentColorTextStyle3JVO9M(j, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), typographyKeyTokens), function2, startRestartGroup, i2 & 910);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$ProvideTextStyleFromToken$1(j, typographyKeyTokens, function2, i));
        }
    }

    public static final float getListItemVerticalPadding() {
        return ListItemVerticalPadding;
    }

    public static final float getListItemThreeLineVerticalPadding() {
        return ListItemThreeLineVerticalPadding;
    }

    public static final float getListItemStartPadding() {
        return ListItemStartPadding;
    }

    public static final float getListItemEndPadding() {
        return ListItemEndPadding;
    }

    public static final float getLeadingContentEndPadding() {
        return LeadingContentEndPadding;
    }

    public static final float getTrailingContentStartPadding() {
        return TrailingContentStartPadding;
    }

    static {
        float f = (float) 16;
        ListItemStartPadding = Dp.m6614constructorimpl(f);
        ListItemEndPadding = Dp.m6614constructorimpl(f);
        LeadingContentEndPadding = Dp.m6614constructorimpl(f);
        TrailingContentStartPadding = Dp.m6614constructorimpl(f);
    }
}
