package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bï\u0001\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003¢\u0006\u0002\u0010 B¥\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0002\u0010(J·\u0002\u0010ñ\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0006\bò\u0001\u0010ó\u0001Jû\u0002\u0010ñ\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0006\bô\u0001\u0010õ\u0001J\n\u0010ö\u0001\u001a\u00030÷\u0001H\u0016R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010A\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010/\"\u0004\bU\u00101R\u001c\u0010V\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00105\"\u0004\bX\u00107R\u001c\u0010Y\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010;\"\u0004\b[\u0010=R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010b\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010/\"\u0004\bd\u00101R\u001c\u0010e\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00105\"\u0004\bg\u00107R\u001c\u0010h\u001a\u0004\u0018\u00010]X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010_\"\u0004\bj\u0010aR\u001c\u0010k\u001a\u0004\u0018\u00010lX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001c\u0010q\u001a\u0004\u0018\u00010]X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010_\"\u0004\bs\u0010aR\"\u0010t\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bu\u0010A\u001a\u0004\bv\u0010C\"\u0004\bw\u0010ER\"\u0010x\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\by\u0010A\u001a\u0004\bz\u0010C\"\u0004\b{\u0010ER\u001e\u0010|\u001a\u0004\u0018\u00010}X\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u00105\"\u0005\b\u0001\u00107R\u001f\u0010\u0001\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010;\"\u0005\b\u0001\u0010=R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R)\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001X\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b¢\u0001\u0010A\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R)\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001X\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b©\u0001\u0010A\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010­\u0001R\"\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R\u001f\u0010´\u0001\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010/\"\u0005\b¶\u0001\u00101R\"\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u001f\u0010½\u0001\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0001\u00105\"\u0005\b¿\u0001\u00107R\"\u0010À\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÁ\u0001\u0010\u0001\"\u0006\bÂ\u0001\u0010\u0001R)\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001X\u000e¢\u0006\u0019\n\u0000\u0012\u0005\bÅ\u0001\u0010A\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R&\u0010Ê\u0001\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0017\n\u0000\u0012\u0005\bË\u0001\u0010A\u001a\u0005\bÌ\u0001\u0010C\"\u0005\bÍ\u0001\u0010ER\u001a\u0010\u0019\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÎ\u0001\u0010*R\u001a\u0010\u001b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÏ\u0001\u0010*R\u001a\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÐ\u0001\u0010*R\u001a\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÑ\u0001\u0010*R\u001a\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÒ\u0001\u0010*R\u001a\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÓ\u0001\u0010*R\u001a\u0010\u001a\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÔ\u0001\u0010*R\u001a\u0010\u001c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÕ\u0001\u0010*R\u001a\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÖ\u0001\u0010*R\u001a\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\b×\u0001\u0010*R\u001a\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bØ\u0001\u0010*R\u001a\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÙ\u0001\u0010*R\u001a\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÚ\u0001\u0010*R\u001a\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÛ\u0001\u0010*R\u001a\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÜ\u0001\u0010*R\u001a\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÝ\u0001\u0010*R\u001a\u0010\u001d\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bÞ\u0001\u0010*R\u001a\u0010\u001e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bß\u0001\u0010*R\u001a\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bà\u0001\u0010*R\u001a\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bá\u0001\u0010*R\u001a\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bâ\u0001\u0010*R\u001a\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bã\u0001\u0010*R\u001a\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bä\u0001\u0010*R\u001a\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bå\u0001\u0010*R\u001a\u0010!\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bæ\u0001\u0010*R\u001a\u0010#\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bç\u0001\u0010*R\u001a\u0010$\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bè\u0001\u0010*R\u001a\u0010%\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bé\u0001\u0010*R\u001a\u0010&\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bê\u0001\u0010*R\u001a\u0010'\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bë\u0001\u0010*R\u001a\u0010\"\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bì\u0001\u0010*R\u001a\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bí\u0001\u0010*R\u001a\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bî\u0001\u0010*R\u001a\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bï\u0001\u0010*R\u001a\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\bð\u0001\u0010*\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006ø\u0001"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "surfaceBright", "surfaceDim", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackground-0d7_KjU", "()J", "J", "defaultAssistChipColorsCached", "Landroidx/compose/material3/ChipColors;", "getDefaultAssistChipColorsCached$material3_release", "()Landroidx/compose/material3/ChipColors;", "setDefaultAssistChipColorsCached$material3_release", "(Landroidx/compose/material3/ChipColors;)V", "defaultButtonColorsCached", "Landroidx/compose/material3/ButtonColors;", "getDefaultButtonColorsCached$material3_release", "()Landroidx/compose/material3/ButtonColors;", "setDefaultButtonColorsCached$material3_release", "(Landroidx/compose/material3/ButtonColors;)V", "defaultCardColorsCached", "Landroidx/compose/material3/CardColors;", "getDefaultCardColorsCached$material3_release", "()Landroidx/compose/material3/CardColors;", "setDefaultCardColorsCached$material3_release", "(Landroidx/compose/material3/CardColors;)V", "defaultCenterAlignedTopAppBarColorsCached", "Landroidx/compose/material3/TopAppBarColors;", "getDefaultCenterAlignedTopAppBarColorsCached$material3_release$annotations", "()V", "getDefaultCenterAlignedTopAppBarColorsCached$material3_release", "()Landroidx/compose/material3/TopAppBarColors;", "setDefaultCenterAlignedTopAppBarColorsCached$material3_release", "(Landroidx/compose/material3/TopAppBarColors;)V", "defaultCheckboxColorsCached", "Landroidx/compose/material3/CheckboxColors;", "getDefaultCheckboxColorsCached$material3_release", "()Landroidx/compose/material3/CheckboxColors;", "setDefaultCheckboxColorsCached$material3_release", "(Landroidx/compose/material3/CheckboxColors;)V", "defaultDatePickerColorsCached", "Landroidx/compose/material3/DatePickerColors;", "getDefaultDatePickerColorsCached$material3_release$annotations", "getDefaultDatePickerColorsCached$material3_release", "()Landroidx/compose/material3/DatePickerColors;", "setDefaultDatePickerColorsCached$material3_release", "(Landroidx/compose/material3/DatePickerColors;)V", "defaultElevatedAssistChipColorsCached", "getDefaultElevatedAssistChipColorsCached$material3_release", "setDefaultElevatedAssistChipColorsCached$material3_release", "defaultElevatedButtonColorsCached", "getDefaultElevatedButtonColorsCached$material3_release", "setDefaultElevatedButtonColorsCached$material3_release", "defaultElevatedCardColorsCached", "getDefaultElevatedCardColorsCached$material3_release", "setDefaultElevatedCardColorsCached$material3_release", "defaultElevatedFilterChipColorsCached", "Landroidx/compose/material3/SelectableChipColors;", "getDefaultElevatedFilterChipColorsCached$material3_release", "()Landroidx/compose/material3/SelectableChipColors;", "setDefaultElevatedFilterChipColorsCached$material3_release", "(Landroidx/compose/material3/SelectableChipColors;)V", "defaultElevatedSuggestionChipColorsCached", "getDefaultElevatedSuggestionChipColorsCached$material3_release", "setDefaultElevatedSuggestionChipColorsCached$material3_release", "defaultFilledTonalButtonColorsCached", "getDefaultFilledTonalButtonColorsCached$material3_release", "setDefaultFilledTonalButtonColorsCached$material3_release", "defaultFilterChipColorsCached", "getDefaultFilterChipColorsCached$material3_release", "setDefaultFilterChipColorsCached$material3_release", "defaultIconButtonColorsCached", "Landroidx/compose/material3/IconButtonColors;", "getDefaultIconButtonColorsCached$material3_release", "()Landroidx/compose/material3/IconButtonColors;", "setDefaultIconButtonColorsCached$material3_release", "(Landroidx/compose/material3/IconButtonColors;)V", "defaultInputChipColorsCached", "getDefaultInputChipColorsCached$material3_release", "setDefaultInputChipColorsCached$material3_release", "defaultLargeTopAppBarColorsCached", "getDefaultLargeTopAppBarColorsCached$material3_release$annotations", "getDefaultLargeTopAppBarColorsCached$material3_release", "setDefaultLargeTopAppBarColorsCached$material3_release", "defaultMediumTopAppBarColorsCached", "getDefaultMediumTopAppBarColorsCached$material3_release$annotations", "getDefaultMediumTopAppBarColorsCached$material3_release", "setDefaultMediumTopAppBarColorsCached$material3_release", "defaultMenuItemColorsCached", "Landroidx/compose/material3/MenuItemColors;", "getDefaultMenuItemColorsCached$material3_release", "()Landroidx/compose/material3/MenuItemColors;", "setDefaultMenuItemColorsCached$material3_release", "(Landroidx/compose/material3/MenuItemColors;)V", "defaultNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationBarItemColors;", "getDefaultNavigationBarItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationBarItemColors;", "setDefaultNavigationBarItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationBarItemColors;)V", "defaultNavigationRailItemColorsCached", "Landroidx/compose/material3/NavigationRailItemColors;", "getDefaultNavigationRailItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationRailItemColors;", "setDefaultNavigationRailItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationRailItemColors;)V", "defaultOutlinedButtonColorsCached", "getDefaultOutlinedButtonColorsCached$material3_release", "setDefaultOutlinedButtonColorsCached$material3_release", "defaultOutlinedCardColorsCached", "getDefaultOutlinedCardColorsCached$material3_release", "setDefaultOutlinedCardColorsCached$material3_release", "defaultOutlinedTextFieldColorsCached", "Landroidx/compose/material3/TextFieldColors;", "getDefaultOutlinedTextFieldColorsCached$material3_release", "()Landroidx/compose/material3/TextFieldColors;", "setDefaultOutlinedTextFieldColorsCached$material3_release", "(Landroidx/compose/material3/TextFieldColors;)V", "defaultRadioButtonColorsCached", "Landroidx/compose/material3/RadioButtonColors;", "getDefaultRadioButtonColorsCached$material3_release", "()Landroidx/compose/material3/RadioButtonColors;", "setDefaultRadioButtonColorsCached$material3_release", "(Landroidx/compose/material3/RadioButtonColors;)V", "defaultRichTooltipColorsCached", "Landroidx/compose/material3/RichTooltipColors;", "getDefaultRichTooltipColorsCached$material3_release$annotations", "getDefaultRichTooltipColorsCached$material3_release", "()Landroidx/compose/material3/RichTooltipColors;", "setDefaultRichTooltipColorsCached$material3_release", "(Landroidx/compose/material3/RichTooltipColors;)V", "defaultSegmentedButtonColorsCached", "Landroidx/compose/material3/SegmentedButtonColors;", "getDefaultSegmentedButtonColorsCached$material3_release$annotations", "getDefaultSegmentedButtonColorsCached$material3_release", "()Landroidx/compose/material3/SegmentedButtonColors;", "setDefaultSegmentedButtonColorsCached$material3_release", "(Landroidx/compose/material3/SegmentedButtonColors;)V", "defaultSliderColorsCached", "Landroidx/compose/material3/SliderColors;", "getDefaultSliderColorsCached$material3_release", "()Landroidx/compose/material3/SliderColors;", "setDefaultSliderColorsCached$material3_release", "(Landroidx/compose/material3/SliderColors;)V", "defaultSuggestionChipColorsCached", "getDefaultSuggestionChipColorsCached$material3_release", "setDefaultSuggestionChipColorsCached$material3_release", "defaultSwitchColorsCached", "Landroidx/compose/material3/SwitchColors;", "getDefaultSwitchColorsCached$material3_release", "()Landroidx/compose/material3/SwitchColors;", "setDefaultSwitchColorsCached$material3_release", "(Landroidx/compose/material3/SwitchColors;)V", "defaultTextButtonColorsCached", "getDefaultTextButtonColorsCached$material3_release", "setDefaultTextButtonColorsCached$material3_release", "defaultTextFieldColorsCached", "getDefaultTextFieldColorsCached$material3_release", "setDefaultTextFieldColorsCached$material3_release", "defaultTimePickerColorsCached", "Landroidx/compose/material3/TimePickerColors;", "getDefaultTimePickerColorsCached$material3_release$annotations", "getDefaultTimePickerColorsCached$material3_release", "()Landroidx/compose/material3/TimePickerColors;", "setDefaultTimePickerColorsCached$material3_release", "(Landroidx/compose/material3/TimePickerColors;)V", "defaultTopAppBarColorsCached", "getDefaultTopAppBarColorsCached$material3_release$annotations", "getDefaultTopAppBarColorsCached$material3_release", "setDefaultTopAppBarColorsCached$material3_release", "getError-0d7_KjU", "getErrorContainer-0d7_KjU", "getInverseOnSurface-0d7_KjU", "getInversePrimary-0d7_KjU", "getInverseSurface-0d7_KjU", "getOnBackground-0d7_KjU", "getOnError-0d7_KjU", "getOnErrorContainer-0d7_KjU", "getOnPrimary-0d7_KjU", "getOnPrimaryContainer-0d7_KjU", "getOnSecondary-0d7_KjU", "getOnSecondaryContainer-0d7_KjU", "getOnSurface-0d7_KjU", "getOnSurfaceVariant-0d7_KjU", "getOnTertiary-0d7_KjU", "getOnTertiaryContainer-0d7_KjU", "getOutline-0d7_KjU", "getOutlineVariant-0d7_KjU", "getPrimary-0d7_KjU", "getPrimaryContainer-0d7_KjU", "getScrim-0d7_KjU", "getSecondary-0d7_KjU", "getSecondaryContainer-0d7_KjU", "getSurface-0d7_KjU", "getSurfaceBright-0d7_KjU", "getSurfaceContainer-0d7_KjU", "getSurfaceContainerHigh-0d7_KjU", "getSurfaceContainerHighest-0d7_KjU", "getSurfaceContainerLow-0d7_KjU", "getSurfaceContainerLowest-0d7_KjU", "getSurfaceDim-0d7_KjU", "getSurfaceTint-0d7_KjU", "getSurfaceVariant-0d7_KjU", "getTertiary-0d7_KjU", "getTertiaryContainer-0d7_KjU", "copy", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "copy-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorScheme.kt */
public final class ColorScheme {
    public static final int $stable = 0;
    private final long background;
    private ChipColors defaultAssistChipColorsCached;
    private ButtonColors defaultButtonColorsCached;
    private CardColors defaultCardColorsCached;
    private TopAppBarColors defaultCenterAlignedTopAppBarColorsCached;
    private CheckboxColors defaultCheckboxColorsCached;
    private DatePickerColors defaultDatePickerColorsCached;
    private ChipColors defaultElevatedAssistChipColorsCached;
    private ButtonColors defaultElevatedButtonColorsCached;
    private CardColors defaultElevatedCardColorsCached;
    private SelectableChipColors defaultElevatedFilterChipColorsCached;
    private ChipColors defaultElevatedSuggestionChipColorsCached;
    private ButtonColors defaultFilledTonalButtonColorsCached;
    private SelectableChipColors defaultFilterChipColorsCached;
    private IconButtonColors defaultIconButtonColorsCached;
    private SelectableChipColors defaultInputChipColorsCached;
    private TopAppBarColors defaultLargeTopAppBarColorsCached;
    private TopAppBarColors defaultMediumTopAppBarColorsCached;
    private MenuItemColors defaultMenuItemColorsCached;
    private NavigationBarItemColors defaultNavigationBarItemColorsCached;
    private NavigationRailItemColors defaultNavigationRailItemColorsCached;
    private ButtonColors defaultOutlinedButtonColorsCached;
    private CardColors defaultOutlinedCardColorsCached;
    private TextFieldColors defaultOutlinedTextFieldColorsCached;
    private RadioButtonColors defaultRadioButtonColorsCached;
    private RichTooltipColors defaultRichTooltipColorsCached;
    private SegmentedButtonColors defaultSegmentedButtonColorsCached;
    private SliderColors defaultSliderColorsCached;
    private ChipColors defaultSuggestionChipColorsCached;
    private SwitchColors defaultSwitchColorsCached;
    private ButtonColors defaultTextButtonColorsCached;
    private TextFieldColors defaultTextFieldColorsCached;
    private TimePickerColors defaultTimePickerColorsCached;
    private TopAppBarColors defaultTopAppBarColorsCached;
    private final long error;
    private final long errorContainer;
    private final long inverseOnSurface;
    private final long inversePrimary;
    private final long inverseSurface;
    private final long onBackground;
    private final long onError;
    private final long onErrorContainer;
    private final long onPrimary;
    private final long onPrimaryContainer;
    private final long onSecondary;
    private final long onSecondaryContainer;
    private final long onSurface;
    private final long onSurfaceVariant;
    private final long onTertiary;
    private final long onTertiaryContainer;
    private final long outline;
    private final long outlineVariant;
    private final long primary;
    private final long primaryContainer;
    private final long scrim;
    private final long secondary;
    private final long secondaryContainer;
    private final long surface;
    private final long surfaceBright;
    private final long surfaceContainer;
    private final long surfaceContainerHigh;
    private final long surfaceContainerHighest;
    private final long surfaceContainerLow;
    private final long surfaceContainerLowest;
    private final long surfaceDim;
    private final long surfaceTint;
    private final long surfaceVariant;
    private final long tertiary;
    private final long tertiaryContainer;

