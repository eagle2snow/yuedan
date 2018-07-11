import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-tool',
  templateUrl: './tool.component.html',
  styleUrls: ['./tool.component.css']
})
export class ToolComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {

    document.addEventListener("touchstart", function () {
    }, true);
    var $$ = document.querySelectorAll.bind(document);
    Element.prototype.on = Element.prototype.addEventListener;
    Element.prototype.off = Element.prototype.removeEventListener;
    var ForEach = function (array, fn) {
      [].forEach.call(array, fn);
    };

    function disableScroll(e) {
      e.preventDefault();
    }

    var sticky = CSS.supports("position", "sticky") || CSS.supports("position", "-webkit-sticky");

// slide
    if (typeof TouchSlide == "function") {
      function focusBn(cell) {
        TouchSlide({
          slideCell: cell,
          titCell: ".hd",
          mainCell: ".bd",
          effect: "leftLoop",
          autoPlay: true,
          autoPage: true,
          delayTime: 500,
          interTime: 5000
        });
      }
      focusBn("#ibn");
      //
      function TabSlide(cell, cellbd, page) {
        TouchSlide({
          slideCell: cell,
          defaultIndex: page,
          endFun: function (i) { //高度自适应
            var bd = document.getElementById(cellbd);
            bd.parentNode.style.height = bd.children[i].children[0].offsetHeight + "px";
            if (i > 0) bd.parentNode.style.transition = "200ms";//添加动画效果
          }
        });
      }
      TabSlide("#tabBox", "tabBox-bd");
      TabSlide("#tabBox-page02", "tabBox-bd", 1);
    }
// end slide

    var $$html = document.querySelector("html");
    var $$body = document.querySelector("body");
    var header = document.getElementById("header");


// listclass
    listClass($$(".sortcldd a"), "selected");
    listClass($$(".spnav.sortbarhd_item"), "active");
// end listclass


// sortbar
    scrollClass("scrollbox01");
    (function () {
      var sortbarWrap = document.getElementById("sortbarWrap");
      var sortbar = document.getElementById("sortbar");
      if (sortbarWrap && sortbar) {
        var sortbarTop = getOffset(sortbarWrap).top;
        var sortbarHditem = sortbar.querySelectorAll(".sortbarhd_item"),
          sortbarItem = sortbar.querySelectorAll(".sortbar_item");
        if (header && header.classList.contains("tofixed")) {
          sortbarTop = sortbarTop - header.clientHeight;
        }
        ;
        ForEach(sortbarHditem, function (el) {
          el.addEventListener("click", function () {
            document.documentElement.scrollTop = window.pageYOffset = document.body.scrollTop = sortbarTop;
            if (this.classList.contains("hasftsort")) {
              removeSiblingClass(this, "active");
              sortbarWrap.classList.remove("show");
              if (this.getAttribute("data-sort") == "up") {
                this.setAttribute("data-sort", "down");
              } else {
                this.setAttribute("data-sort", "up");
              }
            } else if (this.classList.contains("hasbd")) {
              if (this.classList.contains("active")) {
                sortbarWrap.classList.remove("show");
                this.classList.remove("active");
                ForEach(sortbarItem, function (fiteritem) {
                  fiteritem.style.display = "none";
                });
                hscorll();
              } else {
                removeSiblingClass(this, "active");
                sortbarWrap.classList.add("show");
                document.body.scrollTop = sortbarTop;
                nohscorll(sortbar.querySelector(".sortbarbd"));
                var sortbarAttr = this.dataset["sort"];
                ForEach(sortbarItem, function (bdel) {
                  bdel.style.display = "none";
                  bdel.dataset["sort"] == sortbarAttr ? function () {
                    bdel.style.display = "block";
                  }() : 0;
                });
              }
            } else {
              removeSiblingClass(this, "active");
              sortbarWrap.classList.remove("show");
              hscorll();
            }
          });
        });
        ForEach($$(".closesortbar"), function (el) {
          el.addEventListener("click", function () {
            sortbarWrap.classList.remove("show");
            ForEach(sortbarHditem, function (fiterhditem) {
              fiterhditem.classList.remove("active");
            });
            ForEach(sortbarItem, function (fiteritem) {
              fiteritem.style.display = "none";
            });
            hscorll();
          });
        });
      }
      ;
      // selist
      listClass($$(".sortbar_selist>li"), "selected");
      // end selist
    })();
// end sortbar


// scrollIntop
    (function () {
      if (header && header.classList.contains("tofixed")) {
        window.addEventListener("scroll", function () {
          var scrollTop = (document.documentElement && document.documentElement.scrollTop) || document.body.scrollTop;
          if (scrollTop > 0) {
            $$html.classList.add("scrollIntop");
            header.classList.remove("inbn");
            header.classList.remove("style2");
          } else {
            $$html.classList.remove("scrollIntop");
            header.classList.add("inbn");
            header.classList.add("style2");
          }
        });
      }
      ;
    })()
// end scrollIntop


// scrollClass
    function scrollClass(obj) {
      var _ths = document.getElementById(obj);
      if (_ths) {
        var $$html = document.querySelector("html"),
          _thsHeight = _ths.clientHeight,
          _thsTop = getOffset(_ths).top;

        function scrollfn(offtop) {
          if (offtop > _thsTop) {
            $$html.classList.add("navfixed");
            if (offtop > _thsTop + _thsHeight) {
              $$html.classList.remove("navfixed");
            }
            ;
          } else {
            $$html.classList.remove("navfixed");
          }
        }

        if (!sticky) {
          window.addEventListener("scroll", function () {
            var scrollTop = (document.documentElement && document.documentElement.scrollTop) || document.body.scrollTop;
            scrollfn(scrollTop);
          });
        }
      }
    }

// end scrollClass

// todo 广播新闻条 等需求明确再加
// fadenews
//     function fadenewsCarousel() {
//       var _list = document.getElementById("fadenews"),
//         _item = _list.querySelectorAll(".fadenews_item"),
//         _length = _item.length,
//         _count = 0;
//       _item[_count].classList.add("active");
//       this.carousel = function () {
//         var that = this;
//         if (_count < _length) {
//           Array.prototype.filter.call(_item[_count].parentNode.children, function (child) {
//             if (child !== _item[_count]) {
//               child.classList.remove("active");
//             }
//             ;
//           });
//           _item[_count].classList.add("active");
//           _count++;
//         } else {
//           _count = 0;
//           Array.prototype.filter.call(_item[_count].parentNode.children, function (child) {
//             if (child !== _item[_count]) {
//               child.classList.remove("active");
//             }
//             ;
//           });
//           _item[_count].classList.add("active");
//         }
//         setTimeout(that.carousel, 8000);
//       }
//       window.setTimeout(this.carousel.bind(this), 8000);
//     }
//
//     document.addEventListener("DOMContentLoaded", function () {
//       (function () {
//         var fadenews = document.getElementById("fadenews");
//         fadenews ? fadenewsCarousel() : 0;
//       })();
//     });
// end fadenews


// 滚动新闻
    function scrollNew(wrap, speed) {
      var scrollNews = document.getElementById(wrap);
      if (scrollNews) {
        var scrollnewsList = scrollNews.querySelector(".list"),
          scrollNewsH = scrollNews.clientHeight,
          scrollnewsLi = scrollNews.querySelectorAll(".scrollitem"),
          scrollNewsCount = scrollnewsLi.length,
          scrollNewsAmount = 1,
          cloneLi = scrollnewsLi[0].cloneNode(true);
        scrollnewsList.appendChild(cloneLi);
        this.scroll = function () {
          var that = this;
          if (scrollNewsAmount <= scrollNewsCount) {
            var TransformH = scrollNewsAmount * scrollNewsH;
            setStyle(scrollnewsList, {
              transform: "translateY(-" + TransformH + "px)",
              webkitTransform: "translateY(-" + TransformH + "px)",
              transitionDuration: "300ms",
              webkitTransitionDuration: "300ms"
            });
            window.setTimeout(function () {
              that.scroll()
            }, speed);
            scrollNewsAmount += 1;
          } else {
            setStyle(scrollnewsList, {
              transform: "translateY(0px)",
              webkitTransform: "translateY(0px)",
              transitionDuration: "0ms",
              webkitTransitionDuration: "0ms"
            });
            window.setTimeout(function () {
              that.scroll()
            }, 0);
            scrollNewsAmount = 1;
          }
        }
        window.setTimeout(this.scroll.bind(this), speed);
      }
      ;
    }

