class Student{
    private String Name;
    private  Integer id;
    private  Integer age;
    private  Integer fees;
    private String Course;
    private String Address;

    public Student(StudentBuilder studentBuilder) {
        Name = studentBuilder.getName();
        this.id = studentBuilder.getId();
        this.age = studentBuilder.getAge();
        this.fees = studentBuilder.getFees();
        Course = studentBuilder.getCourse();
        Address = studentBuilder.getAddress();
    }


    public void setName(String name) {
        Name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getFees() {
        return fees;
    }

    public String getCourse() {
        return Course;
    }

    public String getAddress() {
        return Address;
    }

    @Override
    public String toString(){
        return "Student{"+
                "Name="+Name+
                " ID="+id+
                " Age="+age+
                " Fees:"+fees+
                " Course="+Course+
                " Address="+Address+"}";
    }
}
class StudentBuilder{
    private String Name;
    private Integer id;
    private Integer age;
    private Integer fees;
    private String Course;
    private String Address;

    public StudentBuilder(String Name,Integer id, Integer age, Integer fees,String Course,String Address){
        this.Name=Name;
        this.id=id;
        this.age=age;
        this.fees=fees;
        this.Course=Course;
        this.Address=Address;
    }

    public String getName() {
        return Name;
    }

    public StudentBuilder setName(String name) {
        Name = name;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public StudentBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getFees() {
        return fees;
    }

    public StudentBuilder setFees(Integer fees) {
        this.fees = fees;
        return this;
    }

    public String getCourse() {
        return Course;
    }

    public StudentBuilder setCourse(String course) {
        Course = course;
        return this;
    }

    public String getAddress() {
        return Address;
    }

    public StudentBuilder setAddress(String address) {
        Address = address;
        return this;
    }
    public Student build(){
        return new Student(this);
    }
}
class Builder{
    public static void main(String[] args) {
        Student student=new StudentBuilder("Pulkit",3279,26,15000,"MCA", "Noida").build();
        System.out.println(student);

    }
}