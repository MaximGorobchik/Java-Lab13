import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) {
        if(args.length < 2) {
            System.out.println("Not enough parameters (requirement - 2)");
            return;
        }
        String thisLine;
        ArrayList list = new ArrayList();
        BufferedReader fin = null;
        try {
            fin = new BufferedReader(new InputStreamReader(
                    new FileInputStream(args[0])));
            while ((thisLine = fin.readLine()) != null) {
                System.out.println("Your line: "+thisLine);
                list.add(thisLine);
            }
            Collections.sort(list);
            System.out.print("Sorted list:");
            Iterator iter = list.iterator();
            while(iter.hasNext() ) {
                String str = (String)iter.next();
                System.out.print(str);
            }
            String searchString = args[1];
            if (list.contains(searchString)) {
                System.out.println("The string '" + searchString + "' was found in the list");
            } else {
                System.out.println("The string '" + searchString + "' was not found in the list");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found: " + args[0]);
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Input/output error. File" + args[0]);
            System.out.println("Error: " + e);
        } finally {
            if ( fin != null )
                try {
                    fin.close(); // !!! Закрыть файл
                } catch ( IOException ex ) {
                    System.out.println("Error closing file " + args[0]);
                    System.out.println("Error: " + ex);
                }
            fin = null;
        }
    }
}