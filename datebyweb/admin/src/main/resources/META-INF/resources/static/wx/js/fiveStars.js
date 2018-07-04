		/*
		 * 根据index获取 str
		 * **/
		function byIndexLeve(index) {
			var str = "";
			switch(index) {
				case 0:
					str = "差评";
					break;
				case 1:
					str = "较差";
					break;
				case 2:
					str = "中等";
					break;
				case 3:
					str = "一般";
					break;
				case 4:
					str = "好评";
					break;
			}
			return str;
		}
		// 星星数量
		var stars = [
			['x2.png', 'x1.png', 'x1.png', 'x1.png', 'x1.png'],
			['x2.png', 'x2.png', 'x1.png', 'x1.png', 'x1.png'],
			['x2.png', 'x2.png', 'x2.png', 'x1.png', 'x1.png'],
			['x2.png', 'x2.png', 'x2.png', 'x2.png', 'x1.png'],
			['x2.png', 'x2.png', 'x2.png', 'x2.png', 'x2.png'],
		];
		$(".block li").find("img").hover(function(e) {
			var obj = $(this);
			var index = obj.index();
			if(index < (parseInt($(".block li").attr("data-default-index")) - 1)) {
				return;
			}
			var li = obj.closest("li");
			var star_area_index = li.index();
			for(var i = 0; i < 5; i++) {
				li.find("img").eq(i).attr("src", "http://7xnlea.com2.z0.glb.qiniucdn.com/" + stars[index][i]); //切换每个星星
			}
			$(".level").html(byIndexLeve(index));
		}, function() {})
		$(".block li").hover(function(e) {}, function() {
			var index = $(this).attr("data-default-index"); //点击后的索引
			index = parseInt(index);
			console.log("index", index);
			$(".level").html(byIndexLeve(index - 1));
			console.log(byIndexLeve(index - 1));
			$(".order-evaluation ul li:eq(0)").find("img").attr("src", "http://7xnlea.com2.z0.glb.qiniucdn.com/x1.png");
			for(var i = 0; i < index; i++) {
				$(".order-evaluation ul li:eq(0)").find("img").eq(i).attr("src", "http://7xnlea.com2.z0.glb.qiniucdn.com/x2.png");
			}
		})
		$(".block li").find("img").click(function() {
			var obj = $(this);
			var li = obj.closest("li");
			var star_area_index = li.index();
			var index1 = obj.index();
			li.attr("data-default-index", (parseInt(index1) + 1));
			var index = $(".block li").attr("data-default-index"); //点击后的索引
			index = parseInt(index);
			console.log("index", index);
			$(".level").html(byIndexLeve(index - 1));
			console.log(byIndexLeve(index - 1));
			$(".order-evaluation ul li:eq(0)").find("img").attr("src", "http://7xnlea.com2.z0.glb.qiniucdn.com/x1.png");
			for(var i = 0; i < index; i++) {
				$(".order-evaluation ul li:eq(0)").find("img").eq(i).attr("src", "http://7xnlea.com2.z0.glb.qiniucdn.com/x2.png");
			}
		});
		//印象
		$(".order-evaluation-check").click(function() {
			if($(this).hasClass('checked')) {
				//当前为选中状态，需要取消
				$(this).removeClass('checked');
			} else {
				//当前未选中，需要增加选中
				$(this).addClass('checked');
			}
		});
		//评价字数限制
		function words_deal() {
			var curLength = $("#TextArea1").val().length;
			if(curLength > 140) {
				var num = $("#TextArea1").val().substr(0, 140);
				$("#TextArea1").val(num);
				alert("超过字数限制，多出的字将被截断！");
			} else {
				$("#textCount").text(140 - $("#TextArea1").val().length);
			}
		}
		$("#order_evaluation").click(function() {
			$("#order_evaluate_modal").html("感谢您的评价！么么哒(* ￣3)(ε￣ *)").show().delay(3000).hide(500);
		})
