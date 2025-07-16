package jp.co.sony.reonpocket.modules.settings.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jp.co.sony.reonpocket.databinding.FragmentOssContentBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/OssContentFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentOssContentBinding;", "initUI", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OssContentFragment.kt */
public final class OssContentFragment extends BaseFragment {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SEPARATOR = "\n\n--------\n\n";
    private static final Integer[] androidStudio = {14, 15, 18};
    private static final String androidStudioTermsUrl = "https://developer.android.com/studio/terms.html";
    /* access modifiers changed from: private */
    public static final Integer[] onlyApacheArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 16, 17, 20, 21, 22, 23, 24, 25};
    public static final int onlyBSD3Index = 19;
    /* access modifiers changed from: private */
    public static final String[] thirdPartyLicenses = {"org.jetbrains.kotlin:kotlin-reflect", "org.jetbrains.kotlinx:kotlinx-coroutines-core", "org.jetbrains.kotlinx:kotlinx-coroutines-android", "androidx.appcompat:appcompat", "androidx.constraintlayout:constraintlayout", "androidx.activity:activity-compose", "com.google.android.material:material", "com.google.android.play:review", "com.google.android.play:review-ktx", "androidx.compose.ui:ui", "androidx.compose.ui:ui-graphics", "androidx.compose.ui:ui-tooling-preview", "androidx.compose.material3:material3", "org.altbeacon:android-beacon-library", "com.google.firebase:firebase-core", "com.google.firebase:firebase-analytics", "com.google.firebase:firebase-config", "com.google.firebase:firebase-crashlytics", "com.google.firebase:firebase-messaging", "no.nordicsemi.android:dfu", "com.amazonaws:aws-android-sdk-core", "com.amazonaws:aws-android-sdk-s3", "com.amazonaws:aws-android-sdk-mobile-client", "com.amazonaws:aws-android-sdk-ddb-mapper", "org.apache.commons:commons-csv", "org.apache.commons:commons-compress"};
    private FragmentOssContentBinding binding;

    @JvmStatic
    public static final OssContentFragment newInstance() {
        return Companion.newInstance();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/OssContentFragment$Companion;", "", "()V", "SEPARATOR", "", "androidStudio", "", "", "[Ljava/lang/Integer;", "androidStudioTermsUrl", "onlyApacheArray", "getOnlyApacheArray", "()[Ljava/lang/Integer;", "onlyBSD3Index", "thirdPartyLicenses", "getThirdPartyLicenses", "()[Ljava/lang/String;", "[Ljava/lang/String;", "newInstance", "Ljp/co/sony/reonpocket/modules/settings/view/OssContentFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: OssContentFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Integer[] getOnlyApacheArray() {
            return OssContentFragment.onlyApacheArray;
        }

        public final String[] getThirdPartyLicenses() {
            return OssContentFragment.thirdPartyLicenses;
        }

        @JvmStatic
        public final OssContentFragment newInstance() {
            return new OssContentFragment();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentOssContentBinding inflate = FragmentOssContentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        initUI(inflate);
        return inflate.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:26|25|31|32|(0)|(0)|41|72|68) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bd, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00be, code lost:
        android.util.Log.w("DEBUG_LICENSES", "BufferedReader close failed", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e2, code lost:
        r15 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e9, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ea, code lost:
        android.util.Log.w("DEBUG_LICENSES", "BufferedReader close failed", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f5, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f6, code lost:
        android.util.Log.w("DEBUG_LICENSES", "InputStream close failed", r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b2 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b9 A[SYNTHETIC, Splitter:B:34:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c5 A[SYNTHETIC, Splitter:B:39:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e5 A[SYNTHETIC, Splitter:B:44:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f1 A[SYNTHETIC, Splitter:B:49:0x00f1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initUI(jp.co.sony.reonpocket.databinding.FragmentOssContentBinding r15) {
        /*
            r14 = this;
            java.lang.String r0 = "InputStream close failed"
            java.lang.String r1 = "BufferedReader close failed"
            android.widget.LinearLayout r15 = r15.licenseHolder
            java.lang.String r2 = "licenseHolder"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r2)
            java.lang.String[] r2 = thirdPartyLicenses
            int r2 = r2.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x01ad
            android.widget.TextView r4 = new android.widget.TextView
            android.content.Context r5 = r14.requireContext()
            r4.<init>(r5)
            java.lang.String[] r5 = thirdPartyLicenses
            r6 = r5[r3]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "\n\n--------\n\n"
            r7.<init>(r8)
            r7.append(r6)
            r7.append(r8)
            java.lang.String r6 = r7.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            android.view.View r4 = (android.view.View) r4
            r15.addView(r4)
            java.lang.Integer[] r4 = onlyApacheArray
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            boolean r4 = kotlin.collections.ArraysKt.contains((T[]) r4, r6)
            java.lang.String r6 = "toString(...)"
            java.lang.String r7 = "Failed loading html."
            java.lang.String r8 = "added: "
            java.lang.String r9 = "DEBUG_LICENSES"
            if (r4 == 0) goto L_0x00fc
            android.widget.TextView r4 = new android.widget.TextView
            android.content.Context r5 = r14.requireContext()
            r4.<init>(r5)
            r5 = 0
            android.content.res.Resources r10 = r14.getResources()     // Catch:{ IOException -> 0x00b1, all -> 0x00ae }
            int r11 = jp.co.sony.reonpocket.R.raw.apache_license     // Catch:{ IOException -> 0x00b1, all -> 0x00ae }
            java.io.InputStream r10 = r10.openRawResource(r11)     // Catch:{ IOException -> 0x00b1, all -> 0x00ae }
            java.io.BufferedReader r11 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b2 }
            java.nio.charset.Charset r12 = kotlin.text.Charsets.UTF_8     // Catch:{ IOException -> 0x00b2 }
            java.io.InputStreamReader r13 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b2 }
            r13.<init>(r10, r12)     // Catch:{ IOException -> 0x00b2 }
            java.io.Reader r13 = (java.io.Reader) r13     // Catch:{ IOException -> 0x00b2 }
            r11.<init>(r13)     // Catch:{ IOException -> 0x00b2 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ac, all -> 0x00a9 }
            r5.<init>()     // Catch:{ IOException -> 0x00ac, all -> 0x00a9 }
            java.lang.String r12 = r11.readLine()     // Catch:{ IOException -> 0x00ac, all -> 0x00a9 }
        L_0x0078:
            if (r12 == 0) goto L_0x0082
            r5.append(r12)     // Catch:{ IOException -> 0x00ac, all -> 0x00a9 }
            java.lang.String r12 = r11.readLine()     // Catch:{ IOException -> 0x00ac, all -> 0x00a9 }
            goto L_0x0078
        L_0x0082:
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x00ac, all -> 0x00a9 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ IOException -> 0x00ac, all -> 0x00a9 }
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)     // Catch:{ IOException -> 0x00ac, all -> 0x00a9 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ IOException -> 0x00ac, all -> 0x00a9 }
            r4.setText(r5)     // Catch:{ IOException -> 0x00ac, all -> 0x00a9 }
            r11.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x009c
        L_0x0096:
            r5 = move-exception
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            android.util.Log.w(r9, r1, r5)
        L_0x009c:
            if (r10 == 0) goto L_0x00c8
            r10.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00c8
        L_0x00a2:
            r5 = move-exception
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            android.util.Log.w(r9, r0, r5)
            goto L_0x00c8
        L_0x00a9:
            r15 = move-exception
            r5 = r11
            goto L_0x00e3
        L_0x00ac:
            r5 = r11
            goto L_0x00b2
        L_0x00ae:
            r15 = move-exception
            r10 = r5
            goto L_0x00e3
        L_0x00b1:
            r10 = r5
        L_0x00b2:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x00e2 }
            r4.setText(r7)     // Catch:{ all -> 0x00e2 }
            if (r5 == 0) goto L_0x00c3
            r5.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00c3
        L_0x00bd:
            r5 = move-exception
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            android.util.Log.w(r9, r1, r5)
        L_0x00c3:
            if (r10 == 0) goto L_0x00c8
            r10.close()     // Catch:{ IOException -> 0x00a2 }
        L_0x00c8:
            java.lang.String[] r5 = thirdPartyLicenses
            r5 = r5[r3]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            android.util.Log.e(r9, r5)
            android.view.View r4 = (android.view.View) r4
            r15.addView(r4)
            goto L_0x01a9
        L_0x00e2:
            r15 = move-exception
        L_0x00e3:
            if (r5 == 0) goto L_0x00ef
            r5.close()     // Catch:{ IOException -> 0x00e9 }
            goto L_0x00ef
        L_0x00e9:
            r2 = move-exception
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            android.util.Log.w(r9, r1, r2)
        L_0x00ef:
            if (r10 == 0) goto L_0x00fb
            r10.close()     // Catch:{ IOException -> 0x00f5 }
            goto L_0x00fb
        L_0x00f5:
            r1 = move-exception
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            android.util.Log.w(r9, r0, r1)
        L_0x00fb:
            throw r15
        L_0x00fc:
            r4 = 19
            if (r3 != r4) goto L_0x0168
            android.widget.TextView r4 = new android.widget.TextView
            android.content.Context r5 = r14.requireContext()
            r4.<init>(r5)
            android.content.res.Resources r5 = r14.getResources()     // Catch:{ IOException -> 0x014a }
            int r10 = jp.co.sony.reonpocket.R.raw.bsd_3_clause_license     // Catch:{ IOException -> 0x014a }
            java.io.InputStream r5 = r5.openRawResource(r10)     // Catch:{ IOException -> 0x014a }
            java.lang.String r10 = "openRawResource(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)     // Catch:{ IOException -> 0x014a }
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ IOException -> 0x014a }
            java.nio.charset.Charset r11 = kotlin.text.Charsets.UTF_8     // Catch:{ IOException -> 0x014a }
            java.io.InputStreamReader r12 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x014a }
            r12.<init>(r5, r11)     // Catch:{ IOException -> 0x014a }
            java.io.Reader r12 = (java.io.Reader) r12     // Catch:{ IOException -> 0x014a }
            r10.<init>(r12)     // Catch:{ IOException -> 0x014a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014a }
            r5.<init>()     // Catch:{ IOException -> 0x014a }
            java.lang.String r11 = r10.readLine()     // Catch:{ IOException -> 0x014a }
        L_0x012f:
            if (r11 == 0) goto L_0x0139
            r5.append(r11)     // Catch:{ IOException -> 0x014a }
            java.lang.String r11 = r10.readLine()     // Catch:{ IOException -> 0x014a }
            goto L_0x012f
        L_0x0139:
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x014a }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ IOException -> 0x014a }
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)     // Catch:{ IOException -> 0x014a }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ IOException -> 0x014a }
            r4.setText(r5)     // Catch:{ IOException -> 0x014a }
            goto L_0x014f
        L_0x014a:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r4.setText(r7)
        L_0x014f:
            java.lang.String[] r5 = thirdPartyLicenses
            r5 = r5[r3]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            android.util.Log.e(r9, r5)
            android.view.View r4 = (android.view.View) r4
            r15.addView(r4)
            goto L_0x01a9
        L_0x0168:
            java.lang.Integer[] r4 = androidStudio
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            boolean r4 = kotlin.collections.ArraysKt.contains((T[]) r4, r6)
            if (r4 == 0) goto L_0x01a9
            android.widget.TextView r4 = new android.widget.TextView
            android.content.Context r6 = r14.requireContext()
            r4.<init>(r6)
            r6 = 1
            r4.setLinksClickable(r6)
            java.lang.String r6 = "<a href=\"https://developer.android.com/studio/terms.html\">https://developer.android.com/studio/terms.html</a>"
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            android.text.method.MovementMethod r6 = android.text.method.LinkMovementMethod.getInstance()
            r4.setMovementMethod(r6)
            r5 = r5[r3]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            android.util.Log.e(r9, r5)
            android.view.View r4 = (android.view.View) r4
            r15.addView(r4)
        L_0x01a9:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x01ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.settings.view.OssContentFragment.initUI(jp.co.sony.reonpocket.databinding.FragmentOssContentBinding):void");
    }
}
