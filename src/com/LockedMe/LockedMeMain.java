package com.LockedMe;

import java.util.Scanner;

public class LockedMeMain {
	

	public static void main(String[] args) {
				
		Scanner scnrObj =new Scanner(System.in);
		boolean isExit = false;
		String ch;
		
		lockedMeSetup();
		
		do {
			lockedMeMenu();
			System.out.println("Enter your choice: ");
			ch=scnrObj.nextLine();
			
			switch (ch) {
				case "1":
					FileManager.listAllFile();
					break;
				case "2":
					FileManager.addFile();
					break;
				case "3":
					FileManager.deleteFile();
					break;
				case "4":
					FileManager.searchFile();
					break;
				case "5":
					isExit=true;
					System.out.println("Exited successfully");
					System.exit(1);
					break;
				default:
					System.out.println("Invalid Option, try again");
				
			}
		
		}while(!isExit);
		scnrObj.close();

	}
	
	public static void lockedMeSetup() {
		System.out.println("*************************************************************************");
		System.out.println("\t\t\t\tLockedMe");
		System.out.println("*************************************************************************");
		System.out.println("");
		FileManager.setLockedMeRootFolder();
		System.out.println("");
		
		
	}
	
	public static void lockedMeMenu() {
		System.out.println("*************************************************************************");
		System.out.println("\t\t\t\tMain Menu");
		System.out.println("*************************************************************************");
		System.out.println("1. List all files");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
	}
	

}
