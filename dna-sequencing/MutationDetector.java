import java.util.ArrayList;

// this class will be responsible for detecting mutations between two genes,
// where the two genes will be given by fastaRecord objects.
public class MutationDetector {
	FastaRecord geneReferenceRecord;
	FastaRecord geneMutationRecord;
	String geneName;
	boolean mutationExists;

	public MutationDetector(FastaRecord geneReferenceRecord, FastaRecord geneMutationRecord, String geneName) {
		this.geneReferenceRecord = geneReferenceRecord;
		this.geneMutationRecord = geneMutationRecord;
		this.geneName = geneName;
	}

	public ArrayList<Mutation> getMutations() {

		String referenceString = geneReferenceRecord.getSequence();
		String mutationString = geneMutationRecord.getSequence();
		ArrayList<Mutation> result = new ArrayList<Mutation>();

		int refIndex = 0;
		int mutatedIndex = 0;

		while (refIndex < referenceString.length() && mutatedIndex < mutationString.length()) {
			// if the chars are the same, then just increment both indices and continue
			char currentRefChar = referenceString.charAt(refIndex);
			char mutationChar = mutationString.charAt(mutatedIndex);
			if (currentRefChar == mutationChar) {
				refIndex++;
				mutatedIndex++;
			} else {
				// there's a mutation
				int beginIndex = refIndex;
				String refSubstring = "";
				String mutatedSubstring = "";
				boolean mutationExists = true;
				while (mutationExists) {
					refSubstring += Character.toString(currentRefChar);
					mutatedSubstring += Character.toString(mutationChar);
					refIndex++;
					mutatedIndex++;
					currentRefChar = referenceString.charAt(refIndex);
					mutationChar = mutationString.charAt(mutatedIndex);
					// mutationExists if both string indices are in bounds, and there is a character
					// mismatch at the indices
					mutationExists = (refIndex < referenceString.length() && mutatedIndex < mutationString.length())
							&& (referenceString.charAt(refIndex) != mutationString.charAt(mutatedIndex));
				}
				Mutation mutation = new Mutation(mutatedSubstring, refSubstring, mutatedIndex,
						mutatedSubstring.length());
				System.out.println(mutation);
				result.add(mutation);
			}
		}
		return result; // return null only if there are no mutations detected.
	}
}
