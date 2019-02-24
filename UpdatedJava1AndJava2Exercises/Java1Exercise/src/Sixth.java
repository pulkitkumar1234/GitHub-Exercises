import java.util.Scanner;

public class Sixth {

    private int arr[];

    public Sixth() {
        arr = new int[]{2, 2, 4, 5, 5, 10, 6, 6, 10};
    }

    public int InputValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ELement of Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int length = arr.length;
        return (this.find(arr, length));
    }

    public int find(int arr[], int length) {

        int once = arr[0];
        for (int i = 1; i < length; i++) {
            once = once ^ arr[i];
        }
        return once;
    }

    public static void main(String[] args) {

        Sixth obj = new Sixth();
        int once = obj.InputValue();
        System.out.println("Value Appear Only Once:" + once);
    }
}
