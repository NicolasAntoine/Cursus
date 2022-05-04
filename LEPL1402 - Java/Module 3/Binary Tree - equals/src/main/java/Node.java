public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val = val;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() != this.getClass()){
            return false;
        }
        Node other = (Node) o;

        if (this.isLeaf() == other.isLeaf()){
            if (this.val == other.val){
                return true;
            } else {
                return false;
            }
        }
        if (this.left == null && this.right == null){
            if (other.left == null && other.right == null){
                return true;
            } else {
                return false;
            }
        } else if (this.val == other.val){
            return this.left.equals(other.left) && this.right.equals(other.right);
        } else {
            return false;
        }
    }
}