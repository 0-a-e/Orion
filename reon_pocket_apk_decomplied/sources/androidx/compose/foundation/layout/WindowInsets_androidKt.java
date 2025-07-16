package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.graphics.Insets;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0000\u001a\f\u0010V\u001a\u00020W*\u00020SH\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u000e*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0010\"(\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\".\u0010\u0015\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00018F@FX\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0017\u0010\u001e\"\u0004\b\u0019\u0010\u001f\"\u0015\u0010 \u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b!\u0010\u0010\"\u0015\u0010\"\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b#\u0010\u0010\"\u001e\u0010$\u001a\u00020\u000e*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0010\"\u001e\u0010'\u001a\u00020\u000e*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0010\"\u001e\u0010*\u001a\u00020\u0001*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u001e\u0010,\u001a\u00020\u0001*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u001e\u0010.\u001a\u00020\u0001*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0015\u00100\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b1\u0010\u0010\"\u0015\u00102\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b3\u0010\u0010\"\u001e\u00104\u001a\u00020\u000e*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0010\"\u0015\u00107\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b8\u0010\u0010\"\u0015\u00109\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b:\u0010\u0010\"\u0015\u0010;\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b<\u0010\u0010\"\u0015\u0010=\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b>\u0010\u0010\"\u001e\u0010?\u001a\u00020\u000e*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0010\"\u0015\u0010B\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bC\u0010\u0010\"\u001e\u0010D\u001a\u00020\u000e*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0010\"\u0015\u0010G\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bH\u0010\u0010\"\u0015\u0010I\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bJ\u0010\u0010\"\u001e\u0010K\u001a\u00020\u000e*\u00020\u00028GX\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0010\"\u0015\u0010N\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bO\u0010\u0010¨\u0006X"}, d2 = {"areNavigationBarsVisible", "", "Landroidx/compose/foundation/layout/WindowInsets$Companion;", "getAreNavigationBarsVisible$annotations", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;)V", "getAreNavigationBarsVisible", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Z", "areStatusBarsVisible", "getAreStatusBarsVisible$annotations", "getAreStatusBarsVisible", "areSystemBarsVisible", "getAreSystemBarsVisible$annotations", "getAreSystemBarsVisible", "captionBar", "Landroidx/compose/foundation/layout/WindowInsets;", "getCaptionBar", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "captionBarIgnoringVisibility", "getCaptionBarIgnoringVisibility$annotations", "getCaptionBarIgnoringVisibility", "value", "consumeWindowInsets", "Landroidx/compose/ui/platform/AbstractComposeView;", "getConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;)Z", "setConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;Z)V", "Landroidx/compose/ui/platform/ComposeView;", "getConsumeWindowInsets$annotations", "(Landroidx/compose/ui/platform/ComposeView;)V", "(Landroidx/compose/ui/platform/ComposeView;)Z", "(Landroidx/compose/ui/platform/ComposeView;Z)V", "displayCutout", "getDisplayCutout", "ime", "getIme", "imeAnimationSource", "getImeAnimationSource$annotations", "getImeAnimationSource", "imeAnimationTarget", "getImeAnimationTarget$annotations", "getImeAnimationTarget", "isCaptionBarVisible", "isCaptionBarVisible$annotations", "isImeVisible", "isImeVisible$annotations", "isTappableElementVisible", "isTappableElementVisible$annotations", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility$annotations", "getNavigationBarsIgnoringVisibility", "safeContent", "getSafeContent", "safeDrawing", "getSafeDrawing", "safeGestures", "getSafeGestures", "statusBars", "getStatusBars", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility$annotations", "getStatusBarsIgnoringVisibility", "systemBars", "getSystemBars", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility$annotations", "getSystemBarsIgnoringVisibility", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility$annotations", "getTappableElementIgnoringVisibility", "waterfall", "getWaterfall", "ValueInsets", "Landroidx/compose/foundation/layout/ValueInsets;", "insets", "Landroidx/core/graphics/Insets;", "name", "", "toInsetsValues", "Landroidx/compose/foundation/layout/InsetsValues;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsets.android.kt */
public final class WindowInsets_androidKt {
    public static /* synthetic */ void getAreNavigationBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getAreStatusBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getAreSystemBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getCaptionBarIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use AbstractComposeView.consumeWindowInsets")
    public static /* synthetic */ void getConsumeWindowInsets$annotations(ComposeView composeView) {
    }

