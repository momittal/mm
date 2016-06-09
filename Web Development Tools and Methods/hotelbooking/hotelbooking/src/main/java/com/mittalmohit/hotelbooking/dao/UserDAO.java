package com.mittalmohit.hotelbooking.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.mittalmohit.hotelbooking.dao.DAO;
import com.mittalmohit.hotelbooking.exception.AdException;
import com.mittalmohit.hotelbooking.pojo.User;
import com.mittalmohit.hotelbooking.pojo.Address;
import com.mittalmohit.hotelbooking.pojo.Hotel;
import com.mittalmohit.hotelbooking.pojo.UserAccount;
public class UserDAO extends DAO {

    public UserDAO() {
    }

    public UserAccount getUserAccount(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from UserAccount where userName = :username");
            q.setString("username", username);
            UserAccount userAccount = (UserAccount) q.uniqueResult();
            commit();
            return userAccount;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
    
    
    public UserAccount authenticateUserAccount(String username, String password, String userrole)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from UserAccount where userName = :username and password = :password and userRole = :userrole");
            q.setString("username", username);
            q.setString("password", password);
            q.setString("userrole", userrole);
            UserAccount userAccount = (UserAccount) q.uniqueResult();
            commit();
            return userAccount;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

    public User create(String firstName, String lastName,String emailId, long phoneNumber,String username, String password, String userRole)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
            UserAccount userAccount = new UserAccount(username, password, userRole);
            User user=new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phoneNumber);
            user.setEmail(emailId);
            user.setUserAccount(userAccount);
            userAccount.setUser(user);
            getSession().save(user);
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();    
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
    
    
    public User update(UserAccount userAccount, String firstName, String lastName,String emailId, long phoneNumber,String username, String password, String userRole)
            throws AdException {
        try {
            begin();
            System.out.println("updating ");
            
//            Query query = getSession().getNamedQuery("getUserAccountByUserName");
//            query.setString("userName",username);
//            UserAccount userAccount = (UserAccount)query.uniqueResult();
            
            User user = userAccount.getUser();
            
            
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phoneNumber);
            user.setEmail(emailId);
            user.setUserAccount(userAccount);
            userAccount.setUser(user);
            getSession().update(user);
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();    
            throw new AdException("Exception while updating user: " + e.getMessage());
        }
    }

    public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while deleting user: " + e.getMessage());
        }
    }
}
