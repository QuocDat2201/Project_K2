package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Report;


public class Report_model {
	public boolean Create(Report report) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into report(content, role_sent, role_report, created) values(?,?,?,?)");
			preparedStatement.setString(1, report.getContent());
			preparedStatement.setInt(2, report.getRole_sent());
			preparedStatement.setInt(3, report.getRole_report());
			preparedStatement.setDate(4, new java.sql.Date(report.getCreate().getTime()));
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public List<Report> findall() {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	/******************************Start Model Panel List********************************/
	public List<Report> find(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_report = ?");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> SearchDate(java.util.Date from, java.util.Date to, int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where created >= ? and created <= ? and role_report = ?");
			preparedStatement.setDate(1, new java.sql.Date(from.getTime()));
			preparedStatement.setDate(2, new java.sql.Date(to.getTime()));
			preparedStatement.setInt(3, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> SearchRole(int role_from, int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_sent = ? and role_report = ?");
			preparedStatement.setInt(1, role_from);
			preparedStatement.setInt(2, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> Sort_ID_asc(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_report = ? order by id asc ");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> Sort_ID_desc(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_report = ? order by id desc");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> Sort_Date_asc(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_report = ? order by created asc");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> Sort_Date_desc(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_report = ? order by created desc");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> Sort_Role_desc(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_report = ? order by role_sent desc");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> Sort_Role_asc(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_report = ? order by role_sent asc");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	/******************************End Model Panel List********************************/
	
	/******************************Start Model Panel History********************************/
	public List<Report> findhistory(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_sent = ?");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> SearchDateHistory(java.util.Date from, java.util.Date to, int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where created >= ? and created <= ? and role_sent = ?");
			preparedStatement.setDate(1, new java.sql.Date(from.getTime()));
			preparedStatement.setDate(2, new java.sql.Date(to.getTime()));
			preparedStatement.setInt(3, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> Sort_IDhistory_asc(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_sent = ? order by id asc ");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> Sort_IDhistory_desc(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_sent = ? order by id desc");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> Sort_Datehistory_asc(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_sent = ? order by created asc");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
	
	public List<Report> Sort_Datehistoy_desc(int role) {
		List<Report> reports = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from report where role_sent = ? order by created desc");
			preparedStatement.setInt(1, role);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Report report = new Report();
				report.setId(resultSet.getInt("id"));
				report.setContent(resultSet.getString("content"));
				report.setRole_report(resultSet.getInt("role_report"));
				report.setRole_sent(resultSet.getInt("role_sent"));
				report.setCreate(resultSet.getDate("created"));
				reports.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reports = null;
		} finally {
			ConnectDB.disconnect();
		}
		return reports;
	}
}
