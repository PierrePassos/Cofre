import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int opcao, moedaSelecionada = 0;
        double valorMoeda;
        boolean cofre = true;
        Scanner teclado = new Scanner(System.in);
        ArrayList<Moeda> listaMoedas = new ArrayList<>();

        //Função para exixbir o menu.
        Runnable exibirMenu = () -> {
            System.out.println(
                    "\nCOFRINHO: \n" +
                            "1 - Adicionar Moeda \n" +
                            "2 - Remover Moeda \n" +
                            "3 - Listar Moedas \n" +
                            "4 - Calcular total convertido para Real \n" +
                            "0 - Encerrar\n");
        };

        System.out.println("\nCOFRE ABERTO O QUE DESEJA FAZER ?\n");

        //criado while para persistir no cofre tratando possiveis erros.
        while (cofre) {

            //execultar o menu inicial do cofre;
            exibirMenu.run();

            try {

                opcao = teclado.nextInt();

                switch (opcao) {

                    case 0:
                        teclado.close();
                        cofre = false;
                        break;

                    //case 1 selecionar a moeda que deseja inserir.
                    case 1:

                        boolean moedaValida = false;
                        //while criado até que o usuario digite uma moeda valida;
                        while (!moedaValida) {

                            System.out.println(
                                    "Escolher a Moeda: \n" +
                                            "1 - Real \n" +
                                            "2 - Dolar \n" +
                                            "3 - Euro");

                            moedaSelecionada = teclado.nextInt();

                            Moeda moeda = null;

                            try {

                                switch (moedaSelecionada) {
                                    case 1:
                                        System.out.println("Digite o valor!");
                                        valorMoeda = teclado.nextDouble();
                                        moeda = new Real(valorMoeda, "Real");
                                        moedaValida = true;
                                        break;
                                    case 2:
                                        System.out.println("Digite o valor!");
                                        valorMoeda = teclado.nextDouble();
                                        moeda = new Dolar(valorMoeda, "Dolar");
                                        moedaValida = true;
                                        break;
                                    case 3:
                                        System.out.println("Digite o valor!");
                                        valorMoeda = teclado.nextDouble();
                                        moeda = new Euro(valorMoeda, "Euro");
                                        moedaValida = true;
                                        break;
                                    default:
                                        System.out.println("Selecione uma opção de moeda válida");
                                        continue;
                                }

                                if (moeda != null) {
                                    System.out.println("\nMoeda Adicionada com Sucesso");
                                    listaMoedas.add(moeda);
                                }

                            } catch (Exception e) {
                                System.out.println("Valor inválido. Por favor, digite um número.");
                                teclado.next();
                                continue;
                            }

                        }

                        break;

                    //case para remover uma moeda especifica de acordo com o valor;
                    case 2:
                        System.out.println("Digite o valor da moeda a ser removida:");
                        try {
                            double valorParaRemover = teclado.nextDouble();
                            Moeda moedaParaRemover = null;

                            for (Moeda m : listaMoedas) {
                                if (m.valorMoeda == valorParaRemover) {
                                    moedaParaRemover = m;
                                    break;
                                }
                            }

                            if (moedaParaRemover != null) {
                                listaMoedas.remove(moedaParaRemover);
                                System.out.println("Moeda removida com sucesso!");
                            } else {
                                System.out.println("Moeda não encontrada.");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Valor inválido. Por favor, digite um número.");
                            teclado.next();
                        }
                        break;

                    //case para exibir todas as modas na ordem em que elas foram inseridas;
                    case 3: {
                        for (Moeda m : listaMoedas) {
                            System.out.println(m.toString());
                        }
                        break;
                    }

                    //case para converter as moedas em reais somando todas que já foram inseridas.
                    case 4: {
                        double totalEmReais = calcularTotalEmReais(listaMoedas);
                        System.out.printf("Total em Reais: %.2f\n", totalEmReais);
                        break;

                    }
                    default:
                        break;

                }

            } catch (Exception e) {
                System.out.println("Somente números são aceitos. Por favor, tente novamente.");
                //caso de algum erro ele exibi o menu inicial novamente;
                exibirMenu.run();
                teclado.next();
            }
        }

    }

    //conversor de moeda para reais
    public static double calcularTotalEmReais(ArrayList<Moeda> listaMoedas) {
        double total = 0.0;
        for (Moeda moeda : listaMoedas) {
            total += moeda.calculaValor();
        }
        return total;
    }

}
