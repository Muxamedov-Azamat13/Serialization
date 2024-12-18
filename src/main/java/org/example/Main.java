package org.example;

import java.io.*;

/**
 * Задание 1:
 * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
 * Обеспечьте поддержку сериализации для этого класса.
 * Создайте объект класса Student и инициализируйте его данными.
 * Сериализируйте этот объект в файл.
 * Десериализируйте объект обратно в программу из файла.
 * Выведите все поля объекта, включая GPA, и обсудите почему значение GPA не было сохранено/восстановлено.
 * Задание 2:
 * ** Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документов).
 */

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serialization_Deserialization.serializationObject();
        Serialization_Deserialization.serializationJSON();
        Serialization_Deserialization.serializationXML();
    }
}