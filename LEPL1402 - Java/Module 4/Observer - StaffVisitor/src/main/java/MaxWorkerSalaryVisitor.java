import java.util.ArrayList;

/**
 * This visitor must compute the salary of the worker who is the most
 * paid.
 **/

class MaxWorkerSalaryVisitor extends Visitor {
    public float getResult() {
        ArrayList<Worker> workers = new ArrayList<>();
        float salary = workers.get(0).getSalary();
        for (Worker i : workers) {
            if (i.getSalary() > salary){
                salary = i.getAge();
            }
        }
        return salary;
    }

    @Override
    public void visit(Manager manager) {

    }

    @Override
    public void visit(Worker worker) {

    }
}
