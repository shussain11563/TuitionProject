public class Roster {
    private Student[] roster;
    private int size; //keep track of the number of students in the roster
    
    
    private static final int NOT_FOUND = -1;
    private static final int INITIAL_CAPACITY = 4;
    private static final int GROWTH_FACTOR = 4;
    private static final int EMPTY = 0;
    
    

    public Roster()
    {
        this.roster = new Student[INITIAL_CAPACITY];
        this.size = 0;
    }

    private int find(Student student)
    {
        for(int i = 0; i < this.size; i++)
        {
            //use .equals??
            /*
            if()
            {
                return i;
            }

             */
        }

        return NOT_FOUND;
        /*
        for(int i = 0; i < this.size; i++) {

            if(this.roster[i] != null && this.roster[i].callProfileGetName().equals(student.callProfileGetName())
                    && this.roster[i].callProfileGetMajor().equals(student.callProfileGetMajor())) {
                return i;
            }
        }
        return -1;

         */

    }

    //Complete, must reformat
    private void grow()
    {
        Student[] oldRoster = this.roster;
        int oldRosterLength = oldRoster.length;
        this.roster = new Student[oldRosterLength + GROWTH_FACTOR];

        for(int i = 0; i < oldRosterLength; i++)
        {
            this.roster[i] = oldRoster[i];
        }

        //this.roster = newRoster;

    }

    private void shifting() {
        for(int i = 0; i < this.roster.length - 1; i++) {
            if(this.roster[i] == null) {
                this.roster[i] = this.roster[i+1];
                this.roster[i+1] = null;
            }
        }
    }

    //complete, must needed
    public boolean add(Student student)
    {
        if(find(student) == NOT_FOUND)
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

    //complete, must reformat
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



        System.out.println("* end of roster **");
    }


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
                //names[i] = this.roster[i].getGenre();
            }
        }

        //insertionSort(names);

        for(int i = 0; i < this.size; i++)
        {
            System.out.println(this.roster[i].toString());
        }


        System.out.println("* end of roster **");
    }

    public void printByPaymentsMade()
    {
        if(this.size == EMPTY)
        {
            System.out.println("Student roster is empty!");
            return;
        }

        System.out.println("* list of students made payments ordered by payment date **");


        for(int i = 0; i < this.size; i++)
        {
            System.out.println(this.roster[i].toString());
        }

        System.out.println("* end of roster **");
    }


    private <T extends Comparable<T>> void insertionSort(T[] arr) {
        for(int i = 0; i < this.roster.length; i++) {
            T key = arr[i];
            //Album keyPointer = albums[i];

            Student keyPointer = this.roster[i];


            //might require instance off?
            int j = i-1;

            while(j>=0 && arr[j]!=null && key!=null && arr[j].compareTo(key)>0)
            {
                arr[j + 1] = arr[j];
                this.roster[j + 1] = this.roster[j];
                j = j - 1;
            }

            arr[j + 1] = key;
            this.roster[j + 1] = keyPointer;
        }
    }



    private void calculateTuition()
    {
        for(int i = 0; i < this.size; i++)
        {
            this.roster[i].tuitionDue();
        }
    }



}
