<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>Default tiles template</title>
 </head>
<body>

    <div>
        <tiles:insertAttribute name="header" />
        <div>
            <tiles:insertAttribute name="body" />
        </div>
    </div>
</body>
</html>