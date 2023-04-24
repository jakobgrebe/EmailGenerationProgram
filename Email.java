import java.util.Scanner;
import java.lang.Math;


public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

   // Constructor to recieve first and last name
    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        // Combine elements to generate email
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
   // Ask for department 
    private String setDepartment(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("New Employee: " + firstName+ "\n" + "CHOOSE DEPARTMENT \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        System.out.print("Department Choice: ");
        int choice = scnr.nextInt();
        if (choice == 1){ return "sales";}
        else if (choice == 2){ return "dev";}
        else if (choice == 3){return "acc";}
        else {return "";}
           
    }
   // Generate a Random Passoword
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }
   //Set the mailbox capacity 
   public void setMailboxCapacity(int capacity){
    this.mailboxCapacity = capacity;
   }
   
   //Set the alternate email
public void setAlternateEmail(String altEmail){
    this.alternateEmail = altEmail;
}
   // Change the password 
public void changePassword(String password){
    this.password = password;
}
public int getMailBoxCapacity(){
    return mailboxCapacity;
}
public String getAlternateEmail(){
    return alternateEmail;
}
public String getPassword(){
    return password;
}
public String showInfo(){
    return "DISPLAY NAME: " + firstName + " " + lastName + "\n" +
            "COMPANY EMAIL: " + email + "\n" + 
            "MAILBOX CAPACITY: " + mailboxCapacity + "mb";

}
}
