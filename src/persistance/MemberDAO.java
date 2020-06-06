package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberDAO {
	private DataSource ds;
	
	public MemberDAO(){
		try{
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	//select
	public ArrayList<MemberDTO> select(){
		Connection conn = null;
		Statement st= null;
		ResultSet rs = null;
		String sql = "SELECT * FROM 按家葛胆.member";
		ArrayList<MemberDTO> members = new ArrayList<MemberDTO>();
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String Member_ID = rs.getString("Member_ID");
				String Member_Password = rs.getString("Member_Password");
				String Member_Name = rs.getString("Member_Name");
				String Member_Phone_Number = rs.getString("Member_Phone_Number");
				String Member_Address = rs.getString("Member_Address");
				String Member_Email = rs.getString("Member_Email");
				LocalDate Member_Birthdate = rs.getDate("Member_Birthdate").toLocalDate();
				String Member_Sex = rs.getString("Member_Sex");
				MemberDTO dto = new MemberDTO(Member_ID,Member_Password,Member_Name,Member_Phone_Number,Member_Address,Member_Email,Member_Birthdate,Member_Sex);
				members.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}
	
	public MemberDTO select(String id){
		Connection conn = null;
		Statement st= null;
		ResultSet rs = null;
		String sql = "SELECT * FROM 按家葛胆.member WHERE Member_ID = '"+id+"'";
		MemberDTO member= null;
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				String Member_ID = rs.getString("Member_ID");
				String Member_Password = rs.getString("Member_Password");
				String Member_Name = rs.getString("Member_Name");
				String Member_Phone_Number = rs.getString("Member_Phone_Number");
				String Member_Address = rs.getString("Member_Address");
				String Member_Email = rs.getString("Member_Email");
				LocalDate Member_Birthdate = rs.getDate("Member_Birthdate").toLocalDate();
				String Member_Sex = rs.getString("Member_Sex");
				member = new MemberDTO(Member_ID,Member_Password,Member_Name,Member_Phone_Number,Member_Address,Member_Email,Member_Birthdate,Member_Sex);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	
	//delete	
	public int delete(String[] id){
		if(id.length <= 0){
			return 0;
		}else{
			Connection conn = null;
			Statement st= null;
			int rs = 0;
			String sql = "DELETE FROM 按家葛胆.member WHERE Member_ID IN (";
			try{
				conn = ds.getConnection();
				st = conn.createStatement();
				for(int i=0; i<id.length; i++){
					sql +="'"+ id[i]+"',";
				}
				sql = sql.substring(0, sql.length()-1);
				sql += ")";
				rs = st.executeUpdate(sql);
			}catch(SQLException e){
				e.printStackTrace();
			}
			return rs;
		}
	}
	
	//update
	public int update(String id,MemberDTO member){
		Connection conn = null;
		PreparedStatement st = null;
		int rs = 0;
		String sql = "UPDATE 按家葛胆.member "
				+ "SET Member_ID=?, Member_Password=?, Member_Name=?,Member_Phone_Number=?,"
				+ "Member_Address=?,Member_Email=?,Member_Birthdate=?,Member_Sex=?"
				+ " WHERE Member_ID = ?";
		try{
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1,member.getMember_ID());
			st.setString(2,member.getMember_Password());
			st.setString(3,member.getMember_Name());
			st.setString(4,member.getMember_Phone_Number());
			st.setString(5,member.getMember_Address());
			st.setString(6,member.getMember_Email());
			st.setDate(7, java.sql.Date.valueOf( member.getMember_Birthdate()));
			st.setString(8,member.getMember_Sex());
			st.setString(9, id);
			rs = st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	//insert
	public int insert(MemberDTO member){
		Connection conn = null;
		PreparedStatement st = null;
		int rs = 0;
		String sql = "INSERT INTO 按家葛胆.member (Member_ID,Member_Password,Member_Name,Member_Phone_Number,Member_Address,Member_Email,Member_Birthdate,Member_Sex)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try{
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1,member.getMember_ID());
			st.setString(2,member.getMember_Password());
			st.setString(3,member.getMember_Name());
			st.setString(4,member.getMember_Phone_Number());
			st.setString(5,member.getMember_Address());
			st.setString(6,member.getMember_Email());
			st.setDate(7, java.sql.Date.valueOf( member.getMember_Birthdate()));
			st.setString(8,member.getMember_Sex());
			rs = st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
}