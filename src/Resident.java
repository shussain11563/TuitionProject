public class Resident extends Student
{
    private static final double FULL_TIME_TUITION = 12536;
    private static final double PART_TIME_TUITION_RATE = 404;


    public Resident(String name, Major major, int creditHours)
    {
        super(name, major, creditHours); //change this
    }

    @Override
    public void tuitionDue()
    {

    }

}