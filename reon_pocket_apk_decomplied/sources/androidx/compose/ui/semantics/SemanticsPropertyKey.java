package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B5\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001c\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t¢\u0006\u0002\u0010\nB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t¢\u0006\u0002\u0010\u000bJ\"\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u00018\u00002\b\u0010\u001a\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ*\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u001f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0004H\u0016R\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "T", "", "name", "", "isImportantForAccessibility", "", "(Ljava/lang/String;Z)V", "mergePolicy", "Lkotlin/Function2;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "<set-?>", "isImportantForAccessibility$ui_release", "()Z", "getMergePolicy$ui_release", "()Lkotlin/jvm/functions/Function2;", "getName", "()Ljava/lang/String;", "getValue", "thisRef", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "merge", "parentValue", "childValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "setValue", "", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsProperties.kt */
public final class SemanticsPropertyKey<T> {
    public static final int $stable = 8;
    private boolean isImportantForAccessibility;
    private final Function2<T, T, T> mergePolicy;
    private final String name;

    public SemanticsPropertyKey(String str, Function2<? super T, ? super T, ? extends T> function2) {
        this.name = str;
        this.mergePolicy = function2;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SemanticsPropertyKey(String str, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? AnonymousClass1.INSTANCE : function2);
    }

    public final Function2<T, T, T> getMergePolicy$ui_release() {
        return this.mergePolicy;
    }

    public final boolean isImportantForAccessibility$ui_release() {
        return this.isImportantForAccessibility;
    }

    public SemanticsPropertyKey(String str, boolean z) {
        this(str, (Function2) null, 2, (DefaultConstructorMarker) null);
        this.isImportantForAccessibility = z;
    }

    public SemanticsPropertyKey(String str, boolean z, Function2<? super T, ? super T, ? extends T> function2) {
        this(str, function2);
        this.isImportantForAccessibility = z;
    }

    public final T merge(T t, T t2) {
        return this.mergePolicy.invoke(t, t2);
    }

    public final T getValue(SemanticsPropertyReceiver semanticsPropertyReceiver, KProperty<?> kProperty) {
        return SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    public final void setValue(SemanticsPropertyReceiver semanticsPropertyReceiver, KProperty<?> kProperty, T t) {
        semanticsPropertyReceiver.set(this, t);
    }

    public String toString() {
        return "AccessibilityKey: " + this.name;
    }
}
