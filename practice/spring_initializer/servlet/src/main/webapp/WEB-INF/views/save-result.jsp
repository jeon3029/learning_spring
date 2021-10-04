<%--<%@ page import="hello.servlet.domain.member.Member" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
  <li>
<%--    id = <%=((Member)request.getAttribute("member")).getId()%>--%>
    id=${member.id}
  </li>
  <li>
<%--    username = <%=((Member)request.getAttribute("member")).getUsername()%>--%>
    username = ${member.username}
  </li>
  <li>
<%--    age = <%=((Member)request.getAttribute("member")).getAge()%>--%>
    age = ${member.age}
  </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
