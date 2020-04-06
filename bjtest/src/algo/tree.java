package algo;

public class tree {

    public static void main(String[] args) {
        Tree t = new Tree();
        Node n4 = t.createNode(null, 4, null);
        Node n5 = t.createNode(null, 5, null);
        Node n2 = t.createNode(n4, 2, n5);
        Node n3 = t.createNode(null, 3, null);
        Node n1 = t.createNode(n2, 1, n3);
        
        t.setRoot(n1);
        t.inOrder(t.getRoot());
    }
}

class Node {
    int data;
    Node left;
    Node right;
}
 
class Tree {
    public Node root;
    
    public void setRoot(Node node) {
        
        this.root = node;
    }
    
    public Node getRoot() {
        
        return root;
    }
    
    public Node createNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        
        return node;
    }
    
    //중위 순회 Inorder = Left -> Root -> Right
    //4 -> 2 -> 5 -> 1 -> 3
    public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }
    
    //전위순회 Preorder = Root -> Left -> Right
    //1 -> 2 -> 4 -> 5 -> 3
    public void preOrder(Node node) {
        if(node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    //후위순회 Postorder = Left -> Right -> Root
    //4 -> 5 -> 2 -> 3 -> 1
    public void postOrder(Node node) {
        if(node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.data);
        }
    }
}

