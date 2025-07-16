package androidx.core.app;

import android.app.job.JobWorkItem;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.LocaleList;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.util.Locale;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationCompat$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ JobWorkItem m(Intent intent) {
        return new JobWorkItem(intent);
    }

    public static /* synthetic */ ShortcutInfo.Builder m(Context context, String str) {
        return new ShortcutInfo.Builder(context, str);
    }

    public static /* synthetic */ Typeface.Builder m(AssetManager assetManager, String str) {
        return new Typeface.Builder(assetManager, str);
    }

    public static /* synthetic */ Typeface.Builder m(File file) {
        return new Typeface.Builder(file);
    }

    public static /* synthetic */ Typeface.Builder m(FileDescriptor fileDescriptor) {
        return new Typeface.Builder(fileDescriptor);
    }

    public static /* synthetic */ FontVariationAxis m(String str, float f) {
        return new FontVariationAxis(str, f);
    }

    public static /* synthetic */ LocaleList m(Locale[] localeArr) {
        return new LocaleList(localeArr);
    }

    public static /* synthetic */ BoringLayout m(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, BoringLayout.Metrics metrics, boolean z, TextUtils.TruncateAt truncateAt, int i2, boolean z2) {
        return new BoringLayout(charSequence, textPaint, i, alignment, f, f2, metrics, z, truncateAt, i2, z2);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void m$2() {
        /*
            android.content.pm.ShortcutInfo$Builder r0 = new android.content.pm.ShortcutInfo$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat$$ExternalSyntheticApiModelOutline0.m$2():void");
    }
}
