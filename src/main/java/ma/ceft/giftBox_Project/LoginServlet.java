package ma.ceft.giftBox_Project;

import ma.ceft.DAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    public void init() {


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("action").equals("signout")){
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("/giftBox_Project_war_exploded/");
            return;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO usrdao = new UserDAO();
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");

        if(usrdao.SignIn(username,pwd) != null) {
            session.setAttribute("user",username);
         //   System.out.println(session.getAttribute("user")+"*********************************************++");
            this.getServletContext().getRequestDispatcher("/index").forward(request, response);
           // request.setAttribute("name",username);

        }
        else {
            request.setAttribute("login","failed");
            this.getServletContext().getRequestDispatcher("/index").forward(request, response);
        }
        doGet(request,response);
    }
}
