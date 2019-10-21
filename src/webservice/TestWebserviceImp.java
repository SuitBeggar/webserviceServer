package webservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebService;

@WebService
public class TestWebserviceImp implements TestWebservice{

	private Connection connection;
	private PreparedStatement prepareStatement;

	@Override
	public String getName(String id) {
		try {
			connection = JDBCUtils.getConnection();
			Statement st=connection.createStatement();
			        ResultSet rs=st.executeQuery("select * from test");
			        //4.处理数据库的返回结果(使用ResultSet类)
			        while(rs.next()){
			            System.out.println(rs.getString("id")+" "+rs.getString("name"));
			       }
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("getName()方法调用");
		return "getName()方法调用";
	}

	@Override
	public String getAll() {
		System.out.println("getAll()方法调用");
		return "getAll()方法调用";
	}

}
