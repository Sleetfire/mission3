package org.barkovsky;

import com.github.javafaker.Faker;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  throws Exception {

        if (args.length < 0 || args.length < 3) {
            System.err.println("Error");
            System.exit(1);
        }

        int users = 1;
        float errors = 0;

        if (args.length > 0) {
            try {
                users = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[1] + " must be an integer.");
                System.exit(1);
            }
            try {
                errors = Float.parseFloat(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[2] + " must be an float.");
                System.exit(1);
            }
        }

        String en = new String("en_US");
        String ru = new String("ru_RU");
        String by = new String("be_BY");

   if (users <= 0 || errors < 0) {
       System.err.println("Errors");
       System.exit(1);
   }

        if (args[0].equals(en)) {
            FileReader fr = new FileReader ("C:\\Users\\Андрей Барковский\\Desktop\\Faker\\en_US.txt");
            Scanner scan = new Scanner(fr);
            String str = scan.nextLine();
            fr.close();
            User[] arrayOfEnUsers = new User[users];
            Faker enFaker = new Faker(new Locale("en-US"));
            for (int i = 0; i < arrayOfEnUsers.length; i++) {
                arrayOfEnUsers[i] = new User(enFaker.name().fullName(), enFaker.address().zipCode(), str, enFaker.address().city(), enFaker.address().streetName(), getHomeNumber(), getFlatNumber(), enFaker.phoneNumber().phoneNumber(), users, errors);
            }
        } else if (args[0].equals(ru)) {
            InputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\Андрей Барковский\\Desktop\\Faker\\1ru_RU.txt"));
            Reader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            Scanner scan = new Scanner(reader);
            String str = scan.nextLine();
            inputStream.close();
            UserRu[] arrayOfRuUsers = new UserRu[users];
            Faker ruFaker = new Faker(new Locale("ru"));
            for (int i = 0; i < arrayOfRuUsers.length; i++) {
                arrayOfRuUsers[i] = new UserRu(ruFaker.name().fullName(), ruFaker.address().zipCode(), str, ruFaker.address().city(), ruFaker.address().streetName(), getHomeNumber(), getFlatNumber(), ruFaker.phoneNumber().phoneNumber(), users, errors);
            }
        }
        else if (args[0].equals(by)) {
            InputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\Андрей Барковский\\Desktop\\Faker\\be_BY.txt"));
            Reader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            Scanner scan = new Scanner(reader);
            String str = scan.nextLine();
            inputStream.close();
            UserBy[] arrayOfByUsers = new UserBy[users];
            Faker byFaker = new Faker(new Locale("by"));
            for (int i = 0; i < arrayOfByUsers.length; i++) {
                arrayOfByUsers[i] = new UserBy(byFaker.name().fullName(), byFaker.address().zipCode(), str, byFaker.address().city(), byFaker.address().streetName(), getHomeNumber(), getFlatNumber(), byFaker.phoneNumber().phoneNumber(), users, errors);
            }
        }
        else System.err.println("Error");

        }

        public static String getHomeNumber () {
            int number = (int) (1 + Math.random() * 100);
            return number + "";
        }

        public static String getFlatNumber () {
            int number = (int) (1 + Math.random() * 120);
            return number + "";
        }
    }



