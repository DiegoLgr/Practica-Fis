package es.upm.fis2019;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.*;

public class TestUsuariosCajaNegra {
    Usuario usr;
    private IEjecutador accesobd;
    Texto texto;
    PublicacionTexto publicacion;
    List<IPublicacion> publicaciones;
    String[] queries = {"CREATE TABLE publicacion( 	id varchar(50) primary key, 	likes Int default 0, 	dislikes Int default 0, 	fecha date default CURRENT_TIMESTAMP, 	contenido varchar(140), 	tipo 	varchar(50) check(tipo in ('texto','enlace') not null) ); ", " Create Table usuario( 	alias varchar(50) primary key, 	correo varchar (50), 	contraseña varchar(50) not null ); ", " Create table comentario( 	id varchar(50) primary key, 	texto varchar(140) not null, 	fecha date default CURRENT_TIMESTAMP, 	respuesta varchar(140) ); ", " create table comenta( 	p_id varchar(50) , 	u_id varchar(50) , 	c_id varchar(50) unique , 	foreign key (p_id) references publicacion(id), 	foreign key(u_id) references usuario(alias), 	foreign key(c_id) references comentario(id), 	primary key(p_id,u_id,c_id) ); ", " create table publica( 	u_id varchar, 	p_id varchar unique, 	foreign key (u_id) references usuario(alias), 	foreign key (p_id) references publicacion(id), 	primary key (p_id,u_id) ); ", " create table sigue( 	alias1 varchar, 	alias2 varchar, 	foreign key(alias1) references usuario(alias), 	foreign key(alias2) references usuario(alias), 	primary key(alias1,alias2) ); ", " PRAGMA foreign_keys = ON; ", "  insert into usuario (alias,contraseña) values('Torby','MeGuhtaFran'); ", " insert into usuario (alias,contraseña) values('Fran701','FraCiskito'); ", " insert into usuario (alias,contraseña) values('Siorata','Siorata'); ", " insert into usuario (alias,contraseña) values('Diego','ElDeBest'); ", " insert into usuario (alias,contraseña) values('Alex','VistaMaster'); ", " insert into usuario (alias,contraseña) values('Sezth','skybreaker'); ", "  insert into publicacion(id,tipo,contenido) values('Me voy pa casa','enlace','aaaaaaaaaaaaaaaaa'); ", " insert into publicacion(id,tipo,contenido) values('He comido arroz','enlace','https://www.google.es'); ", " insert into publicacion(id,tipo,contenido) values('Semifinales Gran Prix de Moscú','texto','bbbbbbbbbb'); ", " insert into publicacion(id,tipo,contenido) values('Gran Prix no es de ajedrez','texto','dddddddddd'); ", " insert into publicacion(id,tipo,contenido) values('Patata Caliente','enlace','https://github.com/DiegoLgr/Practica-Fis/tree/master'); ", "  insert into comentario (id,texto) values('c1','1111'); ", " insert into comentario (id,texto) values('c2','2222'); ", " insert into comentario (id,texto) values('c3','3333'); ", " insert into comentario (id,texto) values('c4','4444'); ", " insert into comentario (id,texto) values('c5','5555'); ", "   insert into publica values('Fran701','Me voy pa casa'); ", " insert into publica values('Fran701','He comido arroz'); ", " insert into publica values('Fran701','Semifinales Gran Prix de Moscú'); ", " insert into publica values('Siorata','Gran Prix no es de ajedrez'); ", " insert into publica values('Siorata','Patata Caliente'); ", "  insert into comenta values('Me voy pa casa','Sezth','c1'); ", " insert into comenta values('Me voy pa casa','Sezth','c2'); ", " insert into comenta values('Me voy pa casa','Sezth','c3'); ", " insert into comenta values('Me voy pa casa','Sezth','c4'); ", " insert into sigue values('Fran701','Sezth'); ", " insert into sigue values('Fran701','Torby'); ", " insert into sigue values('Fran701','Siorata'); ", " insert into sigue values('Siorata','Fran701'); ", " insert into sigue values('Siorata','Torby');"};

