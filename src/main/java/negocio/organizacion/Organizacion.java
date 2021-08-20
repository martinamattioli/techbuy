package negocio.organizacion;

import negocio.cliente.Cliente;
import negocio.cliente.TipoDeDocumento;
import negocio.componente.Componente;
import negocio.envio.Moto;
import negocio.envio.TipoDeEnvio;
import negocio.venta.Venta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private static Organizacion instance = null;
    private String nombre;
    private List<Componente> catalogo;
    private List<Cliente> clientes;
    private List<Venta> ventas;

    private Organizacion(){
        nombre = null;
        catalogo = new ArrayList<Componente>();
        clientes = new ArrayList<Cliente>();
    }

    public static Organizacion getInstance(){
        if(instance == null){
            instance = new Organizacion();
        }
        return instance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProducto(Componente componente){
        catalogo.add(componente);
    }

    public void removerProducto(Componente componente){
        catalogo.remove(componente);
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void registrarCliente(String nombreCompleto, String mail, String telefono, TipoDeDocumento tipoDeDocumento,
                                 String nroDeDocumento){
        this.agregarCliente(new Cliente(nombreCompleto, mail, telefono, tipoDeDocumento, nroDeDocumento));
    }

    public void registrarVenta(Cliente cliente, Componente componente, TipoDeEnvio tipoDeEnvio){
        ventas.add(new Venta(cliente, LocalDate.now(), componente, tipoDeEnvio));
    }

}