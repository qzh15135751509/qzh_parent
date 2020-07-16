import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dj.ssm.pojo.SsmpUser;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        String str1 = "{\"userName\":\"q\",\"userPwd\":\"123\"}";
        String str = "[{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"},{\"userName\":\"qc\",\"userPwd\":\"123\"},{\"userName\":\"qw\",\"userPwd\":\"123\"}]";
        String str2 = "{\"userList\":[{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"}],\"money\" : \"120\"}";
        String str3 = "[{[{\"name\":\"w\"},{\"name\":\"ww\"}],\"money\":\"123\"},{[{\"name\":\"qq\"},{\"name\":\"q\"}],\"money\":\"123\"},{[{\"name\":\"rr\"},{\"name\":\"r\"}],\"money\":\"123\"}]";
     /*  JSONObject obj = JSONObject.parseObject(str1);
        SsmpUser ssmpUser = obj.toJavaObject(SsmpUser.class);
        System.out.println(ssmpUser.getUserName()+"--"+ssmpUser.getUserPwd());

        JSONArray arr = JSONArray.parseArray(str);
        List<SsmpUser> ssmpUsers = arr.toJavaList(SsmpUser.class);
        System.out.println(ssmpUsers.size());
        System.out.println(ssmpUsers.toString());*/
        JSONArray arr = JSONArray.parseArray(str3);


    }
}
