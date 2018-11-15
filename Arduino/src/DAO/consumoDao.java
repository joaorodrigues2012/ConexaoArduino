package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.conexao;
import model.consumo;

public class consumoDao {
	public int criar(consumo consumo) {
		String sqlInsert = "INSERT INTO consumo(potencia) VALUES (?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setDouble(1, consumo.getValor());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					consumo.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consumo.getId();
	}

	
}
