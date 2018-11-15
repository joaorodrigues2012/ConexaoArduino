package model;

import DAO.consumoDao;

public class teste {
	CalcularTensao calc = new CalcularTensao("COM3");
	
	Thread t = new Thread() {
		@Override
		public void run() {
			
			calc.initialize();
			
			while(true) {
				System.out.println("tudo bem: "+calc.read());
				
				if(calc.read() != null) {
					consumoDao consDao = new consumoDao();
					consumo cons = new consumo();
					
					cons.setValor(Double.parseDouble(calc.read()));
					consDao.criar(cons);
					
					calc.sleep(36000); //milisegundos
				}
			}
		}
	};
	
	public static void main(String[] args) {
		
		teste test = new teste();
		test.t.start();
	}
}
