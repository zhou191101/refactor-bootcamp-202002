package cc.xpbootcamp.warmup.utils;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class DateUtilsTest {
    @Test
    public void testGetNowWeek() {
        String now = DateUtils.getNowWeek();
        assertThat(now,containsString("星期二"));
    }

    @Test
    public void testGetNowTime() {
        String now = DateUtils.getNowTime();
        assertThat(now,containsString("2020年02月18日，星期二"));
    }
}
