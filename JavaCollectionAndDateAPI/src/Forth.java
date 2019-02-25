import java.util.*;
class Employee /*implements Comparable<Employee>*/{
    private String EmpName;
    private int EmpAge;
    private int EmpSalary;

    public Employee(String Ename,int EAge,int ESalary)
    {
        EmpName=Ename;
        EmpAge=EAge;
        EmpSalary=ESalary;
    }

    /*public int compareTo(Employee Employee){
        return this.EmpSalary - Employee.EmpSalary;
    }*/

    public String getEmpName(){
        return EmpName;
    }
    public int getEmpAge(){
        return EmpAge;
    }

    public int getEmpSalary(){
        return EmpSalary;
    }
}
class SalaryCompare implements Comparator<Employee>{

    public int compare(Employee e1, Employee e2){

        if(e1.getEmpSalary()<e2.getEmpSalary()) return 1;
        if(e1.getEmpSalary()>e2.getEmpSalary())  return -1;
        else return 0;
    }
}

class Mainn{
    public static void main(String[] args) {
        ArrayList<Employee> list=new ArrayList<>();
        list.add(new Employee("Pulkit",26,15000));
        list.add(new Employee("Shubham",24,14000));
        list.add(new Employee("Raju",23,17000));
        list.add(new Employee("Abhay",28,25000));


        SalaryCompare SalComp=new SalaryCompare();
        Collections.sort(list,SalComp);

        for (Employee employee: list)
            System.out.println(employee.getEmpName() + " " +employee.getEmpAge() + " " +employee.getEmpSalary());

    }
        }