package com.null01;

import com.null01.dbmetadata.DbConnection;
import com.null01.dbmetadata.DbMetaData;
import com.null01.model.TableInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoGeneratorJpaApplicationTests {
	@Autowired
	private DbConnection dbConnection;
	@Autowired
	private DbMetaData dbMetaData;

	/**
	 * 测试连接
	 */
	@Test
	public void contextLoads() throws Exception{
		Connection conn = dbConnection.getConn();
		DatabaseMetaData dbMetaData = conn.getMetaData();
		System.err.println(dbMetaData.getURL());
	}

	/**
	 * 测试获取表信息
	 */
	@Test
	public void getTableInfo() throws Exception{
		List<TableInfo> tableInfoList =  dbMetaData.getTableInfoList();
		System.err.println(tableInfoList);
	}

}
