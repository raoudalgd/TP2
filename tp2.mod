* OPL 12.6.0.0 Model
 * Author: DELL
 * Creation Date: 17 avr. 2022 at 13:14:07
 *********************************************/
//lire dans un fichier le nb d'objet et le poids max
{int} personne = {1,2,3,4,5,6};
{int} machine = {1,2,3,4,5,6};

//déclarer des tableaux de données indexés sur les objets
 int p[personne][machine]=[[13,24,31,19,40,29],[18,25,30,15,43,22],[20,20,27,25,34,33],[23,26,28,18,37,30],[28,33,34,17,38,20],[19,36,25,27,45,24]];
 
 // Déclarer les variables de décisions
 dvar int x[personne][machine];
 
 // function objectif
 maximize sum(i in personne, j in machine) x[i][j]*p[i][j];
 
 // contraintes
 subject to{
 forall(i in machine)sum(j in personne) x[i][j]==1;
 forall(j in personne)sum(i in machine) x[i][j]==1;
 forall(i in machine)sum(j in personne) x[i][j]<=1;
 
 
 }
