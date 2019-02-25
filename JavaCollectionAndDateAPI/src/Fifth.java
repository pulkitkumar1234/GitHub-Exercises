import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private double score;
    private double age;

    public Student(String name, double score, double age) {

        this.name=name;
        this.score=score;
        this.age=age;


    }

    @Override
    public int compareTo(Student S) {
        if(score==S.score)
            return name.compareTo(S.name);
        else if(score>S.score)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "\nName: "+name+" Score: "+score+" Age: "+age;
    }
}

class Mains {

    public static void main(String[] args) {

        Student S1,S2,S3;
        S1=new Student("Chandan",54564,21);
        S2=new Student("Aditya",45786,26);
        S3=new Student("Anil",65945,21);

        List<Student> list=new ArrayList<>();

        list.add(S1);
        list.add(S2);
        list.add(S3);

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);

    }

}




/*
import java.util.*;
class Student */
/*implements Comparable*//*
<Student>{
    private String StudentFirstName;
    private String StudentLastName;
    private int StudentAge;
    private int StudentScore;

    public Student(String SFname,String SLName,int SAge,int SScore)
    {
        StudentFirstName=SFname;
        StudentLastName=SLName;
        StudentAge=SAge;
        StudentScore=SScore;
    }

   */
/* public int compareTo(Student student){
        return this.StudentScore - student.StudentScore;
    }*//*



    public String getStudentFirtsName(){
        return StudentFirstName;
    }
    public String getStudentLastName(){
        return  StudentLastName;
    }
    public int getStudentAge(){
        return StudentAge;
    }

    public int getStudentScore(){
        return StudentScore;
    }
}
class ScoreCompare implements Comparator<Student>{

    public int compare(Student e1, Student e2){

        if(e1.getStudentScore()<e2.getStudentScore()) return 1;
        if(e1.getStudentScore()>e2.getStudentScore())  return -1;
        else {
            return 0;

            //FnameCompare fnameCompare=new FnameCompare();
            //Collections.sort(,fnameCompare);
        }
    }
}
class FnameCompare implements  Comparator<Student>{
    public int compare(Student s1, Student s2){
       return s1.getStudentFirtsName().compareTo(s2.getStudentFirtsName());

    }
}
class Mains{
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        list.add(new Student("Pulkit","Kumar",26,80));
        list.add(new Student("Shubham","Kumar",24,90));
        list.add(new Student("Raju","Chauhaan",23,95));
        list.add(new Student("Abhay","Gupta",28,70));


        ScoreCompare ScoComp=new ScoreCompare();
        Collections.sort(list,ScoComp);

        for (Student student: list)
            System.out.println(student.getStudentFirtsName()+" "+student.getStudentLastName() + " " +student.getStudentAge() + " " +student.getStudentScore());

        FnameCompare fc=new FnameCompare();
        Collections.sort(list,fc);
        for (Student student: list)
            System.out.println(student.getStudentFirtsName()+" "+student.getStudentLastName() + " " +student.getStudentAge() + " " +student.getStudentScore());

    }
}*/
