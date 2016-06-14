package hibernate

import grails.plugin.bcrypt.BCrypt
import org.hibernate.Criteria
import org.hibernate.Transaction
import org.hibernate.classic.Session
import org.hibernate.criterion.Restrictions

import grails.plugin.*
//import org.mindrot.BCrypt;
/**
 * Created by Junaid on 6/12/2016.
 */
public class RdbHelper {

    public addUser(){
        Session session = HibernateUtil.sessionFactory.openSession()
        Transaction tx = session.beginTransaction()
        UserEntity u = new UserEntity();
        u.setUserName("grailsuser1")
        u.setUserId(8)
        session.save u
        tx.commit()
        session.close()

        return "user saved"
    }


    public String signIn(String userName, String password) throws Exception{
        Session session = null
        UserEntity user = null;
        try{
            session = HibernateUtil.sessionFactory.openSession()
            Criteria crit = session.createCriteria(UserEntity.class);
            crit.add(Restrictions.eq("userName", userName));
            if(crit.list().size()>0){
                user = (UserEntity) crit.list().get(0);
                if(checkPassword(password, user.getPassword())){

                    System.out.println("User LoggedIn : "+ user.getName());
                    user.setUserFetchStatus("Success");
                    return user.getUserName();
                }else{
                    System.out.println("User Login Attempt failed "+ user.getName());
                    UserEntity noUser = new UserEntity();
                    noUser.setUserFetchStatus("username/password not matched");
                    return noUser.getUserName();
                }
            }else{
                UserEntity noUser = new UserEntity();
                noUser.setUserFetchStatus("user not found");
                return noUser.getUserFetchStatus();
            }
        }catch(Exception ex){
            System.out.println("Exception occured in signIn"+ ex.getMessage());
            throw new Exception("Exception occured in signIn");
        }
    }

        public static boolean checkPassword(String password_plaintext, String stored_hash) {
            boolean password_verified = false;

            if(null == stored_hash)
                throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

            password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

            return(password_verified);
        }
}
