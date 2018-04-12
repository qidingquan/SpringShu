package com.ys.qdq.springshu.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

/**
 * 数字类型的工具类，提供对数字的按需求的格式和常用的格式(如用数字分隔符分隔表示、用科学计数法表示、<br>
 * 百分比、千分比、金钱符号表示、设定小数点位数等）、格式化成字符串、提供对格式化后的数字字符串<br>
 * 反格式化成数字、和提供精确的数字的加、减、乖、除、和四舍五入运算。<br>
 * <p/>
 * <p/>
 * <p><pre><b>
 * 历史更新记录:</b>
 * 2004-06-17  创建此类型
 * 2005-10-02  修改方法:getCNofNumber(),getBigCNofNumber(),抛出异常:IllegalArgumentException()
 * </pre></p>
 *
 * @author abnerchai, wenjian
 * @version 1.0
 * @since JThink 1.0
 */

public final class NumberHelper {

    /**
     * 有一位小数，且当这个小数为0时不显示，整数部分正常显示，若整数部分为0，则显示0.x，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_1 = "#,##0.#";

    /**
     * 有二位小数，且当最后这位小数为0时不显示,整数部分正常显示，若整数部分为0，则显示0.xx，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_2 = "#,##0.##";

    /**
     * 有三位小数，且当最后这位小数为0时不显示，整数部分正常显示，若整数部分为0，则显示0.xxx，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_3 = "#,##0.###";

    /**
     * 有四位小数，且当最后这位小数为0时不显示，整数部分正常显示，若整数部分为0，则显示0.xxxx，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_4 = "#,##0.####";

    /**
     * 有五位小数，且当最后这位小数为0时不显示，整数部分正常显示，若整数部分为0，则显示0.xxxxx，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_5 = "#,##0.#####";

    /**
     * 有六位小数，且当最后这位小数为0时不显示，整数部分正常显示，若整数部分为0，则显示0.xxxxxx，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_6 = "#,##0.######";

    /**
     * 有一位小数，且当这个小数为0时显示，整数部分正常显示，若整数部分为0，则显示0.x，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_1_0 = "#,##0.0";

    /**
     * 有二位小数，且当最后这位小数为0时显示,整数部分正常显示，若整数部分为0，则显示0.xx，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_2_0 = "#,##0.00";

    /**
     * 有三位小数，且当最后这位小数为0时显示，整数部分正常显示，若整数部分为0，则显示0.xxx，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_3_0 = "#,##0.000";

    /**
     * 有四位小数，且当最后这位小数为0时显示，整数部分正常显示，若整数部分为0，则显示0.xxxx，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_4_0 = "#,##0.0000";

    /**
     * 有五位小数，且当最后这位小数为0时显示，整数部分正常显示，若整数部分为0，则显示0.xxxxx，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_5_0 = "#,##0.00000";

    /**
     * 有六位小数，且当最后这位小数为0时显示，整数部分正常显示，若整数部分为0，则显示0.xxxxxx，若整数部分长度超过3位，用逗号分开
     */
    public final static String NUMBER_I_6_0 = "#,##0.000000";
    /**
     * 有一位小数，且当这个小数为0时不显示，整数部分正常显示，若整数部分为0，则显示0.x，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_1 = "##0.#";
    /**
     * 有二位小数，且当最后这位小数为0时不显示,整数部分正常显示，若整数部分为0，则显示0.xx，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_2 = "##0.##";
    /**
     * 有三位小数，且当最后这位小数为0时不显示，整数部分正常显示，若整数部分为0，则显示0.xxx，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_3 = "##0.###";
    /**
     * 有四位小数，且当最后这位小数为0时不显示，整数部分正常显示，若整数部分为0，则显示0.xxxx，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_4 = "##0.####";
    /**
     * 有五位小数，且当最后这位小数为0时不显示，整数部分正常显示，若整数部分为0，则显示0.xxxxx，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_5 = "##0.#####";
    /**
     * 有六位小数，且当最后这位小数为0时不显示，整数部分正常显示，若整数部分为0，则显示0.xxxxxx，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_6 = "##0.######";

    /**
     * 有一位小数，且当这个小数为0时显示，整数部分正常显示，若整数部分为0，则显示0.x，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_1_0 = "##0.0";
    /**
     * 有二位小数，且当最后这位小数为0时显示,整数部分正常显示，若整数部分为0，则显示0.xx，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_2_0 = "##0.00";
    /**
     * 有三位小数，且当最后这位小数为0时显示，整数部分正常显示，若整数部分为0，则显示0.xxx，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_3_0 = "##0.000";
    /**
     * 有四位小数，且当最后这位小数为0时显示，整数部分正常显示，若整数部分为0，则显示0.xxxx，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_4_0 = "##0.0000";
    /**
     * 有五位小数，且当最后这位小数为0时显示，整数部分正常显示，若整数部分为0，则显示0.xxxxx，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_5_0 = "##0.00000";
    /**
     * 有六位小数，且当最后这位小数为0时显示，整数部分正常显示，若整数部分为0，则显示0.xxxxxx，若整数部分长度超过3位，不用逗号分开
     */
    public final static String NUMBER_IN_6_0 = "##0.000000";

    /**
     * 格式化成整数，如果整数为0，则显示0，当整数长度超过3位时，用逗号隔开
     */
    public final static String NUMBER_I = "#,##0";

    /**
     * 格式化成整数，如果整数为0，则显示0，当整数长度超过3位时，不用逗号隔开
     */
    public final static String NUMBER_IN = "##0";

    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有0位，指数显示为整数
     */
    public final static String NUMBER_E_I_0 = "0E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有一位，若小数部分为0，不显示，指数显示为整数
     */
    public final static String NUMBER_E_I_1 = "0.#E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有二位，若小数部分为0，不显示，指数显示为整数
     */
    public final static String NUMBER_E_I_2 = "0.##E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有三位，若小数部分为0，不显示，指数显示为整数
     */
    public final static String NUMBER_E_I_3 = "0.###E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有四位，若小数部分为0，不显示，指数显示为整数
     */
    public final static String NUMBER_E_I_4 = "0.####E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有五位，若小数部分为0，不显示，指数显示为整数
     */
    public final static String NUMBER_E_I_5 = "0.#####E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有六位，若小数部分为0，不显示，指数显示为整数
     */
    public final static String NUMBER_E_I_6 = "0.######E0";

    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有一位，若小数部分为0，显示出来，指数显示为整数
     */
    public final static String NUMBER_E_I_1_0 = "0.0E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有二位，若小数部分为0，显示出来，指数显示为整数
     */
    public final static String NUMBER_E_I_2_0 = "0.00E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有三位，若小数部分为0，显示出来，指数显示为整数
     */
    public final static String NUMBER_E_I_3_0 = "0.000E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有四位，若小数部分为0，显示出来，指数显示为整数
     */
    public final static String NUMBER_E_I_4_0 = "0.0000E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有五位，若小数部分为0，显示出来，指数显示为整数
     */
    public final static String NUMBER_E_I_5_0 = "0.00000E0";
    /**
     * 采用科学计数法表示一个数，整数部分（整数大于等于0小于10）有一位，若整数部分为0，显示为0，
     * 小数部分有六位，若小数部分为0，显示出来，指数显示为整数
     */
    public final static String NUMBER_E_I_6_0 = "0.000000E0";

