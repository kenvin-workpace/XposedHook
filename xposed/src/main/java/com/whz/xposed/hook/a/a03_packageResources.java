package com.whz.xposed.hook.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;

import static com.whz.xposed.utils.ConfigUtil.PACKAGE_NAME;
import static com.whz.xposed.utils.ConfigUtil.aTag;

/**
 * Created by kevin on 2018/7/23
 */
public class a03_packageResources implements IXposedHookInitPackageResources {

    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam param) throws Throwable {
        if (TextUtils.equals(param.packageName, PACKAGE_NAME)) {
            param.res.hookLayout(param.packageName, "layout", "activity_main", new XC_LayoutInflated() {
                @Override
                public void handleLayoutInflated(LayoutInflatedParam layoutInflatedParam) throws Throwable {
                    ViewGroup viewGroup = (ViewGroup) layoutInflatedParam.view;
                    printChildView(viewGroup);
                }
            });
        }
    }

    /**
     * 遍历资源布局树
     */
    private void printChildView(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            Log.e(aTag, "child: " + child);

            if (child instanceof ViewGroup) {
                printChildView((ViewGroup) child);
            }
        }
    }
}
