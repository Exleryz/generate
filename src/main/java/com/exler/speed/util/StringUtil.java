package com.exler.speed.util;

/**
 * @Description: TODO
 * @Company: BIG-FINTECH
 * @ProjectName: iRich
 * @author: Exler(yz)
 * @GmtCreate: 2019/8/23 11:49
 */
public class StringUtil {

    public static String upFirst(String str) {
        return str.toUpperCase().substring(0, 1) + str.substring(1, str.length());
    }
}
