import java.util.*;


public class UserInput {

    public static void main(String[] args) {
        int counter = 1;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String line = in.nextLine();
            System.out.println(counter + " " + line);
            counter++;
        }
        in.close();
    }
}