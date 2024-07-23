import java.util.ArrayList;

public abstract class Moeda {
    double valorMoeda;
    String nomeMoeda;

    public Moeda(double valorMoeda,String nomeMoeda) {
        super();
        this.valorMoeda = valorMoeda;
        this.nomeMoeda = nomeMoeda;
    }

    ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();

    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
    }

    public void remover(Moeda moeda) {
        listaMoedas.remove(moeda);
    }

    public void listar() {

        for (Moeda moeda : listaMoedas) {
            System.out.println(moeda);
        }
    }

    public static double calcularTotalEmReais(ArrayList<Moeda> listaMoedas) {
        double total = 0.0;
        for (Moeda moeda : listaMoedas) {
            total += moeda.calculaValor();
        }
        return total;
    }

    
    abstract double calculaValor();
}