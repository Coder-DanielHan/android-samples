package com.danielhan.javareflection.ioc;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author DanielHan
 * @date 2018/6/11
 */
public class ViewInjectUtils {

    private static final String METHOD_FIND_VIEW_BY_ID = "findViewById";
    private static final String METHOD_SET_CONTENT_VIEW = "setContentView";

    public static void inject(Activity activity) {
        injectContentView(activity);
        injectView(activity);
        injectClick(activity);
    }

    public static void injectView(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            ViewInject annotation = declaredField.getAnnotation(ViewInject.class);
            if (annotation != null) {
                int viewId = annotation.value();
                if (viewId != -1) {
                    try {
                        Method method = aClass.getMethod(METHOD_FIND_VIEW_BY_ID, int.class);
                        Object invoke = method.invoke(activity, viewId);
                        declaredField.setAccessible(true);
                        declaredField.set(activity, invoke);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void injectContentView(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        ContentView annotation = aClass.getAnnotation(ContentView.class);
        if (annotation != null) {
            int contentViewId = annotation.value();
            if (contentViewId != -1) {
                try {
                    Method method = aClass.getMethod(METHOD_SET_CONTENT_VIEW, int.class);
                    method.invoke(activity, contentViewId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void injectClick(final Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (final Method declaredMethod : declaredMethods) {
            OnClick annotation = declaredMethod.getAnnotation(OnClick.class);
            if (annotation != null) {
                int viewId = annotation.value();
                if (viewId != -1) {
                    Method method = null;
                    try {
                        method = aClass.getMethod(METHOD_FIND_VIEW_BY_ID, int.class);
                        Object invoke = method.invoke(activity, viewId);
                        if (invoke instanceof View) {
                            ((View) invoke).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    try {
                                        declaredMethod.invoke(activity, null);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
