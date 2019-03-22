package admission.model;

//Strategyパターン使用　Contextクラス
public class SelectAdRecContext {
	
	private IAdRecable iAdRecable;
	
	public SelectAdRecContext(IAdRecable iAdRecable) {
		this.iAdRecable = iAdRecable;		
	}
	
	public boolean setAdrecContext() {	
		return iAdRecable.setAdrec();
	}
	
	
}
