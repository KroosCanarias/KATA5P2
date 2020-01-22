package view;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReader {

    public static List<Mail> read(String fileName){
        List<Mail> list = new ArrayList<>();
        try{BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
	    while (true) {
		String line = reader.readLine();
		if (line == null) {
		    break;
		}
		if (Mail.isMail(line)) {
		    list.add(new Mail(line));
		}
	    }
        } catch (FileNotFoundException exception) {
	    System.out.println("ERROR MailListReader::read (FIle Not Found) " + exception.getMessage());
	} catch (IOException exception) {
	    System.out.println("ERROR MailListReader::read (FIle Not Found) " + exception.getMessage());
	}
        return list;
    }
}

