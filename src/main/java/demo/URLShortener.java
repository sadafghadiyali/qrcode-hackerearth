package demo;

import java.util.HashMap;
import java.util.Map;

public class URLShortener {
	static final Map<String, String> map = new HashMap<>();
    static final String BASE_HOST = "http://localhost:8080/Demo_Project/urlgenerator/";

    public String encode(String longUrl)
	{
		String shortUrl = BASE_HOST + Math.abs(longUrl.hashCode());
		map.put(shortUrl, longUrl);
		return shortUrl;
    }

    public String decode(String shortUrl)
	{
		return map.get(shortUrl);
    }
}
