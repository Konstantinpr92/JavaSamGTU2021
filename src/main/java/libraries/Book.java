package libraries;

import interfaces.Ibook;
import java.io.Serializable;


/**
 *
 * @author konst
 */
public class Book implements Ibook , Serializable{
    
    
    private static final long serialVersionUID = 1L;


    private String author;
    private String name;
    private double cost;
    private int year;

    public Book() {
        author = "Не определено";
        name = "Не определено";
        cost = 0.0;
        year = 0;
    }

    public Book(String author, String name, double cost, int year) {
        this.author = author;
        this.name = name;
        this.cost = cost;
        this.year = year;
    }

    public Book(String author, int year) {
        this();
        this.author = author;
        this.year = year;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    public String getInfo(){
        return ("Автор: " + author + ", Название: " + name + ", Цена " + cost + ", Год " + year);
            
            }
    
}
