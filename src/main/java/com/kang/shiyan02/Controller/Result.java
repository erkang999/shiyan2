package com.kang.shiyan02.Controller;

import lombok.Data;

@Data
public class Result {
    private  Object data;
    private  String msg;

    public Result(Object data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public Result() {
    }
}
