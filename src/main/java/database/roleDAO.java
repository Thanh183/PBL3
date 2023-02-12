package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.role;

public class roleDAO implements DAOInterface<role> {

	@Override
	public ArrayList<role> selectAll() {
		ArrayList<role> result = new ArrayList<role>();
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql="SELECT * FROM role";
			PreparedStatement st = connect.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			System.out.println(sql);
			while(rs.next()) {
				int roleId= rs.getInt("roleId");
				String s = rs.getString("roleName");
				role temp = new role(roleId,s);
				result.add(temp);
			}
			
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public role selectById(role t) {
		role result = null;
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql="SELECT * FROM role WHERE roleId=?";
			PreparedStatement st = connect.prepareStatement(sql);
			st.setInt(1, t.getRoleId());
			ResultSet rs = st.executeQuery();
			
			System.out.println(sql);
			while(rs.next()) {
				int roleId= rs.getInt("roleId");
				String s = rs.getString("roleName");
				result = new role(roleId,s);
			}
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(role t) {
		int result = 0;
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql="INSERT INTO role(role) VALUES ?";
			PreparedStatement st = connect.prepareStatement(sql);
			st.setInt(1, t.getRoleId());
			result = st.executeUpdate();
			
			System.out.println(sql);
			
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(role t) {
		int result = 0;
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql="DELETE FROM role WHERE roleId= ?";
			PreparedStatement st = connect.prepareStatement(sql);
			st.setInt(1, t.getRoleId());
			result = st.executeUpdate();
			
			System.out.println(sql);
			
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(role t) {
		int result = 0;
		try {
			Connection connect = JDBCUtil.getConnection();
			
			String sql="UPDATE role SET role=? WHERE roleId=? ";
			PreparedStatement st = connect.prepareStatement(sql);
			st.setString(1, t.getRoleName());
			st.setInt(2,t.getRoleId());
			result = st.executeUpdate();
			
			System.out.println(sql);
			
			JDBCUtil.closeConnection(connect);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}



