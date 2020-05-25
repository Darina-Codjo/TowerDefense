package TowerDefense.vue;

import TowerDefense.modele.Acteur;
import TowerDefense.modele.Ennemis;
import TowerDefense.modele.Jeu;
import TowerDefense.modele.Terrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class VueTerrain {
		
	private Terrain monTerrain;
	private Timeline gameLoop;
	private int temps;
	private Jeu game;
	private Pane plateau;
	private ConstruireMap construction;

	public VueTerrain(Jeu game, ConstruireMap construction, Pane plateau) {
		super();
		this.monTerrain = game.getMonTerrain();
		this.game = game;
		this.construction = construction;
		this.plateau = plateau;
		}

	
	public void initAnimation() {
		this.gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on definit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on definit ce qui se passe Ã  chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if(temps==100){
						//System.out.println("fini");
						gameLoop.stop();
					}
					else if (temps%5==0){
						//System.out.println("un tour");
						this.refreshPlateau();
						this.game.tourDeJeu();
//						this.refreshPlateau();
					}
					temps++;
				})
		);
		gameLoop.getKeyFrames().add(kf);
	}


	public Timeline getGameLoop() {
		return gameLoop;
	}
	
public void refreshPlateau() {
		
		
		for(int i= this.plateau.getChildren().size()-1; i>=0;i--){
			Node c=this.plateau.getChildren().get(i) ;
			
			System.out.println("num :" + i+"=" +c.getId());
			for(int j=0; j< this.game.getListeActeurs().size(); j++){
				if(this.game.getListeActeurs().get(j).getPointsDeVie() ==0) {
					this.plateau.getChildren().remove(c);
				}
			}
			System.out.println("num apres :" + i+"=" +c.getId());
		}

		System.out.println(this.game.getListeActeurs().size());
		for(Acteur acteur :this.game.getListeActeurs()) {
			System.out.println( "tretment acteur " + acteur.getId());
				Circle c = (Circle) this.plateau.lookup("#" + acteur.getId());
				
				if(acteur instanceof Ennemis  ) {
					c.setTranslateX(acteur.getX());
					c.setTranslateY(acteur.getY());
				
				}

				System.out.println("fin tretment " +acteur.getId());
			}
 }
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		if(this.plateau.getChildren().size() == 0) {
//			System.out.println("liste vide");
//		}
//		else {
//			//supprimer les ennemis morts
//			for(int i =  this.plateau.getChildren().size()-1; i >= 0; i--) {
//				System.out.println(i);
//				Node node = this.plateau.getChildren().get(i);
//				Acteur acteur = this.game.getActeurId(node.getId());
//				if(acteur == null) {
//					System.out.println("*" +i);
//					this.plateau.getChildren().remove(node);
//				}
//			}
//		}
	}

	
//	// pour enlever  les  morts,  il  faut  parcourir  les   sprites ...
//	for  ( int  i =this.panneauJeu.getChildren().size()−1; i>=0;i−−){
//		Node c=this.panneauJeu.getChildren().get(i) ;
//		Acteur a = this.env.getActeur(c.getId ());
//		if (a==null){
//			this . panneauJeu.getChildren().remove(c);
//			}
//	}}
