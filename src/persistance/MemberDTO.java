package persistance;

import java.time.LocalDate;

public class MemberDTO {
	
	private String Member_ID;
	private String Member_Password;
	private String Member_Name;
	private String Member_Phone_Number;
	private String Member_Address;
	private String Member_Email;
	private LocalDate Member_Birthdate;
	private String Member_Sex;
	public MemberDTO(String member_ID, String member_Password, String member_Name, String member_Phone_Number,
			String member_Address, String member_Email, LocalDate member_Birthdate, String member_Sex) {
		super();
		Member_ID = member_ID;
		Member_Password = member_Password;
		Member_Name = member_Name;
		Member_Phone_Number = member_Phone_Number;
		Member_Address = member_Address;
		Member_Email = member_Email;
		Member_Birthdate = member_Birthdate;
		Member_Sex = member_Sex;
	}
	public String getMember_ID() {
		return Member_ID;
	}
	public void setMember_ID(String member_ID) {
		Member_ID = member_ID;
	}
	public String getMember_Password() {
		return Member_Password;
	}
	public void setMember_Password(String member_Password) {
		Member_Password = member_Password;
	}
	public String getMember_Name() {
		return Member_Name;
	}
	public void setMember_Name(String member_Name) {
		Member_Name = member_Name;
	}
	public String getMember_Phone_Number() {
		return Member_Phone_Number;
	}
	public void setMember_Phone_Number(String member_Phone_Number) {
		Member_Phone_Number = member_Phone_Number;
	}
	public String getMember_Address() {
		return Member_Address;
	}
	public void setMember_Address(String member_Address) {
		Member_Address = member_Address;
	}
	public String getMember_Email() {
		return Member_Email;
	}
	public void setMember_Email(String member_Email) {
		Member_Email = member_Email;
	}
	public LocalDate getMember_Birthdate() {
		return Member_Birthdate;
	}
	public void setMember_Birthdate(LocalDate member_Birthdate) {
		Member_Birthdate = member_Birthdate;
	}
	public String getMember_Sex() {
		return Member_Sex;
	}
	public void setMember_Sex(String member_Sex) {
		Member_Sex = member_Sex;
	}
	
	
}