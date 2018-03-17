package br.com.infnet.web.moedas;

import br.com.infnet.moedas.Moeda;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "ConversorServlet", urlPatterns = {"/ConversorServlet"})
public class ConversorServlet extends HttpServlet {

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
        
        //----------------------------------------------------------------------
        //Obter os dados
        String svalor = request.getParameter("valor");
        String tipo = request.getParameter("tipo");
        //----------------------------------------------------------------------
        //Validar os dados
        if(StringUtils.isNumeric(svalor) && StringUtils.isNotBlank(tipo)) {
            
            double valor = Double.parseDouble(svalor);
        //----------------------------------------------------------------------
        //Processar a requisição
            Moeda moeda = new Moeda();
            switch(tipo) {
                
                case "Real":
                    moeda.setReal(valor);
                    break;
                case "Dolar":
                    moeda.setDolar(valor);
                    break;
                case "Euro":
                    moeda.setEuro(valor);
                    break;
            }//switch
        //----------------------------------------------------------------------
        //Incluir o JavaBean na requisição
        request.setAttribute("moeda", moeda);
        }//if
        //----------------------------------------------------------------------
        //Redirecionar
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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
