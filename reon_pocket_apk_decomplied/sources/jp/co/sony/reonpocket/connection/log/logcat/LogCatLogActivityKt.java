package jp.co.sony.reonpocket.connection.log.logcat;

import android.content.Context;
import android.widget.Toast;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.DialogProperties;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u0001\u0010\u0005\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Content", "", "presenter", "Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLogPresenter;", "(Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLogPresenter;Landroidx/compose/runtime/Composer;I)V", "LogFileList", "logFiles", "", "Ljava/io/File;", "onClickLogFile", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "file", "onClickStartLogging", "Lkotlin/Function0;", "onClickStopLogging", "onClickDeleteAllFiles", "onLongClickLogFile", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_prodRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
public final class LogCatLogActivityKt {
    public static final void Content(LogCatLogPresenter logCatLogPresenter, Composer composer, int i) {
        Composer composer2;
        LogCatLogPresenter logCatLogPresenter2 = logCatLogPresenter;
        int i2 = i;
        Intrinsics.checkNotNullParameter(logCatLogPresenter2, "presenter");
        Composer startRestartGroup = composer.startRestartGroup(-2072135275);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2072135275, i2, -1, "jp.co.sony.reonpocket.connection.log.logcat.Content (LogCatLogActivity.kt:72)");
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Context context = (Context) consume;
        State<List<File>> collectAsState = SnapshotStateKt.collectAsState(logCatLogPresenter.getLogFiles(), (CoroutineContext) null, startRestartGroup, 8, 1);
        State<String> collectAsState2 = SnapshotStateKt.collectAsState(logCatLogPresenter.getToastMessage(), (CoroutineContext) null, startRestartGroup, 8, 1);
        State<ConfirmDeleteLogFileDialogInfo> collectAsState3 = SnapshotStateKt.collectAsState(logCatLogPresenter.getConfirmDeleteLogFile(), (CoroutineContext) null, startRestartGroup, 8, 1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LogFileList(collectAsState.getValue(), new LogCatLogActivityKt$Content$1(objectRef, ActivityResultRegistryKt.rememberLauncherForActivityResult(new ActivityResultContracts.CreateDocument("text/plain"), new LogCatLogActivityKt$Content$createLogFIleLauncher$1(objectRef, logCatLogPresenter2), startRestartGroup, 8)), new LogCatLogActivityKt$Content$2(logCatLogPresenter2), new LogCatLogActivityKt$Content$3(logCatLogPresenter2), new LogCatLogActivityKt$Content$4(logCatLogPresenter2), new LogCatLogActivityKt$Content$5(logCatLogPresenter2), startRestartGroup, 8);
        String value = collectAsState2.getValue();
        if (value != null) {
            Toast.makeText(context, value, 1).show();
            logCatLogPresenter.onShownToast();
        }
        ConfirmDeleteLogFileDialogInfo value2 = collectAsState3.getValue();
        if (value2 == null) {
            composer2 = startRestartGroup;
        } else {
            composer2 = startRestartGroup;
            AndroidAlertDialog_androidKt.m1504AlertDialogOix01E0(new LogCatLogActivityKt$Content$7$1(logCatLogPresenter2), ComposableLambdaKt.composableLambda(startRestartGroup, 2134973392, true, new LogCatLogActivityKt$Content$7$2(logCatLogPresenter2, value2)), (Modifier) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1414053970, true, new LogCatLogActivityKt$Content$7$3(logCatLogPresenter2)), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.composableLambda(startRestartGroup, 332674837, true, new LogCatLogActivityKt$Content$7$4(value2)), (Shape) null, 0, 0, 0, 0, 0.0f, (DialogProperties) null, composer2, 1772592, 0, 16276);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LogCatLogActivityKt$Content$8(logCatLogPresenter2, i2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v39, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LogFileList(java.util.List<? extends java.io.File> r35, kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> r36, kotlin.jvm.functions.Function0<kotlin.Unit> r37, kotlin.jvm.functions.Function0<kotlin.Unit> r38, kotlin.jvm.functions.Function0<kotlin.Unit> r39, kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            r5 = r39
            r6 = r40
            r7 = r42
            java.lang.String r0 = "logFiles"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "onClickLogFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onClickStartLogging"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onClickStopLogging"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "onClickDeleteAllFiles"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "onLongClickLogFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = -1649565772(0xffffffff9dad9fb4, float:-4.5957848E-21)
            r8 = r41
            androidx.compose.runtime.Composer r15 = r8.startRestartGroup(r0)
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0041
            r8 = -1
            java.lang.String r9 = "jp.co.sony.reonpocket.connection.log.logcat.LogFileList (LogCatLogActivity.kt:153)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r8, r9)
        L_0x0041:
            r0 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r8 = r8.getTop()
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r9 = r9.getStart()
            r14 = 0
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r8, r9, r15, r14)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r15.startReplaceableGroup(r9)
            java.lang.String r10 = "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r10)
            int r11 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r15, r14)
            androidx.compose.runtime.CompositionLocalMap r12 = r15.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r0)
            androidx.compose.runtime.Applier r9 = r15.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0089
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0089:
            r15.startReusableNode()
            boolean r9 = r15.getInserting()
            if (r9 == 0) goto L_0x0096
            r15.createNode(r13)
            goto L_0x0099
        L_0x0096:
            r15.useNode()
        L_0x0099:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m3282constructorimpl(r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r9, r8, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r9, r12, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetCompositeKeyHash()
            boolean r12 = r9.getInserting()
            if (r12 != 0) goto L_0x00c9
            java.lang.Object r12 = r9.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 != 0) goto L_0x00d7
        L_0x00c9:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r9.updateRememberedValue(r12)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r9.apply(r11, r8)
        L_0x00d7:
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r15)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r8)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r14)
            r0.invoke(r8, r15, r9)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r15.startReplaceableGroup(r0)
            r8 = 276693656(0x107e0298, float:5.0094666E-29)
            java.lang.String r9 = "C79@3979L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r8, r9)
            androidx.compose.foundation.layout.ColumnScopeInstance r8 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r8 = (androidx.compose.foundation.layout.ColumnScope) r8
            r8 = 693286680(0x2952b718, float:4.6788176E-14)
            r15.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r8)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r9 = r9.getStart()
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r11 = r11.getTop()
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r9, r11, r15, r14)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r15.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r10)
            int r10 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r15, r14)
            androidx.compose.runtime.CompositionLocalMap r11 = r15.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.modifierMaterializerOf(r8)
            androidx.compose.runtime.Applier r13 = r15.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x013d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x013d:
            r15.startReusableNode()
            boolean r13 = r15.getInserting()
            if (r13 == 0) goto L_0x014a
            r15.createNode(r12)
            goto L_0x014d
        L_0x014a:
            r15.useNode()
        L_0x014d:
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m3282constructorimpl(r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r9, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m3289setimpl((androidx.compose.runtime.Composer) r12, r11, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetCompositeKeyHash()
            boolean r11 = r12.getInserting()
            if (r11 != 0) goto L_0x017d
            java.lang.Object r11 = r12.rememberedValue()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r13)
            if (r11 != 0) goto L_0x018b
        L_0x017d:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r12.updateRememberedValue(r11)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r12.apply(r10, r9)
        L_0x018b:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m3274constructorimpl(r15)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m3273boximpl(r9)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r14)
            r8.invoke(r9, r15, r10)
            r15.startReplaceableGroup(r0)
            r0 = -326681643(0xffffffffec873bd5, float:-1.3079003E27)
            java.lang.String r8 = "C92@4661L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r0, r8)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r0 = (androidx.compose.foundation.layout.RowScope) r0
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            r9 = r8
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r12 = 2
            r13 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r8 = r0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r8, r9, r10, r11, r12, r13)
            r8 = 1338436741(0x4fc6ec85, float:6.6747786E9)
            r15.startReplaceableGroup(r8)
            r8 = r7 & 896(0x380, float:1.256E-42)
            r8 = r8 ^ 384(0x180, float:5.38E-43)
            r10 = 256(0x100, float:3.59E-43)
            r13 = 1
            if (r8 <= r10) goto L_0x01cd
            boolean r8 = r15.changed((java.lang.Object) r3)
            if (r8 != 0) goto L_0x01d1
        L_0x01cd:
            r8 = r7 & 384(0x180, float:5.38E-43)
            if (r8 != r10) goto L_0x01d3
        L_0x01d1:
            r8 = r13
            goto L_0x01d4
        L_0x01d3:
            r8 = r14
        L_0x01d4:
            java.lang.Object r10 = r15.rememberedValue()
            if (r8 != 0) goto L_0x01e2
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r10 != r8) goto L_0x01ed
        L_0x01e2:
            jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$1$1$1$1 r8 = new jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$1$1$1$1
            r8.<init>(r3)
            r10 = r8
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r15.updateRememberedValue(r10)
        L_0x01ed:
            r8 = r10
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r15.endReplaceableGroup()
            jp.co.sony.reonpocket.connection.log.logcat.ComposableSingletons$LogCatLogActivityKt r10 = jp.co.sony.reonpocket.connection.log.logcat.ComposableSingletons$LogCatLogActivityKt.INSTANCE
            kotlin.jvm.functions.Function3 r17 = r10.m6985getLambda3$app_prodRelease()
            r19 = 805306368(0x30000000, float:4.656613E-10)
            r20 = 508(0x1fc, float:7.12E-43)
            r10 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r18 = 0
            r21 = 0
            r22 = 0
            r13 = r16
            r23 = r14
            r14 = r18
            r41 = r15
            r15 = r21
            r16 = r22
            r18 = r41
            androidx.compose.material3.ButtonKt.TextButton(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            r9 = r8
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r12 = 2
            r13 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r8 = r0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r8, r9, r10, r11, r12, r13)
            r8 = 1338449892(0x4fc71fe4, float:6.6815119E9)
            r15 = r41
            r15.startReplaceableGroup(r8)
            r8 = r7 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 ^ 3072(0xc00, float:4.305E-42)
            r10 = 2048(0x800, float:2.87E-42)
            if (r8 <= r10) goto L_0x023e
            boolean r8 = r15.changed((java.lang.Object) r4)
            if (r8 != 0) goto L_0x0242
        L_0x023e:
            r8 = r7 & 3072(0xc00, float:4.305E-42)
            if (r8 != r10) goto L_0x0244
        L_0x0242:
            r14 = 1
            goto L_0x0246
        L_0x0244:
            r14 = r23
        L_0x0246:
            java.lang.Object r8 = r15.rememberedValue()
            if (r14 != 0) goto L_0x0254
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r8 != r10) goto L_0x025e
        L_0x0254:
            jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$1$1$2$1 r8 = new jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$1$1$2$1
            r8.<init>(r4)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r15.updateRememberedValue(r8)
        L_0x025e:
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r15.endReplaceableGroup()
            jp.co.sony.reonpocket.connection.log.logcat.ComposableSingletons$LogCatLogActivityKt r10 = jp.co.sony.reonpocket.connection.log.logcat.ComposableSingletons$LogCatLogActivityKt.INSTANCE
            kotlin.jvm.functions.Function3 r17 = r10.m6986getLambda4$app_prodRelease()
            r19 = 805306368(0x30000000, float:4.656613E-10)
            r20 = 508(0x1fc, float:7.12E-43)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            r41 = r15
            r15 = r16
            r16 = r18
            r18 = r41
            androidx.compose.material3.ButtonKt.TextButton(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            r9 = r8
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r12 = 2
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            r8 = r0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r8, r9, r10, r11, r12, r13)
            r0 = 1338462983(0x4fc75307, float:6.6882145E9)
            r15 = r41
            r15.startReplaceableGroup(r0)
            r0 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r7
            r0 = r0 ^ 24576(0x6000, float:3.4438E-41)
            r8 = 16384(0x4000, float:2.2959E-41)
            if (r0 <= r8) goto L_0x02a7
            boolean r0 = r15.changed((java.lang.Object) r5)
            if (r0 != 0) goto L_0x02ab
        L_0x02a7:
            r0 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r0 != r8) goto L_0x02ad
        L_0x02ab:
            r14 = 1
            goto L_0x02af
        L_0x02ad:
            r14 = r23
        L_0x02af:
            java.lang.Object r0 = r15.rememberedValue()
            if (r14 != 0) goto L_0x02bd
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r0 != r8) goto L_0x02c7
        L_0x02bd:
            jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$1$1$3$1 r0 = new jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$1$1$3$1
            r0.<init>(r5)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r15.updateRememberedValue(r0)
        L_0x02c7:
            r8 = r0
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r15.endReplaceableGroup()
            jp.co.sony.reonpocket.connection.log.logcat.ComposableSingletons$LogCatLogActivityKt r0 = jp.co.sony.reonpocket.connection.log.logcat.ComposableSingletons$LogCatLogActivityKt.INSTANCE
            kotlin.jvm.functions.Function3 r17 = r0.m6987getLambda5$app_prodRelease()
            r19 = 805306368(0x30000000, float:4.656613E-10)
            r20 = 508(0x1fc, float:7.12E-43)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r0 = 0
            r16 = 0
            r41 = r15
            r15 = r0
            r18 = r41
            androidx.compose.material3.ButtonKt.TextButton(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r41)
            r41.endReplaceableGroup()
            r41.endNode()
            r41.endReplaceableGroup()
            r41.endReplaceableGroup()
            r0 = -2064039689(0xffffffff84f940f7, float:-5.859928E-36)
            r15 = r41
            r15.startReplaceableGroup(r0)
            r0 = r1
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0305:
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x038a
            java.lang.Object r8 = r0.next()
            r9 = r8
            java.io.File r9 = (java.io.File) r9
            r8 = 24
            long r12 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r8)
            java.lang.String r10 = r9.getName()
            r8 = r10
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            r14 = 0
            r41 = r0
            r0 = 0
            r16 = r15
            r15 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r11, r14, r15, r0)
            r11 = 5
            float r11 = (float) r11
            float r11 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r11)
            androidx.compose.ui.Modifier r17 = androidx.compose.foundation.layout.PaddingKt.m670padding3ABfNKs(r0, r11)
            jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$1$2$1 r0 = new jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$1$2$1
            r0.<init>(r6, r9)
            r22 = r0
            kotlin.jvm.functions.Function0 r22 = (kotlin.jvm.functions.Function0) r22
            jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$1$2$2 r0 = new jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$1$2$2
            r0.<init>(r2, r9)
            r24 = r0
            kotlin.jvm.functions.Function0 r24 = (kotlin.jvm.functions.Function0) r24
            r25 = 47
            r26 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.ClickableKt.m252combinedClickablecJG_KMw$default(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r31 = 0
            r32 = 131060(0x1fff4, float:1.83654E-40)
            r10 = 0
            r14 = 0
            r0 = 0
            r34 = r15
            r33 = r16
            r15 = r0
            r16 = 0
            r17 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 3072(0xc00, float:4.305E-42)
            r29 = r33
            androidx.compose.material3.TextKt.m2456Text4IGK_g((java.lang.String) r8, (androidx.compose.ui.Modifier) r9, (long) r10, (long) r12, (androidx.compose.ui.text.font.FontStyle) r14, (androidx.compose.ui.text.font.FontWeight) r15, (androidx.compose.ui.text.font.FontFamily) r16, (long) r17, (androidx.compose.ui.text.style.TextDecoration) r19, (androidx.compose.ui.text.style.TextAlign) r20, (long) r21, (int) r23, (boolean) r24, (int) r25, (int) r26, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r27, (androidx.compose.ui.text.TextStyle) r28, (androidx.compose.runtime.Composer) r29, (int) r30, (int) r31, (int) r32)
            r0 = r41
            r15 = r33
            goto L_0x0305
        L_0x038a:
            r33 = r15
            r33.endReplaceableGroup()
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r33)
            r33.endReplaceableGroup()
            r33.endNode()
            r33.endReplaceableGroup()
            r33.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03a7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03a7:
            androidx.compose.runtime.ScopeUpdateScope r8 = r33.endRestartGroup()
            if (r8 == 0) goto L_0x03c6
            jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$2 r9 = new jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt$LogFileList$2
            r0 = r9
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            r5 = r39
            r6 = r40
            r7 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x03c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.logcat.LogCatLogActivityKt.LogFileList(java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }
}
