function checkEmail(obj, url) {
	//	obj: object
	//	url: ajax api 호출 url
	if (obj.form.email.value.trim().length == 0) {
		alert("이메일을 입력하세요")
		return;
	}
	
	//	Ajax로 url에 중복 이메일 검사
	$.ajax({
		url: url,
		type: "get",
		dataType: 'json',
		data: {
			email: obj.form.email.value
		},
		success: function(response) {
			console.log(response);
			
			if (response.data) {	//	true: 이미 가입한 이메일
				alert("이미 가입된 이메일입니다.")
			} else {	// false: 가입되지 않은 이메일
				alert("가입되지 않은 이메일입니다.")
			}
		},
		error: function(xhr, status, error) {
			console.error(status, ":", error);
		}
	})
}