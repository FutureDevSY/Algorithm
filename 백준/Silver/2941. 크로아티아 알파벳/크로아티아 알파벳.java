import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int count = 0;
 
        for (int i=0; i<input.length(); i++) {   //그냥 문자열길이만큼 반복하기로 함
            if (input.contains("c=")) {
                count++;
                input = input.replaceFirst("c=", " ");   //해당 크로아티아 알파벳을 빈문자열로 대체해 소거
            }else if(input.contains("c-")){
                count++;
                input = input.replaceFirst("c-", " ");   //해당 크로아티아 알파벳을 빈문자열로 대체해 소거
            }else if(input.contains("dz=")){
                count++;
                input = input.replaceFirst("dz=", " ");   //해당 크로아티아 알파벳을 빈문자열로 대체해 소거;
            }else if(input.contains("d-")){
                count++;
                input = input.replaceFirst("d-", " ");   //해당 크로아티아 알파벳을 빈문자열로 대체해 소거
            }else if(input.contains("lj")){
                count++;
                input = input.replaceFirst("lj", " ");   //해당 크로아티아 알파벳을 빈문자열로 대체해 소거
            }else if(input.contains("nj")){
                count++;
                input = input.replaceFirst("nj", " ");   //해당 크로아티아 알파벳을 빈문자열로 대체해 소거
            }else if(input.contains("s=")){
                count++;
                input = input.replaceFirst("s=", " ");   //해당 크로아티아 알파벳을 빈문자열로 대체해 소거
            }else if(input.contains("z=")){
                count++;
                input = input.replaceFirst("z=", " ");   //해당 크로아티아 알파벳을 빈문자열로 대체해 소거
            }
        }

        input = input.replace(" ", "");
        count += input.length();    //남은 문자열 갯수를 더한다
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();

    }
}