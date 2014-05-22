package models;

import org.apache.commons.dbcp.BasicDataSource;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Created by blakebishop on 5/21/14.
 */
public class DatabaseConnection extends BasicDataSource {
    private String username, password, jdbcURL, jdbcDriver;

    public DatabaseConnection() {
        initConnection();
    }
    public void initConnection() {
        //todo fix this so that it isn't dumb
        URI dbUri = null;
        try {
            dbUri = new URI(System.getenv("DATABASE_URL"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        this.username = dbUri.getUserInfo().split(":")[0];
        this.password = dbUri.getUserInfo().split(":")[1];
        this.jdbcURL = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        this.jdbcDriver = "org.postgresql.Driver";
    }

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return Logger.getLogger("Dummy Logger");
	}
}
