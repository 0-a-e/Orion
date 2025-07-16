package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aÀ\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052&\u0010#\u001a\"\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052&\u0010'\u001a\"\u0012\u0013\u0012\u00110(¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00162\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a¶\u0001\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020-2'\u00102\u001a#\u0012\u0013\u0012\u001103¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(4\u0012\n\u0012\b\u0012\u0004\u0012\u000206050\u00032\u0006\u00107\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f2\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a!\u0010>\u001a\u00020\n2\b\b\u0002\u0010?\u001a\u00020-2\b\b\u0002\u0010@\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010A\u001a7\u0010B\u001a\u00020-2\b\b\u0002\u0010C\u001a\u0002062\u0014\b\u0002\u0010D\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010E\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010F\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "Lkotlin/ParameterName;", "name", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "", "sheetState", "Landroidx/compose/material3/SheetState;", "BottomSheetScaffoldLayout-PxNyym8", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "StandardBottomSheet", "state", "calculateAnchors", "Landroidx/compose/ui/unit/IntSize;", "sheetSize", "Landroidx/compose/material3/DraggableAnchors;", "Landroidx/compose/material3/SheetValue;", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-XcniZvE", "(Landroidx/compose/material3/SheetState;Lkotlin/jvm/functions/Function1;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
public final class BottomSheetScaffoldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v48, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v51, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v55, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v63, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x04c1  */
    /* JADX WARNING: Removed duplicated region for block: B:284:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012c  */
    /* renamed from: BottomSheetScaffold-sdMYb0k  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1536BottomSheetScaffoldsdMYb0k(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, androidx.compose.material3.BottomSheetScaffoldState r31, float r32, float r33, androidx.compose.ui.graphics.Shape r34, long r35, long r37, float r39, float r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, boolean r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, long r45, long r47, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.runtime.Composer r50, int r51, int r52, int r53) {
        /*
            r15 = r51
            r14 = r52
            r13 = r53
            r0 = -1523924135(0xffffffffa52ac359, float:-1.4811336E-16)
            r1 = r50
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BottomSheetScaffold)P(6,3,4,10:c#ui.unit.Dp,9:c#ui.unit.Dp,12,5:c#ui.graphics.Color,7:c#ui.graphics.Color,14:c#ui.unit.Dp,11:c#ui.unit.Dp,8,13,16,15,0:c#ui.graphics.Color,2:c#ui.graphics.Color)103@5431L34,106@5633L13,107@5701L14,108@5748L36,115@6205L11,116@6252L31,*119@6379L7,130@6700L50,122@6436L1811:BottomSheetScaffold.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001e
            r1 = r15 | 6
            r4 = r1
            r1 = r29
            goto L_0x0032
        L_0x001e:
            r1 = r15 & 6
            if (r1 != 0) goto L_0x002f
            r1 = r29
            boolean r4 = r0.changedInstance(r1)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r15
            goto L_0x0032
        L_0x002f:
            r1 = r29
            r4 = r15
        L_0x0032:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x0039
            r4 = r4 | 48
            goto L_0x004c
        L_0x0039:
            r8 = r15 & 48
            if (r8 != 0) goto L_0x004c
            r8 = r30
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0048
            r9 = 32
            goto L_0x004a
        L_0x0048:
            r9 = 16
        L_0x004a:
            r4 = r4 | r9
            goto L_0x004e
        L_0x004c:
            r8 = r30
        L_0x004e:
            r9 = r15 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0067
            r9 = r13 & 4
            if (r9 != 0) goto L_0x0061
            r9 = r31
            boolean r12 = r0.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x0063
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0061:
            r9 = r31
        L_0x0063:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r4 = r4 | r12
            goto L_0x0069
        L_0x0067:
            r9 = r31
        L_0x0069:
            r12 = r13 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0074
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0074:
            r2 = r15 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0088
            r2 = r32
            boolean r18 = r0.changed((float) r2)
            if (r18 == 0) goto L_0x0083
            r18 = r16
            goto L_0x0085
        L_0x0083:
            r18 = r17
        L_0x0085:
            r4 = r4 | r18
            goto L_0x008a
        L_0x0088:
            r2 = r32
        L_0x008a:
            r18 = r13 & 16
            r19 = 8192(0x2000, float:1.14794E-41)
            r20 = 16384(0x4000, float:2.2959E-41)
            if (r18 == 0) goto L_0x0095
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0095:
            r3 = r15 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x00a9
            r3 = r33
            boolean r22 = r0.changed((float) r3)
            if (r22 == 0) goto L_0x00a4
            r22 = r20
            goto L_0x00a6
        L_0x00a4:
            r22 = r19
        L_0x00a6:
            r4 = r4 | r22
            goto L_0x00ab
        L_0x00a9:
            r3 = r33
        L_0x00ab:
            r22 = 196608(0x30000, float:2.75506E-40)
            r22 = r15 & r22
            r23 = 65536(0x10000, float:9.18355E-41)
            if (r22 != 0) goto L_0x00c7
            r22 = r13 & 32
            r6 = r34
            if (r22 != 0) goto L_0x00c2
            boolean r24 = r0.changed((java.lang.Object) r6)
            if (r24 == 0) goto L_0x00c2
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c2:
            r24 = r23
        L_0x00c4:
            r4 = r4 | r24
            goto L_0x00c9
        L_0x00c7:
            r6 = r34
        L_0x00c9:
            r24 = 1572864(0x180000, float:2.204052E-39)
            r25 = r15 & r24
            if (r25 != 0) goto L_0x00e3
            r25 = r13 & 64
            r7 = r35
            if (r25 != 0) goto L_0x00de
            boolean r26 = r0.changed((long) r7)
            if (r26 == 0) goto L_0x00de
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00de:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r4 = r4 | r26
            goto L_0x00e5
        L_0x00e3:
            r7 = r35
        L_0x00e5:
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            r26 = r15 & r26
            if (r26 != 0) goto L_0x0101
            r11 = r13 & 128(0x80, float:1.794E-43)
            if (r11 != 0) goto L_0x00fa
            r10 = r37
            boolean r27 = r0.changed((long) r10)
            if (r27 == 0) goto L_0x00fc
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fe
        L_0x00fa:
            r10 = r37
        L_0x00fc:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fe:
            r4 = r4 | r27
            goto L_0x0103
        L_0x0101:
            r10 = r37
        L_0x0103:
            r1 = r13 & 256(0x100, float:3.59E-43)
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            if (r1 == 0) goto L_0x010e
            r4 = r4 | r27
            r2 = r39
            goto L_0x0121
        L_0x010e:
            r27 = r15 & r27
            r2 = r39
            if (r27 != 0) goto L_0x0121
            boolean r27 = r0.changed((float) r2)
            if (r27 == 0) goto L_0x011d
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011f
        L_0x011d:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011f:
            r4 = r4 | r27
        L_0x0121:
            r2 = r13 & 512(0x200, float:7.175E-43)
            r27 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x012c
            r4 = r4 | r27
            r3 = r40
            goto L_0x013f
        L_0x012c:
            r27 = r15 & r27
            r3 = r40
            if (r27 != 0) goto L_0x013f
            boolean r27 = r0.changed((float) r3)
            if (r27 == 0) goto L_0x013b
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013d
        L_0x013b:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013d:
            r4 = r4 | r27
        L_0x013f:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0148
            r21 = r14 | 6
            r6 = r41
            goto L_0x015e
        L_0x0148:
            r27 = r14 & 6
            r6 = r41
            if (r27 != 0) goto L_0x015c
            boolean r27 = r0.changedInstance(r6)
            if (r27 == 0) goto L_0x0157
            r21 = 4
            goto L_0x0159
        L_0x0157:
            r21 = 2
        L_0x0159:
            r21 = r14 | r21
            goto L_0x015e
        L_0x015c:
            r21 = r14
        L_0x015e:
            r6 = r13 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0167
            r21 = r21 | 48
            r7 = r42
            goto L_0x017a
        L_0x0167:
            r27 = r14 & 48
            r7 = r42
            if (r27 != 0) goto L_0x017a
            boolean r8 = r0.changed((boolean) r7)
            if (r8 == 0) goto L_0x0176
            r25 = 32
            goto L_0x0178
        L_0x0176:
            r25 = 16
        L_0x0178:
            r21 = r21 | r25
        L_0x017a:
            r8 = r21
            r7 = r13 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0183
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x0197
        L_0x0183:
            r9 = r14 & 384(0x180, float:5.38E-43)
            if (r9 != 0) goto L_0x0197
            r9 = r43
            boolean r21 = r0.changedInstance(r9)
            if (r21 == 0) goto L_0x0192
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x0194
        L_0x0192:
            r26 = 128(0x80, float:1.794E-43)
        L_0x0194:
            r8 = r8 | r26
            goto L_0x0199
        L_0x0197:
            r9 = r43
        L_0x0199:
            r9 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x01a0
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b2
        L_0x01a0:
            r10 = r14 & 3072(0xc00, float:4.305E-42)
            if (r10 != 0) goto L_0x01b2
            r10 = r44
            boolean r11 = r0.changedInstance(r10)
            if (r11 == 0) goto L_0x01ad
            goto L_0x01af
        L_0x01ad:
            r16 = r17
        L_0x01af:
            r8 = r8 | r16
            goto L_0x01b4
        L_0x01b2:
            r10 = r44
        L_0x01b4:
            r11 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x01cc
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 != 0) goto L_0x01c7
            r10 = r45
            boolean r16 = r0.changed((long) r10)
            if (r16 == 0) goto L_0x01c9
            r19 = r20
            goto L_0x01c9
        L_0x01c7:
            r10 = r45
        L_0x01c9:
            r8 = r8 | r19
            goto L_0x01ce
        L_0x01cc:
            r10 = r45
        L_0x01ce:
            r16 = 196608(0x30000, float:2.75506E-40)
            r16 = r14 & r16
            r17 = 32768(0x8000, float:4.5918E-41)
            if (r16 != 0) goto L_0x01eb
            r16 = r13 & r17
            r10 = r47
            if (r16 != 0) goto L_0x01e6
            boolean r16 = r0.changed((long) r10)
            if (r16 == 0) goto L_0x01e6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01e8
        L_0x01e6:
            r16 = r23
        L_0x01e8:
            r8 = r8 | r16
            goto L_0x01ed
        L_0x01eb:
            r10 = r47
        L_0x01ed:
            r16 = r13 & r23
            if (r16 == 0) goto L_0x01f6
            r8 = r8 | r24
            r14 = r49
            goto L_0x0209
        L_0x01f6:
            r16 = r14 & r24
            r14 = r49
            if (r16 != 0) goto L_0x0209
            boolean r16 = r0.changedInstance(r14)
            if (r16 == 0) goto L_0x0205
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0207
        L_0x0205:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x0207:
            r8 = r8 | r16
        L_0x0209:
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r10 = r4 & r16
            r11 = 306783378(0x12492492, float:6.3469493E-28)
            if (r10 != r11) goto L_0x0246
            r10 = 599187(0x92493, float:8.3964E-40)
            r10 = r10 & r8
            r11 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r11) goto L_0x0246
            boolean r10 = r0.getSkipping()
            if (r10 != 0) goto L_0x0223
            goto L_0x0246
        L_0x0223:
            r0.skipToGroupEnd()
            r2 = r30
            r3 = r31
            r4 = r32
            r5 = r33
            r6 = r34
            r7 = r35
            r9 = r37
            r11 = r39
            r12 = r40
            r13 = r41
            r14 = r42
            r15 = r43
            r16 = r44
            r17 = r45
            r19 = r47
            goto L_0x04bb
        L_0x0246:
            r0.startDefaults()
            r10 = r15 & 1
            if (r10 == 0) goto L_0x02a7
            boolean r10 = r0.getDefaultsInvalid()
            if (r10 == 0) goto L_0x0254
            goto L_0x02a7
        L_0x0254:
            r0.skipToGroupEnd()
            r1 = r13 & 4
            if (r1 == 0) goto L_0x025d
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x025d:
            r1 = r13 & 32
            if (r1 == 0) goto L_0x0265
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r1
        L_0x0265:
            r1 = r13 & 64
            if (r1 == 0) goto L_0x026d
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r1
        L_0x026d:
            r1 = r13 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0275
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r4 = r4 & r1
        L_0x0275:
            r1 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x027d
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r8 & r1
        L_0x027d:
            r1 = r13 & r17
            if (r1 == 0) goto L_0x0285
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r8 = r8 & r1
        L_0x0285:
            r1 = r30
            r2 = r31
            r3 = r32
            r12 = r33
            r5 = r35
            r20 = r37
            r7 = r39
            r9 = r41
            r10 = r42
            r18 = r43
            r11 = r44
            r22 = r45
            r24 = r47
            r13 = r4
            r14 = r8
            r4 = r34
            r8 = r40
            goto L_0x03ae
        L_0x02a7:
            if (r5 == 0) goto L_0x02ae
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x02b0
        L_0x02ae:
            r5 = r30
        L_0x02b0:
            r10 = r13 & 4
            r11 = 0
            if (r10 == 0) goto L_0x02c0
            r10 = 0
            r30 = r5
            r5 = 3
            androidx.compose.material3.BottomSheetScaffoldState r5 = rememberBottomSheetScaffoldState(r11, r11, r0, r10, r5)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x02c4
        L_0x02c0:
            r30 = r5
            r5 = r31
        L_0x02c4:
            if (r12 == 0) goto L_0x02cd
            androidx.compose.material3.BottomSheetDefaults r10 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r10 = r10.m1535getSheetPeekHeightD9Ej5fM()
            goto L_0x02cf
        L_0x02cd:
            r10 = r32
        L_0x02cf:
            if (r18 == 0) goto L_0x02d8
            androidx.compose.material3.BottomSheetDefaults r12 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r12 = r12.m1534getSheetMaxWidthD9Ej5fM()
            goto L_0x02da
        L_0x02d8:
            r12 = r33
        L_0x02da:
            r18 = r13 & 32
            if (r18 == 0) goto L_0x02ed
            androidx.compose.material3.BottomSheetDefaults r11 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            r31 = r5
            r5 = 6
            androidx.compose.ui.graphics.Shape r11 = r11.getExpandedShape(r0, r5)
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r16
            goto L_0x02f2
        L_0x02ed:
            r31 = r5
            r5 = 6
            r11 = r34
        L_0x02f2:
            r16 = r13 & 64
            r32 = r10
            if (r16 == 0) goto L_0x0306
            androidx.compose.material3.BottomSheetDefaults r10 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            long r20 = r10.getContainerColor(r0, r5)
            r5 = -3670017(0xffffffffffc7ffff, float:NaN)
            r4 = r4 & r5
            r10 = r4
            r4 = r20
            goto L_0x0309
        L_0x0306:
            r10 = r4
            r4 = r35
        L_0x0309:
            r33 = r11
            r11 = r13 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x031c
            int r11 = r10 >> 18
            r11 = r11 & 14
            long r20 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r4, r0, r11)
            r11 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r10 = r10 & r11
            goto L_0x031e
        L_0x031c:
            r20 = r37
        L_0x031e:
            if (r1 == 0) goto L_0x0327
            androidx.compose.material3.BottomSheetDefaults r1 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r1 = r1.m1533getElevationD9Ej5fM()
            goto L_0x0329
        L_0x0327:
            r1 = r39
        L_0x0329:
            if (r2 == 0) goto L_0x0332
            androidx.compose.material3.BottomSheetDefaults r2 = androidx.compose.material3.BottomSheetDefaults.INSTANCE
            float r2 = r2.m1533getElevationD9Ej5fM()
            goto L_0x0334
        L_0x0332:
            r2 = r40
        L_0x0334:
            if (r3 == 0) goto L_0x033d
            androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt r3 = androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1703getLambda1$material3_release()
            goto L_0x033f
        L_0x033d:
            r3 = r41
        L_0x033f:
            if (r6 == 0) goto L_0x0343
            r6 = 1
            goto L_0x0345
        L_0x0343:
            r6 = r42
        L_0x0345:
            if (r7 == 0) goto L_0x034a
            r18 = 0
            goto L_0x034c
        L_0x034a:
            r18 = r43
        L_0x034c:
            if (r9 == 0) goto L_0x0355
            androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt r7 = androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r7 = r7.m1704getLambda2$material3_release()
            goto L_0x0357
        L_0x0355:
            r7 = r44
        L_0x0357:
            r9 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x036e
            androidx.compose.material3.MaterialTheme r9 = androidx.compose.material3.MaterialTheme.INSTANCE
            r11 = 6
            androidx.compose.material3.ColorScheme r9 = r9.getColorScheme(r0, r11)
            long r22 = r9.m1667getSurface0d7_KjU()
            r9 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r8 & r9
            r11 = r8
            r8 = r22
            goto L_0x0371
        L_0x036e:
            r11 = r8
            r8 = r45
        L_0x0371:
            r17 = r13 & r17
            if (r17 == 0) goto L_0x0397
            int r17 = r11 >> 12
            r34 = r1
            r1 = r17 & 14
            long r22 = androidx.compose.material3.ColorSchemeKt.m1681contentColorForek8zF_U(r8, r0, r1)
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r11
            r14 = r1
            r11 = r7
            r13 = r10
            r24 = r22
            r1 = r30
            r7 = r34
            r10 = r6
            r22 = r8
            r8 = r2
            r9 = r3
            r5 = r4
            r2 = r31
            r3 = r32
            goto L_0x03ac
        L_0x0397:
            r34 = r1
            r1 = r30
            r24 = r47
            r22 = r8
            r13 = r10
            r14 = r11
            r8 = r2
            r9 = r3
            r10 = r6
            r11 = r7
            r2 = r31
            r3 = r32
            r7 = r34
            r5 = r4
        L_0x03ac:
            r4 = r33
        L_0x03ae:
            r0.endDefaults()
            boolean r17 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r17 == 0) goto L_0x03c2
            r15 = -1523924135(0xffffffffa52ac359, float:-1.4811336E-16)
            r45 = r1
            java.lang.String r1 = "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:118)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r13, r14, r1)
            goto L_0x03c4
        L_0x03c2:
            r45 = r1
        L_0x03c4:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            r17 = r14
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r14)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            int r1 = r1.m6545roundToPx0680j_4(r3)
            androidx.compose.material3.SheetState r14 = r2.getBottomSheetState()
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1 r15 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
            r30 = r15
            r31 = r2
            r32 = r1
            r33 = r3
            r34 = r12
            r35 = r10
            r36 = r4
            r37 = r5
            r39 = r20
            r41 = r7
            r42 = r8
            r43 = r9
            r44 = r29
            r30.<init>(r31, r32, r33, r34, r35, r36, r37, r39, r41, r42, r43, r44)
            r1 = -680109608(0xffffffffd77659d8, float:-2.70865736E14)
            r44 = r4
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r4, r15)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2 r15 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
            r15.<init>(r11, r2)
            r46 = r5
            r5 = 88659390(0x548d5be, float:9.443213E-36)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r5, r4, r15)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = -1567544379(0xffffffffa2912bc5, float:-3.934867E-18)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):BottomSheetScaffold.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            r6 = r13 & 896(0x380, float:1.256E-42)
            r6 = r6 ^ 384(0x180, float:5.38E-43)
            r15 = 256(0x100, float:3.59E-43)
            if (r6 <= r15) goto L_0x0439
            boolean r6 = r0.changed((java.lang.Object) r2)
            if (r6 != 0) goto L_0x043f
        L_0x0439:
            r6 = r13 & 384(0x180, float:5.38E-43)
            if (r6 != r15) goto L_0x043e
            goto L_0x043f
        L_0x043e:
            r4 = 0
        L_0x043f:
            java.lang.Object r6 = r0.rememberedValue()
            if (r4 != 0) goto L_0x044d
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x0458
        L_0x044d:
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1 r4 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
            r4.<init>(r2)
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r0.updateRememberedValue(r6)
        L_0x0458:
            r4 = r6
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r0.endReplaceableGroup()
            int r6 = r13 >> 3
            r6 = r6 & 14
            r6 = r6 | 27648(0x6c00, float:3.8743E-41)
            int r15 = r17 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r6 = r6 | r15
            int r15 = r17 >> 12
            r15 = r15 & 896(0x380, float:1.256E-42)
            r6 = r6 | r15
            r15 = 458752(0x70000, float:6.42848E-40)
            r16 = 6
            int r13 = r13 << 6
            r13 = r13 & r15
            r6 = r6 | r13
            int r13 = r17 << 12
            r15 = 234881024(0xe000000, float:1.5777218E-30)
            r15 = r15 & r13
            r6 = r6 | r15
            r15 = 1879048192(0x70000000, float:1.58456325E29)
            r13 = r13 & r15
            r6 = r6 | r13
            r30 = r45
            r31 = r18
            r32 = r49
            r33 = r1
            r34 = r5
            r35 = r3
            r36 = r4
            r37 = r14
            r38 = r22
            r40 = r24
            r42 = r0
            r43 = r6
            m1537BottomSheetScaffoldLayoutPxNyym8(r30, r31, r32, r33, r34, r35, r36, r37, r38, r40, r42, r43)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x04a4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04a4:
            r6 = r44
            r4 = r3
            r13 = r9
            r14 = r10
            r16 = r11
            r5 = r12
            r15 = r18
            r9 = r20
            r17 = r22
            r19 = r24
            r3 = r2
            r11 = r7
            r12 = r8
            r2 = r45
            r7 = r46
        L_0x04bb:
            androidx.compose.runtime.ScopeUpdateScope r1 = r0.endRestartGroup()
            if (r1 == 0) goto L_0x04dd
            androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$4 r25 = new androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$4
            r0 = r25
            r28 = r1
            r1 = r29
            r21 = r49
            r22 = r51
            r23 = r52
            r24 = r53
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17, r19, r21, r22, r23, r24)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r28
            r1.updateScope(r0)
        L_0x04dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt.m1536BottomSheetScaffoldsdMYb0k(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material3.BottomSheetScaffoldState, float, float, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState sheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1474606134);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetScaffoldState)189@9008L34,190@9087L32,192@9161L196:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            sheetState = rememberStandardBottomSheetState((SheetValue) null, (Function1<? super SheetValue, Boolean>) null, false, composer, 0, 7);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(667326536);
            ComposerKt.sourceInformation(composer, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            snackbarHostState = (SnackbarHostState) rememberedValue;
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, i, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:191)");
        }
        composer.startReplaceableGroup(667326610);
        ComposerKt.sourceInformation(composer, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean z = false;
        boolean z2 = (((i & 14) ^ 6) > 4 && composer.changed((Object) sheetState)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) > 32 && composer.changed((Object) snackbarHostState)) || (i & 48) == 32) {
            z = true;
        }
        boolean z3 = z2 | z;
        Object rememberedValue2 = composer.rememberedValue();
        if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new BottomSheetScaffoldState(sheetState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) rememberedValue2;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue sheetValue, Function1<? super SheetValue, Boolean> function1, boolean z, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(678511581);
        ComposerKt.sourceInformation(composer, "C(rememberStandardBottomSheetState)P(1)214@9987L76:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            sheetValue = SheetValue.PartiallyExpanded;
        }
        SheetValue sheetValue2 = sheetValue;
        if ((i2 & 2) != 0) {
            function1 = BottomSheetScaffoldKt$rememberStandardBottomSheetState$1.INSTANCE;
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if ((i2 & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, i, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:214)");
        }
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(false, function12, sheetValue2, z2, composer, (i & 112) | 6 | ((i << 6) & 896) | ((i << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberSheetState;
    }

    /* access modifiers changed from: private */
    /* renamed from: StandardBottomSheet-XcniZvE  reason: not valid java name */
    public static final void m1538StandardBottomSheetXcniZvE(SheetState sheetState, Function1<? super IntSize, ? extends DraggableAnchors<SheetValue>> function1, float f, float f2, boolean z, Shape shape, long j, long j2, float f3, float f4, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        int i3;
        int i4;
        SheetState sheetState2 = sheetState;
        Function1<? super IntSize, ? extends DraggableAnchors<SheetValue>> function12 = function1;
        float f5 = f;
        float f6 = f2;
        int i5 = i;
        Composer startRestartGroup = composer.startRestartGroup(424459667);
        ComposerKt.sourceInformation(startRestartGroup, "C(StandardBottomSheet)P(10!1,5:c#ui.unit.Dp,8:c#ui.unit.Dp,9,7,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,6:c#ui.unit.Dp,4)232@10554L24,242@10826L326,255@11381L491,236@10628L3850:BottomSheetScaffold.kt#uh7d8r");
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) sheetState2) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        int i6 = 16;
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changed(f5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i3 |= startRestartGroup.changed(f6) ? 2048 : 1024;
        }
        boolean z2 = z;
        if ((i5 & CpioConstants.C_ISBLK) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 16384 : 8192;
        }
        Shape shape2 = shape;
        if ((196608 & i5) == 0) {
            i3 |= startRestartGroup.changed((Object) shape2) ? 131072 : 65536;
        }
        long j3 = j;
        if ((1572864 & i5) == 0) {
            i3 |= startRestartGroup.changed(j3) ? 1048576 : 524288;
        }
        long j4 = j2;
        if ((i5 & 12582912) == 0) {
            i3 |= startRestartGroup.changed(j4) ? 8388608 : 4194304;
        }
        float f7 = f3;
        if ((i5 & 100663296) == 0) {
            i3 |= startRestartGroup.changed(f7) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        float f8 = f4;
        if ((i5 & 805306368) == 0) {
            i3 |= startRestartGroup.changed(f8) ? 536870912 : 268435456;
        }
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(function22) ? 4 : 2);
        } else {
            i4 = i2;
        }
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(function32)) {
                i6 = 32;
            }
            i4 |= i6;
        }
        int i7 = i4;
        if ((i3 & 306783379) == 306783378 && (i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(424459667, i3, i7, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:231)");
            }
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            Orientation orientation = Orientation.Vertical;
            Modifier r2 = SizeKt.m733requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m749widthInVpY3zN4$default(Modifier.Companion, 0.0f, f6, 1, (Object) null), 0.0f, 1, (Object) null), f5, 0.0f, 2, (Object) null);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3_release = sheetState.getAnchoredDraggableState$material3_release();
            startRestartGroup.startReplaceableGroup(1603483798);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) anchoredDraggableState$material3_release);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState2, orientation, new BottomSheetScaffoldKt$StandardBottomSheet$1$1(coroutineScope, sheetState2));
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(NestedScrollModifierKt.nestedScroll$default(r2, (NestedScrollConnection) rememberedValue2, (NestedScrollDispatcher) null, 2, (Object) null), sheetState.getAnchoredDraggableState$material3_release(), orientation, z, false, (MutableInteractionSource) null, 24, (Object) null);
            startRestartGroup.startReplaceableGroup(1603484353);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z3 = false;
            boolean z4 = (i3 & 112) == 32;
            if ((i3 & 14) == 4) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new BottomSheetScaffoldKt$StandardBottomSheet$2$1(function12, sheetState2);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            int i8 = i3 >> 12;
            SurfaceKt.m2303SurfaceT9BRK9s(OnRemeasuredModifierKt.onSizeChanged(anchoredDraggable$default, (Function1) rememberedValue3), shape, j, j2, f3, f4, (BorderStroke) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1070542936, true, new BottomSheetScaffoldKt$StandardBottomSheet$3(function2, sheetState, z, coroutineScope, function3)), startRestartGroup, (i8 & 112) | 12582912 | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (i8 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomSheetScaffoldKt$StandardBottomSheet$4(sheetState, function1, f, f2, z, shape, j, j2, f3, f4, function2, function3, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-PxNyym8  reason: not valid java name */
    public static final void m1537BottomSheetScaffoldLayoutPxNyym8(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function22, float f, Function0<Float> function0, SheetState sheetState, long j, long j2, Composer composer, int i) {
        int i2;
        SheetState sheetState2 = sheetState;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1120561936);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffoldLayout)P(4,9!2,8,6:c#ui.unit.Dp,5,7,2:c#ui.graphics.Color,3:c#ui.graphics.Color)334@15050L7,335@15073L44,335@15062L55,338@15139L1965,338@15122L1982:BottomSheetScaffold.kt#uh7d8r");
        Modifier modifier2 = modifier;
        if ((i3 & 6) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        if ((i3 & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 32 : 16;
        }
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33 = function3;
        if ((i3 & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function33) ? 256 : 128;
        }
        Function3<? super Integer, ? super Composer, ? super Integer, Unit> function34 = function32;
        if ((i3 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function34) ? 2048 : 1024;
        }
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        if ((i3 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i2 |= startRestartGroup.changed(f) ? 131072 : 65536;
        } else {
            float f2 = f;
        }
        Function0<Float> function02 = function0;
        if ((i3 & 1572864) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i2 |= startRestartGroup.changed((Object) sheetState2) ? 8388608 : 4194304;
        }
        long j3 = j;
        if ((i3 & 100663296) == 0) {
            i2 |= startRestartGroup.changed(j3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        long j4 = j2;
        if ((i3 & 805306368) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1120561936, i2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:332)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            startRestartGroup.startReplaceableGroup(-99158096);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            int i4 = 29360128 & i2;
            boolean changed = (i4 == 8388608) | startRestartGroup.changed((Object) density);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(sheetState2, density);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-99158030);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z = ((i2 & 7168) == 2048) | ((i2 & 112) == 32) | ((i2 & 14) == 4) | ((234881024 & i2) == 67108864) | ((1879048192 & i2) == 536870912) | ((i2 & 896) == 256) | ((458752 & i2) == 131072) | ((57344 & i2) == 16384) | ((i2 & 3670016) == 1048576) | (i4 == 8388608);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1(function2, function22, function32, modifier, j, j2, function3, f, function0, sheetState);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, (Function2) rememberedValue2, startRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$3(modifier, function2, function3, function32, function22, f, function0, sheetState, j, j2, i));
        }
    }
}
