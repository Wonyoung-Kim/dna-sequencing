public class FastqRecord implements DNARecord {
	private String defline;
	private String sequence;
	private String quality;

	/*
	 * this method throws RecordFormatException when defline's first char is not
	 * equal to @ and initialize inputs
	 */
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException {

		if (defline.charAt(0) != '@') {
			throw new RecordFormatException("Bad 1st char in defline in fastq record: saw X, expected @");
		}
		this.defline = defline;
		this.sequence = sequence;
		this.quality = quality;
	}

	public String toString() {
		// returns a string representing Fastqrecord to be printed out
		String str = "";
		str += "Defline: ";
		str += defline;
		str += ", Sequence: ";
		str += sequence;
		str += ", Quality: ";
		str += quality;
		return str;
	}

	public boolean equals(Object o) {
		FastqRecord that = (FastqRecord) o;
		return this.defline.equals(that.defline) && this.sequence.equals(that.sequence)
				&& this.quality.equals(that.quality);
	}

	public boolean qualityIsLow() {
		if (this.quality.contains("!") || this.quality.contains("#")) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	}

	@Override
	public String getDefline() {
		return defline;
	}

	@Override
	public String getSequence() {
		return sequence;
	}
}
