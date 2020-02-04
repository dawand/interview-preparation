package csv_reader;

import java.io.*;
import java.util.ArrayList;

public class CSVReader {
    public static void main(String[] args) {

        System.out.println(new File(".").getAbsolutePath());

        File csvFile = new File("src/csv_reader/data.csv");
        ArrayList<Integer> points = new ArrayList<>();
        String line = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            while ((line = reader.readLine()) != null){
                String[] nums = line.split(",");
                for (String s : nums) {
                    points.add((Integer.valueOf(s)));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

        points.forEach(System.out::println);
    }
}
