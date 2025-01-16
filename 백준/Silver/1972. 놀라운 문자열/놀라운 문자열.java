import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String input;
            String output;
            int strLng;
            input = br.readLine();
            while(!input.equals("*")){
                  strLng = input.length();
                  output = " is surprising.";
                  ArrayList<String> list = new ArrayList<>();
                  StringBuilder sb = new StringBuilder();
                  String result;
                  out : for (int i = 1; i <= strLng - 2; i++) {
                        for (int j = 0; j < strLng; j++) {
                              if(j + i > strLng - 1) continue;
                              sb.append(input.charAt(j));
                              sb.append(input.charAt(j + i));
                              result = sb.toString();
                              if(list.contains(result)){
                                    output = " is NOT surprising.";
                                    break out;
                              }
                              list.add(result);
                              sb = new StringBuilder();
                        }
                        list = new ArrayList<>();
                  }
                  bw.write(input + output);
                  bw.write('\n');

                  input = br.readLine();
            }
            bw.close();
      }

}