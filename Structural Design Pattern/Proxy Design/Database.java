
public interface Database {
    void connect() throws DatabaseException;
    void executeQuery(String query) throws DatabaseException;
    void disconnect() throws DatabaseException;
}
