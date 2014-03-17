/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaserialization;

/**
 *
 * @author ychabcho
 */


import java.io.Serializable;

public class Personne implements Serializable {
	static private final long serialVersionUID = 6L;
	private String nom;
	private String prenom;
	private Integer age;

	public Personne(String nom, String prenom, Integer age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public String toString() {
		return nom + " " + prenom + " " + age + " ans";
	}
}