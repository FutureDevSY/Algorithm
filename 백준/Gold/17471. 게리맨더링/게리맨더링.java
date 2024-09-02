import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;	//구역의 개수
	static int parents[];
	static int[] population;	//구역별 인구수
	static List<Integer>[] connected;
	private static void make() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;	
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
//		return find(parents[a]);
		//path compression 적용
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {	//a가 속한 집합과 b가 속한 집합을 합칠수 있다면 합치는 연산
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;	//이미 같은 집합(대표자가 같음
		//union 처리(bRoot를 aRoot 아래로 붙일것임.일단 임의로..
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		population = new int[N+1];
		connected = new ArrayList[N+1];	//인접 정점들 표시할 리스트
		for(int i=0; i<N+1; i++) {
			connected[i] = new ArrayList<>();
		}
		make();
		
		for(int i=1; i<=N; i++) {
			population[i] = sc.nextInt();
		}
		
		int tmp, cnt;
		for(int i=1; i<=N; i++) {
			cnt = sc.nextInt();
			for(int j=0; j<cnt; j++) {
				tmp = sc.nextInt();
				union(i, tmp);
				if(!connected[i].contains(tmp)) connected[i].add(tmp);
				if(!connected[tmp].contains(i)) connected[tmp].add(i);
			}
		}
		
		List<Integer> li = new ArrayList<>();
		int tmp2;
		for(int i=1; i<=N; i++) {
			tmp2 = find(i);
			if(!li.contains(tmp2)) li.add(tmp2);
		}//li에 들어가있는 원소 개수가 연결된 구역의 개수
		
		if(li.size() == 1) {
			comb();
		}else if(li.size() == 2) {	//구역이 이미 두개 나뉘어져있는경우
			int t1, t2;
			t1 = t2 = 0;
			int area1 = li.get(0);
			int area2 = li.get(1);
			for(int i=1; i<=N; i++) {
				if(find(i) == area1) t1 += population[i];
				else if(find(i) == area2) t2 += population[i];
			}
			min = Math.abs(t1 - t2);
		}else {
			min = -1;
		}
		
		System.out.println(min);
	}
	
	private static boolean bfs(List<Integer> otherLi, List<Integer> thisLi) {	//조합으로 뽑아놓은 애들이 서로 연결될수 있는지
		//가다가 안뽑은 원소 있으면 리턴해야함
		int checkCnt = 1;	//시작원소 포함해서 리스트 크기만큼 방문할때마다 카운트,리스트 크기만큼이 되면 다 방문가능하단말
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		if(otherLi.isEmpty() || thisLi.isEmpty()) return false;
		q.add(thisLi.get(0));
		visited[thisLi.get(0)] = true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=0; i<connected[tmp].size(); i++) {
				int p = connected[tmp].get(i);
				if(otherLi.contains(p) || visited[p]) continue;	//다른 그룹에서 해당 원소를 갖고있다면 그쪽으로 못가므로
				q.add(p);
				visited[p] = true;
				checkCnt++;
			}
			if(checkCnt == thisLi.size()) break;
		}
		if(checkCnt == thisLi.size()) return true;
		return false;
	}
	
	
	static int min = Integer.MAX_VALUE;
	static int sum1, sum2;
	private static void comb() {
		List<Integer> otherLi = new ArrayList<>();
		List<Integer> thisLi = new ArrayList<>();
		
		for(int i=1; i<(1<<N);i++) {
			for(int j=0; j < N; j++) {
				if((i & (1<<j)) != 0) {
					sum1 += population[j+1];
					thisLi.add(j+1);
				}else {
					sum2 += population[j+1];
					otherLi.add(j+1);
				}
			}
			if(bfs(thisLi, otherLi) && bfs(otherLi, thisLi)) {	//두 그룹 모두 각각 연결될수 있을때 
				min = Math.min(min, Math.abs(sum1 - sum2));
			}
			sum1 = sum2 = 0;
			otherLi.clear();
			thisLi.clear();

		}		
	
	}
	
}
