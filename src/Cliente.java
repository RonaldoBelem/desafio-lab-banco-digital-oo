import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nome;
	List<Conta> contas;

	public Cliente(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public List<Conta> getContas() {
		return contas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
