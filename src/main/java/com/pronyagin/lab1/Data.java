/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pronyagin.lab1;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author konst
 */
public class Data {

    private int year;
    private int month;
    private int day;

    public Data(String s) {
        this.year = Integer.parseInt(s.substring(0, 4));
        this.month = Integer.parseInt(s.substring(5, 7));;
        this.day = Integer.parseInt(s.substring(8, 10));;
    }

    public Data(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Data(Data other) {
        this.year = other.year;
        this.month = other.month;
        this.day = other.day;
    }

    public String toString() {
        return ("Год: " + year + " Месяц: " + month + " День: " + day);
    }

    //добавить дни
    public void plusDay(int d) {
        GregorianCalendar support = new GregorianCalendar(year, month, day);
        support.add(Calendar.DAY_OF_MONTH, d);
        year = support.get(Calendar.YEAR);
        month = support.get(Calendar.MONTH);
        day = support.get(Calendar.DAY_OF_MONTH);
    }
    //вычитание

    public void minusDay(int d) {
        GregorianCalendar support = new GregorianCalendar(year, month, day);
        support.add(Calendar.DAY_OF_MONTH, -d);
        year = support.get(Calendar.YEAR);
        month = support.get(Calendar.MONTH);
        day = support.get(Calendar.DAY_OF_MONTH);

    }

    //сравнение дат при больше вернет 1б при меньше вернет -1. при равном аернет 0
    public static int сompare(Data d1, Data d2) {
        GregorianCalendar aux1 = new GregorianCalendar(d1.year, d1.month, d1.day);
        GregorianCalendar aux2 = new GregorianCalendar(d2.year, d2.month, d2.day);

        return aux1.compareTo(aux2);

    }
    //дней между датами

    public static long daysDetween(Data d1, Data d2) {
        GregorianCalendar aux1 = new GregorianCalendar(d1.year, d1.month, d1.day);
        GregorianCalendar aux2 = new GregorianCalendar(d2.year, d2.month, d2.day);
        long ms1 = aux1.getTimeInMillis();
        long ms2 = aux2.getTimeInMillis();
        long result = Math.abs((ms1 - ms2) / 1000 / 60 / 60 / 24);
        return result;
    }
}
