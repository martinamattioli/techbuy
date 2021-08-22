package negocio.componente;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComboTest {

    static Combo combo;

    @BeforeClass
    public static void init(){
        Producto primerProducto = new Producto("Samsung S21", "Celular de alta gama",
                new Foto(),200, 4);
        Producto segundoProducto = new Producto("iPhone 12 Pro Max", "Celular de alta gama",
                new Foto(), 300,  2);
        Producto tercerProducto = new Producto("Poco X3 Pro", "Celular de gama media",
                new Foto(),150,  35);
        combo = new Combo("Combo de celulares", "El mejor combo",
                new Foto());
        combo.agregarComponente(primerProducto);
        combo.agregarComponente(segundoProducto);
        combo.agregarComponente(tercerProducto);
    }

    @Test
    public void testElPrecioDelComboEsLaSumaDelDeSusComponentes(){
        Assert.assertEquals(650, combo.getPrecio().intValue());
    }

    @Test
    public void testElPrecioDelComboConOtroComboAdentroEsLaSumaDeAmbos(){
        Producto primerProducto = new Producto("Samsung S21", "Celular de alta gama",
                new Foto(),1000,  4);
        Producto segundoProducto = new Producto("iPhone 12 Pro Max","Celular de alta gama",
                new Foto(),350,  2);
        Combo otroCombo = new Combo("Combo de celulares 2", "El mejor combo 2",
                new Foto());
        otroCombo.agregarComponente(primerProducto);
        otroCombo.agregarComponente(segundoProducto);
        combo.agregarComponente(otroCombo);
        Assert.assertEquals(2000, combo.getPrecio().intValue());
    }

}
