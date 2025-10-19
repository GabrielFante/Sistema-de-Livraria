import java.time.LocalDate;
import java.util.Objects;

public class Livro {
    private static int contador = 0;
    private int id;
    private String titulo;
    private String categoria;
    private Autor autor;
    private boolean disponivel = true;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(String titulo, String categoria, Autor autor, boolean disponivel, LocalDate dataCadastro) {
        this.id = ++contador;
        this.titulo = titulo;
        this.categoria = categoria;
        this.autor = autor;
        this.disponivel = disponivel;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return titulo;
    }

    private void setTitle(String titulo) throws Exception {
        if (titulo.length() < 2 || titulo.length() > 20) {
            throw new Exception("Titulo deve ter entre 2 e 20 caracteres!");
        }
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria(String categoria) throws Exception {
        if (categoria.length() < 4 || categoria.length() > 15) {
            throw new Exception("A categoria deve ter entre 3 e 15 caracteres!");
        }
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    private void setAutor(Autor autor) throws Exception {
        if (autor == null) {
            throw new Exception("As informações do autor não podem ser vazias!");
        }
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public boolean equals(Object book) {
        if (this == book) return true;
        if (!(book instanceof Livro)) return false;
        Livro livro = (Livro) book;
        return Objects.equals(titulo, livro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}