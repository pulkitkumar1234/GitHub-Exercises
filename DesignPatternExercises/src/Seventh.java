import java.util.*;
interface Directory{
    void ShowDirectoryDetails();
}

class Department implements Directory{
    private String Name;
    private String DepartmentName;

    public Department(String name, String departmentName) {
        Name = name;
        DepartmentName = departmentName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    @Override
    public void ShowDirectoryDetails(){
        System.out.println(" DIRECTORY NAME="+Name+" DEPARTENT NAME="+DepartmentName);
    }
    @Override
    public String toString(){
        return " DIRECTORY NAME="+Name+" DEPARTENT NAME="+DepartmentName;
    }
}

class DepartmentDirectory implements Directory{
    List<Directory> DirectoryList=new ArrayList<>();
    @Override
    public void ShowDirectoryDetails(){
        System.out.println("Department Directory!");
        DirectoryList.forEach(e->e.ShowDirectoryDetails());
    }
}

class composite{
    public static void main(String[] args) {
        Department department1=new Department("Java", " IT");
        Department department2=new Department("ExcelSheet", "Accounts");

        DepartmentDirectory departmentDirectory=new DepartmentDirectory();
        departmentDirectory.DirectoryList.add(department1);
        departmentDirectory.DirectoryList.add(department2);
        departmentDirectory.ShowDirectoryDetails();
    }
}
