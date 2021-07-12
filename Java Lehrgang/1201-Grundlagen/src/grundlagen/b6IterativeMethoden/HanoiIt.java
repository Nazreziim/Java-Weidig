package grundlagen.b6IterativeMethoden;
class HanoiIt {

	public static void main(String[] args) {
		//ruft die Hanoi-Applikation mit einer Anzahl an Scheiben auf
		hint(5);

	}

	/**
	 * Gibt auf der Konsole eine einzelne Bewegung einer Scheibe von Turm x nach Turm y aus
	 * 
	 * @param scheibe Die Scheibe, welche bewegt werden soll
	 * @param von der Turm, von welchem die Scheibe bewegt werden soll
	 * @param nach der Turm, auf welchen die Scheibe bewegt werden soll
	 */
	private static void bewegungsausgabe(int scheibe, char von, char nach) {
		System.out.println("Bewege Scheibe " + scheibe + " von " + von
				+ " nach " + nach);
	}

	/**
	 * Stellt fest, welche Scheibe die kleinste auf dem Turm ist, bekommt hierfür den Wert des Turms 
	 * und die gesamtAnzahl an vorhandenen Scheiben als Parameter mitgegeben.
	 * 
	 * @param AnzSch Anzahl der vorhandenen Scheiben
	 * @param turmWert Wert des Turms
	 * @return kleinste auf dem Turm liegende Scheibe
	 */
	private static int stelleErmitteln(int AnzSch, int turmWert) {
		int erg = 2;
		//Schaut für jede Scheibe beginnend mit der größten ob diese die kleinste vorhandene ist ( die 
		//Scheibe 1 ist hiervon ausgenommen!
		for (int i = AnzSch; i >= 2; i--) {
			//Wir berechnen den Wert für die Scheibe, welche wir prüfen möchten
			int q = (int) Math.pow(2, i);
			//Wenn der Turmwert sich restlos durch den wert teilen lässt (überprüft mittels Modulo)
			//haben wir die kleinste vorhandene Scheibe gefunden
			if (turmWert % q == 0) {
				//da wir die kleinste Scheibe gefunden haben schreiben wir den aktuellen Scheibenwert
				//in den Ergebniswert, welchen wir anschliessend als return-Wert zurückgeben möchten
				erg = q;
				//nun setzen wir i auf 1, so dass wir aus unserer for-Schleife heraus kommen
				i = 1;
			}
		}
		//letztendlich geben wir das Herausgefundene als Rückgabewert zurück
		return erg;
	}

	/**
	 * Findet heraus, die wievielte Scheibe sich hinter dem als Parameter in Form einer Zahl
	 * verbirgt und gibt selbiges als Rückgabewert aus
	 * 
	 * @param wert Der zahlenwert der Scheibe, für welche ich die Nummer herausfinden möchte
	 * @return Die Nummer der Scheibe
	 */
	private static int Scheibenummer(int wert) {
		int erg = 0;

		while (wert != 1) {
			erg++;
			wert /= 2;
		}
		return erg + 1;
	}

