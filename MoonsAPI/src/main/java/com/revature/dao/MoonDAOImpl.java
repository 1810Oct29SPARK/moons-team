package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Moon;

public class MoonDAOImpl implements MoonDAO {

	@Override
	public List<Moon> getAllMoons() {
			List<Moon> mn = new ArrayList<>();
			try (Connection con = ConnectionUtil.getConnection(filename)) {
				String sql = "SELECT M.ID, M.MOON_NAME, P.PLANET_ID, P.PLANET_NAME, P.PLANET_LOCATION FROM MOONS M INNER JOIN PLANETS P ON " +
						"M.PLANET_ID = P.PLANET_ID ORDER BY M.ID";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("ID");
					String moonName = rs.getString("MOON_NAME");
					int planetId = rs.getInt("PLANET_ID");
					String planetName = rs.getString("PLANET_NAME");
					String location = rs.getString("PLANET_LOCATION");
					mn.add(new Planet(planetId, planetName, location));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return mn;
		}
		
	@Override
	public Moon getMoonById(int id) {
		
		moon moon = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "Select * from moons where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int moonId = rs.getInt("id");
				
				moon = new Moon(id);
				System.out.println(moon);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}

		return moon;
	} 
		
	

	@Override
	public void updateMoonById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMoonById(int id) {
		// TODO Auto-generated method stub
		
	}

}
