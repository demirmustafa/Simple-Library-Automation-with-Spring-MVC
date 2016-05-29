<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">


function deneme(i,message){
	//$("#buton_"+i).attr("disabled","disabled");
	document.getElementById("buton_"+i).disabled = true; 
	alert(""+message);
}


</script>
</head>
<body>


<button id="buton_1" type="button" onclick="deneme(1,'durum')"> deneme1</button>
<button id="buton_2"  onclick="deneme(2,'durum2')"> deneme2</button>
<button > deneme3</button>
<button > deneme4</button>
<button > deneme5</button>
<button > deneme6</button>



</body>
</html>