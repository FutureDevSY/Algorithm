import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //장소의 개수
        int[] hives = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            hives[i] = Integer.parseInt(st.nextToken());
        }
        //N이 3이라면 셋중 가장 큰 수 * 2가 정답
        if(N == 3){
            System.out.println(Math.max(hives[0], Math.max(hives[1], hives[2])) * 2);
        }else{
            //벌집 위치 정하기
            int[] sumArrA = new int[N];
            int[] sumArrB = new int[N];

            int beeFirstSum = 0;
            int beeSecondSum = 0;
            int sumMax = 0;

            for(int i=0; i<N; i++){
                if(i==0) sumArrA[i] = hives[i];
                else sumArrA[i] = sumArrA[i-1] + hives[i];
            }
            for(int i=N-1; i>=0; i--){
                if(i==N-1) sumArrB[i] = hives[i];
                else sumArrB[i] = sumArrB[i+1] + hives[i];
            }

            //벌집을 맨 오른쪽에 놓는게 나을경우
//            if(hives[0] <= hives[N-1]){
                //두번째 벌의 위치정해보면서 최대값 찾기
                for(int i=1; i<N-1; i++){
                    beeFirstSum = sumArrA[N-1] - hives[0] - hives[i];
                    beeSecondSum = sumArrA[N-1] - sumArrA[i];
                    sumMax = Math.max(sumMax, beeFirstSum + beeSecondSum);
                }
            //벌집을 맨 왼쪽에놓는게 나을경우는 반대로 탐색
//            }else{
                for(int i=N-2; i>0; i--){
                    beeFirstSum = sumArrB[0] - hives[N-1] - hives[i];
                    beeSecondSum = sumArrB[0] - sumArrB[i];
                    sumMax = Math.max(sumMax, beeFirstSum + beeSecondSum);
                }
//            }

            //벌통이 가운데 있는것이 최적인경우일수도
            for(int i=1; i<N-1; i++){
                beeFirstSum = sumArrA[i] - hives[0];
                beeSecondSum = sumArrB[i] - hives[N-1];
                sumMax = Math.max(sumMax, beeFirstSum + beeSecondSum);
            }

            System.out.println(sumMax);

        }




      }
}
