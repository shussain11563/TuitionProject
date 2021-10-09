public class NonResident extends Student
{
    //private static final int TUITION = 29737;
    private static final double FULL_TIME_TUITION = 29737;
    private static final double PART_TIME_TUITION_RATE = 966;

    public NonResident(String name, Major major, int creditHours)
    {
        //redundant
        super(name, major, creditHours);
        //throw exception if credit hours not valid
    }


    public void tuitionDue()
    {

    }
}