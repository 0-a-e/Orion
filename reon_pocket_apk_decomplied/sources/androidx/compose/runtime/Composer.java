package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001J@\u00105\u001a\u000206\"\u0004\b\u0000\u00107\"\u0004\b\u0001\u001082\u0006\u00109\u001a\u0002H72\u001d\u0010:\u001a\u0019\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002060;¢\u0006\u0002\b<H'¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020?H'J\u0012\u0010@\u001a\u00020\"2\b\u00109\u001a\u0004\u0018\u00010\u0001H'J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020\"H\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020AH\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020BH\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020CH\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020DH\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020\u0016H\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020EH\u0017J\u0010\u0010@\u001a\u00020\"2\u0006\u00109\u001a\u00020FH\u0017J\u0012\u0010G\u001a\u00020\"2\b\u00109\u001a\u0004\u0018\u00010\u0001H\u0017J\b\u0010H\u001a\u000206H&J!\u0010I\u001a\u0002H8\"\u0004\b\u0000\u001082\f\u0010J\u001a\b\u0012\u0004\u0012\u0002H80KH'¢\u0006\u0002\u0010LJ\u001c\u0010M\u001a\u000206\"\u0004\b\u0000\u001082\f\u0010N\u001a\b\u0012\u0004\u0012\u0002H80OH'J\u0010\u0010P\u001a\u0002062\u0006\u0010@\u001a\u00020\"H'J\b\u0010Q\u001a\u000206H'J\b\u0010R\u001a\u000206H'J\b\u0010S\u001a\u000206H'J\b\u0010T\u001a\u000206H'J\b\u0010U\u001a\u000206H'J\b\u0010V\u001a\u000206H'J\b\u0010W\u001a\u000206H'J\b\u0010X\u001a\u000206H'J\b\u0010Y\u001a\u000206H'J\n\u0010Z\u001a\u0004\u0018\u00010[H'J\b\u0010\\\u001a\u000206H'J\u0010\u0010]\u001a\u0002062\u0006\u0010^\u001a\u00020\u0016H'J\u001e\u0010_\u001a\u0002062\n\u00109\u001a\u0006\u0012\u0002\b\u00030`2\b\u0010a\u001a\u0004\u0018\u00010\u0001H'J$\u0010b\u001a\u0002062\u001a\u0010c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020f\u0012\u0006\u0012\u0004\u0018\u00010f0e0dH'J\u001c\u0010g\u001a\u00020\u00012\b\u0010h\u001a\u0004\u0018\u00010\u00012\b\u0010i\u001a\u0004\u0018\u00010\u0001H'J\u0016\u0010j\u001a\u0002062\f\u0010k\u001a\b\u0012\u0004\u0012\u0002060OH'J\u0010\u0010l\u001a\u0002062\u0006\u0010m\u001a\u00020*H'J\n\u0010n\u001a\u0004\u0018\u00010\u0001H'J\b\u0010o\u001a\u000206H'J\b\u0010p\u001a\u000206H'J\u0010\u0010q\u001a\u0002062\u0006\u0010q\u001a\u00020rH&J\b\u0010s\u001a\u000206H&J\u0018\u0010t\u001a\u0002062\u0006\u0010J\u001a\u00020\u00162\u0006\u0010q\u001a\u00020rH&J\b\u0010u\u001a\u000206H'J\u001a\u0010v\u001a\u0002062\u0006\u0010J\u001a\u00020\u00162\b\u0010w\u001a\u0004\u0018\u00010\u0001H'J\b\u0010x\u001a\u000206H'J\u0014\u0010y\u001a\u0002062\n\u00109\u001a\u0006\u0012\u0002\b\u00030zH'J!\u0010{\u001a\u0002062\u0012\u0010|\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030z0}H'¢\u0006\u0002\u0010~J\u0010\u0010\u001a\u0002062\u0006\u0010J\u001a\u00020\u0016H'J\u0011\u0010\u0001\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0016H'J\u001b\u0010\u0001\u001a\u0002062\u0006\u0010J\u001a\u00020\u00162\b\u0010w\u001a\u0004\u0018\u00010\u0001H'J\t\u0010\u0001\u001a\u000206H'J\u0013\u0010\u0001\u001a\u0002062\b\u00109\u001a\u0004\u0018\u00010\u0001H'J\t\u0010\u0001\u001a\u000206H'R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8gX§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0019R\u001a\u0010!\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010%R\u001c\u0010)\u001a\u0004\u0018\u00010*8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u00018&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0005\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0005\u001a\u0004\b4\u0010%\u0001\u0002\u0001ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0001À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/Composer;", "", "applier", "Landroidx/compose/runtime/Applier;", "getApplier$annotations", "()V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext$annotations", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compoundKeyHash", "", "getCompoundKeyHash$annotations", "getCompoundKeyHash", "()I", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "getCurrentMarker$annotations", "getCurrentMarker", "defaultsInvalid", "", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "()Z", "inserting", "getInserting$annotations", "getInserting", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope$annotations", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity$annotations", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "skipping", "getSkipping$annotations", "getSkipping", "apply", "", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "Landroidx/compose/runtime/CompositionContext;", "changed", "", "", "", "", "", "", "changedInstance", "collectParameterInformation", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createNode", "factory", "Lkotlin/Function0;", "deactivateToEndGroup", "disableReusing", "disableSourceInformation", "enableReusing", "endDefaults", "endMovableGroup", "endNode", "endProvider", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endToMarker", "marker", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentReferences", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "joinKey", "left", "right", "recordSideEffect", "effect", "recordUsed", "scope", "rememberedValue", "skipCurrentGroup", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "startDefaults", "startMovableGroup", "dataKey", "startNode", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "updateRememberedValue", "useNode", "Companion", "Landroidx/compose/runtime/ComposerImpl;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
public interface Composer {
    public static final Companion Companion = Companion.$$INSTANCE;

