package org.iesvdm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        //int[][] carton2 = new int[9][3]

        // Invocamos el método
        Bingo.ponerBlancos(carton);

        for (int[] con: carton){
            //Nos muestra el funcionamiento del metodo. Aunque sale el tablero invertido
            System.out.println(Arrays.toString(con));
        }

    }

    @Test
    // Este metodo busca una posicion de una fila, devuelve true si es -1.
    public void testBuscarFila(){
        //Creamos el carton
        int[][] carton = new int[9][3];

        //Ponemos los blancos:
        Bingo.ponerBlancos(carton);

        for (int[] con: carton){ // Vemos los blancos
            System.out.println(Arrays.toString(con));
        }

        //Comprobamos si es cierto en la primera posicion
        assertTrue(Bingo.buscarFila(carton,0,0));

        //Pasara el test si el primer numero es -1

    }

    @Test
    // Este metodo devuelve true si el valor -1
    public void testBuscarColumna(){
        //Creamos el carton
        int[][] carton = new int[9][3];

        //Ponemos los blancos:
        Bingo.ponerBlancos(carton);

        // Vemos los blancos
        for (int[] con: carton){
            System.out.println(Arrays.toString(con));
        }
    }

    @Test
    public void testbuscarValorRepetido(){
        int[] array = {1, 2, 3, 4, 5};
        assertTrue(Bingo.buscarValorRepetido(array, 3));
        assertFalse(Bingo.buscarValorRepetido(array, 6));
    }
    @Test
    public void testpintarCarton(){
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
    public void testinsertarAlFinal(){
        int[] array = {1, 2, 3};
        int elemento = 4;

        int[] nuevoArray = Bingo.insertarAlFinal(array, elemento);

        // Verificamos que el tamaño del nuevo array es correcto
        assertEquals(array.length + 1, nuevoArray.length);

        // Verificamos que el nuevo elemento está al final del array
        assertEquals(elemento, nuevoArray[nuevoArray.length - 1]);
    }
    @Test
    public void testordenar(){
        int[] array = {5, 1, 4, 2, 3};
        int[] sortedArray = Bingo.ordenar(array);

        int[] expectedArray = {1, 2, 3, 4, 5};

        // Verificamos que el array está ordenado correctamente
        assertArrayEquals(expectedArray, sortedArray);
    }
}
