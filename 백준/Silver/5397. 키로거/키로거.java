
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        LinkedList<Character> list;
        while (T --> 0) {
            list  = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            String input = br.readLine();

            for (int i = 0; i < input.length(); i++) {
                char character = input.charAt(i);
                switch (character) {
                    case '<' -> {
                        if (iter.hasPrevious()) iter.previous();
                    }
                    case '>' -> {
                        if (iter.hasNext()) iter.next();
                    }
                    case '-' -> {
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                    }
                    default -> iter.add(character);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : list)
                sb.append(c);
            System.out.println(sb.toString());
        }
    }
}
