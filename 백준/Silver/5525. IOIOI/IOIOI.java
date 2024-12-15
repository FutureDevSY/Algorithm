import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int targetLng = N * 2 + 1;
            String S = br.readLine();
            int[] cntArr = new int[S.length()];

            int curIdx = 0;
            int cnt = 0;

            while(curIdx < S.length()){
                  if(curIdx != 0 && S.charAt(curIdx) == 'I' && S.charAt(curIdx - 1) == 'O'){
                        if(curIdx >= 2) cntArr[curIdx] = cntArr[curIdx - 2] + 1;
                        else cntArr[curIdx] = 1;

                        if(cntArr[curIdx] >= N && curIdx - (N * 2) >= 0){
                              if(S.charAt(curIdx - (N * 2)) == 'I'){
                                    cnt++;
                              }
                        }
                        curIdx = curIdx + 2;
                  }else{
                        curIdx = curIdx + 1;
                  }
            }

            bw.write(Integer.toString(cnt));
            bw.close();
      }

}
