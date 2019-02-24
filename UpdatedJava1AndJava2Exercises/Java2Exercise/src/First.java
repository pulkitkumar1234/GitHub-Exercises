import java.util.Calendar;
import java.util.Date;

abstract class Library {

    protected String lib_name;
    protected String lib_address;

    public Library() {
        lib_name = "India Library";
        lib_address = "Noida Sector 127";

    }

    abstract void getLibraryInfo();
}

interface LibraryProperty {

    long lib_seatcap = 5000;

    void issueBook();

    void returnBook();

}


class library extends Library implements LibraryProperty {

    private String Member_name;
    private String Member_mobile;
    private String book_name;
    private Date issue_date;
    private Date return_date;

    public library(String rn, String rm, String bn) {
        Member_name = rn;
        Member_mobile = rm;
        book_name = bn;
    }

    @Override
    public void getLibraryInfo() {
        System.out.println("--------Library Details----------");
        System.out.println("Library Name: " + lib_name);
        System.out.println("Library Address: " + lib_address);
        System.out.println("Library Seating Capacity: " + lib_seatcap);
    }

    @Override
    public void issueBook() {
        Date curr_date = new Date();
        issue_date = curr_date;
        Calendar C = Calendar.getInstance();
        C.add(Calendar.DATE, 7);//--------
        return_date = C.getTime();
        System.out.println("Success! Book issued to " + Member_name + " on " + curr_date.toString() + " return date is on " + return_date);
    }

    @Override
    public void returnBook() {
        if (issue_date == null || return_date == null) {
            System.out.println("\nNo book has been issued!");
        } else {
            issue_date = null;
            return_date = null;
            System.out.println("Book has been returned successfully!");
        }
    }

    public void getMemberDetails() {
        if (issue_date == null || return_date == null) {
            System.out.println("Member Name: " + Member_name);
            System.out.println("Member Mobile: " + Member_mobile);
            System.out.println("Book Name: " + book_name);
            System.out.println("\nNo Book Has Been Issued!");
        } else {
            System.out.println("Member Name: " + Member_name);
            System.out.println("Member Mobile: " + Member_mobile);
            System.out.println("Book Name: " + book_name);
            System.out.println("Book Issue Date: " + issue_date);
            System.out.println("Book Return Date: " + return_date);
        }
    }
}

class MyLib {
    public static void main(String[] args) {
        library lib1 = new library("Pulkit", "9821962195", "Book1");
        library lib2 = new library("Shubham", "9572248278", "Book2");
        lib1.issueBook();
        lib2.issueBook();
        lib1.getMemberDetails();
        lib2.getMemberDetails();
        lib2.returnBook();
        lib1.returnBook();
    }
}