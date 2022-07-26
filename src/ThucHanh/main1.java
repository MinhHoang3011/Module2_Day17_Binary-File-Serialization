package ThucHanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Phạm Minh Hoàng","Hà Nam"));
        students.add(new Student(2,"Trần Xuân Ba","Nhật Bản"));
        students.add(new Student(3,"O C Hiệp","America"));

        writeToFile("student.oc", students);

        List<Student> studentDataFromFile = readDataFromFile("student.oc");
        for (Student student: studentDataFromFile) {
            System.out.println(student);
        }
    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            fos.close();
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
