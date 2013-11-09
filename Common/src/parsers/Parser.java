package parsers;

public interface Parser<T> {

	public abstract T toDto(String compra) throws ParserException;

}