package br.com.locadora.beans;

import java.util.ArrayList;


public class Filme {
	private int idFilme;
	private String nome;
	private String genero;
	private String classificacao;
	private boolean disponibilidade;
	private Cliente cliente;
	ArrayList<Filme> arrayFilme = new ArrayList<>();
	int contId = 1;
	
	public Filme(int idFilme, String nome, String genero, String classificacao, boolean disponibilidade) {
		this.idFilme = idFilme;
		this.nome = nome;
		this.genero = genero;
		this.classificacao = classificacao;
		this.disponibilidade = disponibilidade;
		cliente = new Cliente(0, null, null, null, null, null, 0, 0);
	}
	
	public int getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	public void cadastrar(String nome, String genero, String classificacao) {
		setNome(nome);
		setGenero(genero);
		setClassificacao(classificacao);
		setDisponibilidade(true);
		setIdFilme(contId++);
		
		System.out.println("\nFilme cadastrado com sucesso! O ID desse filme é: " + getIdFilme());
		arrayFilme.add(new Filme(getIdFilme(), getNome(), getGenero(), getClassificacao(), isDisponibilidade()));
	}
	
	public String deletar(int id) {
		for (Filme filme : arrayFilme) {
			if(filme.getIdFilme() == id) {
				arrayFilme.remove(filme);
				return "Filme excluído com sucesso!";
			} 
		}
		return "Filme não encontrado!";
	}
	
	public void imprimiFilmes() {
		for (Filme filme : arrayFilme) {
			System.out.println(filme.toString());
		}
	}
	
	public String buscaId(int id) {
		for (Filme filme : arrayFilme) {
			if(filme.getIdFilme() == id) {
				return filme.toString();
			}
		}
		return "Filme não encontrado";
	}
	
	public String buscaNome(String nome) {
		for (Filme filme : arrayFilme) {
			if(filme.getNome().equalsIgnoreCase(nome)) {
				return filme.toString();
			}
		}
		return "Filme não encontrado";
	}
	
	public String buscaGenero(String genero) {
		for (Filme filme : arrayFilme) {
			if(filme.getGenero().equalsIgnoreCase(genero)) {
				return filme.toString();
			}
		}
		return "Filme não encontrado";
	}
	
	public String buscaFaixa(String faixa) {
		for (Filme filme : arrayFilme) {
			if(filme.getClassificacao().equalsIgnoreCase(faixa)) {
				return filme.toString();
			}
		}
		return "Filme não encontrado";
	}
	
	public String alugar(int id) {
		for (Filme filme : arrayFilme) {
			if(filme.getIdFilme() == id) {
				if(filme.isDisponibilidade() == true) {
					filme.setDisponibilidade(false);
					cliente.setIdFilmeAlugado(filme.getIdFilme());
					return "Filme alugado!";
				} else {
					return "Filme indisponível!";
				}
			}
		}
		return "Filme não encontrado";
	}
	
	public void filmesDisponiveis() {
		for (Filme filme : arrayFilme) {
			if(filme.disponibilidade == true) {
				System.out.println("\nNome do filme: " + filme.getNome());
				System.out.println("Gênero do filme: " + filme.getGenero());
				System.out.println("Classificação do filme: " + filme.getClassificacao());
				System.out.println("ID do filme: " + filme.getIdFilme());
			}
		}
	}
	
	public String devolver(int id) {
		for (Filme filme : arrayFilme) {
			if(filme.getIdFilme() == id) {
				if(filme.isDisponibilidade() == false) {
					filme.setDisponibilidade(true);
					return "Filme devolvido.";
				} else {
					return "Esse filme já está disponível no sistema.";
				}
			}
		}
		return "Filme não encontrado";
	}
	
	@Override
	public String toString() {
		return "\nID: " + idFilme + "\nNome: " + nome + "\nGênero: " + genero + "\nClassificação: "
				+ classificacao + "\nDisponibilidade: " + disponibilidade + "\n";
	}
	
	
	
	
	
	
}
