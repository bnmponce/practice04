package com.jalasoft.practice4;

import com.jalasoft.practice4.modelo.Detalle;
import com.jalasoft.practice4.modelo.Pedido;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class Main {
    public static void main (String [] args) {
        Detalle detalle1 = new Detalle("cod1", "cocina", 2, 1000, 10);
        Detalle detalle2 = new Detalle("cod2", "lavadora", 1, 2500, 0);
        Detalle detalle3 = new Detalle("cod3", "plancha", 5, 300, 50);
        Detalle detalle4 = new Detalle("cod4", "mesa", 2, 700, 30);
        Detalle detalle5 = new Detalle("cod5", "muebles", 1, 3500, 0);
        Detalle detalle6 = new Detalle("cod6", "comoda", 3, 800, 100);
        Detalle detalle7 = new Detalle("cod7", "camisa", 10, 100, 100);
        Detalle detalle8 = new Detalle("cod8", "polera", 20, 80, 0);
        Detalle detalle9 = new Detalle("cod9", "zapatos", 8, 400, 200);

        List<Detalle> detalleList1 = new ArrayList<>();
        detalleList1.add(detalle1);
        detalleList1.add(detalle2);
        detalleList1.add(detalle3);

        List<Detalle> detalleList2 = new ArrayList<>();
        detalleList2.add(detalle4);
        detalleList2.add(detalle5);
        detalleList2.add(detalle6);

        List<Detalle> detalleList3 = new ArrayList<>();
        detalleList3.add(detalle7);
        detalleList3.add(detalle8);
        detalleList3.add(detalle9);

        Pedido pedido1 = new Pedido("ped1", "normal", "Juan Perez",
                "2020-05-05", detalleList1);
        Pedido pedido2 = new Pedido("ped2", "programado", "Maria Guaman",
                "2020-05-03", detalleList2);
        Pedido pedido3 = new Pedido("ped3", "normal", "Juan Perez",
                "2020-05-10", detalleList3);

        List<Pedido> pedidoList = new ArrayList<>();
        pedidoList.add(pedido1);
        pedidoList.add(pedido2);
        pedidoList.add(pedido3);

        System.out.println("1. Select cliente from Pedido");
        pedidoList.stream()
                .map(pedido -> pedido.getCliente())
                .forEach(value -> System.out.println(value));

        System.out.println("2. Select cliente from Pedido where tipoPedido = normal");
        pedidoList.stream()
                .filter(pedido -> pedido.getTipoPedido() == "normal")
                .map(pedido -> pedido.getCliente())
                .forEach(value -> System.out.println(value));

        System.out.println("3. Select codPedido from Pedido where fecha = 2020-05-05");
        pedidoList.stream()
                .filter(pedido -> pedido.getFecha().isEqual(LocalDate.parse("2020-05-05")))
                .map(pedido -> pedido.getCodPedido())
                .forEach(value -> System.out.println(value));

        System.out.println("4. Select producto from Detalle, Pedido where Pedido.codPedido = Detalle.codPedido and \n" +
                "Pedido.codPedido = ped1");
        pedidoList.stream()
                .filter(pedido -> pedido.getCodPedido() == "ped1")
                .map(pedido -> pedido.getDetalleList())
                .flatMap(detalle -> detalle.stream())
                .map(detalle -> detalle.getProducto())
                .forEach(value -> System.out.println(value));

        System.out.println("5. Select Detalle.producto from Detalle, Pedido where Pedido.codPedido = Detalle.codPedido\n" +
                "and Detalle.cantidad > 8");
        pedidoList.stream()
                .map(pedido -> pedido.getDetalleList())
                .flatMap(detalles -> detalles.stream())
                .filter(detalle -> detalle.getCantidad() > 8)
                .map(detalle -> detalle.getProducto())
                .forEach(value -> System.out.println(value));
    }

}
