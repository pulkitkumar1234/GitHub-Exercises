import java.util.*;
public class Third {
    private String string;
    public void UniqueCharCount()
    {
        HashMap<Character,Integer> HM=new HashMap<>();
        System.out.println("Enter String::");
        Scanner sc=new Scanner(System.in);
        string=sc.nextLine();
        if(string.isEmpty())
        {
            System.out.println("No String Found!");
        }
        else{
            string=string.trim();
            char[] stringArray=string.toCharArray();
            for(char c : stringArray){
                if(HM.containsKey(c))
                {
                    HM.put(c,HM.get(c)+1);
                }
                else{
                    HM.put(c,1);
                }

            }
            for(Map.Entry entry:HM.entrySet()){
                System.out.println(entry.getKey()+"  "+entry.getValue());
            }
        }

    }


    public static void main(String[] args) {
        Third obj=new Third();
        obj.UniqueCharCount();
    }
}
