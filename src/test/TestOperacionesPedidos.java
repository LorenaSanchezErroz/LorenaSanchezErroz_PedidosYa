package test;


import javabeans.Pedido;
import negocio.OperacionesPedidos;

public class TestOperacionesPedidos {
    public static void main(String[] args) {
        OperacionesPedidos operacionesPedidos = new OperacionesPedidos();

        operacionesPedidos.addPedido(new Pedido("P01", 1, "manzanas", 3));
        operacionesPedidos.addPedido(new Pedido("P02", 2, "peras", 2));
        operacionesPedidos.addPedido(new Pedido("P03", 3, "naranjas", 4));
        operacionesPedidos.addPedido(new Pedido("P04", 4, "plátanos", 2));
        operacionesPedidos.addPedido(new Pedido("P05", 5, "limones", 1));


        //operacionesPedidos.escribirFichero("src/resources/pedidos.csv");
        //operacionesPedidos.escribirObjeto("src/resources/pedidos.dat");

        //operacionesPedidos.leerFichero("src/resources/pedidos.csv");
        //operacionesPedidos.leerObjeto("src/resources/pedidos.dat");

    }
}
