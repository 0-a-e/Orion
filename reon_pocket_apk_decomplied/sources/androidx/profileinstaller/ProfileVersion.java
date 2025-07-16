package androidx.profileinstaller;

import java.util.Arrays;
import org.apache.commons.compress.archivers.tar.TarConstants;

public class ProfileVersion {
    public static final int MAX_SUPPORTED_SDK = 34;
    static final byte[] METADATA_V001_N = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_LINK, 0};
    static final byte[] METADATA_V002 = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_SYMLINK, 0};
    public static final int MIN_SUPPORTED_SDK = 24;
    static final byte[] V001_N = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_LINK, 0};
    static final byte[] V005_O = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_DIR, 0};
    static final byte[] V009_O_MR1 = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 57, 0};
    static final byte[] V010_P = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_NORMAL, 0};
    static final byte[] V015_S = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_DIR, 0};

    private ProfileVersion() {
    }

    static String dexKeySeparator(byte[] bArr) {
        if (!Arrays.equals(bArr, V001_N) && !Arrays.equals(bArr, V005_O)) {
            return "!";
        }
        return ":";
    }
}
