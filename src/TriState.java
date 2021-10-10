public class TriState extends NonResident
{
    public State state;

    private static final double NEW_YORK_TUITION_DISCOUNT = 4000;
    private static final double CONNECTICUT_TUITION_DISCOUNT = 5000;

    public TriState(String name, Major major, int creditHours, State state)
    {
        super(name, major, creditHours);
        this.state = state;
    }

    @Override
    public void tuitionDue()
    {
        State nyState = State.NY;
        State ctState = State.CT;

        if(state.equals(nyState)) {
            if(FULL_TIME == true && creditHours > 16 ) {
                // (Student.NON_RES_FULL_TIME_TUITION - 4000) + Student.UNIVERSITY_FEE +
                // Student.NON_RES_PART_TIME_TUITION_RATE * (creditHours - 16);
            }
            else if(FULL_TIME == true) {
                // (Student.NON_RES_FULL_TIME_TUITION - 4000)+ Student.UNIVERSITY_FEE;
            }
            else if(FULL_TIME == false) {
                // (Student.UNIVERSITY_FEE * PART_TIME_FEE_REDUCTION) + (Student.NON_RES_PART_TIME_TUITION_RATE * creditHours);
            }
        }
        else if(state.equals(ctState)) {
            if(FULL_TIME == true && creditHours > 16 ) {
                // (Student.NON_RES_FULL_TIME_TUITION - 5000) + Student.UNIVERSITY_FEE +
                // Student.NON_RES_PART_TIME_TUITION_RATE * (creditHours - 16);
            }
            else if(FULL_TIME == true) {
                // (Student.NON_RES_FULL_TIME_TUITION - 5000) + Student.UNIVERSITY_FEE;
            }
            else if(FULL_TIME == false) {
                // (Student.UNIVERSITY_FEE * PART_TIME_FEE_REDUCTION) +
                // (Student.NON_RES_PART_TIME_TUITION_RATE * creditHours);
            }
        }
    }

    @Override
    public String toString()
    {
        //add state
        return String.format("%s(tri-state):%s", super.toString(), this.state);
    }






}