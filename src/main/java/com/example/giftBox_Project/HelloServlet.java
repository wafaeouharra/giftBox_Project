package com.example.giftBox_Project;

import com.example.entities.User;

import java.io.*;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private List<User> message;

    public void init() {

        MConnection mc =new MConnection();
        try{
            mc.getTr().begin();
            //add new user
            /*User usr =new User();
            usr.setIdUser(0);
            usr.setActive((byte)1);
            usr.setNomUser("user2");
            usr.setPwd("123");
            usr.setIdRole(1);
             mc.getEm().persist(usr);*/

            TypedQuery<User> tq = mc.getEm().createNamedQuery("allUsers",User.class);

            message = tq.getResultList();
            mc.getTr().commit();
        }
        finally {
            if(mc.getTr().isActive()){
                mc.getTr().rollback();
            }
            mc.getEm().close();
            mc.getEmf().close();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html");

        // Hello
        request.setAttribute("msg",message);
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}