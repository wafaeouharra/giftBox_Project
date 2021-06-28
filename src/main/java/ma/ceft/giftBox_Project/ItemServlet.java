package ma.ceft.giftBox_Project;



import ma.ceft.DAO.ProduitDAO;
import ma.ceft.Models.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/item")
public class ItemServlet extends HttpServlet {
    private Produit produit;
    private ProduitDAO produitDAO;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            produitDAO = new ProduitDAO();
            int id_produit = Integer.parseInt(req.getParameter("id_produit"));
            HttpSession session=req.getSession(false);
            String email=(String) session.getAttribute("email");
            req.setAttribute("User",email);
             req.setAttribute("Item", produitDAO.ProductById(id_produit));
            this.getServletContext().getRequestDispatcher( "/single.jsp" ).forward( req, resp );
        }
        catch (Exception e){

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }
}
