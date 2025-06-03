package Single_Responsibility_Principle;

public class Test {
    public static void main(String[] args){
        StudentManager sm = new StudentManager();
        sm.addStudent();
        sm.removeStudent();
        Fees fees = new Fees();
        fees.payFees();
        Unit unit = new Unit();
        unit.registerUnit();
    }
}
