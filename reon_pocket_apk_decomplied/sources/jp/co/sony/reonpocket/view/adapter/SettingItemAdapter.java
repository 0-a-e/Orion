package jp.co.sony.reonpocket.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001a\u001b\u001c\u001dB6\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001e"}, d2 = {"Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "aSettingItems", "", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "aItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "item", "", "([Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;Lkotlin/jvm/functions/Function1;)V", "mItemList", "[Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "getItemCount", "", "handleClickEvent", "aPosition", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "SettingItem", "SettingItemViewHolder", "SettingListItem", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingItemAdapter.kt */
public final class SettingItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Function1<SettingListItem, Unit> aItemClickListener;
    private SettingListItem[] mItemList;

    public SettingItemAdapter(SettingListItem[] settingListItemArr, Function1<? super SettingListItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(settingListItemArr, "aSettingItems");
        Intrinsics.checkNotNullParameter(function1, "aItemClickListener");
        this.aItemClickListener = function1;
        this.mItemList = settingListItemArr;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        SettingItemViewHolder.Companion companion = SettingItemViewHolder.Companion;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        return companion.create(from, viewGroup);
    }

    public int getItemCount() {
        return this.mItemList.length;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        SettingItemViewHolder settingItemViewHolder = (SettingItemViewHolder) viewHolder;
        settingItemViewHolder.getMTitle().setText(this.mItemList[i].getTitle());
        CharSequence subtitle = this.mItemList[i].getSubtitle();
        int i2 = 8;
        if (subtitle == null || subtitle.length() == 0) {
            settingItemViewHolder.getMSubtitle().setVisibility(8);
        } else {
            settingItemViewHolder.getMSubtitle().setVisibility(0);
            settingItemViewHolder.getMSubtitle().setText(this.mItemList[i].getSubtitle());
        }
        if (Intrinsics.areEqual((Object) Locale.getDefault().getLanguage(), (Object) ArchiveStreamFactory.AR)) {
            settingItemViewHolder.getMRightIcon().setImageResource(R.drawable.ic_right_arrow_ar);
            settingItemViewHolder.getMRightIcon().setScaleType(ImageView.ScaleType.FIT_START);
        }
        ImageView mRightIcon = settingItemViewHolder.getMRightIcon();
        if (this.mItemList[i].isShowArrow()) {
            i2 = 0;
        }
        mRightIcon.setVisibility(i2);
        settingItemViewHolder.itemView.setOnClickListener(new SettingItemAdapter$$ExternalSyntheticLambda0(this, i));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(SettingItemAdapter settingItemAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(settingItemAdapter, "this$0");
        settingItemAdapter.handleClickEvent(i);
    }

    private final void handleClickEvent(int i) {
        this.aItemClickListener.invoke(this.mItemList[i]);
        notifyDataSetChanged();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0015"}, d2 = {"Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "aView", "Landroid/view/View;", "(Landroid/view/View;)V", "mRightIcon", "Landroid/widget/ImageView;", "getMRightIcon", "()Landroid/widget/ImageView;", "setMRightIcon", "(Landroid/widget/ImageView;)V", "mSubtitle", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "getMSubtitle", "()Ljp/co/sony/reonpocket/view/CustomFontTextView;", "setMSubtitle", "(Ljp/co/sony/reonpocket/view/CustomFontTextView;)V", "mTitle", "getMTitle", "setMTitle", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingItemAdapter.kt */
    public static final class SettingItemViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int LAYOUT_ID = R.layout.view_preference_setting_list_item;
        private ImageView mRightIcon;
        private CustomFontTextView mSubtitle;
        private CustomFontTextView mTitle;

        @JvmStatic
        public static final RecyclerView.ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            return Companion.create(layoutInflater, viewGroup);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettingItemViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "aView");
            View findViewById = view.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.mTitle = (CustomFontTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.summary);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.mSubtitle = (CustomFontTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.right_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.mRightIcon = (ImageView) findViewById3;
        }

        public final CustomFontTextView getMTitle() {
            return this.mTitle;
        }

        public final void setMTitle(CustomFontTextView customFontTextView) {
            Intrinsics.checkNotNullParameter(customFontTextView, "<set-?>");
            this.mTitle = customFontTextView;
        }

        public final CustomFontTextView getMSubtitle() {
            return this.mSubtitle;
        }

        public final void setMSubtitle(CustomFontTextView customFontTextView) {
            Intrinsics.checkNotNullParameter(customFontTextView, "<set-?>");
            this.mSubtitle = customFontTextView;
        }

        public final ImageView getMRightIcon() {
            return this.mRightIcon;
        }

        public final void setMRightIcon(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mRightIcon = imageView;
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "create", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: SettingItemAdapter.kt */
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
                View inflate = layoutInflater.inflate(SettingItemViewHolder.LAYOUT_ID, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new SettingItemViewHolder(inflate);
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "", "type", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingItem;", "title", "", "subtitle", "view", "Ljava/lang/Class;", "isShowArrow", "", "(Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Z)V", "()Z", "getSubtitle", "()Ljava/lang/String;", "getTitle", "getType", "()Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingItem;", "getView", "()Ljava/lang/Class;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingItemAdapter.kt */
    public static final class SettingListItem {
        public static final int $stable = 8;
        private final boolean isShowArrow;
        private final String subtitle;
        private final String title;
        private final SettingItem type;
        private final Class<?> view;

        public SettingListItem(SettingItem settingItem, String str, String str2, Class<?> cls, boolean z) {
            Intrinsics.checkNotNullParameter(settingItem, TransferTable.COLUMN_TYPE);
            Intrinsics.checkNotNullParameter(str, "title");
            this.type = settingItem;
            this.title = str;
            this.subtitle = str2;
            this.view = cls;
            this.isShowArrow = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SettingListItem(SettingItem settingItem, String str, String str2, Class cls, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(settingItem, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : cls, (i & 16) != 0 ? false : z);
        }

        public final SettingItem getType() {
            return this.type;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final Class<?> getView() {
            return this.view;
        }

        public final boolean isShowArrow() {
            return this.isShowArrow;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0016\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingItem;", "", "(Ljava/lang/String;I)V", "AUTO_START", "QUICK_LAUNCH", "BATTERY_NOTIFICATIONS", "FEEDBACK", "UNREGISTER_DEVICE", "INITIALIZE_DEVICE", "TAG_REGISTER", "TAG_UNREGISTER", "MODEL", "SOFTWARE_VERSION", "TAG_MODEL", "TAG_SOFTWARE_VERSION", "APP_VERSION", "INFORMATION", "SUPPORT_PAGE", "LEGAL", "USER_INFO", "LICENSE", "PRIVACY_POLICY", "OPEN_SOURCE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingItemAdapter.kt */
    public enum SettingItem {
        AUTO_START,
        QUICK_LAUNCH,
        BATTERY_NOTIFICATIONS,
        FEEDBACK,
        UNREGISTER_DEVICE,
        INITIALIZE_DEVICE,
        TAG_REGISTER,
        TAG_UNREGISTER,
        MODEL,
        SOFTWARE_VERSION,
        TAG_MODEL,
        TAG_SOFTWARE_VERSION,
        APP_VERSION,
        INFORMATION,
        SUPPORT_PAGE,
        LEGAL,
        USER_INFO,
        LICENSE,
        PRIVACY_POLICY,
        OPEN_SOURCE;

        public static EnumEntries<SettingItem> getEntries() {
            return $ENTRIES;
        }

        static {
            SettingItem[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$Companion;", "", "()V", "getMenuPopupList", "", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "aActivity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)[Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingItemAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
            r1 = r1.getPackageInfo(r36.getPackageName(), 0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingListItem[] getMenuPopupList(androidx.fragment.app.FragmentActivity r36) {
            /*
                r35 = this;
                r0 = r36
                java.lang.String r1 = "aActivity"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                android.content.pm.PackageManager r1 = r36.getPackageManager()
                r2 = 0
                r3 = 0
                if (r1 == 0) goto L_0x001d
                java.lang.String r4 = r36.getPackageName()
                android.content.pm.PackageInfo r1 = r1.getPackageInfo(r4, r2)
                if (r1 == 0) goto L_0x001d
                java.lang.String r1 = r1.versionName
                r7 = r1
                goto L_0x001e
            L_0x001d:
                r7 = r3
            L_0x001e:
                jp.co.sony.reonpocket.data.interactor.TagInfoInteractor r1 = new jp.co.sony.reonpocket.data.interactor.TagInfoInteractor
                r1.<init>()
                r12 = r0
                android.content.Context r12 = (android.content.Context) r12
                java.lang.String r4 = r1.getTagBDAddress(r12)
                if (r4 == 0) goto L_0x0039
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                int r4 = r4.length()
                if (r4 <= 0) goto L_0x0036
                r4 = 1
                goto L_0x0037
            L_0x0036:
                r4 = r2
            L_0x0037:
                r13 = r4
                goto L_0x003a
            L_0x0039:
                r13 = r2
            L_0x003a:
                r4 = r1
                jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput r4 = (jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput) r4
                r5 = 2
                boolean r14 = jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput.DefaultImpls.isTagAvailableInThisCountry$default(r4, r12, r3, r5, r3)
                jp.co.sony.reonpocket.data.entity.tag.TagDataEntity r4 = r1.getTagInfo(r12)
                java.lang.String r1 = r1.getTagModel(r12)
                if (r1 != 0) goto L_0x004e
                java.lang.String r1 = ""
            L_0x004e:
                r18 = r1
                if (r4 == 0) goto L_0x0059
                int r1 = r4.getFwVersionCode()
                java.lang.Integer.valueOf(r1)
            L_0x0059:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.List r1 = (java.util.List) r1
                jp.co.sony.reonpocket.util.RemoteConfigUtil r4 = jp.co.sony.reonpocket.util.RemoteConfigUtil.INSTANCE
                java.lang.String r4 = r4.getMFeedBackUrl()
                java.lang.String r15 = "getString(...)"
                if (r4 == 0) goto L_0x0093
                jp.co.sony.reonpocket.util.MyContentUtil r4 = jp.co.sony.reonpocket.util.MyContentUtil.INSTANCE
                boolean r3 = jp.co.sony.reonpocket.util.MyContentUtil.isSupportFeedback$default(r4, r12, r3, r5, r3)
                if (r3 == 0) goto L_0x0093
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r20 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.FEEDBACK
                int r4 = jp.co.sony.reonpocket.R.string.setting_top_feedback
                java.lang.String r4 = r0.getString(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
                r25 = 12
                r26 = 0
                r22 = 0
                r23 = 0
                r24 = 1
                r19 = r3
                r21 = r4
                r19.<init>(r20, r21, r22, r23, r24, r25, r26)
                r1.add(r3)
            L_0x0093:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r5 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.APP_VERSION
                int r4 = jp.co.sony.reonpocket.R.string.setting_top_app_version
                java.lang.String r6 = r0.getString(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r15)
                r10 = 24
                r11 = 0
                r8 = 0
                r9 = 0
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)
                r1.add(r3)
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r20 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.INFORMATION
                int r4 = jp.co.sony.reonpocket.R.string.setting_top_notification
                java.lang.String r4 = r0.getString(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
                r25 = 12
                r26 = 0
                r22 = 0
                r23 = 0
                r24 = 1
                r19 = r3
                r21 = r4
                r19.<init>(r20, r21, r22, r23, r24, r25, r26)
                r1.add(r3)
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r28 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.SUPPORT_PAGE
                int r4 = jp.co.sony.reonpocket.R.string.setting_top_support
                java.lang.String r4 = r0.getString(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
                r33 = 12
                r34 = 0
                r30 = 0
                r31 = 0
                r32 = 1
                r27 = r3
                r29 = r4
                r27.<init>(r28, r29, r30, r31, r32, r33, r34)
                r1.add(r3)
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r20 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.LEGAL
                int r4 = jp.co.sony.reonpocket.R.string.setting_top_legal
                java.lang.String r4 = r0.getString(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
                r19 = r3
                r21 = r4
                r19.<init>(r20, r21, r22, r23, r24, r25, r26)
                r1.add(r3)
                jp.co.sony.reonpocket.util.MyContentUtil r3 = jp.co.sony.reonpocket.util.MyContentUtil.INSTANCE
                boolean r3 = r3.isValidUserInfo(r12)
                if (r3 == 0) goto L_0x0127
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r5 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.USER_INFO
                int r4 = jp.co.sony.reonpocket.R.string.user_info_title
                java.lang.String r6 = r0.getString(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r15)
                r10 = 12
                r11 = 0
                r7 = 0
                r8 = 0
                r9 = 1
                r4 = r3
                r4.<init>(r5, r6, r7, r8, r9, r10, r11)
                r1.add(r3)
            L_0x0127:
                if (r13 == 0) goto L_0x0183
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r20 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_UNREGISTER
                int r4 = jp.co.sony.reonpocket.R.string.setting_top_tag_unregist
                java.lang.String r4 = r0.getString(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
                r25 = 12
                r26 = 0
                r22 = 0
                r23 = 0
                r24 = 1
                r19 = r3
                r21 = r4
                r19.<init>(r20, r21, r22, r23, r24, r25, r26)
                r1.add(r3)
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r16 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_MODEL
                int r4 = jp.co.sony.reonpocket.R.string.setting_top_tag_model
                java.lang.String r4 = r0.getString(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
                r21 = 24
                r19 = 0
                r20 = 0
                r5 = r15
                r15 = r3
                r17 = r4
                r15.<init>(r16, r17, r18, r19, r20, r21, r22)
                r1.add(r3)
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r7 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_SOFTWARE_VERSION
                int r4 = jp.co.sony.reonpocket.R.string.setting_top_tag_fw_version
                java.lang.String r8 = r0.getString(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
                r12 = 24
                r13 = 0
                java.lang.String r9 = "1.3.0"
                r10 = 0
                r11 = 0
                r6 = r3
                r6.<init>(r7, r8, r9, r10, r11, r12, r13)
                r1.add(r3)
                goto L_0x01a6
            L_0x0183:
                r5 = r15
                if (r14 == 0) goto L_0x01a6
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem r3 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r15 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_REGISTER
                int r4 = jp.co.sony.reonpocket.R.string.setting_top_tag_regist
                java.lang.String r0 = r0.getString(r4)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
                r20 = 12
                r21 = 0
                r17 = 0
                r18 = 0
                r19 = 1
                r14 = r3
                r16 = r0
                r14.<init>(r15, r16, r17, r18, r19, r20, r21)
                r1.add(r3)
            L_0x01a6:
                java.util.Collection r1 = (java.util.Collection) r1
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem[] r0 = new jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingListItem[r2]
                java.lang.Object[] r0 = r1.toArray(r0)
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem[] r0 = (jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingListItem[]) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.Companion.getMenuPopupList(androidx.fragment.app.FragmentActivity):jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingListItem[]");
        }
    }
}
