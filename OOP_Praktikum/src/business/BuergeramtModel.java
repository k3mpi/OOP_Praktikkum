package business;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BuergeramtModel {
	
	private Buergeramt buergeramt;
	
	
	public void schreibeBuergeraemterInCsvDatei() throws Exception{
		BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
		aus.write(getBuergeramt().gibBuergeramtZurueck(';'));
		aus.close();
	}
	
	public void schreibeBuergeraemterInTxtDatei() throws Exception{
		
		
	}
	
	
	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
	}
	
	public Buergeramt getBuergeramt() {
		return buergeramt;
	}
	


}