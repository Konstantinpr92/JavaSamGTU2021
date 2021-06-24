/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

/**
 *
 * @author konst
 */
public class ScientificBook extends Book {

    double index;

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public ScientificBook() {
        super();
        this.index = 0.0;
    }

    public ScientificBook(String author, int year, int index) {
        super(author, year);
        this.index = index;
    }

    public ScientificBook(String author, String name, double cost, int year, int index) {
        super(author, name, cost, year);
        this.index = index;
    }
}
