package com.webapp.daoimpl.mdb;

import org.springframework.stereotype.Repository;

import com.webapp.dao.RequestDao;
import com.webapp.model.Request;

@Repository
public class RequestMDBImpl extends BaseMDBImpl<Request>  implements RequestDao{


}
