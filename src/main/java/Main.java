import importers.CSVImporter;
import importers.JSONImporter;

public class Main {
    /*
    - Manage the list of students
    - Import student data from CSV or JSON files. There are others data sources. May add later.
    - Show the list of student
    * */
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.importStudentDataFromFile(new CSVImporter(), "/Users/hungtut.com/Downloads/students-2.csv");
        studentManager.importStudentDataFromFile(new JSONImporter(), "/Users/hungtut.com/Downloads/students-1.json");
        studentManager.showStudents();
    }
}
