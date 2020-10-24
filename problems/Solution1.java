import java.util.*;

public class Solution1 {

    public List<String> sortJunctionBoxes(List<String> boxList) {
        List<String> list = new ArrayList<>();
        List<String> oldList = new ArrayList<>();
        List<String> newList = new ArrayList<>();

        for (String box: boxList) {
            String[] boxWords = box.split(" ");

            if (Character.isDigit(boxWords[1].charAt(0)))
//            if (isNumeric())
                newList.add(box);
            else
                oldList.add(box);
        }

//        newList.forEach(System.out::println);

        oldList.sort((o1, o2) -> {
            String s1 = o1.substring(o1.indexOf(" "));
            String s2 = o2.substring(o2.indexOf(" "));

            if (s1.equals(s2))
                return o1.substring(0, o1.indexOf(" ")).compareTo(o2.substring(0, o2.indexOf(" ")));

            return s1.compareTo(s2);
        });

        list.addAll(oldList);
        list.addAll(newList);

        return list;
    }

    boolean isNumeric(String str){
        return str.contains("+d");
    }
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        List<String> list = new ArrayList<>();
        list.add("r1 box ape bit");
        list.add("br8 eat nim did");
        list.add("b4 tye 121 432");
        list.add("b4 sea 121 432");
        list.add("w1 has uni gry");
        list.add("b4 xi me nu");
        list.add("b4 32 43 54");

        s.sortJunctionBoxes(list).forEach(System.out::println);
    }
}
