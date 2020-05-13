public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	public Datum(int dag, int maand, int jaar) {
		new Datum();
		if(bestaatDatum(dag, maand, jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}

	public int getDag() {
		return dag;
	}

	public int getMaand() {
		return maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public boolean bestaatDatum(int dag, int maand, int jaar) {
		if(dag<1 || dag>31 || maand<1 || maand>12 || jaar<1900 || jaar>2100){
			return false;
		}
		switch (maand) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(dag>30){
					return false;
				}
				break;
			case 2:
				if(jaar%400 == 0 || jaar%4 == 0 && !(jaar%100 == 0)){
					if(dag>29){
						return false;
					}
					break;
				}
				if(dag>28){
					return false;
				}
				break;
		}
		return true;
	}

	/**
	 * Getter voor Sting weergave van datum
	 *
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		// TODO
		return "";
	}
}
