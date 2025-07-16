package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomAccessibilityView;", "Landroid/view/View;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mViewDescription", "", "getMViewDescription", "()Ljava/lang/String;", "setMViewDescription", "(Ljava/lang/String;)V", "changeDescription", "", "aDescription", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomAccessibilityView.kt */
public class CustomAccessibilityView extends View {
    public static final int $stable = 8;
    private String mViewDescription;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomAccessibilityView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomAccessibilityView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomAccessibilityView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomAccessibilityView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    /* access modifiers changed from: protected */
    public final String getMViewDescription() {
        return this.mViewDescription;
    }

    /* access modifiers changed from: protected */
    public final void setMViewDescription(String str) {
        this.mViewDescription = str;
    }

    /* access modifiers changed from: protected */
    public final void changeDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "aDescription");
        if (!Intrinsics.areEqual((Object) getContentDescription(), (Object) str)) {
            setContentDescription(str);
            this.mViewDescription = str;
        }
    }
}
