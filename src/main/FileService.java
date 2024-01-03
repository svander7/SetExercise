package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;

public class FileService {

	public static void main(String[] args) throws FileNotFoundException{
		
		Set<String> hands = new HashSet<>();
		
		Scanner scanner = new Scanner(new File("PokerHands.csv"));
        scanner.nextLine(); 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            hands.add(tokens[1]);
            
            hands.removeIf(hand -> hand.equals("ACE HIGH") || hand.equals("QUEEN HIGH"));
            
            List<String> handsList = new ArrayList<>(hands);
            handsList.replaceAll(hand -> hand.equals("PAIR") ? "DEUCES" : hand);
            hands = new HashSet<>(handsList);
            
            for (String hand : hands) {
            	System.out.println(hand);
            }
                                    
        }
        scanner.close();
    }
	public static void printToConsole() {

	}
	
	public static Set<String> extractDataFromCSV(String fileName) {

		return null;
	}

}