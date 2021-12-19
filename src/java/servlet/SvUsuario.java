package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polo.logica.Controladora;

/**
 *
 * @author profl
 */
@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

    Controladora ctrl = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("frmNombre");
        String password = request.getParameter("frmPassword");
        String empleado = request.getParameter("empleado");

        request.getSession().setAttribute("user", usuario);
        request.getSession().setAttribute("pass", password);

//        HttpSession miSession = request.getSession();
//        miSession.setAttribute("usuario", usuario);
//        miSession.setAttribute("password", password);
        String pagina = "noverificado.jsp";

        switch (empleado) {

            case "Admin":
                if (ctrl.verificarAdmin(usuario, password)) {
                    pagina = "crearJefe.jsp";
                } else {
                    pagina = "crearAdmin.jsp";
                }
                break;
            case "Jefe":
                if (ctrl.verificarJefe(usuario, password)) {
                    pagina = "crearEstructura.jsp";
                }
                break;
            case "Vendedor":
                if (ctrl.verificarVendedor(usuario, password)) {
                    pagina = "principal.jsp";
                }
                break;
        }
        
        response.sendRedirect(pagina);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
