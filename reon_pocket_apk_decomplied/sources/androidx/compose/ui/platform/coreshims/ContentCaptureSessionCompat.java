package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.compose.ui.platform.RenderNodeApi29$$ExternalSyntheticApiModelOutline0;
import java.util.List;
import java.util.Objects;

public class ContentCaptureSessionCompat {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    public ContentCaptureSession toContentCaptureSession() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj);
    }

    private ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }

    public AutofillId newAutofillId(long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.newAutofillId(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), ((AutofillIdCompat) Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView))).toAutofillId(), j);
        }
        return null;
    }

    public ViewStructureCompat newVirtualViewStructure(AutofillId autofillId, long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), autofillId, j));
        }
        return null;
    }

    public void notifyViewsAppeared(List<ViewStructure> list) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.notifyViewsAppeared(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), list);
        } else if (Build.VERSION.SDK_INT >= 29) {
            ViewStructure newViewStructure = Api29Impl.newViewStructure(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            Api29Impl.notifyViewAppeared(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), newViewStructure);
            for (int i = 0; i < list.size(); i++) {
                Api29Impl.notifyViewAppeared(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), list.get(i));
            }
            ViewStructure newViewStructure2 = Api29Impl.newViewStructure(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure2).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            Api29Impl.notifyViewAppeared(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), newViewStructure2);
        }
    }

    public void notifyViewsDisappeared(long[] jArr) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api29Impl.notifyViewsDisappeared(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), ((AutofillIdCompat) Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView))).toAutofillId(), jArr);
        } else if (Build.VERSION.SDK_INT >= 29) {
            ViewStructure newViewStructure = Api29Impl.newViewStructure(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            Api29Impl.notifyViewAppeared(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), newViewStructure);
            Api29Impl.notifyViewsDisappeared(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), ((AutofillIdCompat) Objects.requireNonNull(ViewCompatShims.getAutofillId(this.mView))).toAutofillId(), jArr);
            ViewStructure newViewStructure2 = Api29Impl.newViewStructure(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure2).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            Api29Impl.notifyViewAppeared(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), newViewStructure2);
        }
    }

    public void notifyViewTextChanged(AutofillId autofillId, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewTextChanged(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), autofillId, charSequence);
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static void notifyViewsAppeared(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
            contentCaptureSession.notifyViewsAppeared(list);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static void notifyViewsDisappeared(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }

        static void notifyViewAppeared(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        static ViewStructure newViewStructure(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        static ViewStructure newVirtualViewStructure(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j);
        }

        static AutofillId newAutofillId(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
            return contentCaptureSession.newAutofillId(autofillId, j);
        }

        public static void notifyViewTextChanged(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }
}
