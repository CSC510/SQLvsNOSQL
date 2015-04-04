package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Repository;

import com.webapp.dao.RequestDao;
import com.webapp.model.Request;

@Repository
public class RequestSQLImpl extends BaseSQLImpl<Request> implements RequestDao{

}
