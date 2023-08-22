//PrintStream para imprimir dados na saída padrão, geralmente
//a tela do console. Vou usar para reduzir código.
import java.io.PrintStream;
//Scanner para entrada de dados do usuário;
import java.util.Scanner;
//Random para gerar numeros aleatórios em Java; 
import java.util.Random;

public class App {
    //private -> define que a variável só pode ser acessada dentro da classe onde ela foi definida.
    //static -> indica que a variável pertence à classe em vez de pertencer a uma instância específica da classe. 
    private static PrintStream show = System.out;
    //Estrutura padrão para capturar dados do usuário.
    private static Scanner scan = new Scanner(System.in);

    private static Random gerador = new Random();
    
    private static int escolha_pc;
    private static int escolha_user;
    private static String nome;
    
    public static void PalpitesUser() {
        int tentativas = 1; // Contador de tentativas

        do {
        show.println("Digite um número: ");
        escolha_user = scan.nextInt();

        if (escolha_user == escolha_pc) {
            show.println("Você acertou. Parabéns!!"); 
            break;  // Encerra o loop se acertar
        } else if (tentativas == 4) {
            show.println("Você não tem mais chances. O número era " + escolha_pc);
            break; // Encerra o loop se tentativas chegar a 4.
        } else {
            ++tentativas;
            show.println("Você errou. Tente novamente: ");
        }

        } while (true);
    }

    public static void jogo(){
        show.println("Ok! O jogo é o seguinte...");
        show.println("Eu vou escolher um número de 0 a 10...");
        show.println("Mas, não vou te dizer esse número...");
        show.println("Se você descobrir qual número eu escolhi...");
        show.println("Você ganhará o jogo!!");

        escolha_pc = gerador.nextInt(11);

        show.println("Ok " + nome + ", já escolhi...");
        show.println("Agora tente adivinhar!");

        PalpitesUser();
    }
    public static void main(String[] args) {

        int jogarOuNao;

        show.println("Olá, qual seu nome?");
        //Obj da classe String  
        nome = scan.nextLine();
        show.println("Prazer em conhecê-lo(a), " + nome + "!");
        show.println(nome + ", você gostaria de jogar comigo?");
        show.println("\nInforme o número da sua opção: \n1-Sim\n2-Não");
        do {
            jogarOuNao = scan.nextInt();
            
            if (jogarOuNao == 2) {
                show.println("Tudo bem, " + nome + ". Fica para próxima!");
                break; // Sai do loop se o usuário escolher "Não"
            } else if (jogarOuNao == 1) {
                jogo();
                break;
            } else {
                show.println("Opção inválida! Digite 1 para jogar ou 2 para não jogar: ");
            }
        } while (true);
    }
}
