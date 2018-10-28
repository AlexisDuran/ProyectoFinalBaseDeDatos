<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.cliente"%>
<%@page import="operaciones.Service"%>
<%@page import="dao.ClienteDAO"%><%----%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<script>
    function mensajeAgregarCliente() {
        alert("¡Se ha agregado con exito al cliente!");
    }
    function msgActualizado() {
        alert("¡Se ha Actualizado con exito el cliente!");
    }
    function msgEliminado() {
        alert("¡Se ha Eliminado con exito el cliente!");
    }
</script>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Clientes</title>

    </head>
    <body style="background-color:#B4CBD9;">
        <h1 align="center" style="font-size:42px">Agregar Clientes</h1>

        <div >
            <ul>
                <li><a href=Principal.jsp>Inicio</a></li>
                <li><a href=Clientes.jsp>Agregar Clientes</a></li>
                <li><a href=laptops.jsp>Inventario</a></li>
                <li><a href=ventas.jsp>Ventas</a></li>
                <li><a href=renter.jsp>Registro de Renter</a></li>
            </ul>
        </div> <br>

        <s:form method="post" action="registrar">
            <s:textfield name="client.nombre" label="Nombre"/>
            <s:textfield name="client.rfc" label="RFC"/>
            <s:textfield name="client.direccion" label="Dirección"/>
            <s:textfield name="client.telefono" label="Telefono"/>
            <s:textfield name="client.correo" label="Correo"/>
            <s:submit value="Registrar" onclick="mensajeAgregarCliente()"/>
        </s:form>

        <%--
                <div align="left">
                    <h1 style="font-size:30px">Actualización</h1>
                    <b>ID:        </b><input type="text"  name="nombre" value='<s:property value="client.id_cliente"/>'>
                </div>
        --%>

        <h1 align="center" style="font-size:42px">Consulta</h1>

        <s:form action="Consultar">
            <s:submit value="Consultar" ></s:submit>
        </s:form>

        <table bgcolor="ffffff" width="80%" border="1" bordercolor="#000000" cellspacing="7" cellpadding="7">
            <tr bgcolor="808080">
                <td>ID</td>
                <td>Nombre</td>
                <td>RFC</td>
                <td>Direccón</td>
                <td>Teléfono</td>
                <td>Correo</td>

            </tr>
            <s:iterator value="lista">
                <tr>    <%--   <input type="text" name="correo" value='<s:property value="correo"/>'>  <button type="submit">Update</button>  --%>
                    <td><s:property value="id_cliente"/></td>
                    <td><s:property value="nombre"/></td>
                    <td><s:property value="rfc"/></td>
                    <td><s:property value="direccion"/></td>
                    <td><s:property value="telefono"/></td>
                    <td><s:property value="correo"/></td>

                </tr>
            </s:iterator>
        </table>


        <h1 align="center" style="font-size:42px">Actualizar y Eliminar </h1>
        <div align="left">
            <h1 align="left" style="font-size:20px">Busqueda por ID </h1>

            <s:form action="buscarCliente" method="post">
                <s:textfield name="client.id_cliente" label="ID"/>
                <s:submit value="Buscar"/>
            </s:form>
            <br>
            <s:form action="actualizarCliente" method="post">
                <s:iterator value="listaBuscarCliente">
                    <%-- <input type="text" name="correo" value='<s:property value="id_cliente"/>'>  <button type="submit">Update</button>  --%>
                    <b>ID: </b><input type="text" name="client.id_cliente" value='<s:property value="id_cliente"/>'><br>
                    <b>Nombre: </b><input type="text" name="client.nombre" value='<s:property value="nombre"/>'><br>
                    <b>RFC: </b><input type="text" name="client.rfc" value='<s:property value="rfc"/>'><br>
                    <b>Dirección: </b><input type="text" name="client.direccion" value='<s:property value="direccion"/>'><br>
                    <b>Telefono: </b><input type="text" name="client.telefono" value='<s:property value="telefono"/>'><br>
                    <b>Correo: </b><input type="text" name="client.correo" value='<s:property value="correo"/>'><br>
                    <s:submit value="Actualizar" onclick="msgActualizado()"/>
                </s:iterator>
            </s:form>
        </div>
        <div align="center">
            <h1 style="font-size:20px">Busqueda por ID para eliminar </h1>

            <s:form action="buscarCliente" method="post">
                <s:textfield name="client.id_cliente" label="ID"/>
                <s:submit value="Buscar"/>
            </s:form>
            <br>
            <s:form action="eliminarCliente" method="post">
                <s:iterator value="listaBuscarCliente">
                    <%-- <input type="text" name="correo" value='<s:property value="id_cliente"/>'>  <button type="submit">Update</button>  --%>
                    <b>ID: </b><input type="text" name="client.id_cliente" value='<s:property value="id_cliente"/>'><br>
                    <b>Nombre: </b><input type="text" name="client.nombre" value='<s:property value="nombre"/>'><br>
                    <b>RFC: </b><input type="text" name="client.rfc" value='<s:property value="rfc"/>'><br>
                    <b>Dirección: </b><input type="text" name="client.direccion" value='<s:property value="direccion"/>'><br>
                    <b>Telefono: </b><input type="text" name="client.telefono" value='<s:property value="telefono"/>'><br>
                    <b>Correo: </b><input type="text" name="client.correo" value='<s:property value="correo"/>'><br>
                    <s:submit value="Eliminar" onclick="msgEliminado()"/>
                </s:iterator>
            </s:form>
        </div>



    </body>
</html>



<%--
    <td style="background: #CCCCCC"><s:property/></td>
<s:submit value="Actualizar" onclick="mensaje2()"></s:submit><s:submit value="Eliminar" onclick="mensaje3()"></s:submit>
--%>

<%--
<s:property value="id_cliente"/>
    <s:textfield name="client.id_cliente" value='<s:property value="id_cliente"/>'/>

--%>