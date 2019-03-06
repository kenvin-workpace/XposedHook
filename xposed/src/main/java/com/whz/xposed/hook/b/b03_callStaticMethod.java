package com.whz.xposed.hook.b;

import com.whz.xposed.hook.IXposedHelpers;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static com.whz.xposed.utils.ConfigUtil.DEFAULT_VALUE;
import static com.whz.xposed.utils.ConfigUtil.MAIN_ACTIVITY;

/**
 * Created by kevin on 2018/7/23
 */
public class b03_callStaticMethod extends IXposedHelpers {

    @Override
    public void process(XC_LoadPackage.LoadPackageParam param) throws Throwable {
        XposedHelpers.callStaticMethod(param.classLoader.loadClass(MAIN_ACTIVITY), "btn_04", new Class[]{String.class, int.class}, DEFAULT_VALUE, 888);
    }
}
