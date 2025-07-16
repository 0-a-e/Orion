package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\"\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a\"\u0010:\u001a\u00020\u00022\u0006\u00102\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b;\u00109\u001a*\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a*\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a*\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010C\u001a#\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\bø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a#\u0010J\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\bø\u0001\u0000¢\u0006\u0004\bK\u0010I\u001a\u001f\u0010L\u001a\u00020\b*\u00020\b2\u0006\u0010M\u001a\u00020\bH\bø\u0001\u0000¢\u0006\u0004\bN\u0010I\u001a\u001f\u0010O\u001a\u00020\b*\u00020\b2\u0006\u0010P\u001a\u00020\bH\bø\u0001\u0000¢\u0006\u0004\bQ\u0010I\u001a'\u0010R\u001a\u00020\b*\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\bø\u0001\u0000¢\u0006\u0004\bS\u0010A\u001a%\u0010T\u001a\u00020\b*\u00020\b2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\b0VH\bø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a%\u0010T\u001a\u00020\u0001*\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00010VH\bø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a%\u0010T\u001a\u00020\u0002*\u00020\u00022\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00020VH\bø\u0001\u0000¢\u0006\u0004\b[\u0010Z\u001a\u001f\u0010\\\u001a\u00020\b*\u00020\t2\u0006\u0010]\u001a\u00020\bH\nø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001a\u001f\u0010\\\u001a\u00020\b*\u00020\u000e2\u0006\u0010]\u001a\u00020\bH\nø\u0001\u0000¢\u0006\u0004\b^\u0010I\u001a\u001f\u0010\\\u001a\u00020\u0002*\u00020\u000e2\u0006\u0010.\u001a\u00020\u0002H\nø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a\u001f\u0010\\\u001a\u00020\b*\u00020\u00112\u0006\u0010]\u001a\u00020\bH\nø\u0001\u0000¢\u0006\u0004\b^\u0010b\u001a\u001f\u0010\\\u001a\u00020\u0002*\u00020\u00112\u0006\u0010.\u001a\u00020\u0002H\nø\u0001\u0000¢\u0006\u0004\b`\u0010c\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\b*\u00020\t8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u001f\u0010\u0007\u001a\u00020\b*\u00020\u000e8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000f\u001a\u0004\b\f\u0010\u0010\"\u001f\u0010\u0007\u001a\u00020\b*\u00020\u00118Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\f\u0010\u0013\"\u001f\u0010\u0014\u001a\u00020\b*\u00020\u00158Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u001f\u0010\u001a\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e\"\u001f\u0010\u001f\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u001e\"\u001f\u0010\u001f\u001a\u00020\u001b*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010$\"\u001f\u0010\u001f\u001a\u00020\u001b*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010$\"\u001f\u0010'\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u001e\"\u001f\u0010'\u001a\u00020\u001b*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010$\"\u001f\u0010'\u001a\u00020\u001b*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010$\"\u001f\u0010.\u001a\u00020\u0002*\u00020\u00158Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0017\u001a\u0004\b0\u00101\"\u001f\u00102\u001a\u00020\b*\u00020\u00158Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0017\u001a\u0004\b4\u0010\u0019\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006d"}, d2 = {"center", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/ui/unit/DpSize;", "getCenter-EaSLcWc$annotations", "(J)V", "getCenter-EaSLcWc", "(J)J", "dp", "Landroidx/compose/ui/unit/Dp;", "", "getDp$annotations", "(D)V", "getDp", "(D)F", "", "(F)V", "(F)F", "", "(I)V", "(I)F", "height", "Landroidx/compose/ui/unit/DpRect;", "getHeight$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getHeight", "(Landroidx/compose/ui/unit/DpRect;)F", "isFinite", "", "isFinite-0680j_4$annotations", "isFinite-0680j_4", "(F)Z", "isSpecified", "isSpecified-0680j_4$annotations", "isSpecified-0680j_4", "isSpecified-jo-Fl9I$annotations", "isSpecified-jo-Fl9I", "(J)Z", "isSpecified-EaSLcWc$annotations", "isSpecified-EaSLcWc", "isUnspecified", "isUnspecified-0680j_4$annotations", "isUnspecified-0680j_4", "isUnspecified-jo-Fl9I$annotations", "isUnspecified-jo-Fl9I", "isUnspecified-EaSLcWc$annotations", "isUnspecified-EaSLcWc", "size", "getSize$annotations", "getSize", "(Landroidx/compose/ui/unit/DpRect;)J", "width", "getWidth$annotations", "getWidth", "DpOffset", "x", "y", "DpOffset-YgX7TsA", "(FF)J", "DpSize", "DpSize-YgX7TsA", "lerp", "start", "stop", "fraction", "lerp-Md-fbLM", "(FFF)F", "lerp-xhh869w", "(JJF)J", "lerp-IDex15A", "max", "a", "b", "max-YgX7TsA", "(FF)F", "min", "min-YgX7TsA", "coerceAtLeast", "minimumValue", "coerceAtLeast-YgX7TsA", "coerceAtMost", "maximumValue", "coerceAtMost-YgX7TsA", "coerceIn", "coerceIn-2z7ARbQ", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-D5KLDUw", "(FLkotlin/jvm/functions/Function0;)F", "takeOrElse-gVKV90s", "(JLkotlin/jvm/functions/Function0;)J", "takeOrElse-itqla9I", "times", "other", "times-3ABfNKs", "(DF)F", "times-6HolHcs", "(FJ)J", "(IF)F", "(IJ)J", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dp.kt */
public final class DpKt {
    /* renamed from: getCenter-EaSLcWc$annotations  reason: not valid java name */
    public static /* synthetic */ void m6641getCenterEaSLcWc$annotations(long j) {
    }

    public static /* synthetic */ void getDp$annotations(double d) {
    }

    public static /* synthetic */ void getDp$annotations(float f) {
    }

    public static /* synthetic */ void getDp$annotations(int i) {
    }

    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    /* renamed from: isFinite-0680j_4  reason: not valid java name */
    public static final boolean m6642isFinite0680j_4(float f) {
        return !(f == Float.POSITIVE_INFINITY);
    }

    /* renamed from: isFinite-0680j_4$annotations  reason: not valid java name */
    public static /* synthetic */ void m6643isFinite0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-0680j_4$annotations  reason: not valid java name */
    public static /* synthetic */ void m6645isSpecified0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-EaSLcWc$annotations  reason: not valid java name */
    public static /* synthetic */ void m6647isSpecifiedEaSLcWc$annotations(long j) {
    }

    /* renamed from: isSpecified-jo-Fl9I$annotations  reason: not valid java name */
    public static /* synthetic */ void m6649isSpecifiedjoFl9I$annotations(long j) {
    }

    /* renamed from: isUnspecified-0680j_4$annotations  reason: not valid java name */
    public static /* synthetic */ void m6651isUnspecified0680j_4$annotations(float f) {
    }

    /* renamed from: isUnspecified-EaSLcWc$annotations  reason: not valid java name */
    public static /* synthetic */ void m6653isUnspecifiedEaSLcWc$annotations(long j) {
    }

    /* renamed from: isUnspecified-jo-Fl9I$annotations  reason: not valid java name */
    public static /* synthetic */ void m6655isUnspecifiedjoFl9I$annotations(long j) {
    }

    /* renamed from: isSpecified-0680j_4  reason: not valid java name */
    public static final boolean m6644isSpecified0680j_4(float f) {
        return !Float.isNaN(f);
    }

    /* renamed from: isUnspecified-0680j_4  reason: not valid java name */
    public static final boolean m6650isUnspecified0680j_4(float f) {
        return Float.isNaN(f);
    }

    public static final float getDp(int i) {
        return Dp.m6614constructorimpl((float) i);
    }

    public static final float getDp(double d) {
        return Dp.m6614constructorimpl((float) d);
    }

    public static final float getDp(float f) {
        return Dp.m6614constructorimpl(f);
    }

    /* renamed from: times-3ABfNKs  reason: not valid java name */
    public static final float m6665times3ABfNKs(float f, float f2) {
        return Dp.m6614constructorimpl(f * f2);
    }

    /* renamed from: times-3ABfNKs  reason: not valid java name */
    public static final float m6664times3ABfNKs(double d, float f) {
        return Dp.m6614constructorimpl(((float) d) * f);
    }

    /* renamed from: times-3ABfNKs  reason: not valid java name */
    public static final float m6666times3ABfNKs(int i, float f) {
        return Dp.m6614constructorimpl(((float) i) * f);
    }

    /* renamed from: min-YgX7TsA  reason: not valid java name */
    public static final float m6660minYgX7TsA(float f, float f2) {
        return Dp.m6614constructorimpl(Math.min(f, f2));
    }

    /* renamed from: max-YgX7TsA  reason: not valid java name */
    public static final float m6659maxYgX7TsA(float f, float f2) {
        return Dp.m6614constructorimpl(Math.max(f, f2));
    }

    /* renamed from: coerceIn-2z7ARbQ  reason: not valid java name */
    public static final float m6639coerceIn2z7ARbQ(float f, float f2, float f3) {
        return Dp.m6614constructorimpl(RangesKt.coerceIn(f, f2, f3));
    }

    /* renamed from: coerceAtLeast-YgX7TsA  reason: not valid java name */
    public static final float m6637coerceAtLeastYgX7TsA(float f, float f2) {
        return Dp.m6614constructorimpl(RangesKt.coerceAtLeast(f, f2));
    }

    /* renamed from: coerceAtMost-YgX7TsA  reason: not valid java name */
    public static final float m6638coerceAtMostYgX7TsA(float f, float f2) {
        return Dp.m6614constructorimpl(RangesKt.coerceAtMost(f, f2));
    }

    /* renamed from: lerp-Md-fbLM  reason: not valid java name */
    public static final float m6657lerpMdfbLM(float f, float f2, float f3) {
        return Dp.m6614constructorimpl(MathHelpersKt.lerp(f, f2, f3));
    }

    /* renamed from: isSpecified-jo-Fl9I  reason: not valid java name */
    public static final boolean m6648isSpecifiedjoFl9I(long j) {
        return j != DpOffset.Companion.m6684getUnspecifiedRKDOV3M();
    }

    /* renamed from: isUnspecified-jo-Fl9I  reason: not valid java name */
    public static final boolean m6654isUnspecifiedjoFl9I(long j) {
        return j == DpOffset.Companion.m6684getUnspecifiedRKDOV3M();
    }

    /* renamed from: lerp-xhh869w  reason: not valid java name */
    public static final long m6658lerpxhh869w(long j, long j2, float f) {
        return m6635DpOffsetYgX7TsA(m6657lerpMdfbLM(DpOffset.m6675getXD9Ej5fM(j), DpOffset.m6675getXD9Ej5fM(j2), f), m6657lerpMdfbLM(DpOffset.m6677getYD9Ej5fM(j), DpOffset.m6677getYD9Ej5fM(j2), f));
    }

    /* renamed from: isSpecified-EaSLcWc  reason: not valid java name */
    public static final boolean m6646isSpecifiedEaSLcWc(long j) {
        return j != DpSize.Companion.m6721getUnspecifiedMYxV2XQ();
    }

    /* renamed from: isUnspecified-EaSLcWc  reason: not valid java name */
    public static final boolean m6652isUnspecifiedEaSLcWc(long j) {
        return j == DpSize.Companion.m6721getUnspecifiedMYxV2XQ();
    }

    /* renamed from: getCenter-EaSLcWc  reason: not valid java name */
    public static final long m6640getCenterEaSLcWc(long j) {
        return m6635DpOffsetYgX7TsA(Dp.m6614constructorimpl(DpSize.m6712getWidthD9Ej5fM(j) / 2.0f), Dp.m6614constructorimpl(DpSize.m6710getHeightD9Ej5fM(j) / 2.0f));
    }

    /* renamed from: times-6HolHcs  reason: not valid java name */
    public static final long m6668times6HolHcs(int i, long j) {
        return DpSize.m6718timesGh9hcWk(j, i);
    }

    /* renamed from: times-6HolHcs  reason: not valid java name */
    public static final long m6667times6HolHcs(float f, long j) {
        return DpSize.m6717timesGh9hcWk(j, f);
    }

    /* renamed from: lerp-IDex15A  reason: not valid java name */
    public static final long m6656lerpIDex15A(long j, long j2, float f) {
        return m6636DpSizeYgX7TsA(m6657lerpMdfbLM(DpSize.m6712getWidthD9Ej5fM(j), DpSize.m6712getWidthD9Ej5fM(j2), f), m6657lerpMdfbLM(DpSize.m6710getHeightD9Ej5fM(j), DpSize.m6710getHeightD9Ej5fM(j2), f));
    }

    public static final float getWidth(DpRect dpRect) {
        return Dp.m6614constructorimpl(dpRect.m6698getRightD9Ej5fM() - dpRect.m6697getLeftD9Ej5fM());
    }

    public static final float getHeight(DpRect dpRect) {
        return Dp.m6614constructorimpl(dpRect.m6696getBottomD9Ej5fM() - dpRect.m6699getTopD9Ej5fM());
    }

    /* renamed from: takeOrElse-D5KLDUw  reason: not valid java name */
    public static final float m6661takeOrElseD5KLDUw(float f, Function0<Dp> function0) {
        return Float.isNaN(f) ^ true ? f : function0.invoke().m6628unboximpl();
    }

    /* renamed from: DpOffset-YgX7TsA  reason: not valid java name */
    public static final long m6635DpOffsetYgX7TsA(float f, float f2) {
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f);
        return DpOffset.m6670constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (floatToRawIntBits << 32));
    }

    /* renamed from: takeOrElse-gVKV90s  reason: not valid java name */
    public static final long m6662takeOrElsegVKV90s(long j, Function0<DpOffset> function0) {
        return j != DpOffset.Companion.m6684getUnspecifiedRKDOV3M() ? j : function0.invoke().m6683unboximpl();
    }

    /* renamed from: DpSize-YgX7TsA  reason: not valid java name */
    public static final long m6636DpSizeYgX7TsA(float f, float f2) {
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f);
        return DpSize.m6703constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (floatToRawIntBits << 32));
    }

    /* renamed from: takeOrElse-itqla9I  reason: not valid java name */
    public static final long m6663takeOrElseitqla9I(long j, Function0<DpSize> function0) {
        return j != DpSize.Companion.m6721getUnspecifiedMYxV2XQ() ? j : function0.invoke().m6720unboximpl();
    }

    public static final long getSize(DpRect dpRect) {
        return m6636DpSizeYgX7TsA(Dp.m6614constructorimpl(dpRect.m6698getRightD9Ej5fM() - dpRect.m6697getLeftD9Ej5fM()), Dp.m6614constructorimpl(dpRect.m6696getBottomD9Ej5fM() - dpRect.m6699getTopD9Ej5fM()));
    }
}
