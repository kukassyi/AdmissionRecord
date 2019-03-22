package admission.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public  abstract class AdRecDaoBase {
	
	protected int connDB() {
		//接続設定
		Connection conn = null;
		Statement stmt = null;
		int retvalue= 0;
		// JDBCと接続する
		try {
			// postgresSQLとJDBCとの接続
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// JDBCとの接続エラー
			e.printStackTrace();
		}
		try {
			// 接続する
			conn = (Connection) DriverManager.getConnection("jdbc:postgresql:postgres", // �f�[�^�x�[�X��
					"postgres", // Id
					"admin" // パスワード
			);

			// Statementを取得
			 stmt = ((java.sql.Connection) conn).createStatement();
			
			 retvalue = excecSQL(stmt);
//			String sql ="UPDATE ENV_VALUE SET SERVER_IP = '" + myServerIPadd + 
//					    "', SERVER_PORT = '" + myServerPorttring + "', RASPI_IP = '" + rasPiIPadd + 
//					    "', RASPI_PORT = '" + rasPiPort + "' where ID = 1 ";
//			 retsql = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// �ڑ��ASELECT���ŃG���[�����������ꍇ
			e.printStackTrace();
		} finally {
			// �f�[�^�x�[�X�ڑ��̐ؒf
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e) {
					// �f�[�^�x�[�X�̐ؒf�ŃG���[�����������ꍇ
					e.printStackTrace();
				}
			}
		}
		return retvalue;
	}
	
	protected abstract int excecSQL(Statement stmt);
}
