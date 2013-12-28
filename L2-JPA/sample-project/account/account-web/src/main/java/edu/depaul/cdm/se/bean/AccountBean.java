package edu.depaul.cdm.se.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.sql.DataSource;

@SessionScoped
@Named
public class AccountBean implements Serializable {
    private static final Logger logger = Logger.getLogger(AccountBean.class.getName());
    
    @Resource(name="jdbc/SE554")
    private DataSource ds;
    
    public List<Account> getAccountList() throws SQLException {
        System.out.println("getAccountList");
        logger.info("Before getting connection");
        Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from ACCOUNTS");
        ResultSet result = ps.executeQuery();
        logger.info("After executing query");
        
        List<Account> list = new ArrayList();
        
        while (result.next()) {
            Account a = new Account();
            a.setId(result.getInt("id"));
            a.setName(result.getString("nm"));
            a.setBalance(result.getFloat("balance"));
            list.add(a);
        }
        
        logger.info("Before returning");
        
        return list;
    }
}
