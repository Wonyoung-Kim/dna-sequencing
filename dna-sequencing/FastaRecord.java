public class FastaRecord implements DNARecord {
	String defline;
	String sequence;

	/*
	 * This is ctor of FastaRecord throws exception RecordFormatException when there
	 * is not '>' in first charactor in defline
	 */
	public FastaRecord(String defline, String sequence) throws RecordFormatException {
		if (defline.charAt(0) != '>') {
			throw new RecordFormatException("Bad 1st char in defline in fastq record: saw X, expected @");
		}
		this.defline = defline;
		this.sequence = sequence;
	}

	/*
	 * this is FastaRecord method that take fastqRec as arg defline prints ">" and
	 * rest of defline from fastqRec set sequence from fastqRec to this sequence
	 */
	public FastaRecord(FastqRecord fastqRec) {
		this.defline = ">" + fastqRec.getDefline().substring(1);
		this.sequence = fastqRec.getSequence();

	}

	@Override
	public String getDefline() {
		return defline;
	}

	@Override
	public String getSequence() {
		return sequence;
	}

	public String toString() {
		String str = "";
		str += "defline : " + defline;
		str += "sequence : " + sequence;
		return str;
	}

	/*
	 * comparing defline and sequence to input of defline and sequence 
	 */
	public boolean equals(Object o) {
		FastaRecord that = (FastaRecord) o;
		return this.defline.equals(that.defline) && this.sequence.equals(that.sequence);
	}

	public int hashCode() {
		return (defline + sequence).hashCode();
	}
}
