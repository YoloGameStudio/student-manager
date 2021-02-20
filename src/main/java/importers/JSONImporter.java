package importers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Student;
import models.Subject;
import org.json.*;

public class JSONImporter implements IImporter{
    @Override
    public List<Student> readStudentDataFromFile(String filePath) {
        List<Student> students = new ArrayList<>();
        try {
            String fileContent = Files.readString(Path.of(filePath));
            JSONArray studentObjectsData = new JSONArray(fileContent);
            for (int i = 0; i < studentObjectsData.length(); i++) {
                Student student = new Student();
                JSONObject studentObjectData = studentObjectsData.getJSONObject(i);
                Iterator<String> keys = studentObjectData.keys();
                while(keys.hasNext()) {
                    String key = keys.next();
                    if (key.equals(Student.NAME_FIELD)) {
                        student.setName(studentObjectData.getString(key));
                    } else {
                        String subjectName = key;
                        String subjectScoreStr = studentObjectData.get(key).toString();
                        Subject subject = new Subject(subjectName, subjectScoreStr);
                        student.getSubjects().add(subject);
                    }
                }
                students.add(student);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
