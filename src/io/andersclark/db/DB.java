package io.andersclark.db;

import io.andersclark.models.Customer;
import java.sql.PreparedStatement;

public abstract class DB {
    public static PreparedStatement prep(String SQLQuery){
        return Database.getInstance().prepareStatement(SQLQuery);
    }
    public static Customer getCustomerByName(String firstname, String lastname){

        Customer result = null;

        PreparedStatement ps = prep("SELECT * FROM customers WHERE firstname = ? AND lastname = ?");

        try {
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            result = (Customer)new ObjectMapper<>(Customer.class).mapOne(ps.executeQuery());
        } catch (Exception e) { e.printStackTrace(); }

        return result;
    }

}
