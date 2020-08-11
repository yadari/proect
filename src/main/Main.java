package main;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {


    public static void main(String[] args) throws SQLException {
        Scanner in =new Scanner(System.in);
        Person ob=new Person();
        String q;
        q = null;
        do{
        System.out.println("1.for add user \n2.for select user\n3.for delete user");
        int a=in.nextInt();
        switch(a){
            case 1:{
                System.out.print("Enter a name: ");
                String name=in.nextLine();
                in.nextLine();
                System.out.print("Enter a Age: ");
                int age=in.nextInt();
                System.out.print("Enter a gender: ");
                String gender=in.nextLine();
                in.nextLine();
                ob.insert(name, age, gender);
            }
                break;
            case 2:
        {
            try {
                ob.select();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
                case 3:{
                    System.out.print("Enter a name to delete: ");
                String name=in.next();
                ob.delete(name);
                }
                break;
                default: System.out.println("please enter a valid number");
        }
        System.out.println("Enter q to exit and any for replay");
       q= in.next();
        }while(!q.equalsIgnoreCase("q"));
    System.out.println("good bye");
    
}
}
