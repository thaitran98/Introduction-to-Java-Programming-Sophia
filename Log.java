import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;  


class Log {
//stores the log into 
   public void writeToLog(String line) {
  String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new java.util.Date());
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true));
      writer.write(timeStamp + " : " + line);
      writer.newLine();
      writer.close();
    }catch(IOException e){
      e.printStackTrace();
    }
   }

//method to read each line of the program
 public void readLog() {
    try{
      BufferedReader reader = new BufferedReader(new FileReader("logs.txt"));
      String line = reader.readLine();
      //loops through lines
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
      reader.close();
    }catch(IOException e){
      e.printStackTrace();
    }
   }

  
}