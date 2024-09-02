import java.io.*;

public class Main {    //백준 2839번 설탕 배달 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //맞춰야 하는 설탕의 양 입력받음
        int n = N;
        int bigBag = 0; //5kg짜리 봉지
        int smallBag = 0;   //3kg짜리 봉지
        int maxBigCount = 0;    //5kg짜리가 최대 들어갈수 있는 개수(남은 중량 고려x)

        while (n >= 5) {   //일단 5kg 봉지가 최대 얼마나 들어갈 수 있는지를 알아본다
            n -= 5;
            maxBigCount++;
        }
        
        for (int i = maxBigCount; i >= 0; i--) {    //5kg봉지 넣을수있는 최대 개수 ~ 최악경우 0개까지
            smallBag = 0;
            n = N;
            n = n - (i * 5);
            while (3 <= n) {
                n -= 3;
                smallBag++;
            }
            if (n == 0) {
                bigBag = i; //bigBag개수 저장
                break;  //찾았으니 탈출
            }
        }
        if (n == 0) {   //최선의 딱맞는 값을 찾았다면
            bw.write(Integer.toString(bigBag + smallBag));
        } else {    //끝까지 다 살펴봤는데 딱맞는 값이 없었을때(break로 빠져나가지 못한경우,잉여가 남아있을경우)
            bw.write("-1");
        }
        bw.flush();
        bw.close();
    }
}
