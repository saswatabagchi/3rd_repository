package com.assignment.simplejosn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;





public class FileWrighter {

	public static void main(String[] args) {

	String fileName = "SIT";

		try {
			Writer output = null;
			Employee emp = new Employee("Subir ",30,50000.00,"BFSI","ITA");
			//System.out.println(emp);
			String text = emp.toString();
			Map< File , String  > fileConDetails = FileWrighter.getFileName(fileName);
		    File file = (File) fileConDetails.keySet().toArray()[0];
		    String fileExist = (String) fileConDetails.values().toArray()[0];
		    if (fileExist == "true") {
			output = new BufferedWriter(new FileWriter(file));
			System.out.println("file processing done  ");
			output.write(text);
			output.close();
		    }else {
		    	System.out.println("folder Not Found at " + fileName );
		    }

		} catch (FileNotFoundException e) {
			System.out.println("file Not Found ");
			//e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static Map< File, String > getFileName (String fileDestinationEnv ) {
		
		Map< File , String  > fileConDetails = new HashMap<>();
		ParameterFileRead prm = new ParameterFileRead();
		ParameterFileRead.enviromentLoad();
		String folderLocation = ParameterFileRead.fileDescripter.get(fileDestinationEnv);
		String fileExistance;
		File fileCon = new File(folderLocation );
		
		if (fileCon.exists()) {
			fileExistance = "true";
		}else {
		     fileExistance = "false";
		}

		fileConDetails.put(fileCon, fileExistance );
		//System.out.println(fileCon.exists());
		return fileConDetails;
	}
}
