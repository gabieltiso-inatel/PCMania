public class Cliente {
    String nome;
    long cpf;
    Computador[] compras = new Computador[3];

    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    float calculaTotalCompra() {
        float total = 0;
        for (Computador c : this.compras) {
            if (c != null) {
                total += c.preco;
            }
        }

        return total;
    }
}
