import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Stream;

class main {
    public static void main(String[] args) {
        Student a = new Student("Igor", "Balabka", 1, new HashMap<String, Double>(){{put("Geo", 12.0); put("Math", 10.0);}});
        Student b = new Student("Nicolas", "Antoine", 1, new HashMap<String, Double>(){{put("Geo", 19.0); put("Math", 20.0);}});
        Student c = new Student("Antonin", "Loris", 2, new HashMap<String, Double>(){{put("Geo", 15.0); put("Math", 20.0);}});
        Stream<Student> list = Stream.of(a,b,c);
        ArrayList<Student> test = new ArrayList<>();
        Student antonin = list.max(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName)).orElse(null);
        System.out.println(antonin.getFirstName());
    }
}
