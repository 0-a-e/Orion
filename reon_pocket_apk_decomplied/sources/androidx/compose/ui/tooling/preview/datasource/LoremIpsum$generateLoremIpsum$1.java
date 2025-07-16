package androidx.compose.ui.tooling.preview.datasource;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LoremIpsum.android.kt */
final class LoremIpsum$generateLoremIpsum$1 extends Lambda implements Function0<String> {
    final /* synthetic */ int $loremIpsumMaxSize;
    final /* synthetic */ Ref.IntRef $wordsUsed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoremIpsum$generateLoremIpsum$1(Ref.IntRef intRef, int i) {
        super(0);
        this.$wordsUsed = intRef;
        this.$loremIpsumMaxSize = i;
    }

    public final String invoke() {
        List access$getLOREM_IPSUM_SOURCE$p = LoremIpsum_androidKt.LOREM_IPSUM_SOURCE;
        int i = this.$wordsUsed.element;
        this.$wordsUsed.element = i + 1;
        return (String) access$getLOREM_IPSUM_SOURCE$p.get(i % this.$loremIpsumMaxSize);
    }
}
