import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        // Write your code here
        List<String> numbers = new ArrayList<String>();
        String line = "每月2次(週2/4) 2 Times Per Month (Week 2 / 4)";
        Pattern p = Pattern.compile("週\\d+");
        Matcher m = p.matcher(line); 
        while (m.find()) {
            //numbers.add(m.group());
            int n = Integer.parseInt(m.group());
            System.out.println("週  "+n);
        }
    }
}
