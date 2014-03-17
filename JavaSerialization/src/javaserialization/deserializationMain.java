/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaserialization;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class deserializationMain {

	static public void main(String[] argv)  throws Exception{
		Personne p = null;
                // opening a file inputStream
		FileInputStream fis = new FileInputStream("personne.serial");
		// opening an object Input stream related to the file
		ObjectInputStream ois= new ObjectInputStream(fis);
                //deserialization of the Date
                System.out.println(ois.readObject());
                // deserialization of the object personne
                p = (Personne)ois.readObject();
                System.out.println(p);
                //deserialization of the String Array
                String[]tableau = (String[])ois.readObject();
                System.out.println(tableau[0]+" "+tableau[1]);
                // closing the streams
		ois.close();
		fis.close();
		if(p != null) {
			System.out.println(p + " a ete deserialise");
		}
	}
}
