package com.pronyagin.lab1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import static java.lang.System.out;
import libraries.*;

/**
 *
 * @author konst
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Задача 1");
        // z1 = 3 - i; z2 = -2+ i*3
        Complex z1 = new Complex(3, -1);
        System.out.println(z1.toString());
        Complex z2 = new Complex(-2, 3);
        // z1 * z2 
        Complex z3 = Complex.Mult(z1, z2);
        System.out.println(z3.toString());
        //(z1+z2)*5
        z3 = Complex.Mult(Complex.plus(z1, z2), new Complex(5, 0));
        System.out.println(z3.toString());

        System.out.println("Задача 2");
        Vector v1 = new Vector(1, 1, 1);
        Vector v2 = new Vector(2, 2, 2);
        System.out.print("Длинна первого вектора с координатами " + v1.toString() + " равна ");

        System.out.println(v1.getLength());
        Vector v3 = Vector.plus(v1, v2);
        System.out.println("V1 " + v1.toString() + " + V2 " + v2.toString() + " = V3 " + v3.toString());

        System.out.println("Задача 3");

        Data d1 = new Data("2021.06.09");
        Data d2 = new Data("2022.06.19");

        System.out.println(d1.toString());
        System.out.println("Прибавим 10 дней к дате 1");
        d1.plusDay(10);
        System.out.println(d1.toString());

        System.out.print("Количество дней между " + d1.toString() + " и  " + d2.toString() + " равно ");
        System.out.println(Data.daysDetween(d1, d2));

        System.out.println("Задача про библитотеку");
        ChildrenBook[] bookfForLibrary
                = {new ChildrenBook("АвторA", "НазваниеА", 100, 2010, 3),
                    new ChildrenBook("АвторБ", "НазваниеБ", 150, 2010, 6),
                    new ChildrenBook("АвторВ", "НазваниеВ", 50, 2005, 3),
                    new ChildrenBook("АвторГ", "НазваниеГ", 200, 2020, 6),
                    new ChildrenBook("АвторД", "НазваниеД", 250, 2020, 6),
                    new ChildrenBook("АвторЕ", "НазваниеЕ", 120, 1985, 6),
                    new ChildrenBook("АвторЖ", "НазваниеЖ", 125, 2000, 6),
                    new ChildrenBook("АвторЗ", "НазваниеЗ", 125, 2000, 12),
                    new ChildrenBook("АвторЮ", "НазваниеЮ", 75, 2000, 12),
                    new ChildrenBook("АвторЯ", "НазваниеЯ", 90, 2001, 3)
                };

        int nBook[] = {3, 4, 3};

        ChildrenLibrary MainLibrary = new ChildrenLibrary(3, nBook);

        MainLibrary.getHallByNumber(0).setHallName("Сказки");
        MainLibrary.getHallByNumber(1).setHallName("Стихи");
        MainLibrary.getHallByNumber(2).setHallName("Рассказы");

        ChildrenBook firstBook = new ChildrenBook("Автор первой книги", "Название первой книги", 300, 200, 6);
        MainLibrary.addBookToBegin(firstBook);

        for (int i = 1; i < 11; i++) {
            MainLibrary.replaceBook(i, bookfForLibrary[i - 1]);

        }

        MainLibrary.printHallInfo();
        System.out.println("Книги в библиотеке");
        MainLibrary.printAllBook();

        System.out.println("Самaя дорогая книга " + MainLibrary.getBestBook().getName());

        System.out.println("Цена всех книг " + MainLibrary.getAllCost());

        ChildrenBook GoldBook = new ChildrenBook("АвторТестовойКниги", "Самая дорогая книга для теста", 1000, 2000, 3);
        System.out.println("Меняем книгу....");
        MainLibrary.replaceBook(5, GoldBook);
        MainLibrary.printAllBook();
        System.out.println("Самaя дорогая книга после замены " + MainLibrary.getBestBook().getName());

        System.out.println("Цена всех книг после замены " + MainLibrary.getAllCost());
        ChildrenBook BookForAdd = new ChildrenBook("АвторКнигиДляДобавления", "КнигаДлядовавления", 100, 2005, 3);

        MainLibrary.addBook(6, BookForAdd);
        MainLibrary.printHallInfo();
        System.out.println("Цена всех книг после добавления " + MainLibrary.getAllCost());
        MainLibrary.removeBook(6);
        MainLibrary.printHallInfo();
        System.out.println("Цена всех книг после удаления " + MainLibrary.getAllCost());

        System.out.println("Отсортированные по цене названия книг");
        System.out.println("-------------------------------------------");
        for (int i = MainLibrary.getNumBooks() - 1; i >= 0; --i) {
            ChildrenBook[] aux = MainLibrary.getBookByCost();
            System.out.println(aux[i].getName());

        }
        System.out.println("-------------------------------------------");
        
        
        
        MainLibrary.getBookByNumber(-100);
        MainLibrary.replaceBook(150, GoldBook);
        
        OutputStream out;
        out = new ByteArrayOutputStream();
        Libraries.outputLibrary(MainLibrary, out);
        System.out.println(out.toString());
        
        BufferedInputStream is = new BufferedInputStream(System.in); 

       // ChildrenLibrary NewLibrary = Libraries.inputLibrary(is);
        
      //  Libraries.outputLibrary(NewLibrary, out);
      //  System.out.println(out.toString());
           
        
      Book BookForSer = new Book("Автор кинги для серилизации", "Книга для серидизации", 123.45 , 2021);
            
      //создаем 2 потока для сериализации объекта и сохранения его в файл
      FileOutputStream outputStream = new FileOutputStream("C:\\Book.ser");
       ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
       
       // сохраняем игру в файл
       objectOutputStream.writeObject(BookForSer);
       
        //закрываем поток и освобождаем ресурсы
       objectOutputStream.close();
       
        
       //десериализация
       FileInputStream fileInputStream = new FileInputStream("C:\\Book.ser");
       ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
       
      Book RestoredBook = (Book) objectInputStream.readObject();
      
        System.out.println(RestoredBook.getInfo());
    }

}
