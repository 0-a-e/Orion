package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.changelist.FixupList;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IntMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000ó\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b)*\u0001A\b\u0000\u0018\u00002\u00020\u0001:\u0004Õ\u0002Ö\u0002BG\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002JM\u0010\u0001\u001a\u00030\u0001\"\u0005\b\u0000\u0010\u0001\"\u0005\b\u0001\u0010\u00012\b\u0010\u0001\u001a\u0003H\u00012#\u0010\u0001\u001a\u001e\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u00030\u00010\u0001¢\u0006\u0003\b\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0005H\u0016J2\u0010\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u0007\u0010\u0001\u001a\u00020\u00182\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u0001H\b¢\u0006\u0003\u0010\u0001J\u0014\u0010 \u0001\u001a\u00020\u00182\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0017J\u0012\u0010 \u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u0018H\u0017J\u0013\u0010 \u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030¡\u0001H\u0017J\u0013\u0010 \u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030¢\u0001H\u0017J\u0013\u0010 \u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030£\u0001H\u0017J\u0013\u0010 \u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030¤\u0001H\u0017J\u0012\u0010 \u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u001cH\u0017J\u0013\u0010 \u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030¥\u0001H\u0017J\u0013\u0010 \u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030¦\u0001H\u0017J\u0014\u0010§\u0001\u001a\u00020\u00182\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0017J\u0010\u0010¨\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b©\u0001J\n\u0010ª\u0001\u001a\u00030\u0001H\u0002J\n\u0010«\u0001\u001a\u00030\u0001H\u0002J\n\u0010¬\u0001\u001a\u00030\u0001H\u0016JI\u0010­\u0001\u001a\u00030\u00012\u001d\u0010®\u0001\u001a\u0018\u0012\u0004\u0012\u000205\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020\u0018\u00010°\u00010¯\u00012\u0015\u0010±\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u00010\u0001¢\u0006\u0003\b²\u0001H\u0000¢\u0006\u0006\b³\u0001\u0010´\u0001J$\u0010µ\u0001\u001a\u00020\u001c2\u0007\u0010¶\u0001\u001a\u00020\u001c2\u0007\u0010·\u0001\u001a\u00020\u001c2\u0007\u0010¸\u0001\u001a\u00020\u001cH\u0002J(\u0010¹\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u000f\u0010º\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010»\u0001H\u0017¢\u0006\u0003\u0010¼\u0001J\n\u0010½\u0001\u001a\u00030\u0001H\u0002J\"\u0010¾\u0001\u001a\u00030\u0001\"\u0005\b\u0000\u0010\u00012\u000f\u0010¿\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u0001H\u0016J\t\u0010À\u0001\u001a\u00020kH\u0002J\u0012\u0010À\u0001\u001a\u00020k2\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0002J\u0010\u0010Á\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÂ\u0001J\u0013\u0010Ã\u0001\u001a\u00030\u00012\u0007\u0010 \u0001\u001a\u00020\u0018H\u0017J\n\u0010Ä\u0001\u001a\u00030\u0001H\u0016J\n\u0010Å\u0001\u001a\u00030\u0001H\u0016J\u0010\u0010Æ\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÇ\u0001JH\u0010È\u0001\u001a\u00030\u00012\u001d\u0010®\u0001\u001a\u0018\u0012\u0004\u0012\u000205\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020\u0018\u00010°\u00010¯\u00012\u0017\u0010±\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001¢\u0006\u0003\b²\u0001H\u0002¢\u0006\u0003\u0010´\u0001J\u001c\u0010É\u0001\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\u0007\u0010Ê\u0001\u001a\u00020\u001cH\u0002J\n\u0010Ë\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010Ì\u0001\u001a\u00030\u00012\u0007\u0010Í\u0001\u001a\u00020\u0018H\u0002J\n\u0010Î\u0001\u001a\u00030\u0001H\u0017J\n\u0010Ï\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ð\u0001\u001a\u00030\u0001H\u0017J\n\u0010Ñ\u0001\u001a\u00030\u0001H\u0016J\n\u0010Ò\u0001\u001a\u00030\u0001H\u0017J\n\u0010Ó\u0001\u001a\u00030\u0001H\u0017J\n\u0010Ô\u0001\u001a\u00030\u0001H\u0017J\f\u0010Õ\u0001\u001a\u0005\u0018\u00010Ö\u0001H\u0017J\n\u0010×\u0001\u001a\u00030\u0001H\u0016J\b\u0010Ø\u0001\u001a\u00030\u0001J\n\u0010Ù\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010Ú\u0001\u001a\u00030\u00012\u0007\u0010Û\u0001\u001a\u00020\u001cH\u0016J\n\u0010Ü\u0001\u001a\u00030\u0001H\u0002J\u001e\u0010Ý\u0001\u001a\u00030\u00012\u0007\u0010Í\u0001\u001a\u00020\u00182\t\u0010Þ\u0001\u001a\u0004\u0018\u00010mH\u0002J\u001b\u0010ß\u0001\u001a\u00030\u00012\u0007\u0010à\u0001\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u0018H\u0002J\n\u0010á\u0001\u001a\u00030\u0001H\u0002J\u000e\u0010E\u001a\u00020\u0018H\u0000¢\u0006\u0003\bâ\u0001J#\u0010ã\u0001\u001a\u00030\u00012\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030ä\u00012\t\u0010å\u0001\u001a\u0004\u0018\u00010H\u0017J+\u0010æ\u0001\u001a\u00030\u00012\u001f\u0010ç\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030ê\u0001\u0012\u0007\u0012\u0005\u0018\u00010ê\u00010é\u00010è\u0001H\u0002J+\u0010ë\u0001\u001a\u00030\u00012\u001f\u0010ç\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030ê\u0001\u0012\u0007\u0012\u0005\u0018\u00010ê\u00010é\u00010è\u0001H\u0017J\u0012\u0010ì\u0001\u001a\u00020\u001c2\u0007\u0010í\u0001\u001a\u00020\u001cH\u0002J9\u0010î\u0001\u001a\u00030\u00012\u0010\u0010±\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u000100ä\u00012\u0007\u0010ï\u0001\u001a\u00020k2\t\u0010å\u0001\u001a\u0004\u0018\u000102\u0007\u0010ð\u0001\u001a\u00020\u0018H\u0002J\u001f\u0010ñ\u0001\u001a\u000202\t\u0010ò\u0001\u001a\u0004\u0018\u000102\t\u0010ó\u0001\u001a\u0004\u0018\u00010H\u0017J\u000b\u0010ô\u0001\u001a\u0004\u0018\u00010H\u0001J\u000b\u0010õ\u0001\u001a\u0004\u0018\u00010H\u0001J-\u0010ö\u0001\u001a\u00020\u001c2\u0007\u0010÷\u0001\u001a\u00020\u001c2\u0007\u0010¶\u0001\u001a\u00020\u001c2\u0007\u0010·\u0001\u001a\u00020\u001c2\u0007\u0010ø\u0001\u001a\u00020\u001cH\u0002J\u000f\u0010ù\u0001\u001a\u00020\u001cH\u0001¢\u0006\u0003\bú\u0001J!\u0010û\u0001\u001a\u00030\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0000¢\u0006\u0003\bü\u0001J.\u0010ý\u0001\u001a\u00020\u00182\u001d\u0010®\u0001\u001a\u0018\u0012\u0004\u0012\u000205\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020\u0018\u00010°\u00010¯\u0001H\u0000¢\u0006\u0003\bþ\u0001Jv\u0010ÿ\u0001\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010í\u0001\u001a\u0004\u0018\u00010\u001c2%\b\u0002\u0010\\\u001a\u001f\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u000205\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020\u0018\u00010°\u00010é\u00010è\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020\u0001H\u0002¢\u0006\u0003\u0010\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020OH\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020kH\u0002J\u001b\u0010\u0002\u001a\u00030\u00012\u000f\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0016J%\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u001c2\u0007\u0010\u0002\u001a\u00020\u001c2\u0007\u0010\u0002\u001a\u00020\u001cH\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020{H\u0016J\u000b\u0010\u0002\u001a\u0004\u0018\u00010H\u0016J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u001cH\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0017J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0017J\u0014\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0002H\u0017J\n\u0010\u0002\u001a\u00030\u0001H\u0017J\u001d\u0010\u0002\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u00020\u001c2\b\u0010\u0002\u001a\u00030\u0002H\u0017J?\u0010\u0002\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u00020\u001c2\t\u0010\u0002\u001a\u0004\u0018\u000102\b\u0010 \u0002\u001a\u00030¡\u00022\t\u0010¢\u0002\u001a\u0004\u0018\u00010H\u0002ø\u0001\u0000¢\u0006\u0006\b£\u0002\u0010¤\u0002J\n\u0010¥\u0002\u001a\u00030\u0001H\u0017J\u0013\u0010¦\u0002\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u00020\u001cH\u0002J\u001e\u0010¦\u0002\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u00020\u001c2\t\u0010§\u0002\u001a\u0004\u0018\u00010H\u0002J\u001e\u0010¨\u0002\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u00020\u001c2\t\u0010§\u0002\u001a\u0004\u0018\u00010H\u0017J\n\u0010©\u0002\u001a\u00030\u0001H\u0016J\u0018\u0010ª\u0002\u001a\u00030\u00012\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030«\u0002H\u0017J'\u0010¬\u0002\u001a\u00030\u00012\u0015\u0010­\u0002\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030«\u00020®\u0002H\u0017¢\u0006\u0003\u0010¯\u0002J\u001e\u0010°\u0002\u001a\u00030\u00012\u0007\u0010Í\u0001\u001a\u00020\u00182\t\u0010¢\u0002\u001a\u0004\u0018\u00010H\u0002J\u0013\u0010±\u0002\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u00020\u001cH\u0017J\u0012\u0010²\u0002\u001a\u00020\u00012\u0007\u0010º\u0001\u001a\u00020\u001cH\u0017J\u001e\u0010³\u0002\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u00020\u001c2\t\u0010§\u0002\u001a\u0004\u0018\u00010H\u0016J\n\u0010´\u0002\u001a\u00030\u0001H\u0016J\b\u0010µ\u0002\u001a\u00030\u0001J\n\u0010¶\u0002\u001a\u00030\u0001H\u0002J#\u0010·\u0002\u001a\u00020\u00182\u0007\u0010\u0002\u001a\u0002052\t\u0010¸\u0002\u001a\u0004\u0018\u00010H\u0000¢\u0006\u0003\b¹\u0002J\u0015\u0010º\u0002\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0001J)\u0010»\u0002\u001a\u00030\u00012\u0007\u0010¼\u0002\u001a\u00020\u001c2\t\u0010§\u0002\u001a\u0004\u0018\u000102\t\u0010¢\u0002\u001a\u0004\u0018\u00010H\u0002J\u0013\u0010½\u0002\u001a\u00030\u00012\u0007\u0010¾\u0002\u001a\u00020\u001cH\u0002J)\u0010¿\u0002\u001a\u00030\u00012\u0007\u0010¼\u0002\u001a\u00020\u001c2\t\u0010§\u0002\u001a\u0004\u0018\u000102\t\u0010¢\u0002\u001a\u0004\u0018\u00010H\u0002J\u0013\u0010À\u0002\u001a\u00030\u00012\u0007\u0010¼\u0002\u001a\u00020\u001cH\u0002J\u001c\u0010Á\u0002\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\u0007\u0010Â\u0002\u001a\u00020\u001cH\u0002J\u001c\u0010Ã\u0002\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\u0007\u0010Ä\u0002\u001a\u00020\u001cH\u0002J\u001b\u0010Å\u0002\u001a\u00020k2\u0007\u0010Æ\u0002\u001a\u00020k2\u0007\u0010Ç\u0002\u001a\u00020kH\u0002J\u0015\u0010È\u0002\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0016J\u0015\u0010É\u0002\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0002J\u0015\u0010Ê\u0002\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0001J\u0012\u0010Ë\u0002\u001a\u00020\u001c2\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0002J\n\u0010Ì\u0002\u001a\u00030\u0001H\u0016J\n\u0010Í\u0002\u001a\u00030\u0001H\u0002J\n\u0010Î\u0002\u001a\u00030\u0001H\u0002J\u0010\u0010Ï\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÐ\u0002J1\u0010Ñ\u0002\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022\u0006\u0010t\u001a\u00020u2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020\u0001H\b¢\u0006\u0003\u0010Ò\u0002J\u0016\u0010Ó\u0002\u001a\u00020\u001c*\u00020u2\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0002J\u0018\u0010Ô\u0002\u001a\u0004\u0018\u00010*\u00020u2\u0007\u0010í\u0001\u001a\u00020\u001cH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148WX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R&\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c8\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010\u001eR\u0014\u0010.\u001a\u00020/8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u001eR\u0016\u00104\u001a\u0004\u0018\u0001058@X\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u00188VX\u0004¢\u0006\f\u0012\u0004\b9\u0010,\u001a\u0004\b:\u0010\u001aR\u001c\u0010;\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0010\u0010@\u001a\u00020AX\u0004¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020DX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010I\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bJ\u0010\u001aR\u0014\u0010K\u001a\u00020\u00188@X\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u001aR\u000e\u0010M\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR&\u0010W\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00188\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010,\u001a\u0004\bY\u0010\u001aR\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u0002050[X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010_\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u001aR\u001e\u0010a\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u001aR\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020DX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010mX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010m0[X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010p\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010qX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010t\u001a\u00020uX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0016\u0010z\u001a\u0004\u0018\u00010{8VX\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0018\u0010~\u001a\u0004\u0018\u000108VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020\u00188VX\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u0010,\u001a\u0005\b\u0001\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u0004\u0018\u00010*\u00020u8BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006×\u0002"}, d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "lateChanges", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "changeListWriter", "Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "childrenComposing", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionToken", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "()V", "getCompoundKeyHash", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "getCurrentMarker", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "deferredChanges", "getDeferredChanges$runtime_release", "()Landroidx/compose/runtime/changelist/ChangeList;", "setDeferredChanges$runtime_release", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "derivedStateObserver", "androidx/compose/runtime/ComposerImpl$derivedStateObserver$1", "Landroidx/compose/runtime/ComposerImpl$derivedStateObserver$1;", "entersStack", "Landroidx/compose/runtime/IntStack;", "forceRecomposeScopes", "forciblyRecompose", "groupNodeCount", "groupNodeCountStack", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "implicitRootStart", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "Landroidx/compose/runtime/changelist/FixupList;", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime_release", "(Landroidx/compose/runtime/SlotTable;)V", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "Landroidx/compose/runtime/Stack;", "invalidations", "", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Landroidx/collection/MutableIntIntMap;", "nodeExpected", "nodeIndex", "nodeIndexStack", "parentProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "providerCache", "providerUpdates", "Landroidx/compose/runtime/collection/IntMap;", "providersInvalid", "providersInvalidStack", "reader", "Landroidx/compose/runtime/SlotReader;", "getReader$runtime_release", "()Landroidx/compose/runtime/SlotReader;", "setReader$runtime_release", "(Landroidx/compose/runtime/SlotReader;)V", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "sourceInformationEnabled", "startedGroup", "startedGroups", "writer", "Landroidx/compose/runtime/SlotWriter;", "writerHasAProvider", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "", "addRecomposeScope", "apply", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "changedInstance", "changesApplied", "changesApplied$runtime_release", "cleanUpCompose", "clearUpdatedNodeCounts", "collectParameterInformation", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createFreshInsertTable", "createNode", "factory", "currentCompositionLocalScope", "deactivate", "deactivate$runtime_release", "deactivateToEndGroup", "disableReusing", "disableSourceInformation", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProvider", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endReuseFromRoot", "endRoot", "endToMarker", "marker", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "forceRecomposeScopes$runtime_release", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentGuarded", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentReferences", "insertedGroupVirtualIndex", "index", "invokeMovableContentLambda", "locals", "force", "joinKey", "left", "right", "nextSlot", "nextSlotForCache", "nodeIndexOf", "groupLocation", "recomposeIndex", "parentKey", "parentKey$runtime_release", "prepareCompose", "prepareCompose$runtime_release", "recompose", "recompose$runtime_release", "recomposeMovableContent", "R", "from", "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeToGroupEnd", "recordDelete", "recordInsert", "anchor", "recordProviderUpdate", "providers", "recordSideEffect", "effect", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "rememberedValue", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "start", "objectKey", "kind", "Landroidx/compose/runtime/GroupKind;", "data", "start-BaiHCIY", "(ILjava/lang/Object;ILjava/lang/Object;)V", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startReuseFromRoot", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "count", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateSlot", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "verifyConsistent", "verifyConsistent$runtime_release", "withReader", "(Landroidx/compose/runtime/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
public final class ComposerImpl implements Composer {
    public static final int $stable = 8;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    /* access modifiers changed from: private */
    public final ComposerChangeListWriter changeListWriter;
    private ChangeList changes;
    /* access modifiers changed from: private */
    public int childrenComposing;
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;
    private ChangeList deferredChanges;
    private final ComposerImpl$derivedStateObserver$1 derivedStateObserver = new ComposerImpl$derivedStateObserver$1(this);
    private final IntStack entersStack = new IntStack();
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private IntStack groupNodeCountStack = new IntStack();
    private boolean implicitRootStart;
    private Anchor insertAnchor;
    private FixupList insertFixups;
    private SlotTable insertTable;
    private boolean inserting;
    private final Stack<RecomposeScopeImpl> invalidateStack = new Stack<>();
    private final List<Invalidation> invalidations = new ArrayList();
    private boolean isComposing;
    private boolean isDisposed;
    private ChangeList lateChanges;
    /* access modifiers changed from: private */
    public int[] nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private IntStack nodeIndexStack = new IntStack();
    /* access modifiers changed from: private */
    public final CompositionContext parentContext;
    private PersistentCompositionLocalMap parentProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    private Pending pending;
    private final Stack<Pending> pendingStack = new Stack<>();
    private PersistentCompositionLocalMap providerCache;
    /* access modifiers changed from: private */
    public IntMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private final IntStack providersInvalidStack = new IntStack();
    private SlotReader reader;
    private boolean reusing;
    private int reusingGroup = -1;
    /* access modifiers changed from: private */
    public final SlotTable slotTable;
    private boolean sourceInformationEnabled;
    private boolean startedGroup;
    private final IntStack startedGroups;
    private SlotWriter writer;
    private boolean writerHasAProvider;

    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    private final int insertedGroupVirtualIndex(int i) {
        return -2 - i;
    }

