package br.com.saitodisse.learning;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyUtilitiesTest {
	@Test
	public void saveStringToFile() {
		String saveString = "this is test line one\n"+ 
				"this is test line two\n";
		
		File testFile = new File("testsavetostring.txt");
		testFile.delete();
		
		assertFalse("File should not exist",
				testFile.exists());
		
		assertTrue("File should have been saved",
				MyUtilities.saveStringToFile("testsavestring.txt",
						saveString));
		
		String newString = MyUtilities.getStringFromFile(
				"testsavestring.txt");
		
		assertTrue("Save and get strings should be equal",
				saveString.equals(newString));
		
		assertFalse("File should not be saved",
				MyUtilities.saveStringToFile(
						"non-existent directory/thisshouldfail.txt",
						saveString));
		
		String emptyString = MyUtilities.getStringFromFile(
				"badfilename.txt");
		
		assertTrue("String should be empty", 
				emptyString.length() == 0);
	}
}
