package com.rui.xb.purple.mvp.dagger;

import android.app.Application;

import com.rui.xb.purple.app.RuiApp;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        MainModule.class,
        ActivityBindingModule.class,
        FragmentBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<RuiApp> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent.Builder mainModule(MainModule mainModule);

        AppComponent build();
    }
}
