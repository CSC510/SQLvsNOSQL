package com.springMVC;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.PlatformTransactionManager;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
public class ApplicationConfig extends AbstractMongoConfiguration{

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "MavenTest";
	}

	@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		Mongo mongo=new Mongo();
		mongo.setWriteConcern(WriteConcern.SAFE);
		return mongo;
	}

}
