/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author konst
 */
public interface Ibook {
    
    public String getAuthor() ;
    public void setAuthor(String author) ;
    public String getName() ;
    public void setName(String name);
    public double getCost();
    public void setCost(double cost) ;
    public int getYear() ;
    public void setYear(int year);
    
}
