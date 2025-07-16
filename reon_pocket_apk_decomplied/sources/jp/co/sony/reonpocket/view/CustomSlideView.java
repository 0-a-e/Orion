package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import java.util.List;
import jp.co.sony.reonpocket.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\f\b\u0007\u0018\u0000 E2\u00020\u0001:\u0005DEFGHB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\nH\u0002J\u001a\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0014J0\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0014J\u0012\u00103\u001a\u00020.2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0018\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\u00072\b\b\u0002\u00108\u001a\u00020.J\u0016\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\u0018J\u0006\u0010@\u001a\u00020\"J\u0010\u0010A\u001a\u00020\"2\b\b\u0002\u00108\u001a\u00020.J\u0010\u0010B\u001a\u00020\"2\u0006\u0010$\u001a\u00020\nH\u0002J\u0010\u0010C\u001a\u00020\"2\u0006\u0010$\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0018\u00010\u001dR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomSlideView;", "Ljp/co/sony/reonpocket/view/CustomAccessibilityView;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBottom", "", "mCircleHandler", "jp/co/sony/reonpocket/view/CustomSlideView$mCircleHandler$1", "Ljp/co/sony/reonpocket/view/CustomSlideView$mCircleHandler$1;", "mCurrentLevel", "mDefaultEndColor", "mDefaultStartColor", "mDownTimeMill", "", "mEndColor", "mLayoutListener", "Ljp/co/sony/reonpocket/view/CustomSlideView$OnLayoutListener;", "mLevelHeight", "mListener", "Ljp/co/sony/reonpocket/view/CustomSlideView$OnSlideListener;", "mMaxLevel", "mPaint", "Landroid/graphics/Paint;", "mSemicircleAccessHelper", "Ljp/co/sony/reonpocket/view/CustomSlideView$SliderAccessHelper;", "mStartColor", "mTop", "mUpTimeMill", "adjustTopCoordinate", "", "handleOnTouch", "aY", "initAttrs", "aContext", "aAttrs", "initVariable", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setCurrentLevel", "aLevel", "aIsAnime", "setGradientColor", "aStartColor", "aEndColor", "setMaxLevel", "aMax", "setOnSlideListener", "aListener", "setToMax", "setToOff", "setTop", "updateTouchCoordinate", "CircleThread", "Companion", "OnLayoutListener", "OnSlideListener", "SliderAccessHelper", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomSlideView.kt */
public final class CustomSlideView extends CustomAccessibilityView {
    public static final int $stable = 8;
    public static final long ANIMATION_DURATION = 100;
    public static final long CLICK_INTERVAL = 150;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long TIME_PER_FRAME = 16;
    public static final int UPDATE_MESSAGE = 1;
    /* access modifiers changed from: private */
    public static Thread animationThread;
    private float mBottom;
    /* access modifiers changed from: private */
    public final CustomSlideView$mCircleHandler$1 mCircleHandler;
    private final Context mContext;
    /* access modifiers changed from: private */
    public int mCurrentLevel;
    private final int mDefaultEndColor;
    private final int mDefaultStartColor;
    private long mDownTimeMill;
    private int mEndColor;
    /* access modifiers changed from: private */
    public OnLayoutListener mLayoutListener;
    private float mLevelHeight;
    private OnSlideListener mListener;
    /* access modifiers changed from: private */
    public int mMaxLevel;
    private Paint mPaint;
    private SliderAccessHelper mSemicircleAccessHelper;
    private int mStartColor;
    /* access modifiers changed from: private */
    public float mTop;
    private long mUpTimeMill;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomSlideView$OnLayoutListener;", "", "onLayoutOver", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomSlideView.kt */
    public interface OnLayoutListener {
        void onLayoutOver();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomSlideView$OnSlideListener;", "", "onSlideChange", "", "pos", "", "onSlideFinish", "onSlideStart", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomSlideView.kt */
    public interface OnSlideListener {
        void onSlideChange(int i);

        void onSlideFinish(int i);