    /* JADX INFO: finally extract failed */
    public ComposerImpl(Applier<?> applier2, CompositionContext compositionContext, SlotTable slotTable2, Set<RememberObserver> set, ChangeList changeList, ChangeList changeList2, ControlledComposition controlledComposition) {
        this.applier = applier2;
        this.parentContext = compositionContext;
        this.slotTable = slotTable2;
        this.abandonSet = set;
        this.changes = changeList;
        this.lateChanges = changeList2;
        this.composition = controlledComposition;
        SlotReader openReader = slotTable2.openReader();
        openReader.close();
        this.reader = openReader;
        SlotTable slotTable3 = new SlotTable();
        this.insertTable = slotTable3;
        SlotWriter openWriter = slotTable3.openWriter();
        openWriter.close();
        this.writer = openWriter;
        this.changeListWriter = new ComposerChangeListWriter(this, this.changes);
        SlotReader openReader2 = this.insertTable.openReader();
        try {
            Anchor anchor = openReader2.anchor(0);
            openReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new FixupList();
            this.implicitRootStart = true;
            this.startedGroups = new IntStack();
        } catch (Throwable th) {
            openReader2.close();
            throw th;
        }
    }

    public Applier<?> getApplier() {
        return this.applier;
    }

    public ControlledComposition getComposition() {
        return this.composition;
    }

    public final boolean isComposing$runtime_release() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime_release() {
        return this.isDisposed;
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return this.changes.isNotEmpty();
    }

    public final SlotReader getReader$runtime_release() {
        return this.reader;
    }

    public final void setReader$runtime_release(SlotReader slotReader) {
        this.reader = slotReader;
    }

    public final SlotTable getInsertTable$runtime_release() {
        return this.insertTable;
    }

    public final void setInsertTable$runtime_release(SlotTable slotTable2) {
        this.insertTable = slotTable2;
    }

    public final ChangeList getDeferredChanges$runtime_release() {
        return this.deferredChanges;
    }

