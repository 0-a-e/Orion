package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat$$ExternalSyntheticApiModelOutline0;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.ColorKt$$ExternalSyntheticApiModelOutline0;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    int mDisabledReason;
    int mExcludedSurfaces;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled = true;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    CharSequence mLabel;
    long mLastChangedTimestamp;
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Surface {
    }

    ShortcutInfoCompat() {
    }

    public ShortcutInfo toShortcutInfo() {
        NotificationCompat$$ExternalSyntheticApiModelOutline0.m$2();
        ShortcutInfo.Builder m = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            ShortcutInfo.Builder unused = m.setIcon(iconCompat.toIcon(this.mContext));
        }
        if (!TextUtils.isEmpty(this.mLongLabel)) {
            ShortcutInfo.Builder unused2 = m.setLongLabel(this.mLongLabel);
        }
        if (!TextUtils.isEmpty(this.mDisabledMessage)) {
            ShortcutInfo.Builder unused3 = m.setDisabledMessage(this.mDisabledMessage);
        }
        ComponentName componentName = this.mActivity;
        if (componentName != null) {
            ShortcutInfo.Builder unused4 = m.setActivity(componentName);
        }
        Set<String> set = this.mCategories;
        if (set != null) {
            ShortcutInfo.Builder unused5 = m.setCategories(set);
        }
        ShortcutInfo.Builder unused6 = m.setRank(this.mRank);
        PersistableBundle persistableBundle = this.mExtras;
        if (persistableBundle != null) {
            ShortcutInfo.Builder unused7 = m.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.mPersons;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                for (int i = 0; i < length; i++) {
                    personArr2[i] = this.mPersons[i].toAndroidPerson();
                }
                ShortcutInfo.Builder unused8 = m.setPersons(personArr2);
            }
            LocusIdCompat locusIdCompat = this.mLocusId;
            if (locusIdCompat != null) {
                ShortcutInfo.Builder unused9 = m.setLocusId(locusIdCompat.toLocusId());
            }
            ShortcutInfo.Builder unused10 = m.setLongLived(this.mIsLongLived);
        } else {
            ShortcutInfo.Builder unused11 = m.setExtras(buildLegacyExtrasBundle());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.setExcludedFromSurfaces(m, this.mExcludedSurfaces);
        }
        return m.build();
    }

    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras == null) {
            this.mExtras = new PersistableBundle();
        }
        Person[] personArr = this.mPersons;
        if (personArr != null && personArr.length > 0) {
            this.mExtras.putInt(EXTRA_PERSON_COUNT, personArr.length);
            int i = 0;
            while (i < this.mPersons.length) {
                PersistableBundle persistableBundle = this.mExtras;
                StringBuilder sb = new StringBuilder(EXTRA_PERSON_);
                int i2 = i + 1;
                sb.append(i2);
                persistableBundle.putPersistableBundle(sb.toString(), this.mPersons[i].toPersistableBundle());
                i = i2;
            }
        }
        LocusIdCompat locusIdCompat = this.mLocusId;
        if (locusIdCompat != null) {
            this.mExtras.putString(EXTRA_LOCUS_ID, locusIdCompat.getId());
        }
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    }

    /* access modifiers changed from: package-private */
    public Intent addToIntent(Intent intent) {
        Intent[] intentArr = this.mIntents;
        intent.putExtra("android.intent.extra.shortcut.INTENT", intentArr[intentArr.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon != null) {
            Drawable drawable = null;
            if (this.mIsAlwaysBadged) {
                PackageManager packageManager = this.mContext.getPackageManager();
                ComponentName componentName = this.mActivity;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.mContext.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.mIcon.addToShortcutIntent(intent, drawable, this.mContext);
        }
        return intent;
    }

    public String getId() {
        return this.mId;
    }

    public String getPackage() {
        return this.mPackageName;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public Intent getIntent() {
        Intent[] intentArr = this.mIntents;
        return intentArr[intentArr.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] intentArr = this.mIntents;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public Set<String> getCategories() {
        return this.mCategories;
    }

    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    public int getRank() {
        return this.mRank;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    static Person[] getPersonsFromExtra(PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_PERSON_COUNT)) {
            return null;
        }
        int i = persistableBundle.getInt(EXTRA_PERSON_COUNT);
        Person[] personArr = new Person[i];
        int i2 = 0;
        while (i2 < i) {
            StringBuilder sb = new StringBuilder(EXTRA_PERSON_);
            int i3 = i2 + 1;
            sb.append(i3);
            personArr[i2] = Person.fromPersistableBundle(persistableBundle.getPersistableBundle(sb.toString()));
            i2 = i3;
        }
        return personArr;
    }

    static boolean getLongLivedFromExtra(PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_LONG_LIVED)) {
            return false;
        }
        return persistableBundle.getBoolean(EXTRA_LONG_LIVED);
    }

    static List<ShortcutInfoCompat> fromShortcuts(Context context, List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (ShortcutInfo m : list) {
            arrayList.add(new Builder(context, NotificationCompat$$ExternalSyntheticApiModelOutline0.m((Object) m)).build());
        }
        return arrayList;
    }

    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    static LocusIdCompat getLocusId(ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT < 29) {
            return getLocusIdFromExtra(NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo));
        }
        if (NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo) == null) {
            return null;
        }
        return LocusIdCompat.toLocusIdCompat(NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo));
    }

    public boolean isExcludedFromSurfaces(int i) {
        return (i & this.mExcludedSurfaces) != 0;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString(EXTRA_LOCUS_ID)) == null) {
            return null;
        }
        return new LocusIdCompat(string);
    }

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder(Context context, String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = str;
        }

        public Builder(ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat2;
            shortcutInfoCompat2.mContext = shortcutInfoCompat.mContext;
            shortcutInfoCompat2.mId = shortcutInfoCompat.mId;
            shortcutInfoCompat2.mPackageName = shortcutInfoCompat.mPackageName;
            shortcutInfoCompat2.mIntents = (Intent[]) Arrays.copyOf(shortcutInfoCompat.mIntents, shortcutInfoCompat.mIntents.length);
            shortcutInfoCompat2.mActivity = shortcutInfoCompat.mActivity;
            shortcutInfoCompat2.mLabel = shortcutInfoCompat.mLabel;
            shortcutInfoCompat2.mLongLabel = shortcutInfoCompat.mLongLabel;
            shortcutInfoCompat2.mDisabledMessage = shortcutInfoCompat.mDisabledMessage;
            shortcutInfoCompat2.mDisabledReason = shortcutInfoCompat.mDisabledReason;
            shortcutInfoCompat2.mIcon = shortcutInfoCompat.mIcon;
            shortcutInfoCompat2.mIsAlwaysBadged = shortcutInfoCompat.mIsAlwaysBadged;
            shortcutInfoCompat2.mUser = shortcutInfoCompat.mUser;
            shortcutInfoCompat2.mLastChangedTimestamp = shortcutInfoCompat.mLastChangedTimestamp;
            shortcutInfoCompat2.mIsCached = shortcutInfoCompat.mIsCached;
            shortcutInfoCompat2.mIsDynamic = shortcutInfoCompat.mIsDynamic;
            shortcutInfoCompat2.mIsPinned = shortcutInfoCompat.mIsPinned;
            shortcutInfoCompat2.mIsDeclaredInManifest = shortcutInfoCompat.mIsDeclaredInManifest;
            shortcutInfoCompat2.mIsImmutable = shortcutInfoCompat.mIsImmutable;
            shortcutInfoCompat2.mIsEnabled = shortcutInfoCompat.mIsEnabled;
            shortcutInfoCompat2.mLocusId = shortcutInfoCompat.mLocusId;
            shortcutInfoCompat2.mIsLongLived = shortcutInfoCompat.mIsLongLived;
            shortcutInfoCompat2.mHasKeyFieldsOnly = shortcutInfoCompat.mHasKeyFieldsOnly;
            shortcutInfoCompat2.mRank = shortcutInfoCompat.mRank;
            if (shortcutInfoCompat.mPersons != null) {
                shortcutInfoCompat2.mPersons = (Person[]) Arrays.copyOf(shortcutInfoCompat.mPersons, shortcutInfoCompat.mPersons.length);
            }
            if (shortcutInfoCompat.mCategories != null) {
                shortcutInfoCompat2.mCategories = new HashSet(shortcutInfoCompat.mCategories);
            }
            if (shortcutInfoCompat.mExtras != null) {
                shortcutInfoCompat2.mExtras = shortcutInfoCompat.mExtras;
            }
            shortcutInfoCompat2.mExcludedSurfaces = shortcutInfoCompat.mExcludedSurfaces;
        }

        public Builder(Context context, ShortcutInfo shortcutInfo) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            shortcutInfoCompat.mPackageName = NotificationCompat$$ExternalSyntheticApiModelOutline0.m$1(shortcutInfo);
            Intent[] m = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            shortcutInfoCompat.mIntents = (Intent[]) Arrays.copyOf(m, m.length);
            shortcutInfoCompat.mActivity = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            shortcutInfoCompat.mLabel = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            shortcutInfoCompat.mLongLabel = ColorKt$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            shortcutInfoCompat.mDisabledMessage = shortcutInfo.getDisabledMessage();
            if (Build.VERSION.SDK_INT >= 28) {
                shortcutInfoCompat.mDisabledReason = ColorKt$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            } else {
                shortcutInfoCompat.mDisabledReason = shortcutInfo.isEnabled() ? 0 : 3;
            }
            shortcutInfoCompat.mCategories = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            shortcutInfoCompat.mPersons = ShortcutInfoCompat.getPersonsFromExtra(NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo));
            shortcutInfoCompat.mUser = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            shortcutInfoCompat.mLastChangedTimestamp = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            if (Build.VERSION.SDK_INT >= 30) {
                shortcutInfoCompat.mIsCached = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            }
            shortcutInfoCompat.mIsDynamic = NotificationCompat$$ExternalSyntheticApiModelOutline0.m$1(shortcutInfo);
            shortcutInfoCompat.mIsPinned = shortcutInfo.isPinned();
            shortcutInfoCompat.mIsDeclaredInManifest = shortcutInfo.isDeclaredInManifest();
            shortcutInfoCompat.mIsImmutable = shortcutInfo.isImmutable();
            shortcutInfoCompat.mIsEnabled = shortcutInfo.isEnabled();
            shortcutInfoCompat.mHasKeyFieldsOnly = shortcutInfo.hasKeyFieldsOnly();
            shortcutInfoCompat.mLocusId = ShortcutInfoCompat.getLocusId(shortcutInfo);
            shortcutInfoCompat.mRank = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
            shortcutInfoCompat.mExtras = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(shortcutInfo);
        }

        public Builder setShortLabel(CharSequence charSequence) {
            this.mInfo.mLabel = charSequence;
            return this;
        }

        public Builder setLongLabel(CharSequence charSequence) {
            this.mInfo.mLongLabel = charSequence;
            return this;
        }

        public Builder setDisabledMessage(CharSequence charSequence) {
            this.mInfo.mDisabledMessage = charSequence;
            return this;
        }

        public Builder setIntent(Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        public Builder setIntents(Intent[] intentArr) {
            this.mInfo.mIntents = intentArr;
            return this;
        }

        public Builder setIcon(IconCompat iconCompat) {
            this.mInfo.mIcon = iconCompat;
            return this;
        }

        public Builder setLocusId(LocusIdCompat locusIdCompat) {
            this.mInfo.mLocusId = locusIdCompat;
            return this;
        }

        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        public Builder setActivity(ComponentName componentName) {
            this.mInfo.mActivity = componentName;
            return this;
        }

        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public Builder setPerson(Person person) {
            return setPersons(new Person[]{person});
        }

        public Builder setPersons(Person[] personArr) {
            this.mInfo.mPersons = personArr;
            return this;
        }

        public Builder setCategories(Set<String> set) {
            ArraySet arraySet = new ArraySet();
            arraySet.addAll(set);
            this.mInfo.mCategories = arraySet;
            return this;
        }

        @Deprecated
        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        public Builder setLongLived(boolean z) {
            this.mInfo.mIsLongLived = z;
            return this;
        }

        public Builder setExcludedFromSurfaces(int i) {
            this.mInfo.mExcludedSurfaces = i;
            return this;
        }

        public Builder setRank(int i) {
            this.mInfo.mRank = i;
            return this;
        }

        public Builder setExtras(PersistableBundle persistableBundle) {
            this.mInfo.mExtras = persistableBundle;
            return this;
        }

        public Builder setTransientExtras(Bundle bundle) {
            this.mInfo.mTransientExtras = (Bundle) Preconditions.checkNotNull(bundle);
            return this;
        }

        public Builder addCapabilityBinding(String str) {
            if (this.mCapabilityBindings == null) {
                this.mCapabilityBindings = new HashSet();
            }
            this.mCapabilityBindings.add(str);
            return this;
        }

        public Builder addCapabilityBinding(String str, String str2, List<String> list) {
            addCapabilityBinding(str);
            if (!list.isEmpty()) {
                if (this.mCapabilityBindingParams == null) {
                    this.mCapabilityBindingParams = new HashMap();
                }
                if (this.mCapabilityBindingParams.get(str) == null) {
                    this.mCapabilityBindingParams.put(str, new HashMap());
                }
                this.mCapabilityBindingParams.get(str).put(str2, list);
            }
            return this;
        }

        public Builder setSliceUri(Uri uri) {
            this.mSliceUri = uri;
            return this;
        }

        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            } else if (this.mInfo.mIntents == null || this.mInfo.mIntents.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            } else {
                if (this.mIsConversation) {
                    if (this.mInfo.mLocusId == null) {
                        ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
                        shortcutInfoCompat.mLocusId = new LocusIdCompat(shortcutInfoCompat.mId);
                    }
                    this.mInfo.mIsLongLived = true;
                }
                if (this.mCapabilityBindings != null) {
                    if (this.mInfo.mCategories == null) {
                        this.mInfo.mCategories = new HashSet();
                    }
                    this.mInfo.mCategories.addAll(this.mCapabilityBindings);
                }
                if (this.mCapabilityBindingParams != null) {
                    if (this.mInfo.mExtras == null) {
                        this.mInfo.mExtras = new PersistableBundle();
                    }
                    for (String next : this.mCapabilityBindingParams.keySet()) {
                        Map map = this.mCapabilityBindingParams.get(next);
                        this.mInfo.mExtras.putStringArray(next, (String[]) map.keySet().toArray(new String[0]));
                        for (String str : map.keySet()) {
                            List list = (List) map.get(str);
                            PersistableBundle persistableBundle = this.mInfo.mExtras;
                            persistableBundle.putStringArray(next + "/" + str, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                        }
                    }
                }
                if (this.mSliceUri != null) {
                    if (this.mInfo.mExtras == null) {
                        this.mInfo.mExtras = new PersistableBundle();
                    }
                    this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
                }
                return this.mInfo;
            }
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static void setExcludedFromSurfaces(ShortcutInfo.Builder builder, int i) {
            builder.setExcludedFromSurfaces(i);
        }
    }
}
