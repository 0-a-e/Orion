package org.altbeacon.beacon.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UrlBeaconUrlCompressor {
    private static final byte EDDYSTONE_URL_BIZ = 12;
    private static final byte EDDYSTONE_URL_BIZ_SLASH = 5;
    private static final byte EDDYSTONE_URL_COM = 7;
    private static final byte EDDYSTONE_URL_COM_SLASH = 0;
    private static final byte EDDYSTONE_URL_EDU = 9;
    private static final byte EDDYSTONE_URL_EDU_SLASH = 2;
    private static final int EDDYSTONE_URL_FQDN_GROUP = 3;
    private static final byte EDDYSTONE_URL_GOV = 13;
    private static final byte EDDYSTONE_URL_GOV_SLASH = 6;
    private static final byte EDDYSTONE_URL_INFO = 11;
    private static final byte EDDYSTONE_URL_INFO_SLASH = 4;
    private static final byte EDDYSTONE_URL_NET = 10;
    private static final byte EDDYSTONE_URL_NET_SLASH = 3;
    private static final byte EDDYSTONE_URL_ORG = 8;
    private static final byte EDDYSTONE_URL_ORG_SLASH = 1;
    private static final int EDDYSTONE_URL_PATH_GROUP = 5;
    private static final int EDDYSTONE_URL_PROTOCOL_GROUP = 1;
    private static final byte EDDYSTONE_URL_PROTOCOL_HTTP = 2;
    private static final byte EDDYSTONE_URL_PROTOCOL_HTTPS = 3;
    private static final byte EDDYSTONE_URL_PROTOCOL_HTTPS_WWW = 1;
    private static final byte EDDYSTONE_URL_PROTOCOL_HTTP_WWW = 0;
    private static final String EDDYSTONE_URL_REGEX = "^((?i)http|https):\\/\\/((?i)www\\.)?((?:[0-9a-zA-Z_-]+\\.?)+)(/?)([./0-9a-zA-Z_-]*)";
    private static final int EDDYSTONE_URL_SLASH_GROUP = 4;
    private static final int EDDYSTONE_URL_WWW_GROUP = 2;
    private static final byte TLD_NOT_ENCODABLE = -1;
    private static final String URL_HOST_WWW = "www.";
    private static final String URL_PROTOCOL_HTTP = "http";
    private static final String URL_PROTOCOL_HTTPS_COLON_SLASH_SLASH = "https://";
    private static final String URL_PROTOCOL_HTTPS_WWW_DOT = "https://www.";
    private static final String URL_PROTOCOL_HTTP_COLON_SLASH_SLASH = "http://";
    private static final String URL_PROTOCOL_HTTP_WWW_DOT = "http://www.";
    private static final String URL_TLD_DOT_BIZ = ".biz";
    private static final String URL_TLD_DOT_BIZ_SLASH = ".biz/";
    private static final String URL_TLD_DOT_COM = ".com";
    private static final String URL_TLD_DOT_COM_SLASH = ".com/";
    private static final String URL_TLD_DOT_EDU = ".edu";
    private static final String URL_TLD_DOT_EDU_SLASH = ".edu/";
    private static final String URL_TLD_DOT_GOV = ".gov";
    private static final String URL_TLD_DOT_GOV_SLASH = ".gov/";
    private static final String URL_TLD_DOT_INFO = ".info";
    private static final String URL_TLD_DOT_INFO_SLASH = ".info/";
    private static final String URL_TLD_DOT_NET = ".net";
    private static final String URL_TLD_DOT_NET_SLASH = ".net/";
    private static final String URL_TLD_DOT_ORG = ".org";
    private static final String URL_TLD_DOT_ORG_SLASH = ".org/";
    private static List<TLDMapEntry> tldMap;

    private static class TLDMapEntry {
        public final byte encodedByte;
        public final String tld;

        public TLDMapEntry(String str, byte b) {
            this.tld = str;
            this.encodedByte = b;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        tldMap = arrayList;
        arrayList.add(new TLDMapEntry(URL_TLD_DOT_COM_SLASH, (byte) 0));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_ORG_SLASH, (byte) 1));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_EDU_SLASH, (byte) 2));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_NET_SLASH, (byte) 3));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_INFO_SLASH, (byte) 4));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_BIZ_SLASH, EDDYSTONE_URL_BIZ_SLASH));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_GOV_SLASH, EDDYSTONE_URL_GOV_SLASH));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_COM, EDDYSTONE_URL_COM));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_ORG, EDDYSTONE_URL_ORG));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_EDU, EDDYSTONE_URL_EDU));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_NET, EDDYSTONE_URL_NET));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_INFO, EDDYSTONE_URL_INFO));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_BIZ, EDDYSTONE_URL_BIZ));
        tldMap.add(new TLDMapEntry(URL_TLD_DOT_GOV, EDDYSTONE_URL_GOV));
    }

    private static byte encodedByteForTopLevelDomain(String str) {
        Iterator<TLDMapEntry> it = tldMap.iterator();
        byte b = -1;
        boolean z = false;
        while (!z && it.hasNext()) {
            TLDMapEntry next = it.next();
            boolean equalsIgnoreCase = next.tld.equalsIgnoreCase(str);
            if (equalsIgnoreCase) {
                b = next.encodedByte;
            }
            z = equalsIgnoreCase;
        }
        return b;
    }

    private static String topLevelDomainForByte(Byte b) {
        Iterator<TLDMapEntry> it = tldMap.iterator();
        String str = null;
        boolean z = false;
        while (!z && it.hasNext()) {
            TLDMapEntry next = it.next();
            boolean z2 = next.encodedByte == b.byteValue();
            if (z2) {
                str = next.tld;
            }
            z = z2;
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00be, code lost:
        if (r3 != null) goto L_0x00d1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] compress(java.lang.String r12) throws java.net.MalformedURLException {
        /*
            if (r12 == 0) goto L_0x0104
            int r0 = r12.length()
            byte[] r0 = new byte[r0]
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            java.lang.String r2 = "^((?i)http|https):\\/\\/((?i)www\\.)?((?:[0-9a-zA-Z_-]+\\.?)+)(/?)([./0-9a-zA-Z_-]*)"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.util.regex.Matcher r12 = r2.matcher(r12)
            boolean r2 = r12.matches()
            if (r2 == 0) goto L_0x00fe
            r2 = 2
            java.lang.String r3 = r12.group(r2)
            r4 = 1
            if (r3 == 0) goto L_0x0026
            r3 = r4
            goto L_0x0027
        L_0x0026:
            r3 = r1
        L_0x0027:
            java.lang.String r5 = r12.group(r4)
            java.lang.String r5 = r5.toLowerCase()
            java.lang.String r6 = "http"
            boolean r5 = r5.equalsIgnoreCase(r6)
            r6 = 3
            if (r5 == 0) goto L_0x003e
            if (r3 == 0) goto L_0x003b
            r2 = r1
        L_0x003b:
            r0[r1] = r2
            goto L_0x0045
        L_0x003e:
            if (r3 == 0) goto L_0x0042
            r2 = r4
            goto L_0x0043
        L_0x0042:
            r2 = r6
        L_0x0043:
            r0[r1] = r2
        L_0x0045:
            java.lang.String r2 = r12.group(r6)
            byte[] r2 = r2.getBytes()
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            java.lang.String r2 = r3.toLowerCase()
            java.lang.String r3 = "."
            java.lang.String r5 = java.util.regex.Pattern.quote(r3)
            java.lang.String[] r2 = r2.split(r5)
            r5 = 4
            if (r2 == 0) goto L_0x00cf
            byte[] r6 = new byte[r4]
            r7 = 46
            r6[r1] = r7
            int r7 = r2.length
            if (r7 != r4) goto L_0x006e
            r7 = r4
            goto L_0x0070
        L_0x006e:
            int r7 = r2.length
            int r7 = r7 - r4
        L_0x0070:
            r8 = r1
            r9 = r4
        L_0x0072:
            if (r8 >= r7) goto L_0x0089
            if (r8 <= 0) goto L_0x007b
            java.lang.System.arraycopy(r6, r1, r0, r9, r4)
            int r9 = r9 + 1
        L_0x007b:
            r10 = r2[r8]
            byte[] r10 = r10.getBytes()
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r1, r0, r9, r11)
            int r9 = r9 + r11
            int r8 = r8 + 1
            goto L_0x0072
        L_0x0089:
            int r6 = r2.length
            if (r6 <= r4) goto L_0x00cc
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            int r3 = r2.length
            int r3 = r3 - r4
            r2 = r2[r3]
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            java.lang.String r3 = r12.group(r5)
            if (r3 != 0) goto L_0x00a4
            r6 = r2
            goto L_0x00b3
        L_0x00a4:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
        L_0x00b3:
            byte r6 = encodedByteForTopLevelDomain(r6)
            r7 = -1
            if (r6 == r7) goto L_0x00c1
            int r2 = r9 + 1
            r0[r9] = r6
            if (r3 == 0) goto L_0x00d0
            goto L_0x00d1
        L_0x00c1:
            byte[] r2 = r2.getBytes()
            int r3 = r2.length
            java.lang.System.arraycopy(r2, r1, r0, r9, r3)
            int r4 = r9 + r3
            goto L_0x00cf
        L_0x00cc:
            r4 = r1
            r2 = r9
            goto L_0x00d1
        L_0x00cf:
            r2 = r4
        L_0x00d0:
            r4 = r1
        L_0x00d1:
            if (r4 != 0) goto L_0x00e5
            java.lang.String r3 = r12.group(r5)
            if (r3 == 0) goto L_0x00e5
            int r4 = r3.length()
            byte[] r3 = r3.getBytes()
            java.lang.System.arraycopy(r3, r1, r0, r2, r4)
            int r2 = r2 + r4
        L_0x00e5:
            r3 = 5
            java.lang.String r12 = r12.group(r3)
            if (r12 == 0) goto L_0x00f8
            int r3 = r12.length()
            byte[] r12 = r12.getBytes()
            java.lang.System.arraycopy(r12, r1, r0, r2, r3)
            int r2 = r2 + r3
        L_0x00f8:
            byte[] r12 = new byte[r2]
            java.lang.System.arraycopy(r0, r1, r12, r1, r2)
            return r12
        L_0x00fe:
            java.net.MalformedURLException r12 = new java.net.MalformedURLException
            r12.<init>()
            throw r12
        L_0x0104:
            java.net.MalformedURLException r12 = new java.net.MalformedURLException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.utils.UrlBeaconUrlCompressor.compress(java.lang.String):byte[]");
    }

    public static String uncompress(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        byte b = bArr[0] & 15;
        int i = 1;
        if (b == 0) {
            stringBuffer.append(URL_PROTOCOL_HTTP_WWW_DOT);
        } else if (b == 1) {
            stringBuffer.append(URL_PROTOCOL_HTTPS_WWW_DOT);
        } else if (b == 2) {
            stringBuffer.append(URL_PROTOCOL_HTTP_COLON_SLASH_SLASH);
        } else if (b == 3) {
            stringBuffer.append(URL_PROTOCOL_HTTPS_COLON_SLASH_SLASH);
        }
        byte b2 = -1;
        while (i < bArr.length) {
            byte b3 = bArr[i];
            if (b2 == 0 && b3 == 0) {
                break;
            }
            String str = topLevelDomainForByte(Byte.valueOf(b3));
            if (str != null) {
                stringBuffer.append(str);
            } else {
                stringBuffer.append((char) b3);
            }
            i++;
            b2 = b3;
        }
        return stringBuffer.toString();
    }
}
