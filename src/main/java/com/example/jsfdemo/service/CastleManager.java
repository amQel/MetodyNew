package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Castle;
import com.example.jsfdemo.domain.Castle;

@ApplicationScoped
public class CastleManager {
	private List<Castle> db = new ArrayList<Castle>();

	public void addCastle(Castle castle) {
		Castle newCastle = new Castle();

		newCastle.setCastleName(castle.getCastleName());
		newCastle.setCastleId(castle.getCastleId());
		newCastle.setCastleType(castle.getCastleType());
		newCastle.setBuiltDate(castle.getBuiltDate());
		newCastle.setCondition(castle.getCondition());
		newCastle.setMaterial(castle.getMaterial());

		db.add(newCastle);
	}

	// Removes the person with given PIN
	public void deleteCastle(Castle castle) {
		Castle castleToRemove = null;
		for (Castle p : db) {
			if (castle.getCastleId().equals(p.getCastleId())) {
				castleToRemove = p;
				break;
			}
		}
		if (castleToRemove != null)
			db.remove(castleToRemove);
	}

	public List<Castle> getAllCastles() {
		return db;
	}
}
