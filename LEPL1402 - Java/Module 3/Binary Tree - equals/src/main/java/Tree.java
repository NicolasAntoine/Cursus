public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    @Override
    public boolean equals(Object o){
        if (o == null ){
            return false;
        }
        if (o.getClass() != this.getClass()){
            return false;
        }
        Tree other = (Tree) o;

        if (other.root == null && this.root == null){
            return true;
        } else if (other.root.val == this.root.val){
            return this.root.left.equals(other.root.left) && this.root.right.equals(other.root.left);
        } else {
            return false;
        }
    }

}