public class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(){

    }
    public Employee(int id,String name,int age,String department,double salary){
        this.id=id;
        this.name=name;
        this.age=age;
        this.department=department;
        this.salary=salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Id = "+id+" Name = "+name+" Age = "+age+" Department = "+department+" Salary = "+salary;
    }
}
