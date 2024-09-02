import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int cut = Integer.parseInt(br.readLine());  //자르는 횟수
        ArrayList<Integer> widths = new ArrayList<>();
        ArrayList<Integer> heights = new ArrayList<>();
        ArrayList<Integer> xcuts = new ArrayList<>();
        ArrayList<Integer> ycuts = new ArrayList<>();

        for (int i = 0; i < cut; i++) {
            st = new StringTokenizer(br.readLine());
            int xOrY = Integer.parseInt(st.nextToken());
            int tmp = Integer.parseInt(st.nextToken());
            if (xOrY == 0) {
                xcuts.add(tmp);
            } else {
                ycuts.add(tmp);
            }
        }
        Collections.sort(xcuts);
        Collections.sort(ycuts);

        int xStart = 0; int yStart = 0;
        int tmp;
        for (int i = 0; i < xcuts.size(); i++) {
            tmp = xcuts.get(i);
            heights.add(tmp - xStart);
            xStart = tmp;
        }
        for (int i = 0; i < ycuts.size(); i++) {
            tmp = ycuts.get(i);
            widths.add(tmp - yStart);
            yStart = tmp;
        }

        //가로로는 자르지 않거나 세로로는 자르지 않거나 아예 자르지 않는 경우도 고려하자
        if (xStart == 0 || xStart != height) {
            heights.add(height - xStart);   //마지막 높이도 넣어준다
        }
        if (yStart == 0 || yStart != width) {
            widths.add(width - yStart);
        }
        Collections.sort(widths, Collections.reverseOrder());   //내림차순 정렬
        Collections.sort(heights, Collections.reverseOrder());
        
        bw.write(Integer.toString(widths.get(0) * heights.get(0)));
        bw.flush();
        bw.close();

    }



}
