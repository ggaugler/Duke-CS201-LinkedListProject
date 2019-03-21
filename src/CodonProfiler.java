import java.util.*;

public class CodonProfiler {
	
	/**
	 * Count how many times each codon in an array of codons occurs
	 * in a strand of DNA. Return int[] such that int[k] is number
	 * of occurrences of codons[k] in strand. Strand codons can start
	 * at all valid indexes that are multiples of 3: 0, 3, 6, 9, 12, ...
	 * @param strand is DNA to be analyzed for codon occurrences.
	 * @param codons is an array of strings, each has three characters
	 * @return int[] such that int[k] is number of occurrences of codons[k] in 
	 * strand. 
	 */
	public int[] getCodonProfile(IDnaStrand strand, String[] codons) {
		//System.out.println(strand);
		//for (int i=0;i<codons.length;i++) {
			//System.out.println(codons[i]);
		//}
		
		HashMap<String,Integer> map = new HashMap<>();
		int[] ret = new int[codons.length];
				
//		for(int k=0; k < codons.length; k++) {
//			Iterator<Character> iter = strand.iterator();
//			while (iter.hasNext()) {
//				char a = iter.next();
//				char b = 'z';           // not part of any real codon
//				char c = 'z';
//				if (iter.hasNext()) {
//					b = iter.next();
//				}
//				if (iter.hasNext()) {
//					c = iter.next();
//				}
//				String cod = ""+a+b+c;
//				if (cod.equals(codons[k])) {
//					ret[k] += 1;
//				}
//			}
//		}
		//return ret;
		
		
			for (int i=0; i<strand.size()-2; i+=3) {
				String s = strand.toString();
				String cod = s.substring(i,i+3);
				map.putIfAbsent(cod,0);
				map.put(cod,map.get(cod)+1);
				}
			
		System.out.println(map);
		
		for (int i=0; i < codons.length; i++) {
			if (! map.containsKey(codons[i])) {
				ret[i] = 0;
			}
			else {
				ret[i] = map.get(codons[i]);
			}
		}
		
		for (int i=0;i<ret.length;i++) {
			System.out.println(ret[i]);
		}
		
		return ret;
	
	}
}