    @ComposeCompilerApi
    <V, T> void apply(V v, Function2<? super T, ? super V, Unit> function2);

    CompositionContext buildContext();

    @ComposeCompilerApi
    boolean changed(byte b);

    @ComposeCompilerApi
    boolean changed(char c);

    @ComposeCompilerApi
    boolean changed(double d);

    @ComposeCompilerApi
    boolean changed(float f);

    @ComposeCompilerApi
    boolean changed(int i);

    @ComposeCompilerApi
    boolean changed(long j);

    @ComposeCompilerApi
    boolean changed(Object obj);

    @ComposeCompilerApi
    boolean changed(short s);

    @ComposeCompilerApi
    boolean changed(boolean z);

    @ComposeCompilerApi
    boolean changedInstance(Object obj);

    void collectParameterInformation();

    <T> T consume(CompositionLocal<T> compositionLocal);

    @ComposeCompilerApi
    <T> void createNode(Function0<? extends T> function0);

    @ComposeCompilerApi
    void deactivateToEndGroup(boolean z);

    @ComposeCompilerApi
    void disableReusing();

    void disableSourceInformation();

    @ComposeCompilerApi
    void enableReusing();

    @ComposeCompilerApi
    void endDefaults();

    @ComposeCompilerApi
    void endMovableGroup();

    @ComposeCompilerApi
    void endNode();

    void endProvider();

    void endProviders();

    @ComposeCompilerApi
    void endReplaceableGroup();

    @ComposeCompilerApi
    ScopeUpdateScope endRestartGroup();

    @ComposeCompilerApi
    void endReusableGroup();

    @ComposeCompilerApi
    void endToMarker(int i);

    Applier<?> getApplier();

    CoroutineContext getApplyCoroutineContext();

    ControlledComposition getComposition();

    CompositionData getCompositionData();

    int getCompoundKeyHash();

    CompositionLocalMap getCurrentCompositionLocalMap();

    int getCurrentMarker();

    boolean getDefaultsInvalid();

    boolean getInserting();

    RecomposeScope getRecomposeScope();

    Object getRecomposeScopeIdentity();

    boolean getSkipping();

    void insertMovableContent(MovableContent<?> movableContent, Object obj);

