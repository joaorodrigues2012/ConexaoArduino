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
	
	 <form action="controller.do" method="post">
                                <button type="submit" class="btn btn-primary" name="command" value="ligarled">ligar</button>
                                <button type="submit" class="btn btn-primary" name="command" value="desligarled">desligar</button>
                            </form>
</body>
</html>