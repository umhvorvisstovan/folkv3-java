package fo.us.folkv3.api.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Changes<I extends Id> {

	private final LocalDateTime from;
	private final LocalDateTime to;
	private final List<I> ids;
	
	public Changes(LocalDateTime from, LocalDateTime to, List<I> ids) {
		this.from = Objects.requireNonNull(from, "from must not be null");
		this.to = Objects.requireNonNull(to, "to must not be null");
		if (from.isEqual(to) || from.isAfter(to)) {
			throw new IllegalArgumentException("from has to be before to");
		}
		this.ids = List.copyOf(ids);
	}

	public LocalDateTime getFrom() {
		return from;
	}

	public LocalDateTime getTo() {
		return to;
	}

	public List<I> getIds() {
		return ids;
	}

}
