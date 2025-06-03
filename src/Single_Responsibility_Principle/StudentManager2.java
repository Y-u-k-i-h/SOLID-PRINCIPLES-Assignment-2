package Single_Responsibility_Principle;


// The following code does not adhere to single responsibility principle
// The  class has multiple methods that are not relevant to its single responsibility
public class StudentManager2 {
    private int id;
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(){
        System.out.println("Student added successfully");
    }
    public void deleteStudent(){
        System.out.println("Student removed successfully");
    }
    public void payFees(){
        System.out.println("Fees has been paid");
    }
    public void registerUnit(){
        System.out.println("Unit registered successfully");
    }


}
