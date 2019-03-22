package admission.model.dao;

import java.sql.SQLException;
import java.sql.Statement;

import admission.bean.GuestData;


public class GuestDataUpdateDao extends AdRecDaoBase {
	private static GuestDataUpdateDao guestDataUpdateDao;
	private static String sql;
	//シングルトンを使用
	private GuestDataUpdateDao() {	
		guestDataUpdateDao = null;
	}
	
	public static GuestDataUpdateDao getInstance() {
		if(guestDataUpdateDao==null) {
			guestDataUpdateDao = new GuestDataUpdateDao();
		}
		return guestDataUpdateDao;
	}
	//ゲストデータ追加処理
	public int insertGuestData(GuestData guestData) {
			String sql = "INSERT INTO ADSYS_GUEST_DATA"
					+ "(ADMISSION_ID,GUEST_NAME,GUEST_POST,GUEST_TO_MEETING,GUEST_TO_PURPOSE) "
					+ "VALUES"
					+ " ('" + guestData.getId() + "', '" + guestData.getName() + "', '" + guestData.getPost()+ "', '" + 
					              guestData.getMeeting() + "', '" + guestData.getPurpose()+"')";
			
			GuestDataUpdateDao.sql = sql;
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
