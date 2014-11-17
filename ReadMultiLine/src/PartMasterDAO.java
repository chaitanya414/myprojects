import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;


public class PartMasterDAO {

	public void insertPartDetails(ArrayList<PartMasterDOB> partDetails)throws Exception{
		PartMasterDOB partinfo=null;
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chaitu","chaitu");
		con.setAutoCommit(false);
		System.out.println("autocommit set to false");
		PreparedStatement pstmt= con.prepareStatement("insert into trail(id,warehouse,linenumber,grosweight,units,netweight,description) values (?,?,?,?,?,?,?)");
		if(partDetails!=null){
			if(partDetails.size()>0){
				int lines=partDetails.size();
				System.out.println(lines);
				for(int i=0;i<lines;i++){
					partinfo=(PartMasterDOB)partDetails.get(i);
					pstmt.setLong(1,i);
					pstmt.setString(2,partinfo.getWareHouse());
					pstmt.setLong(3,partinfo.getLineNumber());
					pstmt.setDouble(4, partinfo.getGrossWeight());
					pstmt.setString(5,partinfo.getUnits());
					pstmt.setDouble(6,partinfo.getNetWeight());
					pstmt.setString(7,partinfo.getDescription());
				  pstmt.addBatch();	
				}
			}
		  pstmt.executeBatch();	
		 con.commit();
		}
	}
}
