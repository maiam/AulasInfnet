package br.com.infnet.web.contatos;

import br.com.infnet.contatos.Contato;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author DesenvolvedorJava
 */
@WebServlet(name = "ProcessarContatosServlet", urlPatterns = {"/ProcessarContatosServlet"})
public class ProcessarContatosServlet extends HttpServlet {

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
        //1oPasso: Obter os dados do Formulário
        String opera = request.getParameter("opera");
        switch(opera) {
            
            case "Salvar":
                this.salvar(request, response);
                break;
            case "Excluir":
            //    this.excluir(request, response);
                break;
            case "Imprimir":
            //    this.imprimir(request, response);
                break;
            case "Obter":
            //    this.imprimir(request, response);
                break; 
        }
        
        
        //----------------------------------------------------------------------
        //Redirecionamento para a página de destino
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

    private void salvar (HttpServletRequest request, HttpServletResponse response) {
    
        //----------------------------------------------------------------------
        //1oPasso: Obter os dados do formulário
        Contato contato = new Contato();
        contato.setNome(request.getParameter("nome"));
        contato.setEmail(request.getParameter("email"));
        contato.setFone(request.getParameter("fone"));
        request.setAttribute("contato", contato);
        //----------------------------------------------------------------------
        //2oPasso: Validações
        ArrayList<String> erros = new ArrayList<>();
        //isBlank testa se é nulo e/ou vazio
        if(StringUtils.isBlank(contato.getNome())) {
            
            erros.add("O campo Nome é obrigatório.");
        }
        if(StringUtils.isBlank(contato.getEmail())) {
            
            erros.add("O campo Email é obrigatório.");
        }
        if(StringUtils.isBlank(contato.getFone())) {
            
            erros.add("O campo Fone é obrigatório.");
        }
        //----------------------------------------------------------------------
        //3oPasso: Processar a requisição
        if(erros.isEmpty()) {
            
            
        } else {
            
            request.setAttribute("erros", erros);
        }
        //----------------------------------------------------------------------
        
    }
}
