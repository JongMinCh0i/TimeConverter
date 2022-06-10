import org.junit.Test;

// 테스트 코드 작성 x

import static org.junit.Assert.*;
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
        assertNotNull(converter);
    }

    @Test
    public void setTime() {
        this.converter.setTime("2022/06/08/00:30");
        assertEquals(2022, this.converter.getYear());
        assertEquals(6, this.converter.getMonth());
        assertEquals(8, this.converter.getDay());
        assertEquals(0, this.converter.getHour());
        assertEquals(30, this.converter.getMin());
    }
}
