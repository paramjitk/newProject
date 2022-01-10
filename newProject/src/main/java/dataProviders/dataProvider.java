package dataProviders;

import org.testng.annotations.DataProvider;

import utilityComponents.excelLibrary;

public class dataProvider {
	excelLibrary obj = new excelLibrary();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider(name = "Sheet1")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet1");
			// Total Columns
			int column = obj.getColumnCount("Sheet1");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet1", j, i + 2);
				}
			}
			return data;
		}
		//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
		@DataProvider(name = "Sheet2")
		public Object[][] getEmail() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet2");
			// Total Columns
			int column = obj.getColumnCount("Sheet2");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet2", j, i + 2);
				}
			}
			return data;
		}
}
