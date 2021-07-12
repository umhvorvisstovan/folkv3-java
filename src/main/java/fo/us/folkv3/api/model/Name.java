package fo.us.folkv3.api.model;

public class Name {

	private final String first;
	private final String middle;
	private final String last;
	private final String official;
	
	public Name(String first, String middle, String last, String official) {
		this.first = first; 
		this.middle = middle;
		this.last = last;
		this.official = official;
	}

	public String getFirst() {
		return first;
	}

	public String getMiddle() {
		return middle;
	}

	public String getLast() {
		return last;
	}

	public String getOfficial() {
		return official;
	}

	public boolean isComplete() {
		return first != null && last != null && official != null;
	}
	
	@Override
	public String toString() {
		return official;
	}
	
}
