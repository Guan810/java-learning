/**
 * @author 关凯宁
 * @date 2020/6/8 10:58
 */
class Node{
    public int content;
    public Node left;
    public Node right;
    public Node father;

    public Node(int content) {
        this.content = content;
        left=null;
        right=null;
        father=null;
    }
}
public class SplayTree {
    public Node root;
    public SplayTree left;
    public SplayTree right;

    public SplayTree(Node root) {
        this.root = root;
    }

    public void insert(Node node){
        if(root==null){
            root=node;
        }else{
            if(node.content<root.content){
                left.insert(node);
            }else{
                right.insert(node);
            }
        }
    }

    public Node find(int content){
        if(root==null){
            return null;
        }else{
            Node target;
            if(root.content>content){
                target= left.find(content);
            }else{
                target= right.find(content);
            }
            splay(target);
            return target;
        }
    }

    private void splay(Node node){
        while (node!=root){
            if(root.left==node){
                leftRotate(root);
            }else if(root.right==node){
                rightRotate(root);
            }else{
                Node parent=node.father;
                Node anceter=parent.father;
                if(anceter.left==parent&&parent.left==node){
                    leftRotate(anceter);
                    leftRotate(parent);
                }else if(anceter.right==parent&&parent.right==node){
                    rightRotate(anceter);
                    rightRotate(parent);
                }else{
                    if(parent.left==node){
                        leftRotate(parent);
                        rightRotate(anceter);
                    }else{
                        rightRotate(parent);
                        leftRotate(anceter);
                    }
                }
            }
        }
        root=node;
    }

    //单旋转
    private void leftRotate(Node root) {
        Node leftChild=root.left;
        root.left=leftChild.right;
        leftChild.right=root;
    }

    private void rightRotate(Node root) {
        Node rightChild=root.right;
        root.right=rightChild.left;
        rightChild.left=root;
    }

}
