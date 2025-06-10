package Interface_Segregation_Principle;

public interface Employee {
    void work();
    void writeDocuments();
}
class OfficeEmployee implements Employee{
    @Override
    public void work() {
        System.out.println("Office Employee is at work");

    }
    @Override
    public void writeDocuments() {
        System.out.println("Office Employee is writing Documents");

    }
}
class FieldEmployee implements Employee{

    @Override
    public void work() {
        System.out.println("Field Employee is at work");

    }

    @Override
    public void writeDocuments() {
       throw new UnsupportedOperationException("Field employee does not write documents");
    }
}