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
			        //4.�������ݿ�ķ��ؽ��(ʹ��ResultSet��)
			        while(rs.next()){
			            System.out.println(rs.getString("id")+" "+rs.getString("name"));
			       }
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("getName()��������");
		return "getName()��������";
	}

	@Override
	public String getAll() {
		System.out.println("getAll()��������");
		return "getAll()��������";
	}

}
