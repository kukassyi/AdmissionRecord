package admission.model.guest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import admission.bean.AdmissionData;
import admission.bean.GuestData;
import admission.model.IAdRecable;
import admission.model.dao.AdRecUpdateDao;
import admission.model.dao.GuestDataUpdateDao;

public class AdRecGuestModelimpl implements IAdRecable {

	private GuestData guestData;

	public AdRecGuestModelimpl(GuestData guestData) {
		this.guestData = guestData;
	}

	@Override
	public boolean setAdrec() {

		System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
		// 入場記録を更新
		AdmissionData admissionData = new AdmissionData();
		String nowTime = getNowTime();
		String admissionID = makeId(nowTime);
		
		admissionData.setId(admissionID);
		admissionData.setAdmissionTimestamp(nowTime);
		int getadrec = AdRecUpdateDao.getInstance().insertAdmissionRecord(admissionData);

		guestData.setId(admissionID);
		// ゲストデータを更新
		int getguestrec = GuestDataUpdateDao.getInstance().insertGuestData(guestData);

		// 入場記録かゲストデータのどちらかが更新できなかったらエラー
		if (getadrec * getguestrec == 0) {
			return false;
		}
		return true;
	}

	private String getNowTime() {
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
	}

	private String makeId(String nowTime) {
		nowTime = nowTime.replace("/", "-");
		nowTime = nowTime.replace(":", "-");
		nowTime = nowTime.replace(" ", "-");
		
		String ramdstr = String.valueOf((int)(Math.random() * 10));
		ramdstr = "-" + ramdstr;
		nowTime += ramdstr;
		return nowTime;
	}

}
