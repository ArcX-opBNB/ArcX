package net.daylong.baselibrary.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

import net.daylong.baselibrary.utils.sys.AppUtil;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isNull(String... str) {
        String[] clone = str.clone();

        for (String s : clone) {
            if (!TextUtils.isEmpty(s)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param str
     * @returnCardRankingNumTextView
     */
    public static boolean isOrNull(String... str) {
        String[] clone = str.clone();
        for (String s : clone) {
            if (TextUtils.isEmpty(s)) {
                return true;
            }
        }
        return false;
    }

    /**

     */
    public static boolean isEmpty(String value) {
        return !(value != null && !"".equalsIgnoreCase(value.trim())
                && !"null".equalsIgnoreCase(value.trim()));
    }

    /**

     *


     */
    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**

     *


     */
    public static boolean isNubAndDot(String str) {
        return str.matches("\\d+(\\.\\d+)?");
    }

    /**

     *


     */
    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;
        String expression = "^1[3|4|5|6|7|8|9]\\d{9}$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**

     *



     */
    public static boolean isPhoneNumberValid(String areaCode, String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) {
            return false;
        }

        if (phoneNumber.length() < 5) {
            return false;
        }

        if (TextUtils.equals(areaCode, "+86") || TextUtils.equals(areaCode, "86")) {
            return isPhoneNumberValid(phoneNumber);
        }

        boolean isValid = false;
        String expression = "^[0-9]*$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**

     *



     */
    public static boolean isPhoneFormat(String areaCode, String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) {
            return false;
        }

        if (phoneNumber.length() < 7) {
            return false;
        }

        boolean isValid = false;
        String expression = "^[0-9]*$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**

     *
     * @param email email

     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(" +
                "([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**

     *
     * @param charaString
     * @return
     */
    public static boolean isEnglish(String charaString) {
        return charaString.matches("^[a-zA-Z]*");

    }

    public static String numForK(int coin) {


        if (coin >= 1000) {
            String s = Utils.floatToString2((coin * 1.0f) / 1000);
            String[] split = s.split("\\.");
            if (Integer.parseInt(split[1]) == 0) {
                s = split[0];
            }
            return s + "K";

        }
        return String.valueOf(coin);


    }

    /**

     *
     * @param number
     * @return
     */
    public static String numFormatDot(long number) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(number);
    }

    /**

     *
     * @param number
     * @return
     */
    public static String numFormatDot(double number) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(number);
    }

    /**

     *
     * @param coin
     * @return
     */
    public static String getCoinNum(int coin) {

        if (coin >= 1000 && coin < 1000000) {
            String s = Utils.floatToString2((coin * 1.0f) / 1000);
            String[] split = s.split("\\.");
            if (Integer.parseInt(split[1]) == 0) {
                s = split[0];
            }
            return s + "K";

        } else if (coin >= 1000000) {
            String s = Utils.floatToString2((coin * 1.0f) / 1000000);
            String[] split = s.split("\\.");
            if (Integer.parseInt(split[1]) == 0) {
                s = split[0];
            }
            return s + "M";
        }
        return String.valueOf(coin);

    }

    /**

     *
     * @param coin
     * @return
     */
    public static String getCoinNum(long coin) {

        if (coin >= 1000 && coin < 1000000) {
            String s = Utils.floatToString2((coin * 1.0f) / 1000);
            String[] split = s.split("\\.");
            if (Integer.parseInt(split[1]) == 0) {
                s = split[0];
            }
            return s + "K";

        } else if (coin >= 1000000 && coin < 100000000) {
            String s = Utils.floatToString2((coin * 1.0f) / 1000000);
            String[] split = s.split("\\.");
            if (Integer.parseInt(split[1]) == 0) {
                s = split[0];
            }
            return s + "M";
        } else if (coin >= 100000000) {
            String s = Utils.floatToString2((coin * 1.0f) / 100000000);
            String[] split = s.split("\\.");
            if (Integer.parseInt(split[1]) == 0) {
                s = split[0];
            }
            return s + "B";
        }
        return String.valueOf(coin);

    }

    public static long getIdByImID(String imId) {
        String userId = imId.substring(6);
        return Long.parseLong(userId);
    }

    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            
            char c = string.charAt(i);
            if (c < 0x20 || c > 0x7E) {
                
                String tmp = Integer.toHexString(c);
                if (tmp.length() >= 4) {
                    unicode.append("\\u" + Integer.toHexString(c));
                } else if (tmp.length() == 3) {
                    unicode.append("\\u0" + Integer.toHexString(c));
                } else if (tmp.length() == 2) {
                    unicode.append("\\u00" + Integer.toHexString(c));
                } else if (tmp.length() == 1) {
                    unicode.append("\\u000" + Integer.toHexString(c));
                } else if (tmp.length() == 3) {
                    unicode.append("\\u0000");
                }
            } else {
                unicode.append(c);
            }
        }
        return unicode.toString();

    }


    public static void copy(String copyStr) {
        ClipboardManager clipboard = (ClipboardManager) AppUtil.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", copyStr);
        clipboard.setPrimaryClip(clip);
    }
}
