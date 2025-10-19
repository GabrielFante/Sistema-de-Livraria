import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public void salvarAutor(Autor autor) throws Exception {
        if (autores.contains(autor)) {
            throw new Exception("Já existe esse autor cadastrado!");
        }
        autores.add(autor);
        System.out.println("Autor cadastrado!");
    }

    public void salvarLivro(Livro livro) throws Exception {
        if (livros.contains(livro)) {
            throw new Exception("Esse livro já está cadastrado!");
        }
        livros.add(livro);
        System.out.println("Livro Cadastrado com sucesso!");
    }

    public void cadastrarCliente(Cliente cliente) throws Exception {
        if (!clientes.contains(cliente)) {
            try {
                clientes.add(cliente);
                System.out.println("Cliente cadastrado com sucesso!");
            } catch (Exception e) {
                throw new RuntimeException("Erro ao cadastrar cliente" + e);
            }
        }
        System.out.println("Cliente já cadastrado!");
    }

    public void listarLivros() {
        for (Livro book : livros) {
            if (book.isDisponivel() == true) {
                System.out.println("Id:" + book.getId() + "| Titulo: " + book.getTitle() + "| Categoria: " + book.getCategoria() +
                        "| Autor: " + book.getAutor() + "Disponibilidade: " + book.isDisponivel());
            }
        }
    }

    public Emprestimo emprestarLivro(String nome, int idLivro) throws Exception {
        if (nome == null || nome.isBlank()){
            throw new Exception("Nome é obrigatório!");
        }

        Cliente cliente = encontarClientePorNome(nome);
        Livro livro = encontrarLivroPorId(idLivro);

        if(!livro.isDisponivel()) {
            throw new Exception("Livro não está disponível");
        }

        Emprestimo emprestimo = new Emprestimo(livro, cliente.getNome(), LocalDate.now());
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    private Cliente encontarClientePorNome(String nome) {
        return clientes.stream()
                .filter(client -> client.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado!"));
    }

    private Livro encontrarLivroPorId(int idLivro) {
        return livros.stream()
                .filter(book -> book.getId() == idLivro)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Livro não encontrado!"));
    }
}
