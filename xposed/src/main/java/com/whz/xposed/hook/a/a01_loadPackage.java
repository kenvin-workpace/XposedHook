package com.whz.xposed.hook.a;

import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static com.whz.xposed.utils.ConfigUtil.DEFAULT_VALUE;
import static com.whz.xposed.utils.ConfigUtil.MAIN_ACTIVITY;
import static com.whz.xposed.utils.ConfigUtil.PACKAGE_NAME;
import static com.whz.xposed.utils.ConfigUtil.aTag;


/**
 * Created by kevin on 2018/7/19
 */
public class a01_loadPackage implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable {
        if (TextUtils.equals(param.packageName, PACKAGE_NAME)) {
            Class<?> clz = param.classLoader.loadClass(MAIN_ACTIVITY);

            init(clz);
            //无参
            btn_01(clz);
            //有参
            btn_02(clz);
        }
    }

    /**
     * 有参
     */
    private void btn_02(Class<?> clz) {
        XposedHelpers.findAndHookMethod(clz, "btn_02", String.class, int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                //old
                Log.e(aTag, param.args[0] + " : " + param.args[1]);
                //new
                param.args[0] = DEFAULT_VALUE;
                param.args[1] = 888;
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
    }

    /**
     * 无参
     */
    private void btn_01(Class<?> clz) {
        XposedHelpers.findAndHookMethod(clz, "getResult", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(DEFAULT_VALUE);
            }
        });
    }

    private void init(final Class<?> clz) {
        XposedHelpers.findAndHookMethod(clz, "initData", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                //利用反射
                Field view = clz.getDeclaredField("mTextView");
                view.setAccessible(true);
                TextView textView = (TextView) view.get(param.thisObject);
                textView.setText(DEFAULT_VALUE);
            }
        });
    }


}
