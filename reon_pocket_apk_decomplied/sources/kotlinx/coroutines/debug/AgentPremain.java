package kotlinx.coroutines.debug;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.AgentInstallationType;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import sun.misc.Signal;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain;", "", "()V", "enableCreationStackTraces", "", "installSignalHandler", "", "premain", "args", "", "instrumentation", "Ljava/lang/instrument/Instrumentation;", "DebugProbesTransformer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AgentPremain.kt */
public final class AgentPremain {
    public static final AgentPremain INSTANCE = new AgentPremain();
    private static final boolean enableCreationStackTraces;

    private AgentPremain() {
    }

    static {
        Object obj;
        boolean z;
        Boolean bool = null;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            obj = Result.m7042constructorimpl(property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m7042constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m7048isFailureimpl(obj)) {
            bool = obj;
        }
        Boolean bool2 = bool;
        if (bool2 != null) {
            z = bool2.booleanValue();
        } else {
            z = DebugProbesImpl.INSTANCE.getEnableCreationStackTraces$kotlinx_coroutines_core();
        }
        enableCreationStackTraces = z;
    }

    @JvmStatic
    public static final void premain(String str, Instrumentation instrumentation) {
        AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
        instrumentation.addTransformer(DebugProbesTransformer.INSTANCE);
        DebugProbesImpl.INSTANCE.setEnableCreationStackTraces$kotlinx_coroutines_core(enableCreationStackTraces);
        DebugProbesImpl.INSTANCE.install$kotlinx_coroutines_core();
        INSTANCE.installSignalHandler();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "()V", "transform", "", "loader", "Ljava/lang/ClassLoader;", "className", "", "classBeingRedefined", "Ljava/lang/Class;", "protectionDomain", "Ljava/security/ProtectionDomain;", "classfileBuffer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AgentPremain.kt */
    public static final class DebugProbesTransformer implements ClassFileTransformer {
        public static final DebugProbesTransformer INSTANCE = new DebugProbesTransformer();

        private DebugProbesTransformer() {
        }

        public byte[] transform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
            if (classLoader == null || !Intrinsics.areEqual((Object) str, (Object) "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
            return ByteStreamsKt.readBytes(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    private final void installSignalHandler() {
        try {
            Signal.handle(new Signal("TRAP"), new AgentPremain$$ExternalSyntheticLambda0());
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static final void installSignalHandler$lambda$1(Signal signal) {
        if (DebugProbesImpl.INSTANCE.isInstalled$kotlinx_coroutines_debug()) {
            DebugProbesImpl.INSTANCE.dumpCoroutines(System.out);
        } else {
            System.out.println("Cannot perform coroutines dump, debug probes are disabled");
        }
    }
}