    /**
     * 采用百分数显示，精确到小数点后0位，若小数为0，不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_0 = "0%";
    /**
     * 采用百分数显示，精确到小数点后1位，若小数为0，不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_1 = "0.#%";
    /**
     * 采用百分数显示，精确到小数点后2位，若小数为0，不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_2 = "0.##%";
    /**
     * 采用百分数显示，精确到小数点后3位，若小数为0，不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_3 = "0.###%";
    /**
     * 采用百分数显示，精确到小数点后4位，若小数为0，不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_4 = "0.####%";
    /**
     * 采用百分数显示，精确到小数点后5位，若小数为0，不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_5 = "0.#####%";
    /**
     * 采用百分数显示，精确到小数点后6位，若小数为0，不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_6 = "0.######%";

    /**
     * 采用百分数显示，精确到小数点后1位，若小数为0，显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_1_0 = "0.0%";
    /**
     * 采用百分数显示，精确到小数点后2位，若小数为0，显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_2_0 = "0.00%";
    /**
     * 采用百分数显示，精确到小数点后3位，若小数为0，显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_3_0 = "0.000%";
    /**
     * 采用百分数显示，精确到小数点后4位，若小数为0，显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_4_0 = "0.0000%";
    /**
     * 采用百分数显示，精确到小数点后5位，若小数为0，显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_5_0 = "0.00000%";
    /**
     * 采用百分数显示，精确到小数点后6位，若小数为0，显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_P_I_6_0 = "0.000000%";

    /**
     * 采用千分比数显示，精确到小数点后0位,若小数为0，则不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_0 = "0\u2030";
    /**
     * 采用千分比数显示，精确到小数点后1位,若小数为0，则不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_1 = "0.#\u2030";
    /**
     * 采用千分比数显示，精确到小数点后2位,若小数为0，则不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_2 = "0.##\u2030";
    /**
     * 采用千分比数显示，精确到小数点后3位,若小数为0，则不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_3 = "0.###\u2030";
    /**
     * 采用千分比数显示，精确到小数点后4位,若小数为0，则不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_4 = "0.####\u2030";
    /**
     * 采用千分比数显示，精确到小数点后5位,若小数为0，则不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_5 = "0.#####\u2030";
    /**
     * 采用千分比数显示，精确到小数点后6位,若小数为0，则不显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_6 = "0.######\u2030";

    /**
     * 采用千分比数显示，精确到小数点后1位,若小数为0，则显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_1_0 = "0.0\u2030";
    /**
     * 采用千分比数显示，精确到小数点后2位,若小数为0，则显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_2_0 = "0.00\u2030";
    /**
     * 采用千分比数显示，精确到小数点后3位,若小数为0，则显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_3_0 = "0.000\u2030";
    /**
     * 采用千分比数显示，精确到小数点后4位,若小数为0，则显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_4_0 = "0.0000\u2030";
    /**
     * 采用千分比数显示，精确到小数点后5位,若小数为0，则显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_5_0 = "0.00000\u2030";
    /**
     * 采用千分比数显示，精确到小数点后6位,若小数为0，则显示出来，整数按实际长度显示，若整数为0显示为0
     */
    public final static String NUMBER_M_I_6_0 = "0.000000\u2030";

    /**
     * 以金钱符号显示（人民币格式），精确到小数点后0位,整数部分按实际长度显示，若整数为0，显示为0
     */
    public final static String MONEY_I_0 = "\u00A40";
    /**
     * 以金钱符号显示（人民币格式），精确到小数点后1位,若小数为0，则显示出来，整数部分按实际长度显示，若整数为0，显示为0
     */
    public final static String MONEY_I_1 = "\u00A40.0";
    /**
     * 以金钱符号显示（人民币格式），精确到小数点后2位,若小数为0，则显示出来，整数部分按实际长度显示，若整数为0，显示为0
     */
    public final static String MONEY_I_2 = "\u00A40.00";
    /**
     * 以金钱符号显示（人民币格式），精确到小数点后0位,整数部分按实际长度显示，若整数为0，显示为0
     */

    /**
     * 以金钱符号显示（人民币格式），精确到小数点后1位,若小数为0，则不显示出来，整数部分按实际长度显示，若整数为0，显示为0
     */
    public final static String MONEY_I_1_0 = "\u00A40.#";
    /**
     * 以金钱符号显示（人民币格式），精确到小数点后2位,若小数为0，则不显示出来，整数部分按实际长度显示，若整数为0，显示为0
     */
    public final static String MONEY_I_2_0 = "\u00A40.##";

    /**
     * 默认的精确到小数点后6位
     */
    private static final int DEF_DIV_SCALE = 6;

    /**
     * 私有构造方法，不能创建对象，使得本类的方法全部为静态的。
     */
    private NumberHelper() {
    }

    /**
     * 将给定的一个数字按中国的习惯和指定的格式来格式化它，并返回一个该数字对应的字符串
     *
     * @param number    需要被格式化的数字
     * @param formatStr 格式化该数字的字符串，参见本类中定义的常量
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumberCN(double number, String formatStr) {
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.CHINA);
        df.applyPattern(formatStr);
        return df.format(number);
    }

    /**
     * 将给定的一个数字按中国的习惯和(字符串格式)按指定的格式来格式化它，并返回一个该数字的对应的格式化后的字符串
     *
     * @param number    需要被格式化的数字对应的字符串
     * @param formatStr 格式化该数字的字符串，参见本类中定义的常量
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumberCN(String number, String formatStr) {
        if (number == null || number.length() < 1) {
            return "";
        }
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.CHINA);
        df.applyPattern(formatStr);
        String numberStr = df.format(Double.parseDouble(number));
        return numberStr;
    }

    /**
     * 将给定的一个数字按中国的习惯和按始终显示两位小数，整数部分超过3位时不用","分开的格式格式化
     * 并返回一个该格式化后的字符串
     *
     * @param number 被格式化的数字
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumberCN(double number) {
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.CHINA);
        df.applyPattern(NUMBER_IN_2_0);
        return df.format(number);
    }

    /**
     * 将给定的一个数字字符串按中国的习惯和按始终显示两位小数，整数部分超过3位时不用","分开的格式格式化
     * 并返回一个该格式化后的字符串
     *
     * @param number 被格式化的数字对应的字符串
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumberCN(String number) {
        if (number == null || number.length() < 1) {
            return "";
        }
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.CHINA);
        df.applyPattern(NUMBER_IN_2_0);
        return df.format(Double.parseDouble(number));
    }

    /**
     * 将给定的一个数字按指定的国家的风格和指定的格式来格式化它，并返回一个该数字对应的字符串
     *
     * @param number    需要被格式化的数字
     * @param formatStr 格式化该数字的字符串，参见本类中定义的常量
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumberLocale(double number, String formatStr, Locale locale) {
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(locale);
        df.applyPattern(formatStr);
        return df.format(number);
    }

    /**
     * 将给定的一个数字按指定的国家的风格和(字符串格式)按指定的格式来格式化它，并返回一个该数字的对应的格式化后的字符串
     *
     * @param number    需要被格式化的数字对应的字符串
     * @param formatStr 格式化该数字的字符串，参见本类中定义的常量
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumberLocale(String number, String formatStr, Locale locale) {
        if (number == null || number.length() < 1) {
            return "";
        }
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(locale);
        df.applyPattern(formatStr);
        String numberStr = df.format(Double.parseDouble(number));
        return numberStr;
    }

    /**
     * 将给定的一个数字按指定的国家的风格和按始终显示两位小数，整数部分超过3位时不用","分开的格式格式化
     * 并返回一个该格式化后的字符串
     *
     * @param number 被格式化的数字
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumberLocale(double number, Locale locale) {
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(locale);
        df.applyPattern(NUMBER_IN_2_0);
        return df.format(number);
    }

    /**
     * 将给定的一个数字字符串按指定的国家的风格和按始终显示两位小数，整数部分超过3位时不用","分开的格式格式化
     * 并返回一个该格式化后的字符串
     *
     * @param number 被格式化的数字对应的字符串
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumberLocale(String number, Locale locale) {
        if (number == null || number.length() < 1) {
            return "";
        }
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(locale);
        df.applyPattern(NUMBER_IN_2_0);
        return df.format(Double.parseDouble(number));
    }

    /**
     * 将给定的一个数字按默认操作系统所在的国家的习惯和指定的格式来格式化它，并返回一个该数字对应的字符串
     *
     * @param number    需要被格式化的数字
     * @param formatStr 格式化该数字的字符串，参见本类中定义的常量
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumber(double number, String formatStr) {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern(formatStr);
        return df.format(number);
    }

    /**
     * 将给定的一个数字按默认操作系统所在的国家的习惯和(字符串格式)按指定的格式来格式化它，并返回一个该数字的对应的格式化后的字符串
     *
     * @param number    需要被格式化的数字对应的字符串
     * @param formatStr 格式化该数字的字符串，参见本类中定义的常量
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumber(String number, String formatStr) {
        if (number == null || number.length() < 1) {
            return "";
        }
        DecimalFormat df = new DecimalFormat();
        df.applyPattern(formatStr);
        String numberStr = df.format(Double.parseDouble(number));
        return numberStr;
    }

    /**
     * 将给定的一个数字按默认操作系统所在的国家的习惯和按始终显示两位小数，整数部分超过3位时不用","分开的格式格式化
     * 并返回一个该格式化后的字符串
     *
     * @param number 被格式化的数字
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumber(double number) {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern(NUMBER_IN_2_0);
        return df.format(number);
    }

    /**
     * 将给定的一个数字字符串按默认操作系统所在的国家的习惯和按始终显示两位小数，整数部分超过3位时不用","分开的格式格式化
     * 并返回一个该格式化后的字符串
     *
     * @param number 被格式化的数字对应的字符串
     * @return 返回格式化后的数字的对应的字符串
     */
    public static String formatNumber(String number) {
        if (number == null || number.length() < 1) {
            return "";
        }

        DecimalFormat df = new DecimalFormat();
        df.applyPattern(NUMBER_IN_2_0);
        return df.format(Double.parseDouble(number));
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后6位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE); //调用下面一个方法
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 获取单个数字（0-10）的小写中文对应的描述。
     *
     * @param num 对应的数字，在0和10之间
     * @return 返回该数字对应的中文，如1返回“一”0返回“零”
     */
    public static String getCNofNumber(int num) {
        if (num < 0 || num > 10) {
            throw new IllegalArgumentException("参数不正确,参数值范围:0-10");
        }
        String reCNStr = "";
        switch (num) {
            case 0:
                reCNStr = "零";
                break;
            case 1:
                reCNStr = "一";
                break;
            case 2:
                reCNStr = "二";
                break;
            case 3:
                reCNStr = "三";
                break;
            case 4:
                reCNStr = "四";
                break;
            case 5:
                reCNStr = "五";
                break;
            case 6:
                reCNStr = "六";
                break;
            case 7:
                reCNStr = "七";
                break;
            case 8:
                reCNStr = "八";
                break;
            case 9:
                reCNStr = "九";
                break;
            case 10:
                reCNStr = "十";
                break;
        }
        return reCNStr;
    }

