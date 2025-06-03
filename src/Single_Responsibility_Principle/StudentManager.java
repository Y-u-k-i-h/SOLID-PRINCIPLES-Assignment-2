package Single_Responsibility_Principle;


// The code snippet below indicates adherence to the single responsibility principle since each class has methods relevant to its main goal
public class StudentManager {
    private int id;
    private String name;

    public void addStudent(){
        System.out.println("Student added successfully");
    }
    public void removeStudent(){
        System.out.println("Student removed successfully");
    }
}

class Fees{
    public void payFees(){
        System.out.println("Fees has been paid successfully");
    }
}

class Unit{
    public void registerUnit(){
        System.out.println("Unit registered successfully");
    }
}
