package ma.ceft.giftBox_Project;

import ma.ceft.DAO.ProduitDAO;
import ma.ceft.DAO.UserDAO;
import ma.ceft.Models.Produit;
import ma.ceft.Models.User;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")

public class HelloServlet extends HttpServlet {

        ProduitDAO prddao;
    public void init() {
        prddao = new ProduitDAO();

    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

        req.setAttribute("ProduitsHomme", prddao.AllProductsByCat(1));
        req.setAttribute("ProduitsFemme", prddao.AllProductsByCat(2));
        req.setAttribute("ProduitsKids", prddao.AllProductsByCat(3));


        this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( req, resp );
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request,response);

    }
    public void destroy() {
    }
}