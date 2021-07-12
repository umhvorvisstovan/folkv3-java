package fo.us.folkv3.api.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PublicId extends Id {

	private PublicId(Integer value) {
		super(value);
	}

	public static PublicId of(int value) {
		return new PublicId(Integer.valueOf(value));
	}

	public static PublicId of(Integer value) {
		return new PublicId(value);
	}

	public static List<PublicId> of(Integer... values) {
		return Arrays.stream(values).map(PublicId::of).collect(Collectors.toList());
	}

}
