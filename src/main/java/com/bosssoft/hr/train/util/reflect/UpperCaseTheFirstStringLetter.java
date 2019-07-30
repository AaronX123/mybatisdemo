package com.bosssoft.hr.train.util.reflect;

/**将String字符串的第一个字母大写
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-20
 */
public class UpperCaseTheFirstStringLetter {
    /**
     * 将字符串第一个字母大写
     * @param str 要变化的字符串
     * @return  第一个字母大写的字符串
     */
    public static String upperCaseFirstLetter(String str) {
        char[] ch = str.toCharArray();
        char lowBorder='a';
        char highBorder='z';
        if (ch[0] >= lowBorder && ch[0] <= highBorder) {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}
