package fo.us.folkv3.api.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrivateId extends Id {

	public PrivateId(Integer value) {
		super(value);
	}
	
	public static PrivateId of(int value) {
		return new PrivateId(Integer.valueOf(value));
	}

	public static PrivateId of(Integer value) {
		return new PrivateId(value);
	}

	public static List<PrivateId> list(Integer... values) {
		return Arrays.stream(values).map(PrivateId::of).collect(Collectors.toList());
	}

}
