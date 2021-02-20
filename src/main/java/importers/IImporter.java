package importers;

import models.Student;

import java.util.List;

public interface IImporter {
    List<Student> readStudentDataFromFile(String filePath);
}
