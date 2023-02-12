package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.user_data;

public class user_dataDAO implements DAOInterface<user_data>{

	@Override
	public ArrayList<user_data> selectAll() {
		ArrayList<user_data> result = new ArrayList<user_data>();
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM user_data";
			PreparedStatement st = connect.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()) {
				int userId = rs.getInt("userId");
				String password = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				int roleId=rs.getInt("roleId");
				
				user_data ud = new user_data(userId,password,firstName,lastName,age,gender,address,phone,roleId);
				result.add(ud);
			}
			JDBCUtil.closeConnection(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public user_data selectById(user_data t) {
		user_data result=null;
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM user_data WHERE userId=?";
			PreparedStatement st = connect.prepareStatement(sql);
			st.setInt(1, t.getUserId());
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()) {
				int userId = rs.getInt("userId");
				String password = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				int roleId=rs.getInt("roleId");
				
				result = new user_data(userId,password,firstName,lastName,age,gender,address,phone,roleId);
			}
			JDBCUtil.closeConnection(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int insert(user_data t) {
		int result=0;
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO user_data(userId,password,firstName,lastName,age,gender,address,phone) VALUES(?,?,?,?,?,?,?) ";
			PreparedStatement st = connect.prepareStatement(sql);
			st.setInt(1, t.getUserId());
			st.setString(2, t.getPassword());
			st.setString(3, t.getFirstName());
			st.setString(4, t.getLastName());
			st.setInt(5, t.getAge());
			st.setString(6, t.getGender());
			st.setString(7, t.getAddress());
			st.setString(8, t.getPhone());
			
			
			result = st.executeUpdate();
			
			System.out.println(sql);
			
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(user_data t) {
		int result=0;
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql = "DELETE FROM user_data WHERE userId=? ";
			PreparedStatement st = connect.prepareStatement(sql);
			st.setInt(1, t.getUserId());
			
			result = st.executeUpdate();
			
			System.out.println(sql);
			
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(user_data t) {
		int result=0;
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql = "UPDATE user_data SET userId=?,password=?,firstName=?,lastName=?,age=?,gender=?,address=?,phone=?,roleId=? WHERE userId=? ";
			PreparedStatement st = connect.prepareStatement(sql);
			st.setInt(1, t.getUserId());
			st.setString(2, t.getPassword());
			st.setString(3, t.getFirstName());
			st.setString(4, t.getLastName());
			st.setInt(5, t.getAge());
			st.setString(6, t.getGender());
			st.setString(7, t.getAddress());
			st.setString(8, t.getPhone());
			st.setInt(9, t.getRoleId());
			st.setInt(10, t.getUserId());
			
			result = st.executeUpdate();
			
			System.out.println(sql);
			
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public user_data selectByLoginAndPassword(user_data t) {
		user_data result =null;
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql="SELECT * FROM user_data WHERE userId=? AND password=?";
			PreparedStatement st = connect.prepareStatement(sql);
			st.setInt(1, t.getUserId());
			st.setString(2, t.getPassword());
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()) {
				int userId = rs.getInt("userId");
				String password = rs.getString("password");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				int roleId=rs.getInt("roleId");
				
				result = new user_data(userId,password,firstName,lastName,age,gender,address,phone,roleId);
			}
			JDBCUtil.closeConnection(connect);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}


