<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <p>
        <span class="input_chk">
            <input type="checkbox" name="box" id="allCheck">
            <label for="allCheck"><span class="chk_all_txt">네이버 이용약관, 개인정보 수집 및 이용, 위치기반서비스 이용약관(선택),<br class='m_br'> 프로모션 정보 수신(선택)에 모두 동의합니다.</span></label>
        </span>
    </p>
    <p>
        <span class="input_chk">
            <input type="checkbox" name="box" id="termsService" class="termsCheck req">
            <label for="termsService">네이버 이용약관 동의<span class="terms_necessary">(필수)</span></label>
        </span>
    </p>
    
    <p>
    	<span class="input_chk">
        	<input type="checkbox" name="box" class="termsCheck req" id="termsService2">
        	<label for="termsService2">개인정보 수집 및 이용 동의<span class="terms_necessary">(필수)</span></label>
    	</span>
    </p>
    <div>
       <input type="checkbox" name="box" class="termsCheck"> 선택1 
    </div>
    <div>
       <input type="checkbox" name="box" class="termsCheck"> 선택2
    </div>
    <form action="join.iu" id="form">
        <p id="errMsg"></p>
        <button type="button" id="btnTerms">확인</button>
    </form>

    <script src="/resources/js/member.js"></script>
    <script>
        termsCheck();
    </script>
</body>
</html> 