import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		// Uloha 2
		int PocetSpusten√≠ = 0;

		TreeSet<Pokemon> kolekce2 = new TreeSet<Pokemon>();
		kolekce2.add(new Pokemon("MEWTWO", "MM"));
		kolekce2.add(new Pokemon("REGIGIGAS", "RG"));
		kolekce2.add(new Pokemon("GARCHOMP", "GCH"));
		File f = new File("C:\\Users\\42077\\Documents\\MOJE\\äkola\\JAVA projekty\\Pokemon\\File.txt");

		File pocetSpusteniFile = new File("C:\\Users\\42077\\Documents\\MOJE\\äkola\\JAVA projekty\\Pokemon\\pocetSpusteni.txt");
		File Date = new File("C:\\Users\\42077\\Documents\\MOJE\\äkola\\JAVA projekty\\Pokemon\\Date.txt");

		try {
			FileOutputStream OutputKolekce = new FileOutputStream(f);
			ObjectOutputStream writerKolekce = new ObjectOutputStream(OutputKolekce);
			writerKolekce.writeObject(kolekce2);
			writerKolekce.close();
			FileInputStream KolekceInput = new FileInputStream(f);
			ObjectInputStream KolekceInputReader = new ObjectInputStream(KolekceInput);

			System.out.println(KolekceInputReader.readObject());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Temp = 1;
		// cten√≠ poƒçtu spu≈°tƒõn√≠ ze souboru
		try {
			FileInputStream CounterInput = new FileInputStream(pocetSpusteniFile);
			ObjectInputStream CounterReader = new ObjectInputStream(CounterInput);
			Temp += CounterReader.readInt();

			CounterReader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}
		// vlo≈æen√≠ poctu spu≈°tƒõn√≠ do souboru
		try {
			FileOutputStream outputCounter = new FileOutputStream(pocetSpusteniFile);
			ObjectOutputStream CounterWriter = new ObjectOutputStream(outputCounter);
			CounterWriter.writeInt(Temp);
			CounterWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("POCET SPUSTENI= " + Temp);

		// zapis a cteni data
		try {

			FileInputStream DateInput = new FileInputStream(Date);
			ObjectInputStream DateReader = new ObjectInputStream(DateInput);
			Date read = new Date();
			System.out.println("Naposledy spuötÏno: " + read);
			read = (java.util.Date) DateReader.readObject();

			FileOutputStream DateOutput = new FileOutputStream(Date);
			ObjectOutputStream DateWriter = new ObjectOutputStream(DateOutput);
			Date write = new Date();
			DateWriter.writeObject(write);

			long milisec = write.getTime() - read.getTime();
			System.out.println("SpuötÏno naposledy p¯ed: " + Militodate.Militodatemethod(milisec / 1000));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			try {
				ObjectOutputStream DateWriter = new ObjectOutputStream(new FileOutputStream(Date));
				DateWriter.writeObject(new Date());
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
