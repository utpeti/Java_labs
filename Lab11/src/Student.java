public class Student {

    private final String name;
    private final String gender;
    private final int[] grades;

    public Student(String name, String gender, int[] grades) {
        this.name = name;
        this.gender = gender;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int[] getGrades() {
        return grades;
    }
}
