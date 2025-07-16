package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    static final boolean ALLOWS_EMBEDDED = false;
    private static final boolean CACHE_MEASURED_DIMENSION = false;
    private static final boolean DEBUG = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-1.1.3";
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    private boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOptimizationLevel = 7;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>(100);

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.mDesignIds.put(str, num);
        }
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public ConstraintLayout(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    private void init(AttributeSet attributeSet) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.widget = new Guideline();
            layoutParams.isGuideline = true;
            ((Guideline) layoutParams.widget).setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.remove(viewWidget);
        this.mConstraintHelpers.remove(view);
        this.mVariableDimensionsWidgets.remove(viewWidget);
        this.mDirtyHierarchy = true;
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    private void updateHierarchy() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).isLayoutRequested()) {
                this.mVariableDimensionsWidgets.clear();
                setChildrenConstraints();
                return;
            }
        }
    }

    private void setChildrenConstraints() {
        int i;
        int i2;
        float f;
        ConstraintWidget targetWidget;
        ConstraintWidget targetWidget2;
        ConstraintWidget targetWidget3;
        ConstraintWidget targetWidget4;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        boolean z = false;
        if (isInEditMode) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).setDebugName(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i4));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.applyToInternal(this);
        }
        this.mLayoutWidget.removeAllChildren();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).updatePreLayout(this);
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt3 = getChildAt(i7);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).updatePreLayout(this);
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt4 = getChildAt(i8);
            ConstraintWidget viewWidget2 = getViewWidget(childAt4);
            if (viewWidget2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt4.getLayoutParams();
                layoutParams.validate();
                if (layoutParams.helped) {
                    layoutParams.helped = z;
                } else if (isInEditMode) {
                    try {
                        String resourceName2 = getResources().getResourceName(childAt4.getId());
                        setDesignInformation(z ? 1 : 0, resourceName2, Integer.valueOf(childAt4.getId()));
                        getTargetWidget(childAt4.getId()).setDebugName(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                    } catch (Resources.NotFoundException unused2) {
                    }
                }
                viewWidget2.setVisibility(childAt4.getVisibility());
                if (layoutParams.isInPlaceholder) {
                    viewWidget2.setVisibility(8);
                }
                viewWidget2.setCompanionWidget(childAt4);
                this.mLayoutWidget.add(viewWidget2);
                if (!layoutParams.verticalDimensionFixed || !layoutParams.horizontalDimensionFixed) {
                    this.mVariableDimensionsWidgets.add(viewWidget2);
                }
                if (layoutParams.isGuideline) {
                    Guideline guideline = (Guideline) viewWidget2;
                    int i9 = layoutParams.resolvedGuideBegin;
                    int i10 = layoutParams.resolvedGuideEnd;
                    float f2 = layoutParams.resolvedGuidePercent;
                    if (f2 != -1.0f) {
                        guideline.setGuidePercent(f2);
                    } else if (i9 != -1) {
                        guideline.setGuideBegin(i9);
                    } else if (i10 != -1) {
                        guideline.setGuideEnd(i10);
                    }
                } else if (layoutParams.leftToLeft != -1 || layoutParams.leftToRight != -1 || layoutParams.rightToLeft != -1 || layoutParams.rightToRight != -1 || layoutParams.startToStart != -1 || layoutParams.startToEnd != -1 || layoutParams.endToStart != -1 || layoutParams.endToEnd != -1 || layoutParams.topToTop != -1 || layoutParams.topToBottom != -1 || layoutParams.bottomToTop != -1 || layoutParams.bottomToBottom != -1 || layoutParams.baselineToBaseline != -1 || layoutParams.editorAbsoluteX != -1 || layoutParams.editorAbsoluteY != -1 || layoutParams.circleConstraint != -1 || layoutParams.width == -1 || layoutParams.height == -1) {
                    int i11 = layoutParams.resolvedLeftToLeft;
                    int i12 = layoutParams.resolvedLeftToRight;
                    int i13 = layoutParams.resolvedRightToLeft;
                    int i14 = layoutParams.resolvedRightToRight;
                    int i15 = layoutParams.resolveGoneLeftMargin;
                    int i16 = layoutParams.resolveGoneRightMargin;
                    float f3 = layoutParams.resolvedHorizontalBias;
                    if (layoutParams.circleConstraint != -1) {
                        ConstraintWidget targetWidget5 = getTargetWidget(layoutParams.circleConstraint);
                        if (targetWidget5 != null) {
                            viewWidget2.connectCircularConstraint(targetWidget5, layoutParams.circleAngle, layoutParams.circleRadius);
                        }
                    } else {
                        if (i11 != -1) {
                            ConstraintWidget targetWidget6 = getTargetWidget(i11);
                            if (targetWidget6 != null) {
                                f = f3;
                                ConstraintWidget constraintWidget = targetWidget6;
                                i2 = i16;
                                i = i14;
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, layoutParams.leftMargin, i15);
                            } else {
                                f = f3;
                                i2 = i16;
                                i = i14;
                            }
                        } else {
                            f = f3;
                            i2 = i16;
                            int i17 = i15;
                            i = i14;
                            if (!(i12 == -1 || (targetWidget4 = getTargetWidget(i12)) == null)) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.LEFT, targetWidget4, ConstraintAnchor.Type.RIGHT, layoutParams.leftMargin, i17);
                            }
                        }
                        if (i13 != -1) {
                            ConstraintWidget targetWidget7 = getTargetWidget(i13);
                            if (targetWidget7 != null) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.RIGHT, targetWidget7, ConstraintAnchor.Type.LEFT, layoutParams.rightMargin, i2);
                            }
                        } else {
                            int i18 = i;
                            if (!(i18 == -1 || (targetWidget3 = getTargetWidget(i18)) == null)) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.RIGHT, targetWidget3, ConstraintAnchor.Type.RIGHT, layoutParams.rightMargin, i2);
                            }
                        }
                        if (layoutParams.topToTop != -1) {
                            ConstraintWidget targetWidget8 = getTargetWidget(layoutParams.topToTop);
                            if (targetWidget8 != null) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.TOP, targetWidget8, ConstraintAnchor.Type.TOP, layoutParams.topMargin, layoutParams.goneTopMargin);
                            }
                        } else if (!(layoutParams.topToBottom == -1 || (targetWidget2 = getTargetWidget(layoutParams.topToBottom)) == null)) {
                            viewWidget2.immediateConnect(ConstraintAnchor.Type.TOP, targetWidget2, ConstraintAnchor.Type.BOTTOM, layoutParams.topMargin, layoutParams.goneTopMargin);
                        }
                        if (layoutParams.bottomToTop != -1) {
                            ConstraintWidget targetWidget9 = getTargetWidget(layoutParams.bottomToTop);
                            if (targetWidget9 != null) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.BOTTOM, targetWidget9, ConstraintAnchor.Type.TOP, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                            }
                        } else if (!(layoutParams.bottomToBottom == -1 || (targetWidget = getTargetWidget(layoutParams.bottomToBottom)) == null)) {
                            viewWidget2.immediateConnect(ConstraintAnchor.Type.BOTTOM, targetWidget, ConstraintAnchor.Type.BOTTOM, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                        }
                        if (layoutParams.baselineToBaseline != -1) {
                            View view = this.mChildrenByIds.get(layoutParams.baselineToBaseline);
                            ConstraintWidget targetWidget10 = getTargetWidget(layoutParams.baselineToBaseline);
                            if (!(targetWidget10 == null || view == null || !(view.getLayoutParams() instanceof LayoutParams))) {
                                layoutParams.needsBaseline = true;
                                ((LayoutParams) view.getLayoutParams()).needsBaseline = true;
                                viewWidget2.getAnchor(ConstraintAnchor.Type.BASELINE).connect(targetWidget10.getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
                                viewWidget2.getAnchor(ConstraintAnchor.Type.TOP).reset();
                                viewWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                            }
                        }
                        if (f >= 0.0f && f != 0.5f) {
                            viewWidget2.setHorizontalBiasPercent(f);
                        }
                        if (layoutParams.verticalBias >= 0.0f && layoutParams.verticalBias != 0.5f) {
                            viewWidget2.setVerticalBiasPercent(layoutParams.verticalBias);
                        }
                    }
                    if (isInEditMode && !(layoutParams.editorAbsoluteX == -1 && layoutParams.editorAbsoluteY == -1)) {
                        viewWidget2.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
                    }
                    if (layoutParams.horizontalDimensionFixed) {
                        viewWidget2.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                        viewWidget2.setWidth(layoutParams.width);
                    } else if (layoutParams.width == -1) {
                        viewWidget2.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                        viewWidget2.getAnchor(ConstraintAnchor.Type.LEFT).mMargin = layoutParams.leftMargin;
                        viewWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = layoutParams.rightMargin;
                    } else {
                        viewWidget2.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                        viewWidget2.setWidth(0);
                    }
                    if (layoutParams.verticalDimensionFixed) {
                        z = false;
                        viewWidget2.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                        viewWidget2.setHeight(layoutParams.height);
                    } else if (layoutParams.height == -1) {
                        viewWidget2.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                        viewWidget2.getAnchor(ConstraintAnchor.Type.TOP).mMargin = layoutParams.topMargin;
                        viewWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = layoutParams.bottomMargin;
                        z = false;
                    } else {
                        viewWidget2.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                        z = false;
                        viewWidget2.setHeight(0);
                    }
                    if (layoutParams.dimensionRatio != null) {
                        viewWidget2.setDimensionRatio(layoutParams.dimensionRatio);
                    }
                    viewWidget2.setHorizontalWeight(layoutParams.horizontalWeight);
                    viewWidget2.setVerticalWeight(layoutParams.verticalWeight);
                    viewWidget2.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
                    viewWidget2.setVerticalChainStyle(layoutParams.verticalChainStyle);
                    viewWidget2.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
                    viewWidget2.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
                }
            }
        }
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    private void internalMeasureChildren(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int i3;
        int i4;
        int i5 = i;
        int i6 = i2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.widget;
                if (!layoutParams.isGuideline && !layoutParams.isHelper) {
                    constraintWidget.setVisibility(childAt.getVisibility());
                    int i8 = layoutParams.width;
                    int i9 = layoutParams.height;
                    if (layoutParams.horizontalDimensionFixed || layoutParams.verticalDimensionFixed || (!layoutParams.horizontalDimensionFixed && layoutParams.matchConstraintDefaultWidth == 1) || layoutParams.width == -1 || (!layoutParams.verticalDimensionFixed && (layoutParams.matchConstraintDefaultHeight == 1 || layoutParams.height == -1))) {
                        if (i8 == 0) {
                            i3 = getChildMeasureSpec(i5, paddingLeft, -2);
                            z2 = true;
                        } else if (i8 == -1) {
                            i3 = getChildMeasureSpec(i5, paddingLeft, -1);
                            z2 = false;
                        } else {
                            z2 = i8 == -2;
                            i3 = getChildMeasureSpec(i5, paddingLeft, i8);
                        }
                        if (i9 == 0) {
                            z = true;
                            i4 = getChildMeasureSpec(i6, paddingTop, -2);
                        } else if (i9 == -1) {
                            i4 = getChildMeasureSpec(i6, paddingTop, -1);
                            z = false;
                        } else {
                            z = i9 == -2;
                            i4 = getChildMeasureSpec(i6, paddingTop, i9);
                        }
                        childAt.measure(i3, i4);
                        Metrics metrics = this.mMetrics;
                        if (metrics != null) {
                            metrics.measures++;
                        }
                        constraintWidget.setWidthWrapContent(i8 == -2);
                        constraintWidget.setHeightWrapContent(i9 == -2);
                        i8 = childAt.getMeasuredWidth();
                        i9 = childAt.getMeasuredHeight();
                    } else {
                        z2 = false;
                        z = false;
                    }
                    constraintWidget.setWidth(i8);
                    constraintWidget.setHeight(i9);
                    if (z2) {
                        constraintWidget.setWrapWidth(i8);
                    }
                    if (z) {
                        constraintWidget.setWrapHeight(i9);
                    }
                    if (layoutParams.needsBaseline && (baseline = childAt.getBaseline()) != -1) {
                        constraintWidget.setBaselineDistance(baseline);
                    }
                }
            }
        }
    }

    private void updatePostMeasures() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).updatePostMeasure(this);
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.mConstraintHelpers.get(i2).updatePostMeasure(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void internalMeasureDimensions(int r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            int r3 = r23.getPaddingTop()
            int r4 = r23.getPaddingBottom()
            int r3 = r3 + r4
            int r4 = r23.getPaddingLeft()
            int r5 = r23.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r23.getChildCount()
            r7 = 0
        L_0x001d:
            r8 = 1
            r10 = 8
            r12 = -2
            if (r7 >= r5) goto L_0x00dc
            android.view.View r14 = r0.getChildAt(r7)
            int r15 = r14.getVisibility()
            if (r15 != r10) goto L_0x0030
            goto L_0x00d4
        L_0x0030:
            android.view.ViewGroup$LayoutParams r10 = r14.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r10
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = r10.widget
            boolean r6 = r10.isGuideline
            if (r6 != 0) goto L_0x00d4
            boolean r6 = r10.isHelper
            if (r6 == 0) goto L_0x0042
            goto L_0x00d4
        L_0x0042:
            int r6 = r14.getVisibility()
            r15.setVisibility(r6)
            int r6 = r10.width
            int r13 = r10.height
            if (r6 == 0) goto L_0x00c4
            if (r13 != 0) goto L_0x0053
            goto L_0x00c4
        L_0x0053:
            if (r6 != r12) goto L_0x0058
            r16 = 1
            goto L_0x005a
        L_0x0058:
            r16 = 0
        L_0x005a:
            int r11 = getChildMeasureSpec(r1, r4, r6)
            if (r13 != r12) goto L_0x0063
            r17 = 1
            goto L_0x0065
        L_0x0063:
            r17 = 0
        L_0x0065:
            int r12 = getChildMeasureSpec(r2, r3, r13)
            r14.measure(r11, r12)
            androidx.constraintlayout.solver.Metrics r11 = r0.mMetrics
            r12 = r3
            if (r11 == 0) goto L_0x0076
            long r2 = r11.measures
            long r2 = r2 + r8
            r11.measures = r2
        L_0x0076:
            r2 = -2
            if (r6 != r2) goto L_0x007b
            r3 = 1
            goto L_0x007c
        L_0x007b:
            r3 = 0
        L_0x007c:
            r15.setWidthWrapContent(r3)
            if (r13 != r2) goto L_0x0083
            r13 = 1
            goto L_0x0084
        L_0x0083:
            r13 = 0
        L_0x0084:
            r15.setHeightWrapContent(r13)
            int r2 = r14.getMeasuredWidth()
            int r3 = r14.getMeasuredHeight()
            r15.setWidth(r2)
            r15.setHeight(r3)
            if (r16 == 0) goto L_0x009a
            r15.setWrapWidth(r2)
        L_0x009a:
            if (r17 == 0) goto L_0x009f
            r15.setWrapHeight(r3)
        L_0x009f:
            boolean r6 = r10.needsBaseline
            if (r6 == 0) goto L_0x00ad
            int r6 = r14.getBaseline()
            r8 = -1
            if (r6 == r8) goto L_0x00ad
            r15.setBaselineDistance(r6)
        L_0x00ad:
            boolean r6 = r10.horizontalDimensionFixed
            if (r6 == 0) goto L_0x00d5
            boolean r6 = r10.verticalDimensionFixed
            if (r6 == 0) goto L_0x00d5
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r15.getResolutionWidth()
            r6.resolve(r2)
            androidx.constraintlayout.solver.widgets.ResolutionDimension r2 = r15.getResolutionHeight()
            r2.resolve(r3)
            goto L_0x00d5
        L_0x00c4:
            r12 = r3
            androidx.constraintlayout.solver.widgets.ResolutionDimension r2 = r15.getResolutionWidth()
            r2.invalidate()
            androidx.constraintlayout.solver.widgets.ResolutionDimension r2 = r15.getResolutionHeight()
            r2.invalidate()
            goto L_0x00d5
        L_0x00d4:
            r12 = r3
        L_0x00d5:
            int r7 = r7 + 1
            r2 = r25
            r3 = r12
            goto L_0x001d
        L_0x00dc:
            r12 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r2 = r0.mLayoutWidget
            r2.solveGraph()
            r2 = 0
        L_0x00e3:
            if (r2 >= r5) goto L_0x02e6
            android.view.View r3 = r0.getChildAt(r2)
            int r6 = r3.getVisibility()
            if (r6 != r10) goto L_0x00f1
            goto L_0x02cf
        L_0x00f1:
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r6 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r6
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r6.widget
            boolean r11 = r6.isGuideline
            if (r11 != 0) goto L_0x02cf
            boolean r11 = r6.isHelper
            if (r11 == 0) goto L_0x0103
            goto L_0x02cf
        L_0x0103:
            int r11 = r3.getVisibility()
            r7.setVisibility(r11)
            int r11 = r6.width
            int r13 = r6.height
            if (r11 == 0) goto L_0x0114
            if (r13 == 0) goto L_0x0114
            goto L_0x02cf
        L_0x0114:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r14 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r7.getAnchor(r14)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r14 = r14.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r15 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r7.getAnchor(r15)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r15 = r15.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r7.getAnchor(r10)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r10.getTarget()
            if (r10 == 0) goto L_0x0142
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r7.getAnchor(r10)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r10.getTarget()
            if (r10 == 0) goto L_0x0142
            r10 = 1
            goto L_0x0143
        L_0x0142:
            r10 = 0
        L_0x0143:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r7.getAnchor(r8)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r7.getAnchor(r9)
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r9 = r9.getResolutionNode()
            r17 = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r7.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.getTarget()
            if (r5 == 0) goto L_0x0173
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r7.getAnchor(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.getTarget()
            if (r5 == 0) goto L_0x0173
            r5 = 1
            goto L_0x0174
        L_0x0173:
            r5 = 0
        L_0x0174:
            if (r11 != 0) goto L_0x0187
            if (r13 != 0) goto L_0x0187
            if (r10 == 0) goto L_0x0187
            if (r5 == 0) goto L_0x0187
            r5 = r25
            r6 = r0
            r20 = r2
            r2 = -1
            r8 = -2
            r18 = 1
            goto L_0x02da
        L_0x0187:
            r20 = r2
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r2 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = r2.getHorizontalDimensionBehaviour()
            r21 = r6
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 == r6) goto L_0x0197
            r2 = 1
            goto L_0x0198
        L_0x0197:
            r2 = 0
        L_0x0198:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r6 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r6.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r6 == r0) goto L_0x01a4
            r0 = 1
            goto L_0x01a5
        L_0x01a4:
            r0 = 0
        L_0x01a5:
            if (r2 != 0) goto L_0x01ae
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r7.getResolutionWidth()
            r6.invalidate()
        L_0x01ae:
            if (r0 != 0) goto L_0x01b7
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r7.getResolutionHeight()
            r6.invalidate()
        L_0x01b7:
            if (r11 != 0) goto L_0x01ee
            if (r2 == 0) goto L_0x01e5
            boolean r6 = r7.isSpreadWidth()
            if (r6 == 0) goto L_0x01e5
            if (r10 == 0) goto L_0x01e5
            boolean r6 = r14.isResolved()
            if (r6 == 0) goto L_0x01e5
            boolean r6 = r15.isResolved()
            if (r6 == 0) goto L_0x01e5
            float r6 = r15.getResolvedValue()
            float r10 = r14.getResolvedValue()
            float r6 = r6 - r10
            int r11 = (int) r6
            androidx.constraintlayout.solver.widgets.ResolutionDimension r6 = r7.getResolutionWidth()
            r6.resolve(r11)
            int r6 = getChildMeasureSpec(r1, r4, r11)
            goto L_0x01f7
        L_0x01e5:
            r6 = -2
            int r2 = getChildMeasureSpec(r1, r4, r6)
            r6 = r2
            r2 = 0
            r10 = 1
            goto L_0x0207
        L_0x01ee:
            r6 = -2
            r10 = -1
            if (r11 != r10) goto L_0x01f9
            int r14 = getChildMeasureSpec(r1, r4, r10)
            r6 = r14
        L_0x01f7:
            r10 = 0
            goto L_0x0207
        L_0x01f9:
            if (r11 != r6) goto L_0x01fd
            r6 = 1
            goto L_0x01fe
        L_0x01fd:
            r6 = 0
        L_0x01fe:
            int r10 = getChildMeasureSpec(r1, r4, r11)
            r22 = r10
            r10 = r6
            r6 = r22
        L_0x0207:
            if (r13 != 0) goto L_0x0242
            if (r0 == 0) goto L_0x0237
            boolean r14 = r7.isSpreadHeight()
            if (r14 == 0) goto L_0x0237
            if (r5 == 0) goto L_0x0237
            boolean r5 = r8.isResolved()
            if (r5 == 0) goto L_0x0237
            boolean r5 = r9.isResolved()
            if (r5 == 0) goto L_0x0237
            float r5 = r9.getResolvedValue()
            float r8 = r8.getResolvedValue()
            float r5 = r5 - r8
            int r13 = (int) r5
            androidx.constraintlayout.solver.widgets.ResolutionDimension r5 = r7.getResolutionHeight()
            r5.resolve(r13)
            r5 = r25
            int r8 = getChildMeasureSpec(r5, r12, r13)
            goto L_0x024d
        L_0x0237:
            r5 = r25
            r8 = -2
            int r0 = getChildMeasureSpec(r5, r12, r8)
            r8 = r0
            r0 = 0
            r9 = 1
            goto L_0x025d
        L_0x0242:
            r5 = r25
            r8 = -2
            r9 = -1
            if (r13 != r9) goto L_0x024f
            int r14 = getChildMeasureSpec(r5, r12, r9)
            r8 = r14
        L_0x024d:
            r9 = 0
            goto L_0x025d
        L_0x024f:
            if (r13 != r8) goto L_0x0253
            r8 = 1
            goto L_0x0254
        L_0x0253:
            r8 = 0
        L_0x0254:
            int r9 = getChildMeasureSpec(r5, r12, r13)
            r22 = r9
            r9 = r8
            r8 = r22
        L_0x025d:
            r3.measure(r6, r8)
            r6 = r23
            androidx.constraintlayout.solver.Metrics r8 = r6.mMetrics
            if (r8 == 0) goto L_0x026f
            long r14 = r8.measures
            r18 = 1
            long r14 = r14 + r18
            r8.measures = r14
            goto L_0x0271
        L_0x026f:
            r18 = 1
        L_0x0271:
            r8 = -2
            if (r11 != r8) goto L_0x0276
            r11 = 1
            goto L_0x0277
        L_0x0276:
            r11 = 0
        L_0x0277:
            r7.setWidthWrapContent(r11)
            if (r13 != r8) goto L_0x027e
            r11 = 1
            goto L_0x027f
        L_0x027e:
            r11 = 0
        L_0x027f:
            r7.setHeightWrapContent(r11)
            int r11 = r3.getMeasuredWidth()
            int r13 = r3.getMeasuredHeight()
            r7.setWidth(r11)
            r7.setHeight(r13)
            if (r10 == 0) goto L_0x0295
            r7.setWrapWidth(r11)
        L_0x0295:
            if (r9 == 0) goto L_0x029a
            r7.setWrapHeight(r13)
        L_0x029a:
            if (r2 == 0) goto L_0x02a4
            androidx.constraintlayout.solver.widgets.ResolutionDimension r2 = r7.getResolutionWidth()
            r2.resolve(r11)
            goto L_0x02ab
        L_0x02a4:
            androidx.constraintlayout.solver.widgets.ResolutionDimension r2 = r7.getResolutionWidth()
            r2.remove()
        L_0x02ab:
            if (r0 == 0) goto L_0x02b5
            androidx.constraintlayout.solver.widgets.ResolutionDimension r0 = r7.getResolutionHeight()
            r0.resolve(r13)
            goto L_0x02bc
        L_0x02b5:
            androidx.constraintlayout.solver.widgets.ResolutionDimension r0 = r7.getResolutionHeight()
            r0.remove()
        L_0x02bc:
            r0 = r21
            boolean r0 = r0.needsBaseline
            if (r0 == 0) goto L_0x02cd
            int r0 = r3.getBaseline()
            r2 = -1
            if (r0 == r2) goto L_0x02da
            r7.setBaselineDistance(r0)
            goto L_0x02da
        L_0x02cd:
            r2 = -1
            goto L_0x02da
        L_0x02cf:
            r6 = r0
            r20 = r2
            r17 = r5
            r18 = r8
            r2 = -1
            r8 = -2
            r5 = r25
        L_0x02da:
            int r0 = r20 + 1
            r2 = r0
            r0 = r6
            r5 = r17
            r8 = r18
            r10 = 8
            goto L_0x00e3
        L_0x02e6:
            r6 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.internalMeasureDimensions(int, int):void");
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            java.lang.System.currentTimeMillis()
            int r3 = android.view.View.MeasureSpec.getMode(r24)
            int r4 = android.view.View.MeasureSpec.getSize(r24)
            int r5 = android.view.View.MeasureSpec.getMode(r25)
            int r6 = android.view.View.MeasureSpec.getSize(r25)
            int r7 = r23.getPaddingLeft()
            int r8 = r23.getPaddingTop()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            r9.setX(r7)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            r9.setY(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r10 = r0.mMaxWidth
            r9.setMaxWidth(r10)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r10 = r0.mMaxHeight
            r9.setMaxHeight(r10)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r10 = r23.getLayoutDirection()
            r11 = 0
            r12 = 1
            if (r10 != r12) goto L_0x0045
            r10 = r12
            goto L_0x0046
        L_0x0045:
            r10 = r11
        L_0x0046:
            r9.setRtl(r10)
            r23.setSelfDimensionBehaviour(r24, r25)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r9 = r9.getWidth()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r10 = r0.mLayoutWidget
            int r10 = r10.getHeight()
            boolean r13 = r0.mDirtyHierarchy
            if (r13 == 0) goto L_0x0063
            r0.mDirtyHierarchy = r11
            r23.updateHierarchy()
            r13 = r12
            goto L_0x0064
        L_0x0063:
            r13 = r11
        L_0x0064:
            int r14 = r0.mOptimizationLevel
            r15 = 8
            r14 = r14 & r15
            if (r14 != r15) goto L_0x006d
            r14 = r12
            goto L_0x006e
        L_0x006d:
            r14 = r11
        L_0x006e:
            if (r14 == 0) goto L_0x007e
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r15 = r0.mLayoutWidget
            r15.preOptimize()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r15 = r0.mLayoutWidget
            r15.optimizeForDimensions(r9, r10)
            r23.internalMeasureDimensions(r24, r25)
            goto L_0x0081
        L_0x007e:
            r23.internalMeasureChildren(r24, r25)
        L_0x0081:
            r23.updatePostMeasures()
            int r15 = r23.getChildCount()
            if (r15 <= 0) goto L_0x0091
            if (r13 == 0) goto L_0x0091
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.Analyzer.determineGroups(r13)
        L_0x0091:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            boolean r13 = r13.mGroupsWrapOptimized
            if (r13 == 0) goto L_0x00d1
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            boolean r13 = r13.mHorizontalWrapOptimized
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r13 == 0) goto L_0x00b5
            if (r3 != r15) goto L_0x00b5
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r13 = r13.mWrapFixedWidth
            if (r13 >= r4) goto L_0x00ae
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r12 = r13.mWrapFixedWidth
            r13.setWidth(r12)
        L_0x00ae:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r12.setHorizontalDimensionBehaviour(r13)
        L_0x00b5:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            boolean r12 = r12.mVerticalWrapOptimized
            if (r12 == 0) goto L_0x00d1
            if (r5 != r15) goto L_0x00d1
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            int r12 = r12.mWrapFixedHeight
            if (r12 >= r6) goto L_0x00ca
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            int r13 = r12.mWrapFixedHeight
            r12.setHeight(r13)
        L_0x00ca:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r12.setVerticalDimensionBehaviour(r13)
        L_0x00d1:
            int r12 = r0.mOptimizationLevel
            r13 = 32
            r12 = r12 & r13
            r15 = 1073741824(0x40000000, float:2.0)
            if (r12 != r13) goto L_0x012d
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            int r12 = r12.getWidth()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r13 = r13.getHeight()
            int r11 = r0.mLastMeasureWidth
            if (r11 == r12) goto L_0x00f4
            if (r3 != r15) goto L_0x00f4
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r11 = 0
            androidx.constraintlayout.solver.widgets.Analyzer.setPosition(r3, r11, r12)
        L_0x00f4:
            int r3 = r0.mLastMeasureHeight
            if (r3 == r13) goto L_0x0102
            if (r5 != r15) goto L_0x0102
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r5 = 1
            androidx.constraintlayout.solver.widgets.Analyzer.setPosition(r3, r5, r13)
        L_0x0102:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.mHorizontalWrapOptimized
            if (r3 == 0) goto L_0x0117
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            int r3 = r3.mWrapFixedWidth
            if (r3 <= r4) goto L_0x0117
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r11 = 0
            androidx.constraintlayout.solver.widgets.Analyzer.setPosition(r3, r11, r4)
            goto L_0x0118
        L_0x0117:
            r11 = 0
        L_0x0118:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.mVerticalWrapOptimized
            if (r3 == 0) goto L_0x012d
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            int r3 = r3.mWrapFixedHeight
            if (r3 <= r6) goto L_0x012d
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r4 = 1
            androidx.constraintlayout.solver.widgets.Analyzer.setPosition(r3, r4, r6)
            goto L_0x012e
        L_0x012d:
            r4 = 1
        L_0x012e:
            int r3 = r23.getChildCount()
            if (r3 <= 0) goto L_0x0139
            java.lang.String r3 = "First pass"
            r0.solveLinearSystem(r3)
        L_0x0139:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r3 = r0.mVariableDimensionsWidgets
            int r3 = r3.size()
            int r5 = r23.getPaddingBottom()
            int r8 = r8 + r5
            int r5 = r23.getPaddingRight()
            int r7 = r7 + r5
            if (r3 <= 0) goto L_0x0378
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r5 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = r5.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r6) goto L_0x0157
            r5 = r4
            goto L_0x0158
        L_0x0157:
            r5 = r11
        L_0x0158:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r6 = r0.mLayoutWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r6.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r6 != r12) goto L_0x0164
            r6 = r4
            goto L_0x0165
        L_0x0164:
            r6 = r11
        L_0x0165:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            int r12 = r12.getWidth()
            int r13 = r0.mMinWidth
            int r12 = java.lang.Math.max(r12, r13)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r13 = r13.getHeight()
            int r4 = r0.mMinHeight
            int r4 = java.lang.Math.max(r13, r4)
            r13 = r11
            r16 = r12
            r12 = r13
        L_0x0181:
            r17 = 1
            if (r12 >= r3) goto L_0x02d2
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r15 = r0.mVariableDimensionsWidgets
            java.lang.Object r15 = r15.get(r12)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            java.lang.Object r19 = r15.getCompanionWidget()
            r20 = r3
            r3 = r19
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L_0x019f
            r19 = r9
            r21 = r10
            goto L_0x02b4
        L_0x019f:
            android.view.ViewGroup$LayoutParams r19 = r3.getLayoutParams()
            r21 = r10
            r10 = r19
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r10
            r19 = r9
            boolean r9 = r10.isHelper
            if (r9 != 0) goto L_0x02b4
            boolean r9 = r10.isGuideline
            if (r9 == 0) goto L_0x01b5
            goto L_0x02b4
        L_0x01b5:
            int r9 = r3.getVisibility()
            r22 = r13
            r13 = 8
            if (r9 != r13) goto L_0x01c6
        L_0x01bf:
            r13 = r8
            r9 = r16
            r16 = r5
            goto L_0x02bb
        L_0x01c6:
            if (r14 == 0) goto L_0x01dd
            androidx.constraintlayout.solver.widgets.ResolutionDimension r9 = r15.getResolutionWidth()
            boolean r9 = r9.isResolved()
            if (r9 == 0) goto L_0x01dd
            androidx.constraintlayout.solver.widgets.ResolutionDimension r9 = r15.getResolutionHeight()
            boolean r9 = r9.isResolved()
            if (r9 == 0) goto L_0x01dd
            goto L_0x01bf
        L_0x01dd:
            int r9 = r10.width
            r13 = -2
            if (r9 != r13) goto L_0x01ed
            boolean r9 = r10.horizontalDimensionFixed
            if (r9 == 0) goto L_0x01ed
            int r9 = r10.width
            int r9 = getChildMeasureSpec(r1, r7, r9)
            goto L_0x01f7
        L_0x01ed:
            int r9 = r15.getWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
        L_0x01f7:
            int r13 = r10.height
            r1 = -2
            if (r13 != r1) goto L_0x0207
            boolean r1 = r10.verticalDimensionFixed
            if (r1 == 0) goto L_0x0207
            int r1 = r10.height
            int r1 = getChildMeasureSpec(r2, r8, r1)
            goto L_0x0211
        L_0x0207:
            int r1 = r15.getHeight()
            r13 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r13)
        L_0x0211:
            r3.measure(r9, r1)
            androidx.constraintlayout.solver.Metrics r1 = r0.mMetrics
            r13 = r8
            if (r1 == 0) goto L_0x021f
            long r8 = r1.additionalMeasures
            long r8 = r8 + r17
            r1.additionalMeasures = r8
        L_0x021f:
            int r1 = r3.getMeasuredWidth()
            int r8 = r3.getMeasuredHeight()
            int r9 = r15.getWidth()
            if (r1 == r9) goto L_0x0260
            r15.setWidth(r1)
            if (r14 == 0) goto L_0x0239
            androidx.constraintlayout.solver.widgets.ResolutionDimension r9 = r15.getResolutionWidth()
            r9.resolve(r1)
        L_0x0239:
            if (r5 == 0) goto L_0x0259
            int r1 = r15.getRight()
            r9 = r16
            if (r1 <= r9) goto L_0x025b
            int r1 = r15.getRight()
            r16 = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r15.getAnchor(r5)
            int r5 = r5.getMargin()
            int r1 = r1 + r5
            int r1 = java.lang.Math.max(r9, r1)
            goto L_0x025e
        L_0x0259:
            r9 = r16
        L_0x025b:
            r16 = r5
            r1 = r9
        L_0x025e:
            r5 = 1
            goto L_0x0267
        L_0x0260:
            r9 = r16
            r16 = r5
            r1 = r9
            r5 = r22
        L_0x0267:
            int r9 = r15.getHeight()
            if (r8 == r9) goto L_0x0295
            r15.setHeight(r8)
            if (r14 == 0) goto L_0x0279
            androidx.constraintlayout.solver.widgets.ResolutionDimension r5 = r15.getResolutionHeight()
            r5.resolve(r8)
        L_0x0279:
            if (r6 == 0) goto L_0x0294
            int r5 = r15.getBottom()
            if (r5 <= r4) goto L_0x0294
            int r5 = r15.getBottom()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r15.getAnchor(r8)
            int r8 = r8.getMargin()
            int r5 = r5 + r8
            int r4 = java.lang.Math.max(r4, r5)
        L_0x0294:
            r5 = 1
        L_0x0295:
            boolean r8 = r10.needsBaseline
            if (r8 == 0) goto L_0x02aa
            int r8 = r3.getBaseline()
            r9 = -1
            if (r8 == r9) goto L_0x02aa
            int r9 = r15.getBaselineDistance()
            if (r8 == r9) goto L_0x02aa
            r15.setBaselineDistance(r8)
            r5 = 1
        L_0x02aa:
            int r3 = r3.getMeasuredState()
            int r3 = combineMeasuredStates(r11, r3)
            r11 = r3
            goto L_0x02be
        L_0x02b4:
            r22 = r13
            r9 = r16
            r16 = r5
            r13 = r8
        L_0x02bb:
            r1 = r9
            r5 = r22
        L_0x02be:
            int r12 = r12 + 1
            r8 = r13
            r9 = r19
            r3 = r20
            r10 = r21
            r15 = 1073741824(0x40000000, float:2.0)
            r13 = r5
            r5 = r16
            r16 = r1
            r1 = r24
            goto L_0x0181
        L_0x02d2:
            r20 = r3
            r19 = r9
            r21 = r10
            r22 = r13
            r9 = r16
            r13 = r8
            if (r22 == 0) goto L_0x0320
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r3 = r19
            r1.setWidth(r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r3 = r21
            r1.setHeight(r3)
            if (r14 == 0) goto L_0x02f4
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r1.solveGraph()
        L_0x02f4:
            java.lang.String r1 = "2nd pass"
            r0.solveLinearSystem(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            int r1 = r1.getWidth()
            if (r1 >= r9) goto L_0x0308
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r1.setWidth(r9)
            r1 = 1
            goto L_0x0309
        L_0x0308:
            r1 = 0
        L_0x0309:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            int r3 = r3.getHeight()
            if (r3 >= r4) goto L_0x0318
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r1.setHeight(r4)
            r12 = 1
            goto L_0x0319
        L_0x0318:
            r12 = r1
        L_0x0319:
            if (r12 == 0) goto L_0x0320
            java.lang.String r1 = "3rd pass"
            r0.solveLinearSystem(r1)
        L_0x0320:
            r3 = r20
            r1 = 0
        L_0x0323:
            if (r1 >= r3) goto L_0x037a
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r4 = r0.mVariableDimensionsWidgets
            java.lang.Object r4 = r4.get(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r4
            java.lang.Object r5 = r4.getCompanionWidget()
            android.view.View r5 = (android.view.View) r5
            if (r5 != 0) goto L_0x033a
        L_0x0335:
            r8 = 8
        L_0x0337:
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x0375
        L_0x033a:
            int r6 = r5.getMeasuredWidth()
            int r8 = r4.getWidth()
            if (r6 != r8) goto L_0x034e
            int r6 = r5.getMeasuredHeight()
            int r8 = r4.getHeight()
            if (r6 == r8) goto L_0x0335
        L_0x034e:
            int r6 = r4.getVisibility()
            r8 = 8
            if (r6 == r8) goto L_0x0337
            int r6 = r4.getWidth()
            r9 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
            int r4 = r4.getHeight()
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r9)
            r5.measure(r6, r4)
            androidx.constraintlayout.solver.Metrics r4 = r0.mMetrics
            if (r4 == 0) goto L_0x0375
            long r5 = r4.additionalMeasures
            long r5 = r5 + r17
            r4.additionalMeasures = r5
        L_0x0375:
            int r1 = r1 + 1
            goto L_0x0323
        L_0x0378:
            r13 = r8
            r11 = 0
        L_0x037a:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            int r1 = r1.getWidth()
            int r1 = r1 + r7
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            int r3 = r3.getHeight()
            int r3 = r3 + r13
            r4 = r24
            int r1 = resolveSizeAndState(r1, r4, r11)
            int r4 = r11 << 16
            int r2 = resolveSizeAndState(r3, r2, r4)
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r3
            r2 = r2 & r3
            int r3 = r0.mMaxWidth
            int r1 = java.lang.Math.min(r3, r1)
            int r3 = r0.mMaxHeight
            int r2 = java.lang.Math.min(r3, r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.isWidthMeasuredTooSmall()
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            if (r3 == 0) goto L_0x03b0
            r1 = r1 | r4
        L_0x03b0:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.isHeightMeasuredTooSmall()
            if (r3 == 0) goto L_0x03b9
            r2 = r2 | r4
        L_0x03b9:
            r0.setMeasuredDimension(r1, r2)
            r0.mLastMeasureWidth = r1
            r0.mLastMeasureHeight = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    private void setSelfDimensionBehaviour(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                size = Math.min(this.mMaxWidth, size) - paddingLeft;
            }
            size = 0;
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.mMaxHeight, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        this.mLayoutWidget.setMinWidth(0);
        this.mLayoutWidget.setMinHeight(0);
        this.mLayoutWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.mLayoutWidget.setWidth(size);
        this.mLayoutWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
        this.mLayoutWidget.setHeight(size2);
        this.mLayoutWidget.setMinWidth((this.mMinWidth - getPaddingLeft()) - getPaddingRight());
        this.mLayoutWidget.setMinHeight((this.mMinHeight - getPaddingTop()) - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void solveLinearSystem(String str) {
        this.mLayoutWidget.layout();
        Metrics metrics = this.mMetrics;
        if (metrics != null) {
            metrics.resolutions++;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || isInEditMode) && !layoutParams.isInPlaceholder) {
                int drawX = constraintWidget.getDrawX();
                int drawY = constraintWidget.getDrawY();
                int width = constraintWidget.getWidth() + drawX;
                int height = constraintWidget.getHeight() + drawY;
                childAt.layout(drawX, drawY, width, height);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(drawX, drawY, width, height);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).updatePostLayout(this);
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.mLayoutWidget.setOptimizationLevel(i);
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i2 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i3 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(SupportMenu.CATEGORY_MASK);
                        float f = (float) i2;
                        float f2 = (float) i3;
                        float f3 = (float) (i2 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f4 = f2;
                        float f5 = f2;
                        float f6 = f3;
                        float f7 = f;
                        Paint paint2 = paint;
                        canvas2.drawLine(f, f4, f6, f5, paint);
                        float parseInt4 = (float) (i3 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f8 = f3;
                        float f9 = parseInt4;
                        canvas2.drawLine(f8, f5, f6, f9, paint);
                        float f10 = parseInt4;
                        float f11 = f7;
                        canvas2.drawLine(f8, f10, f11, f9, paint);
                        float f12 = f7;
                        canvas2.drawLine(f12, f10, f11, f5, paint);
                        paint.setColor(-16711936);
                        float f13 = f3;
                        Paint paint3 = paint;
                        canvas2.drawLine(f12, f5, f13, parseInt4, paint);
                        canvas2.drawLine(f12, parseInt4, f13, f5, paint);
                    }
                }
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String dimensionRatio = null;
        int dimensionRatioSide = 1;
        float dimensionRatioValue = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneLeftMargin = -1;
        public int goneRightMargin = -1;
        public int goneStartMargin = -1;
        public int goneTopMargin = -1;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean helped = false;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        boolean horizontalDimensionFixed = true;
        public float horizontalWeight = -1.0f;
        boolean isGuideline = false;
        boolean isHelper = false;
        boolean isInPlaceholder = false;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int matchConstraintDefaultHeight = 0;
        public int matchConstraintDefaultWidth = 0;
        public int matchConstraintMaxHeight = 0;
        public int matchConstraintMaxWidth = 0;
        public int matchConstraintMinHeight = 0;
        public int matchConstraintMinWidth = 0;
        public float matchConstraintPercentHeight = 1.0f;
        public float matchConstraintPercentWidth = 1.0f;
        boolean needsBaseline = false;
        public int orientation = -1;
        int resolveGoneLeftMargin = -1;
        int resolveGoneRightMargin = -1;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias = 0.5f;
        int resolvedLeftToLeft = -1;
        int resolvedLeftToRight = -1;
        int resolvedRightToLeft = -1;
        int resolvedRightToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        boolean verticalDimensionFixed = true;
        public float verticalWeight = -1.0f;
        ConstraintWidget widget = new ConstraintWidget();

        public void reset() {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget != null) {
                constraintWidget.reset();
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.widget = layoutParams.widget;
        }

        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map;

            private Table() {
            }

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = Table.map.get(index);
                switch (i3) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f;
                        if (f >= 0.0f) {
                            break;
                        } else {
                            this.circleAngle = (360.0f - f) % 360.0f;
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 != -1) {
                            break;
                        } else {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 != -1) {
                            break;
                        } else {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 != -1) {
                            break;
                        } else {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 != -1) {
                            break;
                        } else {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 != -1) {
                            break;
                        } else {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 != -1) {
                            break;
                        } else {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 != -1) {
                            break;
                        } else {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 != -1) {
                            break;
                        } else {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 != -1) {
                            break;
                        } else {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 != -1) {
                            break;
                        } else {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /*29*/:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        int i4 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultWidth = i4;
                        if (i4 != 1) {
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        int i5 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultHeight = i5;
                        if (i5 != 1) {
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) != -2) {
                                break;
                            } else {
                                this.matchConstraintMinWidth = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) != -2) {
                                break;
                            } else {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            }
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) != -2) {
                                break;
                            } else {
                                this.matchConstraintMinHeight = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) != -2) {
                                break;
                            } else {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            }
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.dimensionRatio = string;
                                this.dimensionRatioValue = Float.NaN;
                                this.dimensionRatioSide = -1;
                                if (string == null) {
                                    break;
                                } else {
                                    int length = string.length();
                                    int indexOf = this.dimensionRatio.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String substring = this.dimensionRatio.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.dimensionRatioSide = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.dimensionRatioSide = 1;
                                        }
                                        i = indexOf + 1;
                                    }
                                    int indexOf2 = this.dimensionRatio.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.dimensionRatio.substring(i, indexOf2);
                                        String substring3 = this.dimensionRatio.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.dimensionRatioSide != 1) {
                                                        this.dimensionRatioValue = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    } else {
                                                        this.dimensionRatioValue = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.dimensionRatio.substring(i);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            this.dimensionRatioValue = Float.parseFloat(substring4);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                break;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                break;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /*48*/:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case Table.LAYOUT_EDITOR_ABSOLUTEX /*49*/:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                break;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                this.matchConstraintDefaultWidth = 1;
            }
            if (this.height == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                this.matchConstraintDefaultHeight = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.horizontalDimensionFixed = false;
                if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.verticalDimensionFixed = false;
                if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof Guideline)) {
                    this.widget = new Guideline();
                }
                ((Guideline) this.widget).setOrientation(this.orientation);
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r7) {
            /*
                r6 = this;
                int r0 = r6.leftMargin
                int r1 = r6.rightMargin
                super.resolveLayoutDirection(r7)
                r7 = -1
                r6.resolvedRightToLeft = r7
                r6.resolvedRightToRight = r7
                r6.resolvedLeftToLeft = r7
                r6.resolvedLeftToRight = r7
                int r2 = r6.goneLeftMargin
                r6.resolveGoneLeftMargin = r2
                int r2 = r6.goneRightMargin
                r6.resolveGoneRightMargin = r2
                float r2 = r6.horizontalBias
                r6.resolvedHorizontalBias = r2
                int r2 = r6.guideBegin
                r6.resolvedGuideBegin = r2
                int r2 = r6.guideEnd
                r6.resolvedGuideEnd = r2
                float r2 = r6.guidePercent
                r6.resolvedGuidePercent = r2
                int r2 = r6.getLayoutDirection()
                r3 = 1
                if (r3 != r2) goto L_0x0091
                int r2 = r6.startToEnd
                if (r2 == r7) goto L_0x0037
                r6.resolvedRightToLeft = r2
            L_0x0035:
                r2 = r3
                goto L_0x003f
            L_0x0037:
                int r2 = r6.startToStart
                if (r2 == r7) goto L_0x003e
                r6.resolvedRightToRight = r2
                goto L_0x0035
            L_0x003e:
                r2 = 0
            L_0x003f:
                int r4 = r6.endToStart
                if (r4 == r7) goto L_0x0046
                r6.resolvedLeftToRight = r4
                r2 = r3
            L_0x0046:
                int r4 = r6.endToEnd
                if (r4 == r7) goto L_0x004d
                r6.resolvedLeftToLeft = r4
                r2 = r3
            L_0x004d:
                int r4 = r6.goneStartMargin
                if (r4 == r7) goto L_0x0053
                r6.resolveGoneRightMargin = r4
            L_0x0053:
                int r4 = r6.goneEndMargin
                if (r4 == r7) goto L_0x0059
                r6.resolveGoneLeftMargin = r4
            L_0x0059:
                r4 = 1065353216(0x3f800000, float:1.0)
                if (r2 == 0) goto L_0x0063
                float r2 = r6.horizontalBias
                float r2 = r4 - r2
                r6.resolvedHorizontalBias = r2
            L_0x0063:
                boolean r2 = r6.isGuideline
                if (r2 == 0) goto L_0x00b5
                int r2 = r6.orientation
                if (r2 != r3) goto L_0x00b5
                float r2 = r6.guidePercent
                r3 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r5 == 0) goto L_0x007b
                float r4 = r4 - r2
                r6.resolvedGuidePercent = r4
                r6.resolvedGuideBegin = r7
                r6.resolvedGuideEnd = r7
                goto L_0x00b5
            L_0x007b:
                int r2 = r6.guideBegin
                if (r2 == r7) goto L_0x0086
                r6.resolvedGuideEnd = r2
                r6.resolvedGuideBegin = r7
                r6.resolvedGuidePercent = r3
                goto L_0x00b5
            L_0x0086:
                int r2 = r6.guideEnd
                if (r2 == r7) goto L_0x00b5
                r6.resolvedGuideBegin = r2
                r6.resolvedGuideEnd = r7
                r6.resolvedGuidePercent = r3
                goto L_0x00b5
            L_0x0091:
                int r2 = r6.startToEnd
                if (r2 == r7) goto L_0x0097
                r6.resolvedLeftToRight = r2
            L_0x0097:
                int r2 = r6.startToStart
                if (r2 == r7) goto L_0x009d
                r6.resolvedLeftToLeft = r2
            L_0x009d:
                int r2 = r6.endToStart
                if (r2 == r7) goto L_0x00a3
                r6.resolvedRightToLeft = r2
            L_0x00a3:
                int r2 = r6.endToEnd
                if (r2 == r7) goto L_0x00a9
                r6.resolvedRightToRight = r2
            L_0x00a9:
                int r2 = r6.goneStartMargin
                if (r2 == r7) goto L_0x00af
                r6.resolveGoneLeftMargin = r2
            L_0x00af:
                int r2 = r6.goneEndMargin
                if (r2 == r7) goto L_0x00b5
                r6.resolveGoneRightMargin = r2
            L_0x00b5:
                int r2 = r6.endToStart
                if (r2 != r7) goto L_0x00ff
                int r2 = r6.endToEnd
                if (r2 != r7) goto L_0x00ff
                int r2 = r6.startToStart
                if (r2 != r7) goto L_0x00ff
                int r2 = r6.startToEnd
                if (r2 != r7) goto L_0x00ff
                int r2 = r6.rightToLeft
                if (r2 == r7) goto L_0x00d4
                r6.resolvedRightToLeft = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00e2
                if (r1 <= 0) goto L_0x00e2
                r6.rightMargin = r1
                goto L_0x00e2
            L_0x00d4:
                int r2 = r6.rightToRight
                if (r2 == r7) goto L_0x00e2
                r6.resolvedRightToRight = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00e2
                if (r1 <= 0) goto L_0x00e2
                r6.rightMargin = r1
            L_0x00e2:
                int r1 = r6.leftToLeft
                if (r1 == r7) goto L_0x00f1
                r6.resolvedLeftToLeft = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x00ff
                if (r0 <= 0) goto L_0x00ff
                r6.leftMargin = r0
                goto L_0x00ff
            L_0x00f1:
                int r1 = r6.leftToRight
                if (r1 == r7) goto L_0x00ff
                r6.resolvedLeftToRight = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x00ff
                if (r0 <= 0) goto L_0x00ff
                r6.leftMargin = r0
            L_0x00ff:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }
}
