<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
p{
	color:blue;
	font-size:10px;
	margin-bottom:0px;
	#margin-left:40px;
	
}


</style>

<title>入場者情報入力</title>
</head>
<body>
	<h5>入場者記録</h5>
	<p>入場者名</p>
	<form method="POST" action="../AdController">
	<input type ="text" id="adName" name="adName" placeholder="必須"/>
	
	<p>所属</p>
	<input type ="text" id="adPost" name="adPost"  placeholder="必須"/>
	
	<br><br><br>

		<button>結果表示</button>
	</form>


</body>
</html>