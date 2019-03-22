package admission.bean;

public class GuestData {
	private String id;//入場ID
	private String name;//名前
	private String post;//所属
    private String meeting;//面会相手
    private String purpose;//目的
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
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return post
	 */
	public String getPost() {
		return post;
	}
	/**
	 * @param post セットする post
	 */
	public void setPost(String post) {
		this.post = post;
	}
	/**
	 * @return meeting
	 */
	public String getMeeting() {
		return meeting;
	}
	/**
	 * @param meeting セットする meeting
	 */
	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}
	/**
	 * @return purpose
	 */
	public String getPurpose() {
		return purpose;
	}
	/**
	 * @param purpose セットする purpose
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
    

	

}
