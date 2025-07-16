package androidx.core.util;

import java.util.Objects;

public interface Predicate<T> {
    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t);

    /* renamed from: androidx.core.util.Predicate$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Predicate $default$and(Predicate _this, Predicate predicate) {
            Objects.requireNonNull(predicate);
            return new Predicate$$ExternalSyntheticLambda4(_this, predicate);
        }

        public static /* synthetic */ boolean $private$lambda$and$0(Predicate _this, Predicate predicate, Object obj) {
            return _this.test(obj) && predicate.test(obj);
        }

        public static Predicate $default$negate(Predicate _this) {
            return new Predicate$$ExternalSyntheticLambda5(_this);
        }

        public static /* synthetic */ boolean $private$lambda$negate$1(Predicate _this, Object obj) {
            return !_this.test(obj);
        }

        public static Predicate $default$or(Predicate _this, Predicate predicate) {
            Objects.requireNonNull(predicate);
            return new Predicate$$ExternalSyntheticLambda1(_this, predicate);
        }

        public static /* synthetic */ boolean $private$lambda$or$2(Predicate _this, Predicate predicate, Object obj) {
            return _this.test(obj) || predicate.test(obj);
        }

        public static <T> Predicate<T> isEqual(Object obj) {
            if (obj == null) {
                return new Predicate$$ExternalSyntheticLambda2();
            }
            return new Predicate$$ExternalSyntheticLambda3(obj);
        }

        public static <T> Predicate<T> not(Predicate<? super T> predicate) {
            Objects.requireNonNull(predicate);
            return predicate.negate();
        }
    }
}
