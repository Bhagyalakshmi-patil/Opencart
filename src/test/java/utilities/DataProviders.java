package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    //DataProvider 1

    @DataProvider(name = "LoginData")
    public String [][] getData() throws IOException{
        String path = ".\\testData\\Opencart_LoginData.xlsx";   //taking xl file from
        ExcelUtility xlutil = new ExcelUtility(path);   //creating an object for xl
        int totalrows = xlutil.getRowCount("Sheet1");    //6
        int totalcols = xlutil.getCellCount("Sheet1",1);  // 3

        String logindata[][] = new String[totalrows][totalcols];
        for(int i = 1; i <= totalrows;i++){
            for(int j = 0; j <  totalcols; j++){
                logindata[i-1][j] = xlutil.getCellData("Sheet1",i,j);
            }
        }
         return logindata;   //returning 2 dimensional array
    }
    //Data Provider 2
    //Data provider 3
}
