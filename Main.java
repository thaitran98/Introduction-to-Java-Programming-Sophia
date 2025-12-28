import java.io.BufferedWriter; //import for writing
import java.io.BufferedReader; //import for reading
import java.util.Scanner; //import for inputs
import java.io.FileWriter; //import for file writing
import java.io.FileReader; //import for file reading
import java.io.IOException; //import for exceptions
import java.util.*; //hashmap


public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String option = "";
     // create new HashMap
    HashMap<String, String> map = new HashMap<String, String>();
//try and catch for reading the file for the users
    try{
      BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
     String data = reader.readLine();
      //splits the data that was stored into a string by comma and stores each value into an index of an array
      
       String parts[] = data.split(",");
    //loops through each index of that array and splits it into it's key and value
     for (String part : parts) {
  
            // split the user data by colon an indexes it's key and value
            String userData[] = part.split(":");
  
            String userName = userData[0].trim();
            String userPass = userData[1].trim();
  
            // Add to map
            map.put(userName, userPass);
        }

      // System.out.println(map);
      reader.close();
    }catch(IOException e){
      e.printStackTrace();
    }
//creates instances for user and logs, so we can use the methods.
    Users user = new Users();
    Log readLogs = new Log();
//while loops until the option to close the program is chosen.
    while (!option.equals("4")) {
      System.out.println("Enter one of the following: \n '1' to log in: \n '2' to sign up: \n '3' to read log file: \n '4' to quit:");
      option = input.nextLine();
   //switch statement for the options.   
      switch (option) {
        case "1":
          System.out.println("You have chosen to log in.");
          user.userLogin(map, option);
          break;
        case "2":
          System.out.println("You have chosen to sign up.");
          user.createUser(map);
          break;
        case "3":
          System.out.println("You have chosen to read the log file.");
          readLogs.readLog();
          break;
        case "4":
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    }
    
    input.close();
  }
}