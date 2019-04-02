package cn._51even.efast.core.config;

public class DataSourceContextHolder {

    private static final  ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String dataSource){
        contextHolder.set(dataSource);
    }

    public static String getDataSource(){
        return contextHolder.get();
    }

    public static void clearDataSource(){
        contextHolder.remove();
    }
}
