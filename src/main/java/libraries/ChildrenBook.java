/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import interfaces.Ibook;


/**
 *
 * @author konst
 */
public class ChildrenBook extends Book implements Comparable<ChildrenBook> , Ibook{

    int minAge;


    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public ChildrenBook() {
        super();
        this.minAge = 0;
    }

    public ChildrenBook (String author, int year, int minAge) {
        super(author, year);
        this.minAge = minAge;
    }

    public ChildrenBook (String author, String name, double cost, int year, int minAge) {
        super(author, name, cost, year);
        this.minAge = minAge;
        }
    

    /* Перегрузка метода compareTo */
    @Override
    public int compareTo(ChildrenBook obj) {
        ChildrenBook tmp = (ChildrenBook) obj;
        if (this.getCost() < tmp.getCost()) {
            /* текущее меньше полученного */
            return -1;
        } else if (this.getCost() > tmp.getCost()) {
            /* текущее больше полученного */
            return 1;
        }
        /* текущее равно полученному */
        return 0;
    }

}
