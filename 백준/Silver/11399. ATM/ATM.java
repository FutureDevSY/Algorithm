import java.io.*;
import java.util.StringTokenizer;

public class Main {  //백준 11399번 ATM 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());   //사람의 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());    //각 사람마다 걸리는 시간 입력
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        //정렬부터
        int max = 0;
        int maxIndex = 0;
        int temp = 0;
        for (int i = 0; i < N; i++) {
            max = 0;
            for (int j = 0; j < N - i; j++) {
                if (max < seq[j]) {
                    max = seq[j];   //가장 큰 값 찾기
                    maxIndex = j;   //가장 큰 값 위치
                }
            }
            //교환
            temp = seq[N-i-1];
            seq[N-i-1] = max;
            seq[maxIndex] = temp;

        }
        int waitSum = 0;    //기다린 시간 합계
        temp = 0;
        for (int i = 0; i < N; i++) {
            waitSum += (seq[i] + temp); 
            temp += seq[i]; //seq[i]의 누적값 저장해서 계산 간단하게
        }
        bw.write(Integer.toString(waitSum));
        bw.flush();
        bw.close();
    }
}
