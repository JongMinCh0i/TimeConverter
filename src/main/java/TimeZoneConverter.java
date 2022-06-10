import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.GregorianCalendar;

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

    /**
     * int type의 년, 월, 일, 시, 분을 받아 문자열로 변환 후 정리해 반환합니다.
     * 
     * @param year  출력할 연도
     * @param month 출력할 월
     * @param day   출력할 일
     * @param hour  출력할 시간
     * @param min   출력할 분
     * @return YYYY/MM/DD/HH:MM 형식의 시간을 String으로 반환합니다.
     */
    public String getFormattedTime(int year, int month, int day, int hour,
            int min) {
        String strTime = null;

        String strYear = Integer.toString(year);
        String strMonth = String.format("%02d", month);
        String strDay = String.format("%02d", day);
        String strhour = String.format("%02d", hour);
        String strMin = String.format("%02d", min);

        strTime = strYear + "/" + strMonth + "/" + strDay + "/" + strhour + ":" +
                strMin;
        return strTime;
    }

    public void printOtherCountry(String str) {
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
            GregorianCalendar gc = new GregorianCalendar();
            int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            int convertedYear = 0;
            int convertedMonth = 0;
            int convertedDay = 0;
            int convertedHour = 0;
            int convertedMin = 0;
            int timeDiff = -8;

            summerTimeCalculator stc = new summerTimeCalculator();
            stc.setValue(str);
            if (stc.isSummerTimePeriod(this.year, this.month, this.day, this.hour, this.min)) {
                timeDiff = -7;
            }

            convertedHour = this.hour + timeDiff;

            // 시차를 계산했을 때 그 결과값이 음수면 프랑스는 한국보다 하루 늦음.
            boolean isLateOneDay = (convertedHour < 0);

            // n월 1일에서 하루가 늦으면 n-1월의 마지막 일로 가야함.
            boolean isBeginingOfMonth = (this.day == 1);

            // n월 1일 중 3월 1일은 윤년 여부에 따라 일수를 구분해야함.
            boolean isLeapYearAndMarchFirst = (gc.isLeapYear(this.year) && this.month == 3);

            // 1월 1일인 경우 특별히 전년도 12월의 마지막 일로 가야함.
            boolean isJanuary = (this.month == 1);


            if (isLateOneDay) { // 프랑스가 한국보다 하루 늦는다면
                convertedHour = convertedHour + 24;
                if (!isBeginingOfMonth) { // n월 1일이 아니면 해당 값으로 설정.
                    convertedYear = this.year;
                    convertedMonth = this.month;
                    convertedDay = this.day - 1;
                    convertedMin = this.min;
                } else if (isBeginingOfMonth && !isJanuary) { // n월 1일인 경우(1월 제외)
                    convertedYear = this.year;
                    convertedMonth = this.month - 1;
                    convertedDay = days[convertedMonth];
                    if (isLeapYearAndMarchFirst) { // 윤년이고 3월 1일인 경우, 일수를 29일로 설정.
                        convertedDay = convertedDay + 1;
                    }
                    convertedMin = this.min;
                } else if (isBeginingOfMonth && isJanuary) { // 1월 1일인 경우
                    convertedYear = this.year - 1;
                    convertedMonth = 12;
                    convertedDay = days[12];
                    convertedMin = this.min;
                }
            } else { // 프랑스가 한국과 동일한 일이라면,
                convertedYear = this.year;
                convertedMonth = this.month;
                convertedDay = this.day;
                convertedMin = this.min;
            }

            String strTime = this.getFormattedTime(convertedYear, convertedMonth, convertedDay, convertedHour,
                    convertedMin);
            System.out.println("프랑스: " + strTime);

        } else if ("미국".equals(str)) {
            // 개인처리 내부 메서드 구현
            // 브런치 이름은 개인별 이니셜로 구현
        }
    }

    public static void main(String[] args) {
        TimeZoneConverter t = new TimeZoneConverter();
        t.setTime("2020/03/01/00:00");
        t.printOtherCountry("프랑스");
        /*
         * t.setTime(); : 시간 설정
         * 
         * t.printOtherCountry();
         * ex ) @Param str = "영국" 영국의 시간 출력
         * t.printOtherCountry(영국);
         */
    }
}