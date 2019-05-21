package es.upm.fis2019;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ComandoComentarPublicacion implements IComando {
    private Publicacion publicacion;
    private String texto;

    public ComandoComentarPublicacion(Publicacion publicacion, String texto) {
        this.publicacion = publicacion;
        this.texto = texto;
    }

    @Override
    public void ejecutar() {
        //Date to string
        String pattern = "dd/MM/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        String todayAsString = df.format(today);

        this.publicacion.AniadirComentario(new Comentario(Sesion.getInstance().getUsuario().getAlias()
                                                            , this.texto,todayAsString, "Sin respuesta."));
    }
}
