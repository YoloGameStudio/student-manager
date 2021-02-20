import importers.IImporter;
import models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void showStudents() {
        StringBuilder studentInfo = new StringBuilder();
        for (Student student: students) {
            studentInfo.append(student.toString() + "\n");
        }
        System.out.println(studentInfo);
    }

    public void importStudentDataFromFile(IImporter importer, String filePath) {
        students = importer.readStudentDataFromFile(filePath);
    }
}
