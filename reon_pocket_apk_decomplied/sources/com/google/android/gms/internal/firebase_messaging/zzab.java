package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntityKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final class zzab implements ObjectEncoderContext {
    private static final Charset zza = Charset.forName("UTF-8");
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final ObjectEncoder<Map.Entry<Object, Object>> zzi = zzaa.zza;
    private OutputStream zzb;
    private final Map<Class<?>, ObjectEncoder<?>> zzc;
    private final Map<Class<?>, ValueEncoder<?>> zzd;
    private final ObjectEncoder<Object> zze;
    private final zzaf zzf = new zzaf(this);

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(TransferTable.COLUMN_KEY);
        zzv zzv = new zzv();
        zzv.zza(1);
        zzg = builder.withProperty(zzv.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("value");
        zzv zzv2 = new zzv();
        zzv2.zza(2);
        zzh = builder2.withProperty(zzv2.zzb()).build();
    }

    zzab(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.zzb = outputStream;
        this.zzc = map;
        this.zzd = map2;
        this.zze = objectEncoder;
    }

    static final /* synthetic */ void zzg(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(zzg, entry.getKey());
        objectEncoderContext.add(zzh, entry.getValue());
    }

    private final <T> zzab zzh(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) throws IOException {
        long zzi2 = zzi(objectEncoder, t);
        if (z && zzi2 == 0) {
            return this;
        }
        zzn((zzl(fieldDescriptor) << 3) | 2);
        zzo(zzi2);
        objectEncoder.encode(t, this);
        return this;
    }

    private final <T> long zzi(ObjectEncoder<T> objectEncoder, T t) throws IOException {
        OutputStream outputStream;
        zzw zzw = new zzw();
        try {
            outputStream = this.zzb;
            this.zzb = zzw;
            objectEncoder.encode(t, this);
            this.zzb = outputStream;
            long zza2 = zzw.zza();
            zzw.close();
            return zza2;
        } catch (Throwable th) {
            try {
                zzw.close();
            } catch (Throwable th2) {
                zzt.zza(th, th2);
            }
            throw th;
        }
    }

    private final <T> zzab zzj(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) throws IOException {
        this.zzf.zza(fieldDescriptor, z);
        valueEncoder.encode(t, this.zzf);
        return this;
    }

    private static ByteBuffer zzk(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static int zzl(FieldDescriptor fieldDescriptor) {
        zzz zzz = (zzz) fieldDescriptor.getProperty(zzz.class);
        if (zzz != null) {
            return zzz.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static zzz zzm(FieldDescriptor fieldDescriptor) {
        zzz zzz = (zzz) fieldDescriptor.getProperty(zzz.class);
        if (zzz != null) {
            return zzz;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final void zzn(int i) throws IOException {
        while (((long) (i & DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD)) != 0) {
            this.zzb.write((i & WorkQueueKt.MASK) | 128);
            i >>>= 7;
        }
        this.zzb.write(i & WorkQueueKt.MASK);
    }

    private final void zzo(long j) throws IOException {
        while ((-128 & j) != 0) {
            this.zzb.write((((int) j) & WorkQueueKt.MASK) | 128);
            j >>>= 7;
        }
        this.zzb.write(((int) j) & WorkQueueKt.MASK);
    }

    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d) throws IOException {
        zzb(fieldDescriptor, d, true);
        return this;
    }

    public final ObjectEncoderContext inline(Object obj) throws IOException {
        zzf(obj);
        return this;
    }

    public final ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    /* access modifiers changed from: package-private */
    public final ObjectEncoderContext zza(FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            zzn((zzl(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(zza);
            zzn(bytes.length);
            this.zzb.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object zza2 : (Collection) obj) {
                zza(fieldDescriptor, zza2, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry zzh2 : ((Map) obj).entrySet()) {
                zzh(zzi, fieldDescriptor, zzh2, false);
            }
            return this;
        } else if (obj instanceof Double) {
            zzb(fieldDescriptor, ((Double) obj).doubleValue(), z);
            return this;
        } else if (obj instanceof Float) {
            zzc(fieldDescriptor, ((Float) obj).floatValue(), z);
            return this;
        } else if (obj instanceof Number) {
            zze(fieldDescriptor, ((Number) obj).longValue(), z);
            return this;
        } else if (obj instanceof Boolean) {
            zzd(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return this;
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            zzn((zzl(fieldDescriptor) << 3) | 2);
            zzn(bArr.length);
            this.zzb.write(bArr);
            return this;
        } else {
            ObjectEncoder objectEncoder = this.zzc.get(obj.getClass());
            if (objectEncoder != null) {
                zzh(objectEncoder, fieldDescriptor, obj, z);
                return this;
            }
            ValueEncoder valueEncoder = this.zzd.get(obj.getClass());
            if (valueEncoder != null) {
                zzj(valueEncoder, fieldDescriptor, obj, z);
                return this;
            } else if (obj instanceof zzx) {
                zzd(fieldDescriptor, ((zzx) obj).getNumber(), true);
                return this;
            } else if (obj instanceof Enum) {
                zzd(fieldDescriptor, ((Enum) obj).ordinal(), true);
                return this;
            } else {
                zzh(this.zze, fieldDescriptor, obj, z);
                return this;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final ObjectEncoderContext zzb(FieldDescriptor fieldDescriptor, double d, boolean z) throws IOException {
        if (z && d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return this;
        }
        zzn((zzl(fieldDescriptor) << 3) | 1);
        this.zzb.write(zzk(8).putDouble(d).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public final ObjectEncoderContext zzc(FieldDescriptor fieldDescriptor, float f, boolean z) throws IOException {
        if (z && f == 0.0f) {
            return this;
        }
        zzn((zzl(fieldDescriptor) << 3) | 5);
        this.zzb.write(zzk(4).putFloat(f).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzab zzd(FieldDescriptor fieldDescriptor, int i, boolean z) throws IOException {
        if (z && i == 0) {
            return this;
        }
        zzz zzm = zzm(fieldDescriptor);
        zzy zzy = zzy.DEFAULT;
        int ordinal = zzm.zzb().ordinal();
        if (ordinal == 0) {
            zzn(zzm.zza() << 3);
            zzn(i);
        } else if (ordinal == 1) {
            zzn(zzm.zza() << 3);
            zzn((i + i) ^ (i >> 31));
        } else if (ordinal == 2) {
            zzn((zzm.zza() << 3) | 5);
            this.zzb.write(zzk(4).putInt(i).array());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzab zze(FieldDescriptor fieldDescriptor, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return this;
        }
        zzz zzm = zzm(fieldDescriptor);
        zzy zzy = zzy.DEFAULT;
        int ordinal = zzm.zzb().ordinal();
        if (ordinal == 0) {
            zzn(zzm.zza() << 3);
            zzo(j);
        } else if (ordinal == 1) {
            zzn(zzm.zza() << 3);
            zzo((j >> 63) ^ (j + j));
        } else if (ordinal == 2) {
            zzn((zzm.zza() << 3) | 1);
            this.zzb.write(zzk(8).putLong(j).array());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzab zzf(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = this.zzc.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        String valueOf = String.valueOf(obj.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
        sb.append("No encoder for ");
        sb.append(valueOf);
        throw new EncodingException(sb.toString());
    }

    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f) throws IOException {
        zzc(fieldDescriptor, f, true);
        return this;
    }

    public final ObjectEncoderContext nested(String str) throws IOException {
        return nested(FieldDescriptor.of(str));
    }

    public final /* bridge */ /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException {
        zzd(fieldDescriptor, i, true);
        return this;
    }

    public final /* bridge */ /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        zze(fieldDescriptor, j, true);
        return this;
    }

    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        zza(fieldDescriptor, obj, true);
        return this;
    }

    public final /* bridge */ /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        zzd(fieldDescriptor, z ? 1 : 0, true);
        return this;
    }

    public final ObjectEncoderContext add(String str, double d) throws IOException {
        zzb(FieldDescriptor.of(str), d, true);
        return this;
    }

    public final ObjectEncoderContext add(String str, int i) throws IOException {
        zzd(FieldDescriptor.of(str), i, true);
        return this;
    }

    public final ObjectEncoderContext add(String str, long j) throws IOException {
        zze(FieldDescriptor.of(str), j, true);
        return this;
    }

    public final ObjectEncoderContext add(String str, Object obj) throws IOException {
        zza(FieldDescriptor.of(str), obj, true);
        return this;
    }

    public final ObjectEncoderContext add(String str, boolean z) throws IOException {
        zzd(FieldDescriptor.of(str), z ? 1 : 0, true);
        return this;
    }
}
