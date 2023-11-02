package gui;

import business.Buergeramt;
import business.BuergeramtModel;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class BuergeramtControl {
	
	
	private BuergeramtModel model;
	private BuergeramtView view;
	
	
	public BuergeramtControl(Stage s)
	{
		
		this.model = new BuergeramtModel();
		this.view = new BuergeramtView(this, s, model);
		
		System.out.println("control initialized");
	}
	
	
	void schreibeBuergeraemterInDatei(String typ, Buergeramt buergeramt) {
			try{
			if("csv".contentEquals(typ)) {
				model.setBuergeramt(buergeramt);
				model.schreibeBuergeraemterInCsvDatei();
			}
			}
	       	catch(Exception exc){
	       		zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
		
	}
	
	  
    public void nehmeBuergeramtAuf(){
    	try{
    		model.setBuergeramt(new Buergeramt(
    			view.getTxtName().getText(), 
   	            Float.parseFloat(view.getTxtGeoeffnetVon().getText()),
   	            Float.parseFloat(view.getTxtGeoeffnetBis().getText()),
    		    view.getTxtStrasseHNr().getText(),
    		    view.getTxtDienstleistungen().getText().split(";")));
    		model.schreibeBuergeraemterInCsvDatei();
    		zeigeInformationsfensterAn("Das Bürgeramt wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
    
   
    public void zeigeBuergeraemterAn(){
    	
    	
    	if(this.model.getBuergeramt() != null){
    		this.view.getTxtAnzeige().setText(
    			this.model.getBuergeramt().gibBuergeramtZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Bürgeramt aufgenommen!");
    	}
    	
    	
    	
    	System.out.println("ctrl. anzeigen");
    	if(this.model.getBuergeramt() != null){
    		this.view.setTxtAnzeige(new TextArea(this.model.getBuergeramt().gibBuergeramtZurueck(' ')));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Bürgeramt aufgenommen!");
    	}
    }	

    private void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }
	
	

}






