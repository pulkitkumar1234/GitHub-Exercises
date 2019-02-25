import java.util.*;

public class First {

    private List<Float> list;

    public static void main(String[] args) {
        First obj = new First();
        obj.listInsert();

    }

    public void CalculateFloatSum(List<Float> list) {
        Iterator<Float> it = list.iterator();
        float result = 0;
        while (it.hasNext()) {
            float num = it.next();
            result = result + num;
        }
        System.out.println("Sum of Five Float values::" + result);
    }


    public void listInsert() {
        List<Float> list = new ArrayList<>();
        list.add(1.1f);
        list.add(2.7f);
        list.add(5.3f);
        list.add(6.1f);
        list.add(8.9f);
        CalculateFloatSum(list);
    }


}
