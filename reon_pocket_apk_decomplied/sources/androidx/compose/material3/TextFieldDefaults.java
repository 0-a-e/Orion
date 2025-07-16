package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010+J¦\u0002\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010?J7\u0010@\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010+JP\u0010A\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010C\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u0002\u0010F\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010GJî\u0001\u0010F\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010HJ¦\u0002\u0010I\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010?Jø\u0001\u0010I\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b12\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u0002042\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010'\u001a\u00020&2\u0015\b\u0002\u00105\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u000100¢\u0006\u0002\b12\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020=2\u0013\b\u0002\u0010>\u001a\r\u0012\u0004\u0012\u00020$00¢\u0006\u0002\b1H\u0007¢\u0006\u0002\u0010JJ\r\u0010*\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010KJÂ\u0003\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0002\u0010P\u001a\u00020M2\b\b\u0002\u0010Q\u001a\u00020M2\b\b\u0002\u0010R\u001a\u00020M2\b\b\u0002\u0010S\u001a\u00020M2\b\b\u0002\u0010T\u001a\u00020M2\b\b\u0002\u0010U\u001a\u00020M2\b\b\u0002\u0010V\u001a\u00020M2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X2\b\b\u0002\u0010Y\u001a\u00020M2\b\b\u0002\u0010Z\u001a\u00020M2\b\b\u0002\u0010[\u001a\u00020M2\b\b\u0002\u0010\\\u001a\u00020M2\b\b\u0002\u0010]\u001a\u00020M2\b\b\u0002\u0010^\u001a\u00020M2\b\b\u0002\u0010_\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020M2\b\b\u0002\u0010b\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020M2\b\b\u0002\u0010d\u001a\u00020M2\b\b\u0002\u0010e\u001a\u00020M2\b\b\u0002\u0010f\u001a\u00020M2\b\b\u0002\u0010g\u001a\u00020M2\b\b\u0002\u0010h\u001a\u00020M2\b\b\u0002\u0010i\u001a\u00020M2\b\b\u0002\u0010j\u001a\u00020M2\b\b\u0002\u0010k\u001a\u00020M2\b\b\u0002\u0010l\u001a\u00020M2\b\b\u0002\u0010m\u001a\u00020M2\b\b\u0002\u0010n\u001a\u00020M2\b\b\u0002\u0010o\u001a\u00020M2\b\b\u0002\u0010p\u001a\u00020M2\b\b\u0002\u0010q\u001a\u00020M2\b\b\u0002\u0010r\u001a\u00020M2\b\b\u0002\u0010s\u001a\u00020M2\b\b\u0002\u0010t\u001a\u00020M2\b\b\u0002\u0010u\u001a\u00020M2\b\b\u0002\u0010v\u001a\u00020M2\b\b\u0002\u0010w\u001a\u00020M2\b\b\u0002\u0010x\u001a\u00020MH\u0007ø\u0001\u0000¢\u0006\u0004\by\u0010zJ:\u0010{\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J;\u0010\u0001\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0003\u0010\u0001\u001a\u00020\u001f2\t\b\u0002\u0010\u0001\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\b\b\u0002\u0010U\u001a\u00020M2\b\b\u0002\u0010V\u001a\u00020M2\b\b\u0002\u0010W\u001a\u00020X2\t\b\u0002\u0010\u0001\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\b\b\u0002\u0010]\u001a\u00020M2\b\b\u0002\u0010^\u001a\u00020M2\b\b\u0002\u0010_\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020M2\b\b\u0002\u0010b\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020M2\b\b\u0002\u0010d\u001a\u00020M2\b\b\u0002\u0010e\u001a\u00020M2\b\b\u0002\u0010f\u001a\u00020M2\b\b\u0002\u0010g\u001a\u00020M2\b\b\u0002\u0010h\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\b\b\u0002\u0010k\u001a\u00020M2\b\b\u0002\u0010m\u001a\u00020M2\b\b\u0002\u0010n\u001a\u00020M2\b\b\u0002\u0010o\u001a\u00020M2\b\b\u0002\u0010p\u001a\u00020M2\b\b\u0002\u0010q\u001a\u00020M2\b\b\u0002\u0010r\u001a\u00020M2\b\b\u0002\u0010s\u001a\u00020M2\b\b\u0002\u0010t\u001a\u00020M2\b\b\u0002\u0010u\u001a\u00020M2\b\b\u0002\u0010v\u001a\u00020M2\b\b\u0002\u0010w\u001a\u00020M2\b\b\u0002\u0010x\u001a\u00020MH\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J´\u0003\u0010\u0001\u001a\u00020\u001f2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0002\u0010P\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\b\b\u0002\u0010T\u001a\u00020M2\b\b\u0002\u0010U\u001a\u00020M2\b\b\u0002\u0010V\u001a\u00020M2\b\b\u0002\u0010W\u001a\u00020X2\t\b\u0002\u0010\u0001\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\b\b\u0002\u0010]\u001a\u00020M2\b\b\u0002\u0010^\u001a\u00020M2\b\b\u0002\u0010_\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020M2\b\b\u0002\u0010b\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020M2\b\b\u0002\u0010d\u001a\u00020M2\b\b\u0002\u0010e\u001a\u00020M2\b\b\u0002\u0010f\u001a\u00020M2\b\b\u0002\u0010g\u001a\u00020M2\b\b\u0002\u0010h\u001a\u00020M2\b\b\u0002\u0010i\u001a\u00020M2\b\b\u0002\u0010j\u001a\u00020M2\b\b\u0002\u0010k\u001a\u00020M2\b\b\u0002\u0010l\u001a\u00020M2\b\b\u0002\u0010m\u001a\u00020M2\b\b\u0002\u0010n\u001a\u00020M2\b\b\u0002\u0010o\u001a\u00020M2\b\b\u0002\u0010p\u001a\u00020M2\b\b\u0002\u0010q\u001a\u00020M2\b\b\u0002\u0010r\u001a\u00020M2\b\b\u0002\u0010s\u001a\u00020M2\b\b\u0002\u0010t\u001a\u00020M2\b\b\u0002\u0010u\u001a\u00020M2\b\b\u0002\u0010v\u001a\u00020M2\b\b\u0002\u0010w\u001a\u00020M2\b\b\u0002\u0010x\u001a\u00020MH\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J=\u0010\u0001\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J=\u0010\u0001\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u00020\u0004H\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0003\u0010\u0001\u001a\u00020\u001f2\t\b\u0002\u0010\u0001\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\b\b\u0002\u0010U\u001a\u00020M2\b\b\u0002\u0010V\u001a\u00020M2\b\b\u0002\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020M2\b\b\u0002\u0010Z\u001a\u00020M2\b\b\u0002\u0010[\u001a\u00020M2\b\b\u0002\u0010\\\u001a\u00020M2\b\b\u0002\u0010]\u001a\u00020M2\b\b\u0002\u0010^\u001a\u00020M2\b\b\u0002\u0010_\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020M2\b\b\u0002\u0010b\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020M2\b\b\u0002\u0010d\u001a\u00020M2\b\b\u0002\u0010e\u001a\u00020M2\b\b\u0002\u0010f\u001a\u00020M2\b\b\u0002\u0010g\u001a\u00020M2\b\b\u0002\u0010h\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\b\b\u0002\u0010k\u001a\u00020M2\b\b\u0002\u0010m\u001a\u00020M2\b\b\u0002\u0010n\u001a\u00020M2\b\b\u0002\u0010o\u001a\u00020M2\b\b\u0002\u0010p\u001a\u00020M2\b\b\u0002\u0010q\u001a\u00020M2\b\b\u0002\u0010r\u001a\u00020M2\b\b\u0002\u0010s\u001a\u00020M2\b\b\u0002\u0010t\u001a\u00020M2\b\b\u0002\u0010u\u001a\u00020M2\b\b\u0002\u0010v\u001a\u00020M2\b\b\u0002\u0010w\u001a\u00020M2\b\b\u0002\u0010x\u001a\u00020MH\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J°\u0003\u0010\u0001\u001a\u00020\u001f2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020M2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0002\u0010P\u001a\u00020M2\t\b\u0002\u0010\u0001\u001a\u00020M2\b\b\u0002\u0010T\u001a\u00020M2\b\b\u0002\u0010U\u001a\u00020M2\b\b\u0002\u0010V\u001a\u00020M2\b\b\u0002\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020M2\b\b\u0002\u0010Z\u001a\u00020M2\b\b\u0002\u0010[\u001a\u00020M2\b\b\u0002\u0010\\\u001a\u00020M2\b\b\u0002\u0010]\u001a\u00020M2\b\b\u0002\u0010^\u001a\u00020M2\b\b\u0002\u0010_\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020M2\b\b\u0002\u0010b\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020M2\b\b\u0002\u0010d\u001a\u00020M2\b\b\u0002\u0010e\u001a\u00020M2\b\b\u0002\u0010f\u001a\u00020M2\b\b\u0002\u0010g\u001a\u00020M2\b\b\u0002\u0010h\u001a\u00020M2\b\b\u0002\u0010i\u001a\u00020M2\b\b\u0002\u0010j\u001a\u00020M2\b\b\u0002\u0010k\u001a\u00020M2\b\b\u0002\u0010l\u001a\u00020M2\b\b\u0002\u0010m\u001a\u00020M2\b\b\u0002\u0010n\u001a\u00020M2\b\b\u0002\u0010o\u001a\u00020M2\b\b\u0002\u0010p\u001a\u00020M2\b\b\u0002\u0010q\u001a\u00020M2\b\b\u0002\u0010r\u001a\u00020M2\b\b\u0002\u0010s\u001a\u00020M2\b\b\u0002\u0010t\u001a\u00020M2\b\b\u0002\u0010u\u001a\u00020M2\b\b\u0002\u0010v\u001a\u00020M2\b\b\u0002\u0010w\u001a\u00020M2\b\b\u0002\u0010x\u001a\u00020MH\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J=\u0010\u0001\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J=\u0010\u0001\u001a\u00020=2\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JQ\u0010\u0001\u001a\u00030\u0001*\u00030\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\t\b\u0002\u0010\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0001\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010 \u0001R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00158GX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00158GX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\u001e\u001a\u00020\u001f*\u00020 8AX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape$annotations", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape$annotations", "getOutlinedShape", "shape", "getShape", "defaultTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "FilledContainerBox", "OutlinedBorderContainerBox", "focusedBorderThickness", "unfocusedBorderThickness", "OutlinedBorderContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "contentPaddingWithLabel", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "outlinedTextFieldColors", "textColor", "containerColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "placeholderColor", "outlinedTextFieldColors-eS1Emto", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors-M37tBTI", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3_release", "textFieldColors", "textFieldColors-eS1Emto", "textFieldColors-M37tBTI", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness;
    private static final float FocusedIndicatorThickness;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m6614constructorimpl((float) 56);
    private static final float MinWidth = Dp.m6614constructorimpl((float) 280);
    private static final float UnfocusedBorderThickness;
    private static final float UnfocusedIndicatorThickness;

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.shape", imports = {}))
    public static /* synthetic */ void getFilledShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.FocusedIndicatorThickness", imports = {}))
    /* renamed from: getFocusedBorderThickness-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m2417getFocusedBorderThicknessD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.shape", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    public static /* synthetic */ void getOutlinedShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.UnfocusedIndicatorThickness", imports = {}))
    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m2418getUnfocusedBorderThicknessD9Ej5fM$annotations() {
    }

    private TextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(-1941327459);
        ComposerKt.sourceInformation(composer, "C58@2591L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941327459, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:58)");
        }
        Shape value = ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m2430getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m2431getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedIndicatorThickness-D9Ej5fM  reason: not valid java name */
    public final float m2433getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    /* renamed from: getFocusedIndicatorThickness-D9Ej5fM  reason: not valid java name */
    public final float m2429getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00df, code lost:
        if ((r27 & 16) != 0) goto L_0x00ed;
     */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ContainerBox(boolean r20, boolean r21, androidx.compose.foundation.interaction.InteractionSource r22, androidx.compose.material3.TextFieldColors r23, androidx.compose.ui.graphics.Shape r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r19 = this;
            r7 = r26
            r0 = 918564008(0x36c02ca8, float:5.7272446E-6)
            r1 = r25
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ContainerBox)P(1,3,2)101@4199L5,105@4283L51,103@4222L203:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r27 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r7 | 6
            r15 = r20
            goto L_0x002b
        L_0x0019:
            r1 = r7 & 6
            r15 = r20
            if (r1 != 0) goto L_0x002a
            boolean r1 = r8.changed((boolean) r15)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r7
            goto L_0x002b
        L_0x002a:
            r1 = r7
        L_0x002b:
            r2 = r27 & 2
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            r14 = r21
            goto L_0x0046
        L_0x0034:
            r2 = r7 & 48
            r14 = r21
            if (r2 != 0) goto L_0x0046
            boolean r2 = r8.changed((boolean) r14)
            if (r2 == 0) goto L_0x0043
            r2 = 32
            goto L_0x0045
        L_0x0043:
            r2 = 16
        L_0x0045:
            r1 = r1 | r2
        L_0x0046:
            r2 = r27 & 4
            if (r2 == 0) goto L_0x004f
            r1 = r1 | 384(0x180, float:5.38E-43)
            r13 = r22
            goto L_0x0061
        L_0x004f:
            r2 = r7 & 384(0x180, float:5.38E-43)
            r13 = r22
            if (r2 != 0) goto L_0x0061
            boolean r2 = r8.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x005e
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r1 = r1 | r2
        L_0x0061:
            r2 = r27 & 8
            if (r2 == 0) goto L_0x006a
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r12 = r23
            goto L_0x007c
        L_0x006a:
            r2 = r7 & 3072(0xc00, float:4.305E-42)
            r12 = r23
            if (r2 != 0) goto L_0x007c
            boolean r2 = r8.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0079
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r1 = r1 | r2
        L_0x007c:
            r2 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x0095
            r2 = r27 & 16
            if (r2 != 0) goto L_0x008f
            r2 = r24
            boolean r3 = r8.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0091
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x008f:
            r2 = r24
        L_0x0091:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r1 = r1 | r3
            goto L_0x0097
        L_0x0095:
            r2 = r24
        L_0x0097:
            r3 = r27 & 32
            r4 = 196608(0x30000, float:2.75506E-40)
            if (r3 == 0) goto L_0x00a1
            r1 = r1 | r4
            r11 = r19
            goto L_0x00b3
        L_0x00a1:
            r3 = r7 & r4
            r11 = r19
            if (r3 != 0) goto L_0x00b3
            boolean r3 = r8.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x00b0
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00b0:
            r3 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r1 = r1 | r3
        L_0x00b3:
            r3 = 74899(0x12493, float:1.04956E-40)
            r3 = r3 & r1
            r4 = 74898(0x12492, float:1.04954E-40)
            if (r3 != r4) goto L_0x00c9
            boolean r3 = r8.getSkipping()
            if (r3 != 0) goto L_0x00c3
            goto L_0x00c9
        L_0x00c3:
            r8.skipToGroupEnd()
        L_0x00c6:
            r6 = r2
            goto L_0x0145
        L_0x00c9:
            r8.startDefaults()
            r3 = r7 & 1
            r4 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x00e2
            boolean r3 = r8.getDefaultsInvalid()
            if (r3 == 0) goto L_0x00da
            goto L_0x00e2
        L_0x00da:
            r8.skipToGroupEnd()
            r3 = r27 & 16
            if (r3 == 0) goto L_0x00ee
            goto L_0x00ed
        L_0x00e2:
            r3 = r27 & 16
            if (r3 == 0) goto L_0x00ee
            androidx.compose.material3.TextFieldDefaults r2 = INSTANCE
            r3 = 6
            androidx.compose.ui.graphics.Shape r2 = r2.getShape(r8, r3)
        L_0x00ed:
            r1 = r1 & r4
        L_0x00ee:
            r10 = r2
            r8.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00fe
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.TextFieldDefaults.ContainerBox (TextFieldDefaults.kt:102)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x00fe:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r6 = r1 & 8190(0x1ffe, float:1.1477E-41)
            r1 = r23
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r8
            androidx.compose.runtime.State r1 = r1.containerColor$material3_release(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m3826unboximpl()
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m213backgroundbw27NRU(r0, r1, r10)
            r17 = 48
            r18 = 0
            r1 = 0
            r16 = 0
            r9 = r19
            r2 = r10
            r10 = r0
            r11 = r20
            r12 = r21
            r13 = r22
            r14 = r23
            r15 = r1
            androidx.compose.ui.Modifier r0 = m2419indicatorLinegv0btCI$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r1 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r0, r8, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00c6
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x00c6
        L_0x0145:
            androidx.compose.runtime.ScopeUpdateScope r9 = r8.endRestartGroup()
            if (r9 == 0) goto L_0x0164
            androidx.compose.material3.TextFieldDefaults$ContainerBox$1 r10 = new androidx.compose.material3.TextFieldDefaults$ContainerBox$1
            r0 = r10
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r7 = r26
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.ContainerBox(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: indicatorLine-gv0btCI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2419indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4 = (i & 16) != 0 ? FocusedIndicatorThickness : f;
        if ((i & 32) != 0) {
            f3 = UnfocusedIndicatorThickness;
        } else {
            f3 = f2;
        }
        return textFieldDefaults.m2434indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f4, f3);
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2415contentPaddingWithLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m2426contentPaddingWithLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPaddingWithLabel-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2426contentPaddingWithLabela9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m666PaddingValuesa9UjIt4(f, f3, f2, f4);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2416contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2427contentPaddingWithoutLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPaddingWithoutLabel-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2427contentPaddingWithoutLabela9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m666PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2421supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = Dp.m6614constructorimpl((float) 0);
        }
        return textFieldDefaults.m2438supportingTextPaddinga9UjIt4$material3_release(f, f2, f3, f4);
    }

    /* renamed from: supportingTextPadding-a9UjIt4$material3_release  reason: not valid java name */
    public final PaddingValues m2438supportingTextPaddinga9UjIt4$material3_release(float f, float f2, float f3, float f4) {
        return PaddingKt.m666PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(831731228);
        ComposerKt.sourceInformation(composer, "C(colors)197@8134L11,197@8146L22:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(831731228, i, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:197)");
        }
        TextFieldColors defaultTextFieldColors = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* renamed from: colors-0hiis_0  reason: not valid java name */
    public final TextFieldColors m2425colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Composer composer2 = composer;
        int i8 = i6;
        int i9 = i7;
        composer2.startReplaceableGroup(1513344955);
        ComposerKt.sourceInformation(composer2, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,32,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)298@14956L11,298@14968L22:TextFieldDefaults.kt#uh7d8r");
        long r7 = (i8 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j;
        long r9 = (i8 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j2;
        long r11 = (i8 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j3;
        long r13 = (i8 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j4;
        long r15 = (i8 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j5;
        long r17 = (i8 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j6;
        long r19 = (i8 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j7;
        long r21 = (i8 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j8;
        long r23 = (i8 & 256) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j9;
        long r25 = (i8 & 512) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j10;
        TextSelectionColors textSelectionColors2 = (i8 & 1024) != 0 ? null : textSelectionColors;
        long r28 = (i8 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j11;
        long r30 = (i8 & 4096) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j12;
        long r32 = (i8 & 8192) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j13;
        long r34 = (i8 & 16384) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j14;
        long r36 = (32768 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j15;
        long r38 = (65536 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j16;
        long r40 = (131072 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j17;
        long r42 = (262144 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j18;
        long r44 = (524288 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j19;
        long r46 = (1048576 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j20;
        long r48 = (2097152 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j21;
        long r50 = (4194304 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j22;
        long r52 = (8388608 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j23;
        long r54 = (16777216 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j24;
        long r56 = (33554432 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j25;
        long r58 = (67108864 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j26;
        long r60 = (134217728 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j27;
        long r62 = (268435456 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j28;
        long r64 = (536870912 & i8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j29;
        long r66 = (i8 & 1073741824) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j30;
        long r68 = (i9 & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j31;
        long r70 = (i9 & 2) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j32;
        long r72 = (i9 & 4) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j33;
        long r74 = (i9 & 8) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j34;
        long r76 = (i9 & 16) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j35;
        long r78 = (i9 & 32) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j36;
        long r80 = (i9 & 64) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j37;
        long r82 = (i9 & 128) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j38;
        long r84 = (i9 & 256) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j39;
        long r86 = (i9 & 512) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j40;
        long r88 = (i9 & 1024) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j41;
        long r90 = (i9 & 2048) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j42;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1513344955, i, i2, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:298)");
        }
        TextFieldColors r1 = getDefaultTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), composer2, (i5 >> 6) & 112).m2372copyejIjP34(r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, textSelectionColors2, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84, r86, r88, r90);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r1;
    }

    public final TextFieldColors getDefaultTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        ColorScheme colorScheme2 = colorScheme;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1341970309);
        ComposerKt.sourceInformation(composer2, "C*359@18678L7:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1341970309, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-defaultTextFieldColors> (TextFieldDefaults.kt:346)");
        }
        TextFieldColors defaultTextFieldColorsCached$material3_release = colorScheme.getDefaultTextFieldColorsCached$material3_release();
        if (defaultTextFieldColorsCached$material3_release == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusInputColor());
            long fromToken2 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputColor());
            long r8 = Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            long fromToken3 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorInputColor());
            long fromToken4 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken5 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getContainerColor());
            TextFieldColors textFieldColors = r3;
            long fromToken6 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken7 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getContainerColor());
            long fromToken8 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getCaretColor());
            long fromToken9 = ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldColors textFieldColors2 = new TextFieldColors(fromToken, fromToken2, r8, fromToken3, fromToken4, fromToken5, fromToken6, fromToken7, fromToken8, fromToken9, (TextSelectionColors) consume, ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getLabelColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledLabelColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getSupportingColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m3815copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), ColorSchemeKt.fromToken(colorScheme2, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), (DefaultConstructorMarker) null);
            defaultTextFieldColorsCached$material3_release = textFieldColors;
            colorScheme2.setDefaultTextFieldColorsCached$material3_release(defaultTextFieldColorsCached$material3_release);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldColorsCached$material3_release;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x045f  */
    /* JADX WARNING: Removed duplicated region for block: B:272:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void DecorationBox(java.lang.String r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, boolean r44, boolean r45, androidx.compose.ui.text.input.VisualTransformation r46, androidx.compose.foundation.interaction.InteractionSource r47, boolean r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.ui.graphics.Shape r56, androidx.compose.material3.TextFieldColors r57, androidx.compose.foundation.layout.PaddingValues r58, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, androidx.compose.runtime.Composer r60, int r61, int r62, int r63) {
        /*
            r41 = this;
            r15 = r41
            r14 = r61
            r13 = r62
            r12 = r63
            r0 = 289640444(0x11438ffc, float:1.5427156E-28)
            r1 = r60
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DecorationBox)P(16,4,3,12,17,5,6,7,9,8,15,10,13,14,11!1,2)487@27934L5,488@27975L8,499@28330L707:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x001f
            r1 = r14 | 6
            r4 = r42
            goto L_0x0031
        L_0x001f:
            r1 = r14 & 6
            r4 = r42
            if (r1 != 0) goto L_0x0030
            boolean r1 = r0.changed((java.lang.Object) r4)
            if (r1 == 0) goto L_0x002d
            r1 = 4
            goto L_0x002e
        L_0x002d:
            r1 = 2
        L_0x002e:
            r1 = r1 | r14
            goto L_0x0031
        L_0x0030:
            r1 = r14
        L_0x0031:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x0038
            r1 = r1 | 48
            goto L_0x004b
        L_0x0038:
            r5 = r14 & 48
            if (r5 != 0) goto L_0x004b
            r5 = r43
            boolean r8 = r0.changedInstance(r5)
            if (r8 == 0) goto L_0x0047
            r8 = 32
            goto L_0x0049
        L_0x0047:
            r8 = 16
        L_0x0049:
            r1 = r1 | r8
            goto L_0x004d
        L_0x004b:
            r5 = r43
        L_0x004d:
            r8 = r12 & 4
            if (r8 == 0) goto L_0x0054
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0054:
            r8 = r14 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0067
            r8 = r44
            boolean r11 = r0.changed((boolean) r8)
            if (r11 == 0) goto L_0x0063
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r1 = r1 | r11
            goto L_0x0069
        L_0x0067:
            r8 = r44
        L_0x0069:
            r11 = r12 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0074:
            r11 = r14 & 3072(0xc00, float:4.305E-42)
            if (r11 != 0) goto L_0x0088
            r11 = r45
            boolean r18 = r0.changed((boolean) r11)
            if (r18 == 0) goto L_0x0083
            r18 = r16
            goto L_0x0085
        L_0x0083:
            r18 = r17
        L_0x0085:
            r1 = r1 | r18
            goto L_0x008a
        L_0x0088:
            r11 = r45
        L_0x008a:
            r18 = r12 & 16
            r19 = 8192(0x2000, float:1.14794E-41)
            r20 = 16384(0x4000, float:2.2959E-41)
            if (r18 == 0) goto L_0x0095
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0095:
            r2 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x00a9
            r2 = r46
            boolean r18 = r0.changed((java.lang.Object) r2)
            if (r18 == 0) goto L_0x00a4
            r18 = r20
            goto L_0x00a6
        L_0x00a4:
            r18 = r19
        L_0x00a6:
            r1 = r1 | r18
            goto L_0x00ab
        L_0x00a9:
            r2 = r46
        L_0x00ab:
            r18 = r12 & 32
            r21 = 196608(0x30000, float:2.75506E-40)
            r22 = 65536(0x10000, float:9.18355E-41)
            if (r18 == 0) goto L_0x00b8
            r1 = r1 | r21
            r7 = r47
            goto L_0x00cb
        L_0x00b8:
            r18 = r14 & r21
            r7 = r47
            if (r18 != 0) goto L_0x00cb
            boolean r23 = r0.changed((java.lang.Object) r7)
            if (r23 == 0) goto L_0x00c7
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r23 = r22
        L_0x00c9:
            r1 = r1 | r23
        L_0x00cb:
            r23 = r12 & 64
            r24 = 1572864(0x180000, float:2.204052E-39)
            if (r23 == 0) goto L_0x00d6
            r1 = r1 | r24
            r3 = r48
            goto L_0x00e9
        L_0x00d6:
            r24 = r14 & r24
            r3 = r48
            if (r24 != 0) goto L_0x00e9
            boolean r25 = r0.changed((boolean) r3)
            if (r25 == 0) goto L_0x00e5
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r1 = r1 | r25
        L_0x00e9:
            r6 = r12 & 128(0x80, float:1.794E-43)
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            if (r6 == 0) goto L_0x00f4
            r1 = r1 | r26
            r9 = r49
            goto L_0x0107
        L_0x00f4:
            r27 = r14 & r26
            r9 = r49
            if (r27 != 0) goto L_0x0107
            boolean r28 = r0.changedInstance(r9)
            if (r28 == 0) goto L_0x0103
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r1 = r1 | r28
        L_0x0107:
            r10 = r12 & 256(0x100, float:3.59E-43)
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            if (r10 == 0) goto L_0x0112
            r1 = r1 | r29
            r2 = r50
            goto L_0x0125
        L_0x0112:
            r30 = r14 & r29
            r2 = r50
            if (r30 != 0) goto L_0x0125
            boolean r30 = r0.changedInstance(r2)
            if (r30 == 0) goto L_0x0121
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0123
        L_0x0121:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0123:
            r1 = r1 | r30
        L_0x0125:
            r2 = r12 & 512(0x200, float:7.175E-43)
            r30 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0130
            r1 = r1 | r30
            r3 = r51
            goto L_0x0143
        L_0x0130:
            r30 = r14 & r30
            r3 = r51
            if (r30 != 0) goto L_0x0143
            boolean r30 = r0.changedInstance(r3)
            if (r30 == 0) goto L_0x013f
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0141
        L_0x013f:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0141:
            r1 = r1 | r30
        L_0x0143:
            r3 = r12 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x014c
            r24 = r13 | 6
            r4 = r52
            goto L_0x0162
        L_0x014c:
            r30 = r13 & 6
            r4 = r52
            if (r30 != 0) goto L_0x0160
            boolean r30 = r0.changedInstance(r4)
            if (r30 == 0) goto L_0x015b
            r24 = 4
            goto L_0x015d
        L_0x015b:
            r24 = 2
        L_0x015d:
            r24 = r13 | r24
            goto L_0x0162
        L_0x0160:
            r24 = r13
        L_0x0162:
            r4 = r12 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0169
            r24 = r24 | 48
            goto L_0x017c
        L_0x0169:
            r30 = r13 & 48
            r5 = r53
            if (r30 != 0) goto L_0x017c
            boolean r30 = r0.changedInstance(r5)
            if (r30 == 0) goto L_0x0178
            r25 = 32
            goto L_0x017a
        L_0x0178:
            r25 = 16
        L_0x017a:
            r24 = r24 | r25
        L_0x017c:
            r5 = r24
            r7 = r12 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0185
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0199
        L_0x0185:
            r8 = r13 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0199
            r8 = r54
            boolean r18 = r0.changedInstance(r8)
            if (r18 == 0) goto L_0x0194
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x0196
        L_0x0194:
            r27 = 128(0x80, float:1.794E-43)
        L_0x0196:
            r5 = r5 | r27
            goto L_0x019b
        L_0x0199:
            r8 = r54
        L_0x019b:
            r8 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x01a2
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b4
        L_0x01a2:
            r9 = r13 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x01b4
            r9 = r55
            boolean r18 = r0.changedInstance(r9)
            if (r18 == 0) goto L_0x01af
            goto L_0x01b1
        L_0x01af:
            r16 = r17
        L_0x01b1:
            r5 = r5 | r16
            goto L_0x01b6
        L_0x01b4:
            r9 = r55
        L_0x01b6:
            r9 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x01ce
            r9 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r9 != 0) goto L_0x01c9
            r9 = r56
            boolean r16 = r0.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x01cb
            r19 = r20
            goto L_0x01cb
        L_0x01c9:
            r9 = r56
        L_0x01cb:
            r5 = r5 | r19
            goto L_0x01d0
        L_0x01ce:
            r9 = r56
        L_0x01d0:
            r16 = r13 & r21
            if (r16 != 0) goto L_0x01eb
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r12 & r16
            r9 = r57
            if (r16 != 0) goto L_0x01e6
            boolean r16 = r0.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x01e6
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01e8
        L_0x01e6:
            r16 = r22
        L_0x01e8:
            r5 = r5 | r16
            goto L_0x01ed
        L_0x01eb:
            r9 = r57
        L_0x01ed:
            r16 = 1572864(0x180000, float:2.204052E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x0207
            r16 = r12 & r22
            r9 = r58
            if (r16 != 0) goto L_0x0202
            boolean r16 = r0.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x0202
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0204
        L_0x0202:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x0204:
            r5 = r5 | r16
            goto L_0x0209
        L_0x0207:
            r9 = r58
        L_0x0209:
            r16 = 131072(0x20000, float:1.83671E-40)
            r16 = r12 & r16
            if (r16 == 0) goto L_0x0214
            r5 = r5 | r26
            r9 = r59
            goto L_0x0227
        L_0x0214:
            r17 = r13 & r26
            r9 = r59
            if (r17 != 0) goto L_0x0227
            boolean r17 = r0.changedInstance(r9)
            if (r17 == 0) goto L_0x0223
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0225
        L_0x0223:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x0225:
            r5 = r5 | r17
        L_0x0227:
            r17 = 262144(0x40000, float:3.67342E-40)
            r17 = r12 & r17
            if (r17 == 0) goto L_0x0230
            r5 = r5 | r29
            goto L_0x0241
        L_0x0230:
            r17 = r13 & r29
            if (r17 != 0) goto L_0x0241
            boolean r17 = r0.changed((java.lang.Object) r15)
            if (r17 == 0) goto L_0x023d
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x023f
        L_0x023d:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x023f:
            r5 = r5 | r17
        L_0x0241:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r9 = r1 & r17
            r11 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r11) goto L_0x0278
            r9 = 38347923(0x2492493, float:1.4777644E-37)
            r9 = r9 & r5
            r11 = 38347922(0x2492492, float:1.4777643E-37)
            if (r9 != r11) goto L_0x0278
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x025b
            goto L_0x0278
        L_0x025b:
            r0.skipToGroupEnd()
            r8 = r48
            r9 = r49
            r10 = r50
            r11 = r51
            r12 = r52
            r13 = r53
            r14 = r54
            r16 = r55
            r17 = r56
            r18 = r57
            r38 = r58
            r19 = r59
            goto L_0x0459
        L_0x0278:
            r0.startDefaults()
            r9 = r14 & 1
            r11 = 6
            if (r9 == 0) goto L_0x02bf
            boolean r9 = r0.getDefaultsInvalid()
            if (r9 == 0) goto L_0x0287
            goto L_0x02bf
        L_0x0287:
            r0.skipToGroupEnd()
            r2 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0292
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = r5 & r2
        L_0x0292:
            r2 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r12
            if (r2 == 0) goto L_0x029c
            r2 = -458753(0xfffffffffff8ffff, float:NaN)
            r5 = r5 & r2
        L_0x029c:
            r2 = r12 & r22
            if (r2 == 0) goto L_0x02a4
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r2
        L_0x02a4:
            r9 = r48
            r6 = r49
            r10 = r50
            r2 = r51
            r3 = r52
            r4 = r53
            r7 = r54
            r48 = r56
            r11 = r57
            r38 = r58
            r39 = r59
            r8 = r5
            r5 = r55
            goto L_0x03a7
        L_0x02bf:
            if (r23 == 0) goto L_0x02c3
            r9 = 0
            goto L_0x02c5
        L_0x02c3:
            r9 = r48
        L_0x02c5:
            r17 = 0
            if (r6 == 0) goto L_0x02cc
            r6 = r17
            goto L_0x02ce
        L_0x02cc:
            r6 = r49
        L_0x02ce:
            if (r10 == 0) goto L_0x02d3
            r10 = r17
            goto L_0x02d5
        L_0x02d3:
            r10 = r50
        L_0x02d5:
            if (r2 == 0) goto L_0x02da
            r2 = r17
            goto L_0x02dc
        L_0x02da:
            r2 = r51
        L_0x02dc:
            if (r3 == 0) goto L_0x02e1
            r3 = r17
            goto L_0x02e3
        L_0x02e1:
            r3 = r52
        L_0x02e3:
            if (r4 == 0) goto L_0x02e8
            r4 = r17
            goto L_0x02ea
        L_0x02e8:
            r4 = r53
        L_0x02ea:
            if (r7 == 0) goto L_0x02ef
            r7 = r17
            goto L_0x02f1
        L_0x02ef:
            r7 = r54
        L_0x02f1:
            if (r8 == 0) goto L_0x02f4
            goto L_0x02f6
        L_0x02f4:
            r17 = r55
        L_0x02f6:
            r8 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x0306
            androidx.compose.material3.TextFieldDefaults r8 = INSTANCE
            androidx.compose.ui.graphics.Shape r8 = r8.getShape(r0, r11)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = r5 & r18
            goto L_0x0308
        L_0x0306:
            r8 = r56
        L_0x0308:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r12 & r18
            if (r18 == 0) goto L_0x031d
            int r18 = r5 >> 24
            r11 = r18 & 14
            androidx.compose.material3.TextFieldColors r11 = r15.colors(r0, r11)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r5 = r5 & r18
            goto L_0x031f
        L_0x031d:
            r11 = r57
        L_0x031f:
            r18 = r12 & r22
            if (r18 == 0) goto L_0x0368
            if (r6 != 0) goto L_0x0344
            r18 = 15
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r48 = r41
            r49 = r20
            r50 = r21
            r51 = r22
            r52 = r23
            r53 = r18
            r54 = r19
            androidx.compose.foundation.layout.PaddingValues r18 = m2416contentPaddingWithoutLabela9UjIt4$default(r48, r49, r50, r51, r52, r53, r54)
            goto L_0x0362
        L_0x0344:
            r18 = 15
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r48 = r41
            r49 = r20
            r50 = r21
            r51 = r22
            r52 = r23
            r53 = r18
            r54 = r19
            androidx.compose.foundation.layout.PaddingValues r18 = m2415contentPaddingWithLabela9UjIt4$default(r48, r49, r50, r51, r52, r53, r54)
        L_0x0362:
            r19 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r19
            goto L_0x036a
        L_0x0368:
            r18 = r58
        L_0x036a:
            if (r16 == 0) goto L_0x0398
            r16 = r2
            androidx.compose.material3.TextFieldDefaults$DecorationBox$1 r2 = new androidx.compose.material3.TextFieldDefaults$DecorationBox$1
            r48 = r2
            r49 = r44
            r50 = r9
            r51 = r47
            r52 = r11
            r53 = r8
            r48.<init>(r49, r50, r51, r52, r53)
            r48 = r3
            r3 = -435523791(0xffffffffe60a6f31, float:-1.6343442E23)
            r49 = r4
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r3, r4, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = r48
            r4 = r49
            r39 = r2
            r48 = r8
            r2 = r16
            goto L_0x03a2
        L_0x0398:
            r16 = r2
            r48 = r3
            r49 = r4
            r39 = r59
            r48 = r8
        L_0x03a2:
            r38 = r18
            r8 = r5
            r5 = r17
        L_0x03a7:
            r0.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x03b8
            r12 = 289640444(0x11438ffc, float:1.5427156E-28)
            java.lang.String r13 = "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:498)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r1, r8, r13)
        L_0x03b8:
            androidx.compose.material3.TextFieldType r16 = androidx.compose.material3.TextFieldType.Filled
            int r12 = r1 << 3
            r13 = r12 & 112(0x70, float:1.57E-43)
            r17 = 6
            r13 = r13 | 6
            r12 = r12 & 896(0x380, float:1.256E-42)
            r12 = r12 | r13
            int r13 = r1 >> 3
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r14
            int r14 = r1 >> 9
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r14 & r17
            r12 = r12 | r17
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r14 & r17
            r12 = r12 | r17
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r14 & r17
            r12 = r12 | r17
            int r17 = r8 << 21
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r17 & r18
            r12 = r12 | r18
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            r18 = r17 & r18
            r12 = r12 | r18
            r18 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r17 & r18
            r35 = r12 | r17
            int r12 = r8 >> 9
            r12 = r12 & 14
            int r17 = r1 >> 6
            r17 = r17 & 112(0x70, float:1.57E-43)
            r12 = r12 | r17
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r12
            r12 = r14 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r13
            r1 = r1 | r12
            int r12 = r8 >> 3
            r13 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r13
            r1 = r1 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            int r13 = r8 << 3
            r12 = r12 & r13
            r1 = r1 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r8 = r8 & r12
            r36 = r1 | r8
            r37 = 0
            r17 = r42
            r18 = r43
            r19 = r46
            r20 = r6
            r21 = r10
            r22 = r2
            r23 = r3
            r24 = r4
            r25 = r7
            r26 = r5
            r27 = r45
            r28 = r44
            r29 = r9
            r30 = r47
            r31 = r38
            r32 = r11
            r33 = r39
            r34 = r0
            androidx.compose.material3.TextFieldImplKt.CommonDecorationBox(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x044b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x044b:
            r17 = r48
            r12 = r3
            r13 = r4
            r16 = r5
            r14 = r7
            r8 = r9
            r18 = r11
            r19 = r39
            r11 = r2
            r9 = r6
        L_0x0459:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 == 0) goto L_0x048d
            androidx.compose.material3.TextFieldDefaults$DecorationBox$2 r23 = new androidx.compose.material3.TextFieldDefaults$DecorationBox$2
            r0 = r23
            r1 = r41
            r2 = r42
            r3 = r43
            r4 = r44
            r5 = r45
            r6 = r46
            r40 = r7
            r7 = r47
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r38
            r20 = r61
            r21 = r62
            r22 = r63
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r40
            r1.updateScope(r0)
        L_0x048d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.DecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        composer.startReplaceableGroup(-584749279);
        ComposerKt.sourceInformation(composer, "C527@29387L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:527)");
        }
        Shape shape = OutlinedTextFieldDefaults.INSTANCE.getShape(composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getFilledShape(Composer composer, int i) {
        composer.startReplaceableGroup(611926497);
        ComposerKt.sourceInformation(composer, "C534@29625L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:534)");
        }
        Shape shape = getShape(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m2432getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m2428getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00e3, code lost:
        if ((r26 & 16) != 0) goto L_0x00f1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.ContainerBox`", replaceWith = @kotlin.ReplaceWith(expression = "TextFieldDefaults.ContainerBox(\n        enabled = enabled,\n        isError = isError,\n        interactionSource = interactionSource,\n        colors = colors,\n        shape = shape,\n    )", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void FilledContainerBox(boolean r19, boolean r20, androidx.compose.foundation.interaction.InteractionSource r21, androidx.compose.material3.TextFieldColors r22, androidx.compose.ui.graphics.Shape r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r18 = this;
            r7 = r25
            r0 = -1358797526(0xffffffffaf02652a, float:-1.1859372E-10)
            r1 = r24
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(FilledContainerBox)P(1,3,2)570@31126L5,571@31141L168:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r26 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r7 | 6
            r3 = r2
            r2 = r19
            goto L_0x002e
        L_0x001a:
            r2 = r7 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r19
            boolean r3 = r1.changed((boolean) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r7
            goto L_0x002e
        L_0x002b:
            r2 = r19
            r3 = r7
        L_0x002e:
            r4 = r26 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r4 = r7 & 48
            if (r4 != 0) goto L_0x0048
            r4 = r20
            boolean r5 = r1.changed((boolean) r4)
            if (r5 == 0) goto L_0x0044
            r5 = 32
            goto L_0x0046
        L_0x0044:
            r5 = 16
        L_0x0046:
            r3 = r3 | r5
            goto L_0x004a
        L_0x0048:
            r4 = r20
        L_0x004a:
            r5 = r26 & 4
            if (r5 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r5 = r7 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0064
            r5 = r21
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0060
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r6
            goto L_0x0066
        L_0x0064:
            r5 = r21
        L_0x0066:
            r6 = r26 & 8
            if (r6 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r6 = r7 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0080
            r6 = r22
            boolean r8 = r1.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x007c
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r8
            goto L_0x0082
        L_0x0080:
            r6 = r22
        L_0x0082:
            r8 = r7 & 24576(0x6000, float:3.4438E-41)
            if (r8 != 0) goto L_0x009b
            r8 = r26 & 16
            if (r8 != 0) goto L_0x0095
            r8 = r23
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0097
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0095:
            r8 = r23
        L_0x0097:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r9
            goto L_0x009d
        L_0x009b:
            r8 = r23
        L_0x009d:
            r9 = r26 & 32
            r10 = 196608(0x30000, float:2.75506E-40)
            if (r9 == 0) goto L_0x00a7
            r3 = r3 | r10
            r15 = r18
            goto L_0x00b9
        L_0x00a7:
            r9 = r7 & r10
            r15 = r18
            if (r9 != 0) goto L_0x00b9
            boolean r9 = r1.changed((java.lang.Object) r15)
            if (r9 == 0) goto L_0x00b6
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r3 = r3 | r9
        L_0x00b9:
            r9 = 74899(0x12493, float:1.04956E-40)
            r9 = r9 & r3
            r10 = 74898(0x12492, float:1.04954E-40)
            if (r9 != r10) goto L_0x00cd
            boolean r9 = r1.getSkipping()
            if (r9 != 0) goto L_0x00c9
            goto L_0x00cd
        L_0x00c9:
            r1.skipToGroupEnd()
            goto L_0x0126
        L_0x00cd:
            r1.startDefaults()
            r9 = r7 & 1
            r10 = -57345(0xffffffffffff1fff, float:NaN)
            if (r9 == 0) goto L_0x00e6
            boolean r9 = r1.getDefaultsInvalid()
            if (r9 == 0) goto L_0x00de
            goto L_0x00e6
        L_0x00de:
            r1.skipToGroupEnd()
            r9 = r26 & 16
            if (r9 == 0) goto L_0x00f2
            goto L_0x00f1
        L_0x00e6:
            r9 = r26 & 16
            if (r9 == 0) goto L_0x00f2
            androidx.compose.material3.TextFieldDefaults r8 = INSTANCE
            r9 = 6
            androidx.compose.ui.graphics.Shape r8 = r8.getShape(r1, r9)
        L_0x00f1:
            r3 = r3 & r10
        L_0x00f2:
            r17 = r8
            r8 = r3
            r3 = r17
            r1.endDefaults()
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x0106
            r9 = -1
            java.lang.String r10 = "androidx.compose.material3.TextFieldDefaults.FilledContainerBox (TextFieldDefaults.kt:571)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r9, r10)
        L_0x0106:
            r0 = 524286(0x7fffe, float:7.34681E-40)
            r0 = r0 & r8
            r16 = 0
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            r12 = r22
            r13 = r3
            r14 = r1
            r15 = r0
            r8.ContainerBox(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0125
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0125:
            r8 = r3
        L_0x0126:
            androidx.compose.runtime.ScopeUpdateScope r9 = r1.endRestartGroup()
            if (r9 == 0) goto L_0x0146
            androidx.compose.material3.TextFieldDefaults$FilledContainerBox$1 r10 = new androidx.compose.material3.TextFieldDefaults$FilledContainerBox$1
            r0 = r10
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r8
            r7 = r25
            r8 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0146:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.FilledContainerBox(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00eb  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.ContainerBox`", replaceWith = @kotlin.ReplaceWith(expression = "OutlinedTextFieldDefaults.ContainerBox(\n        enabled = enabled,\n        isError = isError,\n        interactionSource = interactionSource,\n        colors = colors,\n        shape = shape,\n        focusedBorderThickness = focusedBorderThickness,\n        unfocusedBorderThickness = unfocusedBorderThickness,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: OutlinedBorderContainerBox-nbWgWpA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m2424OutlinedBorderContainerBoxnbWgWpA(boolean r23, boolean r24, androidx.compose.foundation.interaction.InteractionSource r25, androidx.compose.material3.TextFieldColors r26, androidx.compose.ui.graphics.Shape r27, float r28, float r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r22 = this;
            r9 = r31
            r0 = -1998946250(0xffffffff88da8036, float:-1.315054E-33)
            r1 = r30
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(OutlinedBorderContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)600@32285L5,603@32503L286:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r32 & 1
            if (r2 == 0) goto L_0x001a
            r2 = r9 | 6
            r3 = r2
            r2 = r23
            goto L_0x002e
        L_0x001a:
            r2 = r9 & 6
            if (r2 != 0) goto L_0x002b
            r2 = r23
            boolean r3 = r1.changed((boolean) r2)
            if (r3 == 0) goto L_0x0028
            r3 = 4
            goto L_0x0029
        L_0x0028:
            r3 = 2
        L_0x0029:
            r3 = r3 | r9
            goto L_0x002e
        L_0x002b:
            r2 = r23
            r3 = r9
        L_0x002e:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x0035
            r3 = r3 | 48
            goto L_0x0048
        L_0x0035:
            r4 = r9 & 48
            if (r4 != 0) goto L_0x0048
            r4 = r24
            boolean r5 = r1.changed((boolean) r4)
            if (r5 == 0) goto L_0x0044
            r5 = 32
            goto L_0x0046
        L_0x0044:
            r5 = 16
        L_0x0046:
            r3 = r3 | r5
            goto L_0x004a
        L_0x0048:
            r4 = r24
        L_0x004a:
            r5 = r32 & 4
            if (r5 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r5 = r9 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0064
            r5 = r25
            boolean r6 = r1.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0060
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r3 = r3 | r6
            goto L_0x0066
        L_0x0064:
            r5 = r25
        L_0x0066:
            r6 = r32 & 8
            if (r6 == 0) goto L_0x006d
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r6 = r9 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L_0x0080
            r6 = r26
            boolean r7 = r1.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x007c
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r7
            goto L_0x0082
        L_0x0080:
            r6 = r26
        L_0x0082:
            r7 = r9 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x009b
            r7 = r32 & 16
            if (r7 != 0) goto L_0x0095
            r7 = r27
            boolean r8 = r1.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0097
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0095:
            r7 = r27
        L_0x0097:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r3 = r3 | r8
            goto L_0x009d
        L_0x009b:
            r7 = r27
        L_0x009d:
            r8 = r32 & 32
            r10 = 196608(0x30000, float:2.75506E-40)
            if (r8 == 0) goto L_0x00a5
            r3 = r3 | r10
            goto L_0x00b7
        L_0x00a5:
            r10 = r10 & r9
            if (r10 != 0) goto L_0x00b7
            r10 = r28
            boolean r11 = r1.changed((float) r10)
            if (r11 == 0) goto L_0x00b3
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r3 = r3 | r11
            goto L_0x00b9
        L_0x00b7:
            r10 = r28
        L_0x00b9:
            r11 = r32 & 64
            r12 = 1572864(0x180000, float:2.204052E-39)
            if (r11 == 0) goto L_0x00c1
            r3 = r3 | r12
            goto L_0x00d3
        L_0x00c1:
            r12 = r12 & r9
            if (r12 != 0) goto L_0x00d3
            r12 = r29
            boolean r13 = r1.changed((float) r12)
            if (r13 == 0) goto L_0x00cf
            r13 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r13 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r3 = r3 | r13
            goto L_0x00d5
        L_0x00d3:
            r12 = r29
        L_0x00d5:
            r13 = 599187(0x92493, float:8.3964E-40)
            r13 = r13 & r3
            r14 = 599186(0x92492, float:8.39638E-40)
            if (r13 != r14) goto L_0x00eb
            boolean r13 = r1.getSkipping()
            if (r13 != 0) goto L_0x00e5
            goto L_0x00eb
        L_0x00e5:
            r1.skipToGroupEnd()
            r8 = r10
            goto L_0x017b
        L_0x00eb:
            r1.startDefaults()
            r13 = r9 & 1
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            if (r13 == 0) goto L_0x0108
            boolean r13 = r1.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00fc
            goto L_0x0108
        L_0x00fc:
            r1.skipToGroupEnd()
            r8 = r32 & 16
            if (r8 == 0) goto L_0x0104
            r3 = r3 & r14
        L_0x0104:
            r8 = r10
        L_0x0105:
            r10 = r3
            r3 = r12
            goto L_0x012f
        L_0x0108:
            r13 = r32 & 16
            if (r13 == 0) goto L_0x0118
            androidx.compose.material3.tokens.OutlinedTextFieldTokens r7 = androidx.compose.material3.tokens.OutlinedTextFieldTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r7 = r7.getContainerShape()
            r13 = 6
            androidx.compose.ui.graphics.Shape r7 = androidx.compose.material3.ShapesKt.getValue(r7, r1, r13)
            r3 = r3 & r14
        L_0x0118:
            if (r8 == 0) goto L_0x0121
            androidx.compose.material3.OutlinedTextFieldDefaults r8 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            float r8 = r8.m2042getFocusedBorderThicknessD9Ej5fM()
            goto L_0x0122
        L_0x0121:
            r8 = r10
        L_0x0122:
            if (r11 == 0) goto L_0x0105
            androidx.compose.material3.OutlinedTextFieldDefaults r10 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            float r10 = r10.m2045getUnfocusedBorderThicknessD9Ej5fM()
            r21 = r10
            r10 = r3
            r3 = r21
        L_0x012f:
            r1.endDefaults()
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x013e
            r11 = -1
            java.lang.String r12 = "androidx.compose.material3.TextFieldDefaults.OutlinedBorderContainerBox (TextFieldDefaults.kt:603)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r11, r12)
        L_0x013e:
            androidx.compose.material3.OutlinedTextFieldDefaults r0 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r11 = r10 & 14
            r12 = 12582912(0xc00000, float:1.7632415E-38)
            r11 = r11 | r12
            r12 = r10 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            r12 = r10 & 896(0x380, float:1.256E-42)
            r11 = r11 | r12
            r12 = r10 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r10
            r11 = r11 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r10
            r11 = r11 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r12
            r19 = r11 | r10
            r20 = 0
            r10 = r0
            r11 = r23
            r12 = r24
            r13 = r25
            r14 = r26
            r15 = r7
            r16 = r8
            r17 = r3
            r18 = r1
            r10.m2039ContainerBoxnbWgWpA(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x017a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x017a:
            r12 = r3
        L_0x017b:
            androidx.compose.runtime.ScopeUpdateScope r11 = r1.endRestartGroup()
            if (r11 == 0) goto L_0x019d
            androidx.compose.material3.TextFieldDefaults$OutlinedBorderContainerBox$1 r13 = new androidx.compose.material3.TextFieldDefaults$OutlinedBorderContainerBox$1
            r0 = r13
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r7
            r7 = r8
            r8 = r12
            r9 = r31
            r10 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r11.updateScope(r13)
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m2424OutlinedBorderContainerBoxnbWgWpA(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2422textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m2441textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* renamed from: textFieldWithLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2441textFieldWithLabelPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return m2426contentPaddingWithLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2423textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2442textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithoutLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2442textFieldWithoutLabelPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return m2427contentPaddingWithoutLabela9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m2420outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m2437outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.contentPadding(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: outlinedTextFieldPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m2437outlinedTextFieldPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return OutlinedTextFieldDefaults.INSTANCE.m2041contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.colors` with additional parameters to controlcontainer color based on state.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.colors(\n        focusedTextColor = focusedTextColor,\n        unfocusedTextColor = unfocusedTextColor,\n        disabledTextColor = disabledTextColor,\n        errorTextColor = errorTextColor,\n        focusedContainerColor = containerColor,\n        unfocusedContainerColor = containerColor,\n        disabledContainerColor = containerColor,\n        errorContainerColor = errorContainerColor,\n        cursorColor = cursorColor,\n        errorCursorColor = errorCursorColor,\n        selectionColors = selectionColors,\n        focusedIndicatorColor = focusedIndicatorColor,\n        unfocusedIndicatorColor = unfocusedIndicatorColor,\n        disabledIndicatorColor = disabledIndicatorColor,\n        errorIndicatorColor = errorIndicatorColor,\n        focusedLeadingIconColor = focusedLeadingIconColor,\n        unfocusedLeadingIconColor = unfocusedLeadingIconColor,\n        disabledLeadingIconColor = disabledLeadingIconColor,\n        errorLeadingIconColor = errorLeadingIconColor,\n        focusedTrailingIconColor = focusedTrailingIconColor,\n        unfocusedTrailingIconColor = unfocusedTrailingIconColor,\n        disabledTrailingIconColor = disabledTrailingIconColor,\n        errorTrailingIconColor = errorTrailingIconColor,\n        focusedLabelColor = focusedLabelColor,\n        unfocusedLabelColor = unfocusedLabelColor,\n        disabledLabelColor = disabledLabelColor,\n        errorLabelColor = errorLabelColor,\n        focusedPlaceholderColor = focusedPlaceholderColor,\n        unfocusedPlaceholderColor = unfocusedPlaceholderColor,\n        disabledPlaceholderColor = disabledPlaceholderColor,\n        errorPlaceholderColor = errorPlaceholderColor,\n        focusedSupportingTextColor = focusedSupportingTextColor,\n        unfocusedSupportingTextColor = unfocusedSupportingTextColor,\n        disabledSupportingTextColor = disabledSupportingTextColor,\n        errorSupportingTextColor = errorSupportingTextColor,\n        focusedPrefixColor = focusedPrefixColor,\n        unfocusedPrefixColor = unfocusedPrefixColor,\n        disabledPrefixColor = disabledPrefixColor,\n        errorPrefixColor = errorPrefixColor,\n        focusedSuffixColor = focusedSuffixColor,\n        unfocusedSuffixColor = unfocusedSuffixColor,\n        disabledSuffixColor = disabledSuffixColor,\n        errorSuffixColor = errorSuffixColor,\n    )", imports = {}))
    /* renamed from: textFieldColors-M37tBTI  reason: not valid java name */
    public final TextFieldColors m2439textFieldColorsM37tBTI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        TextSelectionColors textSelectionColors2;
        long j41;
        int i8;
        long j42;
        int i9;
        long j43;
        int i10;
        long j44;
        int i11;
        long j45;
        int i12;
        long j46;
        int i13;
        long j47;
        int i14;
        long j48;
        int i15;
        Composer composer2 = composer;
        int i16 = i;
        int i17 = i2;
        int i18 = i6;
        int i19 = i7;
        composer2.startReplaceableGroup(568209592);
        ComposerKt.sourceInformation(composer2, "C(textFieldColors)P(29:c#ui.graphics.Color,39:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,31,22:c#ui.graphics.Color,32:c#ui.graphics.Color,2:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,30:c#ui.graphics.Color,40:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,27:c#ui.graphics.Color,37:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)733@38609L5,734@38685L5,735@38768L5,737@38915L5,738@38991L5,739@39072L5,740@39141L5,741@39225L5,742@39304L7,743@39400L5,744@39491L5,745@39589L5,747@39761L5,748@39853L5,749@39942L5,750@40038L5,752@40204L5,753@40298L5,754@40389L5,755@40487L5,757@40656L5,758@40736L5,759@40813L5,760@40897L5,762@41045L5,763@41137L5,764@41231L5,765@41321L5,767@41481L5,768@41575L5,769@41666L5,770@41764L5,772@41931L5,773@42013L5,774@42097L5,775@42180L5,777@42330L5,778@42412L5,779@42496L5,780@42579L5,782@42729L5,783@42761L2308:TextFieldDefaults.kt#uh7d8r");
        long value = (i18 & 1) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusInputColor(), composer2, 6) : j;
        long value2 = (i18 & 2) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputColor(), composer2, 6) : j2;
        long r11 = (i18 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long value3 = (i18 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorInputColor(), composer2, 6) : j4;
        long value4 = (i18 & 16) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerColor(), composer2, 6) : j5;
        long value5 = (i18 & 32) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerColor(), composer2, 6) : j6;
        long value6 = (i18 & 64) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer2, 6) : j7;
        long value7 = (i18 & 128) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer2, 6) : j8;
        if ((i18 & 256) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i18 & 512) != 0) {
            i8 = 6;
            j41 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor(), composer2, 6);
        } else {
            i8 = 6;
            j41 = j9;
        }
        long value8 = (i18 & 1024) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor(), composer2, i8) : j10;
        long r31 = (i18 & 2048) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor(), composer2, i8), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        if ((i18 & 4096) != 0) {
            i9 = 6;
            j42 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor(), composer2, 6);
        } else {
            i9 = 6;
            j42 = j12;
        }
        long value9 = (i18 & 8192) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer2, i9) : j13;
        long value10 = (i18 & 16384) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getLeadingIconColor(), composer2, i9) : j14;
        long r39 = (32768 & i18) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer2, i9), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j15;
        if ((65536 & i18) != 0) {
            i10 = 6;
            j43 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer2, 6);
        } else {
            i10 = 6;
            j43 = j16;
        }
        long value11 = (131072 & i18) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer2, i10) : j17;
        long value12 = (262144 & i18) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getTrailingIconColor(), composer2, i10) : j18;
        long r47 = (524288 & i18) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer2, i10), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j19;
        if ((1048576 & i18) != 0) {
            i11 = 6;
            j44 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer2, 6);
        } else {
            i11 = 6;
            j44 = j20;
        }
        long value13 = (2097152 & i18) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusLabelColor(), composer2, i11) : j21;
        long value14 = (4194304 & i18) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getLabelColor(), composer2, i11) : j22;
        long r55 = (8388608 & i18) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer2, i11), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j23;
        if ((16777216 & i18) != 0) {
            i12 = 6;
            j45 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorLabelColor(), composer2, 6);
        } else {
            i12 = 6;
            j45 = j24;
        }
        long value15 = (33554432 & i18) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer2, i12) : j25;
        long value16 = (67108864 & i18) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer2, i12) : j26;
        long r63 = (134217728 & i18) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, i12), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j27;
        if ((268435456 & i18) != 0) {
            i13 = 6;
            j46 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer2, 6);
        } else {
            i13 = 6;
            j46 = j28;
        }
        long value17 = (536870912 & i18) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer2, i13) : j29;
        long value18 = (i18 & 1073741824) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getSupportingColor(), composer2, i13) : j30;
        long r71 = (i19 & 1) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer2, i13), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j31;
        if ((i19 & 2) != 0) {
            i14 = 6;
            j47 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer2, 6);
        } else {
            i14 = 6;
            j47 = j32;
        }
        long value19 = (i19 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, i14) : j33;
        long value20 = (i19 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, i14) : j34;
        long r79 = (i19 & 16) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, i14), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j35;
        if ((i19 & 32) != 0) {
            i15 = 6;
            j48 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, 6);
        } else {
            i15 = 6;
            j48 = j36;
        }
        long value21 = (i19 & 64) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, i15) : j37;
        long value22 = (i19 & 128) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, i15) : j38;
        long r94 = (i19 & 256) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, i15), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j39;
        long value23 = (i19 & 512) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, 6) : j40;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(568209592, i16, i17, "androidx.compose.material3.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:783)");
        }
        int i20 = i16 << 6;
        int i21 = i17 << 6;
        int i22 = i3 << 6;
        int i23 = ((i17 >> 24) & 126) | (i22 & 896) | (i22 & 7168) | (i22 & 57344) | (i22 & 458752) | (i22 & 3670016) | (i22 & 29360128) | (i22 & 234881024) | (i22 & 1879048192);
        int i24 = i4 << 6;
        int i25 = ((i3 >> 24) & 126) | (i24 & 896) | (i24 & 7168) | (i24 & 57344) | (i24 & 458752) | (i24 & 3670016) | (i24 & 29360128) | (i24 & 234881024) | (i24 & 1879048192);
        int i26 = i5 << 6;
        TextFieldColors r0 = m2425colors0hiis_0(value, value2, r11, value3, value4, value4, value4, value5, value6, value7, textSelectionColors2, j41, value8, r31, j42, value9, value10, r39, j43, value11, value12, r47, j44, value13, value14, r55, j45, value15, value16, r63, j46, value17, value18, r71, j47, value19, value20, r79, j48, value21, value22, r94, value23, composer, (65534 & i16) | ((i16 << 3) & 458752) | (i20 & 3670016) | (i20 & 29360128) | (i20 & 234881024) | (i20 & 1879048192), ((i16 >> 24) & 126) | (i21 & 896) | (i21 & 7168) | (i21 & 57344) | (i21 & 458752) | (i21 & 3670016) | (i21 & 29360128) | (i21 & 234881024) | (i21 & 1879048192), i23, i25, ((i4 >> 24) & 126) | (i26 & 896) | (i26 & 7168), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.colors` with additional parameters tocontrol container color based on state.", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.colors(\n        focusedTextColor = focusedTextColor,\n        unfocusedTextColor = unfocusedTextColor,\n        disabledTextColor = disabledTextColor,\n        errorTextColor = errorTextColor,\n        focusedContainerColor = containerColor,\n        unfocusedContainerColor = containerColor,\n        disabledContainerColor = containerColor,\n        errorContainerColor = errorContainerColor,\n        cursorColor = cursorColor,\n        errorCursorColor = errorCursorColor,\n        selectionColors = selectionColors,\n        focusedBorderColor = focusedBorderColor,\n        unfocusedBorderColor = unfocusedBorderColor,\n        disabledBorderColor = disabledBorderColor,\n        errorBorderColor = errorBorderColor,\n        focusedLeadingIconColor = focusedLeadingIconColor,\n        unfocusedLeadingIconColor = unfocusedLeadingIconColor,\n        disabledLeadingIconColor = disabledLeadingIconColor,\n        errorLeadingIconColor = errorLeadingIconColor,\n        focusedTrailingIconColor = focusedTrailingIconColor,\n        unfocusedTrailingIconColor = unfocusedTrailingIconColor,\n        disabledTrailingIconColor = disabledTrailingIconColor,\n        errorTrailingIconColor = errorTrailingIconColor,\n        focusedLabelColor = focusedLabelColor,\n        unfocusedLabelColor = unfocusedLabelColor,\n        disabledLabelColor = disabledLabelColor,\n        errorLabelColor = errorLabelColor,\n        focusedPlaceholderColor = focusedPlaceholderColor,\n        unfocusedPlaceholderColor = unfocusedPlaceholderColor,\n        disabledPlaceholderColor = disabledPlaceholderColor,\n        errorPlaceholderColor = errorPlaceholderColor,\n        focusedSupportingTextColor = focusedSupportingTextColor,\n        unfocusedSupportingTextColor = unfocusedSupportingTextColor,\n        disabledSupportingTextColor = disabledSupportingTextColor,\n        errorSupportingTextColor = errorSupportingTextColor,\n        focusedPrefixColor = focusedPrefixColor,\n        unfocusedPrefixColor = unfocusedPrefixColor,\n        disabledPrefixColor = disabledPrefixColor,\n        errorPrefixColor = errorPrefixColor,\n        focusedSuffixColor = focusedSuffixColor,\n        unfocusedSuffixColor = unfocusedSuffixColor,\n        disabledSuffixColor = disabledSuffixColor,\n        errorSuffixColor = errorSuffixColor,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* renamed from: outlinedTextFieldColors-M37tBTI  reason: not valid java name */
    public final TextFieldColors m2435outlinedTextFieldColorsM37tBTI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        TextSelectionColors textSelectionColors2;
        long j41;
        int i8;
        long j42;
        int i9;
        long j43;
        int i10;
        long j44;
        int i11;
        long j45;
        int i12;
        long j46;
        int i13;
        long j47;
        int i14;
        long j48;
        int i15;
        Composer composer2 = composer;
        int i16 = i;
        int i17 = i2;
        int i18 = i6;
        int i19 = i7;
        composer2.startReplaceableGroup(618732090);
        ComposerKt.sourceInformation(composer2, "C(outlinedTextFieldColors)P(29:c#ui.graphics.Color,39:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,1:c#ui.graphics.Color,13:c#ui.graphics.Color,31,22:c#ui.graphics.Color,32:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,30:c#ui.graphics.Color,40:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,27:c#ui.graphics.Color,37:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)883@48650L5,884@48728L5,885@48813L5,887@48964L5,890@49142L5,891@49228L5,892@49307L7,893@49394L5,894@49476L5,895@49565L5,897@49722L5,898@49816L5,899@49907L5,900@50005L5,902@50175L5,903@50271L5,904@50364L5,906@50477L5,907@50637L5,908@50719L5,909@50798L5,910@50884L5,912@51036L5,913@51130L5,914@51226L5,915@51318L5,917@51482L5,918@51578L5,919@51671L5,921@51784L5,922@51942L5,923@52026L5,924@52112L5,925@52197L5,927@52351L5,928@52435L5,929@52521L5,930@52606L5,932@52760L5,933@52818L2284:TextFieldDefaults.kt#uh7d8r");
        long value = (i18 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusInputColor(), composer2, 6) : j;
        long value2 = (i18 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputColor(), composer2, 6) : j2;
        long r11 = (i18 & 4) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long value3 = (i18 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorInputColor(), composer2, 6) : j4;
        long r16 = (i18 & 16) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j5;
        long r18 = (i18 & 32) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j6;
        long value4 = (i18 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getCaretColor(), composer2, 6) : j7;
        long value5 = (i18 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer2, 6) : j8;
        if ((i18 & 256) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i18 & 512) != 0) {
            i8 = 6;
            j41 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor(), composer2, 6);
        } else {
            i8 = 6;
            j41 = j9;
        }
        long value6 = (i18 & 1024) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getOutlineColor(), composer2, i8) : j10;
        long r31 = (i18 & 2048) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor(), composer2, i8), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        if ((i18 & 4096) != 0) {
            i9 = 6;
            j42 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor(), composer2, 6);
        } else {
            i9 = 6;
            j42 = j12;
        }
        long value7 = (i18 & 8192) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer2, i9) : j13;
        long value8 = (i18 & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor(), composer2, i9) : j14;
        long r39 = (32768 & i18) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer2, i9), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j15;
        if ((65536 & i18) != 0) {
            i10 = 6;
            j43 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer2, 6);
        } else {
            i10 = 6;
            j43 = j16;
        }
        long value9 = (131072 & i18) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer2, i10) : j17;
        long value10 = (262144 & i18) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor(), composer2, i10) : j18;
        long r47 = (524288 & i18) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer2, i10), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j19;
        if ((1048576 & i18) != 0) {
            i11 = 6;
            j44 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer2, 6);
        } else {
            i11 = 6;
            j44 = j20;
        }
        long value11 = (2097152 & i18) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor(), composer2, i11) : j21;
        long value12 = (4194304 & i18) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getLabelColor(), composer2, i11) : j22;
        long r55 = (8388608 & i18) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer2, i11), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j23;
        if ((16777216 & i18) != 0) {
            i12 = 6;
            j45 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor(), composer2, 6);
        } else {
            i12 = 6;
            j45 = j24;
        }
        long value13 = (33554432 & i18) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer2, i12) : j25;
        long value14 = (67108864 & i18) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer2, i12) : j26;
        long r63 = (134217728 & i18) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, i12), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j27;
        if ((268435456 & i18) != 0) {
            i13 = 6;
            j46 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer2, 6);
        } else {
            i13 = 6;
            j46 = j28;
        }
        long value15 = (536870912 & i18) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer2, i13) : j29;
        long value16 = (i18 & 1073741824) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getSupportingColor(), composer2, i13) : j30;
        long r71 = (i19 & 1) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer2, i13), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j31;
        if ((i19 & 2) != 0) {
            i14 = 6;
            j47 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer2, 6);
        } else {
            i14 = 6;
            j47 = j32;
        }
        long value17 = (i19 & 4) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, i14) : j33;
        long value18 = (i19 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, i14) : j34;
        long r79 = (i19 & 16) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, i14), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j35;
        if ((i19 & 32) != 0) {
            i15 = 6;
            j48 = ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, 6);
        } else {
            i15 = 6;
            j48 = j36;
        }
        long value19 = (i19 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, i15) : j37;
        long value20 = (i19 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, i15) : j38;
        long r94 = (i19 & 256) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, i15), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j39;
        long value21 = (i19 & 512) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, 6) : j40;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(618732090, i16, i17, "androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:933)");
        }
        int i20 = i16 << 6;
        int i21 = (65534 & i16) | ((i16 << 3) & 458752) | (i20 & 3670016) | (i20 & 29360128) | (i20 & 234881024) | (i20 & 1879048192);
        int i22 = i17 << 6;
        int i23 = i3 << 6;
        int i24 = ((i17 >> 24) & 126) | (i23 & 896) | (i23 & 7168) | (i23 & 57344) | (i23 & 458752) | (i23 & 3670016) | (i23 & 29360128) | (i23 & 234881024) | (i23 & 1879048192);
        int i25 = i4 << 6;
        int i26 = i4 >> 24;
        TextFieldColors r0 = OutlinedTextFieldDefaults.INSTANCE.m2040colors0hiis_0(value, value2, r11, value3, r16, r16, r16, r18, value4, value5, textSelectionColors2, j41, value6, r31, j42, value7, value8, r39, j43, value9, value10, r47, j44, value11, value12, r55, j45, value13, value14, r63, j46, value15, value16, r71, j47, value17, value18, r79, j48, value19, value20, r94, value21, composer, i21, ((i16 >> 24) & 126) | (i22 & 896) | (i22 & 7168) | (i22 & 57344) | (i22 & 458752) | (i22 & 3670016) | (i22 & 29360128) | (i22 & 234881024) | (i22 & 1879048192), i24, ((i3 >> 24) & 126) | (i25 & 896) | (i25 & 7168) | (i25 & 57344) | (i25 & 458752) | (i25 & 3670016) | (i25 & 29360128) | (i25 & 234881024) | (i25 & 1879048192), (i26 & 112) | (i26 & 14) | 3072 | ((i5 << 6) & 896), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:270:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012e  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.DecorationBox`", replaceWith = @kotlin.ReplaceWith(expression = "TextFieldDefaults.DecorationBox(\n        value = value,\n        innerTextField = innerTextField,\n        enabled = enabled,\n        singleLine = singleLine,\n        visualTransformation = visualTransformation,\n        interactionSource = interactionSource,\n        isError = isError,\n        label = label,\n        placeholder = placeholder,\n        leadingIcon = leadingIcon,\n        trailingIcon = trailingIcon,\n        prefix = prefix,\n        suffix = suffix,\n        supportingText = supportingText,\n        shape = shape,\n        colors = colors,\n        contentPadding = contentPadding,\n        container = container,\n    )", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void TextFieldDecorationBox(java.lang.String r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, boolean r40, boolean r41, androidx.compose.ui.text.input.VisualTransformation r42, androidx.compose.foundation.interaction.InteractionSource r43, boolean r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.ui.graphics.Shape r52, androidx.compose.material3.TextFieldColors r53, androidx.compose.foundation.layout.PaddingValues r54, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.runtime.Composer r56, int r57, int r58, int r59) {
        /*
            r37 = this;
            r15 = r37
            r14 = r57
            r13 = r58
            r12 = r59
            r0 = -1042273141(0xffffffffc1e02c8b, float:-28.02175)
            r1 = r56
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextFieldDecorationBox)P(16,4,3,12,17,5,6,7,9,8,15,10,13,14,11!1,2)1020@56995L5,1021@57036L8,1031@57383L612:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x001f
            r0 = r14 | 6
            r10 = r38
            goto L_0x0031
        L_0x001f:
            r0 = r14 & 6
            r10 = r38
            if (r0 != 0) goto L_0x0030
            boolean r0 = r11.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x002d
            r0 = 4
            goto L_0x002e
        L_0x002d:
            r0 = 2
        L_0x002e:
            r0 = r0 | r14
            goto L_0x0031
        L_0x0030:
            r0 = r14
        L_0x0031:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x003a
            r0 = r0 | 48
            r9 = r39
            goto L_0x004c
        L_0x003a:
            r3 = r14 & 48
            r9 = r39
            if (r3 != 0) goto L_0x004c
            boolean r3 = r11.changedInstance(r9)
            if (r3 == 0) goto L_0x0049
            r3 = 32
            goto L_0x004b
        L_0x0049:
            r3 = 16
        L_0x004b:
            r0 = r0 | r3
        L_0x004c:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            r8 = r40
            goto L_0x0067
        L_0x0055:
            r3 = r14 & 384(0x180, float:5.38E-43)
            r8 = r40
            if (r3 != 0) goto L_0x0067
            boolean r3 = r11.changed((boolean) r8)
            if (r3 == 0) goto L_0x0064
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r3
        L_0x0067:
            r3 = r12 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0072
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0072:
            r3 = r14 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0086
            r3 = r41
            boolean r18 = r11.changed((boolean) r3)
            if (r18 == 0) goto L_0x0081
            r18 = r16
            goto L_0x0083
        L_0x0081:
            r18 = r17
        L_0x0083:
            r0 = r0 | r18
            goto L_0x0088
        L_0x0086:
            r3 = r41
        L_0x0088:
            r18 = r12 & 16
            r19 = 8192(0x2000, float:1.14794E-41)
            r20 = 16384(0x4000, float:2.2959E-41)
            if (r18 == 0) goto L_0x0093
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a7
        L_0x0093:
            r1 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r1 != 0) goto L_0x00a7
            r1 = r42
            boolean r18 = r11.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x00a2
            r18 = r20
            goto L_0x00a4
        L_0x00a2:
            r18 = r19
        L_0x00a4:
            r0 = r0 | r18
            goto L_0x00a9
        L_0x00a7:
            r1 = r42
        L_0x00a9:
            r18 = r12 & 32
            r21 = 196608(0x30000, float:2.75506E-40)
            r22 = 65536(0x10000, float:9.18355E-41)
            if (r18 == 0) goto L_0x00b6
            r0 = r0 | r21
            r10 = r43
            goto L_0x00c9
        L_0x00b6:
            r18 = r14 & r21
            r10 = r43
            if (r18 != 0) goto L_0x00c9
            boolean r18 = r11.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x00c5
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c5:
            r18 = r22
        L_0x00c7:
            r0 = r0 | r18
        L_0x00c9:
            r18 = r12 & 64
            r23 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00d4
            r0 = r0 | r23
            r2 = r44
            goto L_0x00e7
        L_0x00d4:
            r24 = r14 & r23
            r2 = r44
            if (r24 != 0) goto L_0x00e7
            boolean r25 = r11.changed((boolean) r2)
            if (r25 == 0) goto L_0x00e3
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r0 = r0 | r25
        L_0x00e7:
            r4 = r12 & 128(0x80, float:1.794E-43)
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            if (r4 == 0) goto L_0x00f2
            r0 = r0 | r26
            r5 = r45
            goto L_0x0105
        L_0x00f2:
            r27 = r14 & r26
            r5 = r45
            if (r27 != 0) goto L_0x0105
            boolean r28 = r11.changedInstance(r5)
            if (r28 == 0) goto L_0x0101
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0103
        L_0x0101:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x0103:
            r0 = r0 | r28
        L_0x0105:
            r6 = r12 & 256(0x100, float:3.59E-43)
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            if (r6 == 0) goto L_0x0110
            r0 = r0 | r29
            r7 = r46
            goto L_0x0123
        L_0x0110:
            r30 = r14 & r29
            r7 = r46
            if (r30 != 0) goto L_0x0123
            boolean r31 = r11.changedInstance(r7)
            if (r31 == 0) goto L_0x011f
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0121
        L_0x011f:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0121:
            r0 = r0 | r31
        L_0x0123:
            r1 = r12 & 512(0x200, float:7.175E-43)
            r31 = 805306368(0x30000000, float:4.656613E-10)
            if (r1 == 0) goto L_0x012e
            r0 = r0 | r31
            r2 = r47
            goto L_0x0141
        L_0x012e:
            r31 = r14 & r31
            r2 = r47
            if (r31 != 0) goto L_0x0141
            boolean r31 = r11.changedInstance(r2)
            if (r31 == 0) goto L_0x013d
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013f
        L_0x013d:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013f:
            r0 = r0 | r31
        L_0x0141:
            r2 = r12 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x014a
            r24 = r13 | 6
            r3 = r48
            goto L_0x0160
        L_0x014a:
            r31 = r13 & 6
            r3 = r48
            if (r31 != 0) goto L_0x015e
            boolean r31 = r11.changedInstance(r3)
            if (r31 == 0) goto L_0x0159
            r24 = 4
            goto L_0x015b
        L_0x0159:
            r24 = 2
        L_0x015b:
            r24 = r13 | r24
            goto L_0x0160
        L_0x015e:
            r24 = r13
        L_0x0160:
            r3 = r12 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x0167
            r24 = r24 | 48
            goto L_0x017a
        L_0x0167:
            r31 = r13 & 48
            r5 = r49
            if (r31 != 0) goto L_0x017a
            boolean r31 = r11.changedInstance(r5)
            if (r31 == 0) goto L_0x0176
            r25 = 32
            goto L_0x0178
        L_0x0176:
            r25 = 16
        L_0x0178:
            r24 = r24 | r25
        L_0x017a:
            r5 = r24
            r7 = r12 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0183
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0197
        L_0x0183:
            r8 = r13 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0197
            r8 = r50
            boolean r24 = r11.changedInstance(r8)
            if (r24 == 0) goto L_0x0192
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x0194
        L_0x0192:
            r28 = 128(0x80, float:1.794E-43)
        L_0x0194:
            r5 = r5 | r28
            goto L_0x0199
        L_0x0197:
            r8 = r50
        L_0x0199:
            r8 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x01a0
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b2
        L_0x01a0:
            r9 = r13 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x01b2
            r9 = r51
            boolean r24 = r11.changedInstance(r9)
            if (r24 == 0) goto L_0x01ad
            goto L_0x01af
        L_0x01ad:
            r16 = r17
        L_0x01af:
            r5 = r5 | r16
            goto L_0x01b4
        L_0x01b2:
            r9 = r51
        L_0x01b4:
            r9 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x01cc
            r9 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r9 != 0) goto L_0x01c7
            r9 = r52
            boolean r16 = r11.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x01c9
            r19 = r20
            goto L_0x01c9
        L_0x01c7:
            r9 = r52
        L_0x01c9:
            r5 = r5 | r19
            goto L_0x01ce
        L_0x01cc:
            r9 = r52
        L_0x01ce:
            r16 = r13 & r21
            if (r16 != 0) goto L_0x01e9
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r12 & r16
            r9 = r53
            if (r16 != 0) goto L_0x01e4
            boolean r16 = r11.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x01e4
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01e6
        L_0x01e4:
            r16 = r22
        L_0x01e6:
            r5 = r5 | r16
            goto L_0x01eb
        L_0x01e9:
            r9 = r53
        L_0x01eb:
            r16 = r13 & r23
            if (r16 != 0) goto L_0x0203
            r16 = r12 & r22
            r9 = r54
            if (r16 != 0) goto L_0x01fe
            boolean r16 = r11.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x01fe
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0200
        L_0x01fe:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x0200:
            r5 = r5 | r16
            goto L_0x0205
        L_0x0203:
            r9 = r54
        L_0x0205:
            r16 = 131072(0x20000, float:1.83671E-40)
            r16 = r12 & r16
            if (r16 == 0) goto L_0x0210
            r5 = r5 | r26
            r9 = r55
            goto L_0x0223
        L_0x0210:
            r17 = r13 & r26
            r9 = r55
            if (r17 != 0) goto L_0x0223
            boolean r17 = r11.changedInstance(r9)
            if (r17 == 0) goto L_0x021f
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0221
        L_0x021f:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x0221:
            r5 = r5 | r17
        L_0x0223:
            r17 = 262144(0x40000, float:3.67342E-40)
            r17 = r12 & r17
            if (r17 == 0) goto L_0x022c
            r5 = r5 | r29
            goto L_0x023d
        L_0x022c:
            r17 = r13 & r29
            if (r17 != 0) goto L_0x023d
            boolean r17 = r11.changed((java.lang.Object) r15)
            if (r17 == 0) goto L_0x0239
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x023b
        L_0x0239:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x023b:
            r5 = r5 | r17
        L_0x023d:
            r17 = 306783379(0x12492493, float:6.34695E-28)
            r9 = r0 & r17
            r10 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r10) goto L_0x0276
            r9 = 38347923(0x2492493, float:1.4777644E-37)
            r9 = r9 & r5
            r10 = 38347922(0x2492492, float:1.4777643E-37)
            if (r9 != r10) goto L_0x0276
            boolean r9 = r11.getSkipping()
            if (r9 != 0) goto L_0x0257
            goto L_0x0276
        L_0x0257:
            r11.skipToGroupEnd()
            r8 = r44
            r9 = r45
            r10 = r46
            r12 = r48
            r13 = r49
            r14 = r50
            r15 = r51
            r16 = r52
            r17 = r53
            r18 = r54
            r19 = r55
            r35 = r11
            r11 = r47
            goto L_0x0417
        L_0x0276:
            r11.startDefaults()
            r9 = r14 & 1
            if (r9 == 0) goto L_0x02bb
            boolean r9 = r11.getDefaultsInvalid()
            if (r9 == 0) goto L_0x0284
            goto L_0x02bb
        L_0x0284:
            r11.skipToGroupEnd()
            r1 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x028f
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = r5 & r1
        L_0x028f:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r12
            if (r1 == 0) goto L_0x0299
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r5 = r5 & r1
        L_0x0299:
            r1 = r12 & r22
            if (r1 == 0) goto L_0x02a1
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r1
        L_0x02a1:
            r23 = r44
            r24 = r45
            r25 = r46
            r26 = r47
            r27 = r48
            r28 = r49
            r29 = r50
            r30 = r51
            r31 = r52
            r32 = r53
            r33 = r54
            r34 = r55
            goto L_0x03ac
        L_0x02bb:
            if (r18 == 0) goto L_0x02bf
            r9 = 0
            goto L_0x02c1
        L_0x02bf:
            r9 = r44
        L_0x02c1:
            r10 = 0
            if (r4 == 0) goto L_0x02c6
            r4 = r10
            goto L_0x02c8
        L_0x02c6:
            r4 = r45
        L_0x02c8:
            if (r6 == 0) goto L_0x02cc
            r6 = r10
            goto L_0x02ce
        L_0x02cc:
            r6 = r46
        L_0x02ce:
            if (r1 == 0) goto L_0x02d2
            r1 = r10
            goto L_0x02d4
        L_0x02d2:
            r1 = r47
        L_0x02d4:
            if (r2 == 0) goto L_0x02d8
            r2 = r10
            goto L_0x02da
        L_0x02d8:
            r2 = r48
        L_0x02da:
            if (r3 == 0) goto L_0x02de
            r3 = r10
            goto L_0x02e0
        L_0x02de:
            r3 = r49
        L_0x02e0:
            if (r7 == 0) goto L_0x02e4
            r7 = r10
            goto L_0x02e6
        L_0x02e4:
            r7 = r50
        L_0x02e6:
            if (r8 == 0) goto L_0x02e9
            goto L_0x02eb
        L_0x02e9:
            r10 = r51
        L_0x02eb:
            r8 = r12 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x02fd
            androidx.compose.material3.TextFieldDefaults r8 = INSTANCE
            r56 = r1
            r1 = 6
            androidx.compose.ui.graphics.Shape r1 = r8.getShape(r11, r1)
            r8 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = r5 & r8
            goto L_0x0301
        L_0x02fd:
            r56 = r1
            r1 = r52
        L_0x0301:
            r8 = 32768(0x8000, float:4.5918E-41)
            r8 = r8 & r12
            if (r8 == 0) goto L_0x0315
            int r8 = r5 >> 24
            r8 = r8 & 14
            androidx.compose.material3.TextFieldColors r8 = r15.colors(r11, r8)
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r5 = r5 & r17
            goto L_0x0317
        L_0x0315:
            r8 = r53
        L_0x0317:
            r17 = r12 & r22
            if (r17 == 0) goto L_0x0360
            if (r4 != 0) goto L_0x033c
            r17 = 15
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r44 = r37
            r45 = r19
            r46 = r20
            r47 = r21
            r48 = r22
            r49 = r17
            r50 = r18
            androidx.compose.foundation.layout.PaddingValues r17 = m2416contentPaddingWithoutLabela9UjIt4$default(r44, r45, r46, r47, r48, r49, r50)
            goto L_0x035a
        L_0x033c:
            r17 = 15
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r44 = r37
            r45 = r19
            r46 = r20
            r47 = r21
            r48 = r22
            r49 = r17
            r50 = r18
            androidx.compose.foundation.layout.PaddingValues r17 = m2415contentPaddingWithLabela9UjIt4$default(r44, r45, r46, r47, r48, r49, r50)
        L_0x035a:
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r18
            goto L_0x0362
        L_0x0360:
            r17 = r54
        L_0x0362:
            if (r16 == 0) goto L_0x038e
            r16 = r2
            androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$1 r2 = new androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$1
            r44 = r2
            r45 = r40
            r46 = r9
            r47 = r43
            r48 = r8
            r49 = r1
            r44.<init>(r45, r46, r47, r48, r49)
            r44 = r1
            r1 = 2023266550(0x789898f6, float:2.476036E34)
            r45 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r1, r3, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r31 = r44
            r28 = r45
            r26 = r56
            r34 = r1
            goto L_0x039c
        L_0x038e:
            r44 = r1
            r16 = r2
            r45 = r3
            r31 = r44
            r28 = r45
            r34 = r55
            r26 = r56
        L_0x039c:
            r24 = r4
            r25 = r6
            r29 = r7
            r32 = r8
            r23 = r9
            r30 = r10
            r27 = r16
            r33 = r17
        L_0x03ac:
            r11.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x03bd
            r1 = -1042273141(0xffffffffc1e02c8b, float:-28.02175)
            java.lang.String r2 = "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:1031)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r5, r2)
        L_0x03bd:
            r1 = 2147483646(0x7ffffffe, float:NaN)
            r20 = r0 & r1
            r0 = 268435454(0xffffffe, float:2.5243546E-29)
            r21 = r5 & r0
            r22 = 0
            r0 = r37
            r1 = r38
            r2 = r39
            r3 = r40
            r4 = r41
            r5 = r42
            r6 = r43
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r35 = r11
            r11 = r27
            r12 = r28
            r13 = r29
            r14 = r30
            r15 = r31
            r16 = r32
            r17 = r33
            r18 = r34
            r19 = r35
            r0.DecorationBox(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03ff:
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r27
            r13 = r28
            r14 = r29
            r15 = r30
            r16 = r31
            r17 = r32
            r18 = r33
            r19 = r34
        L_0x0417:
            androidx.compose.runtime.ScopeUpdateScope r7 = r35.endRestartGroup()
            if (r7 == 0) goto L_0x0443
            androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$2 r23 = new androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$2
            r0 = r23
            r1 = r37
            r2 = r38
            r3 = r39
            r4 = r40
            r5 = r41
            r6 = r42
            r36 = r7
            r7 = r43
            r20 = r57
            r21 = r58
            r22 = r59
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r36
            r1.updateScope(r0)
        L_0x0443:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:240:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0128  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.DecorationBox`", replaceWith = @kotlin.ReplaceWith(expression = "OutlinedTextFieldDefaults.DecorationBox(\n        value = value,\n        innerTextField = innerTextField,\n        enabled = enabled,\n        singleLine = singleLine,\n        visualTransformation = visualTransformation,\n        interactionSource = interactionSource,\n        isError = isError,\n        label = label,\n        placeholder = placeholder,\n        leadingIcon = leadingIcon,\n        trailingIcon = trailingIcon,\n        prefix = prefix,\n        suffix = suffix,\n        supportingText = supportingText,\n        colors = colors,\n        contentPadding = contentPadding,\n        container = container,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void OutlinedTextFieldDecorationBox(java.lang.String r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, boolean r38, boolean r39, androidx.compose.ui.text.input.VisualTransformation r40, androidx.compose.foundation.interaction.InteractionSource r41, boolean r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.material3.TextFieldColors r50, androidx.compose.foundation.layout.PaddingValues r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.runtime.Composer r53, int r54, int r55, int r56) {
        /*
            r35 = this;
            r15 = r38
            r14 = r41
            r13 = r54
            r12 = r55
            r11 = r56
            r0 = -789275592(0xffffffffd0f49c38, float:-3.28310292E10)
            r1 = r53
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(OutlinedTextFieldDecorationBox)P(15,4,3,11,16,5,6,7,9,8,14,10,12,13!1,2)1093@59957L8,1098@60237L589:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x0021
            r0 = r13 | 6
            r9 = r36
            goto L_0x0033
        L_0x0021:
            r0 = r13 & 6
            r9 = r36
            if (r0 != 0) goto L_0x0032
            boolean r0 = r10.changed((java.lang.Object) r9)
            if (r0 == 0) goto L_0x002f
            r0 = 4
            goto L_0x0030
        L_0x002f:
            r0 = 2
        L_0x0030:
            r0 = r0 | r13
            goto L_0x0033
        L_0x0032:
            r0 = r13
        L_0x0033:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x003c
            r0 = r0 | 48
            r8 = r37
            goto L_0x004e
        L_0x003c:
            r3 = r13 & 48
            r8 = r37
            if (r3 != 0) goto L_0x004e
            boolean r3 = r10.changedInstance(r8)
            if (r3 == 0) goto L_0x004b
            r3 = 32
            goto L_0x004d
        L_0x004b:
            r3 = 16
        L_0x004d:
            r0 = r0 | r3
        L_0x004e:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0055:
            r3 = r13 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L_0x0065
            boolean r3 = r10.changed((boolean) r15)
            if (r3 == 0) goto L_0x0062
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r0 = r0 | r3
        L_0x0065:
            r3 = r11 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0070
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0070:
            r3 = r13 & 3072(0xc00, float:4.305E-42)
            if (r3 != 0) goto L_0x0084
            r3 = r39
            boolean r18 = r10.changed((boolean) r3)
            if (r18 == 0) goto L_0x007f
            r18 = r16
            goto L_0x0081
        L_0x007f:
            r18 = r17
        L_0x0081:
            r0 = r0 | r18
            goto L_0x0086
        L_0x0084:
            r3 = r39
        L_0x0086:
            r18 = r11 & 16
            r19 = 8192(0x2000, float:1.14794E-41)
            r20 = 16384(0x4000, float:2.2959E-41)
            if (r18 == 0) goto L_0x0091
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a5
        L_0x0091:
            r1 = r13 & 24576(0x6000, float:3.4438E-41)
            if (r1 != 0) goto L_0x00a5
            r1 = r40
            boolean r18 = r10.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x00a0
            r18 = r20
            goto L_0x00a2
        L_0x00a0:
            r18 = r19
        L_0x00a2:
            r0 = r0 | r18
            goto L_0x00a7
        L_0x00a5:
            r1 = r40
        L_0x00a7:
            r18 = r11 & 32
            r21 = 65536(0x10000, float:9.18355E-41)
            r22 = 196608(0x30000, float:2.75506E-40)
            if (r18 == 0) goto L_0x00b2
            r0 = r0 | r22
            goto L_0x00c3
        L_0x00b2:
            r18 = r13 & r22
            if (r18 != 0) goto L_0x00c3
            boolean r18 = r10.changed((java.lang.Object) r14)
            if (r18 == 0) goto L_0x00bf
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r18 = r21
        L_0x00c1:
            r0 = r0 | r18
        L_0x00c3:
            r18 = r11 & 64
            r23 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00ce
            r0 = r0 | r23
            r2 = r42
            goto L_0x00e1
        L_0x00ce:
            r24 = r13 & r23
            r2 = r42
            if (r24 != 0) goto L_0x00e1
            boolean r25 = r10.changed((boolean) r2)
            if (r25 == 0) goto L_0x00dd
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r0 = r0 | r25
        L_0x00e1:
            r4 = r11 & 128(0x80, float:1.794E-43)
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            if (r4 == 0) goto L_0x00ec
            r0 = r0 | r26
            r5 = r43
            goto L_0x00ff
        L_0x00ec:
            r27 = r13 & r26
            r5 = r43
            if (r27 != 0) goto L_0x00ff
            boolean r28 = r10.changedInstance(r5)
            if (r28 == 0) goto L_0x00fb
            r28 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fd
        L_0x00fb:
            r28 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fd:
            r0 = r0 | r28
        L_0x00ff:
            r6 = r11 & 256(0x100, float:3.59E-43)
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            if (r6 == 0) goto L_0x010a
            r0 = r0 | r29
            r7 = r44
            goto L_0x011d
        L_0x010a:
            r29 = r13 & r29
            r7 = r44
            if (r29 != 0) goto L_0x011d
            boolean r30 = r10.changedInstance(r7)
            if (r30 == 0) goto L_0x0119
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011b
        L_0x0119:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011b:
            r0 = r0 | r30
        L_0x011d:
            r1 = r11 & 512(0x200, float:7.175E-43)
            r30 = 805306368(0x30000000, float:4.656613E-10)
            if (r1 == 0) goto L_0x0128
            r0 = r0 | r30
            r2 = r45
            goto L_0x013b
        L_0x0128:
            r30 = r13 & r30
            r2 = r45
            if (r30 != 0) goto L_0x013b
            boolean r30 = r10.changedInstance(r2)
            if (r30 == 0) goto L_0x0137
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0139
        L_0x0137:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0139:
            r0 = r0 | r30
        L_0x013b:
            r2 = r11 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0144
            r24 = r12 | 6
            r3 = r46
            goto L_0x015a
        L_0x0144:
            r30 = r12 & 6
            r3 = r46
            if (r30 != 0) goto L_0x0158
            boolean r30 = r10.changedInstance(r3)
            if (r30 == 0) goto L_0x0153
            r24 = 4
            goto L_0x0155
        L_0x0153:
            r24 = 2
        L_0x0155:
            r24 = r12 | r24
            goto L_0x015a
        L_0x0158:
            r24 = r12
        L_0x015a:
            r3 = r11 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x0161
            r24 = r24 | 48
            goto L_0x0174
        L_0x0161:
            r30 = r12 & 48
            r5 = r47
            if (r30 != 0) goto L_0x0174
            boolean r30 = r10.changedInstance(r5)
            if (r30 == 0) goto L_0x0170
            r27 = 32
            goto L_0x0172
        L_0x0170:
            r27 = 16
        L_0x0172:
            r24 = r24 | r27
        L_0x0174:
            r5 = r24
            r7 = r11 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x017d
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0191
        L_0x017d:
            r8 = r12 & 384(0x180, float:5.38E-43)
            if (r8 != 0) goto L_0x0191
            r8 = r48
            boolean r24 = r10.changedInstance(r8)
            if (r24 == 0) goto L_0x018c
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x018e
        L_0x018c:
            r28 = 128(0x80, float:1.794E-43)
        L_0x018e:
            r5 = r5 | r28
            goto L_0x0193
        L_0x0191:
            r8 = r48
        L_0x0193:
            r8 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x019a
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x01ac
        L_0x019a:
            r9 = r12 & 3072(0xc00, float:4.305E-42)
            if (r9 != 0) goto L_0x01ac
            r9 = r49
            boolean r24 = r10.changedInstance(r9)
            if (r24 == 0) goto L_0x01a7
            goto L_0x01a9
        L_0x01a7:
            r16 = r17
        L_0x01a9:
            r5 = r5 | r16
            goto L_0x01ae
        L_0x01ac:
            r9 = r49
        L_0x01ae:
            r9 = r12 & 24576(0x6000, float:3.4438E-41)
            if (r9 != 0) goto L_0x01c6
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 != 0) goto L_0x01c1
            r9 = r50
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x01c3
            r19 = r20
            goto L_0x01c3
        L_0x01c1:
            r9 = r50
        L_0x01c3:
            r5 = r5 | r19
            goto L_0x01c8
        L_0x01c6:
            r9 = r50
        L_0x01c8:
            r16 = r12 & r22
            r17 = 32768(0x8000, float:4.5918E-41)
            if (r16 != 0) goto L_0x01e3
            r16 = r11 & r17
            r9 = r51
            if (r16 != 0) goto L_0x01de
            boolean r16 = r10.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x01de
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01e0
        L_0x01de:
            r16 = r21
        L_0x01e0:
            r5 = r5 | r16
            goto L_0x01e5
        L_0x01e3:
            r9 = r51
        L_0x01e5:
            r16 = r11 & r21
            if (r16 == 0) goto L_0x01ee
            r5 = r5 | r23
            r9 = r52
            goto L_0x0201
        L_0x01ee:
            r19 = r12 & r23
            r9 = r52
            if (r19 != 0) goto L_0x0201
            boolean r19 = r10.changedInstance(r9)
            if (r19 == 0) goto L_0x01fd
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x01ff
        L_0x01fd:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x01ff:
            r5 = r5 | r19
        L_0x0201:
            r19 = 306783379(0x12492493, float:6.34695E-28)
            r9 = r0 & r19
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r12) goto L_0x0238
            r9 = 599187(0x92493, float:8.3964E-40)
            r9 = r9 & r5
            r12 = 599186(0x92492, float:8.39638E-40)
            if (r9 != r12) goto L_0x0238
            boolean r9 = r10.getSkipping()
            if (r9 != 0) goto L_0x021b
            goto L_0x0238
        L_0x021b:
            r10.skipToGroupEnd()
            r8 = r42
            r9 = r43
            r11 = r45
            r12 = r46
            r13 = r47
            r14 = r48
            r15 = r49
            r16 = r50
            r17 = r51
            r18 = r52
            r26 = r10
            r10 = r44
            goto L_0x039e
        L_0x0238:
            r10.startDefaults()
            r9 = r13 & 1
            if (r9 == 0) goto L_0x0271
            boolean r9 = r10.getDefaultsInvalid()
            if (r9 == 0) goto L_0x0246
            goto L_0x0271
        L_0x0246:
            r10.skipToGroupEnd()
            r1 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0251
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = r5 & r1
        L_0x0251:
            r1 = r11 & r17
            if (r1 == 0) goto L_0x0259
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r5 = r5 & r1
        L_0x0259:
            r22 = r42
            r23 = r43
            r24 = r44
            r25 = r45
            r27 = r46
            r28 = r47
            r29 = r48
            r30 = r49
            r31 = r50
            r32 = r51
            r33 = r52
            goto L_0x031f
        L_0x0271:
            if (r18 == 0) goto L_0x0275
            r9 = 0
            goto L_0x0277
        L_0x0275:
            r9 = r42
        L_0x0277:
            r12 = 0
            if (r4 == 0) goto L_0x027c
            r4 = r12
            goto L_0x027e
        L_0x027c:
            r4 = r43
        L_0x027e:
            if (r6 == 0) goto L_0x0282
            r6 = r12
            goto L_0x0284
        L_0x0282:
            r6 = r44
        L_0x0284:
            if (r1 == 0) goto L_0x0288
            r1 = r12
            goto L_0x028a
        L_0x0288:
            r1 = r45
        L_0x028a:
            if (r2 == 0) goto L_0x028e
            r2 = r12
            goto L_0x0290
        L_0x028e:
            r2 = r46
        L_0x0290:
            if (r3 == 0) goto L_0x0294
            r3 = r12
            goto L_0x0296
        L_0x0294:
            r3 = r47
        L_0x0296:
            if (r7 == 0) goto L_0x029a
            r7 = r12
            goto L_0x029c
        L_0x029a:
            r7 = r48
        L_0x029c:
            if (r8 == 0) goto L_0x029f
            goto L_0x02a1
        L_0x029f:
            r12 = r49
        L_0x02a1:
            r8 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x02b3
            androidx.compose.material3.OutlinedTextFieldDefaults r8 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r42 = r1
            r1 = 6
            androidx.compose.material3.TextFieldColors r1 = r8.colors(r10, r1)
            r8 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = r5 & r8
            goto L_0x02b7
        L_0x02b3:
            r42 = r1
            r1 = r50
        L_0x02b7:
            r8 = r11 & r17
            if (r8 == 0) goto L_0x02e1
            androidx.compose.material3.OutlinedTextFieldDefaults r8 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r17 = 15
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r43 = r8
            r44 = r19
            r45 = r20
            r46 = r21
            r47 = r22
            r48 = r17
            r49 = r18
            androidx.compose.foundation.layout.PaddingValues r8 = androidx.compose.material3.OutlinedTextFieldDefaults.m2038contentPaddinga9UjIt4$default(r43, r44, r45, r46, r47, r48, r49)
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r5 = r5 & r17
            goto L_0x02e3
        L_0x02e1:
            r8 = r51
        L_0x02e3:
            if (r16 == 0) goto L_0x0303
            r43 = r2
            androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$1 r2 = new androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$1
            r2.<init>(r15, r9, r14, r1)
            r16 = r1
            r1 = -1153197597(0xffffffffbb4399e3, float:-0.0029846362)
            r44 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r1, r3, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r25 = r42
            r27 = r43
            r28 = r44
            r33 = r1
            goto L_0x0311
        L_0x0303:
            r16 = r1
            r43 = r2
            r44 = r3
            r25 = r42
            r27 = r43
            r28 = r44
            r33 = r52
        L_0x0311:
            r23 = r4
            r24 = r6
            r29 = r7
            r32 = r8
            r22 = r9
            r30 = r12
            r31 = r16
        L_0x031f:
            r10.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0330
            r1 = -789275592(0xffffffffd0f49c38, float:-3.28310292E10)
            java.lang.String r2 = "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:1098)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r0, r5, r2)
        L_0x0330:
            androidx.compose.material3.OutlinedTextFieldDefaults r1 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r2 = r0
            r0 = r1
            r1 = 2147483646(0x7ffffffe, float:NaN)
            r19 = r2 & r1
            r1 = r5 & 14
            r1 = r1 | r26
            r2 = r5 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r5 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r5 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r5
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r5
            r1 = r1 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r5
            r20 = r1 | r2
            r21 = 0
            r1 = r36
            r2 = r37
            r3 = r38
            r4 = r39
            r5 = r40
            r6 = r41
            r7 = r22
            r8 = r23
            r9 = r24
            r26 = r10
            r10 = r25
            r11 = r27
            r12 = r28
            r13 = r29
            r14 = r30
            r15 = r31
            r16 = r32
            r17 = r33
            r18 = r26
            r0.DecorationBox(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0388
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0388:
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r27
            r13 = r28
            r14 = r29
            r15 = r30
            r16 = r31
            r17 = r32
            r18 = r33
        L_0x039e:
            androidx.compose.runtime.ScopeUpdateScope r7 = r26.endRestartGroup()
            if (r7 == 0) goto L_0x03ca
            androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$2 r22 = new androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$2
            r0 = r22
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            r5 = r39
            r6 = r40
            r34 = r7
            r7 = r41
            r19 = r54
            r20 = r55
            r21 = r56
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r0 = r22
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r34
            r1.updateScope(r0)
        L_0x03ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-eS1Emto  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2440textFieldColorseS1Emto(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        Composer composer2 = composer;
        int i7 = i;
        int i8 = i2;
        int i9 = i5;
        composer2.startReplaceableGroup(-595874869);
        ComposerKt.sourceInformation(composer2, "C(textFieldColors)P(28:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,27,19:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,10:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,26:c#ui.graphics.Color,5:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,8:c#ui.graphics.Color,17:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,6:c#ui.graphics.Color,15:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,7:c#ui.graphics.Color,16:c#ui.graphics.Color)1122@61047L5,1123@61130L5,1125@61276L5,1126@61345L5,1127@61429L5,1128@61508L7,1129@61604L5,1130@61695L5,1131@61793L5,1133@61965L5,1134@62057L5,1135@62146L5,1136@62242L5,1138@62408L5,1139@62502L5,1140@62593L5,1141@62691L5,1143@62860L5,1144@62940L5,1145@63017L5,1146@63101L5,1148@63249L5,1149@63334L5,1150@63424L5,1152@63588L5,1153@63679L5,1154@63777L5,1156@63944L5,1157@64026L5,1158@64110L5,1159@64193L5,1161@64343L5,1162@64425L5,1163@64509L5,1164@64592L5,1166@64742L5,1167@64774L2261:TextFieldDefaults.kt#uh7d8r");
        long value = (i9 & 1) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputColor(), composer2, 6) : j;
        long r9 = (i9 & 2) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long value2 = (i9 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerColor(), composer2, 6) : j3;
        long value3 = (i9 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer2, 6) : j4;
        long value4 = (i9 & 16) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer2, 6) : j5;
        if ((i9 & 32) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value5 = (i9 & 64) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor(), composer2, 6) : j6;
        long value6 = (i9 & 128) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor(), composer2, 6) : j7;
        long r27 = (i9 & 256) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long value7 = (i9 & 512) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor(), composer2, 6) : j9;
        long value8 = (i9 & 1024) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer2, 6) : j10;
        long value9 = (i9 & 2048) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j11;
        long r35 = (i9 & 4096) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j12;
        long value10 = (i9 & 8192) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer2, 6) : j13;
        long value11 = (i9 & 16384) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer2, 6) : j14;
        long value12 = (32768 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j15;
        long r43 = (65536 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long value13 = (131072 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer2, 6) : j17;
        long value14 = (262144 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusLabelColor(), composer2, 6) : j18;
        long value15 = (524288 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getLabelColor(), composer2, 6) : j19;
        long r51 = (1048576 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j20;
        long value16 = (2097152 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorLabelColor(), composer2, 6) : j21;
        long value17 = (4194304 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer2, 6) : j22;
        long r58 = (8388608 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j23;
        long value18 = (16777216 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer2, 6) : j24;
        long value19 = (33554432 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getSupportingColor(), composer2, 6) : j25;
        long r66 = (67108864 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j26;
        long value20 = (134217728 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer2, 6) : j27;
        long value21 = (268435456 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, 6) : j28;
        long value22 = (536870912 & i9) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, 6) : j29;
        long r74 = (i9 & 1073741824) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j30;
        long value23 = (i6 & 1) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, 6) : j31;
        long value24 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, 6) : j32;
        long value25 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, 6) : j33;
        long r82 = (i6 & 8) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j34;
        long value26 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, 6) : j35;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-595874869, i7, i8, "androidx.compose.material3.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:1167)");
        }
        int i10 = i7 << 3;
        int i11 = (i7 & 14) | (i10 & 112) | (i10 & 896);
        int i12 = i7 << 9;
        int i13 = i11 | (i12 & 7168) | ((i7 << 6) & 57344) | (i12 & 458752) | ((i7 << 12) & 3670016);
        int i14 = i7 << 15;
        int i15 = i13 | (i14 & 29360128) | (i14 & 234881024) | (i14 & 1879048192);
        int i16 = i8 << 15;
        int i17 = ((i7 >> 15) & 65534) | (i16 & 458752) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192);
        int i18 = i3 << 15;
        int i19 = ((i8 >> 15) & 65534) | (i18 & 458752) | (i18 & 3670016) | (i18 & 29360128);
        int i20 = i3 << 18;
        int i21 = i19 | (i20 & 234881024) | (i20 & 1879048192);
        int i22 = i3 >> 9;
        int i23 = ((i3 >> 6) & 14) | (i22 & 112) | (i22 & 896) | (i22 & 7168) | (i22 & 57344) | (i22 & 458752) | (i22 & 3670016);
        int i24 = i4 << 21;
        TextFieldColors r0 = m2425colors0hiis_0(value, value, r9, value, value2, value2, value2, value2, value3, value4, textSelectionColors2, value5, value6, r27, value7, value8, value9, r35, value10, value11, value12, r43, value13, value14, value15, r51, value16, value17, value17, r58, value17, value18, value19, r66, value20, value21, value22, r74, value23, value24, value25, r82, value26, composer, i15, i17, i21, i23 | (i24 & 29360128) | (i24 & 234881024) | (i24 & 1879048192), (i4 >> 9) & 8190, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-eS1Emto  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2436outlinedTextFieldColorseS1Emto(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        Composer composer2 = composer;
        int i7 = i;
        int i8 = i2;
        int i9 = i5;
        composer2.startReplaceableGroup(1767818445);
        ComposerKt.sourceInformation(composer2, "C(outlinedTextFieldColors)P(28:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,27,19:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,10:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,26:c#ui.graphics.Color,5:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,8:c#ui.graphics.Color,17:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,6:c#ui.graphics.Color,15:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,7:c#ui.graphics.Color,16:c#ui.graphics.Color)1217@67266L5,1218@67351L5,1221@67545L5,1222@67631L5,1223@67710L7,1224@67797L5,1225@67879L5,1226@67968L5,1228@68125L5,1229@68219L5,1230@68310L5,1231@68408L5,1233@68578L5,1234@68674L5,1235@68767L5,1237@68880L5,1238@69040L5,1239@69122L5,1240@69201L5,1241@69287L5,1243@69439L5,1244@69526L5,1245@69618L5,1247@69786L5,1248@69879L5,1250@69992L5,1251@70150L5,1252@70234L5,1253@70320L5,1254@70405L5,1256@70559L5,1257@70643L5,1258@70729L5,1259@70814L5,1261@70968L5,1262@71026L2237:TextFieldDefaults.kt#uh7d8r");
        long value = (i9 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputColor(), composer2, 6) : j;
        long r9 = (i9 & 2) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r16 = (i9 & 4) != 0 ? Color.Companion.m3851getTransparent0d7_KjU() : j3;
        long value2 = (i9 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getCaretColor(), composer2, 6) : j4;
        long value3 = (i9 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer2, 6) : j5;
        if ((i9 & 32) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i9 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor(), composer2, 6) : j6;
        long value5 = (i9 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getOutlineColor(), composer2, 6) : j7;
        long r27 = (i9 & 256) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long value6 = (i9 & 512) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor(), composer2, 6) : j9;
        long value7 = (i9 & 1024) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer2, 6) : j10;
        long value8 = (i9 & 2048) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor(), composer2, 6) : j11;
        long r35 = (i9 & 4096) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j12;
        long value9 = (i9 & 8192) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer2, 6) : j13;
        long value10 = (i9 & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer2, 6) : j14;
        long value11 = (32768 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor(), composer2, 6) : j15;
        long r43 = (65536 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long value12 = (131072 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer2, 6) : j17;
        long value13 = (262144 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor(), composer2, 6) : j18;
        long value14 = (524288 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getLabelColor(), composer2, 6) : j19;
        long r51 = (1048576 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j20;
        long value15 = (2097152 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor(), composer2, 6) : j21;
        long value16 = (4194304 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer2, 6) : j22;
        long r58 = (8388608 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j23;
        long value17 = (16777216 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer2, 6) : j24;
        long value18 = (33554432 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getSupportingColor(), composer2, 6) : j25;
        long r66 = (67108864 & i9) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j26;
        long value19 = (134217728 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer2, 6) : j27;
        long value20 = (268435456 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, 6) : j28;
        long value21 = (536870912 & i9) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, 6) : j29;
        long r74 = (i9 & 1073741824) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j30;
        long value22 = (i6 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer2, 6) : j31;
        long value23 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, 6) : j32;
        long value24 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, 6) : j33;
        long r82 = (i6 & 8) != 0 ? Color.m3815copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j34;
        long value25 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer2, 6) : j35;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1767818445, i7, i8, "androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:1262)");
        }
        int i10 = i7 << 3;
        int i11 = (i7 & 14) | (i10 & 112) | (i10 & 896);
        int i12 = i7 << 9;
        int i13 = i11 | (i12 & 7168) | ((i7 << 6) & 57344) | (i12 & 458752) | ((i7 << 12) & 3670016);
        int i14 = i7 << 15;
        int i15 = i13 | (i14 & 29360128) | (i14 & 234881024) | (i14 & 1879048192);
        int i16 = i8 << 15;
        int i17 = ((i7 >> 15) & 65534) | (i16 & 458752) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192);
        int i18 = i3 << 15;
        int i19 = ((i8 >> 15) & 65534) | (i18 & 458752) | (i18 & 3670016) | (i18 & 29360128);
        int i20 = i3 << 18;
        int i21 = i19 | (i20 & 234881024) | (i20 & 1879048192);
        int i22 = i3 >> 9;
        int i23 = ((i3 >> 6) & 14) | (i22 & 112) | (i22 & 896) | (i22 & 7168) | (i22 & 57344) | (i22 & 458752) | (i22 & 3670016);
        int i24 = i4 << 21;
        int i25 = i23 | (i24 & 29360128) | (i24 & 234881024) | (i24 & 1879048192);
        int i26 = i4 >> 9;
        TextFieldColors r0 = OutlinedTextFieldDefaults.INSTANCE.m2040colors0hiis_0(value, value, r9, value, r16, r16, r16, r16, value2, value3, textSelectionColors2, value4, value5, r27, value6, value7, value8, r35, value9, value10, value11, r43, value12, value13, value14, r51, value15, value16, value16, r58, value16, value17, value18, r66, value19, value20, value21, r74, value22, value23, value24, r82, value25, composer, i15, i17, i21, i25, (i26 & 14) | 3072 | (i26 & 112) | (i26 & 896), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01a8, code lost:
        if (r9.changed((java.lang.Object) r49) != false) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x01c2, code lost:
        if (r9.changed((java.lang.Object) r50) != false) goto L_0x01c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x03d3  */
    /* JADX WARNING: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0130  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void TextFieldDecorationBox(java.lang.String r36, kotlin.jvm.functions.Function2 r37, boolean r38, boolean r39, androidx.compose.ui.text.input.VisualTransformation r40, androidx.compose.foundation.interaction.InteractionSource r41, boolean r42, kotlin.jvm.functions.Function2 r43, kotlin.jvm.functions.Function2 r44, kotlin.jvm.functions.Function2 r45, kotlin.jvm.functions.Function2 r46, kotlin.jvm.functions.Function2 r47, androidx.compose.ui.graphics.Shape r48, androidx.compose.material3.TextFieldColors r49, androidx.compose.foundation.layout.PaddingValues r50, kotlin.jvm.functions.Function2 r51, androidx.compose.runtime.Composer r52, int r53, int r54, int r55) {
        /*
            r35 = this;
            r15 = r35
            r14 = r53
            r11 = r54
            r10 = r55
            r0 = -1224712461(0xffffffffb7005ef3, float:-7.651502E-6)
            r1 = r52
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TextFieldDecorationBox)P(14,4,3,11,15,5,6,7,9,8,13,12,10!1,2)1324@74014L5,1325@74055L8,1336@74410L684:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r10 & 1
            if (r1 == 0) goto L_0x001f
            r1 = r14 | 6
            r8 = r36
            goto L_0x0031
        L_0x001f:
            r1 = r14 & 6
            r8 = r36
            if (r1 != 0) goto L_0x0030
            boolean r1 = r9.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x002d
            r1 = 4
            goto L_0x002e
        L_0x002d:
            r1 = 2
        L_0x002e:
            r1 = r1 | r14
            goto L_0x0031
        L_0x0030:
            r1 = r14
        L_0x0031:
            r4 = r10 & 2
            if (r4 == 0) goto L_0x003a
            r1 = r1 | 48
            r7 = r37
            goto L_0x004c
        L_0x003a:
            r4 = r14 & 48
            r7 = r37
            if (r4 != 0) goto L_0x004c
            boolean r4 = r9.changedInstance(r7)
            if (r4 == 0) goto L_0x0049
            r4 = 32
            goto L_0x004b
        L_0x0049:
            r4 = 16
        L_0x004b:
            r1 = r1 | r4
        L_0x004c:
            r4 = r10 & 4
            if (r4 == 0) goto L_0x0053
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0053:
            r4 = r14 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x0067
            r4 = r38
            boolean r16 = r9.changed((boolean) r4)
            if (r16 == 0) goto L_0x0062
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r1 = r1 | r16
            goto L_0x0069
        L_0x0067:
            r4 = r38
        L_0x0069:
            r16 = r10 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0074:
            r2 = r14 & 3072(0xc00, float:4.305E-42)
            if (r2 != 0) goto L_0x0088
            r2 = r39
            boolean r16 = r9.changed((boolean) r2)
            if (r16 == 0) goto L_0x0083
            r16 = r17
            goto L_0x0085
        L_0x0083:
            r16 = r18
        L_0x0085:
            r1 = r1 | r16
            goto L_0x008a
        L_0x0088:
            r2 = r39
        L_0x008a:
            r16 = r10 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r16 == 0) goto L_0x0095
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0095:
            r3 = r14 & 24576(0x6000, float:3.4438E-41)
            if (r3 != 0) goto L_0x00a9
            r3 = r40
            boolean r21 = r9.changed((java.lang.Object) r3)
            if (r21 == 0) goto L_0x00a4
            r21 = r19
            goto L_0x00a6
        L_0x00a4:
            r21 = r20
        L_0x00a6:
            r1 = r1 | r21
            goto L_0x00ab
        L_0x00a9:
            r3 = r40
        L_0x00ab:
            r21 = r10 & 32
            r22 = 65536(0x10000, float:9.18355E-41)
            r23 = 196608(0x30000, float:2.75506E-40)
            if (r21 == 0) goto L_0x00b8
            r1 = r1 | r23
            r13 = r41
            goto L_0x00cb
        L_0x00b8:
            r21 = r14 & r23
            r13 = r41
            if (r21 != 0) goto L_0x00cb
            boolean r24 = r9.changed((java.lang.Object) r13)
            if (r24 == 0) goto L_0x00c7
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r24 = r22
        L_0x00c9:
            r1 = r1 | r24
        L_0x00cb:
            r24 = r10 & 64
            r25 = 1572864(0x180000, float:2.204052E-39)
            if (r24 == 0) goto L_0x00d6
            r1 = r1 | r25
            r5 = r42
            goto L_0x00e9
        L_0x00d6:
            r26 = r14 & r25
            r5 = r42
            if (r26 != 0) goto L_0x00e9
            boolean r27 = r9.changed((boolean) r5)
            if (r27 == 0) goto L_0x00e5
            r27 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r27 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r1 = r1 | r27
        L_0x00e9:
            r6 = r10 & 128(0x80, float:1.794E-43)
            r28 = 12582912(0xc00000, float:1.7632415E-38)
            if (r6 == 0) goto L_0x00f4
            r1 = r1 | r28
            r12 = r43
            goto L_0x0107
        L_0x00f4:
            r28 = r14 & r28
            r12 = r43
            if (r28 != 0) goto L_0x0107
            boolean r29 = r9.changedInstance(r12)
            if (r29 == 0) goto L_0x0103
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r1 = r1 | r29
        L_0x0107:
            r0 = r10 & 256(0x100, float:3.59E-43)
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            if (r0 == 0) goto L_0x0112
            r1 = r1 | r30
            r2 = r44
            goto L_0x0125
        L_0x0112:
            r30 = r14 & r30
            r2 = r44
            if (r30 != 0) goto L_0x0125
            boolean r30 = r9.changedInstance(r2)
            if (r30 == 0) goto L_0x0121
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0123
        L_0x0121:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0123:
            r1 = r1 | r30
        L_0x0125:
            r2 = r10 & 512(0x200, float:7.175E-43)
            r30 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0130
            r1 = r1 | r30
            r3 = r45
            goto L_0x0143
        L_0x0130:
            r30 = r14 & r30
            r3 = r45
            if (r30 != 0) goto L_0x0143
            boolean r30 = r9.changedInstance(r3)
            if (r30 == 0) goto L_0x013f
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0141
        L_0x013f:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0141:
            r1 = r1 | r30
        L_0x0143:
            r3 = r10 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x014c
            r16 = r11 | 6
            r4 = r46
            goto L_0x0162
        L_0x014c:
            r30 = r11 & 6
            r4 = r46
            if (r30 != 0) goto L_0x0160
            boolean r30 = r9.changedInstance(r4)
            if (r30 == 0) goto L_0x015b
            r16 = 4
            goto L_0x015d
        L_0x015b:
            r16 = 2
        L_0x015d:
            r16 = r11 | r16
            goto L_0x0162
        L_0x0160:
            r16 = r11
        L_0x0162:
            r4 = r10 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x016b
            r16 = r16 | 48
            r5 = r47
            goto L_0x017e
        L_0x016b:
            r30 = r11 & 48
            r5 = r47
            if (r30 != 0) goto L_0x017e
            boolean r30 = r9.changedInstance(r5)
            if (r30 == 0) goto L_0x017a
            r27 = 32
            goto L_0x017c
        L_0x017a:
            r27 = 16
        L_0x017c:
            r16 = r16 | r27
        L_0x017e:
            r5 = r11 & 384(0x180, float:5.38E-43)
            if (r5 != 0) goto L_0x0198
            r5 = r10 & 4096(0x1000, float:5.74E-42)
            if (r5 != 0) goto L_0x0191
            r5 = r48
            boolean r26 = r9.changed((java.lang.Object) r5)
            if (r26 == 0) goto L_0x0193
            r28 = 256(0x100, float:3.59E-43)
            goto L_0x0195
        L_0x0191:
            r5 = r48
        L_0x0193:
            r28 = 128(0x80, float:1.794E-43)
        L_0x0195:
            r16 = r16 | r28
            goto L_0x019a
        L_0x0198:
            r5 = r48
        L_0x019a:
            r5 = r11 & 3072(0xc00, float:4.305E-42)
            if (r5 != 0) goto L_0x01b2
            r5 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r5 != 0) goto L_0x01ab
            r5 = r49
            boolean r21 = r9.changed((java.lang.Object) r5)
            if (r21 == 0) goto L_0x01ad
            goto L_0x01af
        L_0x01ab:
            r5 = r49
        L_0x01ad:
            r17 = r18
        L_0x01af:
            r16 = r16 | r17
            goto L_0x01b4
        L_0x01b2:
            r5 = r49
        L_0x01b4:
            r5 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r5 != 0) goto L_0x01cc
            r5 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r5 != 0) goto L_0x01c5
            r5 = r50
            boolean r17 = r9.changed((java.lang.Object) r5)
            if (r17 == 0) goto L_0x01c7
            goto L_0x01c9
        L_0x01c5:
            r5 = r50
        L_0x01c7:
            r19 = r20
        L_0x01c9:
            r16 = r16 | r19
            goto L_0x01ce
        L_0x01cc:
            r5 = r50
        L_0x01ce:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r10 & r17
            if (r17 == 0) goto L_0x01da
            r16 = r16 | r23
            r5 = r51
            goto L_0x01ed
        L_0x01da:
            r18 = r11 & r23
            r5 = r51
            if (r18 != 0) goto L_0x01ed
            boolean r18 = r9.changedInstance(r5)
            if (r18 == 0) goto L_0x01e9
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01eb
        L_0x01e9:
            r18 = r22
        L_0x01eb:
            r16 = r16 | r18
        L_0x01ed:
            r18 = r10 & r22
            if (r18 == 0) goto L_0x01f4
            r16 = r16 | r25
            goto L_0x0205
        L_0x01f4:
            r18 = r11 & r25
            if (r18 != 0) goto L_0x0205
            boolean r18 = r9.changed((java.lang.Object) r15)
            if (r18 == 0) goto L_0x0201
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0203
        L_0x0201:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x0203:
            r16 = r16 | r18
        L_0x0205:
            r5 = r16
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r7 = r1 & r16
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r8) goto L_0x023b
            r7 = 599187(0x92493, float:8.3964E-40)
            r7 = r7 & r5
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r7 != r8) goto L_0x023b
            boolean r7 = r9.getSkipping()
            if (r7 != 0) goto L_0x0221
            goto L_0x023b
        L_0x0221:
            r9.skipToGroupEnd()
            r8 = r42
            r10 = r44
            r11 = r45
            r13 = r47
            r14 = r48
            r15 = r49
            r16 = r50
            r17 = r51
            r29 = r9
            r9 = r12
            r12 = r46
            goto L_0x03cd
        L_0x023b:
            r9.startDefaults()
            r7 = r14 & 1
            r8 = 6
            if (r7 == 0) goto L_0x0277
            boolean r7 = r9.getDefaultsInvalid()
            if (r7 == 0) goto L_0x024a
            goto L_0x0277
        L_0x024a:
            r9.skipToGroupEnd()
            r0 = r10 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0253
            r5 = r5 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0253:
            r0 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0259
            r5 = r5 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0259:
            r0 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0261
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = r5 & r0
        L_0x0261:
            r23 = r42
            r25 = r44
            r26 = r45
            r27 = r46
            r28 = r47
            r30 = r48
            r31 = r49
            r32 = r50
            r33 = r51
            r24 = r12
            goto L_0x034c
        L_0x0277:
            if (r24 == 0) goto L_0x027b
            r7 = 0
            goto L_0x027d
        L_0x027b:
            r7 = r42
        L_0x027d:
            r16 = 0
            if (r6 == 0) goto L_0x0283
            r12 = r16
        L_0x0283:
            if (r0 == 0) goto L_0x0288
            r0 = r16
            goto L_0x028a
        L_0x0288:
            r0 = r44
        L_0x028a:
            if (r2 == 0) goto L_0x028f
            r2 = r16
            goto L_0x0291
        L_0x028f:
            r2 = r45
        L_0x0291:
            if (r3 == 0) goto L_0x0296
            r3 = r16
            goto L_0x0298
        L_0x0296:
            r3 = r46
        L_0x0298:
            if (r4 == 0) goto L_0x029b
            goto L_0x029d
        L_0x029b:
            r16 = r47
        L_0x029d:
            r4 = r10 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x02aa
            androidx.compose.material3.TextFieldDefaults r4 = INSTANCE
            androidx.compose.ui.graphics.Shape r4 = r4.getShape(r9, r8)
            r5 = r5 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x02ac
        L_0x02aa:
            r4 = r48
        L_0x02ac:
            r6 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x02bb
            int r6 = r5 >> 18
            r6 = r6 & 14
            androidx.compose.material3.TextFieldColors r6 = r15.colors(r9, r6)
            r5 = r5 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x02bd
        L_0x02bb:
            r6 = r49
        L_0x02bd:
            r8 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x0306
            if (r12 != 0) goto L_0x02e2
            r8 = 15
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r42 = r35
            r43 = r19
            r44 = r20
            r45 = r21
            r46 = r22
            r47 = r8
            r48 = r18
            androidx.compose.foundation.layout.PaddingValues r8 = m2416contentPaddingWithoutLabela9UjIt4$default(r42, r43, r44, r45, r46, r47, r48)
            goto L_0x0300
        L_0x02e2:
            r8 = 15
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r42 = r35
            r43 = r19
            r44 = r20
            r45 = r21
            r46 = r22
            r47 = r8
            r48 = r18
            androidx.compose.foundation.layout.PaddingValues r8 = m2415contentPaddingWithLabela9UjIt4$default(r42, r43, r44, r45, r46, r47, r48)
        L_0x0300:
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = r5 & r18
            goto L_0x0308
        L_0x0306:
            r8 = r50
        L_0x0308:
            if (r17 == 0) goto L_0x0332
            r17 = r0
            androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$3 r0 = new androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$3
            r42 = r0
            r43 = r38
            r44 = r7
            r45 = r41
            r46 = r6
            r47 = r4
            r42.<init>(r43, r44, r45, r46, r47)
            r42 = r2
            r2 = -1171460386(0xffffffffba2ceede, float:-6.596873E-4)
            r43 = r3
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r2, r3, r0)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r26 = r42
            r27 = r43
            r33 = r0
            goto L_0x033e
        L_0x0332:
            r17 = r0
            r42 = r2
            r43 = r3
            r26 = r42
            r27 = r43
            r33 = r51
        L_0x033e:
            r30 = r4
            r31 = r6
            r23 = r7
            r32 = r8
            r24 = r12
            r28 = r16
            r25 = r17
        L_0x034c:
            r9.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x035d
            java.lang.String r0 = "androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:1335)"
            r2 = -1224712461(0xffffffffb7005ef3, float:-7.651502E-6)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r5, r0)
        L_0x035d:
            r0 = 2147483646(0x7ffffffe, float:NaN)
            r20 = r1 & r0
            r0 = r5 & 14
            r0 = r0 | 432(0x1b0, float:6.05E-43)
            r1 = 6
            int r1 = r5 << 6
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r2
            r21 = r0 | r1
            r22 = 0
            r12 = 0
            r0 = 0
            r13 = r0
            r0 = r35
            r1 = r36
            r2 = r37
            r3 = r38
            r4 = r39
            r5 = r40
            r6 = r41
            r7 = r23
            r8 = r24
            r29 = r9
            r9 = r25
            r10 = r26
            r11 = r27
            r14 = r28
            r15 = r30
            r16 = r31
            r17 = r32
            r18 = r33
            r19 = r29
            r0.DecorationBox(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03b9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03b9:
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r27
            r13 = r28
            r14 = r30
            r15 = r31
            r16 = r32
            r17 = r33
        L_0x03cd:
            androidx.compose.runtime.ScopeUpdateScope r7 = r29.endRestartGroup()
            if (r7 == 0) goto L_0x03f9
            androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$4 r21 = new androidx.compose.material3.TextFieldDefaults$TextFieldDecorationBox$4
            r0 = r21
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            r5 = r39
            r6 = r40
            r34 = r7
            r7 = r41
            r18 = r53
            r19 = r54
            r20 = r55
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r0 = r21
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r34
            r1.updateScope(r0)
        L_0x03f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x019f, code lost:
        if (r8.changed((java.lang.Object) r47) != false) goto L_0x01a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:214:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0129  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void OutlinedTextFieldDecorationBox(java.lang.String r34, kotlin.jvm.functions.Function2 r35, boolean r36, boolean r37, androidx.compose.ui.text.input.VisualTransformation r38, androidx.compose.foundation.interaction.InteractionSource r39, boolean r40, kotlin.jvm.functions.Function2 r41, kotlin.jvm.functions.Function2 r42, kotlin.jvm.functions.Function2 r43, kotlin.jvm.functions.Function2 r44, kotlin.jvm.functions.Function2 r45, androidx.compose.material3.TextFieldColors r46, androidx.compose.foundation.layout.PaddingValues r47, kotlin.jvm.functions.Function2 r48, androidx.compose.runtime.Composer r49, int r50, int r51, int r52) {
        /*
            r33 = this;
            r15 = r36
            r14 = r39
            r11 = r50
            r10 = r51
            r9 = r52
            r0 = 508645792(0x1e5151a0, float:1.10812475E-20)
            r1 = r49
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextFieldDecorationBox)P(13,4,3,10,14,5,6,7,9,8,12,11!1,2)1374@75878L8,1380@76166L656:TextFieldDefaults.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r9 & 1
            if (r1 == 0) goto L_0x0021
            r1 = r11 | 6
            r7 = r34
            goto L_0x0033
        L_0x0021:
            r1 = r11 & 6
            r7 = r34
            if (r1 != 0) goto L_0x0032
            boolean r1 = r8.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x002f
            r1 = 4
            goto L_0x0030
        L_0x002f:
            r1 = 2
        L_0x0030:
            r1 = r1 | r11
            goto L_0x0033
        L_0x0032:
            r1 = r11
        L_0x0033:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x003a
            r1 = r1 | 48
            goto L_0x004d
        L_0x003a:
            r4 = r11 & 48
            if (r4 != 0) goto L_0x004d
            r4 = r35
            boolean r12 = r8.changedInstance(r4)
            if (r12 == 0) goto L_0x0049
            r12 = 32
            goto L_0x004b
        L_0x0049:
            r12 = 16
        L_0x004b:
            r1 = r1 | r12
            goto L_0x004f
        L_0x004d:
            r4 = r35
        L_0x004f:
            r12 = r9 & 4
            r16 = 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0058
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0058:
            r12 = r11 & 384(0x180, float:5.38E-43)
            if (r12 != 0) goto L_0x0068
            boolean r12 = r8.changed((boolean) r15)
            if (r12 == 0) goto L_0x0065
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r12 = r16
        L_0x0067:
            r1 = r1 | r12
        L_0x0068:
            r12 = r9 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0073
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0087
        L_0x0073:
            r12 = r11 & 3072(0xc00, float:4.305E-42)
            if (r12 != 0) goto L_0x0087
            r12 = r37
            boolean r19 = r8.changed((boolean) r12)
            if (r19 == 0) goto L_0x0082
            r19 = r17
            goto L_0x0084
        L_0x0082:
            r19 = r18
        L_0x0084:
            r1 = r1 | r19
            goto L_0x0089
        L_0x0087:
            r12 = r37
        L_0x0089:
            r19 = r9 & 16
            r20 = 16384(0x4000, float:2.2959E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r19 == 0) goto L_0x0094
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a8
        L_0x0094:
            r2 = r11 & 24576(0x6000, float:3.4438E-41)
            if (r2 != 0) goto L_0x00a8
            r2 = r38
            boolean r19 = r8.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x00a3
            r19 = r20
            goto L_0x00a5
        L_0x00a3:
            r19 = r21
        L_0x00a5:
            r1 = r1 | r19
            goto L_0x00aa
        L_0x00a8:
            r2 = r38
        L_0x00aa:
            r19 = r9 & 32
            r22 = 196608(0x30000, float:2.75506E-40)
            if (r19 == 0) goto L_0x00b3
            r1 = r1 | r22
            goto L_0x00c4
        L_0x00b3:
            r19 = r11 & r22
            if (r19 != 0) goto L_0x00c4
            boolean r19 = r8.changed((java.lang.Object) r14)
            if (r19 == 0) goto L_0x00c0
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r1 = r1 | r19
        L_0x00c4:
            r19 = r9 & 64
            r22 = 1572864(0x180000, float:2.204052E-39)
            if (r19 == 0) goto L_0x00cf
            r1 = r1 | r22
            r3 = r40
            goto L_0x00e2
        L_0x00cf:
            r22 = r11 & r22
            r3 = r40
            if (r22 != 0) goto L_0x00e2
            boolean r23 = r8.changed((boolean) r3)
            if (r23 == 0) goto L_0x00de
            r23 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00de:
            r23 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r1 = r1 | r23
        L_0x00e2:
            r5 = r9 & 128(0x80, float:1.794E-43)
            r24 = 12582912(0xc00000, float:1.7632415E-38)
            if (r5 == 0) goto L_0x00ed
            r1 = r1 | r24
            r6 = r41
            goto L_0x0100
        L_0x00ed:
            r24 = r11 & r24
            r6 = r41
            if (r24 != 0) goto L_0x0100
            boolean r25 = r8.changedInstance(r6)
            if (r25 == 0) goto L_0x00fc
            r25 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fe
        L_0x00fc:
            r25 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fe:
            r1 = r1 | r25
        L_0x0100:
            r13 = r9 & 256(0x100, float:3.59E-43)
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            if (r13 == 0) goto L_0x010b
            r1 = r1 | r26
            r0 = r42
            goto L_0x011e
        L_0x010b:
            r26 = r11 & r26
            r0 = r42
            if (r26 != 0) goto L_0x011e
            boolean r27 = r8.changedInstance(r0)
            if (r27 == 0) goto L_0x011a
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011c
        L_0x011a:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011c:
            r1 = r1 | r27
        L_0x011e:
            r0 = r9 & 512(0x200, float:7.175E-43)
            r27 = 805306368(0x30000000, float:4.656613E-10)
            if (r0 == 0) goto L_0x0129
            r1 = r1 | r27
            r2 = r43
            goto L_0x013c
        L_0x0129:
            r27 = r11 & r27
            r2 = r43
            if (r27 != 0) goto L_0x013c
            boolean r27 = r8.changedInstance(r2)
            if (r27 == 0) goto L_0x0138
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013a
        L_0x0138:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013a:
            r1 = r1 | r27
        L_0x013c:
            r2 = r9 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0145
            r22 = r10 | 6
            r3 = r44
            goto L_0x015b
        L_0x0145:
            r27 = r10 & 6
            r3 = r44
            if (r27 != 0) goto L_0x0159
            boolean r27 = r8.changedInstance(r3)
            if (r27 == 0) goto L_0x0154
            r22 = 4
            goto L_0x0156
        L_0x0154:
            r22 = 2
        L_0x0156:
            r22 = r10 | r22
            goto L_0x015b
        L_0x0159:
            r22 = r10
        L_0x015b:
            r3 = r9 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x0164
            r22 = r22 | 48
            r4 = r45
            goto L_0x0177
        L_0x0164:
            r27 = r10 & 48
            r4 = r45
            if (r27 != 0) goto L_0x0177
            boolean r27 = r8.changedInstance(r4)
            if (r27 == 0) goto L_0x0173
            r23 = 32
            goto L_0x0175
        L_0x0173:
            r23 = 16
        L_0x0175:
            r22 = r22 | r23
        L_0x0177:
            r4 = r10 & 384(0x180, float:5.38E-43)
            if (r4 != 0) goto L_0x018f
            r4 = r9 & 4096(0x1000, float:5.74E-42)
            if (r4 != 0) goto L_0x018a
            r4 = r46
            boolean r23 = r8.changed((java.lang.Object) r4)
            if (r23 == 0) goto L_0x018c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x018c
        L_0x018a:
            r4 = r46
        L_0x018c:
            r22 = r22 | r16
            goto L_0x0191
        L_0x018f:
            r4 = r46
        L_0x0191:
            r4 = r10 & 3072(0xc00, float:4.305E-42)
            if (r4 != 0) goto L_0x01a9
            r4 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r4 != 0) goto L_0x01a2
            r4 = r47
            boolean r16 = r8.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x01a4
            goto L_0x01a6
        L_0x01a2:
            r4 = r47
        L_0x01a4:
            r17 = r18
        L_0x01a6:
            r22 = r22 | r17
            goto L_0x01ab
        L_0x01a9:
            r4 = r47
        L_0x01ab:
            r4 = r22
            r6 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x01b4
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01c6
        L_0x01b4:
            r7 = r10 & 24576(0x6000, float:3.4438E-41)
            if (r7 != 0) goto L_0x01c6
            r7 = r48
            boolean r16 = r8.changedInstance(r7)
            if (r16 == 0) goto L_0x01c1
            goto L_0x01c3
        L_0x01c1:
            r20 = r21
        L_0x01c3:
            r4 = r4 | r20
            goto L_0x01c8
        L_0x01c6:
            r7 = r48
        L_0x01c8:
            r16 = 306783379(0x12492493, float:6.34695E-28)
            r7 = r1 & r16
            r10 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r10) goto L_0x01f8
            r7 = r4 & 9363(0x2493, float:1.312E-41)
            r10 = 9362(0x2492, float:1.3119E-41)
            if (r7 != r10) goto L_0x01f8
            boolean r7 = r8.getSkipping()
            if (r7 != 0) goto L_0x01df
            goto L_0x01f8
        L_0x01df:
            r8.skipToGroupEnd()
            r9 = r41
            r10 = r42
            r11 = r43
            r12 = r44
            r13 = r45
            r14 = r46
            r15 = r47
            r16 = r48
            r26 = r8
            r8 = r40
            goto L_0x0334
        L_0x01f8:
            r8.startDefaults()
            r7 = r11 & 1
            r10 = 6
            if (r7 == 0) goto L_0x022a
            boolean r7 = r8.getDefaultsInvalid()
            if (r7 == 0) goto L_0x0207
            goto L_0x022a
        L_0x0207:
            r8.skipToGroupEnd()
            r0 = r9 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0210
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0210:
            r0 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0216
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0216:
            r22 = r40
            r23 = r41
            r24 = r42
            r25 = r43
            r27 = r44
            r28 = r45
            r29 = r46
            r30 = r47
            r31 = r48
            goto L_0x02bd
        L_0x022a:
            if (r19 == 0) goto L_0x022e
            r7 = 0
            goto L_0x0230
        L_0x022e:
            r7 = r40
        L_0x0230:
            r16 = 0
            if (r5 == 0) goto L_0x0237
            r5 = r16
            goto L_0x0239
        L_0x0237:
            r5 = r41
        L_0x0239:
            if (r13 == 0) goto L_0x023e
            r13 = r16
            goto L_0x0240
        L_0x023e:
            r13 = r42
        L_0x0240:
            if (r0 == 0) goto L_0x0245
            r0 = r16
            goto L_0x0247
        L_0x0245:
            r0 = r43
        L_0x0247:
            if (r2 == 0) goto L_0x024c
            r2 = r16
            goto L_0x024e
        L_0x024c:
            r2 = r44
        L_0x024e:
            if (r3 == 0) goto L_0x0251
            goto L_0x0253
        L_0x0251:
            r16 = r45
        L_0x0253:
            r3 = r9 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x0260
            androidx.compose.material3.OutlinedTextFieldDefaults r3 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            androidx.compose.material3.TextFieldColors r3 = r3.colors(r8, r10)
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0262
        L_0x0260:
            r3 = r46
        L_0x0262:
            r10 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x0289
            androidx.compose.material3.OutlinedTextFieldDefaults r10 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r17 = 15
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r40 = r10
            r41 = r19
            r42 = r20
            r43 = r21
            r44 = r22
            r45 = r17
            r46 = r18
            androidx.compose.foundation.layout.PaddingValues r10 = androidx.compose.material3.OutlinedTextFieldDefaults.m2038contentPaddinga9UjIt4$default(r40, r41, r42, r43, r44, r45, r46)
            r4 = r4 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x028b
        L_0x0289:
            r10 = r47
        L_0x028b:
            if (r6 == 0) goto L_0x02a7
            androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$3 r6 = new androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$3
            r6.<init>(r15, r7, r14, r3)
            r40 = r0
            r0 = 144282315(0x89992cb, float:9.242863E-34)
            r41 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r0, r2, r6)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r25 = r40
            r27 = r41
            r31 = r0
            goto L_0x02b1
        L_0x02a7:
            r40 = r0
            r41 = r2
            r25 = r40
            r27 = r41
            r31 = r48
        L_0x02b1:
            r29 = r3
            r23 = r5
            r22 = r7
            r30 = r10
            r24 = r13
            r28 = r16
        L_0x02bd:
            r8.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02ce
            java.lang.String r0 = "androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:1379)"
            r2 = 508645792(0x1e5151a0, float:1.10812475E-20)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r4, r0)
        L_0x02ce:
            androidx.compose.material3.OutlinedTextFieldDefaults r0 = androidx.compose.material3.OutlinedTextFieldDefaults.INSTANCE
            r2 = 2147483646(0x7ffffffe, float:NaN)
            r19 = r1 & r2
            r1 = r4 & 14
            r2 = 12583344(0xc001b0, float:1.763302E-38)
            r1 = r1 | r2
            r2 = 6
            int r2 = r4 << 6
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r1 = r1 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r2
            r1 = r1 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r3
            r20 = r1 | r2
            r21 = 0
            r1 = 0
            r12 = r1
            r13 = 0
            r1 = r34
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r39
            r7 = r22
            r26 = r8
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r27
            r14 = r28
            r15 = r29
            r16 = r30
            r17 = r31
            r18 = r26
            r0.DecorationBox(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0322
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0322:
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r27
            r13 = r28
            r14 = r29
            r15 = r30
            r16 = r31
        L_0x0334:
            androidx.compose.runtime.ScopeUpdateScope r7 = r26.endRestartGroup()
            if (r7 == 0) goto L_0x0360
            androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$4 r20 = new androidx.compose.material3.TextFieldDefaults$OutlinedTextFieldDecorationBox$4
            r0 = r20
            r1 = r33
            r2 = r34
            r3 = r35
            r4 = r36
            r5 = r37
            r6 = r38
            r32 = r7
            r7 = r39
            r17 = r50
            r18 = r51
            r19 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r32
            r1.updateScope(r0)
        L_0x0360:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: indicatorLine-gv0btCI  reason: not valid java name */
    public final Modifier m2434indicatorLinegv0btCI(Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2) {
        Modifier modifier2 = modifier;
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(z, z2, interactionSource, textFieldColors, f, f2) : InspectableValueKt.getNoInspectorInfo(), new TextFieldDefaults$indicatorLine$2(z, z2, interactionSource, textFieldColors, f, f2));
    }

    static {
        float r0 = Dp.m6614constructorimpl((float) 1);
        UnfocusedIndicatorThickness = r0;
        float r1 = Dp.m6614constructorimpl((float) 2);
        FocusedIndicatorThickness = r1;
        UnfocusedBorderThickness = r0;
        FocusedBorderThickness = r1;
    }
}
