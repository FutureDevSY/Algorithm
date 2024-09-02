import java.util.Scanner;

public class Main {   //한수, 한수는 수의 각 자리가 등차수열을 이루는 수를 의미
    public static int countHnum(int n) {     //1~n까지의 한수들의 개수 출력
        int m = n;
        int hun, ten, one;  //100의자리, 10의자리, 1의자리
        int gap1, gap2;
        int count = 0;  //한자리, 두자리 수들은 아묻따 등차수열이다 (아닌줄알았음
        if (m < 100) {  //n이 1~99의 범위내의 수라면 더 볼것도 업다
            count = m;
        } else {
            if (m == 1000) {    //1000은 등차수열이 아니므로 그냥 999라고 치고 계산시킨다
                m = 999;
            }
            for (int i=100; i<=m; i++) { //100~m까지만 확인하면됨
                hun = i / 100;
                ten = (i / 10) % 10;
                one = i % 10;
                gap1 = hun - ten;   //백의자리수 - 십의자리수
                gap2 = ten - one;   //십의자리수 - 일의자리수
                if (gap1 == gap2) { //같다면 등차수열
                    count++;
                }
            }
            count += 99;    //앞에는 생략하고 100부터 계산한거니까 1~100까지 등차수열의 갯수 99를 더해준다!!
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;  //입력받을 수
        int result;
        N = sc.nextInt();
        result = countHnum(N);
        System.out.println(result);

    }
}