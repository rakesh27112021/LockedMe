package com.LockedMe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager {
	
	public static String lockedMeFolderPath;
	
	/**
	 * This function sets valid Folder path for LookedMe
	 * @return
	 * void
	 */
	public static void setLockedMeRootFolder() {
		
		// Variables declaration
		String lockedMeRootFolderPath;
		@SuppressWarnings("resource")
		Scanner scnrObj =new Scanner(System.in);
		File fl;
		boolean isValid=true;
		
		//Loop until user enter valid folder path for LockedMe
		do {
			
			if (isValid)
				System.out.println("Enter the LockedMe Folder Path: ");
			else
				System.out.println("Given Folder path does not exist, Enter the valid LockedMe folder path again: ");
			
			lockedMeRootFolderPath=scnrObj.nextLine();
			fl = new File(lockedMeRootFolderPath);
			
			if (!fl.exists())
				isValid=false;
			
		}while(!fl.exists());
		
		lockedMeFolderPath=lockedMeRootFolderPath;
		System.out.println("LockedMe folder set-up successfully and ready to use now");
		
		//close scanner 
		//scnrObj.close();
		
	}
	
	/**
	 * This function list-out(displays) all the file in the LockedMe folder
	 */
	public static void listAllFile() {
		File fl = new File(lockedMeFolderPath);	
		String[] files=fl.list();
		for (var file:files)
			System.out.println(file);
		System.out.println("Returning to main menu");
		
	}

	/**
	 * This function add new file to the LockedMe Directory if no such file aleady exist
	 */
	public static void addFile() {
		
		//Variable declaration
		@SuppressWarnings("resource")
		Scanner scnrObj = new Scanner(System.in);
		File fl;
		boolean exitLoop = false;
		
		do {
			System.out.println("Enter file name to be created or press 0 to return to main Menu: ");
			
			//Read file name from user
			String fileName = scnrObj.nextLine();
			
			
			if(fileName.equals("0"))
				exitLoop=true;
			else
			{
				//Check if file already exist
				fl = new File(lockedMeFolderPath + "\\" +fileName);
				if (fl.exists()) {
					System.out.println("File already exist, try with another valid name");
					
				}else {
					
					//Create new file 
					System.out.println("No such file exists, creating now");
					
					try {
						if (fl.createNewFile()) {
							System.out.printf("Successfully created new file: %s%n", fileName);
							//write to the file 
							AppendFileData(fileName);
						}
						else
							System.out.printf("Failed to create new file: %s%n", fileName);
						}
					
					catch(Exception Ex){
							System.out.printf(Ex.getMessage());
					}
					
				}
			}
		
		}while(!exitLoop);
			
		//scnrObj.close();
	}
	
	/**
	 * This function write/Append to the file present in the LockedMe Folder
	 * @param fileName
	 */
	public static void AppendFileData(String fileName) {
		
		//declare and initialize scanner object to read the file data from user
		@SuppressWarnings("resource")
		Scanner scnrObj = new Scanner(System.in);
		
		System.out.println("How many line you want to add to the file");
		try {
		
			//read how many lines data user want to add to the file
			int lines= Integer.parseInt(scnrObj .nextLine());
			
			//loop for each and and write to the file
			for (int i=1; i<=lines; i++) {
				System.out.printf("Enter line %s%n",i);
				String lineData = scnrObj.nextLine();
				BufferedWriter writer= new BufferedWriter(new FileWriter(lockedMeFolderPath + "\\" +fileName,true));
				writer.write(lineData);
				writer.newLine();
				writer.close();
			}
			System.out.println("File updated successfully");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
	}

	/**
	 * This function deletes the file by reading file name from user
	 */
	public static void deleteFile() {
		
		//declare and initialize scanner object to read the file name to be deleted
		@SuppressWarnings("resource")
		Scanner scnrObj = new Scanner(System.in);
		boolean exitLoop = false;
		
		do
		{
			System.out.println("Enter the file name to be deleted or press 0 to return to main Menu: ");
			
			//read file name to be deleted
			String fileName= scnrObj.nextLine();
		
			if(fileName.equals("0"))
				exitLoop=true;
			else
			{
				//create file object to delete file
				File fl = new File(lockedMeFolderPath + "\\" +fileName);
				
				//delete file
				try {
					if (fl.delete())
						System.out.println("File Successfully deleted");
					else
						if (fl.exists())
							System.out.println("Something went wrong, File not deleted");
						else
							System.out.println("File do exist");
							
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			
		}while(!exitLoop);
	}

	/**
	 * This function search the file by reading file name from user
	 */
	public static void searchFile() {
		
		//declare and initialize scanner object to read the file name to be searched
		@SuppressWarnings("resource")
		Scanner scnrObj = new Scanner(System.in);
		
		boolean exitLoop = false;
		
		do
		{
			
			System.out.println("Enter the file name to be searched or press 0 to return to main Menu: ");
			
			//read file name to be searched
			String fileName= scnrObj.nextLine();
			
			if(fileName.equals("0"))
				exitLoop=true;
			else
			{
				
				//create file object to search file
				File fl = new File(lockedMeFolderPath + "\\" +fileName);
				
				//delete file
				try {
					if (fl.exists())
						System.out.println("File Found");
					else
						System.out.println("File not found in the LockedMe folder");
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		
		}while(!exitLoop);

	}
}
