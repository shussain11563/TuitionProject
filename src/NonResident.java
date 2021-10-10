public class NonResident extends Student
{
    //private static final int TUITION = 29737;
    private static final double FULL_TIME_TUITION = 29737;
    private static final double PART_TIME_TUITION_RATE = 966;

    public NonResident(String name, Major major, int creditHours)
    {
        //redundant
        super(name, major, creditHours);
    }

    @Override
    public void tuitionDue()
    {
        if(FULL_TIME == true && creditHours > 16) {
            // Student.NON_RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE + Student.NON_RES_PART_TIME_TUITION_RATE
            // * (creditHours - 16);
        }
        else if(FULL_TIME == true) {
            // Student.NON_RES_FULL_TIME_TUITION + Student.UNIVERSITY_FEE;
        }
        else if(FULL_TIME == false) {
            // (Student.UNIVERSITY_FEE * PART_TIME_FEE_REDUCTION) + (Student.NON_RES_PART_TIME_TUITION_RATE * creditHours);
        }
    }

    @Override
    public String toString()
    {
        return String.format("%s:non-resident", super.toString());
    }
}