/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import exceptions.BookIndexOutOfBoundsException;
import libraries.ChildrenBook;
import interfaces.Ibook;

/**
 *
 * @author konst
 */
public interface IHall {
    
    public int getNumBooks() ;
    public void printNamesBook() ;
    public double getAllCost();
    public ChildrenBook getBookByNumber (int number) throws BookIndexOutOfBoundsException;
    public void mutateBook(ChildrenBook newBook, int number) throws BookIndexOutOfBoundsException;
    public void addBook(ChildrenBook newBook, int number) ;
    public void removeBook(int number);
    public ChildrenBook getBestBook();
    
}
