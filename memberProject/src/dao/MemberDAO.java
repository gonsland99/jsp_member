package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.MemberBean;

public class MemberDAO {
	private static MemberDAO memberDAO;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private MemberDAO() {
	}
	public static MemberDAO getInstance() {
		if(memberDAO == null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int insertMember(MemberBean member) {
		String sql = "insert into members values (?,?,?,?,?,?)";
		int insertCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pw());
			pstmt.setString(3, member.getMember_name());
			pstmt.setInt(4, member.getMember_age());
			pstmt.setString(5, member.getMember_gender());
			pstmt.setString(6, member.getMember_email());
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
	public String selectLoginId(MemberBean member) {
		String loginId = null;
		String sql="select member_id from members where member_id=? and member_pw=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("member_id");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}
	public ArrayList<MemberBean> selectMemberList() {
		String sql="select * from members";
		ArrayList<MemberBean> memberList=new ArrayList<MemberBean>();
		MemberBean mb = null;
		try{
			
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				do {
				mb=new MemberBean();
				mb.setMember_id(rs.getString("member_id"));
				mb.setMember_pw(rs.getString("member_pw"));
				mb.setMember_name(rs.getString("member_name"));
				mb.setMember_age(rs.getInt("member_age"));
				mb.setMember_gender(rs.getString("member_gender"));
				mb.setMember_email(rs.getString("member_email"));
				memberList.add(mb);
				} while(rs.next());
			}
		}catch(Exception e){
			System.out.println("getDeatilMember 에러: " + e);			
		}finally{
			close(rs);
			close(pstmt);
		}
		return memberList;
	}
	public MemberBean selectMember(String viewId) {
		String sql="select * from members where member_id=?";
		MemberBean mb = null;
		try{
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, viewId);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				mb=new MemberBean();
				mb.setMember_id(rs.getString("member_id"));
				mb.setMember_pw(rs.getString("member_pw"));
				mb.setMember_name(rs.getString("member_name"));
				mb.setMember_age(rs.getInt("member_age"));
				mb.setMember_gender(rs.getString("member_gender"));
				mb.setMember_email(rs.getString("member_email"));
			}
		}catch(Exception e){
			System.out.println("getDeatilMember 에러: " + e);			
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return mb;
	}
	public int deleteMember(String deleteId) {
		String sql="delete from members where member_id=?";
		int deleteCount = 0;

		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, deleteId);
			deleteCount = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("deleteMember 에러: " + e);	
		}finally{
			close(pstmt);
		}
		
		return deleteCount;
	}
}
