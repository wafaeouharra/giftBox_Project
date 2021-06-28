package ma.ceft.DAO;

import ma.ceft.Models.Produit;
import ma.ceft.Models.User;
import ma.ceft.giftBox_Project.MConnection;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProduitDAO {


    public void AjouterProduit(Produit pr){
        MConnection mc =new MConnection();
        mc.getTr().begin();
        //add new product
        mc.getEm().persist(pr);
        mc.getTr().commit();
        mc.getTr().begin();
    }

    public List<Produit> AllProducts(){
        MConnection mc =new MConnection();
        try{
            mc.getTr().begin();

            TypedQuery<Produit> tq = mc.getEm().createNamedQuery("allProducts",Produit.class);
            List<Produit> Products = tq.getResultList();
            mc.getTr().commit();
            return Products;
        }
        finally {
            if(mc.getTr().isActive()){
                mc.getTr().rollback();
            }
            mc.getEm().close();
            mc.getEmf().close();
        }
    }

    public List<Produit> AllProductsByCat(int id){
        MConnection mc =new MConnection();
        try{
            mc.getTr().begin();

            TypedQuery<Produit> tq = mc.getEm().createNamedQuery("allProductsByCat",Produit.class);
            tq.setParameter(1,id);
            List<Produit> Products = tq.getResultList();
            mc.getTr().commit();
            return Products;
        }
        finally {
            if(mc.getTr().isActive()){
                mc.getTr().rollback();
            }
            mc.getEm().close();
            mc.getEmf().close();
        }
    }

    public Produit ProductById(int id){

        MConnection mc =new MConnection();
        try{
            mc.getTr().begin();

            TypedQuery<Produit> tq = mc.getEm().createNamedQuery("productById",Produit.class);
            tq.setParameter(1,id);
            Produit Product = tq.getSingleResult();
            mc.getTr().commit();
            return Product;
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
