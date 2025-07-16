package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b?\b\u0000\u0018\u0000 á\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\bá\u0002â\u0002ã\u0002ä\u0002B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010å\u0001\u001a\u00030¶\u00012\b\u0010À\u0001\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bæ\u0001J\u0010\u0010ç\u0001\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\bè\u0001J\n\u0010é\u0001\u001a\u00030¶\u0001H\u0002J\u0014\u0010ê\u0001\u001a\u00030ë\u00012\b\b\u0002\u0010G\u001a\u00020\u000bH\u0002J\u0010\u0010ì\u0001\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\bí\u0001J\u0010\u0010î\u0001\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\bï\u0001J\u001a\u0010ð\u0001\u001a\u00030¶\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0000¢\u0006\u0003\bó\u0001J\"\u0010ô\u0001\u001a\u00030¶\u00012\u0015\u0010õ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030¶\u00010´\u0001H\bJ(\u0010ö\u0001\u001a\u00030¶\u00012\u001b\u0010õ\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030¶\u00010÷\u0001H\bJ)\u0010ø\u0001\u001a\u00030¶\u00012\u0016\u0010õ\u0001\u001a\u0011\u0012\u0005\u0012\u00030ù\u0001\u0012\u0005\u0012\u00030¶\u00010´\u0001H\b¢\u0006\u0003\bú\u0001J(\u0010û\u0001\u001a\u00030¶\u00012\u0015\u0010õ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030¶\u00010´\u0001H\b¢\u0006\u0003\bü\u0001J\n\u0010ý\u0001\u001a\u00030¶\u0001H\u0016J\u0013\u0010þ\u0001\u001a\f\u0018\u00010ÿ\u0001j\u0005\u0018\u0001`\u0002H\u0017J\u0010\u0010\u0002\u001a\t\u0012\u0005\u0012\u00030\u00020$H\u0016J@\u0010\u0002\u001a\u00030¶\u00012\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\t\b\u0002\u0010\u0002\u001a\u00020\t2\t\b\u0002\u0010\u0002\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J@\u0010\u0002\u001a\u00030¶\u00012\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\t\b\u0002\u0010\u0002\u001a\u00020\t2\t\b\u0002\u0010\u0002\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J!\u0010P\u001a\u00030¶\u00012\u000f\u0010õ\u0001\u001a\n\u0012\u0005\u0012\u00030¶\u00010\u0002H\b¢\u0006\u0003\b\u0002J\"\u0010\u0002\u001a\u00030¶\u00012\u0007\u0010\u0002\u001a\u00020\u000b2\u0007\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u0002J\n\u0010\u0002\u001a\u00030¶\u0001H\u0002J\n\u0010\u0002\u001a\u00030¶\u0001H\u0002J\u0010\u0010\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b \u0002J\u0013\u0010¡\u0002\u001a\u00030¶\u00012\t\b\u0002\u0010¢\u0002\u001a\u00020\tJ\n\u0010£\u0002\u001a\u00030¶\u0001H\u0002J \u0010¤\u0002\u001a\u00020\t2\f\b\u0002\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u0002H\u0000ø\u0001\u0000¢\u0006\u0003\b§\u0002J\u0010\u0010¨\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b©\u0002J\u0010\u0010ª\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b«\u0002J\u0010\u0010¬\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b­\u0002J\u0010\u0010®\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b¯\u0002J\u0010\u0010°\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b±\u0002J+\u0010²\u0002\u001a\u00030¶\u00012\u0007\u0010³\u0002\u001a\u00020\u000b2\u0007\u0010´\u0002\u001a\u00020\u000b2\u0007\u0010µ\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\b¶\u0002J\u0013\u0010·\u0002\u001a\u00030¶\u00012\u0007\u0010¸\u0002\u001a\u00020\u0000H\u0002J\n\u0010¹\u0002\u001a\u00030¶\u0001H\u0016J\n\u0010º\u0002\u001a\u00030¶\u0001H\u0002J\n\u0010»\u0002\u001a\u00030¶\u0001H\u0016J\n\u0010¼\u0002\u001a\u00030¶\u0001H\u0016J\n\u0010½\u0002\u001a\u00030¶\u0001H\u0016J\u0010\u0010¾\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\b¿\u0002J\"\u0010À\u0002\u001a\u00030¶\u00012\u0007\u0010Á\u0002\u001a\u00020\u000b2\u0007\u0010Â\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÃ\u0002J\n\u0010Ä\u0002\u001a\u00030¶\u0001H\u0002J \u0010Å\u0002\u001a\u00020\t2\f\b\u0002\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u0002H\u0000ø\u0001\u0000¢\u0006\u0003\bÆ\u0002J\u0010\u0010Ç\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\bÈ\u0002J\"\u0010É\u0002\u001a\u00030¶\u00012\u0007\u0010\u0002\u001a\u00020\u000b2\u0007\u0010µ\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÊ\u0002J\u0010\u0010Ë\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\bÌ\u0002J\u001b\u0010Í\u0002\u001a\u00030¶\u00012\t\b\u0002\u0010Î\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÏ\u0002J&\u0010Ð\u0002\u001a\u00030¶\u00012\t\b\u0002\u0010Î\u0002\u001a\u00020\t2\t\b\u0002\u0010Ñ\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÒ\u0002J\u001b\u0010Ó\u0002\u001a\u00030¶\u00012\t\b\u0002\u0010Î\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÔ\u0002J&\u0010Õ\u0002\u001a\u00030¶\u00012\t\b\u0002\u0010Î\u0002\u001a\u00020\t2\t\b\u0002\u0010Ñ\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÖ\u0002J\u0019\u0010×\u0002\u001a\u00030¶\u00012\u0007\u0010Ø\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÙ\u0002J\n\u0010Ú\u0002\u001a\u00030¶\u0001H\u0002J\u0010\u0010Û\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\bÜ\u0002J\t\u0010Ý\u0002\u001a\u00020\tH\u0002J\n\u0010Þ\u0002\u001a\u00030ë\u0001H\u0016J\u0010\u0010ß\u0002\u001a\u00030¶\u0001H\u0000¢\u0006\u0003\bà\u0002R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8@X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8@X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000$8@X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010\u00128@X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R,\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000b8W@WX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u001f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00108\u001a\u0002072\u0006\u00106\u001a\u000207@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020>8VX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R$\u0010B\u001a\u00020A2\u0006\u00106\u001a\u00020A@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00103\"\u0004\bI\u00105R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00000$8@X\u0004¢\u0006\u0006\u001a\u0004\bK\u0010'R\u0014\u0010L\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u001cR\u0014\u0010N\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\bO\u00103R\u000e\u0010P\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\u00020\u00178@X\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0016\u0010T\u001a\u0004\u0018\u00010\u00178BX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010SR\u001a\u0010V\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001c\"\u0004\bX\u0010\"R\"\u0010Y\u001a\n\u0018\u00010Zj\u0004\u0018\u0001`[X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020aX\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u001cR\u001e\u0010k\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u001cR\u0014\u0010l\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u001cR\u0011\u0010m\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bm\u0010\u001cR\u0013\u0010n\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0014\u0010p\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\u001cR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010q\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u001c\"\u0004\bs\u0010\"R\u0014\u0010t\u001a\u00020uX\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR$\u0010y\u001a\u00020x2\u0006\u00106\u001a\u00020x@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0014\u0010~\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u001cR\u0018\u0010\u0001\u001a\u00030\u00018@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\t8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u001cR\u0016\u0010\u0001\u001a\u00020\t8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u001cR\u001e\u0010\u0001\u001a\t\u0018\u00010\u0001R\u00020u8@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R.\u0010\u0001\u001a\u0004\u0018\u00010\u00002\t\u0010\u0001\u001a\u0004\u0018\u00010\u0000@BX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u00018@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u00070\u0001R\u00020u8@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\t8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u001cR+\u0010\u0001\u001a\u00030\u00012\u0007\u00106\u001a\u00030\u0001@VX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b \u0001\u0010¡\u0001R\u0016\u0010¢\u0001\u001a\u00020e8@X\u0004¢\u0006\u0007\u001a\u0005\b£\u0001\u0010gR\u0016\u0010¤\u0001\u001a\u00020e8@X\u0004¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010gR+\u0010§\u0001\u001a\u00030¦\u00012\u0007\u00106\u001a\u00030¦\u0001@VX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R\u001d\u0010¬\u0001\u001a\u00020\tX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b­\u0001\u0010\u001c\"\u0005\b®\u0001\u0010\"R\u0018\u0010¯\u0001\u001a\u00030°\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b±\u0001\u0010²\u0001R0\u0010³\u0001\u001a\u0013\u0012\u0005\u0012\u00030µ\u0001\u0012\u0005\u0012\u00030¶\u0001\u0018\u00010´\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R0\u0010»\u0001\u001a\u0013\u0012\u0005\u0012\u00030µ\u0001\u0012\u0005\u0012\u00030¶\u0001\u0018\u00010´\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¼\u0001\u0010¸\u0001\"\u0006\b½\u0001\u0010º\u0001R\u0016\u0010¾\u0001\u001a\u00020\u00178@X\u0004¢\u0006\u0007\u001a\u0005\b¿\u0001\u0010SR'\u0010À\u0001\u001a\u0005\u0018\u00010µ\u00012\t\u0010/\u001a\u0005\u0018\u00010µ\u0001@BX\u000e¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u0019\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00008@X\u0004¢\u0006\b\u001a\u0006\bÄ\u0001\u0010\u0001R\u0019\u0010Å\u0001\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0016\u0010È\u0001\u001a\u00020\u000b8@X\u0004¢\u0006\u0007\u001a\u0005\bÉ\u0001\u00103R\u000f\u0010Ê\u0001\u001a\u00020eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bË\u0001\u00103\"\u0005\bÌ\u0001\u00105R\"\u0010Í\u0001\u001a\u0005\u0018\u00010Î\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R\u000f\u0010Ó\u0001\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R+\u0010Õ\u0001\u001a\u00030Ô\u00012\u0007\u00106\u001a\u00030Ô\u0001@VX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R\u000f\u0010Ú\u0001\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Û\u0001\u001a\u00020\u000b8VX\u0004¢\u0006\u0007\u001a\u0005\bÜ\u0001\u00103R\u0018\u0010Ý\u0001\u001a\u00030Þ\u00018BX\u0004¢\u0006\b\u001a\u0006\bß\u0001\u0010à\u0001R#\u0010á\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0004¢\u0006\u000e\u0012\u0005\bâ\u0001\u0010\u001f\u001a\u0005\bã\u0001\u0010\u0010R\u000f\u0010ä\u0001\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006å\u0002"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/InteroperableComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "(ZI)V", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_collapsedSemantics", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "_foldedParent", "_innerLayerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "_unfoldedChildren", "_zSortedChildren", "alignmentLinesRequired", "getAlignmentLinesRequired$ui_release", "()Z", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "()V", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "(Z)V", "childLookaheadMeasurables", "", "Landroidx/compose/ui/layout/Measurable;", "getChildLookaheadMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getChildMeasurables$ui_release", "children", "getChildren$ui_release", "collapsedSemantics", "getCollapsedSemantics$ui_release", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "<set-?>", "compositeKeyHash", "getCompositeKeyHash$annotations", "getCompositeKeyHash", "()I", "setCompositeKeyHash", "(I)V", "value", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "getDepth$ui_release", "setDepth$ui_release", "foldedChildren", "getFoldedChildren$ui_release", "hasFixedInnerContentConstraints", "getHasFixedInnerContentConstraints$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerCoordinator", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinator", "getInnerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "getInteropViewFactoryHolder$ui_release", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui_release", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getIntrinsicsPolicy$ui_release", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "isAttached", "isDeactivated", "isPlaced", "isPlacedByParent", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "isValidOwnerScope", "isVirtualLookaheadRoot", "isVirtualLookaheadRoot$ui_release", "setVirtualLookaheadRoot$ui_release", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutPending", "getLayoutPending$ui_release", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "newRoot", "lookaheadRoot", "getLookaheadRoot$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "setLookaheadRoot", "(Landroidx/compose/ui/node/LayoutNode;)V", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measuredByParent", "getMeasuredByParent$ui_release", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui_release", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "outerCoordinator", "getOuterCoordinator$ui_release", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "placeOrder", "getPlaceOrder$ui_release", "previousIntrinsicsUsageByParent", "getSemanticsId", "setSemanticsId", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "unfoldedVirtualChildrenListDirty", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "zIndex", "", "getZIndex", "()F", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "attach", "attach$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreePlacementIntrinsicsUsage", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "draw$ui_release", "forEachChild", "block", "forEachChildIndexed", "Lkotlin/Function2;", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinator$ui_release", "forEachCoordinatorIncludingInner", "forEachCoordinatorIncludingInner$ui_release", "forceRemeasure", "getInteropView", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsEntities", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateFocusOnAttach", "invalidateFocusOnDetach", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateMeasurements", "invalidateMeasurements$ui_release", "invalidateParentData", "invalidateParentData$ui_release", "invalidateSemantics", "invalidateSemantics$ui_release", "invalidateSubtree", "isRootOfInvalidation", "invalidateUnfoldedVirtualChildren", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui_release", "lookaheadReplace", "lookaheadReplace$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "move", "from", "to", "count", "move$ui_release", "onChildRemoved", "child", "onDeactivate", "onDensityOrLayoutDirectionChanged", "onLayoutComplete", "onRelease", "onReuse", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui_release", "place", "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestLookaheadRelayout", "forceRequest", "requestLookaheadRelayout$ui_release", "requestLookaheadRemeasure", "scheduleMeasureAndLayout", "requestLookaheadRemeasure$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui_release", "resetModifierState", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "shouldInvalidateParentLayer", "toString", "updateChildrenIfDirty", "updateChildrenIfDirty$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, InteroperableComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Function0<LayoutNode> Constructor = LayoutNode$Companion$Constructor$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final ViewConfiguration DummyViewConfiguration = new LayoutNode$Companion$DummyViewConfiguration$1();
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new LayoutNode$Companion$ErrorMeasurePolicy$1();
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final Comparator<LayoutNode> ZComparator = new LayoutNode$$ExternalSyntheticLambda0();
    private SemanticsConfiguration _collapsedSemantics;
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private NodeCoordinator _innerLayerCoordinator;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    private int compositeKeyHash;
    private CompositionLocalMap compositionLocalMap;
    private Density density;
    private int depth;
    /* access modifiers changed from: private */
    public boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private AndroidViewHolder interopViewFactoryHolder;
    private final IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private boolean isDeactivated;
    private final boolean isVirtual;
    private boolean isVirtualLookaheadRoot;
    private final LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private LayoutNode lookaheadRoot;
    private MeasurePolicy measurePolicy;
    private Modifier modifier;
    private boolean needsOnPositionedDispatch;
    private final NodeChain nodes;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private Owner owner;
    private UsageByParent previousIntrinsicsUsageByParent;
    private int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private boolean zSortedChildrenInvalidated;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutNode() {
        this(false, 0, 3, (DefaultConstructorMarker) null);
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    public static /* synthetic */ void getCompositeKeyHash$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public LayoutNode(boolean z, int i) {
        this.isVirtual = z;
        this.semanticsId = i;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new LayoutNode$_foldedChildren$1(this));
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        this.density = LayoutNodeKt.DefaultDensity;
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.compositionLocalMap = CompositionLocalMap.Companion.getEmpty();
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        this.previousIntrinsicsUsageByParent = UsageByParent.NotUsed;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this.modifier = Modifier.Companion;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNode(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? SemanticsModifierKt.generateSemanticsId() : i);
    }

    public int getSemanticsId() {
        return this.semanticsId;
    }

    public void setSemanticsId(int i) {
        this.semanticsId = i;
    }

    public int getCompositeKeyHash() {
        return this.compositeKeyHash;
    }

    public void setCompositeKeyHash(int i) {
        this.compositeKeyHash = i;
    }

    public final boolean isVirtualLookaheadRoot$ui_release() {
        return this.isVirtualLookaheadRoot;
    }

    public final void setVirtualLookaheadRoot$ui_release(boolean z) {
        this.isVirtualLookaheadRoot = z;
    }

    public final LayoutNode getLookaheadRoot$ui_release() {
        return this.lookaheadRoot;
    }

    private final void setLookaheadRoot(LayoutNode layoutNode) {
        if (!Intrinsics.areEqual((Object) layoutNode, (Object) this.lookaheadRoot)) {
            this.lookaheadRoot = layoutNode;
            if (layoutNode != null) {
                this.layoutDelegate.ensureLookaheadDelegateCreated$ui_release();
                NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
                NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
                while (!Intrinsics.areEqual((Object) outerCoordinator$ui_release, (Object) wrapped$ui_release) && outerCoordinator$ui_release != null) {
                    outerCoordinator$ui_release.ensureLookaheadDelegateCreated();
                    outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release();
                }
            }
            invalidateMeasurements$ui_release();
        }
    }

    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            return Boolean.valueOf(lookaheadPassDelegate$ui_release.isPlaced());
        }
        return null;
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            int i = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                mutableVector = new MutableVector<>(new LayoutNode[16], 0);
                this._unfoldedChildren = mutableVector;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                Object[] content = vector.getContent();
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    if (layoutNode.isVirtual) {
                        mutableVector.addAll(mutableVector.getSize(), layoutNode.get_children$ui_release());
                    } else {
                        mutableVector.add(layoutNode);
                    }
                    i++;
                } while (i < size);
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.getChildDelegates$ui_release();
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode layoutNode;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (this.isVirtual && (layoutNode = this._foldedParent) != null) {
            layoutNode.invalidateUnfoldedVirtualChildren();
        }
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    public final void forEachChild(Function1<? super LayoutNode, Unit> function1) {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                function1.invoke(content[i]);
                i++;
            } while (i < size);
        }
    }

    public final void forEachChildIndexed(Function2<? super Integer, ? super LayoutNode, Unit> function2) {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                function2.invoke(Integer.valueOf(i), content[i]);
                i++;
            } while (i < size);
        }
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        while (layoutNode != null && layoutNode.isVirtual) {
            layoutNode = layoutNode._foldedParent;
        }
        return layoutNode;
    }

    public final Owner getOwner$ui_release() {
        return this.owner;
    }

    public final AndroidViewHolder getInteropViewFactoryHolder$ui_release() {
        return this.interopViewFactoryHolder;
    }

    public final void setInteropViewFactoryHolder$ui_release(AndroidViewHolder androidViewHolder) {
        this.interopViewFactoryHolder = androidViewHolder;
    }

    public View getInteropView() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            return androidViewHolder.getInteropView();
        }
        return null;
    }

    public boolean isAttached() {
        return this.owner != null;
    }

    public final int getDepth$ui_release() {
        return this.depth;
    }

    public final void setDepth$ui_release(int i) {
        this.depth = i;
    }

    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    public final LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    public final LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    public final void insertAt$ui_release(int i, LayoutNode layoutNode) {
        String str = null;
        if (layoutNode._foldedParent != null) {
            StringBuilder sb = new StringBuilder("Cannot insert ");
            sb.append(layoutNode);
            sb.append(" because it already has a parent. This tree: ");
            sb.append(debugTreeToString$default(this, 0, 1, (Object) null));
            sb.append(" Other tree: ");
            LayoutNode layoutNode2 = layoutNode._foldedParent;
            if (layoutNode2 != null) {
                str = debugTreeToString$default(layoutNode2, 0, 1, (Object) null);
            }
            sb.append(str);
            throw new IllegalStateException(sb.toString().toString());
        } else if (layoutNode.owner == null) {
            layoutNode._foldedParent = this;
            this._foldedChildren.add(i, layoutNode);
            onZSortedChildrenInvalidated$ui_release();
            if (layoutNode.isVirtual) {
                this.virtualChildrenCount++;
            }
            invalidateUnfoldedVirtualChildren();
            Owner owner2 = this.owner;
            if (owner2 != null) {
                layoutNode.attach$ui_release(owner2);
            }
            if (layoutNode.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
                layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() + 1);
            }
        } else {
            throw new IllegalStateException(("Cannot insert " + layoutNode + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, (Object) null) + " Other tree: " + debugTreeToString$default(layoutNode, 0, 1, (Object) null)).toString());
        }
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (this.isVirtual) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                return;
            }
            return;
        }
        this.zSortedChildrenInvalidated = true;
    }

    public final void removeAt$ui_release(int i, int i2) {
        if (i2 >= 0) {
            int i3 = (i2 + i) - 1;
            if (i <= i3) {
                while (true) {
                    onChildRemoved(this._foldedChildren.removeAt(i3));
                    if (i3 != i) {
                        i3--;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException(("count (" + i2 + ") must be greater than 0").toString());
        }
    }

    public final void removeAll$ui_release() {
        int size = this._foldedChildren.getSize();
        while (true) {
            size--;
            if (-1 < size) {
                onChildRemoved(this._foldedChildren.get(size));
            } else {
                this._foldedChildren.clear();
                return;
            }
        }
    }

    private final void onChildRemoved(LayoutNode layoutNode) {
        if (layoutNode.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            layoutNode.detach$ui_release();
        }
        layoutNode._foldedParent = null;
        layoutNode.getOuterCoordinator$ui_release().setWrappedBy$ui_release((NodeCoordinator) null);
        if (layoutNode.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector<LayoutNode> vector = layoutNode._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                Object[] content = vector.getContent();
                int i = 0;
                do {
                    ((LayoutNode) content[i]).getOuterCoordinator$ui_release().setWrappedBy$ui_release((NodeCoordinator) null);
                    i++;
                } while (i < size);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    public final void move$ui_release(int i, int i2, int i3) {
        if (i != i2) {
            for (int i4 = 0; i4 < i3; i4++) {
                this._foldedChildren.add(i > i2 ? i2 + i4 : (i2 + i3) - 2, this._foldedChildren.removeAt(i > i2 ? i + i4 : i));
            }
            onZSortedChildrenInvalidated$ui_release();
            invalidateUnfoldedVirtualChildren();
            invalidateMeasurements$ui_release();
        }
    }

    public final void invalidateSemantics$ui_release() {
        this._collapsedSemantics = null;
        LayoutNodeKt.requireOwner(this).onSemanticsChange();
    }

    public final SemanticsConfiguration getCollapsedSemantics$ui_release() {
        if (!this.nodes.m5597hasH91voCI$ui_release(NodeKind.m5647constructorimpl(8)) || this._collapsedSemantics != null) {
            return this._collapsedSemantics;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new SemanticsConfiguration();
        LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeSemanticsReads$ui_release(this, new LayoutNode$collapsedSemantics$1(this, objectRef));
        this._collapsedSemantics = (SemanticsConfiguration) objectRef.element;
        return (SemanticsConfiguration) objectRef.element;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [androidx.compose.ui.node.NodeCoordinator] */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void attach$ui_release(androidx.compose.ui.node.Owner r7) {
        /*
            r6 = this;
            androidx.compose.ui.node.Owner r0 = r6.owner
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x011f
            androidx.compose.ui.node.LayoutNode r0 = r6._foldedParent
            if (r0 == 0) goto L_0x005e
            if (r0 == 0) goto L_0x0010
            androidx.compose.ui.node.Owner r0 = r0.owner
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            if (r0 == 0) goto L_0x0018
            goto L_0x005e
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Attaching to a different owner("
            r0.<init>(r4)
            r0.append(r7)
            java.lang.String r7 = ") than the parent's owner("
            r0.append(r7)
            androidx.compose.ui.node.LayoutNode r7 = r6.getParent$ui_release()
            if (r7 == 0) goto L_0x0030
            androidx.compose.ui.node.Owner r7 = r7.owner
            goto L_0x0031
        L_0x0030:
            r7 = r2
        L_0x0031:
            r0.append(r7)
            java.lang.String r7 = "). This tree: "
            r0.append(r7)
            java.lang.String r7 = debugTreeToString$default(r6, r1, r3, r2)
            r0.append(r7)
            java.lang.String r7 = " Parent tree: "
            r0.append(r7)
            androidx.compose.ui.node.LayoutNode r7 = r6._foldedParent
            if (r7 == 0) goto L_0x004d
            java.lang.String r2 = debugTreeToString$default(r7, r1, r3, r2)
        L_0x004d:
            r0.append(r2)
            java.lang.String r7 = r0.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        L_0x005e:
            androidx.compose.ui.node.LayoutNode r0 = r6.getParent$ui_release()
            if (r0 != 0) goto L_0x0074
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate r4 = r6.getMeasurePassDelegate$ui_release()
            r4.setPlaced$ui_release(r3)
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate r4 = r6.getLookaheadPassDelegate$ui_release()
            if (r4 == 0) goto L_0x0074
            r4.setPlaced(r3)
        L_0x0074:
            androidx.compose.ui.node.NodeCoordinator r4 = r6.getOuterCoordinator$ui_release()
            if (r0 == 0) goto L_0x007e
            androidx.compose.ui.node.NodeCoordinator r2 = r0.getInnerCoordinator$ui_release()
        L_0x007e:
            r4.setWrappedBy$ui_release(r2)
            r6.owner = r7
            if (r0 == 0) goto L_0x0088
            int r2 = r0.depth
            goto L_0x0089
        L_0x0088:
            r2 = -1
        L_0x0089:
            int r2 = r2 + r3
            r6.depth = r2
            androidx.compose.ui.node.NodeChain r2 = r6.nodes
            r4 = 8
            int r4 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r4)
            boolean r2 = r2.m5597hasH91voCI$ui_release(r4)
            if (r2 == 0) goto L_0x009d
            r6.invalidateSemantics$ui_release()
        L_0x009d:
            r7.onAttach(r6)
            boolean r2 = r6.isVirtualLookaheadRoot
            if (r2 == 0) goto L_0x00a8
            r6.setLookaheadRoot(r6)
            goto L_0x00b5
        L_0x00a8:
            androidx.compose.ui.node.LayoutNode r2 = r6._foldedParent
            if (r2 == 0) goto L_0x00b0
            androidx.compose.ui.node.LayoutNode r2 = r2.lookaheadRoot
            if (r2 != 0) goto L_0x00b2
        L_0x00b0:
            androidx.compose.ui.node.LayoutNode r2 = r6.lookaheadRoot
        L_0x00b2:
            r6.setLookaheadRoot(r2)
        L_0x00b5:
            boolean r2 = r6.isDeactivated()
            if (r2 != 0) goto L_0x00c0
            androidx.compose.ui.node.NodeChain r2 = r6.nodes
            r2.markAsAttached()
        L_0x00c0:
            androidx.compose.ui.node.MutableVectorWithMutationTracking<androidx.compose.ui.node.LayoutNode> r2 = r6._foldedChildren
            androidx.compose.runtime.collection.MutableVector r2 = r2.getVector()
            int r4 = r2.getSize()
            if (r4 <= 0) goto L_0x00da
            java.lang.Object[] r2 = r2.getContent()
        L_0x00d0:
            r5 = r2[r1]
            androidx.compose.ui.node.LayoutNode r5 = (androidx.compose.ui.node.LayoutNode) r5
            r5.attach$ui_release(r7)
            int r1 = r1 + r3
            if (r1 < r4) goto L_0x00d0
        L_0x00da:
            boolean r1 = r6.isDeactivated()
            if (r1 != 0) goto L_0x00e5
            androidx.compose.ui.node.NodeChain r1 = r6.nodes
            r1.runAttachLifecycle()
        L_0x00e5:
            r6.invalidateMeasurements$ui_release()
            if (r0 == 0) goto L_0x00ed
            r0.invalidateMeasurements$ui_release()
        L_0x00ed:
            androidx.compose.ui.node.NodeCoordinator r0 = r6.getOuterCoordinator$ui_release()
            androidx.compose.ui.node.NodeCoordinator r1 = r6.getInnerCoordinator$ui_release()
            androidx.compose.ui.node.NodeCoordinator r1 = r1.getWrapped$ui_release()
        L_0x00f9:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r2 != 0) goto L_0x0109
            if (r0 == 0) goto L_0x0109
            r0.onLayoutNodeAttach()
            androidx.compose.ui.node.NodeCoordinator r0 = r0.getWrapped$ui_release()
            goto L_0x00f9
        L_0x0109:
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.node.Owner, kotlin.Unit> r0 = r6.onAttach
            if (r0 == 0) goto L_0x0110
            r0.invoke(r7)
        L_0x0110:
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r7 = r6.layoutDelegate
            r7.updateParentData()
            boolean r7 = r6.isDeactivated()
            if (r7 != 0) goto L_0x011e
            r6.invalidateFocusOnAttach()
        L_0x011e:
            return
        L_0x011f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Cannot attach "
            r7.<init>(r0)
            r7.append(r6)
            java.lang.String r0 = " as it already is attached.  Tree: "
            r7.append(r0)
            java.lang.String r0 = debugTreeToString$default(r6, r1, r3, r2)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.attach$ui_release(androidx.compose.ui.node.Owner):void");
    }

    public final void detach$ui_release() {
        Owner owner2 = this.owner;
        String str = null;
        if (owner2 == null) {
            StringBuilder sb = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                str = debugTreeToString$default(parent$ui_release, 0, 1, (Object) null);
            }
            sb.append(str);
            throw new IllegalStateException(sb.toString().toString());
        }
        invalidateFocusOnDetach();
        LayoutNode parent$ui_release2 = getParent$ui_release();
        if (parent$ui_release2 != null) {
            parent$ui_release2.invalidateLayer$ui_release();
            parent$ui_release2.invalidateMeasurements$ui_release();
            getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(UsageByParent.NotUsed);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(UsageByParent.NotUsed);
            }
        }
        this.layoutDelegate.resetAlignmentLines();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner2);
        }
        if (this.nodes.m5597hasH91voCI$ui_release(NodeKind.m5647constructorimpl(8))) {
            invalidateSemantics$ui_release();
        }
        this.nodes.runDetachLifecycle$ui_release();
        this.ignoreRemeasureRequests = true;
        MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
        int size = vector.getSize();
        if (size > 0) {
            Object[] content = vector.getContent();
            int i = 0;
            do {
                ((LayoutNode) content[i]).detach$ui_release();
                i++;
            } while (i < size);
        }
        this.ignoreRemeasureRequests = false;
        this.nodes.markAsDetached$ui_release();
        owner2.onDetach(this);
        this.owner = null;
        setLookaheadRoot((LayoutNode) null);
        this.depth = 0;
        getMeasurePassDelegate$ui_release().onNodeDetached();
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release2 = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release2 != null) {
            lookaheadPassDelegate$ui_release2.onNodeDetached();
        }
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
            mutableVector.addAll(mutableVector.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    public boolean isValidOwnerScope() {
        return isAttached();
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, (String) null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    public final boolean getHasFixedInnerContentConstraints$ui_release() {
        long r0 = getInnerCoordinator$ui_release().m5618getLastMeasurementConstraintsmsEJaDk$ui_release();
        return Constraints.m6524getHasFixedWidthimpl(r0) && Constraints.m6523getHasFixedHeightimpl(r0);
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    private final String debugTreeToString(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append(10);
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i3 = 0;
            do {
                sb.append(((LayoutNode) content[i3]).debugTreeToString(i + 1));
                i3++;
            } while (i3 < size);
        }
        String sb2 = sb.toString();
        if (i != 0) {
            return sb2;
        }
        String substring = sb2.substring(0, sb2.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        public static final int $stable = 0;
        private final String error;

        public NoIntrinsicsMeasurePolicy(String str) {
            this.error = str;
        }

        public Void minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        public Void minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        public Void maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        public Void maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }
    }

    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    public void setMeasurePolicy(MeasurePolicy measurePolicy2) {
        if (!Intrinsics.areEqual((Object) this.measurePolicy, (Object) measurePolicy2)) {
            this.measurePolicy = measurePolicy2;
            this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
            invalidateMeasurements$ui_release();
        }
    }

    public final IntrinsicsPolicy getIntrinsicsPolicy$ui_release() {
        return this.intrinsicsPolicy;
    }

    public Density getDensity() {
        return this.density;
    }

    public void setDensity(Density density2) {
        if (!Intrinsics.areEqual((Object) this.density, (Object) density2)) {
            this.density = density2;
            onDensityOrLayoutDirectionChanged();
            NodeChain nodeChain = this.nodes;
            int r1 = NodeKind.m5647constructorimpl(16);
            if ((nodeChain.getAggregateChildKindSet() & r1) != 0) {
                Modifier.Node head$ui_release = nodeChain.getHead$ui_release();
                while (head$ui_release != null) {
                    if ((head$ui_release.getKindSet$ui_release() & r1) != 0) {
                        Modifier.Node node = head$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof PointerInputModifierNode) {
                                ((PointerInputModifierNode) node).onDensityChange();
                            } else if ((node.getKindSet$ui_release() & r1) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if ((head$ui_release.getAggregateChildKindSet$ui_release() & r1) != 0) {
                        head$ui_release = head$ui_release.getChild$ui_release();
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public void setLayoutDirection(LayoutDirection layoutDirection2) {
        if (this.layoutDirection != layoutDirection2) {
            this.layoutDirection = layoutDirection2;
            onDensityOrLayoutDirectionChanged();
        }
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public void setViewConfiguration(ViewConfiguration viewConfiguration2) {
        if (!Intrinsics.areEqual((Object) this.viewConfiguration, (Object) viewConfiguration2)) {
            this.viewConfiguration = viewConfiguration2;
            NodeChain nodeChain = this.nodes;
            int r1 = NodeKind.m5647constructorimpl(16);
            if ((nodeChain.getAggregateChildKindSet() & r1) != 0) {
                Modifier.Node head$ui_release = nodeChain.getHead$ui_release();
                while (head$ui_release != null) {
                    if ((head$ui_release.getKindSet$ui_release() & r1) != 0) {
                        Modifier.Node node = head$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof PointerInputModifierNode) {
                                ((PointerInputModifierNode) node).onViewConfigurationChange();
                            } else if ((node.getKindSet$ui_release() & r1) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if ((head$ui_release.getAggregateChildKindSet$ui_release() & r1) != 0) {
                        head$ui_release = head$ui_release.getChild$ui_release();
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public CompositionLocalMap getCompositionLocalMap() {
        return this.compositionLocalMap;
    }

    public void setCompositionLocalMap(CompositionLocalMap compositionLocalMap2) {
        this.compositionLocalMap = compositionLocalMap2;
        setDensity((Density) compositionLocalMap2.get(CompositionLocalsKt.getLocalDensity()));
        setLayoutDirection((LayoutDirection) compositionLocalMap2.get(CompositionLocalsKt.getLocalLayoutDirection()));
        setViewConfiguration((ViewConfiguration) compositionLocalMap2.get(CompositionLocalsKt.getLocalViewConfiguration()));
        NodeChain nodeChain = this.nodes;
        int r0 = NodeKind.m5647constructorimpl(32768);
        if ((nodeChain.getAggregateChildKindSet() & r0) != 0) {
            Modifier.Node head$ui_release = nodeChain.getHead$ui_release();
            while (head$ui_release != null) {
                if ((head$ui_release.getKindSet$ui_release() & r0) != 0) {
                    Modifier.Node node = head$ui_release;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof CompositionLocalConsumerModifierNode) {
                            Modifier.Node node2 = ((CompositionLocalConsumerModifierNode) node).getNode();
                            if (node2.isAttached()) {
                                NodeKindKt.autoInvalidateUpdatedNode(node2);
                            } else {
                                node2.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                            }
                        } else if ((node.getKindSet$ui_release() & r0) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & r0) != 0) {
                    head$ui_release = head$ui_release.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    public final boolean getAlignmentLinesRequired$ui_release() {
        AlignmentLines alignmentLines;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (layoutNodeLayoutDelegate.getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release()) {
            return true;
        }
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = layoutNodeLayoutDelegate.getLookaheadAlignmentLinesOwner$ui_release();
        if (lookaheadAlignmentLinesOwner$ui_release == null || (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) == null || !alignmentLines.getRequired$ui_release()) {
            return false;
        }
        return true;
    }

    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    public boolean isPlaced() {
        return getMeasurePassDelegate$ui_release().isPlaced();
    }

    public final boolean isPlacedByParent() {
        return getMeasurePassDelegate$ui_release().isPlacedByParent();
    }

    public final int getPlaceOrder$ui_release() {
        return getMeasurePassDelegate$ui_release().getPlaceOrder$ui_release();
    }

    public final UsageByParent getMeasuredByParent$ui_release() {
        return getMeasurePassDelegate$ui_release().getMeasuredByParent$ui_release();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getMeasuredByParent$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.node.LayoutNode.UsageByParent getMeasuredByParentInLookahead$ui_release() {
        /*
            r1 = this;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate r0 = r1.getLookaheadPassDelegate$ui_release()
            if (r0 == 0) goto L_0x000c
            androidx.compose.ui.node.LayoutNode$UsageByParent r0 = r0.getMeasuredByParent$ui_release()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            androidx.compose.ui.node.LayoutNode$UsageByParent r0 = androidx.compose.ui.node.LayoutNode.UsageByParent.NotUsed
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.getMeasuredByParentInLookahead$ui_release():androidx.compose.ui.node.LayoutNode$UsageByParent");
    }

    public final UsageByParent getIntrinsicsUsageByParent$ui_release() {
        return this.intrinsicsUsageByParent;
    }

    public final void setIntrinsicsUsageByParent$ui_release(UsageByParent usageByParent) {
        this.intrinsicsUsageByParent = usageByParent;
    }

    public final boolean getCanMultiMeasure$ui_release() {
        return this.canMultiMeasure;
    }

    public final void setCanMultiMeasure$ui_release(boolean z) {
        this.canMultiMeasure = z;
    }

    public final NodeChain getNodes$ui_release() {
        return this.nodes;
    }

    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator$ui_release();
    }

    public final LayoutNodeLayoutDelegate getLayoutDelegate$ui_release() {
        return this.layoutDelegate;
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator$ui_release();
    }

    private final float getZIndex() {
        return getMeasurePassDelegate$ui_release().getZIndex$ui_release();
    }

    public final LayoutNodeSubcompositionsState getSubcompositionsState$ui_release() {
        return this.subcompositionsState;
    }

    public final void setSubcompositionsState$ui_release(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    public final boolean getInnerLayerCoordinatorIsDirty$ui_release() {
        return this.innerLayerCoordinatorIsDirty;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean z) {
        this.innerLayerCoordinatorIsDirty = z;
    }

    private final NodeCoordinator getInnerLayerCoordinator() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
            NodeCoordinator wrappedBy$ui_release = getOuterCoordinator$ui_release().getWrappedBy$ui_release();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual((Object) innerCoordinator$ui_release, (Object) wrappedBy$ui_release)) {
                    break;
                }
                if ((innerCoordinator$ui_release != null ? innerCoordinator$ui_release.getLayer() : null) != null) {
                    this._innerLayerCoordinator = innerCoordinator$ui_release;
                    break;
                }
                innerCoordinator$ui_release = innerCoordinator$ui_release != null ? innerCoordinator$ui_release.getWrappedBy$ui_release() : null;
            }
        }
        NodeCoordinator nodeCoordinator = this._innerLayerCoordinator;
        if (nodeCoordinator == null || nodeCoordinator.getLayer() != null) {
            return nodeCoordinator;
        }
        throw new IllegalStateException("layer was not set".toString());
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    public void setModifier(Modifier modifier2) {
        if (this.isVirtual && getModifier() != Modifier.Companion) {
            throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
        } else if (!isDeactivated()) {
            this.modifier = modifier2;
            this.nodes.updateFrom$ui_release(modifier2);
            this.layoutDelegate.updateParentData();
            if (this.nodes.m5597hasH91voCI$ui_release(NodeKind.m5647constructorimpl(512)) && this.lookaheadRoot == null) {
                setLookaheadRoot(this);
            }
        } else {
            throw new IllegalArgumentException("modifier is updated when deactivated".toString());
        }
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui_release();
    }

    public final void invalidateParentData$ui_release() {
        this.layoutDelegate.invalidateParentData();
    }

    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    public final void setOnAttach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    public final void setOnDetach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    public final boolean getNeedsOnPositionedDispatch$ui_release() {
        return this.needsOnPositionedDispatch;
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z) {
        this.needsOnPositionedDispatch = z;
    }

    public final void place$ui_release(int i, int i2) {
        Placeable.PlacementScope placementScope;
        NodeCoordinator innerCoordinator$ui_release;
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release == null || (innerCoordinator$ui_release = parent$ui_release.getInnerCoordinator$ui_release()) == null || (placementScope = innerCoordinator$ui_release.getPlacementScope()) == null) {
            placementScope = LayoutNodeKt.requireOwner(this).getPlacementScope();
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, getMeasurePassDelegate$ui_release(), i, i2, 0.0f, 4, (Object) null);
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        getMeasurePassDelegate$ui_release().replace();
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        lookaheadPassDelegate$ui_release.replace();
    }

    public final void draw$ui_release(Canvas canvas) {
        getOuterCoordinator$ui_release().draw(canvas);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release$default  reason: not valid java name */
    public static /* synthetic */ void m5503hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = true;
        }
        layoutNode.m5507hitTestM_7yMNQ$ui_release(j, hitTestResult, z3, z2);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release  reason: not valid java name */
    public final void m5507hitTestM_7yMNQ$ui_release(long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        getOuterCoordinator$ui_release().m5623hitTestYqVAtuI(NodeCoordinator.Companion.getPointerInputSource(), getOuterCoordinator$ui_release().m5617fromParentPositionMKHz9U(j), hitTestResult, z, z2);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release$default  reason: not valid java name */
    public static /* synthetic */ void m5504hitTestSemanticsM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        layoutNode.m5508hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release  reason: not valid java name */
    public final void m5508hitTestSemanticsM_7yMNQ$ui_release(long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        getOuterCoordinator$ui_release().m5623hitTestYqVAtuI(NodeCoordinator.Companion.getSemanticsSource(), getOuterCoordinator$ui_release().m5617fromParentPositionMKHz9U(j), hitTestResult, true, z2);
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(LayoutNode layoutNode) {
        if (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + layoutNode.getLayoutState$ui_release());
        } else if (layoutNode.getLookaheadMeasurePending$ui_release()) {
            requestLookaheadRemeasure$ui_release$default(layoutNode, true, false, 2, (Object) null);
        } else {
            if (layoutNode.getLookaheadLayoutPending$ui_release()) {
                layoutNode.requestLookaheadRelayout$ui_release(true);
            }
            if (layoutNode.getMeasurePending$ui_release()) {
                requestRemeasure$ui_release$default(layoutNode, true, false, 2, (Object) null);
            } else if (layoutNode.getLayoutPending$ui_release()) {
                layoutNode.requestRelayout$ui_release(true);
            }
        }
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        layoutNode.requestRemeasure$ui_release(z, z2);
    }

    public final void requestRemeasure$ui_release(boolean z, boolean z2) {
        Owner owner2;
        if (!this.ignoreRemeasureRequests && !this.isVirtual && (owner2 = this.owner) != null) {
            Owner.CC.onRequestMeasure$default(owner2, this, false, z, z2, 2, (Object) null);
            getMeasurePassDelegate$ui_release().invalidateIntrinsicsParent(z);
        }
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(z, z2);
    }

    public final void requestLookaheadRemeasure$ui_release(boolean z, boolean z2) {
        if (this.lookaheadRoot != null) {
            Owner owner2 = this.owner;
            if (owner2 != null && !this.ignoreRemeasureRequests && !this.isVirtual) {
                owner2.onRequestMeasure(this, true, z, z2);
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                lookaheadPassDelegate$ui_release.invalidateIntrinsicsParent(z);
                return;
            }
            return;
        }
        throw new IllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadScope".toString());
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, 3, (Object) null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, 3, (Object) null);
        }
    }

    private final void invalidateFocusOnAttach() {
        if (this.nodes.has$ui_release(NodeKind.m5647constructorimpl(1024) | NodeKind.m5647constructorimpl(2048) | NodeKind.m5647constructorimpl(4096))) {
            for (Modifier.Node head$ui_release = this.nodes.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                boolean z = true;
                boolean z2 = ((NodeKind.m5647constructorimpl(1024) & head$ui_release.getKindSet$ui_release()) != 0) | ((NodeKind.m5647constructorimpl(2048) & head$ui_release.getKindSet$ui_release()) != 0);
                if ((NodeKind.m5647constructorimpl(4096) & head$ui_release.getKindSet$ui_release()) == 0) {
                    z = false;
                }
                if (z2 || z) {
                    NodeKindKt.autoInvalidateInsertedNode(head$ui_release);
                }
            }
        }
    }

    private final void invalidateFocusOnDetach() {
        NodeChain nodeChain = this.nodes;
        int r1 = NodeKind.m5647constructorimpl(1024);
        if ((nodeChain.getAggregateChildKindSet() & r1) != 0) {
            for (Modifier.Node tail$ui_release = nodeChain.getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                if ((tail$ui_release.getKindSet$ui_release() & r1) != 0) {
                    Modifier.Node node = tail$ui_release;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                            if (focusTargetNode.getFocusState().isFocused()) {
                                LayoutNodeKt.requireOwner(this).getFocusOwner().clearFocus(true, false);
                                focusTargetNode.scheduleInvalidationForFocusEvents$ui_release();
                            }
                        } else if ((node.getKindSet$ui_release() & r1) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
    }

    public final void ignoreRemeasureRequests$ui_release(Function0<Unit> function0) {
        this.ignoreRemeasureRequests = true;
        function0.invoke();
        this.ignoreRemeasureRequests = false;
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRelayout$ui_release(z);
    }

    public final void requestRelayout$ui_release(boolean z) {
        Owner owner2;
        if (!this.isVirtual && (owner2 = this.owner) != null) {
            Owner.CC.onRequestRelayout$default(owner2, this, false, z, 2, (Object) null);
        }
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRelayout$ui_release(z);
    }

    public final void requestLookaheadRelayout$ui_release(boolean z) {
        Owner owner2;
        if (!this.isVirtual && (owner2 = this.owner) != null) {
            owner2.onRequestRelayout(this, true, z);
        }
    }

    public final void dispatchOnPositionedCallbacks$ui_release() {
        if (getLayoutState$ui_release() == LayoutState.Idle && !getLayoutPending$ui_release() && !getMeasurePending$ui_release() && !isDeactivated() && isPlaced()) {
            NodeChain nodeChain = this.nodes;
            int r2 = NodeKind.m5647constructorimpl(256);
            if ((nodeChain.getAggregateChildKindSet() & r2) != 0) {
                Modifier.Node head$ui_release = nodeChain.getHead$ui_release();
                while (head$ui_release != null) {
                    if ((head$ui_release.getKindSet$ui_release() & r2) != 0) {
                        Modifier.Node node = head$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof GlobalPositionAwareModifierNode) {
                                GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) node;
                                globalPositionAwareModifierNode.onGloballyPositioned(DelegatableNodeKt.m5468requireCoordinator64DMado(globalPositionAwareModifierNode, NodeKind.m5647constructorimpl(256)));
                            } else if ((node.getKindSet$ui_release() & r2) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & r2) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if ((head$ui_release.getAggregateChildKindSet$ui_release() & r2) != 0) {
                        head$ui_release = head$ui_release.getChild$ui_release();
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default  reason: not valid java name */
    public static /* synthetic */ boolean m5505lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m5555getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m5509lookaheadRemeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release  reason: not valid java name */
    public final boolean m5509lookaheadRemeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints == null || this.lookaheadRoot == null) {
            return false;
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.m5560remeasureBRTryo0(constraints.m6532unboximpl());
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default  reason: not valid java name */
    public static /* synthetic */ boolean m5506remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m5554getLastConstraintsDWUhwKw();
        }
        return layoutNode.m5510remeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release  reason: not valid java name */
    public final boolean m5510remeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage$ui_release();
        }
        return getMeasurePassDelegate$ui_release().m5565remeasureBRTryo0(constraints.m6532unboximpl());
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public static /* synthetic */ void invalidateSubtree$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        layoutNode.invalidateSubtree(z);
    }

    public final void invalidateSubtree(boolean z) {
        LayoutNode parent$ui_release;
        if (z && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateSemantics$ui_release();
        requestRemeasure$ui_release$default(this, false, false, 3, (Object) null);
        NodeChain nodeChain = this.nodes;
        int r3 = NodeKind.m5647constructorimpl(2);
        if ((nodeChain.getAggregateChildKindSet() & r3) != 0) {
            for (Modifier.Node head$ui_release = nodeChain.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((head$ui_release.getKindSet$ui_release() & r3) != 0) {
                    Modifier.Node node = head$ui_release;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof LayoutModifierNode) {
                            OwnedLayer layer = DelegatableNodeKt.m5468requireCoordinator64DMado((LayoutModifierNode) node, NodeKind.m5647constructorimpl(2)).getLayer();
                            if (layer != null) {
                                layer.invalidate();
                            }
                        } else if ((node.getKindSet$ui_release() & r3) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r3) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & r3) == 0) {
                    break;
                }
            }
        }
        MutableVector<LayoutNode> mutableVector2 = get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            Object[] content = mutableVector2.getContent();
            int i2 = 0;
            do {
                ((LayoutNode) content[i2]).invalidateSubtree(false);
                i2++;
            } while (i2 < size);
        }
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    public void forceRemeasure() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, 1, (Object) null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, 1, (Object) null);
        }
        Constraints r0 = this.layoutDelegate.m5554getLastConstraintsDWUhwKw();
        if (r0 != null) {
            Owner owner2 = this.owner;
            if (owner2 != null) {
                owner2.m5706measureAndLayout0kLqBqw(this, r0.m6532unboximpl());
                return;
            }
            return;
        }
        Owner owner3 = this.owner;
        if (owner3 != null) {
            Owner.CC.measureAndLayout$default(owner3, false, 1, (Object) null);
        }
    }

    public void onLayoutComplete() {
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        int r1 = NodeKind.m5647constructorimpl(128);
        boolean r2 = NodeKindKt.m5656getIncludeSelfInTraversalH91voCI(r1);
        Modifier.Node tail = innerCoordinator$ui_release.getTail();
        if (r2 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = innerCoordinator$ui_release.headNode(r2);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r1) != 0) {
                if ((access$headNode.getKindSet$ui_release() & r1) != 0) {
                    Modifier.Node node = access$headNode;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof LayoutAwareModifierNode) {
                            ((LayoutAwareModifierNode) node).onPlaced(getInnerCoordinator$ui_release());
                        } else if ((node.getKindSet$ui_release() & r1) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final void forEachCoordinator$ui_release(Function1<? super LayoutModifierNodeCoordinator, Unit> function1) {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            function1.invoke(layoutModifierNodeCoordinator);
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
        }
    }

    public final void forEachCoordinatorIncludingInner$ui_release(Function1<? super NodeCoordinator, Unit> function1) {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) outerCoordinator$ui_release, (Object) wrapped$ui_release) && outerCoordinator$ui_release != null) {
            function1.invoke(outerCoordinator$ui_release);
            outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release();
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        if (this.nodes.m5597hasH91voCI$ui_release(NodeKind.m5647constructorimpl(4)) && !this.nodes.m5597hasH91voCI$ui_release(NodeKind.m5647constructorimpl(2))) {
            return true;
        }
        for (Modifier.Node head$ui_release = this.nodes.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            if ((NodeKind.m5647constructorimpl(2) & head$ui_release.getKindSet$ui_release()) != 0 && DelegatableNodeKt.m5468requireCoordinator64DMado(head$ui_release, NodeKind.m5647constructorimpl(2)).getLayer() != null) {
                return false;
            }
            if ((NodeKind.m5647constructorimpl(4) & head$ui_release.getKindSet$ui_release()) != 0) {
                return true;
            }
        }
        return true;
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i];
                if (layoutNode.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
                }
                i++;
            } while (i < size);
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i];
                if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.clearSubtreePlacementIntrinsicsUsage();
                }
                i++;
            } while (i < size);
        }
    }

    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    public boolean isDeactivated() {
        return this.isDeactivated;
    }

    public void onReuse() {
        if (isAttached()) {
            AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
            if (androidViewHolder != null) {
                androidViewHolder.onReuse();
            }
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
            if (layoutNodeSubcompositionsState != null) {
                layoutNodeSubcompositionsState.onReuse();
            }
            if (isDeactivated()) {
                this.isDeactivated = false;
                invalidateSemantics$ui_release();
            } else {
                resetModifierState();
            }
            setSemanticsId(SemanticsModifierKt.generateSemanticsId());
            this.nodes.markAsAttached();
            this.nodes.runAttachLifecycle();
            rescheduleRemeasureOrRelayout$ui_release(this);
            return;
        }
        throw new IllegalArgumentException("onReuse is only expected on attached node".toString());
    }

    public void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onDeactivate();
        }
        this.isDeactivated = true;
        resetModifierState();
        if (isAttached()) {
            invalidateSemantics$ui_release();
        }
    }

    public void onRelease() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onRelease();
        }
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) outerCoordinator$ui_release, (Object) wrapped$ui_release) && outerCoordinator$ui_release != null) {
            outerCoordinator$ui_release.onRelease();
            outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "ZComparator", "Ljava/util/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }

        public final Comparator<LayoutNode> getZComparator$ui_release() {
            return LayoutNode.ZComparator;
        }
    }

    /* access modifiers changed from: private */
    public static final int ZComparator$lambda$39(LayoutNode layoutNode, LayoutNode layoutNode2) {
        if (layoutNode.getZIndex() == layoutNode2.getZIndex()) {
            return Intrinsics.compare(layoutNode.getPlaceOrder$ui_release(), layoutNode2.getPlaceOrder$ui_release());
        }
        return Float.compare(layoutNode.getZIndex(), layoutNode2.getZIndex());
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            OwnedLayer layer = layoutModifierNodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
        }
        OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i];
                UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
                layoutNode.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                }
                i++;
            } while (i < size);
        }
    }
}
