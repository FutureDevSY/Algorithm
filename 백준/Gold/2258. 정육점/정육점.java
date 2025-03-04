import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Meat implements Comparable<Meat>{
        long weight;
        long price;

        public Meat(long w, long p){
            this.weight = w;
            this.price = p;
        }

        @Override
        public int compareTo(Meat o) {
            if(this.price == o.price){
                return (int)o.weight - (int)this.weight;
            }else return (int)this.price - (int)o.price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;   //덩어리 개수, 필요한무게
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Meat[] meats = new Meat[N];
        int w, p;
        int weightSum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            meats[i] = new Meat(w, p);
            weightSum += w;
        }

        Arrays.sort(meats);

        if(M > weightSum) System.out.println(-1);
        else{
            long lastPrice = meats[0].price;
            //무게 누적합
            for (int i = 1; i < N; i++) {
                //이전과 가격이 같으면 가격도 누적
                if(meats[i].price == lastPrice){
                    meats[i].price += meats[i-1].price;
                }else{
                    lastPrice = meats[i].price;
                }
                meats[i].weight += meats[i - 1].weight;
            }

            //다시정렬하는것보다는..
            long result = Long.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if(meats[i].weight >= M){
                    result = Math.min(result, meats[i].price);
                }
            }
            System.out.println(result);
        }


    }
}
