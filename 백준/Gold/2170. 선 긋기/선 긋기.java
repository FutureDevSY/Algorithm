import java.io.*;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line>{
        int start;
        int end;
        Line(int s, int e){
            //반대 방향으로 그리는경우 고려 
            if(s > e){
                start = e;
                end = s;
            }else{
                start = s;
                end = e;
            }

        }

        @Override
        public int compareTo(Line o) {
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    //입력되는 선분 개수
        int x, y;
        List<Line> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            list.add(new Line(x, y));
        }
      Collections.sort(list);

        int sumLength = 0;
        int start = 0;
        int end = 0;

        //첫번째는 그냥 넣어준다
        start = list.get(0).start;
        end = list.get(0).end;

        for (int i=1; i<list.size(); i++) {
            if(list.get(i).start <= end){ //기존 start~end 사이 범주에서 시작된다먄
                if((list.get(i).end - end) <= 0) continue;  //길이를 연장할수 없는경우 패스
                end = list.get(i).end;  //연장
            }else{  //범주 밖, 끊겨있다면
                sumLength += end - start;   //지금까지 연장한 선분 길이 더해줌
                //새로운 선분의 시작,끝점 생성
                start = list.get(i).start;
                end = list.get(i).end;
            }
        }
        sumLength += end - start;

        bw.write(Integer.toString(sumLength));
        bw.flush();


    }
}
