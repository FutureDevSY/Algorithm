import java.io.*;
public class Main {

        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String input = br.readLine();


            String reverseStr = "";
            for(int i=input.length()-1; i>=0; i--){
                reverseStr += input.charAt(i);    //문자를 거꾸로 다시 만듦. 자동형변환 가능??
            }
            String[] words = reverseStr.split(" ");

            if(Integer.parseInt(words[0]) > Integer.parseInt(words[1])){
                bw.write(words[0]);
            }else{
                bw.write(words[1]);
            }

            bw.flush();
            bw.close();
        }

}
