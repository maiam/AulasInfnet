
package br.com.infnet.noticias;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "NoticiasServlet", urlPatterns = {"/NoticiasServlet"})
public class NoticiasServlet extends HttpServlet {

    //--------------------------------------------------------------------------
    //Propriedades da classe
    private String[] noticias = {
        
        "Brasileiros em Marte",
        "Descoberta a Cura do Câncer",
        "Dez Anos sem Guerras no Mundo"
    };
    private int atual;
    private String teste = ""
            + "<form action=\"SalvarContatoServlet\" method=\"POST\">\n" +
"            <table border=\"1\" cellpadding=\"3\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td>Nome</td>\n" +
"                        <td>\n" +
"                            <input type=\"text\" name=\"nome\" value=\"\" size=\"80\" maxlength=\"150\" />\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>Email</td>\n" +
"                        <td>\n" +
"                            <input type=\"text\" name=\"email\" value=\"\" size=\"50\" maxlength=\"50\" />\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>Telefone</td>\n" +
"                        <td>\n" +
"                            <input type=\"text\" name=\"fone\" value=\"\" size=\"50\" maxlength=\"50\" />\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td colspan=\"2\" align=\"center\">\n" +
"                            <input type=\"submit\" value=\"Salvar\" name=\"btnSalvar\" />\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"\n" +
"        </form>";
    //--------------------------------------------------------------------------
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    //--------------------------------------------------------------------------
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Refresh", "5");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NoticiasServlet</title>");            
            out.println("</head>");
            out.println("<body>");
    //--------------------------------------------------------------------------
            HttpSession sessao = request.getSession();
            Integer atual = (Integer) sessao.getAttribute("atual");
            if(atual == null) {
                
                atual = 0;
            };
    //--------------------------------------------------------------------------        
            out.println("<h1>" + noticias[atual] + "</h1>");
            atual++;
            if(atual>=noticias.length){
                
                atual = 0;
            };
            sessao.setAttribute("atual", atual);
    //--------------------------------------------------------------------------        
            out.println(teste);
            out.println("</body>");
            out.println("</html>");
        }
    //--------------------------------------------------------------------------    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
