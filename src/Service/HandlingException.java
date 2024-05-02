package Service;

public class HandlingException {

    public HandlingException() {}

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean checkDayInMonth(int day, int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                return (day >= 1 || day <= 31);
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                return (day >= 1 || day <= 30);
            }
            case 2: {
                if(isLeapYear(year)) {
                    return (day >= 1 || day <= 29);
                } else {
                    return (day >=1 || day <= 28);
                }
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isFormatDob(String dob) {
        boolean checkFormat = dob.matches("\\d{2}/\\d{2}/\\d{4}");

        if(!checkFormat) {
            return false;
        }

        String[] dataPart = dob.split("/");

        int castDay = (int) Integer.parseInt(dataPart[0]);
        int castMonth = (int) Integer.parseInt(dataPart[1]);
        int castYear = (int) Integer.parseInt(dataPart[2]);

        if(!checkDayInMonth(castDay, castMonth, castYear)) {
            return false;
        }
        return true;
    }

    public static boolean isFormatPhoneNumber(String phoneNum) {
        String subStr = phoneNum.substring(0, 3);
        return (subStr.equals("090") || subStr.equals("098") || subStr.equals("091") || subStr.equals("031")
                || subStr.equals("035") || subStr.equals("038"));
    }
}
