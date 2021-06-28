package ma.ceft.giftBox_Project;

import ma.ceft.DAO.ProduitDAO;
import ma.ceft.Models.Produit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/produit")
public class ProductServlet extends HttpServlet {

    ProduitDAO prddao = new ProduitDAO();
    Produit produit = new Produit();
    private List<Produit> produits ;
    List<Produit> produitsParCat;
    @Override
    public void init() throws ServletException {
        produits = new ArrayList<>();
        prddao = new ProduitDAO();
        produitsParCat = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            if(req.getParameter("action").equals("showBycat")){
                produitsParCat = prddao.AllProductsByCat(Integer.parseInt(req.getParameter("id_cat")));
            //    HttpSession session=req.getSession(false);
              //  String email=(String) session.getAttribute("email");
               // req.setAttribute("User",email);
                int idcat = Integer.parseInt(req.getParameter("id_cat"));
                req.setAttribute("Products", prddao.AllProductsByCat(idcat));
                if(idcat==1){
                    this.getServletContext().getRequestDispatcher( "/mens.jsp" ).forward( req, resp );
                }else if(idcat==2){
                    this.getServletContext().getRequestDispatcher( "/womens.jsp" ).forward( req, resp );
                }
                else {
                    this.getServletContext().getRequestDispatcher( "/kids.jsp" ).forward( req, resp );
                }
            }
            if(req.getParameter("action").equals("add")){
                HttpSession session=req.getSession(false);
                String email=(String) session.getAttribute("email");
                req.setAttribute("User",email);
                this.getServletContext().getRequestDispatcher( "/AddProduct.jsp" ).forward( req, resp );
            }

        } catch (NullPointerException throwables) {

            HttpSession session=req.getSession(false);
            req.setAttribute("ProduitsHomme", prddao.AllProductsByCat(1));
            req.setAttribute("ProduitsFemme", prddao.AllProductsByCat(2));
            req.setAttribute("ProduitsKids", prddao.AllProductsByCat(3));


            this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( req, resp );
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            int idcat = Integer.parseInt(request.getParameter("idcat"));
            String libelle = request.getParameter("libelle");
            String marque = request.getParameter("marque");
            float prix = Float.parseFloat(request.getParameter("prix"));
            String Description = request.getParameter("description");
            int disponibilite = Integer.parseInt(request.getParameter("dispo"));
            int qtestck = Integer.parseInt(request.getParameter("qtestck"));

            produit = new Produit();
            produit.setLibelle(libelle);
            produit.setIdCategorie(idcat);
            produit.setMarque(marque);
            produit.setPrix(prix);
            produit.setDescription(Description);
            produit.setDisponibilite((byte)disponibilite);
            produit.setQteStock(qtestck);
            produit.setImage("b3");
            prddao.AjouterProduit(produit);

            HttpSession session=request.getSession(false);
            String email=(String) session.getAttribute("email");
            request.setAttribute("User",email);
            this.getServletContext().getRequestDispatcher
                    ( "/index.jsp" ).forward( request, response );

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
