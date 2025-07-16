package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.core.view.ViewCompat;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\bU\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 £\u00012\u00020\u0001:\u0002£\u0001B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BÕ\u0001\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010(Bí\u0001\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,¢\u0006\u0002\u0010-B\u0002\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101¢\u0006\u0002\u00102B\u0002\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u00107B\u0002\b\u0016\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020/\u0012\b\b\u0002\u00100\u001a\u000201\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u00108B\u0002\b\u0016\u0012\b\u00109\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010;\u001a\u00020<\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020/\u0012\b\b\u0002\u00100\u001a\u000201\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010=B§\u0002\b\u0017\u0012\b\u00109\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010;\u001a\u00020<\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010>B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010?J«\u0002\u0010\u0001\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00105\u001a\u0004\u0018\u000106ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001Jµ\u0002\u0010\u0001\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J¡\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00105\u001a\u0004\u0018\u000106ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J«\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001Jã\u0001\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001Jû\u0001\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0016\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0000J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0000J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u0010\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J£\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J«\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0005H\u0007J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0003H\u0007J\u0016\u0010\u0001\u001a\u00020\u00002\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007J\u0013\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0005H\u0002J\u0013\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0003H\u0002J\u0013\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0000H\u0002J\t\u0010 \u0001\u001a\u00020\u0005H\u0007J\t\u0010¡\u0001\u001a\u00020\u0003H\u0007J\t\u0010¢\u0001\u001a\u00020\u0014H\u0016R\u0011\u0010;\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0017\u0010\u001c\u001a\u00020\b8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00178Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0017\u0010\u0007\u001a\u00020\b8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bH\u0010CR\"\u0010I\u001a\u0004\u0018\u0001018GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\"\u0010N\u001a\u0004\u0018\u00010/8GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\bO\u0010K\u001a\u0004\bP\u0010QR\"\u0010R\u001a\u0004\u0018\u00010\"8GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\bS\u0010K\u001a\u0004\bT\u0010UR\"\u0010V\u001a\u0004\u0018\u00010$8GX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\bW\u0010K\u001a\u0004\bX\u0010YR\u0013\u00103\u001a\u0004\u0018\u0001048F¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0017\u0010\t\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b`\u0010CR\u0019\u0010\r\u001a\u0004\u0018\u00010\u000e8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00108Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u0017\u00100\u001a\u0002018Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0017\u0010\u0015\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bi\u0010CR\u0017\u0010.\u001a\u00020/8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bj\u0010hR\u0017\u0010%\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bk\u0010CR\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0017\u0010!\u001a\u00020\"8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bx\u0010hR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\by\u0010zR\u0017\u0010#\u001a\u00020$8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b{\u0010hR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0013\u0010&\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\b~\u0010R\u0015\u00105\u001a\u0004\u0018\u0001068F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¤\u0001"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformTextStyle;)V", "getAlpha", "()F", "getBackground-0d7_KjU", "()J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "()V", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getHyphens-vmbZdU8", "()I", "getLetterSpacing-XSAIIZE", "getLineBreak-rAG3T2k", "getLineHeight-XSAIIZE", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getParagraphStyle$ui_text_release", "()Landroidx/compose/ui/text/ParagraphStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getSpanStyle$ui_text_release", "()Landroidx/compose/ui/text/SpanStyle;", "getTextAlign-e0LSkKk", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextDirection-s_7X-co", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "copy", "copy-Ns73l9s", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-aIRg9q4", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-p1EtxEg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-v2rsoow", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "copy-NOaFTUo", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/TextStyle;", "copy-CXVQc50", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/TextStyle;", "equals", "", "other", "hasSameDrawAffectingAttributes", "hasSameLayoutAffectingAttributes", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text_release", "merge", "merge-dA7vx0o", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "merge-Z1GrekI", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "plus", "toParagraphStyle", "toSpanStyle", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextStyle.kt */
public final class TextStyle {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TextStyle Default = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, (int) ViewCompat.MEASURED_SIZE_MASK, (DefaultConstructorMarker) null);
    private final ParagraphStyle paragraphStyle;
    private final PlatformTextStyle platformStyle;
    private final SpanStyle spanStyle;

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, drawStyle, i, i2, j5, textIndent, platformTextStyle, lineHeightStyle, i3, i4, textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, drawStyle, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like TextMotion are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, drawStyle, i, i2, j4, textIndent, platformTextStyle, lineHeightStyle, i3, i4, textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, drawStyle, textAlign, textDirection, j4, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getHyphens-EaSxIns$annotations  reason: not valid java name */
    public static /* synthetic */ void m6057getHyphensEaSxIns$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getLineBreak-LgCVezo$annotations  reason: not valid java name */
    public static /* synthetic */ void m6058getLineBreakLgCVezo$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getTextAlign-buA522U$annotations  reason: not valid java name */
    public static /* synthetic */ void m6059getTextAlignbuA522U$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* renamed from: getTextDirection-mmuk1to$annotations  reason: not valid java name */
    public static /* synthetic */ void m6060getTextDirectionmmuk1to$annotations() {
    }

    public TextStyle(SpanStyle spanStyle2, ParagraphStyle paragraphStyle2, PlatformTextStyle platformTextStyle) {
        this.spanStyle = spanStyle2;
        this.paragraphStyle = paragraphStyle2;
        this.platformStyle = platformTextStyle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextStyle(SpanStyle spanStyle2, ParagraphStyle paragraphStyle2, PlatformTextStyle platformTextStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(spanStyle2, paragraphStyle2, (i & 4) != 0 ? null : platformTextStyle);
    }

    public final SpanStyle getSpanStyle$ui_text_release() {
        return this.spanStyle;
    }

    public final ParagraphStyle getParagraphStyle$ui_text_release() {
        return this.paragraphStyle;
    }

    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public TextStyle(SpanStyle spanStyle2, ParagraphStyle paragraphStyle2) {
        this(spanStyle2, paragraphStyle2, TextStyleKt.createPlatformTextStyleInternal(spanStyle2.getPlatformStyle(), paragraphStyle2.getPlatformStyle()));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r25, long r27, androidx.compose.ui.text.font.FontWeight r29, androidx.compose.ui.text.font.FontStyle r30, androidx.compose.ui.text.font.FontSynthesis r31, androidx.compose.ui.text.font.FontFamily r32, java.lang.String r33, long r34, androidx.compose.ui.text.style.BaselineShift r36, androidx.compose.ui.text.style.TextGeometricTransform r37, androidx.compose.ui.text.intl.LocaleList r38, long r39, androidx.compose.ui.text.style.TextDecoration r41, androidx.compose.ui.graphics.Shadow r42, androidx.compose.ui.text.style.TextAlign r43, androidx.compose.ui.text.style.TextDirection r44, long r45, androidx.compose.ui.text.style.TextIndent r47, int r48, kotlin.jvm.internal.DefaultConstructorMarker r49) {
        /*
            r24 = this;
            r0 = r48
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m3852getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r25
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m6822getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r27
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r29
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r30
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r31
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r32
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r33
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m6822getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r34
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r36
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r37
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r38
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m3852getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r39
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r41
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r42
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r43
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r44
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ab
            androidx.compose.ui.unit.TextUnit$Companion r21 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r21.m6822getUnspecifiedXSAIIZE()
            goto L_0x00ad
        L_0x00ab:
            r21 = r45
        L_0x00ad:
            r23 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r23
            if (r0 == 0) goto L_0x00b5
            r0 = 0
            goto L_0x00b7
        L_0x00b5:
            r0 = r47
        L_0x00b7:
            r23 = 0
            r49 = r23
            r25 = r24
            r26 = r1
            r28 = r3
            r30 = r5
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r10
            r35 = r11
            r37 = r13
            r38 = r14
            r39 = r15
            r40 = r16
            r42 = r18
            r43 = r19
            r44 = r6
            r45 = r20
            r46 = r21
            r48 = r0
            r25.<init>(r26, r28, r30, r31, r32, r33, r34, r35, r37, r38, r39, r40, r42, r43, r44, r45, r46, r48, r49)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r23, long r25, androidx.compose.ui.text.font.FontWeight r27, androidx.compose.ui.text.font.FontStyle r28, androidx.compose.ui.text.font.FontSynthesis r29, androidx.compose.ui.text.font.FontFamily r30, java.lang.String r31, long r32, androidx.compose.ui.text.style.BaselineShift r34, androidx.compose.ui.text.style.TextGeometricTransform r35, androidx.compose.ui.text.intl.LocaleList r36, long r37, androidx.compose.ui.text.style.TextDecoration r39, androidx.compose.ui.graphics.Shadow r40, androidx.compose.ui.text.style.TextAlign r41, androidx.compose.ui.text.style.TextDirection r42, long r43, androidx.compose.ui.text.style.TextIndent r45) {
        /*
            r22 = this;
            r1 = r23
            r3 = r25
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r32
            r12 = r34
            r13 = r35
            r14 = r36
            r15 = r37
            r17 = r39
            r18 = r40
            androidx.compose.ui.text.SpanStyle r0 = new androidx.compose.ui.text.SpanStyle
            r23 = r0
            r20 = 0
            r21 = 0
            r19 = 0
            r0.<init>((long) r1, (long) r3, (androidx.compose.ui.text.font.FontWeight) r5, (androidx.compose.ui.text.font.FontStyle) r6, (androidx.compose.ui.text.font.FontSynthesis) r7, (androidx.compose.ui.text.font.FontFamily) r8, (java.lang.String) r9, (long) r10, (androidx.compose.ui.text.style.BaselineShift) r12, (androidx.compose.ui.text.style.TextGeometricTransform) r13, (androidx.compose.ui.text.intl.LocaleList) r14, (long) r15, (androidx.compose.ui.text.style.TextDecoration) r17, (androidx.compose.ui.graphics.Shadow) r18, (androidx.compose.ui.text.PlatformSpanStyle) r19, (androidx.compose.ui.graphics.drawscope.DrawStyle) r20, (kotlin.jvm.internal.DefaultConstructorMarker) r21)
            androidx.compose.ui.text.ParagraphStyle r0 = new androidx.compose.ui.text.ParagraphStyle
            if (r41 == 0) goto L_0x0032
            int r1 = r41.m6459unboximpl()
            goto L_0x0038
        L_0x0032:
            androidx.compose.ui.text.style.TextAlign$Companion r1 = androidx.compose.ui.text.style.TextAlign.Companion
            int r1 = r1.m6466getUnspecifiede0LSkKk()
        L_0x0038:
            if (r42 == 0) goto L_0x003f
            int r2 = r42.m6473unboximpl()
            goto L_0x0045
        L_0x003f:
            androidx.compose.ui.text.style.TextDirection$Companion r2 = androidx.compose.ui.text.style.TextDirection.Companion
            int r2 = r2.m6479getUnspecifieds_7Xco()
        L_0x0045:
            androidx.compose.ui.text.style.LineBreak$Companion r3 = androidx.compose.ui.text.style.LineBreak.Companion
            int r3 = r3.m6393getUnspecifiedrAG3T2k()
            androidx.compose.ui.text.style.Hyphens$Companion r4 = androidx.compose.ui.text.style.Hyphens.Companion
            int r4 = r4.m6372getUnspecifiedvmbZdU8()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r24 = r0
            r25 = r1
            r26 = r2
            r27 = r43
            r29 = r45
            r30 = r7
            r31 = r8
            r32 = r3
            r33 = r4
            r34 = r5
            r35 = r6
            r24.<init>((int) r25, (int) r26, (long) r27, (androidx.compose.ui.text.style.TextIndent) r29, (androidx.compose.ui.text.PlatformParagraphStyle) r30, (androidx.compose.ui.text.style.LineHeightStyle) r31, (int) r32, (int) r33, (androidx.compose.ui.text.style.TextMotion) r34, (kotlin.jvm.internal.DefaultConstructorMarker) r35)
            r1 = 0
            r2 = r22
            r3 = r23
            r2.<init>(r3, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r27, long r29, androidx.compose.ui.text.font.FontWeight r31, androidx.compose.ui.text.font.FontStyle r32, androidx.compose.ui.text.font.FontSynthesis r33, androidx.compose.ui.text.font.FontFamily r34, java.lang.String r35, long r36, androidx.compose.ui.text.style.BaselineShift r38, androidx.compose.ui.text.style.TextGeometricTransform r39, androidx.compose.ui.text.intl.LocaleList r40, long r41, androidx.compose.ui.text.style.TextDecoration r43, androidx.compose.ui.graphics.Shadow r44, androidx.compose.ui.text.style.TextAlign r45, androidx.compose.ui.text.style.TextDirection r46, long r47, androidx.compose.ui.text.style.TextIndent r49, androidx.compose.ui.text.PlatformTextStyle r50, androidx.compose.ui.text.style.LineHeightStyle r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
        /*
            r26 = this;
            r0 = r52
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m3852getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r27
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m6822getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r29
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r31
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r32
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r33
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r34
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r35
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m6822getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r36
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r38
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r39
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r40
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m3852getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r41
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r43
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r44
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r45
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r46
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ab
            androidx.compose.ui.unit.TextUnit$Companion r21 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r21.m6822getUnspecifiedXSAIIZE()
            goto L_0x00ad
        L_0x00ab:
            r21 = r47
        L_0x00ad:
            r23 = 131072(0x20000, float:1.83671E-40)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00b6
            r23 = 0
            goto L_0x00b8
        L_0x00b6:
            r23 = r49
        L_0x00b8:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c1
            r24 = 0
            goto L_0x00c3
        L_0x00c1:
            r24 = r50
        L_0x00c3:
            r25 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r25
            if (r0 == 0) goto L_0x00cb
            r0 = 0
            goto L_0x00cd
        L_0x00cb:
            r0 = r51
        L_0x00cd:
            r25 = 0
            r53 = r25
            r27 = r26
            r28 = r1
            r30 = r3
            r32 = r5
            r33 = r7
            r34 = r8
            r35 = r9
            r36 = r10
            r37 = r11
            r39 = r13
            r40 = r14
            r41 = r15
            r42 = r16
            r44 = r18
            r45 = r19
            r46 = r6
            r47 = r20
            r48 = r21
            r50 = r23
            r51 = r24
            r52 = r0
            r27.<init>(r28, r30, r32, r33, r34, r35, r36, r37, r39, r40, r41, r42, r44, r45, r46, r47, r48, r50, r51, r52, r53)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r26, long r28, androidx.compose.ui.text.font.FontWeight r30, androidx.compose.ui.text.font.FontStyle r31, androidx.compose.ui.text.font.FontSynthesis r32, androidx.compose.ui.text.font.FontFamily r33, java.lang.String r34, long r35, androidx.compose.ui.text.style.BaselineShift r37, androidx.compose.ui.text.style.TextGeometricTransform r38, androidx.compose.ui.text.intl.LocaleList r39, long r40, androidx.compose.ui.text.style.TextDecoration r42, androidx.compose.ui.graphics.Shadow r43, androidx.compose.ui.text.style.TextAlign r44, androidx.compose.ui.text.style.TextDirection r45, long r46, androidx.compose.ui.text.style.TextIndent r48, androidx.compose.ui.text.PlatformTextStyle r49, androidx.compose.ui.text.style.LineHeightStyle r50) {
        /*
            r25 = this;
            r0 = r49
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r23 = 0
            if (r0 == 0) goto L_0x000f
            androidx.compose.ui.text.PlatformSpanStyle r1 = r49.getSpanStyle()
            r20 = r1
            goto L_0x0011
        L_0x000f:
            r20 = r23
        L_0x0011:
            r21 = 0
            r22 = 0
            r1 = r15
            r2 = r26
            r4 = r28
            r6 = r30
            r7 = r31
            r8 = r32
            r9 = r33
            r10 = r34
            r11 = r35
            r13 = r37
            r14 = r38
            r24 = r15
            r15 = r39
            r16 = r40
            r18 = r42
            r19 = r43
            r1.<init>((long) r2, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r44 == 0) goto L_0x0040
            int r2 = r44.m6459unboximpl()
            goto L_0x0046
        L_0x0040:
            androidx.compose.ui.text.style.TextAlign$Companion r2 = androidx.compose.ui.text.style.TextAlign.Companion
            int r2 = r2.m6466getUnspecifiede0LSkKk()
        L_0x0046:
            if (r45 == 0) goto L_0x004d
            int r3 = r45.m6473unboximpl()
            goto L_0x0053
        L_0x004d:
            androidx.compose.ui.text.style.TextDirection$Companion r3 = androidx.compose.ui.text.style.TextDirection.Companion
            int r3 = r3.m6479getUnspecifieds_7Xco()
        L_0x0053:
            if (r0 == 0) goto L_0x0059
            androidx.compose.ui.text.PlatformParagraphStyle r23 = r49.getParagraphStyle()
        L_0x0059:
            androidx.compose.ui.text.style.LineBreak$Companion r4 = androidx.compose.ui.text.style.LineBreak.Companion
            int r4 = r4.m6393getUnspecifiedrAG3T2k()
            androidx.compose.ui.text.style.Hyphens$Companion r5 = androidx.compose.ui.text.style.Hyphens.Companion
            int r5 = r5.m6372getUnspecifiedvmbZdU8()
            r6 = 0
            r7 = 0
            r26 = r1
            r27 = r2
            r28 = r3
            r29 = r46
            r31 = r48
            r32 = r23
            r33 = r50
            r34 = r4
            r35 = r5
            r36 = r6
            r37 = r7
            r26.<init>((int) r27, (int) r28, (long) r29, (androidx.compose.ui.text.style.TextIndent) r31, (androidx.compose.ui.text.PlatformParagraphStyle) r32, (androidx.compose.ui.text.style.LineHeightStyle) r33, (int) r34, (int) r35, (androidx.compose.ui.text.style.TextMotion) r36, (kotlin.jvm.internal.DefaultConstructorMarker) r37)
            r2 = r25
            r3 = r24
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r29, long r31, androidx.compose.ui.text.font.FontWeight r33, androidx.compose.ui.text.font.FontStyle r34, androidx.compose.ui.text.font.FontSynthesis r35, androidx.compose.ui.text.font.FontFamily r36, java.lang.String r37, long r38, androidx.compose.ui.text.style.BaselineShift r40, androidx.compose.ui.text.style.TextGeometricTransform r41, androidx.compose.ui.text.intl.LocaleList r42, long r43, androidx.compose.ui.text.style.TextDecoration r45, androidx.compose.ui.graphics.Shadow r46, androidx.compose.ui.text.style.TextAlign r47, androidx.compose.ui.text.style.TextDirection r48, long r49, androidx.compose.ui.text.style.TextIndent r51, androidx.compose.ui.text.PlatformTextStyle r52, androidx.compose.ui.text.style.LineHeightStyle r53, androidx.compose.ui.text.style.LineBreak r54, androidx.compose.ui.text.style.Hyphens r55, int r56, kotlin.jvm.internal.DefaultConstructorMarker r57) {
        /*
            r28 = this;
            r0 = r56
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m3852getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r29
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m6822getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r31
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r33
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r34
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r35
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r36
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r37
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m6822getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r38
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r40
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r41
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r42
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m3852getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r43
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r45
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r46
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r47
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r48
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ab
            androidx.compose.ui.unit.TextUnit$Companion r21 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r21.m6822getUnspecifiedXSAIIZE()
            goto L_0x00ad
        L_0x00ab:
            r21 = r49
        L_0x00ad:
            r23 = 131072(0x20000, float:1.83671E-40)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00b6
            r23 = 0
            goto L_0x00b8
        L_0x00b6:
            r23 = r51
        L_0x00b8:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c1
            r24 = 0
            goto L_0x00c3
        L_0x00c1:
            r24 = r52
        L_0x00c3:
            r25 = 524288(0x80000, float:7.34684E-40)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00cc
            r25 = 0
            goto L_0x00ce
        L_0x00cc:
            r25 = r53
        L_0x00ce:
            r26 = 1048576(0x100000, float:1.469368E-39)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00d7
            r26 = 0
            goto L_0x00d9
        L_0x00d7:
            r26 = r54
        L_0x00d9:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r27
            if (r0 == 0) goto L_0x00e1
            r0 = 0
            goto L_0x00e3
        L_0x00e1:
            r0 = r55
        L_0x00e3:
            r27 = 0
            r57 = r27
            r29 = r28
            r30 = r1
            r32 = r3
            r34 = r5
            r35 = r7
            r36 = r8
            r37 = r9
            r38 = r10
            r39 = r11
            r41 = r13
            r42 = r14
            r43 = r15
            r44 = r16
            r46 = r18
            r47 = r19
            r48 = r6
            r49 = r20
            r50 = r21
            r52 = r23
            r53 = r24
            r54 = r25
            r55 = r26
            r56 = r0
            r29.<init>(r30, r32, r34, r35, r36, r37, r38, r39, r41, r42, r43, r44, r46, r47, r48, r49, r50, r52, r53, r54, r55, r56, r57)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r27, long r29, androidx.compose.ui.text.font.FontWeight r31, androidx.compose.ui.text.font.FontStyle r32, androidx.compose.ui.text.font.FontSynthesis r33, androidx.compose.ui.text.font.FontFamily r34, java.lang.String r35, long r36, androidx.compose.ui.text.style.BaselineShift r38, androidx.compose.ui.text.style.TextGeometricTransform r39, androidx.compose.ui.text.intl.LocaleList r40, long r41, androidx.compose.ui.text.style.TextDecoration r43, androidx.compose.ui.graphics.Shadow r44, androidx.compose.ui.text.style.TextAlign r45, androidx.compose.ui.text.style.TextDirection r46, long r47, androidx.compose.ui.text.style.TextIndent r49, androidx.compose.ui.text.PlatformTextStyle r50, androidx.compose.ui.text.style.LineHeightStyle r51, androidx.compose.ui.text.style.LineBreak r52, androidx.compose.ui.text.style.Hyphens r53) {
        /*
            r26 = this;
            r0 = r50
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r24 = 0
            if (r0 == 0) goto L_0x000f
            androidx.compose.ui.text.PlatformSpanStyle r1 = r50.getSpanStyle()
            r20 = r1
            goto L_0x0011
        L_0x000f:
            r20 = r24
        L_0x0011:
            r22 = 32768(0x8000, float:4.5918E-41)
            r23 = 0
            r21 = 0
            r1 = r15
            r2 = r27
            r4 = r29
            r6 = r31
            r7 = r32
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r36
            r13 = r38
            r14 = r39
            r25 = r15
            r15 = r40
            r16 = r41
            r18 = r43
            r19 = r44
            r1.<init>((long) r2, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (int) r22, (kotlin.jvm.internal.DefaultConstructorMarker) r23)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r45 == 0) goto L_0x0043
            int r2 = r45.m6459unboximpl()
            goto L_0x0049
        L_0x0043:
            androidx.compose.ui.text.style.TextAlign$Companion r2 = androidx.compose.ui.text.style.TextAlign.Companion
            int r2 = r2.m6466getUnspecifiede0LSkKk()
        L_0x0049:
            if (r46 == 0) goto L_0x0050
            int r3 = r46.m6473unboximpl()
            goto L_0x0056
        L_0x0050:
            androidx.compose.ui.text.style.TextDirection$Companion r3 = androidx.compose.ui.text.style.TextDirection.Companion
            int r3 = r3.m6479getUnspecifieds_7Xco()
        L_0x0056:
            if (r0 == 0) goto L_0x005c
            androidx.compose.ui.text.PlatformParagraphStyle r24 = r50.getParagraphStyle()
        L_0x005c:
            if (r52 == 0) goto L_0x0063
            int r4 = r52.m6385unboximpl()
            goto L_0x0069
        L_0x0063:
            androidx.compose.ui.text.style.LineBreak$Companion r4 = androidx.compose.ui.text.style.LineBreak.Companion
            int r4 = r4.m6393getUnspecifiedrAG3T2k()
        L_0x0069:
            if (r53 == 0) goto L_0x0070
            int r5 = r53.m6369unboximpl()
            goto L_0x0076
        L_0x0070:
            androidx.compose.ui.text.style.Hyphens$Companion r5 = androidx.compose.ui.text.style.Hyphens.Companion
            int r5 = r5.m6372getUnspecifiedvmbZdU8()
        L_0x0076:
            r6 = 256(0x100, float:3.59E-43)
            r7 = 0
            r8 = 0
            r27 = r1
            r28 = r2
            r29 = r3
            r30 = r47
            r32 = r49
            r33 = r24
            r34 = r51
            r35 = r4
            r36 = r5
            r37 = r8
            r38 = r6
            r39 = r7
            r27.<init>((int) r28, (int) r29, (long) r30, (androidx.compose.ui.text.style.TextIndent) r32, (androidx.compose.ui.text.PlatformParagraphStyle) r33, (androidx.compose.ui.text.style.LineHeightStyle) r34, (int) r35, (int) r36, (androidx.compose.ui.text.style.TextMotion) r37, (int) r38, (kotlin.jvm.internal.DefaultConstructorMarker) r39)
            r2 = r26
            r3 = r25
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r31, long r33, androidx.compose.ui.text.font.FontWeight r35, androidx.compose.ui.text.font.FontStyle r36, androidx.compose.ui.text.font.FontSynthesis r37, androidx.compose.ui.text.font.FontFamily r38, java.lang.String r39, long r40, androidx.compose.ui.text.style.BaselineShift r42, androidx.compose.ui.text.style.TextGeometricTransform r43, androidx.compose.ui.text.intl.LocaleList r44, long r45, androidx.compose.ui.text.style.TextDecoration r47, androidx.compose.ui.graphics.Shadow r48, androidx.compose.ui.graphics.drawscope.DrawStyle r49, androidx.compose.ui.text.style.TextAlign r50, androidx.compose.ui.text.style.TextDirection r51, long r52, androidx.compose.ui.text.style.TextIndent r54, androidx.compose.ui.text.PlatformTextStyle r55, androidx.compose.ui.text.style.LineHeightStyle r56, androidx.compose.ui.text.style.LineBreak r57, androidx.compose.ui.text.style.Hyphens r58, androidx.compose.ui.text.style.TextMotion r59, int r60, kotlin.jvm.internal.DefaultConstructorMarker r61) {
        /*
            r30 = this;
            r0 = r60
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m3852getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r31
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m6822getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r33
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r35
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r36
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r37
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r38
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r39
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m6822getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r40
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r42
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r43
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r44
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m3852getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r45
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r47
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r48
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r49
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r50
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00a7
            r21 = 0
            goto L_0x00a9
        L_0x00a7:
            r21 = r51
        L_0x00a9:
            r22 = 131072(0x20000, float:1.83671E-40)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00b6
            androidx.compose.ui.unit.TextUnit$Companion r22 = androidx.compose.ui.unit.TextUnit.Companion
            long r22 = r22.m6822getUnspecifiedXSAIIZE()
            goto L_0x00b8
        L_0x00b6:
            r22 = r52
        L_0x00b8:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c1
            r24 = 0
            goto L_0x00c3
        L_0x00c1:
            r24 = r54
        L_0x00c3:
            r25 = 524288(0x80000, float:7.34684E-40)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00cc
            r25 = 0
            goto L_0x00ce
        L_0x00cc:
            r25 = r55
        L_0x00ce:
            r26 = 1048576(0x100000, float:1.469368E-39)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00d7
            r26 = 0
            goto L_0x00d9
        L_0x00d7:
            r26 = r56
        L_0x00d9:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00e2
            r27 = 0
            goto L_0x00e4
        L_0x00e2:
            r27 = r57
        L_0x00e4:
            r28 = 4194304(0x400000, float:5.877472E-39)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00ed
            r28 = 0
            goto L_0x00ef
        L_0x00ed:
            r28 = r58
        L_0x00ef:
            r29 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r29
            if (r0 == 0) goto L_0x00f7
            r0 = 0
            goto L_0x00f9
        L_0x00f7:
            r0 = r59
        L_0x00f9:
            r29 = 0
            r61 = r29
            r31 = r30
            r32 = r1
            r34 = r3
            r36 = r5
            r37 = r7
            r38 = r8
            r39 = r9
            r40 = r10
            r41 = r11
            r43 = r13
            r44 = r14
            r45 = r15
            r46 = r16
            r48 = r18
            r49 = r19
            r50 = r6
            r51 = r20
            r52 = r21
            r53 = r22
            r55 = r24
            r56 = r25
            r57 = r26
            r58 = r27
            r59 = r28
            r60 = r0
            r31.<init>((long) r32, (long) r34, (androidx.compose.ui.text.font.FontWeight) r36, (androidx.compose.ui.text.font.FontStyle) r37, (androidx.compose.ui.text.font.FontSynthesis) r38, (androidx.compose.ui.text.font.FontFamily) r39, (java.lang.String) r40, (long) r41, (androidx.compose.ui.text.style.BaselineShift) r43, (androidx.compose.ui.text.style.TextGeometricTransform) r44, (androidx.compose.ui.text.intl.LocaleList) r45, (long) r46, (androidx.compose.ui.text.style.TextDecoration) r48, (androidx.compose.ui.graphics.Shadow) r49, (androidx.compose.ui.graphics.drawscope.DrawStyle) r50, (androidx.compose.ui.text.style.TextAlign) r51, (androidx.compose.ui.text.style.TextDirection) r52, (long) r53, (androidx.compose.ui.text.style.TextIndent) r55, (androidx.compose.ui.text.PlatformTextStyle) r56, (androidx.compose.ui.text.style.LineHeightStyle) r57, (androidx.compose.ui.text.style.LineBreak) r58, (androidx.compose.ui.text.style.Hyphens) r59, (androidx.compose.ui.text.style.TextMotion) r60, (kotlin.jvm.internal.DefaultConstructorMarker) r61)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r26, long r28, androidx.compose.ui.text.font.FontWeight r30, androidx.compose.ui.text.font.FontStyle r31, androidx.compose.ui.text.font.FontSynthesis r32, androidx.compose.ui.text.font.FontFamily r33, java.lang.String r34, long r35, androidx.compose.ui.text.style.BaselineShift r37, androidx.compose.ui.text.style.TextGeometricTransform r38, androidx.compose.ui.text.intl.LocaleList r39, long r40, androidx.compose.ui.text.style.TextDecoration r42, androidx.compose.ui.graphics.Shadow r43, androidx.compose.ui.graphics.drawscope.DrawStyle r44, androidx.compose.ui.text.style.TextAlign r45, androidx.compose.ui.text.style.TextDirection r46, long r47, androidx.compose.ui.text.style.TextIndent r49, androidx.compose.ui.text.PlatformTextStyle r50, androidx.compose.ui.text.style.LineHeightStyle r51, androidx.compose.ui.text.style.LineBreak r52, androidx.compose.ui.text.style.Hyphens r53, androidx.compose.ui.text.style.TextMotion r54) {
        /*
            r25 = this;
            r0 = r50
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r23 = 0
            if (r0 == 0) goto L_0x000f
            androidx.compose.ui.text.PlatformSpanStyle r1 = r50.getSpanStyle()
            r20 = r1
            goto L_0x0011
        L_0x000f:
            r20 = r23
        L_0x0011:
            r22 = 0
            r1 = r15
            r2 = r26
            r4 = r28
            r6 = r30
            r7 = r31
            r8 = r32
            r9 = r33
            r10 = r34
            r11 = r35
            r13 = r37
            r14 = r38
            r24 = r15
            r15 = r39
            r16 = r40
            r18 = r42
            r19 = r43
            r21 = r44
            r1.<init>((long) r2, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r45 == 0) goto L_0x0040
            int r2 = r45.m6459unboximpl()
            goto L_0x0046
        L_0x0040:
            androidx.compose.ui.text.style.TextAlign$Companion r2 = androidx.compose.ui.text.style.TextAlign.Companion
            int r2 = r2.m6466getUnspecifiede0LSkKk()
        L_0x0046:
            if (r46 == 0) goto L_0x004d
            int r3 = r46.m6473unboximpl()
            goto L_0x0053
        L_0x004d:
            androidx.compose.ui.text.style.TextDirection$Companion r3 = androidx.compose.ui.text.style.TextDirection.Companion
            int r3 = r3.m6479getUnspecifieds_7Xco()
        L_0x0053:
            if (r0 == 0) goto L_0x0059
            androidx.compose.ui.text.PlatformParagraphStyle r23 = r50.getParagraphStyle()
        L_0x0059:
            if (r52 == 0) goto L_0x0060
            int r4 = r52.m6385unboximpl()
            goto L_0x0066
        L_0x0060:
            androidx.compose.ui.text.style.LineBreak$Companion r4 = androidx.compose.ui.text.style.LineBreak.Companion
            int r4 = r4.m6393getUnspecifiedrAG3T2k()
        L_0x0066:
            if (r53 == 0) goto L_0x006d
            int r5 = r53.m6369unboximpl()
            goto L_0x0073
        L_0x006d:
            androidx.compose.ui.text.style.Hyphens$Companion r5 = androidx.compose.ui.text.style.Hyphens.Companion
            int r5 = r5.m6372getUnspecifiedvmbZdU8()
        L_0x0073:
            r6 = 0
            r26 = r1
            r27 = r2
            r28 = r3
            r29 = r47
            r31 = r49
            r32 = r23
            r33 = r51
            r34 = r4
            r35 = r5
            r36 = r54
            r37 = r6
            r26.<init>((int) r27, (int) r28, (long) r29, (androidx.compose.ui.text.style.TextIndent) r31, (androidx.compose.ui.text.PlatformParagraphStyle) r32, (androidx.compose.ui.text.style.LineHeightStyle) r33, (int) r34, (int) r35, (androidx.compose.ui.text.style.TextMotion) r36, (kotlin.jvm.internal.DefaultConstructorMarker) r37)
            r2 = r25
            r3 = r24
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r31, long r33, androidx.compose.ui.text.font.FontWeight r35, androidx.compose.ui.text.font.FontStyle r36, androidx.compose.ui.text.font.FontSynthesis r37, androidx.compose.ui.text.font.FontFamily r38, java.lang.String r39, long r40, androidx.compose.ui.text.style.BaselineShift r42, androidx.compose.ui.text.style.TextGeometricTransform r43, androidx.compose.ui.text.intl.LocaleList r44, long r45, androidx.compose.ui.text.style.TextDecoration r47, androidx.compose.ui.graphics.Shadow r48, androidx.compose.ui.graphics.drawscope.DrawStyle r49, int r50, int r51, long r52, androidx.compose.ui.text.style.TextIndent r54, androidx.compose.ui.text.PlatformTextStyle r55, androidx.compose.ui.text.style.LineHeightStyle r56, int r57, int r58, androidx.compose.ui.text.style.TextMotion r59, int r60, kotlin.jvm.internal.DefaultConstructorMarker r61) {
        /*
            r30 = this;
            r0 = r60
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m3852getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r31
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m6822getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r33
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r35
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r36
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r37
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r38
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r39
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m6822getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r40
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r42
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r43
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r44
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m3852getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r45
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r47
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r48
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r49
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00a0
            androidx.compose.ui.text.style.TextAlign$Companion r20 = androidx.compose.ui.text.style.TextAlign.Companion
            int r20 = r20.m6466getUnspecifiede0LSkKk()
            goto L_0x00a2
        L_0x00a0:
            r20 = r50
        L_0x00a2:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00af
            androidx.compose.ui.text.style.TextDirection$Companion r21 = androidx.compose.ui.text.style.TextDirection.Companion
            int r21 = r21.m6479getUnspecifieds_7Xco()
            goto L_0x00b1
        L_0x00af:
            r21 = r51
        L_0x00b1:
            r22 = 131072(0x20000, float:1.83671E-40)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00be
            androidx.compose.ui.unit.TextUnit$Companion r22 = androidx.compose.ui.unit.TextUnit.Companion
            long r22 = r22.m6822getUnspecifiedXSAIIZE()
            goto L_0x00c0
        L_0x00be:
            r22 = r52
        L_0x00c0:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c9
            r24 = 0
            goto L_0x00cb
        L_0x00c9:
            r24 = r54
        L_0x00cb:
            r25 = 524288(0x80000, float:7.34684E-40)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00d4
            r25 = 0
            goto L_0x00d6
        L_0x00d4:
            r25 = r55
        L_0x00d6:
            r26 = 1048576(0x100000, float:1.469368E-39)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00df
            r26 = 0
            goto L_0x00e1
        L_0x00df:
            r26 = r56
        L_0x00e1:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00ee
            androidx.compose.ui.text.style.LineBreak$Companion r27 = androidx.compose.ui.text.style.LineBreak.Companion
            int r27 = r27.m6393getUnspecifiedrAG3T2k()
            goto L_0x00f0
        L_0x00ee:
            r27 = r57
        L_0x00f0:
            r28 = 4194304(0x400000, float:5.877472E-39)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00fd
            androidx.compose.ui.text.style.Hyphens$Companion r28 = androidx.compose.ui.text.style.Hyphens.Companion
            int r28 = r28.m6372getUnspecifiedvmbZdU8()
            goto L_0x00ff
        L_0x00fd:
            r28 = r58
        L_0x00ff:
            r29 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r29
            if (r0 == 0) goto L_0x0107
            r0 = 0
            goto L_0x0109
        L_0x0107:
            r0 = r59
        L_0x0109:
            r29 = 0
            r61 = r29
            r31 = r30
            r32 = r1
            r34 = r3
            r36 = r5
            r37 = r7
            r38 = r8
            r39 = r9
            r40 = r10
            r41 = r11
            r43 = r13
            r44 = r14
            r45 = r15
            r46 = r16
            r48 = r18
            r49 = r19
            r50 = r6
            r51 = r20
            r52 = r21
            r53 = r22
            r55 = r24
            r56 = r25
            r57 = r26
            r58 = r27
            r59 = r28
            r60 = r0
            r31.<init>((long) r32, (long) r34, (androidx.compose.ui.text.font.FontWeight) r36, (androidx.compose.ui.text.font.FontStyle) r37, (androidx.compose.ui.text.font.FontSynthesis) r38, (androidx.compose.ui.text.font.FontFamily) r39, (java.lang.String) r40, (long) r41, (androidx.compose.ui.text.style.BaselineShift) r43, (androidx.compose.ui.text.style.TextGeometricTransform) r44, (androidx.compose.ui.text.intl.LocaleList) r45, (long) r46, (androidx.compose.ui.text.style.TextDecoration) r48, (androidx.compose.ui.graphics.Shadow) r49, (androidx.compose.ui.graphics.drawscope.DrawStyle) r50, (int) r51, (int) r52, (long) r53, (androidx.compose.ui.text.style.TextIndent) r55, (androidx.compose.ui.text.PlatformTextStyle) r56, (androidx.compose.ui.text.style.LineHeightStyle) r57, (int) r58, (int) r59, (androidx.compose.ui.text.style.TextMotion) r60, (kotlin.jvm.internal.DefaultConstructorMarker) r61)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, int, int, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, int, int, androidx.compose.ui.text.style.TextMotion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r26, long r28, androidx.compose.ui.text.font.FontWeight r30, androidx.compose.ui.text.font.FontStyle r31, androidx.compose.ui.text.font.FontSynthesis r32, androidx.compose.ui.text.font.FontFamily r33, java.lang.String r34, long r35, androidx.compose.ui.text.style.BaselineShift r37, androidx.compose.ui.text.style.TextGeometricTransform r38, androidx.compose.ui.text.intl.LocaleList r39, long r40, androidx.compose.ui.text.style.TextDecoration r42, androidx.compose.ui.graphics.Shadow r43, androidx.compose.ui.graphics.drawscope.DrawStyle r44, int r45, int r46, long r47, androidx.compose.ui.text.style.TextIndent r49, androidx.compose.ui.text.PlatformTextStyle r50, androidx.compose.ui.text.style.LineHeightStyle r51, int r52, int r53, androidx.compose.ui.text.style.TextMotion r54) {
        /*
            r25 = this;
            r0 = r50
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r23 = 0
            if (r0 == 0) goto L_0x000f
            androidx.compose.ui.text.PlatformSpanStyle r1 = r50.getSpanStyle()
            r20 = r1
            goto L_0x0011
        L_0x000f:
            r20 = r23
        L_0x0011:
            r22 = 0
            r1 = r15
            r2 = r26
            r4 = r28
            r6 = r30
            r7 = r31
            r8 = r32
            r9 = r33
            r10 = r34
            r11 = r35
            r13 = r37
            r14 = r38
            r24 = r15
            r15 = r39
            r16 = r40
            r18 = r42
            r19 = r43
            r21 = r44
            r1.<init>((long) r2, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r0 == 0) goto L_0x003f
            androidx.compose.ui.text.PlatformParagraphStyle r23 = r50.getParagraphStyle()
        L_0x003f:
            r2 = 0
            r26 = r1
            r27 = r45
            r28 = r46
            r29 = r47
            r31 = r49
            r32 = r23
            r33 = r51
            r34 = r52
            r35 = r53
            r36 = r54
            r37 = r2
            r26.<init>((int) r27, (int) r28, (long) r29, (androidx.compose.ui.text.style.TextIndent) r31, (androidx.compose.ui.text.PlatformParagraphStyle) r32, (androidx.compose.ui.text.style.LineHeightStyle) r33, (int) r34, (int) r35, (androidx.compose.ui.text.style.TextMotion) r36, (kotlin.jvm.internal.DefaultConstructorMarker) r37)
            r2 = r25
            r3 = r24
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, int, int, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, int, int, androidx.compose.ui.text.style.TextMotion):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(androidx.compose.ui.graphics.Brush r34, float r35, long r36, androidx.compose.ui.text.font.FontWeight r38, androidx.compose.ui.text.font.FontStyle r39, androidx.compose.ui.text.font.FontSynthesis r40, androidx.compose.ui.text.font.FontFamily r41, java.lang.String r42, long r43, androidx.compose.ui.text.style.BaselineShift r45, androidx.compose.ui.text.style.TextGeometricTransform r46, androidx.compose.ui.text.intl.LocaleList r47, long r48, androidx.compose.ui.text.style.TextDecoration r50, androidx.compose.ui.graphics.Shadow r51, androidx.compose.ui.graphics.drawscope.DrawStyle r52, int r53, int r54, long r55, androidx.compose.ui.text.style.TextIndent r57, androidx.compose.ui.text.PlatformTextStyle r58, androidx.compose.ui.text.style.LineHeightStyle r59, int r60, int r61, androidx.compose.ui.text.style.TextMotion r62, int r63, kotlin.jvm.internal.DefaultConstructorMarker r64) {
        /*
            r33 = this;
            r0 = r63
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            r1 = 2143289344(0x7fc00000, float:NaN)
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r35
        L_0x000c:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0018
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m6822getUnspecifiedXSAIIZE()
            r5 = r1
            goto L_0x001a
        L_0x0018:
            r5 = r36
        L_0x001a:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r38
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r39
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r40
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r41
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r42
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004e
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r12 = r1.m6822getUnspecifiedXSAIIZE()
            goto L_0x0050
        L_0x004e:
            r12 = r43
        L_0x0050:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0056
            r14 = r2
            goto L_0x0058
        L_0x0056:
            r14 = r45
        L_0x0058:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005e
            r15 = r2
            goto L_0x0060
        L_0x005e:
            r15 = r46
        L_0x0060:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0067
            r16 = r2
            goto L_0x0069
        L_0x0067:
            r16 = r47
        L_0x0069:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r1.m3852getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r17 = r48
        L_0x0076:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007d
            r19 = r2
            goto L_0x007f
        L_0x007d:
            r19 = r50
        L_0x007f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0086
            r20 = r2
            goto L_0x0088
        L_0x0086:
            r20 = r51
        L_0x0088:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0091
            r21 = r2
            goto L_0x0093
        L_0x0091:
            r21 = r52
        L_0x0093:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a1
            androidx.compose.ui.text.style.TextAlign$Companion r1 = androidx.compose.ui.text.style.TextAlign.Companion
            int r1 = r1.m6466getUnspecifiede0LSkKk()
            r22 = r1
            goto L_0x00a3
        L_0x00a1:
            r22 = r53
        L_0x00a3:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b1
            androidx.compose.ui.text.style.TextDirection$Companion r1 = androidx.compose.ui.text.style.TextDirection.Companion
            int r1 = r1.m6479getUnspecifieds_7Xco()
            r23 = r1
            goto L_0x00b3
        L_0x00b1:
            r23 = r54
        L_0x00b3:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00bf
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r24 = r1.m6822getUnspecifiedXSAIIZE()
            goto L_0x00c1
        L_0x00bf:
            r24 = r55
        L_0x00c1:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c9
            r26 = r2
            goto L_0x00cb
        L_0x00c9:
            r26 = r57
        L_0x00cb:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d3
            r27 = r2
            goto L_0x00d5
        L_0x00d3:
            r27 = r58
        L_0x00d5:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00dd
            r28 = r2
            goto L_0x00df
        L_0x00dd:
            r28 = r59
        L_0x00df:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ed
            androidx.compose.ui.text.style.LineBreak$Companion r1 = androidx.compose.ui.text.style.LineBreak.Companion
            int r1 = r1.m6393getUnspecifiedrAG3T2k()
            r29 = r1
            goto L_0x00ef
        L_0x00ed:
            r29 = r60
        L_0x00ef:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00fd
            androidx.compose.ui.text.style.Hyphens$Companion r1 = androidx.compose.ui.text.style.Hyphens.Companion
            int r1 = r1.m6372getUnspecifiedvmbZdU8()
            r30 = r1
            goto L_0x00ff
        L_0x00fd:
            r30 = r61
        L_0x00ff:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0107
            r31 = r2
            goto L_0x0109
        L_0x0107:
            r31 = r62
        L_0x0109:
            r32 = 0
            r2 = r33
            r3 = r34
            r2.<init>((androidx.compose.ui.graphics.Brush) r3, (float) r4, (long) r5, (androidx.compose.ui.text.font.FontWeight) r7, (androidx.compose.ui.text.font.FontStyle) r8, (androidx.compose.ui.text.font.FontSynthesis) r9, (androidx.compose.ui.text.font.FontFamily) r10, (java.lang.String) r11, (long) r12, (androidx.compose.ui.text.style.BaselineShift) r14, (androidx.compose.ui.text.style.TextGeometricTransform) r15, (androidx.compose.ui.text.intl.LocaleList) r16, (long) r17, (androidx.compose.ui.text.style.TextDecoration) r19, (androidx.compose.ui.graphics.Shadow) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (int) r22, (int) r23, (long) r24, (androidx.compose.ui.text.style.TextIndent) r26, (androidx.compose.ui.text.PlatformTextStyle) r27, (androidx.compose.ui.text.style.LineHeightStyle) r28, (int) r29, (int) r30, (androidx.compose.ui.text.style.TextMotion) r31, (kotlin.jvm.internal.DefaultConstructorMarker) r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, int, int, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, int, int, androidx.compose.ui.text.style.TextMotion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(androidx.compose.ui.graphics.Brush r26, float r27, long r28, androidx.compose.ui.text.font.FontWeight r30, androidx.compose.ui.text.font.FontStyle r31, androidx.compose.ui.text.font.FontSynthesis r32, androidx.compose.ui.text.font.FontFamily r33, java.lang.String r34, long r35, androidx.compose.ui.text.style.BaselineShift r37, androidx.compose.ui.text.style.TextGeometricTransform r38, androidx.compose.ui.text.intl.LocaleList r39, long r40, androidx.compose.ui.text.style.TextDecoration r42, androidx.compose.ui.graphics.Shadow r43, androidx.compose.ui.graphics.drawscope.DrawStyle r44, int r45, int r46, long r47, androidx.compose.ui.text.style.TextIndent r49, androidx.compose.ui.text.PlatformTextStyle r50, androidx.compose.ui.text.style.LineHeightStyle r51, int r52, int r53, androidx.compose.ui.text.style.TextMotion r54) {
        /*
            r25 = this;
            r0 = r50
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r23 = 0
            if (r0 == 0) goto L_0x000f
            androidx.compose.ui.text.PlatformSpanStyle r1 = r50.getSpanStyle()
            r20 = r1
            goto L_0x0011
        L_0x000f:
            r20 = r23
        L_0x0011:
            r22 = 0
            r1 = r15
            r2 = r26
            r3 = r27
            r4 = r28
            r6 = r30
            r7 = r31
            r8 = r32
            r9 = r33
            r10 = r34
            r11 = r35
            r13 = r37
            r14 = r38
            r24 = r15
            r15 = r39
            r16 = r40
            r18 = r42
            r19 = r43
            r21 = r44
            r1.<init>((androidx.compose.ui.graphics.Brush) r2, (float) r3, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r0 == 0) goto L_0x0041
            androidx.compose.ui.text.PlatformParagraphStyle r23 = r50.getParagraphStyle()
        L_0x0041:
            r2 = 0
            r26 = r1
            r27 = r45
            r28 = r46
            r29 = r47
            r31 = r49
            r32 = r23
            r33 = r51
            r34 = r52
            r35 = r53
            r36 = r54
            r37 = r2
            r26.<init>((int) r27, (int) r28, (long) r29, (androidx.compose.ui.text.style.TextIndent) r31, (androidx.compose.ui.text.PlatformParagraphStyle) r32, (androidx.compose.ui.text.style.LineHeightStyle) r33, (int) r34, (int) r35, (androidx.compose.ui.text.style.TextMotion) r36, (kotlin.jvm.internal.DefaultConstructorMarker) r37)
            r2 = r25
            r3 = r24
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, int, int, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, int, int, androidx.compose.ui.text.style.TextMotion):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(androidx.compose.ui.graphics.Brush r34, float r35, long r36, androidx.compose.ui.text.font.FontWeight r38, androidx.compose.ui.text.font.FontStyle r39, androidx.compose.ui.text.font.FontSynthesis r40, androidx.compose.ui.text.font.FontFamily r41, java.lang.String r42, long r43, androidx.compose.ui.text.style.BaselineShift r45, androidx.compose.ui.text.style.TextGeometricTransform r46, androidx.compose.ui.text.intl.LocaleList r47, long r48, androidx.compose.ui.text.style.TextDecoration r50, androidx.compose.ui.graphics.Shadow r51, androidx.compose.ui.graphics.drawscope.DrawStyle r52, androidx.compose.ui.text.style.TextAlign r53, androidx.compose.ui.text.style.TextDirection r54, long r55, androidx.compose.ui.text.style.TextIndent r57, androidx.compose.ui.text.PlatformTextStyle r58, androidx.compose.ui.text.style.LineHeightStyle r59, androidx.compose.ui.text.style.LineBreak r60, androidx.compose.ui.text.style.Hyphens r61, androidx.compose.ui.text.style.TextMotion r62, int r63, kotlin.jvm.internal.DefaultConstructorMarker r64) {
        /*
            r33 = this;
            r0 = r63
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            r1 = 2143289344(0x7fc00000, float:NaN)
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r35
        L_0x000c:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0018
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m6822getUnspecifiedXSAIIZE()
            r5 = r1
            goto L_0x001a
        L_0x0018:
            r5 = r36
        L_0x001a:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r38
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r39
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r40
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r41
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r42
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004e
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r12 = r1.m6822getUnspecifiedXSAIIZE()
            goto L_0x0050
        L_0x004e:
            r12 = r43
        L_0x0050:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0056
            r14 = r2
            goto L_0x0058
        L_0x0056:
            r14 = r45
        L_0x0058:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005e
            r15 = r2
            goto L_0x0060
        L_0x005e:
            r15 = r46
        L_0x0060:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0067
            r16 = r2
            goto L_0x0069
        L_0x0067:
            r16 = r47
        L_0x0069:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r1.m3852getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r17 = r48
        L_0x0076:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007d
            r19 = r2
            goto L_0x007f
        L_0x007d:
            r19 = r50
        L_0x007f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0086
            r20 = r2
            goto L_0x0088
        L_0x0086:
            r20 = r51
        L_0x0088:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0091
            r21 = r2
            goto L_0x0093
        L_0x0091:
            r21 = r52
        L_0x0093:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009b
            r22 = r2
            goto L_0x009d
        L_0x009b:
            r22 = r53
        L_0x009d:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a5
            r23 = r2
            goto L_0x00a7
        L_0x00a5:
            r23 = r54
        L_0x00a7:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b3
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r24 = r1.m6822getUnspecifiedXSAIIZE()
            goto L_0x00b5
        L_0x00b3:
            r24 = r55
        L_0x00b5:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00bd
            r26 = r2
            goto L_0x00bf
        L_0x00bd:
            r26 = r57
        L_0x00bf:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c7
            r27 = r2
            goto L_0x00c9
        L_0x00c7:
            r27 = r58
        L_0x00c9:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d1
            r28 = r2
            goto L_0x00d3
        L_0x00d1:
            r28 = r59
        L_0x00d3:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00db
            r29 = r2
            goto L_0x00dd
        L_0x00db:
            r29 = r60
        L_0x00dd:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00e5
            r30 = r2
            goto L_0x00e7
        L_0x00e5:
            r30 = r61
        L_0x00e7:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00ef
            r31 = r2
            goto L_0x00f1
        L_0x00ef:
            r31 = r62
        L_0x00f1:
            r32 = 0
            r2 = r33
            r3 = r34
            r2.<init>((androidx.compose.ui.graphics.Brush) r3, (float) r4, (long) r5, (androidx.compose.ui.text.font.FontWeight) r7, (androidx.compose.ui.text.font.FontStyle) r8, (androidx.compose.ui.text.font.FontSynthesis) r9, (androidx.compose.ui.text.font.FontFamily) r10, (java.lang.String) r11, (long) r12, (androidx.compose.ui.text.style.BaselineShift) r14, (androidx.compose.ui.text.style.TextGeometricTransform) r15, (androidx.compose.ui.text.intl.LocaleList) r16, (long) r17, (androidx.compose.ui.text.style.TextDecoration) r19, (androidx.compose.ui.graphics.Shadow) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (androidx.compose.ui.text.style.TextAlign) r22, (androidx.compose.ui.text.style.TextDirection) r23, (long) r24, (androidx.compose.ui.text.style.TextIndent) r26, (androidx.compose.ui.text.PlatformTextStyle) r27, (androidx.compose.ui.text.style.LineHeightStyle) r28, (androidx.compose.ui.text.style.LineBreak) r29, (androidx.compose.ui.text.style.Hyphens) r30, (androidx.compose.ui.text.style.TextMotion) r31, (kotlin.jvm.internal.DefaultConstructorMarker) r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(androidx.compose.ui.graphics.Brush r26, float r27, long r28, androidx.compose.ui.text.font.FontWeight r30, androidx.compose.ui.text.font.FontStyle r31, androidx.compose.ui.text.font.FontSynthesis r32, androidx.compose.ui.text.font.FontFamily r33, java.lang.String r34, long r35, androidx.compose.ui.text.style.BaselineShift r37, androidx.compose.ui.text.style.TextGeometricTransform r38, androidx.compose.ui.text.intl.LocaleList r39, long r40, androidx.compose.ui.text.style.TextDecoration r42, androidx.compose.ui.graphics.Shadow r43, androidx.compose.ui.graphics.drawscope.DrawStyle r44, androidx.compose.ui.text.style.TextAlign r45, androidx.compose.ui.text.style.TextDirection r46, long r47, androidx.compose.ui.text.style.TextIndent r49, androidx.compose.ui.text.PlatformTextStyle r50, androidx.compose.ui.text.style.LineHeightStyle r51, androidx.compose.ui.text.style.LineBreak r52, androidx.compose.ui.text.style.Hyphens r53, androidx.compose.ui.text.style.TextMotion r54) {
        /*
            r25 = this;
            r0 = r50
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r23 = 0
            if (r0 == 0) goto L_0x000f
            androidx.compose.ui.text.PlatformSpanStyle r1 = r50.getSpanStyle()
            r20 = r1
            goto L_0x0011
        L_0x000f:
            r20 = r23
        L_0x0011:
            r22 = 0
            r1 = r15
            r2 = r26
            r3 = r27
            r4 = r28
            r6 = r30
            r7 = r31
            r8 = r32
            r9 = r33
            r10 = r34
            r11 = r35
            r13 = r37
            r14 = r38
            r24 = r15
            r15 = r39
            r16 = r40
            r18 = r42
            r19 = r43
            r21 = r44
            r1.<init>((androidx.compose.ui.graphics.Brush) r2, (float) r3, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (androidx.compose.ui.graphics.drawscope.DrawStyle) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r45 == 0) goto L_0x0042
            int r2 = r45.m6459unboximpl()
            goto L_0x0048
        L_0x0042:
            androidx.compose.ui.text.style.TextAlign$Companion r2 = androidx.compose.ui.text.style.TextAlign.Companion
            int r2 = r2.m6466getUnspecifiede0LSkKk()
        L_0x0048:
            if (r46 == 0) goto L_0x004f
            int r3 = r46.m6473unboximpl()
            goto L_0x0055
        L_0x004f:
            androidx.compose.ui.text.style.TextDirection$Companion r3 = androidx.compose.ui.text.style.TextDirection.Companion
            int r3 = r3.m6479getUnspecifieds_7Xco()
        L_0x0055:
            if (r0 == 0) goto L_0x005b
            androidx.compose.ui.text.PlatformParagraphStyle r23 = r50.getParagraphStyle()
        L_0x005b:
            if (r52 == 0) goto L_0x0062
            int r4 = r52.m6385unboximpl()
            goto L_0x0068
        L_0x0062:
            androidx.compose.ui.text.style.LineBreak$Companion r4 = androidx.compose.ui.text.style.LineBreak.Companion
            int r4 = r4.m6393getUnspecifiedrAG3T2k()
        L_0x0068:
            if (r53 == 0) goto L_0x006f
            int r5 = r53.m6369unboximpl()
            goto L_0x0075
        L_0x006f:
            androidx.compose.ui.text.style.Hyphens$Companion r5 = androidx.compose.ui.text.style.Hyphens.Companion
            int r5 = r5.m6372getUnspecifiedvmbZdU8()
        L_0x0075:
            r6 = 0
            r26 = r1
            r27 = r2
            r28 = r3
            r29 = r47
            r31 = r49
            r32 = r23
            r33 = r51
            r34 = r4
            r35 = r5
            r36 = r54
            r37 = r6
            r26.<init>((int) r27, (int) r28, (long) r29, (androidx.compose.ui.text.style.TextIndent) r31, (androidx.compose.ui.text.PlatformParagraphStyle) r32, (androidx.compose.ui.text.style.LineHeightStyle) r33, (int) r34, (int) r35, (androidx.compose.ui.text.style.TextMotion) r36, (kotlin.jvm.internal.DefaultConstructorMarker) r37)
            r2 = r25
            r3 = r24
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.graphics.drawscope.DrawStyle, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, androidx.compose.ui.text.style.TextMotion):void");
    }

    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    public static /* synthetic */ TextStyle merge$default(TextStyle textStyle, TextStyle textStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            textStyle2 = null;
        }
        return textStyle.merge(textStyle2);
    }

    public final TextStyle merge(TextStyle textStyle) {
        return (textStyle == null || Intrinsics.areEqual((Object) textStyle, (Object) Default)) ? this : new TextStyle(toSpanStyle().merge(textStyle.toSpanStyle()), toParagraphStyle().merge(textStyle.toParagraphStyle()));
    }

    /* renamed from: merge-dA7vx0o$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m6062mergedA7vx0o$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, LineHeightStyle lineHeightStyle, int i3, int i4, PlatformTextStyle platformTextStyle, TextMotion textMotion, int i5, Object obj) {
        int i6 = i5;
        return textStyle.m6087mergedA7vx0o((i6 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j, (i6 & 2) != 0 ? TextUnit.Companion.m6822getUnspecifiedXSAIIZE() : j2, (i6 & 4) != 0 ? null : fontWeight, (i6 & 8) != 0 ? null : fontStyle, (i6 & 16) != 0 ? null : fontSynthesis, (i6 & 32) != 0 ? null : fontFamily, (i6 & 64) != 0 ? null : str, (i6 & 128) != 0 ? TextUnit.Companion.m6822getUnspecifiedXSAIIZE() : j3, (i6 & 256) != 0 ? null : baselineShift, (i6 & 512) != 0 ? null : textGeometricTransform, (i6 & 1024) != 0 ? null : localeList, (i6 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4, (i6 & 4096) != 0 ? null : textDecoration, (i6 & 8192) != 0 ? null : shadow, (i6 & 16384) != 0 ? null : drawStyle, (i6 & 32768) != 0 ? TextAlign.Companion.m6466getUnspecifiede0LSkKk() : i, (i6 & 65536) != 0 ? TextDirection.Companion.m6479getUnspecifieds_7Xco() : i2, (i6 & 131072) != 0 ? TextUnit.Companion.m6822getUnspecifiedXSAIIZE() : j5, (i6 & 262144) != 0 ? null : textIndent, (i6 & 524288) != 0 ? null : lineHeightStyle, (i6 & 1048576) != 0 ? LineBreak.Companion.m6393getUnspecifiedrAG3T2k() : i3, (i6 & 2097152) != 0 ? Hyphens.Companion.m6372getUnspecifiedvmbZdU8() : i4, (i6 & 4194304) != 0 ? null : platformTextStyle, (i6 & 8388608) != 0 ? null : textMotion);
    }

    /* renamed from: merge-dA7vx0o  reason: not valid java name */
    public final TextStyle m6087mergedA7vx0o(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, LineHeightStyle lineHeightStyle, int i3, int i4, PlatformTextStyle platformTextStyle, TextMotion textMotion) {
        PlatformSpanStyle platformSpanStyle;
        SpanStyle spanStyle2 = this.spanStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        if (platformTextStyle != null) {
            platformSpanStyle = platformTextStyle.getSpanStyle();
        } else {
            platformSpanStyle = null;
        }
        SpanStyle r1 = SpanStyleKt.m6006fastMergedSHsh3o(spanStyle2, j, (Brush) null, Float.NaN, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle);
        ParagraphStyle paragraphStyle2 = this.paragraphStyle;
        if (platformTextStyle != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        ParagraphStyle r2 = ParagraphStyleKt.m5960fastMergej5T8yCg(paragraphStyle2, i, i2, j5, textIndent, platformParagraphStyle, lineHeightStyle, i3, i4, textMotion);
        if (this.spanStyle == r1 && this.paragraphStyle == r2) {
            return this;
        }
        return new TextStyle(r1, r2);
    }

    /* renamed from: merge-Z1GrekI$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m6061mergeZ1GrekI$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, PlatformTextStyle platformTextStyle, TextMotion textMotion, int i, Object obj) {
        int i2 = i;
        return textStyle.m6086mergeZ1GrekI((i2 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j, (i2 & 2) != 0 ? TextUnit.Companion.m6822getUnspecifiedXSAIIZE() : j2, (i2 & 4) != 0 ? null : fontWeight, (i2 & 8) != 0 ? null : fontStyle, (i2 & 16) != 0 ? null : fontSynthesis, (i2 & 32) != 0 ? null : fontFamily, (i2 & 64) != 0 ? null : str, (i2 & 128) != 0 ? TextUnit.Companion.m6822getUnspecifiedXSAIIZE() : j3, (i2 & 256) != 0 ? null : baselineShift, (i2 & 512) != 0 ? null : textGeometricTransform, (i2 & 1024) != 0 ? null : localeList, (i2 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4, (i2 & 4096) != 0 ? null : textDecoration, (i2 & 8192) != 0 ? null : shadow, (i2 & 16384) != 0 ? null : drawStyle, (i2 & 32768) != 0 ? null : textAlign, (i2 & 65536) != 0 ? null : textDirection, (i2 & 131072) != 0 ? TextUnit.Companion.m6822getUnspecifiedXSAIIZE() : j5, (i2 & 262144) != 0 ? null : textIndent, (i2 & 524288) != 0 ? null : lineHeightStyle, (i2 & 1048576) != 0 ? null : lineBreak, (i2 & 2097152) != 0 ? null : hyphens, (i2 & 4194304) != 0 ? null : platformTextStyle, (i2 & 8388608) != 0 ? null : textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "merge that takes nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* renamed from: merge-Z1GrekI  reason: not valid java name */
    public final /* synthetic */ TextStyle m6086mergeZ1GrekI(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, PlatformTextStyle platformTextStyle, TextMotion textMotion) {
        PlatformSpanStyle platformSpanStyle;
        int i;
        SpanStyle spanStyle2 = this.spanStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        if (platformTextStyle != null) {
            platformSpanStyle = platformTextStyle.getSpanStyle();
        } else {
            platformSpanStyle = null;
        }
        SpanStyle r1 = SpanStyleKt.m6006fastMergedSHsh3o(spanStyle2, j, (Brush) null, Float.NaN, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle);
        ParagraphStyle paragraphStyle2 = this.paragraphStyle;
        int r3 = textAlign != null ? textAlign.m6459unboximpl() : TextAlign.Companion.m6466getUnspecifiede0LSkKk();
        int r4 = textDirection != null ? textDirection.m6473unboximpl() : TextDirection.Companion.m6479getUnspecifieds_7Xco();
        if (platformTextStyle != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        int r5 = lineBreak != null ? lineBreak.m6385unboximpl() : LineBreak.Companion.m6393getUnspecifiedrAG3T2k();
        if (hyphens != null) {
            i = hyphens.m6369unboximpl();
        } else {
            i = Hyphens.Companion.m6372getUnspecifiedvmbZdU8();
        }
        ParagraphStyle r2 = ParagraphStyleKt.m5960fastMergej5T8yCg(paragraphStyle2, r3, r4, j5, textIndent, platformParagraphStyle, lineHeightStyle, r5, i, textMotion);
        if (this.spanStyle == r1 && this.paragraphStyle == r2) {
            return this;
        }
        return new TextStyle(r1, r2);
    }

    public final TextStyle merge(SpanStyle spanStyle2) {
        return new TextStyle(toSpanStyle().merge(spanStyle2), toParagraphStyle());
    }

    public final TextStyle merge(ParagraphStyle paragraphStyle2) {
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(paragraphStyle2));
    }

    public final TextStyle plus(TextStyle textStyle) {
        return merge(textStyle);
    }

    public final TextStyle plus(ParagraphStyle paragraphStyle2) {
        return merge(paragraphStyle2);
    }

    public final TextStyle plus(SpanStyle spanStyle2) {
        return merge(spanStyle2);
    }

    /* renamed from: copy-HL5avdY$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m6051copyHL5avdY$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, int i, Object obj) {
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        return textStyle.m6064copyHL5avdY((i2 & 1) != 0 ? textStyle2.spanStyle.m6001getColor0d7_KjU() : j, (i2 & 2) != 0 ? textStyle2.spanStyle.m6002getFontSizeXSAIIZE() : j2, (i2 & 4) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight, (i2 & 8) != 0 ? textStyle2.spanStyle.m6003getFontStyle4Lr2A7w() : fontStyle, (i2 & 16) != 0 ? textStyle2.spanStyle.m6004getFontSynthesisZQGJjVo() : fontSynthesis, (i2 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily, (i2 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str, (i2 & 128) != 0 ? textStyle2.spanStyle.m6005getLetterSpacingXSAIIZE() : j3, (i2 & 256) != 0 ? textStyle2.spanStyle.m6000getBaselineShift5SSeXJ0() : baselineShift, (i2 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform, (i2 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList, (i2 & 2048) != 0 ? textStyle2.spanStyle.m5999getBackground0d7_KjU() : j4, (i2 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration, (i2 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow, (i2 & 16384) != 0 ? TextAlign.m6453boximpl(textStyle2.paragraphStyle.m5957getTextAligne0LSkKk()) : textAlign, (i2 & 32768) != 0 ? TextDirection.m6467boximpl(textStyle2.paragraphStyle.m5959getTextDirections_7Xco()) : textDirection, (i2 & 65536) != 0 ? textStyle2.paragraphStyle.m5955getLineHeightXSAIIZE() : j5, (i2 & 131072) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-HL5avdY  reason: not valid java name */
    public final /* synthetic */ TextStyle m6064copyHL5avdY(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent) {
        TextForegroundStyle textForegroundStyle;
        long j6 = j;
        if (Color.m3817equalsimpl0(j6, this.spanStyle.m6001getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m6482from8_81llA(j6);
        }
        SpanStyle spanStyle2 = r4;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, this.spanStyle.getPlatformStyle(), this.spanStyle.getDrawStyle(), (DefaultConstructorMarker) null);
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign != null ? textAlign.m6459unboximpl() : TextAlign.Companion.m6466getUnspecifiede0LSkKk(), textDirection != null ? textDirection.m6473unboximpl() : TextDirection.Companion.m6479getUnspecifieds_7Xco(), j5, textIndent, this.paragraphStyle.getPlatformStyle(), getLineHeightStyle(), m6080getLineBreakrAG3T2k(), m6077getHyphensvmbZdU8(), getTextMotion(), (DefaultConstructorMarker) null), this.platformStyle);
    }

    /* renamed from: copy-NOaFTUo$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m6052copyNOaFTUo$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i, Object obj) {
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        return textStyle.m6065copyNOaFTUo((i2 & 1) != 0 ? textStyle2.spanStyle.m6001getColor0d7_KjU() : j, (i2 & 2) != 0 ? textStyle2.spanStyle.m6002getFontSizeXSAIIZE() : j2, (i2 & 4) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight, (i2 & 8) != 0 ? textStyle2.spanStyle.m6003getFontStyle4Lr2A7w() : fontStyle, (i2 & 16) != 0 ? textStyle2.spanStyle.m6004getFontSynthesisZQGJjVo() : fontSynthesis, (i2 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily, (i2 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str, (i2 & 128) != 0 ? textStyle2.spanStyle.m6005getLetterSpacingXSAIIZE() : j3, (i2 & 256) != 0 ? textStyle2.spanStyle.m6000getBaselineShift5SSeXJ0() : baselineShift, (i2 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform, (i2 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList, (i2 & 2048) != 0 ? textStyle2.spanStyle.m5999getBackground0d7_KjU() : j4, (i2 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration, (i2 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow, (i2 & 16384) != 0 ? TextAlign.m6453boximpl(textStyle2.paragraphStyle.m5957getTextAligne0LSkKk()) : textAlign, (i2 & 32768) != 0 ? TextDirection.m6467boximpl(textStyle2.paragraphStyle.m5959getTextDirections_7Xco()) : textDirection, (i2 & 65536) != 0 ? textStyle2.paragraphStyle.m5955getLineHeightXSAIIZE() : j5, (i2 & 131072) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent, (i2 & 262144) != 0 ? textStyle2.platformStyle : platformTextStyle, (i2 & 524288) != 0 ? textStyle2.paragraphStyle.getLineHeightStyle() : lineHeightStyle);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-NOaFTUo  reason: not valid java name */
    public final /* synthetic */ TextStyle m6065copyNOaFTUo(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle) {
        TextForegroundStyle textForegroundStyle;
        long j6 = j;
        PlatformTextStyle platformTextStyle2 = platformTextStyle;
        if (Color.m3817equalsimpl0(j6, this.spanStyle.m6001getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m6482from8_81llA(j6);
        }
        TextForegroundStyle textForegroundStyle2 = textForegroundStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        SpanStyle spanStyle2 = r5;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle2, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle2 != null ? platformTextStyle.getSpanStyle() : null, this.spanStyle.getDrawStyle(), (DefaultConstructorMarker) null);
        int r6 = textAlign != null ? textAlign.m6459unboximpl() : TextAlign.Companion.m6466getUnspecifiede0LSkKk();
        int r7 = textDirection != null ? textDirection.m6473unboximpl() : TextDirection.Companion.m6479getUnspecifieds_7Xco();
        if (platformTextStyle2 != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(r6, r7, j5, textIndent, platformParagraphStyle, lineHeightStyle, m6080getLineBreakrAG3T2k(), m6077getHyphensvmbZdU8(), getTextMotion(), (DefaultConstructorMarker) null), platformTextStyle2);
    }

    /* renamed from: copy-CXVQc50$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m6050copyCXVQc50$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i, Object obj) {
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        return textStyle.m6063copyCXVQc50((i2 & 1) != 0 ? textStyle2.spanStyle.m6001getColor0d7_KjU() : j, (i2 & 2) != 0 ? textStyle2.spanStyle.m6002getFontSizeXSAIIZE() : j2, (i2 & 4) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight, (i2 & 8) != 0 ? textStyle2.spanStyle.m6003getFontStyle4Lr2A7w() : fontStyle, (i2 & 16) != 0 ? textStyle2.spanStyle.m6004getFontSynthesisZQGJjVo() : fontSynthesis, (i2 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily, (i2 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str, (i2 & 128) != 0 ? textStyle2.spanStyle.m6005getLetterSpacingXSAIIZE() : j3, (i2 & 256) != 0 ? textStyle2.spanStyle.m6000getBaselineShift5SSeXJ0() : baselineShift, (i2 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform, (i2 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList, (i2 & 2048) != 0 ? textStyle2.spanStyle.m5999getBackground0d7_KjU() : j4, (i2 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration, (i2 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow, (i2 & 16384) != 0 ? TextAlign.m6453boximpl(textStyle2.paragraphStyle.m5957getTextAligne0LSkKk()) : textAlign, (i2 & 32768) != 0 ? TextDirection.m6467boximpl(textStyle2.paragraphStyle.m5959getTextDirections_7Xco()) : textDirection, (i2 & 65536) != 0 ? textStyle2.paragraphStyle.m5955getLineHeightXSAIIZE() : j5, (i2 & 131072) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent, (i2 & 262144) != 0 ? textStyle2.platformStyle : platformTextStyle, (i2 & 524288) != 0 ? textStyle2.paragraphStyle.getLineHeightStyle() : lineHeightStyle, (i2 & 1048576) != 0 ? LineBreak.m6373boximpl(textStyle2.paragraphStyle.m5954getLineBreakrAG3T2k()) : lineBreak, (i2 & 2097152) != 0 ? Hyphens.m6363boximpl(textStyle2.paragraphStyle.m5952getHyphensvmbZdU8()) : hyphens);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "TextStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, and TextMotion are deprecated. Please use the new stable copy constructor.")
    /* renamed from: copy-CXVQc50  reason: not valid java name */
    public final /* synthetic */ TextStyle m6063copyCXVQc50(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        TextForegroundStyle textForegroundStyle;
        long j6 = j;
        PlatformTextStyle platformTextStyle2 = platformTextStyle;
        if (Color.m3817equalsimpl0(j6, this.spanStyle.m6001getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m6482from8_81llA(j6);
        }
        TextForegroundStyle textForegroundStyle2 = textForegroundStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        SpanStyle spanStyle2 = r5;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle2, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle2 != null ? platformTextStyle.getSpanStyle() : null, getDrawStyle(), (DefaultConstructorMarker) null);
        int r6 = textAlign != null ? textAlign.m6459unboximpl() : TextAlign.Companion.m6466getUnspecifiede0LSkKk();
        int r7 = textDirection != null ? textDirection.m6473unboximpl() : TextDirection.Companion.m6479getUnspecifieds_7Xco();
        if (platformTextStyle2 != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(r6, r7, j5, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak != null ? lineBreak.m6385unboximpl() : LineBreak.Companion.m6393getUnspecifiedrAG3T2k(), hyphens != null ? hyphens.m6369unboximpl() : Hyphens.Companion.m6372getUnspecifiedvmbZdU8(), getTextMotion(), (DefaultConstructorMarker) null), platformTextStyle2);
    }

    /* renamed from: copy-v2rsoow$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m6056copyv2rsoow$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        return textStyle.m6069copyv2rsoow((i2 & 1) != 0 ? textStyle2.spanStyle.m6001getColor0d7_KjU() : j, (i2 & 2) != 0 ? textStyle2.spanStyle.m6002getFontSizeXSAIIZE() : j2, (i2 & 4) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight, (i2 & 8) != 0 ? textStyle2.spanStyle.m6003getFontStyle4Lr2A7w() : fontStyle, (i2 & 16) != 0 ? textStyle2.spanStyle.m6004getFontSynthesisZQGJjVo() : fontSynthesis, (i2 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily, (i2 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str, (i2 & 128) != 0 ? textStyle2.spanStyle.m6005getLetterSpacingXSAIIZE() : j3, (i2 & 256) != 0 ? textStyle2.spanStyle.m6000getBaselineShift5SSeXJ0() : baselineShift, (i2 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform, (i2 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList, (i2 & 2048) != 0 ? textStyle2.spanStyle.m5999getBackground0d7_KjU() : j4, (i2 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration, (i2 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow, (i2 & 16384) != 0 ? textStyle2.spanStyle.getDrawStyle() : drawStyle, (i2 & 32768) != 0 ? TextAlign.m6453boximpl(textStyle2.paragraphStyle.m5957getTextAligne0LSkKk()) : textAlign, (i2 & 65536) != 0 ? TextDirection.m6467boximpl(textStyle2.paragraphStyle.m5959getTextDirections_7Xco()) : textDirection, (i2 & 131072) != 0 ? textStyle2.paragraphStyle.m5955getLineHeightXSAIIZE() : j5, (i2 & 262144) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent, (i2 & 524288) != 0 ? textStyle2.platformStyle : platformTextStyle, (i2 & 1048576) != 0 ? textStyle2.paragraphStyle.getLineHeightStyle() : lineHeightStyle, (i2 & 2097152) != 0 ? LineBreak.m6373boximpl(textStyle2.paragraphStyle.m5954getLineBreakrAG3T2k()) : lineBreak, (i2 & 4194304) != 0 ? Hyphens.m6363boximpl(textStyle2.paragraphStyle.m5952getHyphensvmbZdU8()) : hyphens, (i2 & 8388608) != 0 ? textStyle2.paragraphStyle.getTextMotion() : textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* renamed from: copy-v2rsoow  reason: not valid java name */
    public final /* synthetic */ TextStyle m6069copyv2rsoow(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        TextForegroundStyle textForegroundStyle;
        PlatformSpanStyle platformSpanStyle;
        int i;
        long j6 = j;
        PlatformTextStyle platformTextStyle2 = platformTextStyle;
        if (Color.m3817equalsimpl0(j6, this.spanStyle.m6001getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m6482from8_81llA(j6);
        }
        TextForegroundStyle textForegroundStyle2 = textForegroundStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        if (platformTextStyle2 != null) {
            platformSpanStyle = platformTextStyle.getSpanStyle();
        } else {
            platformSpanStyle = null;
        }
        SpanStyle spanStyle2 = r5;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle2, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
        int r6 = textAlign != null ? textAlign.m6459unboximpl() : TextAlign.Companion.m6466getUnspecifiede0LSkKk();
        int r7 = textDirection != null ? textDirection.m6473unboximpl() : TextDirection.Companion.m6479getUnspecifieds_7Xco();
        if (platformTextStyle2 != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        int r8 = lineBreak != null ? lineBreak.m6385unboximpl() : LineBreak.Companion.m6393getUnspecifiedrAG3T2k();
        if (hyphens != null) {
            i = hyphens.m6369unboximpl();
        } else {
            i = Hyphens.Companion.m6372getUnspecifiedvmbZdU8();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(r6, r7, j5, textIndent, platformParagraphStyle, lineHeightStyle, r8, i, textMotion, (DefaultConstructorMarker) null), platformTextStyle2);
    }

    /* renamed from: copy-p1EtxEg$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m6055copyp1EtxEg$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, Object obj) {
        TextStyle textStyle2 = textStyle;
        int i6 = i5;
        return textStyle.m6068copyp1EtxEg((i6 & 1) != 0 ? textStyle2.spanStyle.m6001getColor0d7_KjU() : j, (i6 & 2) != 0 ? textStyle2.spanStyle.m6002getFontSizeXSAIIZE() : j2, (i6 & 4) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight, (i6 & 8) != 0 ? textStyle2.spanStyle.m6003getFontStyle4Lr2A7w() : fontStyle, (i6 & 16) != 0 ? textStyle2.spanStyle.m6004getFontSynthesisZQGJjVo() : fontSynthesis, (i6 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily, (i6 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str, (i6 & 128) != 0 ? textStyle2.spanStyle.m6005getLetterSpacingXSAIIZE() : j3, (i6 & 256) != 0 ? textStyle2.spanStyle.m6000getBaselineShift5SSeXJ0() : baselineShift, (i6 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform, (i6 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList, (i6 & 2048) != 0 ? textStyle2.spanStyle.m5999getBackground0d7_KjU() : j4, (i6 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration, (i6 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow, (i6 & 16384) != 0 ? textStyle2.spanStyle.getDrawStyle() : drawStyle, (i6 & 32768) != 0 ? textStyle2.paragraphStyle.m5957getTextAligne0LSkKk() : i, (i6 & 65536) != 0 ? textStyle2.paragraphStyle.m5959getTextDirections_7Xco() : i2, (i6 & 131072) != 0 ? textStyle2.paragraphStyle.m5955getLineHeightXSAIIZE() : j5, (i6 & 262144) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent, (i6 & 524288) != 0 ? textStyle2.platformStyle : platformTextStyle, (i6 & 1048576) != 0 ? textStyle2.paragraphStyle.getLineHeightStyle() : lineHeightStyle, (i6 & 2097152) != 0 ? textStyle2.paragraphStyle.m5954getLineBreakrAG3T2k() : i3, (i6 & 4194304) != 0 ? textStyle2.paragraphStyle.m5952getHyphensvmbZdU8() : i4, (i6 & 8388608) != 0 ? textStyle2.paragraphStyle.getTextMotion() : textMotion);
    }

    /* renamed from: copy-p1EtxEg  reason: not valid java name */
    public final TextStyle m6068copyp1EtxEg(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        TextForegroundStyle textForegroundStyle;
        PlatformSpanStyle platformSpanStyle;
        long j6 = j;
        PlatformTextStyle platformTextStyle2 = platformTextStyle;
        if (Color.m3817equalsimpl0(j6, this.spanStyle.m6001getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m6482from8_81llA(j6);
        }
        TextForegroundStyle textForegroundStyle2 = textForegroundStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        if (platformTextStyle2 != null) {
            platformSpanStyle = platformTextStyle.getSpanStyle();
        } else {
            platformSpanStyle = null;
        }
        SpanStyle spanStyle2 = r5;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle2, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
        if (platformTextStyle2 != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(i, i2, j5, textIndent, platformParagraphStyle, lineHeightStyle, i3, i4, textMotion, (DefaultConstructorMarker) null), platformTextStyle2);
    }

    /* renamed from: copy-aIRg9q4$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m6054copyaIRg9q4$default(TextStyle textStyle, Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        Shadow shadow2;
        DrawStyle drawStyle2;
        DrawStyle drawStyle3;
        TextAlign textAlign2;
        TextAlign textAlign3;
        TextDirection textDirection2;
        long j5;
        TextDirection textDirection3;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        PlatformTextStyle platformTextStyle3;
        LineHeightStyle lineHeightStyle2;
        LineHeightStyle lineHeightStyle3;
        LineBreak lineBreak2;
        LineBreak lineBreak3;
        Hyphens hyphens2;
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        float alpha = (i2 & 2) != 0 ? textStyle2.spanStyle.getAlpha() : f;
        long r3 = (i2 & 4) != 0 ? textStyle2.spanStyle.m6002getFontSizeXSAIIZE() : j;
        FontWeight fontWeight2 = (i2 & 8) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight;
        FontStyle r6 = (i2 & 16) != 0 ? textStyle2.spanStyle.m6003getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis r7 = (i2 & 32) != 0 ? textStyle2.spanStyle.m6004getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i2 & 64) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i2 & 128) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str;
        long r10 = (i2 & 256) != 0 ? textStyle2.spanStyle.m6005getLetterSpacingXSAIIZE() : j2;
        BaselineShift r12 = (i2 & 512) != 0 ? textStyle2.spanStyle.m6000getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i2 & 1024) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i2 & 2048) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList;
        long r17 = (i2 & 4096) != 0 ? textStyle2.spanStyle.m5999getBackground0d7_KjU() : j3;
        TextDecoration textDecoration2 = (i2 & 8192) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow3 = (i2 & 16384) != 0 ? textStyle2.spanStyle.getShadow() : shadow;
        if ((i2 & 32768) != 0) {
            shadow2 = shadow3;
            drawStyle2 = textStyle2.spanStyle.getDrawStyle();
        } else {
            shadow2 = shadow3;
            drawStyle2 = drawStyle;
        }
        if ((i2 & 65536) != 0) {
            drawStyle3 = drawStyle2;
            textAlign2 = TextAlign.m6453boximpl(textStyle2.paragraphStyle.m5957getTextAligne0LSkKk());
        } else {
            drawStyle3 = drawStyle2;
            textAlign2 = textAlign;
        }
        if ((i2 & 131072) != 0) {
            textAlign3 = textAlign2;
            textDirection2 = TextDirection.m6467boximpl(textStyle2.paragraphStyle.m5959getTextDirections_7Xco());
        } else {
            textAlign3 = textAlign2;
            textDirection2 = textDirection;
        }
        if ((i2 & 262144) != 0) {
            textDirection3 = textDirection2;
            j5 = textStyle2.paragraphStyle.m5955getLineHeightXSAIIZE();
        } else {
            textDirection3 = textDirection2;
            j5 = j4;
        }
        TextIndent textIndent3 = (524288 & i2) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent;
        if ((i2 & 1048576) != 0) {
            textIndent2 = textIndent3;
            platformTextStyle2 = textStyle2.platformStyle;
        } else {
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle;
        }
        if ((i2 & 2097152) != 0) {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = textStyle2.paragraphStyle.getLineHeightStyle();
        } else {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = lineHeightStyle;
        }
        if ((i2 & 4194304) != 0) {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = LineBreak.m6373boximpl(textStyle2.paragraphStyle.m5954getLineBreakrAG3T2k());
        } else {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = lineBreak;
        }
        if ((i2 & 8388608) != 0) {
            lineBreak3 = lineBreak2;
            hyphens2 = Hyphens.m6363boximpl(textStyle2.paragraphStyle.m5952getHyphensvmbZdU8());
        } else {
            lineBreak3 = lineBreak2;
            hyphens2 = hyphens;
        }
        return textStyle.m6067copyaIRg9q4(brush, alpha, r3, fontWeight2, r6, r7, fontFamily2, fontFeatureSettings, r10, r12, textGeometricTransform2, localeList2, r17, textDecoration2, shadow2, drawStyle3, textAlign3, textDirection3, j5, textIndent2, platformTextStyle3, lineHeightStyle3, lineBreak3, hyphens2, (i2 & 16777216) != 0 ? textStyle2.paragraphStyle.getTextMotion() : textMotion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* renamed from: copy-aIRg9q4  reason: not valid java name */
    public final /* synthetic */ TextStyle m6067copyaIRg9q4(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        PlatformSpanStyle platformSpanStyle;
        int i;
        PlatformTextStyle platformTextStyle2 = platformTextStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        if (platformTextStyle2 != null) {
            platformSpanStyle = platformTextStyle.getSpanStyle();
        } else {
            platformSpanStyle = null;
        }
        SpanStyle spanStyle2 = r2;
        SpanStyle spanStyle3 = new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
        int r3 = textAlign != null ? textAlign.m6459unboximpl() : TextAlign.Companion.m6466getUnspecifiede0LSkKk();
        int r4 = textDirection != null ? textDirection.m6473unboximpl() : TextDirection.Companion.m6479getUnspecifieds_7Xco();
        if (platformTextStyle2 != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        int r5 = lineBreak != null ? lineBreak.m6385unboximpl() : LineBreak.Companion.m6393getUnspecifiedrAG3T2k();
        if (hyphens != null) {
            i = hyphens.m6369unboximpl();
        } else {
            i = Hyphens.Companion.m6372getUnspecifiedvmbZdU8();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(r3, r4, j4, textIndent, platformParagraphStyle, lineHeightStyle, r5, i, textMotion, (DefaultConstructorMarker) null), platformTextStyle2);
    }

    /* renamed from: copy-Ns73l9s$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m6053copyNs73l9s$default(TextStyle textStyle, Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion, int i5, Object obj) {
        Shadow shadow2;
        DrawStyle drawStyle2;
        DrawStyle drawStyle3;
        int i6;
        int i7;
        int i8;
        long j5;
        int i9;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        PlatformTextStyle platformTextStyle3;
        LineHeightStyle lineHeightStyle2;
        LineHeightStyle lineHeightStyle3;
        int i10;
        int i11;
        int i12;
        TextStyle textStyle2 = textStyle;
        int i13 = i5;
        float alpha = (i13 & 2) != 0 ? textStyle2.spanStyle.getAlpha() : f;
        long r3 = (i13 & 4) != 0 ? textStyle2.spanStyle.m6002getFontSizeXSAIIZE() : j;
        FontWeight fontWeight2 = (i13 & 8) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight;
        FontStyle r6 = (i13 & 16) != 0 ? textStyle2.spanStyle.m6003getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis r7 = (i13 & 32) != 0 ? textStyle2.spanStyle.m6004getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i13 & 64) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i13 & 128) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str;
        long r10 = (i13 & 256) != 0 ? textStyle2.spanStyle.m6005getLetterSpacingXSAIIZE() : j2;
        BaselineShift r12 = (i13 & 512) != 0 ? textStyle2.spanStyle.m6000getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i13 & 1024) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i13 & 2048) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList;
        long r17 = (i13 & 4096) != 0 ? textStyle2.spanStyle.m5999getBackground0d7_KjU() : j3;
        TextDecoration textDecoration2 = (i13 & 8192) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow3 = (i13 & 16384) != 0 ? textStyle2.spanStyle.getShadow() : shadow;
        if ((i13 & 32768) != 0) {
            shadow2 = shadow3;
            drawStyle2 = textStyle2.spanStyle.getDrawStyle();
        } else {
            shadow2 = shadow3;
            drawStyle2 = drawStyle;
        }
        if ((i13 & 65536) != 0) {
            drawStyle3 = drawStyle2;
            i6 = textStyle2.paragraphStyle.m5957getTextAligne0LSkKk();
        } else {
            drawStyle3 = drawStyle2;
            i6 = i;
        }
        if ((i13 & 131072) != 0) {
            i7 = i6;
            i8 = textStyle2.paragraphStyle.m5959getTextDirections_7Xco();
        } else {
            i7 = i6;
            i8 = i2;
        }
        if ((i13 & 262144) != 0) {
            i9 = i8;
            j5 = textStyle2.paragraphStyle.m5955getLineHeightXSAIIZE();
        } else {
            i9 = i8;
            j5 = j4;
        }
        TextIndent textIndent3 = (524288 & i13) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent;
        if ((i13 & 1048576) != 0) {
            textIndent2 = textIndent3;
            platformTextStyle2 = textStyle2.platformStyle;
        } else {
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle;
        }
        if ((i13 & 2097152) != 0) {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = textStyle2.paragraphStyle.getLineHeightStyle();
        } else {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = lineHeightStyle;
        }
        if ((i13 & 4194304) != 0) {
            lineHeightStyle3 = lineHeightStyle2;
            i10 = textStyle2.paragraphStyle.m5954getLineBreakrAG3T2k();
        } else {
            lineHeightStyle3 = lineHeightStyle2;
            i10 = i3;
        }
        if ((i13 & 8388608) != 0) {
            i11 = i10;
            i12 = textStyle2.paragraphStyle.m5952getHyphensvmbZdU8();
        } else {
            i11 = i10;
            i12 = i4;
        }
        return textStyle.m6066copyNs73l9s(brush, alpha, r3, fontWeight2, r6, r7, fontFamily2, fontFeatureSettings, r10, r12, textGeometricTransform2, localeList2, r17, textDecoration2, shadow2, drawStyle3, i7, i9, j5, textIndent2, platformTextStyle3, lineHeightStyle3, i11, i12, (i13 & 16777216) != 0 ? textStyle2.paragraphStyle.getTextMotion() : textMotion);
    }

    /* renamed from: copy-Ns73l9s  reason: not valid java name */
    public final TextStyle m6066copyNs73l9s(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i, int i2, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        PlatformSpanStyle platformSpanStyle;
        PlatformTextStyle platformTextStyle2 = platformTextStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        if (platformTextStyle2 != null) {
            platformSpanStyle = platformTextStyle.getSpanStyle();
        } else {
            platformSpanStyle = null;
        }
        SpanStyle spanStyle2 = r2;
        SpanStyle spanStyle3 = new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
        if (platformTextStyle2 != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(i, i2, j4, textIndent, platformParagraphStyle, lineHeightStyle, i3, i4, textMotion, (DefaultConstructorMarker) null), platformTextStyle2);
    }

    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m6072getColor0d7_KjU() {
        return this.spanStyle.m6001getColor0d7_KjU();
    }

    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
    public final long m6073getFontSizeXSAIIZE() {
        return this.spanStyle.m6002getFontSizeXSAIIZE();
    }

    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    /* renamed from: getFontStyle-4Lr2A7w  reason: not valid java name */
    public final FontStyle m6074getFontStyle4Lr2A7w() {
        return this.spanStyle.m6003getFontStyle4Lr2A7w();
    }

    /* renamed from: getFontSynthesis-ZQGJjVo  reason: not valid java name */
    public final FontSynthesis m6075getFontSynthesisZQGJjVo() {
        return this.spanStyle.m6004getFontSynthesisZQGJjVo();
    }

    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    /* renamed from: getLetterSpacing-XSAIIZE  reason: not valid java name */
    public final long m6078getLetterSpacingXSAIIZE() {
        return this.spanStyle.m6005getLetterSpacingXSAIIZE();
    }

    /* renamed from: getBaselineShift-5SSeXJ0  reason: not valid java name */
    public final BaselineShift m6071getBaselineShift5SSeXJ0() {
        return this.spanStyle.m6000getBaselineShift5SSeXJ0();
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m6070getBackground0d7_KjU() {
        return this.spanStyle.m5999getBackground0d7_KjU();
    }

    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    public final DrawStyle getDrawStyle() {
        return this.spanStyle.getDrawStyle();
    }

    /* renamed from: getTextAlign-e0LSkKk  reason: not valid java name */
    public final int m6083getTextAligne0LSkKk() {
        return this.paragraphStyle.m5957getTextAligne0LSkKk();
    }

    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m6082getTextAlignbuA522U() {
        return TextAlign.m6453boximpl(m6083getTextAligne0LSkKk());
    }

    /* renamed from: getTextDirection-s_7X-co  reason: not valid java name */
    public final int m6085getTextDirections_7Xco() {
        return this.paragraphStyle.m5959getTextDirections_7Xco();
    }

    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m6084getTextDirectionmmuk1to() {
        return TextDirection.m6467boximpl(m6085getTextDirections_7Xco());
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m6081getLineHeightXSAIIZE() {
        return this.paragraphStyle.m5955getLineHeightXSAIIZE();
    }

    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    /* renamed from: getHyphens-vmbZdU8  reason: not valid java name */
    public final int m6077getHyphensvmbZdU8() {
        return this.paragraphStyle.m5952getHyphensvmbZdU8();
    }

    /* renamed from: getHyphens-EaSxIns  reason: not valid java name */
    public final Hyphens m6076getHyphensEaSxIns() {
        return Hyphens.m6363boximpl(m6077getHyphensvmbZdU8());
    }

    /* renamed from: getLineBreak-rAG3T2k  reason: not valid java name */
    public final int m6080getLineBreakrAG3T2k() {
        return this.paragraphStyle.m5954getLineBreakrAG3T2k();
    }

    /* renamed from: getLineBreak-LgCVezo  reason: not valid java name */
    public final LineBreak m6079getLineBreakLgCVezo() {
        return LineBreak.m6373boximpl(m6080getLineBreakrAG3T2k());
    }

    public final TextMotion getTextMotion() {
        return this.paragraphStyle.getTextMotion();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return Intrinsics.areEqual((Object) this.spanStyle, (Object) textStyle.spanStyle) && Intrinsics.areEqual((Object) this.paragraphStyle, (Object) textStyle.paragraphStyle) && Intrinsics.areEqual((Object) this.platformStyle, (Object) textStyle.platformStyle);
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle textStyle) {
        return this == textStyle || (Intrinsics.areEqual((Object) this.paragraphStyle, (Object) textStyle.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(textStyle.spanStyle));
    }

    public final boolean hasSameDrawAffectingAttributes(TextStyle textStyle) {
        return this == textStyle || this.spanStyle.hasSameNonLayoutAttributes$ui_text_release(textStyle.spanStyle);
    }

    public int hashCode() {
        int hashCode = ((this.spanStyle.hashCode() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return hashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text_release() {
        int hashCodeLayoutAffectingAttributes$ui_text_release = ((this.spanStyle.hashCodeLayoutAffectingAttributes$ui_text_release() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return hashCodeLayoutAffectingAttributes$ui_text_release + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public String toString() {
        return "TextStyle(color=" + Color.m3824toStringimpl(m6072getColor0d7_KjU()) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + TextUnit.m6818toStringimpl(m6073getFontSizeXSAIIZE()) + ", fontWeight=" + getFontWeight() + ", fontStyle=" + m6074getFontStyle4Lr2A7w() + ", fontSynthesis=" + m6075getFontSynthesisZQGJjVo() + ", fontFamily=" + getFontFamily() + ", fontFeatureSettings=" + getFontFeatureSettings() + ", letterSpacing=" + TextUnit.m6818toStringimpl(m6078getLetterSpacingXSAIIZE()) + ", baselineShift=" + m6071getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + getTextGeometricTransform() + ", localeList=" + getLocaleList() + ", background=" + Color.m3824toStringimpl(m6070getBackground0d7_KjU()) + ", textDecoration=" + getTextDecoration() + ", shadow=" + getShadow() + ", drawStyle=" + getDrawStyle() + ", textAlign=" + TextAlign.m6458toStringimpl(m6083getTextAligne0LSkKk()) + ", textDirection=" + TextDirection.m6472toStringimpl(m6085getTextDirections_7Xco()) + ", lineHeight=" + TextUnit.m6818toStringimpl(m6081getLineHeightXSAIIZE()) + ", textIndent=" + getTextIndent() + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + getLineHeightStyle() + ", lineBreak=" + LineBreak.m6384toStringimpl(m6080getLineBreakrAG3T2k()) + ", hyphens=" + Hyphens.m6368toStringimpl(m6077getHyphensvmbZdU8()) + ", textMotion=" + getTextMotion() + ')';
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/TextStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TextStyle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        private Companion() {
        }

        public final TextStyle getDefault() {
            return TextStyle.Default;
        }
    }
}
