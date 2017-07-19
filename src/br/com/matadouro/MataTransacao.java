package br.com.matadouro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MataTransacao {
		
		private Connection connection;
		
		public MataTransacao() {
				this.connection = new FabricaDeConexao().pegaConexao();
		}
		
		public void mata(long tempo){
		
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;	 
		  try {  
			   preparedStatement = this.connection.prepareStatement("SHOW FULL PROCESSLIST");
		  rs = preparedStatement.executeQuery();
		  
			  while(rs.next()) {
				
				  long id = rs.getLong("Id");
				  
				  if(rs.getLong("Time") > tempo){
		
					  preparedStatement = connection.prepareStatement("KILL "+ id);
					  preparedStatement.execute();
				
					  System.out.println("matando: "+id);
				  }
			  }
			  preparedStatement.close();
		  } 
		  catch (SQLException e) {
			  throw new RuntimeException(e);
		  }	  
		finally {try {if(preparedStatement != null){preparedStatement.close();}if(rs != null){rs.close();}connection.close();}catch(SQLException e){e.printStackTrace();}}
		}	
}
