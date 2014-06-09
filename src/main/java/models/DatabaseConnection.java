package models;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Created by blakebishop on 5/21/14.
 */
public class DatabaseConnection extends BasicDataSource {

    private String username, password, url, driverClass;
    public DatabaseConnection() {
        this.username = "xutptnofhukcgb";
        this.password = "AiifNJx9_9vb5d6M6mnrPTZJow";
        this.url = "postgres://xutptnofhukcgb:AiifNJx9_9vb5d6M6mnrPTZJow@ec2-174-129-218-200.compute-1.amazonaws.com:5432/dah5han7jv331o";
        this.driverClass = "org.postgresql.Driver";

        initConnection();
    }
    public void initConnection() {
        super.setUsername(username);
        super.setPassword(password);
        super.setUrl(url);
        super.setDriverClassName(driverClass);
    }

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return Logger.getLogger("Dummy Logger");
	}
}
