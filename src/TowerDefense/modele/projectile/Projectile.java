package TowerDefense.modele.projectile;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Tours;
import TowerDefense.modele.ennemis.Cactus;
import TowerDefense.modele.ennemis.Scorpion;
import TowerDefense.modele.ennemis.Serpent;
import TowerDefense.modele.tourelle.TourelleFeu;
import TowerDefense.modele.tourelle.TourelleGlace;
import TowerDefense.modele.tourelle.TourelleRoche;
import TowerDefense.modele.ennemis.SerpentSpeciale;
import TowerDefense.modele.GrandeTour;
import TowerDefense.modele.tourelle.TourelleDestructible;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Projectile {

	private Tours positionTourelle;
	private Ennemis positionEnnemis;
	private String id;
	private DoubleProperty xProperty;
	private DoubleProperty yProperty;
	private Jeu jeu;

	public Projectile(Tours tourelleDepart, Ennemis ennemisArrivee, Jeu jeu) {

		this.jeu = jeu;
		this.positionTourelle = tourelleDepart;
		this.positionEnnemis = ennemisArrivee;
		this.xProperty = new SimpleDoubleProperty(tourelleDepart.getX());
		this.yProperty = new SimpleDoubleProperty(tourelleDepart.getY());
		this.id = "A" + Acteur.compteur;
		Acteur.compteur++;

	}

	public String getIdEnnemi(){
		return this.positionEnnemis.getId();
	}

	public Jeu getJeu() {
		return this.jeu;
	}

	public double getX() {
		return xProperty.getValue();
	}

	public void setX(double newPositionX) {
		xProperty.setValue(newPositionX);
	}

	public DoubleProperty xProperty() {
		return this.xProperty;
	}

	public double getY() {
		return yProperty.getValue();
	}

	public void setY(double newPositionY) {
		yProperty.setValue(newPositionY);
	}

	public final DoubleProperty yProperty() {
		return this.yProperty;
	}

	public String getId() {
		return this.id;
	}

	public void agit() {
		//Regarde la diff�rence de coordon�es entre le projectile est l'ennemi
		//pour savoir vers o� le projectile doit se d�placer
		double variablex= this.getX() - positionEnnemis.getX();
		double variabley = this.getY() - positionEnnemis.getY();

		//Modification des coordon�es de la projectile en fonction du calcul pr�c�dent
		if (variablex >0) { 
			this.setX(this.getX()-0.5);
		}
		else if (variablex <0) {
			this.setX(this.getX()+0.5);
		}
		if (variabley >0) {
			this.setY(this.getY()-0.5);
		}
		else if (variabley <0) {
			this.setY(this.getY()+0.5);
		}

		//Cas o� le projectile � toucher l'ennemi
		//Retire  les pv � l'ennemi
		//Si 'ennemi n'a plus de pv et est donc mort il est retirer de la liste d'acteur et le joueur gagne de l'argent
		//Le projectile est aussi retirer de la liste de projectile
		if (variablex == 0 && variabley == 0) {
			if((positionEnnemis instanceof Scorpion && positionTourelle instanceof TourelleGlace) || 
					(positionEnnemis instanceof Serpent && positionTourelle instanceof TourelleRoche) ||
					(positionEnnemis instanceof Cactus && positionTourelle instanceof TourelleFeu)) {

				positionEnnemis.setPvDegat(30);
			}
			else {
				positionEnnemis.setPvDegat(20);
			}
				
			
			if(positionTourelle instanceof TourelleDestructible  && positionEnnemis instanceof SerpentSpeciale) {
				((TourelleDestructible) positionTourelle).setPvDegat(25);
				if(((TourelleDestructible) positionTourelle).getPv()<=0) {
					jeu.getListeActeurs().remove(positionTourelle);
				}
			}
			if(positionTourelle instanceof GrandeTour) {
				positionEnnemis.setVitesse(5);
			}
			if(positionEnnemis.getPv()<=0) {
				jeu.getListeActeurs().remove(positionEnnemis);
				jeu.incrementerArgent(10);
			}
			jeu.getListeProjectile().remove(this);
		}
	}
}
