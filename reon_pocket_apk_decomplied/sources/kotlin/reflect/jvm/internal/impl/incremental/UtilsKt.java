package kotlin.reflect.jvm.internal.impl.incremental;

import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: utils.kt */
public final class UtilsKt {
    public static final void record(LookupTracker lookupTracker, LookupLocation lookupLocation, ClassDescriptor classDescriptor, Name name) {
        LocationInfo location;
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(lookupLocation, Constants.MessagePayloadKeys.FROM);
        Intrinsics.checkNotNullParameter(classDescriptor, "scopeOwner");
        Intrinsics.checkNotNullParameter(name, "name");
        if (lookupTracker != LookupTracker.DO_NOTHING.INSTANCE && (location = lookupLocation.getLocation()) != null) {
            Position position = lookupTracker.getRequiresPosition() ? location.getPosition() : Position.Companion.getNO_POSITION();
            String filePath = location.getFilePath();
            String asString = DescriptorUtils.getFqName(classDescriptor).asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            ScopeKind scopeKind = ScopeKind.CLASSIFIER;
            String asString2 = name.asString();
            Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
            lookupTracker.record(filePath, position, asString, scopeKind, asString2);
        }
    }

    public static final void record(LookupTracker lookupTracker, LookupLocation lookupLocation, PackageFragmentDescriptor packageFragmentDescriptor, Name name) {
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(lookupLocation, Constants.MessagePayloadKeys.FROM);
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "scopeOwner");
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = packageFragmentDescriptor.getFqName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
        recordPackageLookup(lookupTracker, lookupLocation, asString, asString2);
    }

    public static final void recordPackageLookup(LookupTracker lookupTracker, LookupLocation lookupLocation, String str, String str2) {
        LocationInfo location;
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(lookupLocation, Constants.MessagePayloadKeys.FROM);
        Intrinsics.checkNotNullParameter(str, "packageFqName");
        Intrinsics.checkNotNullParameter(str2, "name");
        if (lookupTracker != LookupTracker.DO_NOTHING.INSTANCE && (location = lookupLocation.getLocation()) != null) {
            lookupTracker.record(location.getFilePath(), lookupTracker.getRequiresPosition() ? location.getPosition() : Position.Companion.getNO_POSITION(), str, ScopeKind.PACKAGE, str2);
        }
    }
}
