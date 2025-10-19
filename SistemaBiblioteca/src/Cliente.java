public class Cliente {
    private int id;
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email.length() < 5 || email.length() > 40) {
            throw new Exception("O email deve ter entre 5 e 40 caracteres!");
        }
        this.email = email;
    }
}
