package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\b\r¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/KeyedComposedModifier1;", "Landroidx/compose/ui/ComposedModifier;", "fqName", "", "key1", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getFqName", "()Ljava/lang/String;", "getKey1", "()Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposedModifier.kt */
final class KeyedComposedModifier1 extends ComposedModifier {
    private final String fqName;
    private final Object key1;

    public final String getFqName() {
        return this.fqName;
    }

    public final Object getKey1() {
        return this.key1;
    }

    public KeyedComposedModifier1(String str, Object obj, Function1<? super InspectorInfo, Unit> function1, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        super(function1, function3);
        this.fqName = str;
        this.key1 = obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof KeyedComposedModifier1) {
            KeyedComposedModifier1 keyedComposedModifier1 = (KeyedComposedModifier1) obj;
            return Intrinsics.areEqual((Object) this.fqName, (Object) keyedComposedModifier1.fqName) && Intrinsics.areEqual(this.key1, keyedComposedModifier1.key1);
        }
    }

    public int hashCode() {
        int hashCode = this.fqName.hashCode() * 31;
        Object obj = this.key1;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }
}
