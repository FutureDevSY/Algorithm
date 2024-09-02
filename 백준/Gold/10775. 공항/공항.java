import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int G = Integer.parseInt(br.readLine());	//게이트의 수
		int P = Integer.parseInt(br.readLine());	//비행기의 수
		int[] gates = new int[G+1];
		int[] lastDockIdx = new int[G+1];	//각 비행기별 가장 마지막으로 도킹한 게이트 위치
		//예를들어 연속으로 4, 4가 나왔다면 4(-1)번째에 3(-1)이 저장되게 된다
		int gate = 0;
		int dockIdx = 0;
		int dockCnt = 0;
		int gIdx = 0;
		
		int i = 0;
		gate = Integer.parseInt(br.readLine());
		dockIdx = gate - 1;
		while(true) {	//도킹
			//모든 비행기가 다 도킹되었다면
			if(i > P-1) break;
			//도킹할수 없는경우
			if(dockIdx < 0) break;	
			
			if(gates[dockIdx] == 0) {
				gates[dockIdx] = gate;
				lastDockIdx[gate] = dockIdx;
				dockCnt++;
				i++;
				if(i <= P-1) gate = Integer.parseInt(br.readLine());
				if(lastDockIdx[gate] != 0) {
					//해당 번호에서 마지막으로 도킹한 게이트 정보 가져오기,시간절약위함 
					dockIdx = lastDockIdx[gate];
				}else dockIdx = gate - 1; 
				
			}else {
				dockIdx--;
			}
		}
		
		bw.write(Integer.toString(dockCnt));
		bw.flush();
		

	}

}
