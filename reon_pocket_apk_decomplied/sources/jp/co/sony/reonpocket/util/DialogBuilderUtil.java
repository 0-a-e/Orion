package jp.co.sony.reonpocket.util;

import androidx.compose.runtime.ComposerKt;
import androidx.fragment.app.FragmentActivity;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.entity.Capability1$$ExternalSyntheticBackport0;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import jp.co.sony.reonpocket.view.fragment.AlertDialogFragment;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ&\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0011J\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0011J&\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0015J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0011J \u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u0011J \u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u0011H\u0002J \u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ljp/co/sony/reonpocket/util/DialogBuilderUtil;", "", "()V", "tagDfuStartDescriptionFontSize", "", "showSettingMenuDialog", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment;", "aActivity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Ljp/co/sony/reonpocket/util/DialogSelectActionListener;", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "showTagFoundDialog", "aTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "aTagModelName", "", "Ljp/co/sony/reonpocket/util/DialogDoubleActionListener;", "showTagFwUpdateCompleteDialog", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment;", "showTagFwUpdateDialog", "Ljp/co/sony/reonpocket/util/DialogSingleActionListener;", "showTagFwUpdateProgressDialog", "aListener", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "showTagNotFoundDialog", "showTagRegisterDialog", "showTagRegisteredDialog", "showTagRegistrationFailedDialog", "showTagUnRegisterDialog", "tagDoubleButtonDialog", "tagDialogEntity", "Ljp/co/sony/reonpocket/util/DialogBuilderUtil$TagDialogEntity;", "tagSingleButtonDialog", "TagDialogEntity", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DialogBuilderUtil.kt */
public final class DialogBuilderUtil {
    public static final int $stable = 0;
    public static final DialogBuilderUtil INSTANCE = new DialogBuilderUtil();
    private static final float tagDfuStartDescriptionFontSize = 24.0f;

