package br.com.locadora.beans;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {				
		menuPrincipal();
	}
	
	
	public static void menuPrincipal() {
		Scanner teclado = new Scanner(System.in);
		int escolha = 0;
		boolean conti = true;
		
		while(conti) {
			System.out.println("\n----------------------------------------------------");
			System.out.println("Bem-vindo ao sistema da Locadora!");
			System.out.println("* - Digite a opção do menu que você quer acessar: \n1 - Menu de Filmes\n2 - Menu de Jogos\n3 - Sair");
			System.out.println("----------------------------------------------------");
			escolha = teclado.nextInt();
			
			switch(escolha) {
				case 1:
					System.out.println("\nMenu de Filmes");
					//abre menu dos filmes
					menuFilme();
				break;
				case 2:
					System.out.println("\nMenu de Jogos");
					//abre menu dos jogos
					menuJogos();
				break;
				case 3:
					//deixa o "conti" como false para sair do while
					System.out.println("\nPrograma finalizado");
					conti = false;
				break;
				default:
					System.out.println("\nOpção inválida");
				break;
			}
		}
	}
	
	public static void menuFilme() {
		//instancia
		Filme filme = new Filme(0, null, null, null, false);
		Cliente cliente = new Cliente(0, null, null, null, null, null, 0, 0);
		Scanner scan = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		
		String nome, genero, buscaString, cpf, dataNasc, cidade, bairro, classificacao;
		int buscaInt;
		
		int opc = 0, opc2 = 0;
		boolean continuar = true;
		
		//menu de filme
		while(continuar) {
			//Leitura menu do filme
			System.out.println("\n----------------------------------------------------");
			System.out.println("Menu de Filmes!");
			System.out.println("* - Digite a opção: \n1 - Cadastro de Filmes\n2 - Deletar filme\n3 - Visualizar filmes cadastrados\n4 - Buscar filmes" + 
							   "\n5 - Alugar filme\n6 - Devolver filme\n7 - Ir para o menu principal");
			System.out.println("----------------------------------------------------");
			
			opc = s.nextInt();
			switch(opc) {
				case 1:
					System.out.println("\nCadastro de Filmes.");
					System.out.println("Digite o nome do filme: ");
					nome = scan.nextLine();
					
					System.out.println("Digite o gênero do filme: ");
					genero = scan.nextLine();
					
					System.out.println("Digite a classificação do filme: ");
					classificacao = s.next();
					
					//cadastro do filme
					filme.cadastrar(nome, genero, classificacao);
				break;
				case 2:
					System.out.println("\nDeletar filmes do banco de dados");
					//leitura do id do filme
					System.out.println("Digite o ID do filme que você deseja excluir do banco: ");
					buscaInt = s.nextInt();
					
					//deleta o filme com o ID que o usuario digitou
					System.out.println(filme.deletar(buscaInt) + "\n");
					
					//impressao dos filmes
					filme.imprimiFilmes();
				break;
				case 3:
					System.out.println("\nVisualizar filmes cadastrados.");
					
					//impressao dos filmes
					filme.imprimiFilmes();
				break;
				case 4:
					System.out.println("\nBuscar filmes.");
					
					//leitura da opção do tipo de busca
					System.out.println("Você deseja buscar o filme por qual filtro?\n1 - ID\n2 - Nome\n3 - Gênero\n4 - Faixa etária");
					opc2 = scan.nextInt();
					
					//validação se o usuário digitou um número de 1 a 4
					while(opc2 < 0 || opc2 > 4) {
						System.out.println("Opção inválida, digite novamente! Você deseja buscar o filme por qual filtro?\n1 - ID\n2 - Nome\n3 - Gênero\n4 - Faixa etária");
						opc2 = scan.nextInt();
					}
					
					switch(opc2) {
						case 1:
							System.out.println("\nBusca pelo ID");
							
							//leitura do ID
							System.out.println("Digite o Id do filme que você deseja buscar: ");
							buscaInt = scan.nextInt();
							System.out.println(filme.buscaId(buscaInt));
						break;
						case 2:
							System.out.println("\nBusca pelo nome");
							
							//leitura do nome
							System.out.println("Digite o nome do filme que você deseja buscar: ");
							scan.next();
							buscaString = scan.nextLine();
							System.out.println(filme.buscaNome(buscaString));
						break;
						case 3:
							System.out.println("\nBusca pelo gênero");
							
							//leitura do genero
							System.out.println("Digite o gênero que você deseja buscar: ");
							scan.next();
							buscaString = scan.nextLine();
							System.out.println(filme.buscaGenero(buscaString));
						break;
						case 4:
							System.out.println("\nBusca pela faixa etária");
							
							//leitura da faixa etaria
							System.out.println("Digite a faixa etária que você deseja buscar: ");
							buscaString = scan.next();
							System.out.println(filme.buscaFaixa(buscaString));
					}
				break;
				case 5:
					System.out.println("\nAlugar filme.");
					
					//validaçao se o cliente possui cadastro
					System.out.println("O cliente já possui cadastro? \n1 - Sim\n2 - Não");
					int cadastro = scan.nextInt();
					
					//validação se o usuario digitou 1 ou 2
					while(cadastro != 1 && cadastro != 2) {
						System.out.println("Opção inválida, tente novamente. O cliente já possui cadastro? \n1 - Sim\n2 - Não");
						cadastro = scan.nextInt();
					}
					
					//se o usuario digita 2, cadastro do cliente
					if(cadastro == 2) {
						System.out.println("\nDigite o nome do cliente: ");
						scan.next();
						nome = scan.nextLine();
						System.out.println("Digite o CPF do cliente: ");
						cpf = scan.next();
						System.out.println("Digite a data de nascimento do cliente: ");
						dataNasc = scan.next();
						System.out.println("Digite a cidade do cliente: ");
						scan.next();
						cidade = scan.nextLine();
						System.out.println("Digite o bairro do cliente: ");
						scan.next();
						bairro = scan.nextLine();					
						
						cliente.cadastrar(nome, cpf, dataNasc, cidade, bairro);
					}
					
					//imprimi somente os filmes disponiveis
					filme.filmesDisponiveis();
					
					//leitura do id
					System.out.println("\nDigite o ID do filme que vai ser alugado: ");
					buscaInt = scan.nextInt();
					System.out.println(filme.alugar(buscaInt));
				break;
				case 6:
					System.out.println("\nDevolver filme.");
					
					//leitura do id
					System.out.println("Digite o ID do filme que vai ser devolvido: ");
					buscaInt = scan.nextInt();
					System.out.println(filme.devolver(buscaInt));
				break;
				case 7:
					
					//deixa o "continuar" como false para sair do while e ir para o menu principal
					System.out.println("Saindo do menu de filmes!");
					continuar = false;
				break;
				default:
					System.out.println("\nOpção inválida.");
				break;
			}
		}
	}
	
	public static void menuJogos() {
		//instancia
		Jogo jogo = new Jogo(0, null, null, null, false);
		Cliente cliente = new Cliente(0, null, null, null, null, null, 0, 0);
		
		Scanner scan = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		
		String nome, genero, buscaString, cpf, dataNasc, cidade, bairro, classificacao;
		int buscaInt;
		
		int opc = 0, opc2 = 0;
		boolean continuar = true;
		while(continuar) {
			System.out.println("\n----------------------------------------------------");
			System.out.println("Menu de Jogos!");
			System.out.println("* - Digite a opção: \n1 - Cadastrar jogo\n2 - Deletar jogo\n3 - Visualizar jogos cadastrados\n4 - Buscar jogos" + 
							   "\n5 - Alugar jogo\n6 - Devolver jogo\n7 - Ir para o menu principal");
			System.out.println("----------------------------------------------------");
			
			opc = s.nextInt();
			switch(opc) {
				case 1:
					System.out.println("\nCadastro de jogos.");
					System.out.println("Digite o nome do jogo: ");
					nome = scan.nextLine();
					
					System.out.println("Digite o gênero do jogo: ");
					genero = scan.nextLine();
					
					System.out.println("Digite a classificação do jogo: ");
					classificacao = s.next();
					
					//cadastro do jogo
					jogo.cadastrar(nome, genero, classificacao);
				break;
				case 2:
					System.out.println("\nDeletar jogo do banco de dados");
					System.out.println("Digite o ID do jogo que você deseja excluir do banco: ");
					buscaInt = s.nextInt();
					
					System.out.println(jogo.deletar(buscaInt) + "\n");
					
					//impressao dos jogos
					jogo.imprimiJogos();
				break;
				case 3:
					System.out.println("\nVisualizar jogos cadastrados.");
					
					//impressao dos jogos
					jogo.imprimiJogos();
				break;
				case 4:
					System.out.println("\nBuscar jogo.");
					System.out.println("Você deseja buscar o jogo por qual filtro?\n1 - ID\n2 - Nome\n3 - Gênero\n4 - Faixa etária");
					opc2 = scan.nextInt();
					
					while(opc2 < 0 || opc2 > 4) {
						System.out.println("Opção inválida, digite novamente! Você deseja buscar o jogo por qual filtro?\n1 - ID\n2 - Nome\n3 - Gênero\n4 - Faixa etária");
						opc2 = scan.nextInt();
					}
					
					switch(opc2) {
						case 1:
							System.out.println("\nBusca pelo ID");
							System.out.println("Digite o ID do jogo que você deseja buscar: ");
							buscaInt = scan.nextInt();
							System.out.println(jogo.buscaId(buscaInt));
						break;
						case 2:
							System.out.println("\nBusca pelo nome");
							System.out.println("Digite o nome do jogo que você deseja buscar: ");
							scan.next();
							buscaString = scan.nextLine();
							System.out.println(jogo.buscaNome(buscaString));
						break;
						case 3:
							System.out.println("\nBusca pelo gênero");
							System.out.println("Digite o gênero que você deseja buscar: ");
							scan.next();
							buscaString = scan.nextLine();
							System.out.println(jogo.buscaGenero(buscaString));
						break;
						case 4:
							System.out.println("\nBusca pela faixa etária");
							System.out.println("Digite a faixa etária que você deseja buscar: ");
							buscaString = scan.next();
							System.out.println(jogo.buscaFaixa(buscaString));
					}
				break;
				case 5:
					System.out.println("\nAlugar jogo.");
					
					System.out.println("O cliente já possui cadastro? \n1 - Sim\n2 - Não");
					int cadastro = scan.nextInt();
					
					while(cadastro != 1 && cadastro != 2) {
						System.out.println("Opção inválida, tente novamente. O cliente já possui cadastro? \n1 - Sim\n2 - Não");
						cadastro = scan.nextInt();
					}
					
					if(cadastro == 2) {
						System.out.println("\nDigite o nome do cliente: ");
						scan.next();
						nome = scan.nextLine();
						System.out.println("Digite o CPF do cliente: ");
						cpf = scan.next();
						System.out.println("Digite a data de nascimento do cliente: ");
						dataNasc = scan.next();
						System.out.println("Digite a cidade do cliente: ");
						scan.next();
						cidade = scan.nextLine();
						System.out.println("Digite o bairro do cliente: ");
						scan.next();
						bairro = scan.nextLine();					
						
						cliente.cadastrar(nome, cpf, dataNasc, cidade, bairro);
					}
					
					//imprimi somente os jogos disponiveis
					jogo.jogosDisponiveis();
					
					//leitura do id
					System.out.println("\nDigite o ID do jogo que vai ser alugado: ");
					buscaInt = scan.nextInt();
					System.out.println(jogo.alugar(buscaInt));
				break;
				case 6:
					System.out.println("\nDevolver jogo.");
					
					//leitura do id
					System.out.println("Digite o ID do jogo que vai ser devolvido: ");
					buscaInt = scan.nextInt();
					System.out.println(jogo.devolver(buscaInt));
				break;
				case 7:
					//deixa o "continuar" como false para sair do while e ir para o menu principal
					System.out.println("Saindo do menu de jogos!");
					continuar = false;
				break;
				default:
					System.out.println("\nOpção inválida.");
				break;
			}
		}
	}
}
