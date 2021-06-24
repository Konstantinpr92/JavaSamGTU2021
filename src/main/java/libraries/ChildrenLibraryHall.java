/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import exceptions.BookIndexOutOfBoundsException;
import interfaces.IHall;
import interfaces.Ibook;

/**
 *
 * @author konst
 */
public class ChildrenLibraryHall implements IHall{

    private String HallName;
    ChildrenBook booksForChildren[];

    public String getHallName() {
        return HallName;
    }

    public void setHallName(String HallName) {
        this.HallName = HallName;
    }

    public ChildrenLibraryHall(String HallName, int number) {
        this.HallName = HallName;
        this.booksForChildren = new ChildrenBook[number];
        for (int i = 0; i < number; ++i) {
            booksForChildren[i] = new ChildrenBook() {} ;
        }

    }

    public ChildrenLibraryHall(String HallName, ChildrenBook[] books) {
        this.HallName = HallName;
        this.booksForChildren = books;
    }

    @Override
    public int getNumBooks() {
        return booksForChildren.length;
    }

    @Override
    public void printNamesBook() {

        for (int i = 0; i < booksForChildren.length; ++i) {
            System.out.println(booksForChildren[i].getName());
        }

    }

    @Override
    public double getAllCost() {
        double result = 0.0;
        for (int i = 0; i < booksForChildren.length; ++i) {
            result += booksForChildren[i].getCost();
        }
        return result;
    }

    @Override
    public ChildrenBook getBookByNumber (int number) throws BookIndexOutOfBoundsException{
        ChildrenBook result = null;
        try {
            if (number<0 || number>this.getNumBooks()-1)throw new BookIndexOutOfBoundsException(number,this.getNumBooks());
           
            result = booksForChildren[number];
        } catch (BookIndexOutOfBoundsException e) {
            System.out.println("Ошибка. Книга с таким номером не существует");
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public void mutateBook(ChildrenBook newBook, int number) throws BookIndexOutOfBoundsException {
          try {
            if (number<0 || number>this.getNumBooks()-1)throw new BookIndexOutOfBoundsException(number,this.getNumBooks());
           booksForChildren[number] =  newBook;
        } catch (BookIndexOutOfBoundsException e) {
            System.out.println("Ошибка. Книга не изменена.");
            System.out.println(e.getMessage());
        }
        
        

    }

    @Override
    public void addBook(ChildrenBook newBook, int number) {
        ChildrenBook newBooksForChildren[] = new ChildrenBook[booksForChildren.length + 1];
        for (int i = 0; i < number; ++i) {
            newBooksForChildren[i] = booksForChildren[i];
        }
        newBooksForChildren[number] = newBook;
        for (int i = number + 1; i < booksForChildren.length + 1; ++i) {
            newBooksForChildren[i] = booksForChildren[i - 1];
        }

        booksForChildren =  newBooksForChildren;
    }

    @Override
    public void removeBook(int number) {
        libraries.ChildrenBook newBooksForChildren[] = new libraries.ChildrenBook[booksForChildren.length - 1];
        for (int i = 0; i < number; ++i) {
            newBooksForChildren[i] =  booksForChildren[i];
        }

        for (int i = number; i < booksForChildren.length - 1; ++i) {
            newBooksForChildren[i] =  booksForChildren[i + 1];
        }

        booksForChildren = newBooksForChildren;
    }

    @Override
    public ChildrenBook getBestBook() {
        ChildrenBook bestBook =  booksForChildren[0];
        double maxCost = booksForChildren[0].getCost();

        for (int i = 0; i < booksForChildren.length; ++i) {
            if (booksForChildren[i].getCost() > maxCost) {
                bestBook =  booksForChildren[i];
            }

        }
        return bestBook;
    }


}
