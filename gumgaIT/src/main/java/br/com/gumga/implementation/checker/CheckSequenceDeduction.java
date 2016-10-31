package br.com.gumga.implementation.checker;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por implementar a regra das letras, numeros e simbolos
 * sequenciais
 * 
 * @author Larissa
 * @since 29 de out de 2016
 */
public class CheckSequenceDeduction {

	protected static int finalResultBonus(String sequence, String reference) {
		List<Integer> sequenceList = resultOfComparation(reference, sequence);
		int countList = sequenceList.stream().filter(i -> i > 3).mapToInt(i -> i.intValue()).sum();
		String alphabetReverse = new StringBuilder(reference).reverse().toString();

		List<Integer> sequenceListReverse = resultOfComparation(alphabetReverse, sequence);
		int countListReverse = sequenceListReverse.stream().filter(i -> i > 3).mapToInt(i -> i.intValue()).sum();
		int valueCount = countList + countListReverse;
		return CheckCalculateStrongPassword.getValueBonus(valueCount-2, 1);
	}

	private static List<Integer> resultOfComparation(String text, String sequence) {
		int j = 0;
		int countSequence = 0;
		List<Integer> sequenceList = new ArrayList<Integer>();
		for (int i = 0; i < text.length(); i++) {
			if (j > sequence.length() - 1) {
				sequenceList.add(countSequence);
				break;
			}
			if (text.toLowerCase().charAt(i) != sequence.toLowerCase().charAt(j)) {
				sequenceList.add(countSequence);
				countSequence = 0;
				continue;
			} else {
				countSequence++;
				j++;
			}
		}
		return sequenceList;
	}
}
