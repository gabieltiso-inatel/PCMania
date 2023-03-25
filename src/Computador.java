import java.util.ArrayList;

public class Computador {
    String marca;
    float preco;
    
    // Composição
    SistemaOperacional sistemaOperacional;
    HardwareBasico[] hardwaresBasicos;
    // Agregação
    MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;

        this.sistemaOperacional = new SistemaOperacional();
        this.hardwaresBasicos = new HardwareBasico[3];
    }

    // Esse método é responsável por imprimir as configurações de uma promoção.
    // Cada linha é armazenada em um vetor, para que possamos obter o comprimento
    // da maior linha, e a partir disso desenhar o borda que envolverá o texto.
    void mostraPCConfigs() {
        ArrayList<String> linhas = new ArrayList<>();
        linhas.add(String.format("| Marca: %s", this.marca));
        linhas.add(String.format("| Preço: R$%s", this.preco));

        linhas.add("| HARDWARES BÁSICOS");
        for (HardwareBasico hb : this.hardwaresBasicos) {
            if (hb != null){
                if (hb.nome.contains("Pentium Core")) {
                    linhas.add(String.format("| %s (%.2f Mhz)", hb.nome, hb.capacidade));
                    continue;
                }

                linhas.add(String.format("| %.2f Gb de %s", hb.capacidade, hb.nome));
            }
        }

        linhas.add("| SISTEMA OPERACIONAL");
        linhas.add(String.format("| Sistema Operacional %s (%d bits)", this.sistemaOperacional.nome, this.sistemaOperacional.tipo));

        if (this.memoriaUSB != null) {
            linhas.add("| MEMÓRIA USB");
            linhas.add(String.format("| Acompanha %s de %dGb", this.memoriaUSB.nome, this.memoriaUSB.capacidade));
        }

        // Calcula qual linha possui o maior comprimento
        int lengthMaiorLinha = -1;
        for (String linha : linhas) {
            int linhaLength = linha.length();
            if (linhaLength > lengthMaiorLinha) {
                lengthMaiorLinha = linhaLength;
            }
        }

        // Saída dos dados
        System.out.println();
        System.out.printf("+%s+\n", "-".repeat(lengthMaiorLinha));

        for (String linha : linhas) {
            int espacosRestantes = lengthMaiorLinha - linha.length();
            linha = linha + " ".repeat(espacosRestantes) + " |\n";
            System.out.print(linha);
        }

        System.out.printf("+%s+\n", "-".repeat(lengthMaiorLinha));
    }

    void addMemoriaUSB(MemoriaUSB musb) {
        if (this.memoriaUSB == null) {
            this.memoriaUSB = musb;
        }
    }
}
