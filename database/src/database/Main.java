/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

/**
 *
 * @author ychabcho
 */
import java.sql.*;

public class Main
{
  Connection conn;

  public static void main(String[] args)
  {
    new Main();
  }

  public Main()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      String url = "jdbc:mysql://localhost/coffeebreak";
      conn = DriverManager.getConnection(url, "root", "");
      doTests();
      conn.close();
    }
    catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
    catch (IllegalAccessException ex) {System.err.println(ex.getMessage());}
    catch (InstantiationException ex) {System.err.println(ex.getMessage());}
    catch (SQLException ex)           {System.err.println(ex.getMessage());}
  }



  private void doTests()
  {
    doDeleteAll();
    doInsert("Chocolat",5);
    doInsert("Cappucino",3);
    doUpdateTest("Chocolat",10);
    doSelectTest();
    
    doUpdatePrice("Cappucino",2);
    doSelectTest();
    
    doDeleteCondition(6);
    doSelectTest();
    doDeleteAll();
    doSelectTest();
  }

  private void doSelectTest()
  {
    System.out.println("[OUTPUT FROM SELECT]");
    String query = "SELECT taste, price FROM coffees";
    try
    {
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(query);
      while (rs.next())
      {
        String s = rs.getString("taste");
        float n = rs.getFloat("price");
        System.out.println(s + "   " + n);
      }
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }

  private void doInsert(String name, int price)
  {
    System.out.print("\n[Performing INSERT] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("INSERT INTO coffees " +
                       "VALUES ('"+name+"', "+price+")");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }

  private void doUpdateTest(String taste, int price)
  {
    System.out.print("\n[Performing UPDATE] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("UPDATE coffees SET price="+price+" WHERE taste='"+taste+"'");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }
  
  private void doUpdatePrice(String taste, int priceToAdd)
  {
    String query = "SELECT price FROM coffees WHERE taste='"+taste+"'";
    float price = 0;
    try
    {
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(query);
      while (rs.next())
      {
        price = rs.getFloat("price")+priceToAdd;
      }
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }  
      
    System.out.print("\n[Performing UPDATE] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("UPDATE coffees SET price="+price+" WHERE taste='"+taste+"'");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }
  
  private void doDeleteAll()
  {
    System.out.print("\n[Performing DELETE] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("DELETE FROM coffees");
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }
  
  private void doDeleteCondition(int maxPrice)
  {
    System.out.print("\n[Performing DELETE] ... ");
    try
    {
      Statement st = conn.createStatement();
      st.executeUpdate("DELETE FROM coffees WHERE price > "+maxPrice);
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
    }
  }
}