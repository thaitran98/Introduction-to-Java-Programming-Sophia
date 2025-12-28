import java.util.*;
import java.io.*;


class Users {
  Scanner input = new Scanner(System.in);
  Log logWriter = new Log();
  
  public void createUser(HashMap<String,String> map) {
     String username = "";
     String password = ""; 
     boolean userCreated = false;
    //creates a while loop for correct answers until a user is successfully created
      while (!userCreated){
             System.out.println("Please enter a username:");
             username = input.nextLine();
             System.out.println("Please enter a password:");
             password = input.nextLine();
          //conditionals to make sure the username doesn't exist and the password is longer than 5 characters
          if(map.containsKey(username)){
            System.out.println("That username already exist!");
            logWriter.writeToLog("ERROR: There was an attempt to create " + username + " which already exists");
          }else if(password.length() < 5){
            System.out.println("That password is too short!");
            logWriter.writeToLog("ERROR: The password for user: " + username + " was too short.");
          }else{
            map.put(username, password);
            System.out.println("User created!");
            logWriter.writeToLog("SUCCESS: " + username + " was created.");
            userCreated = true;

            try {
  
            // create new BufferedWriter for the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"));
  
            // iterate map entries
            String dataStr = "";
            for (Map.Entry<String, String> entry :
                 map.entrySet()) {
  
                // saves key and value to string to write to file
                dataStr += entry.getKey() + ":" + entry.getValue() + ",";
            }
            //writes the string to the file overwriting everyhing, then closes file
            writer.write(dataStr);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }            
          }
      }
  }

  //handles logging in, by checking against hash map
 public void userLogin(HashMap<String,String> map, String option) {
    String username = "";
    String password = ""; 

      System.out.println("Please enter a username:");
      username = input.nextLine();
      System.out.println("Please enter a password:");
      password = input.nextLine();
//conditionals if map contains username, and if that value(password) is tied to the username
      if(map.containsKey(username)){
           String value = map.get(username);
              if(password.equals(value)){
                System.out.println("You have successfully logged on!");
                logWriter.writeToLog("SUCCESS: " + username + " has logged on.");
                option = "4";
              }else{
                System.out.println("The information provided does not match within our system.");
                logWriter.writeToLog("ERROR: The password for: " + username + " was incorrect.");
              }
          }else{
            System.out.println("No such information within our system.");
        logWriter.writeToLog("ERROR: " + username + " does not exist within our database.");
          }
  }
  
}