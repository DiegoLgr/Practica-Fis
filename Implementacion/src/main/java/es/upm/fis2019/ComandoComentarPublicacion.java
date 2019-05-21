package es.upm.fis2019;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ComandoComentarPublicacion implements IComando {
    private IComentable publicacion;
    private String texto;

    public ComandoComentarPublicacion(IComentable publicacion, String texto) {
        this.publicacion = publicacion;
        this.texto = texto;
    }

    @Override
    public void ejecutar() {
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        String todayAsString = df.format(today);

        this.publicacion.Comentar(todayAsString,this.texto);

    }
}
