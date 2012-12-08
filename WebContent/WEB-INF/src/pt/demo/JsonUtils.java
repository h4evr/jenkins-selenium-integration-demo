package pt.demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

public class JsonUtils {
	public static void respondWithJson(String json, HttpServletResponse response) {
		response.setContentType("application/json");
		try {
			response.getOutputStream().write(json.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
