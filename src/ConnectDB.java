import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnectDB {
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	private  Connection connect() 
	{

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

	private Connection closed()
	{
		try{
			con.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public Room getRoomDetails( String user_input)
	{
		Room room = new Room();
		String name="";
		
		try
		{
			connect();
			String sql ="select * from roomdetails where rname=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_input);


			rs=pstmt.executeQuery();


			while(rs.next())
			{
				//System.out.print("-------------------"+ rs.getInt(1));
				/*name+="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>";
				System.out.println("name............----------------"+name);*/
				
				
                room.setName(rs.getString(1));
                room.setOption1(rs.getString(2));
                room.setOption2(rs.getString(3));
                room.setOption3(rs.getString(4));
                room.setThings(rs.getString(5));
                InsertDetails(rs.getString(1),rs.getString(5));

			}


		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return room;
	}
	public void InsertDetails(String rname ,String item)
	{
		String result="";

		try
		{
			connect();
			String sql ="select count(*) from roomstate where rname=?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rname);


			rs=pstmt.executeQuery();
			while(rs.next())
			{
				if(rs.getInt(1)==0)
				{
					String sql1 ="Insert into roomstate values(?,1,?)";
					PreparedStatement pstmt1 = con.prepareStatement(sql1);
					pstmt1.setString(1, rname);
					pstmt1.setString(2, item);
					pstmt1.execute();
				}

			}


		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	public String logfile()
	{
		String result="";
		try
		{
			connect();
			String sql ="select * from roomstate ";

			PreparedStatement pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();


			while(rs.next())
			{
				//System.out.print("-------------------"+ rs.getInt(1));
				result+="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(3);
				System.out.println("name............----------------"+result);


			}


		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return result;
	}



}
