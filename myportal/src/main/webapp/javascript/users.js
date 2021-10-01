function checkEmail(obj, url) {
	//	obj: object
	//	url: ajax api 호출 url
	if (obj.form.email.value.trim().length == 0) {
		alert("이메일을 입력하세요")
		return;
	}
	
	//	TODO: Ajax로 url에 중복 이메일 검사
}