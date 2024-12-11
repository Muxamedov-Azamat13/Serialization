package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class Serialization_Deserialization {

    public static void serializationObject() throws IOException, ClassNotFoundException {
        Student student = new Student("John", 25, 12331);

        try (FileOutputStream fileOutputStream = new FileOutputStream("student.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("Объект сериализован!");
        }

        try (FileInputStream fileInputStream = new FileInputStream("student.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student = (Student) objectInputStream.readObject();
        }

        System.out.println("Объект дессериализован!" + student);
        System.out.println("Поле имя: " + student.getName());
        System.out.println("Поле возраст: " + student.getAge());
        System.out.println("Поле GPA: (должен быть null так как он помечен trancient!)" + student.getGPA());
    }

    public static void serializationJSON() {
        Student student = new Student("James", 22, 213231);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("student.json"), student);
            System.out.println("Объект сериализован в JSON!");
        } catch (IOException e) {
            throw new RuntimeException();
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Student deserialization = objectMapper.readValue(new File("student.json"), Student.class);
            System.out.println("Объект дессериализован из JSON! " + deserialization);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serializationXML() {
        Student student = new Student("Brad", 32, 212311);

        try {
            XmlMapper xmlMapper = new XmlMapper();

            File xmlFile = new File("student.xml");
            xmlMapper.writeValue(xmlFile, student);
            System.out.println("Объект сериализован в XML!");
        } catch (IOException e) {
            throw new RuntimeException();
        }

        try {
            XmlMapper xmlMapper = new XmlMapper();

            File xmlFile = new File("student.xml");
            Student deserializationXml = xmlMapper.readValue(xmlFile, Student.class);
            System.out.println("Объект дессериализован из XML! " + deserializationXml);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
