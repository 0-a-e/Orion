package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B/\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ:\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019JD\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0017\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0005H\u0000¢\u0006\u0002\b#J\b\u0010$\u001a\u00020%H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getImeAction-eUduSuo", "getKeyboardType-PjHm6EE", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "copy", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-ij11fho", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "other", "hashCode", "", "toImeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "singleLine", "toImeOptions$foundation_release", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyboardOptions.kt */
public final class KeyboardOptions {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final KeyboardOptions Default = new KeyboardOptions(0, false, 0, 0, (PlatformImeOptions) null, 31, (DefaultConstructorMarker) null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3, platformImeOptions2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2) {
        this.capitalization = i;
        this.autoCorrect = z;
        this.keyboardType = i2;
        this.imeAction = i3;
        this.platformImeOptions = platformImeOptions2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.Companion.m6266getNoneIUNYP9k() : i, (i4 & 2) != 0 ? true : z, (i4 & 4) != 0 ? KeyboardType.Companion.m6292getTextPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.Companion.m6237getDefaulteUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions2, (DefaultConstructorMarker) null);
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public final int m1082getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public final int m1084getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    /* renamed from: getImeAction-eUduSuo  reason: not valid java name */
    public final int m1083getImeActioneUduSuo() {
        return this.imeAction;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: KeyboardOptions.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        private Companion() {
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.Companion.m6266getNoneIUNYP9k() : i, (i4 & 2) != 0 ? true : z, (i4 & 4) != 0 ? KeyboardType.Companion.m6292getTextPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.Companion.m6237getDefaulteUduSuo() : i3, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3) {
        this(i, z, i2, i3, (PlatformImeOptions) null, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions keyboardOptions, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ImeOptions.Companion.getDefault().getSingleLine();
        }
        return keyboardOptions.toImeOptions$foundation_release(z);
    }

    public final ImeOptions toImeOptions$foundation_release(boolean z) {
        return new ImeOptions(z, this.capitalization, this.autoCorrect, this.keyboardType, this.imeAction, this.platformImeOptions, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-ij11fho$default  reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1079copyij11fho$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            z = keyboardOptions.autoCorrect;
        }
        boolean z2 = z;
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            platformImeOptions2 = keyboardOptions.platformImeOptions;
        }
        return keyboardOptions.m1081copyij11fho(i, z2, i5, i6, platformImeOptions2);
    }

    /* renamed from: copy-ij11fho  reason: not valid java name */
    public final KeyboardOptions m1081copyij11fho(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions2) {
        return new KeyboardOptions(i, z, i2, i3, platformImeOptions2, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-3m2b7yw$default  reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1078copy3m2b7yw$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            z = keyboardOptions.autoCorrect;
        }
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        return keyboardOptions.m1080copy3m2b7yw(i, z, i2, i3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* renamed from: copy-3m2b7yw  reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1080copy3m2b7yw(int i, boolean z, int i2, int i3) {
        return new KeyboardOptions(i, z, i2, i3, this.platformImeOptions, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) obj;
        return KeyboardCapitalization.m6257equalsimpl0(this.capitalization, keyboardOptions.capitalization) && this.autoCorrect == keyboardOptions.autoCorrect && KeyboardType.m6272equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) && ImeAction.m6225equalsimpl0(this.imeAction, keyboardOptions.imeAction) && Intrinsics.areEqual((Object) this.platformImeOptions, (Object) keyboardOptions.platformImeOptions);
    }

    public int hashCode() {
        int r0 = ((((((KeyboardCapitalization.m6258hashCodeimpl(this.capitalization) * 31) + UByte$$ExternalSyntheticBackport0.m(this.autoCorrect)) * 31) + KeyboardType.m6273hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m6226hashCodeimpl(this.imeAction)) * 31;
        PlatformImeOptions platformImeOptions2 = this.platformImeOptions;
        return r0 + (platformImeOptions2 != null ? platformImeOptions2.hashCode() : 0);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + KeyboardCapitalization.m6259toStringimpl(this.capitalization) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + KeyboardType.m6274toStringimpl(this.keyboardType) + ", imeAction=" + ImeAction.m6227toStringimpl(this.imeAction) + ", platformImeOptions=" + this.platformImeOptions + ')';
    }
}
