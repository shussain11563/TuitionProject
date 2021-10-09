public class TriState extends NonResident
{
    public State state;

    private static final double NEW_YORK_TUITION_DISCOUNT = 4000;
    private static final double CONNECTICUT_TUITION_DISCOUNT = 5000;

    //int city code
    public TriState(String name, Major major, int creditHours, State state)
    {
        super(name, major, creditHours);
        this.state = state;
    }

    @Override
    public String toString()
    {
        //add state
        return String.format("%s(tri-state):%s", super.toString(), this.state);
    }






}