package jp.co.sony.reonpocket.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.sony.reonpocket.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !BS\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00126\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0002\u0010\u000fJ\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016R>\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ljp/co/sony/reonpocket/view/adapter/TimerSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "aDurationDataList", "", "", "aLastSelectedPosition", "", "aItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "aPosition", "aName", "", "([Ljava/lang/String;ILkotlin/jvm/functions/Function2;)V", "mDurationDataList", "[Ljava/lang/String;", "mLastClickTime", "", "mLastSelectedPosition", "getItemCount", "handleClickEvent", "isPassedEnoughTime", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "DurationViewHolder", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimerSelectAdapter.kt */
public final class TimerSelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    private static final int CLICK_DELAY = 200;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Function2<Integer, String, Unit> aItemClickListener;
    private String[] mDurationDataList;
    private long mLastClickTime;
    private int mLastSelectedPosition;

    public TimerSelectAdapter(String[] strArr, int i, Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(strArr, "aDurationDataList");
        Intrinsics.checkNotNullParameter(function2, "aItemClickListener");
        this.aItemClickListener = function2;
        this.mDurationDataList = strArr;
        this.mLastSelectedPosition = i;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/view/adapter/TimerSelectAdapter$Companion;", "", "()V", "CLICK_DELAY", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TimerSelectAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        DurationViewHolder.Companion companion = DurationViewHolder.Companion;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        return companion.create(from, viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        DurationViewHolder durationViewHolder = (DurationViewHolder) viewHolder;
        durationViewHolder.getMDuration().setText(this.mDurationDataList[i]);
        durationViewHolder.getMRadioButton().setChecked(this.mLastSelectedPosition == i);
        durationViewHolder.getMRadioButton().setOnClickListener(new TimerSelectAdapter$$ExternalSyntheticLambda0(this, i));
        durationViewHolder.itemView.setOnClickListener(new TimerSelectAdapter$$ExternalSyntheticLambda1(this, i));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(TimerSelectAdapter timerSelectAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(timerSelectAdapter, "this$0");
        timerSelectAdapter.handleClickEvent(i);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(TimerSelectAdapter timerSelectAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(timerSelectAdapter, "this$0");
        timerSelectAdapter.handleClickEvent(i);
    }

    public int getItemCount() {
        return this.mDurationDataList.length;
    }

    private final boolean isPassedEnoughTime() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - this.mLastClickTime >= 200;
        this.mLastClickTime = currentTimeMillis;
        return z;
    }

    private final void handleClickEvent(int i) {
        if (isPassedEnoughTime()) {
            this.mLastSelectedPosition = i;
            this.aItemClickListener.invoke(Integer.valueOf(i), this.mDurationDataList[this.mLastSelectedPosition]);
            notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/view/adapter/TimerSelectAdapter$DurationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "aView", "Landroid/view/View;", "(Landroid/view/View;)V", "mDuration", "Landroid/widget/TextView;", "getMDuration", "()Landroid/widget/TextView;", "setMDuration", "(Landroid/widget/TextView;)V", "mRadioButton", "Landroid/widget/RadioButton;", "getMRadioButton", "()Landroid/widget/RadioButton;", "setMRadioButton", "(Landroid/widget/RadioButton;)V", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TimerSelectAdapter.kt */
    public static final class DurationViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int LAYOUT_ID = R.layout.item_view_duration;
        private TextView mDuration;
        private RadioButton mRadioButton;

        @JvmStatic
        public static final RecyclerView.ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            return Companion.create(layoutInflater, viewGroup);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DurationViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "aView");
            View findViewById = view.findViewById(R.id.duration);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.mDuration = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.radioButton);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.mRadioButton = (RadioButton) findViewById2;
        }

        public final TextView getMDuration() {
            return this.mDuration;
        }

        public final void setMDuration(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mDuration = textView;
        }

        public final RadioButton getMRadioButton() {
            return this.mRadioButton;
        }

        public final void setMRadioButton(RadioButton radioButton) {
            Intrinsics.checkNotNullParameter(radioButton, "<set-?>");
            this.mRadioButton = radioButton;
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/view/adapter/TimerSelectAdapter$DurationViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "create", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: TimerSelectAdapter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final RecyclerView.ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = layoutInflater.inflate(DurationViewHolder.LAYOUT_ID, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new DurationViewHolder(inflate);
            }
        }
    }
}
