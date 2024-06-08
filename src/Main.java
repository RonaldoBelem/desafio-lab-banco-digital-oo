public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco();
		Cliente venilton = new Cliente("Alexandre");
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta cc1 = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);
		
		try {
			cc.depositar(190);
			cc.sacar(20);
			cc.transferir(100, poupanca);
			
			cc.imprimirExtrato();
			poupanca.imprimirExtrato();

		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
