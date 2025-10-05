package negocio;


import javabeans.Pedido;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OperacionesPedidos {

    Scanner lector = new Scanner(System.in);
    boolean fallo = false;
    boolean crear;

    ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();

    public void addPedido (Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public void escribirFichero(String path) {
        File file = new File(path);
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);
            pw.println("id, clienteId, producto, cantidad");
            for (Pedido cliente : listaPedidos) {
                pw.println(cliente);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe. ¿Quieres crearlo");
            crear = lector.nextBoolean();
            if (crear) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    System.out.println("No tienes permisos para crear ficheros");
                }
            }
        } catch (IOException e) {
            System.out.println("No tienes permisos de escritura");
        } finally {
            try{
                pw.close();
            } catch (NullPointerException e) {
                System.out.println("Error en el cerrado de fichero");
            }
        }
        System.out.println("Escritura de fichero realizada con éxito");
    }

    public void escribirObjeto(String path) {
        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        do {
            try {
                fos = new FileOutputStream(file);

            } catch (FileNotFoundException e) {
                System.out.println("El fichero no existe. ¿Quieres crearlo?");
                crear = lector.nextBoolean();
                if (crear) {
                    fallo = true;
                    try {
                        file.createNewFile();
                    } catch (IOException ex) {
                        System.out.println("No tienes permisos para crear ficheros");
                    }
                }
            }
        } while (fallo);

        try {
            oos = new ObjectOutputStream(fos);
            for (Pedido pedido : listaPedidos) {
                oos.writeObject(pedido);
            }
        } catch (IOException e) {
            System.out.println("No tienes permisos de escritura");
        } finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado de fichero");
            }
        }
        System.out.println("Escritura del objeto realizada con éxito");
    }

    public void leerFichero(String path) {
        File file = new File(path);
        FileReader reader = null;

        try {
            String registro = null;
            reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            registro = bufferedReader.readLine();

            while(registro != null) {
                System.out.println(registro);
                registro = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero");
        } catch (IOException e) {
            System.out.println("No se puede realizar la lectura");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("No se ha podido cerrar la lectura");
            }
        }
    }

    public void leerObjeto(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            System.out.println("id, clienteId, producto, cantidad");
            for(Pedido pedido :listaPedidos) {
                 pedido = (Pedido) ois.readObject();
                System.out.println(pedido.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("No tienes permisos de lectura");
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error en la clase de lectura");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado de fichero");
            }
        }
    }

}