    document.addEventListener("DOMContentLoaded", function () {
      var scrollnews = new scrollNew("scrollnews", 5000);
    });

// end 滚动新闻


    function nohscorll(elm) {
      var $$html = document.querySelector("html");
      $$html.classList.add("noscorll");
      $$html.on("touchmove", disableScroll);
      elm != null ? elm.on("touchmove", function (e) {
        e.stopPropagation()
      }) : 0;
    }

    function hscorll() {
      var $$html = document.querySelector("html");
      $$html.classList.remove("noscorll");
      $$html.off("touchmove", disableScroll);
    }


    function removeSiblingClass(obj, cls) {
      Array.prototype.filter.call(obj.parentNode.children, function (child) {
        if (child !== obj) {
          child.classList.remove(cls);
        }
        ;
        obj.classList.add(cls);
      });
    }

//
    function radioClass(el, cls) {
      ForEach(el.parentNode.children, function (sib) {
        sib.classList.remove(cls);
      });
      el.classList.add(cls);
    }

    function listClass(els, cls) {
      ForEach(els, function (el) {
        el.addEventListener("click", function () {
          removeSiblingClass(this, cls)
        });
      });
    }

//

// 设置css
    function setStyle(obj, json) {
      for (var i in json) {
        obj.style[i] = json[i];
      }
    }

// end 设置css

// getOffset
    function getOffset(el) {
      const box = el.getBoundingClientRect();

      return {
        top: box.top + window.pageYOffset - document.documentElement.clientTop,
        left: box.left + window.pageXOffset - document.documentElement.clientLeft
      }
    }

// end getOffset


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


  } // ngOnInit()

} // class ToolCOmponent
