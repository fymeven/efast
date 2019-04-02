package cn._51even.efast.core.system;

/**
 * Created by Administrator on 2018/5/19.
 */



/**
 * 返回结果封装类
 */
public class ResponseResult {

    private static final String SUCCESS_CODE="200";

    private static final String ERROR_CODE="500";

    private static final String SUCCESS_MESSAGE="操作成功";

    private static final String ERROR_MESSAGE="操作失败";

    public static ResponseResult SUCCESS=new ResponseResult(true,SUCCESS_CODE,SUCCESS_MESSAGE);

    public static ResponseResult ERROR=new ResponseResult(false,ERROR_CODE,ERROR_MESSAGE);

    public static ResponseResult successData(Object data){
        return new ResponseResult(true,SUCCESS_CODE,SUCCESS_MESSAGE,data);
    }

    public static ResponseResult successMsg(String message){
        return new ResponseResult(true,SUCCESS_CODE,message,null);
    }

    public static ResponseResult errorMsg(String message){
        return new ResponseResult(false,ERROR_CODE,message,null);
    }


    public static ResponseResult error(String message,Object data){
        return new ResponseResult(false,ERROR_CODE,message,data);
    }

    public static ResponseResult error(String code,String message,Object data){
        return new ResponseResult(false,code,message,data);
    }

    public ResponseResult() {
    }

    public ResponseResult(boolean status,String code,String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ResponseResult success(String message, Object data) {
        return new ResponseResult(true,SUCCESS_CODE,message,data);
    }

    public ResponseResult(boolean status,String code, String message, Object data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //返回结果
    private boolean status=false;
    //消息
    private String message;
    //状态码
    private String code=SUCCESS_CODE;
    //返回数据
    private Object data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
