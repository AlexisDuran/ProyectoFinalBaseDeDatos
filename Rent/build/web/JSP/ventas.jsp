<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.venta"%>
<%@page import="operaciones.Service"%>
<%@page import="dao.VentaDAO"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<script>
    function mensaje() {
        alert("¡Se ha generado la venta con Exito!");
    }
    function msgActualizado() {
        alert("¡Se ha Actualizado con exito el Contrato!");
    }
    function msgEliminado() {
        alert("¡Se ha Eliminado con exito!");
    }
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
    </head>
    <body style="background-color:#B4CBD9;">
        <h1 align="center" style="font-size:42px">Registro de Ventas</h1>
        <div >
            <ul>
                <li><a href=Principal.jsp>Inicio</a></li>
                <li><a href=Clientes.jsp>Agregar Clientes</a></li>
                <li><a href=laptops.jsp>Inventario</a></li>
                <li><a href=ventas.jsp>Ventas</a></li>
                <li><a href=renter.jsp>Registro de Renter</a></li>
            </ul>
        </div> <br>
        <h1 aling="left" style="font-size:26px">Ingresar Fechas de contratos y costo Total de Renta</h1>

        <s:form method="post" action="registrarVenta">
            <%--
            <label for="party-time">Fecha & Hora de Inicio: </label>
            <input type="datetime-local" value="2017-06-01T08:30"><br><br>
            <label for="party-time">Fecha & Hora de Entrega: </label>
            <input type="datetime-local" value="2017-06-01T08:30"><br>
            --%>
            <label >Fecha con formato YYYY-MM-DD  </label>    <br>
            <s:textfield name="venta.date_inicio" label="Fecha de Inicio"></s:textfield>   <br>
            <s:textfield name="venta.date_fin" label="Fecha de Entrega"></s:textfield>  <br>
            <s:textfield name="venta.total" label="Total"></s:textfield>    <br>



            <s:submit value="Registrar Venta" onclick="mensaje()"></s:submit>

        </s:form>


        <h1 align="center" style="font-size:42px">Consultar Ventas </h1>

        <s:form action="consultaVenta">
            <s:submit value="Consultar" ></s:submit>
        </s:form>

        <table bgcolor="ffffff" width="80%" border="1" bordercolor="#000000" cellspacing="7" cellpadding="7">
            <tr bgcolor="808080">
                <td>ID</td>
                <td>FECHA DE INICIO</td>
                <td>FECHA DE ENTREGA</td>
                <td>TOTAL</td>

            </tr>
            <s:iterator value="listaVenta">
                <tr>
                    <td><s:property value="id_venta"></s:property></td>
                    <td><s:property value="date_inicio"></s:property></td>
                    <td><s:property value="date_fin"></s:property></td>
                    <td><s:property value="total"></s:property></td>

                    </tr>
            </s:iterator>
        </table>



        <%--aqui termina dios --%>

        <h1 align="center" style="font-size:42px">Actualizar y Eliminar </h1>
        <div align="left">
            <h1 align="left" style="font-size:20px">Busqueda por ID </h1>

            <s:form action="buscarVenta" method="post">
                <s:textfield name="venta.id_venta" label="ID"/>
                <s:submit value="Buscar"/>
            </s:form>
            <br>
            <s:form action="actualizarVenta" method="post">
                <s:iterator value="listaBuscarVenta">
                    <%-- <input type="text" name="correo" value='<s:property value="id_cliente"/>'>  <button type="submit">Update</button>  --%>
                    <b>ID: </b><input type="text" name="venta.id_venta" value='<s:property value="id_venta"/>'><br>
                    <b>FECHA DE INICIO: </b><input type="text" name="venta.date_inicio" value='<s:property value="date_inicio"/>'><br>
                    <b>FECHA DE ENTREGA: </b><input type="text" name="venta.date_fin" value='<s:property value="date_fin"/>'><br>
                    <b>TOTAL: </b><input type="text" name="venta.total" value='<s:property value="total"/>'><br>

                    <s:submit value="Actualizar" onclick="msgActualizado()"/>
                </s:iterator>
            </s:form>
        </div>
        <div align="center">
            <h1 style="font-size:20px">Busqueda por ID para eliminar </h1>

            <s:form action="buscarVenta" method="post">
                <s:textfield name="venta.id_venta" label="ID"/>
                <s:submit value="Buscar"/>
            </s:form>
            <br>
            <s:form action="eliminarVenta" method="post">
                <s:iterator value="listaBuscarVenta">
                    <%-- <input type="text" name="correo" value='<s:property value="id_cliente"/>'>  <button type="submit">Update</button>  --%>
                    <b>ID: </b><input type="text" name="venta.id_venta" value='<s:property value="id_venta"/>'><br>
                    <b>FECHA DE INICIO: </b><input type="text" name="venta.date_inicio" value='<s:property value="date_inicio"/>'><br>
                    <b>FECHA DE ENTREGA: </b><input type="text" name="venta.date_fin" value='<s:property value="date_fin"/>'><br>
                    <b>TOTAL: </b><input type="text" name="venta.total" value='<s:property value="total"/>'><br>

                    <s:submit value="Eliminar" onclick="msgEliminado()"/>
                </s:iterator>
            </s:form>
        </div>


    </body>
</html>
