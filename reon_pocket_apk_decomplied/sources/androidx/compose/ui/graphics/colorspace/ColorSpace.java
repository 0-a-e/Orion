package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 72\u00020\u0001:\u00017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0007J\u0012\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u001f\u001a\u00020\u001aH'J\u0012\u0010 \u001a\u00020\u001c2\b\b\u0001\u0010!\u001a\u00020\bH&J\u0012\u0010\"\u001a\u00020\u001c2\b\b\u0001\u0010!\u001a\u00020\bH&J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cH\u0010¢\u0006\u0002\b*J \u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001cH\u0007J\u0012\u0010+\u001a\u00020\u001a2\b\b\u0001\u0010\u001f\u001a\u00020\u001aH'J%\u0010/\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cH\u0010¢\u0006\u0002\b0J=\u00101\u001a\u0002022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u0000H\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106R\u0011\u0010\n\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "", "name", "", "model", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "id", "", "(Ljava/lang/String;JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "componentCount", "getComponentCount", "()I", "getId$ui_graphics_release", "isSrgb", "", "()Z", "isWideGamut", "getModel-xdoWZVw", "()J", "J", "getName", "()Ljava/lang/String;", "equals", "other", "fromXyz", "", "x", "", "y", "z", "v", "getMaxValue", "component", "getMinValue", "hashCode", "toString", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "r", "g", "b", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorSpace.kt */
public abstract class ColorSpace {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MaxId = 63;
    public static final int MinId = -1;
    private final int id;
    private final long model;
    private final String name;

    public /* synthetic */ ColorSpace(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, i);
    }

    public /* synthetic */ ColorSpace(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    public abstract float[] fromXyz(float[] fArr);

    public abstract float getMaxValue(int i);

    public abstract float getMinValue(int i);

    public boolean isSrgb() {
        return false;
    }

    public abstract boolean isWideGamut();

    public abstract float[] toXyz(float[] fArr);

    private ColorSpace(String str, long j, int i) {
        this.name = str;
        this.model = j;
        this.id = i;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        } else if (i < -1 || i > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }

    public final String getName() {
        return this.name;
    }

    /* renamed from: getModel-xdoWZVw  reason: not valid java name */
    public final long m4294getModelxdoWZVw() {
        return this.model;
    }

    public final int getId$ui_graphics_release() {
        return this.id;
    }

    private ColorSpace(String str, long j) {
        this(str, j, -1, (DefaultConstructorMarker) null);
    }

    public final int getComponentCount() {
        return ColorModel.m4286getComponentCountimpl(this.model);
    }

    public final float[] toXyz(float f, float f2, float f3) {
        return toXyz(new float[]{f, f2, f3});
    }

    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float[] xyz = toXyz(f, f2, f3);
        return (((long) Float.floatToRawIntBits(xyz[0])) << 32) | (((long) Float.floatToRawIntBits(xyz[1])) & 4294967295L);
    }

    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        return toXyz(f, f2, f3)[2];
    }

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release  reason: not valid java name */
    public long m4295xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        float[] fromXyz = fromXyz(f, f2, f3);
        return ColorKt.Color(fromXyz[0], fromXyz[1], fromXyz[2], f4, colorSpace);
    }

    public final float[] fromXyz(float f, float f2, float f3) {
        float[] fArr = new float[ColorModel.m4286getComponentCountimpl(this.model)];
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        return fromXyz(fArr);
    }

    public String toString() {
        return this.name + " (id=" + this.id + ", model=" + ColorModel.m4288toStringimpl(this.model) + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorSpace colorSpace = (ColorSpace) obj;
        if (this.id == colorSpace.id && Intrinsics.areEqual((Object) this.name, (Object) colorSpace.name)) {
            return ColorModel.m4285equalsimpl0(this.model, colorSpace.model);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + ColorModel.m4287hashCodeimpl(this.model)) * 31) + this.id;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace$Companion;", "", "()V", "MaxId", "", "MinId", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ColorSpace.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
