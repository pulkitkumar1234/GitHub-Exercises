import java.util.Scanner;

class Fifth
{
    private int arr1[];/*= {1, 2, 4, 5, 6};*/
    private int arr2[];/* = {2, 3, 5, 7};*/

    public Fifth()
    {
        arr1=new int[]{1, 2, 4, 5, 6};
        arr2=new int[]{2, 3, 5, 7};
    }
  public void ini(){
      System.out.println("Enter ELement in Array 1");
      Scanner sc=new Scanner(System.in);

      System.out.println("ELement in Array 1:");
       for(int i=0;i<arr1.length;i++){
           System.out.println(this.arr1[i]);
      }

      System.out.println("ELement in Array 2:");
      for(int i=0;i<arr2.length;i++){
          System.out.println(this.arr1[i]);
      }

      int l1=arr1.length;
      int l2=arr2.length;

      this.common(arr1,arr2,l1,l2);

  }

    public void common(int arr1[], int arr2[], int l1, int l2)
    {
        int i = 0, j = 0;
        while (i < l1 && j < l2)
        {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else
            {
                System.out.println("Common Element:");
                System.out.println(arr2[j++]+" ");
                i++;
            }
        }
    }

    public static void main(String args[])
    {
        Fifth f1=new Fifth();
        f1.ini();
    }
} 

