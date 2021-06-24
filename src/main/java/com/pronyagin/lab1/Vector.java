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
public class Vector {
    
   private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
  
    
    public Vector(){
  
    }
    //конструктор с тремя параметрами для x y z
    public Vector (double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;           
    }
    //сложение
    public void  plus(Vector other){
    this.x += other.x;
    this.y += other.y;
    this.z += other.z;
    }
    //сложение
    public static Vector plus(Vector v1, Vector v2){
    Vector result = new Vector();
    result.x = v1.x + v2.x;
    result.y = v1.y + v2.y;
    result.z = v1.z + v2.z;
        return result;
    }
    // разность
        public void  minus (Vector other){
    this.x -= other.x;
    this.y -= other.y;
    this.z -= other.z;
    }
        // разность
    public static Vector minus(Vector v1, Vector v2){
    Vector result = new Vector();
    result.x = v1.x - v2.x;
    result.y = v1.y - v2.y;
    result.z = v1.z - v2.z;
        return result;
    }
    // скалярное произведение векторов
     public double   scalarMult (Vector other){
    return this.x * other.x + this.y * other.y + this.z * other.z;
    }
        // скалярное произведение векторов
    public static double scalarMult (Vector v1, Vector v2){

        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }
    
        // умножение на число
      public void   scalarMult (double  num){
     this.x *= num;
     this.y *= num;
     this.z *= num;
    }
            // умножение на число
    public static Vector scalarMult (Vector v1, double num){
    Vector result = new Vector();
    result.x = v1.x * num;
    result.y = v1.y * num;
    result.z = v1.z * num;
    return result;
    }
    
    // длинна вектора
   public  double getLength (){
       
       return Math.sqrt(x*x + y*y + z*z);
   }
   
   //сравнение векторов
   public static boolean equal (Vector v1, Vector v2){
           
           if (v1.x == v2.x &&  v1.y == v2.y && v1.z == v2.z)
           {  return  true;}
           else
           {return false;}      
}
   
   public String toString() {
      return ("(x: " + x + ", y: "+ y + ", z: "+ z + ") ");
   }
}