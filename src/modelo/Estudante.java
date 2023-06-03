package modelo;

public class Estudante {

	private int id;
	private String nomeCompleto;
	private int idadeNaMatricula;
	private String email;
	private String endereco;
	private String cep;
	private String telefone;
	private String curso;
	private String observacoes;
	private boolean ativo;

		
	public Estudante() {
	}
	
	public Estudante(int id, String nomeCompleto, int idadeNaMatricula, String email, String endereco, String cep,
			String telefone, String curso, String observacoes, boolean ativo) {

		this.nomeCompleto = nomeCompleto;
		this.idadeNaMatricula = idadeNaMatricula;
		this.email = email;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.curso = curso;
		this.observacoes = observacoes;
		this.ativo = ativo;

	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public int getIdadeNaMatricula() {
		return getIdadeNaMatricula();
	}

	public void setIdadeNaMatricula(int idadeNaMatricula) {
		this.idadeNaMatricula = idadeNaMatricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public boolean isAtivo() {
		return isAtivo();
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}




public Estudante get(int rowIndex) {
		
		return null;
	}

}
