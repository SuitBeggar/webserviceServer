package webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public final class JDBCUtils {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/test";
    private static String user="root";
    private static String password="";
    
    private JDBCUtils(){}
    
    static {
        /**
         * 椹卞姩娉ㄥ唽
         */
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
        
    }
    
    /**
     * 鑾峰彇 Connetion
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
    
    /**
     * 閲婃斁璧勬簮
     * @param conn
     * @param st
     * @param rs
     */
    public static void colseResource(Connection conn,Statement st,ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConnection(conn);
    }
    
    /**
     * 閲婃斁杩炴帴 Connection
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if(conn !=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //绛夊緟鍨冨溇鍥炴敹
        conn = null;
    }
    
    /**
     * 閲婃斁璇彞鎵ц鑰� Statement
     * @param st
     */
    public static void closeStatement(Statement st) {
        if(st !=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //绛夊緟鍨冨溇鍥炴敹
        st = null;
    }
    
    /**
     * 閲婃斁缁撴灉闆� ResultSet
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        if(rs !=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //绛夊緟鍨冨溇鍥炴敹
        rs = null;
    }
}