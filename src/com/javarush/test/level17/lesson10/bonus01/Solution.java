package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
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
            switch (args[0]) {

                case "-c":
                    if (args[2].equals("м")) {
                        try
                        {
                            Person person = Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                        catch (ParseException e)
                        {
                            System.out.println("Введен неправильный формат даты");
                        }
                    } else if (args[2].equals("ж")) {
                        try
                        {
                            Person person = Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                        catch (ParseException e)
                        {
                            System.out.println("Введен неправильный формат даты");
                        }
                    }
                    break;

                case "-u":
                    Person person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(args[2]);
                    if (args[3].equals("м"))
                    {
                        person.setSex(Sex.MALE);

                    } else if (args[3].equals("ж"))
                    {
                        person.setSex(Sex.FEMALE);
                    }
                    try
                    {
                        person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
                    }
                    catch (ParseException e)
                    {
                        System.out.println("Введен неправильный формат даты");
                    }
                    break;

                case "-d":
                    allPeople.set(Integer.parseInt(args[1]), null);
                    break;

                case "-i":
                    Person person1 = allPeople.get(Integer.parseInt(args[1]));

                    System.out.print(person1.getName() + " ");

                    if (person1.getSex().equals(Sex.MALE)) System.out.print("м ");
                    else System.out.print("ж ");

                    System.out.println(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person1.getBirthDay()));

                    break;
            }
        }
    }
}
