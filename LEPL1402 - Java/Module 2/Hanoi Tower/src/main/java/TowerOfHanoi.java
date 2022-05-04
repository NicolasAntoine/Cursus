import java.util.Stack;

public class TowerOfHanoi{

    /**
     * Solve the Tower of Hanoi puzzle
     *
     * @param n The number of disks to move
     * @param a The tower from which we want to move the disks
     * @param b An intermediate tower
     * @param c The tower to which we want to move the disks
     */
    public static void towerOfHanoi(int n, Stack<Disk> a, Stack<Disk> b, Stack<Disk> c) {
        //a.firstElement().getI() >= b.firstElement().getI() && a.firstElement().getI() >= c.firstElement().getI()
        if (!a.empty()){
            if (n == 2) {
                b.push(a.pop());
                c.push(a.pop());
                c.push(b.pop());
            } else {
                if (c.empty() && b.empty()) {
                    c.push(a.pop());
                } else if (!c.empty() && b.empty()) {
                    a.push(a.firstElement());
                } else if (c.empty() && !b.empty()) {
                    a.push(a.firstElement());
                } else {

                }
            }
        }
    }

}
