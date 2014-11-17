import java.io.*;
import java.util.*;

public class ReadTextFile {

	public static void main(String[] args) {
		File file =null;
		FileReader fileReader = null;
		BufferedReader bufferedReader =null;
		PartMasterDOB partsInfo=null;
		ArrayList <PartMasterDOB>partList=new ArrayList<PartMasterDOB>();
		try {
			
			file = new File("D:\\trail\\sampel\\MD001Ot");
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line="";
			while ((line = bufferedReader.readLine()) != null) {
				partsInfo=new PartMasterDOB();
				System.out.println(line);
				partsInfo.setLineNumber(Integer.parseInt(line.substring(0, 1).trim()));
				partsInfo.setWareHouse(line.substring(1,20).trim());
				partsInfo.setGrossWeight(Double.parseDouble(line.substring(20,24).trim()));
				partsInfo.setUnits(line.substring(25,27).trim());
				partsInfo.setNetWeight(Double.parseDouble(line.substring(28,34).trim()));
				partsInfo.setDescription(line.substring(35,46).trim());
			  partList.add(partsInfo);	
			}
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
		}
		System.out.println(partList.size());
		PartMasterDAO dao=new PartMasterDAO();
		try{
			dao.insertPartDetails(partList);			
		}catch(Exception exp){
			exp.printStackTrace();
		}finally{
			
		}

	}
}
