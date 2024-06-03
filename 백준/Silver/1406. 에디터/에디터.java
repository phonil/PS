
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

// Description : ListIterator 사용 ver.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++)
            list.add(s.charAt(i));

        // TODO : 만약 list.listIterator()를 호출하면 커서는 리스트의 시작 위치인 0번째 인덱스에 위치하게 되고,
        //  list.listIterator(list.size())를 호출하면 커서는 리스트의 끝에 위치하게 됩니다.
        ListIterator<Character> iter = list.listIterator(list.size());
        while (T --> 0) {
            String command = br.readLine();
            char operator = command.charAt(0);
            switch (operator) {
                case 'P' -> iter.add(command.charAt(2));
                case 'L' -> {
                    if (iter.hasPrevious()) iter.previous();
                }
                case 'D' -> {
                    if (iter.hasNext()) iter.next();
                }
                case 'B' -> {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                }
            }
        }
        for (Character c : list)
            sb.append(c);
        System.out.print(sb);
    }
}