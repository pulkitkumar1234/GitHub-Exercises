import java.util.Scanner;

class Fifth {
    private int arr1[];/*= {1, 2, 4, 5, 6};*/
    private int arr2[];/* = {2, 3, 5, 7};*/

    public Fifth() {
        arr1 = new int[]{1, 2, 4, 5, 6};
        arr2 = new int[]{2, 3, 5, 7};
    }

    public void InputValue() {
        System.out.println("Enter ELement in Array 1");
        Scanner sc = new Scanner(System.in);

        System.out.println("ELement in Array 1:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(this.arr1[i]);
        }

        System.out.println("ELement in Array 2:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(this.arr1[i]);
        }

        int Array1Length = arr1.length;
        int Array2Length = arr2.length;

        this.common(arr1, arr2, Array1Length, Array2Length);

    }

    public void common(int arr1[], int arr2[], int length1, int length2) {
        int i = 0, j = 0;
        while (i < length1 && j < length2) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else {
                System.out.println("Common Element:");
                System.out.println(arr2[j++] + " ");
                i++;
            }
        }
    }

    public static void main(String args[]) {
        Fifth obj = new Fifth();
        obj.InputValue();
    }
} 

