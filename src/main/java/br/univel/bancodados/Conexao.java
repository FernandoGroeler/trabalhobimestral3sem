package br.univel.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Conexao SELF;
	
	public static Conexao getInstance() {
		if (SELF == null)
			SELF = new Conexao();
		
		return SELF;
	}
	
	public Conexao() {
		conectar();
	}
	
	private Connection connection;
	private static final String USUARIO = "postgres";
	private static final String SENHA = "pr4gr1m1d4r";
	
	public Connection getConnection() {
		return this.connection;
	}
	
	private void conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trabalhobimestral3sem", USUARIO, SENHA);
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				public void run() {
					try {
						Conexao.this.connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Só pode existir uma conexão!");
	}
}