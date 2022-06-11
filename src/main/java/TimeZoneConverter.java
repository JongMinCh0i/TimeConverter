import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class TimeZoneConverter {
    private int year = 0;
    private int month = 0;
    private int day = 0;
    private int hour = 0;
    private int min = 0;

    public void setTime(String data) {
        String regex = "^(?<year>\\d{1,4})/(?<month>\\d{1,2})/(?<day>\\d{1,2})/(?<hour>\\d{1,2}):(?<min>\\d{1,2})$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(data);

        if (m.matches()) {
            this.year = Integer.parseInt(m.group("year"));
            this.month = Integer.parseInt(m.group("month"));
            this.day = Integer.parseInt(m.group("day"));
            this.hour = Integer.parseInt(m.group("hour"));
            this.min = Integer.parseInt(m.group("min"));
        }
    }

    public String printOtherCountry(String str) {
        if ("브라질".equals(str)) {
            // 개인처리 내부 메서드 구현
            // 브런치 이름은 개인별 이니셜로 구현
        } else if ("영국".equals(str)) {
            // 개인처리 내부 메서드 구현
            // 브런치 이름은 개인별 이니셜로 구현
        } else if ("터키".equals(str)) {
            // 개인처리 내부 메서드 구현
            // 브런치 이름은 개인별 이니셜로 구현
        } else if ("프랑스".equals(str)) {
            // 개인처리 내부 메서드 구현
            // 브런치 이름은 개인별 이니셜로 구현
        } else if ("미국".equals(str)) {
            // 개인처리 내부 메서드 구현
            // 브런치 이름은 개인별 이니셜로 구현
        }


        return "you must set Time";
    }

    public static void main(String[] args) {
        TimeZoneConverter t = new TimeZoneConverter();
        t.setTime("2022/06/11/13:10");
    }
}