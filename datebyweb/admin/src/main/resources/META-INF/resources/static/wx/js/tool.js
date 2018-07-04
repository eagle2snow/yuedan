document.addEventListener("touchstart", function(){}, true);
var $$ = document.querySelectorAll.bind(document);
Element.prototype.on = Element.prototype.addEventListener;
Element.prototype.off = Element.prototype.removeEventListener;
var ForEach = function (array, fn) {
	[].forEach.call(array, fn);
};
function disableScroll(e){e.preventDefault();}

// slide
if (typeof TouchSlide == "function") {
	function focusBn(cell){
		TouchSlide({slideCell:cell, titCell:".hd", mainCell:".bd", effect:"leftLoop", autoPlay:true, autoPage:true, delayTime: 500, interTime:5000});
	}
	focusBn("#ibn");
};
// end slide



document.addEventListener("DOMContentLoaded", function(){

var $$html = document.querySelector("html");
var $$body = document.querySelector("body");




// select
ForEach($$(".selint_select"),function (el){
	el.addEventListener("change", function(){
		var selint = closest(this,".selint"),
			selintLabel = selint.querySelector(".selint_label");
		if (selintLabel.nodeName == "INPUT") {
			selintLabel.value = this.options[this.options.selectedIndex].text;
		}else{
			selintLabel.textContent = this.options[this.options.selectedIndex].text;
		}
	});
});
// end select





// numBox
//(function(){
//	var numBox = document.querySelectorAll(".numBox");
//	[].forEach.call(numBox, function (numel) {
//		var reduceNum = numel.querySelector(".reduceNum"),
//			textNum = numel.querySelector(".numtext"),
//			increaseNum = numel.querySelector(".increaseNum");
//	  reduceNum.addEventListener("click", function() {
//	    if(parseInt(textNum.value) == 1) return;
//		textNum.value = parseInt(textNum.value) - 1;
//	  }, false);
//	  increaseNum.addEventListener("click", function() {
//		textNum.value = parseInt(textNum.value) + 1;
//	  }, false);
//	});
//})();
// end numBox










});

// delAddressitem
function delAddressitem(obj){
	var _ths = obj,
		item = closest(_ths,".addressitem");
	item.parentNode.removeChild(item);
}
// end delAddressitem





function closest(el, selector) {
	const matchesSelector = el.matches || el.webkitMatchesSelector || el.mozMatchesSelector || el.msMatchesSelector;

	while (el) {
		if (matchesSelector.call(el, selector)) {
			return el;
		} else {
			el = el.parentElement;
		}
	}
	return null;
}


function parentsUntil(el, selector, filter) {
	const result = [];
	const matchesSelector = el.matches || el.webkitMatchesSelector || el.mozMatchesSelector || el.msMatchesSelector;

	// match start from parent
	el = el.parentElement;
	while (el && !matchesSelector.call(el, selector)) {
		if (!filter) {
			result.push(el);
		} else {
			if (matchesSelector.call(el, filter)) {
			  result.push(el);
			}
		}
		el = el.parentElement;
	}
	return result;
}

