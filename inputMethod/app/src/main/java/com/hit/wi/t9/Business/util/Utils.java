package com.hit.wi.t9.Business.util;

public class Utils {
    private static long lastClickTime=System.currentTimeMillis();
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if ( time - lastClickTime < 50) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
