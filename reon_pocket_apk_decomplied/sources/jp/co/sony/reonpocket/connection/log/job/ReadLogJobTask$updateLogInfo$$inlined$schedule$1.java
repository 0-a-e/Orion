package jp.co.sony.reonpocket.connection.log.job;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Timer.kt */
public final class ReadLogJobTask$updateLogInfo$$inlined$schedule$1 extends TimerTask {
    final /* synthetic */ Function1 $action;

    public ReadLogJobTask$updateLogInfo$$inlined$schedule$1(Function1 function1) {
        this.$action = function1;
    }

    public void run() {
        this.$action.invoke(this);
    }
}
