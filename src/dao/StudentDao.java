package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.JDBCUtil;

public class StudentDao {
	// 每页的记录，传入每页开始索引和每页大小用于分页，即limit的两个参数（mysql分页用limit）
	public List<Student> getPageRecord(int pagenostart, int pagesize) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//String sql = "select * from blog limit ?,?";
		
		String sql="SELECT * FROM  (  SELECT A.*, ROWNUM RN  FROM (SELECT * FROM student) A  WHERE ROWNUM <= ?  )  WHERE RN >= ?";
		List<Student> list = new ArrayList<Student>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pagenostart+5); 
			ps.setInt(2, pagenostart);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student blog = new Student();
				blog.setId(rs.getString("id"));
				blog.setName(rs.getString("name"));
				blog.setAge(rs.getInt("age"));
				// blog.setContent(rs.getString("content"));
				// blog.setCreated_time(rs.getDate("created_time"));
				list.add(blog);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(rs, ps, conn);
		}
		return null;
	}

	// 总记录数
	public int getTotal() {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int a=0;
		try {
			ps = conn.prepareStatement("select COUNT(*) from student");
			rs = ps.executeQuery();
			if (rs.next()) {
				a= rs.getInt("COUNT(*)");
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(rs, ps, conn);
		}
		return a;
	}
}
