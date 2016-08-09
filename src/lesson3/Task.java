package lesson3;

import java.io.*;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class Task {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(
				"D:\\IT-Centre\\DZ1\\DZ1_4\\Task1_4.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader(
				"D:\\IT-Centre\\DZ1\\DZ1_4\\Task11_4.txt"));

		String file;
		String file1;

		ArrayList<String[]> fileAr = new ArrayList<String[]>();
		while ((file = br.readLine()) != null) {
			fileAr.add(file.split("[\\s,.]+"));
		}
		br.close();

		ArrayList<String> badWord = new ArrayList<String>();
		while ((file1 = br1.readLine()) != null) {
			badWord.add(file1);
		}
		br1.close();

		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"D:\\IT-Centre\\DZ1\\DZ1_4\\Task1_4.txt"));

		String x = "[вырезано цензурой]";
		
		for(String [] arr : fileAr){
			for(String str : arr){
				for (String chek : badWord) {
					if (str.equalsIgnoreCase(chek)) {
						bw.write(x);
					} else {
						bw.write(str);
					}
					bw.write(" ");
				}
			}
			bw.write("\r\n");
		}
		
	

	}
}