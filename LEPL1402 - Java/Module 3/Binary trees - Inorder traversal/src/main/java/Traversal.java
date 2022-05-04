import java.util.List;
import java.util.Stack; // this should give you a hint for the iterative version

public class Traversal {

    public static void recursiveInorder(Node root, List<Integer> res) {
        if (root != null){
            recursiveInorder(root.left, res);
            res.add(root.val);
            recursiveInorder(root.right, res);
        }
    }
    public static void iterativeInorder(Node root, List<Integer> res){
        Stack<Node> s = new Stack<>();
        Node current = root;

        while (!s.isEmpty() || current != null){
            if (current != null) {
                s.push(current);
                System.out.println(current.val);
                current = current.left;
            } else {
                current = s.pop();
                System.out.println(current.val);
                res.add(current.val);
                current = current.right;
            }
        }
    }

}
