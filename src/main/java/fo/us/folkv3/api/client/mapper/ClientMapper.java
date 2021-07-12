package fo.us.folkv3.api.client.mapper;

abstract class ClientMapper<T, U> {

	protected ClientMapper() {
	}

	public U map(T value) {
		return value == null ? null : doMap(value);
	}
	
	protected abstract U doMap(T value);
	
}
