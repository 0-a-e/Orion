package kotlin.jvm.optionals;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u001a,\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\f\u0012\b\b\u0001\u0012\u0004\b\u0002H\u00020\u00042\u0006\u0010\u0006\u001a\u0002H\u0002H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a6\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\f\u0012\b\b\u0001\u0012\u0004\b\u0002H\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\f\u001a;\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0010\b\u0001\u0010\u000e*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0010\u001a\u0002H\u000eH\u0007¢\u0006\u0002\u0010\u0011\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u001a$\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u0002\u000b\n\u0002\b9\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "T", "", "Ljava/util/Optional;", "getOrDefault", "defaultValue", "(Ljava/util/Optional;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/util/Optional;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", "(Ljava/util/Optional;)Ljava/lang/Object;", "toCollection", "C", "", "destination", "(Ljava/util/Optional;Ljava/util/Collection;)Ljava/util/Collection;", "toList", "", "toSet", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: Optionals.kt */
public final class OptionalsKt {
    public static final <T> T getOrNull(Optional<T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        return optional.orElse((Object) null);
    }

    public static final <T> T getOrDefault(Optional<? extends T> optional, T t) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional) ? StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional) : t;
    }

    public static final <T> T getOrElse(Optional<? extends T> optional, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional) ? StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional) : function0.invoke();
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Optional<T> optional, C c) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        Intrinsics.checkNotNullParameter(c, FirebaseAnalytics.Param.DESTINATION);
        if (StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional)) {
            Object m = StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional);
            Intrinsics.checkNotNullExpressionValue(m, "get(...)");
            c.add(m);
        }
        return c;
    }

    public static final <T> List<T> toList(Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional) ? CollectionsKt.listOf(StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional)) : CollectionsKt.emptyList();
    }

    public static final <T> Set<T> toSet(Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        return StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional) ? SetsKt.setOf(StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional)) : SetsKt.emptySet();
    }

    public static final <T> Sequence<T> asSequence(Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        if (!StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional)) {
            return SequencesKt.emptySequence();
        }
        return SequencesKt.sequenceOf(StreamsKt$$ExternalSyntheticApiModelOutline0.m((Optional) optional));
    }
}
