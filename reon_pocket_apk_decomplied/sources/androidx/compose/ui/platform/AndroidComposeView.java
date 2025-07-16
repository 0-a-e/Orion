package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationCallback;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusTransactionManager;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000Ê\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f*\u0002­\u0001\b\u0000\u0018\u0000 Ê\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0006É\u0003Ê\u0003Ë\u0003B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010\u0002\u001a\u0002062\b\u0010ç\u0001\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030°\u0001J&\u0010\u0002\u001a\u0002062\u0007\u0010\u0002\u001a\u00020>2\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u0002H\u0002J\u0019\u0010#\u001a\u0002062\u000f\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020\u0002H\u0016J\t\u0010\u0002\u001a\u00020aH\u0002J\u0010\u0010\u0002\u001a\u000206H@¢\u0006\u0003\u0010\u0002J\u001e\u0010\u0002\u001a\u00020z2\u0007\u0010\u0002\u001a\u00020zH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\u001e\u0010\u0002\u001a\u00020z2\u0007\u0010\u0002\u001a\u00020zH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\u0012\u0010\u0002\u001a\u00020a2\u0007\u0010\u0002\u001a\u00020>H\u0016J\u0012\u0010\u0002\u001a\u00020a2\u0007\u0010\u0002\u001a\u00020>H\u0016J\u0012\u0010\u0002\u001a\u0002062\u0007\u0010\u0002\u001a\u00020\u0001H\u0002J\"\u0010\u0002\u001a\u00030\u00022\u0007\u0010\u0002\u001a\u00020>H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J.\u0010 \u0002\u001a\u00020E2\u0014\u0010¡\u0002\u001a\u000f\u0012\u0005\u0012\u00030¢\u0002\u0012\u0004\u0012\u000206042\r\u0010£\u0002\u001a\b\u0012\u0004\u0012\u0002060NH\u0016J\u0013\u0010¤\u0002\u001a\u0002062\b\u0010¥\u0002\u001a\u00030¦\u0002H\u0014J\u0013\u0010§\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0016J\u0013\u0010©\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0016J\u0013\u0010ª\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030«\u0002H\u0016J\u0013\u0010¬\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030«\u0002H\u0016J\u0013\u0010­\u0002\u001a\u00020a2\b\u0010®\u0002\u001a\u00030©\u0001H\u0016J\u001b\u0010¯\u0002\u001a\u0002062\b\u0010ç\u0001\u001a\u00030\u00022\b\u0010¥\u0002\u001a\u00030¦\u0002J\u001f\u0010°\u0002\u001a\u0005\u0018\u00010è\u00012\u0007\u0010±\u0002\u001a\u00020>2\b\u0010²\u0002\u001a\u00030è\u0001H\u0002J\u0013\u0010³\u0002\u001a\u0005\u0018\u00010è\u00012\u0007\u0010±\u0002\u001a\u00020>J\u001c\u0010´\u0002\u001a\u0002062\b\u0010\u0002\u001a\u00030°\u00012\u0007\u0010µ\u0002\u001a\u00020aH\u0016J\"\u0010¶\u0002\u001a\u0005\u0018\u00010·\u00022\b\u0010¸\u0002\u001a\u00030¹\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\bº\u0002\u0010»\u0002J\u0013\u0010¼\u0002\u001a\u0002062\b\u0010½\u0002\u001a\u00030¾\u0002H\u0016J#\u0010¿\u0002\u001a\u00030À\u00022\b\u0010®\u0002\u001a\u00030©\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÁ\u0002\u0010Â\u0002J\u0013\u0010Ã\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0002J\u001d\u0010Ä\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u00012\b\u0010Å\u0002\u001a\u00030©\u0001H\u0002J\t\u0010Æ\u0002\u001a\u000206H\u0016J\u0013\u0010Ç\u0002\u001a\u0002062\b\u0010È\u0002\u001a\u00030°\u0001H\u0002J\u0013\u0010É\u0002\u001a\u0002062\b\u0010È\u0002\u001a\u00030°\u0001H\u0002J\u0013\u0010Ê\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0002J\u0013\u0010Ë\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0002J\u0013\u0010Ì\u0002\u001a\u00020a2\b\u0010®\u0002\u001a\u00030©\u0001H\u0002J\u0013\u0010Í\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0002J\u001e\u0010Î\u0002\u001a\u00020z2\u0007\u0010\u0002\u001a\u00020zH\u0016ø\u0001\u0000¢\u0006\u0006\bÏ\u0002\u0010\u0002J\u001f\u0010Î\u0002\u001a\u0002062\b\u0010Ð\u0002\u001a\u00030á\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÑ\u0002\u0010Ò\u0002J)\u0010Ó\u0002\u001a\u0002062\b\u0010\u0002\u001a\u00030°\u00012\b\u0010Ô\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÕ\u0002\u0010Ö\u0002J\u0012\u0010Ó\u0002\u001a\u0002062\u0007\u0010×\u0002\u001a\u00020aH\u0016J\t\u0010Ø\u0002\u001a\u000206H\u0016J!\u0010Ù\u0002\u001a\u0002062\u0007\u0010Ú\u0002\u001a\u00020E2\u0007\u0010Û\u0002\u001a\u00020aH\u0000¢\u0006\u0003\bÜ\u0002J\u0013\u0010Ý\u0002\u001a\u0002062\b\u0010È\u0002\u001a\u00030°\u0001H\u0016J\t\u0010Þ\u0002\u001a\u000206H\u0014J\t\u0010ß\u0002\u001a\u00020aH\u0016J\u0012\u0010à\u0002\u001a\u0002062\u0007\u0010á\u0002\u001a\u000205H\u0014J\u0016\u0010â\u0002\u001a\u0005\u0018\u00010ã\u00022\b\u0010ä\u0002\u001a\u00030å\u0002H\u0016J0\u0010æ\u0002\u001a\u0002062\b\u0010ç\u0002\u001a\u00030è\u00022\b\u0010é\u0002\u001a\u00030ä\u00012\u0011\u0010ê\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010ì\u00020ë\u0002H\u0017J\u0013\u0010í\u0002\u001a\u0002062\b\u0010È\u0002\u001a\u00030°\u0001H\u0016J\t\u0010î\u0002\u001a\u000206H\u0014J\u0013\u0010ï\u0002\u001a\u0002062\b\u0010¥\u0002\u001a\u00030¦\u0002H\u0014J\t\u0010ð\u0002\u001a\u000206H\u0016J'\u0010ñ\u0002\u001a\u0002062\u0007\u0010ò\u0002\u001a\u00020a2\u0007\u0010\u0002\u001a\u00020>2\n\u0010ó\u0002\u001a\u0005\u0018\u00010¾\u0002H\u0014J6\u0010ô\u0002\u001a\u0002062\u0007\u0010õ\u0002\u001a\u00020a2\u0007\u0010ö\u0002\u001a\u00020>2\u0007\u0010÷\u0002\u001a\u00020>2\u0007\u0010ø\u0002\u001a\u00020>2\u0007\u0010ù\u0002\u001a\u00020>H\u0014J\u0013\u0010ú\u0002\u001a\u0002062\b\u0010\u0002\u001a\u00030°\u0001H\u0016J\u001b\u0010û\u0002\u001a\u0002062\u0007\u0010ü\u0002\u001a\u00020>2\u0007\u0010ý\u0002\u001a\u00020>H\u0014J\u001e\u0010þ\u0002\u001a\u0002062\n\u0010ÿ\u0002\u001a\u0005\u0018\u00010\u00032\u0007\u0010\u0003\u001a\u00020>H\u0016J.\u0010\u0003\u001a\u0002062\b\u0010\u0002\u001a\u00030°\u00012\u0007\u0010µ\u0002\u001a\u00020a2\u0007\u0010\u0003\u001a\u00020a2\u0007\u0010\u0003\u001a\u00020aH\u0016J%\u0010\u0003\u001a\u0002062\b\u0010\u0002\u001a\u00030°\u00012\u0007\u0010µ\u0002\u001a\u00020a2\u0007\u0010\u0003\u001a\u00020aH\u0016J\u0013\u0010\u0003\u001a\u0002062\b\u0010\u0003\u001a\u00030\u0003H\u0016J\u0012\u0010\u0003\u001a\u0002062\u0007\u0010\u0001\u001a\u00020>H\u0016J\t\u0010\u0003\u001a\u000206H\u0016J\u001c\u0010\u0003\u001a\u0002062\u0011\u0010\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u00030\u0003H\u0017J\u0012\u0010\u0003\u001a\u0002062\u0007\u0010\u0003\u001a\u00020aH\u0016J+\u0010\u0003\u001a\u00030\u00022\u0007\u0010\u0003\u001a\u00020>2\u0007\u0010ù\u0002\u001a\u00020>H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0003\u0010\u0003J\t\u0010\u0003\u001a\u000206H\u0002J\u0013\u0010\u0003\u001a\u0002062\b\u0010®\u0002\u001a\u00030©\u0001H\u0002J\t\u0010\u0003\u001a\u000206H\u0002J\u0018\u0010\u0003\u001a\u00020a2\u0007\u0010Ú\u0002\u001a\u00020EH\u0000¢\u0006\u0003\b\u0003J\u0018\u0010\u0003\u001a\u0002062\r\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002060NH\u0016J\u0013\u0010\u0003\u001a\u0002062\b\u0010\u0003\u001a\u00030\u0003H\u0016J\u0011\u0010\u0003\u001a\u0002062\b\u0010ç\u0001\u001a\u00030\u0002J\u0007\u0010\u0003\u001a\u000206J\u0013\u0010\u0003\u001a\u0002062\b\u0010\u0002\u001a\u00030°\u0001H\u0016J\u0017\u0010\u0003\u001a\u0002062\f\b\u0002\u0010 \u0003\u001a\u0005\u0018\u00010°\u0001H\u0002J\u001e\u0010¡\u0003\u001a\u00020z2\u0007\u0010¢\u0003\u001a\u00020zH\u0016ø\u0001\u0000¢\u0006\u0006\b£\u0003\u0010\u0002J\u001f\u0010¤\u0003\u001a\u00020a2\b\u0010¸\u0002\u001a\u00030¹\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b¥\u0003\u0010¦\u0003J#\u0010§\u0003\u001a\u00030À\u00022\b\u0010®\u0002\u001a\u00030©\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¨\u0003\u0010Â\u0002J0\u0010©\u0003\u001a\u0002062\b\u0010®\u0002\u001a\u00030©\u00012\u0007\u0010ª\u0003\u001a\u00020>2\u0007\u0010«\u0003\u001a\u00020|2\t\b\u0002\u0010¬\u0003\u001a\u00020aH\u0002J\u001c\u0010­\u0003\u001a\u0002062\u0013\u0010®\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020604J\t\u0010¯\u0003\u001a\u00020aH\u0016JE\u0010°\u0003\u001a\u00020a2\b\u0010±\u0003\u001a\u00030²\u00032\b\u0010³\u0003\u001a\u00030´\u00032\u001a\u0010µ\u0003\u001a\u0015\u0012\u0005\u0012\u00030¶\u0003\u0012\u0004\u0012\u00020604¢\u0006\u0003\b·\u0003H\u0002ø\u0001\u0000¢\u0006\u0006\b¸\u0003\u0010¹\u0003JA\u0010º\u0003\u001a\u00030»\u00032.\u0010¼\u0003\u001a)\b\u0001\u0012\u0005\u0012\u00030¾\u0003\u0012\f\u0012\n\u0012\u0005\u0012\u00030»\u00030¿\u0003\u0012\u0007\u0012\u0005\u0018\u00010À\u00030½\u0003¢\u0006\u0003\b·\u0003H@¢\u0006\u0003\u0010Á\u0003J\t\u0010Â\u0003\u001a\u000206H\u0002J\u000e\u0010Ã\u0003\u001a\u00020a*\u00030°\u0001H\u0002J\u001b\u0010Ä\u0003\u001a\u00020>*\u00030\u0002H\nø\u0001\u0000¢\u0006\u0006\bÅ\u0003\u0010Æ\u0003J\u001b\u0010Ç\u0003\u001a\u00020>*\u00030\u0002H\nø\u0001\u0000¢\u0006\u0006\bÈ\u0003\u0010Æ\u0003R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128B@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\f8@X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R&\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020604X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020?2\u0006\u0010\u0011\u001a\u00020?@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u00020GX\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010N0MX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\u00020PX\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR+\u0010T\u001a\u00020S2\u0006\u0010\u0011\u001a\u00020S8V@RX\u0002¢\u0006\u0012\n\u0004\bY\u0010\u0019\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Z\u001a\u00020[8\u0016X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u000e\u0010`\u001a\u00020aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010d\u001a\u00020eX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010fR\u0014\u0010g\u001a\u00020hX\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020a8VX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u000e\u0010n\u001a\u00020aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010o\u001a\u00020p8VX\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u000e\u0010s\u001a\u00020aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010t\u001a\u00020a8VX\u0004¢\u0006\u0006\u001a\u0004\bt\u0010mR\u000e\u0010u\u001a\u00020aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020wX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020aX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010y\u001a\u00020zX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010fR&\u0010{\u001a\u00020|8\u0000@\u0000X\u000e¢\u0006\u0016\n\u0000\u0012\u0004\b}\u0010]\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020E0\u0001X\u0004¢\u0006\u0002\n\u0000R3\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0011\u001a\u00030\u00018V@RX\u0002¢\u0006\u0017\n\u0005\b\u0001\u0010\u0019\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\u00020|8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020aX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000206\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0001\u001a\u00030\u00018VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010 \u0001R\u0018\u0010¡\u0001\u001a\u00030¢\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001R\u0010\u0010¥\u0001\u001a\u00030¦\u0001X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020|X\u000e¢\u0006\u0002\n\u0000R\u0015\u0010«\u0001\u001a\b\u0012\u0004\u0012\u0002060NX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010¬\u0001\u001a\u00030­\u0001X\u0004¢\u0006\u0005\n\u0003\u0010®\u0001R\u0018\u0010¯\u0001\u001a\u00030°\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b±\u0001\u0010²\u0001R\u0018\u0010³\u0001\u001a\u00030´\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001R\u000f\u0010·\u0001\u001a\u00020wX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¸\u0001\u001a\u00030¹\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010º\u0001\u001a\u00030»\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010¼\u0001\u001a\u00030½\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0010\u0010À\u0001\u001a\u00030Á\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Â\u0001\u001a\u00030Ã\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÄ\u0001\u0010Å\u0001R%\u0010Æ\u0001\u001a\u00020aX\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bÇ\u0001\u0010]\u001a\u0005\bÈ\u0001\u0010m\"\u0006\bÉ\u0001\u0010Ê\u0001R\u0018\u0010Ë\u0001\u001a\u00030Ì\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0018\u0010Ï\u0001\u001a\u00030Ð\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u000f\u0010Ó\u0001\u001a\u00020aX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010Ô\u0001\u001a\u00030Õ\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÖ\u0001\u0010×\u0001R \u0010Ø\u0001\u001a\n\u0012\u0005\u0012\u00030Ú\u00010Ù\u0001X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010Û\u0001R\u0018\u0010Ü\u0001\u001a\u00030Ý\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÞ\u0001\u0010ß\u0001R\u0019\u0010à\u0001\u001a\u00030á\u0001X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010â\u0001R\u0010\u0010ã\u0001\u001a\u00030ä\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010å\u0001\u001a\u00030æ\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010ç\u0001\u001a\u00030è\u00018VX\u0004¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001R\u0018\u0010ë\u0001\u001a\u00030ì\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bí\u0001\u0010î\u0001R\u0012\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u0001X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010ñ\u0001\u001a\u00030á\u0001X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010â\u0001R!\u0010ò\u0001\u001a\u0004\u0018\u00010\u00128FX\u0002¢\u0006\u000f\n\u0006\bô\u0001\u0010õ\u0001\u001a\u0005\bó\u0001\u0010\u0015R\u000f\u0010ö\u0001\u001a\u00020aX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010÷\u0001\u001a\u00030ø\u00018VX\u0004¢\u0006\b\u001a\u0006\bù\u0001\u0010ú\u0001R\u0017\u0010û\u0001\u001a\u00020zX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010fR\u0019\u0010ü\u0001\u001a\u00030á\u0001X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010â\u0001R\u001b\u0010ý\u0001\u001a\u00020>*\u0002058BX\u0004¢\u0006\b\u001a\u0006\bþ\u0001\u0010ÿ\u0001\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Ì\u0003"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "<set-?>", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "Landroidx/compose/runtime/MutableState;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "currentFontWeightAdjustment", "", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "dragAndDropModifierOnDragListener", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rotaryInputModifier", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/ULong;", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "invalidateParentLayer", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "event", "dispatchHoverEvent", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "dispatchTouchEvent", "motionEvent", "drawAndroidView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "forceMeasureTheSubtree", "affectsLookahead", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "localToScreen", "localToScreen-MK-Hz9U", "localTransform", "localToScreen-58bKbWc", "([F)V", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "measureAndLayoutForTest", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onProvideAutofillVirtualStructure", "structure", "Landroid/view/ViewStructure;", "flags", "onRequestMeasure", "forceRequest", "scheduleMeasureAndLayout", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onSemanticsChange", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onWindowFocusChanged", "hasWindowFocus", "pack", "a", "pack-ZIaKswc", "(II)J", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", "listener", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestClearInvalidObservations", "requestOnPositionedCallback", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "startDrag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "textInputSession", "", "session", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePositionCacheAndDispatch", "childSizeCanAffectParentSize", "component1", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "AndroidComposeViewTranslationCallback", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FocusTag = "Compose Focus";
    private static final int MaximumLayerCacheSize = 10;
    /* access modifiers changed from: private */
    public static Method getBooleanMethod;
    /* access modifiers changed from: private */
    public static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final InputModeManagerImpl _inputModeManager;
    private final MutableState _viewTreeOwners$delegate;
    private final WindowInfoImpl _windowInfo;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboardManager clipboardManager;
    /* access modifiers changed from: private */
    public final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private final CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;
    private Density density;
    private final List<OwnedLayer> dirtyLayers;
    private final DragAndDropManager dragAndDropManager;
    private final DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener;
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;
    private final MutableState fontFamilyResolver$delegate;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isRenderNodeCompatible;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition = Offset.Companion.m3577getUnspecifiedF1C5BW0();
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;
    private final MutableState layoutDirection$delegate;
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    /* access modifiers changed from: private */
    public MotionEvent previousMotionEvent;
    /* access modifiers changed from: private */
    public long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    /* access modifiers changed from: private */
    public final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final Modifier rotaryInputModifier;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final EmptySemanticsElement semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope = new LayoutNodeDrawScope((CanvasDrawScope) null, 1, (DefaultConstructorMarker) null);
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private final SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete = true;
    private final TextInputService textInputService;
    private final AtomicReference<SessionMutex.Session<T>> textInputSessionMutex;
    private final TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;
    private final State viewTreeOwners$delegate;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public void onAttach(LayoutNode layoutNode) {
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onDestroy(this, lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onPause(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStart(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStop(this, lifecycleOwner);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public AndroidComposeView(Context context, CoroutineContext coroutineContext2) {
        super(context);
        CalculateMatrixToWindow calculateMatrixToWindow;
        this.coroutineContext = coroutineContext2;
        this.density = AndroidDensity_androidKt.Density(context);
        EmptySemanticsElement emptySemanticsElement = EmptySemanticsElement.INSTANCE;
        this.semanticsModifier = emptySemanticsElement;
        this.focusOwner = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this));
        DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener2 = new DragAndDropModifierOnDragListener(new AndroidComposeView$dragAndDropModifierOnDragListener$1(this));
        this.dragAndDropModifierOnDragListener = dragAndDropModifierOnDragListener2;
        this.dragAndDropManager = dragAndDropModifierOnDragListener2;
        this._windowInfo = new WindowInfoImpl();
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(Modifier.Companion, new AndroidComposeView$keyInputModifier$1(this));
        this.keyInputModifier = onKeyEvent;
        Modifier onRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(Modifier.Companion, AndroidComposeView$rotaryInputModifier$1.INSTANCE);
        this.rotaryInputModifier = onRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0, 3, (DefaultConstructorMarker) null);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(Modifier.Companion.then(emptySemanticsElement).then(onRotaryScrollEvent).then(getFocusOwner().getModifier()).then(onKeyEvent).then(dragAndDropModifierOnDragListener2.getModifier()));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = AndroidComposeView$configurationChangeObserver$1.INSTANCE;
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        this.viewConfiguration = new AndroidViewConfiguration(ViewConfiguration.get(context));
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        float[] r3 = Matrix.m4058constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.tmpMatrix = r3;
        this.viewToWindowMatrix = Matrix.m4058constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.windowToViewMatrix = Matrix.m4058constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.lastMatrixRecalculationAnimationTime = -1;
        this.windowPosition = Offset.Companion.m3576getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this._viewTreeOwners$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.viewTreeOwners$delegate = SnapshotStateKt.derivedStateOf(new AndroidComposeView$viewTreeOwners$2(this));
        this.globalLayoutListener = new AndroidComposeView$$ExternalSyntheticLambda2(this);
        this.scrollChangedListener = new AndroidComposeView$$ExternalSyntheticLambda3(this);
        this.touchModeChangeListener = new AndroidComposeView$$ExternalSyntheticLambda4(this);
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.legacyTextInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(textInputServiceAndroid));
        this.textInputSessionMutex = SessionMutex.m3422constructorimpl();
        this.softwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver$delegate = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(context.getResources().getConfiguration());
        this.layoutDirection$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AndroidComposeView_androidKt.getLocaleLayoutDirection(context.getResources().getConfiguration()), (SnapshotMutationPolicy) null, 2, (Object) null);
        View view = this;
        this.hapticFeedBack = new PlatformHapticFeedback(view);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.Companion.m4638getTouchaOaMEAU() : InputMode.Companion.m4637getKeyboardaOaMEAU(), new AndroidComposeView$_inputModeManager$1(this), (DefaultConstructorMarker) null);
        Owner owner = this;
        this.modifierLocalManager = new ModifierLocalManager(owner);
        this.textToolbar = new AndroidTextToolbar(view);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new AndroidComposeView$resendMotionEventRunnable$1(this);
        this.sendHoverExitEvent = new AndroidComposeView$$ExternalSyntheticLambda5(this);
        this.resendMotionEventOnLayout = new AndroidComposeView$resendMotionEventOnLayout$1(this);
        if (Build.VERSION.SDK_INT >= 29) {
            calculateMatrixToWindow = new CalculateMatrixToWindowApi29();
        } else {
            calculateMatrixToWindow = new CalculateMatrixToWindowApi21(r3, (DefaultConstructorMarker) null);
        }
        this.matrixToWindow = calculateMatrixToWindow;
        setWillNotDraw(false);
        setFocusable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(view, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(view, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.Companion.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener(dragAndDropModifierOnDragListener2);
        getRoot().attach$ui_release(owner);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(view);
        }
        this.pointerIconService = new AndroidComposeView$pointerIconService$1(this);
    }

    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    public View getView() {
        return this;
    }

    public Density getDensity() {
        return this.density;
    }

    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    public DragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    public LayoutNode getRoot() {
        return this.root;
    }

    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.configurationChangeObserver = function1;
    }

    public Autofill getAutofill() {
        return this._autofill;
    }

    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    /* access modifiers changed from: private */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this._viewTreeOwners$delegate.getValue();
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners$delegate.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void globalLayoutListener$lambda$1(AndroidComposeView androidComposeView) {
        androidComposeView.updatePositionCacheAndDispatch();
    }

    /* access modifiers changed from: private */
    public static final void scrollChangedListener$lambda$2(AndroidComposeView androidComposeView) {
        androidComposeView.updatePositionCacheAndDispatch();
    }

    /* access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$3(AndroidComposeView androidComposeView, boolean z) {
        androidComposeView._inputModeManager.m4643setInputModeiuPiT84(z ? InputMode.Companion.m4638getTouchaOaMEAU() : InputMode.Companion.m4637getKeyboardaOaMEAU());
    }

    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope((Owner) this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object textInputSession(kotlin.jvm.functions.Function2<? super androidx.compose.ui.platform.PlatformTextInputSessionScope, ? super kotlin.coroutines.Continuation<?>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = (androidx.compose.ui.platform.AndroidComposeView$textInputSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 == r3) goto L_0x002e
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.concurrent.atomic.AtomicReference<androidx.compose.ui.SessionMutex$Session<T>> r6 = r4.textInputSessionMutex
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$2 r2 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$2
            r2.<init>(r4)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0.label = r3
            java.lang.Object r5 = androidx.compose.ui.SessionMutex.m3429withSessionCancellingPreviousimpl(r6, r2, r5, r0)
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.textInputSession(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver$delegate.setValue(resolver);
    }

    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver$delegate.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$5(AndroidComposeView androidComposeView) {
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() == 10) {
            androidComposeView.m5734sendMotionEvent8iAsVTc(motionEvent);
            return;
        }
        throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
    }

    public void getFocusedRect(Rect rect) {
        Unit unit;
        androidx.compose.ui.geometry.Rect focusRect = getFocusOwner().getFocusRect();
        if (focusRect != null) {
            rect.left = MathKt.roundToInt(focusRect.getLeft());
            rect.top = MathKt.roundToInt(focusRect.getTop());
            rect.right = MathKt.roundToInt(focusRect.getRight());
            rect.bottom = MathKt.roundToInt(focusRect.getBottom());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        setShowLayoutBounds(Companion.getIsShowingLayoutBounds());
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        Log.d(FocusTag, "Owner FocusChanged(" + z + ')');
        FocusTransactionManager focusTransactionManager = getFocusOwner().getFocusTransactionManager();
        focusTransactionManager.cancellationListener.add(new AndroidComposeView$onFocusChanged$1(z, this));
        if (!focusTransactionManager.ongoingTransaction) {
            try {
                focusTransactionManager.beginTransaction();
                if (z) {
                    getFocusOwner().takeFocus();
                } else {
                    getFocusOwner().releaseFocus();
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                focusTransactionManager.commitTransaction();
            }
        } else if (z) {
            getFocusOwner().takeFocus();
        } else {
            getFocusOwner().releaseFocus();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        boolean access$getIsShowingLayoutBounds;
        this._windowInfo.setWindowFocused(z);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(z);
        if (z && getShowLayoutBounds() != (access$getIsShowingLayoutBounds = Companion.getIsShowingLayoutBounds())) {
            setShowLayoutBounds(access$getIsShowingLayoutBounds);
            invalidateDescendants();
        }
    }

    /* renamed from: sendKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m5743sendKeyEventZmokQxo(KeyEvent keyEvent) {
        return getFocusOwner().m3494dispatchInterceptedSoftKeyboardEventZmokQxo(keyEvent) || getFocusOwner().m3495dispatchKeyEventZmokQxo(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isFocused()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this._windowInfo.m5846setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5180constructorimpl(keyEvent.getMetaState()));
        return getFocusOwner().m3495dispatchKeyEventZmokQxo(androidx.compose.ui.input.key.KeyEvent.m4941constructorimpl(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        return (isFocused() && getFocusOwner().m3494dispatchInterceptedSoftKeyboardEventZmokQxo(androidx.compose.ui.input.key.KeyEvent.m4941constructorimpl(keyEvent))) || super.dispatchKeyEventPreIme(keyEvent);
    }

    public void onDetach(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.onNodeDetached(layoutNode);
        requestClearInvalidObservations();
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                Function0 function0 = (Function0) this.endApplyChangesListeners.getContent()[i];
                this.endApplyChangesListeners.set(i, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    public void registerOnEndApplyChangesListener(Function0<Unit> function0) {
        if (!this.endApplyChangesListeners.contains(function0)) {
            this.endApplyChangesListeners.add(function0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startDrag-12SF9DM  reason: not valid java name */
    public final boolean m5735startDrag12SF9DM(DragAndDropTransferData dragAndDropTransferData, long j, Function1<? super DrawScope, Unit> function1) {
        Resources resources = getContext().getResources();
        ComposeDragShadowBuilder composeDragShadowBuilder = new ComposeDragShadowBuilder(DensityKt.Density(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), j, function1, (DefaultConstructorMarker) null);
        if (Build.VERSION.SDK_INT >= 24) {
            return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(this, dragAndDropTransferData, composeDragShadowBuilder);
        }
        return startDrag(dragAndDropTransferData.getClipData(), composeDragShadowBuilder, dragAndDropTransferData.getLocalState(), dragAndDropTransferData.getFlags());
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        Integer num;
        if (Intrinsics.areEqual((Object) str, (Object) this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal$ui_release())) {
            Integer num2 = this.composeAccessibilityDelegate.getIdToBeforeMap$ui_release().get(Integer.valueOf(i));
            if (num2 != null) {
                accessibilityNodeInfo.getExtras().putInt(str, num2.intValue());
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) this.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal$ui_release()) && (num = this.composeAccessibilityDelegate.getIdToAfterMap$ui_release().get(Integer.valueOf(i))) != null) {
            accessibilityNodeInfo.getExtras().putInt(str, num.intValue());
        }
    }

    public final void addAndroidView(AndroidViewHolder androidViewHolder, LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(androidViewHolder, layoutNode);
        View view = androidViewHolder;
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, androidViewHolder);
        ViewCompat.setImportantForAccessibility(view, 1);
        ViewCompat.setAccessibilityDelegate(view, new AndroidComposeView$addAndroidView$1(this, layoutNode, this));
    }

    public final void removeAndroidView(AndroidViewHolder androidViewHolder) {
        registerOnEndApplyChangesListener(new AndroidComposeView$removeAndroidView$1(this, androidViewHolder));
    }

    public final void drawAndroidView(AndroidViewHolder androidViewHolder, Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(androidViewHolder, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode layoutNode) {
        if (!isLayoutRequested() && isAttachedToWindow()) {
            if (layoutNode != null) {
                while (layoutNode != null && layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(layoutNode)) {
                    layoutNode = layoutNode.getParent$ui_release();
                }
                if (layoutNode == getRoot()) {
                    requestLayout();
                    return;
                }
            }
            if (getWidth() == 0 || getHeight() == 0) {
                requestLayout();
            } else {
                invalidate();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r2.getParent$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean childSizeCanAffectParentSize(androidx.compose.ui.node.LayoutNode r2) {
        /*
            r1 = this;
            boolean r0 = r1.wasMeasuredWithMultipleConstraints
            if (r0 != 0) goto L_0x0013
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x0011
            boolean r2 = r2.getHasFixedInnerContentConstraints$ui_release()
            if (r2 != 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r2 = 0
            goto L_0x0014
        L_0x0013:
            r2 = 1
        L_0x0014:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.childSizeCanAffectParentSize(androidx.compose.ui.node.LayoutNode):boolean");
    }

    public void measureAndLayout(boolean z) {
        Function0<Unit> function0;
        if (this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() || this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (z) {
                try {
                    function0 = this.resendMotionEventOnLayout;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                function0 = null;
            }
            if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
                requestLayout();
            }
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, (Object) null);
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        }
    }

    /* renamed from: measureAndLayout-0kLqBqw  reason: not valid java name */
    public void m5741measureAndLayout0kLqBqw(LayoutNode layoutNode, long j) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m5590measureAndLayout0kLqBqw(layoutNode, j);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, (Object) null);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, z);
    }

    public void onRequestMeasure(LayoutNode layoutNode, boolean z, boolean z2, boolean z3) {
        if (z) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z2) && z3) {
                scheduleMeasureAndLayout(layoutNode);
            }
        } else if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, z2) && z3) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    public void onRequestRelayout(LayoutNode layoutNode, boolean z, boolean z2) {
        if (z) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z2)) {
                scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, z2)) {
            scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
        }
    }

    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
    }

    public void measureAndLayoutForTest() {
        Owner.CC.measureAndLayout$default(this, false, 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long r0 = m5731convertMeasureSpecI7RO_PI(i);
            long r5 = m5731convertMeasureSpecI7RO_PI(i2);
            long Constraints = ConstraintsKt.Constraints((int) ULong.m7216constructorimpl(r0 >>> 32), (int) ULong.m7216constructorimpl(r0 & 4294967295L), (int) ULong.m7216constructorimpl(r5 >>> 32), (int) ULong.m7216constructorimpl(4294967295L & r5));
            Constraints constraints = this.onMeasureConstraints;
            boolean z = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m6514boximpl(Constraints);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    z = Constraints.m6519equalsimpl0(constraints.m6532unboximpl(), Constraints);
                }
                if (!z) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m5591updateRootConstraintsBRTryo0(Constraints);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: component1-VKZWuLQ  reason: not valid java name */
    private final int m5729component1VKZWuLQ(long j) {
        return (int) ULong.m7216constructorimpl(j >>> 32);
    }

    /* renamed from: component2-VKZWuLQ  reason: not valid java name */
    private final int m5730component2VKZWuLQ(long j) {
        return (int) ULong.m7216constructorimpl(j & 4294967295L);
    }

    /* renamed from: pack-ZIaKswc  reason: not valid java name */
    private final long m5733packZIaKswc(int i, int i2) {
        return ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) i2) | ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) i) << 32));
    }

    /* renamed from: convertMeasureSpec-I7RO_PI  reason: not valid java name */
    private final long m5731convertMeasureSpecI7RO_PI(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return m5733packZIaKswc(0, size);
        }
        if (mode == 0) {
            return m5733packZIaKswc(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return m5733packZIaKswc(size, size);
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, i3 - i, i4 - i2);
        }
    }

    private final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int r2 = IntOffset.m6740component1impl(j);
        int r0 = IntOffset.m6741component2impl(j);
        int[] iArr = this.tmpPositionArray;
        boolean z = false;
        int i = iArr[0];
        if (!(r2 == i && r0 == iArr[1])) {
            this.globalPosition = IntOffsetKt.IntOffset(i, iArr[1]);
            if (!(r2 == Integer.MAX_VALUE || r0 == Integer.MAX_VALUE)) {
                getRoot().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                z = true;
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public OwnedLayer createLayer(Function1<? super androidx.compose.ui.graphics.Canvas, Unit> function1, Function0<Unit> function0) {
        DrawChildContainer drawChildContainer;
        OwnedLayer pop = this.layerCache.pop();
        if (pop != null) {
            pop.reuseLayer(function1, function0);
            return pop;
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, function1, function0);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            if (!ViewLayer.Companion.getHasRetrievedMethod()) {
                ViewLayer.Companion.updateDisplayList(new View(getContext()));
            }
            if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
                drawChildContainer = new DrawChildContainer(getContext());
            } else {
                drawChildContainer = new ViewLayerContainer(getContext());
            }
            this.viewLayersContainer = drawChildContainer;
            addView(drawChildContainer);
        }
        DrawChildContainer drawChildContainer2 = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer2);
        return new ViewLayer(this, drawChildContainer2, function1, function0);
    }

    public final boolean recycle$ui_release(OwnedLayer ownedLayer) {
        if (this.viewLayersContainer != null) {
            ViewLayer.Companion.getShouldUseDispatchDraw();
        }
        this.layerCache.push(ownedLayer);
        return true;
    }

    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui_release();
    }

    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui_release(layoutNode);
    }

    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener onLayoutCompletedListener) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(onLayoutCompletedListener);
        scheduleMeasureAndLayout$default(this, (LayoutNode) null, 1, (Object) null);
    }

    /* renamed from: getFocusDirection-P8AzH3I  reason: not valid java name */
    public FocusDirection m5738getFocusDirectionP8AzH3I(KeyEvent keyEvent) {
        long r0 = KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent);
        if (Key.m4649equalsimpl0(r0, Key.Companion.m4885getTabEK5gGoQ())) {
            return FocusDirection.m3476boximpl(KeyEvent_androidKt.m4963isShiftPressedZmokQxo(keyEvent) ? FocusDirection.Companion.m3490getPreviousdhqQ8s() : FocusDirection.Companion.m3489getNextdhqQ8s());
        } else if (Key.m4649equalsimpl0(r0, Key.Companion.m4726getDirectionRightEK5gGoQ())) {
            return FocusDirection.m3476boximpl(FocusDirection.Companion.m3491getRightdhqQ8s());
        } else {
            if (Key.m4649equalsimpl0(r0, Key.Companion.m4725getDirectionLeftEK5gGoQ())) {
                return FocusDirection.m3476boximpl(FocusDirection.Companion.m3488getLeftdhqQ8s());
            }
            boolean z = true;
            if (Key.m4649equalsimpl0(r0, Key.Companion.m4727getDirectionUpEK5gGoQ()) ? true : Key.m4649equalsimpl0(r0, Key.Companion.m4838getPageUpEK5gGoQ())) {
                return FocusDirection.m3476boximpl(FocusDirection.Companion.m3492getUpdhqQ8s());
            }
            if (Key.m4649equalsimpl0(r0, Key.Companion.m4722getDirectionDownEK5gGoQ()) ? true : Key.m4649equalsimpl0(r0, Key.Companion.m4837getPageDownEK5gGoQ())) {
                return FocusDirection.m3476boximpl(FocusDirection.Companion.m3485getDowndhqQ8s());
            }
            if (Key.m4649equalsimpl0(r0, Key.Companion.m4721getDirectionCenterEK5gGoQ()) ? true : Key.m4649equalsimpl0(r0, Key.Companion.m4735getEnterEK5gGoQ()) ? true : Key.m4649equalsimpl0(r0, Key.Companion.m4827getNumPadEnterEK5gGoQ())) {
                return FocusDirection.m3476boximpl(FocusDirection.Companion.m3486getEnterdhqQ8s());
            }
            if (!Key.m4649equalsimpl0(r0, Key.Companion.m4664getBackEK5gGoQ())) {
                z = Key.m4649equalsimpl0(r0, Key.Companion.m4738getEscapeEK5gGoQ());
            }
            if (z) {
                return FocusDirection.m3476boximpl(FocusDirection.Companion.m3487getExitdhqQ8s());
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.CC.measureAndLayout$default(this, false, 1, (Object) null);
        Snapshot.Companion.sendApplyNotifications();
        this.isDrawingContent = true;
        CanvasHolder canvasHolder2 = this.canvasHolder;
        Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
        canvasHolder2.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder2.getAndroidCanvas());
        canvasHolder2.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                this.dirtyLayers.get(i).updateDisplayList();
            }
        }
        if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
            int save = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer ownedLayer, boolean z) {
        if (!z) {
            if (!this.isDrawingContent) {
                this.dirtyLayers.remove(ownedLayer);
                List<OwnedLayer> list = this.postponedDirtyLayers;
                if (list != null) {
                    list.remove(ownedLayer);
                }
            }
        } else if (!this.isDrawingContent) {
            this.dirtyLayers.add(ownedLayer);
        } else {
            List<OwnedLayer> list2 = this.postponedDirtyLayers;
            if (list2 == null) {
                list2 = new ArrayList<>();
                this.postponedDirtyLayers = list2;
            }
            list2.add(ownedLayer);
        }
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> function1) {
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            function1.invoke(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = function1;
        }
    }

    public final Object boundsUpdatesEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop$ui_release = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui_release(continuation);
        return boundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode layoutNode) {
        int i = 0;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, layoutNode, false, 2, (Object) null);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            do {
                invalidateLayoutNodeMeasurement((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    private final void invalidateLayers(LayoutNode layoutNode) {
        layoutNode.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                invalidateLayers((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        View view = this;
        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(view);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(view);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || !(lifecycleOwner2 == null || savedStateRegistryOwner == null || (lifecycleOwner2 == viewTreeOwners.getLifecycleOwner() && savedStateRegistryOwner == viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner2 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            } else if (savedStateRegistryOwner != null) {
                if (!(viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
                    lifecycle.removeObserver(this);
                }
                lifecycleOwner2.getLifecycle().addObserver(this);
                ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner2, savedStateRegistryOwner);
                set_viewTreeOwners(viewTreeOwners2);
                Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
                if (function1 != null) {
                    function1.invoke(viewTreeOwners2);
                }
                this.onViewTreeOwnersAvailable = null;
            } else {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
        }
        this._inputModeManager.m4643setInputModeiuPiT84(isInTouchMode() ? InputMode.Companion.m4638getTouchaOaMEAU() : InputMode.Companion.m4637getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners3);
        viewTreeOwners3.getLifecycleOwner().getLifecycle().addObserver(this);
        ViewTreeOwners viewTreeOwners4 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners4);
        viewTreeOwners4.getLifecycleOwner().getLifecycle().addObserver(this.composeAccessibilityDelegate);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(view, RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m((Object) new AndroidComposeViewTranslationCallback()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner2;
        Lifecycle lifecycle2;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (!(viewTreeOwners == null || (lifecycleOwner2 = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle2 = lifecycleOwner2.getLifecycle()) == null)) {
            lifecycle2.removeObserver(this);
        }
        ViewTreeOwners viewTreeOwners2 = getViewTreeOwners();
        if (!(viewTreeOwners2 == null || (lifecycleOwner = viewTreeOwners2.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
            lifecycle.removeObserver(this.composeAccessibilityDelegate);
        }
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
        }
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        AndroidAutofill androidAutofill;
        if (autofillSupported() && viewStructure != null && (androidAutofill = this._autofill) != null) {
            AndroidAutofill_androidKt.populateViewStructure(androidAutofill, viewStructure);
        }
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        AndroidAutofill androidAutofill;
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AndroidAutofill_androidKt.performAutofill(androidAutofill, sparseArray);
        }
    }

    public void onCreateVirtualViewTranslationRequests(long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
        this.composeAccessibilityDelegate.onCreateVirtualViewTranslationRequests$ui_release(jArr, iArr, consumer);
    }

    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> longSparseArray) {
        this.composeAccessibilityDelegate.onVirtualViewTranslationResponses$ui_release(longSparseArray);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (motionEvent.isFromSource(4194304)) {
            return handleRotaryEvent(motionEvent);
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return ProcessResult.m5206getDispatchedToAPointerInputModifierimpl(m5732handleMotionEvent8iAsVTc(motionEvent));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int r4 = m5732handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m5205getAnyMovementConsumedimpl(r4)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m5206getDispatchedToAPointerInputModifierimpl(r4);
    }

    private final boolean handleRotaryEvent(MotionEvent motionEvent) {
        ViewConfiguration viewConfiguration2 = ViewConfiguration.get(getContext());
        float f = -motionEvent.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(f * ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration2, getContext()), f * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration2, getContext()), motionEvent.getEventTime(), motionEvent.getDeviceId()));
    }

    /* renamed from: handleMotionEvent-8iAsVTc  reason: not valid java name */
    private final int m5732handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            boolean z = true;
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            int actionMasked = motionEvent.getActionMasked();
            MotionEvent motionEvent2 = this.previousMotionEvent;
            boolean z2 = motionEvent2 != null && motionEvent2.getToolType(0) == 3;
            if (motionEvent2 != null && hasChangedDevices(motionEvent, motionEvent2)) {
                if (isDevicePressEvent(motionEvent2)) {
                    this.pointerInputEventProcessor.processCancel();
                } else if (motionEvent2.getActionMasked() != 10 && z2) {
                    sendSimulatedEvent$default(this, motionEvent2, 10, motionEvent2.getEventTime(), false, 8, (Object) null);
                }
            }
            if (motionEvent.getToolType(0) != 3) {
                z = false;
            }
            if (!z2 && z && actionMasked != 3 && actionMasked != 9 && isInBounds(motionEvent)) {
                sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, (Object) null);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
            int r15 = m5734sendMotionEvent8iAsVTc(motionEvent);
            Trace.endSection();
            this.forceUseMatrixCache = false;
            return r15;
        } catch (Throwable th) {
            this.forceUseMatrixCache = false;
            throw th;
        }
    }

    private final boolean hasChangedDevices(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) {
            return false;
        }
        return true;
    }

    private final boolean isDevicePressEvent(MotionEvent motionEvent) {
        int actionMasked;
        if (motionEvent.getButtonState() != 0 || (actionMasked = motionEvent.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6) {
            return true;
        }
        return false;
    }

    /* renamed from: sendMotionEvent-8iAsVTc  reason: not valid java name */
    private final int m5734sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m5846setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5180constructorimpl(motionEvent.getMetaState()));
        }
        PositionCalculator positionCalculator = this;
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, positionCalculator);
        if (convertToPointerInputEvent$ui_release != null) {
            List<PointerInputEventData> pointers = convertToPointerInputEvent$ui_release.getPointers();
            int size = pointers.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    pointerInputEventData = pointers.get(size);
                    if (pointerInputEventData.getDown()) {
                        break;
                    } else if (i < 0) {
                        break;
                    } else {
                        size = i;
                    }
                }
            }
            pointerInputEventData = null;
            PointerInputEventData pointerInputEventData2 = pointerInputEventData;
            if (pointerInputEventData2 != null) {
                this.lastDownPointerPosition = pointerInputEventData2.m5130getPositionF1C5BW0();
            }
            int r0 = this.pointerInputEventProcessor.m5135processBIzXfog(convertToPointerInputEvent$ui_release, positionCalculator, isInBounds(motionEvent));
            int actionMasked = motionEvent.getActionMasked();
            if ((actionMasked != 0 && actionMasked != 5) || ProcessResult.m5206getDispatchedToAPointerInputModifierimpl(r0)) {
                return r0;
            }
            this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
            return r0;
        }
        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false);
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z);
    }

    /* access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int i, long j, boolean z) {
        int i2;
        long j2;
        MotionEvent motionEvent2 = motionEvent;
        int i3 = i;
        int actionMasked = motionEvent.getActionMasked();
        int i4 = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i4 = motionEvent.getActionIndex();
            }
        } else if (!(i3 == 9 || i3 == 10)) {
            i4 = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (i4 >= 0 ? 1 : 0);
        if (pointerCount != 0) {
            MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
            for (int i5 = 0; i5 < pointerCount; i5++) {
                pointerPropertiesArr[i5] = new MotionEvent.PointerProperties();
            }
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
            for (int i6 = 0; i6 < pointerCount; i6++) {
                pointerCoordsArr[i6] = new MotionEvent.PointerCoords();
            }
            int i7 = 0;
            while (i7 < pointerCount) {
                int i8 = ((i4 < 0 || i7 < i4) ? 0 : 1) + i7;
                motionEvent2.getPointerProperties(i8, pointerPropertiesArr[i7]);
                MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i7];
                motionEvent2.getPointerCoords(i8, pointerCoords);
                long r11 = m5740localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
                pointerCoords.x = Offset.m3562getXimpl(r11);
                pointerCoords.y = Offset.m3563getYimpl(r11);
                i7++;
            }
            if (z) {
                i2 = 0;
            } else {
                i2 = motionEvent.getButtonState();
            }
            if (motionEvent.getDownTime() == motionEvent.getEventTime()) {
                j2 = j;
            } else {
                j2 = motionEvent.getDownTime();
            }
            MotionEvent obtain = MotionEvent.obtain(j2, j, i, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), i2, motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
            PositionCalculator positionCalculator = this;
            PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(obtain, positionCalculator);
            Intrinsics.checkNotNull(convertToPointerInputEvent$ui_release);
            this.pointerInputEventProcessor.m5135processBIzXfog(convertToPointerInputEvent$ui_release, positionCalculator, true);
            obtain.recycle();
        }
    }

    public boolean canScrollHorizontally(int i) {
        return this.composeAccessibilityDelegate.m5751canScroll0AR0LA0$ui_release(false, i, this.lastDownPointerPosition);
    }

    public boolean canScrollVertically(int i) {
        return this.composeAccessibilityDelegate.m5751canScroll0AR0LA0$ui_release(true, i, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return 0.0f <= x && x <= ((float) getWidth()) && 0.0f <= y && y <= ((float) getHeight());
    }

    /* renamed from: localToScreen-MK-Hz9U  reason: not valid java name */
    public long m5740localToScreenMKHz9U(long j) {
        recalculateWindowPosition();
        long r4 = Matrix.m4064mapMKHz9U(this.viewToWindowMatrix, j);
        return OffsetKt.Offset(Offset.m3562getXimpl(r4) + Offset.m3562getXimpl(this.windowPosition), Offset.m3563getYimpl(r4) + Offset.m3563getYimpl(this.windowPosition));
    }

    /* renamed from: localToScreen-58bKbWc  reason: not valid java name */
    public void m5739localToScreen58bKbWc(float[] fArr) {
        recalculateWindowPosition();
        Matrix.m4075timesAssign58bKbWc(fArr, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.m5758preTranslatecG2Xzmc(fArr, Offset.m3562getXimpl(this.windowPosition), Offset.m3563getYimpl(this.windowPosition), this.tmpMatrix);
    }

    /* renamed from: screenToLocal-MK-Hz9U  reason: not valid java name */
    public long m5742screenToLocalMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m4064mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m3562getXimpl(j) - Offset.m3562getXimpl(this.windowPosition), Offset.m3563getYimpl(j) - Offset.m3563getYimpl(this.windowPosition)));
    }

    private final void recalculateWindowPosition() {
        if (!this.forceUseMatrixCache) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
                this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
                recalculateWindowViewTransforms();
                ViewParent parent = getParent();
                View view = this;
                while (parent instanceof ViewGroup) {
                    view = (View) parent;
                    parent = ((ViewGroup) view).getParent();
                }
                view.getLocationOnScreen(this.tmpPositionArray);
                int[] iArr = this.tmpPositionArray;
                view.getLocationInWindow(iArr);
                int[] iArr2 = this.tmpPositionArray;
                this.windowPosition = OffsetKt.Offset(((float) iArr[0]) - ((float) iArr2[0]), ((float) iArr[1]) - ((float) iArr2[1]));
            }
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long r0 = Matrix.m4064mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m3562getXimpl(r0), motionEvent.getRawY() - Offset.m3563getYimpl(r0));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.m5760calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m5787invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m3426getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.isEditorFocused();
        }
        return androidPlatformTextInputSession.isReadyForConnection();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m3426getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.createInputConnection(editorInfo);
        }
        return androidPlatformTextInputSession.createInputConnection(editorInfo);
    }

    /* renamed from: calculateLocalPosition-MK-Hz9U  reason: not valid java name */
    public long m5736calculateLocalPositionMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m4064mapMKHz9U(this.windowToViewMatrix, j);
    }

    /* renamed from: calculatePositionInWindow-MK-Hz9U  reason: not valid java name */
    public long m5737calculatePositionInWindowMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m4064mapMKHz9U(this.viewToWindowMatrix, j);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.density = AndroidDensity_androidKt.Density(getContext());
        if (getFontWeightAdjustmentCompat(configuration) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(configuration);
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
        }
        this.configurationChangeObserver.invoke(configuration);
    }

    public void onRtlPropertiesChanged(int i) {
        if (this.superclassInitComplete) {
            LayoutDirection access$layoutDirectionFromInt = AndroidComposeView_androidKt.layoutDirectionFromInt(i);
            setLayoutDirection(access$layoutDirectionFromInt);
            getFocusOwner().setLayoutDirection(access$layoutDirectionFromInt);
        }
    }

    private final boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        this.composeAccessibilityDelegate.dispatchHoverEvent$ui_release(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(motionEvent)) {
                if (motionEvent.getToolType(0) == 3 && motionEvent.getButtonState() != 0) {
                    return false;
                }
                MotionEvent motionEvent2 = this.previousMotionEvent;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                this.hoverExitReceived = true;
                post(this.sendHoverExitEvent);
                return false;
            }
        } else if (!isPositionChanged(motionEvent)) {
            return false;
        }
        return ProcessResult.m5206getDispatchedToAPointerInputModifierimpl(m5732handleMotionEvent8iAsVTc(motionEvent));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0082 A[LOOP:0: B:20:0x004c->B:36:0x0082, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085 A[EDGE_INSN: B:38:0x0085->B:37:0x0085 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isBadMotionEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            float r0 = r7.getX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0044
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0044
            float r0 = r7.getY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x0044
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0044
            float r0 = r7.getRawX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x0044
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0044
            float r0 = r7.getRawY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x0044
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0044
            r0 = r2
            goto L_0x0045
        L_0x0044:
            r0 = r3
        L_0x0045:
            if (r0 != 0) goto L_0x0085
            int r1 = r7.getPointerCount()
            r4 = r3
        L_0x004c:
            if (r4 >= r1) goto L_0x0085
            float r0 = r7.getX(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L_0x007f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x007f
            float r0 = r7.getY(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L_0x007f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x007f
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r0 < r5) goto L_0x007d
            androidx.compose.ui.platform.MotionEventVerifierApi29 r0 = androidx.compose.ui.platform.MotionEventVerifierApi29.INSTANCE
            boolean r0 = r0.isValidMotionEvent(r7, r4)
            if (r0 != 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r0 = r2
            goto L_0x0080
        L_0x007f:
            r0 = r3
        L_0x0080:
            if (r0 != 0) goto L_0x0085
            int r4 = r4 + 1
            goto L_0x004c
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.isBadMotionEvent(android.view.MotionEvent):boolean");
    }

    private final boolean isPositionChanged(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        if (motionEvent.getPointerCount() == 1 && (motionEvent2 = this.previousMotionEvent) != null && motionEvent2.getPointerCount() == motionEvent.getPointerCount() && motionEvent.getRawX() == motionEvent2.getRawX() && motionEvent.getRawY() == motionEvent2.getRawY()) {
            return false;
        }
        return true;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int i, View view) {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("getAccessibilityViewId", (Class[]) null);
            declaredMethod.setAccessible(true);
            if (Intrinsics.areEqual(declaredMethod.invoke(view, (Object[]) null), (Object) Integer.valueOf(i))) {
                return view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i, viewGroup.getChildAt(i2));
                    if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                        return findViewByAccessibilityIdRootedAtCurrentView;
                    }
                }
            }
        }
        return null;
    }

    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int i) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return findViewByAccessibilityIdRootedAtCurrentView(i, this);
            }
            Method declaredMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("findViewByAccessibilityIdTraversal", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(this, new Object[]{Integer.valueOf(i)});
            if (invoke instanceof View) {
                return (View) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (r0 = r0.getLifecycleOwner()).getLifecycle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLifecycleInResumedState() {
        /*
            r2 = this;
            androidx.compose.ui.platform.AndroidComposeView$ViewTreeOwners r0 = r2.getViewTreeOwners()
            if (r0 == 0) goto L_0x0017
            androidx.lifecycle.LifecycleOwner r0 = r0.getLifecycleOwner()
            if (r0 == 0) goto L_0x0017
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            if (r0 == 0) goto L_0x0017
            androidx.lifecycle.Lifecycle$State r0 = r0.getCurrentState()
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r0 != r1) goto L_0x001e
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.isLifecycleInResumedState():boolean");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "FocusTag", "", "MaximumLayerCacheSize", "", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeView.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            Object obj;
            Method method;
            try {
                Boolean bool = null;
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class access$getSystemPropertiesClass$cp = AndroidComposeView.systemPropertiesClass;
                    if (access$getSystemPropertiesClass$cp != null) {
                        method = access$getSystemPropertiesClass$cp.getDeclaredMethod("getBoolean", new Class[]{String.class, Boolean.TYPE});
                    } else {
                        method = null;
                    }
                    AndroidComposeView.getBooleanMethod = method;
                }
                Method access$getGetBooleanMethod$cp = AndroidComposeView.getBooleanMethod;
                if (access$getGetBooleanMethod$cp != null) {
                    obj = access$getGetBooleanMethod$cp.invoke((Object) null, new Object[]{"debug.layout", false});
                } else {
                    obj = null;
                }
                if (obj instanceof Boolean) {
                    bool = (Boolean) obj;
                }
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeView.android.kt */
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner2, SavedStateRegistryOwner savedStateRegistryOwner2) {
            this.lifecycleOwner = lifecycleOwner2;
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$AndroidComposeViewTranslationCallback;", "Landroid/view/translation/ViewTranslationCallback;", "()V", "onClearTranslation", "", "view", "Landroid/view/View;", "onHideTranslation", "onShowTranslation", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidComposeView.android.kt */
    private static final class AndroidComposeViewTranslationCallback implements ViewTranslationCallback {
        public boolean onShowTranslation(View view) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
            ((AndroidComposeView) view).composeAccessibilityDelegate.onShowTranslation$ui_release();
            return true;
        }

        public boolean onHideTranslation(View view) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
            ((AndroidComposeView) view).composeAccessibilityDelegate.onHideTranslation$ui_release();
            return true;
        }

        public boolean onClearTranslation(View view) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
            ((AndroidComposeView) view).composeAccessibilityDelegate.onClearTranslation$ui_release();
            return true;
        }
    }
}
