package org.iesvdm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BingoTest {

    @Test
    public void testRellenarNumerosCarton1() { //Comprueba que la primera columna contiene números del 1 al 9.
        // Crear un cartón vacío
        int[][] carton = new int[9][3];

        // Invocar el método
        Bingo.rellenarNumerosCarton(carton);

        for (int i = 0; i < carton[0].length; i++) {
            assertTrue(carton[0][i] >= 1 && carton[0][i] <= 9);
        }
    }

    @Test
    public void testRellenarNumerosCarton2() { // Comprueba que no haya numeros repetidos
        // Crear un cartón vacío
        int[][] carton = new int[9][3];

        // Invocar el método
        Bingo.rellenarNumerosCarton(carton);

        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                for (int k = j + 1; k < carton[0].length; k++) {
                    assertNotEquals(carton[i][j], carton[i][k]);
                }
            }
        }
    }

    @Test
    public void testPonerBlancos() {
        // Genero los arrays columnas:
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];

        // Los paso a mi matriz o array bidimensional:
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};

        // Invocamos el método
        Bingo.ponerBlancos(carton);

        int totalBlancos = 0;

        for (int[] col : carton) {
            // Verificamos que cada columna no tiene más de 2 blancos
            int countBlancos = 0;
            for (int num : col) {
                if (num == -1) {
                    countBlancos++;
                    totalBlancos++;
                }
            }
            assertTrue(countBlancos <= 2, "Una columna tiene más de 2 blancos");
        }

        // Verificamos que hay un total de 12 blancos en todo el cartón
        assertEquals(12, totalBlancos, "El cartón no tiene 12 blancos");
    }

    @Test
    public void testBuscarFila() {
        // Creamos el carton
        int[][] carton = new int[9][3];

        // Ponemos los blancos
        Bingo.ponerBlancos(carton);

        // Verificamos que el método devuelve true si hay un -1 en la posición especificada
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                if (carton[i][j] == -1) {
                    assertTrue(Bingo.buscarFila(carton, j, i));
                } else {
                    assertFalse(Bingo.buscarFila(carton, j, i));
                }
            }
        }
    }

    @Test
    public void testBuscarColumna() {
        // Creamos el carton
        int[][] carton = new int[9][3];

        // Ponemos los blancos
        Bingo.ponerBlancos(carton);

        // Verificamos que el método devuelve true si hay al menos dos -1 en la columna especificada
        for (int i = 0; i < carton.length; i++) {
            int countBlancos = 0;
            for (int j = 0; j < carton[0].length; j++) {
                if (carton[i][j] == -1) {
                    countBlancos++;
                }
            }
            if (countBlancos >= 2) {
                assertTrue(Bingo.buscarColumna(carton, i));
            } else {
                assertFalse(Bingo.buscarColumna(carton, i));
            }
        }
    }

    @Test
    public void testBuscarValorRepetido() {
        int[] array = {1, 2, 3, 4, 5};
        assertTrue(Bingo.buscarValorRepetido(array, 3));
        assertFalse(Bingo.buscarValorRepetido(array, 6));
    }

    @Test
    public void testPintarCarton() {
        int[][] carton = {
                {1, -1, 3},
                {4, 5, -1},
                {-1, 8, 9}
        };
        int[] bolas = {1, 5, 9};

        int aciertos = Bingo.pintarCarton(carton, bolas);

        // Verificamos que se cuentan correctamente los aciertos
        assertEquals(3, aciertos);
    }

    @Test
    public void testInsertarAlFinal() {
        int[] array = {1, 2, 3};
        int elemento = 4;

        int[] nuevoArray = Bingo.insertarAlFinal(array, elemento);

        // Verificamos que el tamaño del nuevo array es correcto
        assertEquals(array.length + 1, nuevoArray.length);

        // Verificamos que el nuevo elemento está al final del array
        assertEquals(elemento, nuevoArray[nuevoArray.length - 1]);
    }

    @Test
    public void testOrdenar() {
        int[] array = {5, 1, 4, 2, 3};
        int[] sortedArray = Bingo.ordenar(array);

        int[] expectedArray = {1, 2, 3, 4, 5};

        // Verificamos que el array está ordenado correctamente
        assertArrayEquals(expectedArray, sortedArray);
    }
}
