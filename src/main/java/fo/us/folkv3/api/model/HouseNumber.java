package fo.us.folkv3.api.model;

import java.util.Objects;

public class HouseNumber {

	private final Integer number;
	private final Character letter;
	private final String value;
	
	private HouseNumber(Integer number, Character letter) {
		this.number = Objects.requireNonNull(number);
		this.letter = letter;
		var tempValue = number.toString();
		if (letter != null) {
			tempValue += letter;
		}
		value = tempValue;
	}

	public static HouseNumber of(int number) {
		return new HouseNumber(Integer.valueOf(number), null);
	}
	
	public static HouseNumber of(int number, char letter) {
		return new HouseNumber(Integer.valueOf(number), Character.valueOf(letter));
	}

	public static HouseNumber of(String value) {
		value = Objects.requireNonNull(value, "value must not be null").trim();
		Character letter = extractLetter(value);
		var number = Integer.valueOf(letter == null	? value : value.substring(0, value.length() - 1));  
		return new HouseNumber(number, letter);
	}

	public Integer getNumber() {
		return number;
	}

	public Character getLetter() {
		return letter;
	}
	
	public String getValue() {
		return value;
	}

	public boolean hasLetter() {
		return letter != null;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(number, letter);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof HouseNumber)) {
			return false;
		}
		var other = (HouseNumber) o;
		return number.equals(other.number)
				&& (letter == null ? other.letter == null : letter.equals(other.letter));
	}
	
	@Override
	public String toString() {
		return value;
	}

	private static Character extractLetter(String value) {
		if (value.length() > 1 && Character.isLetter(value.charAt(value.length() - 1))) {
			return Character.valueOf(value.charAt(value.length() - 1));
		}
		return null;
	}
	
}
