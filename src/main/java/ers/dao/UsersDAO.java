package ers.dao;

import java.sql.SQLException;

import ers.model.ErsUsers;

public interface UsersDAO {
	
	
	public ErsUsers getManager(int id);
	public ErsUsers getEmployee(int id);
	ErsUsers getUserbyUsername(String username) throws Exception;
	ErsUsers getPassByUserName(String username) throws SQLException;
	 void closeResources();

}
