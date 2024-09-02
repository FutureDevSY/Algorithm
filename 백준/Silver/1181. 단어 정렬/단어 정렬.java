import javax.imageio.IIOException;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main {  //백준 1181번 단어정렬 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //입력될 단어의 수
        String[] words = new String[N];
        int[] wordCount = new int[N];   //각 단어의 길이를 담을 배열
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();   //단어 입력받고
        }

        int max = 0; int maxIndex = 0;
        String compareM; String compareJ; String temp = ""; int tmp;
        int intM; int intJ;

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(words));
        // LinkedHashSet을 배열로
        words = linkedHashSet.toArray(new String[0]);

        int length = words.length;
        for (int i = 0; i < length; i++) {
            max = 0;    //가장 긴 문자열원소의 길이
            for (int j = 0; j < length - i; j++) {
                if (words[j].length() > max) {
                    max = words[j].length();
                    maxIndex = j;
                } else if (words[j].length() == max) {
                    compareM = words[maxIndex]; //비교할 단어
                    compareJ = words[j];
                    for (int k = 0; k < words[maxIndex].length(); k++) {
                        intM = compareM.charAt(k);  //자동형변환 char -> int (반대는 명시적 형변환?뭐더라)
                        intJ = compareJ.charAt(k);
                        if (intM < intJ) {  //j가 정수형으로 바꿨을떄 더 큰수가 된다는건 더 뒤에있는 문자라는 의미일테니까 뒤에 배치되도록
                            max = words[j].length();
                            maxIndex = j;
                            break;  //중간에 브레이크 안하면 맨 마지막 문자만 비교하는꼴이 된다!!
                        }else if (intM > intJ) {
                            break;  //바꿀건 없다
                        }
                    }
                }

            }
            //교환
            temp = words[length-i-1];
            words[length-i-1] = words[maxIndex];
            words[maxIndex] = temp;
        }

        for (int i = 0; i < length; i++) {
            bw.write(words[i]);
            bw.newLine();

        }
        bw.flush();
        bw.close();




    }
}
