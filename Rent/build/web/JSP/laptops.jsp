<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.caracteristicas"%>
<%@page import="operaciones.Service"%><%@page import="dao.CaractDAO"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<script>
    function mensajeAgregar() {
        alert("¡Se agrego con exito el Equipo!");
    }
    function msgActualizado() {
        alert("¡Se ha Actualizado con exito la laptop!");
    }
    function msgEliminado() {
        alert("¡Se ha Eliminado con exito!");
    }
</script>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Laptop</title>

    </head>

    <body style="background-color:#B4CBD9;">
        <h1 align="center" style="font-size:42px">Registro de Laptops</h1>

        <div >
            <ul>
                <li><a href=Principal.jsp>Inicio</a></li>
                <li><a href=Clientes.jsp>Agregar Clientes</a></li>
                <li><a href=laptops.jsp>Inventario</a></li>
                <li><a href=ventas.jsp>Ventas</a></li>
                <li><a href=renter.jsp>Registro de Renter</a></li>
            </ul>
        </div> <br>

        <s:form method="post" action="registrarLap">

            <s:textfield name="cara.marca" label="Marca"></s:textfield>
            <s:textfield name="cara.model" label="Modelo"></s:textfield>
            <s:textfield name="cara.cpu" label="Procesador"></s:textfield>
            <s:textfield name="cara.ram" label="Memoria Ram"></s:textfield>
            <s:textfield name="cara.disco" label="Disco Duro"></s:textfield>
            <s:textfield name="cara.tv" label="Tarjeta de Video"></s:textfield>
            <s:textfield name="cara.serie" label="Numero de Serie"></s:textfield>

            <s:submit value="Registrar" onclick="mensajeAgregar()"></s:submit>

        </s:form>

        <h1 align="center" style="font-size:42px">Consultar Equipos</h1>

        <s:form action="ConsultaLap">
            <s:submit value="Consultar" ></s:submit>
        </s:form>

        <table bgcolor="ffffff" width="80%" border="1" bordercolor="#000000" cellspacing="7" cellpadding="7">
            <tr bgcolor="808080">
                <td>ID</td>
                <td>MARCA</td>
                <td>MODELO</td>
                <td>PROCESADOR </td>
                <td>MEMORIA RAM</td>
                <td>DISCO DURO</td>
                <td>TARJETA DE VIDEO</td>
                <td>NUMERO DE SERIE</td>
            </tr>
            <s:iterator value="listaCaract">
                <tr>
                    <td><s:property value="id_car"/></td>
                    <td><s:property value="marca"/></td>
                    <td><s:property value="model"/></td>
                    <td><s:property value="cpu"/></td>
                    <td><s:property value="ram"/></td>
                    <td><s:property value="disco"/></td>
                    <td><s:property value="tv"/></td>
                    <td><s:property value="serie"/></td>
                </tr>
            </s:iterator>
        </table>


        <%--aqui termina dios --%>

        <h1 align="center" style="font-size:42px">Actualizar y Eliminar </h1>
        <div align="left">
            <h1 align="left" style="font-size:20px">Busqueda por ID </h1>

            <s:form action="buscarCaracteristica" method="post">
                <s:textfield name="cara.id_car" label="ID"/>
                <s:submit value="Buscar"/>
            </s:form>

            <br>
            <s:form action="actualizarCaracteristica" method="post">
                <s:iterator value="listaBuscarCaracteristica">
                    <%-- <input type="text" name="correo" value='<s:property value="id_cliente"/>'>  <button type="submit">Update</button>  --%>
                    <b>ID: </b><input type="text" name="cara.id_car" value='<s:property value="id_car"/>'><br>
                    <b>MARCA: </b><input type="text" name="cara.marca" value='<s:property value="marca"/>'><br>
                    <b>MODELO: </b><input type="text" name="cara.model" value='<s:property value="model"/>'><br>
                    <b>PROCESADOR: </b><input type="text" name="cara.cpu" value='<s:property value="cpu"/>'><br>
                    <b>MEMORIA RAM: </b><input type="text" name="cara.ram" value='<s:property value="ram"/>'><br>
                    <b>DISCO DURO: </b><input type="text" name="cara.disco" value='<s:property value="disco"/>'><br>
                    <b>TARJETA DE VIDEO: </b><input type="text" name="cara.tv" value='<s:property value="tv"/>'><br>
                    <b>NUMERO DE SERIE: </b><input type="text" name="cara.serie" value='<s:property value="serie"/>'><br>

                    <s:submit value="Actualizar" onclick="msgActualizado()"/>
                </s:iterator>
            </s:form>
        </div>
        <div align="center">
            <h1 style="font-size:20px">Busqueda por ID para eliminar </h1>

            <s:form action="buscarCaracteristica" method="post">
                <s:textfield name="cara.id_car" label="ID"/>
                <s:submit value="Buscar"/>
            </s:form>
            <br>
            <s:form action="eliminarCaracteristica" method="post">
                <s:iterator value="listaBuscarCaracteristica">
                    <%-- <input type="text" name="correo" value='<s:property value="id_cliente"/>'>  <button type="submit">Update</button>  --%>
                    <b>ID: </b><input type="text" name="cara.id_car" value='<s:property value="id_car"/>'><br>
                    <b>MARCA: </b><input type="text" name="cara.marca" value='<s:property value="marca"/>'><br>
                    <b>MODELO: </b><input type="text" name="cara.model" value='<s:property value="model"/>'><br>
                    <b>PROCESADOR: </b><input type="text" name="cara.cpu" value='<s:property value="cpu"/>'><br>
                    <b>MEMORIA RAM: </b><input type="text" name="cara.ram" value='<s:property value="ram"/>'><br>
                    <b>DISCO DURO: </b><input type="text" name="cara.disco" value='<s:property value="disco"/>'><br>
                    <b>TARJETA DE VIDEO: </b><input type="text" name="cara.tv" value='<s:property value="tv"/>'><br>
                    <b>NUMERO DE SERIE: </b><input type="text" name="cara.serie" value='<s:property value="serie"/>'><br>
                    <s:submit value="Eliminar" onclick="msgEliminado()"/>
                </s:iterator>
            </s:form>
        </div>


    </body>

</html>