    /**
     * 获取单个数字（0-10）的小写中文对应的描述。
     *
     * @param numStr 串，它对应的数字，在0和10之间，如："0","1","8","10"
     * @return 返回该数字对应的中文，如“1”返回“一”，“10”返回“拾”
     */
    public static String getCNofNumber(String numStr) {
        int num = Integer.parseInt(numStr);
        if (num < 0 || num > 10) {
            throw new IllegalArgumentException("参数不正确,参数值范围:0-10");
        }
        String reCNStr = "";
        switch (num) {
            case 0:
                reCNStr = "零";
                break;
            case 1:
                reCNStr = "一";
                break;
            case 2:
                reCNStr = "二";
                break;
            case 3:
                reCNStr = "三";
                break;
            case 4:
                reCNStr = "四";
                break;
            case 5:
                reCNStr = "五";
                break;
            case 6:
                reCNStr = "六";
                break;
            case 7:
                reCNStr = "七";
                break;
            case 8:
                reCNStr = "八";
                break;
            case 9:
                reCNStr = "九";
                break;
            case 10:
                reCNStr = "十";
                break;
        }
        return reCNStr;
    }

    /**
     * 获取单个数字（0-10）的大写中文对应的描述。
     *
     * @param num 对应的数字，在0和10之间
     * @return 返回该数字对应的中文，如1返回“壹”
     */
    public static String getBigCNofNumber(int num) {
        if (num < 0 || num > 10) {
            throw new IllegalArgumentException("参数不正确,参数值范围:0-10");
        }
        String reCNStr = "";
        switch (num) {
            case 0:
                reCNStr = "零";
                break;
            case 1:
                reCNStr = "壹";
                break;
            case 2:
                reCNStr = "贰";
                break;
            case 3:
                reCNStr = "叁";
                break;
            case 4:
                reCNStr = "肆";
                break;
            case 5:
                reCNStr = "伍";
                break;
            case 6:
                reCNStr = "陆";
                break;
            case 7:
                reCNStr = "柒";
                break;
            case 8:
                reCNStr = "扒";
                break;
            case 9:
                reCNStr = "玖";
                break;
            case 10:
                reCNStr = "拾";
                break;
        }
        return reCNStr;
    }

    /**
     * 获取单个数字串（0-10）的中文对应的描述。
     *
     * @param numStr 串，它对应的数字，在0和10之间
     * @return 返回该数字对应的中文，如1返回“壹”
     */
    public static String getBigCNofNumber(String numStr) {
        int num = Integer.parseInt(numStr);
        if (num < 0 || num > 10) {
            throw new IllegalArgumentException("参数不正确,参数值范围:0-10");
        }
        String reCNStr = "";
        switch (num) {
            case 0:
                reCNStr = "零";
                break;
            case 1:
                reCNStr = "壹";
                break;
            case 2:
                reCNStr = "贰";
                break;
            case 3:
                reCNStr = "叁";
                break;
            case 4:
                reCNStr = "肆";
                break;
            case 5:
                reCNStr = "伍";
                break;
            case 6:
                reCNStr = "陆";
                break;
            case 7:
                reCNStr = "柒";
                break;
            case 8:
                reCNStr = "扒";
                break;
            case 9:
                reCNStr = "玖";
                break;
            case 10:
                reCNStr = "拾";
                break;
        }
        return reCNStr;
    }

    /**
     * 返回一个数字的小写中文写法，如123返回一二三，而不是读法，如1978返回一九七八
     *
     * @param num 对应的数字
     * @return 返回该数字的中文描述, 如123返回一二三，而不是读法，如1978返回一九七八
     */
    public static String getCNStringOfNumber(int num) {
        String reStr = "";
        String numStr = String.valueOf(num).trim();
        int length = numStr.length();
        for (int i = 0; i < length; i++) {
            reStr += getCNofNumber(numStr.substring(i, i + 1));
        }
        return reStr;
    }


    /**
     * 返回一个数字串的小写中文写法，如123返回：一二三；06返回：零六；1978返回一九七八
     *
     * @param num 对应的数字
     * @return 返回该数字的中文描述 如123返回：一二三；06返回：零六；1978返回一九七八
     */
    public static String getCNStringOfNumber(String num) {
        String reStr = "";
        String numStr = num.trim();
        int length = numStr.length();
        for (int i = 0; i < length; i++) {
            reStr += getCNofNumber(numStr.substring(i, i + 1));
        }
        return reStr;
    }

