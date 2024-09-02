import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int wordCount = Integer.parseInt(br.readLine());   //단어 개수 입력받기
        String[] words = new String[wordCount]; //입력받을 단어 개수 크기의 배열 생성
        String alp;    //이게 뭐더라
        boolean flag;
        int k = 0;
        int count = 0;

        for (int i = 0; i < wordCount; i++) {
            words[i] = br.readLine();
            alp = "";   //바깥의 for문을 돌떄마다 비워줘야함!!
            flag = true;    //이것도 바깥for문 한번씩 돌떄마다 true로 해줘야함!!
            for (int j = 0; j < words[i].length(); j++) {   //각 단어의 길이만큼 끝까지 확인
                if (alp.contains(Character.toString(words[i].charAt(j)))) {  //배열에 해당 문자가 있는지 확인, 있다면
                //여기서 뭔가 잘못한듯..
                    if (words[i].charAt(j) != words[i].charAt(j - 1)) { //바로 앞의 문자와 해당 문자가 다르다면!
                        flag = false;
                    }
                }else{  //배열에 해당 문자가 없다면
                    alp += words[i].charAt(j);    //해당 문자 alp배열에 저장
                    k++;
                }
                if (!flag) {    //아니 인텔리제이 머임? flag = false로 비교문 잘못써놨는데 그냥 컴파일해버림;
                    break;  //더 볼것도없이 안쪽 for문을 빠져나가도 될듯
                }
            }
            if (flag) {  //단어 하나를 다 체크했는데 끝까지 flag가 true로 남아있었다면
                count++;
            }
        }

        bw.write(Integer.toString(count));  //다시 String으로 바꾸는거 잊지말기
        bw.flush(); //비우기
        bw.close(); //닫기



   }
}
