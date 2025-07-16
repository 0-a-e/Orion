package jp.co.sony.reonpocket.data.interactor;

import jp.co.sony.reonpocket.data.interactor.SettingInfoInteractorInput;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$compareFirmRevisionWithServer$1", f = "SettingInfoInteractor.kt", i = {0, 0, 0, 0}, l = {72, 110, 115}, m = "invokeSuspend", n = {"connection", "inputStream", "reader", "scanner"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: SettingInfoInteractor.kt */
final class SettingInfoInteractor$compareFirmRevisionWithServer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SettingInfoInteractorInput.OnCompleteListener $aListener;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingInfoInteractor$compareFirmRevisionWithServer$1(SettingInfoInteractorInput.OnCompleteListener onCompleteListener, Continuation<? super SettingInfoInteractor$compareFirmRevisionWithServer$1> continuation) {
        super(2, continuation);
        this.$aListener = onCompleteListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingInfoInteractor$compareFirmRevisionWithServer$1(this.$aListener, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingInfoInteractor$compareFirmRevisionWithServer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v72, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: java.util.Scanner} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v73, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v74, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v75, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r0v21, types: [java.net.URLConnection, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x018b A[SYNTHETIC, Splitter:B:106:0x018b] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0199 A[SYNTHETIC, Splitter:B:113:0x0199] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01a7 A[SYNTHETIC, Splitter:B:120:0x01a7] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r3 = 3
            r4 = 2
            java.lang.String r5 = "InputStream close failed"
            java.lang.String r6 = "Scanner close failed"
            java.lang.String r7 = "Reader close failed"
            r8 = 1
            java.lang.String r9 = "VERSION_CHECK"
            r10 = 0
            if (r0 == 0) goto L_0x004e
            if (r0 == r8) goto L_0x0031
            if (r0 == r4) goto L_0x0029
            if (r0 != r3) goto L_0x0021
            kotlin.ResultKt.throwOnFailure(r17)
            goto L_0x01f9
        L_0x0021:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r17)     // Catch:{ IOException -> 0x002e }
            goto L_0x01f9
        L_0x002e:
            r0 = move-exception
            goto L_0x01d2
        L_0x0031:
            java.lang.Object r0 = r1.L$3
            r4 = r0
            java.util.Scanner r4 = (java.util.Scanner) r4
            java.lang.Object r0 = r1.L$2
            r8 = r0
            java.io.BufferedReader r8 = (java.io.BufferedReader) r8
            java.lang.Object r0 = r1.L$1
            r11 = r0
            java.io.InputStream r11 = (java.io.InputStream) r11
            java.lang.Object r0 = r1.L$0
            r12 = r0
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12
            kotlin.ResultKt.throwOnFailure(r17)     // Catch:{ all -> 0x004a }
            goto L_0x0117
        L_0x004a:
            r0 = move-exception
        L_0x004b:
            r3 = r0
            goto L_0x0189
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r17)
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x002e }
            java.lang.String r11 = "https://rnp-prod-appinfo.s3-ap-northeast-1.amazonaws.com/app-params/latest-app-version-android"
            r0.<init>(r11)     // Catch:{ IOException -> 0x002e }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IOException -> 0x002e }
            java.lang.String r11 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r11)     // Catch:{ IOException -> 0x002e }
            r12 = r0
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ IOException -> 0x002e }
            java.lang.String r0 = "GET"
            r12.setRequestMethod(r0)     // Catch:{ IOException -> 0x002e }
            r0 = 10000(0x2710, float:1.4013E-41)
            r12.setConnectTimeout(r0)     // Catch:{ IOException -> 0x002e }
            int r0 = r12.getResponseCode()     // Catch:{ IOException -> 0x002e }
            r11 = 200(0xc8, float:2.8E-43)
            if (r0 != r11) goto L_0x01b7
            java.io.InputStream r11 = r12.getInputStream()     // Catch:{ all -> 0x0184 }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x017f }
            r13 = 24
            java.lang.String r14 = "\n"
            java.lang.String r15 = ""
            if (r0 < r13) goto L_0x00b9
            java.io.BufferedReader r13 = new java.io.BufferedReader     // Catch:{ all -> 0x017f }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x017f }
            r0.<init>(r11)     // Catch:{ all -> 0x017f }
            java.io.Reader r0 = (java.io.Reader) r0     // Catch:{ all -> 0x017f }
            r13.<init>(r0)     // Catch:{ all -> 0x017f }
            java.util.stream.Stream r0 = r13.lines()     // Catch:{ all -> 0x00b3 }
            java.util.stream.Collector r3 = jp.co.sony.reonpocket.util.LocaleUtil$$ExternalSyntheticApiModelOutline0.m()     // Catch:{ all -> 0x00b3 }
            java.lang.Object r0 = r0.collect(r3)     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = "collect(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00b3 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x00b3 }
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = kotlin.text.StringsKt.replace((java.lang.String) r0, (java.lang.String) r14, (java.lang.String) r15, (boolean) r8)     // Catch:{ all -> 0x00b3 }
            r3 = r10
            goto L_0x00e2
        L_0x00b3:
            r0 = move-exception
            r3 = r0
            r4 = r10
            r8 = r13
            goto L_0x0189
        L_0x00b9:
            java.util.Scanner r0 = new java.util.Scanner     // Catch:{ all -> 0x017f }
            r0.<init>(r11)     // Catch:{ all -> 0x017f }
            java.lang.String r3 = "\\A"
            java.util.Scanner r3 = r0.useDelimiter(r3)     // Catch:{ all -> 0x017f }
            boolean r0 = r3.hasNext()     // Catch:{ all -> 0x017a }
            if (r0 == 0) goto L_0x00cf
            java.lang.String r0 = r3.next()     // Catch:{ all -> 0x017a }
            goto L_0x00d0
        L_0x00cf:
            r0 = r15
        L_0x00d0:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x017a }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x017a }
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)     // Catch:{ all -> 0x017a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x017a }
            java.lang.String r0 = kotlin.text.StringsKt.replace((java.lang.String) r0, (java.lang.String) r14, (java.lang.String) r15, (boolean) r8)     // Catch:{ all -> 0x017a }
            r13 = r10
        L_0x00e2:
            jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil r14 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.INSTANCE     // Catch:{ all -> 0x0175 }
            boolean r14 = r14.isValidFirm(r0)     // Catch:{ all -> 0x0175 }
            if (r14 == 0) goto L_0x0147
            jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil r4 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.INSTANCE     // Catch:{ all -> 0x0175 }
            java.lang.String r14 = "2.0.0"
            jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil$CompareResult r0 = r4.compareVersion(r0, r14)     // Catch:{ all -> 0x0175 }
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ all -> 0x0175 }
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4     // Catch:{ all -> 0x0175 }
            jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$compareFirmRevisionWithServer$1$1 r14 = new jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$compareFirmRevisionWithServer$1$1     // Catch:{ all -> 0x0175 }
            jp.co.sony.reonpocket.data.interactor.SettingInfoInteractorInput$OnCompleteListener r15 = r1.$aListener     // Catch:{ all -> 0x0175 }
            r14.<init>(r0, r15, r10)     // Catch:{ all -> 0x0175 }
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14     // Catch:{ all -> 0x0175 }
            r0 = r1
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0175 }
            r1.L$0 = r12     // Catch:{ all -> 0x0175 }
            r1.L$1 = r11     // Catch:{ all -> 0x0175 }
            r1.L$2 = r13     // Catch:{ all -> 0x0175 }
            r1.L$3 = r3     // Catch:{ all -> 0x0175 }
            r1.label = r8     // Catch:{ all -> 0x0175 }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r4, r14, r0)     // Catch:{ all -> 0x0175 }
            if (r0 != r2) goto L_0x0115
            return r2
        L_0x0115:
            r4 = r3
            r8 = r13
        L_0x0117:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004a }
            if (r8 == 0) goto L_0x0127
            r8.close()     // Catch:{ IOException -> 0x011f }
            goto L_0x0127
        L_0x011f:
            r0 = move-exception
            r8 = r0
            r0 = r8
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ IOException -> 0x002e }
            android.util.Log.w(r9, r7, r0)     // Catch:{ IOException -> 0x002e }
        L_0x0127:
            if (r4 == 0) goto L_0x0135
            r4.close()     // Catch:{ IOException -> 0x012d }
            goto L_0x0135
        L_0x012d:
            r0 = move-exception
            r4 = r0
            r0 = r4
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ IOException -> 0x002e }
            android.util.Log.w(r9, r6, r0)     // Catch:{ IOException -> 0x002e }
        L_0x0135:
            if (r11 == 0) goto L_0x0143
            r11.close()     // Catch:{ IOException -> 0x013b }
            goto L_0x0143
        L_0x013b:
            r0 = move-exception
            r4 = r0
            r0 = r4
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ IOException -> 0x002e }
            android.util.Log.w(r9, r5, r0)     // Catch:{ IOException -> 0x002e }
        L_0x0143:
            r12.disconnect()     // Catch:{ IOException -> 0x002e }
            return r3
        L_0x0147:
            if (r13 == 0) goto L_0x0155
            r13.close()     // Catch:{ IOException -> 0x014d }
            goto L_0x0155
        L_0x014d:
            r0 = move-exception
            r8 = r0
            r0 = r8
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ IOException -> 0x002e }
            android.util.Log.w(r9, r7, r0)     // Catch:{ IOException -> 0x002e }
        L_0x0155:
            if (r3 == 0) goto L_0x0163
            r3.close()     // Catch:{ IOException -> 0x015b }
            goto L_0x0163
        L_0x015b:
            r0 = move-exception
            r3 = r0
            r0 = r3
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ IOException -> 0x002e }
            android.util.Log.w(r9, r6, r0)     // Catch:{ IOException -> 0x002e }
        L_0x0163:
            if (r11 == 0) goto L_0x0171
            r11.close()     // Catch:{ IOException -> 0x0169 }
            goto L_0x0171
        L_0x0169:
            r0 = move-exception
            r3 = r0
            r0 = r3
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ IOException -> 0x002e }
            android.util.Log.w(r9, r5, r0)     // Catch:{ IOException -> 0x002e }
        L_0x0171:
            r12.disconnect()     // Catch:{ IOException -> 0x002e }
            goto L_0x01b7
        L_0x0175:
            r0 = move-exception
            r4 = r3
            r8 = r13
            goto L_0x004b
        L_0x017a:
            r0 = move-exception
            r4 = r3
            r8 = r10
            goto L_0x004b
        L_0x017f:
            r0 = move-exception
            r3 = r0
            r4 = r10
            r8 = r4
            goto L_0x0189
        L_0x0184:
            r0 = move-exception
            r3 = r0
            r4 = r10
            r8 = r4
            r11 = r8
        L_0x0189:
            if (r8 == 0) goto L_0x0197
            r8.close()     // Catch:{ IOException -> 0x018f }
            goto L_0x0197
        L_0x018f:
            r0 = move-exception
            r8 = r0
            r0 = r8
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ IOException -> 0x002e }
            android.util.Log.w(r9, r7, r0)     // Catch:{ IOException -> 0x002e }
        L_0x0197:
            if (r4 == 0) goto L_0x01a5
            r4.close()     // Catch:{ IOException -> 0x019d }
            goto L_0x01a5
        L_0x019d:
            r0 = move-exception
            r4 = r0
            r0 = r4
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ IOException -> 0x002e }
            android.util.Log.w(r9, r6, r0)     // Catch:{ IOException -> 0x002e }
        L_0x01a5:
            if (r11 == 0) goto L_0x01b3
            r11.close()     // Catch:{ IOException -> 0x01ab }
            goto L_0x01b3
        L_0x01ab:
            r0 = move-exception
            r4 = r0
            r0 = r4
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ IOException -> 0x002e }
            android.util.Log.w(r9, r5, r0)     // Catch:{ IOException -> 0x002e }
        L_0x01b3:
            r12.disconnect()     // Catch:{ IOException -> 0x002e }
            throw r3     // Catch:{ IOException -> 0x002e }
        L_0x01b7:
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ IOException -> 0x002e }
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch:{ IOException -> 0x002e }
            jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$compareFirmRevisionWithServer$1$2 r3 = new jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$compareFirmRevisionWithServer$1$2     // Catch:{ IOException -> 0x002e }
            jp.co.sony.reonpocket.data.interactor.SettingInfoInteractorInput$OnCompleteListener r5 = r1.$aListener     // Catch:{ IOException -> 0x002e }
            r3.<init>(r5, r10)     // Catch:{ IOException -> 0x002e }
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch:{ IOException -> 0x002e }
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ IOException -> 0x002e }
            r1.label = r4     // Catch:{ IOException -> 0x002e }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r3, r5)     // Catch:{ IOException -> 0x002e }
            if (r0 != r2) goto L_0x01f9
            return r2
        L_0x01d2:
            r0.printStackTrace()
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$compareFirmRevisionWithServer$1$3 r3 = new jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$compareFirmRevisionWithServer$1$3
            jp.co.sony.reonpocket.data.interactor.SettingInfoInteractorInput$OnCompleteListener r4 = r1.$aListener
            r3.<init>(r4, r10)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r1.L$0 = r10
            r1.L$1 = r10
            r1.L$2 = r10
            r1.L$3 = r10
            r5 = 3
            r1.label = r5
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r3, r4)
            if (r0 != r2) goto L_0x01f9
            return r2
        L_0x01f9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$compareFirmRevisionWithServer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