    /**
     * 返回一个数字的大写中文写法，如123返回：壹贰叁；06返回：零陆；1978返回壹玖柒扒
     *
     * @param num 对应的数字
     * @return 返回该数字的中文描述, 如123返回：壹贰叁；06返回：零陆；1978返回壹玖柒扒
     */
    public static String getBigCNStringOfNumber(int num) {
        String reStr = "";
        String numStr = String.valueOf(num).trim();
        int length = numStr.length();
        for (int i = 0; i < length; i++) {
            reStr += getBigCNofNumber(numStr.substring(i, i + 1));
        }
        return reStr;
    }


    /**
     * 返回一个数字串的大写中文写法，如123返回：壹贰叁；06返回：零陆；1978返回壹玖柒扒
     *
     * @param num 对应的数字
     * @return 返回该数字的中文描述 如123返回：壹贰叁；06返回：零陆；1978返回壹玖柒扒
     */
    public static String getBigCNStringOfNumber(String num) {
        String reStr = "";
        String numStr = num.trim();
        int length = numStr.length();
        for (int i = 0; i < length; i++) {
            reStr += getBigCNofNumber(numStr.substring(i, i + 1));
        }
        return reStr;
    }

    /**
     * 返回一个数字串的口读时的小写中文值读法对应的中文字符串，如<p>
     * 32返回三十二,2022211102返回：二十亿二千二百二十一万一千一百零二
     *
     * @param num 要处理的数字串，所代表的数字只能为java int 型范围（10位长度）
     * @return 返回一个数字串的口读时的小写中文值读法对应的中文字符串, <p>
     * 如32返回三十二,2022211102返回：二十亿二千二百二十一万一千一百零二
     */
    protected static String getReadCNStringOfNumber(String num) {
        num = num.trim();
        String reStr = "";
        int numI = Integer.parseInt(num);
        num = String.valueOf(numI);
        int numLength = num.length();
        if (num == null || numLength < 1) {
            throw new IllegalArgumentException("参数不正确");
        }
        switch (numLength) {
            case 1:
                reStr = getCNofNumber(num);
                break;
            case 2:
                if (!num.substring(0, 1).equals("1")) {
                    reStr = getCNofNumber(num.substring(0, 1)) + "十";
                } else {
                    reStr = "十";
                }

                if (!num.substring(1, 2).equals("0")) {
                    reStr += getCNofNumber(num.substring(1, 2));
                }
                break;
            case 3:
                //第一位不为零
                reStr = getCNofNumber(num.substring(0, 1)) + "百";

                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0")) {
                    //第二位为0第三位也为零
                    break;
                } else if (num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0")) {
                    //第二位为0，第三位不为0
                    reStr += "零" + getCNofNumber(num.substring(2, 3));
                    break;
                } else if (!num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0")) {
                    //第二位不为0，第三位不为0
                    reStr += getCNofNumber(num.substring(1, 2)) + "十" + getCNofNumber(num.substring(2, 3));
                    break;
                } else if (!num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0")) {
                    //第二位不为0，第三位为0
                    reStr += getCNofNumber(num.substring(1, 2)) + "十";
                    break;
                }

            case 4:
                //第一位不为0
                reStr = getCNofNumber(num.substring(0, 1)) + "千";
                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位为0，第四位为0
                    break;
                } else if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位为0，第四位不为0
                    reStr += "零" + getCNofNumber(num.substring(3, 4));
                    break;
                } else if (num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位不为0，第四位为0
                    reStr += "零" + getCNofNumber(num.substring(2, 3)) + "十";
                    break;
                } else if (num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位不为0，第四位不为0
                    reStr += "零" + getCNofNumber(num.substring(2, 3)) + "十" + getCNofNumber(num.substring(3, 4));
                    break;
                } else if (!num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位为0，第四位为0
                    reStr += getCNofNumber(num.substring(1, 2)) + "百";
                    break;
                } else if (!num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位为0，第四位不为0
                    reStr += getCNofNumber(num.substring(1, 2)) + "百" + "零" + getCNofNumber(num.substring(3, 4));
                    break;
                } else if (!num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位不为0，第四位为0
                    reStr += getCNofNumber(num.substring(1, 2)) + "百" + getCNofNumber(num.substring(2, 3)) + "十";
                    break;
                } else if (!num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位不为0，第四位不为0
                    reStr += getCNofNumber(num.substring(1, 2)) + "百" + getCNofNumber(num.substring(2, 3)) + "十" + getCNofNumber(num.substring(3, 4));
                    break;
                }
                break;
            case 5:
                String wan = num.substring(0, 1);
                String qian = num.substring(1, 5);
                String bai = num.substring(2, 5);
                String shi = num.substring(3, 5);
                String ge = num.substring(4, 5);

                reStr = getCNofNumber(wan) + "万";
                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0") && num.substring(4, 5).equals("0")) {
                    break;
                } else if (!num.substring(1, 2).equals("0")) {
                    reStr += getReadCNStringOfNumber(qian);
                    break;
                } else {
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += getReadCNStringOfNumber(bai);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "零";
                            reStr += getReadCNStringOfNumber(shi);
                            break;
                        } else {
                            reStr += "零";
                            reStr += getReadCNStringOfNumber(ge);
                            break;
                        }
                    }
                }

            case 6:
                String shiwan = num.substring(0, 1);
                String wan6 = num.substring(1, 6);
                String qian6 = num.substring(2, 6);
                String bai6 = num.substring(3, 6);
                String shi6 = num.substring(4, 6);
                String ge6 = num.substring(5, 6);

                reStr = getCNofNumber(shiwan) + "十";
                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0") && num.substring(4, 5).equals("0") && num.substring(5, 6).equals("0")) {
                    reStr += "万";
                    break;
                } else if (!num.substring(1, 2).equals("0")) {
                    reStr += getReadCNStringOfNumber(wan6);
                    break;
                } else {
                    reStr += "万";
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += getReadCNStringOfNumber(qian6);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "零";
                            reStr += getReadCNStringOfNumber(bai6);
                            break;
                        } else if (!num.substring(4, 5).equals("0")) {
                            reStr += "零";
                            reStr += getReadCNStringOfNumber(shi6);
                            break;
                        } else {
                            reStr += "零";
                            reStr += getReadCNStringOfNumber(ge6);
                            break;
                        }
                    }
                }

            case 7:
                String baiwan = num.substring(0, 1);
                String shiwan7 = num.substring(1, 7);
                String wan7 = num.substring(2, 7);
                String qian7 = num.substring(3, 7);
                String bai7 = num.substring(4, 7);
                String shi7 = num.substring(5, 7);
                String ge7 = num.substring(6, 7);

                reStr = getCNofNumber(baiwan) + "";
                if (num.substring(1, 2).equals("0")
                        && num.substring(2, 3).equals("0")
                        && num.substring(3, 4).equals("0")
                        && num.substring(4, 5).equals("0")
                        && num.substring(5, 6).equals("0")
                        && num.substring(6, 7).equals("0")) {
                    reStr += "百万";
                    break;
                } else if (!num.substring(1, 2).equals("0")) {
                    reStr += "百";
                    reStr += getReadCNStringOfNumber(shiwan7);
                    break;
                } else {
                    reStr += "百";
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += "零";
                        reStr += getReadCNStringOfNumber(wan7);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "万零";
                            reStr += getReadCNStringOfNumber(qian7);
                            break;
                        } else if (!num.substring(4, 5).equals("0")) {
                            reStr += "万零";
                            reStr += getReadCNStringOfNumber(bai7);
                            break;
                        } else if (!num.substring(5, 6).equals("0")) {
                            reStr += "万零";
                            reStr += getReadCNStringOfNumber(shi7);
                            break;
                        } else {
                            reStr += "万零";
                            reStr += getReadCNStringOfNumber(ge7);
                            break;
                        }
                    }
                }

            case 8:
                String left = num.substring(0, 4);
                String qian8 = num.substring(4, 5);
                String bai8 = num.substring(5, 6);
                String shi8 = num.substring(6, 7);
                String ge8 = num.substring(7, 8);
                String right = num.substring(4, 8);
                reStr = getReadCNStringOfNumber(left) + "万";
                if (qian8.equals("0") && bai8.equals("0") && shi8.equals("0") && ge8.equals("0")) {
                    break;
                } else {
                    if (!qian8.equals("0")) {
                        reStr += getReadCNStringOfNumber(right);
                        break;
                    } else {
                        if (!bai8.equals("0")) {
                            reStr += "零";
                            reStr += getReadCNStringOfNumber(num.substring(5, 8));
                            break;
                        } else {
                            if (!shi8.equals("0")) {
                                reStr += "零";
                                reStr += getReadCNStringOfNumber(num.substring(6, 8));
                                break;
                            } else {
                                reStr += "零";
                                reStr += getReadCNStringOfNumber(num.substring(7, 8));
                                break;
                            }
                        }
                    }
                }

            case 9:
                reStr = getReadCNStringOfNumber(num.substring(0, 1)) + "亿";
                String middle9 = num.substring(1);
                String right9 = num.substring(5);

                if (num.substring(1).equals("00000000")) {
                    break;
                } else {
                    if (!num.substring(1, 2).equals("0")) {
                        reStr += getReadCNStringOfNumber(middle9);
                        break;
                    } else {
                        if (!num.substring(2, 3).equals("0")) {
                            reStr += "零";
                            reStr += getReadCNStringOfNumber(num.substring(2, 5));
                            break;
                        } else {
                            if (!num.substring(3, 4).equals("0")) {
                                reStr += "零";
                                reStr += getReadCNStringOfNumber(num.substring(3, 5));
                                break;
                            } else {
                                if (!num.substring(4, 5).equals("0")) {
                                    reStr += "零";
                                    reStr += getReadCNStringOfNumber(num.substring(4, 5));
                                    break;
                                } else {
                                    if (!num.substring(5, 6).equals("0")) {
                                        reStr += "零";
                                        reStr += getReadCNStringOfNumber(right9);
                                        break;
                                    } else {
                                        if (!num.substring(6, 7).equals("0")) {
                                            reStr += "零";
                                            reStr += getReadCNStringOfNumber(num.substring(6, 9));
                                            break;
                                        } else {
                                            if (!num.substring(7, 8).equals("0")) {
                                                reStr += "零";
                                                reStr += getReadCNStringOfNumber(num.substring(7, 9));
                                                break;
                                            } else {
                                                if (!num.substring(8, 9).equals("0")) {
                                                    reStr += "零";
                                                    reStr += getReadCNStringOfNumber(num.substring(8));
                                                    break;
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }

                }

            case 10:
                reStr = getReadCNStringOfNumber(num.substring(0, 2)) + "亿";
                String middle10 = num.substring(2);
                String right10 = num.substring(6);

                if (num.substring(2).equals("000000000")) {
                    break;
                } else {
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += getReadCNStringOfNumber(middle10);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "零";
                            reStr += getReadCNStringOfNumber(num.substring(3, 6));
                            break;
                        } else {
                            if (!num.substring(4, 5).equals("0")) {
                                reStr += "零";
                                reStr += getReadCNStringOfNumber(num.substring(4, 6));
                                break;
                            } else {
                                if (!num.substring(5, 6).equals("0")) {
                                    reStr += "零";
                                    reStr += getReadCNStringOfNumber(num.substring(5, 6));
                                    break;
                                } else {
                                    if (!num.substring(6, 7).equals("0")) {
                                        reStr += "零";
                                        reStr += getReadCNStringOfNumber(right10);
                                        break;
                                    } else {
                                        if (!num.substring(7, 8).equals("0")) {
                                            reStr += "零";
                                            reStr += getReadCNStringOfNumber(num.substring(7, 10));
                                            break;
                                        } else {
                                            if (!num.substring(8, 9).equals("0")) {
                                                reStr += "零";
                                                reStr += getReadCNStringOfNumber(num.substring(8, 10));
                                                break;
                                            } else {
                                                if (!num.substring(9, 10).equals("0")) {
                                                    reStr += "零";
                                                    reStr += getReadCNStringOfNumber(num.substring(9));
                                                    break;
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }

                }

        }

        return reStr;

    }

    /**
     * 返回一个数字串的口读时的小写中文值读法对应的中文字符串，如:<p>
     * 32返回三十二,2022211102返回：二十亿二千二百二十一万一千一百零二
     *
     * @param num 要处理的数字串，整型值(int)
     * @return 返回一个数字串的口读时的小写中文值读法对应的中文字符串，<p>
     * 如32返回三十二,2022211102返回：二十亿二千二百二十一万一千一百零二
     * @deprecated 此方法还有待完善
     */
    protected static String getReadCNStringOfNumber(int num) {
        return getReadCNStringOfNumber(String.valueOf(num));
    }

    /**
     * 返回一个数字串的金钱书写时的大写中文值写法对应的中文字符串，以满足中国写金钱的习愦,<p>
     * 如32:返回叁拾贰,256返回：贰佰伍拾陆,2005返回：贰仟零佰零拾伍,54005返回：伍万肆仟零佰零拾伍
     *
     * @param num 要处理的数字串，所代表的数字只能为java int 型范围（10位长度）
     * @return 返回一个数字串的金钱书写时的大写中文值写法对应的中文字符串，以满足中国写金钱的习愦,<p>
     * 如32:返回叁拾贰,256返回:贰佰伍拾陆,2005返回：贰仟零佰零拾伍,54005返回：伍万肆仟零佰零拾伍
     * @deprecated 此方法还有待完善
     */
    protected static String getReadMoneyCNStringOfNumber(String num) {
        num = num.trim();
        String reStr = "";
        int numI = Integer.parseInt(num);
        num = String.valueOf(numI);
        int numLength = num.length();

        if (num == null || numLength < 1)
            return "";
        switch (numLength) {
            case 1:
                reStr = getBigCNofNumber(num);
                break;
            case 2:

                reStr = getBigCNofNumber(num.substring(0, 1)) + "拾";

                if (!num.substring(1, 2).equals("0")) {
                    reStr += getBigCNofNumber(num.substring(1, 2));
                }
                break;
            case 3:
                //第一位不为零
                reStr = getBigCNofNumber(num.substring(0, 1)) + "佰";

                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0")) {
                    //第二位为0第三位也为零
                    reStr += "零拾零";
                    break;
                } else if (num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0")) {
                    //第二位为0，第三位不为0
                    reStr += "零拾" + getBigCNofNumber(num.substring(2, 3));
                    break;
                } else if (!num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0")) {
                    //第二位不为0，第三位不为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "拾" + getBigCNofNumber(num.substring(2, 3));
                    break;
                } else if (!num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0")) {
                    //第二位不为0，第三位为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "拾零";
                    break;
                }

            case 4:
                //第一位不为0
                reStr = getBigCNofNumber(num.substring(0, 1)) + "仟";
                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位为0，第四位为0
                    reStr += "零佰零拾零";
                    break;
                } else if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位为0，第四位不为0
                    reStr += "零佰零拾" + getBigCNofNumber(num.substring(3, 4));
                    break;
                } else if (num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位不为0，第四位为0
                    reStr += "零佰" + getBigCNofNumber(num.substring(2, 3)) + "拾零";
                    break;
                } else if (num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位不为0，第四位不为0
                    reStr += "零佰" + getBigCNofNumber(num.substring(2, 3)) + "拾" + getBigCNofNumber(num.substring(3, 4));
                    break;
                } else if (!num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位为0，第四位为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "佰零拾零";
                    break;
                } else if (!num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位为0，第四位不为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "佰" + "零拾" + getBigCNofNumber(num.substring(3, 4));
                    break;
                } else if (!num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位不为0，第四位为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "佰" + getBigCNofNumber(num.substring(2, 3)) + "拾零";
                    break;
                } else if (!num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位不为0，第四位不为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "佰" + getBigCNofNumber(num.substring(2, 3)) + "拾" + getBigCNofNumber(num.substring(3, 4));
                    break;
                }
                break;
            case 5:
                String wan = num.substring(0, 1);
                String qian = num.substring(1, 5);
                String bai = num.substring(2, 5);
                String shi = num.substring(3, 5);
                String ge = num.substring(4, 5);

                reStr = getBigCNofNumber(wan) + "万";
                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0") && num.substring(4, 5).equals("0")) {
                    reStr += "零仟零佰零拾零";
                    break;
                } else if (!num.substring(1, 2).equals("0")) {
                    reStr += getReadMoneyCNStringOfNumber(qian);
                    break;
                } else {
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += "零仟" + getReadMoneyCNStringOfNumber(bai);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "零仟零佰";
                            reStr += getReadMoneyCNStringOfNumber(shi);
                            break;
                        } else {
                            reStr += "零仟零佰零拾";
                            reStr += getReadMoneyCNStringOfNumber(ge);
                            break;
                        }
                    }
                }

            case 6:
                String shiwan = num.substring(0, 1);
                String wan6 = num.substring(1, 6);
                String qian6 = num.substring(2, 6);
                String bai6 = num.substring(3, 6);
                String shi6 = num.substring(4, 6);
                String ge6 = num.substring(5, 6);

                reStr = getBigCNofNumber(shiwan) + "拾";
                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0") && num.substring(4, 5).equals("0") && num.substring(5, 6).equals("0")) {
                    reStr += "万零仟零佰零拾零";
                    break;
                } else if (!num.substring(1, 2).equals("0")) {
                    reStr += getReadMoneyCNStringOfNumber(wan6);
                    break;
                } else {
                    reStr += "万";
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += getReadMoneyCNStringOfNumber(qian6);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "零仟";
                            reStr += getReadMoneyCNStringOfNumber(bai6);
                            break;
                        } else if (!num.substring(4, 5).equals("0")) {
                            reStr += "零仟零佰";
                            reStr += getReadMoneyCNStringOfNumber(shi6);
                            break;
                        } else {
                            reStr += "零仟零佰零拾";
                            reStr += getReadMoneyCNStringOfNumber(ge6);
                            break;
                        }
                    }
                }

            case 7:
                String baiwan = num.substring(0, 1);
                String shiwan7 = num.substring(1, 7);
                String wan7 = num.substring(2, 7);
                String qian7 = num.substring(3, 7);
                String bai7 = num.substring(4, 7);
                String shi7 = num.substring(5, 7);
                String ge7 = num.substring(6, 7);

                reStr = getBigCNofNumber(baiwan) + "";
                if (num.substring(1, 2).equals("0")
                        && num.substring(2, 3).equals("0")
                        && num.substring(3, 4).equals("0")
                        && num.substring(4, 5).equals("0")
                        && num.substring(5, 6).equals("0")
                        && num.substring(6, 7).equals("0")) {
                    reStr += "佰万零仟零佰零拾零";
                    break;
                } else if (!num.substring(1, 2).equals("0")) {
                    reStr += "佰";
                    reStr += getReadMoneyCNStringOfNumber(shiwan7);
                    break;
                } else {
                    reStr += "佰";
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += "零";
                        reStr += getReadMoneyCNStringOfNumber(wan7);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "万";
                            reStr += getReadMoneyCNStringOfNumber(qian7);
                            break;
                        } else if (!num.substring(4, 5).equals("0")) {
                            reStr += "万零仟";
                            reStr += getReadMoneyCNStringOfNumber(bai7);
                            break;
                        } else if (!num.substring(5, 6).equals("0")) {
                            reStr += "万零仟零佰";
                            reStr += getReadMoneyCNStringOfNumber(shi7);
                            break;
                        } else {
                            reStr += "万零零仟零佰零拾";
                            reStr += getReadMoneyCNStringOfNumber(ge7);
                            break;
                        }
                    }
                }

            case 8:
                String left = num.substring(0, 4);
                String qian8 = num.substring(4, 5);
                String bai8 = num.substring(5, 6);
                String shi8 = num.substring(6, 7);
                String ge8 = num.substring(7, 8);
                String right = num.substring(4, 8);

                reStr = getReadBigCNStringOfNumber(left) + "万";

                if (qian8.equals("0") && bai8.equals("0") && shi8.equals("0") && ge8.equals("0")) {
                    reStr += "零仟零佰零拾零";
                    break;
                } else {
                    if (!qian8.equals("0")) {
                        reStr += getReadMoneyCNStringOfNumber(right);
                        break;
                    } else {
                        if (!bai8.equals("0")) {
                            reStr += "零仟";
                            reStr += getReadMoneyCNStringOfNumber(num.substring(5, 8));
                            break;
                        } else {
                            if (!shi8.equals("0")) {
                                reStr += "零仟零佰";
                                reStr += getReadMoneyCNStringOfNumber(num.substring(6, 8));
                                break;
                            } else {
                                reStr += "零仟零佰零拾";
                                reStr += getReadMoneyCNStringOfNumber(num.substring(7, 8));
                                break;
                            }
                        }
                    }
                }

            case 9:
                reStr = getReadMoneyCNStringOfNumber(num.substring(0, 1)) + "亿";
                String middle9 = num.substring(1);
                String right9 = num.substring(5);

                if (num.substring(1).equals("00000000")) {
                    reStr += "零万零仟零佰零拾零";
                    break;
                } else {
                    if (!num.substring(1, 2).equals("0")) {
                        reStr += getReadMoneyCNStringOfNumber(middle9);
                        break;
                    } else {
                        if (!num.substring(2, 3).equals("0")) {
                            reStr += getReadMoneyCNStringOfNumber(num.substring(2, 5));
                            break;
                        } else {
                            if (!num.substring(3, 4).equals("0")) {
                                reStr += getReadMoneyCNStringOfNumber(num.substring(3, 5));
                                break;
                            } else {
                                if (!num.substring(4, 5).equals("0")) {
                                    reStr += getReadMoneyCNStringOfNumber(num.substring(4, 5));
                                    break;
                                } else {
                                    if (!num.substring(5, 6).equals("0")) {
                                        reStr += "零万";
                                        reStr += getReadMoneyCNStringOfNumber(right9);
                                        break;
                                    } else {
                                        if (!num.substring(6, 7).equals("0")) {
                                            reStr += "零万零仟";
                                            reStr += getReadMoneyCNStringOfNumber(num.substring(6, 9));
                                            break;
                                        } else {
                                            if (!num.substring(7, 8).equals("0")) {
                                                reStr += "零万零仟零佰";
                                                reStr += getReadMoneyCNStringOfNumber(num.substring(7, 9));
                                                break;
                                            } else {
                                                if (!num.substring(8, 9).equals("0")) {
                                                    reStr += "零万零仟零佰零拾";
                                                    reStr += getReadMoneyCNStringOfNumber(num.substring(8));
                                                    break;
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }

                }

            case 10:
                reStr = getReadMoneyCNStringOfNumber(num.substring(0, 2)) + "亿";
                String middle10 = num.substring(2);
                String right10 = num.substring(6);

                if (num.substring(2).equals("000000000")) {
                    reStr += "零万零仟零佰零拾零";
                    break;
                } else {
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += getReadMoneyCNStringOfNumber(middle10);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            //reStr += "零";
                            reStr += getReadMoneyCNStringOfNumber(num.substring(3, 6));
                            break;
                        } else {
                            if (!num.substring(4, 5).equals("0")) {
                                //reStr += "零";
                                reStr += getReadMoneyCNStringOfNumber(num.substring(4, 6));
                                break;
                            } else {
                                if (!num.substring(5, 6).equals("0")) {
                                    //reStr += "零";
                                    reStr += getReadMoneyCNStringOfNumber(num.substring(5, 6));
                                    break;
                                } else {
                                    if (!num.substring(6, 7).equals("0")) {
                                        reStr += "零万";
                                        reStr += getReadMoneyCNStringOfNumber(right10);
                                        break;
                                    } else {
                                        if (!num.substring(7, 8).equals("0")) {
                                            reStr += "零万零仟";
                                            reStr += getReadMoneyCNStringOfNumber(num.substring(7, 10));
                                            break;
                                        } else {
                                            if (!num.substring(8, 9).equals("0")) {
                                                reStr += "零万零仟零佰";
                                                reStr += getReadMoneyCNStringOfNumber(num.substring(8, 10));
                                                break;
                                            } else {
                                                if (!num.substring(9, 10).equals("0")) {
                                                    reStr += "零万零仟零佰零拾";
                                                    reStr += getReadMoneyCNStringOfNumber(num.substring(9));
                                                    break;
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }

                }

        }

        return reStr;

    }

    /**
     * 返回一个数字串的金钱书写时的大写中文值写法对应的中文字符串，以满足中国写金钱的习愦,<p>
     * 如32:返回叁拾贰,256返回:贰佰伍拾陆,2005返回：贰仟零佰零拾伍,54005返回：伍万肆仟零佰零拾伍
     *
     * @param num 要处理的数字，int型
     * @return 返回一个数字串的金钱书写时的大写中文值写法对应的中文字符串，以满足中国写金钱的习愦,<p>
     * 如32:返回叁拾贰,256返回:贰佰伍拾陆,2005返回：贰仟零佰零拾伍,54005返回：伍万肆仟零佰零拾伍
     * @deprecated 此方法还有待完善
     */
    protected static String getReadMoneyCNStringOfNumber(int num) {
        return getReadMoneyCNStringOfNumber(String.valueOf(num));

    }


    /**
     * 返回一个数字字符串的口读时的大写中文值读法对应的中文书写字符串，如:"11"返回：拾壹;"5505"返回：伍仟伍佰零伍
     *
     * @param num 对应的数字串
     * @return 返回一个数字字符串的口读时的大写中文值读法对应的中文书写字符串，如:"11"返回：拾壹;"5505"返回：伍仟伍佰零伍
     * @deprecated 此方法还有待完善
     */
    protected static String getReadBigCNStringOfNumber(String num) {
        num = num.trim();
        String reStr = "";
        int numI = Integer.parseInt(num);
        num = String.valueOf(numI);
        int numLength = num.length();
        if (num == null || numLength < 1)
            return "";
        switch (numLength) {
            case 1:
                reStr = getBigCNofNumber(num);
                break;
            case 2:
                if (!num.substring(0, 1).equals("1")) {
                    reStr = getBigCNofNumber(num.substring(0, 1)) + "拾";
                } else {
                    reStr = "拾";
                }

                if (!num.substring(1, 2).equals("0")) {
                    reStr += getBigCNofNumber(num.substring(1, 2));
                }
                break;
            case 3:
                //第一位不为零
                reStr = getBigCNofNumber(num.substring(0, 1)) + "佰";

                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0")) {
                    //第二位为0第三位也为零
                    break;
                } else if (num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0")) {
                    //第二位为0，第三位不为0
                    reStr += "零" + getBigCNofNumber(num.substring(2, 3));
                    break;
                } else if (!num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0")) {
                    //第二位不为0，第三位不为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "拾" + getBigCNofNumber(num.substring(2, 3));
                    break;
                } else if (!num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0")) {
                    //第二位不为0，第三位为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "拾";
                    break;
                }

            case 4:
                //第一位不为0
                reStr = getBigCNofNumber(num.substring(0, 1)) + "仟";
                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位为0，第四位为0
                    break;
                } else if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位为0，第四位不为0
                    reStr += "零" + getBigCNofNumber(num.substring(3, 4));
                    break;
                } else if (num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位不为0，第四位为0
                    reStr += "零" + getBigCNofNumber(num.substring(2, 3)) + "拾";
                    break;
                } else if (num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位为0，第三位不为0，第四位不为0
                    reStr += "零" + getBigCNofNumber(num.substring(2, 3)) + "拾" + getBigCNofNumber(num.substring(3, 4));
                    break;
                } else if (!num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位为0，第四位为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "佰";
                    break;
                } else if (!num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位为0，第四位不为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "佰" + "零" + getBigCNofNumber(num.substring(3, 4));
                    break;
                } else if (!num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位不为0，第四位为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "佰" + getBigCNofNumber(num.substring(2, 3)) + "拾";
                    break;
                } else if (!num.substring(1, 2).equals("0") && !num.substring(2, 3).equals("0") && !num.substring(3, 4).equals("0")) {
                    //第二位不为0，第三位不为0，第四位不为0
                    reStr += getBigCNofNumber(num.substring(1, 2)) + "佰" + getBigCNofNumber(num.substring(2, 3)) + "拾" + getBigCNofNumber(num.substring(3, 4));
                    break;
                }
                break;
            case 5:
                String wan = num.substring(0, 1);
                String qian = num.substring(1, 5);
                String bai = num.substring(2, 5);
                String shi = num.substring(3, 5);
                String ge = num.substring(4, 5);

                reStr = getBigCNofNumber(wan) + "万";
                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0") && num.substring(4, 5).equals("0")) {
                    break;
                } else if (!num.substring(1, 2).equals("0")) {
                    reStr += getReadBigCNStringOfNumber(qian);
                    break;
                } else {
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += getReadBigCNStringOfNumber(bai);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "零";
                            reStr += getReadBigCNStringOfNumber(shi);
                            break;
                        } else {
                            reStr += "零";
                            reStr += getReadBigCNStringOfNumber(ge);
                            break;
                        }
                    }
                }

            case 6:
                String shiwan = num.substring(0, 1);
                String wan6 = num.substring(1, 6);
                String qian6 = num.substring(2, 6);
                String bai6 = num.substring(3, 6);
                String shi6 = num.substring(4, 6);
                String ge6 = num.substring(5, 6);

                reStr = getBigCNofNumber(shiwan) + "拾";
                if (num.substring(1, 2).equals("0") && num.substring(2, 3).equals("0") && num.substring(3, 4).equals("0") && num.substring(4, 5).equals("0") && num.substring(5, 6).equals("0")) {
                    reStr += "万";
                    break;
                } else if (!num.substring(1, 2).equals("0")) {
                    reStr += getReadBigCNStringOfNumber(wan6);
                    break;
                } else {
                    reStr += "万";
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += getReadBigCNStringOfNumber(qian6);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "零";
                            reStr += getReadBigCNStringOfNumber(bai6);
                            break;
                        } else if (!num.substring(4, 5).equals("0")) {
                            reStr += "零";
                            reStr += getReadBigCNStringOfNumber(shi6);
                            break;
                        } else {
                            reStr += "零";
                            reStr += getReadBigCNStringOfNumber(ge6);
                            break;
                        }
                    }
                }

            case 7:
                String baiwan = num.substring(0, 1);
                String shiwan7 = num.substring(1, 7);
                String wan7 = num.substring(2, 7);
                String qian7 = num.substring(3, 7);
                String bai7 = num.substring(4, 7);
                String shi7 = num.substring(5, 7);
                String ge7 = num.substring(6, 7);

                reStr = getBigCNofNumber(baiwan) + "";
                if (num.substring(1, 2).equals("0")
                        && num.substring(2, 3).equals("0")
                        && num.substring(3, 4).equals("0")
                        && num.substring(4, 5).equals("0")
                        && num.substring(5, 6).equals("0")
                        && num.substring(6, 7).equals("0")) {
                    reStr += "佰万";
                    break;
                } else if (!num.substring(1, 2).equals("0")) {
                    reStr += "佰";
                    reStr += getReadBigCNStringOfNumber(shiwan7);
                    break;
                } else {
                    reStr += "佰";
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += "零";
                        reStr += getReadBigCNStringOfNumber(wan7);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "万零";
                            reStr += getReadBigCNStringOfNumber(qian7);
                            break;
                        } else if (!num.substring(4, 5).equals("0")) {
                            reStr += "万零";
                            reStr += getReadBigCNStringOfNumber(bai7);
                            break;
                        } else if (!num.substring(5, 6).equals("0")) {
                            reStr += "万零";
                            reStr += getReadBigCNStringOfNumber(shi7);
                            break;
                        } else {
                            reStr += "万零";
                            reStr += getReadBigCNStringOfNumber(ge7);
                            break;
                        }
                    }
                }

            case 8:
                String left = num.substring(0, 4);
                String qian8 = num.substring(4, 5);
                String bai8 = num.substring(5, 6);
                String shi8 = num.substring(6, 7);
                String ge8 = num.substring(7, 8);
                String right = num.substring(4, 8);
                reStr = getReadBigCNStringOfNumber(left) + "万";
                if (qian8.equals("0") && bai8.equals("0") && shi8.equals("0") && ge8.equals("0")) {
                    break;
                } else {
                    if (!qian8.equals("0")) {
                        reStr += getReadBigCNStringOfNumber(right);
                        break;
                    } else {
                        if (!bai8.equals("0")) {
                            reStr += "零";
                            reStr += getReadBigCNStringOfNumber(num.substring(5, 8));
                            break;
                        } else {
                            if (!shi8.equals("0")) {
                                reStr += "零";
                                reStr += getReadBigCNStringOfNumber(num.substring(6, 8));
                                break;
                            } else {
                                reStr += "零";
                                reStr += getReadBigCNStringOfNumber(num.substring(7, 8));
                                break;
                            }
                        }
                    }
                }

            case 9:
                reStr = getReadBigCNStringOfNumber(num.substring(0, 1)) + "亿";
                String middle9 = num.substring(1);
                String right9 = num.substring(5);

                if (num.substring(1).equals("00000000")) {
                    break;
                } else {
                    if (!num.substring(1, 2).equals("0")) {
                        reStr += getReadBigCNStringOfNumber(middle9);
                        break;
                    } else {
                        if (!num.substring(2, 3).equals("0")) {
                            reStr += "零";
                            reStr += getReadBigCNStringOfNumber(num.substring(2, 5));
                            break;
                        } else {
                            if (!num.substring(3, 4).equals("0")) {
                                reStr += "零";
                                reStr += getReadBigCNStringOfNumber(num.substring(3, 5));
                                break;
                            } else {
                                if (!num.substring(4, 5).equals("0")) {
                                    reStr += "零";
                                    reStr += getReadBigCNStringOfNumber(num.substring(4, 5));
                                    break;
                                } else {
                                    if (!num.substring(5, 6).equals("0")) {
                                        reStr += "零";
                                        reStr += getReadBigCNStringOfNumber(right9);
                                        break;
                                    } else {
                                        if (!num.substring(6, 7).equals("0")) {
                                            reStr += "零";
                                            reStr += getReadBigCNStringOfNumber(num.substring(6, 9));
                                            break;
                                        } else {
                                            if (!num.substring(7, 8).equals("0")) {
                                                reStr += "零";
                                                reStr += getReadBigCNStringOfNumber(num.substring(7, 9));
                                                break;
                                            } else {
                                                if (!num.substring(8, 9).equals("0")) {
                                                    reStr += "零";
                                                    reStr += getReadBigCNStringOfNumber(num.substring(8));
                                                    break;
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }

                }

            case 10:
                reStr = getReadBigCNStringOfNumber(num.substring(0, 2)) + "亿";
                String middle10 = num.substring(2);
                String right10 = num.substring(6);

                if (num.substring(2).equals("000000000")) {
                    break;
                } else {
                    if (!num.substring(2, 3).equals("0")) {
                        reStr += getReadBigCNStringOfNumber(middle10);
                        break;
                    } else {
                        if (!num.substring(3, 4).equals("0")) {
                            reStr += "零";
                            reStr += getReadBigCNStringOfNumber(num.substring(3, 6));
                            break;
                        } else {
                            if (!num.substring(4, 5).equals("0")) {
                                reStr += "零";
                                reStr += getReadBigCNStringOfNumber(num.substring(4, 6));
                                break;
                            } else {
                                if (!num.substring(5, 6).equals("0")) {
                                    reStr += "零";
                                    reStr += getReadBigCNStringOfNumber(num.substring(5, 6));
                                    break;
                                } else {
                                    if (!num.substring(6, 7).equals("0")) {
                                        reStr += "零";
                                        reStr += getReadBigCNStringOfNumber(right10);
                                        break;
                                    } else {
                                        if (!num.substring(7, 8).equals("0")) {
                                            reStr += "零";
                                            reStr += getReadBigCNStringOfNumber(num.substring(7, 10));
                                            break;
                                        } else {
                                            if (!num.substring(8, 9).equals("0")) {
                                                reStr += "零";
                                                reStr += getReadBigCNStringOfNumber(num.substring(8, 10));
                                                break;
                                            } else {
                                                if (!num.substring(9, 10).equals("0")) {
                                                    reStr += "零";
                                                    reStr += getReadBigCNStringOfNumber(num.substring(9));
                                                    break;
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }

                }

        }

        return reStr;

    }

    /**
     * 返回一个数字字符串的口读时的大写中文值读法对应的中文书写字符串，如:11返回：拾壹;5505返回：伍仟伍佰零伍
     *
     * @param num 对应的数字
     * @return 返回一个数字字符串的口读时的大写中文值读法对应的中文书写字符串，如:11返回：拾壹;5505返回：伍仟伍佰零伍
     * @deprecated 此方法还有待完善
     */
    protected static String getReadBigCNStringOfNumber(int num) {
        return getReadBigCNStringOfNumber(String.valueOf(num));

    }

    /**
     * 将给定的一个数字格式化成为中国风格的金钱大写格式;如11.26返回：壹拾壹圆贰角陆分整；3005,返回：三仟零佰零拾伍圆整，3005.00返回：三仟零佰零拾伍圆零角零分整
     *
     * @param num 被格式化的数字
     * @return 返回被格式化后的字符串;如11.26返回：壹拾壹圆贰角陆分整；3005,返回：三仟零佰零拾伍圆整，3005.00返回：三仟零佰零拾伍圆零角零分整
     * @deprecated 此方法还有待完善
     */
    protected static String getCNMoneyStringOfNumber(double num) {

        int pointPos = String.valueOf(num).indexOf(".");//是否包含小数点

        String numStr = formatNumber(num, NUMBER_IN_2_0);//格式化成只有两位有效数字
//		int numLen = numStr.trim().length();
        int pos = numStr.indexOf(".");

        String reStr = "";
        String intPart = numStr.substring(0, pos);
        String floatPart1 = numStr.substring(pos + 1, pos + 2);

        String floatPart2 = numStr.substring(pos + 2);
        String bigCNStr = getReadMoneyCNStringOfNumber(intPart);

        reStr = bigCNStr + "圆";

        if (pointPos == -1) {
            //给出的值就没有小数的情况
            reStr += "整";

        } else {

            reStr += getBigCNofNumber(floatPart1) + "角";
            reStr += getBigCNofNumber(floatPart2) + "分";

        }

        return reStr;
    }
}