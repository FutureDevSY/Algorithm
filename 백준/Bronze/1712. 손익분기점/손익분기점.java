import java.io.*;
import java.util.StringTokenizer;

public class Main {
    //손익분기점 계산 알고리즘
    //가변비용(b, 한대의 노트북을 생산하는데 드는 재료비와 인건비)는 판매금액(c)보다 높으면 아무리 팔아도 손익분기점이 존재할수 없다.
    //a=고정비용, b=가변비용, c=판매금액
    //c-b를 한 값이 한대를 팔았을때 얻는 이득이므로 여기서 얼마를 곱해야 a보다 값이 커지느냐가 정답일듯.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int sellCount = 0;  //손익분기점이 일어나는 판매개수
        while ((C - B) * sellCount <= A) {
            if (B >= C) {   //B가 C보다 크다면 손익분기점이 일어날수 X
                sellCount = -1;
                break;
            }
            sellCount++;
        }

        bw.write(Integer.toString(sellCount));  
        bw.flush(); //비우기
        bw.close(); //닫기

    }




}
