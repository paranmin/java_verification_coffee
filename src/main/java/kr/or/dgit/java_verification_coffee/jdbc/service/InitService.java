package kr.or.dgit.java_verification_coffee.jdbc.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kr.or.dgit.java_verification_coffee.jdbc.DBConn;
import kr.or.dgit.java_verification_coffee.jdbc.dao.ExecuteSql;

public class InitService implements DaoService {
	private static final InitService instance = new InitService();

	public static InitService getInstance() {
		return instance;
	}

	private InitService() {
	}

	@Override
	public void service() {
		createDBTable();
		createTriggerOrProcedure();
	}

	private void createTriggerOrProcedure() {
		File f = new File(System.getProperty("user.dir") + "\\resources\\create_trigger_procedure.txt");
		String dbName = (String) DBConn.getInstance().getProperties().get("dbname");
		ExecuteSql.getInstance().execSQL("use " + dbName);
		if (!f.exists()) {
			return;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(f));) {
			StringBuilder statement = new StringBuilder();
			for (String line; (line = br.readLine()) != null;) {
				if (!line.isEmpty() && !line.startsWith("--")) {
					statement.append(line);
				}
				if (line.endsWith("END;")) {
					ExecuteSql.getInstance().execSQL(statement.toString());
					statement.setLength(0);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createDBTable() {
		File f = new File(System.getProperty("user.dir") + "\\resources\\create_sql.txt");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "utf-8"));) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				if (!(line.isEmpty() && line.startsWith("--"))) {
					sb.append(line + "\r\n");
				}
				if (line.endsWith(";")) {
					//System.out.println(sb);
					ExecuteSql.getInstance().execSQL(sb.toString());
					sb.setLength(0);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
