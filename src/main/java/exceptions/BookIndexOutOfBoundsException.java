/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author konst
 */
public class BookIndexOutOfBoundsException extends IndexOutOfBoundsException {

   private int currentNumber;
   private  int maxNumber;
    
    public BookIndexOutOfBoundsException(int currentNumber, int maxNumber) {
        this.currentNumber = currentNumber;
        this.maxNumber = maxNumber;
    }
    
    public String  getMessage(){
        if (maxNumber>0)
        return ("Введен неверный номер книги: " + currentNumber + ". Номер может быть  от 0 до "+ (maxNumber-1));
        else
            return ("Введен неверный номер книги: " + currentNumber + ". Массив книг пуст.");
            
    }
    
    
}
