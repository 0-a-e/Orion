package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import com.amazonaws.services.s3.internal.Constants;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0004\b\u0000\u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J&\u0010\u001c\u001a\u00020\u00162\u001b\u0010\u001d\u001a\u0017\u0012\b\u0012\u00060\u001fR\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u001e¢\u0006\u0002\b H\bJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\"\u0010#\u001a\u00020\u00162\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J&\u0010*\u001a\u00020\u00162\u001b\u0010+\u001a\u0017\u0012\b\u0012\u00060\u001fR\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u001e¢\u0006\u0002\b H\bJ\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\b\u0010/\u001a\u00020\rH\u0002J\u0006\u00100\u001a\u00020\u0016J\u000e\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u0000J\u000e\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\rJ7\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\r2\u0017\u00105\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00160\u001e¢\u0006\u0002\b H\b\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001J\u0010\u00107\u001a\u00020\u00162\u0006\u00104\u001a\u00020\rH\u0007J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0016J\b\u0010;\u001a\u000209H\u0017J\u001a\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020>H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001e\u0010A\u001a\u00020\u00062\n\u0010=\u001a\u0006\u0012\u0002\b\u00030BH\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010@J\u0018\u0010D\u001a\u000209*\u00060\u001fR\u00020\u00002\u0006\u0010:\u001a\u000209H\u0002J\u0016\u0010E\u001a\u000209*\u0004\u0018\u00010\t2\u0006\u0010:\u001a\u000209H\u0002J\f\u0010F\u001a\u000209*\u000209H\u0002J \u0010G\u001a\u000209\"\u0004\b\u0000\u0010H*\b\u0012\u0004\u0012\u0002HH0I2\u0006\u0010:\u001a\u000209H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\bX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006M"}, d2 = {"Landroidx/compose/runtime/changelist/Operations;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "()V", "intArgs", "", "intArgsSize", "", "objectArgs", "", "", "[Ljava/lang/Object;", "objectArgsSize", "opCodes", "Landroidx/compose/runtime/changelist/Operation;", "[Landroidx/compose/runtime/changelist/Operation;", "opCodesSize", "pushedIntMask", "pushedObjectMask", "size", "getSize", "()I", "clear", "", "createExpectedArgMask", "paramCount", "determineNewSize", "currentSize", "requiredSize", "drain", "sink", "Lkotlin/Function1;", "Landroidx/compose/runtime/changelist/Operations$OpIterator;", "Lkotlin/ExtensionFunctionType;", "ensureIntArgsSizeAtLeast", "ensureObjectArgsSizeAtLeast", "executeAndFlushAllPendingOperations", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "forEach", "action", "isEmpty", "", "isNotEmpty", "peekOperation", "pop", "popInto", "other", "push", "operation", "args", "Landroidx/compose/runtime/changelist/Operations$WriteScope;", "pushOp", "toDebugString", "", "linePrefix", "toString", "topIntIndexOf", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "topIntIndexOf-w8GmfQM", "(I)I", "topObjectIndexOf", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "topObjectIndexOf-31yXWZQ", "currentOpToDebugString", "formatOpArgumentToString", "indent", "toCollectionString", "T", "", "Companion", "OpIterator", "WriteScope", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Operations.kt */
public final class Operations implements OperationsDebugStringFormattable {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int InitialCapacity = 16;
    private static final int MaxResizeAmount = 1024;
    /* access modifiers changed from: private */
    public int[] intArgs = new int[16];
    private int intArgsSize;
    /* access modifiers changed from: private */
    public Object[] objectArgs = new Object[16];
    private int objectArgsSize;
    /* access modifiers changed from: private */
    public Operation[] opCodes = new Operation[16];
    /* access modifiers changed from: private */
    public int opCodesSize;
    /* access modifiers changed from: private */
    public int pushedIntMask;
    /* access modifiers changed from: private */
    public int pushedObjectMask;

    /* access modifiers changed from: private */
    public final int createExpectedArgMask(int i) {
        if (i == 0) {
            return 0;
        }
        return -1 >>> (32 - i);
    }

    public final int getSize() {
        return this.opCodesSize;
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final boolean isNotEmpty() {
        return getSize() != 0;
    }

    public final void clear() {
        this.opCodesSize = 0;
        this.intArgsSize = 0;
        ArraysKt.fill((T[]) this.objectArgs, null, 0, this.objectArgsSize);
        this.objectArgsSize = 0;
    }

    public final void pushOp(Operation operation) {
        this.pushedIntMask = 0;
        this.pushedObjectMask = 0;
        int i = this.opCodesSize;
        if (i == this.opCodes.length) {
            Object[] copyOf = Arrays.copyOf(this.opCodes, this.opCodesSize + RangesKt.coerceAtMost(i, 1024));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.opCodes = (Operation[]) copyOf;
        }
        ensureIntArgsSizeAtLeast(this.intArgsSize + operation.getInts());
        ensureObjectArgsSizeAtLeast(this.objectArgsSize + operation.getObjects());
        Operation[] operationArr = this.opCodes;
        int i2 = this.opCodesSize;
        this.opCodesSize = i2 + 1;
        operationArr[i2] = operation;
        this.intArgsSize += operation.getInts();
        this.objectArgsSize += operation.getObjects();
    }

    private final int determineNewSize(int i, int i2) {
        return RangesKt.coerceAtLeast(i + RangesKt.coerceAtMost(i, 1024), i2);
    }

    private final void ensureIntArgsSizeAtLeast(int i) {
        int[] iArr = this.intArgs;
        int length = iArr.length;
        if (i > length) {
            int[] copyOf = Arrays.copyOf(iArr, determineNewSize(length, i));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.intArgs = copyOf;
        }
    }

    private final void ensureObjectArgsSizeAtLeast(int i) {
        Object[] objArr = this.objectArgs;
        int length = objArr.length;
        if (i > length) {
            Object[] copyOf = Arrays.copyOf(objArr, determineNewSize(length, i));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.objectArgs = copyOf;
        }
    }

    public final void push(Operation operation) {
        if (operation.getInts() == 0 && operation.getObjects() == 0) {
            pushOp(operation);
            return;
        }
        throw new IllegalArgumentException(("Cannot push " + operation + " without arguments because it expects " + operation.getInts() + " ints and " + operation.getObjects() + " objects.").toString());
    }

    public final void push(Operation operation, Function1<? super WriteScope, Unit> function1) {
        pushOp(operation);
        function1.invoke(WriteScope.m3385boximpl(WriteScope.m3386constructorimpl(this)));
        if (this.pushedIntMask != createExpectedArgMask(operation.getInts()) || this.pushedObjectMask != createExpectedArgMask(operation.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = operation.getInts();
            int i = 0;
            for (int i2 = 0; i2 < ints; i2++) {
                if (((1 << i2) & this.pushedIntMask) != 0) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(operation.m3294intParamNamew8GmfQM(Operation.IntParameter.m3332constructorimpl(i2)));
                    i++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = operation.getObjects();
            int i3 = 0;
            for (int i4 = 0; i4 < objects; i4++) {
                if (((1 << i4) & this.pushedObjectMask) != 0) {
                    if (i > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(operation.m3295objectParamName31yXWZQ(Operation.ObjectParameter.m3345constructorimpl(i4)));
                    i3++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            throw new IllegalStateException(("Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb4 + ").").toString());
        }
    }

    public final void pop() {
        if (!isEmpty()) {
            Operation[] operationArr = this.opCodes;
            int i = this.opCodesSize - 1;
            this.opCodesSize = i;
            Operation operation = operationArr[i];
            Intrinsics.checkNotNull(operation);
            this.opCodes[this.opCodesSize] = null;
            int objects = operation.getObjects();
            for (int i2 = 0; i2 < objects; i2++) {
                Object[] objArr = this.objectArgs;
                int i3 = this.objectArgsSize - 1;
                this.objectArgsSize = i3;
                objArr[i3] = null;
            }
            int ints = operation.getInts();
            for (int i4 = 0; i4 < ints; i4++) {
                int[] iArr = this.intArgs;
                int i5 = this.intArgsSize - 1;
                this.intArgsSize = i5;
                iArr[i5] = 0;
            }
            return;
        }
        throw new NoSuchElementException("Cannot pop(), because the stack is empty.");
    }

    public final void popInto(Operations operations) {
        if (!isEmpty()) {
            Operation[] operationArr = this.opCodes;
            int i = this.opCodesSize - 1;
            this.opCodesSize = i;
            Operation operation = operationArr[i];
            Intrinsics.checkNotNull(operation);
            this.opCodes[this.opCodesSize] = null;
            operations.pushOp(operation);
            int i2 = this.objectArgsSize;
            int i3 = operations.objectArgsSize;
            int objects = operation.getObjects();
            for (int i4 = 0; i4 < objects; i4++) {
                i3--;
                i2--;
                Object[] objArr = operations.objectArgs;
                Object[] objArr2 = this.objectArgs;
                objArr[i3] = objArr2[i2];
                objArr2[i2] = null;
            }
            int i5 = this.intArgsSize;
            int i6 = operations.intArgsSize;
            int ints = operation.getInts();
            for (int i7 = 0; i7 < ints; i7++) {
                i6--;
                i5--;
                int[] iArr = operations.intArgs;
                int[] iArr2 = this.intArgs;
                iArr[i6] = iArr2[i5];
                iArr2[i5] = 0;
            }
            this.objectArgsSize -= operation.getObjects();
            this.intArgsSize -= operation.getInts();
            return;
        }
        throw new NoSuchElementException("Cannot pop(), because the stack is empty.");
    }

    public final void forEach(Function1<? super OpIterator, Unit> function1) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            do {
                function1.invoke(opIterator);
            } while (opIterator.next());
        }
    }

    private final String indent(String str) {
        return str + "    ";
    }

    /* access modifiers changed from: private */
    public final Operation peekOperation() {
        Operation operation = this.opCodes[this.opCodesSize - 1];
        Intrinsics.checkNotNull(operation);
        return operation;
    }

    /* access modifiers changed from: private */
    /* renamed from: topIntIndexOf-w8GmfQM  reason: not valid java name */
    public final int m3381topIntIndexOfw8GmfQM(int i) {
        return (this.intArgsSize - peekOperation().getInts()) + i;
    }

    /* access modifiers changed from: private */
    /* renamed from: topObjectIndexOf-31yXWZQ  reason: not valid java name */
    public final int m3382topObjectIndexOf31yXWZQ(int i) {
        return (this.objectArgsSize - peekOperation().getObjects()) + i;
    }

    @JvmInline
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J,\u0010\u001a\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0006\u0010\u0017\u001a\u0002H\u001bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/runtime/changelist/Operations$WriteScope;", "", "stack", "Landroidx/compose/runtime/changelist/Operations;", "constructor-impl", "(Landroidx/compose/runtime/changelist/Operations;)Landroidx/compose/runtime/changelist/Operations;", "operation", "Landroidx/compose/runtime/changelist/Operation;", "getOperation-impl", "(Landroidx/compose/runtime/changelist/Operations;)Landroidx/compose/runtime/changelist/Operation;", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/changelist/Operations;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/changelist/Operations;)I", "setInt", "", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "value", "setInt-A6tL2VI", "(Landroidx/compose/runtime/changelist/Operations;II)V", "setObject", "T", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "setObject-DKhxnng", "(Landroidx/compose/runtime/changelist/Operations;ILjava/lang/Object;)V", "toString", "", "toString-impl", "(Landroidx/compose/runtime/changelist/Operations;)Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Operations.kt */
    public static final class WriteScope {
        private final Operations stack;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ WriteScope m3385boximpl(Operations operations) {
            return new WriteScope(operations);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static Operations m3386constructorimpl(Operations operations) {
            return operations;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m3387equalsimpl(Operations operations, Object obj) {
            return (obj instanceof WriteScope) && Intrinsics.areEqual((Object) operations, (Object) ((WriteScope) obj).m3394unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m3388equalsimpl0(Operations operations, Operations operations2) {
            return Intrinsics.areEqual((Object) operations, (Object) operations2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m3390hashCodeimpl(Operations operations) {
            return operations.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m3393toStringimpl(Operations operations) {
            return "WriteScope(stack=" + operations + ')';
        }

        public boolean equals(Object obj) {
            return m3387equalsimpl(this.stack, obj);
        }

        public int hashCode() {
            return m3390hashCodeimpl(this.stack);
        }

        public String toString() {
            return m3393toStringimpl(this.stack);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ Operations m3394unboximpl() {
            return this.stack;
        }

        private /* synthetic */ WriteScope(Operations operations) {
            this.stack = operations;
        }

        /* renamed from: getOperation-impl  reason: not valid java name */
        public static final Operation m3389getOperationimpl(Operations operations) {
            return operations.peekOperation();
        }

        /* renamed from: setInt-A6tL2VI  reason: not valid java name */
        public static final void m3391setIntA6tL2VI(Operations operations, int i, int i2) {
            int i3 = 1 << i;
            if ((operations.pushedIntMask & i3) == 0) {
                operations.pushedIntMask = i3 | operations.pushedIntMask;
                operations.intArgs[operations.m3381topIntIndexOfw8GmfQM(i)] = i2;
                return;
            }
            throw new IllegalStateException(("Already pushed argument " + m3389getOperationimpl(operations).m3294intParamNamew8GmfQM(i)).toString());
        }

        /* renamed from: setObject-DKhxnng  reason: not valid java name */
        public static final <T> void m3392setObjectDKhxnng(Operations operations, int i, T t) {
            int i2 = 1 << i;
            if ((operations.pushedObjectMask & i2) == 0) {
                operations.pushedObjectMask = i2 | operations.pushedObjectMask;
                operations.objectArgs[operations.m3382topObjectIndexOf31yXWZQ(i)] = t;
                return;
            }
            throw new IllegalStateException(("Already pushed argument " + m3389getOperationimpl(operations).m3295objectParamName31yXWZQ(i)).toString());
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/changelist/Operations$OpIterator;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "(Landroidx/compose/runtime/changelist/Operations;)V", "intIdx", "", "objIdx", "opIdx", "operation", "Landroidx/compose/runtime/changelist/Operation;", "getOperation", "()Landroidx/compose/runtime/changelist/Operation;", "getInt", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getInt-w8GmfQM", "(I)I", "getObject", "T", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "getObject-31yXWZQ", "(I)Ljava/lang/Object;", "next", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Operations.kt */
    public final class OpIterator implements OperationArgContainer {
        private int intIdx;
        private int objIdx;
        private int opIdx;

        public OpIterator() {
        }

        public final boolean next() {
            if (this.opIdx >= Operations.this.opCodesSize) {
                return false;
            }
            Operation operation = getOperation();
            this.intIdx += operation.getInts();
            this.objIdx += operation.getObjects();
            int i = this.opIdx + 1;
            this.opIdx = i;
            if (i < Operations.this.opCodesSize) {
                return true;
            }
            return false;
        }

        public final Operation getOperation() {
            Operation operation = Operations.this.opCodes[this.opIdx];
            Intrinsics.checkNotNull(operation);
            return operation;
        }

        /* renamed from: getInt-w8GmfQM  reason: not valid java name */
        public int m3383getIntw8GmfQM(int i) {
            return Operations.this.intArgs[this.intIdx + i];
        }

        /* renamed from: getObject-31yXWZQ  reason: not valid java name */
        public <T> T m3384getObject31yXWZQ(int i) {
            return Operations.this.objectArgs[this.objIdx + i];
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/changelist/Operations$Companion;", "", "()V", "InitialCapacity", "", "MaxResizeAmount", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Operations.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Deprecated(message = "toString() will return the default implementation from Any. Did you mean to use toDebugString()?", replaceWith = @ReplaceWith(expression = "toDebugString()", imports = {}))
    public String toString() {
        return super.toString();
    }

    public String toDebugString(String str) {
        StringBuilder sb = new StringBuilder();
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            int i = 1;
            while (true) {
                sb.append(str);
                int i2 = i + 1;
                sb.append(i);
                sb.append(". ");
                sb.append(currentOpToDebugString(opIterator, str));
                Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
                sb.append(10);
                Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                if (!opIterator.next()) {
                    break;
                }
                i = i2;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final String currentOpToDebugString(OpIterator opIterator, String str) {
        Operation operation = opIterator.getOperation();
        if (operation.getInts() == 0 && operation.getObjects() == 0) {
            return operation.getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(operation.getName());
        sb.append('(');
        String indent = indent(str);
        int ints = operation.getInts();
        boolean z = true;
        for (int i = 0; i < ints; i++) {
            int r11 = Operation.IntParameter.m3332constructorimpl(i);
            String r12 = operation.m3294intParamNamew8GmfQM(r11);
            if (!z) {
                sb.append(", ");
            } else {
                z = false;
            }
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            sb.append(indent);
            sb.append(r12);
            sb.append(" = ");
            sb.append(opIterator.m3383getIntw8GmfQM(r11));
        }
        int objects = operation.getObjects();
        for (int i2 = 0; i2 < objects; i2++) {
            int r112 = Operation.ObjectParameter.m3345constructorimpl(i2);
            String r122 = operation.m3295objectParamName31yXWZQ(r112);
            if (!z) {
                sb.append(", ");
            } else {
                z = false;
            }
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            sb.append(indent);
            sb.append(r122);
            sb.append(" = ");
            sb.append(formatOpArgumentToString(opIterator.m3384getObject31yXWZQ(r112), indent));
        }
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append(str);
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* access modifiers changed from: private */
    public final String formatOpArgumentToString(Object obj, String str) {
        if (obj == null) {
            return Constants.NULL_VERSION_ID;
        }
        if (obj instanceof Object[]) {
            return toCollectionString(ArraysKt.asIterable((T[]) (Object[]) obj), str);
        }
        if (obj instanceof int[]) {
            return toCollectionString(ArraysKt.asIterable((int[]) obj), str);
        }
        if (obj instanceof long[]) {
            return toCollectionString(ArraysKt.asIterable((long[]) obj), str);
        }
        if (obj instanceof float[]) {
            return toCollectionString(ArraysKt.asIterable((float[]) obj), str);
        }
        if (obj instanceof double[]) {
            return toCollectionString(ArraysKt.asIterable((double[]) obj), str);
        }
        if (obj instanceof Iterable) {
            return toCollectionString((Iterable) obj, str);
        }
        if (obj instanceof OperationsDebugStringFormattable) {
            return ((OperationsDebugStringFormattable) obj).toDebugString(str);
        }
        return obj.toString();
    }

    private final <T> String toCollectionString(Iterable<? extends T> iterable, String str) {
        return CollectionsKt.joinToString$default(iterable, ", ", "[", "]", 0, (CharSequence) null, new Operations$toCollectionString$1(this, str), 24, (Object) null);
    }

    public final void drain(Function1<? super OpIterator, Unit> function1) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            do {
                function1.invoke(opIterator);
            } while (opIterator.next());
        }
        clear();
    }

    public final void executeAndFlushAllPendingOperations(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            do {
                opIterator.getOperation().execute(opIterator, applier, slotWriter, rememberManager);
            } while (opIterator.next());
        }
        clear();
    }
}
