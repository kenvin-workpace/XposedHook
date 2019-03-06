package com.whz.xposed.hook.a;

import android.app.AndroidAppHelper;
import android.text.TextUtils;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static com.whz.xposed.utils.ConfigUtil.PACKAGE_NAME;
import static com.whz.xposed.utils.ConfigUtil.aTag;

/**
 * Created by kevin on 2018/7/23
 */
public class a02_androidAppHelper implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable {
        if (TextUtils.equals(param.packageName, PACKAGE_NAME)) {
            String className = AndroidAppHelper.currentApplicationInfo().className;
            String packageName = AndroidAppHelper.currentPackageName();
            String processName = AndroidAppHelper.currentProcessName();
            Log.e(aTag, "className:" + className + " packageName:" + packageName + " processName:" + processName);
        }
    }
}