    public final void setDeferredChanges$runtime_release(ChangeList changeList) {
        this.deferredChanges = changeList;
    }

    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext();
    }

    @ComposeCompilerApi
    public void startReplaceableGroup(int i) {
        m3260startBaiHCIY(i, (Object) null, GroupKind.Companion.m3270getGroupULZAiWs(), (Object) null);
    }

    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @ComposeCompilerApi
    public void startDefaults() {
        m3260startBaiHCIY(-127, (Object) null, GroupKind.Companion.m3270getGroupULZAiWs(), (Object) null);
    }

    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getUsed()) {
            currentRecomposeScope$runtime_release.setDefaultsInScope(true);
        }
    }

    public boolean getDefaultsInvalid() {
        if (!getSkipping() || this.providersInvalid) {
            return true;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        return currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getDefaultsInvalid();
    }

    @ComposeCompilerApi
    public void startMovableGroup(int i, Object obj) {
        m3260startBaiHCIY(i, obj, GroupKind.Companion.m3270getGroupULZAiWs(), (Object) null);
    }

    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    private final void startRoot() {
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed((Object) this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime_release();
        }
        if (!this.sourceInformationEnabled) {
            this.sourceInformationEnabled = this.parentContext.getCollectingSourceInformation$runtime_release();
        }
        Set set = (Set) CompositionLocalMapKt.read(this.parentProvider, InspectionTablesKt.getLocalInspectionTables());
        if (set != null) {
            set.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(set);
        }
        startGroup(this.parentContext.getCompoundHashKey$runtime_release());
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        this.changeListWriter.endRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.nodeIndexStack.clear();
        this.groupNodeCountStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates = null;
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (!this.writer.getClosed()) {
            this.writer.close();
        }
        this.insertFixups.clear();
        createFreshInsertTable();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
    }

    public final void changesApplied$runtime_release() {
        this.providerUpdates = null;
    }

    public boolean getInserting() {
        return this.inserting;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = getCurrentRecomposeScope$runtime_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getSkipping() {
        /*
            r1 = this;
            boolean r0 = r1.getInserting()
            if (r0 != 0) goto L_0x0020
            boolean r0 = r1.reusing
            if (r0 != 0) goto L_0x0020
            boolean r0 = r1.providersInvalid
            if (r0 != 0) goto L_0x0020
            androidx.compose.runtime.RecomposeScopeImpl r0 = r1.getCurrentRecomposeScope$runtime_release()
            if (r0 == 0) goto L_0x0020
            boolean r0 = r0.getRequiresRecompose()
            if (r0 != 0) goto L_0x0020
            boolean r0 = r1.forciblyRecompose
            if (r0 != 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.getSkipping():boolean");
    }

    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
        this.sourceInformationEnabled = true;
    }

    public final void dispose$runtime_release() {
        Object beginSection = Trace.INSTANCE.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            deactivate$runtime_release();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(beginSection);
        }
    }

    public final void deactivate$runtime_release() {
        this.invalidateStack.clear();
        this.invalidations.clear();
        this.changes.clear();
        this.providerUpdates = null;
    }

    public final boolean forceRecomposeScopes$runtime_release() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    private final void startGroup(int i) {
        m3260startBaiHCIY(i, (Object) null, GroupKind.Companion.m3270getGroupULZAiWs(), (Object) null);
    }

    private final void startGroup(int i, Object obj) {
        m3260startBaiHCIY(i, obj, GroupKind.Companion.m3270getGroupULZAiWs(), (Object) null);
    }

    private final void endGroup() {
        end(false);
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    public void startNode() {
        m3260startBaiHCIY(125, (Object) null, GroupKind.Companion.m3271getNodeULZAiWs(), (Object) null);
        this.nodeExpected = true;
    }

    public void startReusableNode() {
        m3260startBaiHCIY(125, (Object) null, GroupKind.Companion.m3272getReusableNodeULZAiWs(), (Object) null);
        this.nodeExpected = true;
    }

    public <T> void createNode(Function0<? extends T> function0) {
        validateNodeExpected();
        if (getInserting()) {
            int peek = this.nodeIndexStack.peek();
            SlotWriter slotWriter = this.writer;
            Anchor anchor = slotWriter.anchor(slotWriter.getParent());
            this.groupNodeCount++;
            this.insertFixups.createAndInsertNode(function0, peek, anchor);
            return;
        }
        ComposerKt.composeRuntimeError("createNode() can only be called when inserting".toString());
        throw new KotlinNothingValueException();
    }

    public void useNode() {
        validateNodeExpected();
        if (!getInserting()) {
            Object node = getNode(this.reader);
            this.changeListWriter.moveDown(node);
            if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
                this.changeListWriter.useNode(node);
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("useNode() called while inserting".toString());
        throw new KotlinNothingValueException();
    }

    public void endNode() {
        end(true);
    }

    public void startReusableGroup(int i, Object obj) {
        if (!getInserting() && this.reader.getGroupKey() == i && !Intrinsics.areEqual(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        m3260startBaiHCIY(i, (Object) null, GroupKind.Companion.m3270getGroupULZAiWs(), obj);
    }

    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public void disableReusing() {
        this.reusing = false;
    }

    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    public final void startReuseFromRoot() {
        this.reusingGroup = 100;
        this.reusing = true;
    }

    public final void endReuseFromRoot() {
        if (this.isComposing || this.reusingGroup != 100) {
            throw new IllegalArgumentException("Cannot disable reuse from root if it was caused by other groups".toString());
        }
        this.reusingGroup = -1;
        this.reusing = false;
    }

    public int getCurrentMarker() {
        return getInserting() ? -this.writer.getParent() : this.reader.getParent();
    }

    public void endToMarker(int i) {
        if (i < 0) {
            int i2 = -i;
            SlotWriter slotWriter = this.writer;
            while (true) {
                int parent = slotWriter.getParent();
                if (parent > i2) {
                    end(slotWriter.isNode(parent));
                } else {
                    return;
                }
            }
        } else {
            if (getInserting()) {
                SlotWriter slotWriter2 = this.writer;
                while (getInserting()) {
                    end(slotWriter2.isNode(slotWriter2.getParent()));
                }
            }
            SlotReader slotReader = this.reader;
            while (true) {
                int parent2 = slotReader.getParent();
                if (parent2 > i) {
                    end(slotReader.isNode(parent2));
                } else {
                    return;
                }
            }
        }
    }

    public <V, T> void apply(V v, Function2<? super T, ? super V, Unit> function2) {
        if (getInserting()) {
            this.insertFixups.updateNode(v, function2);
        } else {
            this.changeListWriter.updateNode(v, function2);
        }
    }

    @ComposeCompilerApi
    public Object joinKey(Object obj, Object obj2) {
        Object access$getKey = ComposerKt.getKey(this.reader.getGroupObjectKey(), obj, obj2);
        return access$getKey == null ? new JoinedKey(obj, obj2) : access$getKey;
    }

    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserver)) ? next : Composer.Companion.getEmpty();
    }

    public final Object nextSlotForCache() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        Object next = this.reader.next();
        if (!this.reusing || (next instanceof ReusableRememberObserver)) {
            return next instanceof RememberObserverHolder ? ((RememberObserverHolder) next).getWrapped() : next;
        }
        return Composer.Companion.getEmpty();
    }

    @ComposeCompilerApi
    public boolean changed(Object obj) {
        if (Intrinsics.areEqual(nextSlot(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    @ComposeCompilerApi
    public boolean changedInstance(Object obj) {
        if (nextSlot() == obj) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(char c) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Character) && c == ((Character) nextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(c));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(byte b) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Byte) && b == ((Number) nextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(b));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(short s) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Short) && s == ((Number) nextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(s));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(boolean z) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Boolean) && z == ((Boolean) nextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(float f) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Float) && f == ((Number) nextSlot).floatValue()) {
            return false;
        }
        updateValue(Float.valueOf(f));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(long j) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Long) && j == ((Number) nextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(double d) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Double) && d == ((Number) nextSlot).doubleValue()) {
            return false;
        }
        updateValue(Double.valueOf(d));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(int i) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Integer) && i == ((Number) nextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(i));
        return true;
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean z, Function0<? extends T> function0) {
        T nextSlotForCache = nextSlotForCache();
        if (nextSlotForCache != Composer.Companion.getEmpty() && !z) {
            return nextSlotForCache;
        }
        T invoke = function0.invoke();
        updateCachedValue(invoke);
        return invoke;
    }

    private final void updateSlot(Object obj) {
        nextSlot();
        updateValue(obj);
    }

    public final void updateValue(Object obj) {
        if (getInserting()) {
            this.writer.update(obj);
            return;
        }
        this.changeListWriter.updateValue(obj, this.reader.getGroupSlotIndex() - 1);
    }

    public final void updateCachedValue(Object obj) {
        if (obj instanceof RememberObserver) {
            if (getInserting()) {
                this.changeListWriter.remember((RememberObserver) obj);
            }
            this.abandonSet.add(obj);
            obj = new RememberObserverHolder((RememberObserver) obj);
        }
        updateValue(obj);
    }

    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    public void recordSideEffect(Function0<Unit> function0) {
        this.changeListWriter.sideEffect(function0);
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        if (persistentCompositionLocalMap != null) {
            return persistentCompositionLocalMap;
        }
        return currentCompositionLocalScope(this.reader.getParent());
    }

    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: androidx.compose.runtime.PersistentCompositionLocalMap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.PersistentCompositionLocalMap currentCompositionLocalScope(int r6) {
        /*
            r5 = this;
            boolean r0 = r5.getInserting()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap"
            r2 = 202(0xca, float:2.83E-43)
            if (r0 == 0) goto L_0x0043
            boolean r0 = r5.writerHasAProvider
            if (r0 == 0) goto L_0x0043
            androidx.compose.runtime.SlotWriter r0 = r5.writer
            int r0 = r0.getParent()
        L_0x0014:
            if (r0 <= 0) goto L_0x0043
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            int r3 = r3.groupKey(r0)
            if (r3 != r2) goto L_0x003c
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            java.lang.Object r3 = r3.groupObjectKey(r0)
            java.lang.Object r4 = androidx.compose.runtime.ComposerKt.getCompositionLocalMap()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x003c
            androidx.compose.runtime.SlotWriter r6 = r5.writer
            java.lang.Object r6 = r6.groupAux(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            androidx.compose.runtime.PersistentCompositionLocalMap r6 = (androidx.compose.runtime.PersistentCompositionLocalMap) r6
            r5.providerCache = r6
            return r6
        L_0x003c:
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            int r0 = r3.parent((int) r0)
            goto L_0x0014
        L_0x0043:
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r0 = r0.getSize()
            if (r0 <= 0) goto L_0x0087
        L_0x004b:
            if (r6 <= 0) goto L_0x0087
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r0 = r0.groupKey((int) r6)
            if (r0 != r2) goto L_0x0080
            androidx.compose.runtime.SlotReader r0 = r5.reader
            java.lang.Object r0 = r0.groupObjectKey(r6)
            java.lang.Object r3 = androidx.compose.runtime.ComposerKt.getCompositionLocalMap()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0080
            androidx.compose.runtime.collection.IntMap<androidx.compose.runtime.PersistentCompositionLocalMap> r0 = r5.providerUpdates
            if (r0 == 0) goto L_0x0071
            java.lang.Object r0 = r0.get(r6)
            androidx.compose.runtime.PersistentCompositionLocalMap r0 = (androidx.compose.runtime.PersistentCompositionLocalMap) r0
            if (r0 != 0) goto L_0x007d
        L_0x0071:
            androidx.compose.runtime.SlotReader r0 = r5.reader
            java.lang.Object r6 = r0.groupAux(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            r0 = r6
            androidx.compose.runtime.PersistentCompositionLocalMap r0 = (androidx.compose.runtime.PersistentCompositionLocalMap) r0
        L_0x007d:
            r5.providerCache = r0
            return r0
        L_0x0080:
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r6 = r0.parent(r6)
            goto L_0x004b
        L_0x0087:
            androidx.compose.runtime.PersistentCompositionLocalMap r6 = r5.parentProvider
            r5.providerCache = r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.currentCompositionLocalScope(int):androidx.compose.runtime.PersistentCompositionLocalMap");
    }

    public void startProvider(ProvidedValue<?> providedValue) {
        State state;
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(ComposerKt.providerKey, ComposerKt.getProvider());
        Object rememberedValue = rememberedValue();
        if (Intrinsics.areEqual(rememberedValue, Composer.Companion.getEmpty())) {
            state = null;
        } else {
            Intrinsics.checkNotNull(rememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.State<kotlin.Any?>");
            state = (State) rememberedValue;
        }
        CompositionLocal<?> compositionLocal = providedValue.getCompositionLocal();
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        State<?> updatedStateOf$runtime_release = compositionLocal.updatedStateOf$runtime_release(providedValue.getValue(), state);
        boolean z = true;
        boolean z2 = !Intrinsics.areEqual((Object) updatedStateOf$runtime_release, (Object) state);
        if (z2) {
            updateRememberedValue(updatedStateOf$runtime_release);
        }
        boolean z3 = false;
        if (getInserting()) {
            persistentCompositionLocalMap = currentCompositionLocalScope.putValue(compositionLocal, updatedStateOf$runtime_release);
            this.writerHasAProvider = true;
        } else {
            SlotReader slotReader = this.reader;
            Object groupAux = slotReader.groupAux(slotReader.getCurrentGroup());
            Intrinsics.checkNotNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) groupAux;
            if ((!getSkipping() || z2) && (providedValue.getCanOverride() || !CompositionLocalMapKt.contains(currentCompositionLocalScope, compositionLocal))) {
                persistentCompositionLocalMap = currentCompositionLocalScope.putValue(compositionLocal, updatedStateOf$runtime_release);
            } else {
                persistentCompositionLocalMap = persistentCompositionLocalMap2;
            }
            if (!this.reusing && persistentCompositionLocalMap2 == persistentCompositionLocalMap) {
                z = false;
            }
            z3 = z;
        }
        if (z3 && !getInserting()) {
            recordProviderUpdate(persistentCompositionLocalMap);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z3;
        this.providerCache = persistentCompositionLocalMap;
        m3260startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m3270getGroupULZAiWs(), persistentCompositionLocalMap);
    }

    private final void recordProviderUpdate(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        IntMap<PersistentCompositionLocalMap> intMap = this.providerUpdates;
        if (intMap == null) {
            ComposerImpl composerImpl = this;
            intMap = new IntMap<>(0, 1, (DefaultConstructorMarker) null);
            this.providerUpdates = intMap;
        }
        intMap.set(this.reader.getCurrentGroup(), persistentCompositionLocalMap);
    }

    public void endProvider() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    public void startProviders(ProvidedValue<?>[] providedValueArr) {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(ComposerKt.providerKey, ComposerKt.getProvider());
        boolean z = true;
        boolean z2 = false;
        if (getInserting()) {
            persistentCompositionLocalMap = updateProviderMapGroup(currentCompositionLocalScope, CompositionLocalMapKt.updateCompositionMap$default(providedValueArr, currentCompositionLocalScope, (PersistentCompositionLocalMap) null, 4, (Object) null));
            this.writerHasAProvider = true;
        } else {
            Object groupGet = this.reader.groupGet(0);
            Intrinsics.checkNotNull(groupGet, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) groupGet;
            Object groupGet2 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(groupGet2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap3 = (PersistentCompositionLocalMap) groupGet2;
            PersistentCompositionLocalMap updateCompositionMap = CompositionLocalMapKt.updateCompositionMap(providedValueArr, currentCompositionLocalScope, persistentCompositionLocalMap3);
            if (!getSkipping() || this.reusing || !Intrinsics.areEqual((Object) persistentCompositionLocalMap3, (Object) updateCompositionMap)) {
                persistentCompositionLocalMap = updateProviderMapGroup(currentCompositionLocalScope, updateCompositionMap);
                if (!this.reusing && Intrinsics.areEqual((Object) persistentCompositionLocalMap, (Object) persistentCompositionLocalMap2)) {
                    z = false;
                }
                z2 = z;
            } else {
                skipGroup();
                persistentCompositionLocalMap = persistentCompositionLocalMap2;
            }
        }
        if (z2 && !getInserting()) {
            recordProviderUpdate(persistentCompositionLocalMap);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = persistentCompositionLocalMap;
        m3260startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m3270getGroupULZAiWs(), persistentCompositionLocalMap);
    }

    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    public <T> T consume(CompositionLocal<T> compositionLocal) {
        return CompositionLocalMapKt.read(currentCompositionLocalScope(), compositionLocal);
    }

    public CompositionContext buildContext() {
        startGroup(ComposerKt.referenceKey, ComposerKt.getReference());
        CompositionObserverHolder compositionObserverHolder = null;
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, (Object) null);
        }
        Object nextSlot = nextSlot();
        CompositionContextHolder compositionContextHolder = nextSlot instanceof CompositionContextHolder ? (CompositionContextHolder) nextSlot : null;
        if (compositionContextHolder == null) {
            int compoundKeyHash2 = getCompoundKeyHash();
            boolean z = this.forceRecomposeScopes;
            boolean z2 = this.sourceInformationEnabled;
            ControlledComposition composition2 = getComposition();
            CompositionImpl compositionImpl = composition2 instanceof CompositionImpl ? (CompositionImpl) composition2 : null;
            if (compositionImpl != null) {
                compositionObserverHolder = compositionImpl.getObserverHolder$runtime_release();
            }
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(compoundKeyHash2, z, z2, compositionObserverHolder));
            updateValue(compositionContextHolder);
        }
        compositionContextHolder.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return compositionContextHolder.getRef();
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.getSize();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack<RecomposeScopeImpl> stack = this.invalidateStack;
        if (this.childrenComposing != 0 || !stack.isNotEmpty()) {
            return null;
        }
        return stack.peek();
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter openWriter = this.insertTable.openWriter();
            this.writer = openWriter;
            openWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        SlotTable slotTable2 = new SlotTable();
        this.insertTable = slotTable2;
        SlotWriter openWriter = slotTable2.openWriter();
        openWriter.close();
        this.writer = openWriter;
    }

    private final void startReaderGroup(boolean z, Object obj) {
        if (z) {
            this.reader.startNode();
            return;
        }
        if (!(obj == null || this.reader.getGroupAux() == obj)) {
            this.changeListWriter.updateAuxData(obj);
        }
        this.reader.startGroup();
    }

    /* renamed from: start-BaiHCIY  reason: not valid java name */
    private final void m3260startBaiHCIY(int i, Object obj, int i2, Object obj2) {
        int i3 = i;
        Object obj3 = obj;
        int i4 = i2;
        Object obj4 = obj2;
        validateNodeNotExpected();
        updateCompoundKeyWhenWeEnterGroup(i, obj, obj4);
        int i5 = 0;
        boolean z = i4 != GroupKind.Companion.m3270getGroupULZAiWs();
        Pending pending2 = null;
        if (getInserting()) {
            this.reader.beginEmpty();
            int currentGroup = this.writer.getCurrentGroup();
            if (z) {
                this.writer.startNode(i, Composer.Companion.getEmpty());
            } else if (obj4 != null) {
                SlotWriter slotWriter = this.writer;
                if (obj3 == null) {
                    obj3 = Composer.Companion.getEmpty();
                }
                slotWriter.startData(i, obj3, obj4);
            } else {
                SlotWriter slotWriter2 = this.writer;
                if (obj3 == null) {
                    obj3 = Composer.Companion.getEmpty();
                }
                slotWriter2.startGroup(i, obj3);
            }
            Pending pending3 = this.pending;
            if (pending3 != null) {
                KeyInfo keyInfo = new KeyInfo(i, -1, insertedGroupVirtualIndex(currentGroup), -1, 0);
                pending3.registerInsert(keyInfo, this.nodeIndex - pending3.getStartIndex());
                pending3.recordUsed(keyInfo);
            }
            enterGroup(z, (Pending) null);
            return;
        }
        boolean z2 = i4 == GroupKind.Companion.m3271getNodeULZAiWs() && this.reusing;
        if (this.pending == null) {
            int groupKey = this.reader.getGroupKey();
            if (z2 || groupKey != i3 || !Intrinsics.areEqual(obj, this.reader.getGroupObjectKey())) {
                this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
            } else {
                startReaderGroup(z, obj4);
            }
        }
        Pending pending4 = this.pending;
        if (pending4 != null) {
            KeyInfo next = pending4.getNext(i, obj);
            if (z2 || next == null) {
                this.reader.beginEmpty();
                this.inserting = true;
                this.providerCache = null;
                ensureWriter();
                this.writer.beginInsert();
                int currentGroup2 = this.writer.getCurrentGroup();
                if (z) {
                    this.writer.startNode(i, Composer.Companion.getEmpty());
                } else if (obj4 != null) {
                    SlotWriter slotWriter3 = this.writer;
                    if (obj3 == null) {
                        obj3 = Composer.Companion.getEmpty();
                    }
                    slotWriter3.startData(i, obj3, obj4);
                } else {
                    SlotWriter slotWriter4 = this.writer;
                    if (obj3 == null) {
                        obj3 = Composer.Companion.getEmpty();
                    }
                    slotWriter4.startGroup(i, obj3);
                }
                this.insertAnchor = this.writer.anchor(currentGroup2);
                KeyInfo keyInfo2 = new KeyInfo(i, -1, insertedGroupVirtualIndex(currentGroup2), -1, 0);
                pending4.registerInsert(keyInfo2, this.nodeIndex - pending4.getStartIndex());
                pending4.recordUsed(keyInfo2);
                List arrayList = new ArrayList();
                if (!z) {
                    i5 = this.nodeIndex;
                }
                pending2 = new Pending(arrayList, i5);
            } else {
                pending4.recordUsed(next);
                int location = next.getLocation();
                this.nodeIndex = pending4.nodePositionOf(next) + pending4.getStartIndex();
                int slotPositionOf = pending4.slotPositionOf(next);
                int groupIndex = slotPositionOf - pending4.getGroupIndex();
                pending4.registerMoveSlot(slotPositionOf, pending4.getGroupIndex());
                this.changeListWriter.moveReaderRelativeTo(location);
                this.reader.reposition(location);
                if (groupIndex > 0) {
                    this.changeListWriter.moveCurrentGroup(groupIndex);
                }
                startReaderGroup(z, obj4);
            }
        }
        enterGroup(z, pending2);
    }

    private final void enterGroup(boolean z, Pending pending2) {
        this.pendingStack.push(this.pending);
        this.pending = pending2;
        this.nodeIndexStack.push(this.nodeIndex);
        if (z) {
            this.nodeIndex = 0;
        }
        this.groupNodeCountStack.push(this.groupNodeCount);
        this.groupNodeCount = 0;
    }

    private final void exitGroup(int i, boolean z) {
        Pending pop = this.pendingStack.pop();
        if (pop != null && !z) {
            pop.setGroupIndex(pop.getGroupIndex() + 1);
        }
        this.pending = pop;
        this.nodeIndex = this.nodeIndexStack.pop() + i;
        this.groupNodeCount = this.groupNodeCountStack.pop() + i;
    }

    private final void end(boolean z) {
        Set<T> set;
        List<KeyInfo> list;
        if (getInserting()) {
            int parent = this.writer.getParent();
            updateCompoundKeyWhenWeExitGroup(this.writer.groupKey(parent), this.writer.groupObjectKey(parent), this.writer.groupAux(parent));
        } else {
            int parent2 = this.reader.getParent();
            updateCompoundKeyWhenWeExitGroup(this.reader.groupKey(parent2), this.reader.groupObjectKey(parent2), this.reader.groupAux(parent2));
        }
        int i = this.groupNodeCount;
        Pending pending2 = this.pending;
        if (pending2 != null && pending2.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = pending2.getKeyInfos();
            List<KeyInfo> used = pending2.getUsed();
            Set<T> fastToSet = ListUtilsKt.fastToSet(used);
            Set linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < size2) {
                KeyInfo keyInfo = keyInfos.get(i2);
                if (!fastToSet.contains(keyInfo)) {
                    this.changeListWriter.removeNode(pending2.nodePositionOf(keyInfo) + pending2.getStartIndex(), keyInfo.getNodes());
                    pending2.updateNodeCount(keyInfo.getLocation(), 0);
                    this.changeListWriter.moveReaderRelativeTo(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    set = fastToSet;
                    ComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), keyInfo.getLocation() + this.reader.groupSize(keyInfo.getLocation()));
                } else {
                    set = fastToSet;
                    if (!linkedHashSet.contains(keyInfo)) {
                        if (i3 < size) {
                            KeyInfo keyInfo2 = used.get(i3);
                            if (keyInfo2 != keyInfo) {
                                int nodePositionOf = pending2.nodePositionOf(keyInfo2);
                                linkedHashSet.add(keyInfo2);
                                if (nodePositionOf != i4) {
                                    int updatedNodeCountOf = pending2.updatedNodeCountOf(keyInfo2);
                                    list = used;
                                    this.changeListWriter.moveNode(pending2.getStartIndex() + nodePositionOf, i4 + pending2.getStartIndex(), updatedNodeCountOf);
                                    pending2.registerMoveNode(nodePositionOf, i4, updatedNodeCountOf);
                                } else {
                                    list = used;
                                }
                            } else {
                                list = used;
                                i2++;
                            }
                            i3++;
                            i4 += pending2.updatedNodeCountOf(keyInfo2);
                            fastToSet = set;
                            used = list;
                        }
                        fastToSet = set;
                    }
                }
                i2++;
                fastToSet = set;
            }
            this.changeListWriter.endNodeMovement();
            if (keyInfos.size() > 0) {
                this.changeListWriter.moveReaderRelativeTo(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int i5 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            this.changeListWriter.removeNode(i5, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        boolean inserting2 = getInserting();
        if (inserting2) {
            if (z) {
                this.insertFixups.endNodeInsert();
                i = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int insertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close();
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(insertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(insertedGroupVirtualIndex, i);
                }
            }
        } else {
            if (z) {
                this.changeListWriter.moveUp();
            }
            this.changeListWriter.endCurrentGroup();
            int parent4 = this.reader.getParent();
            if (i != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i);
            }
            if (z) {
                i = 1;
            }
            this.reader.endGroup();
            this.changeListWriter.endNodeMovement();
        }
        exitGroup(i, inserting2);
    }

    private final void recomposeToGroupEnd() {
        boolean z = this.isComposing;
        this.isComposing = true;
        int parent = this.reader.getParent();
        int groupSize = this.reader.groupSize(parent) + parent;
        int i = this.nodeIndex;
        int compoundKeyHash2 = getCompoundKeyHash();
        int i2 = this.groupNodeCount;
        Invalidation access$firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        boolean z2 = false;
        int i3 = parent;
        while (access$firstInRange != null) {
            int location = access$firstInRange.getLocation();
            Invalidation unused = ComposerKt.removeLocation(this.invalidations, location);
            if (access$firstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i3, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i);
                this.compoundKeyHash = compoundKeyOf(this.reader.parent(currentGroup), parent, compoundKeyHash2);
                this.providerCache = null;
                access$firstInRange.getScope().compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                i3 = currentGroup;
                z2 = true;
            } else {
                this.invalidateStack.push(access$firstInRange.getScope());
                access$firstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            access$firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        }
        if (z2) {
            recordUpsAndDowns(i3, parent, parent);
            this.reader.skipToGroupEnd();
            int updatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i + updatedNodeCount;
            this.groupNodeCount = i2 + updatedNodeCount;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = compoundKeyHash2;
        this.isComposing = z;
    }

    private final void updateNodeCountOverrides(int i, int i2) {
        int updatedNodeCount = updatedNodeCount(i);
        if (updatedNodeCount != i2) {
            int i3 = i2 - updatedNodeCount;
            int size = this.pendingStack.getSize() - 1;
            while (i != -1) {
                int updatedNodeCount2 = updatedNodeCount(i) + i3;
                updateNodeCount(i, updatedNodeCount2);
                int i4 = size;
                while (true) {
                    if (-1 < i4) {
                        Pending peek = this.pendingStack.peek(i4);
                        if (peek != null && peek.updateNodeCount(i, updatedNodeCount2)) {
                            size = i4 - 1;
                            break;
                        }
                        i4--;
                    } else {
                        break;
                    }
                }
                if (i < 0) {
                    i = this.reader.getParent();
                } else if (!this.reader.isNode(i)) {
                    i = this.reader.parent(i);
                } else {
                    return;
                }
            }
        }
    }

    private final int nodeIndexOf(int i, int i2, int i3, int i4) {
        int i5;
        int parent = this.reader.parent(i2);
        while (i5 != i3 && !this.reader.isNode(i5)) {
            parent = this.reader.parent(i5);
        }
        if (this.reader.isNode(i5)) {
            i4 = 0;
        }
        if (i5 == i2) {
            return i4;
        }
        int updatedNodeCount = (updatedNodeCount(i5) - this.reader.nodeCount(i2)) + i4;
        loop1:
        while (i4 < updatedNodeCount && i5 != i) {
            i5++;
            while (true) {
                if (i5 >= i) {
                    break loop1;
                }
                int groupSize = this.reader.groupSize(i5) + i5;
                if (i >= groupSize) {
                    i4 += updatedNodeCount(i5);
                    i5 = groupSize;
                }
            }
        }
        return i4;
    }

    private final int updatedNodeCount(int i) {
        int i2;
        if (i < 0) {
            MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
            if (mutableIntIntMap == null || !mutableIntIntMap.contains(i)) {
                return 0;
            }
            return mutableIntIntMap.get(i);
        }
        int[] iArr = this.nodeCountOverrides;
        if (iArr == null || (i2 = iArr[i]) < 0) {
            return this.reader.nodeCount(i);
        }
        return i2;
    }

    private final void updateNodeCount(int i, int i2) {
        if (updatedNodeCount(i) == i2) {
            return;
        }
        if (i < 0) {
            MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
            if (mutableIntIntMap == null) {
                ComposerImpl composerImpl = this;
                mutableIntIntMap = new MutableIntIntMap(0, 1, (DefaultConstructorMarker) null);
                this.nodeCountVirtualOverrides = mutableIntIntMap;
            }
            mutableIntIntMap.set(i, i2);
            return;
        }
        int[] iArr = this.nodeCountOverrides;
        if (iArr == null) {
            ComposerImpl composerImpl2 = this;
            iArr = new int[this.reader.getSize()];
            ArraysKt.fill$default(iArr, -1, 0, 0, 6, (Object) null);
            this.nodeCountOverrides = iArr;
        }
        iArr[i] = i2;
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final void recordUpsAndDowns(int i, int i2, int i3) {
        SlotReader slotReader = this.reader;
        int access$nearestCommonRootOf = ComposerKt.nearestCommonRootOf(slotReader, i, i2, i3);
        while (i > 0 && i != access$nearestCommonRootOf) {
            if (slotReader.isNode(i)) {
                this.changeListWriter.moveUp();
            }
            i = slotReader.parent(i);
        }
        doRecordDownsFor(i2, access$nearestCommonRootOf);
    }

    private final void doRecordDownsFor(int i, int i2) {
        if (i > 0 && i != i2) {
            doRecordDownsFor(this.reader.parent(i), i2);
            if (this.reader.isNode(i)) {
                this.changeListWriter.moveDown(nodeAt(this.reader, i));
            }
        }
    }

    private final int compoundKeyOf(int i, int i2, int i3) {
        if (i == i2) {
            return i3;
        }
        ComposerImpl composerImpl = this;
        int groupCompoundKeyPart = groupCompoundKeyPart(this.reader, i);
        if (groupCompoundKeyPart == 126665345) {
            return groupCompoundKeyPart;
        }
        return Integer.rotateLeft(compoundKeyOf(this.reader.parent(i), i2, i3), 3) ^ groupCompoundKeyPart;
    }

    private final int groupCompoundKeyPart(SlotReader slotReader, int i) {
        Object groupAux;
        if (slotReader.hasObjectKey(i)) {
            Object groupObjectKey = slotReader.groupObjectKey(i);
            if (groupObjectKey == null) {
                return 0;
            }
            if (groupObjectKey instanceof Enum) {
                return ((Enum) groupObjectKey).ordinal();
            }
            if (groupObjectKey instanceof MovableContent) {
                return MovableContentKt.movableContentKey;
            }
            return groupObjectKey.hashCode();
        }
        int groupKey = slotReader.groupKey(i);
        if (groupKey == 207 && (groupAux = slotReader.groupAux(i)) != null && !Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
            groupKey = groupAux.hashCode();
        }
        return groupKey;
    }

    public final boolean tryImminentInvalidation$runtime_release(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = anchor.toIndexFor(this.reader.getTable$runtime_release());
        if (!this.isComposing || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, indexFor, recomposeScopeImpl, obj);
        return true;
    }

    public final int parentKey$runtime_release() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    @ComposeCompilerApi
    public void skipCurrentGroup() {
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        Object groupObjectKey = slotReader.getGroupObjectKey();
        Object groupAux = slotReader.getGroupAux();
        updateCompoundKeyWhenWeEnterGroup(groupKey, groupObjectKey, groupAux);
        startReaderGroup(slotReader.isNode(), (Object) null);
        recomposeToGroupEnd();
        slotReader.endGroup();
        updateCompoundKeyWhenWeExitGroup(groupKey, groupObjectKey, groupAux);
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (this.groupNodeCount == 0) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            if (currentRecomposeScope$runtime_release != null) {
                currentRecomposeScope$runtime_release.scopeSkipped();
            }
            if (this.invalidations.isEmpty()) {
                skipReaderToGroupEnd();
            } else {
                recomposeToGroupEnd();
            }
        } else {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling skipAndEndGroup".toString());
            throw new KotlinNothingValueException();
        }
    }

    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean z) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling dactivateToEndGroup".toString());
            throw new KotlinNothingValueException();
        } else if (getInserting()) {
        } else {
            if (!z) {
                skipReaderToGroupEnd();
                return;
            }
            int currentGroup = this.reader.getCurrentGroup();
            int currentEnd = this.reader.getCurrentEnd();
            this.changeListWriter.deactivateCurrentGroup();
            ComposerKt.removeRange(this.invalidations, currentGroup, currentEnd);
            this.reader.skipToGroupEnd();
        }
    }

    @ComposeCompilerApi
    public Composer startRestartGroup(int i) {
        m3260startBaiHCIY(i, (Object) null, GroupKind.Companion.m3270getGroupULZAiWs(), (Object) null);
        addRecomposeScope();
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006b, code lost:
        if (r0 != false) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addRecomposeScope() {
        /*
            r4 = this;
            boolean r0 = r4.getInserting()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl"
            if (r0 == 0) goto L_0x0026
            androidx.compose.runtime.RecomposeScopeImpl r0 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.ControlledComposition r2 = r4.getComposition()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r1)
            androidx.compose.runtime.CompositionImpl r2 = (androidx.compose.runtime.CompositionImpl) r2
            androidx.compose.runtime.RecomposeScopeOwner r2 = (androidx.compose.runtime.RecomposeScopeOwner) r2
            r0.<init>(r2)
            androidx.compose.runtime.Stack<androidx.compose.runtime.RecomposeScopeImpl> r1 = r4.invalidateStack
            r1.push(r0)
            r4.updateValue(r0)
            int r1 = r4.compositionToken
            r0.start(r1)
            goto L_0x007b
        L_0x0026:
            java.util.List<androidx.compose.runtime.Invalidation> r0 = r4.invalidations
            androidx.compose.runtime.SlotReader r2 = r4.reader
            int r2 = r2.getParent()
            androidx.compose.runtime.Invalidation r0 = androidx.compose.runtime.ComposerKt.removeLocation(r0, r2)
            androidx.compose.runtime.SlotReader r2 = r4.reader
            java.lang.Object r2 = r2.next()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0058
            androidx.compose.runtime.RecomposeScopeImpl r2 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.ControlledComposition r3 = r4.getComposition()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r1)
            androidx.compose.runtime.CompositionImpl r3 = (androidx.compose.runtime.CompositionImpl) r3
            androidx.compose.runtime.RecomposeScopeOwner r3 = (androidx.compose.runtime.RecomposeScopeOwner) r3
            r2.<init>(r3)
            r4.updateValue(r2)
            goto L_0x005f
        L_0x0058:
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r1)
            androidx.compose.runtime.RecomposeScopeImpl r2 = (androidx.compose.runtime.RecomposeScopeImpl) r2
        L_0x005f:
            if (r0 != 0) goto L_0x006d
            boolean r0 = r2.getForcedRecompose()
            r1 = 0
            if (r0 == 0) goto L_0x006b
            r2.setForcedRecompose(r1)
        L_0x006b:
            if (r0 == 0) goto L_0x006e
        L_0x006d:
            r1 = 1
        L_0x006e:
            r2.setRequiresRecompose(r1)
            androidx.compose.runtime.Stack<androidx.compose.runtime.RecomposeScopeImpl> r0 = r4.invalidateStack
            r0.push(r2)
            int r0 = r4.compositionToken
            r2.start(r0)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.addRecomposeScope():void");
    }

    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        Anchor anchor;
        Function1<Composition, Unit> end;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl pop = this.invalidateStack.isNotEmpty() ? this.invalidateStack.pop() : null;
        if (pop != null) {
            pop.setRequiresRecompose(false);
        }
        if (!(pop == null || (end = pop.end(this.compositionToken)) == null)) {
            this.changeListWriter.endCompositionScope(end, getComposition());
        }
        if (pop != null && !pop.getSkipped$runtime_release() && (pop.getUsed() || this.forceRecomposeScopes)) {
            if (pop.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                pop.setAnchor(anchor);
            }
            pop.setDefaultsInvalid(false);
            recomposeScopeImpl = pop;
        }
        end(false);
        return recomposeScopeImpl;
    }

    public void insertMovableContent(MovableContent<?> movableContent, Object obj) {
        Intrinsics.checkNotNull(movableContent, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        invokeMovableContentLambda(movableContent, currentCompositionLocalScope(), obj, false);
    }

    /* access modifiers changed from: private */
    public final void invokeMovableContentLambda(MovableContent<Object> movableContent, PersistentCompositionLocalMap persistentCompositionLocalMap, Object obj, boolean z) {
        startMovableGroup(MovableContentKt.movableContentKey, movableContent);
        updateSlot(obj);
        int compoundKeyHash2 = getCompoundKeyHash();
        try {
            this.compoundKeyHash = MovableContentKt.movableContentKey;
            boolean z2 = false;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, (Object) null);
            }
            if (!getInserting()) {
                if (!Intrinsics.areEqual(this.reader.getGroupAux(), (Object) persistentCompositionLocalMap)) {
                    z2 = true;
                }
            }
            if (z2) {
                recordProviderUpdate(persistentCompositionLocalMap);
            }
            m3260startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m3270getGroupULZAiWs(), persistentCompositionLocalMap);
            this.providerCache = null;
            if (!getInserting() || z) {
                boolean z3 = this.providersInvalid;
                this.providersInvalid = z2;
                ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(316014703, true, new ComposerImpl$invokeMovableContentLambda$1(movableContent, obj)));
                this.providersInvalid = z3;
            } else {
                this.writerHasAProvider = true;
                SlotWriter slotWriter = this.writer;
                this.parentContext.insertMovableContent$runtime_release(new MovableContentStateReference(movableContent, obj, getComposition(), this.insertTable, slotWriter.anchor(slotWriter.parent(slotWriter.getParent())), CollectionsKt.emptyList(), currentCompositionLocalScope()));
            }
        } finally {
            endGroup();
            this.providerCache = null;
            this.compoundKeyHash = compoundKeyHash2;
            endMovableGroup();
        }
    }

    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        try {
            insertMovableContentGuarded(list);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b0, code lost:
        if (r7 == null) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c3, code lost:
        if (r8 != null) goto L_0x00c9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void insertMovableContentGuarded(java.util.List<kotlin.Pair<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentStateReference>> r24) {
        /*
            r23 = this;
            r9 = r23
            androidx.compose.runtime.changelist.ComposerChangeListWriter r10 = r9.changeListWriter
            androidx.compose.runtime.changelist.ChangeList r0 = r9.lateChanges
            androidx.compose.runtime.changelist.ChangeList r11 = r10.getChangeList()
            r10.setChangeList(r0)     // Catch:{ all -> 0x021c }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r9.changeListWriter     // Catch:{ all -> 0x021c }
            r0.resetSlots()     // Catch:{ all -> 0x021c }
            int r0 = r24.size()     // Catch:{ all -> 0x021c }
            r12 = 0
            r13 = r12
        L_0x0018:
            if (r13 >= r0) goto L_0x01ff
            r14 = r24
            java.lang.Object r1 = r14.get(r13)     // Catch:{ all -> 0x01f9 }
            kotlin.Pair r1 = (kotlin.Pair) r1     // Catch:{ all -> 0x01f9 }
            java.lang.Object r2 = r1.component1()     // Catch:{ all -> 0x01f9 }
            androidx.compose.runtime.MovableContentStateReference r2 = (androidx.compose.runtime.MovableContentStateReference) r2     // Catch:{ all -> 0x01f9 }
            java.lang.Object r1 = r1.component2()     // Catch:{ all -> 0x01f9 }
            androidx.compose.runtime.MovableContentStateReference r1 = (androidx.compose.runtime.MovableContentStateReference) r1     // Catch:{ all -> 0x01f9 }
            androidx.compose.runtime.Anchor r3 = r2.getAnchor$runtime_release()     // Catch:{ all -> 0x01f9 }
            androidx.compose.runtime.SlotTable r4 = r2.getSlotTable$runtime_release()     // Catch:{ all -> 0x01f9 }
            int r4 = r4.anchorIndex(r3)     // Catch:{ all -> 0x01f9 }
            androidx.compose.runtime.internal.IntRef r15 = new androidx.compose.runtime.internal.IntRef     // Catch:{ all -> 0x01f9 }
            r5 = 0
            r6 = 1
            r15.<init>(r12, r6, r5)     // Catch:{ all -> 0x01f9 }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r7 = r9.changeListWriter     // Catch:{ all -> 0x01f9 }
            r7.determineMovableContentNodeIndex(r15, r3)     // Catch:{ all -> 0x01f9 }
            if (r1 != 0) goto L_0x00a4
            androidx.compose.runtime.SlotTable r1 = r2.getSlotTable$runtime_release()     // Catch:{ all -> 0x021c }
            androidx.compose.runtime.SlotTable r3 = r9.insertTable     // Catch:{ all -> 0x021c }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)     // Catch:{ all -> 0x021c }
            if (r1 == 0) goto L_0x0057
            r23.createFreshInsertTable()     // Catch:{ all -> 0x021c }
        L_0x0057:
            androidx.compose.runtime.SlotTable r1 = r2.getSlotTable$runtime_release()     // Catch:{ all -> 0x021c }
            androidx.compose.runtime.SlotReader r8 = r1.openReader()     // Catch:{ all -> 0x021c }
            r8.reposition(r4)     // Catch:{ all -> 0x009d }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r1 = r9.changeListWriter     // Catch:{ all -> 0x009d }
            r1.moveReaderToAbsolute(r4)     // Catch:{ all -> 0x009d }
            androidx.compose.runtime.changelist.ChangeList r7 = new androidx.compose.runtime.changelist.ChangeList     // Catch:{ all -> 0x009d }
            r7.<init>()     // Catch:{ all -> 0x009d }
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1$1 r1 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1$1     // Catch:{ all -> 0x009d }
            r1.<init>(r9, r7, r8, r2)     // Catch:{ all -> 0x009d }
            r6 = r1
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6     // Catch:{ all -> 0x009d }
            r16 = 15
            r17 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r1 = r23
            r12 = r7
            r7 = r16
            r16 = r8
            r8 = r17
            recomposeMovableContent$default(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x009b }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r1 = r9.changeListWriter     // Catch:{ all -> 0x009b }
            r1.includeOperationsIn(r12, r15)     // Catch:{ all -> 0x009b }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009b }
            r16.close()     // Catch:{ all -> 0x021c }
            r17 = r0
            r16 = r10
            r22 = r11
            r0 = r13
            goto L_0x0198
        L_0x009b:
            r0 = move-exception
            goto L_0x00a0
        L_0x009d:
            r0 = move-exception
            r16 = r8
        L_0x00a0:
            r16.close()     // Catch:{ all -> 0x021c }
            throw r0     // Catch:{ all -> 0x021c }
        L_0x00a4:
            androidx.compose.runtime.CompositionContext r4 = r9.parentContext     // Catch:{ all -> 0x01f9 }
            androidx.compose.runtime.MovableContentState r4 = r4.movableContentStateResolve$runtime_release(r1)     // Catch:{ all -> 0x01f9 }
            if (r4 == 0) goto L_0x00b2
            androidx.compose.runtime.SlotTable r7 = r4.getSlotTable$runtime_release()     // Catch:{ all -> 0x021c }
            if (r7 != 0) goto L_0x00b6
        L_0x00b2:
            androidx.compose.runtime.SlotTable r7 = r1.getSlotTable$runtime_release()     // Catch:{ all -> 0x01f9 }
        L_0x00b6:
            if (r4 == 0) goto L_0x00c5
            androidx.compose.runtime.SlotTable r8 = r4.getSlotTable$runtime_release()     // Catch:{ all -> 0x021c }
            if (r8 == 0) goto L_0x00c5
            r12 = 0
            androidx.compose.runtime.Anchor r8 = r8.anchor(r12)     // Catch:{ all -> 0x021c }
            if (r8 != 0) goto L_0x00c9
        L_0x00c5:
            androidx.compose.runtime.Anchor r8 = r1.getAnchor$runtime_release()     // Catch:{ all -> 0x01f9 }
        L_0x00c9:
            java.util.List r12 = androidx.compose.runtime.ComposerKt.collectNodesFrom(r7, r8)     // Catch:{ all -> 0x01f9 }
            r16 = r12
            java.util.Collection r16 = (java.util.Collection) r16     // Catch:{ all -> 0x01f9 }
            boolean r16 = r16.isEmpty()     // Catch:{ all -> 0x01f9 }
            r6 = r16 ^ 1
            if (r6 == 0) goto L_0x00fc
            androidx.compose.runtime.changelist.ComposerChangeListWriter r6 = r9.changeListWriter     // Catch:{ all -> 0x021c }
            r6.copyNodesToNewAnchorLocation(r12, r15)     // Catch:{ all -> 0x021c }
            androidx.compose.runtime.SlotTable r6 = r2.getSlotTable$runtime_release()     // Catch:{ all -> 0x021c }
            androidx.compose.runtime.SlotTable r5 = r9.slotTable     // Catch:{ all -> 0x021c }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r5)     // Catch:{ all -> 0x021c }
            if (r5 == 0) goto L_0x00fc
            androidx.compose.runtime.SlotTable r5 = r9.slotTable     // Catch:{ all -> 0x021c }
            int r3 = r5.anchorIndex(r3)     // Catch:{ all -> 0x021c }
            int r5 = r9.updatedNodeCount(r3)     // Catch:{ all -> 0x021c }
            int r6 = r12.size()     // Catch:{ all -> 0x021c }
            int r5 = r5 + r6
            r9.updateNodeCount(r3, r5)     // Catch:{ all -> 0x021c }
        L_0x00fc:
            androidx.compose.runtime.changelist.ComposerChangeListWriter r3 = r9.changeListWriter     // Catch:{ all -> 0x01f9 }
            androidx.compose.runtime.CompositionContext r5 = r9.parentContext     // Catch:{ all -> 0x01f9 }
            r3.copySlotTableToAnchorLocation(r4, r5, r1, r2)     // Catch:{ all -> 0x01f9 }
            androidx.compose.runtime.SlotReader r12 = r7.openReader()     // Catch:{ all -> 0x01f9 }
            androidx.compose.runtime.SlotReader r6 = r23.getReader$runtime_release()     // Catch:{ all -> 0x01ee }
            int[] r5 = r23.nodeCountOverrides     // Catch:{ all -> 0x01ee }
            androidx.compose.runtime.collection.IntMap r4 = r23.providerUpdates     // Catch:{ all -> 0x01ee }
            r3 = 0
            r9.nodeCountOverrides = r3     // Catch:{ all -> 0x01ee }
            r9.providerUpdates = r3     // Catch:{ all -> 0x01ee }
            r9.setReader$runtime_release(r12)     // Catch:{ all -> 0x01d8 }
            int r3 = r7.anchorIndex(r8)     // Catch:{ all -> 0x01d8 }
            r12.reposition(r3)     // Catch:{ all -> 0x01d8 }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r7 = r9.changeListWriter     // Catch:{ all -> 0x01d8 }
            r7.moveReaderToAbsolute(r3)     // Catch:{ all -> 0x01d8 }
            androidx.compose.runtime.changelist.ChangeList r7 = new androidx.compose.runtime.changelist.ChangeList     // Catch:{ all -> 0x01d8 }
            r7.<init>()     // Catch:{ all -> 0x01d8 }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r8 = r9.changeListWriter     // Catch:{ all -> 0x01d8 }
            androidx.compose.runtime.changelist.ChangeList r3 = r8.getChangeList()     // Catch:{ all -> 0x01d8 }
            r8.setChangeList(r7)     // Catch:{ all -> 0x01c7 }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r14 = r9.changeListWriter     // Catch:{ all -> 0x01c7 }
            r16 = r10
            boolean r10 = r14.getImplicitRootStart()     // Catch:{ all -> 0x01c3 }
            r17 = r0
            r0 = 0
            r14.setImplicitRootStart(r0)     // Catch:{ all -> 0x01b4 }
            androidx.compose.runtime.ControlledComposition r0 = r1.getComposition$runtime_release()     // Catch:{ all -> 0x01b4 }
            androidx.compose.runtime.ControlledComposition r18 = r2.getComposition$runtime_release()     // Catch:{ all -> 0x01b4 }
            int r19 = r12.getCurrentGroup()     // Catch:{ all -> 0x01b4 }
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)     // Catch:{ all -> 0x01b4 }
            java.util.List r20 = r1.getInvalidations$runtime_release()     // Catch:{ all -> 0x01b4 }
            androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1$1$1$1 r1 = new androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1$1$1$1     // Catch:{ all -> 0x01b4 }
            r1.<init>(r9, r2)     // Catch:{ all -> 0x01b4 }
            r21 = r1
            kotlin.jvm.functions.Function0 r21 = (kotlin.jvm.functions.Function0) r21     // Catch:{ all -> 0x01b4 }
            r1 = r23
            r2 = r0
            r22 = r11
            r11 = r3
            r3 = r18
            r0 = r13
            r13 = r4
            r4 = r19
            r18 = r12
            r12 = r5
            r5 = r20
            r19 = r13
            r13 = r6
            r6 = r21
            r1.recomposeMovableContent(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x01b0 }
            r14.setImplicitRootStart(r10)     // Catch:{ all -> 0x01ac }
            r8.setChangeList(r11)     // Catch:{ all -> 0x01a8 }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r1 = r9.changeListWriter     // Catch:{ all -> 0x01a8 }
            r1.includeOperationsIn(r7, r15)     // Catch:{ all -> 0x01a8 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01a8 }
            r9.setReader$runtime_release(r13)     // Catch:{ all -> 0x01ec }
            r9.nodeCountOverrides = r12     // Catch:{ all -> 0x01ec }
            r1 = r19
            r9.providerUpdates = r1     // Catch:{ all -> 0x01ec }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01ec }
            r18.close()     // Catch:{ all -> 0x0216 }
        L_0x0198:
            androidx.compose.runtime.changelist.ComposerChangeListWriter r1 = r9.changeListWriter     // Catch:{ all -> 0x0216 }
            r1.skipToEndOfCurrentGroup()     // Catch:{ all -> 0x0216 }
            int r13 = r0 + 1
            r10 = r16
            r0 = r17
            r11 = r22
            r12 = 0
            goto L_0x0018
        L_0x01a8:
            r0 = move-exception
            r1 = r19
            goto L_0x01e2
        L_0x01ac:
            r0 = move-exception
            r1 = r19
            goto L_0x01d2
        L_0x01b0:
            r0 = move-exception
            r1 = r19
            goto L_0x01bd
        L_0x01b4:
            r0 = move-exception
            r1 = r4
            r13 = r6
            r22 = r11
            r18 = r12
            r11 = r3
            r12 = r5
        L_0x01bd:
            r14.setImplicitRootStart(r10)     // Catch:{ all -> 0x01c1 }
            throw r0     // Catch:{ all -> 0x01c1 }
        L_0x01c1:
            r0 = move-exception
            goto L_0x01d2
        L_0x01c3:
            r0 = move-exception
            r1 = r4
            r13 = r6
            goto L_0x01cc
        L_0x01c7:
            r0 = move-exception
            r1 = r4
            r13 = r6
            r16 = r10
        L_0x01cc:
            r22 = r11
            r18 = r12
            r11 = r3
            r12 = r5
        L_0x01d2:
            r8.setChangeList(r11)     // Catch:{ all -> 0x01d6 }
            throw r0     // Catch:{ all -> 0x01d6 }
        L_0x01d6:
            r0 = move-exception
            goto L_0x01e2
        L_0x01d8:
            r0 = move-exception
            r1 = r4
            r13 = r6
            r16 = r10
            r22 = r11
            r18 = r12
            r12 = r5
        L_0x01e2:
            r9.setReader$runtime_release(r13)     // Catch:{ all -> 0x01ec }
            r9.nodeCountOverrides = r12     // Catch:{ all -> 0x01ec }
            r9.providerUpdates = r1     // Catch:{ all -> 0x01ec }
            throw r0     // Catch:{ all -> 0x01ec }
        L_0x01ec:
            r0 = move-exception
            goto L_0x01f5
        L_0x01ee:
            r0 = move-exception
            r16 = r10
            r22 = r11
            r18 = r12
        L_0x01f5:
            r18.close()     // Catch:{ all -> 0x0216 }
            throw r0     // Catch:{ all -> 0x0216 }
        L_0x01f9:
            r0 = move-exception
            r16 = r10
            r22 = r11
            goto L_0x0217
        L_0x01ff:
            r16 = r10
            r22 = r11
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r9.changeListWriter     // Catch:{ all -> 0x0216 }
            r0.endMovableContentPlacement()     // Catch:{ all -> 0x0216 }
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r9.changeListWriter     // Catch:{ all -> 0x0216 }
            r1 = 0
            r0.moveReaderToAbsolute(r1)     // Catch:{ all -> 0x0216 }
            r1 = r16
            r2 = r22
            r1.setChangeList(r2)
            return
        L_0x0216:
            r0 = move-exception
        L_0x0217:
            r1 = r16
            r2 = r22
            goto L_0x021f
        L_0x021c:
            r0 = move-exception
            r1 = r10
            r2 = r11
        L_0x021f:
            r1.setChangeList(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.insertMovableContentGuarded(java.util.List):void");
    }

    private final <R> R withReader(SlotReader slotReader, Function0<? extends R> function0) {
        SlotReader reader$runtime_release = getReader$runtime_release();
        int[] access$getNodeCountOverrides$p = this.nodeCountOverrides;
        IntMap access$getProviderUpdates$p = this.providerUpdates;
        this.nodeCountOverrides = null;
        this.providerUpdates = null;
        try {
            setReader$runtime_release(slotReader);
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            setReader$runtime_release(reader$runtime_release);
            this.nodeCountOverrides = access$getNodeCountOverrides$p;
            this.providerUpdates = access$getProviderUpdates$p;
            InlineMarker.finallyEnd(1);
        }
    }

    static /* synthetic */ Object recomposeMovableContent$default(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i, Object obj) {
        ControlledComposition controlledComposition3 = (i & 1) != 0 ? null : controlledComposition;
        ControlledComposition controlledComposition4 = (i & 2) != 0 ? null : controlledComposition2;
        Integer num2 = (i & 4) != 0 ? null : num;
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return composerImpl.recomposeMovableContent(controlledComposition3, controlledComposition4, num2, list, function0);
    }

    private final <R> R recomposeMovableContent(ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> list, Function0<? extends R> function0) {
        R r;
        ControlledComposition controlledComposition3 = controlledComposition;
        boolean z = this.isComposing;
        int i = this.nodeIndex;
        try {
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Pair pair = list.get(i2);
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) pair.component1();
                IdentityArraySet identityArraySet = (IdentityArraySet) pair.component2();
                if (identityArraySet != null) {
                    Object[] values = identityArraySet.getValues();
                    int size2 = identityArraySet.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Object obj = values[i3];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj);
                    }
                } else {
                    tryImminentInvalidation$runtime_release(recomposeScopeImpl, (Object) null);
                }
            }
            if (controlledComposition3 != null) {
                r = controlledComposition.delegateInvalidations(controlledComposition2, num != null ? num.intValue() : -1, function0);
                if (r == null) {
                }
                return r;
            }
            Function0<? extends R> function02 = function0;
            r = function0.invoke();
            return r;
        } finally {
            this.isComposing = z;
            this.nodeIndex = i;
        }
    }

    @ComposeCompilerApi
    public void sourceInformation(String str) {
        if (getInserting() && this.sourceInformationEnabled) {
            this.writer.recordGroupSourceInformation(str);
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int i, String str) {
        if (getInserting() && this.sourceInformationEnabled) {
            this.writer.recordGrouplessCallSourceInformationStart(i, str);
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        if (getInserting() && this.sourceInformationEnabled) {
            this.writer.recordGrouplessCallSourceInformationEnd();
        }
    }

    public void disableSourceInformation() {
        this.sourceInformationEnabled = false;
    }

    public final void composeContent$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (this.changes.isEmpty()) {
            doCompose(identityArrayMap, function2);
        } else {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void prepareCompose$runtime_release(Function0<Unit> function0) {
        if (!this.isComposing) {
            this.isComposing = true;
            try {
                function0.invoke();
            } finally {
                this.isComposing = false;
            }
        } else {
            ComposerKt.composeRuntimeError("Preparing a composition while composing is not supported".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean recompose$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        } else if (!identityArrayMap.isNotEmpty() && !(!this.invalidations.isEmpty()) && !this.forciblyRecompose) {
            return false;
        } else {
            doCompose(identityArrayMap, (Function2<? super Composer, ? super Integer, Unit>) null);
            return this.changes.isNotEmpty();
        }
    }

    private final void doCompose(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, Function2<? super Composer, ? super Integer, Unit> function2) {
        MutableVector<DerivedStateObserver> derivedStateObservers;
        if (!this.isComposing) {
            Object beginSection = Trace.INSTANCE.beginSection("Compose:recompose");
            try {
                this.compositionToken = SnapshotKt.currentSnapshot().getId();
                this.providerUpdates = null;
                int size = identityArrayMap.getSize();
                int i = 0;
                while (i < size) {
                    Object obj = identityArrayMap.getKeys()[i];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                    IdentityArraySet identityArraySet = (IdentityArraySet) identityArrayMap.getValues()[i];
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                    Anchor anchor = recomposeScopeImpl.getAnchor();
                    if (anchor != null) {
                        this.invalidations.add(new Invalidation(recomposeScopeImpl, anchor.getLocation$runtime_release(), identityArraySet));
                        i++;
                    } else {
                        return;
                    }
                }
                CollectionsKt.sortWith(this.invalidations, ComposerKt.InvalidationLocationAscending);
                this.nodeIndex = 0;
                this.isComposing = true;
                try {
                    startRoot();
                    Object nextSlot = nextSlot();
                    if (!(nextSlot == function2 || function2 == null)) {
                        updateValue(function2);
                    }
                    DerivedStateObserver derivedStateObserver2 = this.derivedStateObserver;
                    derivedStateObservers = SnapshotStateKt.derivedStateObservers();
                    derivedStateObservers.add(derivedStateObserver2);
                    if (function2 != null) {
                        startGroup(200, ComposerKt.getInvocation());
                        ActualJvm_jvmKt.invokeComposable(this, function2);
                        endGroup();
                    } else if ((this.forciblyRecompose || this.providersInvalid) && nextSlot != null && !Intrinsics.areEqual(nextSlot, Composer.Companion.getEmpty())) {
                        startGroup(200, ComposerKt.getInvocation());
                        ActualJvm_jvmKt.invokeComposable(this, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(nextSlot, 2));
                        endGroup();
                    } else {
                        skipCurrentGroup();
                    }
                    derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                    endRoot();
                    this.isComposing = false;
                    this.invalidations.clear();
                    createFreshInsertTable();
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                } catch (Throwable th) {
                    this.isComposing = false;
                    this.invalidations.clear();
                    abortRoot();
                    createFreshInsertTable();
                    throw th;
                }
            } finally {
                Trace.INSTANCE.endSection(beginSection);
            }
        } else {
            ComposerKt.composeRuntimeError("Reentrant composition is not supported".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    private final Object nodeAt(SlotReader slotReader, int i) {
        return slotReader.node(i);
    }

    private final void validateNodeExpected() {
        if (this.nodeExpected) {
            this.nodeExpected = false;
        } else {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void validateNodeNotExpected() {
        if (!(!this.nodeExpected)) {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            this.changeListWriter.insertSlots(anchor, this.insertTable);
            return;
        }
        this.changeListWriter.insertSlots(anchor, this.insertTable, this.insertFixups);
        this.insertFixups = new FixupList();
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        this.changeListWriter.removeCurrentGroup();
    }

    private static final int reportFreeMovableContent$reportGroup(ComposerImpl composerImpl, int i, boolean z, int i2) {
        ComposerImpl composerImpl2 = composerImpl;
        int i3 = i;
        int i4 = i2;
        SlotReader slotReader = composerImpl2.reader;
        if (slotReader.hasMark(i3)) {
            int groupKey = slotReader.groupKey(i3);
            Object groupObjectKey = slotReader.groupObjectKey(i3);
            if (groupKey == 126665345 && (groupObjectKey instanceof MovableContent)) {
                MovableContent movableContent = (MovableContent) groupObjectKey;
                Object groupGet = slotReader.groupGet(i3, 0);
                Anchor anchor = slotReader.anchor(i3);
                List access$filterToRange = ComposerKt.filterToRange(composerImpl2.invalidations, i3, slotReader.groupSize(i3) + i3);
                ArrayList arrayList = new ArrayList(access$filterToRange.size());
                int size = access$filterToRange.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Invalidation invalidation = (Invalidation) access$filterToRange.get(i5);
                    arrayList.add(TuplesKt.to(invalidation.getScope(), invalidation.getInstances()));
                }
                MovableContentStateReference movableContentStateReference = new MovableContentStateReference(movableContent, groupGet, composerImpl.getComposition(), composerImpl2.slotTable, anchor, arrayList, composerImpl.currentCompositionLocalScope(i));
                composerImpl2.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
                composerImpl2.changeListWriter.recordSlotEditing();
                composerImpl2.changeListWriter.releaseMovableGroupAtCurrent(composerImpl.getComposition(), composerImpl2.parentContext, movableContentStateReference);
                if (!z) {
                    return slotReader.nodeCount(i3);
                }
                composerImpl2.changeListWriter.endNodeMovementAndDeleteNode(i4, i3);
                return 0;
            } else if (groupKey == 206 && Intrinsics.areEqual(groupObjectKey, ComposerKt.getReference())) {
                Object groupGet2 = slotReader.groupGet(i3, 0);
                CompositionContextHolder compositionContextHolder = groupGet2 instanceof CompositionContextHolder ? (CompositionContextHolder) groupGet2 : null;
                if (compositionContextHolder != null) {
                    for (ComposerImpl composerImpl3 : compositionContextHolder.getRef().getComposers()) {
                        composerImpl3.reportAllMovableContent();
                        composerImpl2.parentContext.reportRemovedComposition$runtime_release(composerImpl3.getComposition());
                    }
                }
                return slotReader.nodeCount(i3);
            } else if (slotReader.isNode(i3)) {
                return 1;
            } else {
                return slotReader.nodeCount(i3);
            }
        } else if (slotReader.containsMark(i3)) {
            int groupSize = slotReader.groupSize(i3) + i3;
            int i6 = 0;
            for (int i7 = i3 + 1; i7 < groupSize; i7 += slotReader.groupSize(i7)) {
                boolean isNode = slotReader.isNode(i7);
                if (isNode) {
                    composerImpl2.changeListWriter.endNodeMovement();
                    composerImpl2.changeListWriter.moveDown(slotReader.node(i7));
                }
                i6 += reportFreeMovableContent$reportGroup(composerImpl2, i7, isNode || z, isNode ? 0 : i4 + i6);
                if (isNode) {
                    composerImpl2.changeListWriter.endNodeMovement();
                    composerImpl2.changeListWriter.moveUp();
                }
            }
            if (slotReader.isNode(i3)) {
                return 1;
            }
            return i6;
        } else if (slotReader.isNode(i3)) {
            return 1;
        } else {
            return slotReader.nodeCount(i3);
        }
    }

    private final void reportFreeMovableContent(int i) {
        reportFreeMovableContent$reportGroup(this, i, false, 0);
        this.changeListWriter.endNodeMovement();
    }

    private final void reportAllMovableContent() {
        ComposerChangeListWriter composerChangeListWriter;
        ChangeList changeList;
        if (this.slotTable.containsMark()) {
            ChangeList changeList2 = new ChangeList();
            this.deferredChanges = changeList2;
            SlotReader openReader = this.slotTable.openReader();
            try {
                this.reader = openReader;
                composerChangeListWriter = this.changeListWriter;
                changeList = composerChangeListWriter.getChangeList();
                composerChangeListWriter.setChangeList(changeList2);
                reportFreeMovableContent(0);
                this.changeListWriter.releaseMovableContent();
                composerChangeListWriter.setChangeList(changeList);
                Unit unit = Unit.INSTANCE;
                openReader.close();
            } catch (Throwable th) {
                openReader.close();
                throw th;
            }
        }
    }

    private final void finalizeCompose() {
        this.changeListWriter.finalizeComposition();
        if (this.pendingStack.isEmpty()) {
            cleanUpCompose();
        } else {
            ComposerKt.composeRuntimeError("Start/end imbalance".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.changeListWriter.resetTransientState();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    public final void verifyConsistent$runtime_release() {
        this.insertTable.verifyWellFormed();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/ReusableRememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composer.kt */
    private static final class CompositionContextHolder implements ReusableRememberObserver {
        private final CompositionContextImpl ref;

        public void onRemembered() {
        }

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            this.ref = compositionContextImpl;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        public void onAbandoned() {
            this.ref.dispose();
        }

        public void onForgotten() {
            this.ref.dispose();
        }
    }

    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ*\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020-01¢\u0006\u0002\b2H\u0010¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0010¢\u0006\u0002\b8J\u0006\u00109\u001a\u00020-J\r\u0010:\u001a\u00020-H\u0010¢\u0006\u0002\b;J\r\u0010\u0015\u001a\u00020\u0013H\u0010¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0010¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0010¢\u0006\u0002\b@J\u0015\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020CH\u0010¢\u0006\u0002\bDJ\u001d\u0010E\u001a\u00020-2\u0006\u00106\u001a\u0002072\u0006\u0010F\u001a\u00020GH\u0010¢\u0006\u0002\bHJ\u0017\u0010I\u001a\u0004\u0018\u00010G2\u0006\u00106\u001a\u000207H\u0010¢\u0006\u0002\bJJ\u001b\u0010K\u001a\u00020-2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\"0\u000eH\u0010¢\u0006\u0002\bMJ\u0015\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u00020PH\u0010¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0010¢\u0006\u0002\bUJ\r\u0010V\u001a\u00020-H\u0010¢\u0006\u0002\bWJ\u0015\u0010X\u001a\u00020-2\u0006\u0010O\u001a\u00020PH\u0010¢\u0006\u0002\bYJ\u0015\u0010Z\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0010¢\u0006\u0002\b[J\u000e\u0010\\\u001a\u00020-2\u0006\u0010B\u001a\u00020\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138B@BX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u000e\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010%R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u001e8PX\u0004¢\u0006\f\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010 ¨\u0006]"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "collectingSourceInformation", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "(Landroidx/compose/runtime/ComposerImpl;IZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "getCollectingParameterInformation$runtime_release", "()Z", "getCollectingSourceInformation$runtime_release", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "deletedMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "deletedMovableContent$runtime_release", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "movableContentStateReleased", "data", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composer.kt */
    private final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final Set<ComposerImpl> composers = new LinkedHashSet();
        private final MutableState compositionLocalScope$delegate = SnapshotStateKt.mutableStateOf(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), SnapshotStateKt.referentialEqualityPolicy());
        private final int compoundHashKey;
        private Set<Set<CompositionData>> inspectionTables;
        private final CompositionObserverHolder observerHolder;

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }

        public CompositionContextImpl(int i, boolean z, boolean z2, CompositionObserverHolder compositionObserverHolder) {
            this.compoundHashKey = i;
            this.collectingParameterInformation = z;
            this.collectingSourceInformation = z2;
            this.observerHolder = compositionObserverHolder;
        }

        public int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        public boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        public boolean getCollectingSourceInformation$runtime_release() {
            return this.collectingSourceInformation;
        }

        public CompositionObserverHolder getObserverHolder$runtime_release() {
            return this.observerHolder;
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        public final void setInspectionTables(Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        public final void dispose() {
            if (!this.composers.isEmpty()) {
                Set<Set<CompositionData>> set = this.inspectionTables;
                if (set != null) {
                    for (ComposerImpl next : this.composers) {
                        for (Set<CompositionData> remove : set) {
                            remove.remove(next.slotTable);
                        }
                    }
                }
                this.composers.clear();
            }
        }

        public void registerComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        public void unregisterComposer$runtime_release(Composer composer) {
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (Set remove : set) {
                    Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                    remove.remove(((ComposerImpl) composer).slotTable);
                }
            }
            TypeIntrinsics.asMutableCollection(this.composers).remove(composer);
        }

        public void registerComposition$runtime_release(ControlledComposition controlledComposition) {
            ComposerImpl.this.parentContext.registerComposition$runtime_release(controlledComposition);
        }

        public void unregisterComposition$runtime_release(ControlledComposition controlledComposition) {
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(controlledComposition);
        }

        public CoroutineContext getEffectCoroutineContext() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext();
        }

        public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(ComposerImpl.this.getComposition());
        }

        public void composeInitial$runtime_release(ControlledComposition controlledComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
            ComposerImpl.this.parentContext.composeInitial$runtime_release(controlledComposition, function2);
        }

        public void invalidate$runtime_release(ControlledComposition controlledComposition) {
            ComposerImpl.this.parentContext.invalidate$runtime_release(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime_release(controlledComposition);
        }

        public void invalidateScope$runtime_release(RecomposeScopeImpl recomposeScopeImpl) {
            ComposerImpl.this.parentContext.invalidateScope$runtime_release(recomposeScopeImpl);
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope$delegate.getValue();
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            this.compositionLocalScope$delegate.setValue(persistentCompositionLocalMap);
        }

        public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        public final void updateCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            setCompositionLocalScope(persistentCompositionLocalMap);
        }

        public void recordInspectionTable$runtime_release(Set<CompositionData> set) {
            Set<Set<CompositionData>> set2 = this.inspectionTables;
            if (set2 == null) {
                set2 = new HashSet<>();
                this.inspectionTables = set2;
            }
            set2.add(set);
        }

        public void startComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing = composerImpl.childrenComposing + 1;
        }

        public void doneComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing = composerImpl.childrenComposing - 1;
        }

        public void insertMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
            ComposerImpl.this.parentContext.insertMovableContent$runtime_release(movableContentStateReference);
        }

        public void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
            ComposerImpl.this.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
        }

        public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference movableContentStateReference) {
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReference);
        }

        public void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState) {
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime_release(movableContentStateReference, movableContentState);
        }

        public void reportRemovedComposition$runtime_release(ControlledComposition controlledComposition) {
            ComposerImpl.this.parentContext.reportRemovedComposition$runtime_release(controlledComposition);
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int i, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null || i != 207 || Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                updateCompoundKeyWhenWeEnterGroupKeyHash(i);
            } else {
                updateCompoundKeyWhenWeEnterGroupKeyHash(obj2.hashCode());
            }
        } else if (obj instanceof Enum) {
            updateCompoundKeyWhenWeEnterGroupKeyHash(((Enum) obj).ordinal());
        } else {
            updateCompoundKeyWhenWeEnterGroupKeyHash(obj.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int i) {
        this.compoundKeyHash = i ^ Integer.rotateLeft(getCompoundKeyHash(), 3);
    }

    private final void updateCompoundKeyWhenWeExitGroup(int i, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null || i != 207 || Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                updateCompoundKeyWhenWeExitGroupKeyHash(i);
            } else {
                updateCompoundKeyWhenWeExitGroupKeyHash(obj2.hashCode());
            }
        } else if (obj instanceof Enum) {
            updateCompoundKeyWhenWeExitGroupKeyHash(((Enum) obj).ordinal());
        } else {
            updateCompoundKeyWhenWeExitGroupKeyHash(obj.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int i) {
        this.compoundKeyHash = Integer.rotateRight(i ^ getCompoundKeyHash(), 3);
    }

    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            return currentRecomposeScope$runtime_release.getAnchor();
        }
        return null;
    }

    public Object rememberedValue() {
        return nextSlotForCache();
    }

    public void updateRememberedValue(Object obj) {
        updateCachedValue(obj);
    }

    public void recordUsed(RecomposeScope recomposeScope) {
        RecomposeScopeImpl recomposeScopeImpl = recomposeScope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) recomposeScope : null;
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
        }
    }

    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2) {
        PersistentCompositionLocalMap.Builder builder = persistentCompositionLocalMap.builder();
        builder.putAll(persistentCompositionLocalMap2);
        PersistentCompositionLocalMap build = builder.build();
        startGroup(ComposerKt.providerMapsKey, ComposerKt.getProviderMaps());
        updateSlot(build);
        updateSlot(persistentCompositionLocalMap2);
        endGroup();
        return build;
    }
}
