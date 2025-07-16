package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001au\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001aS\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001b\u001a\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a]\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001d"}, d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Card.kt */
public final class CardKt {
    public static final void Card(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        BorderStroke borderStroke2;
        BorderStroke borderStroke3;
        CardElevation cardElevation3;
        Shape shape3;
        Modifier modifier3;
        BorderStroke borderStroke4;
        int i4;
        CardColors cardColors3;
        CardElevation cardElevation4;
        CardElevation cardElevation5;
        int i5;
        int i6;
        int i7;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i8 = i;
        Composer startRestartGroup = composer.startRestartGroup(1179621553);
        ComposerKt.sourceInformation(startRestartGroup, "C(Card)P(4,5,1,3)78@3662L5,79@3707L12,80@3765L15,90@4151L57,84@3872L416:Card.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i8 | 6;
            modifier2 = modifier;
        } else if ((i8 & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i8;
        } else {
            modifier2 = modifier;
            i3 = i8;
        }
        if ((i8 & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed((Object) shape2)) {
                    i7 = 32;
                    i3 |= i7;
                }
            } else {
                shape2 = shape;
            }
            i7 = 16;
            i3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i8 & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                if (startRestartGroup.changed((Object) cardColors2)) {
                    i6 = 256;
                    i3 |= i6;
                }
            } else {
                cardColors2 = cardColors;
            }
            i6 = 128;
            i3 |= i6;
        } else {
            cardColors2 = cardColors;
        }
        if ((i8 & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                if (startRestartGroup.changed((Object) cardElevation2)) {
                    i5 = 2048;
                    i3 |= i5;
                }
            } else {
                cardElevation2 = cardElevation;
            }
            i5 = 1024;
            i3 |= i5;
        } else {
            cardElevation2 = cardElevation;
        }
        int i10 = i2 & 16;
        if (i10 != 0) {
            i3 |= CpioConstants.C_ISBLK;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((i8 & CpioConstants.C_ISBLK) == 0) {
                i3 |= startRestartGroup.changed((Object) borderStroke2) ? 16384 : 8192;
            }
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i8 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
        }
        if ((74899 & i3) != 74898 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i8 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                modifier3 = i9 != 0 ? Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    shape3 = CardDefaults.INSTANCE.getShape(startRestartGroup, 6);
                    i3 &= -113;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColors3 = CardDefaults.INSTANCE.cardColors(startRestartGroup, 6);
                    i3 &= -897;
                } else {
                    cardColors3 = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    cardElevation5 = CardDefaults.INSTANCE.m1574cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                    i3 &= -7169;
                } else {
                    cardElevation5 = cardElevation2;
                }
                borderStroke4 = i10 != 0 ? null : borderStroke;
                CardElevation cardElevation6 = cardElevation5;
                i4 = i3;
                cardElevation4 = cardElevation6;
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                modifier3 = modifier2;
                shape3 = shape2;
                cardColors3 = cardColors2;
                borderStroke4 = borderStroke2;
                i4 = i3;
                cardElevation4 = cardElevation2;
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1179621553, i4, -1, "androidx.compose.material3.Card (Card.kt:83)");
            }
            CardElevation cardElevation7 = cardElevation4;
            SurfaceKt.m2303SurfaceT9BRK9s(modifier3, shape3, cardColors3.m1566containerColorvNxB06k$material3_release(true), cardColors3.m1567contentColorvNxB06k$material3_release(true), cardElevation4.m1579tonalElevationu2uoSUM$material3_release(true), cardElevation4.shadowElevation$material3_release(true, (InteractionSource) null, startRestartGroup, ((i4 >> 3) & 896) | 54).getValue().m6628unboximpl(), borderStroke4, ComposableLambdaKt.composableLambda(startRestartGroup, 664103990, true, new CardKt$Card$1(function32)), startRestartGroup, (i4 & 14) | 12582912 | (i4 & 112) | (3670016 & (i4 << 6)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cardColors2 = cardColors3;
            cardElevation3 = cardElevation7;
            borderStroke3 = borderStroke4;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
            cardElevation3 = cardElevation2;
            borderStroke3 = borderStroke2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CardKt$Card$2(modifier3, shape3, cardColors2, cardElevation3, borderStroke3, function3, i, i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Card(kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.ui.graphics.Shape r33, androidx.compose.material3.CardColors r34, androidx.compose.material3.CardElevation r35, androidx.compose.foundation.BorderStroke r36, androidx.compose.foundation.interaction.MutableInteractionSource r37, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r9 = r38
            r10 = r40
            r11 = r41
            r0 = -2024281376(0xffffffff8757eae0, float:-1.6243826E-34)
            r1 = r39
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Card)P(7,6,4,8,1,3!1,5)135@6329L5,136@6374L12,137@6432L15,139@6533L39,150@6942L43,142@6630L482:Card.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r10 | 6
            r3 = r2
            r2 = r30
            goto L_0x0032
        L_0x001e:
            r2 = r10 & 6
            if (r2 != 0) goto L_0x002f
            r2 = r30
            boolean r3 = r1.changedInstance(r2)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r10
            goto L_0x0032
        L_0x002f:
            r2 = r30
            r3 = r10
        L_0x0032:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x004c
            r5 = r31
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0048
            r6 = 32
            goto L_0x004a
        L_0x0048:
            r6 = 16
        L_0x004a:
            r3 = r3 | r6
            goto L_0x004e
        L_0x004c:
            r5 = r31
        L_0x004e:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0055
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0068
            r7 = r32
            boolean r8 = r1.changed((boolean) r7)
            if (r8 == 0) goto L_0x0064
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r3 = r3 | r8
            goto L_0x006a
        L_0x0068:
            r7 = r32
        L_0x006a:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0083
            r8 = r11 & 8
            if (r8 != 0) goto L_0x007d
            r8 = r33
            boolean r12 = r1.changed((java.lang.Object) r8)
            if (r12 == 0) goto L_0x007f
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007d:
            r8 = r33
        L_0x007f:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r3 = r3 | r12
            goto L_0x0085
        L_0x0083:
            r8 = r33
        L_0x0085:
            r12 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r12 != 0) goto L_0x009e
            r12 = r11 & 16
            if (r12 != 0) goto L_0x0098
            r12 = r34
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x009a
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x0098:
            r12 = r34
        L_0x009a:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r3 = r3 | r13
            goto L_0x00a0
        L_0x009e:
            r12 = r34
        L_0x00a0:
            r13 = 196608(0x30000, float:2.75506E-40)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00ba
            r13 = r11 & 32
            if (r13 != 0) goto L_0x00b4
            r13 = r35
            boolean r14 = r1.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b6
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b4:
            r13 = r35
        L_0x00b6:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r3 = r3 | r14
            goto L_0x00bc
        L_0x00ba:
            r13 = r35
        L_0x00bc:
            r22 = r11 & 64
            r14 = 1572864(0x180000, float:2.204052E-39)
            if (r22 == 0) goto L_0x00c6
            r3 = r3 | r14
            r15 = r36
            goto L_0x00d7
        L_0x00c6:
            r14 = r14 & r10
            r15 = r36
            if (r14 != 0) goto L_0x00d7
            boolean r14 = r1.changed((java.lang.Object) r15)
            if (r14 == 0) goto L_0x00d4
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r3 = r3 | r14
        L_0x00d7:
            r14 = r11 & 128(0x80, float:1.794E-43)
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            if (r14 == 0) goto L_0x00e2
            r3 = r3 | r16
            r0 = r37
            goto L_0x00f5
        L_0x00e2:
            r16 = r10 & r16
            r0 = r37
            if (r16 != 0) goto L_0x00f5
            boolean r16 = r1.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x00f1
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x00f1:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f3:
            r3 = r3 | r16
        L_0x00f5:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fe
            r3 = r3 | r16
            goto L_0x010e
        L_0x00fe:
            r0 = r10 & r16
            if (r0 != 0) goto L_0x010e
            boolean r0 = r1.changedInstance(r9)
            if (r0 == 0) goto L_0x010b
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010d
        L_0x010b:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010d:
            r3 = r3 | r0
        L_0x010e:
            r0 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r0 & r3
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x012b
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x011e
            goto L_0x012b
        L_0x011e:
            r1.skipToGroupEnd()
            r2 = r5
            r3 = r7
            r4 = r8
            r5 = r12
            r6 = r13
            r7 = r15
            r8 = r37
            goto L_0x025b
        L_0x012b:
            r1.startDefaults()
            r0 = r10 & 1
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r15 = 6
            r17 = r14
            r14 = 1
            if (r0 == 0) goto L_0x0161
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0143
            goto L_0x0161
        L_0x0143:
            r1.skipToGroupEnd()
            r0 = r11 & 8
            if (r0 == 0) goto L_0x014c
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014c:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0152
            r3 = r3 & r16
        L_0x0152:
            r0 = r11 & 32
            if (r0 == 0) goto L_0x0157
            r3 = r3 & r2
        L_0x0157:
            r2 = r36
            r0 = r12
            r6 = r13
            r4 = r15
        L_0x015c:
            r12 = r3
            r3 = r37
            goto L_0x01df
        L_0x0161:
            if (r4 == 0) goto L_0x0168
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0168:
            if (r6 == 0) goto L_0x016b
            r7 = r14
        L_0x016b:
            r0 = r11 & 8
            if (r0 == 0) goto L_0x0178
            androidx.compose.material3.CardDefaults r0 = androidx.compose.material3.CardDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r0 = r0.getShape(r1, r15)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r8 = r0
        L_0x0178:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0185
            androidx.compose.material3.CardDefaults r0 = androidx.compose.material3.CardDefaults.INSTANCE
            androidx.compose.material3.CardColors r0 = r0.cardColors(r1, r15)
            r3 = r3 & r16
            goto L_0x0186
        L_0x0185:
            r0 = r12
        L_0x0186:
            r4 = r11 & 32
            if (r4 == 0) goto L_0x01ab
            androidx.compose.material3.CardDefaults r12 = androidx.compose.material3.CardDefaults.INSTANCE
            r20 = 1572864(0x180000, float:2.204052E-39)
            r21 = 63
            r13 = 0
            r4 = 0
            r6 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r24 = r17
            r14 = r4
            r4 = r15
            r15 = r6
            r17 = r18
            r18 = r19
            r19 = r1
            androidx.compose.material3.CardElevation r6 = r12.m1574cardElevationaqJV_2Y(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r2 = r2 & r3
            r3 = r2
            goto L_0x01af
        L_0x01ab:
            r4 = r15
            r24 = r17
            r6 = r13
        L_0x01af:
            if (r22 == 0) goto L_0x01b3
            r2 = 0
            goto L_0x01b5
        L_0x01b3:
            r2 = r36
        L_0x01b5:
            if (r24 == 0) goto L_0x015c
            r12 = 63758450(0x3cce072, float:1.20415725E-36)
            r1.startReplaceableGroup(r12)
            java.lang.String r12 = "CC(remember):Card.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r12)
            java.lang.Object r12 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r12 != r13) goto L_0x01d5
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r12)
        L_0x01d5:
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = (androidx.compose.foundation.interaction.MutableInteractionSource) r12
            r1.endReplaceableGroup()
            r29 = r12
            r12 = r3
            r3 = r29
        L_0x01df:
            r1.endDefaults()
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x01f1
            r13 = -1
            java.lang.String r14 = "androidx.compose.material3.Card (Card.kt:141)"
            r15 = -2024281376(0xffffffff8757eae0, float:-1.6243826E-34)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r12, r13, r14)
        L_0x01f1:
            long r16 = r0.m1566containerColorvNxB06k$material3_release(r7)
            long r18 = r0.m1567contentColorvNxB06k$material3_release(r7)
            float r20 = r6.m1579tonalElevationu2uoSUM$material3_release(r7)
            r13 = r3
            androidx.compose.foundation.interaction.InteractionSource r13 = (androidx.compose.foundation.interaction.InteractionSource) r13
            int r14 = r12 >> 6
            r14 = r14 & 14
            int r15 = r12 >> 18
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            int r15 = r12 >> 9
            r15 = r15 & 896(0x380, float:1.256E-42)
            r14 = r14 | r15
            androidx.compose.runtime.State r13 = r6.shadowElevation$material3_release(r7, r13, r1, r14)
            java.lang.Object r13 = r13.getValue()
            androidx.compose.ui.unit.Dp r13 = (androidx.compose.ui.unit.Dp) r13
            float r21 = r13.m6628unboximpl()
            androidx.compose.material3.CardKt$Card$4 r13 = new androidx.compose.material3.CardKt$Card$4
            r13.<init>(r9)
            r14 = 776921067(0x2e4edfeb, float:4.7037856E-11)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r13 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r14, r15, r13)
            r24 = r13
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            r13 = r12 & 8190(0x1ffe, float:1.1477E-41)
            int r4 = r12 << 6
            r12 = 234881024(0xe000000, float:1.5777218E-30)
            r12 = r12 & r4
            r12 = r12 | r13
            r13 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r13
            r26 = r12 | r4
            r27 = 6
            r28 = 0
            r12 = r30
            r13 = r5
            r14 = r7
            r15 = r8
            r22 = r2
            r23 = r3
            r25 = r1
            androidx.compose.material3.SurfaceKt.m2306Surfaceo_FOJdg(r12, r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0255
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0255:
            r4 = r8
            r8 = r3
            r3 = r7
            r7 = r2
            r2 = r5
            r5 = r0
        L_0x025b:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x0274
            androidx.compose.material3.CardKt$Card$5 r13 = new androidx.compose.material3.CardKt$Card$5
            r0 = r13
            r1 = r30
            r9 = r38
            r10 = r40
            r11 = r41
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0274:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.Card(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.CardColors, androidx.compose.material3.CardElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ElevatedCard(androidx.compose.ui.Modifier r19, androidx.compose.ui.graphics.Shape r20, androidx.compose.material3.CardColors r21, androidx.compose.material3.CardElevation r22, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r6 = r25
            r0 = 895940201(0x3566f669, float:8.604025E-7)
            r1 = r24
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ElevatedCard)P(3,4!1,2)185@8559L13,186@8612L20,187@8678L23,189@8755L140:Card.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r26 & 1
            if (r2 == 0) goto L_0x001a
            r3 = r6 | 6
            r4 = r3
            r3 = r19
            goto L_0x002e
        L_0x001a:
            r3 = r6 & 6
            if (r3 != 0) goto L_0x002b
            r3 = r19
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = 2
        L_0x0029:
            r4 = r4 | r6
            goto L_0x002e
        L_0x002b:
            r3 = r19
            r4 = r6
        L_0x002e:
            r5 = r6 & 48
            if (r5 != 0) goto L_0x0047
            r5 = r26 & 2
            if (r5 != 0) goto L_0x0041
            r5 = r20
            boolean r7 = r1.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x0043
            r7 = 32
            goto L_0x0045
        L_0x0041:
            r5 = r20
        L_0x0043:
            r7 = 16
        L_0x0045:
            r4 = r4 | r7
            goto L_0x0049
        L_0x0047:
            r5 = r20
        L_0x0049:
            r7 = r6 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0062
            r7 = r26 & 4
            if (r7 != 0) goto L_0x005c
            r7 = r21
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005e
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005c:
            r7 = r21
        L_0x005e:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r4 = r4 | r8
            goto L_0x0064
        L_0x0062:
            r7 = r21
        L_0x0064:
            r8 = r6 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x007d
            r8 = r26 & 8
            if (r8 != 0) goto L_0x0077
            r8 = r22
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0079
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0077:
            r8 = r22
        L_0x0079:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r4 = r4 | r9
            goto L_0x007f
        L_0x007d:
            r8 = r22
        L_0x007f:
            r9 = r26 & 16
            if (r9 == 0) goto L_0x0088
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            r15 = r23
            goto L_0x009a
        L_0x0088:
            r9 = r6 & 24576(0x6000, float:3.4438E-41)
            r15 = r23
            if (r9 != 0) goto L_0x009a
            boolean r9 = r1.changedInstance(r15)
            if (r9 == 0) goto L_0x0097
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r4 = r4 | r9
        L_0x009a:
            r9 = r4 & 9363(0x2493, float:1.312E-41)
            r10 = 9362(0x2492, float:1.3119E-41)
            if (r9 != r10) goto L_0x00b0
            boolean r9 = r1.getSkipping()
            if (r9 != 0) goto L_0x00a7
            goto L_0x00b0
        L_0x00a7:
            r1.skipToGroupEnd()
            r2 = r3
            r3 = r5
            r5 = r7
            r4 = r8
            goto L_0x0157
        L_0x00b0:
            r1.startDefaults()
            r9 = r6 & 1
            if (r9 == 0) goto L_0x00d7
            boolean r9 = r1.getDefaultsInvalid()
            if (r9 == 0) goto L_0x00be
            goto L_0x00d7
        L_0x00be:
            r1.skipToGroupEnd()
            r2 = r26 & 2
            if (r2 == 0) goto L_0x00c7
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00c7:
            r2 = r26 & 4
            if (r2 == 0) goto L_0x00cd
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00cd:
            r2 = r26 & 8
            if (r2 == 0) goto L_0x00d3
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00d3:
            r2 = r3
            r3 = r5
            r5 = r7
            goto L_0x011d
        L_0x00d7:
            if (r2 == 0) goto L_0x00de
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00df
        L_0x00de:
            r2 = r3
        L_0x00df:
            r3 = r26 & 2
            r9 = 6
            if (r3 == 0) goto L_0x00ed
            androidx.compose.material3.CardDefaults r3 = androidx.compose.material3.CardDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r3 = r3.getElevatedShape(r1, r9)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x00ee
        L_0x00ed:
            r3 = r5
        L_0x00ee:
            r5 = r26 & 4
            if (r5 == 0) goto L_0x00fb
            androidx.compose.material3.CardDefaults r5 = androidx.compose.material3.CardDefaults.INSTANCE
            androidx.compose.material3.CardColors r5 = r5.elevatedCardColors(r1, r9)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00fc
        L_0x00fb:
            r5 = r7
        L_0x00fc:
            r7 = r26 & 8
            if (r7 == 0) goto L_0x011d
            androidx.compose.material3.CardDefaults r7 = androidx.compose.material3.CardDefaults.INSTANCE
            r16 = 1572864(0x180000, float:2.204052E-39)
            r17 = 63
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = r1
            r15 = r16
            r16 = r17
            androidx.compose.material3.CardElevation r7 = r7.m1576elevatedCardElevationaqJV_2Y(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            r18 = r7
            r7 = r4
            r4 = r18
            goto L_0x011f
        L_0x011d:
            r7 = r4
            r4 = r8
        L_0x011f:
            r1.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x012e
            r8 = -1
            java.lang.String r9 = "androidx.compose.material3.ElevatedCard (Card.kt:189)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r8, r9)
        L_0x012e:
            r0 = r7 & 14
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r8 = r7 & 112(0x70, float:1.57E-43)
            r0 = r0 | r8
            r8 = r7 & 896(0x380, float:1.256E-42)
            r0 = r0 | r8
            r8 = r7 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r8
            int r7 = r7 << 3
            r8 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r8
            r14 = r0 | r7
            r15 = 0
            r11 = 0
            r7 = r2
            r8 = r3
            r9 = r5
            r10 = r4
            r12 = r23
            r13 = r1
            Card(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0157
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0157:
            androidx.compose.runtime.ScopeUpdateScope r8 = r1.endRestartGroup()
            if (r8 == 0) goto L_0x0171
            androidx.compose.material3.CardKt$ElevatedCard$1 r9 = new androidx.compose.material3.CardKt$ElevatedCard$1
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r5
            r5 = r23
            r6 = r25
            r7 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0171:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.ElevatedCard(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.CardColors, androidx.compose.material3.CardElevation, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ElevatedCard(kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.ui.Modifier r25, boolean r26, androidx.compose.ui.graphics.Shape r27, androidx.compose.material3.CardColors r28, androidx.compose.material3.CardElevation r29, androidx.compose.foundation.interaction.MutableInteractionSource r30, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r9 = r33
            r10 = r34
            r0 = -1850977784(0xffffffff91ac5208, float:-2.718737E-28)
            r1 = r32
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(ElevatedCard)P(6,5,3,7!1,2,4)233@10876L13,234@10929L20,235@10995L23,236@11070L39,238@11163L229:Card.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r10 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r9 | 6
            r3 = r2
            r2 = r24
            goto L_0x0030
        L_0x001c:
            r2 = r9 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r24
            boolean r3 = r1.changedInstance(r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r9
            goto L_0x0030
        L_0x002d:
            r2 = r24
            r3 = r9
        L_0x0030:
            r4 = r10 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r9 & 48
            if (r5 != 0) goto L_0x004a
            r5 = r25
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r25
        L_0x004c:
            r6 = r10 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r7 = r9 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0066
            r7 = r26
            boolean r8 = r1.changed((boolean) r7)
            if (r8 == 0) goto L_0x0062
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r8
            goto L_0x0068
        L_0x0066:
            r7 = r26
        L_0x0068:
            r8 = r9 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0081
            r8 = r10 & 8
            if (r8 != 0) goto L_0x007b
            r8 = r27
            boolean r11 = r1.changed((java.lang.Object) r8)
            if (r11 == 0) goto L_0x007d
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007b:
            r8 = r27
        L_0x007d:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r3 = r3 | r11
            goto L_0x0083
        L_0x0081:
            r8 = r27
        L_0x0083:
            r11 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r11 != 0) goto L_0x009c
            r11 = r10 & 16
            if (r11 != 0) goto L_0x0096
            r11 = r28
            boolean r12 = r1.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0098
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0096:
            r11 = r28
        L_0x0098:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r3 = r3 | r12
            goto L_0x009e
        L_0x009c:
            r11 = r28
        L_0x009e:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r9
            if (r12 != 0) goto L_0x00b8
            r12 = r10 & 32
            if (r12 != 0) goto L_0x00b2
            r12 = r29
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b4
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b2:
            r12 = r29
        L_0x00b4:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r3 = r3 | r13
            goto L_0x00ba
        L_0x00b8:
            r12 = r29
        L_0x00ba:
            r21 = r10 & 64
            r22 = 1572864(0x180000, float:2.204052E-39)
            if (r21 == 0) goto L_0x00c5
            r3 = r3 | r22
            r15 = r30
            goto L_0x00d7
        L_0x00c5:
            r13 = r9 & r22
            r15 = r30
            if (r13 != 0) goto L_0x00d7
            boolean r13 = r1.changed((java.lang.Object) r15)
            if (r13 == 0) goto L_0x00d4
            r13 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r13 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r3 = r3 | r13
        L_0x00d7:
            r13 = r10 & 128(0x80, float:1.794E-43)
            r14 = 12582912(0xc00000, float:1.7632415E-38)
            if (r13 == 0) goto L_0x00e1
            r3 = r3 | r14
            r14 = r31
            goto L_0x00f3
        L_0x00e1:
            r13 = r9 & r14
            r14 = r31
            if (r13 != 0) goto L_0x00f3
            boolean r13 = r1.changedInstance(r14)
            if (r13 == 0) goto L_0x00f0
            r13 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00f0:
            r13 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r3 = r3 | r13
        L_0x00f3:
            r13 = 4793491(0x492493, float:6.717112E-39)
            r13 = r13 & r3
            r0 = 4793490(0x492492, float:6.71711E-39)
            if (r13 != r0) goto L_0x010c
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0103
            goto L_0x010c
        L_0x0103:
            r1.skipToGroupEnd()
            r3 = r7
            r4 = r8
            r6 = r12
            r7 = r15
            goto L_0x01fd
        L_0x010c:
            r1.startDefaults()
            r0 = r9 & 1
            r23 = -458753(0xfffffffffff8ffff, float:NaN)
            r13 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x013a
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0120
            goto L_0x013a
        L_0x0120:
            r1.skipToGroupEnd()
            r0 = r10 & 8
            if (r0 == 0) goto L_0x0129
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0129:
            r0 = r10 & 16
            if (r0 == 0) goto L_0x012e
            r3 = r3 & r13
        L_0x012e:
            r0 = r10 & 32
            if (r0 == 0) goto L_0x0134
            r3 = r3 & r23
        L_0x0134:
            r6 = r3
            r0 = r11
            r3 = r12
            r4 = r15
            goto L_0x01a7
        L_0x013a:
            if (r4 == 0) goto L_0x0141
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x0141:
            if (r6 == 0) goto L_0x0145
            r0 = 1
            r7 = r0
        L_0x0145:
            r0 = r10 & 8
            r4 = 6
            if (r0 == 0) goto L_0x0153
            androidx.compose.material3.CardDefaults r0 = androidx.compose.material3.CardDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r0 = r0.getElevatedShape(r1, r4)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r8 = r0
        L_0x0153:
            r0 = r10 & 16
            if (r0 == 0) goto L_0x015f
            androidx.compose.material3.CardDefaults r0 = androidx.compose.material3.CardDefaults.INSTANCE
            androidx.compose.material3.CardColors r0 = r0.elevatedCardColors(r1, r4)
            r3 = r3 & r13
            goto L_0x0160
        L_0x015f:
            r0 = r11
        L_0x0160:
            r4 = r10 & 32
            if (r4 == 0) goto L_0x017d
            androidx.compose.material3.CardDefaults r11 = androidx.compose.material3.CardDefaults.INSTANCE
            r19 = 1572864(0x180000, float:2.204052E-39)
            r20 = 63
            r12 = 0
            r13 = 0
            r4 = 0
            r6 = 0
            r16 = 0
            r17 = 0
            r14 = r4
            r15 = r6
            r18 = r1
            androidx.compose.material3.CardElevation r4 = r11.m1576elevatedCardElevationaqJV_2Y(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r3 = r3 & r23
            r12 = r4
        L_0x017d:
            if (r21 == 0) goto L_0x01a3
            r4 = 1166350241(0x458517a1, float:4258.9536)
            r1.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Card.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r4)
            java.lang.Object r4 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r4 != r6) goto L_0x019d
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r4)
        L_0x019d:
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            r1.endReplaceableGroup()
            goto L_0x01a5
        L_0x01a3:
            r4 = r30
        L_0x01a5:
            r6 = r3
            r3 = r12
        L_0x01a7:
            r1.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x01b9
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.ElevatedCard (Card.kt:238)"
            r13 = -1850977784(0xffffffff91ac5208, float:-2.718737E-28)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r6, r11, r12)
        L_0x01b9:
            r11 = r6 & 14
            r11 = r11 | r22
            r12 = r6 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            r12 = r6 & 896(0x380, float:1.256E-42)
            r11 = r11 | r12
            r12 = r6 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r6
            r11 = r11 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r6
            r11 = r11 | r12
            int r6 = r6 << 3
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r12 = r12 & r6
            r11 = r11 | r12
            r12 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r12
            r21 = r11 | r6
            r22 = 0
            r17 = 0
            r11 = r24
            r12 = r5
            r13 = r7
            r14 = r8
            r15 = r0
            r16 = r3
            r18 = r4
            r19 = r31
            r20 = r1
            Card(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x01f8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01f8:
            r11 = r0
            r6 = r3
            r3 = r7
            r7 = r4
            r4 = r8
        L_0x01fd:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x0218
            androidx.compose.material3.CardKt$ElevatedCard$3 r13 = new androidx.compose.material3.CardKt$ElevatedCard$3
            r0 = r13
            r1 = r24
            r2 = r5
            r5 = r11
            r8 = r31
            r9 = r33
            r10 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0218:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.ElevatedCard(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.CardColors, androidx.compose.material3.CardElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void OutlinedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        BorderStroke borderStroke2;
        CardColors cardColors3;
        CardElevation cardElevation3;
        Shape shape3;
        Modifier modifier3;
        BorderStroke borderStroke3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        Composer startRestartGroup = composer.startRestartGroup(740336179);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedCard)P(4,5,1,3)278@12927L13,279@12980L20,280@13046L23,281@13111L20,283@13185L142:Card.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i7 | 6;
            modifier2 = modifier;
        } else if ((i7 & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i7;
        } else {
            modifier2 = modifier;
            i3 = i7;
        }
        if ((i7 & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed((Object) shape2)) {
                    i6 = 32;
                    i3 |= i6;
                }
            } else {
                shape2 = shape;
            }
            i6 = 16;
            i3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((i7 & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                if (startRestartGroup.changed((Object) cardColors2)) {
                    i5 = 256;
                    i3 |= i5;
                }
            } else {
                cardColors2 = cardColors;
            }
            i5 = 128;
            i3 |= i5;
        } else {
            cardColors2 = cardColors;
        }
        if ((i7 & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                if (startRestartGroup.changed((Object) cardElevation2)) {
                    i4 = 2048;
                    i3 |= i4;
                }
            } else {
                cardElevation2 = cardElevation;
            }
            i4 = 1024;
            i3 |= i4;
        } else {
            cardElevation2 = cardElevation;
        }
        if ((i7 & CpioConstants.C_ISBLK) == 0) {
            borderStroke2 = borderStroke;
            i3 |= ((i2 & 16) != 0 || !startRestartGroup.changed((Object) borderStroke2)) ? 8192 : 16384;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        } else {
            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function3;
            if ((i7 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= startRestartGroup.changedInstance(function33) ? 131072 : 65536;
            }
        }
        if ((74899 & i3) != 74898 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i7 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                modifier3 = i8 != 0 ? Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    shape3 = CardDefaults.INSTANCE.getOutlinedShape(startRestartGroup, 6);
                    i3 &= -113;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColors3 = CardDefaults.INSTANCE.outlinedCardColors(startRestartGroup, 6);
                    i3 &= -897;
                } else {
                    cardColors3 = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    cardElevation2 = CardDefaults.INSTANCE.m1578outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                }
                if ((i2 & 16) != 0) {
                    borderStroke3 = CardDefaults.INSTANCE.outlinedCardBorder(false, startRestartGroup, 48, 1);
                    i3 &= -57345;
                } else {
                    borderStroke3 = borderStroke;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
                modifier3 = modifier2;
                shape3 = shape2;
                cardColors3 = cardColors2;
                borderStroke3 = borderStroke2;
            }
            CardElevation cardElevation4 = cardElevation2;
            int i9 = i3;
            cardElevation3 = cardElevation4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(740336179, i9, -1, "androidx.compose.material3.OutlinedCard (Card.kt:283)");
            }
            Card(modifier3, shape3, cardColors3, cardElevation3, borderStroke3, function3, startRestartGroup, i9 & 524286, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            borderStroke2 = borderStroke3;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
            cardColors3 = cardColors2;
            cardElevation3 = cardElevation2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CardKt$OutlinedCard$1(modifier3, shape3, cardColors3, cardElevation3, borderStroke2, function3, i, i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedCard(kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.ui.Modifier r25, boolean r26, androidx.compose.ui.graphics.Shape r27, androidx.compose.material3.CardColors r28, androidx.compose.material3.CardElevation r29, androidx.compose.foundation.BorderStroke r30, androidx.compose.foundation.interaction.MutableInteractionSource r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r10 = r34
            r11 = r35
            r0 = -727137250(0xffffffffd4a8c41e, float:-5.7987584E12)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(OutlinedCard)P(7,6,4,8,1,3!1,5)328@15398L13,329@15451L20,330@15517L23,331@15582L27,332@15661L39,334@15754L231:Card.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r11 & 1
            if (r2 == 0) goto L_0x001c
            r2 = r10 | 6
            r3 = r2
            r2 = r24
            goto L_0x0030
        L_0x001c:
            r2 = r10 & 6
            if (r2 != 0) goto L_0x002d
            r2 = r24
            boolean r3 = r1.changedInstance(r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r10
            goto L_0x0030
        L_0x002d:
            r2 = r24
            r3 = r10
        L_0x0030:
            r4 = r11 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r10 & 48
            if (r5 != 0) goto L_0x004a
            r5 = r25
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r25
        L_0x004c:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0053
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r7 = r10 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L_0x0066
            r7 = r26
            boolean r8 = r1.changed((boolean) r7)
            if (r8 == 0) goto L_0x0062
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r3 = r3 | r8
            goto L_0x0068
        L_0x0066:
            r7 = r26
        L_0x0068:
            r8 = r10 & 3072(0xc00, float:4.305E-42)
            if (r8 != 0) goto L_0x0081
            r8 = r11 & 8
            if (r8 != 0) goto L_0x007b
            r8 = r27
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007b:
            r8 = r27
        L_0x007d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r3 = r3 | r9
            goto L_0x0083
        L_0x0081:
            r8 = r27
        L_0x0083:
            r9 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x009c
            r9 = r11 & 16
            if (r9 != 0) goto L_0x0096
            r9 = r28
            boolean r12 = r1.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x0098
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0096:
            r9 = r28
        L_0x0098:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r3 = r3 | r12
            goto L_0x009e
        L_0x009c:
            r9 = r28
        L_0x009e:
            r12 = 196608(0x30000, float:2.75506E-40)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x00b8
            r12 = r11 & 32
            if (r12 != 0) goto L_0x00b2
            r12 = r29
            boolean r13 = r1.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b4
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b2:
            r12 = r29
        L_0x00b4:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r3 = r3 | r13
            goto L_0x00ba
        L_0x00b8:
            r12 = r29
        L_0x00ba:
            r13 = 1572864(0x180000, float:2.204052E-39)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00d2
            r13 = r11 & 64
            r15 = r30
            if (r13 != 0) goto L_0x00ce
            boolean r13 = r1.changed((java.lang.Object) r15)
            if (r13 == 0) goto L_0x00ce
            r13 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d0
        L_0x00ce:
            r13 = 524288(0x80000, float:7.34684E-40)
        L_0x00d0:
            r3 = r3 | r13
            goto L_0x00d4
        L_0x00d2:
            r15 = r30
        L_0x00d4:
            r14 = r11 & 128(0x80, float:1.794E-43)
            r13 = 12582912(0xc00000, float:1.7632415E-38)
            if (r14 == 0) goto L_0x00dc
            r3 = r3 | r13
            goto L_0x00ef
        L_0x00dc:
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00ef
            r13 = r31
            boolean r16 = r1.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x00ea
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ec
        L_0x00ea:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ec:
            r3 = r3 | r16
            goto L_0x00f1
        L_0x00ef:
            r13 = r31
        L_0x00f1:
            r0 = r11 & 256(0x100, float:3.59E-43)
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x00fa
            r3 = r3 | r16
            goto L_0x010e
        L_0x00fa:
            r0 = r10 & r16
            if (r0 != 0) goto L_0x010e
            r0 = r32
            boolean r16 = r1.changedInstance(r0)
            if (r16 == 0) goto L_0x0109
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x010b
        L_0x0109:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x010b:
            r3 = r3 | r16
            goto L_0x0110
        L_0x010e:
            r0 = r32
        L_0x0110:
            r16 = 38347923(0x2492493, float:1.4777644E-37)
            r0 = r3 & r16
            r2 = 38347922(0x2492492, float:1.4777643E-37)
            if (r0 != r2) goto L_0x012d
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0121
            goto L_0x012d
        L_0x0121:
            r1.skipToGroupEnd()
            r2 = r5
            r3 = r7
            r4 = r8
            r5 = r9
            r6 = r12
            r8 = r13
            r7 = r15
            goto L_0x0226
        L_0x012d:
            r1.startDefaults()
            r0 = r10 & 1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r23 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x0163
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0144
            goto L_0x0163
        L_0x0144:
            r1.skipToGroupEnd()
            r0 = r11 & 8
            if (r0 == 0) goto L_0x014d
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014d:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0153
            r3 = r3 & r16
        L_0x0153:
            r0 = r11 & 32
            if (r0 == 0) goto L_0x0159
            r3 = r3 & r23
        L_0x0159:
            r0 = r11 & 64
            if (r0 == 0) goto L_0x015e
            r3 = r3 & r2
        L_0x015e:
            r4 = r12
            r0 = r13
            r6 = r15
            goto L_0x01e9
        L_0x0163:
            if (r4 == 0) goto L_0x016a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = r0
        L_0x016a:
            if (r6 == 0) goto L_0x016e
            r0 = 1
            r7 = r0
        L_0x016e:
            r0 = r11 & 8
            r4 = 6
            if (r0 == 0) goto L_0x017c
            androidx.compose.material3.CardDefaults r0 = androidx.compose.material3.CardDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r0 = r0.getOutlinedShape(r1, r4)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r8 = r0
        L_0x017c:
            r0 = r11 & 16
            if (r0 == 0) goto L_0x0189
            androidx.compose.material3.CardDefaults r0 = androidx.compose.material3.CardDefaults.INSTANCE
            androidx.compose.material3.CardColors r0 = r0.outlinedCardColors(r1, r4)
            r3 = r3 & r16
            r9 = r0
        L_0x0189:
            r0 = r11 & 32
            if (r0 == 0) goto L_0x01a9
            androidx.compose.material3.CardDefaults r12 = androidx.compose.material3.CardDefaults.INSTANCE
            r20 = 1572864(0x180000, float:2.204052E-39)
            r21 = 63
            r0 = 0
            r4 = 0
            r6 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r13 = r0
            r0 = r14
            r14 = r4
            r15 = r6
            r19 = r1
            androidx.compose.material3.CardElevation r4 = r12.m1578outlinedCardElevationaqJV_2Y(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r3 = r3 & r23
            goto L_0x01ab
        L_0x01a9:
            r0 = r14
            r4 = r12
        L_0x01ab:
            r6 = r11 & 64
            if (r6 == 0) goto L_0x01bf
            androidx.compose.material3.CardDefaults r6 = androidx.compose.material3.CardDefaults.INSTANCE
            int r12 = r3 >> 6
            r12 = r12 & 14
            r12 = r12 | 48
            r13 = 0
            androidx.compose.foundation.BorderStroke r6 = r6.outlinedCardBorder(r7, r1, r12, r13)
            r2 = r2 & r3
            r3 = r2
            goto L_0x01c1
        L_0x01bf:
            r6 = r30
        L_0x01c1:
            if (r0 == 0) goto L_0x01e7
            r0 = 1028043736(0x3d46b3d8, float:0.048511356)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Card.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            java.lang.Object r0 = r1.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x01e1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r1.updateRememberedValue(r0)
        L_0x01e1:
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r1.endReplaceableGroup()
            goto L_0x01e9
        L_0x01e7:
            r0 = r31
        L_0x01e9:
            r1.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01fb
            r2 = -1
            java.lang.String r12 = "androidx.compose.material3.OutlinedCard (Card.kt:334)"
            r13 = -727137250(0xffffffffd4a8c41e, float:-5.7987584E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r3, r2, r12)
        L_0x01fb:
            r2 = 268435454(0xffffffe, float:2.5243546E-29)
            r22 = r3 & r2
            r23 = 0
            r12 = r24
            r13 = r5
            r14 = r7
            r15 = r8
            r16 = r9
            r17 = r4
            r18 = r6
            r19 = r0
            r20 = r32
            r21 = r1
            Card(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x021f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x021f:
            r2 = r5
            r3 = r7
            r5 = r9
            r7 = r6
            r6 = r4
            r4 = r8
            r8 = r0
        L_0x0226:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 == 0) goto L_0x023f
            androidx.compose.material3.CardKt$OutlinedCard$3 r13 = new androidx.compose.material3.CardKt$OutlinedCard$3
            r0 = r13
            r1 = r24
            r9 = r32
            r10 = r34
            r11 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x023f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.OutlinedCard(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.CardColors, androidx.compose.material3.CardElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
