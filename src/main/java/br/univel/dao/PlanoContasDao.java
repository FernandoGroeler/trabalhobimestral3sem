package br.univel.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.bancodados.Conexao;
import br.univel.entidade.PlanoContas;

public class PlanoContasDao {
	private static final String SQL_BUSCAR_TODOS = "select * from planocontas";
	private static final String SQL_INSERIR = "insert into planocontas (descricao, conta, valor) values (?, ?, ?)";
	private static final String SQL_ATUALIZAR = "update planocontas set descricao = ?, conta = ?, valor = ? where idplanocontas = ?";
	private static final String SQL_EXCLUIR = "delete from planocontas where idplanocontas = ?";
	
	public List<PlanoContas> getTodos() {
		Connection connection = Conexao.getInstance().getConnection();
		
		List<PlanoContas> lista = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(SQL_BUSCAR_TODOS);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				PlanoContas pc = new PlanoContas();
				pc.setIdPlanoContas(rs.getInt(1));
				pc.setDescricao(rs.getString(2));
				pc.setConta(rs.getString(3));
				pc.setValor(new BigDecimal(rs.getString(4)));

				lista.add(pc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void inserir(PlanoContas pc) {
		Connection connection = Conexao.getInstance().getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement(SQL_INSERIR);
			ps.setString(1, pc.getDescricao());
			ps.setString(2, pc.getConta());
			ps.setBigDecimal(3, pc.getValor());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(PlanoContas pc) {
		Connection connection = Conexao.getInstance().getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement(SQL_ATUALIZAR);
			ps.setString(1, pc.getDescricao());
			ps.setString(2, pc.getConta());
			ps.setBigDecimal(3, pc.getValor());
			ps.setInt(4, pc.getIdPlanoContas());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(PlanoContas pc) {
		Connection connection = Conexao.getInstance().getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement(SQL_EXCLUIR);
			ps.setInt(1, pc.getIdPlanoContas());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}