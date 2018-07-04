package com.gm.gencode.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Verification {
	/**
	 * 内置基本的datatype类型有： * | *6-16 | n | n6-16 | s | s6-18 | p | m | e | url
	 *	* ：检测是否有输入，可以输入任何字符，不留空即可通过验证； 6-16：检测是否为6到16位任意字符； n：数字类型； n6-16：6到16位数字；
	 * s：字符串类型； s6-18：6到18位字符串； p：验证是否为邮政编码； m：手机号码格式； e：email格式；
	 * url：验证字符串是否为网址。 自定义datatype的名称，可以由字母、数字、下划线、中划线和*号组成。
	 * 形如"*6-16"的datatype，Validform会自动扩展，可以指定任意的数值范围。如内置基本类型有"*6-16"，
	 * 那么你绑定datatype="*4-12"就表示4到12位任意字符。如果你自定义了一个datatype="zh2-4"，表示2到4位中文字符，
	 * 那么datatype="zh2-6"就表示2到6位中文字符。
	 * 5.2版本之后，datatype支持规则累加或单选。用","分隔表示规则累加；用"|"分隔表示规则多选一，即只要符合其中一个规则就可以通过验证，
	 * 绑定的规则会依次验证，只要验证通过，后面的规则就会忽略不再比较。如绑定datatype="m|e"，表示既可以填写手机号码，也能填写邮箱地址，
	 * 如果知道填入的是手机号码，那么就不会再检测他是不是邮箱地址；datatype="zh,s2-4"，表示要符合自定义类型"zh"，
	 * 也要符合规则"s2-4"。
	 * 
	 * @return
	 */
	String datatype() default "";

	/**
	 * 输入内容不能通过验证时的提示信息，默认提示"请输入正确信息！"。 如：errormsg="用户名必须是2到4位中文字符！"
	 * 
	 * @return
	 */
	String errormsg() default "";

	/**
	 * 表单里面经常需要检查两次密码输入是否一致，recheck就是用来指定需要比较的另外一个表单元素。
	 * 如：recheck="password1"，那么它就会拿当前元素的值跟该表单下，name为"password1"的元素比较。
	 * 
	 * @return
	 */
	String recheck() default "";

	/**
	 * 指定ajax实时验证的后台文件的地址。 后台页面如valid.php文件中可以用 $_POST["param"]
	 * 接收到值，Ajax中会POST过来变量param和name。param是文本框的值，name是文本框的name属性。
	 * 5.2版本开始，可以在ajaxurl指定的url后绑定参数，如：ajaxurl=
	 * "valid.php?myparam1=value1&myparam2=value2"；
	 * 5.3.1开始，地址后面附带的参数内部不再做另外解析，仍附带在地址后面，所以需要用GET方式去获取地址后面带的参数。
	 * 
	 * @return
	 */
	String ajaxurl() default "";

	/**
	 * 当表单元素通过验证时的提示信息，不绑定，默认提示"通过信息验证！"。 如：sucmsg="用户名还未被使用，可以注册！"
	 * 5.3版开始，也可以在实时验证返回的json数据里返回成功的提示文字，请查看附加属性ajaxurl的介绍。
	 * 
	 * @return
	 */
	String sucmsg() default "";

	/**
	 * 当表单元素值为空时的提示信息，不绑定，默认提示"请填入信息！"。 如：nullmsg="请填写用户名！
	 * 
	 * @return
	 */
	String nullmsg() default "";

	/**
	 * 绑定了ignore="ignore"的表单元素，在有输入时，会验证所填数据是否符合datatype所指定数据类型，
	 * 没有填写内容时则会忽略对它的验证；
	 * 
	 * @return
	 */
	String ignore() default "";

	/**
	 * 表单里经常有些文本框需要默认就显示一个灰色的提示文字，当获得焦点时提示文字消失，失去焦点时提示文字显示。tip属性就是用来实现这个效果。
	 * 它通常和altercss搭配使用。 如<input type="text" value="默认提示文字" class=
	 * "gray intxt" tip="默认提示文字" altercss="gray" />
	 * 
	 * @return
	 */
	String tip() default "";

	/**
	 * 它需要和tip属性配合使用，altercss指定的样式名，会在文本框获得焦点时被删除，没有输入内容而失去焦点时重新加上。
	 * 
	 * @return
	 */
	String altercss() default "";

	/*
	 * 指定需要使用的插件。 5.3版开始，对于日期、swfupload和密码强度检测这三个插件，绑定了plugin属性即可以初始化对应的插件，
	 * 可以不用在validform初始化时传入空的usePlugin了。 如，你要使用日期插件，5.3之前版本需要这样初始化：
	 * $(".demoform").Validform({ usePlugin:{ datepicker:{} } });
	 */
	String plugin() default "";
}
