package jp.co.sony.reonpocket.constant;

import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import java.util.ArrayList;
import java.util.Locale;
import jp.co.sony.reonpocket.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0002\u0010\rJ\u0011\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/constant/ModelConstant;", "", "()V", "DFU_SUFFIX", "", "getDfuModelNames", "", "()[Ljava/lang/String;", "getDfuTagModelNames", "getModelNames", "getResByDfuModelName", "", "aModelName", "(Ljava/lang/String;)Ljava/lang/Integer;", "getResByDfuTagModelName", "getTagModelNames", "getTopicName", "ModelName", "TagModelName", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ModelConstant.kt */
public final class ModelConstant {
    public static final int $stable = 0;
    public static final String DFU_SUFFIX = "-DFU";
    public static final ModelConstant INSTANCE = new ModelConstant();

    private ModelConstant() {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/constant/ModelConstant$ModelName;", "", "model", "", "fwId", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getFwId", "()I", "getModel", "()Ljava/lang/String;", "RNP_1", "RNP_1L", "RNP_1A", "RNP_2", "RNP_3", "RNP_4", "RNP_5", "RNP_P1", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ModelConstant.kt */
    public enum ModelName {
        RNP_1("RNP-1", R.raw.app_dfu_package_v1),
        RNP_1L("RNP-1L", R.raw.app_dfu_package_v1_light),
        RNP_1A("RNP-1A", R.raw.app_dfu_package_v1_a),
        RNP_2("RNP-2", R.raw.app_dfu_package_v2),
        RNP_3("RNP-3", R.raw.app_dfu_package_v3),
        RNP_4("RNP-4", R.raw.app_dfu_package_v4),
        RNP_5("RNP-5", R.raw.app_dfu_package_v5),
        RNP_P1("RNP-P1", R.raw.app_dfu_package_p_v1);
        
        private final int fwId;
        private final String model;

        public static EnumEntries<ModelName> getEntries() {
            return $ENTRIES;
        }

        private ModelName(String str, int i) {
            this.model = str;
            this.fwId = i;
        }

        public final int getFwId() {
            return this.fwId;
        }

        public final String getModel() {
            return this.model;
        }

        static {
            ModelName[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/constant/ModelConstant$TagModelName;", "", "model", "", "fwId", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getFwId", "()I", "getModel", "()Ljava/lang/String;", "RNPT_1", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ModelConstant.kt */
    public enum TagModelName {
        RNPT_1("RNPT-1", R.raw.app_dfu_package_tag_v1);
        
        private final int fwId;
        private final String model;

        public static EnumEntries<TagModelName> getEntries() {
            return $ENTRIES;
        }

        private TagModelName(String str, int i) {
            this.model = str;
            this.fwId = i;
        }

        public final int getFwId() {
            return this.fwId;
        }

        public final String getModel() {
            return this.model;
        }

        static {
            TagModelName[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final Integer getResByDfuModelName(String str) {
        ModelName modelName;
        Intrinsics.checkNotNullParameter(str, "aModelName");
        ModelName[] values = ModelName.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                modelName = null;
                break;
            }
            modelName = values[i];
            if (Intrinsics.areEqual((Object) modelName.getModel() + DFU_SUFFIX, (Object) str)) {
                break;
            }
            i++;
        }
        if (modelName != null) {
            return Integer.valueOf(modelName.getFwId());
        }
        return null;
    }

    public final Integer getResByDfuTagModelName(String str) {
        TagModelName tagModelName;
        Intrinsics.checkNotNullParameter(str, "aModelName");
        TagModelName[] values = TagModelName.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                tagModelName = null;
                break;
            }
            tagModelName = values[i];
            if (Intrinsics.areEqual((Object) tagModelName.getModel(), (Object) str)) {
                break;
            }
            i++;
        }
        if (tagModelName != null) {
            return Integer.valueOf(tagModelName.getFwId());
        }
        return null;
    }

    public final String[] getModelNames() {
        ArrayList arrayList = new ArrayList();
        for (ModelName model : ModelName.values()) {
            arrayList.add(model.getModel());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String[] getTagModelNames() {
        ArrayList arrayList = new ArrayList();
        for (TagModelName model : TagModelName.values()) {
            arrayList.add(model.getModel());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String[] getDfuModelNames() {
        ArrayList arrayList = new ArrayList();
        for (ModelName model : ModelName.values()) {
            arrayList.add(model.getModel() + DFU_SUFFIX);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String[] getDfuTagModelNames() {
        ArrayList arrayList = new ArrayList();
        for (TagModelName model : TagModelName.values()) {
            arrayList.add(model.getModel() + DFU_SUFFIX);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final String getTopicName(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "aModelName");
        Locale locale = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration()).get(0);
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (Intrinsics.areEqual((Object) language, (Object) Locale.JAPANESE.toString())) {
            str2 = locale.getLanguage();
        } else if (!Intrinsics.areEqual((Object) language, (Object) Locale.CHINESE.toString()) || !StringsKt.equals(locale.getCountry(), "hk", true)) {
            str2 = "en";
        } else {
            str2 = locale.getLanguage() + "-hk";
        }
        return str + "-" + str2;
    }
}
