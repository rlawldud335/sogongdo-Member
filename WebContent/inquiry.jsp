<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="persistance.*" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>관리자/직원 용 - 회원정보관리</title>
	<style>
	
body{
    margin: 0;
    padding: 0;
}

.hd{
    position: fixed;
    top: 2.375rem;
    width : 100%;
    height : 5.375rem;
    background-color: #CEF279;
}

.title{
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    color: #476600;
    font-size: 1.5em;
    font-weight: bold;
}

.bd{
    position: fixed;
    top: 8rem;
    width: 100%;
}

.subtitle{
    text-align: center;
    background-color: #FAF4C0;
}

.content{
    width: 100%;
    height: 30rem;
}

table {
    position: relative;
    left: 50%;
    transform: translateX(-50%);
    margin: 10px 5px;
    border-collapse: collapse;
    width: 70%;
    display:block;
    height:450px;
    overflow:auto;
}

th, td {
    padding: 8px;
    text-align: center;
    border-bottom: 1px solid #ddd;
    border: 1px solid #ddd;
}

thead th{
    background-color: #E4F7BA;
}

th.a, th.i {
    width: 5%;
}

th.b, th.c, th.h{
    width: 10%;
}

th.d{
    width: 8%;
}
th.e{
    width: 10%;
}
th.g{
    width: 15%;
}

th.f{
    width: 27%;
}
tbody tr:hover {background-color:#f5f5f5;}

.bt{
    position: relative;
    left: 52%;
    border-radius: 12px;
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
</head>
<body>
    <div class="hd">
        <h class="title"> 관리자/직원 용 - 회원정보관리</h>
    </div>
	<div class="bd">
        <h3 class="subtitle"> 현재 등록된 회원 정보 조회</h3>

        <div class="content">
            <table>
                <thead>
                    <tr>
                        <th class="a"> </th>
                        <th class="b">ID</th>
                        <th class="c">Password</th>
                        <th class="d">이름</th>
                        <th class="e">전화번호</th>
                        <th class="f">주소</th>
                        <th class="g">이메일</th>
                        <th class="h">생년월일</th>
                        <th class="i">성별</th>
                    </tr>
                </thead>
                <tbody>
					<%
					List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("member");
					for (MemberDTO dto : list) {
						pageContext.setAttribute("dto", dto);	
					%>
					 <tr>
                       	<td><input class="ch" type="checkbox"></td>
                       	<td class="id"><%= dto.getMember_ID() %></td>
                       	<td><%= dto.getMember_Password() %></td>
                       	<td><%= dto.getMember_Name() %></td>
                       	<td><%= dto.getMember_Phone_Number() %></td>
                        <td><%= dto.getMember_Address() %></td>
                        <td><%= dto.getMember_Email() %></td>
                        <td><%= dto.getMember_Birthdate() %></td>
                        <td><%= dto.getMember_Sex() %></td>
                    </tr>
					<%}%>
                </tbody>
            </table>
            <button class="bt register">회원정보 등록하기</button>
            <button class="bt delete">회원정보 삭제하기</button>
            <button class="bt update">회원정보 수정하기</button>
        </div>
    </div>
	<script>
	window.addEventListener("load",function(){
		
		const registerbtn = document.querySelector(".register");
		const deletebtn = document.querySelector(".delete");
		const updatebtn = document.querySelector(".update");
		const chbox = document.querySelectorAll(".ch");
		const id = document.querySelectorAll(".id");
		
		registerbtn.addEventListener("click",()=>{
			//새로운 창 뜨도록 하기
			window.open("register.jsp","새로운 회원 등록","width=500, height=400, left=300, top=300");
		})
		
		deletebtn.addEventListener("click",()=>{
			//체크박스에 체크한 id가져오기
			var ids = new Array();
			for(var i=0; i<chbox.length; i++){
				if(chbox[i].checked==true){
					ids.push(id[i].innerText);
				}
			}
			if(ids.length==0){
				alert('체크해주세요');
			}else{
				
				//삭제컨트롤러에 전송~!
				var ox = confirm("회원 정보를 정말 삭제하시겠습니까?");
				if(ox){
					var url = "delete?";
					url += "cnt="+ids.length+"&";
					for(var i=0;i<ids.length;i++){
						url += "id"+i+"="+ids[i]+"&"
					}
					window.location.href = url;
				}
			}
		})
		
		updatebtn.addEventListener("click",()=>{
			// 새로운 창 뜨도록 하기
			var cnt = 0;
			var up;
			for(var i=0; i<chbox.length; i++){
				if(chbox[i].checked==true){
					cnt++;
					up = id[i].innerText;
				}
			}
			if(cnt==0){
				alert('하나를 체크해주세요');
			}
			else if(cnt==1){
				window.open("updateview?id="+up,"회원 정보 수정","width=500, height=400, left=300, top=300");
			}else{
				alert('하나만 체크해주세요');
			}
		})
		
	})
	</script>
</body>
</html>