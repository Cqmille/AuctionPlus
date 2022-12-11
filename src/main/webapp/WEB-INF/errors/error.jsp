<%@ page isErrorPage="true" %>

<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>An error occurred while processing your request</h1>

<p>Sorry, something went wrong and we were unable to complete your request. Please try again later.</p>

<%
    // Display the error message from the request attribute (if any)
    String errorMessage = (String) request.getAttribute("jakarta.servlet.error.message");
    if (errorMessage != null) {
%>
<p><b>Error message:</b> <%= errorMessage %></p>
<%
    }
%>
</body>
</html>