import org.assertj.core.api.Assertions;
import org.junit.Test;

// 테스트 코드 작성 x

import static org.assertj.core.api.Assertions.*;

import org.junit.After;
import org.junit.Before;

public class TimeZoneConverterTest {
    private TimeZoneConverter converter;

    @Before
    public void createTimeZoneConverterInstance() {
        converter = new TimeZoneConverter();
    }

    @After
    public void deleteTimeZoneConverterInstance() {
        converter = null;
    }

    @Test
    public void getConverterInstance() {
        assertThat(converter).isNotNull();
    }

    @Test
    public void setTimeTest() {

        // given
        converter.setTime("2022/06/11/13:10");

        // when
        int korYear = converter.getYear();
        int korMonth = converter.getMonth();
        int korDay = converter.getDay();
        int korHour = converter.getHour();
        int korMin = converter.getMin();

        // then
        assertThat(korYear).isEqualTo(2022);
        assertThat(korMonth).isEqualTo(6);
        assertThat(korDay).isEqualTo(11);
        assertThat(korHour).isEqualTo(13);
        assertThat(korMin).isEqualTo(10);
    }

    @Test
    public void timeToTurkey() {
        // given
        converter.setTime("2022/06/11/13:10");
        converter.printOtherCountry("터키");

        // when
        String turkeyTime = converter.printOtherCountry("터키");

        // then
        Assertions.assertThat(turkeyTime).isEqualTo("Turkey: 2022-6-11,7:10");
    }

    @Test
    public void timeToFrance() {
        // given
        converter.setTime("2022/06/11/13:10");
        converter.printOtherCountry("프랑스");

        // when
        String franceTime = converter.printOtherCountry("프랑스");

        // then
        Assertions.assertThat(franceTime).isEqualTo("2022/06/11/06:10");

    }

    @Test
    public void timeToBrazil() {
        // given
        converter.setTime("2022/06/11/13:10");
        converter.printOtherCountry("브라질");

        // when
        String brazilTime = converter.printOtherCountry("브라질");

        // then
        Assertions.assertThat(brazilTime).isEqualTo("2022/06/11/01:10");

    }
}
