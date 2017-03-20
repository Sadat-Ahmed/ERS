package com.ers.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.revature.RMS.ErsReimbursementDAO;

import ers.dao.ReimbursementDAOImpl;
import ers.model.ErsReimbursement;
import ers.model.ErsUsers;
import ers.model.ReimbursementType;
import ers.utilities.ConnectionFactory;
import utils.system;

public class InsertTest {

	@Test
	public void insert(){
		ErsReimbursement rim=null;
		//rim = new ErsReimbursement(1, 3, rim.getReimbSubmitted(), rim.getReimbResolved(), "wow", rim.setReimbAuthor(new ErsUsers().getErsUserId()), rim.getReimbResolver(), rim.getReimbStatusId(), rim.getReimbType());
			//ErsReimbursement c = new ErsReimbursement();
			//ErsReimbursement r = new ErsReimbursement(1, 3, "test", new ErsUsers(rim.getReimbAuthor()),new ReimbursementType() );
			try{
			//	new ReimbursementDAOImpl(ConnectionFactory.getConnection()).submitRequest(r);
				
			} catch (Exception e) {
				e.printStackTrace();
				org.junit.Assert.fail();
			}
		}

}
