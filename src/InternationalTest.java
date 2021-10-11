import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternationalTest {

    @Test
    void tuitionDue() {
        Major csMajor = Major.valueOf("CS");
        Major itMajor = Major.valueOf("IT");
        Major eeMajor = Major.valueOf("EE");

        Roster rosterCollection = new Roster();
        Student student1 = new International("Julie Kam", csMajor, 12, false);
        Student student2 = new International("Bob Jones", itMajor, 12, true);
        Student student3 = new International("Chad Jones", eeMajor, 16, false);

        rosterCollection.add(student1);
        rosterCollection.add(student2);
        rosterCollection.add(student3);

        student1.tuitionDue();
        student2.tuitionDue();
        student3.tuitionDue();

        assertEquals(35655, student1.getTuitionDue());
        assertEquals(5918, student2.getTuitionDue());
        assertEquals(35655, student3.getTuitionDue());
    }
}