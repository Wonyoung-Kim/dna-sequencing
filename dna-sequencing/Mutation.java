// this class contains the information about one specific mutation from a reference gene
// and the mutationDetection method in MutationDetector returns a list of these objects.
// Each mutation is given by an integer representing the index where the mutation occurs,
// and two strings, the first being the reference string and the second being the mutated.
public class Mutation {
	String mutatedString;
	String referenceString;
	int index;
	int mutatedLength;

	public Mutation(String mutatedString, String referenceString, int index, int mutatedLength) {
		this.mutatedString = mutatedString;
		this.referenceString = referenceString;
		this.index = index;
		this.mutatedLength = mutatedLength;

	}

	public String getMutatedString() {
		return mutatedString;
	}

	public String getReferenceString() {
		return referenceString;
	}

	public String toString() {
		String i = Integer.toString(index);
		String str = "";
		str += "mutatedString : " + mutatedString;
		str += " referenceString : " + referenceString + " index : " + i + " lengthOfMutation : " + mutatedLength;
		return str;
	}

	public int getMutatedLength() {
		return mutatedLength;
	}
	
	public int getMutatedIndex() {
		return index;
	}
}
