package com.evanf.dddmusicstore.integration.consumer;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.models.Swagger;
import io.swagger.parser.Swagger20Parser;
import io.swagger.parser.SwaggerParser;


public class JsonTest {
	private static final Logger logger=LoggerFactory.getLogger(JsonTest.class); 
	@Test
	public void test() throws IOException {
		Swagger swagger=new SwaggerParser().read("https://us-dev-mycis.synnex.org/customer-service/v2/api-docs.json");
		logger.info(swagger.toString());
	}

	private void jsonDes2() throws IOException, JsonParseException, JsonMappingException {
		String jsonContent=FileUtils.readFileToString(new File("F:\\sources\\api-docs.json"));
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node=objectMapper.readValue(jsonContent, JsonNode.class);
		JsonNode paths=node.get("paths");
		for(Iterator<JsonNode> nodeIterator=paths.elements();nodeIterator.hasNext();){
			JsonNode path=nodeIterator.next();
			JsonNode post=path.get("post");
			JsonNode resonse=post.get("responses");
			JsonNode reponseFor200=resonse.get("200");
			JsonNode schema=reponseFor200.get("schema");
			JsonNode ref=schema.get("$ref");
			for(Iterator<JsonNode> test=ref.iterator();test.hasNext();){
			}
			logger.info(ref.toString());
		}
		logger.info("xxxx");
	}
	
	private void jsonDes() throws IOException{
//		String jsonContent=FileUtils.readFileToString(new File("F:\\sources\\api-docs.json"));
//		JSONObject swaggerJson=JSONObject.parseObject(jsonContent.replaceAll("\\$ref", "ref"));
//		JSONObject paths=(JSONObject) swaggerJson.get("paths");
//		for(Entry<String,Object> path : paths.entrySet()){
//			System.out.println(path.getKey()+" "+path.getValue());
//		}
		
	}
}