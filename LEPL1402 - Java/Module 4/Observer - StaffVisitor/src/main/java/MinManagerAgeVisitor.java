import java.util.ArrayList;

/**
 * This visitor must compute the age of the youngest manager.
 **/

class MinManagerAgeVisitor extends Visitor {
    public int getResult() {
        ArrayList<Manager> managers = new ArrayList<>();
        int answer = managers.get(0).getAge();
        for (Manager i : managers) {
            if (i.getAge() < answer){
                answer = i.getAge();
            }
        }
        return answer;
    }

    @Override
    public void visit(Manager manager) {

    }

    @Override
    public void visit(Worker worker) {

    }
}
