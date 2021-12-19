<%-- 
    Document   : useradmin.jsp
    Created on : 17 dic. 2021, 16:33:56
    Author     : Leo Martinez
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.*" session="true"%> 
<%@page import="java.util.Date"%>
<!doctype html>
<html lang="es">

    <head>

        <!-- Required meta tags -->
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Leo Martinez 20754731 ✨ Trabajo Integrador 2021 - comisión 2 </title>
        <meta name="description" content="Leo Martinez 20754731 - Trabajo Integrador 2021 - comisión 2 " />
        <meta name="keywords" content="free website templates, free html5, free template, free bootstrap, 
              free website template, html5, css3, mobile first, responsive" />
        <meta name="author" content="LeoMartinez" />

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/styleuser.css">
    </head>

    <body>
        <% //HttpSession sesion = request.getSession();%>
        <%
            String user = (String) request.getSession().getAttribute("user");
            String pass = (String) request.getSession().getAttribute("pass");
            
            
        %>
        <section class="h-100 gradient-form" style="background-color: #eee;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-xl-10">
                        <div class="card rounded-3 text-black">
                            <div class="row g-0">
                                <div class="col-lg-6">
                                    <div class="card-body p-md-5 mx-md-4">

                                        <div class="text-center">
                                            <img src="images/logo.png" style="width: 185px;" alt="logo">
                                            <h4 class="mt-1 mb-5 pb-1">CREAR UN ADMINISTRADOR</h4>
                                        </div>

                                        <form action="SvCrearAdmin"  method="POST">
                                            <p>Datos del Adminsitrador</p>
                                            
                                            <div class="form-outline mb-4">
                                                <input type="text" id="frmNombre" name="frmNombre" 
                                                       class="form-control" placeholder="Nombre de la Persona" />
                                                <label class="form-label" for="frmNombre">Nombre</label>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <input type="text" id="frmApellido" name="frmApellido" 
                                                       class="form-control" placeholder="Apellido de la Persona" />
                                                <label class="form-label" for="forApellido">Apellido</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="text" id="frmDomicilio" name="frmDomicilio" 
                                                       class="form-control" placeholder="Domicilio de la Persona" />
                                                <label class="form-label" for="frmDomicilio">Domicilio</label>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <input type="text" id="frmDNI" name="frmDNI" class="form-control" placeholder="DNI de la Persona" />
                                                <label class="form-label" for="frmDNI">DNI</label>
                                            </div>


                                            <div class="form-outline mb-4">
                                                <input type="text" id="frmNacional" name="frmNacional" class="form-control" placeholder="Nacionalidad de la Persona" />
                                                <label class="form-label" for="frmNacional">Nacionalidad </label>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <input type="text" id="frmCelular" name="frmCelular" class="form-control" placeholder="Celular de la Persona" />
                                                <label class="form-label" for="frmCelular">Celular </label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="email" id="frmEmail" name="frmEmail" class="form-control" placeholder="Correo Electrónico de la Persona" />
                                                <label class="form-label" for="frmEmail">Correo Electrónico </label>
                                            </div>



                                            <div class="text-center pt-1 mb-5 pb-1">
                                              <input class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" 
                                                     type="submit" value="Guardar Admin">
                                                <!-- <a class="text-muted" href="#!">Recupera Contraseña</a> -->
                                            </div>



                                        </form>

                                    </div>
                                </div>
                                <div class="col-lg-6 d-flex align-items-top gradient-custom-2">
                                    <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                                        <h4 class="mb-4">We are more than just a company</h4>

                                        <p>Creación de la Sessión :
                                            <% Date momento = new Date(request.getSession().getCreationTime());

                                                out.println(momento);%></p>
                                        <hr>
                                        <p >Usuario    :<span class="h5" ><%= user %> </span> </p>
                                        <p >Contraseña :<span class="h5" ><%= pass %> </span> </p>
                                        <p></p>
                                        <p class="small mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                            consequat.
                                        </p>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>

</html>