package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CalcularTensao;

public class desligarled implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		CalcularTensao calc = new CalcularTensao("COM3");
			
		
				
				calc.initialize();
				calc.send("d");
			
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
			
		view = request.getRequestDispatcher("consumo.jsp");
		
		view.forward(request, response);
	}

}
