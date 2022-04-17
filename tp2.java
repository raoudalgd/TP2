import ilog.concert.*;
import ilog.cplex.*;
public class tp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void model1(){
		try{
			IloCplex simplexe = new IloCplex();
			
			//déclaration des variables des décision 
			 IloNumVar x [][] = new IloNumVar [6][1];
			 for (int i=0;i<6;i++){
				x[i][0]= simplexe.numVar(0, Double.MAX_VALUE);
				
			// declaration de la fonction objectif
			 IloLinearNumExpr objectif = simplexe.linearNumExpr();	
			
			// Définition des coefficients de la fonction objectif
			 objectif.addTerm(60, x[0][0]);
			 objectif.addTerm(40, x[1][0]);
			 
			// Définir le type d'otimisation de la fonction (max ou min )
			 simplexe.addMinimize(objectif);
			 
			// contrainte 1 : 35*x1+12*x1+16*x3+38*x4+5*x5+2*x6<=750 ***750=12*60+30***12h30
			 IloLinearNumExpr contrainte_1 = simplexe.linearNumExpr();
			 contrainte_1.addTerm(35, x[0][0]);
			 contrainte_1.addTerm(12, x[1][0]);
			 contrainte_1.addTerm(16, x[2][0]);
			 contrainte_1.addTerm(38, x[3][0]);
			 contrainte_1.addTerm(5, x[4][0]);
			 contrainte_1.addTerm(2, x[5][0]);
			  simplexe.addLe(contrainte_1, 750);

			// contrainte 2 : 25*x1+8*x2+9*x3+24*x4+6*x5+8*x6
			  IloLinearNumExpr contrainte_2 = simplexe.linearNumExpr();
				 contrainte_2.addTerm(25, x[0][0]);
				 contrainte_2.addTerm(8, x[1][0]);
				 contrainte_2.addTerm(9, x[2][0]);
				 contrainte_2.addTerm(24, x[3][0]);
				 contrainte_2.addTerm(6, x[4][0]);
				 contrainte_2.addTerm(8, x[5][0]);
			   simplexe.addLe(contrainte_, 750);

			// contrainte 3 : 12*x1+8*x2+11*x3+27*x4+3*x5+2*x6
			   IloLinearNumExpr contrainte_3 = simplexe.linearNumExpr();
			     contrainte_3.addTerm(12, x[0][0]);
				 contrainte_3.addTerm(8, x[1][0]);
				 contrainte_3.addTerm(11, x[2][0]);
				 contrainte_3.addTerm(27, x[3][0]);
				 contrainte_3.addTerm(3, x[4][0]);
				 contrainte_3.addTerm(2, x[5][0]);
			    simplexe.addLe(contrainte_3, 750);

			// contrainte 4 : 38*x1+15*x2+14*x3+30*x4+2*x5+9*x6
			    IloLinearNumExpr contrainte_4 = simplexe.linearNumExpr();
			     contrainte_4.addTerm(38, x[0][0]);
				 contrainte_4.addTerm(15, x[1][0]);
				 contrainte_4.addTerm(14, x[2][0]);
				 contrainte_4.addTerm(30, x[3][0]);
				 contrainte_4.addTerm(2, x[4][0]);
				 contrainte_4.addTerm(9, x[5][0]);
			     simplexe.addLe(contrainte_4, 750);

			// contrainte 5 : 
			     IloLinearNumExpr contrainte_5 = simplexe.linearNumExpr();
			     contrainte_5.addTerm(0, x[0][0]);
				 contrainte_5.addTerm(9, x[1][0]);
				 contrainte_5.addTerm(8, x[2][0]);
				 contrainte_5.addTerm(25, x[3][0]);
				 contrainte_5.addTerm(10, x[4][0]);
				 contrainte_5.addTerm(5, x[5][0]);
			      simplexe.addLe(contrainte_5, 750);

			// contrainte 6 : 
			      IloLinearNumExpr contrainte_6 = simplexe.linearNumExpr();
			      	 contrainte_6.addTerm(35, x[0][0]);
					 contrainte_6.addTerm(0, x[1][0]);
					 contrainte_6.addTerm(0, x[2][0]);
					 contrainte_6.addTerm(14, x[3][0]);
					 contrainte_6.addTerm(6, x[4][0]);
					 contrainte_6.addTerm(7, x[5][0]);
			       simplexe.addLe(contrainte_6,750 );
			       
			       simplexe.solve(); 
		   // lancer la resolution
		   // Afficher des résultat    
			       	
			       System.out.println("Voici la valeur des vols de départ "+ simplexe.getObjValue());
			       System.out.println(" Voici les valeurs des variables de décision: ") ;
			       for (int i=0;i<6;i++)
			       System.out.println( "X"+i+ " = "+ simplexe.getValue(x[i][0]));
			      } catch (IloException e){
			      System.out.print("Exception levée " + e);
			       }
				
				
				}

		
		
		}
	}

}
