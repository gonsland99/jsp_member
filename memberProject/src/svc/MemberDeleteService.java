package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.MemberDAO;

public class MemberDeleteService {

	public boolean deleteMember(String deleteId) {
		boolean deleteResult = false;
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		int deleteCount = memberDAO.deleteMember(deleteId);
		if(deleteCount > 0){
			commit(conn);
			deleteResult = true;
		}else{
			rollback(conn);
		}
		close(conn);
		return deleteResult;
	}

}
