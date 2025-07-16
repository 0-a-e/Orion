package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner;

/* compiled from: ArrayMapOwner.kt */
public final class NullableArrayMapAccessor<K, V, T extends V> extends AbstractArrayMapOwner.AbstractArrayMapAccessor<K, V, T> implements ReadOnlyProperty<AbstractArrayMapOwner<K, V>, V> {
    public NullableArrayMapAccessor(int i) {
        super(i);
    }

    public T getValue(AbstractArrayMapOwner<K, V> abstractArrayMapOwner, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(abstractArrayMapOwner, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return extractValue(abstractArrayMapOwner);
    }
}
