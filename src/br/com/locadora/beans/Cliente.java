package br.com.locadora.beans;

import java.util.ArrayList;

public class Cliente {
	private int idCliente;
	private String nome;
	private String cpf;
	private String dataNasc;
	private String cidade;
	private String bairro;
	private int idFilmeAlugado;
	private int idJogoAlugado;
	
	int cont = 1;
	Filme filme;
	ArrayList<Cliente> arrayCliente = new ArrayList<>();
	
	public Cliente(int idCliente, String nome, String cpf, String dataNasc, String cidade, String bairro, int idFilmeAlugado, int idJogoAlugado) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.cidade = cidade;
		this.bairro = bairro;
		this.idFilmeAlugado = idFilmeAlugado;
		this.idJogoAlugado = idJogoAlugado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public int getIdFilmeAlugado() {
		return idFilmeAlugado;
	}

	public void setIdFilmeAlugado(int idFilmeAlugado) {
		this.idFilmeAlugado = idFilmeAlugado;
	}

	public int getIdJogoAlugado() {
		return idJogoAlugado;
	}

	public void setIdJogoAlugado(int idJogoAlugado) {
		this.idJogoAlugado = idJogoAlugado;
	}

	
	public void cadastrar(String nome, String cpf, String dataNasc, String cidade, String bairro) {
		setNome(nome);
		setCpf(cpf);
		setDataNasc(dataNasc);
		setCidade(cidade);
		setBairro(bairro);
		setIdCliente(cont++);
		
		System.out.println("\nCliente cadastrado com sucesso! O ID desse cliente é: " + getIdCliente());
	}
	
	
}
