package br.unitins.books.application;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {
	
	//para nao permitir uma instancia

	public void addErrorMessage(String message) {
		FacesContext.getCurrentInstance()
		.addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						message, null));
	}
}
