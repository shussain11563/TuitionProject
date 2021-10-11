import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void isValid() {
        Date date1 = new Date("9/1/2021");
        Date date2 = new Date("2/29/2021");
        Date date3 = new Date("5/50/2000");
        Date date4 = new Date("2/29/2016");
        Date date5 = new Date("12/1/2021");
        Date date6 = new Date("2/30/2016");
        Date date7 = new Date("8/25/2021");
        Date date8 = new Date("5/12/2021");

        assertTrue(date1.isValid());
        assertFalse(date2.isValid());
        assertFalse(date3.isValid());
        assertFalse(date4.isValid());
        assertFalse(date5.isValid());
        assertFalse(date6.isValid());
        assertTrue(date7.isValid());
        assertTrue(date8.isValid());
    }
}