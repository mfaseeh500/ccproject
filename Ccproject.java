/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccproject;

import java.util.Scanner;

/**
 *
 * @author MUHAMMAD FASEEH
 */
public class Ccproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
      
       Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
      Lexer x =  new Lexer(input);
      Interprator i=new Interprator(x);
      int result = i.expr();
      System.out.println(result);
    }
        
    }
    

