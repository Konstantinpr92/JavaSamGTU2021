/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pronyagin.lab1;

/**
 *
 * @author konst
 */
public class Complex {
    private double re;//вещественная часть
    private double im;//мнимая часть

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }
    // конструктор без параметров
    public Complex()
    {
    }
    // конструктор с одним параметром - действительная часть
    public Complex( double Real ) {
      this.re = Real;
      this.im = 0;
   }    
    
    //констуктор с двумя параметрами
    public Complex( double Real, double Imaginary ) {
      this.re = Real;
      this.im = Imaginary;
   }
    public Complex( Complex number ) {
      this.re = number.re;
      this.im = number.im;
   }
    //сложение
    public void plus(Complex other){
       re += other.re;
       im+= other.im;
}
     // сложение
    public static Complex plus( Complex c1, Complex c2){
        return new Complex( c1.re+c2.re, c1.im+c2.im);
}
//вычитание
      public void minus( Complex other ) {
       re -= other.re;
       im -= other.im;
   }

//вычитание
    public static Complex minus( Complex c1, Complex c2){
        return new Complex( c1.re-c2.re, c1.im-c2.im);
}
  //умножение  
      public void Mult( Complex cB ) {
       this.re = this.re*cB.re - this.im*cB.im;
       this.im = this.im*cB.re + this.re*cB.im;

   }
      //умножение 
     public static Complex Mult( Complex с1, Complex с2 ) {
        Complex result = new Complex();

       result.re = с1.re*с2.re - с1.im*с2.im;
       result.im = с1.im*с2.re + с1.re*с2.im;

       return result;
   }
     // сопряженное число 
    public Complex Conjugate() {
   Complex conj = new Complex();

      conj.re      =  re;
      conj.im = -im;

      return (conj);
   }
    
    public String toString() {
      if (im >= 0)
          return re + "+" +  im + "i";
      else
          return re + " " + im + "i";
   }
    //сравнение
       public static boolean isEqual (Complex z1, Complex z2){
           
           if (z1.re == z2.re &&  z1.im == z2.im)
           {  return  true;}
           else
           {return false;}      
}
        
}
