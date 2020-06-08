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

@WebServlet("/update")
public class updatecontroller extends HttpServlet{
	private MemberDAO memberdao = new MemberDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate dt = LocalDate.parse(req.getParameter("birth"));
		MemberDTO dto = new MemberDTO(req.getParameter("id"),req.getParameter("pw"),req.getParameter("name"),req.getParameter("tel"),
				req.getParameter("addr"),req.getParameter("mail"),dt,req.getParameter("sex"));
		
		int rs = memberdao.update(req.getParameter("ri"),dto);
		PrintWriter out = resp.getWriter();
		if(rs==1){
			out.print("<script>alert('성공적으로 수정되었습니다');window.opener.location.reload(); history.back(); </script>");
		}else{
			out.print("<script>alert('수정이 실패하였습니다');window.opener.location.reload();history.back();  </script>");
		}
	}
}
