package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\bA\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ¯\u00012\u00020\u0001:\u0002¯\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\nJ\u0010\u00109\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020\nJ\u000e\u0010;\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0007J\u0006\u0010<\u001a\u000207J\u0006\u0010=\u001a\u000207J\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\nH\u0002J\b\u0010@\u001a\u000207H\u0002J\u0006\u0010A\u001a\u000207J\u0010\u0010B\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\nH\u0002J\u0010\u0010C\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\nH\u0002J \u0010D\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010F\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0002J\u0010\u0010G\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nH\u0002J(\u0010H\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010J\u001a\u00020\nJ\u0006\u0010K\u001a\u000207J\u000e\u0010L\u001a\u0002072\u0006\u00109\u001a\u00020\u0007J\u000e\u0010L\u001a\u0002072\u0006\u0010:\u001a\u00020\nJ \u0010M\u001a\u0002072\u0006\u0010#\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n2\u0006\u0010N\u001a\u00020\nH\u0002JK\u0010O\u001a\u0002072\u0006\u0010?\u001a\u00020\n28\u0010P\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(T\u0012\u0004\u0012\u0002070QH\bJ\u0010\u0010U\u001a\u0004\u0018\u00010\u00012\u0006\u0010:\u001a\u00020\nJ\u0010\u0010V\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0002J\u000e\u0010W\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nJ\u0010\u0010X\u001a\u0004\u0018\u00010\u00012\u0006\u0010:\u001a\u00020\nJ\u000e\u0010Y\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nJ\u000e\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010[J\u001a\u0010\\\u001a\u0002012\u0006\u0010#\u001a\u00020\n2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0006\u0010_\u001a\u00020^J\u000e\u0010`\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\nJ\u0016\u0010a\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nJ\u000e\u0010b\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\nJ\u0010\u0010c\u001a\u0002072\b\u0010d\u001a\u0004\u0018\u00010\u0001J\u0010\u0010e\u001a\u0002072\u0006\u0010'\u001a\u00020\nH\u0002J\u0018\u0010f\u001a\u0002072\u0006\u0010'\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0002J\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\nJ\u000e\u0010g\u001a\b\u0012\u0004\u0012\u00020\n0hH\u0002J\u0010\u0010i\u001a\u0002072\b\b\u0002\u0010?\u001a\u00020\nJ \u0010j\u001a\u0002072\u0006\u0010k\u001a\u00020\n2\u0006\u0010l\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0002J&\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00070h2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\n2\b\b\u0002\u0010n\u001a\u00020\u000eJ\u000e\u0010o\u001a\u0002072\u0006\u0010p\u001a\u00020\nJ\u0010\u0010q\u001a\u0002072\u0006\u0010:\u001a\u00020\nH\u0002J$\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00070h2\u0006\u0010p\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\nJ\u0018\u0010s\u001a\u0002072\u0006\u0010:\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0002J$\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00070h2\u0006\u00109\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\n2\u0006\u0010u\u001a\u00020\u0000J\u0010\u0010v\u001a\u0004\u0018\u00010\u00012\u0006\u00109\u001a\u00020\u0007J\u0010\u0010v\u001a\u0004\u0018\u00010\u00012\u0006\u0010:\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nJ\u000e\u0010#\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nJ\u0010\u0010w\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0002J\u0018\u0010x\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nH\u0002J\b\u0010y\u001a\u000207H\u0002J\u000e\u0010z\u001a\u0002072\u0006\u0010]\u001a\u00020^J\u0006\u0010{\u001a\u000207J\u0016\u0010|\u001a\u0002072\u0006\u0010}\u001a\u00020\n2\u0006\u0010d\u001a\u00020^J@\u0010~\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2&\u0010/\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000201\u0018\u000100j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000201\u0018\u0001`2H\u0002J\u0006\u0010\u001a\u00020\u000eJ\u001b\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0002J#\u0010\u0001\u001a\u0002072\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0002J\u0007\u0010\u0001\u001a\u000207J\t\u0010\u0001\u001a\u00020\nH\u0002J\t\u0010\u0001\u001a\u000207H\u0002J\u000f\u0010\u0001\u001a\u0002072\u0006\u00109\u001a\u00020\u0007J\u0011\u0010\u0001\u001a\u0002072\b\u0010d\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010:\u001a\u00020\n2\b\u0010d\u001a\u0004\u0018\u00010\u0001J#\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010?\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\b\u0010d\u001a\u0004\u0018\u00010\u0001J\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010\u0001\u001a\u00020\nJ\u0007\u0010\u0001\u001a\u000207J\u0019\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\nJ\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nJ\u0013\u0010\u0001\u001a\u0004\u0018\u0001012\u0006\u0010?\u001a\u00020\nH\u0002J\u001a\u0010\u0001\u001a\u0002072\u0006\u0010}\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J%\u0010\u0001\u001a\u0002072\u0006\u0010}\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010\u0001\u001a\u000207J\u000f\u0010\u0001\u001a\u0002072\u0006\u0010}\u001a\u00020\nJ\u001a\u0010\u0001\u001a\u0002072\u0006\u0010}\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J/\u0010\u0001\u001a\u0002072\u0006\u0010}\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u00020\u000e2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010\u0001\u001a\u0002072\u0006\u0010}\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J$\u0010\u0001\u001a\u0002072\u0006\u0010}\u001a\u00020\n2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010v\u001a\u0004\u0018\u00010\u0001J\t\u0010\u0001\u001a\u00020^H\u0016J\u0019\u0010\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010?\u001a\u00020\nH\u0000¢\u0006\u0003\b\u0001J\u0013\u0010\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010d\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0001\u001a\u0002072\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u0001\u001a\u0002072\b\u0010d\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u0001\u001a\u0002072\u0006\u0010?\u001a\u00020\nH\u0002J\u001a\u0010\u0001\u001a\u0002072\u0006\u0010?\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020&H\u0002J\u0019\u0010\u0001\u001a\u0002072\u0006\u00109\u001a\u00020\u00072\b\u0010d\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u0001\u001a\u0002072\b\u0010d\u001a\u0004\u0018\u00010\u0001J\u001b\u0010 \u0001\u001a\u0002072\u0006\u0010:\u001a\u00020\n2\b\u0010d\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010¡\u0001\u001a\u0002072\b\u0010d\u001a\u0004\u0018\u00010\u0001J\u000f\u0010¢\u0001\u001a\u000207H\u0000¢\u0006\u0003\b£\u0001J\u000f\u0010¤\u0001\u001a\u000207H\u0000¢\u0006\u0003\b¥\u0001J\u0016\u0010¦\u0001\u001a\u00020\n*\u00020\u001d2\u0007\u0010§\u0001\u001a\u00020\nH\u0002J\u0015\u0010F\u001a\u00020\n*\u00020\u001d2\u0007\u0010§\u0001\u001a\u00020\nH\u0002J\u0013\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\n0h*\u00020\u001dH\u0002J\u001b\u0010©\u0001\u001a\u000207*\b0ª\u0001j\u0003`«\u00012\u0006\u0010:\u001a\u00020\nH\u0002J\u0016\u0010¬\u0001\u001a\u00020\n*\u00020\u001d2\u0007\u0010§\u0001\u001a\u00020\nH\u0002J\u0014\u0010#\u001a\u00020\n*\u00020\u001d2\u0006\u0010:\u001a\u00020\nH\u0002J\u0016\u0010­\u0001\u001a\u00020\n*\u00020\u001d2\u0007\u0010§\u0001\u001a\u00020\nH\u0002J\u001e\u0010®\u0001\u001a\u000207*\u00020\u001d2\u0007\u0010§\u0001\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u001e\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u0011\u0010 \u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b \u0010\u0011R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\fR\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\fR\u0018\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010*X\u000e¢\u0006\u0004\n\u0002\u0010+R\u000e\u0010,\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R.\u0010/\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000201\u0018\u000100j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000201\u0018\u0001`2X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006°\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "capacity", "", "getCapacity", "()I", "<set-?>", "", "closed", "getClosed", "()Z", "currentGroup", "getCurrentGroup", "currentGroupEnd", "getCurrentGroupEnd", "currentSlot", "currentSlotEnd", "endStack", "Landroidx/compose/runtime/IntStack;", "groupGapLen", "groupGapStart", "groups", "", "insertCount", "isGroupEnd", "isNode", "nodeCount", "nodeCountStack", "parent", "getParent", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "size", "getSize$runtime_release", "slots", "", "[Ljava/lang/Object;", "slotsGapLen", "slotsGapOwner", "slotsGapStart", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "startStack", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "advanceBy", "", "amount", "anchor", "index", "anchorIndex", "bashCurrentGroup", "beginInsert", "childContainsAnyMarks", "group", "clearSlotGap", "close", "containsAnyGroupMarks", "containsGroupMark", "dataAnchorToDataIndex", "gapLen", "dataIndex", "dataIndexToDataAddress", "dataIndexToDataAnchor", "gapStart", "endGroup", "endInsert", "ensureStarted", "fixParentAnchorsFor", "firstChild", "forEachData", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "groupAux", "groupIndexToAddress", "groupKey", "groupObjectKey", "groupSize", "groupSlots", "", "groupSourceInformationFor", "sourceInformation", "", "groupsAsString", "indexInCurrentGroup", "indexInGroup", "indexInParent", "insertAux", "value", "insertGroups", "insertSlots", "keys", "", "markGroup", "moveAnchors", "originalLocation", "newLocation", "moveFrom", "removeSourceGroup", "moveGroup", "offset", "moveGroupGapTo", "moveIntoGroupFrom", "moveSlotGapTo", "moveTo", "writer", "node", "parentAnchorToIndex", "parentIndexToAnchor", "recalculateMarks", "recordGroupSourceInformation", "recordGrouplessCallSourceInformationEnd", "recordGrouplessCallSourceInformationStart", "key", "removeAnchors", "removeGroup", "removeGroups", "start", "len", "removeSlots", "reset", "restoreCurrentGroupEnd", "saveCurrentGroupEnd", "seek", "set", "skip", "skipGroup", "skipToGroupEnd", "slot", "groupIndex", "sourceInformationOf", "startData", "aux", "objectKey", "startGroup", "dataKey", "startNode", "toString", "tryAnchor", "tryAnchor$runtime_release", "update", "updateAnchors", "previousGapStart", "newGapStart", "updateAux", "updateContainsMark", "updateContainsMarkNow", "updateNode", "updateNodeOfGroup", "updateParentNode", "verifyDataAnchors", "verifyDataAnchors$runtime_release", "verifyParentAnchors", "verifyParentAnchors$runtime_release", "auxIndex", "address", "dataIndexes", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nodeIndex", "slotIndex", "updateDataIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class SlotWriter {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public ArrayList<Anchor> anchors;
    private boolean closed;
    /* access modifiers changed from: private */
    public int currentGroup;
    private int currentGroupEnd;
    /* access modifiers changed from: private */
    public int currentSlot;
    private int currentSlotEnd;
    private final IntStack endStack = new IntStack();
    private int groupGapLen;
    /* access modifiers changed from: private */
    public int groupGapStart;
    /* access modifiers changed from: private */
    public int[] groups;
    private int insertCount;
    /* access modifiers changed from: private */
    public int nodeCount;
    private final IntStack nodeCountStack = new IntStack();
    private int parent;
    private PrioritySet pendingRecalculateMarks;
    /* access modifiers changed from: private */
    public Object[] slots;
    /* access modifiers changed from: private */
    public int slotsGapLen;
    /* access modifiers changed from: private */
    public int slotsGapOwner;
    /* access modifiers changed from: private */
    public int slotsGapStart;
    /* access modifiers changed from: private */
    public HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final IntStack startStack = new IntStack();
    private final SlotTable table;

    private final int dataAnchorToDataIndex(int i, int i2, int i3) {
        return i < 0 ? (i3 - i2) + i + 1 : i;
    }

    /* access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int i, int i2, int i3, int i4) {
        return i > i2 ? -(((i4 - i3) - i) + 1) : i;
    }

    public SlotWriter(SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        this.slots = slotTable.getSlots();
        this.anchors = slotTable.getAnchors$runtime_release();
        this.sourceInformationMap = slotTable.getSourceInformationMap$runtime_release();
        this.groupGapStart = slotTable.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - slotTable.getGroupsSize();
        this.slotsGapStart = slotTable.getSlotsSize();
        this.slotsGapLen = this.slots.length - slotTable.getSlotsSize();
        this.slotsGapOwner = slotTable.getGroupsSize();
        this.currentGroupEnd = slotTable.getGroupsSize();
        this.parent = -1;
    }

    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final boolean isNode() {
        int i = this.currentGroup;
        return i < this.currentGroupEnd && SlotTableKt.isNode(this.groups, groupIndexToAddress(i));
    }

    public final boolean isNode(int i) {
        return SlotTableKt.isNode(this.groups, groupIndexToAddress(i));
    }

    public final int nodeCount(int i) {
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress(i));
    }

    public final int groupKey(int i) {
        return SlotTableKt.key(this.groups, groupIndexToAddress(i));
    }

    public final Object groupObjectKey(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        if (SlotTableKt.hasObjectKey(this.groups, groupIndexToAddress)) {
            return this.slots[SlotTableKt.objectKeyIndex(this.groups, groupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int i) {
        return SlotTableKt.groupSize(this.groups, groupIndexToAddress(i));
    }

    public final Object groupAux(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        return SlotTableKt.hasAux(this.groups, groupIndexToAddress) ? this.slots[auxIndex(this.groups, groupIndexToAddress)] : Composer.Companion.getEmpty();
    }

    public final boolean indexInParent(int i) {
        int i2 = this.parent;
        return (i > i2 && i < this.currentGroupEnd) || (i2 == 0 && i == 0);
    }

    public final boolean indexInCurrentGroup(int i) {
        return indexInGroup(i, this.currentGroup);
    }

    public final boolean indexInGroup(int i, int i2) {
        int i3;
        int groupSize;
        if (i2 == this.parent) {
            i3 = this.currentGroupEnd;
        } else {
            if (i2 > this.startStack.peekOr(0)) {
                groupSize = groupSize(i2);
            } else {
                int indexOf = this.startStack.indexOf(i2);
                if (indexOf < 0) {
                    groupSize = groupSize(i2);
                } else {
                    i3 = (getCapacity() - this.groupGapLen) - this.endStack.peek(indexOf);
                }
            }
            i3 = groupSize + i2;
        }
        if (i <= i2 || i >= i3) {
            return false;
        }
        return true;
    }

    public final Object node(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))];
        }
        return null;
    }

    public final Object node(Anchor anchor) {
        return node(anchor.toIndexFor(this));
    }

    public final int getParent() {
        return this.parent;
    }

    public final int parent(int i) {
        return parent(this.groups, i);
    }

    public final int parent(Anchor anchor) {
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final void close() {
        this.closed = true;
        if (this.startStack.isEmpty()) {
            moveGroupGapTo(getSize$runtime_release());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            clearSlotGap();
            recalculateMarks();
        }
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap);
    }

    public final void reset() {
        if (this.insertCount == 0) {
            recalculateMarks();
            this.currentGroup = 0;
            this.currentGroupEnd = getCapacity() - this.groupGapLen;
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            this.nodeCount = 0;
            return;
        }
        ComposerKt.composeRuntimeError("Cannot reset when inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final Object update(Object obj) {
        Object skip = skip();
        set(obj);
        return skip;
    }

    public final void updateAux(Object obj) {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (SlotTableKt.hasAux(this.groups, groupIndexToAddress)) {
            this.slots[dataIndexToDataAddress(auxIndex(this.groups, groupIndexToAddress))] = obj;
        } else {
            ComposerKt.composeRuntimeError("Updating the data of a group that was not created with a data slot".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void insertAux(Object obj) {
        if (this.insertCount >= 0) {
            int i = this.parent;
            int groupIndexToAddress = groupIndexToAddress(i);
            if (!SlotTableKt.hasAux(this.groups, groupIndexToAddress)) {
                insertSlots(1, i);
                int auxIndex = auxIndex(this.groups, groupIndexToAddress);
                int dataIndexToDataAddress = dataIndexToDataAddress(auxIndex);
                int i2 = this.currentSlot;
                if (i2 > auxIndex) {
                    int i3 = i2 - auxIndex;
                    if (i3 < 3) {
                        if (i3 > 1) {
                            Object[] objArr = this.slots;
                            objArr[dataIndexToDataAddress + 2] = objArr[dataIndexToDataAddress + 1];
                        }
                        Object[] objArr2 = this.slots;
                        objArr2[dataIndexToDataAddress + 1] = objArr2[dataIndexToDataAddress];
                    } else {
                        throw new IllegalStateException("Moving more than two slot not supported".toString());
                    }
                }
                SlotTableKt.addAux(this.groups, groupIndexToAddress);
                this.slots[dataIndexToDataAddress] = obj;
                this.currentSlot++;
                return;
            }
            ComposerKt.composeRuntimeError("Group already has auxiliary data".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Cannot insert auxiliary data when not inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void recordGroupSourceInformation(String str) {
        if (this.insertCount > 0) {
            groupSourceInformationFor(this.parent, str);
        }
    }

    public final void recordGrouplessCallSourceInformationStart(int i, String str) {
        if (this.insertCount > 0) {
            groupSourceInformationFor(this.parent, (String) null).startGrouplessCall(i, str);
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        if (this.insertCount > 0) {
            groupSourceInformationFor(this.parent, (String) null).endGrouplessCall();
        }
    }

    private final GroupSourceInformation groupSourceInformationFor(int i, String str) {
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        this.sourceInformationMap = hashMap;
        Map map = hashMap;
        Anchor anchor = anchor(i);
        Object obj = map.get(anchor);
        GroupSourceInformation groupSourceInformation = obj;
        if (obj == null) {
            GroupSourceInformation groupSourceInformation2 = new GroupSourceInformation(0, str);
            if (str == null) {
                int i2 = i + 1;
                int i3 = this.currentGroup;
                while (i2 < i3) {
                    groupSourceInformation2.reportGroup(this, i2);
                    i2 += SlotTableKt.groupSize(this.groups, i2);
                }
            }
            map.put(anchor, groupSourceInformation2);
            groupSourceInformation = groupSourceInformation2;
        }
        return (GroupSourceInformation) groupSourceInformation;
    }

    public final void updateNode(Object obj) {
        updateNodeOfGroup(this.currentGroup, obj);
    }

    public final void updateNode(Anchor anchor, Object obj) {
        updateNodeOfGroup(anchor.toIndexFor(this), obj);
    }

    public final void updateParentNode(Object obj) {
        updateNodeOfGroup(this.parent, obj);
    }

    public final void set(Object obj) {
        int i = this.currentSlot;
        if (i <= this.currentSlotEnd) {
            this.slots[dataIndexToDataAddress(i - 1)] = obj;
        } else {
            ComposerKt.composeRuntimeError("Writing to an invalid slot".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final Object set(int i, Object obj) {
        return set(this.currentGroup, i, obj);
    }

    public final Object set(int i, int i2, Object obj) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int i3 = slotIndex + i2;
        if (i3 >= slotIndex && i3 < dataIndex(this.groups, groupIndexToAddress(i + 1))) {
            int dataIndexToDataAddress = dataIndexToDataAddress(i3);
            Object[] objArr = this.slots;
            Object obj2 = objArr[dataIndexToDataAddress];
            objArr[dataIndexToDataAddress] = obj;
            return obj2;
        }
        ComposerKt.composeRuntimeError(("Write to an invalid slot index " + i2 + " for group " + i).toString());
        throw new KotlinNothingValueException();
    }

    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        return objArr[dataIndexToDataAddress(i)];
    }

    public final Object slot(Anchor anchor, int i) {
        return slot(anchorIndex(anchor), i);
    }

    public final Object slot(int i, int i2) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1));
        int i3 = i2 + slotIndex;
        if (slotIndex > i3 || i3 >= dataIndex) {
            return Composer.Companion.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(i3)];
    }

    public final void advanceBy(int i) {
        boolean z = true;
        if (!(i >= 0)) {
            ComposerKt.composeRuntimeError("Cannot seek backwards".toString());
            throw new KotlinNothingValueException();
        } else if (this.insertCount > 0) {
            throw new IllegalStateException("Cannot call seek() while inserting".toString());
        } else if (i != 0) {
            int i2 = this.currentGroup + i;
            if (i2 < this.parent || i2 > this.currentGroupEnd) {
                z = false;
            }
            if (z) {
                this.currentGroup = i2;
                int dataIndex = dataIndex(this.groups, groupIndexToAddress(i2));
                this.currentSlot = dataIndex;
                this.currentSlotEnd = dataIndex;
                return;
            }
            ComposerKt.composeRuntimeError(("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')').toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void seek(Anchor anchor) {
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void skipToGroupEnd() {
        int i = this.currentGroupEnd;
        this.currentGroup = i;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i));
    }

    public final void beginInsert() {
        int i = this.insertCount;
        this.insertCount = i + 1;
        if (i == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void endInsert() {
        int i = this.insertCount;
        if (i > 0) {
            int i2 = i - 1;
            this.insertCount = i2;
            if (i2 == 0) {
                if (this.nodeCountStack.getSize() == this.startStack.getSize()) {
                    restoreCurrentGroupEnd();
                } else {
                    ComposerKt.composeRuntimeError("startGroup/endGroup mismatch while inserting".toString());
                    throw new KotlinNothingValueException();
                }
            }
        } else {
            throw new IllegalStateException("Unbalanced begin/end insert".toString());
        }
    }

    public final void startGroup() {
        if (this.insertCount == 0) {
            startGroup(0, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
        } else {
            ComposerKt.composeRuntimeError("Key must be supplied when inserting".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void startGroup(int i) {
        startGroup(i, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
    }

    public final void startGroup(int i, Object obj) {
        startGroup(i, obj, false, Composer.Companion.getEmpty());
    }

    public final void startNode(int i, Object obj) {
        startGroup(i, obj, true, Composer.Companion.getEmpty());
    }

    public final void startNode(int i, Object obj, Object obj2) {
        startGroup(i, obj, true, obj2);
    }

    public final void startData(int i, Object obj, Object obj2) {
        startGroup(i, obj, false, obj2);
    }

    public final void startData(int i, Object obj) {
        startGroup(i, Composer.Companion.getEmpty(), false, obj);
    }

    private final void startGroup(int i, Object obj, boolean z, Object obj2) {
        int i2;
        GroupSourceInformation sourceInformationOf;
        Object obj3 = obj;
        Object obj4 = obj2;
        int i3 = this.parent;
        boolean z2 = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (z2) {
            insertGroups(1);
            int i4 = this.currentGroup;
            int groupIndexToAddress = groupIndexToAddress(i4);
            boolean z3 = obj3 != Composer.Companion.getEmpty();
            boolean z4 = !z && obj4 != Composer.Companion.getEmpty();
            SlotTableKt.initGroup(this.groups, groupIndexToAddress, i, z, z3, z4, this.parent, this.currentSlot);
            this.currentSlotEnd = this.currentSlot;
            int i5 = (z ? 1 : 0) + (z3 ? 1 : 0) + (z4 ? 1 : 0);
            if (i5 > 0) {
                insertSlots(i5, i4);
                Object[] objArr = this.slots;
                int i6 = this.currentSlot;
                if (z) {
                    objArr[i6] = obj4;
                    i6++;
                }
                if (z3) {
                    objArr[i6] = obj3;
                    i6++;
                }
                if (z4) {
                    objArr[i6] = obj4;
                    i6++;
                }
                this.currentSlot = i6;
            }
            this.nodeCount = 0;
            i2 = i4 + 1;
            this.parent = i4;
            this.currentGroup = i2;
            if (i3 >= 0 && (sourceInformationOf = sourceInformationOf(i3)) != null) {
                sourceInformationOf.reportGroup(this, i4);
            }
        } else {
            this.startStack.push(i3);
            saveCurrentGroupEnd();
            int i7 = this.currentGroup;
            int groupIndexToAddress2 = groupIndexToAddress(i7);
            if (!Intrinsics.areEqual(obj4, Composer.Companion.getEmpty())) {
                if (z) {
                    updateNode(obj4);
                } else {
                    updateAux(obj4);
                }
            }
            this.currentSlot = slotIndex(this.groups, groupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            this.nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress2);
            this.parent = i7;
            this.currentGroup = i7 + 1;
            i2 = i7 + SlotTableKt.groupSize(this.groups, groupIndexToAddress2);
        }
        this.currentGroupEnd = i2;
    }

    public final int endGroup() {
        int i = 1;
        int i2 = 0;
        boolean z = this.insertCount > 0;
        int i3 = this.currentGroup;
        int i4 = this.currentGroupEnd;
        int i5 = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i5);
        int i6 = this.nodeCount;
        int i7 = i3 - i5;
        boolean access$isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress);
        if (z) {
            SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress, i7);
            SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress, i6);
            int pop = this.nodeCountStack.pop();
            if (!access$isNode) {
                i = i6;
            }
            this.nodeCount = pop + i;
            this.parent = parent(this.groups, i5);
        } else {
            if (i3 != i4) {
                i = 0;
            }
            if (i != 0) {
                int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress);
                int access$nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
                SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress, i7);
                SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress, i6);
                int pop2 = this.startStack.pop();
                restoreCurrentGroupEnd();
                this.parent = pop2;
                int parent2 = parent(this.groups, i5);
                int pop3 = this.nodeCountStack.pop();
                this.nodeCount = pop3;
                if (parent2 == pop2) {
                    if (!access$isNode) {
                        i2 = i6 - access$nodeCount;
                    }
                    this.nodeCount = pop3 + i2;
                } else {
                    int i8 = i7 - access$groupSize;
                    int i9 = access$isNode ? 0 : i6 - access$nodeCount;
                    if (!(i8 == 0 && i9 == 0)) {
                        while (parent2 != 0 && parent2 != pop2 && (i9 != 0 || i8 != 0)) {
                            int groupIndexToAddress2 = groupIndexToAddress(parent2);
                            if (i8 != 0) {
                                SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress2, SlotTableKt.groupSize(this.groups, groupIndexToAddress2) + i8);
                            }
                            if (i9 != 0) {
                                int[] iArr = this.groups;
                                SlotTableKt.updateNodeCount(iArr, groupIndexToAddress2, SlotTableKt.nodeCount(iArr, groupIndexToAddress2) + i9);
                            }
                            if (SlotTableKt.isNode(this.groups, groupIndexToAddress2)) {
                                i9 = 0;
                            }
                            parent2 = parent(this.groups, parent2);
                        }
                    }
                    this.nodeCount += i9;
                }
            } else {
                ComposerKt.composeRuntimeError("Expected to be at the end of a group".toString());
                throw new KotlinNothingValueException();
            }
        }
        return i6;
    }

    public final void ensureStarted(int i) {
        boolean z = true;
        if (this.insertCount <= 0) {
            int i2 = this.parent;
            if (i2 != i) {
                if (i < i2 || i >= this.currentGroupEnd) {
                    z = false;
                }
                if (z) {
                    int i3 = this.currentGroup;
                    int i4 = this.currentSlot;
                    int i5 = this.currentSlotEnd;
                    this.currentGroup = i;
                    startGroup();
                    this.currentGroup = i3;
                    this.currentSlot = i4;
                    this.currentSlotEnd = i5;
                    return;
                }
                ComposerKt.composeRuntimeError(("Started group at " + i + " must be a subgroup of the group at " + i2).toString());
                throw new KotlinNothingValueException();
            }
            return;
        }
        ComposerKt.composeRuntimeError("Cannot call ensureStarted() while inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void ensureStarted(Anchor anchor) {
        ensureStarted(anchor.toIndexFor(this));
    }

    public final int skipGroup() {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int access$groupSize = this.currentGroup + SlotTableKt.groupSize(this.groups, groupIndexToAddress);
        this.currentGroup = access$groupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(access$groupSize));
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            return 1;
        }
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
    }

    public final boolean removeGroup() {
        Anchor tryAnchor$runtime_release;
        if (this.insertCount == 0) {
            int i = this.currentGroup;
            int i2 = this.currentSlot;
            int skipGroup = skipGroup();
            GroupSourceInformation sourceInformationOf = sourceInformationOf(this.parent);
            if (!(sourceInformationOf == null || (tryAnchor$runtime_release = tryAnchor$runtime_release(i)) == null)) {
                sourceInformationOf.removeAnchor(tryAnchor$runtime_release);
            }
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet != null) {
                while (prioritySet.isNotEmpty() && prioritySet.peek() >= i) {
                    prioritySet.takeMax();
                }
            }
            boolean removeGroups = removeGroups(i, this.currentGroup - i);
            removeSlots(i2, this.currentSlot - i2, i - 1);
            this.currentGroup = i;
            this.currentSlot = i2;
            this.nodeCount -= skipGroup;
            return removeGroups;
        }
        ComposerKt.composeRuntimeError("Cannot remove group while inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final Iterator<Object> groupSlots() {
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i = this.currentGroup;
        return new SlotWriter$groupSlots$1(dataIndex, dataIndex(iArr, groupIndexToAddress(i + groupSize(i))), this);
    }

    public final void forEachData(int i, Function2<? super Integer, Object, Unit> function2) {
        int access$slotIndex = slotIndex(this.groups, groupIndexToAddress(i));
        int access$dataIndex = dataIndex(this.groups, groupIndexToAddress(i + 1));
        for (int i2 = access$slotIndex; i2 < access$dataIndex; i2++) {
            function2.invoke(Integer.valueOf(i2 - access$slotIndex), this.slots[dataIndexToDataAddress(i2)]);
        }
    }

    public final void moveGroup(int i) {
        if (this.insertCount == 0) {
            if (!(i >= 0)) {
                ComposerKt.composeRuntimeError("Parameter offset is out of bounds".toString());
                throw new KotlinNothingValueException();
            } else if (i != 0) {
                int i2 = this.currentGroup;
                int i3 = this.parent;
                int i4 = this.currentGroupEnd;
                int i5 = i;
                int i6 = i2;
                while (i5 > 0) {
                    i6 += SlotTableKt.groupSize(this.groups, groupIndexToAddress(i6));
                    if (i6 <= i4) {
                        i5--;
                    } else {
                        ComposerKt.composeRuntimeError("Parameter offset is out of bounds".toString());
                        throw new KotlinNothingValueException();
                    }
                }
                int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i6));
                int i7 = this.currentSlot;
                int dataIndex = dataIndex(this.groups, groupIndexToAddress(i6));
                int i8 = i6 + access$groupSize;
                int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(i8));
                int i9 = dataIndex2 - dataIndex;
                insertSlots(i9, Math.max(this.currentGroup - 1, 0));
                insertGroups(access$groupSize);
                int[] iArr = this.groups;
                int groupIndexToAddress = groupIndexToAddress(i8) * 5;
                ArraysKt.copyInto(iArr, iArr, groupIndexToAddress(i2) * 5, groupIndexToAddress, (access$groupSize * 5) + groupIndexToAddress);
                if (i9 > 0) {
                    Object[] objArr = this.slots;
                    ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i7, dataIndexToDataAddress(dataIndex + i9), dataIndexToDataAddress(dataIndex2 + i9));
                }
                int i10 = dataIndex + i9;
                int i11 = i10 - i7;
                int i12 = this.slotsGapStart;
                int i13 = this.slotsGapLen;
                int length = this.slots.length;
                int i14 = this.slotsGapOwner;
                int i15 = i2 + access$groupSize;
                int i16 = i2;
                while (i16 < i15) {
                    int groupIndexToAddress2 = groupIndexToAddress(i16);
                    int i17 = i12;
                    int i18 = i11;
                    updateDataIndex(iArr, groupIndexToAddress2, dataIndexToDataAnchor(dataIndex(iArr, groupIndexToAddress2) - i11, i14 < groupIndexToAddress2 ? 0 : i17, i13, length));
                    i16++;
                    i12 = i17;
                    i11 = i18;
                }
                moveAnchors(i8, i2, access$groupSize);
                if (!removeGroups(i8, access$groupSize)) {
                    fixParentAnchorsFor(i3, this.currentGroupEnd, i2);
                    if (i9 > 0) {
                        removeSlots(i10, i9, i8 - 1);
                        return;
                    }
                    return;
                }
                ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
                throw new KotlinNothingValueException();
            }
        } else {
            ComposerKt.composeRuntimeError("Cannot move a group while inserting".toString());
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SlotTable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ List moveGroup$default(Companion companion, SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2, boolean z3, int i2, Object obj) {
            if ((i2 & 32) != 0) {
                z3 = true;
            }
            return companion.moveGroup(slotWriter, i, slotWriter2, z, z2, z3);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x01d9  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01ff  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<androidx.compose.runtime.Anchor> moveGroup(androidx.compose.runtime.SlotWriter r24, int r25, androidx.compose.runtime.SlotWriter r26, boolean r27, boolean r28, boolean r29) {
            /*
                r23 = this;
                r0 = r24
                r1 = r25
                r2 = r26
                int r3 = r24.groupSize(r25)
                int r4 = r1 + r3
                int r5 = r24.dataIndex(r25)
                int r6 = r0.dataIndex(r4)
                int r7 = r6 - r5
                boolean r8 = r24.containsAnyGroupMarks(r25)
                r2.insertGroups(r3)
                int r9 = r26.getCurrentGroup()
                r2.insertSlots(r7, r9)
                int r9 = r24.groupGapStart
                if (r9 >= r4) goto L_0x002d
                r0.moveGroupGapTo(r4)
            L_0x002d:
                int r9 = r24.slotsGapStart
                if (r9 >= r6) goto L_0x0036
                r0.moveSlotGapTo(r6, r4)
            L_0x0036:
                int[] r9 = r26.groups
                int r10 = r26.getCurrentGroup()
                int[] r11 = r24.groups
                int r12 = r10 * 5
                int r13 = r1 * 5
                int r14 = r4 * 5
                kotlin.collections.ArraysKt.copyInto((int[]) r11, (int[]) r9, (int) r12, (int) r13, (int) r14)
                java.lang.Object[] r11 = r26.slots
                int r12 = r26.currentSlot
                java.lang.Object[] r13 = r24.slots
                kotlin.collections.ArraysKt.copyInto((T[]) r13, (T[]) r11, (int) r12, (int) r5, (int) r6)
                int r6 = r26.getParent()
                androidx.compose.runtime.SlotTableKt.updateParentAnchor(r9, r10, r6)
                int r13 = r10 - r1
                int r14 = r10 + r3
                int r15 = r2.dataIndex(r9, r10)
                int r15 = r12 - r15
                int r16 = r26.slotsGapOwner
                r17 = r8
                int r8 = r26.slotsGapLen
                int r11 = r11.length
                r18 = r12
                r12 = r16
                r16 = r5
                r5 = r10
            L_0x007d:
                r19 = 0
                if (r5 >= r14) goto L_0x00b3
                if (r5 == r10) goto L_0x008f
                int r20 = androidx.compose.runtime.SlotTableKt.parentAnchor(r9, r5)
                r21 = r14
                int r14 = r20 + r13
                androidx.compose.runtime.SlotTableKt.updateParentAnchor(r9, r5, r14)
                goto L_0x0091
            L_0x008f:
                r21 = r14
            L_0x0091:
                int r14 = r2.dataIndex(r9, r5)
                int r14 = r14 + r15
                if (r12 >= r5) goto L_0x0099
                goto L_0x009d
            L_0x0099:
                int r19 = r26.slotsGapStart
            L_0x009d:
                r20 = r15
                r15 = r19
                int r14 = r2.dataIndexToDataAnchor(r14, r15, r8, r11)
                androidx.compose.runtime.SlotTableKt.updateDataAnchor(r9, r5, r14)
                if (r5 != r12) goto L_0x00ac
                int r12 = r12 + 1
            L_0x00ac:
                int r5 = r5 + 1
                r15 = r20
                r14 = r21
                goto L_0x007d
            L_0x00b3:
                r21 = r14
                r2.slotsGapOwner = r12
                java.util.ArrayList r5 = r24.anchors
                int r8 = r24.getSize$runtime_release()
                int r5 = androidx.compose.runtime.SlotTableKt.locationOf(r5, r1, r8)
                java.util.ArrayList r8 = r24.anchors
                int r11 = r24.getSize$runtime_release()
                int r4 = androidx.compose.runtime.SlotTableKt.locationOf(r8, r4, r11)
                if (r5 >= r4) goto L_0x0118
                java.util.ArrayList r8 = r24.anchors
                java.util.ArrayList r11 = new java.util.ArrayList
                int r12 = r4 - r5
                r11.<init>(r12)
                r12 = r5
            L_0x00de:
                if (r12 >= r4) goto L_0x00f4
                java.lang.Object r14 = r8.get(r12)
                androidx.compose.runtime.Anchor r14 = (androidx.compose.runtime.Anchor) r14
                int r15 = r14.getLocation$runtime_release()
                int r15 = r15 + r13
                r14.setLocation$runtime_release(r15)
                r11.add(r14)
                int r12 = r12 + 1
                goto L_0x00de
            L_0x00f4:
                java.util.ArrayList r12 = r26.anchors
                int r13 = r26.getCurrentGroup()
                int r14 = r26.getSize$runtime_release()
                int r12 = androidx.compose.runtime.SlotTableKt.locationOf(r12, r13, r14)
                java.util.ArrayList r13 = r26.anchors
                r14 = r11
                java.util.Collection r14 = (java.util.Collection) r14
                r13.addAll(r12, r14)
                java.util.List r4 = r8.subList(r5, r4)
                r4.clear()
                java.util.List r11 = (java.util.List) r11
                goto L_0x011c
            L_0x0118:
                java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
            L_0x011c:
                r4 = r11
                java.util.Collection r4 = (java.util.Collection) r4
                boolean r4 = r4.isEmpty()
                r5 = 1
                r4 = r4 ^ r5
                if (r4 == 0) goto L_0x016a
                java.util.HashMap r4 = r24.sourceInformationMap
                if (r4 == 0) goto L_0x016a
                java.util.HashMap r8 = r26.sourceInformationMap
                int r12 = r11.size()
                r13 = r19
            L_0x0137:
                if (r13 >= r12) goto L_0x0160
                java.lang.Object r14 = r11.get(r13)
                androidx.compose.runtime.Anchor r14 = (androidx.compose.runtime.Anchor) r14
                java.lang.Object r15 = r4.get(r14)
                androidx.compose.runtime.GroupSourceInformation r15 = (androidx.compose.runtime.GroupSourceInformation) r15
                if (r15 == 0) goto L_0x015c
                r4.remove(r14)
                if (r8 != 0) goto L_0x0156
                androidx.compose.runtime.SlotWriter$Companion r8 = androidx.compose.runtime.SlotWriter.Companion
                java.util.HashMap r8 = new java.util.HashMap
                r8.<init>()
                r2.sourceInformationMap = r8
            L_0x0156:
                r5 = r8
                java.util.Map r5 = (java.util.Map) r5
                r5.put(r14, r15)
            L_0x015c:
                int r13 = r13 + 1
                r5 = 1
                goto L_0x0137
            L_0x0160:
                boolean r4 = r4.isEmpty()
                if (r4 == 0) goto L_0x016a
                r4 = 0
                r0.sourceInformationMap = r4
            L_0x016a:
                int r4 = r26.getParent()
                androidx.compose.runtime.GroupSourceInformation r5 = r2.sourceInformationOf(r6)
                if (r5 == 0) goto L_0x018f
                r8 = 1
                int r4 = r4 + r8
                int r8 = r26.getCurrentGroup()
                r12 = -1
            L_0x017b:
                if (r4 >= r8) goto L_0x018c
                int[] r12 = r26.groups
                int r12 = androidx.compose.runtime.SlotTableKt.groupSize(r12, r4)
                int r12 = r12 + r4
                r22 = r12
                r12 = r4
                r4 = r22
                goto L_0x017b
            L_0x018c:
                r5.addGroupAfter(r2, r12, r8)
            L_0x018f:
                int r4 = r24.parent((int) r25)
                if (r29 != 0) goto L_0x0197
            L_0x0195:
                r3 = 1
                goto L_0x01d5
            L_0x0197:
                if (r27 == 0) goto L_0x01ca
                if (r4 < 0) goto L_0x019d
                r19 = 1
            L_0x019d:
                if (r19 == 0) goto L_0x01ad
                r24.startGroup()
                int r3 = r24.getCurrentGroup()
                int r4 = r4 - r3
                r0.advanceBy(r4)
                r24.startGroup()
            L_0x01ad:
                int r3 = r24.getCurrentGroup()
                int r1 = r1 - r3
                r0.advanceBy(r1)
                boolean r1 = r24.removeGroup()
                if (r19 == 0) goto L_0x01c7
                r24.skipToGroupEnd()
                r24.endGroup()
                r24.skipToGroupEnd()
                r24.endGroup()
            L_0x01c7:
                r19 = r1
                goto L_0x0195
            L_0x01ca:
                boolean r19 = r0.removeGroups(r1, r3)
                r3 = 1
                int r1 = r1 - r3
                r4 = r16
                r0.removeSlots(r4, r7, r1)
            L_0x01d5:
                r0 = r19 ^ 1
                if (r0 == 0) goto L_0x01ff
                int r0 = r26.nodeCount
                boolean r1 = androidx.compose.runtime.SlotTableKt.isNode(r9, r10)
                if (r1 == 0) goto L_0x01e5
                r5 = r3
                goto L_0x01e9
            L_0x01e5:
                int r5 = androidx.compose.runtime.SlotTableKt.nodeCount(r9, r10)
            L_0x01e9:
                int r0 = r0 + r5
                r2.nodeCount = r0
                if (r28 == 0) goto L_0x01f9
                r10 = r21
                r2.currentGroup = r10
                int r12 = r18 + r7
                r2.currentSlot = r12
            L_0x01f9:
                if (r17 == 0) goto L_0x01fe
                r2.updateContainsMark(r6)
            L_0x01fe:
                return r11
            L_0x01ff:
                java.lang.String r0 = "Unexpectedly removed anchors"
                java.lang.String r0 = r0.toString()
                androidx.compose.runtime.ComposerKt.composeRuntimeError(r0)
                kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.Companion.moveGroup(androidx.compose.runtime.SlotWriter, int, androidx.compose.runtime.SlotWriter, boolean, boolean, boolean):java.util.List");
        }
    }

    public final List<Anchor> moveTo(Anchor anchor, int i, SlotWriter slotWriter) {
        boolean z = true;
        ComposerKt.runtimeCheck(slotWriter.insertCount > 0);
        ComposerKt.runtimeCheck(this.insertCount == 0);
        ComposerKt.runtimeCheck(anchor.getValid());
        int anchorIndex = anchorIndex(anchor) + i;
        int i2 = this.currentGroup;
        ComposerKt.runtimeCheck(i2 <= anchorIndex && anchorIndex < this.currentGroupEnd);
        int parent2 = parent(anchorIndex);
        int groupSize = groupSize(anchorIndex);
        int nodeCount2 = isNode(anchorIndex) ? 1 : nodeCount(anchorIndex);
        List<Anchor> moveGroup$default = Companion.moveGroup$default(Companion, this, anchorIndex, slotWriter, false, false, false, 32, (Object) null);
        updateContainsMark(parent2);
        boolean z2 = nodeCount2 > 0;
        while (parent2 >= i2) {
            int groupIndexToAddress = groupIndexToAddress(parent2);
            int[] iArr = this.groups;
            SlotTableKt.updateGroupSize(iArr, groupIndexToAddress, SlotTableKt.groupSize(iArr, groupIndexToAddress) - groupSize);
            if (z2) {
                if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
                    z2 = false;
                } else {
                    int[] iArr2 = this.groups;
                    SlotTableKt.updateNodeCount(iArr2, groupIndexToAddress, SlotTableKt.nodeCount(iArr2, groupIndexToAddress) - nodeCount2);
                }
            }
            parent2 = parent(parent2);
        }
        if (z2) {
            if (this.nodeCount < nodeCount2) {
                z = false;
            }
            ComposerKt.runtimeCheck(z);
            this.nodeCount -= nodeCount2;
        }
        return moveGroup$default;
    }

    public static /* synthetic */ List moveFrom$default(SlotWriter slotWriter, SlotTable slotTable, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return slotWriter.moveFrom(slotTable, i, z);
    }

    public final List<Anchor> moveFrom(SlotTable slotTable, int i, boolean z) {
        ComposerKt.runtimeCheck(this.insertCount > 0);
        if (i == 0 && this.currentGroup == 0 && this.table.getGroupsSize() == 0 && SlotTableKt.groupSize(slotTable.getGroups(), i) == slotTable.getGroupsSize()) {
            int[] iArr = this.groups;
            Object[] objArr = this.slots;
            ArrayList<Anchor> arrayList = this.anchors;
            HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
            int[] groups2 = slotTable.getGroups();
            int groupsSize = slotTable.getGroupsSize();
            Object[] slots2 = slotTable.getSlots();
            int slotsSize = slotTable.getSlotsSize();
            HashMap<Anchor, GroupSourceInformation> sourceInformationMap$runtime_release = slotTable.getSourceInformationMap$runtime_release();
            this.groups = groups2;
            this.slots = slots2;
            this.anchors = slotTable.getAnchors$runtime_release();
            this.groupGapStart = groupsSize;
            this.groupGapLen = (groups2.length / 5) - groupsSize;
            this.slotsGapStart = slotsSize;
            this.slotsGapLen = slots2.length - slotsSize;
            this.slotsGapOwner = groupsSize;
            this.sourceInformationMap = sourceInformationMap$runtime_release;
            slotTable.setTo$runtime_release(iArr, 0, objArr, 0, arrayList, hashMap);
            return this.anchors;
        }
        SlotWriter openWriter = slotTable.openWriter();
        try {
            return Companion.moveGroup(openWriter, i, this, true, true, z);
        } finally {
            openWriter.close();
        }
    }

    public final void bashCurrentGroup() {
        SlotTableKt.updateGroupKey(this.groups, this.currentGroup, -3);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        if (groupSize(r12.currentGroup + r13) == 1) goto L_0x0010;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.runtime.Anchor> moveIntoGroupFrom(int r13, androidx.compose.runtime.SlotTable r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.insertCount
            if (r0 > 0) goto L_0x000f
            int r0 = r12.currentGroup
            int r0 = r0 + r13
            int r0 = r12.groupSize(r0)
            r1 = 1
            if (r0 != r1) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            androidx.compose.runtime.ComposerKt.runtimeCheck(r1)
            int r0 = r12.currentGroup
            int r1 = r12.currentSlot
            int r2 = r12.currentSlotEnd
            r12.advanceBy(r13)
            r12.startGroup()
            r12.beginInsert()
            androidx.compose.runtime.SlotWriter r13 = r14.openWriter()
            androidx.compose.runtime.SlotWriter$Companion r3 = Companion     // Catch:{ all -> 0x0045 }
            r10 = 32
            r11 = 0
            r7 = 0
            r8 = 1
            r9 = 0
            r4 = r13
            r5 = r15
            r6 = r12
            java.util.List r14 = androidx.compose.runtime.SlotWriter.Companion.moveGroup$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0045 }
            r13.close()
            r12.endInsert()
            r12.endGroup()
            r12.currentGroup = r0
            r12.currentSlot = r1
            r12.currentSlotEnd = r2
            return r14
        L_0x0045:
            r14 = move-exception
            r13.close()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.moveIntoGroupFrom(int, androidx.compose.runtime.SlotTable, int):java.util.List");
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i);
    }

    public final Anchor anchor(int i) {
        ArrayList<Anchor> arrayList = this.anchors;
        int access$search = SlotTableKt.search(arrayList, i, getSize$runtime_release());
        if (access$search >= 0) {
            return arrayList.get(access$search);
        }
        if (i > this.groupGapStart) {
            i = -(getSize$runtime_release() - i);
        }
        Anchor anchor = new Anchor(i);
        arrayList.add(-(access$search + 1), anchor);
        return anchor;
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.parent;
        }
        slotWriter.markGroup(i);
    }

    public final void markGroup(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        if (!SlotTableKt.hasMark(this.groups, groupIndexToAddress)) {
            SlotTableKt.updateMark(this.groups, groupIndexToAddress, true);
            if (!SlotTableKt.containsMark(this.groups, groupIndexToAddress)) {
                updateContainsMark(parent(i));
            }
        }
    }

    private final boolean containsGroupMark(int i) {
        return i >= 0 && SlotTableKt.containsMark(this.groups, groupIndexToAddress(i));
    }

    /* access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int i) {
        return i >= 0 && SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(i));
    }

    private final void recalculateMarks() {
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty()) {
                updateContainsMarkNow(prioritySet.takeMax(), prioritySet);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateContainsMark(int i) {
        if (i >= 0) {
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet == null) {
                prioritySet = new PrioritySet((List) null, 1, (DefaultConstructorMarker) null);
                this.pendingRecalculateMarks = prioritySet;
            }
            prioritySet.add(i);
        }
    }

    private final void updateContainsMarkNow(int i, PrioritySet prioritySet) {
        int groupIndexToAddress = groupIndexToAddress(i);
        boolean childContainsAnyMarks = childContainsAnyMarks(i);
        if (SlotTableKt.containsMark(this.groups, groupIndexToAddress) != childContainsAnyMarks) {
            SlotTableKt.updateContainsMark(this.groups, groupIndexToAddress, childContainsAnyMarks);
            int parent2 = parent(i);
            if (parent2 >= 0) {
                prioritySet.add(parent2);
            }
        }
    }

    private final boolean childContainsAnyMarks(int i) {
        int i2 = i + 1;
        int groupSize = i + groupSize(i);
        while (i2 < groupSize) {
            if (SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(i2))) {
                return true;
            }
            i2 += groupSize(i2);
        }
        return false;
    }

    public final int anchorIndex(Anchor anchor) {
        int location$runtime_release = anchor.getLocation$runtime_release();
        return location$runtime_release < 0 ? location$runtime_release + getSize$runtime_release() : location$runtime_release;
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void fixParentAnchorsFor(int i, int i2, int i3) {
        int parentIndexToAnchor = parentIndexToAnchor(i, this.groupGapStart);
        while (i3 < i2) {
            SlotTableKt.updateParentAnchor(this.groups, groupIndexToAddress(i3), parentIndexToAnchor);
            int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i3)) + i3;
            fixParentAnchorsFor(i3, access$groupSize, i3 + 1);
            i3 = access$groupSize;
        }
    }

    /* access modifiers changed from: private */
    public final void moveGroupGapTo(int i) {
        int i2;
        int i3 = this.groupGapLen;
        int i4 = this.groupGapStart;
        if (i4 != i) {
            boolean z = true;
            if (!this.anchors.isEmpty()) {
                updateAnchors(i4, i);
            }
            if (i3 > 0) {
                int[] iArr = this.groups;
                int i5 = i * 5;
                int i6 = i3 * 5;
                int i7 = i4 * 5;
                if (i < i4) {
                    ArraysKt.copyInto(iArr, iArr, i6 + i5, i5, i7);
                } else {
                    ArraysKt.copyInto(iArr, iArr, i7, i7 + i6, i5 + i6);
                }
            }
            if (i < i4) {
                i4 = i + i3;
            }
            int capacity = getCapacity();
            if (i2 >= capacity) {
                z = false;
            }
            ComposerKt.runtimeCheck(z);
            while (i2 < capacity) {
                int access$parentAnchor = SlotTableKt.parentAnchor(this.groups, i2);
                int parentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(access$parentAnchor), i);
                if (parentIndexToAnchor != access$parentAnchor) {
                    SlotTableKt.updateParentAnchor(this.groups, i2, parentIndexToAnchor);
                }
                i2++;
                if (i2 == i) {
                    i2 += i3;
                }
            }
        }
        this.groupGapStart = i;
    }

    /* access modifiers changed from: private */
    public final void moveSlotGapTo(int i, int i2) {
        int i3 = this.slotsGapLen;
        int i4 = this.slotsGapStart;
        int i5 = this.slotsGapOwner;
        if (i4 != i) {
            Object[] objArr = this.slots;
            if (i < i4) {
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i + i3, i, i4);
            } else {
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i4, i4 + i3, i + i3);
            }
        }
        int min = Math.min(i2 + 1, getSize$runtime_release());
        if (i5 != min) {
            int length = this.slots.length - i3;
            if (min < i5) {
                int groupIndexToAddress = groupIndexToAddress(min);
                int groupIndexToAddress2 = groupIndexToAddress(i5);
                int i6 = this.groupGapStart;
                while (groupIndexToAddress < groupIndexToAddress2) {
                    int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
                    if (access$dataAnchor >= 0) {
                        SlotTableKt.updateDataAnchor(this.groups, groupIndexToAddress, -((length - access$dataAnchor) + 1));
                        groupIndexToAddress++;
                        if (groupIndexToAddress == i6) {
                            groupIndexToAddress += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a positive anchor".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            } else {
                int groupIndexToAddress3 = groupIndexToAddress(i5);
                int groupIndexToAddress4 = groupIndexToAddress(min);
                while (groupIndexToAddress3 < groupIndexToAddress4) {
                    int access$dataAnchor2 = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress3);
                    if (access$dataAnchor2 < 0) {
                        SlotTableKt.updateDataAnchor(this.groups, groupIndexToAddress3, access$dataAnchor2 + length + 1);
                        groupIndexToAddress3++;
                        if (groupIndexToAddress3 == this.groupGapStart) {
                            groupIndexToAddress3 += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a negative anchor".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            }
            this.slotsGapOwner = min;
        }
        this.slotsGapStart = i;
    }

    private final void clearSlotGap() {
        int i = this.slotsGapStart;
        ArraysKt.fill((T[]) this.slots, null, i, this.slotsGapLen + i);
    }

    /* access modifiers changed from: private */
    public final void insertGroups(int i) {
        if (i > 0) {
            int i2 = this.currentGroup;
            moveGroupGapTo(i2);
            int i3 = this.groupGapStart;
            int i4 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i5 = length - i4;
            int i6 = 0;
            if (i4 < i) {
                int max = Math.max(Math.max(length * 2, i5 + i), 32);
                int[] iArr2 = new int[(max * 5)];
                int i7 = max - i5;
                ArraysKt.copyInto(iArr, iArr2, 0, 0, i3 * 5);
                ArraysKt.copyInto(iArr, iArr2, (i3 + i7) * 5, (i4 + i3) * 5, length * 5);
                this.groups = iArr2;
                i4 = i7;
            }
            int i8 = this.currentGroupEnd;
            if (i8 >= i3) {
                this.currentGroupEnd = i8 + i;
            }
            int i9 = i3 + i;
            this.groupGapStart = i9;
            this.groupGapLen = i4 - i;
            int dataIndex = i5 > 0 ? dataIndex(i2 + i) : 0;
            if (this.slotsGapOwner >= i3) {
                i6 = this.slotsGapStart;
            }
            int dataIndexToDataAnchor = dataIndexToDataAnchor(dataIndex, i6, this.slotsGapLen, this.slots.length);
            for (int i10 = i3; i10 < i9; i10++) {
                SlotTableKt.updateDataAnchor(this.groups, i10, dataIndexToDataAnchor);
            }
            int i11 = this.slotsGapOwner;
            if (i11 >= i3) {
                this.slotsGapOwner = i11 + i;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void insertSlots(int i, int i2) {
        if (i > 0) {
            moveSlotGapTo(this.currentSlot, i2);
            int i3 = this.slotsGapStart;
            int i4 = this.slotsGapLen;
            if (i4 < i) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i5 = length - i4;
                int max = Math.max(Math.max(length * 2, i5 + i), 32);
                Object[] objArr2 = new Object[max];
                for (int i6 = 0; i6 < max; i6++) {
                    objArr2[i6] = null;
                }
                int i7 = max - i5;
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr2, 0, 0, i3);
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr2, i3 + i7, i4 + i3, length);
                this.slots = objArr2;
                i4 = i7;
            }
            int i8 = this.currentSlotEnd;
            if (i8 >= i3) {
                this.currentSlotEnd = i8 + i;
            }
            this.slotsGapStart = i3 + i;
            this.slotsGapLen = i4 - i;
        }
    }

    /* access modifiers changed from: private */
    public final boolean removeGroups(int i, int i2) {
        boolean z = false;
        if (i2 > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(i);
            if (!arrayList.isEmpty()) {
                z = removeAnchors(i, i2, this.sourceInformationMap);
            }
            this.groupGapStart = i;
            this.groupGapLen += i2;
            int i3 = this.slotsGapOwner;
            if (i3 > i) {
                this.slotsGapOwner = Math.max(i, i3 - i2);
            }
            int i4 = this.currentGroupEnd;
            if (i4 >= this.groupGapStart) {
                this.currentGroupEnd = i4 - i2;
            }
            int i5 = this.parent;
            if (containsGroupMark(i5)) {
                updateContainsMark(i5);
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final GroupSourceInformation sourceInformationOf(int i) {
        Anchor tryAnchor$runtime_release;
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null || (tryAnchor$runtime_release = tryAnchor$runtime_release(i)) == null) {
            return null;
        }
        return hashMap.get(tryAnchor$runtime_release);
    }

    public final Anchor tryAnchor$runtime_release(int i) {
        if (i < 0 || i >= getSize$runtime_release()) {
            return null;
        }
        return SlotTableKt.find(this.anchors, i, getSize$runtime_release());
    }

    /* access modifiers changed from: private */
    public final void removeSlots(int i, int i2, int i3) {
        if (i2 > 0) {
            int i4 = this.slotsGapLen;
            int i5 = i + i2;
            moveSlotGapTo(i5, i3);
            this.slotsGapStart = i;
            this.slotsGapLen = i4 + i2;
            ArraysKt.fill((T[]) this.slots, null, i, i5);
            int i6 = this.currentSlotEnd;
            if (i6 >= i) {
                this.currentSlotEnd = i6 - i2;
            }
        }
    }

    private final void updateNodeOfGroup(int i, Object obj) {
        int groupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        if (groupIndexToAddress < iArr.length && SlotTableKt.isNode(iArr, groupIndexToAddress)) {
            this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))] = obj;
            return;
        }
        ComposerKt.composeRuntimeError(("Updating the node of a group at " + i + " that was not created with as a node group").toString());
        throw new KotlinNothingValueException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        r5 = r3.anchors.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        r0 = r3.anchors.get(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateAnchors(int r4, int r5) {
        /*
            r3 = this;
            int r0 = r3.groupGapLen
            int r1 = r3.getCapacity()
            int r1 = r1 - r0
            if (r4 >= r5) goto L_0x002e
            java.util.ArrayList<androidx.compose.runtime.Anchor> r0 = r3.anchors
            int r4 = androidx.compose.runtime.SlotTableKt.locationOf(r0, r4, r1)
        L_0x000f:
            java.util.ArrayList<androidx.compose.runtime.Anchor> r0 = r3.anchors
            int r0 = r0.size()
            if (r4 >= r0) goto L_0x0053
            java.util.ArrayList<androidx.compose.runtime.Anchor> r0 = r3.anchors
            java.lang.Object r0 = r0.get(r4)
            androidx.compose.runtime.Anchor r0 = (androidx.compose.runtime.Anchor) r0
            int r2 = r0.getLocation$runtime_release()
            if (r2 >= 0) goto L_0x0053
            int r2 = r2 + r1
            if (r2 >= r5) goto L_0x0053
            r0.setLocation$runtime_release(r2)
            int r4 = r4 + 1
            goto L_0x000f
        L_0x002e:
            java.util.ArrayList<androidx.compose.runtime.Anchor> r4 = r3.anchors
            int r4 = androidx.compose.runtime.SlotTableKt.locationOf(r4, r5, r1)
        L_0x0034:
            java.util.ArrayList<androidx.compose.runtime.Anchor> r5 = r3.anchors
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0053
            java.util.ArrayList<androidx.compose.runtime.Anchor> r5 = r3.anchors
            java.lang.Object r5 = r5.get(r4)
            androidx.compose.runtime.Anchor r5 = (androidx.compose.runtime.Anchor) r5
            int r0 = r5.getLocation$runtime_release()
            if (r0 < 0) goto L_0x0053
            int r0 = r1 - r0
            int r0 = -r0
            r5.setLocation$runtime_release(r0)
            int r4 = r4 + 1
            goto L_0x0034
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.updateAnchors(int, int):void");
    }

    private final boolean removeAnchors(int i, int i2, HashMap<Anchor, GroupSourceInformation> hashMap) {
        int i3 = i2 + i;
        int access$locationOf = SlotTableKt.locationOf(this.anchors, i3, getCapacity() - this.groupGapLen);
        if (access$locationOf >= this.anchors.size()) {
            access$locationOf--;
        }
        int i4 = access$locationOf + 1;
        boolean z = false;
        int i5 = 0;
        while (access$locationOf >= 0) {
            Anchor anchor = this.anchors.get(access$locationOf);
            int anchorIndex = anchorIndex(anchor);
            if (anchorIndex < i) {
                break;
            }
            if (anchorIndex < i3) {
                anchor.setLocation$runtime_release(Integer.MIN_VALUE);
                if (hashMap != null) {
                    GroupSourceInformation remove = hashMap.remove(anchor);
                }
                if (i5 == 0) {
                    i5 = access$locationOf + 1;
                }
                i4 = access$locationOf;
            }
            access$locationOf--;
        }
        if (i4 < i5) {
            z = true;
        }
        if (z) {
            this.anchors.subList(i4, i5).clear();
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        r3 = r5.anchors.get(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void moveAnchors(int r6, int r7, int r8) {
        /*
            r5 = this;
            int r8 = r8 + r6
            int r0 = r5.getSize$runtime_release()
            java.util.ArrayList<androidx.compose.runtime.Anchor> r1 = r5.anchors
            int r1 = androidx.compose.runtime.SlotTableKt.locationOf(r1, r6, r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            if (r1 < 0) goto L_0x0035
        L_0x0014:
            java.util.ArrayList<androidx.compose.runtime.Anchor> r3 = r5.anchors
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0035
            java.util.ArrayList<androidx.compose.runtime.Anchor> r3 = r5.anchors
            java.lang.Object r3 = r3.get(r1)
            androidx.compose.runtime.Anchor r3 = (androidx.compose.runtime.Anchor) r3
            int r4 = r5.anchorIndex(r3)
            if (r4 < r6) goto L_0x0035
            if (r4 >= r8) goto L_0x0035
            r2.add(r3)
            java.util.ArrayList<androidx.compose.runtime.Anchor> r3 = r5.anchors
            r3.remove(r1)
            goto L_0x0014
        L_0x0035:
            int r7 = r7 - r6
            int r6 = r2.size()
            r8 = 0
        L_0x003b:
            if (r8 >= r6) goto L_0x0064
            java.lang.Object r1 = r2.get(r8)
            androidx.compose.runtime.Anchor r1 = (androidx.compose.runtime.Anchor) r1
            int r3 = r5.anchorIndex(r1)
            int r3 = r3 + r7
            int r4 = r5.groupGapStart
            if (r3 < r4) goto L_0x0053
            int r4 = r0 - r3
            int r4 = -r4
            r1.setLocation$runtime_release(r4)
            goto L_0x0056
        L_0x0053:
            r1.setLocation$runtime_release(r3)
        L_0x0056:
            java.util.ArrayList<androidx.compose.runtime.Anchor> r4 = r5.anchors
            int r3 = androidx.compose.runtime.SlotTableKt.locationOf(r4, r3, r0)
            java.util.ArrayList<androidx.compose.runtime.Anchor> r4 = r5.anchors
            r4.add(r3, r1)
            int r8 = r8 + 1
            goto L_0x003b
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotWriter.moveAnchors(int, int, int):void");
    }

    public final String groupsAsString() {
        StringBuilder sb = new StringBuilder();
        int size$runtime_release = getSize$runtime_release();
        for (int i = 0; i < size$runtime_release; i++) {
            groupAsString(sb, i);
            sb.append(10);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final void groupAsString(StringBuilder sb, int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        sb.append("Group(");
        if (i < 10) {
            sb.append(' ');
        }
        if (i < 100) {
            sb.append(' ');
        }
        if (i < 1000) {
            sb.append(' ');
        }
        sb.append(i);
        if (groupIndexToAddress != i) {
            sb.append("(");
            sb.append(groupIndexToAddress);
            sb.append(")");
        }
        sb.append('#');
        sb.append(SlotTableKt.groupSize(this.groups, groupIndexToAddress));
        boolean groupAsString$isStarted = groupAsString$isStarted(this, i);
        if (groupAsString$isStarted) {
            sb.append('?');
        }
        sb.append('^');
        sb.append(parentAnchorToIndex(SlotTableKt.parentAnchor(this.groups, groupIndexToAddress)));
        sb.append(": key=");
        sb.append(SlotTableKt.key(this.groups, groupIndexToAddress));
        sb.append(", nodes=");
        sb.append(SlotTableKt.nodeCount(this.groups, groupIndexToAddress));
        if (groupAsString$isStarted) {
            sb.append('?');
        }
        sb.append(", dataAnchor=");
        sb.append(SlotTableKt.dataAnchor(this.groups, groupIndexToAddress));
        sb.append(", parentAnchor=");
        sb.append(SlotTableKt.parentAnchor(this.groups, groupIndexToAddress));
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            sb.append(", node=" + this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))]);
        }
        int slotIndex = slotIndex(this.groups, groupIndexToAddress);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress + 1);
        if (dataIndex > slotIndex) {
            sb.append(", [");
            for (int i2 = slotIndex; i2 < dataIndex; i2++) {
                if (i2 != slotIndex) {
                    sb.append(", ");
                }
                sb.append(String.valueOf(this.slots[dataIndexToDataAddress(i2)]));
            }
            sb.append(']');
        }
        sb.append(")");
    }

    private static final boolean groupAsString$isStarted(SlotWriter slotWriter, int i) {
        return i < slotWriter.currentGroup && (i == slotWriter.parent || slotWriter.startStack.indexOf(i) >= 0 || groupAsString$isStarted(slotWriter, slotWriter.parent(i)));
    }

    public final void verifyDataAnchors$runtime_release() {
        int i = this.slotsGapOwner;
        int length = this.slots.length - this.slotsGapLen;
        int size$runtime_release = getSize$runtime_release();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < size$runtime_release) {
            int groupIndexToAddress = groupIndexToAddress(i2);
            int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
            int dataIndex = dataIndex(this.groups, groupIndexToAddress);
            if (dataIndex < i3) {
                throw new IllegalStateException(("Data index out of order at " + i2 + ", previous = " + i3 + ", current = " + dataIndex).toString());
            } else if (dataIndex <= length) {
                if (access$dataAnchor < 0 && !z) {
                    if (i == i2) {
                        z = true;
                    } else {
                        throw new IllegalStateException(("Expected the slot gap owner to be " + i + " found gap at " + i2).toString());
                    }
                }
                i2++;
                i3 = dataIndex;
            } else {
                throw new IllegalStateException(("Data index, " + dataIndex + ", out of bound at " + i2).toString());
            }
        }
    }

    public final void verifyParentAnchors$runtime_release() {
        int i = this.groupGapStart;
        int i2 = this.groupGapLen;
        int capacity = getCapacity();
        int i3 = 0;
        while (i3 < i) {
            if (SlotTableKt.parentAnchor(this.groups, i3) > -2) {
                i3++;
            } else {
                throw new IllegalStateException(("Expected a start relative anchor at " + i3).toString());
            }
        }
        for (int i4 = i2 + i; i4 < capacity; i4++) {
            int access$parentAnchor = SlotTableKt.parentAnchor(this.groups, i4);
            if (parentAnchorToIndex(access$parentAnchor) < i) {
                if (access$parentAnchor <= -2) {
                    throw new IllegalStateException(("Expected a start relative anchor at " + i4).toString());
                }
            } else if (access$parentAnchor > -2) {
                throw new IllegalStateException(("Expected an end relative anchor at " + i4).toString());
            }
        }
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    /* access modifiers changed from: private */
    public final int groupIndexToAddress(int i) {
        return i < this.groupGapStart ? i : i + this.groupGapLen;
    }

    /* access modifiers changed from: private */
    public final int dataIndexToDataAddress(int i) {
        return i < this.slotsGapStart ? i : i + this.slotsGapLen;
    }

    private final int parent(int[] iArr, int i) {
        return parentAnchorToIndex(SlotTableKt.parentAnchor(iArr, groupIndexToAddress(i)));
    }

    /* access modifiers changed from: private */
    public final int dataIndex(int i) {
        return dataIndex(this.groups, groupIndexToAddress(i));
    }

    /* access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i) {
        if (i >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        return dataAnchorToDataIndex(SlotTableKt.dataAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    /* access modifiers changed from: private */
    public final int slotIndex(int[] iArr, int i) {
        if (i >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        return dataAnchorToDataIndex(SlotTableKt.slotAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    private final void updateDataIndex(int[] iArr, int i, int i2) {
        SlotTableKt.updateDataAnchor(iArr, i, dataIndexToDataAnchor(i2, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    private final int nodeIndex(int[] iArr, int i) {
        return dataIndex(iArr, i);
    }

    private final int auxIndex(int[] iArr, int i) {
        return dataIndex(iArr, i) + SlotTableKt.countOneBits(SlotTableKt.groupInfo(iArr, i) >> 29);
    }

    private final List<Integer> dataIndexes(int[] iArr) {
        List dataAnchors$default = SlotTableKt.dataAnchors$default(this.groups, 0, 1, (Object) null);
        List plus = CollectionsKt.plus(CollectionsKt.slice(dataAnchors$default, RangesKt.until(0, this.groupGapStart)), CollectionsKt.slice(dataAnchors$default, RangesKt.until(this.groupGapStart + this.groupGapLen, iArr.length / 5)));
        ArrayList arrayList = new ArrayList(plus.size());
        int size = plus.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(dataAnchorToDataIndex(((Number) plus.get(i)).intValue(), this.slotsGapLen, this.slots.length)));
        }
        return arrayList;
    }

    private final List<Integer> keys() {
        List keys$default = SlotTableKt.keys$default(this.groups, 0, 1, (Object) null);
        ArrayList arrayList = new ArrayList(keys$default.size());
        int size = keys$default.size();
        for (int i = 0; i < size; i++) {
            Object obj = keys$default.get(i);
            ((Number) obj).intValue();
            int i2 = this.groupGapStart;
            if (i < i2 || i >= i2 + this.groupGapLen) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final int parentIndexToAnchor(int i, int i2) {
        return i < i2 ? i : -((getSize$runtime_release() - i) + 2);
    }

    private final int parentAnchorToIndex(int i) {
        return i > -2 ? i : getSize$runtime_release() + i + 2;
    }
}
