package Formas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PinturaTest {
    @Test
    public void testCalcularPintura() {
        Pintura pintura = new Pintura(10);
        Esfera esfera = new Esfera(5);
        Rectangulo rectangulo = new Rectangulo("Rectangulo",4, 6);
        Cilindro cilindro = new Cilindro("Cilindro",3, 7);

        assertEquals(esfera.area() / pintura.cobertura, pintura.cantidadPint(esfera), 0.01);
        assertEquals(rectangulo.area() / pintura.cobertura, pintura.cantidadPint(rectangulo), 0.01);
        assertEquals(cilindro.area() / pintura.cobertura, pintura.cantidadPint(cilindro), 0.01);
    }
}
