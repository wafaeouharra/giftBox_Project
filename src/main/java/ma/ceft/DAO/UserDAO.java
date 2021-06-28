package ma.ceft.DAO;

import ma.ceft.Models.Client;
import ma.ceft.Models.User;
import ma.ceft.giftBox_Project.MConnection;

import javax.persistence.TypedQuery;
import java.sql.Date;
import java.time.LocalDate;

public class UserDAO {
    MConnection mc =new MConnection();

    public User SignIn(String usrname,String pwd){

        User usr=null;
        try{
            mc.getTr().begin();
            TypedQuery<User> tq = mc.getEm().createNamedQuery("Login",User.class);
            tq.setParameter(1,usrname);
            tq.setParameter(2,pwd);
            if(!tq.getResultList().isEmpty()){
                usr = new User();
                usr.setNomUser(tq.getResultList().get(0).getNomUser());
                mc.getTr().commit();
            }

        }
        finally {
            if(mc.getTr().isActive()){
                mc.getTr().rollback();
            }
            mc.getEm().close();
            mc.getEmf().close();
        }
        return usr;
    }

        public void SignUp(User u){
            try{
                mc.getTr().begin();
                //add new user
                mc.getEm().persist(u);
                mc.getTr().commit();
                mc.getTr().begin();

                //add new Client
               /* Client cl = new Client();
                cl.setNomClient(T[0]);
                cl.setPrenomClient(T[2]);
                cl.setEmail(T[3]);
                cl.setAdresse(T[4]);
                cl.setNumeroTel(Integer.valueOf(T[4].toString()));
                cl.setRegdate(Date.valueOf(LocalDate.now()));
                cl.setIdUser(usr.getIdUser());
                mc.getEm().persist(usr);
                mc.getTr().commit();*/
            }
            finally {
                if(mc.getTr().isActive()){
                    mc.getTr().rollback();
                }
                mc.getEm().close();
                mc.getEmf().close();
            }
        }

}
