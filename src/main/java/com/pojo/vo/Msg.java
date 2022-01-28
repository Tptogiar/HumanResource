package com.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tptogiar
 * @description
 * @date 2022/1/28 - 15:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {

    //100-失败
    //200-成功
    private int code;
    private String msg;
    private HashMap<String, Object> data;

    public Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Msg success(String message){
        return new Msg(200, message);
    }

    public static Msg success(){
        return success((String) null);
    }

    public  Msg addData(String key,Object value){
        if (this.data==null){
            this.data=new HashMap<>();
        }
        this.data.put(key,value);
        return this;
    }

}
