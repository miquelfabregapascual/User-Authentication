/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class exercise {

    /**
     * @param args the command line arguments
     *
     */
public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    int option;

    do {
        menu();
        option = input.nextInt();
        System.out.println("You entered option:" + option);

        switch (option) {
            case 1:
                Exercise1();
                break;
            case 2:
                Exercise2();
                break;
            case 3:
                Exercise3();
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    } while (option != 0);
}

    private static void menu() {
        System.out.println("******MENU******");
        System.out.println("1.- Exercise 1");
        System.out.println("2.- Exercise 2");
        System.out.println("3.- Exercise 3");
        System.out.println("0.- Exit");
    }

    private static void Exercise1() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("./file.txt", true);
            Scanner input = new Scanner(System.in);
            String text = "a";
            while (!"".equals(text)) {
                System.out.println("Enter username (leave blank to finish):");
                text = input.nextLine();
                System.out.println("Enter password (leave blank to finish):");
                String text2 = input.nextLine();
                if (!"".equals(text)) fw.write(text+":"+text2 + "\n");
            }   fw.close();
        } catch (IOException ex) {
            Logger.getLogger(exercise.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(exercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   public static void Exercise2() throws FileNotFoundException, IOException {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter username:");
    String username = input.nextLine();

    System.out.println("Enter password:");
    String password = input.nextLine();

    FileReader fr = new FileReader("./file.txt");
    BufferedReader br = new BufferedReader(fr);

    String line;
    boolean found = false;

    while ((line = br.readLine()) != null) {
        String[] parts = line.split(":");
        if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
            found = true;
            break;
        }
    }

    br.close();
    fr.close();

    if (found) {
        System.out.println("Login Successful");
    } else {
        System.out.println("Login Failed");
    }
}

  private static void Exercise3() throws FileNotFoundException, IOException{
      FileWriter f = null;
        try {
            f = new FileWriter("./groups.txt", true);
            Scanner entrada = new Scanner(System.in);
            String text3 = "a";
            while (!"".equals(text3)) {
                System.out.println(" Enter Group (leave blank to finish)::");
                text3 = entrada.nextLine();
                if (!"".equals(text3));
                if (!existeixGrup(text3)){
                    f.write( text3 + "\n");
                }
                else{
                     System.out.println("Group already exist."); // print the use (text writed) doesnt exist  
                     f.close();
                }
            }
              System.out.println("Group " + text3 + ", doesn't exist."); // print the use (text writed) doesnt exist  
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(exercise.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(exercise.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
     }
     private static boolean grupExisteix(String grup, Object text3) throws IOException{
             FileReader fr = new FileReader("./gruops.txt");
             BufferedReader buf = new BufferedReader(fr);
             String linia = buf.readLine();
             while (linia != null){
             if (linia.equals(text3)){
                 buf.close();
                 fr.close();
                 return true;
             }
             }
             buf.close();
             fr.close();
             return false;
         }

   private static boolean existeixGrup(String text3) throws IOException {
    FileReader fr = new FileReader("./groups.txt");
    BufferedReader buf = new BufferedReader(fr);
    String linia;
    while ((linia = buf.readLine()) != null) {
        if (linia.equals(text3)) {
            buf.close();
            fr.close();
            return true;
        }
    }
    buf.close();
    fr.close();
    return false;
}

         }
