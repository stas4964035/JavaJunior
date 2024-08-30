import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentData{
    private static final XmlMapper xmlMapper = new XmlMapper();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void writeData(String filename){
        try {
            if (filename.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                    oos.writeObject(students);
                    System.out.println("Data written to " + filename);
                }
            } else if (filename.endsWith(".xml")) {
                xmlMapper.writeValue(new File(filename), students);
                System.out.println("Data written to " + filename);
            } else{
                System.out.println("Wrong file name");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readData(String filename){
        try{
            if (filename.endsWith(".bin")) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                    this.students= (List<Student>) ois.readObject();
                    System.out.println("Data read from " + filename);
                }
            } else if (filename.endsWith(".xml")) {
                students = xmlMapper.readValue(filename, xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }


    public void printData() {
        students.forEach(System.out::println);
    }

    private List<Student> students = new ArrayList<>();

    public StudentData() {
        students.add(new Student("Ivan", 18, 4.5));
        students.add(new Student("Petr", 19, 4.2));
        students.add(new Student("Elena", 20, 4.7));
        students.add(new Student("Michael", 21, 4.6));
    }
    public StudentData(List<Student> students) {
        this.students = students;
    }
}
