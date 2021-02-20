package importers;

import models.Student;
import models.Subject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVImporter implements IImporter {
    // Import student from CSV file
    @Override
    public List<Student> readStudentDataFromFile(String pathFile) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line;

            int lineIndex = 0;
            String[] headers = new String[0];
            while ((line = br.readLine()) != null) {
                if (lineIndex == 0) {
                    headers = line.split(Constants.CSV_DELIMITER);
                } else {
                    students.add(parseStudentInfoFromLine(line, headers));
                }
                lineIndex++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    // Input
    // Data: Nam, 9, 8
    // Headers: Name, Toan, Van
    // Output
    // models.Student data
    private Student parseStudentInfoFromLine(String line, String[] headers) {
        Student student = new Student();
        String[] studentValues = line.split(Constants.CSV_DELIMITER);

        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals(Student.NAME_FIELD)) {
                student.setName(studentValues[i]);
            } else {
                // Parse models.Subject data here
                String subjectName = headers[i];
                if (i >= studentValues.length) {
                    continue;
                }

                String subjectScoreStr = studentValues[i];
                Subject subject = new Subject(subjectName, subjectScoreStr);
                student.getSubjects().add(subject);
            }
        }
        return student;
    }
}
