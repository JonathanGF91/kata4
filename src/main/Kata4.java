
package main;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata4 {
    
    private static String fileName = "email.txt";
    private static List<Mail> listMail;
    private static Histogram<String> histogram;

    public static void main(String[] args) {
        input();
        process();
        output();
    }
    
    private static void input(){
        listMail = MailListReader.read(fileName);    
    }
    
    private static void process(){
        histogram = MailHistogramBuilder.build(listMail);
    }
    
    private static void output(){
        HistogramDisplay histoDisplay = new HistogramDisplay("Histogram", histogram);
        histoDisplay.execute();
    }    
}
