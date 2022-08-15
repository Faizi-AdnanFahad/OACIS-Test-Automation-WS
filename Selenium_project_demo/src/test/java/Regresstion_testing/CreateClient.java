package Regresstion_testing;

import java.util.Scanner;

import Excel_Handlers.ExcelDataByRowColIndex;

public class CreateClient {

	public static void main(String[] args) {
		
		 String input = "";
		 String lastNameInput = "";
		 String firstNameInput = "";
		 String dobInput = "";
		 
		  while(!input.toUpperCase().equals("E") || !input.toUpperCase().equals("C")) {
			  Scanner reader = new Scanner(System.in);
			  System.out.println("How do you want to enter the client information? (E for EXCEL or C for CONSOLE)");
			  input = reader.nextLine();
			  if (input.toUpperCase().equals("E")) {
					 /* Reading from an Excel file */
				  
				  System.out.println("Enter the Excel fileName you want to read from: ");
				  String excelFileName = reader.nextLine();
				  excelFileName += ".xlsx";
				  // TBD: Implement a loop to enter all client information
				  lastNameInput = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, 1, 0);
				  firstNameInput = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, 1, 1);
				  dobInput = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, 1, 2); // The format should be DD-MM-YYYY
				  
				  ClientDriver client = new ClientDriver();
				  client.launchOACIS();
				  client.searchForClientByLastName(lastNameInput);
				  client.createClient(lastNameInput, firstNameInput, dobInput);
				  reader.close();
				  break;
			  }
			  else if (input.toUpperCase().equals("C")) {
				  	/* Getting inputs from console. */
				  System.out.println("Client Last Name: ");
				  lastNameInput = reader.nextLine();
				  
				  System.out.println("Client First Name: ");
				  firstNameInput = reader.nextLine();
				  
				  System.out.println("Client DOB: ");
				  dobInput = reader.nextLine();
				  
				  ClientDriver client = new ClientDriver();
				  client.searchForClientByLastName(lastNameInput);
				  client.createClient(lastNameInput, firstNameInput, dobInput);
				  reader.close();
				  break;
			  }
		  }
		
	}
}