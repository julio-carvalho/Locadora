package br.com.locadora.beans;

import java.util.ArrayList;

public class Jogo {
	private int idJogo;
	private String nome;
	private String classificacao;
	private String genero;
	private boolean disponibilidade;
	private Cliente cliente;
	
	int cont = 1;
	
	ArrayList<Jogo> arrayJogo = new ArrayList<>();
	
	public Jogo(int idJogo, String nome, String classificacao, String genero, boolean disponibilidade) {
		this.idJogo = idJogo;
		this.nome = nome;
		this.classificacao = classificacao;
		this.genero = genero;
		this.disponibilidade = disponibilidade;
		cliente = new Cliente(0, null, null, null, null, null, 0, 0);
	}
	
	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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
		setIdJogo(cont++);
		
		System.out.println("\nJogo cadastrado com sucesso! O ID desse jogo �: " + getNome());
		arrayJogo.add(new Jogo(getIdJogo(), getNome(), getClassificacao(), getGenero(), isDisponibilidade()));
	}
	
	public String deletar(int id) {
		for (Jogo jogo : arrayJogo) {
			if(jogo.getIdJogo() == id) {
				arrayJogo.remove(jogo);
				return "Jogo exclu�do com sucesso!";
			} 
		}
		return "Jogo n�o encontrado!";
	}
	
	public void imprimiJogos() {
		for (Jogo jogo : arrayJogo) {
			System.out.println(jogo.toString());
		}
	}
	
	public String buscaId(int id) {
		for (Jogo jogo : arrayJogo) {
			if(jogo.getIdJogo() == id) {
				return jogo.toString();
			}
		}
		return "Jogo n�o encontrado!";
	}
	
	public String buscaNome(String nome) {
		for (Jogo jogo : arrayJogo) {
			if(jogo.getNome().equalsIgnoreCase(nome)) {
				return jogo.toString();
			}
		}
		return "Jogo n�o encontrado!";
	}
	
	public String buscaGenero(String genero) {
		for (Jogo jogo : arrayJogo) {
			if(jogo.getGenero().equalsIgnoreCase(genero)) {
				return jogo.toString();
			}
		}
		return "Jogo n�o encontrado!";
	}
	
	public String buscaFaixa(String faixa) {
		for (Jogo jogo : arrayJogo) {
			if(jogo.getClassificacao().equalsIgnoreCase(faixa)) {
				return jogo.toString();
			}
		}
		return "Jogo n�o encontrado";
	}
	
	public String alugar(int id) {
		for (Jogo jogo : arrayJogo) {
			if(jogo.getIdJogo() == id) {
				if(jogo.isDisponibilidade() == true) {
					jogo.setDisponibilidade(false);
					cliente.setIdJogoAlugado(jogo.getIdJogo());
					return "Jogo alugado!";
				} else {
					return "Jogo indispon�vel!";
				}
			}
		}
		return "Jogo n�o encontrado!";
	}
	
	public void jogosDisponiveis() {
		for (Jogo jogo : arrayJogo) {
			if(jogo.disponibilidade == true) {
				System.out.println("\nNome do filme: " + jogo.getNome());
				System.out.println("G�nero do filme: " + jogo.getGenero());
				System.out.println("Classifica��o do filme: " + jogo.getClassificacao());
				System.out.println("ID do filme: " + jogo.getIdJogo());
			}
		}
	}
	
	public String devolver(int id) {
		for (Jogo jogo : arrayJogo) {
			if(jogo.getIdJogo() == id) {
				if(jogo.isDisponibilidade() == false) {
					jogo.setDisponibilidade(true);
					return "Jogo devolvido.";
				} else {
					return "Esse jogo j� est� dispon�vel no sistema.";
				}
			}
		}
		return "Jogo n�o encontrado";
	}
	
	@Override
	public String toString() {
		return "\nID: " + idJogo + "\nNome: " + nome + "\nG�nero: " + genero + "\nClassifica��o: "
				+ classificacao + "\nDisponibilidade: " + disponibilidade + "\n";
	}
}
