/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaserialization;

/**
 *
 * @author ychabcho
 */

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {

	static public void main(String[] argv) throws Exception {
			// instanciation of Personne
			Personne p = new Personne("Dupont", "Jean", 36);
			System.out.println("new instance : " + p);
			// opening a stream related to the file "personne.serial"
			FileOutputStream fos = new FileOutputStream("personne.serial");
			// creating a stream of objects related to the file stream
			ObjectOutputStream oos= new ObjectOutputStream(fos);
                        oos.writeObject(new java.util.Date());
			// serialization of the object p
			oos.writeObject(p);
                        String[] tableau = {"Au", "revoir!"};
                        oos.writeObject(tableau);
			oos.flush();
			System.out.println(p + " a ete serialise");
			//closing the streams
			oos.close();
			fos.close();
			}
}