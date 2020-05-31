 import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Trida reprezentuje pokemona, jedna se transfer object.
 * 
 * @author mandik@spsejecna.cz
 *
 */
public class Pokemon implements Comparable<Pokemon>, Serializable {

	public String toCSV() {
		return "Pokemon [jmeno=" + jmeno + ", druh=" + druh + "]";
	}

	public void fromCsv(String in) {
		Matcher mat;
		Pattern p = Pattern.compile("Pokemon \\[jmeno=([a-z A-Z]+), druh=([a-z A-Z]+)]");
		mat = p.matcher(in);

		if (mat.matches()) {
			this.jmeno = mat.group(1);
			this.druh = mat.group(2);
		} else {

			System.out.println("Spatný format jmena a druhu");
		}
	}

	@Override
	public String toString() {
		return "Pokemon [jmeno=" + jmeno + ", druh=" + druh + "]";
	}

	/**
	 * Jmeno pokemona
	 */
	public String jmeno;

	/**
	 * Druh pokemona
	 */
	public String druh;

	/**
	 * Konstruktor pro rychle vytvareni
	 * 
	 * @param jmeno Jmeno pokemona
	 * @param druh  Druh pokemona
	 */
	public Pokemon(String jmeno, String druh) {
		this.jmeno = jmeno;
		this.druh = druh;
	}

 
	/**
	 * Komparator umozni porovnat dva pokemony jednoduse podle jmena
	 */
	@Override
	public int compareTo(Pokemon other) {
		return this.jmeno.compareTo(other.jmeno);
	}

}