<%-- 
    Document   : empleado
    Created on : 5 dic. 2021, 23:15:34
    Author     : profl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Leo Martinez 20754731 &mdash; Trabajo Integrador 2021 - comisión 2 </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Leo Martinez 20754731 - Trabajo Integrador 2021 - comisión 2 " />
    <meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
    <meta name="author" content="FreeHTML5.co" />

    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content="" />
    <meta property="og:image" content="" />
    <meta property="og:url" content="" />
    <meta property="og:site_name" content="" />
    <meta property="og:description" content="" />
    <meta name="twitter:title" content="" />
    <meta name="twitter:image" content="" />
    <meta name="twitter:url" content="" />
    <meta name="twitter:card" content="" />

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="css/icomoon.css">
    <!-- Themify Icons-->
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="css/bootstrap.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="css/magnific-popup.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="css/bootstrap-datepicker.min.css">

    <!-- Owl Carousel  -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <!-- Theme style  -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>

<body>

    <div class="gtco-loader"></div>

    <div id="page">


        <!-- <div class="page-inner"> -->
        <nav class="gtco-nav" role="navigation">
            <div class="gtco-container">

                <div class="row">
                    <div class="col-sm-4 col-xs-12">
                        <div id="gtco-logo"><a href="index.jsp">Agencia POLO <em>.</em></a></div>
                    </div>
                    <div class="col-xs-8 text-right menu-1">
                        <ul>
                            <li><a href="destination.jsp">Destino</a></li>
                            <li class="has-dropdown">
                                <a href="#">Viajes</a>
                                <ul class="dropdown">
                                    <li><a href="#">Exterior</a></li>
                                    <li><a href="#">Argentina</a></li>
                                    <li><a href="#">Turismo</a></li>
                                    <li><a href="#">Directo</a></li>
                                </ul>
                            </li>
                            <li><a href="pricing.jsp">Precios</a></li>
                            <li><a href="contact.jsp">Contacto</a></li>
                            <li class="has-dropdown">
                                <a href="#">Admin</a>
                                <ul class="dropdown">
                                    <li><a href="empleado.jsp">Empleados</a></li>
                                    <li><a href="#">Servicios</a></li>
                                    <li><a href="#">Paquetes</a></li>
                                    <li><a href="#">Ventas</a></li>
                                </ul>
                            </li>

                        </ul>
                    </div>
                </div>


            </div>
        </nav>
        
        <header id="gtco-header" class="gtco-cover gtco-cover-sm" role="banner" style="background-image: url(images/img_emp.jpg)">
            <div class="overlay"></div>
            <div class="gtco-container">
                <div class="row">
                    <div class="col-md-12 col-md-offset-0 text-center">
                        <div class="row row-mt-15em">

                            <div class="col-md-12 mt-text animate-box" data-animate-effect="fadeInUp">
                                <h1>Datos de los Empleados</h1>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </header>        

        
        <div class="gtco-section border-bottom">
            <div class="gtco-container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-6 animate-box">
                            <h3>Get In Touch</h3>
                            <form action="svrEmpleado" method="POST">
                                <div class="row form-group">
                                    <div class="col-md-12">
                                        <label class="sr-only" for="nombre">Nombre</label>
                                        <input type="text" id="nombre" class="form-control" placeholder="ingrese su nombre">
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-12">
                                        <label class="sr-only" for="apellido">Apellido</label>
                                        <input type="text" id="apellido" class="form-control" placeholder="ingrese su apellido">
                                    </div>
                                </div>

                                <div class="row form-group">
                                    <div class="col-md-12">
                                        <label class="sr-only" for="email">Email</label>
                                        <input type="text" id="email" class="form-control" placeholder="su correo electrónico">
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-12">
                                        <label class="sr-only" for="celular">Celular</label>
                                        <input type="text" id="celular" class="form-control" placeholder="su núrmero de celular">
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-12">
                                        <label class="sr-only" for="subject">Subject</label>
                                        <input type="text" id="subject" class="form-control" placeholder="Escriba un motivo">
                                    </div>
                                </div>

                                <div class="row form-group">
                                    <div class="col-md-12">
                                        <label class="sr-only" for="message">Mensaje</label>
                                        <textarea name="message" id="message" cols="30" rows="5" class="form-control" placeholder="Escriba su mensaje o su consulta"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="submit" value="Enviar Mensaje" class="btn btn-primary">
                                </div>

                            </form>
                        </div>
                        <div class="col-md-5 col-md-push-1 animate-box">

                            <div class="gtco-contact-info">
                                <h3>Contact Information</h3>
                                <ul>
                                    <li class="address">Av. Rivadavia 1234, <br>Suite 721 Buenos Aires ARG 1000</li>
                                    <li class="phone"><a href="tel://123456789">+54 1235 2355 9888</a></li>
                                    <li class="email"><a href="mailto:info@agenciapolo.com.ar">info@agenciapolo.com.ar</a></li>
                                    <li class="url"><a href="https://freehtml5.co">FreeHTML5.co</a></li>
                                </ul>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>

        
        <footer id="gtco-footer" role="contentinfo">
            <div class="gtco-container">
                <div class="row row-p	b-md">

                    <div class="col-md-4">
                        <div class="gtco-widget">
                            <h3>Sobre Nosotros</h3>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore eos molestias quod sint ipsum possimus temporibus officia iste perspiciatis consectetur in fugiat repudiandae cum. Totam cupiditate nostrum ut neque ab?</p>
                        </div>
                    </div>

                    <div class="col-md-2 col-md-push-1">
                        <div class="gtco-widget">
                            <h3>Destinos</h3>
                            <ul class="gtco-footer-links">
                                <li><a href="#">Viaje al Exterior</a></li>
                                <li><a href="#">Viejae por Argentina</a></li>
                                <li><a href="#">Turismo Aventura></li>
                                <li><a href="#">Turismo Gastronomico</a></li>
                                <li><a href="#">Viaje Directo</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-2 col-md-push-1">
                        <div class="gtco-widget">
                            <h3>Hotels</h3>
                            <ul class="gtco-footer-links">
                                <li><a href="#">NH Mendoza Cordillera</a></li>
                                <li><a href="#">Sheraton Mendoza</a></li>
                                <li><a href="#">Mercure Iguazu Hotel Iru</a></li>
                                <li><a href="#">Casita Suiza</a></li>
                                <li><a href="#">Loi Suites Iguazú</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-3 col-md-push-1">
                        <div class="gtco-widget">
                            <h3>Contacta a nuestros Operadores</h3>
                            <ul class="gtco-quick-contact">
                                <li><a href="#"><i class="icon-phone"></i> +54 123 456 789</a></li>
                                <li><a href="#"><i class="icon-mail2"></i> info@agenciapolo.com.ar</a></li>
                                <li><a href="#"><i class="icon-chat"></i> Habla por Chat!</a></li>
                            </ul>
                        </div>
                    </div>

                </div>

                <div class="row copyright">
                    <div class="col-md-12">
                        <p class="pull-left">
                            <small class="block">&copy; 2021 Leo Martinez. All Rights Reserved.</small>
                            <small class="block">Diseñando por <a href="https://freehtml5.co/" target="_blank">FreeHTML5.co</a> Composición: <a href="#" target="_blank">Leo Martinez</a> Profesora: <a href="#" target="_blank">Ing. Luisina de Paula</a> </small>
                            <small class="block">Trabajo Inttegrador. Comisión Nº2.</small>
                        </p>
                        <p class="pull-right">
                            <ul class="gtco-social-icons pull-right">
                                <li><a href="#"><i class="icon-twitter"></i></a></li>
                                <li><a href="#"><i class="icon-facebook"></i></a></li>
                                <li><a href="#"><i class="icon-linkedin"></i></a></li>
                                <li><a href="#"><i class="icon-dribbble"></i></a></li>
                            </ul>
                        </p>
                    </div>
                </div>

            </div>
        </footer>
        <!-- </div> -->

    </div>

    <div class="gototop js-top">
        <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
    </div>

    <!-- jQuery -->
    <script src="js/jquery.min.js"></script>
    <!-- jQuery Easing -->
    <script src="js/jquery.easing.1.3.js"></script>
    <!-- Bootstrap -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Waypoints -->
    <script src="js/jquery.waypoints.min.js"></script>
    <!-- Carousel -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- countTo -->
    <script src="js/jquery.countTo.js"></script>

    <!-- Stellar Parallax -->
    <script src="js/jquery.stellar.min.js"></script>

    <!-- Magnific Popup -->
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/magnific-popup-options.js"></script>

    <!-- Datepicker -->
    <script src="js/bootstrap-datepicker.min.js"></script>


    <!-- Main -->
    <script src="js/main.js"></script>

</body>

</html>