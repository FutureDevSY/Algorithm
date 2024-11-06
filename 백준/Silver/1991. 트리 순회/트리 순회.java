import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      static class Node{
            char value;
            Node leftChild;
            Node rightChild;

            public Node(char c){
                  this.value = c;
                  this.leftChild = null;
                  this.rightChild = null;
            }
      }

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            Node[] tree = new Node[N];

            StringTokenizer st;
            char a, b, c;
            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  a = st.nextToken().charAt(0);
                  b = st.nextToken().charAt(0);
                  c = st.nextToken().charAt(0);

                  if(tree[a - 'A'] == null){ //아직 생성되지 않은 노드
                        tree[a - 'A'] = new Node(a);
                  }
                  if(b != '.') {
                        tree[b - 'A'] = new Node(b);
                        tree[a - 'A'].leftChild = tree[b - 'A'];
                  }
                  if(c != '.'){
                        tree[c - 'A'] = new Node(c);
                        tree[a - 'A'].rightChild = tree[c - 'A'];
                  }
            }

            preorder(tree[0]);
            System.out.println();
            inorder(tree[0]);
            System.out.println();
            postorder(tree[0]);
      }

      static void preorder(Node node){ //전위 순회
            System.out.print(node.value);
            if(node.leftChild != null) preorder(node.leftChild);
            if(node.rightChild != null) preorder(node.rightChild);
      }

      static void inorder(Node node){
            if(node.leftChild != null) inorder(node.leftChild);
            System.out.print(node.value);
            if(node.rightChild != null) inorder(node.rightChild);
      }

      static void postorder(Node node){
            if(node.leftChild != null) postorder(node.leftChild);
            if(node.rightChild != null) postorder(node.rightChild);
            System.out.print(node.value);
      }

}
