package models;

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
					.prepareStatement("insert into report(content, role_sent, role_report) values(?,?,?)");
			preparedStatement.setString(1, report.getContent());
			preparedStatement.setInt(2, report.getRole_sent());
			preparedStatement.setInt(3, report.getRole_report());
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
