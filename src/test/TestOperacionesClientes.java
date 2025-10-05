package test;

import javabeans.Cliente;
import negocio.OperacionesClientes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestOperacionesClientes {
    public static void main(String[] args) {

        OperacionesClientes operacionCliente = new OperacionesClientes();

        operacionCliente.addCliente(new Cliente(1, "Pedro", "pedro@correo.com"));
        operacionCliente.addCliente(new Cliente(2, "Ana", "ana@correo.com"));
        operacionCliente.addCliente(new Cliente(3, "Cristina", "cris@correo.com"));

        //operacionCliente.escribirFichero("src/resources/clientes.csv");
        //operacionCliente.escribirObjeto("src/resources/clientes.dat");

        //operacionCliente.leerFichero("src/resources/clientes.csv");
        operacionCliente.leerObjeto("src/resources/clientes.dat");


    }



}
