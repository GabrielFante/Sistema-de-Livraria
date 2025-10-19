import java.time.LocalDate;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();

        Autor georgeOrwell = new Autor("George Orwell", LocalDate.of(1903, 7,23));
        Autor gabriel = new Autor("Gabriel Fante", LocalDate.of(2004, 2, 29));
        Livro CleanCode = new Livro("Clean Code", "Técnico", gabriel , true, LocalDate.now());
        Livro Nineteen_EightyFour = new Livro("1984", "romance", georgeOrwell, true, LocalDate.now());
        Livro Java = new Livro("Clesdan Code", "Técnico", gabriel , true, LocalDate.now());
        Cliente joao = new Cliente("Joao", "joao@gmail.com");

        biblioteca.salvarAutor(georgeOrwell);
        biblioteca.salvarAutor(gabriel);
        biblioteca.salvarLivro(CleanCode);
        biblioteca.salvarLivro(Nineteen_EightyFour);
        biblioteca.cadastrarCliente(joao);
        biblioteca.salvarLivro(Java);

        Scanner scanner = new Scanner(System.in);
        boolean escolha = false;

        while(!escolha) {
            try {
                System.out.println("ESCOLHA UMA OPÇÃO NUMÉRICA:\n" +
                        "1 - LISTAR LIVROS DISPONÍVEIS\n" +
                        "2 - SOLICITAR EMPRESTIMO\n" +
                        "3 - SAIR\n");

                String opcao = scanner.nextLine();

                switch (opcao) {
                    case ("1"):
                        biblioteca.listarLivros();
                        break;
                    case ("2"):
                        System.out.println("Digite seu nome como cadastrado: ");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o Id do livro: ");
                        int idLivro = Integer.parseInt(scanner.nextLine());

                        biblioteca.emprestarLivro(nome, idLivro);
                        break;
                    case ("3"):
                        escolha = true;
                        break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}