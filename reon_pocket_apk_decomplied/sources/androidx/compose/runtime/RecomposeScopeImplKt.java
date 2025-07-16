package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"DefaultsInScopeFlag", "", "DefaultsInvalidFlag", "ForcedRecomposeFlag", "RequiresRecomposeFlag", "RereadingFlag", "SkippedFlag", "UsedFlag", "callbackLock", "", "changedHighBitMask", "changedLowBitMask", "changedMask", "updateChangedFlags", "flags", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RecomposeScopeImpl.kt */
public final class RecomposeScopeImplKt {
    private static final int DefaultsInScopeFlag = 2;
    private static final int DefaultsInvalidFlag = 4;
    private static final int ForcedRecomposeFlag = 64;
    private static final int RequiresRecomposeFlag = 8;
    private static final int RereadingFlag = 32;
    private static final int SkippedFlag = 16;
    private static final int UsedFlag = 1;
    /* access modifiers changed from: private */
    public static final Object callbackLock = new Object();
    private static final int changedHighBitMask = 613566756;
    private static final int changedLowBitMask = 306783378;
    private static final int changedMask = -920350135;

    public static final int updateChangedFlags(int i) {
        int i2 = changedLowBitMask & i;
        int i3 = changedHighBitMask & i;
        return (i & changedMask) | (i3 >> 1) | i2 | ((i2 << 1) & i3);
    }
}
