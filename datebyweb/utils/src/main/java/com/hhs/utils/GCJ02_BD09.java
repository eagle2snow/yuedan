package com.hhs.utils;

/**
 * 坐标转换类
 */
public class GCJ02_BD09 {  
    
    public static double pi = 3.141592653589793 * 3000.0 / 180.0;  
  
    public static void main(String[] args) {  
  
        // GCJ02 ——> BD09  
       // gcj02_To_Bd09(116.422954, 40.010749).print();  
  
        // BD09 ——> GCJ02  
       // bd09_To_Gcj02(121.481085, 31.236173).print();  
    }  
  
    /** 
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标 
     *  
     * @param gg_lat 
     * @param gg_lon 
     * @return 
     */  
    public static Gps gcj02_To_Bd09(double gg_lon, double gg_lat) {  
        double x = gg_lon, y = gg_lat;  
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * pi);  
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * pi);  
        double bd_lon = z * Math.cos(theta) + 0.0065;  
        double bd_lat = z * Math.sin(theta) + 0.006;  
        return new Gps(bd_lon, bd_lat);  
    }  
  
    /** 
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法   将 BD-09 坐标转换成GCJ-02 坐标  
     *  
     * @param bd_lon 
     * @param bd_lat 
     * @return 
     */  
    public static Gps bd09_To_Gcj02(double bd_lon, double bd_lat) {  
        double x = bd_lon - 0.0065, y = bd_lat - 0.006;  
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * pi);  
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * pi);  
        double gg_lon = z * Math.cos(theta);  
        double gg_lat = z * Math.sin(theta);  
        return new Gps(gg_lon, gg_lat);  
    }  
  
    //Gps类  
    public static class Gps {  
  
        public double lat;  
        public double lon;  
  
        public Gps(double lon, double lat) {  
            this.lat = lat;  
            this.lon = lon;  
        }  
  
        public void print() {  
            System.out.println(this.lon + "," + this.lat);  
        }  
    }  
  
}  



