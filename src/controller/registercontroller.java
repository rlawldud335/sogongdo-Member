package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

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
		
		int rs = memberdao.insert(dto);
		PrintWriter out = resp.getWriter();
		
		if(rs==1){
			out.print("<script>alert('���������� ��ϵǾ����ϴ�');window.opener.location.reload(); window.close(); </script>");
		}else{
			out.print("<script>alert('����� �����Ͽ����ϴ�');window.opener.location.reload(); window.close(); </script>");
		}
	}
}
