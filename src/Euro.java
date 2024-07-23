public class Euro extends Moeda {
    private static final double TAXA_CONVERSAO_PARA_REAL = 6.07;

    public Euro(double valorMoeda, String nomeMoeda) {
        super(valorMoeda, nomeMoeda);
    }

    @Override
    double calculaValor() {
        return valorMoeda * TAXA_CONVERSAO_PARA_REAL;
    }

    public double converterParaReal() {
        return calculaValor();
    }

    @Override
    public String toString() {
        return nomeMoeda + ": " + valorMoeda;
    }
}
