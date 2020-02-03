/*
 * Code Author: Akshay Miterani
 * DA-IICT
 */
import java.io.*;
import java.util.*;

public class AmritaGraphCopy {

    InputReader in;
    PrintWriter out;
    AmritaGraphCopy() throws IOException {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String args[]) {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new AmritaGraphCopy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();
    }

    //--------------------My Code Starts Here----------------------
    static long mod=(long)1e9+7;
    public void solve() {
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            Pair p[]=new Pair[n];
            for(int i=0;i<n;i++){
                p[i]=new Pair(in.nextInt(), in.nextInt());
            }
            Arrays.sort(p);
            long dp[]=new long[n+1];
            long ans=0;
            for(int i=1;i<=n;i++){
                dp[i]=p[i-1].y;
                for(int j=1;j<i;j++){
                    if(p[j-1].y<p[i-1].y && p[j-1].x<p[i-1].x)
                        dp[i]=Math.max(dp[i], dp[j]+p[i-1].y);
                }
                ans=Math.max(ans, dp[i]);
            }
            out.println(ans);
        }
    }
    //---------------------My Code Ends Here------------------------

    static long modulo(long a,long b,long c) {
        long x=1;
        long y=a;
        while(b > 0){
            if(b%2 == 1){
                x=(x*y)%c;
            }
            y = (y*y)%c; // squaring the base
            b /= 2;
        }
        return  x%c;
    }
    static class Pair implements Comparable<Pair>{
        int x;
        int y;

        Pair(int xx,int yy){
            x=xx;
            y=yy;
        }
        @Override
        public int compareTo(Pair o) {
            if(Long.compare(this.y, o.y)!=0)
                return Integer.compare(this.y, o.y);
            else
                return Long.compare(this.x, o.x);
        }
    }
    public static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream inputstream) {
            reader = new BufferedReader(new InputStreamReader(inputstream));
            tokenizer = null;
        }

        public String nextLine(){
            String fullLine=null;
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    fullLine=reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return fullLine;
            }
            return fullLine;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}     