    void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> list);

    @ComposeCompilerApi
    Object joinKey(Object obj, Object obj2);

    void recordSideEffect(Function0<Unit> function0);

    void recordUsed(RecomposeScope recomposeScope);

    @ComposeCompilerApi
    Object rememberedValue();

    @ComposeCompilerApi
    void skipCurrentGroup();

    @ComposeCompilerApi
    void skipToGroupEnd();

    void sourceInformation(String str);

    void sourceInformationMarkerEnd();

    void sourceInformationMarkerStart(int i, String str);

    @ComposeCompilerApi
    void startDefaults();

    @ComposeCompilerApi
    void startMovableGroup(int i, Object obj);

    @ComposeCompilerApi
    void startNode();

    void startProvider(ProvidedValue<?> providedValue);

    void startProviders(ProvidedValue<?>[] providedValueArr);

    @ComposeCompilerApi
    void startReplaceableGroup(int i);

    @ComposeCompilerApi
    Composer startRestartGroup(int i);

    @ComposeCompilerApi
    void startReusableGroup(int i, Object obj);

    @ComposeCompilerApi
    void startReusableNode();

    @ComposeCompilerApi
    void updateRememberedValue(Object obj);

    @ComposeCompilerApi
    void useNode();

    /* renamed from: androidx.compose.runtime.Composer$-CC  reason: invalid class name */
    /* compiled from: Composer.kt */
    public final /* synthetic */ class CC {
        static {
            Companion companion = Composer.Companion;
        }

        @ComposeCompilerApi
        public static /* synthetic */ void getApplier$annotations() {
        }

        public static /* synthetic */ void getApplyCoroutineContext$annotations() {
        }

        public static /* synthetic */ void getCompoundKeyHash$annotations() {
        }

        @ComposeCompilerApi
        public static /* synthetic */ void getCurrentMarker$annotations() {
        }

        @ComposeCompilerApi
        public static /* synthetic */ void getDefaultsInvalid$annotations() {
        }

        @ComposeCompilerApi
        public static /* synthetic */ void getInserting$annotations() {
        }

        public static /* synthetic */ void getRecomposeScope$annotations() {
        }

        @ComposeCompilerApi
        public static /* synthetic */ void getRecomposeScopeIdentity$annotations() {
        }

        @ComposeCompilerApi
        public static /* synthetic */ void getSkipping$annotations() {
        }

        @ComposeCompilerApi
        public static boolean $default$changed(Composer _this, boolean z) {
            return _this.changed(z);
        }

        @ComposeCompilerApi
        public static boolean $default$changed(Composer _this, char c) {
            return _this.changed(c);
        }

        @ComposeCompilerApi
        public static boolean $default$changed(Composer _this, byte b) {
            return _this.changed(b);
        }

        @ComposeCompilerApi
        public static boolean $default$changed(Composer _this, short s) {
            return _this.changed(s);
        }

        @ComposeCompilerApi
        public static boolean $default$changed(Composer _this, int i) {
            return _this.changed(i);
        }

        @ComposeCompilerApi
        public static boolean $default$changed(Composer _this, float f) {
            return _this.changed(f);
        }

        @ComposeCompilerApi
        public static boolean $default$changed(Composer _this, long j) {
            return _this.changed(j);
        }

        @ComposeCompilerApi
        public static boolean $default$changed(Composer _this, double d) {
            return _this.changed(d);
        }

        @ComposeCompilerApi
        public static boolean $default$changedInstance(Composer _this, Object obj) {
            return _this.changed(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Landroidx/compose/runtime/Composer$Companion;", "", "()V", "Empty", "getEmpty", "()Ljava/lang/Object;", "setTracer", "", "tracer", "Landroidx/compose/runtime/CompositionTracer;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Composer.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Object Empty = new Composer$Companion$Empty$1();

        private Companion() {
        }

        public final Object getEmpty() {
            return Empty;
        }

        public final void setTracer(CompositionTracer compositionTracer) {
            ComposerKt.compositionTracer = compositionTracer;
        }
    }
}
