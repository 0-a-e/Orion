package androidx.compose.ui.graphics.colorspace;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "gamma", "", "a", "b", "c", "d", "e", "f", "(DDDDDDD)V", "getA", "()D", "getB", "getC", "getD", "getE", "getF", "getGamma", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransferParameters.kt */
public final class TransferParameters {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double gamma;

    public static /* synthetic */ TransferParameters copy$default(TransferParameters transferParameters, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, Object obj) {
        TransferParameters transferParameters2 = transferParameters;
        return transferParameters.copy((i & 1) != 0 ? transferParameters2.gamma : d2, (i & 2) != 0 ? transferParameters2.a : d3, (i & 4) != 0 ? transferParameters2.b : d4, (i & 8) != 0 ? transferParameters2.c : d5, (i & 16) != 0 ? transferParameters2.d : d6, (i & 32) != 0 ? transferParameters2.e : d7, (i & 64) != 0 ? transferParameters2.f : d8);
    }

    public final double component1() {
        return this.gamma;
    }

    public final double component2() {
        return this.a;
    }

    public final double component3() {
        return this.b;
    }

    public final double component4() {
        return this.c;
    }

    public final double component5() {
        return this.d;
    }

    public final double component6() {
        return this.e;
    }

    public final double component7() {
        return this.f;
    }

    public final TransferParameters copy(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return new TransferParameters(d2, d3, d4, d5, d6, d7, d8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferParameters)) {
            return false;
        }
        TransferParameters transferParameters = (TransferParameters) obj;
        return Double.compare(this.gamma, transferParameters.gamma) == 0 && Double.compare(this.a, transferParameters.a) == 0 && Double.compare(this.b, transferParameters.b) == 0 && Double.compare(this.c, transferParameters.c) == 0 && Double.compare(this.d, transferParameters.d) == 0 && Double.compare(this.e, transferParameters.e) == 0 && Double.compare(this.f, transferParameters.f) == 0;
    }

    public int hashCode() {
        return (((((((((((Double.doubleToLongBits(this.gamma) * 31) + Double.doubleToLongBits(this.a)) * 31) + Double.doubleToLongBits(this.b)) * 31) + Double.doubleToLongBits(this.c)) * 31) + Double.doubleToLongBits(this.d)) * 31) + Double.doubleToLongBits(this.e)) * 31) + Double.doubleToLongBits(this.f);
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ')';
    }

    public TransferParameters(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        this.gamma = d2;
        this.a = d3;
        this.b = d4;
        this.c = d5;
        this.d = d6;
        this.e = d7;
        this.f = d8;
        if (Double.isNaN(d3) || Double.isNaN(d4) || Double.isNaN(d5) || Double.isNaN(d6) || Double.isNaN(d7) || Double.isNaN(d8) || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Parameters cannot be NaN");
        } else if (d6 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d6 > 1.0d) {
            throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + d6);
        } else if (d6 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && (d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
            throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
        } else if (d6 >= 1.0d && d5 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
        } else if ((d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) && d5 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
        } else if (d5 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException("The transfer function must be increasing");
        } else if (d3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException("The transfer function must be positive or increasing");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransferParameters(double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d2, d3, d4, d5, d6, (i & 32) != 0 ? 0.0d : d7, (i & 64) != 0 ? 0.0d : d8);
    }

    public final double getGamma() {
        return this.gamma;
    }

    public final double getA() {
        return this.a;
    }

    public final double getB() {
        return this.b;
    }

    public final double getC() {
        return this.c;
    }

    public final double getD() {
        return this.d;
    }

    public final double getE() {
        return this.e;
    }

    public final double getF() {
        return this.f;
    }
}
