package parsers;

public interface Parser<T> {

	public abstract T toDTO(String data) throws ParserException;

}