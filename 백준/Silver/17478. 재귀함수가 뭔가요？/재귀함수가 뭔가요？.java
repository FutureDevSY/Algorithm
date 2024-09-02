import java.io.*;

    public class Main {
        static int N;
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static String[] ansArr = {"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
                "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());    //재귀호출 횟수
            bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
            bw.newLine();
            chatBot(0);
            bw.close();
        }

        static void printUnderbar(int n) throws IOException{
            for(int j=0; j<n; j++) {
                bw.write("____");
            }
        }

        static void chatBot(int n) throws IOException{
            printUnderbar(n);
            bw.write("\"재귀함수가 뭔가요?\"");
            bw.newLine();
            if(n >= N) {
                printUnderbar(n);
                bw.write("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
                bw.newLine();
                printUnderbar(n);
                bw.write("라고 답변하였지.");
                bw.newLine();
                return;
            }
            for(int i=0; i< ansArr.length; i++) {
                printUnderbar(n);
                bw.write(ansArr[i]);
                bw.newLine();
            }
            chatBot(n+1);
            printUnderbar(n);
            bw.write("라고 답변하였지.");
            bw.newLine();
        }
    }