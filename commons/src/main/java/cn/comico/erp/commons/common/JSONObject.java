package cn.comico.erp.commons.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName JSONObject
 * @Description TODO
 * @date 2018/7/18 10:44
 **/
public class JSONObject {

    private ObjectMapper mapper;

    private ObjectNode node;

    public JSONObject() {
        mapper = new ObjectMapper();
        node = mapper.createObjectNode();
    }

    public JSONObject put(String key, Object val) {
        node.putPOJO(key, val);
        return this;
    }

    public JsonNode get(String key) {
        return node.get(key);
    }

    public String toJSONString() {
        String result = null;
        try {
            result = mapper.writeValueAsString(node);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("name","hch").put("id", "001");
        String string = json.toJSONString();
        System.out.println(string);
    }

}
