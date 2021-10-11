import java.awt.*;

/**
 * The Roster class is an arraylist data structure that contains Students and related types.
 * This class contains methods that allow adding, deleting, sorting, lending, removing
 * and other manipulations of the arraylist.
 * @author Sharia Hussain, David Lam
 */
public class Roster {
    private Student[] roster;
    private int size; //keep track of the number of students in the roster

    private static final int FOUND = 0;
    private static final int NOT_FOUND = -1;
    private static final int INITIAL_CAPACITY = 4;
    private static final int GROWTH_FACTOR = 4;
    private static final int EMPTY = 0;

    /**
     * Constructs and initializes a Student Roster object.
     * Initializes a roster array with size of INITIAL_CAPACITY (4).
     */
    public Roster()
    {
        this.roster = new Student[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Finds a student within the Student Roster.
     * @param student the student to find within the Student Roster.
     * @return position of student in rosters array, returns NOT_FOUND (-1) if not found.
     */
    private int find(Student student)
    {
        for(int i = 0; i < this.size; i++)
        {
            //change for readabilitiy
            if(this.roster[i] != null && this.roster[i].getProfile().getName().equals(student.getProfile().getName()) &&
                    this.roster[i].getProfile().getMajor().equals(student.getProfile().getMajor()))
            {
                return i;
            }
        }

        return NOT_FOUND;
    }

    /**
     * Returns the Student from the Student Roster.
     * @param student the student to find and return.
     * @return the student if the student is within the Student Roster, null otherwise
     */
    public Student getStudent(Student student)
    {
        int index = find(student);

        if(index == NOT_FOUND)
        {
            return null;
        }
        else
        {
            return this.roster[index];
        }

    }

    /**
     * Grows the Student Roster by GROWTH_FACTOR.
     * grow() is called in add() when the roster array is full.
     */
    private void grow()
    {
        Student[] oldRoster = this.roster;
        int oldRosterLength = oldRoster.length;
        this.roster = new Student[oldRosterLength + GROWTH_FACTOR];

        for(int i = 0; i < oldRosterLength; i++)
        {
            this.roster[i] = oldRoster[i];
        }
    }

    /**
     * shifting() is called after a removal in the Roster is done in remove().
     * Keeps the albums array contiguous with no gaps by shifting.
     */
    private void shifting() {
        for(int i = 0; i < this.roster.length - 1; i++) {
            if(this.roster[i] == null) {
                this.roster[i] = this.roster[i+1];
                this.roster[i+1] = null;
            }
        }
    }

    /**
     * Adds a student to the Student Roster and increases counter.
     * Grows the Student Roster to store more than the capacity of the Student Roster.
     * @param student the student to add to the Roster.
     * @return true if adding student to the Roster was successful, false if the student is already in the Roster.
     */
    public boolean add(Student student)
    {

        if(find(student) != NOT_FOUND)
        {
            return false;
        }

        if(size == this.roster.length)
        {
            grow();
        }

        this.roster[this.size] = student;
        this.size++;
        return true;
    }


    public boolean remove(Student student)
    {
        int indexOfStudent = find(student);

        if(indexOfStudent == NOT_FOUND)
        {
            return false;
        }

        this.roster[indexOfStudent] = null;
        this.size--;
        shifting();
        return true;



        //return false;
    }

    //complete, must reformat
    public void print()
    {
        if(this.size == EMPTY)
        {
            System.out.println("Student roster is empty!");
            return;
        }

        System.out.println("* list of students in the roster **");

        for(int i = 0; i < this.size; i++)
        {
            System.out.println(this.roster[i].toString());
        }

        System.out.println("* end of roster **");

    }

    //complete, must reformat
    public void printByNames()
    {
        if(this.size == EMPTY)
        {
            System.out.println("Student roster is empty!");
            return;
        }

        System.out.println("* list of students ordered by name **");

        String[] names = new String[this.roster.length];

        for(int i = 0; i < this.roster.length; i++)
        {
            if(this.roster[i] != null)
            {
                names[i] = this.roster[i].getProfile().getName();
                //names[i] = this.roster[i].getGenre();
            }
        }


        insertionSort(names);
        bubbleNullToEnd();

        for(int i = 0; i < this.size; i++)
        {

            System.out.println(this.roster[i].toString());
        }

        System.out.println("* end of roster **");
    }

    public void printByPaymentsMadeByPaymentDate()
    {

        if(this.size == EMPTY)
        {
            System.out.println("Student roster is empty!");
            return;
        }

        System.out.println("* list of students made payments ordered by payment date **");

        Date paymentMades[] = new Date[this.roster.length];

        for(int i = 0; i < this.roster.length; i++)
        {
            if(this.roster[i] != null && this.roster[i].getLastPaymentDate() != null)
            {
                paymentMades[i] = this.roster[i].getLastPaymentDate();
            }
        }

        insertionSort(paymentMades);

        for(int i = 0; i < this.roster.length; i++)
        {
            //System.out.println(this.roster[i].toString());
            if(paymentMades[i] != null)
            {
                System.out.println(this.roster[i].toString());
            }
        }

        bubbleNullToEnd();


        System.out.println("* end of roster **");
    }

    private <T extends Comparable<T>> int safeNullCompareTo(T first, T second)
    {
        if(first == null)
        {
            return -1;
        }
        else if(second == null)
        {
            return 1;
        }
        else
        {
            return first.compareTo(second);
        }

    }

    private void bubbleNullToEnd()
    {
        Student[] oldRoster = this.roster;
        Student[] newRoster = new Student[oldRoster.length];
        int indexCounter = 0;

        for(int i = 0; i < oldRoster.length; i++)
        {
            if(oldRoster[i] != null)
            {
                newRoster[indexCounter] = oldRoster[i];
                indexCounter++;
            }
        }
        this.roster = newRoster;
    }

    /*
    private void bubbleNullToEnd(Date[] arr)
    {
        Date[] old = arr;
        Date[] newDate = new Date[arr.length];

        int indexCounter = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(old[i] == null)
            {

            }

            if(oldRoster[i] != null)
            {
                newRoster[indexCounter] = oldRoster[i];
                indexCounter++;
            }
        }
        this.roster = newRoster;
    }
    */

    //complete, must reformat
    private <T extends Comparable<T>> void insertionSort(T[] arr) {
        for(int i = 0; i < this.roster.length; i++) {
            T key = arr[i];
            //Album keyPointer = albums[i];

            Student keyPointer = this.roster[i];


            //might require instance off?
            int j = i-1;

            //if arr[j].compareTo causes error, then continue


            //while(j>=0 && arr[j]!=null && arr[j].compareTo(key)>0)
            //while(j>=0 && arr[j]!=null && key!=null && arr[j].compareTo(key)>0)
            //while(j>=0 && arr[j]!=null && arr[j].compareTo(key)>0)
            while(j>=0 && arr[j]!=null && safeNullCompareTo(arr[j], key) > 0)
            {

                arr[j + 1] = arr[j];
                this.roster[j + 1] = this.roster[j];
                j = j - 1;

            }

            arr[j + 1] = key;
            this.roster[j + 1] = keyPointer;
        }
        //bubbleNullToEnd();
    }

    public void calculateTuition()
    {
        for(int i = 0; i < this.size; i++)
        {
            this.roster[i].tuitionDue();
        }

    }

}