    public static /* synthetic */ void getImeAnimationSource$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getImeAnimationTarget$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getNavigationBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getStatusBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getSystemBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getTappableElementIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void isCaptionBarVisible$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void isImeVisible$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void isTappableElementVisible$annotations(WindowInsets.Companion companion) {
    }

    public static final InsetsValues toInsetsValues(Insets insets) {
        return new InsetsValues(insets.left, insets.top, insets.right, insets.bottom);
    }

    public static final ValueInsets ValueInsets(Insets insets, String str) {
        return new ValueInsets(toInsetsValues(insets), str);
    }

    public static final boolean getConsumeWindowInsets(AbstractComposeView abstractComposeView) {
        Object tag = abstractComposeView.getTag(R.id.consume_window_insets_tag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final void setConsumeWindowInsets(AbstractComposeView abstractComposeView, boolean z) {
        abstractComposeView.setTag(R.id.consume_window_insets_tag, Boolean.valueOf(z));
    }

    public static final /* synthetic */ boolean getConsumeWindowInsets(ComposeView composeView) {
        Object tag = composeView.getTag(R.id.consume_window_insets_tag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final WindowInsets getCaptionBar(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-1832025528);
        ComposerKt.sourceInformation(composer, "C142@4955L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1832025528, i, -1, "androidx.compose.foundation.layout.<get-captionBar> (WindowInsets.android.kt:142)");
        }
        AndroidWindowInsets captionBar = WindowInsetsHolder.Companion.current(composer, 8).getCaptionBar();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return captionBar;
    }

    public static final WindowInsets getDisplayCutout(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(1324817724);
        ComposerKt.sourceInformation(composer, "C151@5303L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1324817724, i, -1, "androidx.compose.foundation.layout.<get-displayCutout> (WindowInsets.android.kt:151)");
        }
        AndroidWindowInsets displayCutout = WindowInsetsHolder.Companion.current(composer, 8).getDisplayCutout();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return displayCutout;
    }

    public static final WindowInsets getIme(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-1466917860);
        ComposerKt.sourceInformation(composer, "C165@5937L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1466917860, i, -1, "androidx.compose.foundation.layout.<get-ime> (WindowInsets.android.kt:165)");
        }
        AndroidWindowInsets ime = WindowInsetsHolder.Companion.current(composer, 8).getIme();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return ime;
    }

    public static final WindowInsets getMandatorySystemGestures(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(1369492988);
        ComposerKt.sourceInformation(composer, "C174@6271L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1369492988, i, -1, "androidx.compose.foundation.layout.<get-mandatorySystemGestures> (WindowInsets.android.kt:174)");
        }
        AndroidWindowInsets mandatorySystemGestures = WindowInsetsHolder.Companion.current(composer, 8).getMandatorySystemGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mandatorySystemGestures;
    }

    public static final WindowInsets getNavigationBars(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(1596175702);
        ComposerKt.sourceInformation(composer, "C184@6630L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1596175702, i, -1, "androidx.compose.foundation.layout.<get-navigationBars> (WindowInsets.android.kt:184)");
        }
        AndroidWindowInsets navigationBars = WindowInsetsHolder.Companion.current(composer, 8).getNavigationBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return navigationBars;
    }

    public static final WindowInsets getStatusBars(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-675090670);
        ComposerKt.sourceInformation(composer, "C192@6849L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-675090670, i, -1, "androidx.compose.foundation.layout.<get-statusBars> (WindowInsets.android.kt:192)");
        }
        AndroidWindowInsets statusBars = WindowInsetsHolder.Companion.current(composer, 8).getStatusBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return statusBars;
    }

    public static final WindowInsets getSystemBars(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-282936756);
        ComposerKt.sourceInformation(composer, "C200@7064L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-282936756, i, -1, "androidx.compose.foundation.layout.<get-systemBars> (WindowInsets.android.kt:200)");
        }
        AndroidWindowInsets systemBars = WindowInsetsHolder.Companion.current(composer, 8).getSystemBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return systemBars;
    }

