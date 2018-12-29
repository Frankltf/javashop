package com.ltf.shop.http;

import com.ltf.shop.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GetDemo {

    @RequestMapping(params = "/{city_id}/{user_id}",method = RequestMethod.GET)
    public Object findOne(
            @PathVariable("city_id") String cityId,
            @PathVariable("user_id") String userId
    ){
        Map<String,Object> params=new HashMap<>();
        params.put("city_id",cityId);
        params.put("user_id",userId);
        return params;
    }

    /**
     *
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/findTwo")
    public Object findTwo(int from,int size){
        Map<String,Object> params=new HashMap<>();
        params.put("from",from);
        params.put("size",size);
        return params;
    }

    @GetMapping(value = "/v1/findThree")
    public Object findThree(HttpServletRequest request){
        Map<String,Object> params=new HashMap<>();
        String id=request.getParameter("id");
        params.put("id",id);
        return params;
    }


    /**
     * 功能描述：bean对象传参
     * 注意：1、注意需要指定http头为 content-type为application/json
     * 		2、使用body传输数据
     * @param user
     * @return
     */
    @RequestMapping(value = "/v1/findFour")
    public Object findFour(@RequestBody User user){
        Map<String,Object> params=new HashMap<>();
        params.put("user",user);
        return params;
    }


}
