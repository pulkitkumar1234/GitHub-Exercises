public class Sixth2 {

    public int find(int arr[],int l){

        int r1=arr[0];
        for(int i=1;i<l;i++)
        {
            r1=r1^arr[i];
        }
        return r1;
    }

    public static void main(String[] args) {

        Sixth s1=new Sixth();

        int arr[]={2, 2, 4, 5,5, 10,6, 6,10};
        int l=arr.length;

        int once= s1.find(arr,l);
        //int once=fun(arr,l);
        System.out.println("Element Come only once:"+once);
    }
}
