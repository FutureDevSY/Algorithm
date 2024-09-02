import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N, M;    //총 사람의 수, 총 파티 수
    static Queue<Integer> queue = new ArrayDeque<>(); //거짓말을 할 수 없는 사람 번호

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());   //진실을 알고있는 사람 수
        for(int i=0; i<S; i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        /* 파티에서 거짓말을 할수있는지 여부, 불가하면 TRUE 가능하면 FALSE */
        boolean[] ableToLie = new boolean[M];
        ArrayList<Integer>[] partyPpl = new ArrayList[M];   //각 파티에 참여하는 사람들을 나타내는 arrayList 배열 선언
        for(int i=0; i<partyPpl.length; i++){
            partyPpl[i] = new ArrayList<>();
        }

        int pplCnt;   //각 파티별 참여자수
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            pplCnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<pplCnt; j++){
                partyPpl[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int cantlie = 0;     //거짓말 못하는 횟수
        //queue안의 원소만큼 반복

        if(!queue.isEmpty()){
            while(!queue.isEmpty()){
                int check = queue.poll();
                for(int i=0; i<M; i++){
                    //만약 해당 파티 참석자에 check번 사람이 포함되어있으면서 해당 파티에서 거짓말을 할수있는지 여부가 false로 되어있다면
                    if(partyPpl[i].contains(check) && !ableToLie[i] ){
                        cantlie++;
                        ableToLie[i] = true;    //해당 파티에서는 거짓말을 할 수 없게 된다
                        for(int j=0; j<partyPpl[i].size(); j++){
                            // 함께 참석하는 다른 사람들도 거짓말 못하는 사람 목록에(없으면) 추가
                            if(!queue.contains(partyPpl[i].get(j))){
                                queue.add(partyPpl[i].get(j));
                            }
                        }
                    }
                }
            }
        }

        bw.write(Integer.toString(M - cantlie));
        bw.flush();
        bw.close();

    }
}