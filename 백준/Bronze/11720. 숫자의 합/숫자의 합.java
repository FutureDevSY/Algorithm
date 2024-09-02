import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String input = sc.next();   //next는 개행문자를 건너띄고 입력을 받지만 nextLine은 개행문자까지 받아들인다.
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += input.charAt(i) - '0';

        }
        System.out.print(sum);

    }
}