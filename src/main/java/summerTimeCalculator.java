public class summerTimeCalculator {
    String country;
    int startSundayNumberLimit;
    int endSundayNumberLimit;
    int startMonth;
    int endMonth;
    int startDay;
    int endDay;
    double startHour;
    double endHour;

    public void setValue(String country) {
        this.country = country;
        switch (this.country) {
            case "프랑스":
                this.startSundayNumberLimit = 0;
                this.endSundayNumberLimit = 0;
                this.startMonth = 3;
                this.endMonth = 10;
                this.startHour = 2.0;
                this.endHour = 3.0;
                break;
            case "영국":
                this.startSundayNumberLimit = 0;
                this.endSundayNumberLimit = 0;
                this.startMonth = 3;
                this.endMonth = 10;
                this.startHour = 1.0;
                this.endHour = 2.0;
                break;
            case "미국":
                this.startSundayNumberLimit = 2;
                this.endSundayNumberLimit = 1;
                this.startMonth = 3;
                this.endMonth = 11;
                this.startHour = 2.0;
                this.endHour = 2.0;
                break;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 400) == 0 ? true : ((year % 100 == 0) ? false : ((year % 4 == 0) ? true : false));
    }

    private int getSpecificSunday(int year, int summerTimeMonth, int limit) {
        boolean isRepeatNumber = (limit > 0);
        int counter = 0;
        int specificSunday = 0;
        int totalDays = 0;
        int[] daysOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        for (int i = 1; i < year; i++) {
            if (this.isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        for (int i = 1; i < summerTimeMonth; i++) {
            totalDays += daysOfMonth[i];
        }

        for (int i = 1; i <= daysOfMonth[summerTimeMonth]; i++) {
            totalDays += 1;
            if (totalDays % 7 == 0) {
                specificSunday = i;
                if (isRepeatNumber) {
                    counter = counter + 1;
                    if (counter == limit) {
                        break;
                    }
                }
            }
        }
        return specificSunday;
    }

    public boolean isSummerTimePeriod(int year, int month, int day, int hour, int min) {

        boolean flag = false;
        double hourAndMin = hour + (min / 60.00);

        this.startDay = this.getSpecificSunday(year, this.startMonth, this.startSundayNumberLimit);
        this.endDay = this.getSpecificSunday(year, this.endMonth, this.endSundayNumberLimit);

        if (month > startMonth && month < endMonth) {
            flag = true;
        } else if (month == startMonth) {
            if (day > startDay) {
                flag = true;
            } else if (day == this.startDay) {
                if (hourAndMin >= startHour) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
        } else if (month == endMonth) {
            if (day < endDay) {
                flag = true;
            } else if (day == this.endDay) {
                if (hourAndMin >= endHour) {
                    flag = false;
                } else {
                    flag = true;
                }
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        summerTimeCalculator stc = new summerTimeCalculator();
        stc.setValue("프랑스");
        System.out.println(stc.isSummerTimePeriod(2021, 3, 27, 00, 00));
        stc.setValue("영국");
        System.out.println(stc.isSummerTimePeriod(2021, 3, 28, 1, 59));
        stc.setValue("미국");
        System.out.println(stc.isSummerTimePeriod(2023, 11, 5, 1, 59));
    }
}