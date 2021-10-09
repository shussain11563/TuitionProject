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

    }

    //use insttance of in tuition manager to make sure it is an international student


    @Override
    public String toString()
    {
        return String.format("%s:international", super.toString());
    }




}