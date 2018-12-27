package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Planet;
import com.revature.util.ConnectionUtil;

public class PlanetDAOImpl implements PlanetDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public List<Planet> getAllPlanets() {
		List<Planet> pl = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM PLANETS";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int planetId = rs.getInt("PLANET_ID");
				String planetName = rs.getString("PLANET_NAME");
				String location = rs.getString("PLANET_LOCATION");
				pl.add(new Planet(planetId, planetName, location));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pl;
	}

	@Override
	public Planet getPlanetById(int id) {
		Planet pl = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM PLANETS WHERE PLANET_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int planetId = rs.getInt("PLANET_ID");
				String planetName = rs.getString("PLANET_NAME");
				String location = rs.getString("PLANET_LOCATION");
				pl = new Planet(planetId, planetName, location);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pl;
	}

	@Override
	public void updatePlanetById(int id) {
		
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM PLANETS";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deletePlanetById(int id) {
		// TODO Auto-generated method stub
		
	}

}