        void onSlideStart(int i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomSlideView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomSlideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomSlideView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomSlideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.mMaxLevel = -1;
        this.mCurrentLevel = -1;
        int color = context.getColor(R.color.LevelAutoTopCool);
        this.mDefaultStartColor = color;
        int color2 = context.getColor(R.color.LevelAutoBottomCool);
        this.mDefaultEndColor = color2;
        this.mStartColor = color;
        this.mEndColor = color2;
        this.mPaint = new Paint();
        this.mCircleHandler = new CustomSlideView$mCircleHandler$1(this);
        initAttrs(context, attributeSet);
        initVariable();
        View view = this;
        SliderAccessHelper sliderAccessHelper = new SliderAccessHelper(this, view);
        this.mSemicircleAccessHelper = sliderAccessHelper;
        ViewCompat.setAccessibilityDelegate(view, sliderAccessHelper);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomSlideView$Companion;", "", "()V", "ANIMATION_DURATION", "", "CLICK_INTERVAL", "TIME_PER_FRAME", "UPDATE_MESSAGE", "", "animationThread", "Ljava/lang/Thread;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomSlideView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\u001c\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020 XD¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomSlideView$CircleThread;", "Ljava/lang/Runnable;", "targetLevel", "", "(Ljp/co/sony/reonpocket/view/CustomSlideView;I)V", "isUpper", "", "isUpper$app_prodRelease", "()Z", "setUpper$app_prodRelease", "(Z)V", "m", "getM$app_prodRelease", "()I", "setM$app_prodRelease", "(I)V", "moveY", "", "getMoveY$app_prodRelease", "()F", "setMoveY$app_prodRelease", "(F)V", "moveYPerFrame", "getMoveYPerFrame$app_prodRelease", "setMoveYPerFrame$app_prodRelease", "getTargetLevel", "targetY", "getTargetY$app_prodRelease", "tempY", "getTempY$app_prodRelease", "setTempY$app_prodRelease", "totalFrame", "", "getTotalFrame$app_prodRelease", "()J", "run", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomSlideView.kt */
    private final class CircleThread implements Runnable {
        private boolean isUpper;
        private int m = 1;
        private float moveY;
        private float moveYPerFrame;
        private final int targetLevel;
        private final float targetY;
        private float tempY;
        private final long totalFrame = 6;

        public CircleThread(int i) {
            this.targetLevel = i;
            boolean z = true;
            float height = ((float) CustomSlideView.this.getHeight()) - (((float) i) * (((float) CustomSlideView.this.getHeight()) / ((float) CustomSlideView.this.mMaxLevel)));
            this.targetY = height;
            float access$getMTop$p = height - CustomSlideView.this.mTop;
            this.moveY = access$getMTop$p;
            this.moveYPerFrame = access$getMTop$p / ((float) 6);
            this.isUpper = CustomSlideView.this.mTop >= height ? false : z;
        }

        public final int getTargetLevel() {
            return this.targetLevel;
        }

        public final int getM$app_prodRelease() {
            return this.m;
        }

        public final void setM$app_prodRelease(int i) {
            this.m = i;
        }

        public final float getTempY$app_prodRelease() {
            return this.tempY;
        }

        public final void setTempY$app_prodRelease(float f) {
            this.tempY = f;
        }

        public final long getTotalFrame$app_prodRelease() {
            return this.totalFrame;
        }

        public final float getTargetY$app_prodRelease() {
            return this.targetY;
        }

        public final float getMoveY$app_prodRelease() {
            return this.moveY;
        }

        public final void setMoveY$app_prodRelease(float f) {
            this.moveY = f;
        }

        public final float getMoveYPerFrame$app_prodRelease() {
            return this.moveYPerFrame;
        }

        public final void setMoveYPerFrame$app_prodRelease(float f) {
            this.moveYPerFrame = f;
        }

        public final boolean isUpper$app_prodRelease() {
            return this.isUpper;
        }

        public final void setUpper$app_prodRelease(boolean z) {
            this.isUpper = z;
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Message message = new Message();
                    message.what = 1;
                    int i = this.m;
                    if (((long) i) < this.totalFrame) {
                        this.m = i + 1;
                        float access$getMTop$p = CustomSlideView.this.mTop + this.moveYPerFrame;
                        this.tempY = access$getMTop$p;
                        if (this.isUpper) {
                            float f = this.targetY;
                            if (access$getMTop$p > f) {
                                this.tempY = f;
                            }
                        } else {
                            float f2 = this.targetY;
                            if (access$getMTop$p < f2) {
                                this.tempY = f2;
                            }
                        }
                        message.obj = Float.valueOf(this.tempY);
                        CustomSlideView.this.mCircleHandler.sendMessage(message);
                        Thread.sleep(16);
                    } else {
                        message.obj = Float.valueOf(this.targetY);
                        CustomSlideView.this.mCircleHandler.sendMessage(message);
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private final void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CustomSlideView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.mMaxLevel = obtainStyledAttributes.getInteger(R.styleable.CustomSlideView_maxLevel, 4);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private final void initVariable() {
        this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) getHeight(), this.mStartColor, this.mEndColor, Shader.TileMode.MIRROR));
        this.mBottom = (float) getHeight();
        this.mTop = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        OnLayoutListener onLayoutListener = this.mLayoutListener;
        if (onLayoutListener != null) {
            onLayoutListener.onLayoutOver();
        }
        if (this.mCurrentLevel == 0) {
            this.mTop = (float) getHeight();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.mPaint.setShader(new LinearGradient(((float) getWidth()) / 2.0f, this.mTop, ((float) getWidth()) / 2.0f, (float) getHeight(), this.mStartColor, this.mEndColor, Shader.TileMode.MIRROR));
        canvas.drawRect(0.0f, this.mTop, (float) getWidth(), (float) getHeight(), this.mPaint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    OnSlideListener onSlideListener = this.mListener;
                    if (onSlideListener != null) {
                        onSlideListener.onSlideFinish(this.mCurrentLevel);
                    }
                    performClick();
                } else if (action == 2 && handleOnTouch(motionEvent.getY()) != this.mCurrentLevel) {
                    int handleOnTouch = handleOnTouch(motionEvent.getY());
                    this.mCurrentLevel = handleOnTouch;
                    setCurrentLevel$default(this, handleOnTouch, false, 2, (Object) null);
                    OnSlideListener onSlideListener2 = this.mListener;
                    if (onSlideListener2 != null) {
                        onSlideListener2.onSlideChange(this.mCurrentLevel);
                    }
                    performClick();
                }
            } else if (handleOnTouch(motionEvent.getY()) != this.mCurrentLevel) {
                int handleOnTouch2 = handleOnTouch(motionEvent.getY());
                this.mCurrentLevel = handleOnTouch2;
                setCurrentLevel$default(this, handleOnTouch2, false, 2, (Object) null);
                OnSlideListener onSlideListener3 = this.mListener;
                if (onSlideListener3 != null) {
                    onSlideListener3.onSlideStart(this.mCurrentLevel);
                }
                OnSlideListener onSlideListener4 = this.mListener;
                if (onSlideListener4 != null) {
                    onSlideListener4.onSlideChange(this.mCurrentLevel);
                }
                performClick();
            }
        }
        return true;
    }

