<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보 수정</title>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function checkPasswd(password) {
		var elemSpanCheckPasswdResult = document
				.getElementById("checkPasswdResult");

		// 패스워드 검사 패턴 설정
		// 1. 길이 및 사용 가능 문자에 대한 규칙 : 8 ~ 16 자리 영문자, 숫자, 특수문자(!@#$%) 조합
		var lengthRegex = /^[A-Za-z0-9!@#$%]{8,16}$/;

		// 각 문자 형식이 포함되는지 여부를 각각 체크하기 위한 패턴 설정
		// => 주의! 부분 패턴 검사이므로 시작(^) 과 끝($)은 사용하면 안된다!
		// 2. 영문 대문자 규칙
		var engUpperRegex = /[A-Z]/;
		// 3. 영문 소문자 규칙
		var engLowerRegex = /[a-z]/;
		// 4. 숫자 규칙
		var numRegex = /[0-9]/;
		// 5. 특수문자 규칙
		var specRegex = /[!@#$%]/;

		if (lengthRegex.exec(password)) {
			var count = 0; // 검증 결과를 포인트화 할 변수 선언

			if (engUpperRegex.exec(password)) { // 대문자 검사
				count++;
			}

			// 주의! 각 조건마다 별도로 검사하므로 else if 가 아닌 각각 단일 if 문 사용
			if (engLowerRegex.exec(password)) { // 소문자 검사
				count++;
			}

			if (numRegex.exec(password)) { // 숫자 검사
				count++;
			}

			if (specRegex.exec(password)) { // 특수문자(!@#$%) 검사
				count++;
			}

			// 패턴 카운팅 결과를 사용하여 복잡도 판별 결과 출력
			if (count == 4) {
				elemSpanCheckPasswdResult.innerHTML = "사용 가능 : 안전";
				elemSpanCheckPasswdResult.style.color = "GREEN";
			} else if (count == 3) {
				elemSpanCheckPasswdResult.innerHTML = "사용 가능 : 보통";
				elemSpanCheckPasswdResult.style.color = "YELLOW";
			} else if (count == 2) {
				elemSpanCheckPasswdResult.innerHTML = "사용 가능 : 위험";
				elemSpanCheckPasswdResult.style.color = "ORANGE";
			} else {
				elemSpanCheckPasswdResult.innerHTML = "영문자, 숫자, 특수문자 중 2가지 이상 조합 필수!";
				elemSpanCheckPasswdResult.style.color = "RED";
			}

		} else { // 패스워드 길이 또는 사용 가능 문자 체크 부적합 시
			elemSpanCheckPasswdResult.innerHTML = "8~16자리 영문자, 숫자, 특수문자 조합 필수!";
			elemSpanCheckPasswdResult.style.color = "RED";
		}

	}
	function checkConfirmPasswd() {
		// 결과를 표시할 span 태그 영역 객체 가져오기
		let confirmPasswdResult = document
				.getElementById("confirmPasswdResult");

		// 입력된 두 패스워드 가져오기
		let passwd = document.fr.passwd.value;
		let passwd2 = document.fr.passwd2.value;

		// 두 패스워드 비교
		if (passwd == passwd2) {
			confirmPasswdResult.innerHTML = "비밀번호 일치";
			confirmPasswdResult.style.color = "GREEN";
		} else {
			confirmPasswdResult.innerHTML = "비밀번호 불일치";
			confirmPasswdResult.style.color = "RED";
		}
	}
	//다음 우편번호 API
	function execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample4_postcode').value = data.zonecode;
						document.getElementById("sample4_roadAddress").value = roadAddr;
						//             document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
					}

				}).open();
	}
</script>
</head>
<body>
	<h2>내정보 수정</h2>
	<form action="../UserUpdateFrom.me" method="post">
		<table>
			<tr>
				<td><p>아이디</p></td>
				<td><input type="text" name="id" value="${param.user_id}"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td><p>이름</p></td>
				<td><input type="text" name="name" value="${param.user_name}"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td><p>비밀번호수정</p></td>
				<td><input type="password" name="passwd"
					onchange="checkPasswd(this.value)"><br> <span
					id="checkPasswdResult">
						<!-- 패스워드 검증 결과 표시할 위치 -->
				</span></td>
			</tr>

			<tr>
				<td>
					<p>비밀번호재확인</p>
				</td>
				<td><input type="password" name="passwd2"
					onkeyup="checkConfirmPasswd()"><br> <span
					id="confirmPasswdResult">
						<!-- 일치여부 판별 -->
				</span></td>
			</tr>

			<tr>
				<td><p>현재전화번호</p></td>
				<td><input type="text" name="phone" value="${param.user_phone}"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td><p>전화번호수정</p></td>
				<td><input type="text" name="phone"></td>
			</tr>

			<tr>
				<td><p>현재주소</p></td>
				<td><textarea rows="6" cols="48" readonly="readonly">
     				${param.address}
   						</textarea></td>
			</tr>

			<tr>
				<td><p>주소수정</p></td>
				<td><input type="text" id="sample4_postcode" name="post_code"
					placeholder="우편번호" required="required" readonly="readonly"
					onclick="execDaumPostcode()"> <input type="button"
					onclick="execDaumPostcode()" value="우편번호 찾기"><br> <input
					type="text" id="sample4_roadAddress" name="address1"
					placeholder="도로명주소" required="required" readonly="readonly"
					onclick="execDaumPostcode()"> <input type="text"
					id="sample4_detailAddress" name="address2" placeholder="상세주소"
					required="required"></td>
			</tr>

			<tr>
				<td><p>이메일</p></td>
				<td><input type="text" name="email" value="${param.email }"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td><p>이메일수정</p></td>
				<td><input type="text" name="email" value=""></td>
			</tr>

			<tr>
				<td><input type="submit" value="수정하기"
					onclick="loction.href='UserUpdateView.me'"> <input type="reset"
					value="다시입력"> <input type="button" value="마이페이지"
					onclick="location.href='MypageAction.me'"></td>
			</tr>
		</table>
	</form>
</body>
</html>