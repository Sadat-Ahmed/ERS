package ers.model;

public class ReimbursementType {

	private int reimbTypeId;
	private String reimbType;
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	public String getReimbType() {
		return reimbType;
	}
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	public ReimbursementType(int reimbTypeId, String reimbType) {
		super();
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
	}
	
	
	
	public ReimbursementType() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReimbursementType [reimbTypeId=" + reimbTypeId + ", reimbType=" + reimbType + "]";
	}
	
	
	
	
}
