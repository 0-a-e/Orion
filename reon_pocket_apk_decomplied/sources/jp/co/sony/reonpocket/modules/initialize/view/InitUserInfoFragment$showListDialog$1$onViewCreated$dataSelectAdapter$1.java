package jp.co.sony.reonpocket.modules.initialize.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "aPosition", "", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: InitUserInfoFragment.kt */
final class InitUserInfoFragment$showListDialog$1$onViewCreated$dataSelectAdapter$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ InitUserInfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitUserInfoFragment$showListDialog$1$onViewCreated$dataSelectAdapter$1(InitUserInfoFragment initUserInfoFragment) {
        super(2);
        this.this$0 = initUserInfoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        this.this$0.mTempGenderSelectedValue = i;
        InitUserInfoFragment initUserInfoFragment = this.this$0;
        initUserInfoFragment.mLastGenderSelectedValue = initUserInfoFragment.mTempGenderSelectedValue;
    }
}
