import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {    //백준 13023번 ABCDE 문제
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();	//친구 관계 저장 리스트
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //N은 사람의 수
        int M = Integer.parseInt(st.nextToken());   //M은 관계의 수
        
        for(int i=0;i<N;i++)		//그래프 초기화
            graph.add(new ArrayList<>());

        int a; int b;
        //인접리스트 채우기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);    //a 리스트에 b 추가, a-b는 관계가 있음 나타냄
            graph.get(b).add(a);    //관계는 양방향이므로 반대로도 해줌
        }
        visited = new boolean[N];

        for(int i=0;i<N;i++) {		//각 노드 기준 DFS 탐색 시작
            dfs(i,1);
        }
        bw.write("0");  //끝끝내 없었으면 0 출력
        bw.flush();
        bw.close();
    }

    static void dfs(int n, int count) throws IOException {  //탐색할 노드와 횟수(5번이 되면 성공), count는 1에서 시작
        if (count == 5) {
            bw.write("1");
            bw.flush();
            bw.close();
            System.exit(0); //확인됐으면 더 볼 필요 없으므로 종료
        }
        visited[n] = true;  //방문체크
        for(int i=0;i<graph.get(n).size();i++) {
            if(!visited[graph.get(n).get(i)]) {	//n번 노드의 i번째를 아직 방문 안한경우
                dfs(graph.get(n).get(i),count+1);   //해당 i번째 노드의 관계를 살펴본다, 카운트 증가
            }
        }
        visited[n] = false;
        return;
    }
}
