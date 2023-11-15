package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Rank;

public class RankModel {
    private List<Rank> rankList;

    public RankModel() {
        rankList = new ArrayList<>();
    }

    // Phương thức để thêm một rank mới vào danh sách
    public boolean create(Rank rank) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = ConnectDB.connection()
                    .prepareStatement("INSERT INTO rank (`rank`, `point`, `discount`) VALUES (?, ?, ?)");

            preparedStatement.setString(1, rank.getRank());
            preparedStatement.setInt(2, rank.getPoint());
            preparedStatement.setInt(3, rank.getDiscount());
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            ConnectDB.disconnect();
        }
        return result;
    }


    // Phương thức để truy xuất tất cả các rank
    public List<Rank> findAll() {
        List<Rank> ranks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT * FROM rank");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Rank rank = new Rank();
                rank.setId(resultSet.getInt("id"));
                rank.setRank(resultSet.getString("rank"));
                rank.setPoint(resultSet.getInt("point"));
                rank.setDiscount(resultSet.getInt("discount"));
                ranks.add(rank);
            }
        } catch (Exception e) {
            ranks = null;
        } finally {
            ConnectDB.disconnect();
        }
        return ranks;
    }

 // Phương thức để cập nhật thông tin rank
    public boolean update(Rank rank) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = ConnectDB.connection()
                    .prepareStatement("UPDATE rank SET point = ?, rank = ?, discount = ? WHERE id = ?");
            preparedStatement.setInt(1, rank.getPoint());
            preparedStatement.setString(2, rank.getRank());
            preparedStatement.setInt(3, rank.getDiscount());
            preparedStatement.setInt(4, rank.getId());
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            ConnectDB.disconnect();
        }
        return result;
    }

}
