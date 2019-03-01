@FunctionalInterface
interface GeneralEmployee{
    Employee printEmployee(String name, int age, String city);
}

class Employee{
    String Name;
    int Age;
    String city;

    public Employee(String Name, int Age, String city){
        this.Name=Name;
        this.Age=Age;
        this.city=city;
    }

    @Override
    public String toString(){
        return "Name of Employee:"+Name+" Age of Employee:"+Age+" City of Employee:"+city;
    }

}



class ImplementEmployee{
    public static void main(String[] args) {
        GeneralEmployee generalEmployee=Employee::new;
        Employee employee=generalEmployee.printEmployee("Pulkit",26,"Delhi");
        System.out.println(employee.toString());
    }
}