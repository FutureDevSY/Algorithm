import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ppl = new int[N];
        List<Integer> li = new ArrayList<Integer>();
        for(int i=0; i<N; i++){
            ppl[i] = sc.nextInt();
        }
        for(int i=N-1; i>=0; i--){
            li.add(ppl[i], i+1);
        }

        for(int i : li){
            System.out.print(i + " ");
        }
    }
}
