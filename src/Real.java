public class Real extends Moeda {

    public Real(double valorMoeda, String nomeMoeda) {
        super(valorMoeda, nomeMoeda);
    }

    @Override
    double calculaValor() {
        return valorMoeda;
    }

    @Override
    public String toString() {
        return nomeMoeda + ": " + valorMoeda;
    }

}
