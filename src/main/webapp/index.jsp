<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "demo.URLValidator, demo.URLShortener" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function setFocusToTextBox(){
    var textbox = document.getElementById("url");
    let end = textbox.value.length;
    textbox.setSelectionRange(end,end);
    textbox.focus();
    textbox.scrollIntoView();
}
</script>
</head>

<body onload="setFocusToTextBox()">
<form id= "urlgenerator" name="urlgenerator" method = "post" 
	action="${pageContext.request.contextPath }/urlgenerator"
	>
<input type="url" id="url" name="url" value="${url}" placeholder="Enter URL to generate QR code" oninput="urlgenerator.submit()">
<input type="submit" value="Generate">
<br>
<% if(URLValidator.isValidURL(request.getParameter("url"))) {%>
<img src = "${pageContext.request.contextPath }/qrcode?url=${url}" alt="QR Code" />
<%URLShortener urlShortener = new URLShortener();
	String shortURL = urlShortener.encode(request.getParameter("url"));
%>
<p>Short URL : <%=shortURL %></p>
<%} %>
</form>
</body>

</html>