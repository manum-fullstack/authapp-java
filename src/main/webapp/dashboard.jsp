<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionObj = request.getSession(false);

    if (sessionObj == null || sessionObj.getAttribute("username") == null) {
        response.sendRedirect("login.html");
        return;
    }

    String username = (String) sessionObj.getAttribute("username");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
    <h2>Welcome, <%= username %></h2>
    <p>You are successfully logged in 🎉</p>

    <form action="logout" method="post">
        <input type="submit" value="Logout">
    </form>
</div>
<div id="toast" class="toast"></div>
<script src="toast.js"></script>

<script>
<%
    if ("success".equals(request.getParameter("login"))) {
%>
    showToast("Login successful 🎉", "success");
<%
    }
%>
</script>

</body>
</html>
