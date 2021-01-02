import java.util.Arrays;
import java.util.List;

public class BinaryMatchString {

    
    int binaryPatternMatching(String pattern, String s) {

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');

        int matches = 0;
        int i = 0;

        while (i <= s.length() - pattern.length()) {
            boolean found = false;
            for (int j = 0; j < pattern.length(); j++) {
                // System.out.println(i + " " + j);

                if (pattern.charAt(j) == '0' && !vowels.contains(s.charAt(i+j))) break;
                if (pattern.charAt(j) == '1' && vowels.contains(s.charAt(i+j))) break;

                if (j == pattern.length() - 1) found = true;

                // System.out.println("found: " + j + " " + i);
            }

            if (found) matches++;

            i++;
        }

        return matches;
    }

}
