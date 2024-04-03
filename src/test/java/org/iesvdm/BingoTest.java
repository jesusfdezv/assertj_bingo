package org.iesvdm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BingoTest {
    @Test
    public void testRellenarNumerosCarton_columnaUno() {
        // Crear un cartón vacío
        int[][] carton = new int[3][9];

        // Invocar el método a probar
        Bingo.rellenarNumerosCarton(carton);

        // Comprobar que la columna 1 contiene números del 1 al 9
        for (int i = 0; i < carton[0].length; i++) {
            assertTrue(carton[0][i] >= 1 && carton[0][i] <= 9);
        }
    }
}
