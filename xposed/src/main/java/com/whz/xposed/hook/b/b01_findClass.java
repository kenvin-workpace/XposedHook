package com.whz.xposed.hook.b;

import android.util.Log;

import com.whz.xposed.hook.IXposedHelpers;

import java.lang.reflect.Method;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static com.whz.xposed.utils.ConfigUtil.MAIN_ACTIVITY;
import static com.whz.xposed.utils.ConfigUtil.aTag;

/**
 * Created by kevin on 2018/7/23
 */
public class b01_findClass extends IXposedHelpers {
    @Override
    public void process(XC_LoadPackage.LoadPackageParam param) throws Throwable {
        Class<?> clz = XposedHelpers.findClass(MAIN_ACTIVITY, param.classLoader);
        Method[] methods = clz.getMethods();
        Log.e(aTag, "method:" + methods.length);
    }
}
