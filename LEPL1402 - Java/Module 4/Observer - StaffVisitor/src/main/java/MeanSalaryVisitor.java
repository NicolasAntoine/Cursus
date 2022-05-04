import java.util.ArrayList;

/**
 * This visitor must compute the mean salary of all the staff
 * (including both workers and managers).
 **/

class MeanSalaryVisitor extends Visitor {
    public float getResult() {
        ArrayList<Person> all = new ArrayList<>();
        float salary = all.get(0).getSalary();
        for (Person i : all) {
            if (i.getSalary() < salary){
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
