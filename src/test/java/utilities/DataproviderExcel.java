package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataproviderExcel {

	
	
	@DataProvider
	public  String[][] logindata() throws IOException {
		
		ExcelUtility logindata=new ExcelUtility(".//testDATA//Opencart_LoginData.xlsx");	
		int row=logindata.getRowCount("Sheet1");
		int cell=logindata.getCellCount("Sheet1", 1);
		String[][] data=new String[row][cell];
		
		for(int i=1;i<=row;i++)
		{
			for(int j=0;j<cell;j++)
			{
				 data[i-1][j]=logindata.getCellData("Sheet1", i, j);
			}
			
			
			
		}
		
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
