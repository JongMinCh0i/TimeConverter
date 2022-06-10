import org.assertj.core.api.Assertions;
import org.junit.Test;

// 테스트 코드 작성 x

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

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
    public void setTime() {
        this.converter.setTime("2022/06/08/00:30");
        assertThat(2022).isEqualTo(converter.getYear());
        assertThat(6).isEqualTo(converter.getMonth());
        assertThat(8).isEqualTo(converter.getDay());
        assertThat(0).isEqualTo(converter.getHour());
        assertThat(30).isEqualTo(converter.getMin());
    }
}
