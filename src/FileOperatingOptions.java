import java.io.IOException;
import java.util.Scanner;

public class FileOperatingOptions {
	public void choosingOperation(String filePath) throws IOException {
		int option;
		Scanner scanner = new Scanner(System.in);
		FileModifier file = new FileModifier();
		System.out.printf("What do you want to swap?\n1)Lines\n2)Words\n");		
		option=scanner.nextInt();
		
		if (option == 1) {
			System.out.println("Whitch lines you want to swap?");
			int firstIndex,secondIndex;	
			firstIndex=scanner.nextInt();
			secondIndex=scanner.nextInt();
			file.swapLines(firstIndex-1,secondIndex-1,filePath);
		} else if (option == 2) {
			int firstLineIndex,firstWordIndex,secondLineIndex,secondWordIndex;

			System.out.println("Enter the index of first the line and the word:");
			firstLineIndex = scanner.nextInt();
			firstWordIndex = scanner.nextInt();

			System.out.println("Enter the index of second the line and the word:");
			secondLineIndex = scanner.nextInt();
			secondWordIndex = scanner.nextInt();

			file.swapWords(firstLineIndex-1,firstWordIndex-1,secondLineIndex-1,secondWordIndex-1,filePath);
			
		}
		else {
			System.err.println("Wrong input!");
			choosingOperation(filePath);
		}
		scanner.close();
	}
}
