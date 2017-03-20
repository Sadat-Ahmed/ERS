package ers.model;

import java.sql.Date;

public class ErsReimbursement {
	
	//variables do not need to match database columns
		private int reimbId;
		private double reimbAmount;
		private Date reimbSubmitted;
		private Date reimbResolved;
		private String description;
		//private byte reimbReceipt;
		private ErsUsers reimbAuthor;
		private ErsUsers reimbResolver;
		private ReimbursementStatus reimbStatusId;
		private ReimbursementType reimbType;
		
		
		@Override
		public String toString() {
			return "ErsReimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
					+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", description=" + description
					+ ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatusId="
					+ reimbStatusId + ", reimbType=" + reimbType + "]";
		}
		public int getReimbId() {
			return reimbId;
		}
		public void setReimbId(int reimbId) {
			this.reimbId = reimbId;
		}
		
		public double getReimbAmount() {
			return reimbAmount;
		}
		public void setReimbAmount(double amount) {
			this.reimbAmount = amount;
		}
		public Date getReimbSubmitted() {
			return reimbSubmitted;
		}
		public void setReimbSubmitted(Date reimbSubmitted) {
			this.reimbSubmitted = reimbSubmitted;
		}
		public Date getReimbResolved() {
			return reimbResolved;
		}
		public void setReimbResolved(Date reimbResolved) {
			this.reimbResolved = reimbResolved;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
//		public byte getReimbReceipt() {
//			return reimbReceipt;
//		}
//		public void setReimbReceipt(byte reimbReceipt) {
//			this.reimbReceipt = reimbReceipt;
//		}
		public ErsUsers getReimbAuthor() {
			return reimbAuthor;
		}
		public void setReimbAuthor(ErsUsers reimbAuthor) {
			this.reimbAuthor = reimbAuthor;
		}
		public ErsUsers getReimbResolver() {
			return reimbResolver;
		}
		public void setReimbResolver(ErsUsers reimbResolver) {
			this.reimbResolver = reimbResolver;
		}
		public ReimbursementStatus getReimbStatusId() {
			return reimbStatusId;
		}
		public void setReimbStatusId(ReimbursementStatus reimbStatusId) {
			this.reimbStatusId = reimbStatusId;
		}
		public ReimbursementType getReimbType() {
			return reimbType;
		}
		public void setReimbType(ReimbursementType reimbType) {
			this.reimbType = reimbType;
		}
//		public ErsReimbursement(int reimbId, double reimbAmount, Date reimbSubmitted, Date reimbResolved,
//				String description,  int i, int j, int k,
//				int l) {    //maybe  insert byte reimbReceipt after String Description and before riembAuthor.
//			super();
//			this.reimbId = reimbId;
//			this.reimbAmount = reimbAmount;
//			this.reimbSubmitted = reimbSubmitted;
//			this.reimbResolved = reimbResolved;
//			this.description = description;
//			//this.reimbReceipt = reimbReceipt;
//			this.reimbAuthor = i;
//			this.reimbResolver = j;
//			this.reimbStatusId = k;
//			this.reimbType = l;
		
		
		
//		}
		
		
		
		
		
		public ErsReimbursement() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ErsReimbursement(int reimbId, double reimbAmount, Date reimbSubmitted, Date reimbResolved,
				String description, ErsUsers reimbAuthor, ErsUsers reimbResolver, ReimbursementStatus reimbStatusId,
				ReimbursementType reimbType) {
			super();
			this.reimbId = reimbId;
			this.reimbAmount = reimbAmount;
			this.reimbSubmitted = reimbSubmitted;
			this.reimbResolved = reimbResolved;
			this.description = description;
			this.reimbAuthor = reimbAuthor;
			this.reimbResolver = reimbResolver;
			this.reimbStatusId = reimbStatusId;
			this.reimbType = reimbType;
		}
		public ErsReimbursement(int i, int j, String string, ErsUsers k, ReimbursementType l) {
			this.reimbId = i;
			this.reimbAmount = j;
			this.description = string;
			this.reimbAuthor = k;
			this.reimbType = l;
		}
		
		
		
		
}
