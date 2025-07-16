package com.google.android.play.core.ktx;

import com.google.android.play.core.review.ReviewManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.google.android.play.core.ktx.ReviewManagerKtxKt", f = "ReviewManagerKtx.kt", i = {}, l = {22}, m = "requestReview", n = {}, s = {})
/* compiled from: com.google.android.play:review-ktx@@2.0.1 */
final class ReviewManagerKtxKt$requestReview$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    ReviewManagerKtxKt$requestReview$1(Continuation<? super ReviewManagerKtxKt$requestReview$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReviewManagerKtxKt.requestReview((ReviewManager) null, this);
    }
}
