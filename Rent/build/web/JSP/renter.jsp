<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.renter"%>
<%@page import="operaciones.Service"%>
<%@page import="dao.renterDAO"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<script>
    function mensaje() {
        alert("¡Se ha registrado con exito!");
    }
    function msgActualizado() {
        alert("¡Se ha Actualizado con exito al Renter!");
    }
    function msgEliminado() {
        alert("¡Se ha Eliminado con exito el Renter!");
    }
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>

    <body style="background-color:#B4CBD9;">
        <h1 align="center" style="font-size:42px">Registrar Renter</h1>

        <div >
            <ul>
                <li><a href=Principal.jsp>Inicio</a></li>
                <li><a href=Clientes.jsp>Agregar Clientes</a></li>
                <li><a href=laptops.jsp>Inventario</a></li>
                <li><a href=ventas.jsp>Ventas</a></li>
                <li><a href=renter.jsp>Registro de Renter</a></li>
            </ul>
        </div> <br>

        <s:form method="post" action="registrarRenter">
            <s:textfield name="rent.nombre" label="Nombre"></s:textfield>
            <s:textfield name="rent.correo" label="Correo"></s:textfield>
            <s:submit value="Registrar" onclick="mensaje()"></s:submit>
        </s:form>

        <h1 align="center" style="font-size:42px">Consulta</h1>

        <s:form action="consultaRenter">
            <s:submit value="Consultar" ></s:submit>
        </s:form>

        <table bgcolor="ffffff" width="80%" border="1" bordercolor="#000000" cellspacing="7" cellpadding="7">
            <tr bgcolor="808080">
                <td>ID</td>
                <td>NOMBRE</td>
                <td>CORREO</td>
            </tr>
            <s:iterator value="listaRenter">
                <tr>
                    <td><s:property value="id_user"></s:property></td>
                    <td><s:property value="nombre"></s:property></td>
                    <td><s:property value="correo"></s:property></td>

                    </tr>
            </s:iterator>
        </table>



        <%--aqui termina dios --%>

        <h1 align="center" style="font-size:42px">Actualizar y Eliminar </h1>
        <div align="left">
            <h1 align="left" style="font-size:20px">Busqueda por ID </h1>

            <s:form action="buscarRenter" method="post">
                <s:textfield name="rent.id_user" label="ID"/>
                <s:submit value="Buscar"/>
            </s:form>
            <br>
            <s:form action="actualizarRenter" method="post">
                <s:iterator value="listaBuscarRenter">
                    <%-- <input type="text" name="correo" value='<s:property value="id_cliente"/>'>  <button type="submit">Update</button>  --%>
                    <b>ID: </b><input type="text" name="rent.id_user" value='<s:property value="id_user"/>'><br>
                    <b>Nombre: </b><input type="text" name="rent.nombre" value='<s:property value="nombre"/>'><br>
                    <b>Correo: </b><input type="text" name="rent.correo" value='<s:property value="correo"/>'><br>
                    <s:submit value="Actualizar" onclick="msgActualizado()"/>
                </s:iterator>
            </s:form>
        </div>
        <div align="center">
            <h1 style="font-size:20px">Busqueda por ID para eliminar </h1>

            <s:form action="buscarRenter" method="post">
                <s:textfield name="rent.id_user" label="ID"/>
                <s:submit value="Buscar"/>
            </s:form>
            <br>
            <s:form action="eliminarRenter" method="post">
                <s:iterator value="listaBuscarRenter">
                    <%-- <input type="text" name="correo" value='<s:property value="id_cliente"/>'>  <button type="submit">Update</button>  --%>
                    <b>ID: </b><input type="text" name="rent.id_user" value='<s:property value="id_user"/>'><br>
                    <b>Nombre: </b><input type="text" name="rent.nombre" value='<s:property value="nombre"/>'><br>
                    <b>Correo: </b><input type="text" name="rent.correo" value='<s:property value="correo"/>'><br>
                    <s:submit value="Eliminar" onclick="msgEliminado()"/>
                </s:iterator>
            </s:form>
        </div>

    </body>
</html>
