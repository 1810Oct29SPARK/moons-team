package com.revature.dao;

import java.util.List;

import com.revature.beans.Moon;

public interface MoonDAO {
	
	public List<Moon> getAllMoons();
	public Moon getMoonById(int id);
	public void updateMoonById(int id);
	public void deleteMoonById(int id);

}
