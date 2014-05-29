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

    private String username, password, url, driverClass;
    public DatabaseConnection() {
        this.username = "xutptnofhukcgb";
        this.password = "AiifNJx9_9vb5d6M6mnrPTZJow";
        this.url = "postgres://xutptnofhukcgb:AiifNJx9_9vb5d6M6mnrPTZJow@ec2-174-129-218-200.compute-1.amazonaws.com:5432/dah5han7jv331o";
        this.driverClass = "org.postgresql.Driver";

        initConnection();
    }
    public void initConnection() {
        //todo fix this so that it isn't dumb
//        URI dbUri = null;
//        try {
//            dbUri = new URI(System.getenv("DATABASE_URL"));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//
//        super.setUsername(dbUri.getUserInfo().split(":")[0]);
//        super.setPassword(this.password = dbUri.getUserInfo().split(":")[1]);
//        super.setUrl("jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath());
//        super.setDriverClassName("org.postgresql.Driver");
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
