package com.apolo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.apolo.app.exception.TinyUrlNotFoundException;
import com.apolo.app.repository.TinyUrlRepository;
import com.apolo.app.request.TinyUrlRequest;
import com.apolo.app.utils.AppUtils;

@Service
public class TinyUrlService {

	@Autowired
	private TinyUrlRepository repository;

	public String createTinyUrl(TinyUrlRequest request) {
		String inCache = repository.getTinyUrl(request);
		if(inCache!= null){
			return inCache;
		}
		String tinyUrl = AppUtils.generateFixedSizeUniqueRandom(6);
		repository.persist(request, tinyUrl);
		return tinyUrl;
	}

	public String getOriginalUrl(String tinyUrl){
		String url =  repository.getOriginalUrl(tinyUrl);
		if(url == null){
			throw new TinyUrlNotFoundException(HttpStatus.NOT_FOUND,"Invalid tinyUrl");
		}
		return url;
	}
}
