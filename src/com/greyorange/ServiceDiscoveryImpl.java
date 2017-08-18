package com.greyorange;

import java.util.HashMap;
import java.util.Map;

public class ServiceDiscoveryImpl implements ServiceDiscovery{

	private static final Map<String, ServiceDetail> serviceDetailMap=new HashMap<>();
	
	@Override
	public ServiceDetail getServiceInfo(String serviceName){		
		return serviceDetailMap.get(serviceName);	
	}
	
	@Override
	public void registerService(ServiceDetail serviceDetail){
		serviceDetailMap.put(serviceDetail.getServiceName(), serviceDetail);		
	}
	
	public void updateServiceStatus(ServiceDetail serviceDetail){
		serviceDetail.setStatus(false);
		serviceDetailMap.put(serviceDetail.getServiceName(), serviceDetail);
	}
	
	/**
	 * This will be a batch program which will be running to check the status of each
	 * and every service registered in the system
	 */
	public void checkServiceStatus(){
		serviceDetailMap.keySet().forEach(serviceName->{
			ServiceDetail serviceDetail=serviceDetailMap.get(serviceName);
			if(ping(serviceDetail.getEndPoint())){
				updateServiceStatus(serviceDetail);
			}
		});
	}
	
	private boolean ping(String endPoint){
		return endPoint==null?true:false;
	}
}