    public /* synthetic */ ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36);
    }

    public /* synthetic */ ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29);
    }

    public static /* synthetic */ void getDefaultCenterAlignedTopAppBarColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultDatePickerColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultLargeTopAppBarColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultMediumTopAppBarColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultRichTooltipColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultSegmentedButtonColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultTimePickerColorsCached$material3_release$annotations() {
    }

    public static /* synthetic */ void getDefaultTopAppBarColorsCached$material3_release$annotations() {
    }

    private ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        this.primary = j;
        this.onPrimary = j2;
        this.primaryContainer = j3;
        this.onPrimaryContainer = j4;
        this.inversePrimary = j5;
        this.secondary = j6;
        this.onSecondary = j7;
        this.secondaryContainer = j8;
        this.onSecondaryContainer = j9;
        this.tertiary = j10;
        this.onTertiary = j11;
        this.tertiaryContainer = j12;
        this.onTertiaryContainer = j13;
        this.background = j14;
        this.onBackground = j15;
        this.surface = j16;
        this.onSurface = j17;
        this.surfaceVariant = j18;
        this.onSurfaceVariant = j19;
        this.surfaceTint = j20;
        this.inverseSurface = j21;
        this.inverseOnSurface = j22;
        this.error = j23;
        this.onError = j24;
        this.errorContainer = j25;
        this.onErrorContainer = j26;
        this.outline = j27;
        this.outlineVariant = j28;
        this.scrim = j29;
        this.surfaceBright = j30;
        this.surfaceDim = j31;
        this.surfaceContainer = j32;
        this.surfaceContainerHigh = j33;
        this.surfaceContainerHighest = j34;
        this.surfaceContainerLow = j35;
        this.surfaceContainerLowest = j36;
    }

    /* renamed from: getPrimary-0d7_KjU  reason: not valid java name */
    public final long m1662getPrimary0d7_KjU() {
        return this.primary;
    }

    /* renamed from: getOnPrimary-0d7_KjU  reason: not valid java name */
    public final long m1652getOnPrimary0d7_KjU() {
        return this.onPrimary;
    }

    /* renamed from: getPrimaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1663getPrimaryContainer0d7_KjU() {
        return this.primaryContainer;
    }

    /* renamed from: getOnPrimaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1653getOnPrimaryContainer0d7_KjU() {
        return this.onPrimaryContainer;
    }

    /* renamed from: getInversePrimary-0d7_KjU  reason: not valid java name */
    public final long m1647getInversePrimary0d7_KjU() {
        return this.inversePrimary;
    }

    /* renamed from: getSecondary-0d7_KjU  reason: not valid java name */
    public final long m1665getSecondary0d7_KjU() {
        return this.secondary;
    }

    /* renamed from: getOnSecondary-0d7_KjU  reason: not valid java name */
    public final long m1654getOnSecondary0d7_KjU() {
        return this.onSecondary;
    }

    /* renamed from: getSecondaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1666getSecondaryContainer0d7_KjU() {
        return this.secondaryContainer;
    }

    /* renamed from: getOnSecondaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1655getOnSecondaryContainer0d7_KjU() {
        return this.onSecondaryContainer;
    }

    /* renamed from: getTertiary-0d7_KjU  reason: not valid java name */
    public final long m1677getTertiary0d7_KjU() {
        return this.tertiary;
    }

    /* renamed from: getOnTertiary-0d7_KjU  reason: not valid java name */
    public final long m1658getOnTertiary0d7_KjU() {
        return this.onTertiary;
    }

    /* renamed from: getTertiaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1678getTertiaryContainer0d7_KjU() {
        return this.tertiaryContainer;
    }

    /* renamed from: getOnTertiaryContainer-0d7_KjU  reason: not valid java name */
    public final long m1659getOnTertiaryContainer0d7_KjU() {
        return this.onTertiaryContainer;
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m1643getBackground0d7_KjU() {
        return this.background;
    }

    /* renamed from: getOnBackground-0d7_KjU  reason: not valid java name */
    public final long m1649getOnBackground0d7_KjU() {
        return this.onBackground;
    }

    /* renamed from: getSurface-0d7_KjU  reason: not valid java name */
    public final long m1667getSurface0d7_KjU() {
        return this.surface;
    }

    /* renamed from: getOnSurface-0d7_KjU  reason: not valid java name */
    public final long m1656getOnSurface0d7_KjU() {
        return this.onSurface;
    }

    /* renamed from: getSurfaceVariant-0d7_KjU  reason: not valid java name */
    public final long m1676getSurfaceVariant0d7_KjU() {
        return this.surfaceVariant;
    }

    /* renamed from: getOnSurfaceVariant-0d7_KjU  reason: not valid java name */
    public final long m1657getOnSurfaceVariant0d7_KjU() {
        return this.onSurfaceVariant;
    }

    /* renamed from: getSurfaceTint-0d7_KjU  reason: not valid java name */
    public final long m1675getSurfaceTint0d7_KjU() {
        return this.surfaceTint;
    }

    /* renamed from: getInverseSurface-0d7_KjU  reason: not valid java name */
    public final long m1648getInverseSurface0d7_KjU() {
        return this.inverseSurface;
    }

    /* renamed from: getInverseOnSurface-0d7_KjU  reason: not valid java name */
    public final long m1646getInverseOnSurface0d7_KjU() {
        return this.inverseOnSurface;
    }

    /* renamed from: getError-0d7_KjU  reason: not valid java name */
    public final long m1644getError0d7_KjU() {
        return this.error;
    }

    /* renamed from: getOnError-0d7_KjU  reason: not valid java name */
    public final long m1650getOnError0d7_KjU() {
        return this.onError;
    }

    /* renamed from: getErrorContainer-0d7_KjU  reason: not valid java name */
    public final long m1645getErrorContainer0d7_KjU() {
        return this.errorContainer;
    }

    /* renamed from: getOnErrorContainer-0d7_KjU  reason: not valid java name */
    public final long m1651getOnErrorContainer0d7_KjU() {
        return this.onErrorContainer;
    }

    /* renamed from: getOutline-0d7_KjU  reason: not valid java name */
    public final long m1660getOutline0d7_KjU() {
        return this.outline;
    }

    /* renamed from: getOutlineVariant-0d7_KjU  reason: not valid java name */
    public final long m1661getOutlineVariant0d7_KjU() {
        return this.outlineVariant;
    }

    /* renamed from: getScrim-0d7_KjU  reason: not valid java name */
    public final long m1664getScrim0d7_KjU() {
        return this.scrim;
    }

    /* renamed from: getSurfaceBright-0d7_KjU  reason: not valid java name */
    public final long m1668getSurfaceBright0d7_KjU() {
        return this.surfaceBright;
    }

    /* renamed from: getSurfaceDim-0d7_KjU  reason: not valid java name */
    public final long m1674getSurfaceDim0d7_KjU() {
        return this.surfaceDim;
    }

    /* renamed from: getSurfaceContainer-0d7_KjU  reason: not valid java name */
    public final long m1669getSurfaceContainer0d7_KjU() {
        return this.surfaceContainer;
    }

    /* renamed from: getSurfaceContainerHigh-0d7_KjU  reason: not valid java name */
    public final long m1670getSurfaceContainerHigh0d7_KjU() {
        return this.surfaceContainerHigh;
    }

    /* renamed from: getSurfaceContainerHighest-0d7_KjU  reason: not valid java name */
    public final long m1671getSurfaceContainerHighest0d7_KjU() {
        return this.surfaceContainerHighest;
    }

    /* renamed from: getSurfaceContainerLow-0d7_KjU  reason: not valid java name */
    public final long m1672getSurfaceContainerLow0d7_KjU() {
        return this.surfaceContainerLow;
    }

    /* renamed from: getSurfaceContainerLowest-0d7_KjU  reason: not valid java name */
    public final long m1673getSurfaceContainerLowest0d7_KjU() {
        return this.surfaceContainerLowest;
    }

    private ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, Color.Companion.m3852getUnspecified0d7_KjU(), Color.Companion.m3852getUnspecified0d7_KjU(), Color.Companion.m3852getUnspecified0d7_KjU(), Color.Companion.m3852getUnspecified0d7_KjU(), Color.Companion.m3852getUnspecified0d7_KjU(), Color.Companion.m3852getUnspecified0d7_KjU(), Color.Companion.m3852getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-C-Xl9yA$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1639copyCXl9yA$default(ColorScheme colorScheme, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long j37;
        ColorScheme colorScheme2 = colorScheme;
        int i3 = i;
        long j38 = (i3 & 1) != 0 ? colorScheme2.primary : j;
        long j39 = (i3 & 2) != 0 ? colorScheme2.onPrimary : j2;
        long j40 = (i3 & 4) != 0 ? colorScheme2.primaryContainer : j3;
        long j41 = (i3 & 8) != 0 ? colorScheme2.onPrimaryContainer : j4;
        long j42 = (i3 & 16) != 0 ? colorScheme2.inversePrimary : j5;
        long j43 = (i3 & 32) != 0 ? colorScheme2.secondary : j6;
        long j44 = (i3 & 64) != 0 ? colorScheme2.onSecondary : j7;
        long j45 = (i3 & 128) != 0 ? colorScheme2.secondaryContainer : j8;
        long j46 = (i3 & 256) != 0 ? colorScheme2.onSecondaryContainer : j9;
        long j47 = (i3 & 512) != 0 ? colorScheme2.tertiary : j10;
        long j48 = (i3 & 1024) != 0 ? colorScheme2.onTertiary : j11;
        long j49 = (i3 & 2048) != 0 ? colorScheme2.tertiaryContainer : j12;
        long j50 = (i3 & 4096) != 0 ? colorScheme2.onTertiaryContainer : j13;
        long j51 = (i3 & 8192) != 0 ? colorScheme2.background : j14;
        long j52 = (i3 & 16384) != 0 ? colorScheme2.onBackground : j15;
        long j53 = (i3 & 32768) != 0 ? colorScheme2.surface : j16;
        long j54 = (i3 & 65536) != 0 ? colorScheme2.onSurface : j17;
        long j55 = (i3 & 131072) != 0 ? colorScheme2.surfaceVariant : j18;
        long j56 = (i3 & 262144) != 0 ? colorScheme2.onSurfaceVariant : j19;
        long j57 = (i3 & 524288) != 0 ? colorScheme2.surfaceTint : j20;
        long j58 = (i3 & 1048576) != 0 ? colorScheme2.inverseSurface : j21;
        long j59 = (i3 & 2097152) != 0 ? colorScheme2.inverseOnSurface : j22;
        long j60 = (i3 & 4194304) != 0 ? colorScheme2.error : j23;
        long j61 = (i3 & 8388608) != 0 ? colorScheme2.onError : j24;
        long j62 = (i3 & 16777216) != 0 ? colorScheme2.errorContainer : j25;
        long j63 = (i3 & 33554432) != 0 ? colorScheme2.onErrorContainer : j26;
        long j64 = (i3 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? colorScheme2.outline : j27;
        long j65 = (i3 & 134217728) != 0 ? colorScheme2.outlineVariant : j28;
        long j66 = (i3 & 268435456) != 0 ? colorScheme2.scrim : j29;
        long j67 = (i3 & 536870912) != 0 ? colorScheme2.surfaceBright : j30;
        long j68 = (i3 & 1073741824) != 0 ? colorScheme2.surfaceDim : j31;
        long j69 = (i3 & Integer.MIN_VALUE) != 0 ? colorScheme2.surfaceContainer : j32;
        long j70 = (i2 & 1) != 0 ? colorScheme2.surfaceContainerHigh : j33;
        long j71 = (i2 & 2) != 0 ? colorScheme2.surfaceContainerHighest : j34;
        long j72 = (i2 & 4) != 0 ? colorScheme2.surfaceContainerLow : j35;
        if ((i2 & 8) != 0) {
            j37 = colorScheme2.surfaceContainerLowest;
        } else {
            j37 = j36;
        }
        return colorScheme.m1641copyCXl9yA(j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, j49, j50, j51, j52, j53, j54, j55, j56, j57, j58, j59, j60, j61, j62, j63, j64, j65, j66, j67, j68, j69, j70, j71, j72, j37);
    }

    /* renamed from: copy-C-Xl9yA  reason: not valid java name */
    public final ColorScheme m1641copyCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-G1PFc-w$default  reason: not valid java name */
    public static /* synthetic */ ColorScheme m1640copyG1PFcw$default(ColorScheme colorScheme, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long j30;
        ColorScheme colorScheme2 = colorScheme;
        int i2 = i;
        long j31 = (i2 & 1) != 0 ? colorScheme2.primary : j;
        long j32 = (i2 & 2) != 0 ? colorScheme2.onPrimary : j2;
        long j33 = (i2 & 4) != 0 ? colorScheme2.primaryContainer : j3;
        long j34 = (i2 & 8) != 0 ? colorScheme2.onPrimaryContainer : j4;
        long j35 = (i2 & 16) != 0 ? colorScheme2.inversePrimary : j5;
        long j36 = (i2 & 32) != 0 ? colorScheme2.secondary : j6;
        long j37 = (i2 & 64) != 0 ? colorScheme2.onSecondary : j7;
        long j38 = (i2 & 128) != 0 ? colorScheme2.secondaryContainer : j8;
        long j39 = (i2 & 256) != 0 ? colorScheme2.onSecondaryContainer : j9;
        long j40 = (i2 & 512) != 0 ? colorScheme2.tertiary : j10;
        long j41 = (i2 & 1024) != 0 ? colorScheme2.onTertiary : j11;
        long j42 = (i2 & 2048) != 0 ? colorScheme2.tertiaryContainer : j12;
        long j43 = (i2 & 4096) != 0 ? colorScheme2.onTertiaryContainer : j13;
        long j44 = (i2 & 8192) != 0 ? colorScheme2.background : j14;
        long j45 = (i2 & 16384) != 0 ? colorScheme2.onBackground : j15;
        long j46 = (i2 & 32768) != 0 ? colorScheme2.surface : j16;
        long j47 = (i2 & 65536) != 0 ? colorScheme2.onSurface : j17;
        long j48 = (i2 & 131072) != 0 ? colorScheme2.surfaceVariant : j18;
        long j49 = (i2 & 262144) != 0 ? colorScheme2.onSurfaceVariant : j19;
        long j50 = (i2 & 524288) != 0 ? colorScheme2.surfaceTint : j20;
        long j51 = (i2 & 1048576) != 0 ? colorScheme2.inverseSurface : j21;
        long j52 = (i2 & 2097152) != 0 ? colorScheme2.inverseOnSurface : j22;
        long j53 = (i2 & 4194304) != 0 ? colorScheme2.error : j23;
        long j54 = (i2 & 8388608) != 0 ? colorScheme2.onError : j24;
        long j55 = (i2 & 16777216) != 0 ? colorScheme2.errorContainer : j25;
        long j56 = (i2 & 33554432) != 0 ? colorScheme2.onErrorContainer : j26;
        long j57 = (i2 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? colorScheme2.outline : j27;
        long j58 = (i2 & 134217728) != 0 ? colorScheme2.outlineVariant : j28;
        if ((i2 & 268435456) != 0) {
            j30 = colorScheme2.scrim;
        } else {
            j30 = j29;
        }
        return colorScheme.m1642copyG1PFcw(j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, j49, j50, j51, j52, j53, j54, j55, j56, j57, j58, j30);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    /* renamed from: copy-G1PFc-w  reason: not valid java name */
    public final /* synthetic */ ColorScheme m1642copyG1PFcw(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        return m1639copyCXl9yA$default(this, j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, 0, 0, 0, 0, 0, 0, 0, -536870912, 15, (Object) null);
    }

    public String toString() {
        return "ColorScheme(primary=" + Color.m3824toStringimpl(this.primary) + "onPrimary=" + Color.m3824toStringimpl(this.onPrimary) + "primaryContainer=" + Color.m3824toStringimpl(this.primaryContainer) + "onPrimaryContainer=" + Color.m3824toStringimpl(this.onPrimaryContainer) + "inversePrimary=" + Color.m3824toStringimpl(this.inversePrimary) + "secondary=" + Color.m3824toStringimpl(this.secondary) + "onSecondary=" + Color.m3824toStringimpl(this.onSecondary) + "secondaryContainer=" + Color.m3824toStringimpl(this.secondaryContainer) + "onSecondaryContainer=" + Color.m3824toStringimpl(this.onSecondaryContainer) + "tertiary=" + Color.m3824toStringimpl(this.tertiary) + "onTertiary=" + Color.m3824toStringimpl(this.onTertiary) + "tertiaryContainer=" + Color.m3824toStringimpl(this.tertiaryContainer) + "onTertiaryContainer=" + Color.m3824toStringimpl(this.onTertiaryContainer) + "background=" + Color.m3824toStringimpl(this.background) + "onBackground=" + Color.m3824toStringimpl(this.onBackground) + "surface=" + Color.m3824toStringimpl(this.surface) + "onSurface=" + Color.m3824toStringimpl(this.onSurface) + "surfaceVariant=" + Color.m3824toStringimpl(this.surfaceVariant) + "onSurfaceVariant=" + Color.m3824toStringimpl(this.onSurfaceVariant) + "surfaceTint=" + Color.m3824toStringimpl(this.surfaceTint) + "inverseSurface=" + Color.m3824toStringimpl(this.inverseSurface) + "inverseOnSurface=" + Color.m3824toStringimpl(this.inverseOnSurface) + "error=" + Color.m3824toStringimpl(this.error) + "onError=" + Color.m3824toStringimpl(this.onError) + "errorContainer=" + Color.m3824toStringimpl(this.errorContainer) + "onErrorContainer=" + Color.m3824toStringimpl(this.onErrorContainer) + "outline=" + Color.m3824toStringimpl(this.outline) + "outlineVariant=" + Color.m3824toStringimpl(this.outlineVariant) + "scrim=" + Color.m3824toStringimpl(this.scrim) + "surfaceBright=" + Color.m3824toStringimpl(this.surfaceBright) + "surfaceDim=" + Color.m3824toStringimpl(this.surfaceDim) + "surfaceContainer=" + Color.m3824toStringimpl(this.surfaceContainer) + "surfaceContainerHigh=" + Color.m3824toStringimpl(this.surfaceContainerHigh) + "surfaceContainerHighest=" + Color.m3824toStringimpl(this.surfaceContainerHighest) + "surfaceContainerLow=" + Color.m3824toStringimpl(this.surfaceContainerLow) + "surfaceContainerLowest=" + Color.m3824toStringimpl(this.surfaceContainerLowest) + ')';
    }

    public final ButtonColors getDefaultButtonColorsCached$material3_release() {
        return this.defaultButtonColorsCached;
    }

    public final void setDefaultButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultButtonColorsCached = buttonColors;
    }

    public final ButtonColors getDefaultElevatedButtonColorsCached$material3_release() {
        return this.defaultElevatedButtonColorsCached;
    }

    public final void setDefaultElevatedButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultElevatedButtonColorsCached = buttonColors;
    }

    public final ButtonColors getDefaultFilledTonalButtonColorsCached$material3_release() {
        return this.defaultFilledTonalButtonColorsCached;
    }

    public final void setDefaultFilledTonalButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultFilledTonalButtonColorsCached = buttonColors;
    }

    public final ButtonColors getDefaultOutlinedButtonColorsCached$material3_release() {
        return this.defaultOutlinedButtonColorsCached;
    }

    public final void setDefaultOutlinedButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultOutlinedButtonColorsCached = buttonColors;
    }

    public final ButtonColors getDefaultTextButtonColorsCached$material3_release() {
        return this.defaultTextButtonColorsCached;
    }

    public final void setDefaultTextButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultTextButtonColorsCached = buttonColors;
    }

    public final CardColors getDefaultCardColorsCached$material3_release() {
        return this.defaultCardColorsCached;
    }

    public final void setDefaultCardColorsCached$material3_release(CardColors cardColors) {
        this.defaultCardColorsCached = cardColors;
    }

    public final CardColors getDefaultElevatedCardColorsCached$material3_release() {
        return this.defaultElevatedCardColorsCached;
    }

    public final void setDefaultElevatedCardColorsCached$material3_release(CardColors cardColors) {
        this.defaultElevatedCardColorsCached = cardColors;
    }

    public final CardColors getDefaultOutlinedCardColorsCached$material3_release() {
        return this.defaultOutlinedCardColorsCached;
    }

    public final void setDefaultOutlinedCardColorsCached$material3_release(CardColors cardColors) {
        this.defaultOutlinedCardColorsCached = cardColors;
    }

    public final ChipColors getDefaultAssistChipColorsCached$material3_release() {
        return this.defaultAssistChipColorsCached;
    }

    public final void setDefaultAssistChipColorsCached$material3_release(ChipColors chipColors) {
        this.defaultAssistChipColorsCached = chipColors;
    }

    public final ChipColors getDefaultElevatedAssistChipColorsCached$material3_release() {
        return this.defaultElevatedAssistChipColorsCached;
    }

    public final void setDefaultElevatedAssistChipColorsCached$material3_release(ChipColors chipColors) {
        this.defaultElevatedAssistChipColorsCached = chipColors;
    }

    public final ChipColors getDefaultSuggestionChipColorsCached$material3_release() {
        return this.defaultSuggestionChipColorsCached;
    }

    public final void setDefaultSuggestionChipColorsCached$material3_release(ChipColors chipColors) {
        this.defaultSuggestionChipColorsCached = chipColors;
    }

    public final ChipColors getDefaultElevatedSuggestionChipColorsCached$material3_release() {
        return this.defaultElevatedSuggestionChipColorsCached;
    }

    public final void setDefaultElevatedSuggestionChipColorsCached$material3_release(ChipColors chipColors) {
        this.defaultElevatedSuggestionChipColorsCached = chipColors;
    }

    public final SelectableChipColors getDefaultFilterChipColorsCached$material3_release() {
        return this.defaultFilterChipColorsCached;
    }

    public final void setDefaultFilterChipColorsCached$material3_release(SelectableChipColors selectableChipColors) {
        this.defaultFilterChipColorsCached = selectableChipColors;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColorsCached$material3_release() {
        return this.defaultElevatedFilterChipColorsCached;
    }

    public final void setDefaultElevatedFilterChipColorsCached$material3_release(SelectableChipColors selectableChipColors) {
        this.defaultElevatedFilterChipColorsCached = selectableChipColors;
    }

    public final SelectableChipColors getDefaultInputChipColorsCached$material3_release() {
        return this.defaultInputChipColorsCached;
    }

    public final void setDefaultInputChipColorsCached$material3_release(SelectableChipColors selectableChipColors) {
        this.defaultInputChipColorsCached = selectableChipColors;
    }

    public final TopAppBarColors getDefaultTopAppBarColorsCached$material3_release() {
        return this.defaultTopAppBarColorsCached;
    }

    public final void setDefaultTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultTopAppBarColorsCached = topAppBarColors;
    }

    public final TopAppBarColors getDefaultCenterAlignedTopAppBarColorsCached$material3_release() {
        return this.defaultCenterAlignedTopAppBarColorsCached;
    }

    public final void setDefaultCenterAlignedTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultCenterAlignedTopAppBarColorsCached = topAppBarColors;
    }

    public final TopAppBarColors getDefaultMediumTopAppBarColorsCached$material3_release() {
        return this.defaultMediumTopAppBarColorsCached;
    }

    public final void setDefaultMediumTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultMediumTopAppBarColorsCached = topAppBarColors;
    }

    public final TopAppBarColors getDefaultLargeTopAppBarColorsCached$material3_release() {
        return this.defaultLargeTopAppBarColorsCached;
    }

    public final void setDefaultLargeTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultLargeTopAppBarColorsCached = topAppBarColors;
    }

    public final CheckboxColors getDefaultCheckboxColorsCached$material3_release() {
        return this.defaultCheckboxColorsCached;
    }

    public final void setDefaultCheckboxColorsCached$material3_release(CheckboxColors checkboxColors) {
        this.defaultCheckboxColorsCached = checkboxColors;
    }

    public final DatePickerColors getDefaultDatePickerColorsCached$material3_release() {
        return this.defaultDatePickerColorsCached;
    }

    public final void setDefaultDatePickerColorsCached$material3_release(DatePickerColors datePickerColors) {
        this.defaultDatePickerColorsCached = datePickerColors;
    }

    public final IconButtonColors getDefaultIconButtonColorsCached$material3_release() {
        return this.defaultIconButtonColorsCached;
    }

    public final void setDefaultIconButtonColorsCached$material3_release(IconButtonColors iconButtonColors) {
        this.defaultIconButtonColorsCached = iconButtonColors;
    }

    public final MenuItemColors getDefaultMenuItemColorsCached$material3_release() {
        return this.defaultMenuItemColorsCached;
    }

    public final void setDefaultMenuItemColorsCached$material3_release(MenuItemColors menuItemColors) {
        this.defaultMenuItemColorsCached = menuItemColors;
    }

    public final NavigationBarItemColors getDefaultNavigationBarItemColorsCached$material3_release() {
        return this.defaultNavigationBarItemColorsCached;
    }

    public final void setDefaultNavigationBarItemColorsCached$material3_release(NavigationBarItemColors navigationBarItemColors) {
        this.defaultNavigationBarItemColorsCached = navigationBarItemColors;
    }

    public final NavigationRailItemColors getDefaultNavigationRailItemColorsCached$material3_release() {
        return this.defaultNavigationRailItemColorsCached;
    }

    public final void setDefaultNavigationRailItemColorsCached$material3_release(NavigationRailItemColors navigationRailItemColors) {
        this.defaultNavigationRailItemColorsCached = navigationRailItemColors;
    }

    public final RadioButtonColors getDefaultRadioButtonColorsCached$material3_release() {
        return this.defaultRadioButtonColorsCached;
    }

    public final void setDefaultRadioButtonColorsCached$material3_release(RadioButtonColors radioButtonColors) {
        this.defaultRadioButtonColorsCached = radioButtonColors;
    }

    public final SegmentedButtonColors getDefaultSegmentedButtonColorsCached$material3_release() {
        return this.defaultSegmentedButtonColorsCached;
    }

    public final void setDefaultSegmentedButtonColorsCached$material3_release(SegmentedButtonColors segmentedButtonColors) {
        this.defaultSegmentedButtonColorsCached = segmentedButtonColors;
    }

    public final SliderColors getDefaultSliderColorsCached$material3_release() {
        return this.defaultSliderColorsCached;
    }

    public final void setDefaultSliderColorsCached$material3_release(SliderColors sliderColors) {
        this.defaultSliderColorsCached = sliderColors;
    }

    public final SwitchColors getDefaultSwitchColorsCached$material3_release() {
        return this.defaultSwitchColorsCached;
    }

    public final void setDefaultSwitchColorsCached$material3_release(SwitchColors switchColors) {
        this.defaultSwitchColorsCached = switchColors;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColorsCached$material3_release() {
        return this.defaultOutlinedTextFieldColorsCached;
    }

    public final void setDefaultOutlinedTextFieldColorsCached$material3_release(TextFieldColors textFieldColors) {
        this.defaultOutlinedTextFieldColorsCached = textFieldColors;
    }

    public final TextFieldColors getDefaultTextFieldColorsCached$material3_release() {
        return this.defaultTextFieldColorsCached;
    }

    public final void setDefaultTextFieldColorsCached$material3_release(TextFieldColors textFieldColors) {
        this.defaultTextFieldColorsCached = textFieldColors;
    }

    public final TimePickerColors getDefaultTimePickerColorsCached$material3_release() {
        return this.defaultTimePickerColorsCached;
    }

    public final void setDefaultTimePickerColorsCached$material3_release(TimePickerColors timePickerColors) {
        this.defaultTimePickerColorsCached = timePickerColors;
    }

    public final RichTooltipColors getDefaultRichTooltipColorsCached$material3_release() {
        return this.defaultRichTooltipColorsCached;
    }

    public final void setDefaultRichTooltipColorsCached$material3_release(RichTooltipColors richTooltipColors) {
        this.defaultRichTooltipColorsCached = richTooltipColors;
    }
}
