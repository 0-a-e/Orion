package androidx.compose.material3.tokens;

import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0003\b\u0001\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0019\u0010\u000e\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0017\u0010\nR\u0019\u0010\u0018\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0019\u0010\nR\u0019\u0010\u001a\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u001b\u0010\nR\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0019\u0010 \u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b!\u0010\nR\u0019\u0010\"\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b#\u0010\nR\u0019\u0010$\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b%\u0010\nR\u0011\u0010&\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0013R\u0011\u0010(\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006R\u0019\u0010*\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b+\u0010\nR\u0019\u0010,\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b-\u0010\nR\u0019\u0010.\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b/\u0010\nR\u0011\u00100\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0013R\u0011\u00102\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0006R\u0019\u00104\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b5\u0010\nR\u0019\u00106\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b7\u0010\nR\u0019\u00108\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b9\u0010\nR\u0011\u0010:\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0013R\u0011\u0010<\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0006R\u0019\u0010>\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b?\u0010\nR\u0019\u0010@\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bA\u0010\nR\u0019\u0010B\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bC\u0010\nR\u0011\u0010D\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0013R\u0011\u0010F\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0006R\u0019\u0010H\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bI\u0010\nR\u0019\u0010J\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bK\u0010\nR\u0019\u0010L\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bM\u0010\nR\u0011\u0010N\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0013R\u0011\u0010P\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0006R\u0019\u0010R\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bS\u0010\nR\u0019\u0010T\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bU\u0010\nR\u0019\u0010V\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bW\u0010\nR\u0011\u0010X\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0013R\u0011\u0010Z\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0006R\u0019\u0010\\\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b]\u0010\nR\u0019\u0010^\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b_\u0010\nR\u0019\u0010`\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\ba\u0010\nR\u0011\u0010b\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0013R\u0011\u0010d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0006R\u0019\u0010f\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bg\u0010\nR\u0019\u0010h\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bi\u0010\nR\u0019\u0010j\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bk\u0010\nR\u0011\u0010l\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0013R\u0011\u0010n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0006R\u0019\u0010p\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bq\u0010\nR\u0019\u0010r\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bs\u0010\nR\u0019\u0010t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bu\u0010\nR\u0011\u0010v\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0013R\u0011\u0010x\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u0006R\u0019\u0010z\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b{\u0010\nR\u0019\u0010|\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b}\u0010\nR\u0019\u0010~\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0010\nR\u0013\u0010\u0001\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\u0013R\u0013\u0010\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\u0006R\u001b\u0010\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u0001\u0010\nR\u001b\u0010\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u0001\u0010\nR\u001b\u0010\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u0001\u0010\nR\u0013\u0010\u0001\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\u0013R\u0013\u0010\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\u0006R\u001b\u0010\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u0001\u0010\nR\u001b\u0010\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u0001\u0010\nR\u001b\u0010\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u0001\u0010\nR\u0013\u0010\u0001\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\u0013R\u0013\u0010\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\u0006R\u001b\u0010\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u0001\u0010\nR\u001b\u0010\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u0001\u0010\nR\u001b\u0010\u0001\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\b\u0001\u0010\nR\u0013\u0010\u0001\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 \u0001"}, d2 = {"Landroidx/compose/material3/tokens/TypeScaleTokens;", "", "()V", "BodyLargeFont", "Landroidx/compose/ui/text/font/GenericFontFamily;", "getBodyLargeFont", "()Landroidx/compose/ui/text/font/GenericFontFamily;", "BodyLargeLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "getBodyLargeLineHeight-XSAIIZE", "()J", "J", "BodyLargeSize", "getBodyLargeSize-XSAIIZE", "BodyLargeTracking", "getBodyLargeTracking-XSAIIZE", "BodyLargeWeight", "Landroidx/compose/ui/text/font/FontWeight;", "getBodyLargeWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "BodyMediumFont", "getBodyMediumFont", "BodyMediumLineHeight", "getBodyMediumLineHeight-XSAIIZE", "BodyMediumSize", "getBodyMediumSize-XSAIIZE", "BodyMediumTracking", "getBodyMediumTracking-XSAIIZE", "BodyMediumWeight", "getBodyMediumWeight", "BodySmallFont", "getBodySmallFont", "BodySmallLineHeight", "getBodySmallLineHeight-XSAIIZE", "BodySmallSize", "getBodySmallSize-XSAIIZE", "BodySmallTracking", "getBodySmallTracking-XSAIIZE", "BodySmallWeight", "getBodySmallWeight", "DisplayLargeFont", "getDisplayLargeFont", "DisplayLargeLineHeight", "getDisplayLargeLineHeight-XSAIIZE", "DisplayLargeSize", "getDisplayLargeSize-XSAIIZE", "DisplayLargeTracking", "getDisplayLargeTracking-XSAIIZE", "DisplayLargeWeight", "getDisplayLargeWeight", "DisplayMediumFont", "getDisplayMediumFont", "DisplayMediumLineHeight", "getDisplayMediumLineHeight-XSAIIZE", "DisplayMediumSize", "getDisplayMediumSize-XSAIIZE", "DisplayMediumTracking", "getDisplayMediumTracking-XSAIIZE", "DisplayMediumWeight", "getDisplayMediumWeight", "DisplaySmallFont", "getDisplaySmallFont", "DisplaySmallLineHeight", "getDisplaySmallLineHeight-XSAIIZE", "DisplaySmallSize", "getDisplaySmallSize-XSAIIZE", "DisplaySmallTracking", "getDisplaySmallTracking-XSAIIZE", "DisplaySmallWeight", "getDisplaySmallWeight", "HeadlineLargeFont", "getHeadlineLargeFont", "HeadlineLargeLineHeight", "getHeadlineLargeLineHeight-XSAIIZE", "HeadlineLargeSize", "getHeadlineLargeSize-XSAIIZE", "HeadlineLargeTracking", "getHeadlineLargeTracking-XSAIIZE", "HeadlineLargeWeight", "getHeadlineLargeWeight", "HeadlineMediumFont", "getHeadlineMediumFont", "HeadlineMediumLineHeight", "getHeadlineMediumLineHeight-XSAIIZE", "HeadlineMediumSize", "getHeadlineMediumSize-XSAIIZE", "HeadlineMediumTracking", "getHeadlineMediumTracking-XSAIIZE", "HeadlineMediumWeight", "getHeadlineMediumWeight", "HeadlineSmallFont", "getHeadlineSmallFont", "HeadlineSmallLineHeight", "getHeadlineSmallLineHeight-XSAIIZE", "HeadlineSmallSize", "getHeadlineSmallSize-XSAIIZE", "HeadlineSmallTracking", "getHeadlineSmallTracking-XSAIIZE", "HeadlineSmallWeight", "getHeadlineSmallWeight", "LabelLargeFont", "getLabelLargeFont", "LabelLargeLineHeight", "getLabelLargeLineHeight-XSAIIZE", "LabelLargeSize", "getLabelLargeSize-XSAIIZE", "LabelLargeTracking", "getLabelLargeTracking-XSAIIZE", "LabelLargeWeight", "getLabelLargeWeight", "LabelMediumFont", "getLabelMediumFont", "LabelMediumLineHeight", "getLabelMediumLineHeight-XSAIIZE", "LabelMediumSize", "getLabelMediumSize-XSAIIZE", "LabelMediumTracking", "getLabelMediumTracking-XSAIIZE", "LabelMediumWeight", "getLabelMediumWeight", "LabelSmallFont", "getLabelSmallFont", "LabelSmallLineHeight", "getLabelSmallLineHeight-XSAIIZE", "LabelSmallSize", "getLabelSmallSize-XSAIIZE", "LabelSmallTracking", "getLabelSmallTracking-XSAIIZE", "LabelSmallWeight", "getLabelSmallWeight", "TitleLargeFont", "getTitleLargeFont", "TitleLargeLineHeight", "getTitleLargeLineHeight-XSAIIZE", "TitleLargeSize", "getTitleLargeSize-XSAIIZE", "TitleLargeTracking", "getTitleLargeTracking-XSAIIZE", "TitleLargeWeight", "getTitleLargeWeight", "TitleMediumFont", "getTitleMediumFont", "TitleMediumLineHeight", "getTitleMediumLineHeight-XSAIIZE", "TitleMediumSize", "getTitleMediumSize-XSAIIZE", "TitleMediumTracking", "getTitleMediumTracking-XSAIIZE", "TitleMediumWeight", "getTitleMediumWeight", "TitleSmallFont", "getTitleSmallFont", "TitleSmallLineHeight", "getTitleSmallLineHeight-XSAIIZE", "TitleSmallSize", "getTitleSmallSize-XSAIIZE", "TitleSmallTracking", "getTitleSmallTracking-XSAIIZE", "TitleSmallWeight", "getTitleSmallWeight", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TypeScaleTokens.kt */
public final class TypeScaleTokens {
    public static final int $stable = 0;
    private static final GenericFontFamily BodyLargeFont = TypefaceTokens.INSTANCE.getPlain();
    private static final long BodyLargeLineHeight = TextUnitKt.getSp(24.0d);
    private static final long BodyLargeSize = TextUnitKt.getSp(16);
    private static final long BodyLargeTracking = TextUnitKt.getSp(0.5d);
    private static final FontWeight BodyLargeWeight = TypefaceTokens.INSTANCE.getWeightRegular();
    private static final GenericFontFamily BodyMediumFont = TypefaceTokens.INSTANCE.getPlain();
    private static final long BodyMediumLineHeight = TextUnitKt.getSp(20.0d);
    private static final long BodyMediumSize = TextUnitKt.getSp(14);
    private static final long BodyMediumTracking = TextUnitKt.getSp(0.2d);
    private static final FontWeight BodyMediumWeight = TypefaceTokens.INSTANCE.getWeightRegular();
    private static final GenericFontFamily BodySmallFont = TypefaceTokens.INSTANCE.getPlain();
    private static final long BodySmallLineHeight = TextUnitKt.getSp(16.0d);
    private static final long BodySmallSize = TextUnitKt.getSp(12);
    private static final long BodySmallTracking = TextUnitKt.getSp(0.4d);
    private static final FontWeight BodySmallWeight = TypefaceTokens.INSTANCE.getWeightRegular();
    private static final GenericFontFamily DisplayLargeFont = TypefaceTokens.INSTANCE.getBrand();
    private static final long DisplayLargeLineHeight = TextUnitKt.getSp(64.0d);
    private static final long DisplayLargeSize = TextUnitKt.getSp(57);
    private static final long DisplayLargeTracking;
    private static final FontWeight DisplayLargeWeight = TypefaceTokens.INSTANCE.getWeightRegular();
    private static final GenericFontFamily DisplayMediumFont = TypefaceTokens.INSTANCE.getBrand();
    private static final long DisplayMediumLineHeight = TextUnitKt.getSp(52.0d);
    private static final long DisplayMediumSize = TextUnitKt.getSp(45);
    private static final long DisplayMediumTracking = TextUnitKt.getSp((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final FontWeight DisplayMediumWeight = TypefaceTokens.INSTANCE.getWeightRegular();
    private static final GenericFontFamily DisplaySmallFont = TypefaceTokens.INSTANCE.getBrand();
    private static final long DisplaySmallLineHeight = TextUnitKt.getSp(44.0d);
    private static final long DisplaySmallSize = TextUnitKt.getSp(36);
    private static final long DisplaySmallTracking = TextUnitKt.getSp((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final FontWeight DisplaySmallWeight = TypefaceTokens.INSTANCE.getWeightRegular();
    private static final GenericFontFamily HeadlineLargeFont = TypefaceTokens.INSTANCE.getBrand();
    private static final long HeadlineLargeLineHeight = TextUnitKt.getSp(40.0d);
    private static final long HeadlineLargeSize = TextUnitKt.getSp(32);
    private static final long HeadlineLargeTracking = TextUnitKt.getSp((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final FontWeight HeadlineLargeWeight = TypefaceTokens.INSTANCE.getWeightRegular();
    private static final GenericFontFamily HeadlineMediumFont = TypefaceTokens.INSTANCE.getBrand();
    private static final long HeadlineMediumLineHeight = TextUnitKt.getSp(36.0d);
    private static final long HeadlineMediumSize = TextUnitKt.getSp(28);
    private static final long HeadlineMediumTracking = TextUnitKt.getSp((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final FontWeight HeadlineMediumWeight = TypefaceTokens.INSTANCE.getWeightRegular();
    private static final GenericFontFamily HeadlineSmallFont = TypefaceTokens.INSTANCE.getBrand();
    private static final long HeadlineSmallLineHeight = TextUnitKt.getSp(32.0d);
    private static final long HeadlineSmallSize = TextUnitKt.getSp(24);
    private static final long HeadlineSmallTracking = TextUnitKt.getSp((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final FontWeight HeadlineSmallWeight = TypefaceTokens.INSTANCE.getWeightRegular();
    public static final TypeScaleTokens INSTANCE = new TypeScaleTokens();
    private static final GenericFontFamily LabelLargeFont = TypefaceTokens.INSTANCE.getPlain();
    private static final long LabelLargeLineHeight = TextUnitKt.getSp(20.0d);
    private static final long LabelLargeSize = TextUnitKt.getSp(14);
    private static final long LabelLargeTracking = TextUnitKt.getSp(0.1d);
    private static final FontWeight LabelLargeWeight = TypefaceTokens.INSTANCE.getWeightMedium();
    private static final GenericFontFamily LabelMediumFont = TypefaceTokens.INSTANCE.getPlain();
    private static final long LabelMediumLineHeight = TextUnitKt.getSp(16.0d);
    private static final long LabelMediumSize = TextUnitKt.getSp(12);
    private static final long LabelMediumTracking = TextUnitKt.getSp(0.5d);
    private static final FontWeight LabelMediumWeight = TypefaceTokens.INSTANCE.getWeightMedium();
    private static final GenericFontFamily LabelSmallFont = TypefaceTokens.INSTANCE.getPlain();
    private static final long LabelSmallLineHeight = TextUnitKt.getSp(16.0d);
    private static final long LabelSmallSize = TextUnitKt.getSp(11);
    private static final long LabelSmallTracking = TextUnitKt.getSp(0.5d);
    private static final FontWeight LabelSmallWeight = TypefaceTokens.INSTANCE.getWeightMedium();
    private static final GenericFontFamily TitleLargeFont = TypefaceTokens.INSTANCE.getBrand();
    private static final long TitleLargeLineHeight = TextUnitKt.getSp(28.0d);
    private static final long TitleLargeSize = TextUnitKt.getSp(22);
    private static final long TitleLargeTracking = TextUnitKt.getSp((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final FontWeight TitleLargeWeight = TypefaceTokens.INSTANCE.getWeightRegular();
    private static final GenericFontFamily TitleMediumFont = TypefaceTokens.INSTANCE.getPlain();
    private static final long TitleMediumLineHeight = TextUnitKt.getSp(24.0d);
    private static final long TitleMediumSize = TextUnitKt.getSp(16);
    private static final long TitleMediumTracking = TextUnitKt.getSp(0.2d);
    private static final FontWeight TitleMediumWeight = TypefaceTokens.INSTANCE.getWeightMedium();
    private static final GenericFontFamily TitleSmallFont = TypefaceTokens.INSTANCE.getPlain();
    private static final long TitleSmallLineHeight = TextUnitKt.getSp(20.0d);
    private static final long TitleSmallSize = TextUnitKt.getSp(14);
    private static final long TitleSmallTracking = TextUnitKt.getSp(0.1d);
    private static final FontWeight TitleSmallWeight = TypefaceTokens.INSTANCE.getWeightMedium();

    private TypeScaleTokens() {
    }

    static {
        long sp = TextUnitKt.getSp(0.2d);
        TextUnitKt.m6824checkArithmeticR2X_6o(sp);
        DisplayLargeTracking = TextUnitKt.pack(TextUnit.m6809getRawTypeimpl(sp), -TextUnit.m6811getValueimpl(sp));
    }

    public final GenericFontFamily getBodyLargeFont() {
        return BodyLargeFont;
    }

    /* renamed from: getBodyLargeLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3211getBodyLargeLineHeightXSAIIZE() {
        return BodyLargeLineHeight;
    }

    /* renamed from: getBodyLargeSize-XSAIIZE  reason: not valid java name */
    public final long m3212getBodyLargeSizeXSAIIZE() {
        return BodyLargeSize;
    }

    /* renamed from: getBodyLargeTracking-XSAIIZE  reason: not valid java name */
    public final long m3213getBodyLargeTrackingXSAIIZE() {
        return BodyLargeTracking;
    }

    public final FontWeight getBodyLargeWeight() {
        return BodyLargeWeight;
    }

    public final GenericFontFamily getBodyMediumFont() {
        return BodyMediumFont;
    }

    /* renamed from: getBodyMediumLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3214getBodyMediumLineHeightXSAIIZE() {
        return BodyMediumLineHeight;
    }

    /* renamed from: getBodyMediumSize-XSAIIZE  reason: not valid java name */
    public final long m3215getBodyMediumSizeXSAIIZE() {
        return BodyMediumSize;
    }

    /* renamed from: getBodyMediumTracking-XSAIIZE  reason: not valid java name */
    public final long m3216getBodyMediumTrackingXSAIIZE() {
        return BodyMediumTracking;
    }

    public final FontWeight getBodyMediumWeight() {
        return BodyMediumWeight;
    }

    public final GenericFontFamily getBodySmallFont() {
        return BodySmallFont;
    }

    /* renamed from: getBodySmallLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3217getBodySmallLineHeightXSAIIZE() {
        return BodySmallLineHeight;
    }

    /* renamed from: getBodySmallSize-XSAIIZE  reason: not valid java name */
    public final long m3218getBodySmallSizeXSAIIZE() {
        return BodySmallSize;
    }

    /* renamed from: getBodySmallTracking-XSAIIZE  reason: not valid java name */
    public final long m3219getBodySmallTrackingXSAIIZE() {
        return BodySmallTracking;
    }

    public final FontWeight getBodySmallWeight() {
        return BodySmallWeight;
    }

    public final GenericFontFamily getDisplayLargeFont() {
        return DisplayLargeFont;
    }

    /* renamed from: getDisplayLargeLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3220getDisplayLargeLineHeightXSAIIZE() {
        return DisplayLargeLineHeight;
    }

    /* renamed from: getDisplayLargeSize-XSAIIZE  reason: not valid java name */
    public final long m3221getDisplayLargeSizeXSAIIZE() {
        return DisplayLargeSize;
    }

    /* renamed from: getDisplayLargeTracking-XSAIIZE  reason: not valid java name */
    public final long m3222getDisplayLargeTrackingXSAIIZE() {
        return DisplayLargeTracking;
    }

    public final FontWeight getDisplayLargeWeight() {
        return DisplayLargeWeight;
    }

    public final GenericFontFamily getDisplayMediumFont() {
        return DisplayMediumFont;
    }

    /* renamed from: getDisplayMediumLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3223getDisplayMediumLineHeightXSAIIZE() {
        return DisplayMediumLineHeight;
    }

    /* renamed from: getDisplayMediumSize-XSAIIZE  reason: not valid java name */
    public final long m3224getDisplayMediumSizeXSAIIZE() {
        return DisplayMediumSize;
    }

    /* renamed from: getDisplayMediumTracking-XSAIIZE  reason: not valid java name */
    public final long m3225getDisplayMediumTrackingXSAIIZE() {
        return DisplayMediumTracking;
    }

    public final FontWeight getDisplayMediumWeight() {
        return DisplayMediumWeight;
    }

    public final GenericFontFamily getDisplaySmallFont() {
        return DisplaySmallFont;
    }

    /* renamed from: getDisplaySmallLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3226getDisplaySmallLineHeightXSAIIZE() {
        return DisplaySmallLineHeight;
    }

    /* renamed from: getDisplaySmallSize-XSAIIZE  reason: not valid java name */
    public final long m3227getDisplaySmallSizeXSAIIZE() {
        return DisplaySmallSize;
    }

    /* renamed from: getDisplaySmallTracking-XSAIIZE  reason: not valid java name */
    public final long m3228getDisplaySmallTrackingXSAIIZE() {
        return DisplaySmallTracking;
    }

    public final FontWeight getDisplaySmallWeight() {
        return DisplaySmallWeight;
    }

    public final GenericFontFamily getHeadlineLargeFont() {
        return HeadlineLargeFont;
    }

    /* renamed from: getHeadlineLargeLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3229getHeadlineLargeLineHeightXSAIIZE() {
        return HeadlineLargeLineHeight;
    }

    /* renamed from: getHeadlineLargeSize-XSAIIZE  reason: not valid java name */
    public final long m3230getHeadlineLargeSizeXSAIIZE() {
        return HeadlineLargeSize;
    }

    /* renamed from: getHeadlineLargeTracking-XSAIIZE  reason: not valid java name */
    public final long m3231getHeadlineLargeTrackingXSAIIZE() {
        return HeadlineLargeTracking;
    }

    public final FontWeight getHeadlineLargeWeight() {
        return HeadlineLargeWeight;
    }

    public final GenericFontFamily getHeadlineMediumFont() {
        return HeadlineMediumFont;
    }

    /* renamed from: getHeadlineMediumLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3232getHeadlineMediumLineHeightXSAIIZE() {
        return HeadlineMediumLineHeight;
    }

    /* renamed from: getHeadlineMediumSize-XSAIIZE  reason: not valid java name */
    public final long m3233getHeadlineMediumSizeXSAIIZE() {
        return HeadlineMediumSize;
    }

    /* renamed from: getHeadlineMediumTracking-XSAIIZE  reason: not valid java name */
    public final long m3234getHeadlineMediumTrackingXSAIIZE() {
        return HeadlineMediumTracking;
    }

    public final FontWeight getHeadlineMediumWeight() {
        return HeadlineMediumWeight;
    }

    public final GenericFontFamily getHeadlineSmallFont() {
        return HeadlineSmallFont;
    }

    /* renamed from: getHeadlineSmallLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3235getHeadlineSmallLineHeightXSAIIZE() {
        return HeadlineSmallLineHeight;
    }

    /* renamed from: getHeadlineSmallSize-XSAIIZE  reason: not valid java name */
    public final long m3236getHeadlineSmallSizeXSAIIZE() {
        return HeadlineSmallSize;
    }

    /* renamed from: getHeadlineSmallTracking-XSAIIZE  reason: not valid java name */
    public final long m3237getHeadlineSmallTrackingXSAIIZE() {
        return HeadlineSmallTracking;
    }

    public final FontWeight getHeadlineSmallWeight() {
        return HeadlineSmallWeight;
    }

    public final GenericFontFamily getLabelLargeFont() {
        return LabelLargeFont;
    }

    /* renamed from: getLabelLargeLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3238getLabelLargeLineHeightXSAIIZE() {
        return LabelLargeLineHeight;
    }

    /* renamed from: getLabelLargeSize-XSAIIZE  reason: not valid java name */
    public final long m3239getLabelLargeSizeXSAIIZE() {
        return LabelLargeSize;
    }

    /* renamed from: getLabelLargeTracking-XSAIIZE  reason: not valid java name */
    public final long m3240getLabelLargeTrackingXSAIIZE() {
        return LabelLargeTracking;
    }

    public final FontWeight getLabelLargeWeight() {
        return LabelLargeWeight;
    }

    public final GenericFontFamily getLabelMediumFont() {
        return LabelMediumFont;
    }

    /* renamed from: getLabelMediumLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3241getLabelMediumLineHeightXSAIIZE() {
        return LabelMediumLineHeight;
    }

    /* renamed from: getLabelMediumSize-XSAIIZE  reason: not valid java name */
    public final long m3242getLabelMediumSizeXSAIIZE() {
        return LabelMediumSize;
    }

    /* renamed from: getLabelMediumTracking-XSAIIZE  reason: not valid java name */
    public final long m3243getLabelMediumTrackingXSAIIZE() {
        return LabelMediumTracking;
    }

    public final FontWeight getLabelMediumWeight() {
        return LabelMediumWeight;
    }

    public final GenericFontFamily getLabelSmallFont() {
        return LabelSmallFont;
    }

    /* renamed from: getLabelSmallLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3244getLabelSmallLineHeightXSAIIZE() {
        return LabelSmallLineHeight;
    }

    /* renamed from: getLabelSmallSize-XSAIIZE  reason: not valid java name */
    public final long m3245getLabelSmallSizeXSAIIZE() {
        return LabelSmallSize;
    }

    /* renamed from: getLabelSmallTracking-XSAIIZE  reason: not valid java name */
    public final long m3246getLabelSmallTrackingXSAIIZE() {
        return LabelSmallTracking;
    }

    public final FontWeight getLabelSmallWeight() {
        return LabelSmallWeight;
    }

    public final GenericFontFamily getTitleLargeFont() {
        return TitleLargeFont;
    }

    /* renamed from: getTitleLargeLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3247getTitleLargeLineHeightXSAIIZE() {
        return TitleLargeLineHeight;
    }

    /* renamed from: getTitleLargeSize-XSAIIZE  reason: not valid java name */
    public final long m3248getTitleLargeSizeXSAIIZE() {
        return TitleLargeSize;
    }

    /* renamed from: getTitleLargeTracking-XSAIIZE  reason: not valid java name */
    public final long m3249getTitleLargeTrackingXSAIIZE() {
        return TitleLargeTracking;
    }

    public final FontWeight getTitleLargeWeight() {
        return TitleLargeWeight;
    }

    public final GenericFontFamily getTitleMediumFont() {
        return TitleMediumFont;
    }

    /* renamed from: getTitleMediumLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3250getTitleMediumLineHeightXSAIIZE() {
        return TitleMediumLineHeight;
    }

    /* renamed from: getTitleMediumSize-XSAIIZE  reason: not valid java name */
    public final long m3251getTitleMediumSizeXSAIIZE() {
        return TitleMediumSize;
    }

    /* renamed from: getTitleMediumTracking-XSAIIZE  reason: not valid java name */
    public final long m3252getTitleMediumTrackingXSAIIZE() {
        return TitleMediumTracking;
    }

    public final FontWeight getTitleMediumWeight() {
        return TitleMediumWeight;
    }

    public final GenericFontFamily getTitleSmallFont() {
        return TitleSmallFont;
    }

    /* renamed from: getTitleSmallLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3253getTitleSmallLineHeightXSAIIZE() {
        return TitleSmallLineHeight;
    }

    /* renamed from: getTitleSmallSize-XSAIIZE  reason: not valid java name */
    public final long m3254getTitleSmallSizeXSAIIZE() {
        return TitleSmallSize;
    }

    /* renamed from: getTitleSmallTracking-XSAIIZE  reason: not valid java name */
    public final long m3255getTitleSmallTrackingXSAIIZE() {
        return TitleSmallTracking;
    }

    public final FontWeight getTitleSmallWeight() {
        return TitleSmallWeight;
    }
}
