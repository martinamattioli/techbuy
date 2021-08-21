package negocio.organizacion;

import negocio.cliente.Cliente;
import negocio.cliente.TipoDeDocumento;
import negocio.cliente.Ubicacion;
import negocio.componente.Componente;
import negocio.envio.TipoDeEnvio;
import negocio.pedido.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private static Organizacion instance = null;
    private String nombre;
    private List<Componente> catalogo;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;

    private Organizacion(){
        nombre = null;
        catalogo = new ArrayList<Componente>();
        clientes = new ArrayList<Cliente>();
        pedidos = new ArrayList<Pedido>();
    }

    public static Organizacion getInstance(){
        if(instance == null){
            instance = new Organizacion();
        }
        return instance;
    }

    // INICIO - GETTER & SETTER

    public List<Componente> getCatalogo() {
        return catalogo;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // FIN - GETTER & SETTER

    public void agregarProducto(Componente componente){
        catalogo.add(componente);
    }

    public void removerProducto(Componente componente){
        catalogo.remove(componente);
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void registrarCliente(String nombreCompleto, String mail, TipoDeDocumento tipoDeDocumento,
                                 String nroDeDocumento, String direccion, Ubicacion ubicacion){
        this.agregarCliente(new Cliente(nombreCompleto, mail, tipoDeDocumento, nroDeDocumento, direccion, ubicacion));
    }

    public void registrarPedido(Cliente cliente, Componente componente, TipoDeEnvio tipoDeEnvio){
        pedidos.add(new Pedido(cliente, LocalDate.now(), componente, tipoDeEnvio));
    }

}
