import java.io.IOException;
import java.io.PrintWriter;

public class FastaWriter {
	PrintWriter thePrintWriter;

	public FastaWriter(PrintWriter thePW) {
		this.thePrintWriter = thePW;
	}

	/*
	 * this prints defline and sequnece from FastaRecord
	 */
	public void writeRecord(FastaRecord rec) throws IOException {
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
	}
}
