package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Repeatable;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.internal.RepeatableContainer;

@ComposeCompilerApi
@Target(allowedTargets = {AnnotationTarget.CLASS})
@Repeatable
@java.lang.annotation.Repeatable(Container.class)
@Retention(AnnotationRetention.RUNTIME)
@java.lang.annotation.Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003R\u000f\u0010\u0005\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/internal/FunctionKeyMeta;", "", "key", "", "startOffset", "endOffset", "()I", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* compiled from: FunctionKeyMeta.kt */
public @interface FunctionKeyMeta {

    @Target(allowedTargets = {AnnotationTarget.CLASS})
    @Retention(AnnotationRetention.RUNTIME)
    @RepeatableContainer
    @java.lang.annotation.Target({ElementType.TYPE})
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
    /* compiled from: FunctionKeyMeta.kt */
    public @interface Container {
        FunctionKeyMeta[] value();
    }

    int endOffset();

    int key();

    int startOffset();
}
