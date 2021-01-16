
package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReader {
    
    public static List<Mail> read(String fileName){
        List<Mail> listMail = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                if (line.split("@").length == 2){
                    listMail.add(new Mail(line));
                }
                line = br.readLine();   
            }
        }catch (Exception e) {
            System.out.println("Error: File " + e.getMessage());
        }
        
        return listMail;
    }
}
