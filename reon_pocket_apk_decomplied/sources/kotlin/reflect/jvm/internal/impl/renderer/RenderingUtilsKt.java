package kotlin.reflect.jvm.internal.impl.renderer;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* compiled from: RenderingUtils.kt */
public final class RenderingUtilsKt {
    public static final String render(Name name) {
        Intrinsics.checkNotNullParameter(name, "<this>");
        if (shouldBeEscaped(name)) {
            StringBuilder sb = new StringBuilder();
            String asString = name.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            sb.append("`" + asString);
            sb.append('`');
            return sb.toString();
        }
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
        return asString2;
    }

    private static final boolean shouldBeEscaped(Name name) {
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        if (!KeywordStringsGenerated.KEYWORDS.contains(asString)) {
            CharSequence charSequence = asString;
            int i = 0;
            while (true) {
                if (i < charSequence.length()) {
                    char charAt = charSequence.charAt(i);
                    if (!Character.isLetterOrDigit(charAt) && charAt != '_') {
                        break;
                    }
                    i++;
                } else if (charSequence.length() != 0 && Character.isJavaIdentifierStart(asString.codePointAt(0))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final String render(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "<this>");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "pathSegments(...)");
        return renderFqName(pathSegments);
    }

    public static final String renderFqName(List<Name> list) {
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (Name next : list) {
            if (sb.length() > 0) {
                sb.append(InstructionFileId.DOT);
            }
            sb.append(render(next));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final String replacePrefixesInTypeRepresentations(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "lowerRendered");
        Intrinsics.checkNotNullParameter(str2, "lowerPrefix");
        Intrinsics.checkNotNullParameter(str3, "upperRendered");
        Intrinsics.checkNotNullParameter(str4, "upperPrefix");
        Intrinsics.checkNotNullParameter(str5, "foldedPrefix");
        if (StringsKt.startsWith$default(str, str2, false, 2, (Object) null) && StringsKt.startsWith$default(str3, str4, false, 2, (Object) null)) {
            String substring = str.substring(str2.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = str3.substring(str4.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            String str6 = str5 + substring;
            if (Intrinsics.areEqual((Object) substring, (Object) substring2)) {
                return str6;
            }
            if (typeStringsDifferOnlyInNullability(substring, substring2)) {
                return str6 + '!';
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003c, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7 + '?', (java.lang.Object) r8) == false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean typeStringsDifferOnlyInNullability(java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "lower"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "upper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r5 = 4
            r6 = 0
            java.lang.String r2 = "?"
            java.lang.String r3 = ""
            r4 = 0
            r1 = r8
            java.lang.String r0 = kotlin.text.StringsKt.replace$default((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (boolean) r4, (int) r5, (java.lang.Object) r6)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0057
            r0 = 2
            r1 = 0
            java.lang.String r2 = "?"
            r3 = 0
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r8, r2, r3, r0, r1)
            if (r0 == 0) goto L_0x003e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r1 = 63
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r8)
            if (r0 != 0) goto L_0x0057
        L_0x003e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "("
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = ")?"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0058
        L_0x0057:
            r3 = 1
        L_0x0058:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt.typeStringsDifferOnlyInNullability(java.lang.String, java.lang.String):boolean");
    }
}
