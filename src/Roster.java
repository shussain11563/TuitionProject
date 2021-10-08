public class Roster {
    private Student[] roster;
    private int size; //keep track of the number of students in the roster

    private int find(Student student) {
        for(int i = 0; i < this.size; i++) {

            if(this.roster[i] != null && this.roster[i].callProfileGetName().equals(student.callProfileGetName())
                    && this.roster[i].callProfileGetMajor().equals(student.callProfileGetMajor())) {
                return i;
            }
        }
        return -1;

    }
    private void grow() {

    }
    public boolean add(Student student) {
        return false;

    }
    public boolean remove(Student student) {
        return false;
    }

    public void print() {
    }

    public void printByNames() {
    }

    public void printByPaymentsMade() {
    }

}
