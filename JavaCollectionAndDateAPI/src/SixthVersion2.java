import java.util.*;

class Q6ArrayFrequency {
    public static void main(String[] str) {
        LinkedHashMap<Integer,Integer> array=new LinkedHashMap<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array (Press a character to end): ");
        try {
            while(true){
                int num=sc.nextInt();
                if(array.containsKey(num)){
                    array.put(num,array.get(num)+1);
                }
                else{
                    array.put(num,1);
                }
            }
        }
        catch (Exception e){
        }
        Set<Map.Entry<Integer, Integer>> set=array.entrySet();
        List<Map.Entry<Integer, Integer>> list=new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });
        for(Map.Entry<Integer,Integer> entry:list){
            System.out.println(entry);
        }
    }
}