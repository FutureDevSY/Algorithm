import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char ch = sc.nextLine().charAt(0);  //문자 입력받으려면 이렇게 해야한다고 했던듯. nextChar 만들어줘 ㅡㅡ
            int in = (int) ch;
            System.out.println(in);
        }

}