package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.BackEventCompat;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\b\u001f !\"#$%&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003J\u001e\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J2\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002J$\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0016\u0010\u001a\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002J&\u0010\u001b\u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0002¨\u0006'"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController;", "Landroidx/fragment/app/SpecialEffectsController;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "collectAnimEffects", "", "animationInfos", "", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "collectEffects", "operations", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "isPop", "", "createTransitionEffect", "transitionInfos", "Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "firstOut", "lastIn", "findNamedViews", "namedViews", "", "", "Landroid/view/View;", "view", "syncAnimations", "retainMatchingViews", "Landroidx/collection/ArrayMap;", "names", "", "AnimationEffect", "AnimationInfo", "AnimatorEffect", "Api24Impl", "Api26Impl", "SpecialEffectsInfo", "TransitionEffect", "TransitionInfo", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultSpecialEffectsController.kt */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
    }

    public void collectEffects(List<? extends SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation;
        Object obj;
        Intrinsics.checkNotNullParameter(list, "operations");
        Iterator it = list.iterator();
        while (true) {
            operation = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            SpecialEffectsController.Operation operation2 = (SpecialEffectsController.Operation) obj;
            SpecialEffectsController.Operation.State.Companion companion = SpecialEffectsController.Operation.State.Companion;
            View view = operation2.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
            if (companion.asOperationState(view) == SpecialEffectsController.Operation.State.VISIBLE && operation2.getFinalState() != SpecialEffectsController.Operation.State.VISIBLE) {
                break;
            }
        }
        SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) obj;
        ListIterator<? extends SpecialEffectsController.Operation> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object previous = listIterator.previous();
            SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) previous;
            SpecialEffectsController.Operation.State.Companion companion2 = SpecialEffectsController.Operation.State.Companion;
            View view2 = operation4.getFragment().mView;
            Intrinsics.checkNotNullExpressionValue(view2, "operation.fragment.mView");
            if (companion2.asOperationState(view2) != SpecialEffectsController.Operation.State.VISIBLE && operation4.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                operation = previous;
                break;
            }
        }
        SpecialEffectsController.Operation operation5 = operation;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Executing operations from " + operation3 + " to " + operation5);
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        syncAnimations(list);
        for (SpecialEffectsController.Operation operation6 : list) {
            arrayList.add(new AnimationInfo(operation6, z));
            boolean z2 = true;
            if (z) {
                if (operation6 == operation3) {
                    arrayList2.add(new TransitionInfo(operation6, z, z2));
                    operation6.addCompletionListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda0(this, operation6));
                }
            } else if (operation6 == operation5) {
                arrayList2.add(new TransitionInfo(operation6, z, z2));
                operation6.addCompletionListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda0(this, operation6));
            }
            z2 = false;
            arrayList2.add(new TransitionInfo(operation6, z, z2));
            operation6.addCompletionListener(new DefaultSpecialEffectsController$$ExternalSyntheticLambda0(this, operation6));
        }
        createTransitionEffect(arrayList2, z, operation3, operation5);
        collectAnimEffects(arrayList);
    }

    /* access modifiers changed from: private */
    public static final void collectEffects$lambda$2(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController.Operation operation) {
        Intrinsics.checkNotNullParameter(defaultSpecialEffectsController, "this$0");
        Intrinsics.checkNotNullParameter(operation, "$operation");
        defaultSpecialEffectsController.applyContainerChangesToOperation$fragment_release(operation);
    }

    private final void syncAnimations(List<? extends SpecialEffectsController.Operation> list) {
        Fragment fragment = ((SpecialEffectsController.Operation) CollectionsKt.last(list)).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    private final void collectAnimEffects(List<AnimationInfo> list) {
        List<AnimationInfo> arrayList = new ArrayList<>();
        Collection arrayList2 = new ArrayList();
        for (AnimationInfo operation : list) {
            CollectionsKt.addAll(arrayList2, operation.getOperation().getEffects$fragment_release());
        }
        boolean z = !((List) arrayList2).isEmpty();
        boolean z2 = false;
        for (AnimationInfo next : list) {
            Context context = getContainer().getContext();
            SpecialEffectsController.Operation operation2 = next.getOperation();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context);
            if (animation != null) {
                if (animation.animator == null) {
                    arrayList.add(next);
                } else {
                    Fragment fragment = operation2.getFragment();
                    if (!(!operation2.getEffects$fragment_release().isEmpty())) {
                        if (operation2.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation2.setAwaitingContainerChanges(false);
                        }
                        operation2.addEffect(new AnimatorEffect(next));
                        z2 = true;
                    } else if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                    }
                }
            }
        }
        for (AnimationInfo animationInfo : arrayList) {
            SpecialEffectsController.Operation operation3 = animationInfo.getOperation();
            Fragment fragment2 = operation3.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
            } else if (!z2) {
                operation3.addEffect(new AnimationEffect(animationInfo));
            } else if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
            }
        }
    }

    private final void createTransitionEffect(List<TransitionInfo> list, boolean z, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        Object obj;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterable iterable;
        List list2;
        FragmentTransitionImpl fragmentTransitionImpl;
        Iterator it;
        Pair pair;
        Object obj2;
        String findKeyForValue;
        SpecialEffectsController.Operation operation3 = operation;
        SpecialEffectsController.Operation operation4 = operation2;
        Collection arrayList3 = new ArrayList();
        for (Object next : list) {
            if (!((TransitionInfo) next).isVisibilityUnchanged()) {
                arrayList3.add(next);
            }
        }
        Collection arrayList4 = new ArrayList();
        for (Object next2 : (List) arrayList3) {
            if (((TransitionInfo) next2).getHandlingImpl() != null) {
                arrayList4.add(next2);
            }
        }
        List list3 = (List) arrayList4;
        Iterable<TransitionInfo> iterable2 = list3;
        FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : iterable2) {
            FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
            if (fragmentTransitionImpl2 == null || handlingImpl == fragmentTransitionImpl2) {
                fragmentTransitionImpl2 = handlingImpl;
            } else {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition type than other Fragments.").toString());
            }
        }
        if (fragmentTransitionImpl2 != null) {
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayMap arrayMap = new ArrayMap();
            ArrayList<String> arrayList7 = new ArrayList<>();
            ArrayList<String> arrayList8 = new ArrayList<>();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayMap arrayMap3 = new ArrayMap();
            Iterator it2 = list3.iterator();
            ArrayList<String> arrayList9 = arrayList7;
            ArrayList<String> arrayList10 = arrayList8;
            loop3:
            while (true) {
                obj = null;
                while (it2.hasNext()) {
                    TransitionInfo transitionInfo2 = (TransitionInfo) it2.next();
                    if (!transitionInfo2.hasSharedElementTransition() || operation3 == null || operation4 == null) {
                        list2 = list3;
                        fragmentTransitionImpl = fragmentTransitionImpl2;
                        arrayList = arrayList5;
                        arrayList2 = arrayList6;
                        it = it2;
                        iterable = iterable2;
                    } else {
                        Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(transitionInfo2.getSharedElementTransition()));
                        ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                        Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                        ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                        Intrinsics.checkNotNullExpressionValue(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                        ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                        it = it2;
                        Intrinsics.checkNotNullExpressionValue(sharedElementTargetNames, "firstOut.fragment.sharedElementTargetNames");
                        int size = sharedElementTargetNames.size();
                        list2 = list3;
                        fragmentTransitionImpl = fragmentTransitionImpl2;
                        int i = 0;
                        while (i < size) {
                            int i2 = size;
                            int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i));
                            if (indexOf != -1) {
                                sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i));
                            }
                            i++;
                            size = i2;
                        }
                        arrayList9 = operation2.getFragment().getSharedElementTargetNames();
                        Intrinsics.checkNotNullExpressionValue(arrayList9, "lastIn.fragment.sharedElementTargetNames");
                        if (!z) {
                            pair = TuplesKt.to(operation.getFragment().getExitTransitionCallback(), operation2.getFragment().getEnterTransitionCallback());
                        } else {
                            pair = TuplesKt.to(operation.getFragment().getEnterTransitionCallback(), operation2.getFragment().getExitTransitionCallback());
                        }
                        SharedElementCallback sharedElementCallback = (SharedElementCallback) pair.component1();
                        SharedElementCallback sharedElementCallback2 = (SharedElementCallback) pair.component2();
                        int size2 = sharedElementSourceNames.size();
                        iterable = iterable2;
                        int i3 = 0;
                        while (true) {
                            arrayList2 = arrayList6;
                            if (i3 >= size2) {
                                break;
                            }
                            int i4 = size2;
                            String str = sharedElementSourceNames.get(i3);
                            Intrinsics.checkNotNullExpressionValue(str, "exitingNames[i]");
                            String str2 = arrayList9.get(i3);
                            Intrinsics.checkNotNullExpressionValue(str2, "enteringNames[i]");
                            arrayMap.put(str, str2);
                            i3++;
                            size2 = i4;
                            arrayList6 = arrayList2;
                        }
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, ">>> entering view names <<<");
                            Iterator<String> it3 = arrayList9.iterator();
                            while (true) {
                                arrayList = arrayList5;
                                if (!it3.hasNext()) {
                                    break;
                                }
                                Log.v(FragmentManager.TAG, "Name: " + it3.next());
                                wrapTransitionInSet = wrapTransitionInSet;
                                arrayList5 = arrayList;
                                it3 = it3;
                            }
                            obj2 = wrapTransitionInSet;
                            Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
                            for (Iterator<String> it4 = sharedElementSourceNames.iterator(); it4.hasNext(); it4 = it4) {
                                Log.v(FragmentManager.TAG, "Name: " + it4.next());
                            }
                        } else {
                            arrayList = arrayList5;
                            obj2 = wrapTransitionInSet;
                        }
                        Map map = arrayMap2;
                        View view = operation.getFragment().mView;
                        Intrinsics.checkNotNullExpressionValue(view, "firstOut.fragment.mView");
                        findNamedViews(map, view);
                        arrayMap2.retainAll(sharedElementSourceNames);
                        if (sharedElementCallback != null) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Executing exit callback for operation " + operation3);
                            }
                            sharedElementCallback.onMapSharedElements(sharedElementSourceNames, map);
                            int size3 = sharedElementSourceNames.size() - 1;
                            if (size3 >= 0) {
                                while (true) {
                                    int i5 = size3 - 1;
                                    String str3 = sharedElementSourceNames.get(size3);
                                    Intrinsics.checkNotNullExpressionValue(str3, "exitingNames[i]");
                                    String str4 = str3;
                                    View view2 = (View) arrayMap2.get(str4);
                                    if (view2 == null) {
                                        arrayMap.remove(str4);
                                    } else if (!Intrinsics.areEqual((Object) str4, (Object) ViewCompat.getTransitionName(view2))) {
                                        arrayMap.put(ViewCompat.getTransitionName(view2), (String) arrayMap.remove(str4));
                                    }
                                    if (i5 < 0) {
                                        break;
                                    }
                                    size3 = i5;
                                }
                            }
                        } else {
                            arrayMap.retainAll(arrayMap2.keySet());
                        }
                        Map map2 = arrayMap3;
                        View view3 = operation2.getFragment().mView;
                        Intrinsics.checkNotNullExpressionValue(view3, "lastIn.fragment.mView");
                        findNamedViews(map2, view3);
                        arrayMap3.retainAll(arrayList9);
                        arrayMap3.retainAll(arrayMap.values());
                        if (sharedElementCallback2 != null) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Executing enter callback for operation " + operation4);
                            }
                            sharedElementCallback2.onMapSharedElements(arrayList9, map2);
                            int size4 = arrayList9.size() - 1;
                            if (size4 >= 0) {
                                while (true) {
                                    int i6 = size4 - 1;
                                    String str5 = arrayList9.get(size4);
                                    Intrinsics.checkNotNullExpressionValue(str5, "enteringNames[i]");
                                    String str6 = str5;
                                    View view4 = (View) arrayMap3.get(str6);
                                    if (view4 == null) {
                                        String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap, str6);
                                        if (findKeyForValue2 != null) {
                                            arrayMap.remove(findKeyForValue2);
                                        }
                                    } else if (!Intrinsics.areEqual((Object) str6, (Object) ViewCompat.getTransitionName(view4)) && (findKeyForValue = FragmentTransition.findKeyForValue(arrayMap, str6)) != null) {
                                        arrayMap.put(findKeyForValue, ViewCompat.getTransitionName(view4));
                                    }
                                    if (i6 < 0) {
                                        break;
                                    }
                                    size4 = i6;
                                }
                            }
                        } else {
                            FragmentTransition.retainValues(arrayMap, arrayMap3);
                        }
                        Set keySet = arrayMap.keySet();
                        Intrinsics.checkNotNullExpressionValue(keySet, "sharedElementNameMapping.keys");
                        retainMatchingViews(arrayMap2, keySet);
                        Collection values = arrayMap.values();
                        Intrinsics.checkNotNullExpressionValue(values, "sharedElementNameMapping.values");
                        retainMatchingViews(arrayMap3, values);
                        if (arrayMap.isEmpty()) {
                            Log.i(FragmentManager.TAG, "Ignoring shared elements transition " + obj2 + " between " + operation3 + " and " + operation4 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
                            arrayList.clear();
                            arrayList2.clear();
                            arrayList10 = sharedElementSourceNames;
                            it2 = it;
                            fragmentTransitionImpl2 = fragmentTransitionImpl;
                            list3 = list2;
                            iterable2 = iterable;
                            arrayList6 = arrayList2;
                            arrayList5 = arrayList;
                        } else {
                            arrayList10 = sharedElementSourceNames;
                            obj = obj2;
                        }
                    }
                    it2 = it;
                    fragmentTransitionImpl2 = fragmentTransitionImpl;
                    list3 = list2;
                    iterable2 = iterable;
                    arrayList6 = arrayList2;
                    arrayList5 = arrayList;
                }
                break loop3;
            }
            List list4 = list3;
            FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
            ArrayList arrayList11 = arrayList5;
            ArrayList arrayList12 = arrayList6;
            Iterable iterable3 = iterable2;
            if (obj != null) {
                TransitionEffect transitionEffect = new TransitionEffect(list4, operation, operation2, fragmentTransitionImpl3, obj, arrayList11, arrayList12, arrayMap, arrayList9, arrayList10, arrayMap2, arrayMap3, z);
            } else if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                for (TransitionInfo transition : iterable2) {
                    if (transition.getTransition() != null) {
                    }
                }
                return;
            } else {
                return;
            }
            TransitionEffect transitionEffect2 = new TransitionEffect(list4, operation, operation2, fragmentTransitionImpl3, obj, arrayList11, arrayList12, arrayMap, arrayList9, arrayList10, arrayMap2, arrayMap3, z);
            for (TransitionInfo operation5 : iterable2) {
                operation5.getOperation().addEffect(transitionEffect2);
            }
        }
    }

    private final void retainMatchingViews(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Set<Map.Entry<String, View>> entrySet = arrayMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, RemoteConfigConstants.ResponseFieldKey.ENTRIES);
        CollectionsKt.retainAll(entrySet, new DefaultSpecialEffectsController$retainMatchingViews$1(collection));
    }

    private final void findNamedViews(Map<String, View> map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "child");
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "(Landroidx/fragment/app/SpecialEffectsController$Operation;)V", "isVisibilityUnchanged", "", "()Z", "getOperation", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    public static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation operation;

        public SpecialEffectsInfo(SpecialEffectsController.Operation operation2) {
            Intrinsics.checkNotNullParameter(operation2, "operation");
            this.operation = operation2;
        }

        public final SpecialEffectsController.Operation getOperation() {
            return this.operation;
        }

        public final boolean isVisibilityUnchanged() {
            View view = this.operation.getFragment().mView;
            SpecialEffectsController.Operation.State asOperationState = view != null ? SpecialEffectsController.Operation.State.Companion.asOperationState(view) : null;
            SpecialEffectsController.Operation.State finalState = this.operation.getFinalState();
            return asOperationState == finalState || !(asOperationState == SpecialEffectsController.Operation.State.VISIBLE || finalState == SpecialEffectsController.Operation.State.VISIBLE);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "isPop", "", "(Landroidx/fragment/app/SpecialEffectsController$Operation;Z)V", "animation", "Landroidx/fragment/app/FragmentAnim$AnimationOrAnimator;", "isAnimLoaded", "getAnimation", "context", "Landroid/content/Context;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    private static final class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator animation;
        private boolean isAnimLoaded;
        private final boolean isPop;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnimationInfo(SpecialEffectsController.Operation operation, boolean z) {
            super(operation);
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.isPop = z;
        }

        public final FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.isAnimLoaded) {
                return this.animation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.isPop);
            this.animation = loadAnimation;
            this.isAnimLoaded = true;
            return loadAnimation;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0006\u0010\u0014\u001a\u00020\u0005R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;", "operation", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "isPop", "", "providesSharedElementTransition", "(Landroidx/fragment/app/SpecialEffectsController$Operation;ZZ)V", "handlingImpl", "Landroidx/fragment/app/FragmentTransitionImpl;", "getHandlingImpl", "()Landroidx/fragment/app/FragmentTransitionImpl;", "isOverlapAllowed", "()Z", "sharedElementTransition", "", "getSharedElementTransition", "()Ljava/lang/Object;", "transition", "getTransition", "hasSharedElementTransition", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    private static final class TransitionInfo extends SpecialEffectsInfo {
        private final boolean isOverlapAllowed;
        private final Object sharedElementTransition;
        private final Object transition;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransitionInfo(SpecialEffectsController.Operation operation, boolean z, boolean z2) {
            super(operation);
            Object obj;
            boolean z3;
            Object obj2;
            Intrinsics.checkNotNullParameter(operation, "operation");
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                Fragment fragment = operation.getFragment();
                obj = z ? fragment.getReenterTransition() : fragment.getEnterTransition();
            } else {
                Fragment fragment2 = operation.getFragment();
                obj = z ? fragment2.getReturnTransition() : fragment2.getExitTransition();
            }
            this.transition = obj;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                z3 = z ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                z3 = true;
            }
            this.isOverlapAllowed = z3;
            if (z2) {
                obj2 = z ? operation.getFragment().getSharedElementReturnTransition() : operation.getFragment().getSharedElementEnterTransition();
            } else {
                obj2 = null;
            }
            this.sharedElementTransition = obj2;
        }

        public final Object getTransition() {
            return this.transition;
        }

        public final boolean isOverlapAllowed() {
            return this.isOverlapAllowed;
        }

        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        public final boolean hasSharedElementTransition() {
            return this.sharedElementTransition != null;
        }

        public final FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.transition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.sharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl == null ? handlingImpl2 : handlingImpl;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.transition + " which uses a different Transition  type than its shared element transition " + this.sharedElementTransition).toString());
        }

        private final FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            if (FragmentTransition.PLATFORM_IMPL != null && FragmentTransition.PLATFORM_IMPL.canHandle(obj)) {
                return FragmentTransition.PLATFORM_IMPL;
            }
            if (FragmentTransition.SUPPORT_IMPL != null && FragmentTransition.SUPPORT_IMPL.canHandle(obj)) {
                return FragmentTransition.SUPPORT_IMPL;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationEffect;", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "animationInfo", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "(Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;)V", "getAnimationInfo", "()Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "onCancel", "", "container", "Landroid/view/ViewGroup;", "onCommit", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    private static final class AnimationEffect extends SpecialEffectsController.Effect {
        private final AnimationInfo animationInfo;

        public AnimationEffect(AnimationInfo animationInfo2) {
            Intrinsics.checkNotNullParameter(animationInfo2, "animationInfo");
            this.animationInfo = animationInfo2;
        }

        public final AnimationInfo getAnimationInfo() {
            return this.animationInfo;
        }

        public void onCommit(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (this.animationInfo.isVisibilityUnchanged()) {
                this.animationInfo.getOperation().completeEffect(this);
                return;
            }
            Context context = viewGroup.getContext();
            SpecialEffectsController.Operation operation = this.animationInfo.getOperation();
            View view = operation.getFragment().mView;
            AnimationInfo animationInfo2 = this.animationInfo;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator animation = animationInfo2.getAnimation(context);
            if (animation != null) {
                Animation animation2 = animation.animation;
                if (animation2 == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                } else if (operation.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view.startAnimation(animation2);
                    this.animationInfo.getOperation().completeEffect(this);
                } else {
                    viewGroup.startViewTransition(view);
                    Animation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, viewGroup, view);
                    endViewTransitionAnimation.setAnimationListener(new DefaultSpecialEffectsController$AnimationEffect$onCommit$1(operation, viewGroup, view, this));
                    view.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has started.");
                    }
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }

        public void onCancel(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            SpecialEffectsController.Operation operation = this.animationInfo.getOperation();
            View view = operation.getFragment().mView;
            view.clearAnimation();
            viewGroup.endViewTransition(view);
            this.animationInfo.getOperation().completeEffect(this);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has been cancelled.");
            }
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006\u0019"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$AnimatorEffect;", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "animatorInfo", "Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "(Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;)V", "animator", "Landroid/animation/AnimatorSet;", "getAnimator", "()Landroid/animation/AnimatorSet;", "setAnimator", "(Landroid/animation/AnimatorSet;)V", "getAnimatorInfo", "()Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;", "isSeekingSupported", "", "()Z", "onCancel", "", "container", "Landroid/view/ViewGroup;", "onCommit", "onProgress", "backEvent", "Landroidx/activity/BackEventCompat;", "onStart", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    private static final class AnimatorEffect extends SpecialEffectsController.Effect {
        private AnimatorSet animator;
        private final AnimationInfo animatorInfo;

        public boolean isSeekingSupported() {
            return true;
        }

        public AnimatorEffect(AnimationInfo animationInfo) {
            Intrinsics.checkNotNullParameter(animationInfo, "animatorInfo");
            this.animatorInfo = animationInfo;
        }

        public final AnimationInfo getAnimatorInfo() {
            return this.animatorInfo;
        }

        public final AnimatorSet getAnimator() {
            return this.animator;
        }

        public final void setAnimator(AnimatorSet animatorSet) {
            this.animator = animatorSet;
        }

        public void onStart(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!this.animatorInfo.isVisibilityUnchanged()) {
                Context context = viewGroup.getContext();
                AnimationInfo animationInfo = this.animatorInfo;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                this.animator = animation != null ? animation.animator : null;
                SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
                Fragment fragment = operation.getFragment();
                boolean z = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                View view = fragment.mView;
                viewGroup.startViewTransition(view);
                AnimatorSet animatorSet = this.animator;
                if (animatorSet != null) {
                    animatorSet.addListener(new DefaultSpecialEffectsController$AnimatorEffect$onStart$1(viewGroup, view, z, operation, this));
                }
                AnimatorSet animatorSet2 = this.animator;
                if (animatorSet2 != null) {
                    animatorSet2.setTarget(view);
                }
            }
        }

        public void onProgress(BackEventCompat backEventCompat, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(backEventCompat, "backEvent");
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
            } else if (Build.VERSION.SDK_INT >= 34 && operation.getFragment().mTransitioning) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Adding BackProgressCallbacks for Animators to operation " + operation);
                }
                long j = Api24Impl.INSTANCE.totalDuration(animatorSet);
                long progress = (long) (backEventCompat.getProgress() * ((float) j));
                if (progress == 0) {
                    progress = 1;
                }
                if (progress == j) {
                    progress = j - 1;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Setting currentPlayTime to " + progress + " for Animator " + animatorSet + " on operation " + operation);
                }
                Api26Impl.INSTANCE.setCurrentPlayTime(animatorSet, progress);
            }
        }

        public void onCommit(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
                return;
            }
            animatorSet.start();
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has started.");
            }
        }

        public void onCancel(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            AnimatorSet animatorSet = this.animator;
            if (animatorSet == null) {
                this.animatorInfo.getOperation().completeEffect(this);
                return;
            }
            SpecialEffectsController.Operation operation = this.animatorInfo.getOperation();
            if (!operation.isSeeking()) {
                animatorSet.end();
            } else if (Build.VERSION.SDK_INT >= 26) {
                Api26Impl.INSTANCE.reverse(animatorSet);
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder("Animator from operation ");
                sb.append(operation);
                sb.append(" has been canceled");
                sb.append(operation.isSeeking() ? " with seeking." : InstructionFileId.DOT);
                sb.append(' ');
                Log.v(FragmentManager.TAG, sb.toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BÝ\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\rj\b\u0012\u0004\u0012\u00020\u0013`\u000f\u0012\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\rj\b\u0012\u0004\u0012\u00020\u0013`\u000f\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ(\u0010;\u001a\u00020<2\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010>\u001a\u00020\u000eH\u0002J@\u0010?\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0004\u0012\u00020\u000b0@2\u0006\u0010A\u001a\u00020B2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010C\u001a\u00020<2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010D\u001a\u00020<2\u0006\u0010A\u001a\u00020BH\u0016J\u0018\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020G2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010H\u001a\u00020<2\u0006\u0010A\u001a\u00020BH\u0016J6\u0010I\u001a\u00020<2\u0016\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010A\u001a\u00020B2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020<0LH\u0002R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR!\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\rj\b\u0012\u0004\u0012\u00020\u0013`\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R!\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\rj\b\u0012\u0004\u0012\u00020\u0013`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010'R\u0014\u0010(\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0017\u00103\u001a\u000204¢\u0006\u000e\n\u0000\u0012\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0011\u00109\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b:\u0010'¨\u0006M"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect;", "Landroidx/fragment/app/SpecialEffectsController$Effect;", "transitionInfos", "", "Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionInfo;", "firstOut", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "lastIn", "transitionImpl", "Landroidx/fragment/app/FragmentTransitionImpl;", "sharedElementTransition", "", "sharedElementFirstOutViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "sharedElementLastInViews", "sharedElementNameMapping", "Landroidx/collection/ArrayMap;", "", "enteringNames", "exitingNames", "firstOutViews", "lastInViews", "isPop", "", "(Ljava/util/List;Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/SpecialEffectsController$Operation;Landroidx/fragment/app/FragmentTransitionImpl;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/collection/ArrayMap;Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;Z)V", "controller", "getController", "()Ljava/lang/Object;", "setController", "(Ljava/lang/Object;)V", "getEnteringNames", "()Ljava/util/ArrayList;", "getExitingNames", "getFirstOut", "()Landroidx/fragment/app/SpecialEffectsController$Operation;", "getFirstOutViews", "()Landroidx/collection/ArrayMap;", "()Z", "isSeekingSupported", "getLastIn", "getLastInViews", "getSharedElementFirstOutViews", "getSharedElementLastInViews", "getSharedElementNameMapping", "getSharedElementTransition", "getTransitionImpl", "()Landroidx/fragment/app/FragmentTransitionImpl;", "getTransitionInfos", "()Ljava/util/List;", "transitionSignal", "Landroidx/core/os/CancellationSignal;", "getTransitionSignal$annotations", "()V", "getTransitionSignal", "()Landroidx/core/os/CancellationSignal;", "transitioning", "getTransitioning", "captureTransitioningViews", "", "transitioningViews", "view", "createMergedTransition", "Lkotlin/Pair;", "container", "Landroid/view/ViewGroup;", "onCancel", "onCommit", "onProgress", "backEvent", "Landroidx/activity/BackEventCompat;", "onStart", "runTransition", "enteringViews", "executeTransition", "Lkotlin/Function0;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    private static final class TransitionEffect extends SpecialEffectsController.Effect {
        private Object controller;
        private final ArrayList<String> enteringNames;
        private final ArrayList<String> exitingNames;
        private final SpecialEffectsController.Operation firstOut;
        private final ArrayMap<String, View> firstOutViews;
        private final boolean isPop;
        private final SpecialEffectsController.Operation lastIn;
        private final ArrayMap<String, View> lastInViews;
        private final ArrayList<View> sharedElementFirstOutViews;
        private final ArrayList<View> sharedElementLastInViews;
        private final ArrayMap<String, String> sharedElementNameMapping;
        private final Object sharedElementTransition;
        private final FragmentTransitionImpl transitionImpl;
        private final List<TransitionInfo> transitionInfos;
        private final CancellationSignal transitionSignal = new CancellationSignal();

        public static /* synthetic */ void getTransitionSignal$annotations() {
        }

        public final List<TransitionInfo> getTransitionInfos() {
            return this.transitionInfos;
        }

        public final SpecialEffectsController.Operation getFirstOut() {
            return this.firstOut;
        }

        public final SpecialEffectsController.Operation getLastIn() {
            return this.lastIn;
        }

        public final FragmentTransitionImpl getTransitionImpl() {
            return this.transitionImpl;
        }

        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        public final ArrayList<View> getSharedElementFirstOutViews() {
            return this.sharedElementFirstOutViews;
        }

        public final ArrayList<View> getSharedElementLastInViews() {
            return this.sharedElementLastInViews;
        }

        public final ArrayMap<String, String> getSharedElementNameMapping() {
            return this.sharedElementNameMapping;
        }

        public final ArrayList<String> getEnteringNames() {
            return this.enteringNames;
        }

        public final ArrayList<String> getExitingNames() {
            return this.exitingNames;
        }

        public final ArrayMap<String, View> getFirstOutViews() {
            return this.firstOutViews;
        }

        public final ArrayMap<String, View> getLastInViews() {
            return this.lastInViews;
        }

        public final boolean isPop() {
            return this.isPop;
        }

        public TransitionEffect(List<TransitionInfo> list, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, FragmentTransitionImpl fragmentTransitionImpl, Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayMap<String, String> arrayMap, ArrayList<String> arrayList3, ArrayList<String> arrayList4, ArrayMap<String, View> arrayMap2, ArrayMap<String, View> arrayMap3, boolean z) {
            Intrinsics.checkNotNullParameter(list, "transitionInfos");
            Intrinsics.checkNotNullParameter(fragmentTransitionImpl, "transitionImpl");
            Intrinsics.checkNotNullParameter(arrayList, "sharedElementFirstOutViews");
            Intrinsics.checkNotNullParameter(arrayList2, "sharedElementLastInViews");
            Intrinsics.checkNotNullParameter(arrayMap, "sharedElementNameMapping");
            Intrinsics.checkNotNullParameter(arrayList3, "enteringNames");
            Intrinsics.checkNotNullParameter(arrayList4, "exitingNames");
            Intrinsics.checkNotNullParameter(arrayMap2, "firstOutViews");
            Intrinsics.checkNotNullParameter(arrayMap3, "lastInViews");
            this.transitionInfos = list;
            this.firstOut = operation;
            this.lastIn = operation2;
            this.transitionImpl = fragmentTransitionImpl;
            this.sharedElementTransition = obj;
            this.sharedElementFirstOutViews = arrayList;
            this.sharedElementLastInViews = arrayList2;
            this.sharedElementNameMapping = arrayMap;
            this.enteringNames = arrayList3;
            this.exitingNames = arrayList4;
            this.firstOutViews = arrayMap2;
            this.lastInViews = arrayMap3;
            this.isPop = z;
        }

        public final CancellationSignal getTransitionSignal() {
            return this.transitionSignal;
        }

        public final Object getController() {
            return this.controller;
        }

        public final void setController(Object obj) {
            this.controller = obj;
        }

        public boolean isSeekingSupported() {
            if (this.transitionImpl.isSeekingSupported()) {
                Iterable iterable = this.transitionInfos;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TransitionInfo transitionInfo = (TransitionInfo) it.next();
                        if (Build.VERSION.SDK_INT >= 34) {
                            if (transitionInfo.getTransition() != null) {
                                if (!this.transitionImpl.isSeekingSupported(transitionInfo.getTransition())) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                Object obj = this.sharedElementTransition;
                if (obj == null || this.transitionImpl.isSeekingSupported(obj)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean getTransitioning() {
            Iterable<TransitionInfo> iterable = this.transitionInfos;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                return true;
            }
            for (TransitionInfo operation : iterable) {
                if (!operation.getOperation().getFragment().mTransitioning) {
                    return false;
                }
            }
            return true;
        }

        public void onStart(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!viewGroup.isLaidOut()) {
                for (TransitionInfo operation : this.transitionInfos) {
                    SpecialEffectsController.Operation operation2 = operation.getOperation();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Skipping onStart for operation " + operation2);
                    }
                }
                return;
            }
            if (getTransitioning() && this.sharedElementTransition != null && !isSeekingSupported()) {
                Log.i(FragmentManager.TAG, "Ignoring shared elements transition " + this.sharedElementTransition + " between " + this.firstOut + " and " + this.lastIn + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (isSeekingSupported() && getTransitioning()) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Pair<ArrayList<View>, Object> createMergedTransition = createMergedTransition(viewGroup, this.lastIn, this.firstOut);
                ArrayList component1 = createMergedTransition.component1();
                Object component2 = createMergedTransition.component2();
                Iterable<TransitionInfo> iterable = this.transitionInfos;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (TransitionInfo operation3 : iterable) {
                    arrayList.add(operation3.getOperation());
                }
                for (SpecialEffectsController.Operation operation4 : (List) arrayList) {
                    DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda3 defaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda3 = new DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda3(objectRef);
                    this.transitionImpl.setListenerForTransitionEnd(operation4.getFragment(), component2, this.transitionSignal, defaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda3, new DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4(operation4, this));
                }
                runTransition(component1, viewGroup, new DefaultSpecialEffectsController$TransitionEffect$onStart$4(this, viewGroup, component2, objectRef));
            }
        }

        /* access modifiers changed from: private */
        public static final void onStart$lambda$6$lambda$4(Ref.ObjectRef objectRef) {
            Intrinsics.checkNotNullParameter(objectRef, "$seekCancelLambda");
            Function0 function0 = (Function0) objectRef.element;
            if (function0 != null) {
                function0.invoke();
            }
        }

        /* access modifiers changed from: private */
        public static final void onStart$lambda$6$lambda$5(SpecialEffectsController.Operation operation, TransitionEffect transitionEffect) {
            Intrinsics.checkNotNullParameter(operation, "$operation");
            Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Transition for operation " + operation + " has completed");
            }
            operation.completeEffect(transitionEffect);
        }

        public void onProgress(BackEventCompat backEventCompat, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(backEventCompat, "backEvent");
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Object obj = this.controller;
            if (obj != null) {
                this.transitionImpl.setCurrentPlayTime(obj, backEventCompat.getProgress());
            }
        }

        public void onCommit(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            if (!viewGroup.isLaidOut()) {
                for (TransitionInfo transitionInfo : this.transitionInfos) {
                    SpecialEffectsController.Operation operation = transitionInfo.getOperation();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Completing operation " + operation);
                    }
                    transitionInfo.getOperation().completeEffect(this);
                }
                return;
            }
            Object obj = this.controller;
            if (obj != null) {
                FragmentTransitionImpl fragmentTransitionImpl = this.transitionImpl;
                Intrinsics.checkNotNull(obj);
                fragmentTransitionImpl.animateToEnd(obj);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ending execution of operations from " + this.firstOut + " to " + this.lastIn);
                    return;
                }
                return;
            }
            Pair<ArrayList<View>, Object> createMergedTransition = createMergedTransition(viewGroup, this.lastIn, this.firstOut);
            ArrayList component1 = createMergedTransition.component1();
            Object component2 = createMergedTransition.component2();
            Iterable<TransitionInfo> iterable = this.transitionInfos;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (TransitionInfo operation2 : iterable) {
                arrayList.add(operation2.getOperation());
            }
            for (SpecialEffectsController.Operation operation3 : (List) arrayList) {
                this.transitionImpl.setListenerForTransitionEnd(operation3.getFragment(), component2, this.transitionSignal, new DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda5(operation3, this));
            }
            runTransition(component1, viewGroup, new DefaultSpecialEffectsController$TransitionEffect$onCommit$4(this, viewGroup, component2));
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Completed executing operations from " + this.firstOut + " to " + this.lastIn);
            }
        }

        /* access modifiers changed from: private */
        public static final void onCommit$lambda$11$lambda$10(SpecialEffectsController.Operation operation, TransitionEffect transitionEffect) {
            Intrinsics.checkNotNullParameter(operation, "$operation");
            Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Transition for operation " + operation + " has completed");
            }
            operation.completeEffect(transitionEffect);
        }

        private final Pair<ArrayList<View>, Object> createMergedTransition(ViewGroup viewGroup, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
            Iterator<TransitionInfo> it;
            SpecialEffectsController.Operation operation3 = operation;
            SpecialEffectsController.Operation operation4 = operation2;
            View view = new View(viewGroup.getContext());
            Rect rect = new Rect();
            boolean z = false;
            View view2 = null;
            for (TransitionInfo hasSharedElementTransition : this.transitionInfos) {
                if (!(!hasSharedElementTransition.hasSharedElementTransition() || operation4 == null || operation3 == null || !(!this.sharedElementNameMapping.isEmpty()) || this.sharedElementTransition == null)) {
                    FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), this.isPop, this.firstOutViews, true);
                    View view3 = viewGroup;
                    OneShotPreDrawListener.add(view3, new DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda0(operation3, operation4, this));
                    this.sharedElementFirstOutViews.addAll(this.firstOutViews.values());
                    if (!this.exitingNames.isEmpty()) {
                        String str = this.exitingNames.get(0);
                        Intrinsics.checkNotNullExpressionValue(str, "exitingNames[0]");
                        view2 = this.firstOutViews.get(str);
                        this.transitionImpl.setEpicenter(this.sharedElementTransition, view2);
                    }
                    this.sharedElementLastInViews.addAll(this.lastInViews.values());
                    if (!this.enteringNames.isEmpty()) {
                        String str2 = this.enteringNames.get(0);
                        Intrinsics.checkNotNullExpressionValue(str2, "enteringNames[0]");
                        View view4 = this.lastInViews.get(str2);
                        if (view4 != null) {
                            OneShotPreDrawListener.add(view3, new DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda1(this.transitionImpl, view4, rect));
                            z = true;
                        }
                    }
                    this.transitionImpl.setSharedElementTargets(this.sharedElementTransition, view, this.sharedElementFirstOutViews);
                    FragmentTransitionImpl fragmentTransitionImpl = this.transitionImpl;
                    Object obj = this.sharedElementTransition;
                    fragmentTransitionImpl.scheduleRemoveTargets(obj, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null, obj, this.sharedElementLastInViews);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator<TransitionInfo> it2 = this.transitionInfos.iterator();
            Object obj2 = null;
            Object obj3 = null;
            while (it2.hasNext()) {
                TransitionInfo next = it2.next();
                SpecialEffectsController.Operation operation5 = next.getOperation();
                Object cloneTransition = this.transitionImpl.cloneTransition(next.getTransition());
                if (cloneTransition != null) {
                    ArrayList arrayList2 = new ArrayList();
                    it = it2;
                    View view5 = operation5.getFragment().mView;
                    Object obj4 = obj3;
                    Intrinsics.checkNotNullExpressionValue(view5, "operation.fragment.mView");
                    captureTransitioningViews(arrayList2, view5);
                    if (this.sharedElementTransition != null && (operation5 == operation4 || operation5 == operation3)) {
                        if (operation5 == operation4) {
                            arrayList2.removeAll(CollectionsKt.toSet(this.sharedElementFirstOutViews));
                        } else {
                            arrayList2.removeAll(CollectionsKt.toSet(this.sharedElementLastInViews));
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        this.transitionImpl.addTarget(cloneTransition, view);
                    } else {
                        this.transitionImpl.addTargets(cloneTransition, arrayList2);
                        this.transitionImpl.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList2, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null);
                        if (operation5.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation5.setAwaitingContainerChanges(false);
                            ArrayList arrayList3 = new ArrayList(arrayList2);
                            arrayList3.remove(operation5.getFragment().mView);
                            this.transitionImpl.scheduleHideFragmentView(cloneTransition, operation5.getFragment().mView, arrayList3);
                            OneShotPreDrawListener.add(viewGroup, new DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda2(arrayList2));
                        }
                    }
                    if (operation5.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList.addAll(arrayList2);
                        if (z) {
                            this.transitionImpl.setEpicenter(cloneTransition, rect);
                        }
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Entering Transition: " + cloneTransition);
                            Log.v(FragmentManager.TAG, ">>>>> EnteringViews <<<<<");
                            Iterator it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                Object next2 = it3.next();
                                Intrinsics.checkNotNullExpressionValue(next2, "transitioningViews");
                                Log.v(FragmentManager.TAG, "View: " + ((View) next2));
                            }
                        }
                    } else {
                        this.transitionImpl.setEpicenter(cloneTransition, view2);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Exiting Transition: " + cloneTransition);
                            Log.v(FragmentManager.TAG, ">>>>> ExitingViews <<<<<");
                            Iterator it4 = arrayList2.iterator();
                            while (it4.hasNext()) {
                                Object next3 = it4.next();
                                Intrinsics.checkNotNullExpressionValue(next3, "transitioningViews");
                                Log.v(FragmentManager.TAG, "View: " + ((View) next3));
                            }
                        }
                    }
                    if (next.isOverlapAllowed()) {
                        obj2 = this.transitionImpl.mergeTransitionsTogether(obj2, cloneTransition, (Object) null);
                        operation3 = operation;
                        it2 = it;
                        obj3 = obj4;
                    } else {
                        obj3 = this.transitionImpl.mergeTransitionsTogether(obj4, cloneTransition, (Object) null);
                    }
                } else {
                    it = it2;
                    Object obj5 = obj3;
                }
                operation3 = operation;
                it2 = it;
            }
            Object mergeTransitionsInSequence = this.transitionImpl.mergeTransitionsInSequence(obj2, obj3, this.sharedElementTransition);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Final merged transition: " + mergeTransitionsInSequence);
            }
            return new Pair<>(arrayList, mergeTransitionsInSequence);
        }

        /* access modifiers changed from: private */
        public static final void createMergedTransition$lambda$12(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, TransitionEffect transitionEffect) {
            Intrinsics.checkNotNullParameter(transitionEffect, "this$0");
            FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), transitionEffect.isPop, transitionEffect.lastInViews, false);
        }

        /* access modifiers changed from: private */
        public static final void createMergedTransition$lambda$13(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
            Intrinsics.checkNotNullParameter(fragmentTransitionImpl, "$impl");
            Intrinsics.checkNotNullParameter(rect, "$lastInEpicenterRect");
            fragmentTransitionImpl.getBoundsOnScreen(view, rect);
        }

        /* access modifiers changed from: private */
        public static final void createMergedTransition$lambda$14(ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "$transitioningViews");
            FragmentTransition.setViewVisibility(arrayList, 4);
        }

        private final void runTransition(ArrayList<View> arrayList, ViewGroup viewGroup, Function0<Unit> function0) {
            List list = arrayList;
            FragmentTransition.setViewVisibility(list, 4);
            ArrayList<String> prepareSetNameOverridesReordered = this.transitionImpl.prepareSetNameOverridesReordered(this.sharedElementLastInViews);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, ">>>>> Beginning transition <<<<<");
                Log.v(FragmentManager.TAG, ">>>>> SharedElementFirstOutViews <<<<<");
                Iterator<View> it = this.sharedElementFirstOutViews.iterator();
                while (it.hasNext()) {
                    View next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "sharedElementFirstOutViews");
                    View view = next;
                    Log.v(FragmentManager.TAG, "View: " + view + " Name: " + ViewCompat.getTransitionName(view));
                }
                Log.v(FragmentManager.TAG, ">>>>> SharedElementLastInViews <<<<<");
                Iterator<View> it2 = this.sharedElementLastInViews.iterator();
                while (it2.hasNext()) {
                    View next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "sharedElementLastInViews");
                    View view2 = next2;
                    Log.v(FragmentManager.TAG, "View: " + view2 + " Name: " + ViewCompat.getTransitionName(view2));
                }
            }
            function0.invoke();
            this.transitionImpl.setNameOverridesReordered(viewGroup, this.sharedElementFirstOutViews, this.sharedElementLastInViews, prepareSetNameOverridesReordered, this.sharedElementNameMapping);
            FragmentTransition.setViewVisibility(list, 0);
            this.transitionImpl.swapSharedElementTargets(this.sharedElementTransition, this.sharedElementFirstOutViews, this.sharedElementLastInViews);
        }

        public void onCancel(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            this.transitionSignal.cancel();
        }

        private final void captureTransitioningViews(ArrayList<View> arrayList, View view) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (!ViewGroupCompat.isTransitionGroup(viewGroup)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt.getVisibility() == 0) {
                            Intrinsics.checkNotNullExpressionValue(childAt, "child");
                            captureTransitioningViews(arrayList, childAt);
                        }
                    }
                } else if (!arrayList.contains(view)) {
                    arrayList.add(view);
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(view);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$Api24Impl;", "", "()V", "totalDuration", "", "animatorSet", "Landroid/animation/AnimatorSet;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    public static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        public final long totalDuration(AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/fragment/app/DefaultSpecialEffectsController$Api26Impl;", "", "()V", "reverse", "", "animatorSet", "Landroid/animation/AnimatorSet;", "setCurrentPlayTime", "time", "", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultSpecialEffectsController.kt */
    public static final class Api26Impl {
        public static final Api26Impl INSTANCE = new Api26Impl();

        private Api26Impl() {
        }

        public final void reverse(AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        public final void setCurrentPlayTime(AnimatorSet animatorSet, long j) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j);
        }
    }
}
