import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat;  //각 문자 반복할 횟수
        String str; //반복시킬 문자열
        int testCaseNum = sc.nextInt(); //주어질 테스트 케이스의 수
        int[] rpNums = new int[testCaseNum];
        String[] strs = new String[testCaseNum];    //테스트 케이스 개수만큼의 문자열들이 들어갈 배열

        for (int i = 0; i < testCaseNum; i++) {
            repeat = sc.nextInt();  //각 문자 반복할 횟수
            str = sc.next(); //반복시킬 문자열
            rpNums[i] = repeat;
            strs[i] = str;
        }

        for(int i = 0; i < testCaseNum; i++){   //테스트 케이스의 수만큼
            for (int j = 0; j < strs[i].length(); j++) {    //각 문자열의 길이만큼
                for (int k = 0; k < rpNums[i]; k++) {   //반복할 횟수만큼
                    System.out.print(strs[i].charAt(j));
                }
            }
            System.out.println();   //문자열 하나 출력하고나서 개행해주기 위함
        }
    }
}

