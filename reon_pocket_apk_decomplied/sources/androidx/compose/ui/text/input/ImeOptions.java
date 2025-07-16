package androidx.compose.ui.text.input;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B9\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bBC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJN\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions;", "", "singleLine", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "(ZIZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getImeAction-eUduSuo", "getKeyboardType-PjHm6EE", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getSingleLine", "copy", "copy-uxg59PA", "(ZIZII)Landroidx/compose/ui/text/input/ImeOptions;", "copy-YTHSh70", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/ui/text/input/ImeOptions;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ImeOptions.kt */
public final class ImeOptions {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ImeOptions Default = new ImeOptions(false, 0, false, 0, 0, (PlatformImeOptions) null, 63, (DefaultConstructorMarker) null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final boolean singleLine;

    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, i2, i3, platformImeOptions2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, z2, i2, i3);
    }

    private ImeOptions(boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2) {
        this.singleLine = z;
        this.capitalization = i;
        this.autoCorrect = z2;
        this.keyboardType = i2;
        this.imeAction = i3;
        this.platformImeOptions = platformImeOptions2;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ImeOptions(boolean r8, int r9, boolean r10, int r11, int r12, androidx.compose.ui.text.input.PlatformImeOptions r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r0 = r14 & 1
            if (r0 == 0) goto L_0x0006
            r0 = 0
            goto L_0x0007
        L_0x0006:
            r0 = r8
        L_0x0007:
            r1 = r14 & 2
            if (r1 == 0) goto L_0x0012
            androidx.compose.ui.text.input.KeyboardCapitalization$Companion r1 = androidx.compose.ui.text.input.KeyboardCapitalization.Companion
            int r1 = r1.m6266getNoneIUNYP9k()
            goto L_0x0013
        L_0x0012:
            r1 = r9
        L_0x0013:
            r2 = r14 & 4
            if (r2 == 0) goto L_0x0019
            r2 = 1
            goto L_0x001a
        L_0x0019:
            r2 = r10
        L_0x001a:
            r3 = r14 & 8
            if (r3 == 0) goto L_0x0025
            androidx.compose.ui.text.input.KeyboardType$Companion r3 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r3 = r3.m6292getTextPjHm6EE()
            goto L_0x0026
        L_0x0025:
            r3 = r11
        L_0x0026:
            r4 = r14 & 16
            if (r4 == 0) goto L_0x0031
            androidx.compose.ui.text.input.ImeAction$Companion r4 = androidx.compose.ui.text.input.ImeAction.Companion
            int r4 = r4.m6237getDefaulteUduSuo()
            goto L_0x0032
        L_0x0031:
            r4 = r12
        L_0x0032:
            r5 = r14 & 32
            if (r5 == 0) goto L_0x0038
            r5 = 0
            goto L_0x0039
        L_0x0038:
            r5 = r13
        L_0x0039:
            r6 = 0
            r8 = r7
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r8.<init>((boolean) r9, (int) r10, (boolean) r11, (int) r12, (int) r13, (androidx.compose.ui.text.input.PlatformImeOptions) r14, (kotlin.jvm.internal.DefaultConstructorMarker) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.ImeOptions.<init>(boolean, int, boolean, int, int, androidx.compose.ui.text.input.PlatformImeOptions, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public final int m6249getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public final int m6251getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    /* renamed from: getImeAction-eUduSuo  reason: not valid java name */
    public final int m6250getImeActioneUduSuo() {
        return this.imeAction;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/input/ImeOptions;", "getDefault", "()Landroidx/compose/ui/text/input/ImeOptions;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ImeOptions.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImeOptions getDefault() {
            return ImeOptions.Default;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImeOptions(boolean z, int i, boolean z2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? KeyboardCapitalization.Companion.m6266getNoneIUNYP9k() : i, (i4 & 4) != 0 ? true : z2, (i4 & 8) != 0 ? KeyboardType.Companion.m6292getTextPjHm6EE() : i2, (i4 & 16) != 0 ? ImeAction.Companion.m6237getDefaulteUduSuo() : i3, (DefaultConstructorMarker) null);
    }

    private ImeOptions(boolean z, int i, boolean z2, int i2, int i3) {
        this(z, i, z2, i2, i3, (PlatformImeOptions) null, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-YTHSh70$default  reason: not valid java name */
    public static /* synthetic */ ImeOptions m6245copyYTHSh70$default(ImeOptions imeOptions, boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = imeOptions.singleLine;
        }
        if ((i4 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            z2 = imeOptions.autoCorrect;
        }
        boolean z3 = z2;
        if ((i4 & 8) != 0) {
            i2 = imeOptions.keyboardType;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = imeOptions.imeAction;
        }
        int i7 = i3;
        if ((i4 & 32) != 0) {
            platformImeOptions2 = imeOptions.platformImeOptions;
        }
        return imeOptions.m6247copyYTHSh70(z, i5, z3, i6, i7, platformImeOptions2);
    }

    /* renamed from: copy-YTHSh70  reason: not valid java name */
    public final ImeOptions m6247copyYTHSh70(boolean z, int i, boolean z2, int i2, int i3, PlatformImeOptions platformImeOptions2) {
        return new ImeOptions(z, i, z2, i2, i3, platformImeOptions2, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-uxg59PA$default  reason: not valid java name */
    public static /* synthetic */ ImeOptions m6246copyuxg59PA$default(ImeOptions imeOptions, boolean z, int i, boolean z2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = imeOptions.singleLine;
        }
        if ((i4 & 2) != 0) {
            i = imeOptions.capitalization;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            z2 = imeOptions.autoCorrect;
        }
        boolean z3 = z2;
        if ((i4 & 8) != 0) {
            i2 = imeOptions.keyboardType;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = imeOptions.imeAction;
        }
        return imeOptions.m6248copyuxg59PA(z, i5, z3, i6, i3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* renamed from: copy-uxg59PA  reason: not valid java name */
    public final /* synthetic */ ImeOptions m6248copyuxg59PA(boolean z, int i, boolean z2, int i2, int i3) {
        return new ImeOptions(z, i, z2, i2, i3, this.platformImeOptions, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImeOptions)) {
            return false;
        }
        ImeOptions imeOptions = (ImeOptions) obj;
        return this.singleLine == imeOptions.singleLine && KeyboardCapitalization.m6257equalsimpl0(this.capitalization, imeOptions.capitalization) && this.autoCorrect == imeOptions.autoCorrect && KeyboardType.m6272equalsimpl0(this.keyboardType, imeOptions.keyboardType) && ImeAction.m6225equalsimpl0(this.imeAction, imeOptions.imeAction) && Intrinsics.areEqual((Object) this.platformImeOptions, (Object) imeOptions.platformImeOptions);
    }

    public int hashCode() {
        int m = ((((((((UByte$$ExternalSyntheticBackport0.m(this.singleLine) * 31) + KeyboardCapitalization.m6258hashCodeimpl(this.capitalization)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.autoCorrect)) * 31) + KeyboardType.m6273hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m6226hashCodeimpl(this.imeAction)) * 31;
        PlatformImeOptions platformImeOptions2 = this.platformImeOptions;
        return m + (platformImeOptions2 != null ? platformImeOptions2.hashCode() : 0);
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + KeyboardCapitalization.m6259toStringimpl(this.capitalization) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + KeyboardType.m6274toStringimpl(this.keyboardType) + ", imeAction=" + ImeAction.m6227toStringimpl(this.imeAction) + ", platformImeOptions=" + this.platformImeOptions + ')';
    }
}
