package jp.co.sony.reonpocket.util;

import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/util/SecureDataUtil;", "", "()V", "ALGORITHM", "", "KEY_ALGORITHM", "KEY_ALIAS", "KEY_PROVIDER", "KEY_SIZE", "", "LIFE_TIME_END", "SERIAL_NUMBER", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "createKeyStore", "Ljava/security/KeyStore;", "decryptString", "aEncryptedText", "encryptString", "aPlainText", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SecureDataUtil.kt */
public final class SecureDataUtil {
    public static final int $stable = 8;
    private static final String ALGORITHM = "RSA/ECB/PKCS1Padding";
    public static final SecureDataUtil INSTANCE = new SecureDataUtil();
    private static final String KEY_ALGORITHM = "RSA";
    private static final String KEY_ALIAS = "reonpocketkey";
    private static final String KEY_PROVIDER = "AndroidKeyStore";
    private static final int KEY_SIZE = 2048;
    private static final int LIFE_TIME_END = 100;
    private static final BigInteger SERIAL_NUMBER = BigInteger.ONE;

    private SecureDataUtil() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.crypto.CipherOutputStream} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067 A[SYNTHETIC, Splitter:B:21:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006f A[SYNTHETIC, Splitter:B:26:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String encryptString(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "aPlainText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0010
            return r1
        L_0x0010:
            java.security.KeyStore r0 = r5.createKeyStore()
            if (r0 == 0) goto L_0x0078
            java.lang.String r2 = "reonpocketkey"
            java.security.cert.Certificate r0 = r0.getCertificate(r2)     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            java.security.PublicKey r0 = r0.getPublicKey()     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            java.lang.String r2 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            java.security.Key r0 = (java.security.Key) r0     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            r3 = 1
            r2.init(r3, r0)     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            r0.<init>()     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            javax.crypto.CipherOutputStream r3 = new javax.crypto.CipherOutputStream     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            r4 = r0
            java.io.OutputStream r4 = (java.io.OutputStream) r4     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            r3.<init>(r4, r2)     // Catch:{ Exception -> 0x0060, all -> 0x005e }
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x005c }
            byte[] r6 = r6.getBytes(r2)     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)     // Catch:{ Exception -> 0x005c }
            r3.write(r6)     // Catch:{ Exception -> 0x005c }
            r3.close()     // Catch:{ Exception -> 0x005c }
            byte[] r6 = r0.toByteArray()     // Catch:{ Exception -> 0x005c }
            r0 = 0
            java.lang.String r1 = android.util.Base64.encodeToString(r6, r0)     // Catch:{ Exception -> 0x005c }
            r3.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0078
        L_0x0057:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0078
        L_0x005c:
            r6 = move-exception
            goto L_0x0062
        L_0x005e:
            r6 = move-exception
            goto L_0x006d
        L_0x0060:
            r6 = move-exception
            r3 = r1
        L_0x0062:
            r6.printStackTrace()     // Catch:{ all -> 0x006b }
            if (r3 == 0) goto L_0x0078
            r3.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0078
        L_0x006b:
            r6 = move-exception
            r1 = r3
        L_0x006d:
            if (r1 == 0) goto L_0x0077
            r1.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0077:
            throw r6
        L_0x0078:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.util.SecureDataUtil.encryptString(java.lang.String):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A[SYNTHETIC, Splitter:B:30:0x0075] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String decryptString(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "aEncryptedText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = r6
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0010
            return r1
        L_0x0010:
            java.security.KeyStore r0 = r5.createKeyStore()
            if (r0 == 0) goto L_0x007e
            java.lang.String r2 = "reonpocketkey"
            java.security.Key r0 = r0.getKey(r2, r1)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.lang.String r2 = "null cannot be cast to non-null type java.security.PrivateKey"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r2)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.security.PrivateKey r0 = (java.security.PrivateKey) r0     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.lang.String r2 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.security.Key r0 = (java.security.Key) r0     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r3 = 2
            r2.init(r3, r0)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            javax.crypto.CipherInputStream r0 = new javax.crypto.CipherInputStream     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r4 = 0
            byte[] r6 = android.util.Base64.decode(r6, r4)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r0.<init>(r3, r2)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r6.<init>()     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
        L_0x0045:
            int r2 = r0.read()     // Catch:{ Exception -> 0x0062 }
            r3 = -1
            if (r2 != r3) goto L_0x005e
            r6.close()     // Catch:{ Exception -> 0x0062 }
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = r6.toString(r0)     // Catch:{ Exception -> 0x0062 }
            r6.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x007e
        L_0x0059:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x007e
        L_0x005e:
            r6.write(r2)     // Catch:{ Exception -> 0x0062 }
            goto L_0x0045
        L_0x0062:
            r0 = move-exception
            goto L_0x0068
        L_0x0064:
            r0 = move-exception
            goto L_0x0073
        L_0x0066:
            r0 = move-exception
            r6 = r1
        L_0x0068:
            r0.printStackTrace()     // Catch:{ all -> 0x0071 }
            if (r6 == 0) goto L_0x007e
            r6.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x007e
        L_0x0071:
            r0 = move-exception
            r1 = r6
        L_0x0073:
            if (r1 == 0) goto L_0x007d
            r1.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r6 = move-exception
            r6.printStackTrace()
        L_0x007d:
            throw r0
        L_0x007e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.util.SecureDataUtil.decryptString(java.lang.String):java.lang.String");
    }

    private final KeyStore createKeyStore() {
        KeyStore keyStore = null;
        try {
            KeyStore instance = KeyStore.getInstance(KEY_PROVIDER);
            try {
                instance.load((KeyStore.LoadStoreParameter) null);
                if (instance.containsAlias(KEY_ALIAS)) {
                    return instance;
                }
                KeyPairGenerator instance2 = KeyPairGenerator.getInstance(KEY_ALGORITHM, KEY_PROVIDER);
                Calendar instance3 = Calendar.getInstance();
                instance3.add(1, 100);
                KeyGenParameterSpec.Builder encryptionPaddings = new KeyGenParameterSpec.Builder(KEY_ALIAS, 3).setEncryptionPaddings(new String[]{"PKCS1Padding"});
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("CN=%s", Arrays.copyOf(new Object[]{KEY_ALIAS}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                instance2.initialize(encryptionPaddings.setCertificateSubject(new X500Principal(format)).setCertificateSerialNumber(SERIAL_NUMBER).setKeyValidityStart(Calendar.getInstance().getTime()).setKeyValidityEnd(instance3.getTime()).setKeySize(2048).build());
                instance2.generateKeyPair();
                return instance;
            } catch (Exception e) {
                e = e;
                keyStore = instance;
                e.printStackTrace();
                return keyStore;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return keyStore;
        }
    }
}
