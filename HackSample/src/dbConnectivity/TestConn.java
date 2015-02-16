package dbConnectivity;

import java.sql.ResultSet;

public class TestConn {
	public static void main(String [] args){
		MysqlDbConn checkConn = new MysqlDbConn();
		ResultSet rs = null;
		try{
			checkConn.setConnection();
			System.out.println("READ DB:");
			rs = checkConn.readDB("RandomValues");
			if(null!=rs)checkConn.writeResultSet(rs);
			System.out.println("INSERT DB:");
			String[] insdata = new String[5];
			insdata[0] = "NULL";
			insdata[1] = "\"poivot\"";
			insdata[2] = "\"dgh\"";
			insdata[3] = "\"e\"";
			insdata[4] = "'2014-02-02'";

			/*checkConn.insertDB("RandomValues", insdata);
			rs = checkConn.readDB("RandomValues");
			if(null!=rs)checkConn.writeResultSet(rs);*/

			System.out.println("UPDATE DB:");
			String[] upddata = new String[4];
			upddata[0] = "\"poivot\"";
			upddata[1] = "\"dgh\"";
			upddata[2] = "\"e\"";
			upddata[3] = "'2014-02-02'";

			if(true == checkConn.updateDB("RandomValues", upddata, "2"))
				System.out.println("UPDATE SUCCESS");
			rs = checkConn.readDB("RandomValues");
			if(null!=rs)checkConn.writeResultSet(rs);

			System.out.println("DELETE DATA IN DB:");
			if(true == checkConn.removeDataDB("RandomValues", "2"))
				System.out.println("DELETE SUCCESS");
			rs = checkConn.readDB("RandomValues");
			if(null!=rs)checkConn.writeResultSet(rs);

			System.out.println("METEDATA DB:");
			checkConn.writeMetaData();
			checkConn.close();
		}catch(Exception e){
			System.out.println("exc:"+e.getMessage()+ e.getStackTrace());
		}

	}
}
