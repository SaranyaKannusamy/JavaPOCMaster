package javaConcepts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelObjects.AccountData;


public class JavaFileSystem {
	public static void main(String args[])  {
		try
		{
			Map finalMap=new HashMap<String,List<AccountData>>();
			File file= new File("D://Bank_Data.txt");
			BufferedReader br=null;
			String s1=null;
			
			if(file.exists()){
				FileReader fr=new FileReader(file);
				br= new BufferedReader(fr);
				List<AccountData> listData1=new ArrayList<AccountData>();
				List<AccountData> listData2=new ArrayList<AccountData>();
				List<AccountData> listData3=new ArrayList<AccountData>();
				
					while((s1=br.readLine())!=null)
					{
						String[] data=s1.split(",");
							
						Boolean result=validateData(data);
						System.out.println(result);
						AccountData accountData=new AccountData();
						
						
						if(result)
						{
							accountData.setFirstName(data[0]);
							accountData.setLastName(data[1]);
							accountData.setBranchArea(data[2]);
							accountData.setAge(Integer.parseInt(data[3]));
							accountData.setBankName(data[4]);
							accountData.setAccountType(data[4]);
							if(data[4].equals("HDFC"))
							{
								listData1.add(accountData);
							}
							
							if(data[4].equals("CITI"))
							{
								listData2.add(accountData);
							}
							if(data[4].equals("ICICI"))
							{
								listData3.add(accountData);
							}
						}
						else
						{
							System.out.println("Validation Fails");
						}
						
						
					}
					finalMap.put("HDFC", listData1.toString());
					finalMap.put("CITI", listData2.toString());
					finalMap.put("ICICI", listData3.toString());
					System.out.println("FINAL MAP -----> "+finalMap.toString());
			 }
		}
		catch(IOException exp)
		{
			System.out.println("Ëxception occured"+exp);
		}
		
	}
	
	public static boolean validateData(String[] dataValue)
	{
		boolean result=true;
		if(dataValue[0].isEmpty()||dataValue[1].isEmpty()||dataValue[2].isEmpty()||
				dataValue[3].isEmpty()	||dataValue[4].isEmpty()||dataValue[5].isEmpty())
		{
			System.out.println("All fields are mandatory");
			result=false;
		}
		if(Integer.parseInt(dataValue[3])<19)
		{
			System.out.println("Account Holder Age should not be less than 19");
			result=false;
		}
		
		return result;
	}

}
