/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author konst
 */
public class Libraries {

    public static void outputLibrary(ChildrenLibrary lib, OutputStream out) throws IOException {
        String forOut = "Детская ";
        forOut += (lib.getNumHalls() + " ");
        for (int i = 0; i < lib.getNumHalls(); ++i) {
            forOut += (lib.getHallByNumber(i).getNumBooks() + " ");
            for (int k = 0; k < lib.getHallByNumber(i).getNumBooks(); ++k) {
                forOut += ("\"" + lib.getHallByNumber(i).getBookByNumber(k).getAuthor() + "\"" + " ");
                forOut += ("\"" + lib.getHallByNumber(i).getBookByNumber(k).getName() + "\"" + " ");
                forOut += (lib.getHallByNumber(i).getBookByNumber(k).getCost() + " ");
                forOut += (lib.getHallByNumber(i).getBookByNumber(k).getYear() + " ");
                forOut += (lib.getHallByNumber(i).getBookByNumber(k).getMinAge() + " ");
            }

        }
        byte[] b = forOut.getBytes();
        out.write(b);

    }

  static  String streamToString(InputStream in) throws IOException {
      System.out.println("  В функции 1");
  StringBuilder out = new StringBuilder();
        System.out.println("  В функции 2");

  BufferedReader br = new BufferedReader(new InputStreamReader(in));
        System.out.println("  В функции 3");

  for(String line = br.readLine(); line != null; line = br.readLine()) 
    out.append(line);
  
        System.out.println("  В функции 4 после for");

  br.close();

  return out.toString();
}
    
    public static ChildrenLibrary inputLibrary(InputStream in) throws IOException {
 System.out.println("  до чтения ");
        //http://developer.alexanderklimov.ru/android/java/inputstream.php
        //String resStr = IOUtils.toString(in, StandardCharsets.UTF_8);
        
         //Scanner s = new Scanner(in).useDelimiter("\\A");
        // String resStr = s.hasNext() ? s.next() : "";
        
         String resStr = streamToString(in);
         System.out.println("  после  чтения ");

        String[] splitedStr = resStr.split(" ");
        int numSymbol = 0;
       
        for (var ch : resStr.toCharArray()) {
            if (ch == '\"') {
                numSymbol++;
            }
        }
        int numAllBooks = numSymbol / 4;
        int numHalls = Integer.parseInt(splitedStr[1]);
        ChildrenBook[] books = new ChildrenBook[numAllBooks];
        for (int i = 0; i < numAllBooks; i++) {
            books[i] = new ChildrenBook(splitedStr[2 + i * 5], splitedStr[2 + i * 5 + 1], Double.parseDouble(splitedStr[2 + i * 5 + 2]), Integer.parseInt(splitedStr[2 + i * 5 + 3]), Integer.parseInt(splitedStr[2 + i * 5 + 4]));
        }

        ChildrenLibraryHall[] halls = new ChildrenLibraryHall[numHalls];
        int k = 0;
        ChildrenBook[] bookForHall = null;
        while (k < numHalls) {
            int numBookInPrevHall = Integer.parseInt(splitedStr[2]);
            for (int i = 0; i < numHalls; i++) {
               bookForHall  = new ChildrenBook[Integer.parseInt(splitedStr[numBookInPrevHall])];
            }
            for(int i = 0; i < numBookInPrevHall; i++){
            bookForHall[i] = new ChildrenBook();
            bookForHall[i] = books[i];
            }
            halls[k]= new ChildrenLibraryHall("Прочитанный зал "+ k, bookForHall);
        }

        ChildrenLibrary result = new ChildrenLibrary(halls);
        
        
        return null;
    }
}
