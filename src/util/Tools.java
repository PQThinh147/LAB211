package util;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Tools {

    public static Scanner sc = new Scanner(System.in);

    public static boolean getBooleanData(String inpMsg, String errMsg) {
        return (getAnInteger(inpMsg, errMsg, 1, 2) == 1) ? true : false;
    }

    public static int getAnInteger(String inpMsg, String errMsg,
            double lower, double upper) {
        int number;
        do {
            try {
                System.out.print(inpMsg);
                number = Integer.parseInt(sc.nextLine());
                if (number < lower || number > upper) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        } while (true);
    }

    public static String getString(String inputMsg, String errorMsg) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty()) {
                System.err.println(errorMsg);
            } else {
                return str;
            }
        }
    }

    public static double getADouble(String inpMsg, String errMsg,
            double lower, double upper) {
        double number;
        do {
            try {
                System.out.print(inpMsg);
                number = Double.parseDouble(sc.nextLine());
                if (number < lower || number > upper) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.err.println(errMsg);
                System.out.println(errMsg);
            }
        } while (true);
    }

    public static boolean getBooleanDataOfNull(String inpMsg, String errMsg, boolean b) {
        return (getIntegerOfNull(inpMsg, errMsg, 1, 2, (b) ? 1 : 2) == 1) ? true : false;
    }
    
    public static String getStringOfNull(String inpMsg, String str) {
        System.out.print(inpMsg);
        String tmp = sc.nextLine().trim();
        return tmp.equals("") ? str : tmp;
    }

    public static double getDoubleOfNull(String inpMsg, String errMsg,
            double lower, double upper, double number) {
        double d;
        do {
            try {
                System.out.print(inpMsg);
                String tmp = sc.nextLine().trim();
                if (tmp.equals("")) {
                    return number;
                } else {
                    d = Double.parseDouble(tmp);
                    if (d < lower || d > upper) {
                        throw new Exception();
                    }
                    return d;
                }
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        } while (true);
    }

    public static int getIntegerOfNull(String inpMsg, String errMsg,
            int lower, int upper, int number) {
        int d;
        do {
            try {
                System.out.print(inpMsg);
                String tmp = sc.nextLine().trim();
                if (tmp.equals("")) {
                    return number;
                } else {
                    d = Integer.parseInt(tmp);
                    if (d < lower || d > upper) {
                        throw new Exception();
                    }
                    return d;
                }
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        } while (true);
    }
    
    public static boolean getBooleanOfNull(String inpMsg, String errMsg, int number) {
        return (getIntegerOfNull(inpMsg, errMsg, 1, 2, number) == 1) ? true : false;
    }
    
    public static String getDate(String inputMsg) {
        String date;
        do {
            try {
                System.out.print(inputMsg);
                date = sc.nextLine();
                if (Pattern.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|"
                        + "(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))"
                        + "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3"
                        + "(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|"
                        + "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])"
                        + "(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", date)) {
                    return date;
                }
            } catch (Exception ex) {
                System.err.println("Invalid date !!!");
//                System.out.println("Invalid date !!!");
            }
        } while (true);
    }
}
