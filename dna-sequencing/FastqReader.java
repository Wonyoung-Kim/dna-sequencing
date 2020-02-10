import java.io.BufferedReader;
import java.io.IOException;

public class FastqReader {

	private BufferedReader br;

	public FastqReader(BufferedReader br) {
		this.br = br;
	}

	/*
	 * this method throws IOException and RecordFormatException when defline has
	 * nothing to be read
	 */
	public FastqRecord readRecord() throws IOException, RecordFormatException {
		String defline = br.readLine();
		if (defline == null) {
			return null;
		}
		String sequence = br.readLine();
		br.readLine();
		String quality = br.readLine();
		FastqRecord fr = new FastqRecord(defline, sequence, quality);
		return fr;
	}
}
