import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class SpanishToEnglish {
	
	File file;
	BufferedReader in;
	TreeMap<String, String> wordMap;
	
	public SpanishToEnglish() throws IOException {
		wordMap = new TreeMap<String, String>();
		try {
			file = new File("/home/compsci/eclipse-workspace/021MapsLab1/src/spantoeng.dat");
			in = new BufferedReader(new FileReader(file));
		} catch (Exception e) {
			System.out.println("file not found, exiting program");
			System.exit(0);
		}
		for (int i = 0; i< 46; i++) {
			String[] temp = in.readLine().split(" ");
			wordMap.put(temp[0], temp[1]);
		}
		
	}
	
	public void translate() throws IOException {
		while (in.ready()) { // while there's more lines in the file
			String[] spanText = in.readLine().split(" ");
			ArrayList<String> engText = new ArrayList<String>();
			for (String s : spanText) {
				engText.add(wordMap.get(s)); // add the corresponding english word to an arraylist
			}
			for (String e : engText) {
				System.out.print(e + " ");
			}
			System.out.println();
			engText.clear();
		}
		

	}

}
