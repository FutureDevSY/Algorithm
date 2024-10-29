    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

public class Main {
      static int N, M;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            permutation(0, M, new int[M], 1);

      }

      static void permutation(int cnt, int M, int[] selected, int lastNum){
            if(cnt >= M){
                  for(int i : selected){
                        System.out.print(i + " ");
                  }
                  System.out.println();
                  return;
            }
            for (int i = lastNum; i <= N; i++) {
                  selected[cnt] = i;
                  permutation(cnt + 1, M, selected, i);
            }
      }

}
