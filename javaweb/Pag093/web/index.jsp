<%-- 
    Document   : index
    Created on : 10/03/2018, 15:24:23
    Author     : DesenvolvedorJava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Contatos</title>
    </head>
    <body>
        <h1>Cadastro de Contatos</h1>
        <form action="SalvarContatoServlet" method="POST">
            <table border="1" cellpadding="3">
                <tbody>
                    <tr>
                        <td>Nome</td>
                        <td>
                            <input type="text" name="nome" value="" size="80" maxlength="150" />
                        </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>
                            <input type="text" name="email" value="" size="50" maxlength="50" />
                        </td>
                    </tr>
                    <tr>
                        <td>Telefone</td>
                        <td>
                            <input type="text" name="fone" value="" size="50" maxlength="50" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salvar" name="btnSalvar" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
