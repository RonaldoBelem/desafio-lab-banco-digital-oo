public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public String sacar(double valor) {
		verificarRetiradaDeMontanteNaConta(valor);
		saldo -= valor;
		return "Saque realizado com sucesso";
	}

	@Override
	public String depositar(double valor) {
		saldo += valor;
		return "Depósito realizado com sucesso";
	}

	@Override
	public String transferir(double valor, IConta contaDestino) {
		verificarRetiradaDeMontanteNaConta(valor);
		this.sacar(valor);
		contaDestino.depositar(valor);
		return "Transferência realizada com sucesso";
	}

	// verifica se o valor solicitado para retirada é válido ou não e joga uma exceção se não for
	private void verificarRetiradaDeMontanteNaConta(double valor) {
		if (saldo < valor || valor < 0) {
			throw new IllegalArgumentException("Quantia inválida!");
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
