import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileModifier {
	
	private String filePath="";
	
	public void setFilePath(String filePath) {
		this.filePath=filePath;
	}
	public String getFilePath(){
		return this.filePath;
	}
	

	public void swapLines(int firstIndex, int secondIndex, String filePath) throws IOException {
		Scanner scanner = new Scanner(new File(filePath));
		ArrayList<String> textInFile = new ArrayList<String>();
		
		while (scanner.hasNextLine()){
		    textInFile.add(scanner.nextLine());
		}	
		
		Collections.swap(textInFile, firstIndex, secondIndex);
		PrintWriter printWriter = new PrintWriter(filePath);
		
	    for (String s : textInFile) {
	        printWriter.println(s);
	    }
	    printWriter.close();
		System.out.println("Done!");
		scanner.close();
	}
	public void swapWords(int firstLineIndex,int firstWordIndex,int secondLineIndex,int secondWordIndex,String filePath) throws FileNotFoundException {

		Scanner file = new Scanner(new File(filePath));
		String firstLine="",secondLine="";
		List<ArrayList<String>> textInFile= new ArrayList();
		List<String> lineOfFile = new ArrayList<String>();
		ArrayList<String> firstLineOfFile = new ArrayList<String>();
		ArrayList<String> secondLineOfFile = new ArrayList<String>();
		
		for(int i=0; i<4; i++) {
		    String x = file.nextLine();
		    String[] arr= x.split(" ");
		    lineOfFile = new ArrayList<String>();
		    for(int j=0;j<arr.length;j++)
		    {
		    	lineOfFile.add(arr[j]);
		    }
		    
		    textInFile.add(i, (ArrayList<String>) lineOfFile);
		}
		
		firstLineOfFile=textInFile.get(firstLineIndex);
		secondLineOfFile=textInFile.get(secondLineIndex);
		
		firstLine=firstLineOfFile.get(firstWordIndex);
		secondLine=secondLineOfFile.get(secondWordIndex);
		
		firstLineOfFile.set(firstWordIndex, secondLine);
		secondLineOfFile.set(secondWordIndex, firstLine);
		
		textInFile.set(firstLineIndex, firstLineOfFile);
		textInFile.set(secondLineIndex, secondLineOfFile);
		
		for(int i=0;i<4;i++) {
			System.out.println(textInFile.get(i));
		}
		
		PrintWriter printWriter = new PrintWriter(filePath);
		
	    for (ArrayList<String> s : textInFile) {
	        printWriter.println(String.join(" ", s));
	    }
	    
	    printWriter.close();
		System.out.println("Done!");
		file.close();
	}
}
