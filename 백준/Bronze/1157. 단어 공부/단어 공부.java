import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char wordChar[] = word.toCharArray();   //입력받은 문자열을 char 배열로 만들어줌
        int alpCount[] = new int[26];   //a~z까지의 알파벳만큼의 배열 생성, 0부터 a를 의미
        int max = 0;    //가장 많이 들어간 문자의 등장횟수
        int isDuplicated = 0;   //가장 많이 들어간 문자의 횟수가 중복되어 존재한다면(여러개라면) 이 값이 1 이상일것
        int maxCharIndex = 0;   //가장 많이 들어간 문자의 배열 인덱스

        for (char c : wordChar) {
            if (c >= 65 && c <= 90) {   //c가 숫자로 65~90범위 내라면 대문자라는 뜻
                alpCount[c - 'A'] += 1;
                if (alpCount[c - 'A'] > max) {  //만약 이게 max값보다 크면 값 갱신해준다
                    max = alpCount[c - 'A'];
                }
                //문자열의 각 문자를 꺼내와 해당 문자에 해당하는 인덱스의 값을 1씩 증가
            } else if (c >= 97 && c <= 122) {   //c가 숫자로 97~122범위 내라면 소문자라는 뜻
                alpCount[c - 'a'] += 1;
                if (alpCount[c - 'a'] > max) {  //만약 이게 max값보다 크면 값 갱신해준다
                    max = alpCount[c - 'a'];
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기

        for (int i = 0; i < 26; i++) {
            if (alpCount[i] == max) {
                isDuplicated++;
                maxCharIndex = i;
            }
        }

        if (isDuplicated > 1) {
            bw.write("?");
        } else {
            bw.write((char)(maxCharIndex + 65));  //65 더해주면 아스키코드상 대문자 수로 나옴
        }

        bw.flush();   
        bw.close();   



    }
}
