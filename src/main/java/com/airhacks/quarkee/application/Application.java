package com.airhacks.quarkee.application;

import java.util.List;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "application")
public class Application extends PanacheMongoEntity {

	private String name;
	private String owner;
	private String uuid;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	public static Application findByName(String name) {
		return find("name",name).firstResult();
	}
	
	public static Application findByUUID(String uuid) {
		return find("uuid",uuid).firstResult();
	}
	
	public static List<Application> findByOwner(String owner) {
		return list("owner",owner);
	}

}
