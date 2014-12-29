package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            OutputStream outputStream = new FileOutputStream("c:/tmp/200202.txt");
            InputStream inputStream = new FileInputStream("c:/tmp/200202.txt");

            JavaRush javaRush = new JavaRush();

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Vsevolod");
            user1.setLastName("Alokhin");
            user1.setBirthDate(new Date(1994, 3, 13));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);

            User user2 = new User();
            user2.setFirstName("Name");
            user2.setMale(true);
            user2.setCountry(User.Country.UKRAINE);

            User user3 = new User();
            user3.setFirstName("Ivan");
            user3.setLastName("Ivanov");
            user3.setMale(true);

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            loadedObject.save(outputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (loadedObject.equals(javaRush))
                System.out.println("yes!");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (PrintWriter writer = new PrintWriter(outputStream)) {
                for (User user : users) {
                    writer.print(user.getFirstName() != null ? user.getFirstName() + " " : "null ");
                    writer.print(user.getLastName() != null ? user.getLastName() + " " : "null ");

                    if (user.getBirthDate() != null) {
                        writer.write(user.getBirthDate().getYear() + " ");
                        writer.write(user.getBirthDate().getMonth() + " ");
                        writer.write(user.getBirthDate().getDate() + " ");
                    } else writer.write("null ");

                    writer.write(String.valueOf(user.isMale()) + " ");
                    writer.print(user.getCountry() != null ? user.getCountry().getDisplayedName().toUpperCase() + " " : "null ");
                }
                writer.println();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                while (reader.ready()) {
                    Scanner scanner = new Scanner(reader.readLine());

                    while (scanner.hasNext()) {
                        User user = new User();
                        String firstName;
                        String lastName;
                        String birthDate;
                        String country;

                        if (!(firstName = scanner.next()).equals("null")) user.setFirstName(firstName);
                        if (!(lastName = scanner.next()).equals("null")) user.setLastName(lastName);

                        if (!(birthDate = scanner.next()).equals("null")) {
                            user.setBirthDate(new Date(
                                    Integer.parseInt(birthDate),
                                    Integer.parseInt(scanner.next()),
                                    Integer.parseInt(scanner.next())));
                        }

                        user.setMale(Boolean.parseBoolean(scanner.next()));
                        if (!(country = scanner.next()).equals("null")) user.setCountry(User.Country.valueOf(country));

                        users.add(user);
                    }
                }
            }
        }
    }
}
