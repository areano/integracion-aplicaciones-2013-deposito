package parsers;

public interface Parser<T> {

	public abstract T toObject(String data) throws ParserException;

	public abstract String toString(T data) throws ParserException;

}
