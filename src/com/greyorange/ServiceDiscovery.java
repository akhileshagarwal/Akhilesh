package com.greyorange;

public interface ServiceDiscovery {

	public ServiceDetail getServiceInfo(String serviceName);
	
	public void registerService(ServiceDetail serviceDetail);
	
}
