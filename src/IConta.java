public interface IConta {
	
	String sacar(double valor);
	
	String depositar(double valor);
	
	String transferir(double valor, IConta contaDestino);
	
	// void 

	void imprimirExtrato();
}
