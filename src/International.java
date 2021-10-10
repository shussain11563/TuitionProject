public class International extends NonResident
{
    private boolean isStudyAbroad;
    private static final double ADDITIONAL_FEE = 2650;

    public International(String name, Major major, int creditHours, boolean isStudyAbroad)
    {
        super(name, major, creditHours);
        this.isStudyAbroad = isStudyAbroad;
    }

    public void setIsStudyAbroad()
    {
        //change magic number
        int minFullTimeCredit = 12;
        //if already true, return fa;se
        this.isStudyAbroad = true;
        //magic number
        this.setCreditHours(minFullTimeCredit);

        //.....



    }

    @Override
    public void tuitionDue()
    {
        //call super method
        if(this.isStudyAbroad)
        {
            //remove tuition or just dont
        }
        //super.tuitionDue();
    }

    //use insttance of in tuition manager to make sure it is an international student


    @Override
    public String toString()
    {
        return String.format("%s:international", super.toString());
    }




}