    public static final WindowInsets getSystemGestures(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(989216224);
        ComposerKt.sourceInformation(composer, "C208@7287L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(989216224, i, -1, "androidx.compose.foundation.layout.<get-systemGestures> (WindowInsets.android.kt:208)");
        }
        AndroidWindowInsets systemGestures = WindowInsetsHolder.Companion.current(composer, 8).getSystemGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return systemGestures;
    }

    public static final WindowInsets getTappableElement(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-1994205284);
        ComposerKt.sourceInformation(composer, "C216@7516L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994205284, i, -1, "androidx.compose.foundation.layout.<get-tappableElement> (WindowInsets.android.kt:216)");
        }
        AndroidWindowInsets tappableElement = WindowInsetsHolder.Companion.current(composer, 8).getTappableElement();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return tappableElement;
    }

    public static final WindowInsets getWaterfall(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(1943241020);
        ComposerKt.sourceInformation(composer, "C224@7745L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1943241020, i, -1, "androidx.compose.foundation.layout.<get-waterfall> (WindowInsets.android.kt:224)");
        }
        ValueInsets waterfall = WindowInsetsHolder.Companion.current(composer, 8).getWaterfall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return waterfall;
    }

    public static final WindowInsets getSafeDrawing(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-49441252);
        ComposerKt.sourceInformation(composer, "C234@8107L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-49441252, i, -1, "androidx.compose.foundation.layout.<get-safeDrawing> (WindowInsets.android.kt:234)");
        }
        WindowInsets safeDrawing = WindowInsetsHolder.Companion.current(composer, 8).getSafeDrawing();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return safeDrawing;
    }

    public static final WindowInsets getSafeGestures(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-1594247780);
        ComposerKt.sourceInformation(composer, "C245@8541L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1594247780, i, -1, "androidx.compose.foundation.layout.<get-safeGestures> (WindowInsets.android.kt:245)");
        }
        WindowInsets safeGestures = WindowInsetsHolder.Companion.current(composer, 8).getSafeGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return safeGestures;
    }

    public static final WindowInsets getSafeContent(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-2026663876);
        ComposerKt.sourceInformation(composer, "C254@8858L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026663876, i, -1, "androidx.compose.foundation.layout.<get-safeContent> (WindowInsets.android.kt:254)");
        }
        WindowInsets safeContent = WindowInsetsHolder.Companion.current(composer, 8).getSafeContent();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return safeContent;
    }

    public static final WindowInsets getCaptionBarIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-1731251574);
        ComposerKt.sourceInformation(composer, "C266@9266L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1731251574, i, -1, "androidx.compose.foundation.layout.<get-captionBarIgnoringVisibility> (WindowInsets.android.kt:266)");
        }
        ValueInsets captionBarIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getCaptionBarIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return captionBarIgnoringVisibility;
    }

    public static final WindowInsets getNavigationBarsIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-1990981160);
        ComposerKt.sourceInformation(composer, "C280@9832L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1990981160, i, -1, "androidx.compose.foundation.layout.<get-navigationBarsIgnoringVisibility> (WindowInsets.android.kt:280)");
        }
        ValueInsets navigationBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getNavigationBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return navigationBarsIgnoringVisibility;
    }

    public static final WindowInsets getStatusBarsIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(594020756);
        ComposerKt.sourceInformation(composer, "C292@10273L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(594020756, i, -1, "androidx.compose.foundation.layout.<get-statusBarsIgnoringVisibility> (WindowInsets.android.kt:292)");
        }
        ValueInsets statusBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getStatusBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return statusBarsIgnoringVisibility;
    }

    public static final WindowInsets getSystemBarsIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(1564566798);
        ComposerKt.sourceInformation(composer, "C305@10710L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1564566798, i, -1, "androidx.compose.foundation.layout.<get-systemBarsIgnoringVisibility> (WindowInsets.android.kt:305)");
        }
        ValueInsets systemBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getSystemBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return systemBarsIgnoringVisibility;
    }

    public static final WindowInsets getTappableElementIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-1488788292);
        ComposerKt.sourceInformation(composer, "C318@11155L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1488788292, i, -1, "androidx.compose.foundation.layout.<get-tappableElementIgnoringVisibility> (WindowInsets.android.kt:318)");
        }
        ValueInsets tappableElementIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 8).getTappableElementIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return tappableElementIgnoringVisibility;
    }

    public static final boolean isCaptionBarVisible(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-501076620);
        ComposerKt.sourceInformation(composer, "C330@11561L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-501076620, i, -1, "androidx.compose.foundation.layout.<get-isCaptionBarVisible> (WindowInsets.android.kt:330)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getCaptionBar().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    public static final boolean isImeVisible(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-1873571424);
        ComposerKt.sourceInformation(composer, "C342@11942L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1873571424, i, -1, "androidx.compose.foundation.layout.<get-isImeVisible> (WindowInsets.android.kt:342)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getIme().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    public static final boolean getAreStatusBarsVisible(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(1613283456);
        ComposerKt.sourceInformation(composer, "C354@12319L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1613283456, i, -1, "androidx.compose.foundation.layout.<get-areStatusBarsVisible> (WindowInsets.android.kt:354)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getStatusBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    public static final boolean getAreNavigationBarsVisible(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(710310464);
        ComposerKt.sourceInformation(composer, "C366@12711L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(710310464, i, -1, "androidx.compose.foundation.layout.<get-areNavigationBarsVisible> (WindowInsets.android.kt:366)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getNavigationBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    public static final boolean getAreSystemBarsVisible(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(1985490720);
        ComposerKt.sourceInformation(composer, "C378@13099L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1985490720, i, -1, "androidx.compose.foundation.layout.<get-areSystemBarsVisible> (WindowInsets.android.kt:378)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getSystemBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    public static final boolean isTappableElementVisible(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-1737201120);
        ComposerKt.sourceInformation(composer, "C389@13490L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1737201120, i, -1, "androidx.compose.foundation.layout.<get-isTappableElementVisible> (WindowInsets.android.kt:389)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 8).getTappableElement().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return isVisible;
    }

    public static final WindowInsets getImeAnimationSource(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-1126064918);
        ComposerKt.sourceInformation(composer, "C404@14002L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1126064918, i, -1, "androidx.compose.foundation.layout.<get-imeAnimationSource> (WindowInsets.android.kt:404)");
        }
        ValueInsets imeAnimationSource = WindowInsetsHolder.Companion.current(composer, 8).getImeAnimationSource();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imeAnimationSource;
    }

    public static final WindowInsets getImeAnimationTarget(WindowInsets.Companion companion, Composer composer, int i) {
        composer.startReplaceableGroup(-466319786);
        ComposerKt.sourceInformation(composer, "C419@14543L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-466319786, i, -1, "androidx.compose.foundation.layout.<get-imeAnimationTarget> (WindowInsets.android.kt:419)");
        }
        ValueInsets imeAnimationTarget = WindowInsetsHolder.Companion.current(composer, 8).getImeAnimationTarget();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imeAnimationTarget;
    }
}
