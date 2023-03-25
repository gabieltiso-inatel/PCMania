import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Hardwares básicos especificados para cada PC, respectivamente.
        HardwareBasico hb1Promo1 = new HardwareBasico("Pentium Core i3", 2200);
        HardwareBasico hb2Promo1 = new HardwareBasico("Memória RAM", 8);
        HardwareBasico hb3Promo1 = new HardwareBasico("HD", 500);

        HardwareBasico hb1Promo2 = new HardwareBasico("Pentium Core i5", 3370);
        HardwareBasico hb2Promo2 = new HardwareBasico("Memória RAM", 16);
        HardwareBasico hb3Promo2 = new HardwareBasico("HD", 1000);

        HardwareBasico hb1Promo3 = new HardwareBasico("Pentium Core i7", 4500);
        HardwareBasico hb2Promo3 = new HardwareBasico("Memória RAM", 32);
        HardwareBasico hb3Promo3 = new HardwareBasico("HD", 2000);

        // Memórias USB das promoções
        MemoriaUSB musbPromo1 = new MemoriaUSB("Pen-drive", 16);
        MemoriaUSB musbPromo2 = new MemoriaUSB("Pen-drive", 32);
        MemoriaUSB musbPromo3 = new MemoriaUSB("HD Externo", 1000);

        // instanciando os computadores e atribuindo os valores aos atributos
        Computador promo1 = new Computador("Positivo", 2300);
        promo1.hardwaresBasicos[0] = hb1Promo1;
        promo1.hardwaresBasicos[1] = hb2Promo1;
        promo1.hardwaresBasicos[2] = hb3Promo1;
        promo1.sistemaOperacional.nome = "Linux Ubuntu";
        promo1.sistemaOperacional.tipo = 32;
        promo1.addMemoriaUSB(musbPromo1);

        Computador promo2 = new Computador("Acer", 5800);
        promo2.hardwaresBasicos[0] = hb1Promo2;
        promo2.hardwaresBasicos[1] = hb2Promo2;
        promo2.hardwaresBasicos[2] = hb3Promo2;
        promo2.sistemaOperacional.nome = "Windows 8";
        promo2.sistemaOperacional.tipo = 64;
        promo2.addMemoriaUSB(musbPromo2);

        Computador promo3 = new Computador("Vaio", 1800);
        promo3.hardwaresBasicos[0] = hb1Promo3;
        promo3.hardwaresBasicos[1] = hb2Promo3;
        promo3.hardwaresBasicos[2] = hb3Promo3;
        promo3.sistemaOperacional.nome = "Windows 10";
        promo3.sistemaOperacional.tipo = 64;
        promo3.addMemoriaUSB(musbPromo3);

        // instanciando a classe Cliente
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("Cpf do cliente: ");
        long cpf = sc.nextLong();

        Cliente cl = new Cliente(nome, cpf);

        System.out.println("PC's disponíveis para compra: "); 
        promo1.mostraPCConfigs();
        promo2.mostraPCConfigs();
        promo3.mostraPCConfigs();

        System.out.print("Selecione uma promoção para comprar (1, 2 ou 3) ou pressione 0 para sair: ");
        int operacao = sc.nextInt();
        while (operacao != 0) {
            switch (operacao) {
                case 1:
                    cl.compras[0] = promo1;
                    break;
                case 2:
                    cl.compras[1] = promo2;
                    break;
                case 3:
                    cl.compras[2] = promo3;
                    break;
                default:
                    System.out.println("Essa promoção não existe");
                    break;
            }
            System.out.print("Selecione uma promoção para comprar (1, 2 ou 3): ");
            operacao = sc.nextInt();
        }

        System.out.printf("Compra finalizada, informações do cliente:\n\nNome: %s\nCPF: %d\n\n", cl.nome, cl.cpf);
        System.out.print("Informações de compra:");
        for (Computador pc : cl.compras) {
            if (pc != null) {
                pc.mostraPCConfigs();
            }
        }
        System.out.printf("Total a pagar: %.3f R$\n", cl.calculaTotalCompra());

        sc.close();
    }
}
