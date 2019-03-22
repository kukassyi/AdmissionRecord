package admission.model.dao;

import java.sql.SQLException;
import java.sql.Statement;

import admission.bean.AdmissionData;


public class AdRecUpdateDao extends AdRecDaoBase {
	private static String sql;
	private static AdRecUpdateDao adRecUpdateDaoInstance;
	//シングルトンを使用
	private AdRecUpdateDao() {	
		adRecUpdateDaoInstance = null;
	}
	
	public static AdRecUpdateDao getInstance() {
		if(adRecUpdateDaoInstance==null) {
			adRecUpdateDaoInstance = new AdRecUpdateDao();
			
		}
		return adRecUpdateDaoInstance;
	}
	
	
	//入場記録更新処理
	public int insertAdmissionRecord(AdmissionData admissionData) {
			String sql = "INSERT INTO ADSYS_ADMISSION_RECORD"
					+ "(ADMISSION_ID,ADMISSION_DATE) "
					+ "VALUES"
					+ " ('" + admissionData.getId() + "', '" + admissionData.getAdmissionTimestamp() +"')";
			
			AdRecUpdateDao.sql = sql;
			int retsql =0;
			retsql = connDB();
			
		return retsql;
	}
	
	protected int excecSQL(Statement stmt){
    	int retsql = 0;
		try {
			retsql = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return retsql;
}

}
