package kr.or.dgit.java_verification_coffee.jdbc.service;

import java.util.Properties;

import kr.or.dgit.java_verification_coffee.jdbc.LoadProperties;
import kr.or.dgit.java_verification_coffee.jdbc.dao.ExecuteSql;

public class LoadService implements DaoService {
	private static final LoadService instance = new LoadService();

	public static LoadService getInstance() {
		return instance;
	}

	private LoadService() {
	}

	@Override
	public void service() {
		Properties properties = LoadProperties.getInstance().getProperties();

		ExecuteSql.getInstance().execSQL("use " + properties.getProperty("dbname"));
		ExecuteSql.getInstance().execSQL("set foreign_key_checks=0");

		String[] tables = properties.getProperty("tables").split(",");
		for (String tblName : tables) {
			String path = String.format("%s\\DataFiles\\%s.txt", System.getProperty("user.dir"), tblName);
			String sql = String.format(
					"load data local infile '%s' into table %s character set 'utf8' fields terminated by ',';", path,
					tblName);
			sql = sql.replace("\\", "/");
			ExecuteSql.getInstance().execSQL(sql);
		}
		ExecuteSql.getInstance().execSQL("set foreign_key_checks=1");
	}

}
