<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Sportium Challenge - Markus</title>
</head>
<body>
<h1>Sportium Challenge - Markus</h1>
<br>
<form:form method="POST" action="/process">
  Input Value:<form:input path="inputValue" size="80"/><br>
    <input type="submit" value="Submit"/>
</form:form>
<h3>${result}</h3>
<h4>${errorMessage}</h4>
<br>
<br>
<br>
<i>
    Usage examples:<br>
    <ul>
        <li>Tenis: Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko</li>
        <li>Football: F.C. Barcelona 3-2 Real Madrid</li>
        <li>American Football: Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter</li>
    </ul>
</i>

</body>
</html>
