package com.allen.enums;


public enum ResCode {

    OK("200","请求成功");


    private ResCode(String code,String des){
        this.code=code;
        this.des=des;
    }
    private String code;
    private String des;
    public static String getDes(String code){
        ResCode[] values = values();
        for (ResCode value : values) {
            if (value.code.equals(code)){
                return value.des;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String des = getDes("200");
        System.out.println(des);
    }
}
