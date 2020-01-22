package main;
import model.Mail;
import java.util.List;
import model.*;
import view.*;
public class Kata5p2 {
    public static void main(String[] args) {
        String fileName=new String("email.txt");
        MailListReaderBD.execute();
        List<Mail> mailList = MailListReaderBD.list;
	Histogram histogram = MailHistogramBuilder.build(mailList);
	HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
	histoDisplay.execute();
    }
    
}
