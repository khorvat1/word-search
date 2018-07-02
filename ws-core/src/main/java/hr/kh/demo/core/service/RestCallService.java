package hr.kh.demo.core.service;

public interface RestCallService {
	
	public <T> T makeRestGetCall(String url, Class<T> type);

}
