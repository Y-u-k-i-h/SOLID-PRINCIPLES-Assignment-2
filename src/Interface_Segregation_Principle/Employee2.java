package Interface_Segregation_Principle;

public interface Employee2 {
    void work();
}

class OfficeEmployees implements Employee2,Documents{

    public void work() {
        System.out.println("Office employee is working");
    }

    public void writeDocuments() {
        System.out.println("Office worker is writing documents ");
    }
}
class FieldEmployee2 implements Employee2 {

    public void work() {
        System.out.println("Field Employee is working.");
    }
}