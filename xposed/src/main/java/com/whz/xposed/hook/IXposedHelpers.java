package com.whz.xposed.hook;

import android.text.TextUtils;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static com.whz.xposed.utils.ConfigUtil.PACKAGE_NAME;

/**
 * Created by kevin on 2018/7/23
 */
public abstract class IXposedHelpers implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (TextUtils.equals(loadPackageParam.packageName, PACKAGE_NAME)) {
            process(loadPackageParam);
        }
    }

    public abstract void process(XC_LoadPackage.LoadPackageParam param) throws Throwable;
}
