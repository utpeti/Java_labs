import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Strategy implements Strategy{

    @Override
    public ArrayList<Student> processFile(String fileName) {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            return (ArrayList<Student>) bufferedReader.lines().map(line -> {
                String[] splittedParts = line.split(",");
                String name = splittedParts[0];
                String gender = splittedParts[1];
                int[] grades = Arrays.stream(splittedParts)
                        .skip(2)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                return new Student(name, gender, grades);
            }).sorted(Comparator.comparing(Student::getName)).toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printStatistics(List<Student> students) {
        System.out.println("Mean grades per student:");
        students.forEach(student -> System.out.println(student.getName() + " : " + Arrays.stream(new Double[]{Arrays.stream(student.getGrades()).average().orElse(0)})));

        double gradesMeanMean = students.stream().mapToDouble(student -> Arrays.stream(student.getGrades()).average().orElse(0)).average().orElse(0);
        System.out.println("Means of means: " + gradesMeanMean);

        double gradesAllMeanMean = students.stream().flatMapToInt(student -> Arrays.stream(student.getGrades())).average().orElse(0);
        System.out.println("Mean of all grades: " + gradesAllMeanMean);

        students.stream().filter(student -> student.getGender().equals("male")).max(Comparator.comparingDouble(current -> Arrays.stream(current.getGrades()).average().orElse(0))).ifPresent(newcurrent -> System.out.println("Male student with highest mean: " + newcurrent.getName()));

        students.stream().filter(student -> student.getGender().equals("female")).max(Comparator.comparingDouble(current -> Arrays.stream(current.getGrades()).average().orElse(0))).ifPresent(newcurrent -> System.out.println("Female student with highest mean: " + newcurrent.getName()));

        String firstNamesWith10 = students.stream().filter(student -> Arrays.stream(student.getGrades()).anyMatch(grade -> grade == 10)).map(student -> student.getName().split(" ")[0]).collect(Collectors.joining(", "));
        System.out.println("Student's first name that have a grade 10: " + firstNamesWith10);
    }
}