    public final void setMaxLevel(int i) {
        this.mMaxLevel = i;
    }

    public final void setGradientColor(int i, int i2) {
        this.mStartColor = this.mContext.getColor(i);
        this.mEndColor = this.mContext.getColor(i2);
    }

    public static /* synthetic */ void setCurrentLevel$default(CustomSlideView customSlideView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        customSlideView.setCurrentLevel(i, z);
    }

    public final void setCurrentLevel(int i, boolean z) {
        this.mCurrentLevel = i;
        if (z) {
            if (getHeight() == 0) {
                this.mLayoutListener = new CustomSlideView$setCurrentLevel$1(this);
                return;
            }
            Thread thread = new Thread(new CircleThread(this.mCurrentLevel));
            animationThread = thread;
            thread.start();
        } else if (getHeight() == 0) {
            this.mLayoutListener = new CustomSlideView$setCurrentLevel$2(this);
        } else {
            setTop(((float) getHeight()) - (((float) this.mCurrentLevel) * (((float) getHeight()) / ((float) this.mMaxLevel))));
        }
    }

    public static /* synthetic */ void setToOff$default(CustomSlideView customSlideView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        customSlideView.setToOff(z);
    }

    public final void setToOff(boolean z) {
        setCurrentLevel(0, z);
    }

    public final void setToMax() {
        new Thread(new CircleThread(this.mMaxLevel)).start();
        this.mCurrentLevel = this.mMaxLevel;
    }

    public final void setOnSlideListener(OnSlideListener onSlideListener) {
        Intrinsics.checkNotNullParameter(onSlideListener, "aListener");
        this.mListener = onSlideListener;
    }

    private final void updateTouchCoordinate(float f) {
        this.mLevelHeight = ((float) getHeight()) / ((float) this.mMaxLevel);
        getHeight();
        if (f > ((float) getHeight())) {
            f = 0.0f;
        } else if (f > ((float) getHeight()) - this.mLevelHeight) {
            f = ((float) getHeight()) - this.mLevelHeight;
        }
        this.mTop = f;
        postInvalidate();
    }

    private final int handleOnTouch(float f) {
        this.mLevelHeight = ((float) getHeight()) / ((float) this.mMaxLevel);
        if (f > ((float) getHeight()) || f < 0.0f) {
            return this.mCurrentLevel;
        }
        int i = this.mMaxLevel;
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            float f2 = this.mLevelHeight;
            float f3 = ((float) i2) * f2;
            if (f < ((float) i3) * f2 && f > f3) {
                return this.mMaxLevel - i2;
            }
            i2 = i3;
        }
        return i;
    }

    private final void adjustTopCoordinate() {
        this.mLevelHeight = ((float) getHeight()) / ((float) this.mMaxLevel);
        this.mTop = ((float) getHeight()) - (this.mLevelHeight * ((float) this.mCurrentLevel));
        postInvalidate();
    }

    /* access modifiers changed from: private */
    public final void setTop(float f) {
        this.mTop = f;
        postInvalidate();
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0018\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0014J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Ljp/co/sony/reonpocket/view/CustomSlideView$SliderAccessHelper;", "Landroidx/customview/widget/ExploreByTouchHelper;", "aView", "Landroid/view/View;", "(Ljp/co/sony/reonpocket/view/CustomSlideView;Landroid/view/View;)V", "getAView", "()Landroid/view/View;", "getVirtualViewAt", "", "x", "", "y", "getVisibleVirtualViews", "", "virtualViewIds", "", "onPerformActionForVirtualView", "", "virtualViewId", "action", "arguments", "Landroid/os/Bundle;", "onPopulateNodeForVirtualView", "node", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomSlideView.kt */
    public final class SliderAccessHelper extends ExploreByTouchHelper {
        private final View aView;
        final /* synthetic */ CustomSlideView this$0;

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float f, float f2) {
            return 0;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> list) {
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "node");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SliderAccessHelper(CustomSlideView customSlideView, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "aView");
            this.this$0 = customSlideView;
            this.aView = view;
        }

        public final View getAView() {
            return this.aView;
        }
    }
}
