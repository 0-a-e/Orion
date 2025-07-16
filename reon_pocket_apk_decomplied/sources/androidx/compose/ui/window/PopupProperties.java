package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.scheduling.WorkQueueKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nBM\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/window/PopupProperties;", "", "focusable", "", "dismissOnBackPress", "dismissOnClickOutside", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "excludeFromSystemGesture", "clippingEnabled", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "usePlatformDefaultWidth", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZZ)V", "getClippingEnabled", "()Z", "getDismissOnBackPress", "getDismissOnClickOutside", "getExcludeFromSystemGesture", "getFocusable", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getUsePlatformDefaultWidth", "equals", "other", "hashCode", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class PopupProperties {
    public static final int $stable = 0;
    private final boolean clippingEnabled;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final boolean excludeFromSystemGesture;
    private final boolean focusable;
    private final SecureFlagPolicy securePolicy;
    private final boolean usePlatformDefaultWidth;

    public PopupProperties() {
        this(false, false, false, (SecureFlagPolicy) null, false, false, false, WorkQueueKt.MASK, (DefaultConstructorMarker) null);
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5, boolean z6) {
        this.focusable = z;
        this.dismissOnBackPress = z2;
        this.dismissOnClickOutside = z3;
        this.securePolicy = secureFlagPolicy;
        this.excludeFromSystemGesture = z4;
        this.clippingEnabled = z5;
        this.usePlatformDefaultWidth = z6;
    }

    public final boolean getFocusable() {
        return this.focusable;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PopupProperties(boolean r7, boolean r8, boolean r9, androidx.compose.ui.window.SecureFlagPolicy r10, boolean r11, boolean r12, boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            r1 = 1
            if (r7 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r8
        L_0x0010:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0016
            r3 = r1
            goto L_0x0017
        L_0x0016:
            r3 = r9
        L_0x0017:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001d
            androidx.compose.ui.window.SecureFlagPolicy r10 = androidx.compose.ui.window.SecureFlagPolicy.Inherit
        L_0x001d:
            r4 = r10
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0024
            r5 = r1
            goto L_0x0025
        L_0x0024:
            r5 = r11
        L_0x0025:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r1 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r2
            r10 = r3
            r11 = r4
            r12 = r5
            r13 = r1
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupProperties.<init>(boolean, boolean, boolean, androidx.compose.ui.window.SecureFlagPolicy, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getExcludeFromSystemGesture() {
        return this.excludeFromSystemGesture;
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PopupProperties(boolean r5, boolean r6, boolean r7, androidx.compose.ui.window.SecureFlagPolicy r8, boolean r9, boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0005
            r5 = 0
        L_0x0005:
            r12 = r11 & 2
            r0 = 1
            if (r12 == 0) goto L_0x000c
            r12 = r0
            goto L_0x000d
        L_0x000c:
            r12 = r6
        L_0x000d:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0013
            r1 = r0
            goto L_0x0014
        L_0x0013:
            r1 = r7
        L_0x0014:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001a
            androidx.compose.ui.window.SecureFlagPolicy r8 = androidx.compose.ui.window.SecureFlagPolicy.Inherit
        L_0x001a:
            r2 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0021
            r3 = r0
            goto L_0x0022
        L_0x0021:
            r3 = r9
        L_0x0022:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r0 = r10
        L_0x0028:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupProperties.<init>(boolean, boolean, boolean, androidx.compose.ui.window.SecureFlagPolicy, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy secureFlagPolicy, boolean z4, boolean z5) {
        this(z, z2, z3, secureFlagPolicy, z4, z5, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupProperties)) {
            return false;
        }
        PopupProperties popupProperties = (PopupProperties) obj;
        return this.focusable == popupProperties.focusable && this.dismissOnBackPress == popupProperties.dismissOnBackPress && this.dismissOnClickOutside == popupProperties.dismissOnClickOutside && this.securePolicy == popupProperties.securePolicy && this.excludeFromSystemGesture == popupProperties.excludeFromSystemGesture && this.clippingEnabled == popupProperties.clippingEnabled && this.usePlatformDefaultWidth == popupProperties.usePlatformDefaultWidth;
    }

    public int hashCode() {
        return (((((((((((((UByte$$ExternalSyntheticBackport0.m(this.dismissOnBackPress) * 31) + UByte$$ExternalSyntheticBackport0.m(this.focusable)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.dismissOnBackPress)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.dismissOnClickOutside)) * 31) + this.securePolicy.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.excludeFromSystemGesture)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.clippingEnabled)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.usePlatformDefaultWidth);
    }
}
