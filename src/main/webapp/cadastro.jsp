<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!DOCTYPE html>
            <html lang="pt-br">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
                <title>Projeto final</title>
            </head>

            <body>
                <header class="bg-success">
                    <div class="container-fluid">
                        <div class="row mb-5">
                        <div class="col-6">
                          <h2 class="text-light  mt-2 mb-2"> Jeff - Tabela Usuarios</h2>
                        </div>
                          <div class="col-6">
                             <form action="ServletDB" method="post">
                        <button type="submit" name="option" value="indexfrm" class="btn btn-info btn-lg  mt-2 mb-2">Tabela</button>
                   			</form>
                        </div>
                        </div>
                    </div>
                </header>

              
               <div class="container mt-5">
    <div class="row">
      <div class="col-md-5 mx-auto border text-center">
        <h3>Adicionar Usuario</h3>
        <form method="post" action="ServletDB">
          <input type="hidden" name="id" value="${user.id}" />
          <!-- nome -->
          <div class="form-group" style="text-align-last: left;">
            <label for="nome" class="form-label ">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" value="${user.nome}" required>
          </div>
  
          <!-- email -->
          <div class="form-group" style="text-align-last: left;">
            <label for="email">Email:</label>
            <input type="text" class="form-control" id="email" name="email" value="${user.email}" required>
          </div>
          <!-- telefone -->
          <div class="form-group" style="text-align-last: left;">
            <label for="telefone">Telefone:</label>
            <input type="number" class="form-control" id="telefone" name="telefone" value="${user.telefone}" required>
          </div>
          <!-- pais -->
          <div class="form-group" style="text-align-last: left;">
            <label for="pais" class="form-label">Pais:</label>
            <input type="text" class="form-control" id="pais" name="pais" value="${user.pais}" required>
          </div>
  
          <c:choose>
            <c:when test="${user == null}">
              <button type="submit" name="option" value="insert" class="btn btn-primary bt-lg mt-3 mb-3">Cadastar</button>
            </c:when>
            <c:otherwise>
              <button type="submit" name="option" value="update" class="btn btn-info bt-lg mt-3 mb-3">Atualizar</button>
            </c:otherwise>
          </c:choose>
        </form>
      </div>
    </div>
  </div>
               
            </body>

            </html>