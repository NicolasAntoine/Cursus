import java.util.*;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Stream<Student> findSecondAndThirdTopStudentForGivenCourse(Stream<Student> studentStream, String name){
    Stream<Student> course = studentStream
            .sorted(Comparator.comparingDouble(value -> value.getCoursesResults().get(name)));
    Student[] tab = course.toArray(Student[]::new);
    return Stream.of(tab[tab.length-2], tab[tab.length-3]);
  }

  public Object[] computeAverageForStudentInSection(Stream<Student> studentStream, int section){
    Stream<Student> rightSection = studentStream.filter(student -> student.getSection() == section);
    // Computes, for each student in the given section, their average grade result,
    // in the form of an array of arrays structured as follows:
    // [ ["Student FirstName1 LastName1", 7.5], ["Student FirstName2 LastName2", 9.5] ]
    return rightSection.map(student -> new Object[] {"Student " + student.getFirstName() + " " +  student.getLastName(),
            student.getCoursesResults().values().stream().reduce(0.0, Double::sum)/student.getCoursesResults().size()}).toArray();
  }

  public int getNumberOfSuccessfulStudents(Stream<Student> studentStream){
    return (int) studentStream.filter(student -> student.getCoursesResults().values().stream().allMatch(aDouble -> aDouble >= 10)).count();
  }

  public Student findLastInLexicographicOrder(Stream<Student> studentStream){
      Stream<Student> compare = studentStream.sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName));
      Object[] list = compare.toArray();
      return (Student) list[list.length-1];
  }

  public double getFullSum(Stream<Student> studentStream){
    return studentStream.map(student -> student.getCoursesResults().values().stream().reduce(0.0,Double::sum)).reduce(0.0, Double::sum);
  }
}