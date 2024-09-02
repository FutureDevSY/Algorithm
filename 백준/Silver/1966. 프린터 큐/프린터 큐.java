import java.io.*;
import java.util.StringTokenizer;

class Queue {   //큐 클래스 구현
    final int arraySize = 1000;
    int[] arr;
    int front;  //맨 앞에있는 원소의 인덱스
    int rear;   //맨 뒤에있는 원소의 인덱스
    public Queue(){
        front = 0; rear = 0;
        arr = new int[arraySize];
    }

    boolean isQueueEmpty(){
        return front == rear;
    }

    boolean isQueueFull(){
        return rear == arraySize-1; //rear가 배열 바깥 벗어나는것 방지 위해 -1로 한것
   }

   void push(int data){
       if (isQueueFull()) {
           System.out.println("Queue가 꽉찼는데 push를한다?");
       } else {
           arr[rear] = data;
           rear++;
       }

   }

   int pop(){
       if (isQueueEmpty()) {
           System.out.println("Queue가 비었는데 pop이라?");
           return -1;
       } else {
           int popReturn = arr[front];
           front++;
           return popReturn;
       }
   }

   int peek(){
       if (isQueueEmpty()) {
           System.out.println("Queue가 비었는데 peek?");
           return -1;
       } else {
           int peekReturn = arr[front];
           return peekReturn;
       }
   }

}

public class Main { //백준 1966번 프린터 큐 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T; int N;
        int where;  //몇번째로 출력되는지 알아야 할 문서의 배열 내 위치점보
//        int[] tasks;    //N개 문서들의 중요도가 저장될 배열

        boolean isPrinted;    //몇번째로 출력되는지 알아야 할 문서가 출력되었는지 아닌지 여부
        int count=0;  //출력이 이루어질때마다 count 증가

        T = Integer.parseInt(br.readLine());    //테스트 케이스의 수

        for (int i = 0; i < T; i++) {
            //반복문 돌때마다 초기화 해줄 값들
            isPrinted = false;
            count = 0;
            Queue queue = new Queue();

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //문서의 개수
//            tasks = new int[N];
            where = Integer.parseInt(st.nextToken());    //몇번째로 출력되는지 알아볼 문서의 인덱스
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
//                tasks[j] = Integer.parseInt(st.nextToken());
                queue.push(Integer.parseInt(st.nextToken()));
            }

            while (!isPrinted) {    //해당 문서가 출력될때까지만 반복
                int fr = queue.front;
                boolean hasBigger = false;  //뒤에 더 중요도 높은 문서가 있는지를 의미
                for (int j = fr + 1; j < queue.rear; j++) {
                    if(queue.arr[queue.front] < queue.arr[j]){
                        hasBigger = true;
                    }
                }
                if (hasBigger) {    //현재 front에 있는 수보다 더 큰(중요도 높은) 문서가 있다면
                    if (queue.front == where) { //그 문서가 현재 front에 있는거라면 pop,rear에 push, 위치정보 갱신
                        queue.push(queue.pop());
                        where = queue.rear - 1;   //맨 뒤의 위치로 where 갱신
                    } else {    //아니라면 pop push만 수행
                        queue.push(queue.pop());    //  pop하고 그 값을 다시 push
                    }

                } else {    //현재 front에 있는 수보다 더 큰(중요도 높은) 문서가 없다면 출력 수행!
                    if (queue.front == where) { //그 문서가 현재 front에 있는거라면 count 증가시키고 빠져나감
                        count++;
                        isPrinted = true;
                    } else {
                        queue.pop();    //  push는 할필요없음
                        count++;
                    }

                }
            }
            bw.write(Integer.toString(count));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
