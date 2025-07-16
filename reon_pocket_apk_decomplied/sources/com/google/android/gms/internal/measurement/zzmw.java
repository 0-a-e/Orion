package com.google.android.gms.internal.measurement;

import jp.co.sony.reonpocket.modules.main.presenter.MainPresenterKt;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzmw {
    private static final zzmt zza = new zzmu();

    static {
        if (zzmr.zza() && zzmr.zzb()) {
            int i = zziq.zza;
        }
    }

    public static boolean zza(byte[] bArr) {
        return zza.zza(bArr, 0, bArr.length);
    }

    public static boolean zzb(byte[] bArr, int i, int i2) {
        return zza.zza(bArr, i, i2);
    }

    static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new zzmv(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zzd(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char charAt;
        int length = charSequence.length();
        int i5 = i2 + i;
        int i6 = 0;
        while (i6 < length && (i4 = i6 + i) < i5 && (charAt = charSequence.charAt(i6)) < 128) {
            bArr[i4] = (byte) charAt;
            i6++;
        }
        if (i6 == length) {
            return i + length;
        }
        int i7 = i + i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 < 128 && i7 < i5) {
                bArr[i7] = (byte) charAt2;
                i7++;
            } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                i7 += 2;
                bArr[i8] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || charAt2 > 57343) && i7 <= i5 - 3) {
                bArr[i7] = (byte) ((charAt2 >>> 12) | MainPresenterKt.EIGHT_HOURS_IN_MINUTES);
                int i9 = i7 + 2;
                bArr[i7 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i7 += 3;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
            } else if (i7 <= i5 - 4) {
                int i10 = i6 + 1;
                if (i10 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i10);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                        bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i11 = i7 + 3;
                        bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i7 += 4;
                        bArr[i11] = (byte) ((codePoint & 63) | 128);
                        i6 = i10;
                    } else {
                        i6 = i10;
                    }
                }
                throw new zzmv(i6 - 1, length);
            } else if (charAt2 < 55296 || charAt2 > 57343 || ((i3 = i6 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(i7);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            } else {
                throw new zzmv(i6, length);
            }
            i6++;
        }
        return i7;
    }

    static String zze(byte[] bArr, int i, int i2) throws zzkn {
        int i3;
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (r10 < i4) {
                byte b = bArr[r10];
                if (!zzms.zza(b)) {
                    break;
                }
                i = r10 + 1;
                cArr[i3] = (char) b;
                i5 = i3 + 1;
            }
            while (r10 < i4) {
                int i6 = r10 + 1;
                byte b2 = bArr[r10];
                if (zzms.zza(b2)) {
                    cArr[i3] = (char) b2;
                    i3++;
                    r10 = i6;
                    while (r10 < i4) {
                        byte b3 = bArr[r10];
                        if (!zzms.zza(b3)) {
                            break;
                        }
                        r10++;
                        cArr[i3] = (char) b3;
                        i3++;
                    }
                } else if (b2 < -32) {
                    if (i6 < i4) {
                        r10 += 2;
                        zzms.zzb(b2, bArr[i6], cArr, i3);
                        i3++;
                    } else {
                        throw zzkn.zzf();
                    }
                } else if (b2 < -16) {
                    if (i6 < i4 - 1) {
                        int i7 = r10 + 2;
                        r10 += 3;
                        zzms.zzc(b2, bArr[i6], bArr[i7], cArr, i3);
                        i3++;
                    } else {
                        throw zzkn.zzf();
                    }
                } else if (i6 < i4 - 2) {
                    int i8 = r10 + 2;
                    int i9 = r10 + 3;
                    r10 += 4;
                    zzms.zzd(b2, bArr[i6], bArr[i8], bArr[i9], cArr, i3);
                    i3 += 2;
                } else {
                    throw zzkn.zzf();
                }
            }
            return new String(cArr, 0, i3);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    static /* synthetic */ int zzf(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == 1) {
                byte b2 = bArr[i];
                if (b <= -12 && b2 <= -65) {
                    return b ^ (b2 << 8);
                }
            } else if (i3 == 2) {
                byte b3 = bArr[i];
                byte b4 = bArr[i + 1];
                if (b <= -12 && b3 <= -65 && b4 <= -65) {
                    return ((b3 << 8) ^ b) ^ (b4 << 16);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b <= -12) {
            return b;
        }
        return -1;
    }
}
