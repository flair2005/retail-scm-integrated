package translation;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import com.google.gson.Gson;

import baiduservicecommon.BaiduInstantService;
import baiduservicecommon.URLBuilder;

public class TranslationService extends BaiduInstantService {
	
	public TranslationResponse translate(String chineseOrEnglish) throws URISyntaxException, Exception
	{
		
		
		String urlExpr=buildRequestURL(chineseOrEnglish);
		log(urlExpr);
		String content=callBaiduAPI(new URI(urlExpr));     
        Gson gson = new Gson();     
        log(content);
        final TranslationResponse transResponse=gson.fromJson(content,TranslationResponse.class);
        log(transResponse.getErrMsg());
        
        if(transResponse.getErrNum()!=0){
        	throw new IllegalStateException("Service  returns error: "+transResponse.getErrMsg());
        }
        
		return transResponse;
		
	}
	
	
	public TranslationResponse translateTo(String english, String language) throws URISyntaxException, Exception
	{
		
		
		String urlExpr=buildRequestURL(english,language);
		log(urlExpr);
		String content=callBaiduAPI(new URI(urlExpr));     
        Gson gson = new Gson();     
        log(content);
        final TranslationResponse transResponse=gson.fromJson(content,TranslationResponse.class);
        log(transResponse.getErrMsg());
        
        if(transResponse.getErrNum()!=0){
        	throw new IllegalStateException("Service  returns error: "+transResponse.getErrMsg());
        }
        
		return transResponse;
		
	}
	
	
	public String buildRequestURL(String english, String lang) throws UnsupportedEncodingException
	{
		
		URLBuilder builder=new URLBuilder("http://apis.baidu.com/apistore/tranlateservice/translate");
		return builder.parameter("from", "en").parameter("to", lang).parameter("query", english).done();

	}
	
	public String buildRequestURL(String chineseOrEnglish) throws UnsupportedEncodingException
	{
		
		URLBuilder builder=new URLBuilder("http://apis.baidu.com/apistore/tranlateservice/translate");
		
		if(chineseOrEnglish.charAt(0)<128){
				
			return builder.parameter("from", "en").parameter("to", "zh").parameter("query", chineseOrEnglish).done();
			
		}

		return builder.parameter("from", "zh").parameter("to", "en").parameter("query", chineseOrEnglish).done();

	}
}
