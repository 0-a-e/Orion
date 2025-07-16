package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.util.LongSparseArrayKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.LongIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000²\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 ³\u00022\u00020\u00012\u00020\u0002:\u0016±\u0002²\u0002³\u0002´\u0002µ\u0002¶\u0002·\u0002¸\u0002¹\u0002º\u0002»\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J.\u0010~\u001a\u00020\u001c2\u0006\u0010\u001a\u00020\r2\u0007\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020\u00072\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u000201H\u0002J\u0013\u0010\u0001\u001a\u00020\u001cH@¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020\r2\t\u0010\u0001\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020\rH\u0002J1\u0010\u0001\u001a\u00020\u000f2\u0007\u0010\u0001\u001a\u00020\u000f2\u0007\u0010\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J@\u0010\u0001\u001a\u00020\u000f2\r\u0010/\u001a\t\u0012\u0004\u0012\u0002010\u00012\u0007\u0010\u0001\u001a\u00020\u000f2\u0007\u0010\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020\u001cH\u0002J\u0011\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u001a\u00020\rH\u0002J\t\u0010\u0001\u001a\u00020\u001cH\u0002J\u001a\u0010\u0001\u001a\u00020\\2\u0006\u0010\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\rH\u0003J\u0013\u0010\u0001\u001a\u0004\u0018\u0001062\u0006\u0010\u001a\u00020\rH\u0002JC\u0010\u0001\u001a\u00020\\2\u0006\u0010\u001a\u00020\r2\t\u0010\u0001\u001a\u0004\u0018\u00010\r2\t\u0010 \u0001\u001a\u0004\u0018\u00010\r2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\r2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0003\u0010£\u0001J\u0019\u0010¤\u0001\u001a\u00020\u000f2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0000¢\u0006\u0003\b§\u0001JL\u0010¨\u0001\u001a\u00020\u001c2\b\u0010©\u0001\u001a\u00030ª\u00012\u001b\u0010«\u0001\u001a\u0016\u0012\u0005\u0012\u00030ª\u00010¬\u0001j\n\u0012\u0005\u0012\u00030ª\u0001`­\u00012\u001a\u0010®\u0001\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ª\u0001080iH\u0002J\u0013\u0010¯\u0001\u001a\u00020Y2\b\u0010°\u0001\u001a\u00030±\u0001H\u0016J\u0013\u0010²\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030ª\u0001H\u0002J\u0013\u0010³\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030ª\u0001H\u0002J\u0013\u0010´\u0001\u001a\u00020\u000f2\b\u0010\u0001\u001a\u00030ª\u0001H\u0002J\u0015\u0010µ\u0001\u001a\u0004\u0018\u00010\u00072\b\u0010\u0001\u001a\u00030ª\u0001H\u0002J\u0016\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00012\b\u0010\u0001\u001a\u00030ª\u0001H\u0002J\u0017\u0010¸\u0001\u001a\u0004\u0018\u00010\u00072\n\u0010\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0002J!\u0010¹\u0001\u001a\u0005\u0018\u00010º\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010ª\u00012\u0007\u0010»\u0001\u001a\u00020\rH\u0002J\u0016\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J\t\u0010À\u0001\u001a\u00020\u001cH\u0002J#\u0010Á\u0001\u001a\u00020\r2\b\u0010Â\u0001\u001a\u00030Ã\u00012\b\u0010Ä\u0001\u001a\u00030Ã\u0001H\u0001¢\u0006\u0003\bÅ\u0001J\u0012\u0010Æ\u0001\u001a\u00020\u001c2\u0007\u0010Ç\u0001\u001a\u00020\u000fH\u0002J\u0011\u0010È\u0001\u001a\u00020\u000f2\u0006\u0010\u001a\u00020\rH\u0002J\u0013\u0010É\u0001\u001a\u00020\u000f2\b\u0010\u0001\u001a\u00030ª\u0001H\u0002J\u0013\u0010Ê\u0001\u001a\u00020\u000f2\b\u0010\u0001\u001a\u00030ª\u0001H\u0002J\t\u0010Ë\u0001\u001a\u00020\u001cH\u0002J\u0012\u0010Ì\u0001\u001a\u00020\u001c2\u0007\u0010Í\u0001\u001a\u00020uH\u0002J\u000f\u0010Î\u0001\u001a\u00020\u001cH\u0000¢\u0006\u0003\bÏ\u0001J6\u0010Ð\u0001\u001a\u00020\u001c2\b\u0010Ñ\u0001\u001a\u00030Ò\u00012\b\u0010Ó\u0001\u001a\u00030Ô\u00012\u0011\u0010Õ\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010×\u00010Ö\u0001H\u0001¢\u0006\u0003\bØ\u0001J\u000f\u0010Ù\u0001\u001a\u00020\u001cH\u0000¢\u0006\u0003\bÚ\u0001J\u0018\u0010Û\u0001\u001a\u00020\u001c2\u0007\u0010Í\u0001\u001a\u00020uH\u0000¢\u0006\u0003\bÜ\u0001J\u000f\u0010Ý\u0001\u001a\u00020\u001cH\u0000¢\u0006\u0003\bÞ\u0001J\u000f\u0010ß\u0001\u001a\u00020\u001cH\u0000¢\u0006\u0003\bà\u0001J\u0013\u0010Ç\u0001\u001a\u00020\u001c2\b\u0010á\u0001\u001a\u00030â\u0001H\u0016J\u0013\u0010ã\u0001\u001a\u00020\u001c2\b\u0010á\u0001\u001a\u00030â\u0001H\u0016J\"\u0010ä\u0001\u001a\u00020\u001c2\u0011\u0010å\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010ç\u00010æ\u0001H\u0001¢\u0006\u0003\bè\u0001J&\u0010é\u0001\u001a\u00020\u000f2\u0006\u0010\u001a\u00020\r2\u0007\u0010ê\u0001\u001a\u00020\r2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J%\u0010ë\u0001\u001a\u00020\u001c2\u0006\u0010\u001a\u00020\r2\b\u0010\u0001\u001a\u00030ì\u00012\b\u0010í\u0001\u001a\u00030ª\u0001H\u0002J!\u0010î\u0001\u001a\u00020\u000f2\u0007\u0010ï\u0001\u001a\u00020\r2\r\u0010ð\u0001\u001a\b\u0012\u0004\u0012\u00020o0;H\u0002J\u0011\u0010ñ\u0001\u001a\u00020\u000f2\u0006\u0010\u001a\u00020\rH\u0002J\u0012\u0010ò\u0001\u001a\u00020\u001c2\u0007\u0010ó\u0001\u001a\u00020oH\u0002J'\u0010ô\u0001\u001a\u0016\u0012\u0005\u0012\u00030ª\u00010õ\u0001j\n\u0012\u0005\u0012\u00030ª\u0001`ö\u00012\u0007\u0010÷\u0001\u001a\u00020\u000fH\bJ\u0012\u0010ø\u0001\u001a\u00020\r2\u0007\u0010ï\u0001\u001a\u00020\rH\u0002J\u001c\u0010ù\u0001\u001a\u00020\u001c2\b\u0010ú\u0001\u001a\u00030ª\u00012\u0007\u0010û\u0001\u001a\u00020jH\u0002J\u001c\u0010ü\u0001\u001a\u00020\u001c2\b\u0010ú\u0001\u001a\u00030ª\u00012\u0007\u0010û\u0001\u001a\u00020jH\u0002J\u001b\u0010ý\u0001\u001a\u00020\u001c2\u0007\u0010ï\u0001\u001a\u00020\r2\u0007\u0010þ\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010ÿ\u0001\u001a\u00020\u000f2\u0007\u0010¥\u0001\u001a\u00020\\H\u0002J@\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\r2\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\r2\u0011\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010;H\u0002¢\u0006\u0003\u0010\u0002J&\u0010\u0002\u001a\u00020\u001c2\u0007\u0010\u0002\u001a\u00020\r2\u0007\u0010\u0002\u001a\u00020\r2\t\u0010\u0002\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0002\u001a\u00020\u001c2\u0007\u0010\u0002\u001a\u00020\rH\u0002J\u001e\u0010\u0002\u001a\u00020\u001c2\u0013\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020100H\u0002J!\u0010\u0002\u001a\u00020\u001c2\u0007\u0010Í\u0001\u001a\u00020u2\r\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\r0!H\u0002J\u0012\u0010\u0002\u001a\u00020\u001c2\u0007\u0010Í\u0001\u001a\u00020uH\u0002J.\u0010\u0002\u001a\u00020\u000f2\b\u0010\u0001\u001a\u00030ª\u00012\u0007\u0010\u0002\u001a\u00020\r2\u0007\u0010\u0002\u001a\u00020\r2\u0007\u0010\u0002\u001a\u00020\u000fH\u0002J\u001d\u0010\u0002\u001a\u00020\u001c2\b\u0010\u0001\u001a\u00030ª\u00012\b\u0010\u0001\u001a\u00030ì\u0001H\u0002J\u001d\u0010\u0002\u001a\u00020\u001c2\b\u0010\u0001\u001a\u00030ª\u00012\b\u0010\u0001\u001a\u00030ì\u0001H\u0002J\u001d\u0010\u0002\u001a\u00020\u001c2\b\u0010\u0001\u001a\u00030ª\u00012\b\u0010\u0001\u001a\u00030ì\u0001H\u0002J\u001d\u0010\u0002\u001a\u00020\u001c2\b\u0010\u0001\u001a\u00030ª\u00012\b\u0010\u0001\u001a\u00030ì\u0001H\u0002J\t\u0010\u0002\u001a\u00020\u001cH\u0002J\t\u0010\u0002\u001a\u00020\u001cH\u0002JT\u0010\u0002\u001a\t\u0012\u0005\u0012\u00030ª\u0001082\u0007\u0010÷\u0001\u001a\u00020\u000f2\u001b\u0010\u0002\u001a\u0016\u0012\u0005\u0012\u00030ª\u00010¬\u0001j\n\u0012\u0005\u0012\u00030ª\u0001`­\u00012\u001c\b\u0002\u0010\u0002\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ª\u0001080iH\u0002J)\u0010\u0002\u001a\t\u0012\u0005\u0012\u00030ª\u0001082\u0007\u0010÷\u0001\u001a\u00020\u000f2\u000e\u0010\u0002\u001a\t\u0012\u0005\u0012\u00030ª\u000108H\u0002J\"\u0010\u0002\u001a\u0005\u0018\u00010\u00022\n\u0010\u0002\u001a\u0005\u0018\u00010ª\u00012\b\u0010\u0002\u001a\u00030 \u0002H\u0002J.\u0010¡\u0002\u001a\u00020\u000f2\b\u0010\u0001\u001a\u00030ª\u00012\u0007\u0010»\u0001\u001a\u00020\r2\u0007\u0010¢\u0002\u001a\u00020\u000f2\u0007\u0010£\u0002\u001a\u00020\u000fH\u0002J4\u0010¤\u0002\u001a\u0005\u0018\u0001H¥\u0002\"\t\b\u0000\u0010¥\u0002*\u00020\u00192\n\u0010¢\u0001\u001a\u0005\u0018\u0001H¥\u00022\t\b\u0001\u0010¦\u0002\u001a\u00020\rH\u0002¢\u0006\u0003\u0010§\u0002J\u0013\u0010¨\u0002\u001a\u00020\u001c2\b\u0010\u0001\u001a\u00030ª\u0001H\u0002J\u0013\u0010©\u0002\u001a\u00020\u001c2\b\u0010\u0001\u001a\u00030ª\u0001H\u0002J\u0011\u0010ª\u0002\u001a\u00020\u001c2\u0006\u0010\u001a\u00020\rH\u0002J\t\u0010«\u0002\u001a\u00020\u001cH\u0002J\u0013\u0010¬\u0002\u001a\u00020\u001c2\b\u0010\u0001\u001a\u00030ª\u0001H\u0002J\u0010\u0010­\u0002\u001a\u0004\u0018\u00010)*\u00030±\u0001H\u0002J\u0011\u0010®\u0002\u001a\u0005\u0018\u00010¯\u0002*\u00030¿\u0001H\u0002J\u0010\u0010°\u0002\u001a\u0004\u0018\u00010\u001f*\u00030ª\u0001H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001f0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\u000f8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R&\u0010(\u001a\u0004\u0018\u00010)8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010%\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000201008BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R2\u00107\u001a&\u0012\f\u0012\n :*\u0004\u0018\u00010909 :*\u0012\u0012\f\u0012\n :*\u0004\u0018\u00010909\u0018\u00010;08X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000R$\u0010A\u001a\u00020\r8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bB\u0010%\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR6\u0010G\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0Hj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR6\u0010N\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0Hj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR\u0014\u0010Q\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0012R\u0014\u0010R\u001a\u00020\u000f8@X\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0012R\u001a\u0010T\u001a\u00020\u000f8BX\u0004¢\u0006\f\u0012\u0004\bU\u0010%\u001a\u0004\bT\u0010\u0012R\u0014\u0010V\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0012R \u0010W\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r000\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u000e¢\u0006\u0002\n\u0000R0\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u000f0[8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b]\u0010%\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0014\u0010b\u001a\b\u0012\u0004\u0012\u00020\r0!X\u000e¢\u0006\u0002\n\u0000R*\u0010c\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020d0Hj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020d`IX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R*\u0010g\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020d0Hj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020d`IX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020j0iX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020jX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010l\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010mR\u001a\u0010n\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020\u001c0[X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010p\u001a\b\u0012\u0004\u0012\u00020o08X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010t\u001a\b\u0012\u0004\u0012\u00020u0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020wX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020yX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020{X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006¼\u0002"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "ExtraDataTestTraversalAfterVal", "", "getExtraDataTestTraversalAfterVal$ui_release", "()Ljava/lang/String;", "ExtraDataTestTraversalBeforeVal", "getExtraDataTestTraversalBeforeVal$ui_release", "accessibilityCursorPosition", "", "value", "", "accessibilityForceEnabledForTesting", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "bufferedContentCaptureAppearedNodes", "Landroidx/collection/ArrayMap;", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "bufferedContentCaptureDisappearedNodes", "Landroidx/collection/ArraySet;", "checkingForSemanticsChanges", "contentCaptureForceEnabledForTesting", "getContentCaptureForceEnabledForTesting$ui_release$annotations", "()V", "getContentCaptureForceEnabledForTesting$ui_release", "setContentCaptureForceEnabledForTesting$ui_release", "contentCaptureSession", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "getContentCaptureSession$ui_release$annotations", "getContentCaptureSession$ui_release", "()Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "setContentCaptureSession$ui_release", "(Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;)V", "currentSemanticsNodes", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Ljava/util/Map;", "currentSemanticsNodesInvalidated", "currentlyFocusedANI", "Landroid/view/accessibility/AccessibilityNodeInfo;", "enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release$annotations", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "idToAfterMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getIdToAfterMap$ui_release", "()Ljava/util/HashMap;", "setIdToAfterMap$ui_release", "(Ljava/util/HashMap;)V", "idToBeforeMap", "getIdToBeforeMap$ui_release", "setIdToBeforeMap$ui_release", "isEnabled", "isEnabledForAccessibility", "isEnabledForAccessibility$ui_release", "isEnabledForContentCapture", "isEnabledForContentCapture$annotations", "isTouchExplorationEnabled", "labelToActionId", "nodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "onSendAccessibilityEvent", "Lkotlin/Function1;", "Landroid/view/accessibility/AccessibilityEvent;", "getOnSendAccessibilityEvent$ui_release$annotations", "getOnSendAccessibilityEvent$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "paneDisplayed", "pendingHorizontalScrollEvents", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "pendingVerticalScrollEvents", "previousSemanticsNodes", "", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scheduleScrollEventIfNeededLambda", "Landroidx/compose/ui/platform/ScrollObservationScope;", "scrollObservationScopes", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendingFocusAffectingEvent", "subtreeChangedLayoutNodes", "Landroidx/compose/ui/node/LayoutNode;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "translateStatus", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$TranslateStatus;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "extraDataKey", "arguments", "Landroid/os/Bundle;", "boundsInScreen", "Landroid/graphics/Rect;", "node", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bufferContentCaptureViewAppeared", "virtualId", "viewStructure", "bufferContentCaptureViewDisappeared", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "", "canScroll-moWRBKg", "(Ljava/util/Collection;ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "clearTranslatedText", "createEvent", "eventType", "createNodeInfo", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui_release", "geometryDepthFirstSearch", "currNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "geometryList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "containerMapToChildren", "getAccessibilityNodeProvider", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "getAccessibilitySelectionStart", "getInfoIsCheckable", "getInfoStateDescriptionOrNull", "getInfoText", "Landroid/text/SpannableString;", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "getTextLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "configuration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "hideTranslatedText", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "initContentCapture", "onStart", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "isScreenReaderFocusable", "notifyContentCaptureChanges", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onClearTranslation", "onClearTranslation$ui_release", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onCreateVirtualViewTranslationRequests$ui_release", "onHideTranslation", "onHideTranslation$ui_release", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "onShowTranslation", "onShowTranslation$ui_release", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onVirtualViewTranslationResponses$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "requestAccessibilityFocus", "scheduleScrollEventIfNeeded", "scrollObservationScope", "semanticComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "layoutIsRtl", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "sendContentCaptureSemanticsStructureChangeEvents", "sendContentCaptureTextUpdateEvent", "newText", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "sendTypeViewScrolledAccessibilityEvent", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setIsCheckable", "setStateDescription", "setText", "setTraversalValues", "showTranslatedText", "sortByGeometryGroupings", "parentListToSort", "containerChildrenMapping", "subtreeSortedByGeometryGrouping", "listToSort", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateContentCaptureBuffersOnAppeared", "updateContentCaptureBuffersOnDisappeared", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "updateTranslationOnAppeared", "getContentCaptureSessionCompat", "getTextForTextField", "Landroidx/compose/ui/text/AnnotatedString;", "toViewStructure", "Api24Impl", "Api29Impl", "Companion", "ComposeAccessibilityNodeProvider", "LtrBoundsComparator", "PendingTextTraversedEvent", "RtlBoundsComparator", "SemanticsNodeCopy", "TopBottomBoundsComparator", "TranslateStatus", "ViewTranslationHelperMethodsS", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    private static final int[] AccessibilityActionsResourceIds = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final long SendRecurringAccessibilityEventsIntervalMillis = 100;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    /* access modifiers changed from: private */
    public final AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private final ArrayMap<Integer, ViewStructureCompat> bufferedContentCaptureAppearedNodes;
    private final ArraySet<Integer> bufferedContentCaptureDisappearedNodes;
    private boolean checkingForSemanticsChanges;
    private boolean contentCaptureForceEnabledForTesting;
    private ContentCaptureSessionCompat contentCaptureSession;
    private Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    /* access modifiers changed from: private */
    public AccessibilityNodeInfo currentlyFocusedANI;
    private List<AccessibilityServiceInfo> enabledServices;
    /* access modifiers changed from: private */
    public final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    /* access modifiers changed from: private */
    public int focusedVirtualViewId;
    /* access modifiers changed from: private */
    public final Handler handler;
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private HashMap<Integer, Integer> idToAfterMap;
    private HashMap<Integer, Integer> idToBeforeMap;
    private SparseArrayCompat<Map<CharSequence, Integer>> labelToActionId;
    private AccessibilityNodeProviderCompat nodeProvider;
    private Function1<? super AccessibilityEvent, Boolean> onSendAccessibilityEvent = new AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1(this);
    private ArraySet<Integer> paneDisplayed;
    /* access modifiers changed from: private */
    public final HashMap<Integer, ScrollAxisRange> pendingHorizontalScrollEvents;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    /* access modifiers changed from: private */
    public final HashMap<Integer, ScrollAxisRange> pendingVerticalScrollEvents;
    private Map<Integer, SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final Function1<ScrollObservationScope, Unit> scheduleScrollEventIfNeededLambda;
    private final List<ScrollObservationScope> scrollObservationScopes;
    /* access modifiers changed from: private */
    public final Runnable semanticsChangeChecker;
    /* access modifiers changed from: private */
    public boolean sendingFocusAffectingEvent;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    /* access modifiers changed from: private */
    public final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private TranslateStatus translateStatus;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$TranslateStatus;", "", "(Ljava/lang/String;I)V", "SHOW_ORIGINAL", "SHOW_TRANSLATED", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private enum TranslateStatus {
        SHOW_ORIGINAL,
        SHOW_TRANSLATED
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.ui.state.ToggleableState[] r0 = androidx.compose.ui.state.ToggleableState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.On     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Off     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.state.ToggleableState r1 = androidx.compose.ui.state.ToggleableState.Indeterminate     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ void getContentCaptureForceEnabledForTesting$ui_release$annotations() {
    }

    public static /* synthetic */ void getContentCaptureSession$ui_release$annotations() {
    }

    public static /* synthetic */ void getHoveredVirtualViewId$ui_release$annotations() {
    }

    public static /* synthetic */ void getOnSendAccessibilityEvent$ui_release$annotations() {
    }

    private static /* synthetic */ void isEnabledForContentCapture$annotations() {
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onDestroy(this, lifecycleOwner);
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onPause(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onResume(this, lifecycleOwner);
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.view = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager2 = (AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager2;
        this.enabledStateListener = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0(this);
        this.touchExplorationStateListener = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1(this);
        this.enabledServices = accessibilityManager2.getEnabledAccessibilityServiceList(-1);
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new ComposeAccessibilityNodeProvider());
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new HashMap<>();
        this.pendingVerticalScrollEvents = new HashMap<>();
        this.actionIdToLabel = new SparseArrayCompat<>(0, 1, (DefaultConstructorMarker) null);
        this.labelToActionId = new SparseArrayCompat<>(0, 1, (DefaultConstructorMarker) null);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>(0, 1, (DefaultConstructorMarker) null);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.currentSemanticsNodesInvalidated = true;
        this.bufferedContentCaptureAppearedNodes = new ArrayMap<>();
        this.bufferedContentCaptureDisappearedNodes = new ArraySet<>(0, 1, (DefaultConstructorMarker) null);
        this.currentSemanticsNodes = MapsKt.emptyMap();
        this.paneDisplayed = new ArraySet<>(0, 1, (DefaultConstructorMarker) null);
        this.idToBeforeMap = new HashMap<>();
        this.idToAfterMap = new HashMap<>();
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = new LinkedHashMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), MapsKt.emptyMap());
        androidComposeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

            {
                this.this$0 = r1;
            }

            public void onViewAttachedToWindow(View view) {
                AccessibilityManager access$getAccessibilityManager$p = this.this$0.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.this$0;
                access$getAccessibilityManager$p.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                access$getAccessibilityManager$p.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
                if (!this.this$0.getContentCaptureForceEnabledForTesting$ui_release()) {
                    AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this.this$0;
                    androidComposeViewAccessibilityDelegateCompat2.setContentCaptureSession$ui_release(androidComposeViewAccessibilityDelegateCompat2.getContentCaptureSessionCompat(view));
                }
            }

            public void onViewDetachedFromWindow(View view) {
                this.this$0.handler.removeCallbacks(this.this$0.semanticsChangeChecker);
                AccessibilityManager access$getAccessibilityManager$p = this.this$0.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.this$0;
                access$getAccessibilityManager$p.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                access$getAccessibilityManager$p.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
                this.this$0.setContentCaptureSession$ui_release((ContentCaptureSessionCompat) null);
            }
        });
        this.semanticsChangeChecker = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2(this);
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1(this);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Companion;", "", "()V", "AccessibilityActionsResourceIds", "", "AccessibilityCursorPositionUndefined", "", "AccessibilitySliderStepsCount", "ClassName", "", "ExtraDataIdKey", "ExtraDataTestTagKey", "InvalidId", "LogTag", "ParcelSafeTextLength", "SendRecurringAccessibilityEventsIntervalMillis", "", "TextClassName", "TextFieldClassName", "TextTraversedEventTimeoutMillis", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getHoveredVirtualViewId$ui_release() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final Function1<AccessibilityEvent, Boolean> getOnSendAccessibilityEvent$ui_release() {
        return this.onSendAccessibilityEvent;
    }

    public final void setOnSendAccessibilityEvent$ui_release(Function1<? super AccessibilityEvent, Boolean> function1) {
        this.onSendAccessibilityEvent = function1;
    }

    public final boolean getAccessibilityForceEnabledForTesting$ui_release() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
        this.currentSemanticsNodesInvalidated = true;
    }

    /* access modifiers changed from: private */
    public static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z) {
        List<AccessibilityServiceInfo> list;
        if (z) {
            list = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } else {
            list = CollectionsKt.emptyList();
        }
        androidComposeViewAccessibilityDelegateCompat.enabledServices = list;
    }

    /* access modifiers changed from: private */
    public static final void touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z) {
        androidComposeViewAccessibilityDelegateCompat.enabledServices = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
    }

    private final boolean isEnabled() {
        return isEnabledForAccessibility$ui_release() || isEnabledForContentCapture();
    }

    public final boolean isEnabledForAccessibility$ui_release() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        if (!this.accessibilityManager.isEnabled() || !(!this.enabledServices.isEmpty())) {
            return false;
        }
        return true;
    }

    private final boolean isEnabledForContentCapture() {
        return !AndroidComposeViewAccessibilityDelegateCompat_androidKt.getDisableContentCapture() && (this.contentCaptureSession != null || this.contentCaptureForceEnabledForTesting);
    }

    private final boolean isTouchExplorationEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    public final boolean getContentCaptureForceEnabledForTesting$ui_release() {
        return this.contentCaptureForceEnabledForTesting;
    }

    public final void setContentCaptureForceEnabledForTesting$ui_release(boolean z) {
        this.contentCaptureForceEnabledForTesting = z;
    }

    public final ContentCaptureSessionCompat getContentCaptureSession$ui_release() {
        return this.contentCaptureSession;
    }

    public final void setContentCaptureSession$ui_release(ContentCaptureSessionCompat contentCaptureSessionCompat) {
        this.contentCaptureSession = contentCaptureSessionCompat;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i, int i2, int i3, int i4, long j) {
            this.node = semanticsNode;
            this.action = i;
            this.granularity = i2;
            this.fromIndex = i3;
            this.toIndex = i4;
            this.traverseTime = j;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* access modifiers changed from: private */
    public final Map<Integer, SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getAllUncoveredSemanticsNodesToMap(this.view.getSemanticsOwner());
            if (isEnabledForAccessibility$ui_release()) {
                setTraversalValues();
            }
        }
        return this.currentSemanticsNodes;
    }

    public final HashMap<Integer, Integer> getIdToBeforeMap$ui_release() {
        return this.idToBeforeMap;
    }

    public final void setIdToBeforeMap$ui_release(HashMap<Integer, Integer> hashMap) {
        this.idToBeforeMap = hashMap;
    }

    public final HashMap<Integer, Integer> getIdToAfterMap$ui_release() {
        return this.idToAfterMap;
    }

    public final void setIdToAfterMap$ui_release(HashMap<Integer, Integer> hashMap) {
        this.idToAfterMap = hashMap;
    }

    public final String getExtraDataTestTraversalBeforeVal$ui_release() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    public final String getExtraDataTestTraversalAfterVal$ui_release() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "currentSemanticsNodes", "", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/Map;)V", "children", "", "getChildren", "()Ljava/util/Set;", "getSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "hasPaneTitle", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class SemanticsNodeCopy {
        private final Set<Integer> children = new LinkedHashSet();
        private final SemanticsNode semanticsNode;
        private final SemanticsConfiguration unmergedConfig;

        public SemanticsNodeCopy(SemanticsNode semanticsNode2, Map<Integer, SemanticsNodeWithAdjustedBounds> map) {
            this.semanticsNode = semanticsNode2;
            this.unmergedConfig = semanticsNode2.getUnmergedConfig$ui_release();
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode2.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i = 0; i < size; i++) {
                SemanticsNode semanticsNode3 = replacedChildren$ui_release.get(i);
                if (map.containsKey(Integer.valueOf(semanticsNode3.getId()))) {
                    this.children.add(Integer.valueOf(semanticsNode3.getId()));
                }
            }
        }

        public final SemanticsNode getSemanticsNode() {
            return this.semanticsNode;
        }

        public final SemanticsConfiguration getUnmergedConfig() {
            return this.unmergedConfig;
        }

        public final Set<Integer> getChildren() {
            return this.children;
        }

        public final boolean hasPaneTitle() {
            return this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getPaneTitle());
        }
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        initContentCapture(true);
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        initContentCapture(false);
    }

    /* renamed from: canScroll-0AR0LA0$ui_release  reason: not valid java name */
    public final boolean m5751canScroll0AR0LA0$ui_release(boolean z, int i, long j) {
        if (!Intrinsics.areEqual((Object) Looper.getMainLooper().getThread(), (Object) Thread.currentThread())) {
            return false;
        }
        return m5750canScrollmoWRBKg(getCurrentSemanticsNodes().values(), z, i, j);
    }

    /* renamed from: canScroll-moWRBKg  reason: not valid java name */
    private final boolean m5750canScrollmoWRBKg(Collection<SemanticsNodeWithAdjustedBounds> collection, boolean z, int i, long j) {
        SemanticsPropertyKey semanticsPropertyKey;
        ScrollAxisRange scrollAxisRange;
        if (Offset.m3559equalsimpl0(j, Offset.Companion.m3577getUnspecifiedF1C5BW0()) || !Offset.m3565isValidimpl(j)) {
            return false;
        }
        if (z) {
            semanticsPropertyKey = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else if (!z) {
            semanticsPropertyKey = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Iterable<SemanticsNodeWithAdjustedBounds> iterable = collection;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds : iterable) {
            if (RectHelper_androidKt.toComposeRect(semanticsNodeWithAdjustedBounds.getAdjustedBounds()).m3588containsk4lQ0M(j) && (scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNodeWithAdjustedBounds.getSemanticsNode().getConfig(), semanticsPropertyKey)) != null) {
                int i2 = scrollAxisRange.getReverseScrolling() ? -i : i;
                if (i == 0 && scrollAxisRange.getReverseScrolling()) {
                    i2 = -1;
                }
                if (i2 < 0) {
                    if (scrollAxisRange.getValue().invoke().floatValue() > 0.0f) {
                    }
                } else if (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue()) {
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r1v11, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r4v5, types: [android.view.ViewParent] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = (r0 = r0.getLifecycleOwner()).getLifecycle();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.accessibility.AccessibilityNodeInfo createNodeInfo(int r7) {
        /*
            r6 = this;
            androidx.compose.ui.platform.AndroidComposeView r0 = r6.view
            androidx.compose.ui.platform.AndroidComposeView$ViewTreeOwners r0 = r0.getViewTreeOwners()
            r1 = 0
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.LifecycleOwner r0 = r0.getLifecycleOwner()
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.Lifecycle$State r0 = r0.getCurrentState()
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.DESTROYED
            if (r0 != r2) goto L_0x0020
            return r1
        L_0x0020:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r0 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.obtain()
            java.util.Map r2 = r6.getCurrentSemanticsNodes()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object r2 = r2.get(r3)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            if (r2 != 0) goto L_0x0035
            return r1
        L_0x0035:
            androidx.compose.ui.semantics.SemanticsNode r3 = r2.getSemanticsNode()
            r4 = -1
            if (r7 != r4) goto L_0x004f
            androidx.compose.ui.platform.AndroidComposeView r4 = r6.view
            android.view.View r4 = (android.view.View) r4
            android.view.ViewParent r4 = androidx.core.view.ViewCompat.getParentForAccessibility(r4)
            boolean r5 = r4 instanceof android.view.View
            if (r5 == 0) goto L_0x004b
            r1 = r4
            android.view.View r1 = (android.view.View) r1
        L_0x004b:
            r0.setParent(r1)
            goto L_0x007e
        L_0x004f:
            androidx.compose.ui.semantics.SemanticsNode r5 = r3.getParent()
            if (r5 == 0) goto L_0x005d
            int r1 = r5.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x005d:
            if (r1 == 0) goto L_0x0094
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            androidx.compose.ui.platform.AndroidComposeView r5 = r6.view
            androidx.compose.ui.semantics.SemanticsOwner r5 = r5.getSemanticsOwner()
            androidx.compose.ui.semantics.SemanticsNode r5 = r5.getUnmergedRootSemanticsNode()
            int r5 = r5.getId()
            if (r1 != r5) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r4 = r1
        L_0x0077:
            androidx.compose.ui.platform.AndroidComposeView r1 = r6.view
            android.view.View r1 = (android.view.View) r1
            r0.setParent(r1, r4)
        L_0x007e:
            androidx.compose.ui.platform.AndroidComposeView r1 = r6.view
            android.view.View r1 = (android.view.View) r1
            r0.setSource(r1, r7)
            android.graphics.Rect r1 = r6.boundsInScreen(r2)
            r0.setBoundsInScreen(r1)
            r6.populateAccessibilityNodeInfoProperties(r7, r0, r3)
            android.view.accessibility.AccessibilityNodeInfo r7 = r0.unwrap()
            return r7
        L_0x0094:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "semanticsNode "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = " has null parent"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.createNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    /* access modifiers changed from: private */
    public final Rect boundsInScreen(SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds) {
        Rect adjustedBounds = semanticsNodeWithAdjustedBounds.getAdjustedBounds();
        long r0 = this.view.m5740localToScreenMKHz9U(OffsetKt.Offset((float) adjustedBounds.left, (float) adjustedBounds.top));
        long r2 = this.view.m5740localToScreenMKHz9U(OffsetKt.Offset((float) adjustedBounds.right, (float) adjustedBounds.bottom));
        return new Rect((int) ((float) Math.floor((double) Offset.m3562getXimpl(r0))), (int) ((float) Math.floor((double) Offset.m3563getYimpl(r0))), (int) ((float) Math.ceil((double) Offset.m3562getXimpl(r2))), (int) ((float) Math.ceil((double) Offset.m3563getYimpl(r2))));
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u000026\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002`\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007J<\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$TopBottomBoundsComparator;", "Ljava/util/Comparator;", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class TopBottomBoundsComparator implements Comparator<Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>> {
        public static final TopBottomBoundsComparator INSTANCE = new TopBottomBoundsComparator();

        private TopBottomBoundsComparator() {
        }

        public int compare(Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> pair, Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> pair2) {
            int compare = Float.compare(pair.getFirst().getTop(), pair2.getFirst().getTop());
            if (compare != 0) {
                return compare;
            }
            return Float.compare(pair.getFirst().getBottom(), pair2.getFirst().getBottom());
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$LtrBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class LtrBoundsComparator implements Comparator<SemanticsNode> {
        public static final LtrBoundsComparator INSTANCE = new LtrBoundsComparator();

        private LtrBoundsComparator() {
        }

        public int compare(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
            androidx.compose.ui.geometry.Rect boundsInWindow = semanticsNode.getBoundsInWindow();
            androidx.compose.ui.geometry.Rect boundsInWindow2 = semanticsNode2.getBoundsInWindow();
            int compare = Float.compare(boundsInWindow.getLeft(), boundsInWindow2.getLeft());
            if (compare != 0) {
                return compare;
            }
            int compare2 = Float.compare(boundsInWindow.getTop(), boundsInWindow2.getTop());
            if (compare2 != 0) {
                return compare2;
            }
            int compare3 = Float.compare(boundsInWindow.getBottom(), boundsInWindow2.getBottom());
            if (compare3 != 0) {
                return compare3;
            }
            return Float.compare(boundsInWindow.getRight(), boundsInWindow2.getRight());
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$RtlBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class RtlBoundsComparator implements Comparator<SemanticsNode> {
        public static final RtlBoundsComparator INSTANCE = new RtlBoundsComparator();

        private RtlBoundsComparator() {
        }

        public int compare(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
            androidx.compose.ui.geometry.Rect boundsInWindow = semanticsNode.getBoundsInWindow();
            androidx.compose.ui.geometry.Rect boundsInWindow2 = semanticsNode2.getBoundsInWindow();
            int compare = Float.compare(boundsInWindow2.getRight(), boundsInWindow.getRight());
            if (compare != 0) {
                return compare;
            }
            int compare2 = Float.compare(boundsInWindow.getTop(), boundsInWindow2.getTop());
            if (compare2 != 0) {
                return compare2;
            }
            int compare3 = Float.compare(boundsInWindow.getBottom(), boundsInWindow2.getBottom());
            if (compare3 != 0) {
                return compare3;
            }
            return Float.compare(boundsInWindow2.getLeft(), boundsInWindow.getLeft());
        }
    }

    private final Comparator<SemanticsNode> semanticComparator(boolean z) {
        return new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2<>(new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(z ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE, LayoutNode.Companion.getZComparator$ui_release()));
    }

    static /* synthetic */ List sortByGeometryGroupings$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z, ArrayList arrayList, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = new LinkedHashMap();
        }
        return androidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings(z, arrayList, map);
    }

    private final List<SemanticsNode> sortByGeometryGroupings(boolean z, ArrayList<SemanticsNode> arrayList, Map<Integer, List<SemanticsNode>> map) {
        ArrayList arrayList2 = new ArrayList();
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        int i = 0;
        if (lastIndex >= 0) {
            int i2 = 0;
            while (true) {
                SemanticsNode semanticsNode = arrayList.get(i2);
                if (i2 == 0 || !sortByGeometryGroupings$placedEntryRowOverlaps(arrayList2, semanticsNode)) {
                    arrayList2.add(new Pair(semanticsNode.getBoundsInWindow(), CollectionsKt.mutableListOf(semanticsNode)));
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        List list = arrayList2;
        CollectionsKt.sortWith(list, TopBottomBoundsComparator.INSTANCE);
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Pair pair = (Pair) list.get(i3);
            CollectionsKt.sortWith((List) pair.getSecond(), new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2(new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(z ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE, LayoutNode.Companion.getZComparator$ui_release())));
            arrayList3.addAll((Collection) pair.getSecond());
        }
        List<SemanticsNode> list2 = arrayList3;
        CollectionsKt.sortWith(list2, new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda3(AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$2.INSTANCE));
        while (i <= CollectionsKt.getLastIndex(list2)) {
            List list3 = map.get(Integer.valueOf(((SemanticsNode) arrayList3.get(i)).getId()));
            if (list3 != null) {
                if (!isScreenReaderFocusable((SemanticsNode) arrayList3.get(i))) {
                    arrayList3.remove(i);
                } else {
                    i++;
                }
                arrayList3.addAll(i, list3);
                i += list3.size();
            } else {
                i++;
            }
        }
        return list2;
    }

    private static final boolean sortByGeometryGroupings$placedEntryRowOverlaps(ArrayList<Pair<androidx.compose.ui.geometry.Rect, List<SemanticsNode>>> arrayList, SemanticsNode semanticsNode) {
        float top = semanticsNode.getBoundsInWindow().getTop();
        float bottom = semanticsNode.getBoundsInWindow().getBottom();
        boolean z = top >= bottom;
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        if (lastIndex >= 0) {
            int i = 0;
            while (true) {
                androidx.compose.ui.geometry.Rect rect = (androidx.compose.ui.geometry.Rect) arrayList.get(i).getFirst();
                boolean z2 = rect.getTop() >= rect.getBottom();
                if (z || z2 || Math.max(top, rect.getTop()) >= Math.min(bottom, rect.getBottom())) {
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    arrayList.set(i, new Pair(rect.intersect(0.0f, top, Float.POSITIVE_INFINITY, bottom), arrayList.get(i).getSecond()));
                    ((List) arrayList.get(i).getSecond()).add(semanticsNode);
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final int sortByGeometryGroupings$lambda$7(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private final List<SemanticsNode> subtreeSortedByGeometryGrouping(boolean z, List<SemanticsNode> list) {
        Map linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            geometryDepthFirstSearch(list.get(i), arrayList, linkedHashMap);
        }
        return sortByGeometryGroupings(z, arrayList, linkedHashMap);
    }

    private final void setTraversalValues() {
        SemanticsNode semanticsNode;
        this.idToBeforeMap.clear();
        this.idToAfterMap.clear();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(-1);
        if (semanticsNodeWithAdjustedBounds != null) {
            semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        } else {
            semanticsNode = null;
        }
        Intrinsics.checkNotNull(semanticsNode);
        int i = 1;
        List<SemanticsNode> subtreeSortedByGeometryGrouping = subtreeSortedByGeometryGrouping(semanticsNode.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl, CollectionsKt.mutableListOf(semanticsNode));
        int lastIndex = CollectionsKt.getLastIndex(subtreeSortedByGeometryGrouping);
        if (1 <= lastIndex) {
            while (true) {
                int id = subtreeSortedByGeometryGrouping.get(i - 1).getId();
                int id2 = subtreeSortedByGeometryGrouping.get(i).getId();
                this.idToBeforeMap.put(Integer.valueOf(id), Integer.valueOf(id2));
                this.idToAfterMap.put(Integer.valueOf(id2), Integer.valueOf(id));
                if (i != lastIndex) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean isScreenReaderFocusable(SemanticsNode semanticsNode) {
        boolean z = (AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoContentDescriptionOrNull(semanticsNode) == null && getInfoText(semanticsNode) == null && getInfoStateDescriptionOrNull(semanticsNode) == null && !getInfoIsCheckable(semanticsNode)) ? false : true;
        if (semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || (semanticsNode.isUnmergedLeafNode$ui_release() && z)) {
            return true;
        }
        return false;
    }

    private final void populateAccessibilityNodeInfoProperties(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        boolean z;
        int i2 = i;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
        SemanticsNode semanticsNode2 = semanticsNode;
        accessibilityNodeInfoCompat2.setClassName(ClassName);
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        if (role != null) {
            role.m5863unboximpl();
            if (semanticsNode.isFake$ui_release() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                if (Role.m5860equalsimpl0(role.m5863unboximpl(), Role.Companion.m5870getTabo7Vup1c())) {
                    accessibilityNodeInfoCompat2.setRoleDescription(this.view.getContext().getResources().getString(R.string.tab));
                } else {
                    if (Role.m5860equalsimpl0(role.m5863unboximpl(), Role.Companion.m5869getSwitcho7Vup1c())) {
                        accessibilityNodeInfoCompat2.setRoleDescription(this.view.getContext().getResources().getString(R.string.switch_role));
                    } else {
                        String r5 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.m5753toLegacyClassNameV4PA4sw(role.m5863unboximpl());
                        if (!Role.m5860equalsimpl0(role.m5863unboximpl(), Role.Companion.m5867getImageo7Vup1c()) || semanticsNode.isUnmergedLeafNode$ui_release() || semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
                            accessibilityNodeInfoCompat2.setClassName(r5);
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetText())) {
            accessibilityNodeInfoCompat2.setClassName(TextFieldClassName);
        }
        if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getText())) {
            accessibilityNodeInfoCompat2.setClassName(TextClassName);
        }
        accessibilityNodeInfoCompat2.setPackageName(this.view.getContext().getPackageName());
        accessibilityNodeInfoCompat2.setImportantForAccessibility(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isImportantForAccessibility(semanticsNode));
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            SemanticsNode semanticsNode3 = replacedChildren$ui_release.get(i3);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode3.getId()))) {
                AndroidViewHolder androidViewHolder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(semanticsNode3.getLayoutNode$ui_release());
                if (androidViewHolder != null) {
                    accessibilityNodeInfoCompat2.addChild(androidViewHolder);
                } else if (semanticsNode3.getId() != -1) {
                    accessibilityNodeInfoCompat2.addChild(this.view, semanticsNode3.getId());
                }
            }
        }
        if (i2 == this.focusedVirtualViewId) {
            accessibilityNodeInfoCompat2.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            accessibilityNodeInfoCompat2.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode2, accessibilityNodeInfoCompat2);
        setContentInvalid(semanticsNode2, accessibilityNodeInfoCompat2);
        setStateDescription(semanticsNode2, accessibilityNodeInfoCompat2);
        setIsCheckable(semanticsNode2, accessibilityNodeInfoCompat2);
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        if (toggleableState != null) {
            if (toggleableState == ToggleableState.On) {
                accessibilityNodeInfoCompat2.setChecked(true);
            } else if (toggleableState == ToggleableState.Off) {
                accessibilityNodeInfoCompat2.setChecked(false);
            }
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (role == null ? false : Role.m5860equalsimpl0(role.m5863unboximpl(), Role.Companion.m5870getTabo7Vup1c())) {
                accessibilityNodeInfoCompat2.setSelected(booleanValue);
            } else {
                accessibilityNodeInfoCompat2.setChecked(booleanValue);
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        if (!semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            accessibilityNodeInfoCompat2.setContentDescription(AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoContentDescriptionOrNull(semanticsNode));
        }
        String str = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag());
        if (str != null) {
            SemanticsNode semanticsNode4 = semanticsNode2;
            while (true) {
                if (semanticsNode4 == null) {
                    z = false;
                    break;
                } else if (semanticsNode4.getUnmergedConfig$ui_release().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                    z = ((Boolean) semanticsNode4.getUnmergedConfig$ui_release().get(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())).booleanValue();
                    break;
                } else {
                    semanticsNode4 = semanticsNode4.getParent();
                }
            }
            if (z) {
                accessibilityNodeInfoCompat2.setViewIdResourceName(str);
            }
        }
        if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHeading())) != null) {
            accessibilityNodeInfoCompat2.setHeading(true);
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat2.setPassword(semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getPassword()));
        accessibilityNodeInfoCompat2.setEditable(semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetText()));
        accessibilityNodeInfoCompat2.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode));
        accessibilityNodeInfoCompat2.setFocusable(semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getFocused()));
        int i4 = 2;
        if (accessibilityNodeInfoCompat.isFocusable()) {
            accessibilityNodeInfoCompat2.setFocused(((Boolean) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getFocused())).booleanValue());
            if (accessibilityNodeInfoCompat.isFocused()) {
                accessibilityNodeInfoCompat2.addAction(2);
            } else {
                accessibilityNodeInfoCompat2.addAction(1);
            }
        }
        accessibilityNodeInfoCompat2.setVisibleToUser(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(semanticsNode));
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getLiveRegion());
        if (liveRegionMode != null) {
            int r4 = liveRegionMode.m5854unboximpl();
            if (LiveRegionMode.m5851equalsimpl0(r4, LiveRegionMode.Companion.m5856getPolite0phEisY()) || !LiveRegionMode.m5851equalsimpl0(r4, LiveRegionMode.Companion.m5855getAssertive0phEisY())) {
                i4 = 1;
            }
            accessibilityNodeInfoCompat2.setLiveRegion(i4);
            Unit unit9 = Unit.INSTANCE;
            Unit unit10 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat2.setClickable(false);
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnClick());
        if (accessibilityAction != null) {
            boolean areEqual = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected()), (Object) true);
            accessibilityNodeInfoCompat2.setClickable(!areEqual);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && !areEqual) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
            }
            Unit unit11 = Unit.INSTANCE;
            Unit unit12 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat2.setLongClickable(false);
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnLongClick());
        if (accessibilityAction2 != null) {
            accessibilityNodeInfoCompat2.setLongClickable(true);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, accessibilityAction2.getLabel()));
            }
            Unit unit13 = Unit.INSTANCE;
            Unit unit14 = Unit.INSTANCE;
        }
        AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCopyText());
        if (accessibilityAction3 != null) {
            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, accessibilityAction3.getLabel()));
            Unit unit15 = Unit.INSTANCE;
            Unit unit16 = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetText());
            if (accessibilityAction4 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, accessibilityAction4.getLabel()));
                Unit unit17 = Unit.INSTANCE;
                Unit unit18 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnImeAction());
            if (accessibilityAction5 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908372, accessibilityAction5.getLabel()));
                Unit unit19 = Unit.INSTANCE;
                Unit unit20 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCutText());
            if (accessibilityAction6 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, accessibilityAction6.getLabel()));
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPasteText());
            if (accessibilityAction7 != null) {
                if (accessibilityNodeInfoCompat.isFocused() && this.view.getClipboardManager().hasText()) {
                    accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, accessibilityAction7.getLabel()));
                }
                Unit unit23 = Unit.INSTANCE;
                Unit unit24 = Unit.INSTANCE;
            }
        }
        CharSequence iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode2);
        if (!(iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0)) {
            accessibilityNodeInfoCompat2.setTextSelection(getAccessibilitySelectionStart(semanticsNode2), getAccessibilitySelectionEnd(semanticsNode2));
            AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetSelection());
            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, accessibilityAction8 != null ? accessibilityAction8.getLabel() : null));
            accessibilityNodeInfoCompat2.addAction(256);
            accessibilityNodeInfoCompat2.addAction(512);
            accessibilityNodeInfoCompat2.setMovementGranularities(11);
            Collection collection = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
            if ((collection == null || collection.isEmpty()) && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode)) {
                accessibilityNodeInfoCompat2.setMovementGranularities(accessibilityNodeInfoCompat.getMovementGranularities() | 20);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            List arrayList = new ArrayList();
            arrayList.add(ExtraDataIdKey);
            CharSequence text = accessibilityNodeInfoCompat.getText();
            if (!(text == null || text.length() == 0) && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag())) {
                arrayList.add(ExtraDataTestTagKey);
            }
            AccessibilityNodeInfoVerificationHelperMethods.INSTANCE.setAvailableExtraData(accessibilityNodeInfoCompat.unwrap(), arrayList);
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                accessibilityNodeInfoCompat2.setClassName("android.widget.SeekBar");
            } else {
                accessibilityNodeInfoCompat2.setClassName("android.widget.ProgressBar");
            }
            if (progressBarRangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                accessibilityNodeInfoCompat2.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getCurrent()));
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (progressBarRangeInfo.getCurrent() < RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue())) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                }
                if (progressBarRangeInfo.getCurrent() > RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue())) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.addSetProgressAction(accessibilityNodeInfoCompat, semanticsNode);
        }
        CollectionInfo_androidKt.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat2);
        CollectionInfo_androidKt.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat2);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getScrollBy());
        if (!(scrollAxisRange == null || accessibilityAction9 == null)) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat2.setClassName("android.widget.HorizontalScrollView");
            }
            if (scrollAxisRange.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat2.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    if (!(semanticsNode.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl)) {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    } else {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    }
                    accessibilityNodeInfoCompat2.addAction(accessibilityActionCompat2);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    if (!(semanticsNode.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl)) {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    } else {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    }
                    accessibilityNodeInfoCompat2.addAction(accessibilityActionCompat);
                }
            }
        }
        ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (!(scrollAxisRange2 == null || accessibilityAction9 == null)) {
            if (!CollectionInfo_androidKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat2.setClassName("android.widget.ScrollView");
            }
            if (scrollAxisRange2.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat2.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.addPageActions(accessibilityNodeInfoCompat, semanticsNode);
        }
        accessibilityNodeInfoCompat2.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getPaneTitle()));
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getExpand());
            if (accessibilityAction10 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, accessibilityAction10.getLabel()));
                Unit unit25 = Unit.INSTANCE;
                Unit unit26 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCollapse());
            if (accessibilityAction11 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, accessibilityAction11.getLabel()));
                Unit unit27 = Unit.INSTANCE;
                Unit unit28 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getDismiss());
            if (accessibilityAction12 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, accessibilityAction12.getLabel()));
                Unit unit29 = Unit.INSTANCE;
                Unit unit30 = Unit.INSTANCE;
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                List list = (List) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getCustomActions());
                int size2 = list.size();
                int[] iArr = AccessibilityActionsResourceIds;
                if (size2 < iArr.length) {
                    SparseArrayCompat sparseArrayCompat = new SparseArrayCompat(0, 1, (DefaultConstructorMarker) null);
                    Map linkedHashMap = new LinkedHashMap();
                    if (this.labelToActionId.containsKey(i2)) {
                        Map map = this.labelToActionId.get(i2);
                        List<Integer> mutableList = ArraysKt.toMutableList(iArr);
                        List arrayList2 = new ArrayList();
                        int size3 = list.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list.get(i5);
                            Intrinsics.checkNotNull(map);
                            if (map.containsKey(customAccessibilityAction.getLabel())) {
                                Integer num = (Integer) map.get(customAccessibilityAction.getLabel());
                                Intrinsics.checkNotNull(num);
                                sparseArrayCompat.put(num.intValue(), customAccessibilityAction.getLabel());
                                linkedHashMap.put(customAccessibilityAction.getLabel(), num);
                                mutableList.remove(num);
                                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(num.intValue(), customAccessibilityAction.getLabel()));
                            } else {
                                arrayList2.add(customAccessibilityAction);
                            }
                        }
                        int size4 = arrayList2.size();
                        for (int i6 = 0; i6 < size4; i6++) {
                            CustomAccessibilityAction customAccessibilityAction2 = (CustomAccessibilityAction) arrayList2.get(i6);
                            int intValue = mutableList.get(i6).intValue();
                            sparseArrayCompat.put(intValue, customAccessibilityAction2.getLabel());
                            linkedHashMap.put(customAccessibilityAction2.getLabel(), Integer.valueOf(intValue));
                            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(intValue, customAccessibilityAction2.getLabel()));
                        }
                    } else {
                        int size5 = list.size();
                        for (int i7 = 0; i7 < size5; i7++) {
                            CustomAccessibilityAction customAccessibilityAction3 = (CustomAccessibilityAction) list.get(i7);
                            int i8 = AccessibilityActionsResourceIds[i7];
                            sparseArrayCompat.put(i8, customAccessibilityAction3.getLabel());
                            linkedHashMap.put(customAccessibilityAction3.getLabel(), Integer.valueOf(i8));
                            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i8, customAccessibilityAction3.getLabel()));
                        }
                    }
                    this.actionIdToLabel.put(i2, sparseArrayCompat);
                    this.labelToActionId.put(i2, linkedHashMap);
                } else {
                    throw new IllegalStateException("Can't have more than " + iArr.length + " custom actions for one widget");
                }
            }
        }
        accessibilityNodeInfoCompat2.setScreenReaderFocusable(isScreenReaderFocusable(semanticsNode2));
        Integer num2 = this.idToBeforeMap.get(Integer.valueOf(i));
        if (num2 != null) {
            num2.intValue();
            View semanticsIdToView = AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), num2.intValue());
            if (semanticsIdToView != null) {
                accessibilityNodeInfoCompat2.setTraversalBefore(semanticsIdToView);
            } else {
                accessibilityNodeInfoCompat2.setTraversalBefore(this.view, num2.intValue());
            }
            addExtraDataToAccessibilityNodeInfoHelper(i2, accessibilityNodeInfoCompat.unwrap(), this.ExtraDataTestTraversalBeforeVal, (Bundle) null);
            Unit unit31 = Unit.INSTANCE;
            Unit unit32 = Unit.INSTANCE;
        }
        Integer num3 = this.idToAfterMap.get(Integer.valueOf(i));
        if (num3 != null) {
            num3.intValue();
            View semanticsIdToView2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(this.view.getAndroidViewsHandler$ui_release(), num3.intValue());
            if (semanticsIdToView2 != null) {
                accessibilityNodeInfoCompat2.setTraversalAfter(semanticsIdToView2);
                addExtraDataToAccessibilityNodeInfoHelper(i2, accessibilityNodeInfoCompat.unwrap(), this.ExtraDataTestTraversalAfterVal, (Bundle) null);
            }
            Unit unit33 = Unit.INSTANCE;
            Unit unit34 = Unit.INSTANCE;
        }
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && scrollAxisRange.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && scrollAxisRange.getReverseScrolling());
    }

    private final void setContentInvalid(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getError())) {
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final String getInfoStateDescriptionOrNull(SemanticsNode semanticsNode) {
        Object obj;
        float f;
        int i;
        Object orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getStateDescription());
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        if (toggleableState != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i2 == 1) {
                if ((role == null ? false : Role.m5860equalsimpl0(role.m5863unboximpl(), Role.Companion.m5869getSwitcho7Vup1c())) && orNull == null) {
                    orNull = this.view.getContext().getResources().getString(R.string.on);
                }
            } else if (i2 == 2) {
                if ((role == null ? false : Role.m5860equalsimpl0(role.m5863unboximpl(), Role.Companion.m5869getSwitcho7Vup1c())) && orNull == null) {
                    orNull = this.view.getContext().getResources().getString(R.string.off);
                }
            } else if (i2 == 3 && orNull == null) {
                orNull = this.view.getContext().getResources().getString(R.string.indeterminate);
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (!(role == null ? false : Role.m5860equalsimpl0(role.m5863unboximpl(), Role.Companion.m5870getTabo7Vup1c())) && orNull == null) {
                if (booleanValue) {
                    orNull = this.view.getContext().getResources().getString(R.string.selected);
                } else {
                    orNull = this.view.getContext().getResources().getString(R.string.not_selected);
                }
            }
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (progressBarRangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                if (orNull == null) {
                    ClosedFloatingPointRange<Float> range = progressBarRangeInfo.getRange();
                    if (range.getEndInclusive().floatValue() - range.getStart().floatValue() == 0.0f) {
                        f = 0.0f;
                    } else {
                        f = (progressBarRangeInfo.getCurrent() - range.getStart().floatValue()) / (range.getEndInclusive().floatValue() - range.getStart().floatValue());
                    }
                    float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
                    if (coerceIn == 0.0f) {
                        i = 0;
                    } else {
                        i = 100;
                        if (!(coerceIn == 1.0f)) {
                            i = RangesKt.coerceIn(MathKt.roundToInt(coerceIn * ((float) 100)), 1, 99);
                        }
                    }
                    obj = this.view.getContext().getResources().getString(R.string.template_percent, new Object[]{Integer.valueOf(i)});
                }
            } else if (orNull == null) {
                obj = this.view.getContext().getResources().getString(R.string.in_progress);
            }
            orNull = obj;
        }
        return (String) orNull;
    }

    private final void setStateDescription(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.setStateDescription(getInfoStateDescriptionOrNull(semanticsNode));
    }

    private final boolean getInfoIsCheckable(SemanticsNode semanticsNode) {
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        boolean z = true;
        boolean z2 = false;
        boolean z3 = toggleableState != null;
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool == null) {
            return z3;
        }
        bool.booleanValue();
        int r6 = Role.Companion.m5870getTabo7Vup1c();
        if (role != null) {
            z2 = Role.m5860equalsimpl0(role.m5863unboximpl(), r6);
        }
        if (z2) {
            z = z3;
        }
        return z;
    }

    private final void setIsCheckable(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.setCheckable(getInfoIsCheckable(semanticsNode));
    }

    private final SpannableString getInfoText(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        FontFamily.Resolver fontFamilyResolver = this.view.getFontFamilyResolver();
        AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
        SpannableString spannableString = null;
        SpannableString spannableString2 = (SpannableString) trimToSize(textForTextField != null ? AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(textForTextField, this.view.getDensity(), fontFamilyResolver, this.urlSpanCache) : null, 100000);
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (!(list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null)) {
            spannableString = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), fontFamilyResolver, this.urlSpanCache);
        }
        return spannableString2 == null ? (SpannableString) trimToSize(spannableString, 100000) : spannableString2;
    }

    private final void setText(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.setText(getInfoText(semanticsNode));
    }

    private final boolean isAccessibilityFocused(int i) {
        return this.focusedVirtualViewId == i;
    }

    private final boolean requestAccessibilityFocus(int i) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(i)) {
            return false;
        }
        int i2 = this.focusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i2, 65536, (Integer) null, (List) null, 12, (Object) null);
        }
        this.focusedVirtualViewId = i;
        this.view.invalidate();
        sendEventForVirtualView$default(this, i, 32768, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int i, int i2, Integer num, List<String> list) {
        if (i == Integer.MIN_VALUE || !isEnabled()) {
            return false;
        }
        AccessibilityEvent createEvent = createEvent(i, i2);
        if (num != null) {
            createEvent.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            createEvent.setContentDescription(ListUtilsKt.fastJoinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        return sendEvent(createEvent);
    }

    private final boolean sendEvent(AccessibilityEvent accessibilityEvent) {
        if (!isEnabledForAccessibility$ui_release()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.sendingFocusAffectingEvent = true;
        }
        try {
            return this.onSendAccessibilityEvent.invoke(accessibilityEvent).booleanValue();
        } finally {
            this.sendingFocusAffectingEvent = false;
        }
    }

    private final AccessibilityEvent createEvent(int i, int i2) {
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setEnabled(true);
        obtain.setClassName(ClassName);
        obtain.setPackageName(this.view.getContext().getPackageName());
        obtain.setSource(this.view, i);
        if (isEnabledForAccessibility$ui_release() && (semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i))) != null) {
            obtain.setPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode().getConfig().contains(SemanticsProperties.INSTANCE.getPassword()));
        }
        return obtain;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int i, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent createEvent = createEvent(i, 8192);
        if (num != null) {
            createEvent.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            createEvent.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            createEvent.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            createEvent.getText().add(charSequence);
        }
        return createEvent;
    }

    private final boolean clearAccessibilityFocus(int i) {
        if (!isAccessibilityFocused(i)) {
            return false;
        }
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.currentlyFocusedANI = null;
        this.view.invalidate();
        sendEventForVirtualView$default(this, i, 65536, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r4v14, types: [java.lang.String] */
    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x01c1 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a5 A[ADDED_TO_REGION] */
    public final boolean performActionHelper(int r13, int r14, android.os.Bundle r15) {
        /*
            r12 = this;
            java.util.Map r0 = r12.getCurrentSemanticsNodes()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            java.lang.Object r0 = r0.get(r1)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r0 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r0
            r1 = 0
            if (r0 == 0) goto L_0x062c
            androidx.compose.ui.semantics.SemanticsNode r0 = r0.getSemanticsNode()
            if (r0 != 0) goto L_0x0019
            goto L_0x062c
        L_0x0019:
            r2 = 64
            if (r14 == r2) goto L_0x0627
            r2 = 128(0x80, float:1.794E-43)
            if (r14 == r2) goto L_0x0622
            r2 = 256(0x100, float:3.59E-43)
            r3 = 1
            if (r14 == r2) goto L_0x060b
            r4 = 512(0x200, float:7.175E-43)
            if (r14 == r4) goto L_0x060b
            r2 = 16384(0x4000, float:2.2959E-41)
            if (r14 == r2) goto L_0x05e6
            r2 = 131072(0x20000, float:1.83671E-40)
            if (r14 == r2) goto L_0x05ba
            boolean r2 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(r0)
            if (r2 != 0) goto L_0x0039
            return r1
        L_0x0039:
            if (r14 == r3) goto L_0x0595
            r2 = 2
            r4 = 0
            if (r14 == r2) goto L_0x0570
            switch(r14) {
                case 16: goto L_0x053d;
                case 32: goto L_0x0518;
                case 4096: goto L_0x037a;
                case 8192: goto L_0x037a;
                case 32768: goto L_0x0355;
                case 65536: goto L_0x0330;
                case 262144: goto L_0x030b;
                case 524288: goto L_0x02e6;
                case 1048576: goto L_0x02c1;
                case 2097152: goto L_0x0285;
                case 16908342: goto L_0x0189;
                case 16908349: goto L_0x0151;
                case 16908372: goto L_0x012c;
                default: goto L_0x0042;
            }
        L_0x0042:
            switch(r14) {
                case 16908344: goto L_0x037a;
                case 16908345: goto L_0x037a;
                case 16908346: goto L_0x037a;
                case 16908347: goto L_0x037a;
                default: goto L_0x0045;
            }
        L_0x0045:
            switch(r14) {
                case 16908358: goto L_0x0107;
                case 16908359: goto L_0x00e2;
                case 16908360: goto L_0x00bd;
                case 16908361: goto L_0x0098;
                default: goto L_0x0048;
            }
        L_0x0048:
            androidx.collection.SparseArrayCompat<androidx.collection.SparseArrayCompat<java.lang.CharSequence>> r15 = r12.actionIdToLabel
            java.lang.Object r13 = r15.get(r13)
            androidx.collection.SparseArrayCompat r13 = (androidx.collection.SparseArrayCompat) r13
            if (r13 == 0) goto L_0x0097
            java.lang.Object r13 = r13.get(r14)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r13 != 0) goto L_0x005b
            goto L_0x0097
        L_0x005b:
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r15 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r15 = r15.getCustomActions()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r15)
            java.util.List r14 = (java.util.List) r14
            if (r14 != 0) goto L_0x006e
            return r1
        L_0x006e:
            int r15 = r14.size()
            r0 = r1
        L_0x0073:
            if (r0 >= r15) goto L_0x0097
            java.lang.Object r2 = r14.get(r0)
            androidx.compose.ui.semantics.CustomAccessibilityAction r2 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r2
            java.lang.String r3 = r2.getLabel()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r13)
            if (r3 == 0) goto L_0x0094
            kotlin.jvm.functions.Function0 r13 = r2.getAction()
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            return r13
        L_0x0094:
            int r0 = r0 + 1
            goto L_0x0073
        L_0x0097:
            return r1
        L_0x0098:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getPageRight()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x00bc
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x00bc
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x00bc:
            return r1
        L_0x00bd:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getPageLeft()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x00e1
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x00e1
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x00e1:
            return r1
        L_0x00e2:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getPageDown()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x0106
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x0106
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0106:
            return r1
        L_0x0107:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getPageUp()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x012b
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x012b
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x012b:
            return r1
        L_0x012c:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getOnImeAction()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x0150
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x0150
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0150:
            return r1
        L_0x0151:
            if (r15 == 0) goto L_0x0188
            java.lang.String r13 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"
            boolean r14 = r15.containsKey(r13)
            if (r14 != 0) goto L_0x015c
            goto L_0x0188
        L_0x015c:
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r0 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r0 = r0.getSetProgress()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r0)
            androidx.compose.ui.semantics.AccessibilityAction r14 = (androidx.compose.ui.semantics.AccessibilityAction) r14
            if (r14 == 0) goto L_0x0188
            kotlin.Function r14 = r14.getAction()
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            if (r14 == 0) goto L_0x0188
            float r13 = r15.getFloat(r13)
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.Object r13 = r14.invoke(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0188:
            return r1
        L_0x0189:
            androidx.compose.ui.semantics.SemanticsNode r13 = r0.getParent()
            if (r13 == 0) goto L_0x01a2
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r13.getConfig()
            if (r14 == 0) goto L_0x01a2
            androidx.compose.ui.semantics.SemanticsActions r15 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r15 = r15.getScrollBy()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r15)
            androidx.compose.ui.semantics.AccessibilityAction r14 = (androidx.compose.ui.semantics.AccessibilityAction) r14
            goto L_0x01a3
        L_0x01a2:
            r14 = r4
        L_0x01a3:
            if (r13 == 0) goto L_0x01c1
            if (r14 == 0) goto L_0x01a8
            goto L_0x01c1
        L_0x01a8:
            androidx.compose.ui.semantics.SemanticsNode r13 = r13.getParent()
            if (r13 == 0) goto L_0x01a2
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r13.getConfig()
            if (r14 == 0) goto L_0x01a2
            androidx.compose.ui.semantics.SemanticsActions r15 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r15 = r15.getScrollBy()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r15)
            androidx.compose.ui.semantics.AccessibilityAction r14 = (androidx.compose.ui.semantics.AccessibilityAction) r14
            goto L_0x01a3
        L_0x01c1:
            if (r13 != 0) goto L_0x01c4
            return r1
        L_0x01c4:
            androidx.compose.ui.layout.LayoutInfo r15 = r13.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r15 = r15.getCoordinates()
            androidx.compose.ui.geometry.Rect r15 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r15)
            androidx.compose.ui.layout.LayoutInfo r2 = r13.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r2 = r2.getCoordinates()
            androidx.compose.ui.layout.LayoutCoordinates r2 = r2.getParentLayoutCoordinates()
            if (r2 == 0) goto L_0x01e3
            long r4 = androidx.compose.ui.layout.LayoutCoordinatesKt.positionInRoot(r2)
            goto L_0x01e9
        L_0x01e3:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r2.m3578getZeroF1C5BW0()
        L_0x01e9:
            androidx.compose.ui.geometry.Rect r15 = r15.m3599translatek4lQ0M(r4)
            long r4 = r0.m5872getPositionInRootF1C5BW0()
            long r6 = r0.m5874getSizeYbymL2g()
            long r6 = androidx.compose.ui.unit.IntSizeKt.m6800toSizeozmzZPI(r6)
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.geometry.RectKt.m3602Recttz77jQw(r4, r6)
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r13.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r5 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getHorizontalScrollAxisRange()
            java.lang.Object r4 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r4, r5)
            androidx.compose.ui.semantics.ScrollAxisRange r4 = (androidx.compose.ui.semantics.ScrollAxisRange) r4
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r13.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r5 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getVerticalScrollAxisRange()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r5)
            androidx.compose.ui.semantics.ScrollAxisRange r13 = (androidx.compose.ui.semantics.ScrollAxisRange) r13
            float r5 = r2.getLeft()
            float r6 = r15.getLeft()
            float r5 = r5 - r6
            float r6 = r2.getRight()
            float r7 = r15.getRight()
            float r6 = r6 - r7
            float r5 = performActionHelper$scrollDelta(r5, r6)
            if (r4 == 0) goto L_0x023c
            boolean r4 = r4.getReverseScrolling()
            if (r4 != r3) goto L_0x023c
            float r5 = -r5
        L_0x023c:
            androidx.compose.ui.layout.LayoutInfo r0 = r0.getLayoutInfo()
            androidx.compose.ui.unit.LayoutDirection r0 = r0.getLayoutDirection()
            androidx.compose.ui.unit.LayoutDirection r4 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r0 != r4) goto L_0x0249
            float r5 = -r5
        L_0x0249:
            float r0 = r2.getTop()
            float r4 = r15.getTop()
            float r0 = r0 - r4
            float r2 = r2.getBottom()
            float r15 = r15.getBottom()
            float r2 = r2 - r15
            float r15 = performActionHelper$scrollDelta(r0, r2)
            if (r13 == 0) goto L_0x0268
            boolean r13 = r13.getReverseScrolling()
            if (r13 != r3) goto L_0x0268
            float r15 = -r15
        L_0x0268:
            if (r14 == 0) goto L_0x0284
            kotlin.Function r13 = r14.getAction()
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            if (r13 == 0) goto L_0x0284
            java.lang.Float r14 = java.lang.Float.valueOf(r5)
            java.lang.Float r15 = java.lang.Float.valueOf(r15)
            java.lang.Object r13 = r13.invoke(r14, r15)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0284:
            return r1
        L_0x0285:
            if (r15 == 0) goto L_0x028d
            java.lang.String r13 = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE"
            java.lang.String r4 = r15.getString(r13)
        L_0x028d:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getSetText()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x02c0
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            if (r13 == 0) goto L_0x02c0
            androidx.compose.ui.text.AnnotatedString r14 = new androidx.compose.ui.text.AnnotatedString
            if (r4 != 0) goto L_0x02ad
            java.lang.String r4 = ""
        L_0x02ad:
            r6 = r4
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            r5 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            java.lang.Object r13 = r13.invoke(r14)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x02c0:
            return r1
        L_0x02c1:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getDismiss()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x02e5
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x02e5
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x02e5:
            return r1
        L_0x02e6:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getCollapse()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x030a
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x030a
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x030a:
            return r1
        L_0x030b:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getExpand()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x032f
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x032f
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x032f:
            return r1
        L_0x0330:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getCutText()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x0354
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x0354
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0354:
            return r1
        L_0x0355:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getPasteText()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x0379
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x0379
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0379:
            return r1
        L_0x037a:
            r13 = 4096(0x1000, float:5.74E-42)
            if (r14 != r13) goto L_0x0380
            r13 = r3
            goto L_0x0381
        L_0x0380:
            r13 = r1
        L_0x0381:
            r15 = 8192(0x2000, float:1.14794E-41)
            if (r14 != r15) goto L_0x0387
            r15 = r3
            goto L_0x0388
        L_0x0387:
            r15 = r1
        L_0x0388:
            r2 = 16908345(0x1020039, float:2.387739E-38)
            if (r14 != r2) goto L_0x038f
            r2 = r3
            goto L_0x0390
        L_0x038f:
            r2 = r1
        L_0x0390:
            r4 = 16908347(0x102003b, float:2.3877394E-38)
            if (r14 != r4) goto L_0x0397
            r4 = r3
            goto L_0x0398
        L_0x0397:
            r4 = r1
        L_0x0398:
            r5 = 16908344(0x1020038, float:2.3877386E-38)
            if (r14 != r5) goto L_0x039f
            r5 = r3
            goto L_0x03a0
        L_0x039f:
            r5 = r1
        L_0x03a0:
            r6 = 16908346(0x102003a, float:2.3877392E-38)
            if (r14 != r6) goto L_0x03a7
            r14 = r3
            goto L_0x03a8
        L_0x03a7:
            r14 = r1
        L_0x03a8:
            if (r2 != 0) goto L_0x03b3
            if (r4 != 0) goto L_0x03b3
            if (r13 != 0) goto L_0x03b3
            if (r15 == 0) goto L_0x03b1
            goto L_0x03b3
        L_0x03b1:
            r6 = r1
            goto L_0x03b4
        L_0x03b3:
            r6 = r3
        L_0x03b4:
            if (r5 != 0) goto L_0x03bf
            if (r14 != 0) goto L_0x03bf
            if (r13 != 0) goto L_0x03bf
            if (r15 == 0) goto L_0x03bd
            goto L_0x03bf
        L_0x03bd:
            r14 = r1
            goto L_0x03c0
        L_0x03bf:
            r14 = r3
        L_0x03c0:
            if (r13 != 0) goto L_0x03c4
            if (r15 == 0) goto L_0x0459
        L_0x03c4:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getProgressBarRangeInfo()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r7)
            androidx.compose.ui.semantics.ProgressBarRangeInfo r13 = (androidx.compose.ui.semantics.ProgressBarRangeInfo) r13
            androidx.compose.ui.semantics.SemanticsConfiguration r7 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r8 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r8 = r8.getSetProgress()
            java.lang.Object r7 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r7, r8)
            androidx.compose.ui.semantics.AccessibilityAction r7 = (androidx.compose.ui.semantics.AccessibilityAction) r7
            if (r13 == 0) goto L_0x0459
            if (r7 == 0) goto L_0x0459
            kotlin.ranges.ClosedFloatingPointRange r14 = r13.getRange()
            java.lang.Comparable r14 = r14.getEndInclusive()
            java.lang.Number r14 = (java.lang.Number) r14
            float r14 = r14.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r0 = r13.getRange()
            java.lang.Comparable r0 = r0.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r14 = kotlin.ranges.RangesKt.coerceAtLeast((float) r14, (float) r0)
            kotlin.ranges.ClosedFloatingPointRange r0 = r13.getRange()
            java.lang.Comparable r0 = r0.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r2 = r13.getRange()
            java.lang.Comparable r2 = r2.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            float r0 = kotlin.ranges.RangesKt.coerceAtMost((float) r0, (float) r2)
            int r2 = r13.getSteps()
            if (r2 <= 0) goto L_0x0435
            float r14 = r14 - r0
            int r0 = r13.getSteps()
            int r0 = r0 + r3
            goto L_0x0438
        L_0x0435:
            float r14 = r14 - r0
            r0 = 20
        L_0x0438:
            float r0 = (float) r0
            float r14 = r14 / r0
            if (r15 == 0) goto L_0x043d
            float r14 = -r14
        L_0x043d:
            kotlin.Function r15 = r7.getAction()
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            if (r15 == 0) goto L_0x0458
            float r13 = r13.getCurrent()
            float r13 = r13 + r14
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.Object r13 = r15.invoke(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0458:
            return r1
        L_0x0459:
            androidx.compose.ui.layout.LayoutInfo r13 = r0.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r13 = r13.getCoordinates()
            androidx.compose.ui.geometry.Rect r13 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r13)
            long r7 = r13.m3595getSizeNHjbRc()
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getScrollBy()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r3)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 != 0) goto L_0x047c
            return r1
        L_0x047c:
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r9 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r9 = r9.getHorizontalScrollAxisRange()
            java.lang.Object r3 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r3, r9)
            androidx.compose.ui.semantics.ScrollAxisRange r3 = (androidx.compose.ui.semantics.ScrollAxisRange) r3
            r9 = 0
            if (r3 == 0) goto L_0x04d3
            if (r6 == 0) goto L_0x04d3
            float r6 = androidx.compose.ui.geometry.Size.m3631getWidthimpl(r7)
            if (r2 != 0) goto L_0x0499
            if (r15 == 0) goto L_0x049a
        L_0x0499:
            float r6 = -r6
        L_0x049a:
            boolean r10 = r3.getReverseScrolling()
            if (r10 == 0) goto L_0x04a1
            float r6 = -r6
        L_0x04a1:
            androidx.compose.ui.layout.LayoutInfo r10 = r0.getLayoutInfo()
            androidx.compose.ui.unit.LayoutDirection r10 = r10.getLayoutDirection()
            androidx.compose.ui.unit.LayoutDirection r11 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r10 != r11) goto L_0x04b2
            if (r2 != 0) goto L_0x04b1
            if (r4 == 0) goto L_0x04b2
        L_0x04b1:
            float r6 = -r6
        L_0x04b2:
            boolean r2 = performActionHelper$canScroll(r3, r6)
            if (r2 == 0) goto L_0x04d3
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            if (r13 == 0) goto L_0x04d2
            java.lang.Float r14 = java.lang.Float.valueOf(r6)
            java.lang.Float r15 = java.lang.Float.valueOf(r9)
            java.lang.Object r13 = r13.invoke(r14, r15)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x04d2:
            return r1
        L_0x04d3:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getVerticalScrollAxisRange()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r2)
            androidx.compose.ui.semantics.ScrollAxisRange r0 = (androidx.compose.ui.semantics.ScrollAxisRange) r0
            if (r0 == 0) goto L_0x0517
            if (r14 == 0) goto L_0x0517
            float r14 = androidx.compose.ui.geometry.Size.m3628getHeightimpl(r7)
            if (r5 != 0) goto L_0x04ef
            if (r15 == 0) goto L_0x04f0
        L_0x04ef:
            float r14 = -r14
        L_0x04f0:
            boolean r15 = r0.getReverseScrolling()
            if (r15 == 0) goto L_0x04f7
            float r14 = -r14
        L_0x04f7:
            boolean r15 = performActionHelper$canScroll(r0, r14)
            if (r15 == 0) goto L_0x0517
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            if (r13 == 0) goto L_0x0517
            java.lang.Float r15 = java.lang.Float.valueOf(r9)
            java.lang.Float r14 = java.lang.Float.valueOf(r14)
            java.lang.Object r13 = r13.invoke(r15, r14)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0517:
            return r1
        L_0x0518:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getOnLongClick()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x053c
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x053c
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x053c:
            return r1
        L_0x053d:
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r15 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r15 = r15.getOnClick()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r15)
            androidx.compose.ui.semantics.AccessibilityAction r14 = (androidx.compose.ui.semantics.AccessibilityAction) r14
            if (r14 == 0) goto L_0x055e
            kotlin.Function r14 = r14.getAction()
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            if (r14 == 0) goto L_0x055e
            java.lang.Object r14 = r14.invoke()
            r4 = r14
            java.lang.Boolean r4 = (java.lang.Boolean) r4
        L_0x055e:
            r10 = 12
            r11 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r5 = r12
            r6 = r13
            sendEventForVirtualView$default(r5, r6, r7, r8, r9, r10, r11)
            if (r4 == 0) goto L_0x056f
            boolean r1 = r4.booleanValue()
        L_0x056f:
            return r1
        L_0x0570:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r14 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getFocused()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r3)
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x0594
            androidx.compose.ui.platform.AndroidComposeView r13 = r12.view
            androidx.compose.ui.focus.FocusOwner r13 = r13.getFocusOwner()
            androidx.compose.ui.focus.FocusManager r13 = (androidx.compose.ui.focus.FocusManager) r13
            androidx.compose.ui.focus.FocusManager.CC.clearFocus$default(r13, r1, r3, r4)
            r1 = r3
        L_0x0594:
            return r1
        L_0x0595:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getRequestFocus()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x05b9
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x05b9
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x05b9:
            return r1
        L_0x05ba:
            r13 = -1
            if (r15 == 0) goto L_0x05c4
            java.lang.String r14 = "ACTION_ARGUMENT_SELECTION_START_INT"
            int r14 = r15.getInt(r14, r13)
            goto L_0x05c5
        L_0x05c4:
            r14 = r13
        L_0x05c5:
            if (r15 == 0) goto L_0x05cd
            java.lang.String r2 = "ACTION_ARGUMENT_SELECTION_END_INT"
            int r13 = r15.getInt(r2, r13)
        L_0x05cd:
            boolean r13 = r12.setAccessibilitySelection(r0, r14, r13, r1)
            if (r13 == 0) goto L_0x05e5
            int r14 = r0.getId()
            int r1 = r12.semanticsNodeIdToAccessibilityVirtualNodeId(r14)
            r5 = 12
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r0 = r12
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x05e5:
            return r13
        L_0x05e6:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getCopyText()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x060a
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x060a
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x060a:
            return r1
        L_0x060b:
            if (r15 == 0) goto L_0x0621
            java.lang.String r13 = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"
            int r13 = r15.getInt(r13)
            java.lang.String r4 = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN"
            boolean r15 = r15.getBoolean(r4)
            if (r14 != r2) goto L_0x061c
            r1 = r3
        L_0x061c:
            boolean r13 = r12.traverseAtGranularity(r0, r13, r1, r15)
            return r13
        L_0x0621:
            return r1
        L_0x0622:
            boolean r13 = r12.clearAccessibilityFocus(r13)
            return r13
        L_0x0627:
            boolean r13 = r12.requestAccessibilityFocus(r13)
            return r13
        L_0x062c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f) {
        return (f < 0.0f && scrollAxisRange.getValue().invoke().floatValue() > 0.0f) || (f > 0.0f && scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float f, float f2) {
        if (Math.signum(f) == Math.signum(f2)) {
            return Math.abs(f) < Math.abs(f2) ? f : f2;
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        SemanticsNode semanticsNode;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i));
        if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
            String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
            if (Intrinsics.areEqual((Object) str, (Object) this.ExtraDataTestTraversalBeforeVal)) {
                Integer num = this.idToBeforeMap.get(Integer.valueOf(i));
                if (num != null) {
                    accessibilityNodeInfo.getExtras().putInt(str, num.intValue());
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) this.ExtraDataTestTraversalAfterVal)) {
                Integer num2 = this.idToAfterMap.get(Integer.valueOf(i));
                if (num2 != null) {
                    accessibilityNodeInfo.getExtras().putInt(str, num2.intValue());
                }
            } else if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
                int i2 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
                int i3 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
                if (i3 > 0 && i2 >= 0) {
                    if (i2 < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                        TextLayoutResult textLayoutResult = getTextLayoutResult(semanticsNode.getUnmergedConfig$ui_release());
                        if (textLayoutResult != null) {
                            List arrayList = new ArrayList();
                            for (int i4 = 0; i4 < i3; i4++) {
                                int i5 = i2 + i4;
                                if (i5 >= textLayoutResult.getLayoutInput().getText().length()) {
                                    arrayList.add((Object) null);
                                } else {
                                    arrayList.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i5)));
                                }
                            }
                            accessibilityNodeInfo.getExtras().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                            return;
                        }
                        return;
                    }
                }
                Log.e(LogTag, "Invalid arguments for accessibility character locations");
            } else if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) ExtraDataTestTagKey)) {
                String str2 = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag());
                if (str2 != null) {
                    accessibilityNodeInfo.getExtras().putCharSequence(str, str2);
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) ExtraDataIdKey)) {
                accessibilityNodeInfo.getExtras().putInt(str, semanticsNode.getId());
            }
        }
    }

    private final RectF toScreenCoords(SemanticsNode semanticsNode, androidx.compose.ui.geometry.Rect rect) {
        if (semanticsNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect r6 = rect.m3599translatek4lQ0M(semanticsNode.m5872getPositionInRootF1C5BW0());
        androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
        androidx.compose.ui.geometry.Rect intersect = r6.overlaps(boundsInRoot) ? r6.intersect(boundsInRoot) : null;
        if (intersect == null) {
            return null;
        }
        long r0 = this.view.m5740localToScreenMKHz9U(OffsetKt.Offset(intersect.getLeft(), intersect.getTop()));
        long r5 = this.view.m5740localToScreenMKHz9U(OffsetKt.Offset(intersect.getRight(), intersect.getBottom()));
        return new RectF(Offset.m3562getXimpl(r0), Offset.m3563getYimpl(r0), Offset.m3562getXimpl(r5), Offset.m3563getYimpl(r5));
    }

    public final boolean dispatchHoverEvent$ui_release(MotionEvent motionEvent) {
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int hitTestSemanticsAt$ui_release = hitTestSemanticsAt$ui_release(motionEvent.getX(), motionEvent.getY());
            boolean dispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            updateHoveredVirtualView(hitTestSemanticsAt$ui_release);
            if (hitTestSemanticsAt$ui_release == Integer.MIN_VALUE) {
                return dispatchGenericMotionEvent;
            }
            return true;
        } else if (action != 10) {
            return false;
        } else {
            if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
                return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            }
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
    }

    public final int hitTestSemanticsAt$ui_release(float f, float f2) {
        NodeChain nodes$ui_release;
        LayoutNode layoutNode = null;
        Owner.CC.measureAndLayout$default(this.view, false, 1, (Object) null);
        HitTestResult hitTestResult = new HitTestResult();
        LayoutNode.m5504hitTestSemanticsM_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(f, f2), hitTestResult, false, false, 12, (Object) null);
        Modifier.Node node = (Modifier.Node) CollectionsKt.lastOrNull(hitTestResult);
        if (node != null) {
            layoutNode = DelegatableNodeKt.requireLayoutNode(node);
        }
        if (layoutNode == null || (nodes$ui_release = layoutNode.getNodes$ui_release()) == null || !nodes$ui_release.m5597hasH91voCI$ui_release(NodeKind.m5647constructorimpl(8)) || !AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(SemanticsNodeKt.SemanticsNode(layoutNode, false)) || this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNode) != null) {
            return Integer.MIN_VALUE;
        }
        return semanticsNodeIdToAccessibilityVirtualNodeId(layoutNode.getSemanticsId());
    }

    private final void updateHoveredVirtualView(int i) {
        int i2 = this.hoveredVirtualViewId;
        if (i2 != i) {
            this.hoveredVirtualViewId = i;
            sendEventForVirtualView$default(this, i, 128, (Integer) null, (List) null, 12, (Object) null);
            sendEventForVirtualView$default(this, i2, 256, (Integer) null, (List) null, 12, (Object) null);
        }
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view2) {
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T t, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("size should be greater than 0".toString());
        } else if (t == null || t.length() == 0 || t.length() <= i) {
            return t;
        } else {
            int i2 = i - 1;
            if (Character.isHighSurrogate(t.charAt(i2)) && Character.isLowSurrogate(t.charAt(i))) {
                i = i2;
            }
            T subSequence = t.subSequence(0, i);
            Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
            return subSequence;
        }
    }

    /* access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$46(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Owner.CC.measureAndLayout$default(androidComposeViewAccessibilityDelegateCompat.view, false, 1, (Object) null);
        androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
        androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074 A[Catch:{ all -> 0x0053 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x0043
            if (r2 != r4) goto L_0x003b
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r6 = r0.L$1
            androidx.collection.ArraySet r6 = (androidx.collection.ArraySet) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r7 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r7
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0053 }
        L_0x0039:
            r12 = r6
            goto L_0x0066
        L_0x003b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0043:
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r6 = r0.L$1
            androidx.collection.ArraySet r6 = (androidx.collection.ArraySet) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r7 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r7
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0053 }
            goto L_0x0078
        L_0x0053:
            r12 = move-exception
            goto L_0x00e6
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.collection.ArraySet r12 = new androidx.collection.ArraySet     // Catch:{ all -> 0x00e4 }
            r2 = 0
            r12.<init>(r3, r5, r2)     // Catch:{ all -> 0x00e4 }
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r2 = r11.boundsUpdateChannel     // Catch:{ all -> 0x00e4 }
            kotlinx.coroutines.channels.ChannelIterator r2 = r2.iterator()     // Catch:{ all -> 0x00e4 }
            r7 = r11
        L_0x0066:
            r0.L$0 = r7     // Catch:{ all -> 0x0053 }
            r0.L$1 = r12     // Catch:{ all -> 0x0053 }
            r0.L$2 = r2     // Catch:{ all -> 0x0053 }
            r0.label = r5     // Catch:{ all -> 0x0053 }
            java.lang.Object r6 = r2.hasNext(r0)     // Catch:{ all -> 0x0053 }
            if (r6 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r10 = r6
            r6 = r12
            r12 = r10
        L_0x0078:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x0053 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0053 }
            if (r12 == 0) goto L_0x00dc
            r2.next()     // Catch:{ all -> 0x0053 }
            boolean r12 = r7.isEnabledForContentCapture()     // Catch:{ all -> 0x0053 }
            if (r12 == 0) goto L_0x008c
            r7.notifyContentCaptureChanges()     // Catch:{ all -> 0x0053 }
        L_0x008c:
            boolean r12 = r7.isEnabledForAccessibility$ui_release()     // Catch:{ all -> 0x0053 }
            if (r12 == 0) goto L_0x00bc
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r12 = r7.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0053 }
            int r12 = r12.size()     // Catch:{ all -> 0x0053 }
            r8 = r3
        L_0x0099:
            if (r8 >= r12) goto L_0x00ac
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r9 = r7.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0053 }
            java.lang.Object r9 = r9.valueAt(r8)     // Catch:{ all -> 0x0053 }
            androidx.compose.ui.node.LayoutNode r9 = (androidx.compose.ui.node.LayoutNode) r9     // Catch:{ all -> 0x0053 }
            r7.sendSubtreeChangeAccessibilityEvents(r9, r6)     // Catch:{ all -> 0x0053 }
            r7.sendTypeViewScrolledAccessibilityEvent(r9)     // Catch:{ all -> 0x0053 }
            int r8 = r8 + 1
            goto L_0x0099
        L_0x00ac:
            r6.clear()     // Catch:{ all -> 0x0053 }
            boolean r12 = r7.checkingForSemanticsChanges     // Catch:{ all -> 0x0053 }
            if (r12 != 0) goto L_0x00bc
            r7.checkingForSemanticsChanges = r5     // Catch:{ all -> 0x0053 }
            android.os.Handler r12 = r7.handler     // Catch:{ all -> 0x0053 }
            java.lang.Runnable r8 = r7.semanticsChangeChecker     // Catch:{ all -> 0x0053 }
            r12.post(r8)     // Catch:{ all -> 0x0053 }
        L_0x00bc:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r12 = r7.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0053 }
            r12.clear()     // Catch:{ all -> 0x0053 }
            java.util.HashMap<java.lang.Integer, androidx.compose.ui.semantics.ScrollAxisRange> r12 = r7.pendingHorizontalScrollEvents     // Catch:{ all -> 0x0053 }
            r12.clear()     // Catch:{ all -> 0x0053 }
            java.util.HashMap<java.lang.Integer, androidx.compose.ui.semantics.ScrollAxisRange> r12 = r7.pendingVerticalScrollEvents     // Catch:{ all -> 0x0053 }
            r12.clear()     // Catch:{ all -> 0x0053 }
            r0.L$0 = r7     // Catch:{ all -> 0x0053 }
            r0.L$1 = r6     // Catch:{ all -> 0x0053 }
            r0.L$2 = r2     // Catch:{ all -> 0x0053 }
            r0.label = r4     // Catch:{ all -> 0x0053 }
            r8 = 100
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r8, r0)     // Catch:{ all -> 0x0053 }
            if (r12 != r1) goto L_0x0039
            return r1
        L_0x00dc:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r12 = r7.subtreeChangedLayoutNodes
            r12.clear()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00e4:
            r12 = move-exception
            r7 = r11
        L_0x00e6:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r0 = r7.subtreeChangedLayoutNodes
            r0.clear()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    /* access modifiers changed from: private */
    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.m8593trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int semanticsId = layoutNode.getSemanticsId();
            ScrollAxisRange scrollAxisRange = this.pendingHorizontalScrollEvents.get(Integer.valueOf(semanticsId));
            ScrollAxisRange scrollAxisRange2 = this.pendingVerticalScrollEvents.get(Integer.valueOf(semanticsId));
            if (scrollAxisRange != null || scrollAxisRange2 != null) {
                AccessibilityEvent createEvent = createEvent(semanticsId, 4096);
                if (scrollAxisRange != null) {
                    createEvent.setScrollX((int) scrollAxisRange.getValue().invoke().floatValue());
                    createEvent.setMaxScrollX((int) scrollAxisRange.getMaxValue().invoke().floatValue());
                }
                if (scrollAxisRange2 != null) {
                    createEvent.setScrollY((int) scrollAxisRange2.getValue().invoke().floatValue());
                    createEvent.setMaxScrollY((int) scrollAxisRange2.getMaxValue().invoke().floatValue());
                }
                sendEvent(createEvent);
            }
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, ArraySet<Integer> arraySet) {
        SemanticsConfiguration collapsedSemantics$ui_release;
        LayoutNode access$findClosestParentNode;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int size = this.subtreeChangedLayoutNodes.size();
            int i = 0;
            while (i < size) {
                if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isAncestorOf(this.subtreeChangedLayoutNodes.valueAt(i), layoutNode)) {
                    i++;
                } else {
                    return;
                }
            }
            if (!layoutNode.getNodes$ui_release().m5597hasH91voCI$ui_release(NodeKind.m5647constructorimpl(8))) {
                layoutNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.INSTANCE);
            }
            if (layoutNode != null && (collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release()) != null) {
                if (!collapsedSemantics$ui_release.isMergingSemanticsOfDescendants() && (access$findClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE)) != null) {
                    layoutNode = access$findClosestParentNode;
                }
                if (layoutNode != null) {
                    int semanticsId = layoutNode.getSemanticsId();
                    if (arraySet.add(Integer.valueOf(semanticsId))) {
                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsId), 2048, 1, (List) null, 8, (Object) null);
                    }
                }
            }
        }
    }

    private final void checkForSemanticsChanges() {
        if (isEnabledForAccessibility$ui_release()) {
            sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        }
        if (isEnabledForContentCapture()) {
            sendContentCaptureSemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        }
        sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
        updateSemanticsNodesCopyAndPanes();
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        SemanticsConfiguration unmergedConfig;
        ArraySet arraySet = new ArraySet(0, 1, (DefaultConstructorMarker) null);
        Iterator<Integer> it = this.paneDisplayed.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(intValue));
            SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
            if (semanticsNode == null || !AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(semanticsNode)) {
                arraySet.add(Integer.valueOf(intValue));
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(Integer.valueOf(intValue));
                sendPaneChangeEvents(intValue, 32, (semanticsNodeCopy == null || (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) == null) ? null : (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle()));
            }
        }
        this.paneDisplayed.removeAll(arraySet);
        this.previousSemanticsNodes.clear();
        for (Map.Entry next : getCurrentSemanticsNodes().entrySet()) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(((SemanticsNodeWithAdjustedBounds) next.getValue()).getSemanticsNode()) && this.paneDisplayed.add(next.getKey())) {
                sendPaneChangeEvents(((Number) next.getKey()).intValue(), 16, (String) ((SemanticsNodeWithAdjustedBounds) next.getValue()).getSemanticsNode().getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getPaneTitle()));
            }
            this.previousSemanticsNodes.put(next.getKey(), new SemanticsNodeCopy(((SemanticsNodeWithAdjustedBounds) next.getValue()).getSemanticsNode(), getCurrentSemanticsNodes()));
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:179:0x064c, code lost:
        if (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$accessibilityEquals((androidx.compose.ui.semantics.AccessibilityAction) r2, androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r11.getUnmergedConfig(), (androidx.compose.ui.semantics.SemanticsPropertyKey) r0.getKey())) == false) goto L_0x0620;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void sendSemanticsPropertyChangeEvents(java.util.Map<java.lang.Integer, androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r28) {
        /*
            r27 = this;
            r7 = r27
            java.util.ArrayList r8 = new java.util.ArrayList
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r0 = r7.scrollObservationScopes
            java.util.Collection r0 = (java.util.Collection) r0
            r8.<init>(r0)
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r0 = r7.scrollObservationScopes
            r0.clear()
            java.util.Set r0 = r28.keySet()
            java.util.Iterator r9 = r0.iterator()
        L_0x0018:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x0680
            java.lang.Object r0 = r9.next()
            java.lang.Number r0 = (java.lang.Number) r0
            int r10 = r0.intValue()
            java.util.Map<java.lang.Integer, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy> r0 = r7.previousSemanticsNodes
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            java.lang.Object r0 = r0.get(r1)
            r11 = r0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy r11 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy) r11
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
            r12 = r28
            java.lang.Object r0 = r12.get(r0)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r0 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r0
            if (r0 == 0) goto L_0x0049
            androidx.compose.ui.semantics.SemanticsNode r0 = r0.getSemanticsNode()
            r14 = r0
            goto L_0x004a
        L_0x0049:
            r14 = 0
        L_0x004a:
            if (r14 == 0) goto L_0x0674
            if (r11 != 0) goto L_0x0098
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            java.util.Iterator r0 = r0.iterator()
        L_0x0056:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0018
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getKey()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getText()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0056
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x008b
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)
            androidx.compose.ui.text.AnnotatedString r1 = (androidx.compose.ui.text.AnnotatedString) r1
            goto L_0x008c
        L_0x008b:
            r1 = 0
        L_0x008c:
            int r2 = r14.getId()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r7.sendContentCaptureTextUpdateEvent(r2, r1)
            goto L_0x0056
        L_0x0098:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            java.util.Iterator r15 = r0.iterator()
            r16 = 0
            r17 = r16
        L_0x00a4:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x064f
            java.lang.Object r0 = r15.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getHorizontalScrollAxisRange()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x00d4
            java.lang.Object r1 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getVerticalScrollAxisRange()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x00d1
            goto L_0x00d4
        L_0x00d1:
            r1 = r16
            goto L_0x00db
        L_0x00d4:
            r1 = r8
            java.util.List r1 = (java.util.List) r1
            boolean r1 = r7.registerScrollingId(r10, r1)
        L_0x00db:
            if (r1 != 0) goto L_0x00f9
            java.lang.Object r1 = r0.getValue()
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r11.getUnmergedConfig()
            java.lang.Object r3 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r3
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x00f9
        L_0x00f5:
            r20 = r8
            goto L_0x0622
        L_0x00f9:
            java.lang.Object r1 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r1
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getText()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0151
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig()
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getText()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0124
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            androidx.compose.ui.text.AnnotatedString r0 = (androidx.compose.ui.text.AnnotatedString) r0
            goto L_0x0125
        L_0x0124:
            r0 = 0
        L_0x0125:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x013e
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)
            androidx.compose.ui.text.AnnotatedString r1 = (androidx.compose.ui.text.AnnotatedString) r1
            goto L_0x013f
        L_0x013e:
            r1 = 0
        L_0x013f:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x00f5
            int r0 = r14.getId()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r7.sendContentCaptureTextUpdateEvent(r0, r1)
            goto L_0x00f5
        L_0x0151:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPaneTitle()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r3 = 8
            if (r2 == 0) goto L_0x0174
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = r11.hasPaneTitle()
            if (r1 == 0) goto L_0x00f5
            r7.sendPaneChangeEvents(r10, r3, r0)
            goto L_0x00f5
        L_0x0174:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getStateDescription()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r4 = 1
            if (r2 == 0) goto L_0x0183
            r2 = r4
            goto L_0x018d
        L_0x0183:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getToggleableState()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
        L_0x018d:
            r5 = 64
            if (r2 == 0) goto L_0x01b1
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x00f5
        L_0x01b1:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getProgressBarRangeInfo()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x01dd
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x00f5
        L_0x01dd:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getSelected()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r6 = 4
            if (r2 == 0) goto L_0x02d7
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getRole()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.Role r0 = (androidx.compose.ui.semantics.Role) r0
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m5870getTabo7Vup1c()
            if (r0 != 0) goto L_0x0205
            r0 = r16
            goto L_0x020d
        L_0x0205:
            int r0 = r0.m5863unboximpl()
            boolean r0 = androidx.compose.ui.semantics.Role.m5860equalsimpl0(r0, r1)
        L_0x020d:
            if (r0 == 0) goto L_0x02b7
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getSelected()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x02a2
            int r0 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            android.view.accessibility.AccessibilityEvent r0 = r7.createEvent(r0, r6)
            androidx.compose.ui.semantics.SemanticsNode r1 = r14.copyWithMergingEnabled$ui_release()
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r1.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r3 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getContentDescription()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            r18 = r2
            java.util.List r18 = (java.util.List) r18
            java.lang.String r2 = ","
            if (r18 == 0) goto L_0x0260
            r19 = r2
            java.lang.CharSequence r19 = (java.lang.CharSequence) r19
            r25 = 62
            r26 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            java.lang.String r3 = androidx.compose.ui.util.ListUtilsKt.fastJoinToString$default(r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0261
        L_0x0260:
            r3 = 0
        L_0x0261:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r1.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r4 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r4)
            r18 = r1
            java.util.List r18 = (java.util.List) r18
            if (r18 == 0) goto L_0x028c
            r19 = r2
            java.lang.CharSequence r19 = (java.lang.CharSequence) r19
            r25 = 62
            r26 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            java.lang.String r1 = androidx.compose.ui.util.ListUtilsKt.fastJoinToString$default(r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x028d
        L_0x028c:
            r1 = 0
        L_0x028d:
            if (r3 == 0) goto L_0x0294
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setContentDescription(r3)
        L_0x0294:
            if (r1 == 0) goto L_0x029d
            java.util.List r2 = r0.getText()
            r2.add(r1)
        L_0x029d:
            r7.sendEvent(r0)
            goto L_0x00f5
        L_0x02a2:
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x00f5
        L_0x02b7:
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x00f5
        L_0x02d7:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getContentDescription()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x02fd
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r3)
            java.util.List r0 = (java.util.List) r0
            r3 = 2048(0x800, float:2.87E-42)
            r7.sendEventForVirtualView(r1, r3, r2, r0)
            goto L_0x00f5
        L_0x02fd:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getEditableText()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r5 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r6 = ""
            if (r2 == 0) goto L_0x048c
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getSetText()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0474
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig()
            androidx.compose.ui.text.AnnotatedString r0 = r7.getTextForTextField(r0)
            if (r0 == 0) goto L_0x032b
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x032e
        L_0x032b:
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x032e:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.text.AnnotatedString r1 = r7.getTextForTextField(r1)
            if (r1 == 0) goto L_0x033b
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x033e
        L_0x033b:
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x033e:
            java.lang.CharSequence r5 = r7.trimToSize(r1, r5)
            int r2 = r0.length()
            int r3 = r1.length()
            int r6 = kotlin.ranges.RangesKt.coerceAtMost((int) r2, (int) r3)
            r13 = r16
        L_0x0350:
            if (r13 >= r6) goto L_0x0365
            char r4 = r0.charAt(r13)
            r20 = r8
            char r8 = r1.charAt(r13)
            if (r4 == r8) goto L_0x035f
            goto L_0x0367
        L_0x035f:
            int r13 = r13 + 1
            r8 = r20
            r4 = 1
            goto L_0x0350
        L_0x0365:
            r20 = r8
        L_0x0367:
            r4 = r16
        L_0x0369:
            int r8 = r6 - r13
            if (r4 >= r8) goto L_0x0386
            int r8 = r2 + -1
            int r8 = r8 - r4
            char r8 = r0.charAt(r8)
            int r21 = r3 + -1
            r22 = r6
            int r6 = r21 - r4
            char r6 = r1.charAt(r6)
            if (r8 == r6) goto L_0x0381
            goto L_0x0386
        L_0x0381:
            int r4 = r4 + 1
            r6 = r22
            goto L_0x0369
        L_0x0386:
            int r2 = r2 - r4
            int r2 = r2 - r13
            int r1 = r3 - r4
            int r1 = r1 - r13
            androidx.compose.ui.semantics.SemanticsNode r4 = r11.getSemanticsNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r6 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r6 = r6.getSetText()
            boolean r4 = r4.contains(r6)
            if (r4 == 0) goto L_0x03c5
            androidx.compose.ui.semantics.SemanticsNode r4 = r11.getSemanticsNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r4.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r6 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r6 = r6.getPassword()
            boolean r4 = r4.contains(r6)
            if (r4 != 0) goto L_0x03c5
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r14.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r6 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r6 = r6.getPassword()
            boolean r4 = r4.contains(r6)
            if (r4 == 0) goto L_0x03c5
            r6 = 1
            goto L_0x03c7
        L_0x03c5:
            r6 = r16
        L_0x03c7:
            androidx.compose.ui.semantics.SemanticsNode r4 = r11.getSemanticsNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r8 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r8 = r8.getSetText()
            boolean r4 = r4.contains(r8)
            if (r4 == 0) goto L_0x0402
            androidx.compose.ui.semantics.SemanticsNode r4 = r11.getSemanticsNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r4.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r8 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r8 = r8.getPassword()
            boolean r4 = r4.contains(r8)
            if (r4 == 0) goto L_0x0402
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r14.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r8 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r8 = r8.getPassword()
            boolean r4 = r4.contains(r8)
            if (r4 != 0) goto L_0x0402
            r19 = 1
            goto L_0x0404
        L_0x0402:
            r19 = r16
        L_0x0404:
            if (r6 != 0) goto L_0x0427
            if (r19 == 0) goto L_0x0409
            goto L_0x0427
        L_0x0409:
            int r3 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            r4 = 16
            android.view.accessibility.AccessibilityEvent r3 = r7.createEvent(r3, r4)
            r3.setFromIndex(r13)
            r3.setRemovedCount(r2)
            r3.setAddedCount(r1)
            r3.setBeforeText(r0)
            java.util.List r0 = r3.getText()
            r0.add(r5)
            goto L_0x043f
        L_0x0427:
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            r0 = r27
            r3 = r4
            r4 = r8
            android.view.accessibility.AccessibilityEvent r3 = r0.createTextSelectionChangedEvent(r1, r2, r3, r4, r5)
        L_0x043f:
            java.lang.String r0 = "android.widget.EditText"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.setClassName(r0)
            r7.sendEvent(r3)
            if (r6 != 0) goto L_0x044d
            if (r19 == 0) goto L_0x0622
        L_0x044d:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getTextSelectionRange()
            java.lang.Object r0 = r0.get(r1)
            androidx.compose.ui.text.TextRange r0 = (androidx.compose.ui.text.TextRange) r0
            long r0 = r0.m6046unboximpl()
            int r2 = androidx.compose.ui.text.TextRange.m6042getStartimpl(r0)
            r3.setFromIndex(r2)
            int r0 = androidx.compose.ui.text.TextRange.m6037getEndimpl(r0)
            r3.setToIndex(r0)
            r7.sendEvent(r3)
            goto L_0x0622
        L_0x0474:
            r20 = r8
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            r0 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0622
        L_0x048c:
            r20 = r8
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getTextSelectionRange()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x04f8
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.text.AnnotatedString r0 = r7.getTextForTextField(r0)
            if (r0 == 0) goto L_0x04ac
            java.lang.String r0 = r0.getText()
            if (r0 != 0) goto L_0x04ab
            goto L_0x04ac
        L_0x04ab:
            r6 = r0
        L_0x04ac:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getTextSelectionRange()
            java.lang.Object r0 = r0.get(r1)
            androidx.compose.ui.text.TextRange r0 = (androidx.compose.ui.text.TextRange) r0
            long r0 = r0.m6046unboximpl()
            int r2 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            int r3 = androidx.compose.ui.text.TextRange.m6042getStartimpl(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r0 = androidx.compose.ui.text.TextRange.m6037getEndimpl(r0)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            int r0 = r6.length()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.CharSequence r5 = r7.trimToSize(r6, r5)
            r0 = r27
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r8
            android.view.accessibility.AccessibilityEvent r0 = r0.createTextSelectionChangedEvent(r1, r2, r3, r4, r5)
            r7.sendEvent(r0)
            int r0 = r14.getId()
            r7.sendPendingTextTraversedAtGranularityEvent(r0)
            goto L_0x0622
        L_0x04f8:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getHorizontalScrollAxisRange()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0506
            r2 = 1
            goto L_0x0510
        L_0x0506:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getVerticalScrollAxisRange()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
        L_0x0510:
            if (r2 == 0) goto L_0x054d
            androidx.compose.ui.node.LayoutNode r0 = r14.getLayoutNode$ui_release()
            r7.notifySubtreeAccessibilityStateChangedIfNeeded(r0)
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r0 = r7.scrollObservationScopes
            androidx.compose.ui.platform.ScrollObservationScope r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(r0, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getHorizontalScrollAxisRange()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.ScrollAxisRange r1 = (androidx.compose.ui.semantics.ScrollAxisRange) r1
            r0.setHorizontalScrollAxisRange(r1)
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getVerticalScrollAxisRange()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.ScrollAxisRange r1 = (androidx.compose.ui.semantics.ScrollAxisRange) r1
            r0.setVerticalScrollAxisRange(r1)
            r7.scheduleScrollEventIfNeeded(r0)
            goto L_0x0622
        L_0x054d:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getFocused()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0592
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0579
            int r0 = r14.getId()
            int r0 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r0)
            android.view.accessibility.AccessibilityEvent r0 = r7.createEvent(r0, r3)
            r7.sendEvent(r0)
        L_0x0579:
            int r0 = r14.getId()
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0622
        L_0x0592:
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getCustomActions()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0626
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getCustomActions()
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r11.getUnmergedConfig()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getCustomActions()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0616
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet
            r2.<init>()
            java.util.Set r2 = (java.util.Set) r2
            int r3 = r0.size()
            r4 = r16
        L_0x05cd:
            if (r4 >= r3) goto L_0x05df
            java.lang.Object r5 = r0.get(r4)
            androidx.compose.ui.semantics.CustomAccessibilityAction r5 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r5
            java.lang.String r5 = r5.getLabel()
            r2.add(r5)
            int r4 = r4 + 1
            goto L_0x05cd
        L_0x05df:
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.util.Set r0 = (java.util.Set) r0
            int r3 = r1.size()
            r4 = r16
        L_0x05ec:
            if (r4 >= r3) goto L_0x05fe
            java.lang.Object r5 = r1.get(r4)
            androidx.compose.ui.semantics.CustomAccessibilityAction r5 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r5
            java.lang.String r5 = r5.getLabel()
            r0.add(r5)
            int r4 = r4 + 1
            goto L_0x05ec
        L_0x05fe:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r2.containsAll(r1)
            if (r1 == 0) goto L_0x0613
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r0 = r0.containsAll(r2)
            if (r0 != 0) goto L_0x0610
            goto L_0x0613
        L_0x0610:
            r17 = r16
            goto L_0x0622
        L_0x0613:
            r17 = 1
            goto L_0x0622
        L_0x0616:
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0622
        L_0x0620:
            r17 = r1
        L_0x0622:
            r8 = r20
            goto L_0x00a4
        L_0x0626:
            r1 = 1
            java.lang.Object r2 = r0.getValue()
            boolean r2 = r2 instanceof androidx.compose.ui.semantics.AccessibilityAction
            if (r2 == 0) goto L_0x0620
            java.lang.Object r2 = r0.getValue()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            androidx.compose.ui.semantics.AccessibilityAction r2 = (androidx.compose.ui.semantics.AccessibilityAction) r2
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r11.getUnmergedConfig()
            java.lang.Object r0 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r0 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r0
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r3, r0)
            boolean r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals(r2, r0)
            if (r0 != 0) goto L_0x0610
            goto L_0x0620
        L_0x064f:
            r20 = r8
            if (r17 != 0) goto L_0x065b
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r11.getUnmergedConfig()
            boolean r17 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(r14, r0)
        L_0x065b:
            if (r17 == 0) goto L_0x0670
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r5 = 8
            r6 = 0
            r2 = 2048(0x800, float:2.87E-42)
            r4 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x0670:
            r8 = r20
            goto L_0x0018
        L_0x0674:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "no value for specified key"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0680:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSemanticsPropertyChangeEvents(java.util.Map):void");
    }

    private final void sendContentCaptureTextUpdateEvent(int i, String str) {
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat != null && Build.VERSION.SDK_INT >= 29) {
            AutofillId newAutofillId = contentCaptureSessionCompat.newAutofillId((long) i);
            if (newAutofillId != null) {
                contentCaptureSessionCompat.notifyViewTextChanged(newAutofillId, str);
                return;
            }
            throw new IllegalStateException("Invalid content capture ID".toString());
        }
    }

    private final boolean registerScrollingId(int i, List<ScrollObservationScope> list) {
        boolean z;
        ScrollObservationScope access$findById = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(list, i);
        if (access$findById != null) {
            z = false;
        } else {
            access$findById = new ScrollObservationScope(i, this.scrollObservationScopes, (Float) null, (Float) null, (ScrollAxisRange) null, (ScrollAxisRange) null);
            z = true;
        }
        this.scrollObservationScopes.add(access$findById);
        return z;
    }

    /* access modifiers changed from: private */
    public final void scheduleScrollEventIfNeeded(ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValidOwnerScope()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.scheduleScrollEventIfNeededLambda, new AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1(scrollObservationScope, this));
        }
    }

    private final void sendPaneChangeEvents(int i, int i2, String str) {
        AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(i), 32);
        createEvent.setContentChangeTypes(i2);
        if (str != null) {
            createEvent.getText().add(str);
        }
        sendEvent(createEvent);
    }

    /* access modifiers changed from: private */
    public final ContentCaptureSessionCompat getContentCaptureSessionCompat(View view2) {
        ViewCompatShims.setImportantForContentCapture(view2, 1);
        return ViewCompatShims.getContentCaptureSession(view2);
    }

    private final TextLayoutResult getTextLayoutResult(SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        List arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getGetTextLayoutResult());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.getAction()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (TextLayoutResult) arrayList.get(0);
    }

    private final ViewStructureCompat toViewStructure(SemanticsNode semanticsNode) {
        AutofillIdCompat autofillId;
        AutofillId autofillId2;
        String r1;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat == null || Build.VERSION.SDK_INT < 29 || (autofillId = ViewCompatShims.getAutofillId(this.view)) == null) {
            return null;
        }
        SemanticsNode parent = semanticsNode.getParent();
        if (parent != null) {
            autofillId2 = contentCaptureSessionCompat.newAutofillId((long) parent.getId());
            if (autofillId2 == null) {
                return null;
            }
        } else {
            autofillId2 = autofillId.toAutofillId();
        }
        ViewStructureCompat newVirtualViewStructure = contentCaptureSessionCompat.newVirtualViewStructure(autofillId2, (long) semanticsNode.getId());
        if (newVirtualViewStructure == null) {
            return null;
        }
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        if (unmergedConfig$ui_release.contains(SemanticsProperties.INSTANCE.getPassword())) {
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getText());
        if (list != null) {
            newVirtualViewStructure.setClassName(TextClassName);
            newVirtualViewStructure.setText(ListUtilsKt.fastJoinToString$default(list, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getEditableText());
        if (annotatedString != null) {
            newVirtualViewStructure.setClassName(TextFieldClassName);
            newVirtualViewStructure.setText(annotatedString);
        }
        List list2 = (List) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getContentDescription());
        if (list2 != null) {
            newVirtualViewStructure.setContentDescription(ListUtilsKt.fastJoinToString$default(list2, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getRole());
        if (!(role == null || (r1 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.m5753toLegacyClassNameV4PA4sw(role.m5863unboximpl())) == null)) {
            newVirtualViewStructure.setClassName(r1);
        }
        TextLayoutResult textLayoutResult = getTextLayoutResult(unmergedConfig$ui_release);
        if (textLayoutResult != null) {
            TextLayoutInput layoutInput = textLayoutResult.getLayoutInput();
            newVirtualViewStructure.setTextStyle(TextUnit.m6811getValueimpl(layoutInput.getStyle().m6073getFontSizeXSAIIZE()) * layoutInput.getDensity().getDensity() * layoutInput.getDensity().getFontScale(), 0, 0, 0);
        }
        androidx.compose.ui.geometry.Rect boundsInParent$ui_release = semanticsNode.getBoundsInParent$ui_release();
        newVirtualViewStructure.setDimens((int) boundsInParent$ui_release.getLeft(), (int) boundsInParent$ui_release.getTop(), 0, 0, (int) boundsInParent$ui_release.getWidth(), (int) boundsInParent$ui_release.getHeight());
        return newVirtualViewStructure;
    }

    private final void bufferContentCaptureViewAppeared(int i, ViewStructureCompat viewStructureCompat) {
        if (viewStructureCompat != null) {
            if (this.bufferedContentCaptureDisappearedNodes.contains(Integer.valueOf(i))) {
                this.bufferedContentCaptureDisappearedNodes.remove(Integer.valueOf(i));
                return;
            }
            this.bufferedContentCaptureAppearedNodes.put(Integer.valueOf(i), viewStructureCompat);
        }
    }

    private final void bufferContentCaptureViewDisappeared(int i) {
        if (this.bufferedContentCaptureAppearedNodes.containsKey(Integer.valueOf(i))) {
            this.bufferedContentCaptureAppearedNodes.remove(Integer.valueOf(i));
        } else {
            this.bufferedContentCaptureDisappearedNodes.add(Integer.valueOf(i));
        }
    }

    private final void notifyContentCaptureChanges() {
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat != null && Build.VERSION.SDK_INT >= 29) {
            if (!this.bufferedContentCaptureAppearedNodes.isEmpty()) {
                List list = CollectionsKt.toList(this.bufferedContentCaptureAppearedNodes.values());
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(((ViewStructureCompat) list.get(i)).toViewStructure());
                }
                contentCaptureSessionCompat.notifyViewsAppeared(arrayList);
                this.bufferedContentCaptureAppearedNodes.clear();
            }
            if (!this.bufferedContentCaptureDisappearedNodes.isEmpty()) {
                List list2 = CollectionsKt.toList(this.bufferedContentCaptureDisappearedNodes);
                ArrayList arrayList2 = new ArrayList(list2.size());
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    arrayList2.add(Long.valueOf((long) ((Number) list2.get(i2)).intValue()));
                }
                contentCaptureSessionCompat.notifyViewsDisappeared(CollectionsKt.toLongArray(arrayList2));
                this.bufferedContentCaptureDisappearedNodes.clear();
            }
        }
    }

    private final void updateContentCaptureBuffersOnAppeared(SemanticsNode semanticsNode) {
        if (isEnabledForContentCapture()) {
            updateTranslationOnAppeared(semanticsNode);
            bufferContentCaptureViewAppeared(semanticsNode.getId(), toViewStructure(semanticsNode));
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i = 0; i < size; i++) {
                updateContentCaptureBuffersOnAppeared(replacedChildren$ui_release.get(i));
            }
        }
    }

    private final void updateContentCaptureBuffersOnDisappeared(SemanticsNode semanticsNode) {
        if (isEnabledForContentCapture()) {
            bufferContentCaptureViewDisappeared(semanticsNode.getId());
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i = 0; i < size; i++) {
                updateContentCaptureBuffersOnDisappeared(replacedChildren$ui_release.get(i));
            }
        }
    }

    private final void updateTranslationOnAppeared(SemanticsNode semanticsNode) {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        Function1 function12;
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution());
        if (this.translateStatus == TranslateStatus.SHOW_ORIGINAL && Intrinsics.areEqual((Object) bool, (Object) true)) {
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution());
            if (accessibilityAction2 != null && (function12 = (Function1) accessibilityAction2.getAction()) != null) {
                Boolean bool2 = (Boolean) function12.invoke(false);
            }
        } else if (this.translateStatus == TranslateStatus.SHOW_TRANSLATED && Intrinsics.areEqual((Object) bool, (Object) false) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
            Boolean bool3 = (Boolean) function1.invoke(true);
        }
    }

    public final void onShowTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_TRANSLATED;
        showTranslatedText();
    }

    public final void onHideTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        hideTranslatedText();
    }

    public final void onClearTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        clearTranslatedText();
    }

    private final void showTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        for (SemanticsNodeWithAdjustedBounds semanticsNode : getCurrentSemanticsNodes().values()) {
            SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getSemanticsNode().getUnmergedConfig$ui_release();
            if (!(!Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), (Object) false) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) == null || (function1 = (Function1) accessibilityAction.getAction()) == null)) {
                Boolean bool = (Boolean) function1.invoke(true);
            }
        }
    }

    private final void hideTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        for (SemanticsNodeWithAdjustedBounds semanticsNode : getCurrentSemanticsNodes().values()) {
            SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getSemanticsNode().getUnmergedConfig$ui_release();
            if (!(!Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), (Object) true) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) == null || (function1 = (Function1) accessibilityAction.getAction()) == null)) {
                Boolean bool = (Boolean) function1.invoke(false);
            }
        }
    }

    private final void clearTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function0 function0;
        for (SemanticsNodeWithAdjustedBounds semanticsNode : getCurrentSemanticsNodes().values()) {
            SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getSemanticsNode().getUnmergedConfig$ui_release();
            if (!(SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()) == null || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getClearTextSubstitution())) == null || (function0 = (Function0) accessibilityAction.getAction()) == null)) {
                Boolean bool = (Boolean) function0.invoke();
            }
        }
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        Set linkedHashSet = new LinkedHashSet();
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                if (!semanticsNodeCopy.getChildren().contains(Integer.valueOf(semanticsNode2.getId()))) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                    return;
                }
                linkedHashSet.add(Integer.valueOf(semanticsNode2.getId()));
            }
        }
        for (Integer intValue : semanticsNodeCopy.getChildren()) {
            if (!linkedHashSet.contains(Integer.valueOf(intValue.intValue()))) {
                notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                return;
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            SemanticsNode semanticsNode3 = replacedChildren$ui_release2.get(i2);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode3.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy2 = this.previousSemanticsNodes.get(Integer.valueOf(semanticsNode3.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy2);
                sendAccessibilitySemanticsStructureChangeEvents(semanticsNode3, semanticsNodeCopy2);
            }
        }
    }

    private final void initContentCapture(boolean z) {
        if (z) {
            updateContentCaptureBuffersOnAppeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        } else {
            updateContentCaptureBuffersOnDisappeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        }
        notifyContentCaptureChanges();
    }

    private final void sendContentCaptureSemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode2.getId())) && !semanticsNodeCopy.getChildren().contains(Integer.valueOf(semanticsNode2.getId()))) {
                updateContentCaptureBuffersOnAppeared(semanticsNode2);
            }
        }
        for (Map.Entry next : this.previousSemanticsNodes.entrySet()) {
            if (!getCurrentSemanticsNodes().containsKey(next.getKey())) {
                bufferContentCaptureViewDisappeared(((Number) next.getKey()).intValue());
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            SemanticsNode semanticsNode3 = replacedChildren$ui_release2.get(i2);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode3.getId())) && this.previousSemanticsNodes.containsKey(Integer.valueOf(semanticsNode3.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy2 = this.previousSemanticsNodes.get(Integer.valueOf(semanticsNode3.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy2);
                sendContentCaptureSemanticsStructureChangeEvents(semanticsNode3, semanticsNodeCopy2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int i) {
        if (i == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return i;
    }

    private final boolean traverseAtGranularity(SemanticsNode semanticsNode, int i, boolean z, boolean z2) {
        AccessibilityIterators.TextSegmentIterator iteratorForGranularity;
        int i2;
        int i3;
        int id = semanticsNode.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(semanticsNode.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        CharSequence charSequence = iterableTextForAccessibility;
        if (charSequence == null || charSequence.length() == 0 || (iteratorForGranularity = getIteratorForGranularity(semanticsNode, i)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd(semanticsNode);
        if (accessibilitySelectionEnd == -1) {
            accessibilitySelectionEnd = z ? 0 : iterableTextForAccessibility.length();
        }
        int[] following = z ? iteratorForGranularity.following(accessibilitySelectionEnd) : iteratorForGranularity.preceding(accessibilitySelectionEnd);
        if (following == null) {
            return false;
        }
        int i4 = following[0];
        int i5 = following[1];
        if (!z2 || !isAccessibilitySelectionExtendable(semanticsNode)) {
            i3 = z ? i5 : i4;
            i2 = i3;
        } else {
            i3 = getAccessibilitySelectionStart(semanticsNode);
            if (i3 == -1) {
                i3 = z ? i4 : i5;
            }
            i2 = z ? i5 : i4;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(semanticsNode, z ? 256 : 512, i, i4, i5, SystemClock.uptimeMillis());
        SemanticsNode semanticsNode2 = semanticsNode;
        setAccessibilitySelection(semanticsNode, i3, i2, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int i) {
        PendingTextTraversedEvent pendingTextTraversedEvent2 = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent2 != null) {
            if (i == pendingTextTraversedEvent2.getNode().getId()) {
                if (SystemClock.uptimeMillis() - pendingTextTraversedEvent2.getTraverseTime() <= 1000) {
                    AccessibilityEvent createEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent2.getNode().getId()), 131072);
                    createEvent.setFromIndex(pendingTextTraversedEvent2.getFromIndex());
                    createEvent.setToIndex(pendingTextTraversedEvent2.getToIndex());
                    createEvent.setAction(pendingTextTraversedEvent2.getAction());
                    createEvent.setMovementGranularity(pendingTextTraversedEvent2.getGranularity());
                    createEvent.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent2.getNode()));
                    sendEvent(createEvent);
                }
            } else {
                return;
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode semanticsNode, int i, int i2, boolean z) {
        String iterableTextForAccessibility;
        boolean z2 = false;
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            Function3 function3 = (Function3) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
            }
            return false;
        } else if ((i == i2 && i2 == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode)) == null) {
            return false;
        } else {
            if (i < 0 || i != i2 || i2 > iterableTextForAccessibility.length()) {
                i = -1;
            }
            this.accessibilityCursorPosition = i;
            CharSequence charSequence = iterableTextForAccessibility;
            if (charSequence.length() > 0) {
                z2 = true;
            }
            int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId());
            Integer num = null;
            Integer valueOf = z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null;
            Integer valueOf2 = z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null;
            if (z2) {
                num = Integer.valueOf(iterableTextForAccessibility.length());
            }
            sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId, valueOf, valueOf2, num, charSequence));
            sendPendingTextTraversedAtGranularityEvent(semanticsNode.getId());
            return true;
        }
    }

    private final int getAccessibilitySelectionStart(SemanticsNode semanticsNode) {
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m6042getStartimpl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m6046unboximpl());
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode semanticsNode) {
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m6037getEndimpl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m6046unboximpl());
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode semanticsNode) {
        return !semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode semanticsNode, int i) {
        AccessibilityIterators.AbstractTextSegmentIterator abstractTextSegmentIterator;
        TextLayoutResult textLayoutResult;
        if (semanticsNode == null) {
            return null;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        CharSequence charSequence = iterableTextForAccessibility;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        if (i == 1) {
            abstractTextSegmentIterator = AccessibilityIterators.CharacterTextSegmentIterator.Companion.getInstance(this.view.getContext().getResources().getConfiguration().locale);
            abstractTextSegmentIterator.initialize(iterableTextForAccessibility);
        } else if (i != 2) {
            if (i != 4) {
                if (i == 8) {
                    abstractTextSegmentIterator = AccessibilityIterators.ParagraphTextSegmentIterator.Companion.getInstance();
                    abstractTextSegmentIterator.initialize(iterableTextForAccessibility);
                } else if (i != 16) {
                    return null;
                }
            }
            if (!semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) || (textLayoutResult = getTextLayoutResult(semanticsNode.getUnmergedConfig$ui_release())) == null) {
                return null;
            }
            if (i == 4) {
                abstractTextSegmentIterator = AccessibilityIterators.LineTextSegmentIterator.Companion.getInstance();
                ((AccessibilityIterators.LineTextSegmentIterator) abstractTextSegmentIterator).initialize(iterableTextForAccessibility, textLayoutResult);
            } else {
                AccessibilityIterators.AbstractTextSegmentIterator instance = AccessibilityIterators.PageTextSegmentIterator.Companion.getInstance();
                ((AccessibilityIterators.PageTextSegmentIterator) instance).initialize(iterableTextForAccessibility, textLayoutResult, semanticsNode);
                abstractTextSegmentIterator = instance;
            }
        } else {
            abstractTextSegmentIterator = AccessibilityIterators.WordTextSegmentIterator.Companion.getInstance(this.view.getContext().getResources().getConfiguration().locale);
            abstractTextSegmentIterator.initialize(iterableTextForAccessibility);
        }
        return abstractTextSegmentIterator;
    }

    private final String getIterableTextForAccessibility(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default((List) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetText())) {
            AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroid/view/accessibility/AccessibilityNodeProvider;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "findFocus", "focus", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProvider {
        public ComposeAccessibilityNodeProvider() {
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            AccessibilityNodeInfo access$createNodeInfo = AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(i);
            if (AndroidComposeViewAccessibilityDelegateCompat.this.sendingFocusAffectingEvent && i == AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId) {
                AndroidComposeViewAccessibilityDelegateCompat.this.currentlyFocusedANI = access$createNodeInfo;
            }
            return access$createNodeInfo;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(i, i2, bundle);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(i, accessibilityNodeInfo, str, bundle);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            AccessibilityAction accessibilityAction;
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress())) != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908349, accessibilityAction.getLabel()));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageUp());
                if (accessibilityAction != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, accessibilityAction.getLabel()));
                }
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageDown());
                if (accessibilityAction2 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, accessibilityAction2.getLabel()));
                }
                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageLeft());
                if (accessibilityAction3 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908360, accessibilityAction3.getLabel()));
                }
                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPageRight());
                if (accessibilityAction4 != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908361, accessibilityAction4.getLabel()));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0002J0\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0007J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ViewTranslationHelperMethodsS;", "", "()V", "doTranslation", "", "accessibilityDelegateCompat", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class ViewTranslationHelperMethodsS {
        public static final ViewTranslationHelperMethodsS INSTANCE = new ViewTranslationHelperMethodsS();

        private ViewTranslationHelperMethodsS() {
        }

        public final void onVirtualViewTranslationResponses(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, LongSparseArray<ViewTranslationResponse> longSparseArray) {
            if (Build.VERSION.SDK_INT >= 31) {
                if (Intrinsics.areEqual((Object) Looper.getMainLooper().getThread(), (Object) Thread.currentThread())) {
                    doTranslation(androidComposeViewAccessibilityDelegateCompat, longSparseArray);
                } else {
                    androidComposeViewAccessibilityDelegateCompat.getView().post(new AndroidComposeViewAccessibilityDelegateCompat$ViewTranslationHelperMethodsS$$ExternalSyntheticLambda10(androidComposeViewAccessibilityDelegateCompat, longSparseArray));
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void onVirtualViewTranslationResponses$lambda$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, LongSparseArray longSparseArray) {
            INSTANCE.doTranslation(androidComposeViewAccessibilityDelegateCompat, longSparseArray);
        }

        private final void doTranslation(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, LongSparseArray<ViewTranslationResponse> longSparseArray) {
            TranslationResponseValue m;
            CharSequence m2;
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
            SemanticsNode semanticsNode;
            AccessibilityAction accessibilityAction;
            Function1 function1;
            LongIterator keyIterator = LongSparseArrayKt.keyIterator(longSparseArray);
            while (keyIterator.hasNext()) {
                long nextLong = keyIterator.nextLong();
                ViewTranslationResponse m3 = RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m((Object) longSparseArray.get(nextLong));
                if (!(m3 == null || (m = m3.getValue("android:text")) == null || (m2 = m.getText()) == null || (semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(Integer.valueOf((int) nextLong))) == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetTextSubstitution())) == null || (function1 = (Function1) accessibilityAction.getAction()) == null)) {
                    Boolean bool = (Boolean) function1.invoke(new AnnotatedString(m2.toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null));
                }
            }
        }

        public final void onCreateVirtualViewTranslationRequests(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
            SemanticsNode semanticsNode;
            for (long j : jArr) {
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(Integer.valueOf((int) j));
                if (!(semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null)) {
                    RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m();
                    ViewTranslationRequest.Builder m = RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(androidComposeViewAccessibilityDelegateCompat.getView().getAutofillId(), (long) semanticsNode.getId());
                    String access$getTextForTranslation = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getTextForTranslation(semanticsNode);
                    if (access$getTextForTranslation != null) {
                        ViewTranslationRequest.Builder unused = m.setValue("android:text", TranslationRequestValue.forText(new AnnotatedString(access$getTextForTranslation, (List) null, (List) null, 6, (DefaultConstructorMarker) null)));
                        consumer.accept(m.build());
                    }
                }
            }
        }
    }

    public final void onCreateVirtualViewTranslationRequests$ui_release(long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
        ViewTranslationHelperMethodsS.INSTANCE.onCreateVirtualViewTranslationRequests(this, jArr, iArr, consumer);
    }

    public final void onVirtualViewTranslationResponses$ui_release(LongSparseArray<ViewTranslationResponse> longSparseArray) {
        ViewTranslationHelperMethodsS.INSTANCE.onVirtualViewTranslationResponses(this, longSparseArray);
    }

    private final void geometryDepthFirstSearch(SemanticsNode semanticsNode, ArrayList<SemanticsNode> arrayList, Map<Integer, List<SemanticsNode>> map) {
        boolean z = semanticsNode.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl;
        boolean booleanValue = ((Boolean) semanticsNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getIsTraversalGroup(), AndroidComposeViewAccessibilityDelegateCompat_androidKt$isTraversalGroup$1.INSTANCE)).booleanValue();
        if ((booleanValue || isScreenReaderFocusable(semanticsNode)) && getCurrentSemanticsNodes().keySet().contains(Integer.valueOf(semanticsNode.getId()))) {
            arrayList.add(semanticsNode);
        }
        if (booleanValue) {
            map.put(Integer.valueOf(semanticsNode.getId()), subtreeSortedByGeometryGrouping(z, CollectionsKt.toMutableList(semanticsNode.getChildren())));
            return;
        }
        List<SemanticsNode> children = semanticsNode.getChildren();
        int size = children.size();
        for (int i = 0; i < size; i++) {
            geometryDepthFirstSearch(children.get(i), arrayList, map);
        }
    }
}
