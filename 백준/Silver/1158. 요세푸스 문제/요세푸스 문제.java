import java.io.*;
import java.util.StringTokenizer;

class Node {    //원형 연결리스트를 구성하는 노드 클래스
    int data;
    Node link;  //참조할 다음 노드

    //생성자, 객체생성시 변수들 초기화
    public Node(){
        this.data = 0;
        this.link = null;
    }
    public Node(int data){
        this.data = data;
        this.link = null;
    }

    public Node(int data, Node link) {
        this.data = data;
        this.link = link;
    }

    public int getData(){
        return this.data;
    }
}

class CircularLinkedList{
    Node head;  //리스트의 맨 마지막 노드를 참조함
    private Node start; //K번째 노드를 삭제하려고 할때, 시작점이 될 노드
    private Node preNode;   //start노드의 이전 노드정보를 참조할 노드

    public CircularLinkedList(){
        head = null;
        start = null;
    }
    //맨 끝, 마지막에 노드 삽입하기
    public void insertNode(int data){
        Node newNode = new Node(data);

        if (head == null) { //만약 head가 null이라면 비어있다는 의미이므로 바로 head가 newNode 가리키게 하면 됨
            this.head = newNode;    //여기에도 꼭 this.붙여야하나?
            this.start = this.head;
            this.head.link = this.head; //노드가 하나만 들어와있는 상황, 자기 자신을 가리킨다(원형이니까)
        }else{
            Node tempNode = head;       //head값을 참조하는 임시 node변수
            while (tempNode.link != head) { //tempNode말고 tempNode의 link가 null이 될때까지를 반복해야한다, tempNode가 맨 마지막 노드가 될때까지
                tempNode = tempNode.link;   //link, 즉 다음 노드를 쭉 쭉 참조한다 null값 올때까지. 여기선 New생성자 없어도 되나?
            }
            tempNode.link = newNode;
            newNode.link = head;    //원형 구조이기 때문에 마지막에 오는 이 newNode가 다시 head를 참조하게 해야함!
        }

    }

    public int deleteNode(int K){   //K번째 노드 삭제하기(중간에 있는 노드)
//        if (start == head) { //start가 아직 움직이지 않은 최초상태라면
//            preNode = null;    //null에서 시작한다
//        }
//        Node start = head.link;

        for (int i = 0; i < K-1; i++) {   //start노드에서 시작해 세번째에 있는 노드를 찾음, K-2번 건너감
            preNode = start;
            start = start.link; //다음 노드를 참조하게 함
        }
        if (K == 1) {   //예외:K가 1일경우, head를 가리키는 노드, 즉 맨 끝 노드를 찾아야함
            preNode = start;
            while (preNode.link != start) {
                preNode = preNode.link;
            }
        }
        Node tempNode = start;   //임시변수node에 원래 preNode가 가리키던 다음노드, 즉
        preNode.link = start.link;  //prenode가 start가 가리키는 노드 그 다음의 노드를 가리키게 함..어근데 이 preNode랑 insert때 생긴 노드랑 다른객체 아닌가?
        start = start.link; //start는 다음으로 건너감

        return tempNode.data;    //삭제된 노드의 data값 반환
    }
}


public class Main { //백준 1158번 요세푸스 순열 문제
    public static void main(String[] args) throws IOException {
        CircularLinkedList cll = new CircularLinkedList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        int N = 0;  //1부터 N까지
        int K = 0; //K번째 순서대로 제거

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] result = new int[N];  //결괏값 출력을 위한 배열

        for (int i = 1; i <= N; i++) {  //1~N까지 노드 생성
            cll.insertNode(i);
        }

        for (int i = 0; i < N; i++) {   //삭제연산 N번 수행, 리턴값 sb에 저장
            result[i] = cll.deleteNode(K);
        }

        bw.write("<");
        for (int i = 0; i < N-1; i++) {
            bw.write(Integer.toString(result[i]));
            bw.write(", ");
        }   //어떻게해야 간단하게 예제 출력처럼 출력이 가능할까?
        bw.write(Integer.toString(result[N-1]));
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
