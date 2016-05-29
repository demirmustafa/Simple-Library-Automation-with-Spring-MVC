<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="width:100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="height:100%;">

	<div style="width: 100%; height: 900px;">
		<object style="width: 100%; height: 100%;" type="application/pdf"
			data="${pageContext.request.contextPath }/static/pdf/${pdfName}"></object>

	</div>

</body>
