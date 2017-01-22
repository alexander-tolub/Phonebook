<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="mainContent" fragment="true" required="false" %>
<%@ attribute name="htmlTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ include file="/WEB-INF/jsp/base.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <title><c:out value="${htmlTitle}" /></title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/scrollScript.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/editScrtipt.js"></script>

        <meta name="_csrf" content="${_csrf.token}"/>
        <!-- default header name is X-CSRF-TOKEN -->
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <!-- ... -->
    </head>
    <body>
        <jsp:invoke fragment="mainContent"/>
    </body>
</html>