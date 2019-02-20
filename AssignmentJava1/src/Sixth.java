import java.util.Scanner;

public class Sixth {

    private int arr[];

    public Sixth() {
        arr = new int[]{2, 2, 4, 5, 5, 10, 6, 6, 10};
    }

    public int ini() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ELement of Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int l = arr.length;
        return (this.find(arr, l));
    }

    public int find(int arr[], int l) {

        int r1 = arr[0];
        for (int i = 1; i < l; i++) {
            r1 = r1 ^ arr[i];
        }
        return r1;
    }

    public static void main(String[] args) {

        Sixth s1 = new Sixth();
        int once= s1.ini();
        System.out.println("Value Appear Only Once:"+once);
    }
}
