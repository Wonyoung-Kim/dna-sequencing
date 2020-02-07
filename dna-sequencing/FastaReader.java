<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;

public class FastaReader {
	private BufferedReader br;

	public FastaReader(BufferedReader br) {
		this.br = br;
	}

	/*
	 * this method throws IOException and RecordFormatException when defline has
	 * nothing to be read
	 */
	public FastaRecord readRecord() throws IOException, RecordFormatException {
		String defline = br.readLine();
		if (defline == null) {
			return null;
		}

		String sequence = "";
		String line;
		while ((line = br.readLine()) != null) {
			sequence += line;
		}
		FastaRecord fr = new FastaRecord(defline, sequence);
		return fr;
	}
}
=======
import java.io.BufferedReader;
import java.io.IOException;

public class FastaReader {
	private BufferedReader br;

	public FastaReader(BufferedReader br) {
		this.br = br;
	}

	/*
	 * this method throws IOException and RecordFormatException when defline has
	 * nothing to be read
	 */
	public FastaRecord readRecord() throws IOException, RecordFormatException {
		String defline = br.readLine();
		if (defline == null) {
			return null;
		}

		String sequence = "";
		String line;
		while ((line = br.readLine()) != null) {
			sequence += line;
		}
		FastaRecord fr = new FastaRecord(defline, sequence);
		return fr;
	}
}
>>>>>>> 416960b28820de14a654e85f1c224a03f16c8b6a
