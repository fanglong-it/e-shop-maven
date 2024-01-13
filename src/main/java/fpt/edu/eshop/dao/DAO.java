/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.edu.eshop.dao;

import entity.Account;
import fpt.edu.eshop.dao.MyDAO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
//TANG DAN PRICE
//select * from Product where price < 700
//order by price asc


public class DAO extends MyDAO { //Đổi tên đúng với entity !

  
    

    public Account login(String user, String pass) {
        String query = "select * from Account where [user] = ? and [password] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt("id"),
                        rs.getString("user"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("phone"),
                        rs.getString("describe"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        Account a = dao.login("longpc", "longpc");
        System.out.println(a.toString());
    }
}

