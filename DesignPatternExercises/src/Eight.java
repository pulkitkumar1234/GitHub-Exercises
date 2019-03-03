
class Students {
    int roll;
    String name;
    int age;

    public Students() {

    }

    public Students(int roll, String name, int age) {
        this.roll=roll;
        this.name=name;
        this.age=age;
    }

    public int getRoll() {
        return roll;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "Student { Roll: "+roll+" Name: "+name+" Age: "+age+" }";
    }
}

interface Driver {
    void display();
}

class Admin implements Driver {
    protected Students students;

    public Admin(Students students) {
        this.students=students;
    }

    @Override
    public void display() {
        System.out.println(students);
    }
}

class AdminProxy extends Admin {

    public AdminProxy(Students students) {
        super(students);
    }

    @Override
    public void display() {
        if(students.getRoll()==0) {
            System.out.println("Data cannot be accessed!");
        } else {
            System.out.println("Data Access Succeed!");
            super.display();
        }
    }

}

class Eight {

    public static void main(String[] args) {

        Students students1=new Students(1001,"Pulkit",24);
        Admin admin=new AdminProxy(students1);
        admin.display();

        Students students2=new Students();
        students2.setName("Prateek");
        students2.setAge(23);

        Admin admin1=new AdminProxy(students2);
        admin1.display();

    }

}