<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>새로운 회원 등록</title>
    <style>
    	legend{
            font-weight: bold;
        }
        fieldset{
            border: 1px;
            border-color: green;
            border-style: groove;
            border-image: initial;
            background-color: #E4F7BA;
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
    <h2>새로운 회원 등록</h2>

    <form action="register">
        <fieldset>
            <legend>로그인 정보</legend>
            <div>
                <label for="user_id">아이디</label>
                <input name="id" type="text" id="user_id" required>
            </div>
            <div>
                <label for="user_pw">비밀번호</label>
                <input name="pw" type="password" id="user_pw"required>
            </div>
        </fieldset>

        <fieldset>
            <legend>개인정보</legend>
            <div>
                <label for="user_name">이름</label>
                <input name="name" type="text" id="user_name"required>
            </div>
            <div>
                <label for="tel">전화번호</label>
                <input name="tel" type="tel" id="tel"required>
            </div>
            <div>
                <label for="address">주소</label>
                <input name="addr" type="text" id ="address"required>
            </div>
            <div>
                <label for="email">메일주소</label>
                <input name="mail" type="email" id="email"required>
            </div>
            <div>
                <label for="birth">생년월일</label>
                <input name="birth" type="date" id="birth"required>
            </div>
            <div>
                <label>성별</label>
                <input type="radio" name="sex" value="남" id="man" checked="checked"><label for="man">남</label>
                <input type="radio" name="sex" value="여" id="woman"><label for="woman">여</label>
            </div>
        </fieldset>
        <input type="submit" value="회원가입" class="register">
        <input type="reset" value="입력취소" class="reset">
    </form>
</body>
</html>