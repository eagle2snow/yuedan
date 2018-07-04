<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/wx/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>商品评价</title>
    <%@ include file="/common/wx/mate.jsp" %>
    <%@ include file="/common/wx/css.jsp" %>
    <style>
        .leftIcon {
            width: 7rem;
            height: 7rem;
            position: absolute;
            top: 24rem;
            left: 3rem;
            display: block;
        }

        #leftFile {
            position: absolute;
            top: 30rem;
            left: 5rem;
        }

        .rightIcon {
            width: 7rem;
            height: 7rem;
            position: absolute;
            top: 24rem;
            left: 19rem;
            display: block;
        }

        #rightFile {
            position: absolute;
            top: 30rem;
            left: 21rem;
        }

        .hiddenInput {
            opacity: 0;
            z-index: 99;
        }

    </style>
</head>
<body>
<div class="mbox">
    <div id="memberId" style="display: none">${orderItems.order.member.id}</div>
    <div id="orderid" style="display: none">${orderItems.id}</div>
    <div id="commodityid" style="display:none ">${orderItems.commodity.id}</div>
    <div class="simplecutproitem">
        <div class="simplecutpro">
            <div class="simplecutpro_pic"><img src="${orderItems.commodity.imgerPath}" alt=""></div>
            <span class="givescorebox">
					综合评价
					<span class="givescore">
						<i id="xx1" class="givescore_item"></i>
						<i id="xx2" class="givescore_item"></i>
						<i id="xx3" class="givescore_item"></i>
						<i id="xx4" class="givescore_item"></i>
						<i id="xx5" class="givescore_item"></i>
					</span>
            </span>
        </div>
    </div>
    <form id="form" method="post">
        <div class="textintbox">
            <textarea id="text" placeholder="点击此处，说说它的优点与美中不足吧~" class="remark_textint textint"></textarea>
            <div class="picthumbs">
                <div class="picthumbitm"><img src="${orderItems.imgerPath}" alt=""></div>
                <div class="picthumbitm"><img src="${orderItems.imgerPath}" alt=""></div>
            </div>
        </div>
    </form>



    <div>
        <img id="img1" hidden="hidden">
        <img id="img2" hidden="hidden">
        <img id="img3" hidden="hidden">
        <img id="img4" hidden="hidden">
        <img id="img5" hidden="hidden">
    </div>
    <img src="/static/wx/images/icon/cam.png" alt="  " id="cam">
    <div>
        <input id="upload1" name="file" accept="image/*" type="file" multiple="multiple" style="display: none">
        <input id="upload2" name="file" accept="image/*" type="file" multiple="multiple" style="display: none">
        <input id="upload3" name="file" accept="image/*" type="file" multiple="multiple" style="display: none">
        <input id="upload4" name="file" accept="image/*" type="file" multiple="multiple" style="display: none">
        <input id="upload5" name="file" accept="image/*" type="file" multiple="multiple" style="display: none">
    </div>


</div>
<div class="fbottom">
    <nav class="btool">
        <div class="btool_halfcont"><a onclick="confirmComments()" class="primarybtn btoolbtn">确认评价</a></div>
    </nav>
</div>

<%@ include file="/common/wx/js.jsp" %>
<%@ include file="/common/wx/socket.jsp" %>

<script src="/static/wx/js/tool.js"></script>
<script src="/static/tools/imageOp.js"></script>
<script type="text/javascript">
    $(function () {
        let inputCount = 1
        let imgCount = 0
        $("#cam").click(function () {
            const input = $("#upload" + inputCount)
            input.change(function() {
                const len = this.files.length
                if (len + imgCount > 5) {
                    alert("最多只能上传5张图片!")
                    return
                }
                for (let i = 1; i <= len; ++i) {
                    const url = getObjectURL(this.files[i - 1])
                    const img = $("#img" + (i + imgCount))
                    img.attr("src", url).attr("width", "100rem").show()
                }
                inputCount += 1
                imgCount += len
            })
            input.click()
        })
    });

    function makePromise(file, form) {
        let i = 1
        return new Promise((resolve) => {
            const fileSize = file.size / 1024
            if (fileSize > 2048) {
                photoCompress(file, {
                    quality: 0.2
                }, function (base64Codes) {
                    const compressed = convertBase64UrlToBlob(base64Codes)
                    form.append("file[]" + i, compressed, "compressed.jpg" + i);
                    ++i
                    resolve()
                })
            } else {
                form.append("file[]" + i, file, "orginal.jpg" + i)
                ++i
                resolve()
            }
        })
    }

    function confirmComments() {
        const text = $("#text").val()
        if (text == "" || $.trim(text) == '') {
            $.alert("请输入评价内容", "提示");
            return
        }

        const form = new FormData()
        const promises = []
        for (let i = 1; i <= 5; ++i) {
            const files = document.getElementById("upload" + i).files
            for (let j = 0; j < files.length; ++j)
                promises.push(makePromise(files[j], form))
        }

        form.append("xx", a)
        form.append("text", text)
        form.append("memberId", $("#memberId").html())
        form.append("orderid", $("#orderid").html())
        form.append("commodityid", $("#commodityid").html())
        Promise.all(promises).then(() => {
            alert("是否开始上传文件")
            $.ajax({
                url : "${ctx}wx/comments/confirmComments",
                type : 'POST',
                data : form,
                contentType: false,
                processData: false,
                dataType: 'json',
                success: function(data) {
                    if (data == 'ok')
                        location.href = '${ctx}wx/comments/commentSucceed'
                    else
                        location.href = '${ctx}wx/comments/commentFailure/' +${orderId};
                },
                error: function() {
                    $.alert('系统出错　请稍后再试')
                }
            });
        })
    }

    var a = "";
    $('#xx1').click(function () {
        a = 1;
        $('#xx1').attr({class: "givescore_item1"});
        $('#xx2').attr({class: "givescore_item"});
        $('#xx3').attr({class: "givescore_item"});
        $('#xx4').attr({class: "givescore_item"});
        $('#xx5').attr({class: "givescore_item"});
    });
    $('#xx2').click(function () {
        a = 2;
        $('#xx1').attr({class: "givescore_item1"});
        $('#xx2').attr({class: "givescore_item1"});
        $('#xx3').attr({class: "givescore_item"});
        $('#xx4').attr({class: "givescore_item"});
        $('#xx5').attr({class: "givescore_item"});
    });
    $('#xx3').click(function () {
        a = 3;
        $('#xx1').attr({class: "givescore_item1"});
        $('#xx2').attr({class: "givescore_item1"});
        $('#xx3').attr({class: "givescore_item1"});
        $('#xx4').attr({class: "givescore_item"});
        $('#xx5').attr({class: "givescore_item"});
    });
    $('#xx4').click(function () {
        a = 4;
        $('#xx1').attr({class: "givescore_item1"});
        $('#xx2').attr({class: "givescore_item1"});
        $('#xx3').attr({class: "givescore_item1"});
        $('#xx4').attr({class: "givescore_item1"});
        $('#xx5').attr({class: "givescore_item"});
    });
    $('#xx5').click(function () {
        a = 5;
        $('#xx1').attr({class: "givescore_item1"});
        $('#xx2').attr({class: "givescore_item1"});
        $('#xx3').attr({class: "givescore_item1"});
        $('#xx4').attr({class: "givescore_item1"});
        $('#xx5').attr({class: "givescore_item1"});
    });
</script>

</body>
</html>