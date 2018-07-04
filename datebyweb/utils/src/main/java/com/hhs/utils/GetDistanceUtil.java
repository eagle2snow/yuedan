package com.hhs.utils;

import java.text.DecimalFormat;

public class GetDistanceUtil {
	private final static double EARTH_RADIUS = 6378.137;// 地球半径

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 根据经纬度计算两点间的距离
	 * 
	 * @param lng1 经度1
	 * @param lat1 纬度1
	 * @param lng2 经度2
	 * @param lat2 纬度2
	 * @return
	 */
	public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	public static double GetShortDistance(double lon1, double lat1, double lon2, double lat2) {

		double ew1, ns1, ew2, ns2;
		double dx, dy, dew;
		double distance;
		double DEF_PI = 3.14159265359; // PI
		double DEF_2PI = 6.28318530712; // 2*PI
		double DEF_PI180 = 0.01745329252; // PI/180.0
		double DEF_R = 6370693.5; // radius of earth
		// 角度转换为弧度
		ew1 = lon1 * DEF_PI180;
		ns1 = lat1 * DEF_PI180;

		ew2 = lon2 * DEF_PI180;
		ns2 = lat2 * DEF_PI180;
		// 经度差
		dew = ew1 - ew2;
		// 若跨东经和西经180 度，进行调整
		if (dew > DEF_PI)
			dew = DEF_2PI - dew;
		else if (dew < -DEF_PI)
			dew = DEF_2PI + dew;
		dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
		dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)
		// 勾股定理求斜边长
		distance = Math.sqrt(dx * dx + dy * dy);
		DecimalFormat df = new DecimalFormat("#.##");
		String distanceStr = df.format(distance / 1000);
		distance = Double.parseDouble(distanceStr);
		return distance;
	}

}
