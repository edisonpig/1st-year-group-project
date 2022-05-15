
import java.sql.*;
import java.util.ArrayList;
public class Registerdb {
public int newu;
public int count;

	/*public void loaddb(String dbDriver){
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public Connection getConnection(){
		Connection con = null;
		try {
			DriverManager.getConnection(dburl,dbusername,dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	*/
 
	public String insert(Member member) throws SQLException{
		String dbname = "converter"; //<--Schema name
		String dburl = "jdbc:mysql://localhost:3306/" + dbname;
		String dbusername = "root";
		String dbpassword = "root1234";
		String dbDriver = "com.msql.cj.jdbc.Driver";
		System.out.println("Connecting database...");
		String sql = "insert into converter.member (first_name,last_name,username,password,count)" + "values(?,?,?,?,?)";
		Connection connection =null; 
		
		System.out.println("start db test");
	//	loaddb(dbDriver);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection(dburl, dbusername, dbpassword);
			System.out.println("Database connected!");

			//SELECT * FROM USERS
		//	Statement stmt = connection.createStatement();
		 //find user 

				PreparedStatement ps = connection.prepareStatement(sql);    //nullpointer detected
				ps.setString(1,member.getFname());
				ps.setString(2,member.getLname());
				ps.setString(3,member.getNewuname());
				ps.setString(4,member.getNewpwd());
				ps.setString(5,"0");
				System.out.println("done");
				//            		ps.setString(2,member.getLname());
				//ps.setString(3,member.getNewuname());
				//ps.setString(4,member.getNewpwd());
				//            		ps.executeUpdate();
					ps.executeUpdate();
					newu = 0;
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("SQLE Data not entered");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("CLASSE Data not entered");
			}
		return "Click BACK to continue.";
	}

	

public String check(String uname,String pwd) throws SQLException{
	String dbname = "converter"; //<--Schema name
	String dburl = "jdbc:mysql://localhost:3306/" + dbname;
	String dbusername = "root";
	String dbpassword = "root1234";
	String dbDriver = "com.msql.cj.jdbc.Driver";
	System.out.println("Connecting database...");
	String sqlcheck = "select * from member";
	String sql = "update converter.member"+" set count = count + 1 " + "where username = ? " +"and password = ? ";
	String result = "";	
	Connection connection =null; 	
	ArrayList<String> fname = new ArrayList<String>();
	ArrayList<String> lname = new ArrayList<String>();
	ArrayList<String> user = new ArrayList<String>();
	ArrayList<String> userpwd = new ArrayList<String>();
	ArrayList<Integer> num = new ArrayList<Integer>();
	int i=0;
	boolean good =false;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		 connection = DriverManager.getConnection(dburl, dbusername, dbpassword);
		System.out.println("Database connected!");
	Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sqlcheck);
			 while ( rs.next() ) {
	             fname.add(rs.getString("first_name"));
	             lname.add(rs.getString("last_name"));
	             user.add(rs.getString("username"));
	             userpwd.add(rs.getString("password"));
	             num.add(rs.getInt("count"));
			 }
			 i=userpwd.size()-1;
			 while(i!=-1){
				 if (i==-1){
					 break;
				 }
				 else if((uname.equals(user.get(i)))&&(pwd.equals(userpwd.get(i)))){
					 good =true;
					 break;
				 }else{
					 i--;
				 }
			 }
		
	
	if (good == true){
		count = num.get(i);
		result = "Welcome Back!"+fname.get(i) +"!"+lname.get(i);
		if (count==0){
			newu =0;
		}else{
			newu=1;
		}
	}else if ((i==-1)&&(good==false)){
			i=0;
	result = "Invalid username or password.";
}

}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQLE Data not entered");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CLASSE Data not entered");
		}
	PreparedStatement ss = connection.prepareStatement(sql); 
	ss.setString(1, user.get(i));
	ss.setString(2, userpwd.get(i));
	ss.executeUpdate();
	System.out.println("count in db is "+count);
	System.out.println("newu in db "+ newu);
System.out.println(result+" "+user.get(i)+userpwd.get(i));
	return result;
}	
}
	
	

