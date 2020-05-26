package com.jalasoft.practice4.modelo;

import java.util.List;
import java.time.LocalDate;
/**
 * @version 1.1
 * @autor Magdalena
 */
public class Pedido {
    private String codPedido;
    private String tipoPedido;
    private String cliente;
    private LocalDate  fecha;
    private List<Detalle> detalleList;

    public Pedido(String codPedido, String tipoPedido, String cliente, String fecha, List<Detalle> detalleList) {
        this.codPedido = codPedido;
        this.tipoPedido = tipoPedido;
        this.cliente = cliente;
        this.fecha = LocalDate.parse(fecha);
        this.detalleList = detalleList;
    }


    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }
}