	/**
	 * Führt iterativ alle Schritte der Türme von Hanoi aus.
	 * 
	 * Die Speicherung des aktuellen Stands findet mit Hilfe von int-Variablen für die einzelnen Türme 
	 * statt
	 * 
	 * Nach jedem Schritt findet eine Ausgabe auf der Konsole statt, welche wie folgt aussieht:
	 * Bewege Scheibe <Scheibennummer> von <Turm x> nach <Turm y>
	 * 
	 * Hierzu wird eine do-while-Schleife genutzt, welche in jedem Durchlauf folgende 2 Schritte 
	 * durchführt:
	 * 1. Die kleinste Scheibe (Scheibe 1) wird von dem Turm auf welchem sie sich gerade befindet 
	 *    zwei Türme weiter bewegt
	 * 2. Die Zweitkleinste zum verschieben verfügbare Scheibe wird auf die einzig den Regeln entsprechend
	 *    mögliche Position verschoben.
	 *    
	 *    Quelle: FH-Wiesbaden - Professor Dr. Ulrich Schwannecke
	 * 
	 * @param scheibenAnzahl Die Anzahl an Scheiben
	 */
	/**
	 * @param scheibenAnzahl
	 */
	private static void hint(int scheibenAnzahl) {
		//Als erstes initialisieren wir unsere Türme
		//
		//Hierzu setzen wir in Turm A alle bits der ihm zugehörigen Variablen auf 1 indem wir die Schei-
		//benanzahl quadrieren und vom Ergebnis abziehen 
		/**************************Beispiel********************
		 * 3 Scheiben:
		 * 2^3=8
		 * 8-1=7
		 * 
		 * 7 in Binärdarstellung: 111
		 * 
		 * jedes Bit stellt hierbei eine Scheibe dar
		 * 	1: Scheibe 1
		 * 	2: Scheibe 2
		 * 	4: Scheibe 3
		 *****************************************************/
		int turmA = (int) Math.pow(2, scheibenAnzahl) - 1;
		
		//Nun initialisiere ich noch die Türme B und C jeweils mit 0, da dort ja keine Scheiben liegen
		//       (zu Beginn)
		int turmB = 0;
		int turmC = 0;
		
		//Nun legen wir eine Variable an, in welcher steht ob die do-while-Schleife am Ende des Durchlaufs
		//nochmals durchlaufen werden soll oder nicht.
		boolean weiter = true;
		
		//Hier halten wir die Gesamtzahl an Scheiben fest
		int AnzahlScheiben = scheibenAnzahl;
		do {
			// erster Schritt: kleinste Scheibe (Wert %2==1) wird 2 Türme nach
			// rechts verschoben
			if (turmA % 2 == 1) {
				//Hierzu setzen wir das 1er-bit auf dem Turm auf welchem es sich aktuell befindet
				//durch ein einfaches subtrahieren des Wertes 1 auf 0
				turmA--;
				//Und setzen es durch ein addieren des Wertes 1 auf dem Zielturm auf 1
				turmC++;
				//Abschliessend gebe ich die Bewegung auf der Konsole aus
				bewegungsausgabe(1, 'A', 'C');
			} 
			//Diese Schritte führe ich natürlich auch aus wenn sich die 1.Scheibe auf einem anderen Turm
			//befindet.
			//da sich hierbei allerdings Quell-/ und Zielturm verändern muss ich diese Fälle mit else-if
			else if (turmB % 2 == 1) {
				turmB--;
				turmA++;
				bewegungsausgabe(1, 'B', 'A');
			} 
			//beziehungsweise else abfangen (hier könnte auch folgendes stehen:
			// else if(turmC % 2 ==1)...
			else {
				turmC--;
				turmB++;
				bewegungsausgabe(1, 'C', 'B');
			}
			//Nun stellen wir fest ob die Simulation an ihrem Ende angelangt ist.
			//Dies ist der Fall wenn 2 Türme den gleichen wert haben.
			//In diesem Fall befinden sich nämlich alle Scheiben auf einem Turm, was entweder bedeutet,
			//dass ich noch gar nicht begonnen habe (dies ist allerdings nicht möglich, da ich gerade 
			//mindestens den ersten Schritt bereits getätigt habe) oder ich mein Ziel erreicht habe.
			if (turmA == turmB || turmA == turmC || turmB == turmC) {
				//sollte das ziel erreicht sein setze ich die weiterführungsbedingung der while-Schleife auf 
				//false
				weiter = false;
			}
			//Sollte das Ziel noch nicht erreicht sein fahre ich mit Schritt 2 fort:
			else {
					
				//Zuerst legen wir Variablen für jeden Turm an in welchen festgehalten wird ob sich auf diesem 
				//die Scheibe 1 befindet.
				boolean Arestlos = false;
				boolean Brestlos = false;
				boolean Crestlos = false;
	
				//Diese belegen wir nun mit Werten, wie wir bereits vorher erfahren haben befindet sich
				// bei x % 2 == 1 die Scheibe auf dem Turm
				//Da x % 2 nur 0 oder 1 ergeben kann folgt daraus, dass sich die erste Scheibe auf 
				//einem Turm bei welchem <Turmwert>%2==0 ist nicht befindet!
				//Diesen Schritt führe ich für alle 3 Türme durch
				if (turmA % 2 == 0) {
					Arestlos = true;
				}
				if (turmB % 2 == 0) {
					Brestlos = true;
				}
				if (turmC % 2 == 0) {
					Crestlos = true;
				}
			
				//Nun stelle ich für jeden Turm fest, welche die kleinste auf ihm liegende Scheibe ist
				//indem ich die weiter oben erläuterte Methode nutze (Auch auf Hinweis die Scheibe 1 be-
				//treffend achten)
				int aKleinst = stelleErmitteln(AnzahlScheiben, turmA);
				int bKleinst = stelleErmitteln(AnzahlScheiben, turmB);
				int cKleinst = stelleErmitteln(AnzahlScheiben, turmC);

				//Nun stelle ich fest ob einer der Türme keine Scheibe enthält
				if (turmA == 0) {
					//Wenn einer der Türme keine Scheibe enthält ist die Sache recht einfach, da
					//dies uns auch sagt das der leere Turm der ist auf welchen wir die 2.größte Scheibe 
					//schieben müssen
					//Wir müssen nur noch feststellen von welchem Turm aus wir verschieben müssen, also
					//Programmtechnisch ausgedrückt, welcher Turm sich restlos durch 2 teilen lässt
					//wozu wir unsere angelegten *restlos-Variablen nutzen können
					if (Brestlos) {
						//Nun setzen wir das bit-der kleinsten Scheibe auf dem Quell-Turm auf 0
						turmB -= bKleinst;
						//Und auf dem Zielturm auf 1,
						//indem wir dem bit gehörigen Zahlenwert vom Wert
						//des Quellturms abziehen und auf den Zielturm aufaddieren
						turmA += bKleinst;
						//und geben Schlussendlich die Bewegung aus
						bewegungsausgabe(Scheibenummer(bKleinst), 'B', 'A');
						//das selbe tun wir mit anderen Quell-/Zieltürmen auch wenn einer der anderen Tüme
						//jener ist welcher aktuell leer ist.
					} else if (Crestlos) {
						
						turmC -= cKleinst;
						turmA += cKleinst;
						bewegungsausgabe(Scheibenummer(cKleinst), 'C', 'A');
					}
				} else if (turmB == 0) {
					if (Arestlos) {
						turmA -= aKleinst;
						turmB += aKleinst;
						bewegungsausgabe(Scheibenummer(aKleinst), 'A', 'B');
					} else if (Crestlos) {
						turmC -= cKleinst;
						turmB += cKleinst;
						bewegungsausgabe(Scheibenummer(cKleinst), 'C', 'B');
					}
				} else if (turmC == 0) {
					if (Arestlos) {
						turmA -= aKleinst;
						turmC += aKleinst;
						bewegungsausgabe(Scheibenummer(aKleinst), 'A', 'C');
					} else if (Brestlos) {
						turmB -= bKleinst;
						turmC += bKleinst;
						bewegungsausgabe(Scheibenummer(bKleinst), 'B', 'C');
					}
				}
				//Sollte momentan kein Turm leer sein, so müssen wir als erstes feststellen welche beiden Türme
				//sich restlos durch 2 teilen lassen, also NICHT die Scheibe 1 auf sich liegen haben
				//um zu wissen, welche Türme ich im folgenden betrachten muss
				else if (Arestlos && Brestlos) {
					//Nun, da ich weiss, welche beiden Türme für mich relevant sind muss ich nur noch 
					//feststellen von welchem auf welchen Turm ich verschieben muss
					if (aKleinst < bKleinst) { 
						//Nun verschiebe ich wie bereits weiter oben bereits beschrieben vom kleineren						
						turmA -= aKleinst;
						//auf den größeren Turm
						turmB += aKleinst;
						//und gebe dies aus
						bewegungsausgabe(Scheibenummer(aKleinst), 'A', 'B');
					} 
					//da nur zwei werte Verglichen werden gibt es logischerweise auch nur einen else-Fall - 
					//ein else if ist nicht notwendig!
					else { 
						//Im else-Fall führe ich das ganze Seitenverkehrt durch
						turmB -= bKleinst;
						turmA += bKleinst;
						bewegungsausgabe(Scheibenummer(bKleinst), 'B', 'A');
					}
				} 
				// Hier folgen die anderen Kombinationen von relevanten Türmen
				//Der einzige Unterschied zum unmittelbar hierrüber befindlichen Fall sind Quell- und Zieltürme
				else if (Arestlos && Crestlos) {
					if (aKleinst < cKleinst) {
						turmA -= aKleinst;
						turmC += aKleinst;
						bewegungsausgabe(Scheibenummer(aKleinst), 'A', 'C');
					} else { 
						turmC -= cKleinst;
						turmA += cKleinst;
						bewegungsausgabe(Scheibenummer(cKleinst), 'C', 'A');
					}
				} else if (Brestlos && Crestlos) {
					if (bKleinst < cKleinst) { 
						turmB -= bKleinst;
						turmC += bKleinst;
						bewegungsausgabe(Scheibenummer(bKleinst), 'B', 'C');
					} else { 
						turmC -= cKleinst;
						turmB += cKleinst;
						bewegungsausgabe(Scheibenummer(cKleinst), 'C', 'B');
					}
				}		
			}

		} while (weiter); //Hier wird nur die Abbruchbedingung geprüft!

	}

}
//Autor: Markus Feußner - letzte Bearbeitung: 15.06.2011