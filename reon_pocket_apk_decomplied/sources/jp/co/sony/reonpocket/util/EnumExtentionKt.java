package jp.co.sony.reonpocket.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0014\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0006\u001a:\u0010\u0007\u001a\u0004\u0018\u0001H\u0001\"\u001a\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0001\u0010\t2\u0006\u0010\n\u001a\u0002H\tH\b¢\u0006\u0002\u0010\u000b\u001a9\u0010\f\u001a\u0004\u0018\u0001H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000f0\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0011"}, d2 = {"findByCode", "T", "", "Ljp/co/sony/reonpocket/util/EnumWithCode;", "code", "", "(I)Ljava/lang/Enum;", "findByValue", "Ljp/co/sony/reonpocket/util/EnumWithValue;", "F", "aValue", "(Ljava/lang/Object;)Ljava/lang/Enum;", "valuesFind", "conditions", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Enum;", "app_prodRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: EnumExtention.kt */
public final class EnumExtentionKt {
    public static final /* synthetic */ <T extends Enum<T>> T valuesFind(Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "conditions");
        Intrinsics.reifiedOperationMarker(5, "T");
        Enum enumR = null;
        return null;
    }

    public static final /* synthetic */ <T extends Enum<T> & EnumWithValue<F>, F> T findByValue(F f) {
        Intrinsics.reifiedOperationMarker(5, "T");
        Enum enumR = null;
        return null;
    }

    public static final /* synthetic */ <T extends Enum<T> & EnumWithCode> T findByCode(int i) {
        Intrinsics.reifiedOperationMarker(5, "T");
        Enum enumR = null;
        return null;
    }
}
