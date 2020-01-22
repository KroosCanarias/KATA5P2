package main;
import java.util.List;
import model.*;
import view.*;
public class Kata4 {
    public static void main(String[] args) {
        String fileName=new String("email.txt");
        List<Mail> mailList = MailListReader.read(fileName);
	Histogram histogram = MailHistogramBuilder.build(mailList);
	HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
	histoDisplay.execute();
    }
    
}
