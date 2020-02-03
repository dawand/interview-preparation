import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        System.out.println(solution("+++++]]]}}}++++"));
    }

    static int solution(String S) {

        if (S.length() % 2 != 0) return 0;
        if (S.length() == 0) return 1;

        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '{' || c == '[' || c == '(')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return 0;
                else if (c == '}' && stack.pop() != '{')
                    return 0;
                else if (c == ']' && stack.pop() != '[')
                    return 0;
                else if (c == ')' && stack.pop() != '(')
                    return 0;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
