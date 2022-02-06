package br.com.entidade;

public class User {
	private Integer id;
	private String nome;
	private String pais;
	private String email;
	private String telefone;

	public User(String nome, String pais, String email,String telefone) {
		this.nome = nome;
		this.pais = pais;
		this.email = email;
		this.telefone = telefone;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getPais() {
		return this.pais;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", pais=" + pais + ", email=" + email + ", telefone=" + telefone
				+ "]";
	}
}
