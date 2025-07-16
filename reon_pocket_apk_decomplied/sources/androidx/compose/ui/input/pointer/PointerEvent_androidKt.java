package androidx.compose.ui.input.pointer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u000b\u001a\r\u0010$\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0010%\u001a\u0014\u0010&\u001a\u00020'*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0014\u0010*\u001a\u00020'*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)\u001a\u001c\u0010,\u001a\u00020\u0001*\u00020\u00022\u0006\u0010-\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\b.\u0010/\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004\"\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004\"\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004\"\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0004\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004\"\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0015\u0010\u001a\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0004\"\u0015\u0010\u001c\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\"\u0015\u0010 \u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b!\u0010\u0004\"\u0015\u0010\"\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b#\u0010\u0004*\f\b\u0000\u00100\"\u00020'2\u00020'*\f\b\u0000\u00101\"\u00020'2\u00020'\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"areAnyPressed", "", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getAreAnyPressed-aHzCx-E", "(I)Z", "isAltGraphPressed", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "isAltGraphPressed-5xRPYO0", "isAltPressed", "isAltPressed-5xRPYO0", "isBackPressed", "isBackPressed-aHzCx-E", "isCapsLockOn", "isCapsLockOn-5xRPYO0", "isCtrlPressed", "isCtrlPressed-5xRPYO0", "isForwardPressed", "isForwardPressed-aHzCx-E", "isFunctionPressed", "isFunctionPressed-5xRPYO0", "isMetaPressed", "isMetaPressed-5xRPYO0", "isNumLockOn", "isNumLockOn-5xRPYO0", "isPrimaryPressed", "isPrimaryPressed-aHzCx-E", "isScrollLockOn", "isScrollLockOn-5xRPYO0", "isSecondaryPressed", "isSecondaryPressed-aHzCx-E", "isShiftPressed", "isShiftPressed-5xRPYO0", "isSymPressed", "isSymPressed-5xRPYO0", "isTertiaryPressed", "isTertiaryPressed-aHzCx-E", "EmptyPointerKeyboardModifiers", "()I", "indexOfFirstPressed", "", "indexOfFirstPressed-aHzCx-E", "(I)I", "indexOfLastPressed", "indexOfLastPressed-aHzCx-E", "isPressed", "buttonIndex", "isPressed-bNIWhpI", "(II)Z", "NativePointerButtons", "NativePointerKeyboardModifiers", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerEvent.android.kt */
public final class PointerEvent_androidKt {
    /* renamed from: getAreAnyPressed-aHzCx-E  reason: not valid java name */
    public static final boolean m5072getAreAnyPressedaHzCxE(int i) {
        return i != 0;
    }

    /* renamed from: indexOfFirstPressed-aHzCx-E  reason: not valid java name */
    public static final int m5073indexOfFirstPressedaHzCxE(int i) {
        if (i == 0) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = (i & -97) | ((i & 96) >>> 5); (i3 & 1) == 0; i3 >>>= 1) {
            i2++;
        }
        return i2;
    }

    /* renamed from: indexOfLastPressed-aHzCx-E  reason: not valid java name */
    public static final int m5074indexOfLastPressedaHzCxE(int i) {
        int i2 = -1;
        for (int i3 = (i & -97) | ((i & 96) >>> 5); i3 != 0; i3 >>>= 1) {
            i2++;
        }
        return i2;
    }

    /* renamed from: isAltGraphPressed-5xRPYO0  reason: not valid java name */
    public static final boolean m5075isAltGraphPressed5xRPYO0(int i) {
        return false;
    }

    /* renamed from: isAltPressed-5xRPYO0  reason: not valid java name */
    public static final boolean m5076isAltPressed5xRPYO0(int i) {
        return (i & 2) != 0;
    }

    /* renamed from: isBackPressed-aHzCx-E  reason: not valid java name */
    public static final boolean m5077isBackPressedaHzCxE(int i) {
        return (i & 8) != 0;
    }

    /* renamed from: isCapsLockOn-5xRPYO0  reason: not valid java name */
    public static final boolean m5078isCapsLockOn5xRPYO0(int i) {
        return (i & 1048576) != 0;
    }

    /* renamed from: isCtrlPressed-5xRPYO0  reason: not valid java name */
    public static final boolean m5079isCtrlPressed5xRPYO0(int i) {
        return (i & 4096) != 0;
    }

    /* renamed from: isForwardPressed-aHzCx-E  reason: not valid java name */
    public static final boolean m5080isForwardPressedaHzCxE(int i) {
        return (i & 16) != 0;
    }

    /* renamed from: isFunctionPressed-5xRPYO0  reason: not valid java name */
    public static final boolean m5081isFunctionPressed5xRPYO0(int i) {
        return (i & 8) != 0;
    }

    /* renamed from: isMetaPressed-5xRPYO0  reason: not valid java name */
    public static final boolean m5082isMetaPressed5xRPYO0(int i) {
        return (i & 65536) != 0;
    }

    /* renamed from: isNumLockOn-5xRPYO0  reason: not valid java name */
    public static final boolean m5083isNumLockOn5xRPYO0(int i) {
        return (i & 2097152) != 0;
    }

    /* renamed from: isPrimaryPressed-aHzCx-E  reason: not valid java name */
    public static final boolean m5085isPrimaryPressedaHzCxE(int i) {
        return (i & 33) != 0;
    }

    /* renamed from: isScrollLockOn-5xRPYO0  reason: not valid java name */
    public static final boolean m5086isScrollLockOn5xRPYO0(int i) {
        return (i & 4194304) != 0;
    }

    /* renamed from: isSecondaryPressed-aHzCx-E  reason: not valid java name */
    public static final boolean m5087isSecondaryPressedaHzCxE(int i) {
        return (i & 66) != 0;
    }

    /* renamed from: isShiftPressed-5xRPYO0  reason: not valid java name */
    public static final boolean m5088isShiftPressed5xRPYO0(int i) {
        return (i & 1) != 0;
    }

    /* renamed from: isSymPressed-5xRPYO0  reason: not valid java name */
    public static final boolean m5089isSymPressed5xRPYO0(int i) {
        return (i & 4) != 0;
    }

    /* renamed from: isTertiaryPressed-aHzCx-E  reason: not valid java name */
    public static final boolean m5090isTertiaryPressedaHzCxE(int i) {
        return (i & 4) != 0;
    }

    public static final int EmptyPointerKeyboardModifiers() {
        return PointerKeyboardModifiers.m5180constructorimpl(0);
    }

    /* renamed from: isPressed-bNIWhpI  reason: not valid java name */
    public static final boolean m5084isPressedbNIWhpI(int i, int i2) {
        if (i2 == 0) {
            return m5085isPrimaryPressedaHzCxE(i);
        }
        if (i2 == 1) {
            return m5087isSecondaryPressedaHzCxE(i);
        }
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            if ((i & (1 << i2)) != 0) {
                return true;
            }
        } else if ((i & (1 << (i2 + 2))) != 0) {
            return true;
        }
        return false;
    }
}
