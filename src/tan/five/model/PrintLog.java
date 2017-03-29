package tan.five.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PrintLog {

	private static File log = new File("log.csv");
	private static File equipmentList = new File("Resources/Sample Equipment.csv");
	private static File equipmentListTest = new File("/Users/ashleytan/Desktop/Sample Equipment.csv");

	static List<String> lines = new ArrayList<String>();
	static String line = null;

	public static void main(String[] args) throws FileNotFoundException {


	}


	public static void updateLog(Boolean checkIn, Equipment equipment) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream(log, true));
		StringBuilder sb = new StringBuilder();

		sb.append(LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss")),		//Date + Time
				DateTimeFormatter.ofPattern("yyyy MM dd HH mm ss"))); 										
		sb.append(',');

		if(checkIn) {																										//In / Out
			sb.append("IN");
		}
		else {
			sb.append("OUT");
		}

		sb.append(',');
		sb.append(Student.SELECTED_STUDENT.getFirstName() + " " + Student.SELECTED_STUDENT.getLastName());					//Student Name
		sb.append(',');
		sb.append(Student.SELECTED_STUDENT.getStudentID());																	//Student ID
		sb.append(',');
		sb.append(equipment.getEquipmentName());																			//Equipment Name
		sb.append('\n');

		pw.write(sb.toString());
		pw.close();

	}


	public static void alterEquipmentFile(Equipment equipmentCheckingOut) throws FileNotFoundException {
		try { 
			FileReader fr = new FileReader(equipmentListTest);
			FileWriter fw = new FileWriter(equipmentListTest);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);

			while ((line = br.readLine()) != null) {
				if (line.contains(equipmentCheckingOut.getEquipmentName())){
					//line = line.replace("IN", "SUCCESS");
					bw.write(line.replace("IN", "SUCCESS"));
					bw.write("\n");
					
				}
			}
			fr.close();
			br.close();
			
			br.close();
			bw.flush();
			bw.close();

			
		/*for(String s : lines) {
				if (line.contains(equipmentCheckingOut.getEquipmentName())){
					out.write(s);
					out.write("\n");
				}
			}*/
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
