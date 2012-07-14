package br.com.saitodisse.learning;

import java.io.*;

public class MyUtilities {

	public static boolean saveStringToFile(String path, String content) {
		File file = new File(path);
		
		boolean saved = false;
		BufferedWriter bw = null;

		try
		{
			bw = new BufferedWriter(new FileWriter(path));

			try 
			{
				bw.write(content);
			} 
			finally {
				bw.close();
				saved = true;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			saved = false;
		}
		return saved;
	}

	public static String getStringFromFile(String pathname) {
		File file = new File(pathname);
		if(!file.exists()){
			return "";
		}
		
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		try {
			br = new BufferedReader(new FileReader(pathname));
			try {
				String s;
				while ( (s = br.readLine()) != null  ) {
					sb.append(s);
					sb.append('\n');
				}
			} finally {
				br.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
