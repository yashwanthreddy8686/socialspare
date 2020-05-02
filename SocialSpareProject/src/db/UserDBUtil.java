package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import model.User;

public class UserDBUtil {
private DataSource dataSource;
Connection con ;

public UserDBUtil(Connection con) {
    this.con = con;
}

	public UserDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public User findUser(String email) throws Exception{
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		User foundUser = null;	
		try {
			conn = this.dataSource.getConnection();
			String sql = "SELECT * FROM user WHERE email = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			res = pstmt.executeQuery();
			if(res.next()) {
				String tempFname = res.getString("fname").toString();
				String tempLname = res.getString("lname").toString();
				String tempEmail = res.getString("email").toString();
				String tempPass = res.getString("pass").toString();
				foundUser = new User(tempFname,tempLname,tempEmail,tempPass);
			}	
		}finally {
			close(conn,smt,pstmt,res);
		}
		return foundUser;
	}
	
	//for register user 
    public boolean saveUser(User user){
    	Connection conn = null;
        boolean set = false;
        try{
           conn = this.dataSource.getConnection();
           //Insert register data to database
           String query = "insert into user(email,fname,lname,pass) values(?,?,?,?)";
           PreparedStatement pt = conn.prepareStatement(query);
           pt.setString(1, user.getEmail());
           pt.setString(2, user.getFname());
           pt.setString(3, user.getLname());
           pt.setString(4, user.getPass());
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
	
	private void close(Connection conn, Statement smt, PreparedStatement pstmt, ResultSet res) {
		try {
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(smt != null) {
				smt.close();
			}
			if(res != null) {
				res.close();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
