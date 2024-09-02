import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //길이가 1인경우?
        int start, end, sum, minlng;
        sum = start = end = minlng = 0;

        //최초의 S 이상이되는 부분합을 찾는다
        for(int i=0; i<N; i++){
            sum += arr[i];
            if(sum >= S) {
                end = i;
                minlng = i + 1;
                break;
            }
        }
        if(minlng != 0){
            start = 1;
            sum -= arr[0];
            while (true){
                if(start > end || end >= N) break;
                if(sum >= S){
                    minlng = Math.min(minlng, end - start + 1);   //길이갱신
                    sum -= arr[start];
                    start++;
                }else{
                    end++;
                    if(end < N){
                        sum += arr[end];
                    }
                }
            }
        }

        bw.write(Integer.toString(minlng));
        bw.flush();
    }
}
