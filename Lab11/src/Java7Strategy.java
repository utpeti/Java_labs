import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Java7Strategy implements Strategy {

    @Override
    public ArrayList<Student> processFile(String fileName) {

        ArrayList<Student> students = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String readLine = bufferedReader.readLine();
            String[] currentLine;
            String currentName;
            String currentGender;
            int[] currentGrades;

            while (readLine != null) {
                currentLine = readLine.split(",");
                currentName = currentLine[0];
                currentGender = currentLine[1];
                currentGrades = new int[currentLine.length - 2];

                for (int i = 2; i < currentLine.length; ++i) {
                    currentGrades[i - 2] = parseInt(currentLine[i]);
                }

                readLine = bufferedReader.readLine();
                students.add(new Student(currentName, currentGender, currentGrades));

            }

            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        students.sort(Comparator.comparing(Student::getName));
        return students;
    }

    @Override
    public void printStatistics(List<Student> students) {

        int gradesAllSum = 0, gradesAllNr = 0, studentNr = 0;
        double gradesMeanMean = 0, maxMeanMale = 0, maxMeanFemale = 0;
        String maxMeanMaleName = null, maxMeanFemaleName = null;
        System.out.println("Mean grades per student:");
        for(Student student : students) {
            int gradesNr = 0, gradesSum = 0;
            int[] grades = student.getGrades();
            for(int grade : grades) {
                ++gradesNr;
                gradesSum += grade;
            }
            ++studentNr;
            gradesAllNr += gradesNr;
            gradesAllSum += gradesSum;
            double gradesMean = (double) gradesSum / gradesNr;
            if(gradesMean > maxMeanMale && Objects.equals(student.getGender(), "male")) {
                maxMeanMale = gradesMean;
                maxMeanMaleName = student.getName();
            }
            if(gradesMean > maxMeanFemale && Objects.equals(student.getGender(), "female")) {
                maxMeanFemale = gradesMean;
                maxMeanFemaleName = student.getName();
            }
            gradesMeanMean += gradesMean;
            System.out.println(student.getName() + " : " + gradesMean);
        }

        double gradesAllMeanMean = gradesMeanMean / studentNr;
        System.out.println("Mean of mean grades: " + gradesAllMeanMean);

        double gradesAllMean = (double) gradesAllSum / gradesAllNr;
        System.out.println("Mean of all grades: " + gradesAllMean);

        System.out.println("Male student with highest grade: " + maxMeanMaleName);

        System.out.println("Female student with highest grade: " + maxMeanFemaleName);

        StringBuilder firstNamesWith10 = new StringBuilder();
        for(Student student : students) {
            int[] grades = student.getGrades();
            for(int grade : grades) {
                if(grade == 10) {
                    firstNamesWith10.append(student.getName().split(" ")[0]).append(", ");
                }
            }
        }

        System.out.println("Student's fist name that have a grade 10: " + firstNamesWith10.substring(0, firstNamesWith10.length() - 2));
    }
}
