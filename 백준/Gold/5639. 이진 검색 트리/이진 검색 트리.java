import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      static class Node{
            int num;
            Node leftNode;
            Node rightNode;

            public Node(int num){
                  this.num = num;
            }

            public void insertNode(int num){
                  if(num < this.num){
                        if(this.leftNode == null){
                              this.leftNode = new Node(num);
                        }else{
                              this.leftNode.insertNode(num);
                        }
                  }else{
                        if(this.rightNode == null){
                              this.rightNode = new Node(num);
                        }else{
                              this.rightNode.insertNode(num);
                        }
                  }
            }

      }

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            String input;
            Node root = new Node(Integer.parseInt(br.readLine()));
            while((input = br.readLine()) != null && !input.isEmpty()){
                  root.insertNode(Integer.parseInt(input));
            }
            postorder(root);
      }

      static void postorder(Node node) {
            if (node.leftNode != null)
                  postorder(node.leftNode);
            if (node.rightNode != null)
                  postorder(node.rightNode);
            System.out.println(node.num);
      }
}
