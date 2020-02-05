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
