import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] adjList;
	static int[] inDegree;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adjList = new ArrayList[N+1];
		inDegree = new int[N + 1];

		for(int i=0; i<=N; i++) adjList[i] = new ArrayList<>();
		
		for (int i = 0; i < M; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			++inDegree[to];
		}
		
		topologySort();

	}

	private static void topologySort() {
		ArrayList<Integer> orderList = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; ++i) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			
			for(int v : adjList[cur]) {
				if(--inDegree[v] == 0) {
					queue.offer(v);
				}
			}
		}
	}
}