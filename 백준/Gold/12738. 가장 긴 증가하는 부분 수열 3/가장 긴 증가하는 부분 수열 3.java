import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(arr[0]);
        for (int i = 1; i < N; i++) {
            if(arr[i] > lis.get(lis.size() - 1)){
                lis.add(arr[i]);
            }else{
                lis.set(binarySearch(0, lis.size() - 1, arr[i]), arr[i]);
            }
        }

        System.out.print(lis.size());


    }

    private static int binarySearch(int left, int right, int x){
        int mid;

        //lowerbound!!
        while(left < right){
            mid = (left + right) / 2;

            if(lis.get(mid) < x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        //right??
        return right;
    }
}
