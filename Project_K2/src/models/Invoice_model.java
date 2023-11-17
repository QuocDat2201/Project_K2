package models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entites.Invoices;
import entites.ProductTopsaler;
import entites.Products;


public class Invoice_model {
	public boolean Create(Invoices invoices) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into invoices( InvoiceDate, CustomerName,CustomerPhone, Status,Total) values(?,?,?,?,?)");
			
			preparedStatement.setDate(1, new java.sql.Date(invoices.getInvoiceDate().getTime()));
			preparedStatement.setString(2, invoices.getCustomerName());
			preparedStatement.setString(3, invoices.getCustomerPhone());
			preparedStatement.setBoolean(4, invoices.isStatus());
			preparedStatement.setBigDecimal(5, invoices.getTotal());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	public List<Double> findtotal() {
		List<Double> total = new ArrayList<Double>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT SUM(i.Total)as total FROM invoices i JOIN sales s ON i.InvoiceID=s.Invoice_id JOIN products p ON s.ProductID = p.ProductID JOIN category c ON p.Category_id= c.CategoryID GROUP BY c.CategoryName;");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				total.add(resultSet.getDouble("total"));
			}
		} catch (Exception e) {
			total = null;
		} finally {
			ConnectDB.disconnect();
		}
		return total;
	}
	public List<String> findtotalcategogy() {
		List<String> cate = new ArrayList<String>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT SUM(i.Total)as total,c.CategoryName as catename FROM invoices i JOIN sales s ON i.InvoiceID=s.Invoice_id JOIN products p ON s.ProductID = p.ProductID JOIN category c ON p.Category_id= c.CategoryID GROUP BY c.CategoryName;");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				cate.add(resultSet.getString("catename"));
			}
		} catch (Exception e) {
			cate = null;
		} finally {
			ConnectDB.disconnect();
		}
		return cate;
	}
	public List<Invoices> findAll() {
		List<Invoices> invoices = new ArrayList<Invoices>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from invoices order by InvoiceID desc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Invoices invoice = new Invoices();
				invoice.setInvoiceID(resultSet.getInt("InvoiceID"));
				invoice.setInvoiceDate(resultSet.getDate("InvoiceDate"));
				invoice.setCustomerName(resultSet.getString("CustomerName"));
				invoice.setCustomerPhone(resultSet.getString("CustomerPhone"));
				invoice.setStatus(resultSet.getBoolean("Status"));
				invoice.setTotal(resultSet.getBigDecimal("Total"));
				invoices.add(invoice);
			}
		} catch (Exception e) {
			invoices = null;
		} finally {
			ConnectDB.disconnect();
		}
		return invoices;
	}
	public Invoices findID(int id) {
		Invoices invoice = new Invoices();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from invoices where InvoiceID=?");// java.sql
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
			
				invoice.setInvoiceID(resultSet.getInt("InvoiceID"));
				invoice.setInvoiceDate(resultSet.getDate("InvoiceDate"));
				invoice.setCustomerName(resultSet.getString("CustomerName"));
				invoice.setCustomerPhone(resultSet.getString("CustomerPhone"));
				invoice.setStatus(resultSet.getBoolean("Status"));
				invoice.setTotal(resultSet.getBigDecimal("Total"));
				
			}
		} catch (Exception e) {
			invoice = null;
		} finally {
			ConnectDB.disconnect();
		}
		return invoice;
	}
	public Invoices findAllsort() {
		Invoices invoices = new Invoices();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from invoices order by InvoiceID desc limit 1;");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {
				invoices.setInvoiceID(resultSet.getInt("InvoiceID"));
				invoices.setInvoiceDate(resultSet.getDate("InvoiceDate"));
				invoices.setCustomerName(resultSet.getString("CustomerName"));
				invoices.setCustomerPhone(resultSet.getString("CustomerPhone"));
				invoices.setStatus(resultSet.getBoolean("Status"));
				invoices.setTotal(resultSet.getBigDecimal("Total"));
			}
			
		} catch (Exception e) {
			invoices = null;
		} finally {
			ConnectDB.disconnect();
		}
		return invoices;
	}

    public Map<String, Object> findProductMap(String name, int month) {
        Map<String, Object> map = new HashMap<>();
        List<Date> dates = new ArrayList<Date>();
        List<Double> values = new ArrayList<Double>();
        List<String> nameProduct = new ArrayList<String>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.connection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement("SELECT SUM(s.Quantity * s.Price) as Total, i.InvoiceDate, p.ProductName FROM invoices i JOIN sales s ON i.InvoiceID = s.Invoice_id JOIN products p ON s.ProductID = p.ProductID WHERE p.ProductName = ? and MONTH(i.InvoiceDate) = ? GROUP BY p.ProductName, i.InvoiceDate;");
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, month);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    dates.add(resultSet.getDate("InvoiceDate"));
                    values.add(resultSet.getDouble("Total"));
                    System.out.println(dates.get(0));
                    nameProduct.add(resultSet.getString("ProductName"));
                }

                map.put("dates", dates);
                List<Date> a= (List<Date>) map.get("dates");
                map.put("values", values);
                map.put("nameproducts", nameProduct);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Hoặc xử lý ngoại lệ theo cách khác
        } finally {
            // Đóng PreparedStatement và ResultSet
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Hoặc xử lý ngoại lệ theo cách khác
            }

            // Ngắt kết nối
            ConnectDB.disconnect();

            // Kiểm tra và xử lý map
            if (map.isEmpty()) {
                map = null;
            }
        }
        return map;
    }
	
	
	public boolean update(Invoices invoices){
		boolean result = true  ; 
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement
					("update invoices set status = ? where InvoiceID = ?");//java.sql
			preparedStatement.setBoolean(1, invoices.isStatus());
			preparedStatement.setInt(2, invoices.getInvoiceID());
			result = preparedStatement.executeUpdate()>0 ; //tu hieu luon :)) la neu them dc thi so dong se tang 
		} catch (Exception e) {
			e.printStackTrace();
			 result = false ; 
		}finally {
			ConnectDB.disconnect();
		} return result; 
	}
	 public Map<String, Object> findRevenueMap( int month) {
	        Map<String, Object> map = new HashMap<>();
	        List<Date> dates = new ArrayList<Date>();
	        List<Double> values = new ArrayList<Double>();
	       
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        try {
	            connection = ConnectDB.connection();

	            if (connection != null) {
	                preparedStatement = connection.prepareStatement("	SELECT SUM(s.Quantity * s.Price) as Total, i.InvoiceDate, p.ProductName FROM invoices i JOIN sales s ON i.InvoiceID = s.Invoice_id JOIN products p ON s.ProductID = p.ProductID where MONTH(i.InvoiceDate) = ? GROUP BY i.InvoiceDate;");
	                preparedStatement.setInt(1, month);
	                resultSet = preparedStatement.executeQuery();

	                while (resultSet.next()) {
	                    dates.add(resultSet.getDate("InvoiceDate"));
	                    values.add(resultSet.getDouble("Total"));
	                   
	                    
	                }

	                map.put("dates", dates);
	                List<Date> a= (List<Date>) map.get("dates");
	                map.put("values", values);
	         
	            }

	        } catch (SQLException e) {
	            e.printStackTrace(); // Hoặc xử lý ngoại lệ theo cách khác
	        } finally {
	            // Đóng PreparedStatement và ResultSet
	            try {
	                if (preparedStatement != null) {
	                    preparedStatement.close();
	                }
	                if (resultSet != null) {
	                    resultSet.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace(); // Hoặc xử lý ngoại lệ theo cách khác
	            }

	            // Ngắt kết nối
	            ConnectDB.disconnect();

	            // Kiểm tra và xử lý map
	            if (map.isEmpty()) {
	                map = null;
	            }
	        }
	        return map;
	    }
	 public List<ProductTopsaler > findAllTopsalers() {
		List<ProductTopsaler>	 invoices = new ArrayList<ProductTopsaler>();
			try {
				PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT sum(s.Quantity * s.Price) AS total,s.Product_name as name,sum( s.Quantity) as quantity FROM sales s JOIN invoices i on s.Invoice_id=i.InvoiceID WHERE i.InvoiceDate>= CURDATE() - INTERVAL 30 DAY GROUP BY s.ProductID ORDER BY `quantity` DESC ;");// java.sql
				ResultSet resultSet = preparedStatement.executeQuery();// java.sql
				while (resultSet.next()) {
					ProductTopsaler productTopsaler=new ProductTopsaler();
					productTopsaler.setNameString(resultSet.getString("name"));
					productTopsaler.setQuantity(resultSet.getInt("quantity"));
					productTopsaler.setTotalBigDecimal(resultSet.getBigDecimal("total"));
				invoices.add(productTopsaler);
				}
				
			} catch (Exception e) {
				invoices = null;
			} finally {
				ConnectDB.disconnect();
			}
			return invoices;
		}
	 public List<ProductTopsaler > findAllTopsalersfull() {
			List<ProductTopsaler>	 invoices = new ArrayList<ProductTopsaler>();
				try {
					PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT sum(s.Quantity * s.Price) AS total,s.Product_name as name,sum( s.Quantity) as quantity FROM sales s GROUP BY s.ProductID ORDER BY `quantity` DESC ;");// java.sql
					ResultSet resultSet = preparedStatement.executeQuery();// java.sql
					while (resultSet.next()) {
						ProductTopsaler productTopsaler=new ProductTopsaler();
						productTopsaler.setNameString(resultSet.getString("name"));
						productTopsaler.setQuantity(resultSet.getInt("quantity"));
						productTopsaler.setTotalBigDecimal(resultSet.getBigDecimal("total"));
					invoices.add(productTopsaler);
					}
					
				} catch (Exception e) {
					invoices = null;
				} finally {
					ConnectDB.disconnect();
				}
				return invoices;
			}
}
