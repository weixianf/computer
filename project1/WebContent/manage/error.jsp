<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<html>
<head>
<title>错误提示</title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
</head>
<body background="<%=request.getContextPath() %>/images/bg.jpg">
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0" bgcolor="#EEEEEE">
		<tr>
			<td align="center">
				<table width="500" height="300" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="center"
							background="<%=request.getContextPath() %>/Images/error.jpg">
							&nbsp;&nbsp;错误提示信息： <%=request.getAttribute("errorMsg")%> <br>
							<br> <input name="Submit" type="submit" class="btn_grey"
							value="返回" onClick="history.back(-1)">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<center></center>
</body>
</html>

