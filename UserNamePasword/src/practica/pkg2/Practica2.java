/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Practica2 {

    /**
     * @param args the command line arguments
     *
     */
public static void main(String[] args) throws IOException {
    Scanner entrada = new Scanner(System.in);
    int opcion;

    do {
        menu();
        opcion = entrada.nextInt();
        System.out.println("Has entrat la opcio:" + opcion);

        switch (opcion) {
            case 1:
                Exercici1();
                break;
            case 2:
                Exercici2();
                break;
            case 3:
                Exercici3();
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    } while (opcion != 0);
}

//      FileReader text = new FileReader("./arxiu.txt");
//       BufferedReader buf = new BufferedReader(text);
//        String linia = buf.readLine();
//        while (linia != null) {
//           if (linia.contains(text)) {
//                return true;
//         }
//            linia = buf.readLine();
//      }
//        return false;
//     }
    private static void menu() {
        System.out.println("******MENU******");
        System.out.println("1.- Exercici 1");
        System.out.println("2.- Exercici 2");
        System.out.println("3.- Exercici 3");
          System.out.println("0.- Exit");
    }

    private static void Exercici1() {
        FileWriter f = null;
        try {
            f = new FileWriter("./arxiu.txt", true);
            Scanner entrada = new Scanner(System.in);
            String text = "a";
            while (!"".equals(text)) {
                System.out.println("introdueix el nom usuari(deixa en blanc per finalitzar):");
                text = entrada.nextLine();
                System.out.println("introdueix la contrasenya(deixa en blanc per finalitzar):");
                String text2 = entrada.nextLine();
                if (!"".equals(text)) f.write(text+":"+text2 + "\n");
            }   f.close();
        } catch (IOException ex) {
            Logger.getLogger(Practica2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(Practica2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   public static void Exercici2() throws FileNotFoundException, IOException {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Escriu el nom d'usuari:");
    String username = entrada.nextLine();

    System.out.println("Escriu la contrasenya:");
    String password = entrada.nextLine();

    FileReader fr = new FileReader("./arxiu.txt");
    BufferedReader buf = new BufferedReader(fr);

    String linia;
    boolean found = false;

    while ((linia = buf.readLine()) != null) {
        String[] parts = linia.split(":");
        if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
            found = true;
            break;
        }
    }

    buf.close();
    fr.close();

    if (found) {
        System.out.println("Login Correcte");
    } else {
        System.out.println("Login Incorrecte");
    }
}

     private static void Exercici3() throws FileNotFoundException, IOException{
      FileWriter f = null;
        try {
            f = new FileWriter("./gurps.txt", true);
            Scanner entrada = new Scanner(System.in);
            String text3 = "a";
            while (!"".equals(text3)) {
                System.out.println("introdueix el nom del grup (deixa en blanc per finalitzar):");
                text3 = entrada.nextLine();
                if (!"".equals(text3));
                if (!existeixGrup(text3)){
                    f.write( text3 + "\n");
                }
                else{
                     System.out.println("El grup ja existeix."); // print the use (text writed) doesnt exist  
                     f.close();
                }
            }
              System.out.println("El Grup " + text3 + ", no existeix."); // print the use (text writed) doesnt exist  
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(Practica2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(Practica2.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
     }
     private static boolean grupExisteix(String grup, Object text3) throws IOException{
             FileReader fr = new FileReader("./grups.txt");
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
    FileReader fr = new FileReader("./gurps.txt");
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
         
      


