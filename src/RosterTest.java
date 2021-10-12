import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RosterTest {

    @org.junit.jupiter.api.Test
    void add() {
        Major csMajor = Major.valueOf("CS");
        Major itMajor = Major.valueOf("IT");
        Major eeMajor = Major.valueOf("EE");
        Major meMajor = Major.valueOf("ME");
        Major baMajor = Major.valueOf("BA");
        State nyState = State.valueOf("NY");

        Roster rosterCollection = new Roster();

        Student student1 = new Student("John Smith", csMajor, 20);
        Student student2 = new Resident("Joe Kim", itMajor, 12);
        Student student3 = new NonResident("Aidan Blacksmith", eeMajor, 15);
        Student student4 = new TriState("Phillip Hello", meMajor, 14, nyState);
        Student student5 = new International("Julie Kam", baMajor, 10, false);
        assertTrue(rosterCollection.add(student1));
        assertTrue(rosterCollection.add(student2));
        assertTrue(rosterCollection.add(student3));
        assertTrue(rosterCollection.add(student4));
        assertTrue(rosterCollection.add(student5));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        Major csMajor = Major.valueOf("CS");
        Major itMajor = Major.valueOf("IT");
        Major eeMajor = Major.valueOf("EE");
        Major meMajor = Major.valueOf("ME");
        Major baMajor = Major.valueOf("BA");
        State nyState = State.valueOf("NY");

        Roster rosterCollection = new Roster();

        Student student1 = new Student("John Smith", csMajor, 20);
        Student student2 = new Resident("Joe Kim", itMajor, 12);
        Student student3 = new NonResident("Aidan Blacksmith", eeMajor, 15);
        Student student4 = new TriState("Phillip Hello", meMajor, 14, nyState);
        Student student5 = new International("Julie Kam", baMajor, 10, false);

        assertFalse(rosterCollection.remove(student1));

        rosterCollection.add(student1);
        rosterCollection.add(student2);
        rosterCollection.add(student3);
        rosterCollection.add(student4);
        rosterCollection.add(student5);

        assertTrue(rosterCollection.remove(student1));
        assertTrue(rosterCollection.remove(student2));
        assertTrue(rosterCollection.remove(student3));
        assertTrue(rosterCollection.remove(student4));
        assertTrue(rosterCollection.remove(student5));
    }
}