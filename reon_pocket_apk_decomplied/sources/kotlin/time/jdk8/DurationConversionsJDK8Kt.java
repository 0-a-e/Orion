package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\b¢\u0006\u0002\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, d2 = {"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)J", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0}, pn = "kotlin.time", xi = 48)
/* compiled from: DurationConversions.kt */
public final class DurationConversionsJDK8Kt {
    private static final long toKotlinDuration(Duration duration) {
        Intrinsics.checkNotNullParameter(duration, "<this>");
        return kotlin.time.Duration.m8411plusLRDsOJo(DurationKt.toDuration(StreamsKt$$ExternalSyntheticApiModelOutline0.m(duration), DurationUnit.SECONDS), DurationKt.toDuration(StreamsKt$$ExternalSyntheticApiModelOutline0.m(duration), DurationUnit.NANOSECONDS));
    }

    /* renamed from: toJavaDuration-LRDsOJo  reason: not valid java name */
    private static final Duration m8546toJavaDurationLRDsOJo(long j) {
        Duration m = Duration.ofSeconds(kotlin.time.Duration.m8396getInWholeSecondsimpl(j), (long) kotlin.time.Duration.m8398getNanosecondsComponentimpl(j));
        Intrinsics.checkNotNullExpressionValue(m, "toComponents-impl(...)");
        return m;
    }
}
