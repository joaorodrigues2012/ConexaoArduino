<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<script type="text/javascript">
 
  function ligarLed() {
    websocket.send("l");
  }
  function desligarLed() {
    websocket.send("d");
  }

</script>

<title>Arduino Web</title>
</head>

<body>
	<input onclick="ligarLed();" type="button" value="Ligar LED"> <br />
	<input onclick="desligarLed();" type="button" value="Desligar LED">	<br />
	<div id="saida"></div>
	<div id="servo"></div>
</body>
</html>