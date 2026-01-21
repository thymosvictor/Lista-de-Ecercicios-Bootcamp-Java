import br.com.listaexercicios.model.Pessoa;
import br.com.listaexercicios.model.Jogador;
import br.com.listaexercicios.model.Elevador;
import br.com.listaexercicios.service.PessoaService;
import br.com.listaexercicios.service.JogadorService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PessoaService pessoaService = new PessoaService();
        JogadorService jogadorService = new JogadorService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Elevador elevador = null; // vamos criar o elevador quando escolher a opção 3

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Cadastrar Jogador");
            System.out.println("3. Controlar Elevador");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    // === Pessoa ===
                    System.out.print("Digite o nome: ");
                    String nomeP = scanner.nextLine();
                    LocalDate dataNascimentoP = lerData(scanner, formatter);
                    System.out.print("Digite a altura em metros: ");
                    double alturaP = lerDouble(scanner);

                    Pessoa pessoa = new Pessoa(nomeP, dataNascimentoP, alturaP);
                    int idadeP = pessoaService.getIdade(pessoa);

                    System.out.println("\n=== Dados da Pessoa ===");
                    System.out.println("Nome: " + pessoa.getNome());
                    System.out.println("Data de Nascimento: " + pessoa.getDataNascimento().format(formatter));
                    System.out.println("Altura: " + pessoa.getAltura() + " m");
                    System.out.println("Idade: " + idadeP + " anos");
                    break;

                case "2":
                    // === Jogador ===
                    System.out.print("Digite o nome do jogador: ");
                    String nomeJ = scanner.nextLine();

                    System.out.print("Digite a nacionalidade: ");
                    String nacionalidadeJ = scanner.nextLine();

                    System.out.print("Digite a altura em metros: ");
                    double alturaJ = lerDouble(scanner);

                    System.out.print("Digite o peso em kg: ");
                    double pesoJ = lerDouble(scanner);

                    LocalDate dataNascimentoJ = lerData(scanner, formatter);

                    Jogador jogador = new Jogador(nomeJ, "", nacionalidadeJ, alturaJ, pesoJ, dataNascimentoJ);

                    int idadeJ = jogadorService.getIdade(jogador);
                    String posicaoJ = jogadorService.determinarPosicao(jogador);

                    System.out.println("\n=== Dados do Jogador ===");
                    System.out.println("Nome: " + jogador.getNome());
                    System.out.println("Posição: " + posicaoJ);
                    System.out.println("Nacionalidade: " + jogador.getNacionalidade());
                    System.out.println("Altura: " + jogador.getAltura() + " m");
                    System.out.println("Peso: " + jogador.getPeso() + " kg");
                    System.out.println("Idade: " + idadeJ + " anos");
                    break;

                case "3":
                    // === Elevador ===
                    if (elevador == null) {
                        System.out.print("Digite a capacidade do elevador: ");
                        int capacidade = (int) lerDouble(scanner);
                        System.out.print("Digite o total de andares (sem contar o térreo): ");
                        int totalAndares = (int) lerDouble(scanner);
                        elevador = new Elevador(capacidade, totalAndares);
                        System.out.println("Elevador inicializado no térreo com capacidade de " + capacidade + " pessoas e " + totalAndares + " andares.");
                    }

                    boolean elevadorRodando = true;
                    while (elevadorRodando) {
                        System.out.println("\n--- Controle do Elevador ---");
                        System.out.println("1. Entrar pessoa");
                        System.out.println("2. Sair pessoa");
                        System.out.println("3. Subir andar");
                        System.out.println("4. Descer andar");
                        System.out.println("5. Mostrar status do elevador");
                        System.out.println("0. Voltar ao menu principal");
                        System.out.print("Escolha uma opção: ");
                        String opElev = scanner.nextLine();

                        switch (opElev) {
                            case "1": elevador.entra(); break;
                            case "2": elevador.sai(); break;
                            case "3": elevador.sobe(); break;
                            case "4": elevador.desce(); break;
                            case "5":
                                System.out.println("Andar atual: " + elevador.getAndarAtual());
                                System.out.println("Pessoas presentes: " + elevador.getPessoasPresentes());
                                System.out.println("Capacidade: " + elevador.getCapacidade());
                                System.out.println("Total de andares: " + elevador.getTotalAndares());
                                break;
                            case "0": elevadorRodando = false; break;
                            default: System.out.println("Opção inválida!"); break;
                        }
                    }
                    break;

                case "0":
                    rodando = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }

    // Métodos auxiliares para ler dados com validação
    private static LocalDate lerData(Scanner scanner, DateTimeFormatter formatter) {
        while (true) {
            try {
                String dataStr = scanner.nextLine();
                return LocalDate.parse(dataStr, formatter);
            } catch (Exception e) {
                System.out.print("Data inválida! Digite no formato dd/MM/yyyy: ");
            }
        }
    }

    private static double lerDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Valor inválido! Digite novamente: ");
            }
        }
    }
}

