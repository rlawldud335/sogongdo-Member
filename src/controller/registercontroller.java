package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.*;

@WebServlet("/register")
public class registercontroller extends HttpServlet{
	private MemberDAO memberdao = new MemberDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate dt = LocalDate.parse(req.getParameter("birth"));
		MemberDTO dto = new MemberDTO(req.getParameter("id"),req.getParameter("pw"),req.getParameter("name"),req.getParameter("tel"),
				req.getParameter("addr"),req.getParameter("mail"),dt,req.getParameter("sex"));
		//ID�ߺ��˻�
		ArrayList<String> ids = memberdao.selectid();
		boolean wq = true;
		for(int i=0; i<ids.size(); i++){
			if(req.getParameter("id").equals(ids.get(i))){
				System.out.print(ids.get(i));
				wq= false;
				break;
			}
		}
		
		if(wq){
			//����ϱ�
			int rs = memberdao.insert(dto);
			PrintWriter out = resp.getWriter();
			
			if(rs==1){
				out.print("<script>alert('���������� ��ϵǾ����ϴ�');window.opener.location.reload();history.back();</script>");
			}else{
				out.print("<script>alert('����� �����Ͽ����ϴ�');window.opener.location.reload();history.back();</script>");
			}
		}else{
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('ID�� �ߺ��˴ϴ�');window.opener.location.reload();history.back();</script>");
		}
		
		
	}
}
