package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {

            String lastName = scanner.next();
            String firstName = scanner.next();
            String middleName = scanner.next();
            Calendar calendar = new GregorianCalendar();
            calendar.set(Calendar.DATE, scanner.nextInt());
            calendar.set(Calendar.MONTH, scanner.nextInt() - 1);
            calendar.set(Calendar.YEAR, scanner.nextInt());
            Date date = calendar.getTime();

            return new Person(firstName, middleName, lastName, date);
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}