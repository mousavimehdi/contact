package contact;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

class DataBase
{

    Properties properties;
    File file = new File("contact.jar");

   public void store(Properties properties)  {

        try {
                this.properties=properties;
                PrintWriter printWriter = new PrintWriter(file);
                properties.store(printWriter, "contact list ");
                printWriter.flush();

        }catch (IOException e){System.out.println();}

    }

}


class GetName  {
    Properties properties;

    GetName() {

        String removename;
        int command;
        String name;
        String phonenumber;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);


        System.out.println("to add contact type '1' ");
        System.out.println("to search contact type '2': ");
        System.out.println("to remove contact type '3' ");
        System.out.println("to edit contact type '4' ");

        command=scanner.nextInt();

        switch (command)
        {
            case 1 :

                do {

                    System.out.println("Name:");
                    name = scanner1.nextLine();

                    System.out.println("PhoneNumber:");
                    phonenumber = scanner1.nextLine();

                    properties.put(name, phonenumber);
                    new DataBase().store(properties);

                    System.out.println("to return enter exit as name");

                } while (!(name.equals("exit") || name.equals("Exit")));

                break;

            case 2:

                System.out.print("the name should fine is : ");
                String searchname = scanner1.nextLine();
                search(searchname);

                break;

            case 3:

                do {
                    System.out.println("the name should remove is : ");
                    removename = scanner1.nextLine();
                    System.out.println("type exit to return ");
                    remove( (removename));
                }while (!(removename.equals("exit")||removename.equals("Exit")));


                break;
            case 4:


                System.out.println("the name should edit is : ");
                String oldName = scanner1.nextLine();

                System.out.println("the new name  is : ");
                String newName = scanner1.nextLine();

                System.out.println("the new number  is : ");
                String newNumber = scanner1.nextLine();

                edit(oldName,newName,newNumber);

                break;
        }


    }
    public void search (String str)
    {
        try {

            FileInputStream fileInputStream = new FileInputStream( new File("contact.jar"));
            properties.load(fileInputStream);
            System.out.println(properties.getProperty(str,"not exist") );
            new DataBase().store(properties);
            fileInputStream.close();
            }catch (Exception e){}

    }
    public void remove(String str)
    {
        try {
            FileInputStream fileInputStream = new FileInputStream( new File("contact.jar"));
            properties.load(fileInputStream);
            properties.remove((Object) str);
            System.out.println(" remove ...");
            new DataBase().store(properties);
            fileInputStream.close();
        }catch (IOException e ){}

    }

    public void edit(String str,String newName,String number)
    {
        try {
            FileInputStream fileInputStream = new FileInputStream( new File("contact.jar"));
            properties.load(fileInputStream);
            properties.remove(str);
            properties.put(newName,number);
            new DataBase().store(properties);
            fileInputStream.close();
        }catch (IOException e ){}


    }
}

public class Contact {
    public static void main(String[] args) {

        new GetName();

    }
}
