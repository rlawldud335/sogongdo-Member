<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="persistance.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원 정보 변경하기</title>
    <style>
    	legend{
            font-weight: bold;
        }
        fieldset{
            border: 1px;
            border-color: green;
            border-style: groove;
            border-image: initial;
            background-color: #FAF4C0;
        }
        #man{
            margin-left: 35px;
        }
        .register ,.reset{
            margin : 10px;
        }
        #address{
            margin-left: 33px;
        }
        #user_name{
            margin-left: 32px;
        }
        #user_id{
            margin-left: 15px;
        }
    </style>
</head>
<body>
    <h2>회원 정보 변경하기</h2>

	<% 
		MemberDTO dto = (MemberDTO)request.getAttribute("dto");
		pageContext.setAttribute("dto", dto);
		String ri = dto.getMember_ID();
	%>
    <form action="update">
        <fieldset>
            <legend>로그인 정보</legend>
            <div>
                <label for="user_id">수정 전 아이디</label>
                <input name="ri" type="text" id="user_ri"  value='<%= ri %>' readonly>
            </div>
            <div>
                <label for="user_id">아이디</label>
                <input name="id" type="text" id="user_id"  value='<%= dto.getMember_ID() %>' required>
            </div>
            <div>
                <label for="user_pw">비밀번호</label>
                <input name="pw" type="password" id="user_pw" value='<%= dto.getMember_Password() %>' required>
            </div>
        </fieldset>

        <fieldset>
            <legend>개인정보</legend>
            <div>
                <label for="user_name">이름</label>
                <input name="name" type="text" id="user_name" value='<%= dto.getMember_Name() %>' required>
            </div>
            <div>
                <label for="tel">전화번호</label>
                <input name="tel" type="tel" id="tel" value='<%= dto.getMember_Phone_Number() %>' required>
            </div>
            <div>
                <label for="address">주소</label>
                <input name="addr" type="text" id ="address" value='<%= dto.getMember_Address() %>' required>
            </div>
            <div>
                <label for="email">메일주소</label>
                <input name="mail" type="email" id="email" value='<%= dto.getMember_Email() %>' required>
            </div>
            <div>
                <label for="birth">생년월일</label>
                <input name="birth" type="date" id="birth" value='<%= dto.getMember_Birthdate() %>'required>
            </div>
            <div>
            <label>성별</label>
            <% String s = (String) dto.getMember_Sex();
            	if(s.equals("남")){
           	%>
                <input type="radio" name="sex" value="남" id="man" <%out.print("checked=\"checked\"");%>><label for="man">남</label>
                <input type="radio" name="sex" value="여" id="woman"><label for="woman">여</label>
                <%} else{%>
                <input type="radio" name="sex" value="남" id="man"><label for="man">남</label>
                <input type="radio" name="sex" value="여" id="woman" <%out.print("checked=\"checked\"");%>><label for="woman">여</label>
                <%} %>
            </div>
        </fieldset>
        <input type="submit" value="수정하기" class="register">
    </form>
</body>
</html>