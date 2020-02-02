import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++)
            list.add(i+1);
        String input=br.readLine();
        int i=0,j=0;
        int len=input.length();
        while(list.size()!=1) {
                if (input.charAt(i) == 'b') {
                    list.remove(j);
                    j--;
                }
                i = (++i) % len;
                j = (++j) % list.size();
        }
        System.out.println(list.get(0));

    }
}
