package set;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps a {@link ResultSet} to a value.
 */
@FunctionalInterface
public interface ResultSetMapper<T> {

	/**
	 * Maps a {@link ResultSet} to a value.
	 * Result set must point to a row before calling this method.
	 * @param set Result set.
	 * @return Value, may be null.
	 * @throws SQLException On SQL error.
	 */
	T map(ResultSet set) throws SQLException;

}
