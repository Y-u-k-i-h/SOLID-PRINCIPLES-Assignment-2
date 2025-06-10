package Interface_Segregation_Principle;

public interface Employee2 {
    void work();
}

class FieldEmployees implements Employee2,Documents{

    @Override
    public void work() {
        System.out.println("Office employee is working");
    }

    @Override
    public void writeDocuments() {
        System.out.println("Office worker is writing documents ");

    }
}
class FieldEmployee2 implements Employee2 {
    @Override
    public void work() {
        System.out.println("Field Employee is working.");
    }
}