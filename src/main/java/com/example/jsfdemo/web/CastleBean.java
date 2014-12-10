package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Castle;
import com.example.jsfdemo.service.CastleManager;

@SessionScoped
@Named("castleBean")
public class CastleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Castle castle = new Castle();

	private ListDataModel<Castle> castles = new ListDataModel<Castle>();

	@Inject
	private CastleManager keyKeeper;

	private Castle castleToUpdate = new Castle();

	public Castle getCastle() {
		return castle;
	}

	public void setCastle(Castle castle) {
		this.castle = castle;
	}

	public ListDataModel<Castle> getAllCastles() {
		castles.setWrappedData(keyKeeper.getAllCastles());
		return castles;
	}

	// Actions
	public String addCastle() {
		keyKeeper.addCastle(castle);
		return "showCastles";
		//return null;
	}

	public String deleteCastle() {
		Castle castleToDelete = castles.getRowData();
		keyKeeper.deleteCastle(castleToDelete);
		return null;
	}
	
	public String updateCastle() {
		Castle castleToUpdate = castles.getRowData();
		this.setCastleToUpdate(castleToUpdate);
		return "updateCastle";
	}

	public String afterUpdate() {
		return "showCastles";
	}
	
	public void castleIdValidator(FacesContext context, UIComponent component,
			Object value) {

		String castleN_Id = (String) value;

		for (Castle castle : keyKeeper.getAllCastles()) {
			if (castle.getCastleId().equalsIgnoreCase(castleN_Id)) {
				FacesMessage message = new FacesMessage(
						"There is already Castle with that Id, My Lord.");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}

	public Castle getCastleToUpdate() {
		return castleToUpdate;
	}

	public void setCastleToUpdate(Castle castleToUpdate) {
		this.castleToUpdate = castleToUpdate;
	}
}
