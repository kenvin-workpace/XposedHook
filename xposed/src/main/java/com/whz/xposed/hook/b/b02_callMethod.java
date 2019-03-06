package com.whz.xposed.hook.b;

import com.whz.xposed.hook.IXposedHelpers;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static com.whz.xposed.utils.ConfigUtil.MAIN_ACTIVITY;

/**
 * Created by kevin on 2018/7/23
 */
public class b02_callMethod extends IXposedHelpers {
    @Override
    public void process(XC_LoadPackage.LoadPackageParam param) throws Throwable {
        XposedHelpers.callMethod(param.classLoader.loadClass(MAIN_ACTIVITY).newInstance(), "btn_03");
    }
}
