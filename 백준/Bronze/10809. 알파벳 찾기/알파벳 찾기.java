import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] alpIndex = new int[26];   //a~z까지의 26크기의 배열 생성
        Arrays.fill(alpIndex, -1);  //-1로 배열 초기화
        Scanner sc = new Scanner(System.in);
        String S = sc.next();   //단어 S 입력받기
        int alpNum;     //a는 0, b는 1,,
        for (int i = S.length() - 1; i >= 0; i--) {  //헷갈리지말자 문자열길이는 .length(), 배열길이는 .length (이건 괄호없음)
            //배열의 0번째부터 a를 나타내고, 해당 자리에 index를 할당
            alpNum = S.charAt(i) - 97;  //문자열의 맨 앞의 문자에서 97을 빼면 해당하는 순번의 배열 번호이다
            alpIndex[alpNum] = i;
        }

        for (int i : alpIndex) {
            System.out.print(i + " ");
        }
    }
}
