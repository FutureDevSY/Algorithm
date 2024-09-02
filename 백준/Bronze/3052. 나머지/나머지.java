import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static final int input = 10;    //입력받을 자연수 개수는 10개로 고정

    public static void main(String[] args) throws IOException { //readLine때문에 예외처리 해줘야함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nums = new int[input];
        //한줄씩 들어오는 입력값에 42를 나눈 나머지값 저장
        for (int t = 0; t < input; t++) {
            nums[t] = Integer.parseInt(br.readLine()) % 42;
        }
//         중복된 원소를 제거하기위해 HashSet으로 변환
        HashSet<Integer> hashSet = new HashSet<>();
        for(int item : nums){
            hashSet.add(item);
        }

        bw.write(Integer.toString(hashSet.size()));
        bw.flush();
        bw.close();





    }


}
