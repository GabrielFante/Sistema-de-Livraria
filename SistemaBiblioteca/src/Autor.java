import java.time.LocalDate;
import java.util.Objects;

public class Autor {
    private int id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.length() <= 2 || nome.length() > 50) {
            throw new Exception("O nome deve ter entre 3 e 50 caracteres!");
        }
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) throws Exception {
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new Exception("A data deve ser válida!");
        } else if (!dataNascimento.isBefore(LocalDate.now().minusYears(18))) {
            throw new Exception("Você deve ter mais do que 18 anos!");
        }
        this.dataNascimento = dataNascimento;
    }

    public void nextId() {

    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (!(a instanceof Autor)) return false;
        Autor autor = (Autor) a;
        return Objects.equals(nome, autor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}