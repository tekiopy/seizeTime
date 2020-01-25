package seizeTime;

import java.io.File;

import java.util.Scanner;

import java.util.TreeMap;


public class SeizeTimeData {
	
	public static TreeMap<String, Integer> countriesDictionary = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
	//readInputAndConvertInDictionary("resources/timeZoneData.txt");
	
	public SeizeTimeData() {
		// TODO Auto-generated constructor stub
		readInputAndConvertInDictionary("resources/timeZonesData.txt");
	}
	
	public static TreeMap<String, Integer> getTreeMap(){
		return countriesDictionary;
	}
	
	public static void readInputAndConvertInDictionary(String fileInputName) {
		File file = new File(fileInputName);
		Scanner readFile = null;
		
		try {
			readFile = new Scanner(file);
			while(readFile.hasNextLine()) {
				String[] lineStrings = readFile.nextLine().split(",");
				countriesDictionary.put(changeOrder(lineStrings[0]), Integer.valueOf(lineStrings[1]));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			readFile.close();
		}
	}
	
	//change order of country
	//Europe/Madrid --> Madrid/Europe
	public static String changeOrder(String country) {
		String changedString = "";
		for(int i = 0; i < country.length(); i++) {
			if(country.charAt(i) == '/') {
				changedString = country.substring(i+1, country.length()) + "/" + country.substring(0, i);
			}
		}
		return changedString;
	}


}
