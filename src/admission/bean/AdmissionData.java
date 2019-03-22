package admission.bean;

public class AdmissionData {
	private String id;//入場時ID
	private String admissionTimestamp;//入場時間
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return admissionDate
	 */
	public String getAdmissionTimestamp() {
		return admissionTimestamp;
	}
	/**
	 * @param admissionDate セットする admissionDate
	 */
	public void setAdmissionTimestamp(String admissionTimestamp) {
		this.admissionTimestamp = admissionTimestamp;
	}

}
