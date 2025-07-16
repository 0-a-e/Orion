package kotlin.reflect.jvm.internal.impl.renderer;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: DescriptorRendererImpl.kt */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    private final Lazy functionTypeAnnotationsRenderer$delegate = LazyKt.lazy(new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(this));
    private final DescriptorRendererOptionsImpl options;

    /* compiled from: DescriptorRendererImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat[] r0 = kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat r2 = kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat r3 = kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy[] r0 = kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy r3 = kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.ALL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy r1 = kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy r1 = kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.NONE     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.WhenMappings.<clinit>():void");
        }
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.options.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.options.getAlwaysRenderModifiers();
    }

    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.options.getAnnotationArgumentsRenderingPolicy();
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.options.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.options.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.options.getClassWithPrimaryConstructor();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.options.getClassifierNamePolicy();
    }

    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.options.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.options.getEachAnnotationOnNewLine();
    }

    public boolean getEnhancedTypes() {
        return this.options.getEnhancedTypes();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return this.options.getExcludedAnnotationClasses();
    }

    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.options.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.options.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.options.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.options.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.options.getInformativeErrorType();
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        return this.options.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.options.getNormalizedVisibilities();
    }

    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.options.getOverrideRenderingPolicy();
    }

    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.options.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.options.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.options.getPresentableUnresolvedTypes();
    }

    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.options.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.options.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.options.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.options.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.options.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.options.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.options.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.options.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.options.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.options.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.options.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.options.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.options.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.options.getStartFromName();
    }

    public RenderingFormat getTextFormat() {
        return this.options.getTextFormat();
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.options.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.options.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.options.getUnitReturnType();
    }

    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.options.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.options.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.options.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.options.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.options.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.options.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.options.getWithoutTypeParameters();
    }

    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.options.setClassifierNamePolicy(classifierNamePolicy);
    }

    public void setDebugMode(boolean z) {
        this.options.setDebugMode(z);
    }

    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(set);
    }

    public void setModifiers(Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setModifiers(set);
    }

    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.options.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    public void setReceiverAfterName(boolean z) {
        this.options.setReceiverAfterName(z);
    }

    public void setRenderCompanionObjectName(boolean z) {
        this.options.setRenderCompanionObjectName(z);
    }

    public void setStartFromName(boolean z) {
        this.options.setStartFromName(z);
    }

    public void setTextFormat(RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.options.setTextFormat(renderingFormat);
    }

    public void setVerbose(boolean z) {
        this.options.setVerbose(z);
    }

    public void setWithDefinedIn(boolean z) {
        this.options.setWithDefinedIn(z);
    }

    public void setWithoutSuperTypes(boolean z) {
        this.options.setWithoutSuperTypes(z);
    }

    public void setWithoutTypeParameters(boolean z) {
        this.options.setWithoutTypeParameters(z);
    }

    public final DescriptorRendererOptionsImpl getOptions() {
        return this.options;
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        Intrinsics.checkNotNullParameter(descriptorRendererOptionsImpl, "options");
        this.options = descriptorRendererOptionsImpl;
        descriptorRendererOptionsImpl.isLocked();
    }

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        return (DescriptorRendererImpl) this.functionTypeAnnotationsRenderer$delegate.getValue();
    }

    private final String renderKeyword(String str) {
        int i = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else if (getBoldOnlyForNamesInHtml()) {
            return str;
        } else {
            return "<b>" + str + "</b>";
        }
    }

    private final String renderError(String str) {
        int i = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i == 2) {
            return "<font color=red><b>" + str + "</b></font>";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String escape(String str) {
        return getTextFormat().escape(str);
    }

    private final String lt() {
        return escape("<");
    }

    private final String gt() {
        return escape(">");
    }

    private final String arrow() {
        int i = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return escape("->");
        }
        if (i == 2) {
            return "&rarr;";
        }
        throw new NoWhenBranchMatchedException();
    }

    public String renderMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        int i = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i == 2) {
            return "<i>" + str + "</i>";
        }
        throw new NoWhenBranchMatchedException();
    }

    public String renderName(Name name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        String escape = escape(RenderingUtilsKt.render(name));
        if (!getBoldOnlyForNamesInHtml() || getTextFormat() != RenderingFormat.HTML || !z) {
            return escape;
        }
        return "<b>" + escape + "</b>";
    }

    /* access modifiers changed from: private */
    public final void renderName(DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z) {
        Name name = declarationDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        sb.append(renderName(name, z));
    }

    private final void renderCompanionObjectName(DeclarationDescriptor declarationDescriptor, StringBuilder sb) {
        if (getRenderCompanionObjectName()) {
            if (getStartFromName()) {
                sb.append("companion object");
            }
            renderSpaceIfNeeded(sb);
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                sb.append("of ");
                Name name = containingDeclaration.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                sb.append(renderName(name, false));
            }
        }
        if (getVerbose() || !Intrinsics.areEqual((Object) declarationDescriptor.getName(), (Object) SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(sb);
            }
            Name name2 = declarationDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            sb.append(renderName(name2, true));
        }
    }

    public String renderFqName(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "fqName");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "pathSegments(...)");
        return renderFqName(pathSegments);
    }

    private final String renderFqName(List<Name> list) {
        return escape(RenderingUtilsKt.renderFqName(list));
    }

    public String renderClassifierName(ClassifierDescriptor classifierDescriptor) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "klass");
        if (ErrorUtils.isError(classifierDescriptor)) {
            return classifierDescriptor.getTypeConstructor().toString();
        }
        return getClassifierNamePolicy().renderClassifier(classifierDescriptor, this);
    }

    public String renderType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, TransferTable.COLUMN_TYPE);
        StringBuilder sb = new StringBuilder();
        renderNormalizedType(sb, getTypeNormalizer().invoke(kotlinType));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final void renderNormalizedType(StringBuilder sb, KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        AbbreviatedType abbreviatedType = unwrap instanceof AbbreviatedType ? (AbbreviatedType) unwrap : null;
        if (abbreviatedType == null) {
            renderNormalizedTypeAsIs(sb, kotlinType);
        } else if (getRenderTypeExpansions()) {
            renderNormalizedTypeAsIs(sb, abbreviatedType.getExpandedType());
        } else {
            renderNormalizedTypeAsIs(sb, abbreviatedType.getAbbreviation());
            if (getRenderUnabbreviatedType()) {
                renderAbbreviatedTypeExpansion(sb, abbreviatedType);
            }
        }
    }

    private final void renderAbbreviatedTypeExpansion(StringBuilder sb, AbbreviatedType abbreviatedType) {
        if (getTextFormat() == RenderingFormat.HTML) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        renderNormalizedTypeAsIs(sb, abbreviatedType.getExpandedType());
        sb.append(" */");
        if (getTextFormat() == RenderingFormat.HTML) {
            sb.append("</i></font>");
        }
    }

    private final void renderNormalizedTypeAsIs(StringBuilder sb, KotlinType kotlinType) {
        if (!(kotlinType instanceof WrappedType) || !getDebugMode() || ((WrappedType) kotlinType).isComputed()) {
            UnwrappedType unwrap = kotlinType.unwrap();
            if (unwrap instanceof FlexibleType) {
                sb.append(((FlexibleType) unwrap).render(this, this));
            } else if (unwrap instanceof SimpleType) {
                renderSimpleType(sb, (SimpleType) unwrap);
            }
        } else {
            sb.append("<Not computed yet>");
        }
    }

    private final void renderSimpleType(StringBuilder sb, SimpleType simpleType) {
        if (!Intrinsics.areEqual((Object) simpleType, (Object) TypeUtils.CANNOT_INFER_FUNCTION_PARAM_TYPE)) {
            KotlinType kotlinType = simpleType;
            if (!TypeUtils.isDontCarePlaceholder(kotlinType)) {
                if (ErrorUtils.isUninferredTypeVariable(kotlinType)) {
                    if (getUninferredTypeParameterAsName()) {
                        TypeConstructor constructor = simpleType.getConstructor();
                        Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                        sb.append(renderError(((ErrorTypeConstructor) constructor).getParam(0)));
                        return;
                    }
                    sb.append("???");
                    return;
                } else if (KotlinTypeKt.isError(kotlinType)) {
                    renderDefaultType(sb, kotlinType);
                    return;
                } else if (shouldRenderAsPrettyFunctionType(kotlinType)) {
                    renderFunctionType(sb, kotlinType);
                    return;
                } else {
                    renderDefaultType(sb, kotlinType);
                    return;
                }
            }
        }
        sb.append("???");
    }

    private final boolean shouldRenderAsPrettyFunctionType(KotlinType kotlinType) {
        if (FunctionTypesKt.isBuiltinFunctionalType(kotlinType)) {
            Iterable<TypeProjection> arguments = kotlinType.getArguments();
            if (!(arguments instanceof Collection) || !((Collection) arguments).isEmpty()) {
                for (TypeProjection isStarProjection : arguments) {
                    if (isStarProjection.isStarProjection()) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.checkNotNullParameter(str, "lowerRendered");
        Intrinsics.checkNotNullParameter(str2, "upperRendered");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (!RenderingUtilsKt.typeStringsDifferOnlyInNullability(str, str2)) {
            ClassifierNamePolicy classifierNamePolicy = getClassifierNamePolicy();
            ClassDescriptor collection = kotlinBuiltIns.getCollection();
            Intrinsics.checkNotNullExpressionValue(collection, "getCollection(...)");
            DescriptorRenderer descriptorRenderer = this;
            String substringBefore$default = StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(collection, descriptorRenderer), "Collection", (String) null, 2, (Object) null);
            String replacePrefixesInTypeRepresentations = RenderingUtilsKt.replacePrefixesInTypeRepresentations(str, substringBefore$default + "Mutable", str2, substringBefore$default, substringBefore$default + "(Mutable)");
            if (replacePrefixesInTypeRepresentations != null) {
                return replacePrefixesInTypeRepresentations;
            }
            String replacePrefixesInTypeRepresentations2 = RenderingUtilsKt.replacePrefixesInTypeRepresentations(str, substringBefore$default + "MutableMap.MutableEntry", str2, substringBefore$default + "Map.Entry", substringBefore$default + "(Mutable)Map.(Mutable)Entry");
            if (replacePrefixesInTypeRepresentations2 != null) {
                return replacePrefixesInTypeRepresentations2;
            }
            ClassifierNamePolicy classifierNamePolicy2 = getClassifierNamePolicy();
            ClassDescriptor array = kotlinBuiltIns.getArray();
            Intrinsics.checkNotNullExpressionValue(array, "getArray(...)");
            String substringBefore$default2 = StringsKt.substringBefore$default(classifierNamePolicy2.renderClassifier(array, descriptorRenderer), "Array", (String) null, 2, (Object) null);
            String replacePrefixesInTypeRepresentations3 = RenderingUtilsKt.replacePrefixesInTypeRepresentations(str, substringBefore$default2 + escape("Array<"), str2, substringBefore$default2 + escape("Array<out "), substringBefore$default2 + escape("Array<(out) "));
            if (replacePrefixesInTypeRepresentations3 != null) {
                return replacePrefixesInTypeRepresentations3;
            }
            return "(" + str + ".." + str2 + ')';
        } else if (StringsKt.startsWith$default(str2, "(", false, 2, (Object) null)) {
            return "(" + str + ")!";
        } else {
            return str + '!';
        }
    }

    public String renderTypeArguments(List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lt());
        appendTypeProjections(sb, list);
        sb.append(gt());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final void renderDefaultType(StringBuilder sb, KotlinType kotlinType) {
        renderAnnotations$default(this, sb, kotlinType, (AnnotationUseSiteTarget) null, 2, (Object) null);
        SimpleType simpleType = null;
        DefinitelyNotNullType definitelyNotNullType = kotlinType instanceof DefinitelyNotNullType ? (DefinitelyNotNullType) kotlinType : null;
        if (definitelyNotNullType != null) {
            simpleType = definitelyNotNullType.getOriginal();
        }
        if (KotlinTypeKt.isError(kotlinType)) {
            if (!TypeUtilsKt.isUnresolvedType(kotlinType) || !getPresentableUnresolvedTypes()) {
                if (!(kotlinType instanceof ErrorType) || getInformativeErrorType()) {
                    sb.append(kotlinType.getConstructor().toString());
                } else {
                    sb.append(((ErrorType) kotlinType).getDebugMessage());
                }
                sb.append(renderTypeArguments(kotlinType.getArguments()));
            } else {
                sb.append(renderError(ErrorUtils.INSTANCE.unresolvedTypeAsItIs(kotlinType)));
            }
        } else if (kotlinType instanceof StubTypeForBuilderInference) {
            sb.append(((StubTypeForBuilderInference) kotlinType).getOriginalTypeVariable().toString());
        } else if (simpleType instanceof StubTypeForBuilderInference) {
            sb.append(((StubTypeForBuilderInference) simpleType).getOriginalTypeVariable().toString());
        } else {
            renderTypeConstructorAndArguments$default(this, sb, kotlinType, (TypeConstructor) null, 2, (Object) null);
        }
        if (kotlinType.isMarkedNullable()) {
            sb.append("?");
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
            sb.append(" & Any");
        }
    }

    static /* synthetic */ void renderTypeConstructorAndArguments$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, KotlinType kotlinType, TypeConstructor typeConstructor, int i, Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = kotlinType.getConstructor();
        }
        descriptorRendererImpl.renderTypeConstructorAndArguments(sb, kotlinType, typeConstructor);
    }

    private final void renderTypeConstructorAndArguments(StringBuilder sb, KotlinType kotlinType, TypeConstructor typeConstructor) {
        PossiblyInnerType buildPossiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType(kotlinType);
        if (buildPossiblyInnerType == null) {
            sb.append(renderTypeConstructor(typeConstructor));
            sb.append(renderTypeArguments(kotlinType.getArguments()));
            return;
        }
        renderPossiblyInnerType(sb, buildPossiblyInnerType);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
        if (r3 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void renderPossiblyInnerType(java.lang.StringBuilder r3, kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType r4) {
        /*
            r2 = this;
            kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType r0 = r4.getOuterType()
            if (r0 == 0) goto L_0x0025
            r2.renderPossiblyInnerType(r3, r0)
            r0 = 46
            r3.append(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r0 = r4.getClassifierDescriptor()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r0.getName()
            java.lang.String r1 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = 0
            java.lang.String r0 = r2.renderName(r0, r1)
            r3.append(r0)
            if (r3 != 0) goto L_0x0039
        L_0x0025:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r0 = r4.getClassifierDescriptor()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r0.getTypeConstructor()
            java.lang.String r1 = "getTypeConstructor(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r0 = r2.renderTypeConstructor(r0)
            r3.append(r0)
        L_0x0039:
            java.util.List r4 = r4.getArguments()
            java.lang.String r4 = r2.renderTypeArguments(r4)
            r3.append(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderPossiblyInnerType(java.lang.StringBuilder, kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType):void");
    }

    public String renderTypeConstructor(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        boolean z = true;
        if (!(declarationDescriptor instanceof TypeParameterDescriptor ? true : declarationDescriptor instanceof ClassDescriptor)) {
            z = declarationDescriptor instanceof TypeAliasDescriptor;
        }
        if (z) {
            return renderClassifierName(declarationDescriptor);
        }
        if (declarationDescriptor != null) {
            throw new IllegalStateException(("Unexpected classifier: " + declarationDescriptor.getClass()).toString());
        } else if (typeConstructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) typeConstructor).makeDebugNameForIntersectionType(DescriptorRendererImpl$renderTypeConstructor$1.INSTANCE);
        } else {
            return typeConstructor.toString();
        }
    }

    public String renderTypeProjection(TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        StringBuilder sb = new StringBuilder();
        appendTypeProjections(sb, CollectionsKt.listOf(typeProjection));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final void appendTypeProjections(StringBuilder sb, List<? extends TypeProjection> list) {
        CollectionsKt.joinTo$default(list, sb, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new DescriptorRendererImpl$appendTypeProjections$1(this), 60, (Object) null);
    }

    private final void renderFunctionType(StringBuilder sb, KotlinType kotlinType) {
        Name name;
        int length = sb.length();
        renderAnnotations$default(getFunctionTypeAnnotationsRenderer(), sb, kotlinType, (AnnotationUseSiteTarget) null, 2, (Object) null);
        boolean z = sb.length() != length;
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        List<KotlinType> contextReceiverTypesFromFunctionType = FunctionTypesKt.getContextReceiverTypesFromFunctionType(kotlinType);
        if (!contextReceiverTypesFromFunctionType.isEmpty()) {
            sb.append("context(");
            for (KotlinType renderNormalizedType : contextReceiverTypesFromFunctionType.subList(0, CollectionsKt.getLastIndex(contextReceiverTypesFromFunctionType))) {
                renderNormalizedType(sb, renderNormalizedType);
                sb.append(", ");
            }
            renderNormalizedType(sb, (KotlinType) CollectionsKt.last(contextReceiverTypesFromFunctionType));
            sb.append(") ");
        }
        boolean isSuspendFunctionType = FunctionTypesKt.isSuspendFunctionType(kotlinType);
        boolean isMarkedNullable = kotlinType.isMarkedNullable();
        boolean z2 = isMarkedNullable || (z && receiverTypeFromFunctionType != null);
        if (z2) {
            if (isSuspendFunctionType) {
                sb.insert(length, '(');
            } else {
                if (z) {
                    CharSequence charSequence = sb;
                    CharsKt.isWhitespace(StringsKt.last(charSequence));
                    if (sb.charAt(StringsKt.getLastIndex(charSequence) - 1) != ')') {
                        sb.insert(StringsKt.getLastIndex(charSequence), "()");
                    }
                }
                sb.append("(");
            }
        }
        renderModifier(sb, isSuspendFunctionType, "suspend");
        if (receiverTypeFromFunctionType != null) {
            boolean z3 = (shouldRenderAsPrettyFunctionType(receiverTypeFromFunctionType) && !receiverTypeFromFunctionType.isMarkedNullable()) || hasModifiersOrAnnotations(receiverTypeFromFunctionType) || (receiverTypeFromFunctionType instanceof DefinitelyNotNullType);
            if (z3) {
                sb.append("(");
            }
            renderNormalizedType(sb, receiverTypeFromFunctionType);
            if (z3) {
                sb.append(")");
            }
            sb.append(InstructionFileId.DOT);
        }
        sb.append("(");
        if (!FunctionTypesKt.isBuiltinExtensionFunctionalType(kotlinType) || kotlinType.getArguments().size() > 1) {
            int i = 0;
            for (TypeProjection next : FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType)) {
                int i2 = i + 1;
                if (i > 0) {
                    sb.append(", ");
                }
                if (getParameterNamesInFunctionalTypes()) {
                    KotlinType type = next.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    name = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type);
                } else {
                    name = null;
                }
                if (name != null) {
                    sb.append(renderName(name, false));
                    sb.append(": ");
                }
                sb.append(renderTypeProjection(next));
                i = i2;
            }
        } else {
            sb.append("???");
        }
        sb.append(") ");
        sb.append(arrow());
        sb.append(" ");
        renderNormalizedType(sb, FunctionTypesKt.getReturnTypeFromFunctionType(kotlinType));
        if (z2) {
            sb.append(")");
        }
        if (isMarkedNullable) {
            sb.append("?");
        }
    }

    private final boolean hasModifiersOrAnnotations(KotlinType kotlinType) {
        return FunctionTypesKt.isSuspendFunctionType(kotlinType) || !kotlinType.getAnnotations().isEmpty();
    }

    private final void appendDefinedIn(StringBuilder sb, DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptor containingDeclaration;
        String name;
        if (!(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor) && (containingDeclaration = declarationDescriptor.getContainingDeclaration()) != null && !(containingDeclaration instanceof ModuleDescriptor)) {
            sb.append(" ");
            sb.append(renderMessage("defined in"));
            sb.append(" ");
            FqNameUnsafe fqName = DescriptorUtils.getFqName(containingDeclaration);
            Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(...)");
            sb.append(fqName.isRoot() ? "root package" : renderFqName(fqName));
            if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && (name = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile().getName()) != null) {
                sb.append(" ");
                sb.append(renderMessage("in file"));
                sb.append(" ");
                sb.append(name);
            }
        }
    }

    static /* synthetic */ void renderAnnotations$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if ((i & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.renderAnnotations(sb, annotated, annotationUseSiteTarget);
    }

    private final void renderAnnotations(StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Set<FqName> excludedTypeAnnotationClasses = annotated instanceof KotlinType ? getExcludedTypeAnnotationClasses() : getExcludedAnnotationClasses();
            Function1<AnnotationDescriptor, Boolean> annotationFilter = getAnnotationFilter();
            for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
                if (!CollectionsKt.contains(excludedTypeAnnotationClasses, annotationDescriptor.getFqName()) && !isParameterName(annotationDescriptor)) {
                    if (annotationFilter == null || annotationFilter.invoke(annotationDescriptor).booleanValue()) {
                        sb.append(renderAnnotation(annotationDescriptor, annotationUseSiteTarget));
                        if (getEachAnnotationOnNewLine()) {
                            sb.append(10);
                            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                        } else {
                            sb.append(" ");
                        }
                    }
                }
            }
        }
    }

    private final boolean isParameterName(AnnotationDescriptor annotationDescriptor) {
        return Intrinsics.areEqual((Object) annotationDescriptor.getFqName(), (Object) StandardNames.FqNames.parameterName);
    }

    public String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (annotationUseSiteTarget != null) {
            sb.append(annotationUseSiteTarget.getRenderName() + ':');
        }
        KotlinType type = annotationDescriptor.getType();
        sb.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            List<String> renderAndSortAnnotationArguments = renderAndSortAnnotationArguments(annotationDescriptor);
            if (getIncludeEmptyAnnotationArguments() || (!renderAndSortAnnotationArguments.isEmpty())) {
                CollectionsKt.joinTo$default(renderAndSortAnnotationArguments, sb, ", ", "(", ")", 0, (CharSequence) null, (Function1) null, 112, (Object) null);
            }
        }
        if (getVerbose() && (KotlinTypeKt.isError(type) || (type.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor))) {
            sb.append(" /* annotation class not found */");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> renderAndSortAnnotationArguments(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r8) {
        /*
            r7 = this;
            java.util.Map r0 = r8.getAllValueArguments()
            boolean r1 = r7.getRenderDefaultAnnotationArguments()
            r2 = 0
            if (r1 == 0) goto L_0x0010
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getAnnotationClass(r8)
            goto L_0x0011
        L_0x0010:
            r8 = r2
        L_0x0011:
            r1 = 10
            if (r8 == 0) goto L_0x006f
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r8 = r8.getUnsubstitutedPrimaryConstructor()
            if (r8 == 0) goto L_0x006f
            java.util.List r8 = r8.getValueParameters()
            if (r8 == 0) goto L_0x006f
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r8 = r8.iterator()
        L_0x002e:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0045
            java.lang.Object r3 = r8.next()
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            boolean r4 = r4.declaresDefaultValue()
            if (r4 == 0) goto L_0x002e
            r2.add(r3)
            goto L_0x002e
        L_0x0045:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r8 = new java.util.ArrayList
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r1)
            r8.<init>(r3)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r2 = r2.iterator()
        L_0x0058:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x006c
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r3
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r3.getName()
            r8.add(r3)
            goto L_0x0058
        L_0x006c:
            r2 = r8
            java.util.List r2 = (java.util.List) r2
        L_0x006f:
            if (r2 != 0) goto L_0x0075
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0075:
            r8 = r2
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r8 = r8.iterator()
        L_0x0083:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x009f
            java.lang.Object r4 = r8.next()
            r5 = r4
            kotlin.reflect.jvm.internal.impl.name.Name r5 = (kotlin.reflect.jvm.internal.impl.name.Name) r5
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            boolean r5 = r0.containsKey(r5)
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x0083
            r3.add(r4)
            goto L_0x0083
        L_0x009f:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r8 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r1)
            r8.<init>(r4)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r3 = r3.iterator()
        L_0x00b2:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00d7
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.name.Name r4 = (kotlin.reflect.jvm.internal.impl.name.Name) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = r4.asString()
            r5.append(r4)
            java.lang.String r4 = " = ..."
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r8.add(r4)
            goto L_0x00b2
        L_0x00d7:
            java.util.List r8 = (java.util.List) r8
            java.util.Set r0 = r0.entrySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r1)
            r3.<init>(r1)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r0 = r0.iterator()
        L_0x00ee:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x012f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r4 = r1.getKey()
            kotlin.reflect.jvm.internal.impl.name.Name r4 = (kotlin.reflect.jvm.internal.impl.name.Name) r4
            java.lang.Object r1 = r1.getValue()
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue r1 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r4.asString()
            r5.append(r6)
            java.lang.String r6 = " = "
            r5.append(r6)
            boolean r4 = r2.contains(r4)
            if (r4 != 0) goto L_0x0122
            java.lang.String r1 = r7.renderConstant(r1)
            goto L_0x0124
        L_0x0122:
            java.lang.String r1 = "..."
        L_0x0124:
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r3.add(r1)
            goto L_0x00ee
        L_0x012f:
            java.util.List r3 = (java.util.List) r3
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r8 = kotlin.collections.CollectionsKt.plus(r8, r3)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.List r8 = kotlin.collections.CollectionsKt.sorted(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderAndSortAnnotationArguments(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor):java.util.List");
    }

    private final String renderConstant(ConstantValue<?> constantValue) {
        Function1<ConstantValue<?>, String> propertyConstantRenderer = this.options.getPropertyConstantRenderer();
        if (propertyConstantRenderer != null) {
            return propertyConstantRenderer.invoke(constantValue);
        }
        if (constantValue instanceof ArrayValue) {
            Collection arrayList = new ArrayList();
            for (ConstantValue renderConstant : (Iterable) ((ArrayValue) constantValue).getValue()) {
                String renderConstant2 = renderConstant(renderConstant);
                if (renderConstant2 != null) {
                    arrayList.add(renderConstant2);
                }
            }
            return CollectionsKt.joinToString$default((List) arrayList, ", ", "{", "}", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
        } else if (constantValue instanceof AnnotationValue) {
            return StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, (AnnotationDescriptor) ((AnnotationValue) constantValue).getValue(), (AnnotationUseSiteTarget) null, 2, (Object) null), (CharSequence) "@");
        } else {
            if (!(constantValue instanceof KClassValue)) {
                return constantValue.toString();
            }
            KClassValue.Value value = (KClassValue.Value) ((KClassValue) constantValue).getValue();
            if (value instanceof KClassValue.Value.LocalClass) {
                return ((KClassValue.Value.LocalClass) value).getType() + "::class";
            } else if (value instanceof KClassValue.Value.NormalClass) {
                KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value;
                String asString = normalClass.getClassId().asSingleFqName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                for (int i = 0; i < normalClass.getArrayDimensions(); i++) {
                    asString = "kotlin.Array<" + asString + Typography.greater;
                }
                return asString + "::class";
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    private final boolean renderVisibility(DescriptorVisibility descriptorVisibility, StringBuilder sb) {
        if (!getModifiers().contains(DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            descriptorVisibility = descriptorVisibility.normalize();
        }
        if (!getRenderDefaultVisibility() && Intrinsics.areEqual((Object) descriptorVisibility, (Object) DescriptorVisibilities.DEFAULT_VISIBILITY)) {
            return false;
        }
        sb.append(renderKeyword(descriptorVisibility.getInternalDisplayName()));
        sb.append(" ");
        return true;
    }

    private final void renderModality(Modality modality, StringBuilder sb, Modality modality2) {
        if (getRenderDefaultModality() || modality != modality2) {
            renderModifier(sb, getModifiers().contains(DescriptorRendererModifier.MODALITY), CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(modality.name()));
        }
    }

    private final Modality implicitModalityWithoutExtensions(MemberDescriptor memberDescriptor) {
        if (memberDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) memberDescriptor).getKind() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            return Modality.FINAL;
        }
        if (!(memberDescriptor instanceof CallableMemberDescriptor)) {
            return Modality.FINAL;
        }
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        if ((!overriddenDescriptors.isEmpty()) && classDescriptor.getModality() != Modality.FINAL) {
            return Modality.OPEN;
        }
        if (classDescriptor.getKind() != ClassKind.INTERFACE || Intrinsics.areEqual((Object) callableMemberDescriptor.getVisibility(), (Object) DescriptorVisibilities.PRIVATE)) {
            return Modality.FINAL;
        }
        return callableMemberDescriptor.getModality() == Modality.ABSTRACT ? Modality.ABSTRACT : Modality.OPEN;
    }

    private final void renderModalityForCallable(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (DescriptorUtils.isTopLevelDeclaration(callableMemberDescriptor) && callableMemberDescriptor.getModality() == Modality.FINAL) {
            return;
        }
        if (getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OVERRIDE || callableMemberDescriptor.getModality() != Modality.OPEN || !overridesSomething(callableMemberDescriptor)) {
            Modality modality = callableMemberDescriptor.getModality();
            Intrinsics.checkNotNullExpressionValue(modality, "getModality(...)");
            renderModality(modality, sb, implicitModalityWithoutExtensions(callableMemberDescriptor));
        }
    }

    private final void renderOverride(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) && overridesSomething(callableMemberDescriptor) && getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OPEN) {
            renderModifier(sb, true, "override");
            if (getVerbose()) {
                sb.append("/*");
                sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    private final void renderMemberKind(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) && getVerbose() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb.append("/*");
            sb.append(CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(callableMemberDescriptor.getKind().name()));
            sb.append("*/ ");
        }
    }

    private final void renderModifier(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(renderKeyword(str));
            sb.append(" ");
        }
    }

    private final void renderMemberModifiers(MemberDescriptor memberDescriptor, StringBuilder sb) {
        renderModifier(sb, memberDescriptor.isExternal(), "external");
        boolean z = true;
        renderModifier(sb, getModifiers().contains(DescriptorRendererModifier.EXPECT) && memberDescriptor.isExpect(), "expect");
        if (!getModifiers().contains(DescriptorRendererModifier.ACTUAL) || !memberDescriptor.isActual()) {
            z = false;
        }
        renderModifier(sb, z, "actual");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (getAlwaysRenderModifiers() != false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        if (getAlwaysRenderModifiers() != false) goto L_0x0073;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void renderAdditionalModifiers(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6, java.lang.StringBuilder r7) {
        /*
            r5 = this;
            boolean r0 = r6.isOperator()
            r1 = 1
            java.lang.String r2 = "getOverriddenDescriptors(...)"
            r3 = 0
            if (r0 == 0) goto L_0x003b
            java.util.Collection r0 = r6.getOverriddenDescriptors()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x001d
            goto L_0x0039
        L_0x001d:
            java.util.Iterator r0 = r0.iterator()
        L_0x0021:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0039
            java.lang.Object r4 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            boolean r4 = r4.isOperator()
            if (r4 == 0) goto L_0x0021
            boolean r0 = r5.getAlwaysRenderModifiers()
            if (r0 == 0) goto L_0x003b
        L_0x0039:
            r0 = r1
            goto L_0x003c
        L_0x003b:
            r0 = r3
        L_0x003c:
            boolean r4 = r6.isInfix()
            if (r4 == 0) goto L_0x0072
            java.util.Collection r4 = r6.getOverriddenDescriptors()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r2 = r4
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0055
            goto L_0x0073
        L_0x0055:
            java.util.Iterator r2 = r4.iterator()
        L_0x0059:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0073
            java.lang.Object r4 = r2.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            boolean r4 = r4.isInfix()
            if (r4 == 0) goto L_0x0059
            boolean r2 = r5.getAlwaysRenderModifiers()
            if (r2 == 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r1 = r3
        L_0x0073:
            boolean r2 = r6.isTailrec()
            java.lang.String r3 = "tailrec"
            r5.renderModifier(r7, r2, r3)
            r5.renderSuspendModifier(r6, r7)
            boolean r6 = r6.isInline()
            java.lang.String r2 = "inline"
            r5.renderModifier(r7, r6, r2)
            java.lang.String r6 = "infix"
            r5.renderModifier(r7, r1, r6)
            java.lang.String r6 = "operator"
            r5.renderModifier(r7, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderAdditionalModifiers(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.StringBuilder):void");
    }

    private final void renderSuspendModifier(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        renderModifier(sb, functionDescriptor.isSuspend(), "suspend");
    }

    public String render(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.accept(new RenderDeclarationDescriptorVisitor(), sb);
        if (getWithDefinedIn()) {
            appendDefinedIn(sb, declarationDescriptor);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* access modifiers changed from: private */
    public final void renderTypeParameter(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z) {
        if (z) {
            sb.append(lt());
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        renderModifier(sb, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z2 = true;
        renderModifier(sb, label.length() > 0, label);
        renderAnnotations$default(this, sb, typeParameterDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
        renderName(typeParameterDescriptor, sb, z);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            KotlinType next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(next)) {
                sb.append(" : ");
                Intrinsics.checkNotNull(next);
                sb.append(renderType(next));
            }
        } else if (z) {
            for (KotlinType next2 : typeParameterDescriptor.getUpperBounds()) {
                if (!KotlinBuiltIns.isDefaultBound(next2)) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    Intrinsics.checkNotNull(next2);
                    sb.append(renderType(next2));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(gt());
        }
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> list, StringBuilder sb, boolean z) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb.append(lt());
            renderTypeParameterList(sb, list);
            sb.append(gt());
            if (z) {
                sb.append(" ");
            }
        }
    }

    private final void renderTypeParameterList(StringBuilder sb, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            renderTypeParameter((TypeParameterDescriptor) it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void renderFunction(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                renderAnnotations$default(this, sb, functionDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
                List<ReceiverParameterDescriptor> contextReceiverParameters = functionDescriptor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
                renderContextReceivers(contextReceiverParameters, sb);
                DescriptorVisibility visibility = functionDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
                renderVisibility(visibility, sb);
                CallableMemberDescriptor callableMemberDescriptor = functionDescriptor;
                renderModalityForCallable(callableMemberDescriptor, sb);
                if (getIncludeAdditionalModifiers()) {
                    renderMemberModifiers(functionDescriptor, sb);
                }
                renderOverride(callableMemberDescriptor, sb);
                if (getIncludeAdditionalModifiers()) {
                    renderAdditionalModifiers(functionDescriptor, sb);
                } else {
                    renderSuspendModifier(functionDescriptor, sb);
                }
                renderMemberKind(callableMemberDescriptor, sb);
                if (getVerbose()) {
                    if (functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(renderKeyword("fun"));
            sb.append(" ");
            List<TypeParameterDescriptor> typeParameters = functionDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            renderTypeParameters(typeParameters, sb, true);
            renderReceiver(functionDescriptor, sb);
        }
        renderName(functionDescriptor, sb, true);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        renderValueParameters(valueParameters, functionDescriptor.hasSynthesizedParameterNames(), sb);
        renderReceiverAfterName(functionDescriptor, sb);
        KotlinType returnType = functionDescriptor.getReturnType();
        if (!getWithoutReturnType() && (getUnitReturnType() || returnType == null || !KotlinBuiltIns.isUnit(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : renderType(returnType));
        }
        List<TypeParameterDescriptor> typeParameters2 = functionDescriptor.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "getTypeParameters(...)");
        renderWhereSuffix(typeParameters2, sb);
    }

    private final void renderReceiverAfterName(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            sb.append(renderType(type));
        }
    }

    private final String renderForReceiver(KotlinType kotlinType) {
        String renderType = renderType(kotlinType);
        if ((!shouldRenderAsPrettyFunctionType(kotlinType) || TypeUtils.isNullableType(kotlinType)) && !(kotlinType instanceof DefinitelyNotNullType)) {
            return renderType;
        }
        return "(" + renderType + ')';
    }

    private final void renderContextReceivers(List<? extends ReceiverParameterDescriptor> list, StringBuilder sb) {
        if (!list.isEmpty()) {
            sb.append("context(");
            int i = 0;
            for (ReceiverParameterDescriptor receiverParameterDescriptor : list) {
                int i2 = i + 1;
                renderAnnotations(sb, receiverParameterDescriptor, AnnotationUseSiteTarget.RECEIVER);
                KotlinType type = receiverParameterDescriptor.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                sb.append(renderForReceiver(type));
                if (i == CollectionsKt.getLastIndex(list)) {
                    sb.append(") ");
                } else {
                    sb.append(", ");
                }
                i = i2;
            }
        }
    }

    private final void renderReceiver(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            renderAnnotations(sb, extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            sb.append(renderForReceiver(type));
            sb.append(InstructionFileId.DOT);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void renderConstructor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r18, java.lang.StringBuilder r19) {
        /*
            r17 = this;
            r6 = r17
            r7 = r19
            r2 = r18
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r2
            r4 = 2
            r5 = 0
            r3 = 0
            r0 = r17
            r1 = r19
            renderAnnotations$default(r0, r1, r2, r3, r4, r5)
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r0 = r6.options
            boolean r0 = r0.getRenderDefaultVisibility()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0028
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = r18.getConstructedClass()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = r0.getModality()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r3 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED
            if (r0 == r3) goto L_0x0039
        L_0x0028:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r0 = r18.getVisibility()
            java.lang.String r3 = "getVisibility(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r0 = r6.renderVisibility(r0, r7)
            if (r0 == 0) goto L_0x0039
            r0 = r2
            goto L_0x003a
        L_0x0039:
            r0 = r1
        L_0x003a:
            r3 = r18
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3
            r6.renderMemberKind(r3, r7)
            boolean r3 = r17.getRenderConstructorKeyword()
            if (r3 != 0) goto L_0x0052
            boolean r3 = r18.isPrimary()
            if (r3 == 0) goto L_0x0052
            if (r0 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r0 = r1
            goto L_0x0053
        L_0x0052:
            r0 = r2
        L_0x0053:
            if (r0 == 0) goto L_0x005e
            java.lang.String r3 = "constructor"
            java.lang.String r3 = r6.renderKeyword(r3)
            r7.append(r3)
        L_0x005e:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r3 = r18.getContainingDeclaration()
            java.lang.String r4 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r4 = r17.getSecondaryConstructorsAsPrimary()
            java.lang.String r5 = "getTypeParameters(...)"
            if (r4 == 0) goto L_0x0086
            if (r0 == 0) goto L_0x0076
            java.lang.String r0 = " "
            r7.append(r0)
        L_0x0076:
            r0 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r0
            r6.renderName(r0, r7, r2)
            java.util.List r0 = r18.getTypeParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r6.renderTypeParameters(r0, r7, r1)
        L_0x0086:
            java.util.List r0 = r18.getValueParameters()
            java.lang.String r1 = "getValueParameters(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r4 = r18.hasSynthesizedParameterNames()
            r6.renderValueParameters(r0, r4, r7)
            boolean r0 = r17.getRenderConstructorDelegation()
            if (r0 == 0) goto L_0x011f
            boolean r0 = r18.isPrimary()
            if (r0 != 0) goto L_0x011f
            boolean r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 == 0) goto L_0x011f
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r0 = r3.getUnsubstitutedPrimaryConstructor()
            if (r0 == 0) goto L_0x011f
            java.util.List r0 = r0.getValueParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x00c4:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00e1
            java.lang.Object r3 = r0.next()
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            boolean r8 = r4.declaresDefaultValue()
            if (r8 != 0) goto L_0x00c4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.getVarargElementType()
            if (r4 != 0) goto L_0x00c4
            r1.add(r3)
            goto L_0x00c4
        L_0x00e1:
            java.util.List r1 = (java.util.List) r1
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x011f
            java.lang.String r0 = " : "
            r7.append(r0)
            java.lang.String r0 = "this"
            java.lang.String r0 = r6.renderKeyword(r0)
            r7.append(r0)
            r8 = r1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.lang.String r0 = ", "
            r9 = r0
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r0 = "("
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.String r0 = ")"
            r11 = r0
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstructor$1 r0 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstructor$1.INSTANCE
            r14 = r0
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r15 = 24
            r16 = 0
            r12 = 0
            r13 = 0
            java.lang.String r0 = kotlin.collections.CollectionsKt.joinToString$default(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r7.append(r0)
        L_0x011f:
            boolean r0 = r17.getSecondaryConstructorsAsPrimary()
            if (r0 == 0) goto L_0x012f
            java.util.List r0 = r18.getTypeParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r6.renderWhereSuffix(r0, r7)
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderConstructor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, java.lang.StringBuilder):void");
    }

    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> list, StringBuilder sb) {
        if (!getWithoutTypeParameters()) {
            ArrayList arrayList = new ArrayList(0);
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                for (KotlinType kotlinType : CollectionsKt.drop(upperBounds, 1)) {
                    StringBuilder sb2 = new StringBuilder();
                    Name name = typeParameterDescriptor.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    sb2.append(renderName(name, false));
                    sb2.append(" : ");
                    Intrinsics.checkNotNull(kotlinType);
                    sb2.append(renderType(kotlinType));
                    arrayList.add(sb2.toString());
                }
                Collection collection = arrayList;
            }
            if (!arrayList.isEmpty()) {
                sb.append(" ");
                sb.append(renderKeyword("where"));
                sb.append(" ");
                CollectionsKt.joinTo$default(arrayList, sb, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null);
            }
        }
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> collection, boolean z, StringBuilder sb) {
        boolean shouldRenderParameterNames = shouldRenderParameterNames(z);
        int size = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(size, sb);
        int i = 0;
        for (ValueParameterDescriptor valueParameterDescriptor : collection) {
            getValueParametersHandler().appendBeforeValueParameter(valueParameterDescriptor, i, size, sb);
            renderValueParameter(valueParameterDescriptor, shouldRenderParameterNames, sb, false);
            getValueParametersHandler().appendAfterValueParameter(valueParameterDescriptor, i, size, sb);
            i++;
        }
        getValueParametersHandler().appendAfterValueParameters(size, sb);
    }

    private final boolean shouldRenderParameterNames(boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$1[getParameterNameRenderingPolicy().ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!z) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005d, code lost:
        if (r0.isPrimary() == true) goto L_0x0061;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void renderValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r9, boolean r10, java.lang.StringBuilder r11, boolean r12) {
        /*
            r8 = this;
            if (r12 == 0) goto L_0x0010
            java.lang.String r0 = "value-parameter"
            java.lang.String r0 = r8.renderKeyword(r0)
            r11.append(r0)
            java.lang.String r0 = " "
            r11.append(r0)
        L_0x0010:
            boolean r0 = r8.getVerbose()
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = "/*"
            r11.append(r0)
            int r0 = r9.getIndex()
            r11.append(r0)
            java.lang.String r0 = "*/ "
            r11.append(r0)
        L_0x0027:
            r3 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r3 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r3
            r5 = 2
            r6 = 0
            r4 = 0
            r1 = r8
            r2 = r11
            renderAnnotations$default(r1, r2, r3, r4, r5, r6)
            boolean r0 = r9.isCrossinline()
            java.lang.String r1 = "crossinline"
            r8.renderModifier(r11, r0, r1)
            boolean r0 = r9.isNoinline()
            java.lang.String r1 = "noinline"
            r8.renderModifier(r11, r0, r1)
            boolean r0 = r8.getRenderPrimaryConstructorParametersAsProperties()
            if (r0 == 0) goto L_0x0060
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r0 = r9.getContainingDeclaration()
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor
            if (r1 == 0) goto L_0x0055
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r0
            goto L_0x0056
        L_0x0055:
            r0 = 0
        L_0x0056:
            if (r0 == 0) goto L_0x0060
            boolean r0 = r0.isPrimary()
            r1 = 1
            if (r0 != r1) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            r7 = r1
            if (r7 == 0) goto L_0x006d
            boolean r0 = r8.getActualPropertiesInPrimaryConstructor()
            java.lang.String r1 = "actual"
            r8.renderModifier(r11, r0, r1)
        L_0x006d:
            r3 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor) r3
            r2 = r8
            r4 = r10
            r5 = r11
            r6 = r12
            r2.renderVariable(r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function1 r10 = r8.getDefaultParameterValueRenderer()
            if (r10 == 0) goto L_0x00ac
            boolean r10 = r8.getDebugMode()
            if (r10 == 0) goto L_0x0088
            boolean r10 = r9.declaresDefaultValue()
            goto L_0x008c
        L_0x0088:
            boolean r10 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(r9)
        L_0x008c:
            if (r10 == 0) goto L_0x00ac
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = " = "
            r10.<init>(r12)
            kotlin.jvm.functions.Function1 r12 = r8.getDefaultParameterValueRenderer()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            java.lang.Object r9 = r12.invoke(r9)
            java.lang.String r9 = (java.lang.String) r9
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r11.append(r9)
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, boolean, java.lang.StringBuilder, boolean):void");
    }

    static /* synthetic */ void renderValVarPrefix$default(DescriptorRendererImpl descriptorRendererImpl, VariableDescriptor variableDescriptor, StringBuilder sb, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        descriptorRendererImpl.renderValVarPrefix(variableDescriptor, sb, z);
    }

    private final void renderValVarPrefix(VariableDescriptor variableDescriptor, StringBuilder sb, boolean z) {
        if (z || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            sb.append(renderKeyword(variableDescriptor.isVar() ? "var" : "val"));
            sb.append(" ");
        }
    }

    private final void renderVariable(VariableDescriptor variableDescriptor, boolean z, StringBuilder sb, boolean z2, boolean z3) {
        KotlinType type = variableDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        KotlinType kotlinType = null;
        ValueParameterDescriptor valueParameterDescriptor = variableDescriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) variableDescriptor : null;
        if (valueParameterDescriptor != null) {
            kotlinType = valueParameterDescriptor.getVarargElementType();
        }
        KotlinType kotlinType2 = kotlinType == null ? type : kotlinType;
        renderModifier(sb, kotlinType != null, "vararg");
        if (z3 || (z2 && !getStartFromName())) {
            renderValVarPrefix(variableDescriptor, sb, z3);
        }
        if (z) {
            renderName(variableDescriptor, sb, z2);
            sb.append(": ");
        }
        sb.append(renderType(kotlinType2));
        renderInitializer(variableDescriptor, sb);
        if (getVerbose() && kotlinType != null) {
            sb.append(" /*");
            sb.append(renderType(type));
            sb.append("*/");
        }
    }

    /* access modifiers changed from: private */
    public final void renderProperty(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                renderPropertyAnnotations(propertyDescriptor, sb);
                List<ReceiverParameterDescriptor> contextReceiverParameters = propertyDescriptor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
                renderContextReceivers(contextReceiverParameters, sb);
                DescriptorVisibility visibility = propertyDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
                renderVisibility(visibility, sb);
                boolean z = false;
                renderModifier(sb, getModifiers().contains(DescriptorRendererModifier.CONST) && propertyDescriptor.isConst(), "const");
                renderMemberModifiers(propertyDescriptor, sb);
                CallableMemberDescriptor callableMemberDescriptor = propertyDescriptor;
                renderModalityForCallable(callableMemberDescriptor, sb);
                renderOverride(callableMemberDescriptor, sb);
                if (getModifiers().contains(DescriptorRendererModifier.LATEINIT) && propertyDescriptor.isLateInit()) {
                    z = true;
                }
                renderModifier(sb, z, "lateinit");
                renderMemberKind(callableMemberDescriptor, sb);
            }
            renderValVarPrefix$default(this, propertyDescriptor, sb, false, 4, (Object) null);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            renderTypeParameters(typeParameters, sb, true);
            renderReceiver(propertyDescriptor, sb);
        }
        renderName(propertyDescriptor, sb, true);
        sb.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        sb.append(renderType(type));
        renderReceiverAfterName(propertyDescriptor, sb);
        renderInitializer(propertyDescriptor, sb);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "getTypeParameters(...)");
        renderWhereSuffix(typeParameters2, sb);
    }

    private final void renderPropertyAnnotations(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            renderAnnotations$default(this, sb, propertyDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
            FieldDescriptor backingField = propertyDescriptor.getBackingField();
            if (backingField != null) {
                renderAnnotations(sb, backingField, AnnotationUseSiteTarget.FIELD);
            }
            FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
            if (delegateField != null) {
                renderAnnotations(sb, delegateField, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (getPropertyAccessorRenderingPolicy() == PropertyAccessorRenderingPolicy.NONE) {
                PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                if (getter != null) {
                    renderAnnotations(sb, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                if (setter != null) {
                    renderAnnotations(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                    List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt.single(valueParameters);
                    Intrinsics.checkNotNull(valueParameterDescriptor);
                    renderAnnotations(sb, valueParameterDescriptor, AnnotationUseSiteTarget.SETTER_PARAMETER);
                }
            }
        }
    }

    private final void renderInitializer(VariableDescriptor variableDescriptor, StringBuilder sb) {
        ConstantValue<?> compileTimeInitializer;
        String renderConstant;
        if (getIncludePropertyConstant() && (compileTimeInitializer = variableDescriptor.getCompileTimeInitializer()) != null && (renderConstant = renderConstant(compileTimeInitializer)) != null) {
            sb.append(" = ");
            sb.append(escape(renderConstant));
        }
    }

    /* access modifiers changed from: private */
    public final void renderTypeAlias(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
        renderAnnotations$default(this, sb, typeAliasDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
        DescriptorVisibility visibility = typeAliasDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        renderVisibility(visibility, sb);
        renderMemberModifiers(typeAliasDescriptor, sb);
        sb.append(renderKeyword("typealias"));
        sb.append(" ");
        renderName(typeAliasDescriptor, sb, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        renderTypeParameters(declaredTypeParameters, sb, false);
        renderCapturedTypeParametersIfRequired(typeAliasDescriptor, sb);
        sb.append(" = ");
        sb.append(renderType(typeAliasDescriptor.getUnderlyingType()));
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        if (getVerbose() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            renderTypeParameterList(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    /* access modifiers changed from: private */
    public final void renderClass(ClassDescriptor classDescriptor, StringBuilder sb) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        boolean z = classDescriptor.getKind() == ClassKind.ENUM_ENTRY;
        if (!getStartFromName()) {
            renderAnnotations$default(this, sb, classDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
            List<ReceiverParameterDescriptor> contextReceivers = classDescriptor.getContextReceivers();
            Intrinsics.checkNotNullExpressionValue(contextReceivers, "getContextReceivers(...)");
            renderContextReceivers(contextReceivers, sb);
            if (!z) {
                DescriptorVisibility visibility = classDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
                renderVisibility(visibility, sb);
            }
            if (!(classDescriptor.getKind() == ClassKind.INTERFACE && classDescriptor.getModality() == Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != Modality.FINAL)) {
                Modality modality = classDescriptor.getModality();
                Intrinsics.checkNotNullExpressionValue(modality, "getModality(...)");
                renderModality(modality, sb, implicitModalityWithoutExtensions(classDescriptor));
            }
            renderMemberModifiers(classDescriptor, sb);
            renderModifier(sb, getModifiers().contains(DescriptorRendererModifier.INNER) && classDescriptor.isInner(), "inner");
            renderModifier(sb, getModifiers().contains(DescriptorRendererModifier.DATA) && classDescriptor.isData(), Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
            renderModifier(sb, getModifiers().contains(DescriptorRendererModifier.INLINE) && classDescriptor.isInline(), "inline");
            renderModifier(sb, getModifiers().contains(DescriptorRendererModifier.VALUE) && classDescriptor.isValue(), "value");
            renderModifier(sb, getModifiers().contains(DescriptorRendererModifier.FUN) && classDescriptor.isFun(), "fun");
            renderClassKindPrefix(classDescriptor, sb);
        }
        DeclarationDescriptor declarationDescriptor = classDescriptor;
        if (!DescriptorUtils.isCompanionObject(declarationDescriptor)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(sb);
            }
            renderName(declarationDescriptor, sb, true);
        } else {
            renderCompanionObjectName(declarationDescriptor, sb);
        }
        if (!z) {
            List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
            renderTypeParameters(declaredTypeParameters, sb, false);
            renderCapturedTypeParametersIfRequired(classDescriptor, sb);
            if (!classDescriptor.getKind().isSingleton() && getClassWithPrimaryConstructor() && (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) != null) {
                sb.append(" ");
                renderAnnotations$default(this, sb, unsubstitutedPrimaryConstructor, (AnnotationUseSiteTarget) null, 2, (Object) null);
                DescriptorVisibility visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility2, "getVisibility(...)");
                renderVisibility(visibility2, sb);
                sb.append(renderKeyword("constructor"));
                List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                renderValueParameters(valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
            }
            renderSuperTypes(classDescriptor, sb);
            renderWhereSuffix(declaredTypeParameters, sb);
        }
    }

    private final void renderSuperTypes(ClassDescriptor classDescriptor, StringBuilder sb) {
        if (!getWithoutSuperTypes() && !KotlinBuiltIns.isNothing(classDescriptor.getDefaultType())) {
            Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            Intrinsics.checkNotNullExpressionValue(supertypes, "getSupertypes(...)");
            if (supertypes.isEmpty()) {
                return;
            }
            if (supertypes.size() != 1 || !KotlinBuiltIns.isAnyOrNullableAny(supertypes.iterator().next())) {
                renderSpaceIfNeeded(sb);
                sb.append(": ");
                CollectionsKt.joinTo$default(supertypes, sb, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new DescriptorRendererImpl$renderSuperTypes$1(this), 60, (Object) null);
            }
        }
    }

    private final void renderClassKindPrefix(ClassDescriptor classDescriptor, StringBuilder sb) {
        sb.append(renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(classDescriptor)));
    }

    /* access modifiers changed from: private */
    public final void renderPackageView(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
        renderPackageHeader(packageViewDescriptor.getFqName(), "package", sb);
        if (getDebugMode()) {
            sb.append(" in context of ");
            renderName(packageViewDescriptor.getModule(), sb, false);
        }
    }

    /* access modifiers changed from: private */
    public final void renderPackageFragment(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
        renderPackageHeader(packageFragmentDescriptor.getFqName(), "package-fragment", sb);
        if (getDebugMode()) {
            sb.append(" in ");
            renderName(packageFragmentDescriptor.getContainingDeclaration(), sb, false);
        }
    }

    private final void renderPackageHeader(FqName fqName, String str, StringBuilder sb) {
        sb.append(renderKeyword(str));
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "toUnsafe(...)");
        String renderFqName = renderFqName(unsafe);
        if (renderFqName.length() > 0) {
            sb.append(" ");
            sb.append(renderFqName);
        }
    }

    /* access modifiers changed from: private */
    public final void renderAccessorModifiers(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb) {
        renderMemberModifiers(propertyAccessorDescriptor, sb);
    }

    /* compiled from: DescriptorRendererImpl.kt */
    private final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {

        /* compiled from: DescriptorRendererImpl.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy[] r0 = kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy r1 = kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy.PRETTY     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy r1 = kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy.DEBUG     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy r1 = kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.RenderDeclarationDescriptorVisitor.WhenMappings.<clinit>():void");
            }
        }

        public RenderDeclarationDescriptorVisitor() {
        }

        public /* bridge */ /* synthetic */ Object visitClassDescriptor(ClassDescriptor classDescriptor, Object obj) {
            visitClassDescriptor(classDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, Object obj) {
            visitConstructorDescriptor(constructorDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitFunctionDescriptor(FunctionDescriptor functionDescriptor, Object obj) {
            visitFunctionDescriptor(functionDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitModuleDeclaration(ModuleDescriptor moduleDescriptor, Object obj) {
            visitModuleDeclaration(moduleDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, Object obj) {
            visitPackageFragmentDescriptor(packageFragmentDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, Object obj) {
            visitPackageViewDescriptor(packageViewDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Object obj) {
            visitPropertyDescriptor(propertyDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, Object obj) {
            visitPropertyGetterDescriptor(propertyGetterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, Object obj) {
            visitPropertySetterDescriptor(propertySetterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, Object obj) {
            visitReceiverParameterDescriptor(receiverParameterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, Object obj) {
            visitTypeAliasDescriptor(typeAliasDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, Object obj) {
            visitTypeParameterDescriptor(typeParameterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, Object obj) {
            visitValueParameterDescriptor(valueParameterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public void visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(valueParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.this.renderValueParameter(valueParameterDescriptor, true, sb, true);
        }

        public void visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.this.renderProperty(propertyDescriptor, sb);
        }

        public void visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(propertyGetterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            visitPropertyAccessorDescriptor(propertyGetterDescriptor, sb, "getter");
        }

        public void visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(propertySetterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            visitPropertyAccessorDescriptor(propertySetterDescriptor, sb, "setter");
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb, String str) {
            int i = WhenMappings.$EnumSwitchMapping$0[DescriptorRendererImpl.this.getPropertyAccessorRenderingPolicy().ordinal()];
            if (i == 1) {
                DescriptorRendererImpl.this.renderAccessorModifiers(propertyAccessorDescriptor, sb);
                sb.append(str + " for ");
                DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
                Intrinsics.checkNotNullExpressionValue(correspondingProperty, "getCorrespondingProperty(...)");
                descriptorRendererImpl.renderProperty(correspondingProperty, sb);
            } else if (i == 2) {
                visitFunctionDescriptor((FunctionDescriptor) propertyAccessorDescriptor, sb);
            }
        }

        public void visitFunctionDescriptor(FunctionDescriptor functionDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.this.renderFunction(functionDescriptor, sb);
        }

        public void visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(receiverParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            sb.append(receiverParameterDescriptor.getName());
        }

        public void visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(constructorDescriptor, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.this.renderConstructor(constructorDescriptor, sb);
        }

        public void visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.this.renderTypeParameter(typeParameterDescriptor, sb, true);
        }

        public void visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.this.renderPackageFragment(packageFragmentDescriptor, sb);
        }

        public void visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(packageViewDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.this.renderPackageView(packageViewDescriptor, sb);
        }

        public void visitModuleDeclaration(ModuleDescriptor moduleDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.this.renderName(moduleDescriptor, sb, true);
        }

        public void visitClassDescriptor(ClassDescriptor classDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.this.renderClass(classDescriptor, sb);
        }

        public void visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.this.renderTypeAlias(typeAliasDescriptor, sb);
        }
    }

    private final void renderSpaceIfNeeded(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    private final boolean overridesSomething(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.getOverriddenDescriptors().isEmpty();
    }
}
