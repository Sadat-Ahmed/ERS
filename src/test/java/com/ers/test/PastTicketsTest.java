package com.ers.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.RMS.ErsReimbursementDAO;

import ers.dao.ReimbursementDAOImpl;
import ers.model.ErsReimbursement;
import ers.utilities.ConnectionFactory;

public class PastTicketsTest {

	@Test
	public void test() {
		List<ErsReimbursement> all = new ArrayList<ErsReimbursement>();
		try{
	
			//all = new ReimbursementDAOImpl(ConnectionFactory.getConnection()).viewAllTickets();
			all = new ReimbursementDAOImpl(ConnectionFactory.getConnection()).viewTicketsById(3);
			for(ErsReimbursement a: all){
				System.out.println(a.toString());
			}
			
			//System.out.println(all.getErsUserId()+u.getErsUsername());
		}catch (Exception e){
			e.printStackTrace();
			
			fail("not impld");
			
			
		}
	}

}
