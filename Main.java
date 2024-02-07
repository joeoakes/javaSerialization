import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) {
        // Creating an instance of the Student class
        Student student = new Student("Alice", 17, "11th");

        // Serialization: Converting the student object to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String studentJson = objectMapper.writeValueAsString(student);
            System.out.println("Student object serialized to JSON string:");
            System.out.println(studentJson);

            // Deserialization: Converting the JSON string back to a student object
            Student deserializedStudent = objectMapper.readValue(studentJson, Student.class);
            System.out.println("\nStudent object deserialized from JSON string:");
            System.out.println("Name: " + deserializedStudent.getName());
            System.out.println("Age: " + deserializedStudent.getAge());
            System.out.println("Grade: " + deserializedStudent.getGrade());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

class Student {
    private String name;
    private int age;
    private String grade;

    // Default constructor (required for Jackson)
    public Student() {}

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
