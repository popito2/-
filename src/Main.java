import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		FileModifier file = new FileModifier();
		openFile();
		
	}
	public static void openFile() {
		Scanner scanner = new Scanner(System.in);
		FileModifier fileM = new FileModifier();
		System.out.println("Write a file path!");
		String filePath = scanner.next();
		fileM.setFilePath(filePath);	
		FileOperatingOptions options = new FileOperatingOptions();
		try {
			Scanner scanner1 = new Scanner(new File(filePath));
			scanner1.close();
			options.choosingOperation(filePath);
		}catch(Exception e) {
			System.err.println("There is no such file!");
			openFile();
		}
		scanner.close();

	}
}
