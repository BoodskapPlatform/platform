package io.boodskap.iot.spi.storage.jpa;

public enum DBType {

	CASSANDRA("cassandra","com.impetus.kundera.client.cassandra.dsdriver.DSClientFactory"),
	MONGODB("mongodb", "com.impetus.client.mongodb.MongoDBClientFactory"),
	ELASTIC_SEARCH("", ""),
	ELASSANDRA("cassandra", "com.impetus.kundera.client.cassandra.dsdriver.DSClientFactory"),
	DB2("org.hibernate.dialect.DB2Dialect", "com.ibm.db2.jcc.DB2Driver"),
	DB2_AS400("org.hibernate.dialect.DB2400Dialect", "com.ibm.as400.access.AS400JDBCDriver"),
	DB2_OS390("org.hibernate.dialect.DB2390Dialect", "com.ibm.db2.jcc.DB2Driver"),
	DERBY("org.hibernate.dialect.DerbyDialect", "org.apache.derby.jdbc.ClientDriver"),
	DERBY_EMBEDDED("org.hibernate.dialect.DerbyDialect", "org.apache.derby.jdbc.EmbeddedDriver"),
	FIREBIRD("org.hibernate.dialect.FirebirdDialect", "org.firebirdsql.jdbc.FBDriver"),
	FRONTBASE("org.hibernate.dialect.FrontBaseDialect", "com.frontbase.jdbc.FBJDriver"),
	H2("org.hibernate.dialect.H2Dialect", "org.h2.Driver"),
	HSQLDB("org.hibernate.dialect.HSQLDialect", "org.hsqldb.jdbcDriver"),
	INFORMIX("org.hibernate.dialect.InformixDialect", "com.informix.jdbc.IfxDriver"),
	INGRES("org.hibernate.dialect.IngresDialect", "ca.edbc.jdbc.EdbcDriver"),
	INTERBASE("org.hibernate.dialect.InterbaseDialect", "ca.edbc.jdbc.EdbcDriver"),
	MCKOI_SQL("org.hibernate.dialect.MckoiDialect", "com.mckoi.JDBCDriver"),
	MSSQL_2000("org.hibernate.dialect.SQLServerDialect", "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
	MSSQL_2005("org.hibernate.dialect.SQLServer2005Dialect", "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
	MSSQL_2008("org.hibernate.dialect.SQLServer2008Dialect", "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
	MYSQL("org.hibernate.dialect.MySQL5Dialect", "com.mysql.jdbc.Driver"),
	MYSQL_INNODB("org.hibernate.dialect.MySQL5InnoDBDialect", "com.mysql.jdbc.Driver"),
	MYSQL_MYISAM("org.hibernate.dialect.MySQLMyISAMDialect", "com.mysql.jdbc.Driver"),
	ORACLE("org.hibernate.dialect.OracleDialect", "oracle.jdbc.OracleDriver"),
	ORACLE_9I("org.hibernate.dialect.Oracle9iDialect", "oracle.jdbc.OracleDriver"),
	ORACLE_10G11G("org.hibernate.dialect.Oracle10gDialect", "oracle.jdbc.OracleDriver"),
	POINTBASE("org.hibernate.dialect.PointbaseDialect", "com.pointbase.jdbc.jdbcUniversalDriver"),
	PROGRESS("org.hibernate.dialect.ProgressDialect", "org.postgresql.Driver"),
	SAPDB("org.hibernate.dialect.SAPDBDialect", "com.sap.db.jdbc.Driver"),
	SYBASE("org.hibernate.dialect.SybaseDialect", "com.sybase.jdbc3.jdbc.SybDriver"),
	SYBASE_ASE("org.hibernate.dialect.SybaseASE15Dialect", "com.sybase.jdbc3.jdbc.SybDriver"),
	SYBASE_ANYWHERE("org.hibernate.dialect.SybaseAnywhereDialect", "com.sybase.jdbc4.jdbc.SybDriver"),
	
	;
	
	private DBType(String dialect, String driver) {
		this.dialect = dialect;
		this.driver = driver;
	}
	
	private String dialect;
	private String driver;
	
	public final String dialect() {
		return this.dialect;
	}
	
	public final String driver() {
		return this.driver;
	}
}
