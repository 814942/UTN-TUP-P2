import java.util.ArrayList;

public class Sucursal {
    private ArrayList<Instrumento> instrumentos;

    private void absolutoAPorcentaje(double[] porcentajes) {
        for (int i = 0; i < porcentajes.length; i++) {
            porcentajes[i] = (porcentajes[i] * 100) / instrumentos.size();
        }
    }

    public double[] porcInstrumentosPorTipo() {
        final int CANT_INSTRUMENTOS = TipoInstrumento.values().length;
        double[] porcentajes = new double[CANT_INSTRUMENTOS];
        System.out.println(porcentajes);
        for (Instrumento instrumento : instrumentos) {
            porcentajes[instrumento.getTipo().ordinal()]++;
        }

        absolutoAPorcentaje(porcentajes);

        return porcentajes;
    }
}