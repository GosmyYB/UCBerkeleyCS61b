/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputLine;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();
  
    String urlStr = "http://www.x.com";
    URL url = new URL(urlStr.replace("x", inputLine));
    // print the fisrt five lines of the page in reverse order.
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    
    String s1 = reader.readLine();
    String s2 = reader.readLine();
    String s3 = reader.readLine();
    String s4 = reader.readLine();
    String s5 = reader.readLine();
    System.out.println(s5);
    System.out.println(s4);
    System.out.println(s3);
    System.out.println(s2);
    System.out.println(s1);
  }
}
