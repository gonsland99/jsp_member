package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberViewService {

	public MemberBean getMember(String viewId) {
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		MemberBean member = memberDAO.selectMember(viewId);
		close(conn);
		return member;
	}

}
