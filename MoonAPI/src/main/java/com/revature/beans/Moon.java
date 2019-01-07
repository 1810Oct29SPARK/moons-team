package com.revature.beans;

public class Moon {

	public Moon(int id, String name, Planet planetId) {
		super();
		this.id = id;
		this.name = name;
		this.planetId = planetId;
	}
	
	public Moon(int id) {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String name;
	private Planet planetId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Planet getPlanetId() {
		return planetId;
	}
	public void setPlanetId(Planet planetId) {
		this.planetId = planetId;
	}
	
	@Override
	public String toString() {
		return "Moon [id=" + id + ", name=" + name + ", planetId=" + planetId + "]";
	}
	
}
