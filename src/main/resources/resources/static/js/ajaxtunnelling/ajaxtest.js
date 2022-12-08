// index 라는 객체를 생성한다.
// 객체명은 index 이다.
// 함수는 init, save가 있다.
// jsp에서 나오는 객체 id를 받아서 사용한다.
let index = {

	init: function() {
		$("#btn-save").on("click", () => { // function(){} , ()=>{} this를 바인딩하기 위해서!! 
			this.save();
		});
	},


	save: function() {
		// alert('user의 save함수 호출됨');
		// data object 생성한다.
		let data = {
			// username은 label for="username">Username</label> <input type="text" class="form-control" placeholder="Enter username" id="username"> id 값을 말한다.
			username: $("#username").val(),
			password: $("#password").val()
		};

		let dto = {
			v1: "aaaa",
			v2: "bbbb"
		};

		console.log(data);

		dto: JSON.stringify(dto)
		console.log(dto);

		// ajax 는 기본이 비동기 호출이다.

		$.ajax({
		}).done(function() {


		}).fail(function() {

		});


		// ajax호출시 default가 비동기 호출
		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해주네요.
		// ajaax().done().fail()
		$.ajax({
			type: "POST",
			url: "/ajaxtunnelling/welcome",
			data: JSON.stringify(data), // http body데이터
			contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
		}).done(function(resp) {
			if (resp.status === 500) {
				alert("실패하였습니다.");
			} else {
				alert("완료되었습니다.");
				location.href = "/";
			}

		}).fail(function(error) {
			alert('1=============================');
			alert(JSON.stringify(error));
			alert('=============================3');
		});

	},

}

// 최초에 실행된다.
index.init();
