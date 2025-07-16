package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ShaderBrushSpan.android.kt */
final class ShaderBrushSpan$shaderState$1 extends Lambda implements Function0<Shader> {
    final /* synthetic */ ShaderBrushSpan this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShaderBrushSpan$shaderState$1(ShaderBrushSpan shaderBrushSpan) {
        super(0);
        this.this$0 = shaderBrushSpan;
    }

    public final Shader invoke() {
        if (this.this$0.m6341getSizeNHjbRc() != Size.Companion.m3639getUnspecifiedNHjbRc() && !Size.m3633isEmptyimpl(this.this$0.m6341getSizeNHjbRc())) {
            return this.this$0.getShaderBrush().m4186createShaderuvyYCjk(this.this$0.m6341getSizeNHjbRc());
        }
        return null;
    }
}
