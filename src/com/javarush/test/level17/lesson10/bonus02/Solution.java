package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length > 0) {

            {
                switch (args[0]) {

                    case "-c":

                        synchronized (Solution.class)
                        {
                            for(int i = 1; i < args.length; i += 3) {
                                if (args[i+1].equals("м")) {
                                    try {
                                        Person person = Person.createMale(args[i], new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 2]));
                                        allPeople.add(person);
                                        System.out.println(allPeople.indexOf(person));
                                    }
                                    catch (ParseException e)
                                    {
                                        System.out.println("Введен неправильный формат даты");
                                    }
                                } else if (args[i+1].equals("ж")) {
                                    try {
                                        Person person = Person.createFemale(args[i], new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 2]));
                                        allPeople.add(person);
                                        System.out.println(allPeople.indexOf(person));
                                    }
                                    catch (ParseException e) {
                                        System.out.println("Введен неправильный формат даты");
                                    }
                                }
                            }
                        }
                        break;

                    case "-u":
                        synchronized (Solution.class)
                        {
                            for(int i = 1; i < args.length; i += 4) {
                                Person person = allPeople.get(Integer.parseInt(args[i]));
                                person.setName(args[i + 1]);
                                if (args[i + 2].equals("м"))
                                    person.setSex(Sex.MALE);
                                else if (args[i + 2].equals("ж"))
                                    person.setSex(Sex.FEMALE);
                                try {
                                    person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 3]));
                                }
                                catch (ParseException e) {
                                    System.out.println("Введен неправильный формат даты");
                                }
                            }
                        }
                        break;

                    case "-d":
                        synchronized (Solution.class)
                        {
                            for(int i = 1; i < args.length; i++) allPeople.set(Integer.parseInt(args[i]), null);
                        }
                        break;

                    case "-i":
                        for(int i = 1; i < args.length; i++) {
                            Person person = allPeople.get(Integer.parseInt(args[i]));

                            System.out.print(person.getName() + " ");

                            if (person.getSex().equals(Sex.MALE)) System.out.print("м ");
                            else System.out.print("ж ");

                            System.out.println(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));
                        }
                        break;
                }
            }
        }
    }
}
