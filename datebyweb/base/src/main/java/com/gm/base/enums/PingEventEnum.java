package com.gm.base.enums;

/**
 * ping ++ 事件
 * 
 * @author ying
 *
 */
public enum PingEventEnum {

	summary_daily_available("summary.daily.available", "上一天 0 点到 23 点 59 分 59 秒的交易金额和交易量统计，在每日 04:00 点左右触发"),

	summary_weekly_available("summary.weekly.available", "上周一 0 点至上周日 23 点 59 分 59 秒的交易金额和交易量统计，在每周一 04:00 点左右触发"),

	summary_monthly_available("summary.monthly.available", "上月一日 0 点至上月末 23 点 59 分 59 秒的交易金额和交易量统计，在每月一日 04:00 点左右触发"),

	charge_succeeded("charge.succeeded", "支付对象，支付成功时触发"),

	refund_succeeded("refund.succeeded", "退款对象，退款成功时触发"),

	transfer_succeeded("transfer.succeeded", "企业支付对象，支付成功时触发"),

	red_envelope_sent("red_envelope.sent", "红包对象，红包发送成功时触发"),

	red_envelope_received("red_envelope.received", "红包接收成功时触发"),

	batch_transfer_succeeded("batch_transfer.succeeded", "批量企业付款对象，批量企业付款成功时触发"),

	customs_succeeded("customs.succeeded", "报关对象，报关成功时触发"),

	batch_refund_succeeded("batch_refund.succeeded", "批量退款对象，批量退款成功时触发"),

	;

	private String name;
	private String desc;

	private PingEventEnum(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
