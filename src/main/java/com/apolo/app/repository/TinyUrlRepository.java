package com.apolo.app.repository;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.apolo.app.request.TinyUrlRequest;

@Repository
public class TinyUrlRepository {

	private ConcurrentHashMap<String,TinyUrlRequest> repository = new ConcurrentHashMap<>();
	private ConcurrentHashMap<TinyUrlRequest,String> tinyUrlReposity = new ConcurrentHashMap<>();

	
	public void persist(TinyUrlRequest request,String tinyUrl){
		repository.put(tinyUrl,request);
		tinyUrlReposity.put(request,tinyUrl);
	}
	
	public String getOriginalUrl(String tinyUrl){
		return repository.get(tinyUrl).getOriginalUrl();
	}
	
	public String getTinyUrl(TinyUrlRequest request){
		return tinyUrlReposity.get(request);
	}
}
