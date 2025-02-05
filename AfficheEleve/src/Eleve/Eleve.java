package Eleve;

public class Eleve {

	double Note;
	String NomPrenom;
	String Matiere;
	
		
	public Eleve(double note, String nomPrenom, String matiere) {
		super();
		Note = note;
		NomPrenom = nomPrenom;
		Matiere = matiere;
	}


	@Override
	public String toString() {
		return NomPrenom ;
	}

}

