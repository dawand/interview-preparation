import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {
    public static void main(String[] args) {
        String str = "ABEEEEECDEABEEECA"; // DEAB -> 4
        Character[] chars = {'A', 'B', 'D'};
        System.out.println(smallestSubstring(str, chars));
    }

    private static int smallestSubstring(String str, Character[] chars) {
        int length = 0;
        Set<Character> charSet = new HashSet<>(Arrays.asList(chars));
        int p = 0;
        int q = 0;
        int found = 0;

        while (q < str.length()) {
            if (charSet.contains(str.charAt(q)) || found != charSet.size()) {
                q++;
                found++;
            } else {
                p++;
            }
            length = q - p;
        }

        return length;
    }
}

/*
'A' 'B' 'D'
"ABEEEEECDEABEEECA"
  p        q


 */