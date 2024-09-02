import java.io.*;
import java.util.Arrays;

public class Main {   //백준 2309번 일곱난쟁이 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dwarfs = new int[9];  //9명의 난쟁이들 키
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dwarfs);    //정렬부터

        int count = 0; int sum = 0;
        for (int i = 0; i < 9; i++) {
            if(sum == 100) break;   //완전 빠져나가기 위해 break 한번더써줌
            for (int j = i + 1; j < 9; j++) {
                sum = 0;
                for (int k = 0; k < 9; k++) {
                    if (k == i || k == j) {
                        continue;   //i,j번째는 가짜난쟁이로 일단 간주하므로 건너뜀
                    }
                    sum += dwarfs[k];
                }
                if (sum == 100) {
                    for (int h = 0; h < 9; h++) {
                        if (h == i || h == j) { //가짜난쟁이 빼고 출력
                            continue;
                        }
                        bw.write(Integer.toString(dwarfs[h]));
                        bw.newLine();
                    }
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
