package com.google.firebase.datatransport;

import android.content.Context;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.Collections;
import java.util.List;

public class TransportRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return Collections.singletonList(Component.builder(TransportFactory.class).add(Dependency.required(Context.class)).factory(new TransportRegistrar$$ExternalSyntheticLambda0()).build());
    }
}