    private DialogBuilderUtil() {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010+\u001a\u00020\fHÆ\u0003Jh\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014¨\u00063"}, d2 = {"Ljp/co/sony/reonpocket/util/DialogBuilderUtil$TagDialogEntity;", "", "title", "", "message", "modelName", "serialNo", "positiveButtonText", "negativeButtonText", "messageFontSize", "", "isPositiveButtonDelayAppear", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Z)V", "()Z", "setPositiveButtonDelayAppear", "(Z)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getMessageFontSize", "()Ljava/lang/Float;", "setMessageFontSize", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getModelName", "setModelName", "getNegativeButtonText", "setNegativeButtonText", "getPositiveButtonText", "setPositiveButtonText", "getSerialNo", "setSerialNo", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Z)Ljp/co/sony/reonpocket/util/DialogBuilderUtil$TagDialogEntity;", "equals", "other", "hashCode", "", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DialogBuilderUtil.kt */
    public static final class TagDialogEntity {
        public static final int $stable = 8;
        private boolean isPositiveButtonDelayAppear;
        private String message;
        private Float messageFontSize;
        private String modelName;
        private String negativeButtonText;
        private String positiveButtonText;
        private String serialNo;
        private String title;

        public static /* synthetic */ TagDialogEntity copy$default(TagDialogEntity tagDialogEntity, String str, String str2, String str3, String str4, String str5, String str6, Float f, boolean z, int i, Object obj) {
            TagDialogEntity tagDialogEntity2 = tagDialogEntity;
            int i2 = i;
            return tagDialogEntity.copy((i2 & 1) != 0 ? tagDialogEntity2.title : str, (i2 & 2) != 0 ? tagDialogEntity2.message : str2, (i2 & 4) != 0 ? tagDialogEntity2.modelName : str3, (i2 & 8) != 0 ? tagDialogEntity2.serialNo : str4, (i2 & 16) != 0 ? tagDialogEntity2.positiveButtonText : str5, (i2 & 32) != 0 ? tagDialogEntity2.negativeButtonText : str6, (i2 & 64) != 0 ? tagDialogEntity2.messageFontSize : f, (i2 & 128) != 0 ? tagDialogEntity2.isPositiveButtonDelayAppear : z);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.message;
        }

        public final String component3() {
            return this.modelName;
        }

        public final String component4() {
            return this.serialNo;
        }

        public final String component5() {
            return this.positiveButtonText;
        }

        public final String component6() {
            return this.negativeButtonText;
        }

        public final Float component7() {
            return this.messageFontSize;
        }

        public final boolean component8() {
            return this.isPositiveButtonDelayAppear;
        }

        public final TagDialogEntity copy(String str, String str2, String str3, String str4, String str5, String str6, Float f, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str5, "positiveButtonText");
            return new TagDialogEntity(str, str2, str3, str4, str5, str6, f, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TagDialogEntity)) {
                return false;
            }
            TagDialogEntity tagDialogEntity = (TagDialogEntity) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) tagDialogEntity.title) && Intrinsics.areEqual((Object) this.message, (Object) tagDialogEntity.message) && Intrinsics.areEqual((Object) this.modelName, (Object) tagDialogEntity.modelName) && Intrinsics.areEqual((Object) this.serialNo, (Object) tagDialogEntity.serialNo) && Intrinsics.areEqual((Object) this.positiveButtonText, (Object) tagDialogEntity.positiveButtonText) && Intrinsics.areEqual((Object) this.negativeButtonText, (Object) tagDialogEntity.negativeButtonText) && Intrinsics.areEqual((Object) this.messageFontSize, (Object) tagDialogEntity.messageFontSize) && this.isPositiveButtonDelayAppear == tagDialogEntity.isPositiveButtonDelayAppear;
        }

        public int hashCode() {
            int hashCode = this.title.hashCode() * 31;
            String str = this.message;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.modelName;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.serialNo;
            int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.positiveButtonText.hashCode()) * 31;
            String str4 = this.negativeButtonText;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Float f = this.messageFontSize;
            if (f != null) {
                i = f.hashCode();
            }
            return ((hashCode5 + i) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isPositiveButtonDelayAppear);
        }

        public String toString() {
            String str = this.title;
            String str2 = this.message;
            String str3 = this.modelName;
            String str4 = this.serialNo;
            String str5 = this.positiveButtonText;
            String str6 = this.negativeButtonText;
            Float f = this.messageFontSize;
            boolean z = this.isPositiveButtonDelayAppear;
            return "TagDialogEntity(title=" + str + ", message=" + str2 + ", modelName=" + str3 + ", serialNo=" + str4 + ", positiveButtonText=" + str5 + ", negativeButtonText=" + str6 + ", messageFontSize=" + f + ", isPositiveButtonDelayAppear=" + z + ")";
        }

        public TagDialogEntity(String str, String str2, String str3, String str4, String str5, String str6, Float f, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str5, "positiveButtonText");
            this.title = str;
            this.message = str2;
            this.modelName = str3;
            this.serialNo = str4;
            this.positiveButtonText = str5;
            this.negativeButtonText = str6;
            this.messageFontSize = f;
            this.isPositiveButtonDelayAppear = z;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ TagDialogEntity(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.Float r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
            /*
                r12 = this;
                r0 = r21
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r5 = r2
                goto L_0x000a
            L_0x0009:
                r5 = r14
            L_0x000a:
                r1 = r0 & 4
                if (r1 == 0) goto L_0x0010
                r6 = r2
                goto L_0x0011
            L_0x0010:
                r6 = r15
            L_0x0011:
                r1 = r0 & 8
                if (r1 == 0) goto L_0x0017
                r7 = r2
                goto L_0x0019
            L_0x0017:
                r7 = r16
            L_0x0019:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x001f
                r9 = r2
                goto L_0x0021
            L_0x001f:
                r9 = r18
            L_0x0021:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0027
                r10 = r2
                goto L_0x0029
            L_0x0027:
                r10 = r19
            L_0x0029:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x0030
                r0 = 0
                r11 = r0
                goto L_0x0032
            L_0x0030:
                r11 = r20
            L_0x0032:
                r3 = r12
                r4 = r13
                r8 = r17
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.util.DialogBuilderUtil.TagDialogEntity.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Float, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }

        public final String getModelName() {
            return this.modelName;
        }

        public final void setModelName(String str) {
            this.modelName = str;
        }

        public final String getSerialNo() {
            return this.serialNo;
        }

        public final void setSerialNo(String str) {
            this.serialNo = str;
        }

        public final String getPositiveButtonText() {
            return this.positiveButtonText;
        }

        public final void setPositiveButtonText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.positiveButtonText = str;
        }

        public final String getNegativeButtonText() {
            return this.negativeButtonText;
        }

        public final void setNegativeButtonText(String str) {
            this.negativeButtonText = str;
        }

        public final Float getMessageFontSize() {
            return this.messageFontSize;
        }

        public final void setMessageFontSize(Float f) {
            this.messageFontSize = f;
        }

        public final boolean isPositiveButtonDelayAppear() {
            return this.isPositiveButtonDelayAppear;
        }

        public final void setPositiveButtonDelayAppear(boolean z) {
            this.isPositiveButtonDelayAppear = z;
        }
    }

    private final DataDialogFragment tagDoubleButtonDialog(FragmentActivity fragmentActivity, TagDialogEntity tagDialogEntity, DialogDoubleActionListener dialogDoubleActionListener) {
        DataDialogFragment showDataDialog$default = DialogHelperUtil.showDataDialog$default(DialogHelperUtil.Companion.newInstance(fragmentActivity), 0, BaseDialogFragment.Builder.DialogType.TAG_DOUBLE_BUTTON, DialogHelperUtil.RequestCode.TAG_DOUBLE_BUTTON.ordinal(), 0, 0, false, 0, 121, (Object) null);
        showDataDialog$default.setLifecycleListener(new DialogBuilderUtil$tagDoubleButtonDialog$1(tagDialogEntity, fragmentActivity, dialogDoubleActionListener, showDataDialog$default));
        return showDataDialog$default;
    }

    private final DataDialogFragment tagSingleButtonDialog(FragmentActivity fragmentActivity, TagDialogEntity tagDialogEntity, DialogSingleActionListener dialogSingleActionListener) {
        DataDialogFragment showDataDialog$default = DialogHelperUtil.showDataDialog$default(DialogHelperUtil.Companion.newInstance(fragmentActivity), 0, BaseDialogFragment.Builder.DialogType.TAG_SINGLE_BUTTON, DialogHelperUtil.RequestCode.TAG_SINGLE_BUTTON.ordinal(), 0, 0, false, 0, 121, (Object) null);
        showDataDialog$default.setLifecycleListener(new DialogBuilderUtil$tagSingleButtonDialog$1(tagDialogEntity, fragmentActivity, dialogSingleActionListener, showDataDialog$default));
        return showDataDialog$default;
    }

    public final DataDialogFragment showTagRegisterDialog(FragmentActivity fragmentActivity, DialogDoubleActionListener dialogDoubleActionListener) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "aActivity");
        Intrinsics.checkNotNullParameter(dialogDoubleActionListener, "callback");
        String string = fragmentActivity.getString(R.string.tag_registration_start_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = fragmentActivity.getString(R.string.tag_registration_start_description);
        String string3 = fragmentActivity.getString(R.string.common_register);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return tagDoubleButtonDialog(fragmentActivity, new TagDialogEntity(string, string2, (String) null, (String) null, string3, fragmentActivity.getString(R.string.common_cancel), (Float) null, false, ComposerKt.providerMapsKey, (DefaultConstructorMarker) null), dialogDoubleActionListener);
    }

    public final DataDialogFragment showTagFoundDialog(FragmentActivity fragmentActivity, TagDataEntity tagDataEntity, String str, DialogDoubleActionListener dialogDoubleActionListener) {
        FragmentActivity fragmentActivity2 = fragmentActivity;
        DialogDoubleActionListener dialogDoubleActionListener2 = dialogDoubleActionListener;
        Intrinsics.checkNotNullParameter(fragmentActivity2, "aActivity");
        Intrinsics.checkNotNullParameter(tagDataEntity, "aTagInfo");
        Intrinsics.checkNotNullParameter(str, "aTagModelName");
        Intrinsics.checkNotNullParameter(dialogDoubleActionListener2, "callback");
        String string = fragmentActivity2.getString(R.string.tag_registration_discovered_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = fragmentActivity2.getString(R.string.tag_registration_discovered_description);
        String serialNo = tagDataEntity.getSerialNo();
        if (serialNo == null) {
            serialNo = "";
        }
        String str2 = serialNo;
        String string3 = fragmentActivity2.getString(R.string.common_yes);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return tagDoubleButtonDialog(fragmentActivity2, new TagDialogEntity(string, string2, str, str2, string3, fragmentActivity2.getString(R.string.common_no), (Float) null, false, 192, (DefaultConstructorMarker) null), dialogDoubleActionListener2);
    }

    public final DataDialogFragment showTagRegisteredDialog(FragmentActivity fragmentActivity, TagDataEntity tagDataEntity, String str, DialogSingleActionListener dialogSingleActionListener) {
        FragmentActivity fragmentActivity2 = fragmentActivity;
        DialogSingleActionListener dialogSingleActionListener2 = dialogSingleActionListener;
        Intrinsics.checkNotNullParameter(fragmentActivity, "aActivity");
        Intrinsics.checkNotNullParameter(tagDataEntity, "aTagInfo");
        Intrinsics.checkNotNullParameter(str, "aTagModelName");
        Intrinsics.checkNotNullParameter(dialogSingleActionListener2, "callback");
        String string = fragmentActivity.getString(R.string.tag_registration_completed_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String serialNo = tagDataEntity.getSerialNo();
        if (serialNo == null) {
            serialNo = "";
        }
        String str2 = serialNo;
        String string2 = fragmentActivity.getString(R.string.common_ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return tagSingleButtonDialog(fragmentActivity, new TagDialogEntity(string, (String) null, str, str2, string2, (String) null, (Float) null, false, 226, (DefaultConstructorMarker) null), dialogSingleActionListener2);
    }

    public final DataDialogFragment showTagRegistrationFailedDialog(FragmentActivity fragmentActivity, DialogDoubleActionListener dialogDoubleActionListener) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "aActivity");
        Intrinsics.checkNotNullParameter(dialogDoubleActionListener, "callback");
        String string = fragmentActivity.getString(R.string.tag_registration_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = fragmentActivity.getString(R.string.tag_registration_error_description);
        String string3 = fragmentActivity.getString(R.string.common_yes);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return tagDoubleButtonDialog(fragmentActivity, new TagDialogEntity(string, string2, (String) null, (String) null, string3, fragmentActivity.getString(R.string.common_no), (Float) null, false, ComposerKt.providerMapsKey, (DefaultConstructorMarker) null), dialogDoubleActionListener);
    }

    public final DataDialogFragment showTagNotFoundDialog(FragmentActivity fragmentActivity, DialogDoubleActionListener dialogDoubleActionListener) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "aActivity");
        Intrinsics.checkNotNullParameter(dialogDoubleActionListener, "callback");
        String string = fragmentActivity.getString(R.string.tag_registration_not_discovered_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = fragmentActivity.getString(R.string.tag_registration_not_discovered_description);
        String string3 = fragmentActivity.getString(R.string.common_yes);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return tagDoubleButtonDialog(fragmentActivity, new TagDialogEntity(string, string2, (String) null, (String) null, string3, fragmentActivity.getString(R.string.common_no), (Float) null, false, ComposerKt.providerMapsKey, (DefaultConstructorMarker) null), dialogDoubleActionListener);
    }

    public final DataDialogFragment showTagUnRegisterDialog(FragmentActivity fragmentActivity, TagDataEntity tagDataEntity, DialogDoubleActionListener dialogDoubleActionListener) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "aActivity");
        Intrinsics.checkNotNullParameter(dialogDoubleActionListener, "callback");
        String string = fragmentActivity.getString(R.string.tag_registration_unregister_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = fragmentActivity.getString(R.string.tag_registration_unregister_description);
        String string3 = fragmentActivity.getString(R.string.setting_unregister_buttun);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return tagDoubleButtonDialog(fragmentActivity, new TagDialogEntity(string, string2, (String) null, (String) null, string3, fragmentActivity.getString(R.string.common_cancel), (Float) null, false, ComposerKt.providerMapsKey, (DefaultConstructorMarker) null), dialogDoubleActionListener);
    }

    public final DataDialogFragment showTagFwUpdateDialog(FragmentActivity fragmentActivity, DialogSingleActionListener dialogSingleActionListener) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "aActivity");
        Intrinsics.checkNotNullParameter(dialogSingleActionListener, "callback");
        String string = fragmentActivity.getString(R.string.tag_dfu_start_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = fragmentActivity.getString(R.string.tag_dfu_start_description);
        String string3 = fragmentActivity.getString(R.string.common_ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return tagSingleButtonDialog(fragmentActivity, new TagDialogEntity(string, string2, (String) null, (String) null, string3, (String) null, Float.valueOf(24.0f), true, 44, (DefaultConstructorMarker) null), dialogSingleActionListener);
    }

    public final DataDialogFragment showTagFwUpdateProgressDialog(FragmentActivity fragmentActivity, BaseDialogFragment.DialogFragmentLifecycleListener dialogFragmentLifecycleListener) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "aActivity");
        Intrinsics.checkNotNullParameter(dialogFragmentLifecycleListener, "aListener");
        DataDialogFragment showDataDialog = DialogHelperUtil.Companion.newInstance(fragmentActivity).showDataDialog(R.string.tag_dfu_on_going_subtitle, BaseDialogFragment.Builder.DialogType.PROGRESS, DialogHelperUtil.RequestCode.DIALOG_DURATION.ordinal(), 0, 0, R.string.tag_dfu_on_going_description);
        showDataDialog.setLifecycleListener(dialogFragmentLifecycleListener);
        return showDataDialog;
    }

    public final AlertDialogFragment showTagFwUpdateCompleteDialog(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "aActivity");
        return DialogHelperUtil.Companion.newInstance(fragmentActivity).showConfirmationDialog(R.string.tag_dfu_complete_message, 0, 0, DialogHelperUtil.RequestCode.TAG_DFU_COMPLETE.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    public final DataDialogFragment showSettingMenuDialog(FragmentActivity fragmentActivity, DialogSelectActionListener<SettingItemAdapter.SettingListItem> dialogSelectActionListener) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "aActivity");
        Intrinsics.checkNotNullParameter(dialogSelectActionListener, "callback");
        DataDialogFragment showDataDialog$default = DialogHelperUtil.showDataDialog$default(DialogHelperUtil.Companion.newInstance(fragmentActivity), 0, BaseDialogFragment.Builder.DialogType.SETTING_MENU_POPUP, DialogHelperUtil.RequestCode.SETTING_MENU_POPUP.ordinal(), 0, 0, true, 0, 89, (Object) null);
        showDataDialog$default.setLifecycleListener(new DialogBuilderUtil$showSettingMenuDialog$1(fragmentActivity, dialogSelectActionListener));
        return showDataDialog$default;
    }
}
