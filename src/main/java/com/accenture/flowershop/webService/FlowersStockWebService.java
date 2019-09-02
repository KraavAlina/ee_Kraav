package com.accenture.flowershop.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FlowersStockWebService {
    @WebMethod
    void increaseFlowersStockSize (@WebParam(name = "count")int count);
}
