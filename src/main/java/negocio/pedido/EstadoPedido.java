package negocio.pedido;

import java.io.IOException;

public abstract class EstadoPedido {

    protected Pedido pedido;

    public EstadoPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract void pagar() throws MontoInsuficienteException, IOException, NoSePuedePagarException;

    public abstract void entregar() throws IOException, NoSePuedeEntregarException;

    public abstract void cancelar() throws IOException, NoSePuedeCancelarException;

}
