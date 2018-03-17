<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda de Contatos</title>
        <link href="Estilos/css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Agenda de Contatos</h1>
        <hr />
        <div style="width: 600px">
            <form action="ProcessarContatosServlet" method="POST">
                <h3 class="cabecForm">Contatos</h3>
                <select style="width: 100%" name="contatos" size="10">
                    <option></option>
                    <option></option>
                    <option></option>
                    <option></option>
                    <option></option>
                    <option></option>
                    <option></option>
                    <option></option>
                    <option></option>
                    <option></option>
                </select><br />
                <table style="width: 100%" border="1" cellpadding="3">
                    <tbody>
                        <tr>
                            <td>Nome:</td>
                            <td>
                                <input type="text" name="nome" size="80" maxlength="150" value="${contato.nome}" />
                            </td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td>
                                <input type="text" name="email" size="50" maxlength="150" value="${contato.email}" />
                            </td>
                        </tr>
                        <tr>
                            <td>Telefone:</td>
                            <td>
                                <input type="text" name="fone" size="50" maxlength="150" value="${contato.fone}" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" name="opera" value="Salvar" />
                                <input type="submit" name="limpa" value="Limpar" />
                                <input type="submit" name="opera" value="Excluir" />
                                <input type="submit" name="opera" value="Imprimir" />
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <div style="background-color: #eee; width: 100%"> 
                <h3 class="mensagemErro"> > ${opera} ${erros}</h3>
            </div>
        </div>
    </body>
</html>
