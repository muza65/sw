package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private ArrayList<RegisterAsDriver> driversUsingTheSystem = new ArrayList();
    private ArrayList<String> suspendingAccounts = new ArrayList();
    Scanner input;
    private static Admin instance = new Admin();
    private static String UserName = "ADMIN_55";
    private static String Password = "12334567";


    RegisterAsDriver obj=new RegisterAsDriver();

    private Admin() {
        this.input = new Scanner(System.in);
    }

    public static void setPassword(String password) {
        Password = password;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static String getUserName() {
        System.out.println(UserName);
        return UserName;
    }

    public static String getPassword() {
        System.out.println(Password);
        return Password;
    }

    public static Admin getInstance() {
        return instance;
    }

    public void verifyRegistration() {
        System.out.println("This is the list of the pending drivers ,enter (accept or refuse) for each one of them to allow or prevent him from using the system:");

        for(int i = 0; i < obj.getPendingDrivers().size(); ++i) {
            obj.getPendingDrivers().get(i);
            System.out.print(" : ");
            String stat = this.input.nextLine();
            if (this.input.equals("accept")) {
                this.driversUsingTheSystem.add(obj.getPendingDrivers().get(i));
                obj.setMap_Driv(obj.getPendingDrivers().get(i).getUserName(),obj.getPendingDrivers().get(i).getPassword());
            } else {
                System.out.println("The admin refuse Your Registration");
            }
        }

    }

    public void suspendAccount(String userName) {
        boolean status = false;

        for(int i = 0; i < this.driversUsingTheSystem.size(); ++i) {
            if (userName.equals(((RegisterAsDriver)this.driversUsingTheSystem.get(i)).getUserName())) {
                this.suspendingAccounts.add(userName);
                status = true;
                break;
            }
        }

        if (!status) {
            System.out.println("This UserName isn't correct and found on the System");
        }

    }

    public void activateAccount(String userName) {
        boolean status = false;

        for(int i = 0; i < this.suspendingAccounts.size(); ++i) {
            if (((String)this.suspendingAccounts.get(i)).equals(userName)) {
                this.suspendingAccounts.remove(i);
                status = true;
                break;
            }
        }

        if (!status) {
            if (this.driversUsingTheSystem.contains(userName)) {
                System.out.println("This account is found on the system but not suspended");
            } else {
                System.out.println("This UserName isn't correct and found on the System");
            }
        }

    }

    public ArrayList<RegisterAsDriver> getDriversUsingTheSystem() {
        return this.driversUsingTheSystem;
    }
}
