/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import exceptions.BookIndexOutOfBoundsException;
import java.util.*;

/**
 *
 * @author konst
 */
public class ChildrenLibrary {

    ChildrenLibraryHall hallsInLibrary[];

    public ChildrenLibrary(int numHalls, int bookInHalls[]) {

        this.hallsInLibrary = new ChildrenLibraryHall[numHalls];

        for (int i = 0; i < numHalls; ++i) {
            hallsInLibrary[i] = new ChildrenLibraryHall("", bookInHalls[i]);

        }

    }

    public ChildrenLibrary(ChildrenLibraryHall hallsInLibrary[]) {
        this.hallsInLibrary = hallsInLibrary;

    }

    public int getNumHalls() {
        return hallsInLibrary.length;
    }

    public int getNumBooks() {
        int result = 0;
        for (int i = 0; i < hallsInLibrary.length; ++i) {
            result += hallsInLibrary[i].getNumBooks();
        }

        return result;
    }

    public int getAllCost() {
        int result = 0;
        for (int i = 0; i < hallsInLibrary.length; ++i) {
            result += hallsInLibrary[i].getAllCost();
        }

        return result;
    }

    public ChildrenLibraryHall[] getHalls() {
        return hallsInLibrary;
    }

    public ChildrenLibraryHall getHallByNumber(int n) {
        if (n >= 0 && n < hallsInLibrary.length) {
            return hallsInLibrary[n];
        } else {
            return null;
        }
    }

    public ChildrenBook getBookByNumber(int n) {
        //    if (n >= 0 && n < this.getNumBooks()) {
        int aux = n;
        int prevAux = n;
        int i = 0;
        while (aux > 0) {
            prevAux = aux;
            aux -= hallsInLibrary[i].getNumBooks();
        }
        return  hallsInLibrary[i].getBookByNumber(prevAux);
        // } else {
        //    return null;
    }

    // статья http://www.codenet.ru/webmast/java/Simple-Sorting.php
    public ChildrenBook[] getBookByCost() {

        ChildrenBook[] auxArray = new ChildrenBook[this.getNumBooks()];

        int auxNum = 0;
        for (int i = 0; i < hallsInLibrary.length; ++i) {
            for (int k = 0; k < hallsInLibrary[i].getNumBooks(); k++) {
                auxArray[auxNum] =  hallsInLibrary[i].getBookByNumber(k);
                auxNum++;
            }

        }
        Arrays.sort(auxArray);
        return auxArray;
    }

    public ChildrenBook getBestBook() {
        ChildrenBook bestOfBest = hallsInLibrary[0].getBestBook();
        for (int i = 0; i < hallsInLibrary.length; ++i) {
            if (bestOfBest.getCost() < hallsInLibrary[i].getBestBook().getCost()) {
                bestOfBest = hallsInLibrary[i].getBestBook();
            }
        }
        return bestOfBest;
    }

    public void printHallInfo() {
        for (int i = 0; i < hallsInLibrary.length; ++i) {

            System.out.println("Зал " + hallsInLibrary[i].getHallName() + " содержит " + hallsInLibrary[i].getNumBooks() + " книги");
        }
    }

    public void replaceBook(int n, ChildrenBook newBook) {
        try {
            if (n < 0 || n > this.getNumBooks() - 1) {
                throw new BookIndexOutOfBoundsException(n, this.getNumBooks());
            }

            int aux = n;
            int prevAux = n;
            int i = 0;
            while (aux >= 0) {
                prevAux = aux;
                aux -= hallsInLibrary[i].getNumBooks();
                i++;
            }
            hallsInLibrary[i - 1].mutateBook(newBook, prevAux);

        } catch (BookIndexOutOfBoundsException e) {
            System.out.println("Ошибка. Книга не изменена.");
            System.out.println(e.getMessage());
        }

    }

    public void removeBook(int n) {
        if (n >= 0 && n < this.getNumBooks()) {
            int aux = n;
            int prevAux = n;
            int i = 0;
            while (aux >= 0) {
                prevAux = aux;
                aux -= hallsInLibrary[i].getNumBooks();
                i++;
            }
            hallsInLibrary[i - 1].removeBook(prevAux);
        } else {
            System.out.println("Неверный индекс");
        }
    }

    public void addBook(int n, ChildrenBook newBook) {
        if (n >= 0 && n < this.getNumBooks()) {
            int aux = n;
            int prevAux = n;
            int i = 0;
            while (aux >= 0) {
                prevAux = aux;
                aux -= hallsInLibrary[i].getNumBooks();
                i++;
            }
            hallsInLibrary[i - 1].addBook(newBook, prevAux);
        } else {
            System.out.println("Неверный индекс");
        }

    }

    public void addBookToBegin(ChildrenBook newBook) {
        hallsInLibrary[0].addBook(newBook, 0);
    }

    public void replaceHall(ChildrenLibraryHall newHall, int number) {
        if (number >= 0 && number < this.getNumHalls()) {

            hallsInLibrary[number] = newHall;
        } else {
            System.out.println("Неверный индекс");
        }

    }

    public void printAllBook() {
        for (int i = 0; i < hallsInLibrary.length; ++i) {
            System.out.println("Зал " + hallsInLibrary[i].getHallName() + " " + i + " ");
            hallsInLibrary[i].printNamesBook();

        }

    }

}
