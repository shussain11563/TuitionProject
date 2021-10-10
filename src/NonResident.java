public class NonResident extends Student
{
    //private static final int TUITION = 29737;
    public static final double FULL_TIME_TUITION = 29737;
    public static final double PART_TIME_TUITION_RATE = 966;
    public static final double CREDIT_HOURS_MAX = 16;

    public NonResident(String name, Major major, int creditHours)
    {
        //redundant
        super(name, major, creditHours);
        //throw exception if credit hours not valid
    }

    @Override
    public void tuitionDue()
    {
        //tuition + university free
        if(this.getStatus() == FULL_TIME)
        {
            this.setTuitionDue((this.getTuitionDue() + FULL_TIME_TUITION));
            this.setTuitionDue((this.getTuitionDue() + UNIVERSITY_FEE_FULL_TIME));
        }
        else if(this.getStatus() == PART_TIME)
        {
            this.setTuitionDue((this.getTuitionDue() + (this.getCreditHours() * PART_TIME_TUITION_RATE)));
            this.setTuitionDue(this.getTuitionDue() + UNIVERSITY_FEE_PART_TIME);
        }

        //extra creditHours
        if(this.getCreditHours() - CREDIT_HOURS_MAX > 0 && this.getStatus() == FULL_TIME)
        {
            this.setTuitionDue(this.getTuitionDue() + ((this.getCreditHours() - CREDIT_HOURS_MAX) * PART_TIME_TUITION_RATE));
        }

    }

    @Override
    public String toString()
    {
        return String.format("%s:non-resident", super.toString());
    }
}