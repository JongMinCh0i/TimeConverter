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
            int t_year = getYear();
            int t_month = getMonth();
            int t_day = getDay();
            int t_hour = getHour() - 6;
            String turkeyTime = " ";
          
            if(getHour() < 6){
                t_hour = 24 + t_hour;
                if(getDay() == 1){
                    if (t_month == 2 || t_month == 4 || t_month == 6 || t_month == 9 || t_month == 11) {
                        t_day = 31;
                        t_month = t_month - 1;
                    } else if (t_month == 5 || t_month == 7 || t_month == 8 || t_month == 10 || t_month == 12) {
                        t_day = 30;
                        t_month = t_month - 1;
                    } else if (t_month == 1) {
                        t_day = 31;
                        t_month = 12;
                        t_year = t_year - 1;
                    } else if(t_month == 3) {
                        t_day = 28;
                        t_month = t_month - 1;
                    }
                }
                else if((t_month == 1 || t_month == 3 || t_month == 5 || t_month == 7 || t_month == 8 || t_month == 10 || t_month == 12) && (t_day > 31 || t_day < 1)){
                    System.out.println("날짜 입력 오류 !! \n입력 월의 날짜는 1~31까지있습니다.");
                }
                else if((t_month == 4 || t_month == 6 || t_month == 9 || t_month == 11) && (t_day > 30 || t_day < 1)){
                    System.out.println("날짜 입력 오류 !! \n입력 월의 날짜는 1~30까지있습니다.");

                }
                else if(t_month == 2 && (t_day > 28 || t_day < 1)){
                    System.out.println("날짜 입력 오류 !! \n입력 월의 날짜는 1~28까지있습니다.");
                }
                else{
                    t_day = t_day - 1;
                }
            }

            turkeyTime = "Turkey :" + t_year + "-" + t_month + "-" + t_day + "," + t_hour + ":" + getMin();

            System.out.println("Input :" + getYear() + "-" + getMonth() + "-" + getDay() + "," + getHour() + ":" + getMin());
            System.out.println(turkeyTime);
          
            return turkeyTime;
        }
        else if ("프랑스".equals(str)) {
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
        t.printOtherCountry("터키");
    }
}