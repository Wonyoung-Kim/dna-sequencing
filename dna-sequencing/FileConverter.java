import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileConverter {

	File fastq;
	File fasta;

	public FileConverter(File fastq, File fasta) {
		this.fastq = fastq;
		this.fasta = fasta;
	}

	/*
	 * this method converts reading what is written in file to print to the what is
	 * written as it is programmed.
	 */
	public void convert() throws IOException {

		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);
		boolean done = false;

		while (!done) {
			try {
				FastqRecord FR = fqr.readRecord();
				if (FR != null) {
					System.out.println(FR);
				}
				if (FR == null) {
					done = true;
				} else if (FR.qualityIsLow() == false) {

					FastaRecord fastARecord = new FastaRecord(FR);
					System.out.println(fastARecord);
					faw.writeRecord(fastARecord);
				}
			} catch (RecordFormatException x) {
				x.getMessage();
			}
		}
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}
}
