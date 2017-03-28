package chappelle.five.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import tan.five.model.Student;

public class CheckOutFinalController {
	public static void main(String[]args) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File("test.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("DATE / TIME");
        sb.append(',');
        sb.append("CHECK IN / OUT");
        sb.append(',');
        sb.append("STUDENT");
        sb.append(',');
        sb.append("EQUIPMENT");
        sb.append('\n');
        sb.append("beep beep");

        
        
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
	}
	
	
	
        public static void updateLog(StringBuilder sb) {
        	sb.append(LocalDateTime.now());
            sb.append(',');
            //IF(CHECKING IN / CHECKING OUT)//
            sb.append(Student.SELECTED_STUDENT);
            sb.append(',');
            //PRINT EQUIPMENT HERE//
            sb.append(',');
	}
}
