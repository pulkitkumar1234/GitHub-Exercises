import java.util.*;

public class Second {

    private String string;

    public void CalculateUniqueCharacter() {
        //boolean result = false;
        string = "abcdesfeedbjsbsdvbhfbvbvjhvbvvhbvjvvbvvfbifdbdv";
        System.out.println(string);

        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
               hs.add(string.charAt(i));
            /*if (result == false)
                break;*/
        }
        System.out.println(hs);
    }

    public static void main(String[] args) {
        Second obj = new Second();
        obj.CalculateUniqueCharacter();
    }
}
