package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a¦\u0001\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a¹\u0001\u0010(\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0003ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u0001\u00101\u001a\u00020\u00112\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a¦\u0001\u00107\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u00107\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a®\u0001\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\u001a\u0001\u0010=\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010?\u001a\u0001\u0010=\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a®\u0001\u0010A\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\u001aÅ\u0001\u0010B\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010C\u001aÎ\u0001\u0010D\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020:2\b\u0010\u001f\u001a\u0004\u0018\u00010;2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0003ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u0001\u0010G\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010?\u001a\u0001\u0010G\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a&\u0010H\u001a\u00020\u00012\b\b\u0002\u0010I\u001a\u00020\u00192\b\b\u0002\u0010J\u001a\u00020\u00192\b\b\u0002\u0010K\u001a\u00020\u0019H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"AssistChipPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "FilterChipPadding", "HorizontalElementsPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LabelLayoutId", "", "LeadingIconLayoutId", "SuggestionChipPadding", "TrailingIconLayoutId", "defaultSuggestionChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "elevation", "Landroidx/compose/material3/ChipElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "paddingValues", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "avatar", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "ElevatedAssistChip", "ElevatedFilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedSuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "InputChip", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SuggestionChip", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class ChipKt {
    private static final PaddingValues AssistChipPadding;
    private static final PaddingValues FilterChipPadding;
    /* access modifiers changed from: private */
    public static final float HorizontalElementsPadding;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding;
    private static final String TrailingIconLayoutId = "trailingIcon";

    /* JADX WARNING: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void AssistChip(kotlin.jvm.functions.Function0<kotlin.Unit> r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.ui.Modifier r38, boolean r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.ui.graphics.Shape r42, androidx.compose.material3.ChipColors r43, androidx.compose.material3.ChipElevation r44, androidx.compose.foundation.BorderStroke r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.runtime.Composer r47, int r48, int r49, int r50) {
        /*
            r12 = r48
            r14 = r50
            r0 = 313450168(0x12aedeb8, float:1.1035848E-27)
            r1 = r47
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AssistChip)P(8,5,7,3,6,10,9,1,2)119@6048L5,120@6099L18,121@6170L21,122@6240L25,123@6317L39,129@6493L10,124@6362L507:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r12 | 6
            r13 = r36
            goto L_0x002d
        L_0x001b:
            r1 = r12 & 6
            r13 = r36
            if (r1 != 0) goto L_0x002c
            boolean r1 = r11.changedInstance(r13)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r12
            goto L_0x002d
        L_0x002c:
            r1 = r12
        L_0x002d:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r15 = r37
            goto L_0x0048
        L_0x0036:
            r4 = r12 & 48
            r15 = r37
            if (r4 != 0) goto L_0x0048
            boolean r4 = r11.changedInstance(r15)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r5 = r12 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0062
            r5 = r38
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r6
            goto L_0x0064
        L_0x0062:
            r5 = r38
        L_0x0064:
            r6 = r14 & 8
            if (r6 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r7 = r12 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007e
            r7 = r39
            boolean r8 = r11.changed((boolean) r7)
            if (r8 == 0) goto L_0x007a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r8
            goto L_0x0080
        L_0x007e:
            r7 = r39
        L_0x0080:
            r8 = r14 & 16
            if (r8 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r9 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009a
            r9 = r40
            boolean r10 = r11.changedInstance(r9)
            if (r10 == 0) goto L_0x0096
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r10
            goto L_0x009c
        L_0x009a:
            r9 = r40
        L_0x009c:
            r10 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a7
            r1 = r1 | r16
            r2 = r41
            goto L_0x00ba
        L_0x00a7:
            r16 = r12 & r16
            r2 = r41
            if (r16 != 0) goto L_0x00ba
            boolean r16 = r11.changedInstance(r2)
            if (r16 == 0) goto L_0x00b6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r16
        L_0x00ba:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d4
            r16 = r14 & 64
            r0 = r42
            if (r16 != 0) goto L_0x00cf
            boolean r17 = r11.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00d6
        L_0x00d4:
            r0 = r42
        L_0x00d6:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x00f2
            r3 = r14 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00eb
            r3 = r43
            boolean r18 = r11.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x00ed
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r3 = r43
        L_0x00ed:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r18
            goto L_0x00f4
        L_0x00f2:
            r3 = r43
        L_0x00f4:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0110
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0109
            r0 = r44
            boolean r18 = r11.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010b
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x0109:
            r0 = r44
        L_0x010b:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r1 = r1 | r18
            goto L_0x0112
        L_0x0110:
            r0 = r44
        L_0x0112:
            r18 = 805306368(0x30000000, float:4.656613E-10)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x012e
            r0 = r14 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0127
            r0 = r45
            boolean r18 = r11.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x0129
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012b
        L_0x0127:
            r0 = r45
        L_0x0129:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012b:
            r1 = r1 | r18
            goto L_0x0130
        L_0x012e:
            r0 = r45
        L_0x0130:
            r9 = r14 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x013d
            r18 = r49 | 6
            r35 = r18
            r18 = r9
            r9 = r35
            goto L_0x015b
        L_0x013d:
            r18 = r49 & 6
            if (r18 != 0) goto L_0x0155
            r18 = r9
            r9 = r46
            boolean r19 = r11.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x014e
            r19 = 4
            goto L_0x0150
        L_0x014e:
            r19 = 2
        L_0x0150:
            r19 = r49 | r19
            r9 = r19
            goto L_0x015b
        L_0x0155:
            r18 = r9
            r9 = r46
            r9 = r49
        L_0x015b:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r19
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x0185
            r0 = r9 & 3
            r2 = 2
            if (r0 != r2) goto L_0x0185
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0171
            goto L_0x0185
        L_0x0171:
            r11.skipToGroupEnd()
            r6 = r41
            r9 = r44
            r10 = r45
            r12 = r46
            r8 = r3
            r3 = r5
            r4 = r7
            r5 = r40
            r7 = r42
            goto L_0x0327
        L_0x0185:
            r11.startDefaults()
            r0 = r12 & 1
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r47 = r9
            r9 = 6
            if (r0 == 0) goto L_0x01cb
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x019c
            goto L_0x01cb
        L_0x019c:
            r11.skipToGroupEnd()
            r0 = r14 & 64
            if (r0 == 0) goto L_0x01a5
            r1 = r1 & r17
        L_0x01a5:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01aa
            r1 = r1 & r2
        L_0x01aa:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01b2
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r0
        L_0x01b2:
            r0 = r14 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01ba
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r0
        L_0x01ba:
            r0 = r40
            r2 = r42
            r4 = r44
            r6 = r45
            r8 = r46
            r34 = r47
            r9 = r1
            r1 = r41
            goto L_0x0293
        L_0x01cb:
            if (r4 == 0) goto L_0x01d2
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01d3
        L_0x01d2:
            r0 = r5
        L_0x01d3:
            if (r6 == 0) goto L_0x01d9
            r4 = 1
            r19 = r4
            goto L_0x01db
        L_0x01d9:
            r19 = r7
        L_0x01db:
            r4 = 0
            if (r8 == 0) goto L_0x01e1
            r20 = r4
            goto L_0x01e3
        L_0x01e1:
            r20 = r40
        L_0x01e3:
            if (r10 == 0) goto L_0x01e8
            r21 = r4
            goto L_0x01ea
        L_0x01e8:
            r21 = r41
        L_0x01ea:
            r4 = r14 & 64
            if (r4 == 0) goto L_0x01f9
            androidx.compose.material3.AssistChipDefaults r4 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r4 = r4.getShape(r11, r9)
            r1 = r1 & r17
            r17 = r4
            goto L_0x01fb
        L_0x01f9:
            r17 = r42
        L_0x01fb:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0206
            androidx.compose.material3.AssistChipDefaults r3 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.assistChipColors(r11, r9)
            r1 = r1 & r2
        L_0x0206:
            r23 = r1
            r22 = r3
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x022e
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            r10 = 1572864(0x180000, float:2.204052E-39)
            r24 = 63
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = r11
            r34 = r47
            r9 = r10
            r10 = r24
            androidx.compose.material3.ChipElevation r1 = r1.m1524assistChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r23 = r23 & r2
            r24 = r23
            r23 = r1
            goto L_0x0234
        L_0x022e:
            r34 = r47
            r24 = r23
            r23 = r44
        L_0x0234:
            r1 = r14 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0254
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            int r2 = r24 >> 9
            r2 = r2 & 14
            r9 = r2 | 24576(0x6000, float:3.4438E-41)
            r10 = 14
            r3 = 0
            r5 = 0
            r7 = 0
            r2 = r19
            r8 = r11
            androidx.compose.foundation.BorderStroke r1 = r1.m1522assistChipBorderh1eTWw(r2, r3, r5, r7, r8, r9, r10)
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r2 = r24 & r2
            goto L_0x0258
        L_0x0254:
            r1 = r45
            r2 = r24
        L_0x0258:
            if (r18 == 0) goto L_0x0282
            r3 = 839902005(0x320fe335, float:8.375356E-9)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            java.lang.Object r3 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0278
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r3)
        L_0x0278:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            r11.endReplaceableGroup()
            r5 = r0
            r6 = r1
            r9 = r2
            r8 = r3
            goto L_0x0287
        L_0x0282:
            r8 = r46
            r5 = r0
            r6 = r1
            r9 = r2
        L_0x0287:
            r2 = r17
            r7 = r19
            r0 = r20
            r1 = r21
            r3 = r22
            r4 = r23
        L_0x0293:
            r11.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x02a7
            java.lang.String r10 = "androidx.compose.material3.AssistChip (Chip.kt:124)"
            r12 = r34
            r13 = 313450168(0x12aedeb8, float:1.1035848E-27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r9, r12, r10)
            goto L_0x02a9
        L_0x02a7:
            r12 = r34
        L_0x02a9:
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            r13 = 6
            androidx.compose.material3.Typography r10 = r10.getTypography(r11, r13)
            androidx.compose.material3.tokens.AssistChipTokens r13 = androidx.compose.material3.tokens.AssistChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r13 = r13.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r19 = androidx.compose.material3.TypographyKt.fromToken(r10, r13)
            long r20 = r3.m1616labelColorvNxB06k$material3_release(r7)
            androidx.compose.material3.AssistChipDefaults r10 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            float r28 = r10.m1527getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r29 = AssistChipPadding
            int r10 = r9 >> 6
            r10 = r10 & 14
            int r13 = r9 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r10 = r10 | r13
            int r13 = r9 >> 3
            r13 = r13 & 896(0x380, float:1.256E-42)
            r10 = r10 | r13
            int r13 = r9 << 6
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r14
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r13
            r10 = r10 | r14
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r14 = r14 & r13
            r10 = r10 | r14
            r14 = 234881024(0xe000000, float:1.5777218E-30)
            r14 = r14 & r13
            r10 = r10 | r14
            r14 = 1879048192(0x70000000, float:1.58456325E29)
            r13 = r13 & r14
            r32 = r10 | r13
            int r9 = r9 >> 24
            r10 = r9 & 14
            r10 = r10 | 3456(0xd80, float:4.843E-42)
            r9 = r9 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            int r10 = r12 << 12
            r12 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r12
            r33 = r9 | r10
            r15 = r5
            r16 = r36
            r17 = r7
            r18 = r37
            r22 = r0
            r23 = r1
            r24 = r2
            r25 = r3
            r26 = r4
            r27 = r6
            r30 = r8
            r31 = r11
            m1626ChipnkUnTEs(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x031e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x031e:
            r9 = r4
            r10 = r6
            r4 = r7
            r12 = r8
            r6 = r1
            r7 = r2
            r8 = r3
            r3 = r5
            r5 = r0
        L_0x0327:
            androidx.compose.runtime.ScopeUpdateScope r15 = r11.endRestartGroup()
            if (r15 == 0) goto L_0x0346
            androidx.compose.material3.ChipKt$AssistChip$2 r16 = new androidx.compose.material3.ChipKt$AssistChip$2
            r0 = r16
            r1 = r36
            r2 = r37
            r11 = r12
            r12 = r48
            r13 = r49
            r14 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0346:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.AssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x034f  */
    /* JADX WARNING: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0118  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "AssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void AssistChip(kotlin.jvm.functions.Function0 r36, kotlin.jvm.functions.Function2 r37, androidx.compose.ui.Modifier r38, boolean r39, kotlin.jvm.functions.Function2 r40, kotlin.jvm.functions.Function2 r41, androidx.compose.ui.graphics.Shape r42, androidx.compose.material3.ChipColors r43, androidx.compose.material3.ChipElevation r44, androidx.compose.material3.ChipBorder r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.runtime.Composer r47, int r48, int r49, int r50) {
        /*
            r12 = r48
            r14 = r50
            r0 = -1932300596(0xffffffff8cd36ecc, float:-3.257638E-31)
            r1 = r47
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AssistChip)P(8,5,7,3,6,10,9,1,2)199@10095L5,200@10146L18,201@10217L21,202@10285L18,203@10355L39,209@10531L10,204@10400L537:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r12 | 6
            r13 = r36
            goto L_0x002d
        L_0x001b:
            r1 = r12 & 6
            r13 = r36
            if (r1 != 0) goto L_0x002c
            boolean r1 = r11.changedInstance(r13)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r12
            goto L_0x002d
        L_0x002c:
            r1 = r12
        L_0x002d:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r15 = r37
            goto L_0x0048
        L_0x0036:
            r4 = r12 & 48
            r15 = r37
            if (r4 != 0) goto L_0x0048
            boolean r4 = r11.changedInstance(r15)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r5 = r12 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0062
            r5 = r38
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r6
            goto L_0x0064
        L_0x0062:
            r5 = r38
        L_0x0064:
            r6 = r14 & 8
            if (r6 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r7 = r12 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007e
            r7 = r39
            boolean r8 = r11.changed((boolean) r7)
            if (r8 == 0) goto L_0x007a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r8
            goto L_0x0080
        L_0x007e:
            r7 = r39
        L_0x0080:
            r8 = r14 & 16
            if (r8 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r9 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009a
            r9 = r40
            boolean r10 = r11.changedInstance(r9)
            if (r10 == 0) goto L_0x0096
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r10
            goto L_0x009c
        L_0x009a:
            r9 = r40
        L_0x009c:
            r10 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a7
            r1 = r1 | r16
            r2 = r41
            goto L_0x00ba
        L_0x00a7:
            r16 = r12 & r16
            r2 = r41
            if (r16 != 0) goto L_0x00ba
            boolean r16 = r11.changedInstance(r2)
            if (r16 == 0) goto L_0x00b6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r16
        L_0x00ba:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d4
            r16 = r14 & 64
            r0 = r42
            if (r16 != 0) goto L_0x00cf
            boolean r17 = r11.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00d6
        L_0x00d4:
            r0 = r42
        L_0x00d6:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x00f2
            r3 = r14 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00eb
            r3 = r43
            boolean r18 = r11.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x00ed
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r3 = r43
        L_0x00ed:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r18
            goto L_0x00f4
        L_0x00f2:
            r3 = r43
        L_0x00f4:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0110
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0109
            r0 = r44
            boolean r18 = r11.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010b
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x0109:
            r0 = r44
        L_0x010b:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r1 = r1 | r18
            goto L_0x0112
        L_0x0110:
            r0 = r44
        L_0x0112:
            r18 = 805306368(0x30000000, float:4.656613E-10)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x012e
            r0 = r14 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0127
            r0 = r45
            boolean r18 = r11.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x0129
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012b
        L_0x0127:
            r0 = r45
        L_0x0129:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012b:
            r1 = r1 | r18
            goto L_0x0130
        L_0x012e:
            r0 = r45
        L_0x0130:
            r9 = r14 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x013d
            r18 = r49 | 6
            r35 = r18
            r18 = r9
            r9 = r35
            goto L_0x015b
        L_0x013d:
            r18 = r49 & 6
            if (r18 != 0) goto L_0x0155
            r18 = r9
            r9 = r46
            boolean r19 = r11.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x014e
            r19 = 4
            goto L_0x0150
        L_0x014e:
            r19 = 2
        L_0x0150:
            r19 = r49 | r19
            r9 = r19
            goto L_0x015b
        L_0x0155:
            r18 = r9
            r9 = r46
            r9 = r49
        L_0x015b:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r19
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x0185
            r0 = r9 & 3
            r2 = 2
            if (r0 != r2) goto L_0x0185
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0171
            goto L_0x0185
        L_0x0171:
            r11.skipToGroupEnd()
            r6 = r41
            r9 = r44
            r10 = r45
            r12 = r46
            r8 = r3
            r3 = r5
            r4 = r7
            r5 = r40
            r7 = r42
            goto L_0x0349
        L_0x0185:
            r11.startDefaults()
            r0 = r12 & 1
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r19 = 0
            r47 = r9
            r9 = 6
            if (r0 == 0) goto L_0x01cd
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x019e
            goto L_0x01cd
        L_0x019e:
            r11.skipToGroupEnd()
            r0 = r14 & 64
            if (r0 == 0) goto L_0x01a7
            r1 = r1 & r17
        L_0x01a7:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01ac
            r1 = r1 & r2
        L_0x01ac:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01b4
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r0
        L_0x01b4:
            r0 = r14 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01bc
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r0
        L_0x01bc:
            r0 = r40
            r2 = r42
            r10 = r44
            r4 = r45
            r6 = r46
            r34 = r47
            r8 = r1
            r1 = r41
            goto L_0x0286
        L_0x01cd:
            if (r4 == 0) goto L_0x01d4
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01d5
        L_0x01d4:
            r0 = r5
        L_0x01d5:
            if (r6 == 0) goto L_0x01db
            r4 = 1
            r20 = r4
            goto L_0x01dd
        L_0x01db:
            r20 = r7
        L_0x01dd:
            if (r8 == 0) goto L_0x01e2
            r21 = r19
            goto L_0x01e4
        L_0x01e2:
            r21 = r40
        L_0x01e4:
            if (r10 == 0) goto L_0x01e9
            r22 = r19
            goto L_0x01eb
        L_0x01e9:
            r22 = r41
        L_0x01eb:
            r4 = r14 & 64
            if (r4 == 0) goto L_0x01fa
            androidx.compose.material3.AssistChipDefaults r4 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r4 = r4.getShape(r11, r9)
            r1 = r1 & r17
            r17 = r4
            goto L_0x01fc
        L_0x01fa:
            r17 = r42
        L_0x01fc:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0207
            androidx.compose.material3.AssistChipDefaults r3 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.assistChipColors(r11, r9)
            r1 = r1 & r2
        L_0x0207:
            r24 = r1
            r23 = r3
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x022c
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            r10 = 1572864(0x180000, float:2.204052E-39)
            r25 = 63
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = r11
            r34 = r47
            r9 = r10
            r10 = r25
            androidx.compose.material3.ChipElevation r1 = r1.m1524assistChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r24 = r24 & r2
            r10 = r1
            goto L_0x0230
        L_0x022c:
            r34 = r47
            r10 = r44
        L_0x0230:
            r1 = r14 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0249
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            r8 = 3072(0xc00, float:4.305E-42)
            r9 = 7
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = r11
            androidx.compose.material3.ChipBorder r1 = r1.m1521assistChipBorderd_3_b6Q(r2, r4, r6, r7, r8, r9)
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r2 = r24 & r2
            goto L_0x024d
        L_0x0249:
            r1 = r45
            r2 = r24
        L_0x024d:
            if (r18 == 0) goto L_0x0277
            r3 = 839906043(0x320ff2fb, float:8.378943E-9)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            java.lang.Object r3 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x026d
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r3)
        L_0x026d:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            r11.endReplaceableGroup()
            r5 = r0
            r4 = r1
            r8 = r2
            r6 = r3
            goto L_0x027c
        L_0x0277:
            r6 = r46
            r5 = r0
            r4 = r1
            r8 = r2
        L_0x027c:
            r2 = r17
            r7 = r20
            r0 = r21
            r1 = r22
            r3 = r23
        L_0x0286:
            r11.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x029a
            java.lang.String r9 = "androidx.compose.material3.AssistChip (Chip.kt:204)"
            r12 = r34
            r13 = -1932300596(0xffffffff8cd36ecc, float:-3.257638E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r8, r12, r9)
            goto L_0x029c
        L_0x029a:
            r12 = r34
        L_0x029c:
            androidx.compose.material3.MaterialTheme r9 = androidx.compose.material3.MaterialTheme.INSTANCE
            r13 = 6
            androidx.compose.material3.Typography r9 = r9.getTypography(r11, r13)
            androidx.compose.material3.tokens.AssistChipTokens r13 = androidx.compose.material3.tokens.AssistChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r13 = r13.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r9 = androidx.compose.material3.TypographyKt.fromToken(r9, r13)
            long r20 = r3.m1616labelColorvNxB06k$material3_release(r7)
            r13 = 839906470(0x320ff4a6, float:8.379322E-9)
            r11.startReplaceableGroup(r13)
            java.lang.String r13 = "216@10782L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r13)
            if (r4 != 0) goto L_0x02c1
            r13 = r19
            goto L_0x02cf
        L_0x02c1:
            int r13 = r8 >> 9
            r13 = r13 & 14
            int r16 = r8 >> 24
            r16 = r16 & 112(0x70, float:1.57E-43)
            r13 = r13 | r16
            androidx.compose.runtime.State r13 = r4.borderStroke$material3_release(r7, r11, r13)
        L_0x02cf:
            r11.endReplaceableGroup()
            if (r13 == 0) goto L_0x02dd
            java.lang.Object r13 = r13.getValue()
            androidx.compose.foundation.BorderStroke r13 = (androidx.compose.foundation.BorderStroke) r13
            r27 = r13
            goto L_0x02df
        L_0x02dd:
            r27 = r19
        L_0x02df:
            androidx.compose.material3.AssistChipDefaults r13 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            float r28 = r13.m1527getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r29 = AssistChipPadding
            int r13 = r8 >> 6
            r13 = r13 & 14
            int r16 = r8 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r13 = r13 | r16
            r38 = r4
            int r4 = r8 >> 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r4 = r4 | r13
            int r13 = r8 << 6
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r14
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r13
            r4 = r4 | r14
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r14 = r14 & r13
            r4 = r4 | r14
            r14 = 234881024(0xe000000, float:1.5777218E-30)
            r14 = r14 & r13
            r4 = r4 | r14
            r14 = 1879048192(0x70000000, float:1.58456325E29)
            r13 = r13 & r14
            r32 = r4 | r13
            int r4 = r8 >> 24
            r4 = r4 & 14
            r4 = r4 | 3456(0xd80, float:4.843E-42)
            int r8 = r12 << 12
            r12 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r12
            r33 = r4 | r8
            r15 = r5
            r16 = r36
            r17 = r7
            r18 = r37
            r19 = r9
            r22 = r0
            r23 = r1
            r24 = r2
            r25 = r3
            r26 = r10
            r30 = r6
            r31 = r11
            m1626ChipnkUnTEs(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x033f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x033f:
            r8 = r3
            r3 = r5
            r12 = r6
            r4 = r7
            r9 = r10
            r10 = r38
            r5 = r0
            r6 = r1
            r7 = r2
        L_0x0349:
            androidx.compose.runtime.ScopeUpdateScope r15 = r11.endRestartGroup()
            if (r15 == 0) goto L_0x0368
            androidx.compose.material3.ChipKt$AssistChip$4 r16 = new androidx.compose.material3.ChipKt$AssistChip$4
            r0 = r16
            r1 = r36
            r2 = r37
            r11 = r12
            r12 = r48
            r13 = r49
            r14 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0368:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.AssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ElevatedAssistChip(kotlin.jvm.functions.Function0<kotlin.Unit> r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.ui.Modifier r38, boolean r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.ui.graphics.Shape r42, androidx.compose.material3.ChipColors r43, androidx.compose.material3.ChipElevation r44, androidx.compose.foundation.BorderStroke r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.runtime.Composer r47, int r48, int r49, int r50) {
        /*
            r12 = r48
            r14 = r50
            r0 = 1594789934(0x5f0e902e, float:1.0272761E19)
            r1 = r47
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)270@13792L5,271@13843L26,272@13922L29,274@14037L39,280@14212L10,275@14081L507:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r12 | 6
            r13 = r36
            goto L_0x002d
        L_0x001b:
            r1 = r12 & 6
            r13 = r36
            if (r1 != 0) goto L_0x002c
            boolean r1 = r11.changedInstance(r13)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r12
            goto L_0x002d
        L_0x002c:
            r1 = r12
        L_0x002d:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r15 = r37
            goto L_0x0048
        L_0x0036:
            r4 = r12 & 48
            r15 = r37
            if (r4 != 0) goto L_0x0048
            boolean r4 = r11.changedInstance(r15)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r5 = r12 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0062
            r5 = r38
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r6
            goto L_0x0064
        L_0x0062:
            r5 = r38
        L_0x0064:
            r6 = r14 & 8
            if (r6 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r7 = r12 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007e
            r7 = r39
            boolean r8 = r11.changed((boolean) r7)
            if (r8 == 0) goto L_0x007a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r8
            goto L_0x0080
        L_0x007e:
            r7 = r39
        L_0x0080:
            r8 = r14 & 16
            if (r8 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r9 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009a
            r9 = r40
            boolean r10 = r11.changedInstance(r9)
            if (r10 == 0) goto L_0x0096
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r10
            goto L_0x009c
        L_0x009a:
            r9 = r40
        L_0x009c:
            r10 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a7
            r1 = r1 | r16
            r2 = r41
            goto L_0x00ba
        L_0x00a7:
            r16 = r12 & r16
            r2 = r41
            if (r16 != 0) goto L_0x00ba
            boolean r16 = r11.changedInstance(r2)
            if (r16 == 0) goto L_0x00b6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r16
        L_0x00ba:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d4
            r16 = r14 & 64
            r0 = r42
            if (r16 != 0) goto L_0x00cf
            boolean r17 = r11.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00d6
        L_0x00d4:
            r0 = r42
        L_0x00d6:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x00f2
            r3 = r14 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00eb
            r3 = r43
            boolean r18 = r11.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x00ed
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r3 = r43
        L_0x00ed:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r18
            goto L_0x00f4
        L_0x00f2:
            r3 = r43
        L_0x00f4:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0110
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0109
            r0 = r44
            boolean r18 = r11.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010b
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x0109:
            r0 = r44
        L_0x010b:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r1 = r1 | r18
            goto L_0x0112
        L_0x0110:
            r0 = r44
        L_0x0112:
            r9 = r14 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r9 == 0) goto L_0x011b
            r1 = r1 | r18
            goto L_0x0131
        L_0x011b:
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0131
            r18 = r9
            r9 = r45
            boolean r19 = r11.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x012c
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012e
        L_0x012c:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012e:
            r1 = r1 | r19
            goto L_0x0135
        L_0x0131:
            r18 = r9
            r9 = r45
        L_0x0135:
            r9 = r14 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0142
            r19 = r49 | 6
            r35 = r19
            r19 = r9
            r9 = r35
            goto L_0x0160
        L_0x0142:
            r19 = r49 & 6
            if (r19 != 0) goto L_0x015a
            r19 = r9
            r9 = r46
            boolean r20 = r11.changed((java.lang.Object) r9)
            if (r20 == 0) goto L_0x0153
            r20 = 4
            goto L_0x0155
        L_0x0153:
            r20 = 2
        L_0x0155:
            r20 = r49 | r20
            r9 = r20
            goto L_0x0160
        L_0x015a:
            r19 = r9
            r9 = r46
            r9 = r49
        L_0x0160:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r20
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x018a
            r0 = r9 & 3
            r2 = 2
            if (r0 != r2) goto L_0x018a
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0176
            goto L_0x018a
        L_0x0176:
            r11.skipToGroupEnd()
            r6 = r41
            r9 = r44
            r10 = r45
            r12 = r46
            r8 = r3
            r3 = r5
            r4 = r7
            r5 = r40
            r7 = r42
            goto L_0x0300
        L_0x018a:
            r11.startDefaults()
            r0 = r12 & 1
            r17 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r20 = -3670017(0xffffffffffc7ffff, float:NaN)
            r47 = r9
            r9 = 6
            if (r0 == 0) goto L_0x01c9
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01a4
            goto L_0x01c9
        L_0x01a4:
            r11.skipToGroupEnd()
            r0 = r14 & 64
            if (r0 == 0) goto L_0x01ad
            r1 = r1 & r20
        L_0x01ad:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01b2
            r1 = r1 & r2
        L_0x01b2:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01b8
            r1 = r1 & r17
        L_0x01b8:
            r0 = r40
            r2 = r42
            r4 = r44
            r6 = r45
            r8 = r46
            r34 = r47
            r9 = r1
            r1 = r41
            goto L_0x026c
        L_0x01c9:
            if (r4 == 0) goto L_0x01d0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01d1
        L_0x01d0:
            r0 = r5
        L_0x01d1:
            if (r6 == 0) goto L_0x01d7
            r4 = 1
            r21 = r4
            goto L_0x01d9
        L_0x01d7:
            r21 = r7
        L_0x01d9:
            r22 = 0
            if (r8 == 0) goto L_0x01e0
            r23 = r22
            goto L_0x01e2
        L_0x01e0:
            r23 = r40
        L_0x01e2:
            if (r10 == 0) goto L_0x01e7
            r24 = r22
            goto L_0x01e9
        L_0x01e7:
            r24 = r41
        L_0x01e9:
            r4 = r14 & 64
            if (r4 == 0) goto L_0x01f8
            androidx.compose.material3.AssistChipDefaults r4 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r4 = r4.getShape(r11, r9)
            r1 = r1 & r20
            r20 = r4
            goto L_0x01fa
        L_0x01f8:
            r20 = r42
        L_0x01fa:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0205
            androidx.compose.material3.AssistChipDefaults r3 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.elevatedAssistChipColors(r11, r9)
            r1 = r1 & r2
        L_0x0205:
            r26 = r1
            r25 = r3
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0226
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            r10 = 1572864(0x180000, float:2.204052E-39)
            r27 = 63
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = r11
            r34 = r47
            r9 = r10
            r10 = r27
            androidx.compose.material3.ChipElevation r1 = r1.m1526elevatedAssistChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = r26 & r17
            goto L_0x022c
        L_0x0226:
            r34 = r47
            r1 = r44
            r2 = r26
        L_0x022c:
            if (r18 == 0) goto L_0x022f
            goto L_0x0231
        L_0x022f:
            r22 = r45
        L_0x0231:
            if (r19 == 0) goto L_0x025b
            r3 = -227035565(0xfffffffff277b653, float:-4.9064457E30)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            java.lang.Object r3 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0251
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r3)
        L_0x0251:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            r11.endReplaceableGroup()
            r5 = r0
            r4 = r1
            r9 = r2
            r8 = r3
            goto L_0x0260
        L_0x025b:
            r8 = r46
            r5 = r0
            r4 = r1
            r9 = r2
        L_0x0260:
            r2 = r20
            r7 = r21
            r6 = r22
            r0 = r23
            r1 = r24
            r3 = r25
        L_0x026c:
            r11.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0280
            java.lang.String r10 = "androidx.compose.material3.ElevatedAssistChip (Chip.kt:275)"
            r12 = r34
            r13 = 1594789934(0x5f0e902e, float:1.0272761E19)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r9, r12, r10)
            goto L_0x0282
        L_0x0280:
            r12 = r34
        L_0x0282:
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            r13 = 6
            androidx.compose.material3.Typography r10 = r10.getTypography(r11, r13)
            androidx.compose.material3.tokens.AssistChipTokens r13 = androidx.compose.material3.tokens.AssistChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r13 = r13.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r19 = androidx.compose.material3.TypographyKt.fromToken(r10, r13)
            long r20 = r3.m1616labelColorvNxB06k$material3_release(r7)
            androidx.compose.material3.AssistChipDefaults r10 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            float r28 = r10.m1527getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r29 = AssistChipPadding
            int r10 = r9 >> 6
            r10 = r10 & 14
            int r13 = r9 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r10 = r10 | r13
            int r13 = r9 >> 3
            r13 = r13 & 896(0x380, float:1.256E-42)
            r10 = r10 | r13
            int r13 = r9 << 6
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r14
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r13
            r10 = r10 | r14
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r14 = r14 & r13
            r10 = r10 | r14
            r14 = 234881024(0xe000000, float:1.5777218E-30)
            r14 = r14 & r13
            r10 = r10 | r14
            r14 = 1879048192(0x70000000, float:1.58456325E29)
            r13 = r13 & r14
            r32 = r10 | r13
            int r9 = r9 >> 24
            r10 = r9 & 14
            r10 = r10 | 3456(0xd80, float:4.843E-42)
            r9 = r9 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            int r10 = r12 << 12
            r12 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r12
            r33 = r9 | r10
            r15 = r5
            r16 = r36
            r17 = r7
            r18 = r37
            r22 = r0
            r23 = r1
            r24 = r2
            r25 = r3
            r26 = r4
            r27 = r6
            r30 = r8
            r31 = r11
            m1626ChipnkUnTEs(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x02f7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02f7:
            r9 = r4
            r10 = r6
            r4 = r7
            r12 = r8
            r6 = r1
            r7 = r2
            r8 = r3
            r3 = r5
            r5 = r0
        L_0x0300:
            androidx.compose.runtime.ScopeUpdateScope r15 = r11.endRestartGroup()
            if (r15 == 0) goto L_0x031f
            androidx.compose.material3.ChipKt$ElevatedAssistChip$2 r16 = new androidx.compose.material3.ChipKt$ElevatedAssistChip$2
            r0 = r16
            r1 = r36
            r2 = r37
            r11 = r12
            r12 = r48
            r13 = r49
            r14 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x031f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedAssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x011b  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "ElevatedAssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void ElevatedAssistChip(kotlin.jvm.functions.Function0 r36, kotlin.jvm.functions.Function2 r37, androidx.compose.ui.Modifier r38, boolean r39, kotlin.jvm.functions.Function2 r40, kotlin.jvm.functions.Function2 r41, androidx.compose.ui.graphics.Shape r42, androidx.compose.material3.ChipColors r43, androidx.compose.material3.ChipElevation r44, androidx.compose.material3.ChipBorder r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.runtime.Composer r47, int r48, int r49, int r50) {
        /*
            r12 = r48
            r14 = r50
            r0 = 1295844802(0x4d3d05c2, float:1.98204448E8)
            r1 = r47
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)349@17824L5,350@17875L26,351@17954L29,353@18067L39,359@18242L10,354@18111L537:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r12 | 6
            r13 = r36
            goto L_0x002d
        L_0x001b:
            r1 = r12 & 6
            r13 = r36
            if (r1 != 0) goto L_0x002c
            boolean r1 = r11.changedInstance(r13)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r12
            goto L_0x002d
        L_0x002c:
            r1 = r12
        L_0x002d:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r15 = r37
            goto L_0x0048
        L_0x0036:
            r4 = r12 & 48
            r15 = r37
            if (r4 != 0) goto L_0x0048
            boolean r4 = r11.changedInstance(r15)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r5 = r12 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0062
            r5 = r38
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r6
            goto L_0x0064
        L_0x0062:
            r5 = r38
        L_0x0064:
            r6 = r14 & 8
            if (r6 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r7 = r12 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007e
            r7 = r39
            boolean r8 = r11.changed((boolean) r7)
            if (r8 == 0) goto L_0x007a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r8
            goto L_0x0080
        L_0x007e:
            r7 = r39
        L_0x0080:
            r8 = r14 & 16
            if (r8 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r9 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009a
            r9 = r40
            boolean r10 = r11.changedInstance(r9)
            if (r10 == 0) goto L_0x0096
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r10
            goto L_0x009c
        L_0x009a:
            r9 = r40
        L_0x009c:
            r10 = r14 & 32
            r16 = 196608(0x30000, float:2.75506E-40)
            if (r10 == 0) goto L_0x00a7
            r1 = r1 | r16
            r2 = r41
            goto L_0x00ba
        L_0x00a7:
            r16 = r12 & r16
            r2 = r41
            if (r16 != 0) goto L_0x00ba
            boolean r16 = r11.changedInstance(r2)
            if (r16 == 0) goto L_0x00b6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r16
        L_0x00ba:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x00d4
            r16 = r14 & 64
            r0 = r42
            if (r16 != 0) goto L_0x00cf
            boolean r17 = r11.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00cf
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r1 = r1 | r17
            goto L_0x00d6
        L_0x00d4:
            r0 = r42
        L_0x00d6:
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x00f2
            r3 = r14 & 128(0x80, float:1.794E-43)
            if (r3 != 0) goto L_0x00eb
            r3 = r43
            boolean r18 = r11.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x00ed
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r3 = r43
        L_0x00ed:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r1 = r1 | r18
            goto L_0x00f4
        L_0x00f2:
            r3 = r43
        L_0x00f4:
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0110
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0109
            r0 = r44
            boolean r18 = r11.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x010b
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x0109:
            r0 = r44
        L_0x010b:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r1 = r1 | r18
            goto L_0x0112
        L_0x0110:
            r0 = r44
        L_0x0112:
            r9 = r14 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r9 == 0) goto L_0x011b
            r1 = r1 | r18
            goto L_0x0131
        L_0x011b:
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0131
            r18 = r9
            r9 = r45
            boolean r19 = r11.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x012c
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012e
        L_0x012c:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012e:
            r1 = r1 | r19
            goto L_0x0135
        L_0x0131:
            r18 = r9
            r9 = r45
        L_0x0135:
            r9 = r14 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0142
            r19 = r49 | 6
            r35 = r19
            r19 = r9
            r9 = r35
            goto L_0x0160
        L_0x0142:
            r19 = r49 & 6
            if (r19 != 0) goto L_0x015a
            r19 = r9
            r9 = r46
            boolean r20 = r11.changed((java.lang.Object) r9)
            if (r20 == 0) goto L_0x0153
            r20 = 4
            goto L_0x0155
        L_0x0153:
            r20 = 2
        L_0x0155:
            r20 = r49 | r20
            r9 = r20
            goto L_0x0160
        L_0x015a:
            r19 = r9
            r9 = r46
            r9 = r49
        L_0x0160:
            r20 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r20
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x018a
            r0 = r9 & 3
            r2 = 2
            if (r0 != r2) goto L_0x018a
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0176
            goto L_0x018a
        L_0x0176:
            r11.skipToGroupEnd()
            r6 = r41
            r9 = r44
            r10 = r45
            r12 = r46
            r8 = r3
            r3 = r5
            r4 = r7
            r5 = r40
            r7 = r42
            goto L_0x033b
        L_0x018a:
            r11.startDefaults()
            r0 = r12 & 1
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r20 = 0
            r47 = r9
            r9 = 6
            if (r0 == 0) goto L_0x01ca
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01a3
            goto L_0x01ca
        L_0x01a3:
            r11.skipToGroupEnd()
            r0 = r14 & 64
            if (r0 == 0) goto L_0x01ac
            r1 = r1 & r17
        L_0x01ac:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01b1
            r1 = r1 & r2
        L_0x01b1:
            r0 = r14 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01b9
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r0
        L_0x01b9:
            r0 = r40
            r2 = r42
            r4 = r44
            r6 = r45
            r8 = r46
            r34 = r47
            r9 = r1
            r1 = r41
            goto L_0x027a
        L_0x01ca:
            if (r4 == 0) goto L_0x01d1
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01d2
        L_0x01d1:
            r0 = r5
        L_0x01d2:
            if (r6 == 0) goto L_0x01d8
            r4 = 1
            r21 = r4
            goto L_0x01da
        L_0x01d8:
            r21 = r7
        L_0x01da:
            if (r8 == 0) goto L_0x01df
            r22 = r20
            goto L_0x01e1
        L_0x01df:
            r22 = r40
        L_0x01e1:
            if (r10 == 0) goto L_0x01e6
            r23 = r20
            goto L_0x01e8
        L_0x01e6:
            r23 = r41
        L_0x01e8:
            r4 = r14 & 64
            if (r4 == 0) goto L_0x01f7
            androidx.compose.material3.AssistChipDefaults r4 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r4 = r4.getShape(r11, r9)
            r1 = r1 & r17
            r17 = r4
            goto L_0x01f9
        L_0x01f7:
            r17 = r42
        L_0x01f9:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0204
            androidx.compose.material3.AssistChipDefaults r3 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r3 = r3.elevatedAssistChipColors(r11, r9)
            r1 = r1 & r2
        L_0x0204:
            r25 = r1
            r24 = r3
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0228
            androidx.compose.material3.AssistChipDefaults r1 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            r10 = 1572864(0x180000, float:2.204052E-39)
            r26 = 63
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = r11
            r34 = r47
            r9 = r10
            r10 = r26
            androidx.compose.material3.ChipElevation r1 = r1.m1526elevatedAssistChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = r25 & r2
            goto L_0x022e
        L_0x0228:
            r34 = r47
            r1 = r44
            r2 = r25
        L_0x022e:
            if (r18 == 0) goto L_0x0233
            r3 = r20
            goto L_0x0235
        L_0x0233:
            r3 = r45
        L_0x0235:
            if (r19 == 0) goto L_0x026a
            r4 = -227031535(0xfffffffff277c611, float:-4.9076637E30)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            java.lang.Object r4 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x0255
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r4)
        L_0x0255:
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            r11.endReplaceableGroup()
            r5 = r0
            r9 = r2
            r6 = r3
            r8 = r4
            r2 = r17
            r7 = r21
            r0 = r22
            r3 = r24
            r4 = r1
            r1 = r23
            goto L_0x027a
        L_0x026a:
            r8 = r46
            r5 = r0
            r4 = r1
            r9 = r2
            r6 = r3
            r2 = r17
            r7 = r21
            r0 = r22
            r1 = r23
            r3 = r24
        L_0x027a:
            r11.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x028e
            java.lang.String r10 = "androidx.compose.material3.ElevatedAssistChip (Chip.kt:354)"
            r12 = r34
            r13 = 1295844802(0x4d3d05c2, float:1.98204448E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r9, r12, r10)
            goto L_0x0290
        L_0x028e:
            r12 = r34
        L_0x0290:
            androidx.compose.material3.MaterialTheme r10 = androidx.compose.material3.MaterialTheme.INSTANCE
            r13 = 6
            androidx.compose.material3.Typography r10 = r10.getTypography(r11, r13)
            androidx.compose.material3.tokens.AssistChipTokens r13 = androidx.compose.material3.tokens.AssistChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r13 = r13.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r19 = androidx.compose.material3.TypographyKt.fromToken(r10, r13)
            long r21 = r3.m1616labelColorvNxB06k$material3_release(r7)
            androidx.compose.material3.AssistChipDefaults r10 = androidx.compose.material3.AssistChipDefaults.INSTANCE
            float r28 = r10.m1527getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r29 = AssistChipPadding
            r10 = -227031027(0xfffffffff277c80d, float:-4.9078172E30)
            r11.startReplaceableGroup(r10)
            java.lang.String r10 = "368@18575L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r10)
            if (r6 != 0) goto L_0x02bd
            r10 = r20
            goto L_0x02ca
        L_0x02bd:
            int r10 = r9 >> 9
            r10 = r10 & 14
            int r13 = r9 >> 24
            r13 = r13 & 112(0x70, float:1.57E-43)
            r10 = r10 | r13
            androidx.compose.runtime.State r10 = r6.borderStroke$material3_release(r7, r11, r10)
        L_0x02ca:
            r11.endReplaceableGroup()
            if (r10 == 0) goto L_0x02d8
            java.lang.Object r10 = r10.getValue()
            androidx.compose.foundation.BorderStroke r10 = (androidx.compose.foundation.BorderStroke) r10
            r27 = r10
            goto L_0x02da
        L_0x02d8:
            r27 = r20
        L_0x02da:
            int r10 = r9 >> 6
            r10 = r10 & 14
            int r13 = r9 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r10 = r10 | r13
            int r13 = r9 >> 3
            r13 = r13 & 896(0x380, float:1.256E-42)
            r10 = r10 | r13
            int r13 = r9 << 6
            r38 = r6
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r10
            r10 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r13
            r6 = r6 | r10
            r10 = 29360128(0x1c00000, float:7.052966E-38)
            r10 = r10 & r13
            r6 = r6 | r10
            r10 = 234881024(0xe000000, float:1.5777218E-30)
            r10 = r10 & r13
            r6 = r6 | r10
            r10 = 1879048192(0x70000000, float:1.58456325E29)
            r10 = r10 & r13
            r32 = r6 | r10
            int r6 = r9 >> 24
            r6 = r6 & 14
            r6 = r6 | 3456(0xd80, float:4.843E-42)
            int r9 = r12 << 12
            r10 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r10
            r33 = r6 | r9
            r15 = r5
            r16 = r36
            r17 = r7
            r18 = r37
            r20 = r21
            r22 = r0
            r23 = r1
            r24 = r2
            r25 = r3
            r26 = r4
            r30 = r8
            r31 = r11
            m1626ChipnkUnTEs(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0331
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0331:
            r10 = r38
            r6 = r1
            r9 = r4
            r4 = r7
            r12 = r8
            r7 = r2
            r8 = r3
            r3 = r5
            r5 = r0
        L_0x033b:
            androidx.compose.runtime.ScopeUpdateScope r15 = r11.endRestartGroup()
            if (r15 == 0) goto L_0x035a
            androidx.compose.material3.ChipKt$ElevatedAssistChip$4 r16 = new androidx.compose.material3.ChipKt$ElevatedAssistChip$4
            r0 = r16
            r1 = r36
            r2 = r37
            r11 = r12
            r12 = r48
            r13 = r49
            r14 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x035a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedAssistChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FilterChip(boolean r42, kotlin.jvm.functions.Function0<kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.ui.Modifier r45, boolean r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.ui.graphics.Shape r49, androidx.compose.material3.SelectableChipColors r50, androidx.compose.material3.SelectableChipElevation r51, androidx.compose.foundation.BorderStroke r52, androidx.compose.foundation.interaction.MutableInteractionSource r53, androidx.compose.runtime.Composer r54, int r55, int r56, int r57) {
        /*
            r13 = r55
            r15 = r57
            r0 = -1711985619(0xffffffff99f52c2d, float:-2.5350249E-23)
            r1 = r54
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FilterChip)P(9,8,5,7,3,6,11,10,1,2)430@21945L5,431@22006L18,432@22087L21,433@22157L35,434@22244L39,441@22454L10,435@22288L516:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r13 | 6
            r12 = r42
            goto L_0x002d
        L_0x001b:
            r1 = r13 & 6
            r12 = r42
            if (r1 != 0) goto L_0x002c
            boolean r1 = r11.changed((boolean) r12)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r13
            goto L_0x002d
        L_0x002c:
            r1 = r13
        L_0x002d:
            r4 = r15 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r14 = r43
            goto L_0x0048
        L_0x0036:
            r4 = r13 & 48
            r14 = r43
            if (r4 != 0) goto L_0x0048
            boolean r4 = r11.changedInstance(r14)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r15 & 4
            if (r4 == 0) goto L_0x0051
            r1 = r1 | 384(0x180, float:5.38E-43)
            r10 = r44
            goto L_0x0063
        L_0x0051:
            r4 = r13 & 384(0x180, float:5.38E-43)
            r10 = r44
            if (r4 != 0) goto L_0x0063
            boolean r4 = r11.changedInstance(r10)
            if (r4 == 0) goto L_0x0060
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r4
        L_0x0063:
            r4 = r15 & 8
            if (r4 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r7 = r13 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007d
            r7 = r45
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0079
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r8
            goto L_0x007f
        L_0x007d:
            r7 = r45
        L_0x007f:
            r8 = r15 & 16
            if (r8 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0086:
            r9 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009a
            r9 = r46
            boolean r16 = r11.changed((boolean) r9)
            if (r16 == 0) goto L_0x0095
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r16
            goto L_0x009c
        L_0x009a:
            r9 = r46
        L_0x009c:
            r16 = r15 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a7
            r1 = r1 | r17
            r2 = r47
            goto L_0x00ba
        L_0x00a7:
            r17 = r13 & r17
            r2 = r47
            if (r17 != 0) goto L_0x00ba
            boolean r17 = r11.changedInstance(r2)
            if (r17 == 0) goto L_0x00b6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r17
        L_0x00ba:
            r17 = r15 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c5
            r1 = r1 | r18
            r3 = r48
            goto L_0x00d8
        L_0x00c5:
            r18 = r13 & r18
            r3 = r48
            if (r18 != 0) goto L_0x00d8
            boolean r19 = r11.changedInstance(r3)
            if (r19 == 0) goto L_0x00d4
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r1 = r1 | r19
        L_0x00d8:
            r32 = 12582912(0xc00000, float:1.7632415E-38)
            r19 = r13 & r32
            if (r19 != 0) goto L_0x00f4
            r5 = r15 & 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x00ed
            r5 = r49
            boolean r20 = r11.changed((java.lang.Object) r5)
            if (r20 == 0) goto L_0x00ef
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f1
        L_0x00ed:
            r5 = r49
        L_0x00ef:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f1:
            r1 = r1 | r20
            goto L_0x00f6
        L_0x00f4:
            r5 = r49
        L_0x00f6:
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r20 = r13 & r20
            if (r20 != 0) goto L_0x0112
            r6 = r15 & 256(0x100, float:3.59E-43)
            if (r6 != 0) goto L_0x010b
            r6 = r50
            boolean r21 = r11.changed((java.lang.Object) r6)
            if (r21 == 0) goto L_0x010d
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010b:
            r6 = r50
        L_0x010d:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r1 = r1 | r21
            goto L_0x0114
        L_0x0112:
            r6 = r50
        L_0x0114:
            r21 = 805306368(0x30000000, float:4.656613E-10)
            r21 = r13 & r21
            if (r21 != 0) goto L_0x0130
            r0 = r15 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0129
            r0 = r51
            boolean r21 = r11.changed((java.lang.Object) r0)
            if (r21 == 0) goto L_0x012b
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012d
        L_0x0129:
            r0 = r51
        L_0x012b:
            r21 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012d:
            r1 = r1 | r21
            goto L_0x0132
        L_0x0130:
            r0 = r51
        L_0x0132:
            r21 = r56 & 6
            if (r21 != 0) goto L_0x014c
            r0 = r15 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L_0x0145
            r0 = r52
            boolean r21 = r11.changed((java.lang.Object) r0)
            if (r21 == 0) goto L_0x0147
            r18 = 4
            goto L_0x0149
        L_0x0145:
            r0 = r52
        L_0x0147:
            r18 = 2
        L_0x0149:
            r18 = r56 | r18
            goto L_0x0150
        L_0x014c:
            r0 = r52
            r18 = r56
        L_0x0150:
            r10 = r15 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x015d
            r18 = r18 | 48
            r21 = r10
            r34 = r18
            r10 = r53
            goto L_0x0179
        L_0x015d:
            r21 = r56 & 48
            if (r21 != 0) goto L_0x0173
            r21 = r10
            r10 = r53
            boolean r22 = r11.changed((java.lang.Object) r10)
            if (r22 == 0) goto L_0x016e
            r19 = 32
            goto L_0x0170
        L_0x016e:
            r19 = 16
        L_0x0170:
            r18 = r18 | r19
            goto L_0x0177
        L_0x0173:
            r21 = r10
            r10 = r53
        L_0x0177:
            r34 = r18
        L_0x0179:
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r18
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x01a2
            r0 = r34 & 19
            r2 = 18
            if (r0 != r2) goto L_0x01a2
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0190
            goto L_0x01a2
        L_0x0190:
            r11.skipToGroupEnd()
            r12 = r52
            r8 = r5
            r4 = r7
            r5 = r9
            r16 = r10
            r10 = r51
            r7 = r3
            r9 = r6
            r6 = r47
            goto L_0x035c
        L_0x01a2:
            r11.startDefaults()
            r0 = r13 & 1
            r2 = 6
            if (r0 == 0) goto L_0x01e0
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01b1
            goto L_0x01e0
        L_0x01b1:
            r11.skipToGroupEnd()
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01bc
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r0
        L_0x01bc:
            r0 = r15 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01c4
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r0
        L_0x01c4:
            r0 = r15 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01cc
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r0
        L_0x01cc:
            r0 = r15 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01d2
            r34 = r34 & -15
        L_0x01d2:
            r36 = r47
            r2 = r52
            r4 = r1
            r0 = r7
            r35 = r9
            r7 = r34
            r1 = r51
            goto L_0x02bf
        L_0x01e0:
            if (r4 == 0) goto L_0x01e7
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01e8
        L_0x01e7:
            r0 = r7
        L_0x01e8:
            if (r8 == 0) goto L_0x01ee
            r4 = 1
            r35 = r4
            goto L_0x01f0
        L_0x01ee:
            r35 = r9
        L_0x01f0:
            if (r16 == 0) goto L_0x01f6
            r4 = 0
            r36 = r4
            goto L_0x01f8
        L_0x01f6:
            r36 = r47
        L_0x01f8:
            if (r17 == 0) goto L_0x01fb
            r3 = 0
        L_0x01fb:
            r37 = r3
            r3 = r15 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x020e
            androidx.compose.material3.FilterChipDefaults r3 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r11, r2)
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r4
            r38 = r3
            goto L_0x0210
        L_0x020e:
            r38 = r5
        L_0x0210:
            r3 = r15 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0223
            androidx.compose.material3.FilterChipDefaults r3 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            androidx.compose.material3.SelectableChipColors r3 = r3.filterChipColors(r11, r2)
            r4 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r4
            r16 = r1
            r39 = r3
            goto L_0x0227
        L_0x0223:
            r16 = r1
            r39 = r6
        L_0x0227:
            r1 = r15 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x024c
            androidx.compose.material3.FilterChipDefaults r1 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r17 = 63
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r11
            r40 = r21
            r10 = r17
            androidx.compose.material3.SelectableChipElevation r1 = r1.m1869filterChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r2 = r16 & r2
            goto L_0x0252
        L_0x024c:
            r40 = r21
            r1 = r51
            r2 = r16
        L_0x0252:
            r3 = r15 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0280
            androidx.compose.material3.FilterChipDefaults r16 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            int r3 = r2 >> 12
            r3 = r3 & 14
            r4 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r4
            int r4 = r2 << 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r30 = r3 | r4
            r31 = 252(0xfc, float:3.53E-43)
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r17 = r35
            r18 = r42
            r29 = r11
            androidx.compose.foundation.BorderStroke r3 = r16.m1867filterChipBorder_7El2pE(r17, r18, r19, r21, r23, r25, r27, r28, r29, r30, r31)
            r34 = r34 & -15
            goto L_0x0282
        L_0x0280:
            r3 = r52
        L_0x0282:
            if (r40 == 0) goto L_0x02b3
            r4 = 276179389(0x107629bd, float:4.85471E-29)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            java.lang.Object r4 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x02a2
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r4)
        L_0x02a2:
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            r11.endReplaceableGroup()
            r10 = r4
            r7 = r34
            r5 = r38
            r6 = r39
            r4 = r2
            r2 = r3
            r3 = r37
            goto L_0x02bf
        L_0x02b3:
            r10 = r53
            r4 = r2
            r2 = r3
            r7 = r34
            r3 = r37
            r5 = r38
            r6 = r39
        L_0x02bf:
            r11.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x02d0
            java.lang.String r8 = "androidx.compose.material3.FilterChip (Chip.kt:435)"
            r9 = -1711985619(0xffffffff99f52c2d, float:-2.5350249E-23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r4, r7, r8)
        L_0x02d0:
            androidx.compose.material3.MaterialTheme r8 = androidx.compose.material3.MaterialTheme.INSTANCE
            r9 = 6
            androidx.compose.material3.Typography r8 = r8.getTypography(r11, r9)
            androidx.compose.material3.tokens.FilterChipTokens r9 = androidx.compose.material3.tokens.FilterChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r9 = r9.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r21 = androidx.compose.material3.TypographyKt.fromToken(r8, r9)
            androidx.compose.material3.FilterChipDefaults r8 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            float r29 = r8.m1870getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r30 = FilterChipPadding
            r8 = r4 & 14
            r8 = r8 | r32
            int r9 = r4 >> 6
            r9 = r9 & 112(0x70, float:1.57E-43)
            r8 = r8 | r9
            int r9 = r4 << 3
            r12 = r9 & 896(0x380, float:1.256E-42)
            r8 = r8 | r12
            int r12 = r4 >> 3
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | r12
            int r12 = r4 << 6
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r12 & r16
            r8 = r8 | r16
            r16 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r16
            r8 = r8 | r9
            r9 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r12
            r8 = r8 | r9
            r9 = 1879048192(0x70000000, float:1.58456325E29)
            r9 = r9 & r12
            r33 = r8 | r9
            int r4 = r4 >> 24
            r8 = r4 & 14
            r8 = r8 | 27648(0x6c00, float:3.8743E-41)
            r4 = r4 & 112(0x70, float:1.57E-43)
            r4 = r4 | r8
            int r8 = r7 << 6
            r8 = r8 & 896(0x380, float:1.256E-42)
            r4 = r4 | r8
            int r7 = r7 << 12
            r8 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r8
            r34 = r4 | r7
            r23 = 0
            r16 = r42
            r17 = r0
            r18 = r43
            r19 = r35
            r20 = r44
            r22 = r36
            r24 = r3
            r25 = r5
            r26 = r6
            r27 = r1
            r28 = r2
            r31 = r10
            r32 = r11
            m1628SelectableChipu0RnIRE(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0350
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0350:
            r4 = r0
            r12 = r2
            r7 = r3
            r8 = r5
            r9 = r6
            r16 = r10
            r5 = r35
            r6 = r36
            r10 = r1
        L_0x035c:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 == 0) goto L_0x0384
            androidx.compose.material3.ChipKt$FilterChip$2 r17 = new androidx.compose.material3.ChipKt$FilterChip$2
            r0 = r17
            r1 = r42
            r2 = r43
            r3 = r44
            r14 = r11
            r11 = r12
            r12 = r16
            r13 = r55
            r41 = r14
            r14 = r56
            r15 = r57
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r41
            r1.updateScope(r0)
        L_0x0384:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.FilterChip(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:194:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ElevatedFilterChip(boolean r36, kotlin.jvm.functions.Function0<kotlin.Unit> r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, boolean r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.ui.graphics.Shape r43, androidx.compose.material3.SelectableChipColors r44, androidx.compose.material3.SelectableChipElevation r45, androidx.compose.foundation.BorderStroke r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.runtime.Composer r48, int r49, int r50, int r51) {
        /*
            r13 = r49
            r15 = r51
            r0 = -106647389(0xfffffffff9a4b0a3, float:-1.0688991E35)
            r1 = r48
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedFilterChip)P(9,8,5,7,3,6,11,10,1,2)509@25986L5,510@26047L26,511@26136L29,513@26251L39,520@26461L10,514@26295L516:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r13 | 6
            r12 = r36
            goto L_0x002d
        L_0x001b:
            r1 = r13 & 6
            r12 = r36
            if (r1 != 0) goto L_0x002c
            boolean r1 = r11.changed((boolean) r12)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r13
            goto L_0x002d
        L_0x002c:
            r1 = r13
        L_0x002d:
            r4 = r15 & 2
            if (r4 == 0) goto L_0x0036
            r1 = r1 | 48
            r14 = r37
            goto L_0x0048
        L_0x0036:
            r4 = r13 & 48
            r14 = r37
            if (r4 != 0) goto L_0x0048
            boolean r4 = r11.changedInstance(r14)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r1 = r1 | r4
        L_0x0048:
            r4 = r15 & 4
            if (r4 == 0) goto L_0x0051
            r1 = r1 | 384(0x180, float:5.38E-43)
            r10 = r38
            goto L_0x0063
        L_0x0051:
            r4 = r13 & 384(0x180, float:5.38E-43)
            r10 = r38
            if (r4 != 0) goto L_0x0063
            boolean r4 = r11.changedInstance(r10)
            if (r4 == 0) goto L_0x0060
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r1 = r1 | r4
        L_0x0063:
            r4 = r15 & 8
            if (r4 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r7 = r13 & 3072(0xc00, float:4.305E-42)
            if (r7 != 0) goto L_0x007d
            r7 = r39
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0079
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r8
            goto L_0x007f
        L_0x007d:
            r7 = r39
        L_0x007f:
            r8 = r15 & 16
            if (r8 == 0) goto L_0x0086
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0086:
            r9 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009a
            r9 = r40
            boolean r16 = r11.changed((boolean) r9)
            if (r16 == 0) goto L_0x0095
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r16
            goto L_0x009c
        L_0x009a:
            r9 = r40
        L_0x009c:
            r16 = r15 & 32
            r17 = 196608(0x30000, float:2.75506E-40)
            if (r16 == 0) goto L_0x00a7
            r1 = r1 | r17
            r2 = r41
            goto L_0x00ba
        L_0x00a7:
            r17 = r13 & r17
            r2 = r41
            if (r17 != 0) goto L_0x00ba
            boolean r17 = r11.changedInstance(r2)
            if (r17 == 0) goto L_0x00b6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r17
        L_0x00ba:
            r17 = r15 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c5
            r1 = r1 | r18
            r3 = r42
            goto L_0x00d8
        L_0x00c5:
            r18 = r13 & r18
            r3 = r42
            if (r18 != 0) goto L_0x00d8
            boolean r19 = r11.changedInstance(r3)
            if (r19 == 0) goto L_0x00d4
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r1 = r1 | r19
        L_0x00d8:
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r20 = r13 & r19
            if (r20 != 0) goto L_0x00f4
            r5 = r15 & 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x00ed
            r5 = r43
            boolean r21 = r11.changed((java.lang.Object) r5)
            if (r21 == 0) goto L_0x00ef
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f1
        L_0x00ed:
            r5 = r43
        L_0x00ef:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f1:
            r1 = r1 | r21
            goto L_0x00f6
        L_0x00f4:
            r5 = r43
        L_0x00f6:
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            r21 = r13 & r21
            if (r21 != 0) goto L_0x0112
            r6 = r15 & 256(0x100, float:3.59E-43)
            if (r6 != 0) goto L_0x010b
            r6 = r44
            boolean r22 = r11.changed((java.lang.Object) r6)
            if (r22 == 0) goto L_0x010d
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010f
        L_0x010b:
            r6 = r44
        L_0x010d:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010f:
            r1 = r1 | r22
            goto L_0x0114
        L_0x0112:
            r6 = r44
        L_0x0114:
            r22 = 805306368(0x30000000, float:4.656613E-10)
            r22 = r13 & r22
            if (r22 != 0) goto L_0x0130
            r0 = r15 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x0129
            r0 = r45
            boolean r23 = r11.changed((java.lang.Object) r0)
            if (r23 == 0) goto L_0x012b
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012d
        L_0x0129:
            r0 = r45
        L_0x012b:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012d:
            r1 = r1 | r23
            goto L_0x0132
        L_0x0130:
            r0 = r45
        L_0x0132:
            r10 = r15 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x013d
            r18 = r50 | 6
            r23 = r10
            r10 = r46
            goto L_0x0159
        L_0x013d:
            r23 = r50 & 6
            if (r23 != 0) goto L_0x0153
            r23 = r10
            r10 = r46
            boolean r24 = r11.changed((java.lang.Object) r10)
            if (r24 == 0) goto L_0x014e
            r18 = 4
            goto L_0x0150
        L_0x014e:
            r18 = 2
        L_0x0150:
            r18 = r50 | r18
            goto L_0x0159
        L_0x0153:
            r23 = r10
            r10 = r46
            r18 = r50
        L_0x0159:
            r10 = r15 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x0162
            r18 = r18 | 48
            r24 = r10
            goto L_0x017c
        L_0x0162:
            r24 = r50 & 48
            if (r24 != 0) goto L_0x0178
            r24 = r10
            r10 = r47
            boolean r25 = r11.changed((java.lang.Object) r10)
            if (r25 == 0) goto L_0x0173
            r20 = 32
            goto L_0x0175
        L_0x0173:
            r20 = 16
        L_0x0175:
            r18 = r18 | r20
            goto L_0x017c
        L_0x0178:
            r24 = r10
            r10 = r47
        L_0x017c:
            r10 = r18
            r18 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r18
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r2) goto L_0x01a7
            r0 = r10 & 19
            r2 = 18
            if (r0 != r2) goto L_0x01a7
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0195
            goto L_0x01a7
        L_0x0195:
            r11.skipToGroupEnd()
            r10 = r45
            r12 = r46
            r13 = r47
            r8 = r5
            r4 = r7
            r5 = r9
            r7 = r3
            r9 = r6
            r6 = r41
            goto L_0x032d
        L_0x01a7:
            r11.startDefaults()
            r0 = r13 & 1
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r18 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r48 = r10
            r10 = 6
            if (r0 == 0) goto L_0x01e2
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x01be
            goto L_0x01e2
        L_0x01be:
            r11.skipToGroupEnd()
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01c7
            r1 = r1 & r18
        L_0x01c7:
            r0 = r15 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01cc
            r1 = r1 & r2
        L_0x01cc:
            r0 = r15 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01d4
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r0
        L_0x01d4:
            r2 = r45
            r4 = r46
            r8 = r47
            r0 = r48
            r12 = r10
            r10 = r1
            r1 = r41
            goto L_0x0293
        L_0x01e2:
            if (r4 == 0) goto L_0x01e9
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01ea
        L_0x01e9:
            r0 = r7
        L_0x01ea:
            if (r8 == 0) goto L_0x01f0
            r4 = 1
            r20 = r4
            goto L_0x01f2
        L_0x01f0:
            r20 = r9
        L_0x01f2:
            r21 = 0
            if (r16 == 0) goto L_0x01f9
            r16 = r21
            goto L_0x01fb
        L_0x01f9:
            r16 = r41
        L_0x01fb:
            if (r17 == 0) goto L_0x0200
            r17 = r21
            goto L_0x0202
        L_0x0200:
            r17 = r3
        L_0x0202:
            r3 = r15 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0211
            androidx.compose.material3.FilterChipDefaults r3 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getShape(r11, r10)
            r1 = r1 & r18
            r18 = r3
            goto L_0x0213
        L_0x0211:
            r18 = r5
        L_0x0213:
            r3 = r15 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0223
            androidx.compose.material3.FilterChipDefaults r3 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            androidx.compose.material3.SelectableChipColors r3 = r3.elevatedFilterChipColors(r11, r10)
            r1 = r1 & r2
            r26 = r1
            r25 = r3
            goto L_0x0227
        L_0x0223:
            r26 = r1
            r25 = r6
        L_0x0227:
            r1 = r15 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0249
            androidx.compose.material3.FilterChipDefaults r1 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r27 = 63
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = r11
            r39 = r0
            r12 = r10
            r0 = r48
            r10 = r27
            androidx.compose.material3.SelectableChipElevation r1 = r1.m1866elevatedFilterChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r2 = r26 & r2
            goto L_0x0252
        L_0x0249:
            r39 = r0
            r12 = r10
            r0 = r48
            r1 = r45
            r2 = r26
        L_0x0252:
            if (r23 == 0) goto L_0x0255
            goto L_0x0257
        L_0x0255:
            r21 = r46
        L_0x0257:
            if (r24 == 0) goto L_0x0281
            r3 = -790761894(0xffffffffd0ddee5a, float:-2.97870828E10)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            java.lang.Object r3 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0277
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r3)
        L_0x0277:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            r11.endReplaceableGroup()
            r7 = r39
            r10 = r2
            r8 = r3
            goto L_0x0286
        L_0x0281:
            r7 = r39
            r8 = r47
            r10 = r2
        L_0x0286:
            r3 = r17
            r5 = r18
            r9 = r20
            r4 = r21
            r6 = r25
            r2 = r1
            r1 = r16
        L_0x0293:
            r11.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x02a4
            java.lang.String r12 = "androidx.compose.material3.ElevatedFilterChip (Chip.kt:514)"
            r13 = -106647389(0xfffffffff9a4b0a3, float:-1.0688991E35)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r10, r0, r12)
        L_0x02a4:
            androidx.compose.material3.MaterialTheme r12 = androidx.compose.material3.MaterialTheme.INSTANCE
            r13 = 6
            androidx.compose.material3.Typography r12 = r12.getTypography(r11, r13)
            androidx.compose.material3.tokens.FilterChipTokens r13 = androidx.compose.material3.tokens.FilterChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r13 = r13.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r21 = androidx.compose.material3.TypographyKt.fromToken(r12, r13)
            androidx.compose.material3.FilterChipDefaults r12 = androidx.compose.material3.FilterChipDefaults.INSTANCE
            float r29 = r12.m1870getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r30 = FilterChipPadding
            r12 = r10 & 14
            r12 = r12 | r19
            int r13 = r10 >> 6
            r13 = r13 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            int r13 = r10 << 3
            r14 = r13 & 896(0x380, float:1.256E-42)
            r12 = r12 | r14
            int r14 = r10 >> 3
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r14
            int r14 = r10 << 6
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r14 & r16
            r12 = r12 | r16
            r16 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r16
            r12 = r12 | r13
            r13 = 234881024(0xe000000, float:1.5777218E-30)
            r13 = r13 & r14
            r12 = r12 | r13
            r13 = 1879048192(0x70000000, float:1.58456325E29)
            r13 = r13 & r14
            r33 = r12 | r13
            int r10 = r10 >> 24
            r12 = r10 & 14
            r12 = r12 | 27648(0x6c00, float:3.8743E-41)
            r10 = r10 & 112(0x70, float:1.57E-43)
            r10 = r10 | r12
            int r12 = r0 << 6
            r12 = r12 & 896(0x380, float:1.256E-42)
            r10 = r10 | r12
            int r0 = r0 << 12
            r12 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r12
            r34 = r10 | r0
            r23 = 0
            r16 = r36
            r17 = r7
            r18 = r37
            r19 = r9
            r20 = r38
            r22 = r1
            r24 = r3
            r25 = r5
            r26 = r6
            r27 = r2
            r28 = r4
            r31 = r8
            r32 = r11
            m1628SelectableChipu0RnIRE(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0324
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0324:
            r10 = r2
            r12 = r4
            r4 = r7
            r13 = r8
            r7 = r3
            r8 = r5
            r5 = r9
            r9 = r6
            r6 = r1
        L_0x032d:
            androidx.compose.runtime.ScopeUpdateScope r14 = r11.endRestartGroup()
            if (r14 == 0) goto L_0x0353
            androidx.compose.material3.ChipKt$ElevatedFilterChip$2 r16 = new androidx.compose.material3.ChipKt$ElevatedFilterChip$2
            r0 = r16
            r1 = r36
            r2 = r37
            r3 = r38
            r11 = r12
            r12 = r13
            r13 = r49
            r35 = r14
            r14 = r50
            r15 = r51
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r35
            r1.updateScope(r0)
        L_0x0353:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedFilterChip(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x03c4  */
    /* JADX WARNING: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void InputChip(boolean r44, kotlin.jvm.functions.Function0<kotlin.Unit> r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.ui.Modifier r47, boolean r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.ui.graphics.Shape r52, androidx.compose.material3.SelectableChipColors r53, androidx.compose.material3.SelectableChipElevation r54, androidx.compose.foundation.BorderStroke r55, androidx.compose.foundation.interaction.MutableInteractionSource r56, androidx.compose.runtime.Composer r57, int r58, int r59, int r60) {
        /*
            r14 = r58
            r15 = r59
            r13 = r60
            r0 = 1658928131(0x62e13c03, float:2.0774209E21)
            r1 = r57
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(InputChip)P(10,9,6,8,4,7!1,12,11,2,3)593@30171L5,594@30231L17,595@30310L20,596@30378L34,597@30464L39,624@31431L10,618@31241L747:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001d
            r1 = r14 | 6
            r12 = r44
            goto L_0x002f
        L_0x001d:
            r1 = r14 & 6
            r12 = r44
            if (r1 != 0) goto L_0x002e
            boolean r1 = r11.changed((boolean) r12)
            if (r1 == 0) goto L_0x002b
            r1 = 4
            goto L_0x002c
        L_0x002b:
            r1 = 2
        L_0x002c:
            r1 = r1 | r14
            goto L_0x002f
        L_0x002e:
            r1 = r14
        L_0x002f:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0038
            r1 = r1 | 48
            r10 = r45
            goto L_0x004a
        L_0x0038:
            r4 = r14 & 48
            r10 = r45
            if (r4 != 0) goto L_0x004a
            boolean r4 = r11.changedInstance(r10)
            if (r4 == 0) goto L_0x0047
            r4 = 32
            goto L_0x0049
        L_0x0047:
            r4 = 16
        L_0x0049:
            r1 = r1 | r4
        L_0x004a:
            r4 = r13 & 4
            if (r4 == 0) goto L_0x0053
            r1 = r1 | 384(0x180, float:5.38E-43)
            r9 = r46
            goto L_0x0065
        L_0x0053:
            r4 = r14 & 384(0x180, float:5.38E-43)
            r9 = r46
            if (r4 != 0) goto L_0x0065
            boolean r4 = r11.changedInstance(r9)
            if (r4 == 0) goto L_0x0062
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r1 = r1 | r4
        L_0x0065:
            r4 = r13 & 8
            if (r4 == 0) goto L_0x006c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006c:
            r2 = r14 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0080
            r2 = r47
            boolean r16 = r11.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x007b
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r1 = r1 | r16
            goto L_0x0082
        L_0x0080:
            r2 = r47
        L_0x0082:
            r16 = r13 & 16
            if (r16 == 0) goto L_0x0089
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x0089:
            r3 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x009d
            r3 = r48
            boolean r18 = r11.changed((boolean) r3)
            if (r18 == 0) goto L_0x0098
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r1 = r1 | r18
            goto L_0x009f
        L_0x009d:
            r3 = r48
        L_0x009f:
            r18 = r13 & 32
            r19 = 196608(0x30000, float:2.75506E-40)
            if (r18 == 0) goto L_0x00aa
            r1 = r1 | r19
            r5 = r49
            goto L_0x00bd
        L_0x00aa:
            r19 = r14 & r19
            r5 = r49
            if (r19 != 0) goto L_0x00bd
            boolean r20 = r11.changedInstance(r5)
            if (r20 == 0) goto L_0x00b9
            r20 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r20 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r1 = r1 | r20
        L_0x00bd:
            r20 = r13 & 64
            r21 = 1572864(0x180000, float:2.204052E-39)
            if (r20 == 0) goto L_0x00c8
            r1 = r1 | r21
            r6 = r50
            goto L_0x00db
        L_0x00c8:
            r21 = r14 & r21
            r6 = r50
            if (r21 != 0) goto L_0x00db
            boolean r22 = r11.changedInstance(r6)
            if (r22 == 0) goto L_0x00d7
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r1 = r1 | r22
        L_0x00db:
            r7 = r13 & 128(0x80, float:1.794E-43)
            r23 = 12582912(0xc00000, float:1.7632415E-38)
            if (r7 == 0) goto L_0x00e6
            r1 = r1 | r23
            r8 = r51
            goto L_0x00f9
        L_0x00e6:
            r23 = r14 & r23
            r8 = r51
            if (r23 != 0) goto L_0x00f9
            boolean r24 = r11.changedInstance(r8)
            if (r24 == 0) goto L_0x00f5
            r24 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f7
        L_0x00f5:
            r24 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f7:
            r1 = r1 | r24
        L_0x00f9:
            r24 = 100663296(0x6000000, float:2.4074124E-35)
            r24 = r14 & r24
            if (r24 != 0) goto L_0x0115
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x010e
            r0 = r52
            boolean r24 = r11.changed((java.lang.Object) r0)
            if (r24 == 0) goto L_0x0110
            r24 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0112
        L_0x010e:
            r0 = r52
        L_0x0110:
            r24 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0112:
            r1 = r1 | r24
            goto L_0x0117
        L_0x0115:
            r0 = r52
        L_0x0117:
            r24 = 805306368(0x30000000, float:4.656613E-10)
            r24 = r14 & r24
            if (r24 != 0) goto L_0x0133
            r0 = r13 & 512(0x200, float:7.175E-43)
            if (r0 != 0) goto L_0x012c
            r0 = r53
            boolean r24 = r11.changed((java.lang.Object) r0)
            if (r24 == 0) goto L_0x012e
            r24 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0130
        L_0x012c:
            r0 = r53
        L_0x012e:
            r24 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0130:
            r1 = r1 | r24
            goto L_0x0135
        L_0x0133:
            r0 = r53
        L_0x0135:
            r24 = r15 & 6
            if (r24 != 0) goto L_0x014f
            r0 = r13 & 1024(0x400, float:1.435E-42)
            if (r0 != 0) goto L_0x0148
            r0 = r54
            boolean r24 = r11.changed((java.lang.Object) r0)
            if (r24 == 0) goto L_0x014a
            r17 = 4
            goto L_0x014c
        L_0x0148:
            r0 = r54
        L_0x014a:
            r17 = 2
        L_0x014c:
            r17 = r15 | r17
            goto L_0x0153
        L_0x014f:
            r0 = r54
            r17 = r15
        L_0x0153:
            r24 = r15 & 48
            if (r24 != 0) goto L_0x016d
            r0 = r13 & 2048(0x800, float:2.87E-42)
            if (r0 != 0) goto L_0x0166
            r0 = r55
            boolean r24 = r11.changed((java.lang.Object) r0)
            if (r24 == 0) goto L_0x0168
            r19 = 32
            goto L_0x016a
        L_0x0166:
            r0 = r55
        L_0x0168:
            r19 = 16
        L_0x016a:
            r17 = r17 | r19
            goto L_0x016f
        L_0x016d:
            r0 = r55
        L_0x016f:
            r0 = r17
            r10 = r13 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0178
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x018c
        L_0x0178:
            r2 = r15 & 384(0x180, float:5.38E-43)
            if (r2 != 0) goto L_0x018c
            r2 = r56
            boolean r17 = r11.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x0187
            r22 = 256(0x100, float:3.59E-43)
            goto L_0x0189
        L_0x0187:
            r22 = 128(0x80, float:1.794E-43)
        L_0x0189:
            r0 = r0 | r22
            goto L_0x018e
        L_0x018c:
            r2 = r56
        L_0x018e:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r2 = r1 & r17
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r3) goto L_0x01ba
            r2 = r0 & 147(0x93, float:2.06E-43)
            r3 = 146(0x92, float:2.05E-43)
            if (r2 != r3) goto L_0x01ba
            boolean r2 = r11.getSkipping()
            if (r2 != 0) goto L_0x01a5
            goto L_0x01ba
        L_0x01a5:
            r11.skipToGroupEnd()
            r4 = r47
            r9 = r52
            r10 = r53
            r12 = r54
            r16 = r55
            r17 = r56
            r7 = r6
            r6 = r5
            r5 = r48
            goto L_0x03be
        L_0x01ba:
            r11.startDefaults()
            r2 = r14 & 1
            r33 = 0
            r3 = 6
            r17 = r10
            r10 = 1
            if (r2 == 0) goto L_0x0204
            boolean r2 = r11.getDefaultsInvalid()
            if (r2 == 0) goto L_0x01ce
            goto L_0x0204
        L_0x01ce:
            r11.skipToGroupEnd()
            r2 = r13 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x01d9
            r2 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r2
        L_0x01d9:
            r2 = r13 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x01e1
            r2 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r2
        L_0x01e1:
            r2 = r13 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x01e7
            r0 = r0 & -15
        L_0x01e7:
            r2 = r13 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x01ed
            r0 = r0 & -113(0xffffffffffffff8f, float:NaN)
        L_0x01ed:
            r35 = r48
            r39 = r52
            r40 = r53
            r2 = r55
            r3 = r56
            r4 = r0
            r36 = r5
            r38 = r8
            r12 = r10
            r0 = r47
            r5 = r1
            r1 = r54
            goto L_0x02dd
        L_0x0204:
            if (r4 == 0) goto L_0x020d
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r34 = r2
            goto L_0x020f
        L_0x020d:
            r34 = r47
        L_0x020f:
            if (r16 == 0) goto L_0x0214
            r35 = r10
            goto L_0x0216
        L_0x0214:
            r35 = r48
        L_0x0216:
            if (r18 == 0) goto L_0x021b
            r36 = r33
            goto L_0x021d
        L_0x021b:
            r36 = r5
        L_0x021d:
            if (r20 == 0) goto L_0x0222
            r37 = r33
            goto L_0x0224
        L_0x0222:
            r37 = r6
        L_0x0224:
            if (r7 == 0) goto L_0x0229
            r38 = r33
            goto L_0x022b
        L_0x0229:
            r38 = r8
        L_0x022b:
            r2 = r13 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x023c
            androidx.compose.material3.InputChipDefaults r2 = androidx.compose.material3.InputChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r11, r3)
            r4 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r4
            r39 = r2
            goto L_0x023e
        L_0x023c:
            r39 = r52
        L_0x023e:
            r2 = r13 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0251
            androidx.compose.material3.InputChipDefaults r2 = androidx.compose.material3.InputChipDefaults.INSTANCE
            androidx.compose.material3.SelectableChipColors r2 = r2.inputChipColors(r11, r3)
            r4 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r4
            r41 = r1
            r40 = r2
            goto L_0x0255
        L_0x0251:
            r40 = r53
            r41 = r1
        L_0x0255:
            r1 = r13 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0279
            androidx.compose.material3.InputChipDefaults r1 = androidx.compose.material3.InputChipDefaults.INSTANCE
            r16 = 1572864(0x180000, float:2.204052E-39)
            r18 = 63
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r11
            r9 = r16
            r12 = r10
            r42 = r17
            r10 = r18
            androidx.compose.material3.SelectableChipElevation r1 = r1.m1916inputChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r0 & -15
            goto L_0x027e
        L_0x0279:
            r12 = r10
            r42 = r17
            r1 = r54
        L_0x027e:
            r2 = r13 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x02ac
            androidx.compose.material3.InputChipDefaults r16 = androidx.compose.material3.InputChipDefaults.INSTANCE
            int r2 = r41 >> 12
            r2 = r2 & 14
            r3 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 | r3
            int r3 = r41 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r30 = r2 | r3
            r31 = 252(0xfc, float:3.53E-43)
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r17 = r35
            r18 = r44
            r29 = r11
            androidx.compose.foundation.BorderStroke r2 = r16.m1914inputChipBorder_7El2pE(r17, r18, r19, r21, r23, r25, r27, r28, r29, r30, r31)
            r0 = r0 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02ae
        L_0x02ac:
            r2 = r55
        L_0x02ae:
            if (r42 == 0) goto L_0x02d4
            r3 = -1371993939(0xffffffffae3908ad, float:-4.2071836E-11)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            java.lang.Object r3 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x02ce
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r3)
        L_0x02ce:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            r11.endReplaceableGroup()
            goto L_0x02d6
        L_0x02d4:
            r3 = r56
        L_0x02d6:
            r4 = r0
            r0 = r34
            r6 = r37
            r5 = r41
        L_0x02dd:
            r11.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x02ee
            java.lang.String r7 = "androidx.compose.material3.InputChip (Chip.kt:598)"
            r8 = 1658928131(0x62e13c03, float:2.0774209E21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r5, r4, r7)
        L_0x02ee:
            r7 = -1371993712(0xffffffffae390990, float:-4.2072623E-11)
            r11.startReplaceableGroup(r7)
            java.lang.String r7 = "604@30854L5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r7)
            if (r6 == 0) goto L_0x031f
            if (r35 == 0) goto L_0x0300
            r7 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0303
        L_0x0300:
            r7 = 1052938076(0x3ec28f5c, float:0.38)
        L_0x0303:
            androidx.compose.material3.tokens.InputChipTokens r8 = androidx.compose.material3.tokens.InputChipTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r8 = r8.getAvatarShape()
            r9 = 6
            androidx.compose.ui.graphics.Shape r8 = androidx.compose.material3.ShapesKt.getValue(r8, r11, r9)
            androidx.compose.material3.ChipKt$InputChip$2 r10 = new androidx.compose.material3.ChipKt$InputChip$2
            r10.<init>(r7, r8, r6)
            r7 = 1154227507(0x44cc1d33, float:1632.9125)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r7, r12, r10)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r23 = r7
            goto L_0x0322
        L_0x031f:
            r9 = 6
            r23 = r33
        L_0x0322:
            r11.endReplaceableGroup()
            androidx.compose.material3.MaterialTheme r7 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r7 = r7.getTypography(r11, r9)
            androidx.compose.material3.tokens.InputChipTokens r8 = androidx.compose.material3.tokens.InputChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r8 = r8.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r21 = androidx.compose.material3.TypographyKt.fromToken(r7, r8)
            androidx.compose.material3.InputChipDefaults r7 = androidx.compose.material3.InputChipDefaults.INSTANCE
            float r29 = r7.m1912getHeightD9Ej5fM()
            r10 = 0
            if (r23 == 0) goto L_0x0340
            r7 = r12
            goto L_0x0341
        L_0x0340:
            r7 = r10
        L_0x0341:
            if (r36 == 0) goto L_0x0345
            r8 = r12
            goto L_0x0346
        L_0x0345:
            r8 = r10
        L_0x0346:
            if (r38 == 0) goto L_0x0349
            r10 = r12
        L_0x0349:
            androidx.compose.foundation.layout.PaddingValues r30 = inputChipPadding(r7, r8, r10)
            r7 = r5 & 14
            int r8 = r5 >> 6
            r8 = r8 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            int r8 = r5 << 3
            r9 = r8 & 896(0x380, float:1.256E-42)
            r7 = r7 | r9
            int r9 = r5 >> 3
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r9
            int r9 = r5 << 6
            r10 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r10
            r7 = r7 | r9
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r8
            r7 = r7 | r9
            r9 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r8
            r7 = r7 | r9
            r9 = 1879048192(0x70000000, float:1.58456325E29)
            r8 = r8 & r9
            r33 = r7 | r8
            int r5 = r5 >> 27
            r5 = r5 & 14
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            int r7 = r4 << 3
            r8 = r7 & 112(0x70, float:1.57E-43)
            r5 = r5 | r8
            r7 = r7 & 896(0x380, float:1.256E-42)
            r5 = r5 | r7
            int r4 = r4 << 9
            r7 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r7
            r34 = r5 | r4
            r16 = r44
            r17 = r0
            r18 = r45
            r19 = r35
            r20 = r46
            r22 = r36
            r24 = r38
            r25 = r39
            r26 = r40
            r27 = r1
            r28 = r2
            r31 = r3
            r32 = r11
            m1628SelectableChipu0RnIRE(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x03ad
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03ad:
            r4 = r0
            r12 = r1
            r16 = r2
            r17 = r3
            r7 = r6
            r5 = r35
            r6 = r36
            r8 = r38
            r9 = r39
            r10 = r40
        L_0x03be:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 == 0) goto L_0x03e7
            androidx.compose.material3.ChipKt$InputChip$3 r18 = new androidx.compose.material3.ChipKt$InputChip$3
            r0 = r18
            r1 = r44
            r2 = r45
            r3 = r46
            r43 = r11
            r11 = r12
            r12 = r16
            r13 = r17
            r14 = r58
            r15 = r59
            r16 = r60
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r43
            r1.updateScope(r0)
        L_0x03e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.InputChip(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SelectableChipColors, androidx.compose.material3.SelectableChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SuggestionChip(kotlin.jvm.functions.Function0<kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r11 = r43
            r12 = r44
            r0 = -1700130831(0xffffffff9aaa0ff1, float:-7.0336107E-23)
            r1 = r42
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SuggestionChip)P(8,6,7,3,4,9,1,2)688@34668L5,689@34723L22,690@34802L25,691@34880L29,692@34961L39,698@35137L10,693@35006L504:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r14 = r32
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r14 = r32
            if (r1 != 0) goto L_0x002c
            boolean r1 = r15.changedInstance(r14)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r33
            goto L_0x0048
        L_0x0036:
            r2 = r11 & 48
            r13 = r33
            if (r2 != 0) goto L_0x0048
            boolean r2 = r15.changedInstance(r13)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r34
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r34
        L_0x0064:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r35
            boolean r6 = r15.changed((boolean) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r35
        L_0x0080:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r36
            boolean r8 = r15.changedInstance(r7)
            if (r8 == 0) goto L_0x0096
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r8
            goto L_0x009c
        L_0x009a:
            r7 = r36
        L_0x009c:
            r8 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00b6
            r8 = r12 & 32
            if (r8 != 0) goto L_0x00b0
            r8 = r37
            boolean r9 = r15.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00b2
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r8 = r37
        L_0x00b2:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r9
            goto L_0x00b8
        L_0x00b6:
            r8 = r37
        L_0x00b8:
            r9 = 1572864(0x180000, float:2.204052E-39)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00d2
            r9 = r12 & 64
            if (r9 != 0) goto L_0x00cc
            r9 = r38
            boolean r10 = r15.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00ce
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r9 = r38
        L_0x00ce:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r10
            goto L_0x00d4
        L_0x00d2:
            r9 = r38
        L_0x00d4:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r10 = r11 & r16
            if (r10 != 0) goto L_0x00f0
            r10 = r12 & 128(0x80, float:1.794E-43)
            if (r10 != 0) goto L_0x00e9
            r10 = r39
            boolean r17 = r15.changed((java.lang.Object) r10)
            if (r17 == 0) goto L_0x00eb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r10 = r39
        L_0x00eb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r1 = r1 | r17
            goto L_0x00f2
        L_0x00f0:
            r10 = r39
        L_0x00f2:
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r17 = r11 & r17
            if (r17 != 0) goto L_0x010e
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0107
            r0 = r40
            boolean r18 = r15.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x0109
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010b
        L_0x0107:
            r0 = r40
        L_0x0109:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010b:
            r1 = r1 | r18
            goto L_0x0110
        L_0x010e:
            r0 = r40
        L_0x0110:
            r10 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r10 == 0) goto L_0x0119
            r1 = r1 | r18
            goto L_0x012f
        L_0x0119:
            r18 = r11 & r18
            if (r18 != 0) goto L_0x012f
            r18 = r10
            r10 = r41
            boolean r19 = r15.changed((java.lang.Object) r10)
            if (r19 == 0) goto L_0x012a
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012c
        L_0x012a:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012c:
            r1 = r1 | r19
            goto L_0x0133
        L_0x012f:
            r18 = r10
            r10 = r41
        L_0x0133:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r19
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x0154
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x0144
            goto L_0x0154
        L_0x0144:
            r15.skipToGroupEnd()
            r3 = r34
            r4 = r5
            r5 = r7
            r6 = r8
            r7 = r9
            r0 = r15
            r8 = r39
            r9 = r40
            goto L_0x02e0
        L_0x0154:
            r15.startDefaults()
            r0 = r11 & 1
            r19 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r20 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r21 = -458753(0xfffffffffff8ffff, float:NaN)
            r10 = 6
            if (r0 == 0) goto L_0x0195
            boolean r0 = r15.getDefaultsInvalid()
            if (r0 == 0) goto L_0x016f
            goto L_0x0195
        L_0x016f:
            r15.skipToGroupEnd()
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0178
            r1 = r1 & r21
        L_0x0178:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x017d
            r1 = r1 & r3
        L_0x017d:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0183
            r1 = r1 & r20
        L_0x0183:
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0189
            r1 = r1 & r19
        L_0x0189:
            r2 = r39
            r3 = r40
            r4 = r41
            r6 = r1
            r0 = r10
        L_0x0191:
            r1 = r34
            goto L_0x0251
        L_0x0195:
            if (r2 == 0) goto L_0x019c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x019e
        L_0x019c:
            r0 = r34
        L_0x019e:
            if (r4 == 0) goto L_0x01a4
            r2 = 1
            r22 = r2
            goto L_0x01a6
        L_0x01a4:
            r22 = r5
        L_0x01a6:
            if (r6 == 0) goto L_0x01ac
            r2 = 0
            r23 = r2
            goto L_0x01ae
        L_0x01ac:
            r23 = r7
        L_0x01ae:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x01bd
            androidx.compose.material3.SuggestionChipDefaults r2 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r15, r10)
            r1 = r1 & r21
            r21 = r2
            goto L_0x01bf
        L_0x01bd:
            r21 = r8
        L_0x01bf:
            r2 = r12 & 64
            if (r2 == 0) goto L_0x01cf
            androidx.compose.material3.SuggestionChipDefaults r2 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r2 = r2.suggestionChipColors(r15, r10)
            r1 = r1 & r3
            r25 = r1
            r24 = r2
            goto L_0x01d3
        L_0x01cf:
            r25 = r1
            r24 = r9
        L_0x01d3:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01f2
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r26 = 63
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = r15
            r34 = r0
            r0 = r10
            r10 = r26
            androidx.compose.material3.ChipElevation r1 = r1.m2302suggestionChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r25 = r25 & r20
            r20 = r1
            goto L_0x01f7
        L_0x01f2:
            r34 = r0
            r0 = r10
            r20 = r39
        L_0x01f7:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0216
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            int r2 = r25 >> 9
            r2 = r2 & 14
            r9 = r2 | 24576(0x6000, float:3.4438E-41)
            r10 = 14
            r3 = 0
            r5 = 0
            r7 = 0
            r2 = r22
            r8 = r15
            androidx.compose.foundation.BorderStroke r1 = r1.m2300suggestionChipBorderh1eTWw(r2, r3, r5, r7, r8, r9, r10)
            r2 = r25 & r19
            r25 = r2
            goto L_0x0218
        L_0x0216:
            r1 = r40
        L_0x0218:
            if (r18 == 0) goto L_0x0240
            r2 = 2118462942(0x7e452dde, float:6.552402E37)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            java.lang.Object r2 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0238
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r15.updateRememberedValue(r2)
        L_0x0238:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r15.endReplaceableGroup()
            r3 = r1
            r4 = r2
            goto L_0x0243
        L_0x0240:
            r4 = r41
            r3 = r1
        L_0x0243:
            r2 = r20
            r8 = r21
            r5 = r22
            r7 = r23
            r9 = r24
            r6 = r25
            goto L_0x0191
        L_0x0251:
            r15.endDefaults()
            boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r10 == 0) goto L_0x0263
            r10 = -1
            java.lang.String r0 = "androidx.compose.material3.SuggestionChip (Chip.kt:693)"
            r11 = -1700130831(0xffffffff9aaa0ff1, float:-7.0336107E-23)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r6, r10, r0)
        L_0x0263:
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            r10 = 6
            androidx.compose.material3.Typography r0 = r0.getTypography(r15, r10)
            androidx.compose.material3.tokens.SuggestionChipTokens r10 = androidx.compose.material3.tokens.SuggestionChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r10 = r10.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material3.TypographyKt.fromToken(r0, r10)
            long r18 = r9.m1616labelColorvNxB06k$material3_release(r5)
            androidx.compose.material3.SuggestionChipDefaults r0 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            float r26 = r0.m2297getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r27 = SuggestionChipPadding
            int r0 = r6 >> 6
            r0 = r0 & 14
            r0 = r0 | r16
            int r10 = r6 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r0 = r0 | r10
            int r10 = r6 >> 3
            r10 = r10 & 896(0x380, float:1.256E-42)
            r0 = r0 | r10
            int r10 = r6 << 6
            r11 = r10 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r11
            r0 = r0 | r10
            int r10 = r6 << 9
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r10
            r0 = r0 | r11
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r10 = r10 & r11
            r30 = r0 | r10
            int r0 = r6 >> 21
            r10 = r0 & 14
            r10 = r10 | 3456(0xd80, float:4.843E-42)
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r10
            int r6 = r6 >> 15
            r10 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r10
            r31 = r0 | r6
            r21 = 0
            r13 = r1
            r14 = r32
            r0 = r15
            r15 = r5
            r16 = r33
            r20 = r7
            r22 = r8
            r23 = r9
            r24 = r2
            r25 = r3
            r28 = r4
            r29 = r0
            m1626ChipnkUnTEs(r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x02d8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02d8:
            r10 = r4
            r4 = r5
            r5 = r7
            r6 = r8
            r7 = r9
            r8 = r2
            r9 = r3
            r3 = r1
        L_0x02e0:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 == 0) goto L_0x02f9
            androidx.compose.material3.ChipKt$SuggestionChip$2 r14 = new androidx.compose.material3.ChipKt$SuggestionChip$2
            r0 = r14
            r1 = r32
            r2 = r33
            r11 = r43
            r12 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x02f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.SuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x010e  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "SuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void SuggestionChip(kotlin.jvm.functions.Function0 r32, kotlin.jvm.functions.Function2 r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.material3.ChipBorder r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r11 = r43
            r12 = r44
            r0 = 170629701(0xa2b9a45, float:8.2623654E-33)
            r1 = r42
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SuggestionChip)P(8,6,7,3,4,9,1,2)765@38541L5,766@38596L22,767@38675L25,768@38751L22,769@38825L39,775@39001L10,770@38870L534:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r14 = r32
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r14 = r32
            if (r1 != 0) goto L_0x002c
            boolean r1 = r15.changedInstance(r14)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r33
            goto L_0x0048
        L_0x0036:
            r2 = r11 & 48
            r13 = r33
            if (r2 != 0) goto L_0x0048
            boolean r2 = r15.changedInstance(r13)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r34
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r34
        L_0x0064:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r35
            boolean r6 = r15.changed((boolean) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r35
        L_0x0080:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r36
            boolean r8 = r15.changedInstance(r7)
            if (r8 == 0) goto L_0x0096
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r8
            goto L_0x009c
        L_0x009a:
            r7 = r36
        L_0x009c:
            r8 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00b6
            r8 = r12 & 32
            if (r8 != 0) goto L_0x00b0
            r8 = r37
            boolean r9 = r15.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00b2
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r8 = r37
        L_0x00b2:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r9
            goto L_0x00b8
        L_0x00b6:
            r8 = r37
        L_0x00b8:
            r9 = 1572864(0x180000, float:2.204052E-39)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00d2
            r9 = r12 & 64
            if (r9 != 0) goto L_0x00cc
            r9 = r38
            boolean r10 = r15.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00ce
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r9 = r38
        L_0x00ce:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r10
            goto L_0x00d4
        L_0x00d2:
            r9 = r38
        L_0x00d4:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r10 = r11 & r16
            if (r10 != 0) goto L_0x00f0
            r10 = r12 & 128(0x80, float:1.794E-43)
            if (r10 != 0) goto L_0x00e9
            r10 = r39
            boolean r17 = r15.changed((java.lang.Object) r10)
            if (r17 == 0) goto L_0x00eb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r10 = r39
        L_0x00eb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r1 = r1 | r17
            goto L_0x00f2
        L_0x00f0:
            r10 = r39
        L_0x00f2:
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r17 = r11 & r17
            if (r17 != 0) goto L_0x010e
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0107
            r0 = r40
            boolean r18 = r15.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x0109
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010b
        L_0x0107:
            r0 = r40
        L_0x0109:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010b:
            r1 = r1 | r18
            goto L_0x0110
        L_0x010e:
            r0 = r40
        L_0x0110:
            r10 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r10 == 0) goto L_0x0119
            r1 = r1 | r18
            goto L_0x012f
        L_0x0119:
            r18 = r11 & r18
            if (r18 != 0) goto L_0x012f
            r18 = r10
            r10 = r41
            boolean r19 = r15.changed((java.lang.Object) r10)
            if (r19 == 0) goto L_0x012a
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012c
        L_0x012a:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012c:
            r1 = r1 | r19
            goto L_0x0133
        L_0x012f:
            r18 = r10
            r10 = r41
        L_0x0133:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r0 = r1 & r19
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x0154
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x0144
            goto L_0x0154
        L_0x0144:
            r15.skipToGroupEnd()
            r3 = r34
            r4 = r5
            r5 = r7
            r6 = r8
            r7 = r9
            r0 = r15
            r8 = r39
            r9 = r40
            goto L_0x0309
        L_0x0154:
            r15.startDefaults()
            r0 = r11 & 1
            r19 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r20 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r21 = -458753(0xfffffffffff8ffff, float:NaN)
            r22 = 0
            r10 = 6
            if (r0 == 0) goto L_0x0197
            boolean r0 = r15.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0171
            goto L_0x0197
        L_0x0171:
            r15.skipToGroupEnd()
            r0 = r12 & 32
            if (r0 == 0) goto L_0x017a
            r1 = r1 & r21
        L_0x017a:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x017f
            r1 = r1 & r3
        L_0x017f:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0185
            r1 = r1 & r20
        L_0x0185:
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x018b
            r1 = r1 & r19
        L_0x018b:
            r2 = r40
            r3 = r41
            r4 = r1
            r0 = r10
            r1 = r34
            r10 = r39
            goto L_0x0252
        L_0x0197:
            if (r2 == 0) goto L_0x019e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01a0
        L_0x019e:
            r0 = r34
        L_0x01a0:
            if (r4 == 0) goto L_0x01a6
            r2 = 1
            r23 = r2
            goto L_0x01a8
        L_0x01a6:
            r23 = r5
        L_0x01a8:
            if (r6 == 0) goto L_0x01ad
            r24 = r22
            goto L_0x01af
        L_0x01ad:
            r24 = r7
        L_0x01af:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x01be
            androidx.compose.material3.SuggestionChipDefaults r2 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r15, r10)
            r1 = r1 & r21
            r21 = r2
            goto L_0x01c0
        L_0x01be:
            r21 = r8
        L_0x01c0:
            r2 = r12 & 64
            if (r2 == 0) goto L_0x01d0
            androidx.compose.material3.SuggestionChipDefaults r2 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r2 = r2.suggestionChipColors(r15, r10)
            r1 = r1 & r3
            r26 = r1
            r25 = r2
            goto L_0x01d4
        L_0x01d0:
            r26 = r1
            r25 = r9
        L_0x01d4:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01f2
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r27 = 63
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = r15
            r34 = r0
            r0 = r10
            r10 = r27
            androidx.compose.material3.ChipElevation r1 = r1.m2302suggestionChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r26 = r26 & r20
            r10 = r1
            goto L_0x01f7
        L_0x01f2:
            r34 = r0
            r0 = r10
            r10 = r39
        L_0x01f7:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x020f
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            r8 = 3072(0xc00, float:4.305E-42)
            r9 = 7
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = r15
            androidx.compose.material3.ChipBorder r1 = r1.m2299suggestionChipBorderd_3_b6Q(r2, r4, r6, r7, r8, r9)
            r2 = r26 & r19
            r26 = r2
            goto L_0x0211
        L_0x020f:
            r1 = r40
        L_0x0211:
            if (r18 == 0) goto L_0x0243
            r2 = 2118466806(0x7e453cf6, float:6.554361E37)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            java.lang.Object r2 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0231
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r15.updateRememberedValue(r2)
        L_0x0231:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r15.endReplaceableGroup()
            r3 = r2
            r8 = r21
            r5 = r23
            r7 = r24
            r9 = r25
            r4 = r26
            r2 = r1
            goto L_0x0250
        L_0x0243:
            r3 = r41
            r2 = r1
            r8 = r21
            r5 = r23
            r7 = r24
            r9 = r25
            r4 = r26
        L_0x0250:
            r1 = r34
        L_0x0252:
            r15.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0264
            r6 = -1
            java.lang.String r0 = "androidx.compose.material3.SuggestionChip (Chip.kt:770)"
            r11 = 170629701(0xa2b9a45, float:8.2623654E-33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r4, r6, r0)
        L_0x0264:
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            r6 = 6
            androidx.compose.material3.Typography r0 = r0.getTypography(r15, r6)
            androidx.compose.material3.tokens.SuggestionChipTokens r6 = androidx.compose.material3.tokens.SuggestionChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r6 = r6.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material3.TypographyKt.fromToken(r0, r6)
            long r18 = r9.m1616labelColorvNxB06k$material3_release(r5)
            r0 = 2118467222(0x7e453e96, float:6.554572E37)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "782@39241L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            if (r2 != 0) goto L_0x0289
            r0 = r22
            goto L_0x0296
        L_0x0289:
            int r0 = r4 >> 9
            r0 = r0 & 14
            int r6 = r4 >> 21
            r6 = r6 & 112(0x70, float:1.57E-43)
            r0 = r0 | r6
            androidx.compose.runtime.State r0 = r2.borderStroke$material3_release(r5, r15, r0)
        L_0x0296:
            r15.endReplaceableGroup()
            if (r0 == 0) goto L_0x02a4
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.BorderStroke r0 = (androidx.compose.foundation.BorderStroke) r0
            r25 = r0
            goto L_0x02a6
        L_0x02a4:
            r25 = r22
        L_0x02a6:
            androidx.compose.material3.SuggestionChipDefaults r0 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            float r26 = r0.m2297getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r27 = SuggestionChipPadding
            int r0 = r4 >> 6
            r0 = r0 & 14
            r0 = r0 | r16
            int r6 = r4 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r0 = r0 | r6
            int r6 = r4 >> 3
            r6 = r6 & 896(0x380, float:1.256E-42)
            r0 = r0 | r6
            int r6 = r4 << 6
            r11 = r6 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r11
            r0 = r0 | r6
            int r6 = r4 << 9
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r6
            r0 = r0 | r11
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = r6 & r11
            r30 = r0 | r6
            int r0 = r4 >> 21
            r0 = r0 & 14
            r0 = r0 | 3456(0xd80, float:4.843E-42)
            int r4 = r4 >> 15
            r6 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r6
            r31 = r0 | r4
            r21 = 0
            r13 = r1
            r14 = r32
            r0 = r15
            r15 = r5
            r16 = r33
            r20 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r28 = r3
            r29 = r0
            m1626ChipnkUnTEs(r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0301
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0301:
            r4 = r5
            r5 = r7
            r6 = r8
            r7 = r9
            r8 = r10
            r9 = r2
            r10 = r3
            r3 = r1
        L_0x0309:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 == 0) goto L_0x0322
            androidx.compose.material3.ChipKt$SuggestionChip$4 r14 = new androidx.compose.material3.ChipKt$SuggestionChip$4
            r0 = r14
            r1 = r32
            r2 = r33
            r11 = r43
            r12 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x0322:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.SuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ElevatedSuggestionChip(kotlin.jvm.functions.Function0<kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r11 = r43
            r12 = r44
            r0 = -818834969(0xffffffffcf3191e7, float:-2.97912909E9)
            r1 = r42
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)833@42061L5,834@42116L30,835@42203L33,837@42322L39,843@42498L10,838@42367L504:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r14 = r32
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r14 = r32
            if (r1 != 0) goto L_0x002c
            boolean r1 = r15.changedInstance(r14)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r33
            goto L_0x0048
        L_0x0036:
            r2 = r11 & 48
            r13 = r33
            if (r2 != 0) goto L_0x0048
            boolean r2 = r15.changedInstance(r13)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r34
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r34
        L_0x0064:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r35
            boolean r6 = r15.changed((boolean) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r35
        L_0x0080:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r36
            boolean r8 = r15.changedInstance(r7)
            if (r8 == 0) goto L_0x0096
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r8
            goto L_0x009c
        L_0x009a:
            r7 = r36
        L_0x009c:
            r8 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00b6
            r8 = r12 & 32
            if (r8 != 0) goto L_0x00b0
            r8 = r37
            boolean r9 = r15.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00b2
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r8 = r37
        L_0x00b2:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r9
            goto L_0x00b8
        L_0x00b6:
            r8 = r37
        L_0x00b8:
            r9 = 1572864(0x180000, float:2.204052E-39)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00d2
            r9 = r12 & 64
            if (r9 != 0) goto L_0x00cc
            r9 = r38
            boolean r10 = r15.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00ce
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r9 = r38
        L_0x00ce:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r10
            goto L_0x00d4
        L_0x00d2:
            r9 = r38
        L_0x00d4:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r10 = r11 & r16
            if (r10 != 0) goto L_0x00f0
            r10 = r12 & 128(0x80, float:1.794E-43)
            if (r10 != 0) goto L_0x00e9
            r10 = r39
            boolean r17 = r15.changed((java.lang.Object) r10)
            if (r17 == 0) goto L_0x00eb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r10 = r39
        L_0x00eb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r1 = r1 | r17
            goto L_0x00f2
        L_0x00f0:
            r10 = r39
        L_0x00f2:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fd
            r1 = r1 | r18
            r10 = r40
            goto L_0x0110
        L_0x00fd:
            r18 = r11 & r18
            r10 = r40
            if (r18 != 0) goto L_0x0110
            boolean r18 = r15.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x010c
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010c:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r1 = r1 | r18
        L_0x0110:
            r10 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r10 == 0) goto L_0x0119
            r1 = r1 | r18
            goto L_0x012f
        L_0x0119:
            r18 = r11 & r18
            if (r18 != 0) goto L_0x012f
            r18 = r10
            r10 = r41
            boolean r19 = r15.changed((java.lang.Object) r10)
            if (r19 == 0) goto L_0x012a
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012c
        L_0x012a:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012c:
            r1 = r1 | r19
            goto L_0x0133
        L_0x012f:
            r18 = r10
            r10 = r41
        L_0x0133:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r3 = r1 & r19
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x0154
            boolean r3 = r15.getSkipping()
            if (r3 != 0) goto L_0x0144
            goto L_0x0154
        L_0x0144:
            r15.skipToGroupEnd()
            r3 = r34
            r4 = r35
            r6 = r8
            r11 = r10
            r5 = r15
            r8 = r39
            r10 = r40
            goto L_0x02b9
        L_0x0154:
            r15.startDefaults()
            r3 = r11 & 1
            r19 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r5 = -3670017(0xffffffffffc7ffff, float:NaN)
            r20 = -458753(0xfffffffffff8ffff, float:NaN)
            r10 = 6
            if (r3 == 0) goto L_0x018e
            boolean r3 = r15.getDefaultsInvalid()
            if (r3 == 0) goto L_0x016c
            goto L_0x018e
        L_0x016c:
            r15.skipToGroupEnd()
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0175
            r1 = r1 & r20
        L_0x0175:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x017a
            r1 = r1 & r5
        L_0x017a:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0180
            r1 = r1 & r19
        L_0x0180:
            r0 = r34
            r2 = r39
            r3 = r40
            r4 = r41
            r5 = r1
            r11 = r10
            r1 = r35
            goto L_0x022c
        L_0x018e:
            if (r2 == 0) goto L_0x0197
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r21 = r2
            goto L_0x0199
        L_0x0197:
            r21 = r34
        L_0x0199:
            if (r4 == 0) goto L_0x019f
            r2 = 1
            r22 = r2
            goto L_0x01a1
        L_0x019f:
            r22 = r35
        L_0x01a1:
            r23 = 0
            if (r6 == 0) goto L_0x01a8
            r24 = r23
            goto L_0x01aa
        L_0x01a8:
            r24 = r7
        L_0x01aa:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x01b9
            androidx.compose.material3.SuggestionChipDefaults r2 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r15, r10)
            r1 = r1 & r20
            r20 = r2
            goto L_0x01bb
        L_0x01b9:
            r20 = r8
        L_0x01bb:
            r2 = r12 & 64
            if (r2 == 0) goto L_0x01cb
            androidx.compose.material3.SuggestionChipDefaults r2 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r2 = r2.elevatedSuggestionChipColors(r15, r10)
            r1 = r1 & r5
            r26 = r1
            r25 = r2
            goto L_0x01cf
        L_0x01cb:
            r26 = r1
            r25 = r9
        L_0x01cf:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01ec
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r27 = 63
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = r15
            r11 = r10
            r10 = r27
            androidx.compose.material3.ChipElevation r1 = r1.m2296elevatedSuggestionChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = r26 & r19
            r26 = r2
            goto L_0x01ef
        L_0x01ec:
            r11 = r10
            r1 = r39
        L_0x01ef:
            if (r0 == 0) goto L_0x01f2
            goto L_0x01f4
        L_0x01f2:
            r23 = r40
        L_0x01f4:
            if (r18 == 0) goto L_0x021b
            r0 = -1455582059(0xffffffffa93d9495, float:-4.2095305E-14)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            java.lang.Object r0 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x0214
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r15.updateRememberedValue(r0)
        L_0x0214:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r15.endReplaceableGroup()
            r4 = r0
            goto L_0x021d
        L_0x021b:
            r4 = r41
        L_0x021d:
            r2 = r1
            r8 = r20
            r0 = r21
            r1 = r22
            r3 = r23
            r7 = r24
            r9 = r25
            r5 = r26
        L_0x022c:
            r15.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x023e
            r6 = -1
            java.lang.String r10 = "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:838)"
            r11 = -818834969(0xffffffffcf3191e7, float:-2.97912909E9)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r5, r6, r10)
        L_0x023e:
            androidx.compose.material3.MaterialTheme r6 = androidx.compose.material3.MaterialTheme.INSTANCE
            r10 = 6
            androidx.compose.material3.Typography r6 = r6.getTypography(r15, r10)
            androidx.compose.material3.tokens.SuggestionChipTokens r10 = androidx.compose.material3.tokens.SuggestionChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r10 = r10.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material3.TypographyKt.fromToken(r6, r10)
            long r18 = r9.m1616labelColorvNxB06k$material3_release(r1)
            androidx.compose.material3.SuggestionChipDefaults r6 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            float r26 = r6.m2297getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r27 = SuggestionChipPadding
            int r6 = r5 >> 6
            r6 = r6 & 14
            r6 = r6 | r16
            int r10 = r5 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r6 = r6 | r10
            int r10 = r5 >> 3
            r10 = r10 & 896(0x380, float:1.256E-42)
            r6 = r6 | r10
            int r10 = r5 << 6
            r11 = r10 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r11
            r6 = r6 | r10
            int r10 = r5 << 9
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r10
            r6 = r6 | r11
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r10 = r10 & r11
            r30 = r6 | r10
            int r6 = r5 >> 21
            r10 = r6 & 14
            r10 = r10 | 3456(0xd80, float:4.843E-42)
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | r10
            int r5 = r5 >> 15
            r10 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r10
            r31 = r6 | r5
            r21 = 0
            r13 = r0
            r14 = r32
            r5 = r15
            r15 = r1
            r16 = r33
            r20 = r7
            r22 = r8
            r23 = r9
            r24 = r2
            r25 = r3
            r28 = r4
            r29 = r5
            m1626ChipnkUnTEs(r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x02b3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02b3:
            r10 = r3
            r11 = r4
            r6 = r8
            r3 = r0
            r4 = r1
            r8 = r2
        L_0x02b9:
            androidx.compose.runtime.ScopeUpdateScope r13 = r5.endRestartGroup()
            if (r13 == 0) goto L_0x02d6
            androidx.compose.material3.ChipKt$ElevatedSuggestionChip$2 r14 = new androidx.compose.material3.ChipKt$ElevatedSuggestionChip$2
            r0 = r14
            r1 = r32
            r2 = r33
            r5 = r7
            r7 = r9
            r9 = r10
            r10 = r11
            r11 = r43
            r12 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x02d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedSuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0116  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith = @kotlin.ReplaceWith(expression = "ElevatedSuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void ElevatedSuggestionChip(kotlin.jvm.functions.Function0 r32, kotlin.jvm.functions.Function2 r33, androidx.compose.ui.Modifier r34, boolean r35, kotlin.jvm.functions.Function2 r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.material3.ChipColors r38, androidx.compose.material3.ChipElevation r39, androidx.compose.material3.ChipBorder r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r11 = r43
            r12 = r44
            r0 = 1668751803(0x637721bb, float:4.5587763E21)
            r1 = r42
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)909@45897L5,910@45952L30,911@46039L33,913@46156L39,919@46332L10,914@46201L534:Chip.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r11 | 6
            r14 = r32
            goto L_0x002d
        L_0x001b:
            r1 = r11 & 6
            r14 = r32
            if (r1 != 0) goto L_0x002c
            boolean r1 = r15.changedInstance(r14)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r11
            goto L_0x002d
        L_0x002c:
            r1 = r11
        L_0x002d:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            r13 = r33
            goto L_0x0048
        L_0x0036:
            r2 = r11 & 48
            r13 = r33
            if (r2 != 0) goto L_0x0048
            boolean r2 = r15.changedInstance(r13)
            if (r2 == 0) goto L_0x0045
            r2 = 32
            goto L_0x0047
        L_0x0045:
            r2 = 16
        L_0x0047:
            r1 = r1 | r2
        L_0x0048:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0062
            r3 = r34
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005e
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r4
            goto L_0x0064
        L_0x0062:
            r3 = r34
        L_0x0064:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x007e
            r5 = r35
            boolean r6 = r15.changed((boolean) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r35
        L_0x0080:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r7 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009a
            r7 = r36
            boolean r8 = r15.changedInstance(r7)
            if (r8 == 0) goto L_0x0096
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r8
            goto L_0x009c
        L_0x009a:
            r7 = r36
        L_0x009c:
            r8 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00b6
            r8 = r12 & 32
            if (r8 != 0) goto L_0x00b0
            r8 = r37
            boolean r9 = r15.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00b2
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r8 = r37
        L_0x00b2:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r9
            goto L_0x00b8
        L_0x00b6:
            r8 = r37
        L_0x00b8:
            r9 = 1572864(0x180000, float:2.204052E-39)
            r9 = r9 & r11
            if (r9 != 0) goto L_0x00d2
            r9 = r12 & 64
            if (r9 != 0) goto L_0x00cc
            r9 = r38
            boolean r10 = r15.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00ce
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00cc:
            r9 = r38
        L_0x00ce:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r1 = r1 | r10
            goto L_0x00d4
        L_0x00d2:
            r9 = r38
        L_0x00d4:
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r10 = r11 & r16
            if (r10 != 0) goto L_0x00f0
            r10 = r12 & 128(0x80, float:1.794E-43)
            if (r10 != 0) goto L_0x00e9
            r10 = r39
            boolean r17 = r15.changed((java.lang.Object) r10)
            if (r17 == 0) goto L_0x00eb
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ed
        L_0x00e9:
            r10 = r39
        L_0x00eb:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ed:
            r1 = r1 | r17
            goto L_0x00f2
        L_0x00f0:
            r10 = r39
        L_0x00f2:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fd
            r1 = r1 | r18
            r10 = r40
            goto L_0x0110
        L_0x00fd:
            r18 = r11 & r18
            r10 = r40
            if (r18 != 0) goto L_0x0110
            boolean r18 = r15.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x010c
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010e
        L_0x010c:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010e:
            r1 = r1 | r18
        L_0x0110:
            r10 = r12 & 512(0x200, float:7.175E-43)
            r18 = 805306368(0x30000000, float:4.656613E-10)
            if (r10 == 0) goto L_0x0119
            r1 = r1 | r18
            goto L_0x012f
        L_0x0119:
            r18 = r11 & r18
            if (r18 != 0) goto L_0x012f
            r18 = r10
            r10 = r41
            boolean r19 = r15.changed((java.lang.Object) r10)
            if (r19 == 0) goto L_0x012a
            r19 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012c
        L_0x012a:
            r19 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x012c:
            r1 = r1 | r19
            goto L_0x0133
        L_0x012f:
            r18 = r10
            r10 = r41
        L_0x0133:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r3 = r1 & r19
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x0154
            boolean r3 = r15.getSkipping()
            if (r3 != 0) goto L_0x0144
            goto L_0x0154
        L_0x0144:
            r15.skipToGroupEnd()
            r3 = r34
            r4 = r35
            r6 = r8
            r11 = r10
            r5 = r15
            r8 = r39
            r10 = r40
            goto L_0x02f0
        L_0x0154:
            r15.startDefaults()
            r3 = r11 & 1
            r19 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r5 = -3670017(0xffffffffffc7ffff, float:NaN)
            r20 = -458753(0xfffffffffff8ffff, float:NaN)
            r21 = 0
            r10 = 6
            if (r3 == 0) goto L_0x0190
            boolean r3 = r15.getDefaultsInvalid()
            if (r3 == 0) goto L_0x016e
            goto L_0x0190
        L_0x016e:
            r15.skipToGroupEnd()
            r0 = r12 & 32
            if (r0 == 0) goto L_0x0177
            r1 = r1 & r20
        L_0x0177:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x017c
            r1 = r1 & r5
        L_0x017c:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0182
            r1 = r1 & r19
        L_0x0182:
            r0 = r34
            r2 = r39
            r3 = r40
            r4 = r41
            r5 = r1
            r11 = r10
            r1 = r35
            goto L_0x023b
        L_0x0190:
            if (r2 == 0) goto L_0x0199
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r22 = r2
            goto L_0x019b
        L_0x0199:
            r22 = r34
        L_0x019b:
            if (r4 == 0) goto L_0x01a1
            r2 = 1
            r23 = r2
            goto L_0x01a3
        L_0x01a1:
            r23 = r35
        L_0x01a3:
            if (r6 == 0) goto L_0x01a8
            r24 = r21
            goto L_0x01aa
        L_0x01a8:
            r24 = r7
        L_0x01aa:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x01b9
            androidx.compose.material3.SuggestionChipDefaults r2 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r15, r10)
            r1 = r1 & r20
            r20 = r2
            goto L_0x01bb
        L_0x01b9:
            r20 = r8
        L_0x01bb:
            r2 = r12 & 64
            if (r2 == 0) goto L_0x01cb
            androidx.compose.material3.SuggestionChipDefaults r2 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            androidx.compose.material3.ChipColors r2 = r2.elevatedSuggestionChipColors(r15, r10)
            r1 = r1 & r5
            r26 = r1
            r25 = r2
            goto L_0x01cf
        L_0x01cb:
            r26 = r1
            r25 = r9
        L_0x01cf:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01ec
            androidx.compose.material3.SuggestionChipDefaults r1 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            r9 = 1572864(0x180000, float:2.204052E-39)
            r27 = 63
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = r15
            r11 = r10
            r10 = r27
            androidx.compose.material3.ChipElevation r1 = r1.m2296elevatedSuggestionChipElevationaqJV_2Y(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = r26 & r19
            r26 = r2
            goto L_0x01ef
        L_0x01ec:
            r11 = r10
            r1 = r39
        L_0x01ef:
            if (r0 == 0) goto L_0x01f4
            r0 = r21
            goto L_0x01f6
        L_0x01f4:
            r0 = r40
        L_0x01f6:
            if (r18 == 0) goto L_0x022b
            r2 = -1455578225(0xffffffffa93da38f, float:-4.2108295E-14)
            r15.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember):Chip.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            java.lang.Object r2 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0216
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r15.updateRememberedValue(r2)
        L_0x0216:
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r15.endReplaceableGroup()
            r3 = r0
            r4 = r2
            r8 = r20
            r0 = r22
            r7 = r24
            r9 = r25
            r5 = r26
            r2 = r1
            r1 = r23
            goto L_0x023b
        L_0x022b:
            r4 = r41
            r3 = r0
            r2 = r1
            r8 = r20
            r0 = r22
            r1 = r23
            r7 = r24
            r9 = r25
            r5 = r26
        L_0x023b:
            r15.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x024d
            r6 = -1
            java.lang.String r10 = "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:914)"
            r11 = 1668751803(0x637721bb, float:4.5587763E21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r5, r6, r10)
        L_0x024d:
            androidx.compose.material3.MaterialTheme r6 = androidx.compose.material3.MaterialTheme.INSTANCE
            r10 = 6
            androidx.compose.material3.Typography r6 = r6.getTypography(r15, r10)
            androidx.compose.material3.tokens.SuggestionChipTokens r10 = androidx.compose.material3.tokens.SuggestionChipTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r10 = r10.getLabelTextFont()
            androidx.compose.ui.text.TextStyle r17 = androidx.compose.material3.TypographyKt.fromToken(r6, r10)
            long r18 = r9.m1616labelColorvNxB06k$material3_release(r1)
            androidx.compose.material3.SuggestionChipDefaults r6 = androidx.compose.material3.SuggestionChipDefaults.INSTANCE
            float r26 = r6.m2297getHeightD9Ej5fM()
            androidx.compose.foundation.layout.PaddingValues r27 = SuggestionChipPadding
            r6 = -1455577719(0xffffffffa93da589, float:-4.211001E-14)
            r15.startReplaceableGroup(r6)
            java.lang.String r6 = "928@46662L21"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            if (r3 != 0) goto L_0x027a
            r6 = r21
            goto L_0x0287
        L_0x027a:
            int r6 = r5 >> 9
            r6 = r6 & 14
            int r10 = r5 >> 21
            r10 = r10 & 112(0x70, float:1.57E-43)
            r6 = r6 | r10
            androidx.compose.runtime.State r6 = r3.borderStroke$material3_release(r1, r15, r6)
        L_0x0287:
            r15.endReplaceableGroup()
            if (r6 == 0) goto L_0x0295
            java.lang.Object r6 = r6.getValue()
            androidx.compose.foundation.BorderStroke r6 = (androidx.compose.foundation.BorderStroke) r6
            r25 = r6
            goto L_0x0297
        L_0x0295:
            r25 = r21
        L_0x0297:
            int r6 = r5 >> 6
            r6 = r6 & 14
            r6 = r6 | r16
            int r10 = r5 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r6 = r6 | r10
            int r10 = r5 >> 3
            r10 = r10 & 896(0x380, float:1.256E-42)
            r6 = r6 | r10
            int r10 = r5 << 6
            r11 = r10 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r11
            r11 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r11
            r6 = r6 | r10
            int r10 = r5 << 9
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r10
            r6 = r6 | r11
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r10 = r10 & r11
            r30 = r6 | r10
            int r6 = r5 >> 21
            r6 = r6 & 14
            r6 = r6 | 3456(0xd80, float:4.843E-42)
            int r5 = r5 >> 15
            r10 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r10
            r31 = r6 | r5
            r21 = 0
            r13 = r0
            r14 = r32
            r5 = r15
            r15 = r1
            r16 = r33
            r20 = r7
            r22 = r8
            r23 = r9
            r24 = r2
            r28 = r4
            r29 = r5
            m1626ChipnkUnTEs(r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x02ea
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02ea:
            r10 = r3
            r11 = r4
            r6 = r8
            r3 = r0
            r4 = r1
            r8 = r2
        L_0x02f0:
            androidx.compose.runtime.ScopeUpdateScope r13 = r5.endRestartGroup()
            if (r13 == 0) goto L_0x030d
            androidx.compose.material3.ChipKt$ElevatedSuggestionChip$4 r14 = new androidx.compose.material3.ChipKt$ElevatedSuggestionChip$4
            r0 = r14
            r1 = r32
            r2 = r33
            r5 = r7
            r7 = r9
            r9 = r10
            r10 = r11
            r11 = r43
            r12 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x030d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt.ElevatedSuggestionChip(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ChipColors, androidx.compose.material3.ChipElevation, androidx.compose.material3.ChipBorder, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Chip-nkUnTEs  reason: not valid java name */
    public static final void m1626ChipnkUnTEs(Modifier modifier, Function0<Unit> function0, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, long j, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, float f, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        int i4;
        Composer composer2;
        float f2;
        Modifier modifier2 = modifier;
        boolean z2 = z;
        ChipColors chipColors2 = chipColors;
        ChipElevation chipElevation2 = chipElevation;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        int i5 = i;
        int i6 = i2;
        Composer startRestartGroup = composer.startRestartGroup(1400504719);
        ComposerKt.sourceInformation(startRestartGroup, "C(Chip)P(10,11,3,5,7,6:c#ui.graphics.Color,8,14,13,1,2!1,9:c#ui.unit.Dp,12)1862@93125L917:Chip.kt#uh7d8r");
        int i7 = 2;
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        int i8 = 32;
        Function0<Unit> function02 = function0;
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        int i9 = 256;
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        int i10 = 2048;
        if ((i5 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = function2;
        }
        int i11 = 16384;
        if ((i5 & CpioConstants.C_ISBLK) == 0) {
            i3 |= startRestartGroup.changed((Object) textStyle) ? 16384 : 8192;
        } else {
            TextStyle textStyle2 = textStyle;
        }
        int i12 = i3;
        long j2 = j;
        if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i12 |= startRestartGroup.changed(j2) ? 131072 : 65536;
        }
        Function2<? super Composer, ? super Integer, Unit> function25 = function22;
        if ((i5 & 1572864) == 0) {
            i12 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
        }
        Function2<? super Composer, ? super Integer, Unit> function26 = function23;
        if ((i5 & 12582912) == 0) {
            i12 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
        }
        Shape shape2 = shape;
        if ((i5 & 100663296) == 0) {
            i12 |= startRestartGroup.changed((Object) shape2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i12 |= startRestartGroup.changed((Object) chipColors2) ? 536870912 : 268435456;
        }
        int i13 = i12;
        if ((i6 & 6) == 0) {
            if (startRestartGroup.changed((Object) chipElevation2)) {
                i7 = 4;
            }
            i4 = i7 | i6;
        } else {
            i4 = i6;
        }
        BorderStroke borderStroke2 = borderStroke;
        if ((i6 & 48) == 0) {
            if (!startRestartGroup.changed((Object) borderStroke2)) {
                i8 = 16;
            }
            i4 |= i8;
        }
        float f3 = f;
        if ((i6 & 384) == 0) {
            if (!startRestartGroup.changed(f3)) {
                i9 = 128;
            }
            i4 |= i9;
        }
        if ((i6 & 3072) == 0) {
            if (!startRestartGroup.changed((Object) paddingValues)) {
                i10 = 1024;
            }
            i4 |= i10;
        } else {
            PaddingValues paddingValues2 = paddingValues;
        }
        if ((i6 & CpioConstants.C_ISBLK) == 0) {
            if (!startRestartGroup.changed((Object) mutableInteractionSource2)) {
                i11 = 8192;
            }
            i4 |= i11;
        }
        if ((306783379 & i13) == 306783378 && (i4 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1400504719, i13, i4, "androidx.compose.material3.Chip (Chip.kt:1861)");
            }
            State<Dp> state = null;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, ChipKt$Chip$1.INSTANCE, 1, (Object) null);
            long r20 = chipColors2.m1606containerColorvNxB06k$material3_release(z2);
            if (chipElevation2 != null) {
                f2 = chipElevation2.m1625tonalElevationu2uoSUM$material3_release(z2);
            } else {
                f2 = Dp.m6614constructorimpl((float) 0);
            }
            float f4 = f2;
            startRestartGroup.startReplaceableGroup(64045604);
            ComposerKt.sourceInformation(startRestartGroup, "1869@93427L43");
            if (chipElevation2 != null) {
                state = chipElevation2.shadowElevation$material3_release(z2, mutableInteractionSource2, startRestartGroup, ((i13 >> 6) & 14) | ((i4 >> 9) & 112) | ((i4 << 6) & 896));
            }
            startRestartGroup.endReplaceableGroup();
            float r23 = state != null ? state.getValue().m6628unboximpl() : Dp.m6614constructorimpl((float) 0);
            int i14 = i4;
            composer2 = startRestartGroup;
            ChipKt$Chip$2 chipKt$Chip$2 = r2;
            ChipKt$Chip$2 chipKt$Chip$22 = new ChipKt$Chip$2(function2, textStyle, j, function22, function23, chipColors, z, f, paddingValues);
            Function2 composableLambda = ComposableLambdaKt.composableLambda(composer2, -1985962652, true, chipKt$Chip$2);
            int i15 = i13;
            SurfaceKt.m2306Surfaceo_FOJdg(function0, semantics$default, z, shape, r20, 0, f4, r23, borderStroke, mutableInteractionSource, composableLambda, composer2, ((i15 >> 15) & 7168) | ((i15 >> 3) & 14) | (i15 & 896) | ((i14 << 21) & 234881024) | (1879048192 & (i14 << 15)), 6, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$Chip$3(modifier, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f, paddingValues, mutableInteractionSource, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: SelectableChip-u0RnIRE  reason: not valid java name */
    public static final void m1628SelectableChipu0RnIRE(boolean z, Modifier modifier, Function0<Unit> function0, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, float f, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        int i4;
        Composer composer2;
        float f2;
        boolean z3 = z;
        Modifier modifier2 = modifier;
        boolean z4 = z2;
        SelectableChipColors selectableChipColors2 = selectableChipColors;
        SelectableChipElevation selectableChipElevation2 = selectableChipElevation;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        int i5 = i;
        int i6 = i2;
        Composer startRestartGroup = composer.startRestartGroup(402951308);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectableChip)P(13,10,11,4,6,7,8!1,15,14,2,3!1,9:c#ui.unit.Dp,12)1914@94883L33,1908@94681L1012:Chip.kt#uh7d8r");
        int i7 = 2;
        if ((i5 & 6) == 0) {
            i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        int i8 = 32;
        if ((i5 & 48) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier2) ? 32 : 16;
        }
        int i9 = 256;
        if ((i5 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        } else {
            Function0<Unit> function02 = function0;
        }
        int i10 = 2048;
        if ((i5 & 3072) == 0) {
            i3 |= startRestartGroup.changed(z4) ? 2048 : 1024;
        }
        int i11 = 16384;
        if ((i5 & CpioConstants.C_ISBLK) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        }
        int i12 = 65536;
        TextStyle textStyle2 = textStyle;
        if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changed((Object) textStyle2) ? 131072 : 65536;
        }
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        if ((i5 & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function26) ? 1048576 : 524288;
        }
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        if ((i5 & 12582912) == 0) {
            i3 |= startRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
        }
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        if ((i5 & 100663296) == 0) {
            i3 |= startRestartGroup.changedInstance(function28) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i13 = i5 & 805306368;
        Shape shape2 = shape;
        if (i13 == 0) {
            i3 |= startRestartGroup.changed((Object) shape2) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            if (startRestartGroup.changed((Object) selectableChipColors2)) {
                i7 = 4;
            }
            i4 = i7 | i6;
        } else {
            i4 = i6;
        }
        if ((i6 & 48) == 0) {
            if (!startRestartGroup.changed((Object) selectableChipElevation2)) {
                i8 = 16;
            }
            i4 |= i8;
        }
        if ((i6 & 384) == 0) {
            if (!startRestartGroup.changed((Object) borderStroke)) {
                i9 = 128;
            }
            i4 |= i9;
        } else {
            BorderStroke borderStroke2 = borderStroke;
        }
        if ((i6 & 3072) == 0) {
            if (!startRestartGroup.changed(f)) {
                i10 = 1024;
            }
            i4 |= i10;
        } else {
            float f3 = f;
        }
        if ((i6 & CpioConstants.C_ISBLK) == 0) {
            if (!startRestartGroup.changed((Object) paddingValues)) {
                i11 = 8192;
            }
            i4 |= i11;
        } else {
            PaddingValues paddingValues2 = paddingValues;
        }
        if ((i6 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (startRestartGroup.changed((Object) mutableInteractionSource2)) {
                i12 = 131072;
            }
            i4 |= i12;
        }
        if ((i3 & 306783379) == 306783378 && (74899 & i4) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402951308, i3, i4, "androidx.compose.material3.SelectableChip (Chip.kt:1906)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, ChipKt$SelectableChip$1.INSTANCE, 1, (Object) null);
            int i14 = (i3 >> 9) & 14;
            long r19 = selectableChipColors2.containerColor$material3_release(z4, z3, startRestartGroup, ((i3 << 3) & 112) | i14 | ((i4 << 6) & 896)).getValue().m3826unboximpl();
            if (selectableChipElevation2 != null) {
                f2 = selectableChipElevation2.m2158tonalElevationu2uoSUM$material3_release(z4);
            } else {
                f2 = Dp.m6614constructorimpl((float) 0);
            }
            float f4 = f2;
            startRestartGroup.startReplaceableGroup(1036687729);
            ComposerKt.sourceInformation(startRestartGroup, "1916@95030L43");
            State<Dp> shadowElevation$material3_release = selectableChipElevation2 == null ? null : selectableChipElevation2.shadowElevation$material3_release(z4, mutableInteractionSource2, startRestartGroup, i14 | ((i4 >> 12) & 112) | ((i4 << 3) & 896));
            startRestartGroup.endReplaceableGroup();
            float r22 = shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().m6628unboximpl() : Dp.m6614constructorimpl((float) 0);
            int i15 = i4;
            int i16 = i3;
            ChipKt$SelectableChip$2 chipKt$SelectableChip$2 = r0;
            Composer composer3 = startRestartGroup;
            ChipKt$SelectableChip$2 chipKt$SelectableChip$22 = new ChipKt$SelectableChip$2(selectableChipColors, z2, z, function2, textStyle, function22, function23, function24, f, paddingValues);
            composer2 = composer3;
            SurfaceKt.m2304Surfaced85dljk(z, function0, semantics$default, z2, shape, r19, 0, f4, r22, borderStroke, mutableInteractionSource, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer3, -577614814, true, chipKt$SelectableChip$2), composer3, (i16 & 14) | ((i16 >> 3) & 112) | (i16 & 7168) | ((i16 >> 15) & 57344) | ((i15 << 21) & 1879048192), ((i15 >> 15) & 14) | 48, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$SelectableChip$3(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f, paddingValues, mutableInteractionSource, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ChipContent-fe0OD_I  reason: not valid java name */
    public static final void m1627ChipContentfe0OD_I(Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, long j, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, long j2, long j3, float f, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        int i3;
        TextStyle textStyle2 = textStyle;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(-782878228);
        ComposerKt.sourceInformation(startRestartGroup, "C(ChipContent)P(1,3,2:c#ui.graphics.Color,4!1,8,5:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.unit.Dp)1948@96070L3672:Chip.kt#uh7d8r");
        if ((i4 & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i4;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function25 = function2;
            i2 = i4;
        }
        if ((i4 & 48) == 0) {
            i2 |= startRestartGroup.changed((Object) textStyle2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        } else {
            long j4 = j;
        }
        if ((i4 & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        }
        if ((i4 & CpioConstants.C_ISBLK) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        }
        if ((196608 & i4) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        }
        if ((1572864 & i4) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 1048576 : 524288;
        } else {
            long j5 = j2;
        }
        if ((12582912 & i4) == 0) {
            i3 = i2 | (startRestartGroup.changed(j3) ? 8388608 : 4194304);
        } else {
            i3 = i2;
            long j6 = j3;
        }
        if ((100663296 & i4) == 0) {
            i3 |= startRestartGroup.changed(f) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            float f2 = f;
        }
        PaddingValues paddingValues2 = paddingValues;
        if ((i4 & 805306368) == 0) {
            i3 |= startRestartGroup.changed((Object) paddingValues2) ? 536870912 : 268435456;
        }
        if ((i3 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782878228, i3, -1, "androidx.compose.material3.ChipContent (Chip.kt:1947)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3806boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle2)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 1748799148, true, new ChipKt$ChipContent$1(f, paddingValues, function23, function22, function24, j2, function2, j3)), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$ChipContent$2(function2, textStyle, j, function22, function23, function24, j2, j3, f, paddingValues, i));
        }
    }

    public static final ChipColors getDefaultSuggestionChipColors(ColorScheme colorScheme) {
        ColorScheme colorScheme2 = colorScheme;
        ChipColors defaultSuggestionChipColorsCached$material3_release = colorScheme.getDefaultSuggestionChipColorsCached$material3_release();
        if (defaultSuggestionChipColorsCached$material3_release != null) {
            return defaultSuggestionChipColorsCached$material3_release;
        }
        ChipColors chipColors = new ChipColors(Color.Companion.m3851getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.Companion.m3852getUnspecified0d7_KjU(), Color.Companion.m3851getTransparent0d7_KjU(), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.Companion.m3852getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
        colorScheme2.setDefaultSuggestionChipColorsCached$material3_release(chipColors);
        return chipColors;
    }

    static /* synthetic */ PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return inputChipPadding(z, z2, z3);
    }

    private static final PaddingValues inputChipPadding(boolean z, boolean z2, boolean z3) {
        return PaddingKt.m667PaddingValuesa9UjIt4$default(Dp.m6614constructorimpl((z || !z2) ? (float) 4 : (float) 8), 0.0f, Dp.m6614constructorimpl(z3 ? (float) 8 : (float) 4), 0.0f, 10, (Object) null);
    }

    static {
        float r0 = Dp.m6614constructorimpl((float) 8);
        HorizontalElementsPadding = r0;
        AssistChipPadding = PaddingKt.m665PaddingValuesYgX7TsA$default(r0, 0.0f, 2, (Object) null);
        FilterChipPadding = PaddingKt.m665PaddingValuesYgX7TsA$default(r0, 0.0f, 2, (Object) null);
        SuggestionChipPadding = PaddingKt.m665PaddingValuesYgX7TsA$default(r0, 0.0f, 2, (Object) null);
    }
}
