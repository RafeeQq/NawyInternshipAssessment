import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2 {
    public static String[] transformDateFormat(String[] dates) {
        List<String> result = new ArrayList<>();
        for (String date : dates) {
            if (date.length() == 10 && date.charAt(4) == '/' && date.charAt(7) == '/') {
                String[] parts = date.split("/");
                try {
                    int month = Integer.parseInt(parts[1]);
                    int day = Integer.parseInt(parts[2]);
                    if (1 <= month && month <= 12 && 1 <= day && day <= 31) {
                        result.add(date.replace("/", ""));
                    }
                } catch (NumberFormatException e) {
                }
                ;
            } else if (date.length() == 10 && date.charAt(2) == '/' && date.charAt(5) == '/') {
                String[] parts = date.split("/");
                try {
                    int month = Integer.parseInt(parts[1]);
                    int day = Integer.parseInt(parts[0]);
                    if (1 <= month && month <= 12 && 1 <= day && day <= 31) {
                        result.add(parts[2] + parts[1] + parts[0]);
                    }
                } catch (NumberFormatException e) {
                }
                ;
            } else if (date.length() == 10 && date.charAt(2) == '-' && date.charAt(5) == '-') {
                String[] parts = date.split("-");
                try {
                    int month = Integer.parseInt(parts[0]);
                    int day = Integer.parseInt(parts[1]);
                    if (1 <= month && month <= 12 && 1 <= day && day <= 31) {
                        result.add(parts[2] + parts[0] + parts[1]);
                    }
                } catch (NumberFormatException e) {
                }
                ;
            }
        }
        String[] resultArray = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        String[] dates = { "2012/02/20", "19/12/2016", "11-18-2012", "18-11-2012", "asda/ad/ad" };
        String[] result = transformDateFormat(dates);
        System.out.println(Arrays.toString(result));
        for (String date : result) {
            System.out.println(date);
        }
    }
}