    private void limpiar() {
        String borrar_usuario = "DELETE FROM usuario WHERE  alias = 'franciscohc';";
        String borrar_publicacion = "DELETE FROM publicacion WHERE  id = 'España';";
        String borrar_publica = "DELETE FROM publica WHERE  u_id = 'franciscohc' AND p_id = 'España';";
        accesobd=Conexion.getInstance();
        accesobd.conectar();
        accesobd.ejecutar(borrar_usuario);
        accesobd.ejecutar(borrar_publicacion);
        accesobd.ejecutar(borrar_publica);
        accesobd.desconectar();
    }

    @Before
    public void setUp() throws Exception {
        accesobd=Conexion.getInstance();
        accesobd.conectar();
        for (String q : queries) {accesobd.ejecutar(q);}
        String query1 = "insert into usuario (alias,correo,contraseña)\n" +
                "values(\"franciscohc\",\"franhc@gmail.com\",\"arribaespaña69\");";
        accesobd.ejecutar(query1);
        accesobd.desconectar();

        usr= new Usuario("franciscohc","franhc@gmail.com","arribaespaña69");
        texto = new Texto("España es el mejor país del mundo.");
        publicacion = new PublicacionTexto("España", 100, 0, texto);
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void getAlias() {
        accesobd.conectar();
        String query="select alias from usuario where alias = '"+usr.getAlias()+"';";
        ResultSet rs = accesobd.ejecutarQuery(query);

        try {
            String alias=rs.getString(1);
            assertEquals(usr.getAlias(), alias);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        accesobd.desconectar();
    }

    @Test
    public void getCorreo() {
        accesobd.conectar();
        String query="select correo from usuario where alias = '"+usr.getAlias()+"';";
        ResultSet rs = accesobd.ejecutarQuery(query);

        try {
            String correo=rs.getString(1);
            assertEquals(usr.getCorreo(), correo);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        accesobd.desconectar();
    }

    @Test
    public void getPublicacionesTimeline() {
    }

    @Test
    public void borrar() {
    }

    private void comparar(ResultSet rs, IPublicacion publicacion) {
        try {
            String aux=rs.getString(6);
            String id=rs.getString(1);
            int likes=rs.getInt(2);
            int dislikes=rs.getInt(3);
            String fecha=rs.getString(4);
            String contenido=rs.getString(5);

            assertEquals(id, publicacion.getId());
            assertEquals(likes, publicacion.getLikes());
            assertEquals(dislikes, publicacion.getDislikes());
            //assertEquals(fecha, publicacion.getFecha());
            assertEquals(contenido, publicacion.getContenido());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getPublicacionesUsuario() {
        String query="select *\n" +
                "from publicacion\n" +
                "where id in (select p_id\n" +
                "from publica pu, usuario u\n" +
                "where u.alias = pu.u_id\n" +
                "and u.alias = '"+usr.getAlias()+"')";
        accesobd.conectar();
        ResultSet rs = accesobd.ejecutarQuery(query);

        publicaciones = usr.GetPublicacionesUsuario("");

        for (IPublicacion p : publicaciones) { comparar(rs, p); }
    }

    @Test
    public void publicar() {
        usr.publicar(publicacion);
        accesobd.conectar();

        String query1="select * from publicacion where id = '"+publicacion.getId()+"';";
        ResultSet rs = accesobd.ejecutarQuery(query1);
        comparar(rs, publicacion);

        accesobd.desconectar();
    }

    @Test
    public void publicar1() {
    }

    @Test
    public void cambiarAlias() {
    }

    @Test
    public void restaurarContrasena() {
    }

    @Test
    public void verificarCredenciales() {
    }

    public static void main(String[] args) throws Exception {
        TestUsuariosCajaNegra test = new TestUsuariosCajaNegra();
        test.limpiar();
        test.setUp();
        test.getAlias();
        test.getCorreo();
        test.publicar();
        test.getPublicacionesUsuario();
    }
}