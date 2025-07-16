package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\nJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0005H\u0016R\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalConsumerImpl;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "consumer", "Lkotlin/Function1;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "", "Lkotlin/ExtensionFunctionType;", "debugInspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getConsumer", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "onModifierLocalsUpdated", "scope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalConsumer.kt */
final class ModifierLocalConsumerImpl extends InspectorValueInfo implements ModifierLocalConsumer {
    private final Function1<ModifierLocalReadScope, Unit> consumer;

    public /* synthetic */ boolean all(Function1 function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldIn(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldOut(this, obj, function2);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    public final Function1<ModifierLocalReadScope, Unit> getConsumer() {
        return this.consumer;
    }

    public ModifierLocalConsumerImpl(Function1<? super ModifierLocalReadScope, Unit> function1, Function1<? super InspectorInfo, Unit> function12) {
        super(function12);
        this.consumer = function1;
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        this.consumer.invoke(modifierLocalReadScope);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ModifierLocalConsumerImpl) && Intrinsics.areEqual((Object) ((ModifierLocalConsumerImpl) obj).consumer, (Object) this.consumer);
    }

    public int hashCode() {
        return this.consumer.hashCode();
    }
}
