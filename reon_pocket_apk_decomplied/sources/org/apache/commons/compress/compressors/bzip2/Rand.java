package org.apache.commons.compress.compressors.bzip2;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.runtime.ComposerKt;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.amazonaws.services.s3.internal.Constants;
import jp.co.sony.reonpocket.modules.main.presenter.MainPresenterKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.archivers.zip.UnixStat;

final class Rand {
    private static final int[] RNUMS = {619, 720, WorkQueueKt.MASK, 481, 931, 816, 813, 233, 566, 247, 985, 724, 205, 454, 863, 491, 741, 242, 949, 214, 733, 859, 335, 708, 621, 574, 73, 654, 730, 472, 419, 436, 278, 496, 867, 210, 399, 680, MainPresenterKt.EIGHT_HOURS_IN_MINUTES, 51, 878, 465, 811, 169, 869, 675, 611, 697, 867, 561, 862, 687, 507, DfuBaseService.NOTIFICATION_ID, 482, 129, 807, 591, 733, 623, 150, 238, 59, 379, 684, 877, 625, 169, 643, 105, 170, 607, 520, 932, 727, 476, 693, 425, 174, 647, 73, 122, 335, 530, 442, 853, 695, 249, 445, 515, 909, 545, 703, 919, 874, 474, 882, 500, 594, 612, 641, 801, 220, 162, 819, 984, 589, InputDeviceCompat.SOURCE_DPAD, 495, 799, 161, 604, 958, 533, 221, 400, 386, 867, 600, 782, 382, 596, 414, 171, 516, 375, 682, 485, 911, 276, 98, 553, 163, 354, 666, 933, 424, 341, 533, 870, 227, 730, 475, 186, TarConstants.VERSION_OFFSET, 647, 537, 686, 600, 224, 469, 68, 770, 919, 190, 373, 294, 822, 808, ComposerKt.referenceKey, 184, 943, 795, 384, 383, 461, Constants.NO_SUCH_BUCKET_STATUS_CODE, 758, 839, 887, 715, 67, 618, 276, ComposerKt.providerMapsKey, 918, 873, 777, 604, 560, 951, 160, 578, 722, 79, 804, 96, 409, 713, 940, 652, 934, 970, 447, 318, 353, 859, 672, 112, 785, 645, 863, 803, 350, 139, 93, 354, 99, 820, 908, 609, 772, 154, 274, 580, 184, 79, 626, 630, 742, 653, 282, 762, 623, 680, 81, 927, 626, 789, 125, 411, 521, 938, AnimationConstants.DefaultDurationMillis, 821, 78, 343, 175, 128, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 170, 774, 972, 275, 999, 639, 495, 78, 352, 126, 857, 956, 358, 619, 580, 124, 737, 594, 701, 612, 669, 112, 134, 694, 363, 992, 809, 743, 168, 974, 944, 375, 748, 52, 600, 747, 642, 182, 862, 81, 344, 805, 988, 739, 511, 655, 814, 334, 249, 515, 897, 955, 664, 981, 649, 113, 974, 459, 893, 228, 433, 837, 553, 268, 926, 240, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 654, 459, 51, 686, 754, 806, 760, UnixStat.DEFAULT_DIR_PERM, Constants.BUCKET_ACCESS_FORBIDDEN_STATUS_CODE, 415, 394, 687, 700, 946, 670, 656, 610, 738, 392, 760, 799, 887, 653, 978, 321, 576, 617, 626, 502, 894, 679, 243, 440, 680, 879, 194, 572, 640, 724, 926, 56, ComposerKt.providerMapsKey, 700, 707, 151, 457, 449, 797, 195, 791, 558, 945, 679, 297, 59, 87, 824, 713, 663, Constants.FAILED_PRECONDITION_STATUS_CODE, 693, 342, 606, 134, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 571, 364, 631, 212, 174, 643, 304, 329, 343, 97, 430, 751, 497, 314, 983, 374, 822, 928, 140, ComposerKt.referenceKey, 73, TarConstants.VERSION_OFFSET, 980, 736, 876, 478, 430, 305, 170, 514, 364, 692, 829, 82, 855, 953, 676, 246, 369, 970, 294, 750, 807, 827, 150, 790, 288, 923, 804, 378, 215, 828, 592, 281, 565, 555, 710, 82, 896, 831, 547, 261, 524, 462, 293, 465, 502, 56, 661, 821, 976, 991, 658, 869, 905, 758, 745, 193, 768, 550, 608, 933, 378, 286, 215, 979, 792, 961, 61, 688, 793, 644, 986, Constants.BUCKET_ACCESS_FORBIDDEN_STATUS_CODE, 106, 366, 905, 644, 372, 567, 466, 434, 645, 210, 389, 550, 919, 135, 780, 773, 635, 389, 707, 100, 626, 958, 165, TarConstants.SPARSELEN_GNU_SPARSE, 920, 176, 193, 713, 857, 265, ComposerKt.providerValuesKey, 50, 668, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 645, 990, 626, 197, 510, 357, 358, 850, 858, 364, 936, 638};

    Rand() {
    }

    static int rNums(int i) {
        return RNUMS[i];
    }
}
