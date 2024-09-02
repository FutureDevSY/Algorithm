import java.io.*;
import java.util.StringTokenizer;

public class Main {     //백준 주유소 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cityCnt = Integer.parseInt(br.readLine());  //도시의 개수
        long[] road = new long[cityCnt - 1];  //도시와 도시를 잇는 도로의 거리(비용)
        long[] cost = new long[cityCnt];  //각 도시별 기름값

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cityCnt - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cityCnt; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int cur = 0;    //어디까지 왔는지 인덱스 표시
        int temp = 1;   //처음으로 cur보다 기름값이 싼 도시의 인덱스
        long tmpDist = 0;    //cur~temp까지의 거리
        long minCost = 0;    //누적되는 기름값, 최소
        while (cur < cityCnt-1) {    //마지막 도시까지 도달할떄까지 구해준다
            while (temp < cityCnt && cost[cur] <= cost[temp]) {   //기름값이 더 싼 도시가 나타날때까지 반복
                temp++;
            }
            for (int i = cur; i < temp; i++) {
                if(i >= cityCnt - 1) break;
                tmpDist += road[i]; //temp까지의 거리를 구한다
            }
            minCost += tmpDist * cost[cur]; //현재 위치의 기름값 * temp까지의 거리를 곱해 비용계산
            cur = temp;
            temp++;
            tmpDist = 0;
        }
        bw.write(Long.toString(minCost));
        bw.flush();
        bw.close();
    }
}
