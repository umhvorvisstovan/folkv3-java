package fo.us.folkv3.api.model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpecialMarks implements Iterable<SpecialMarks.Type> {

	private final Set<Type> types;
	
	public SpecialMarks(Set<Type> types) {
		this.types = Set.copyOf(types);
	}
	
	public boolean isEmpty() {
		return types.isEmpty();
	}
	
	public boolean isNameAndAddressProtected() {
		return this.types.contains(Type.NAME_AND_ADDRESS_PROTECTED);
	}
	
	public boolean isExcludedFromMarketing() {
		return this.types.contains(Type.EXCLUDED_FROM_MARKETING);
	}
	
	public boolean isExcludedFromStatisticsAndResearch() {
		return this.types.contains(Type.EXCLUDED_FROM_STATISTICS_AND_RESEARCH);
	}
	
	public static enum Type {
	    
		NAME_AND_ADDRESS_PROTECTED,
		EXCLUDED_FROM_MARKETING,
		EXCLUDED_FROM_STATISTICS_AND_RESEARCH,
		;
		
	}

	@Override
	public Iterator<SpecialMarks.Type> iterator() {
		return types.iterator();
	}

	public List<SpecialMarks.Type> toList() {
		return List.copyOf(types);
	}
	
	public Stream<SpecialMarks.Type> stream() {
		return StreamSupport.stream(types.spliterator(), false);
	}
	
}
