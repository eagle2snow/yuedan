(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error('Cannot find module "' + req + '".');
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<script>\r\n  alert('helo')\r\n</script>\r\n\r\n<router-outlet></router-outlet>\r\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'app';
    }
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _app_routes__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app.routes */ "./src/app/app.routes.ts");
/* harmony import */ var _home_home_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./home/home.component */ "./src/app/home/home.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};






var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"],
                _home_home_component__WEBPACK_IMPORTED_MODULE_5__["HomeComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forRoot(_app_routes__WEBPACK_IMPORTED_MODULE_4__["appRoutes"])
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/app.routes.ts":
/*!*******************************!*\
  !*** ./src/app/app.routes.ts ***!
  \*******************************/
/*! exports provided: appRoutes */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "appRoutes", function() { return appRoutes; });
/* harmony import */ var _home_home_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./home/home.component */ "./src/app/home/home.component.ts");

var appRoutes = [
    {
        path: '',
        redirectTo: 'ang/home',
        pathMatch: 'full'
    },
    {
        path: 'ang/home',
        component: _home_home_component__WEBPACK_IMPORTED_MODULE_0__["HomeComponent"]
    }
];


/***/ }),

/***/ "./src/app/home/home.component.css":
/*!*****************************************!*\
  !*** ./src/app/home/home.component.css ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/home/home.component.html":
/*!******************************************!*\
  !*** ./src/app/home/home.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<link rel=\"stylesheet\" type=\"text/css\" href=\"/assets/css/css.css\"/>\n<meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" name=\"viewport\"/>\n<meta content=\"yes\" name=\"apple-mobile-web-app-capable\"/>\n<meta content=\"black\" name=\"apple-mobile-web-app-status-bar-style\"/>\n<meta name=\"format-detection\" content=\"telephone=no\"/>\n<meta name=\"format-detection\" content=\"email=no\"/>\n<meta name=\"msapplication-tap-highlight\" content=\"no\">\n\n<!-- header -->\n<header class=\"tofixed inbn style2 header\" id=\"header\">\n  <div class=\"headcenter\"><img src=\"/assets/images/icon/headlogo.png\" alt=\"\" class=\"headlogo\"/></div>\n  <div class=\"headr\">\n    <a href=\"###\" class=\"headbtn\"><i class=\"search_hico hico\"></i></a>\n    <a href=\"###\" class=\"headbtn\"><i class=\"mes_hico hico\"></i><span class=\"ntnum\">99+</span></a>\n  </div>\n</header>\n<!--end header-->\n<!-- banner -->\n<div class=\"ibn\" id=\"ibn\">\n  <ul class=\"bd\">\n    <li><a href=\"###\"><img src=\"/assets/images/banner/ibn/01.jpg\" alt=\"\"/></a></li>\n    <li><a href=\"###\"><img src=\"/assets/images/banner/ibn/01.jpg\" alt=\"\"/></a></li>\n    <li><a href=\"###\"><img src=\"/assets/images/banner/ibn/01.jpg\" alt=\"\"/></a></li>\n    <li><a href=\"###\"><img src=\"/assets/images/banner/ibn/01.jpg\" alt=\"\"/></a></li>\n  </ul>\n  <ul class=\"hd\"></ul>\n</div>\n<!-- banner -->\n<!-- 中间 -->\n<!-- 一行 -->\n<nav class=\"inavlist wbox\">\n  <a href=\"###\" class=\"inavitem\"><img src=\"/assets/images/icon/inav/01.png\" alt=\"\" class=\"ico\"/>\n    <div class=\"t\">男士SPA</div>\n  </a>\n  <a href=\"###\" class=\"inavitem\"><img src=\"/assets/images/icon/inav/02.png\" alt=\"\" class=\"ico\"/>\n    <div class=\"t\">看电影</div>\n  </a>\n  <a href=\"###\" class=\"inavitem\"><img src=\"/assets/images/icon/inav/03.png\" alt=\"\" class=\"ico\"/>\n    <div class=\"t\">足疗</div>\n  </a>\n  <a href=\"###\" class=\"inavitem\"><img src=\"/assets/images/icon/inav/04.png\" alt=\"\" class=\"ico\"/>\n    <div class=\"t\">模特</div>\n  </a>\n  <a href=\"###\" class=\"inavitem\"><img src=\"/assets/images/icon/inav/05.png\" alt=\"\" class=\"ico\"/>\n    <div class=\"t\">陪聊天</div>\n  </a>\n  <a href=\"###\" class=\"inavitem\"><img src=\"/assets/images/icon/inav/06.png\" alt=\"\" class=\"ico\"/>\n    <div class=\"t\">交友</div>\n  </a>\n  <a href=\"###\" class=\"inavitem\"><img src=\"/assets/images/icon/inav/07.png\" alt=\"\" class=\"ico\"/>\n    <div class=\"t\">相亲</div>\n  </a>\n  <a href=\"###\" class=\"inavitem\"><img src=\"/assets/images/icon/inav/08.png\" alt=\"\" class=\"ico\"/>\n    <div class=\"t\">中医推拿</div>\n  </a>\n  <a href=\"###\" class=\"inavitem\"><img src=\"/assets/images/icon/inav/09.png\" alt=\"\" class=\"ico\"/>\n    <div class=\"t\">练唱歌</div>\n  </a>\n  <a href=\"###\" class=\"inavitem\"><img src=\"/assets/images/icon/inav/10.png\" alt=\"\" class=\"ico\"/>\n    <div class=\"t\">全部</div>\n  </a>\n</nav>\n<!-- end 一行 -->\n<!-- 一行 -->\n<div class=\"scrollnewsrow wbox\">\n  <div class=\"scrollnewsrow_th\"><img src=\"/assets/images/icon/scrollnewsrow_label.png\" alt=\"\" class=\"scrollnewsrow_label\"/>\n  </div>\n  <div class=\"scrollnews\" id=\"scrollnews\">\n    <div class=\"scrollnewsList list\">\n      <div class=\"scrollitem\">\n        <a href=\"###\" class=\"scrollnewsgo\">\n          <div class=\"text\"><span class=\"rdtxt\">momo*</span>邀请了6个好友加入走野...</div>\n          <span class=\"avatoritm\"><img src=\"/assets/images/portrait/40/01.jpg\" alt=\"\"/></span>\n          <span class=\"avatoritm\"><img src=\"/assets/images/portrait/40/02.jpg\" alt=\"\"/></span>\n          <span class=\"avatoritm\"><img src=\"/assets/images/portrait/40/03.jpg\" alt=\"\"/></span>\n        </a>\n      </div>\n      <div class=\"scrollitem\">\n        <a href=\"###\" class=\"scrollnewsgo\">\n          <div class=\"text\">02<span class=\"rdtxt\">momo*</span>邀请了6个好友加入走野...</div>\n          <span class=\"avatoritm\"><img src=\"/assets/images/portrait/40/01.jpg\" alt=\"\"/></span>\n          <span class=\"avatoritm\"><img src=\"/assets/images/portrait/40/03.jpg\" alt=\"\"/></span>\n        </a>\n      </div>\n      <div class=\"scrollitem\">\n        <a href=\"###\" class=\"scrollnewsgo\">\n          <div class=\"text\">03<span class=\"rdtxt\">momo*</span>邀请了6个好友加入走野...</div>\n          <span class=\"avatoritm\"><img src=\"/assets/images/portrait/40/01.jpg\" alt=\"\"/></span>\n        </a>\n      </div>\n      <div class=\"scrollitem\">\n        <a href=\"###\" class=\"scrollnewsgo\">\n          <div class=\"text\">04<span class=\"rdtxt\">momo*</span>邀请了6个好友加入走野...</div>\n          <span class=\"avatoritm\"><img src=\"/assets/images/portrait/40/02.jpg\" alt=\"\"/></span>\n          <span class=\"avatoritm\"><img src=\"/assets/images/portrait/40/03.jpg\" alt=\"\"/></span>\n        </a>\n      </div>\n    </div>\n  </div>\n</div>\n<!-- end 一行 -->\n<!-- 一行 -->\n<section class=\"wpbox\">\n  <div class=\"boxmt\">\n    <i class=\"favor_tico tico\"></i>\n    <div class=\"cutcont\">\n      <h2 class=\"boxmtitle\">同城热约</h2>\n    </div>\n  </div>\n  <ul class=\"quickcards\">\n    <li class=\"quickcard\"><a href=\"###\" class=\"quickcard_link\">\n      <div class=\"quickcard_produce\">\n        <div class=\"quickcard_pic\">\n          <div class=\"pinlside\"><span class=\"bktextag\">男士SPA</span></div>\n          <img src=\"/assets/images/pic/quickcard/01.jpg\" alt=\"\"/>\n          <div class=\"picdecs\">\n            <div class=\"ac picdecs_cont\"><i class=\"local_sico sico\"></i>距离你13.3km</div>\n          </div>\n        </div>\n        <div class=\"quickcard_decs\">\n          <div class=\"quickcard_tr\"><span href=\"###\" class=\"primarybtn msbtn\">约Ta</span></div>\n        </div>\n      </div>\n    </a></li>\n    <li class=\"quickcard\"><a href=\"###\" class=\"quickcard_link\">\n      <div class=\"quickcard_produce\">\n        <div class=\"quickcard_pic\">\n          <div class=\"pinlside\"><span class=\"bktextag\">陪聊天</span></div>\n          <img src=\"/assets/images/pic/quickcard/02.jpg\" alt=\"\"/>\n          <div class=\"picdecs\">\n            <div class=\"ac picdecs_cont\"><i class=\"local_sico sico\"></i>距离你19.8km距离你19.8km距离你19.8km距离你19.8km距离你19.8km\n            </div>\n          </div>\n        </div>\n        <div class=\"quickcard_decs\">\n          <div class=\"quickcard_tr\"><span href=\"###\" class=\"primarybtn msbtn\">约Ta</span></div>\n        </div>\n      </div>\n    </a></li>\n    <li class=\"quickcard\"><a href=\"###\" class=\"quickcard_link\">\n      <div class=\"quickcard_produce\">\n        <div class=\"quickcard_pic\">\n          <div class=\"pinlside\"><span class=\"bktextag\">练唱歌</span></div>\n          <img src=\"/assets/images/pic/quickcard/03.jpg\" alt=\"\"/>\n          <div class=\"picdecs\">\n            <div class=\"ac picdecs_cont\"><i class=\"local_sico sico\"></i>距离你15.8km</div>\n          </div>\n        </div>\n        <div class=\"quickcard_decs\">\n          <div class=\"quickcard_tr\"><span href=\"###\" class=\"primarybtn msbtn\">约Ta</span></div>\n        </div>\n      </div>\n    </a></li>\n  </ul>\n</section>\n<!-- end 一行 -->\n<!-- 一行 -->\n<section class=\"wpbox\">\n  <div class=\"boxmt\">\n    <i class=\"favor_tico tico\"></i>\n    <div class=\"cutcont\">\n      <h2 class=\"boxmtitle\">限时活动</h2>\n    </div>\n  </div>\n  <div class=\"activecards\">\n    <div class=\"col3\">\n      <a href=\"###\" class=\"activecard_veritem\"><img src=\"/assets/images/pic/activecard/01.png\" alt=\"\"/></a>\n    </div>\n    <div class=\"col4\">\n      <a href=\"###\" class=\"activecard_hozitem\">\n        <div class=\"decs\">\n          <div class=\"title\">每日签到</div>\n          <p>巨额奖金等你瓜分</p>\n        </div>\n        <img src=\"/assets/images/pic/activecard/02.png\" alt=\"\"/>\n      </a>\n      <a href=\"###\" class=\"activecard_hozitem\">\n        <div class=\"decs\">\n          <div class=\"title\">每日签到</div>\n          <p>得百元现金奖励</p>\n        </div>\n        <img src=\"/assets/images/pic/activecard/03.png\" alt=\"\"/>\n      </a>\n    </div>\n  </div>\n  <div class=\"picsclenternav\">\n    <ul class=\"picsclenternav_list\">\n      <li><a href=\"###\"><img src=\"/assets/images/pic/picsclenternav/01.png\" alt=\"\"/></a></li>\n      <li><a href=\"###\"><img src=\"/assets/images/pic/picsclenternav/02.png\" alt=\"\"/></a></li>\n      <li><a href=\"###\"><img src=\"/assets/images/pic/picsclenternav/03.png\" alt=\"\"/></a></li>\n      <li><a href=\"###\"><img src=\"/assets/images/pic/picsclenternav/01.png\" alt=\"\"/></a></li>\n      <li><a href=\"###\"><img src=\"/assets/images/pic/picsclenternav/02.png\" alt=\"\"/></a></li>\n      <li><a href=\"###\"><img src=\"/assets/images/pic/picsclenternav/03.png\" alt=\"\"/></a></li>\n    </ul>\n  </div>\n</section>\n<!-- end 一行 -->\n<!-- 一行 -->\n<section class=\"wpbox\">\n  <div class=\"boxmt\">\n    <i class=\"favor_tico tico\"></i>\n    <div class=\"cutcont\">\n      <h2 class=\"boxmtitle\">身边动态</h2>\n    </div>\n    <a href=\"###\" class=\"boxmtbtn\">MORE<i class=\"rgt\"></i></a>\n  </div>\n  <ul class=\"quickcards\">\n    <li class=\"quickcard\"><a href=\"###\" class=\"quickcard_link\">\n      <div class=\"quickcard_produce\">\n        <div class=\"quickcard_pic\">\n          <div class=\"pinlside\"><span class=\"bktextag\">男士SPA</span></div>\n          <img src=\"/assets/images/pic/quickcard/01.jpg\" alt=\"\"/>\n          <div class=\"picdecs\">\n            <div class=\"picdecs_cont\"><span class=\"t\">芳芒MI</span></div>\n            <span><i class=\"local_sico sico\"></i>13.3km</span>\n          </div>\n        </div>\n      </div>\n    </a></li>\n    <li class=\"quickcard\"><a href=\"###\" class=\"quickcard_link\">\n      <div class=\"quickcard_produce\">\n        <div class=\"quickcard_pic\">\n          <div class=\"pinlside\"><span class=\"bktextag\">陪聊天</span></div>\n          <img src=\"/assets/images/pic/quickcard/02.jpg\" alt=\"\"/>\n          <div class=\"picdecs\">\n            <div class=\"ac picdecs_cont\">我是可乐...</div>\n            <span><i class=\"local_sico sico\"></i>9.8km</span>\n          </div>\n        </div>\n      </div>\n    </a></li>\n    <li class=\"quickcard\"><a href=\"###\" class=\"quickcard_link\">\n      <div class=\"quickcard_produce\">\n        <div class=\"quickcard_pic\">\n          <div class=\"pinlside\"><span class=\"bktextag\">练唱歌</span></div>\n          <img src=\"/assets/images/pic/quickcard/03.jpg\" alt=\"\"/>\n          <div class=\"picdecs\">\n            <div class=\"ac picdecs_cont\">眼神在放...</div>\n            <span><i class=\"local_sico sico\"></i>5.8km</span>\n          </div>\n        </div>\n      </div>\n    </a></li>\n  </ul>\n</section>\n<!-- end 一行 -->\n<!-- 一行 -->\n<div class=\"stickyWrap\" id=\"scrollbox01\">\n  <!-- sortbar -->\n  <div class=\"sortbar_wrap stickyInTop\" id=\"sortbarWrap\">\n    <div class=\"sortbar\" id=\"sortbar\">\n      <nav class=\"sortbarhd\">\n        <a href=\"javascript:;\" class=\"active spnav  sortbarhd_item\">智能排序</a>\n        <a href=\"javascript:;\" class=\"spnav sortbarhd_item\">人气最高</a>\n        <a href=\"javascript:;\" class=\"spnav sortbarhd_item\">距离最近</a>\n        <div data-sort=\"filter\" class=\"hasbd sortbarhd_item\">高级筛选<i class=\"selgt\"></i></div>\n      </nav>\n      <div class=\"sortbarbd\">\n        <div data-sort=\"filter\" class=\"sortbar_item\">\n          <div class=\"sortbar_column\">\n            <div class=\"ph20 sortbar_mc\">\n              <dl class=\"sortcldl\">\n                <dt class=\"sortcldt\">品类</dt>\n                <dd class=\"sortcldd\">\n                  <a href=\"###\">情感咨询</a>\n                  <a href=\"###\">兼职红娘</a>\n                  <a href=\"###\">户外运动</a>\n                </dd>\n              </dl>\n              <dl class=\"sortcldl\">\n                <dt class=\"sortcldt\">性别</dt>\n                <dd class=\"sortcldd\">\n                  <a class=\"selected\" href=\"###\">不限</a>\n                  <a href=\"###\">男</a>\n                  <a href=\"###\">女</a>\n                </dd>\n              </dl>\n              <dl class=\"sortcldl\">\n                <dt class=\"sortcldt\">距离</dt>\n                <dd class=\"sortcldd\">\n                  <a class=\"selected\" href=\"###\">不限</a>\n                  <a href=\"###\">5公里内</a>\n                  <a href=\"###\">10公里内</a>\n                </dd>\n              </dl>\n            </div>\n            <nav class=\"setbtnrow\">\n              <a href=\"###\" class=\"reset setbtn\">重置</a>\n              <a href=\"###\" class=\"confirm setbtn\">确定</a>\n            </nav>\n          </div>\n        </div>\n      </div>\n    </div>\n    <div class=\"closesortbar sortbarbg\"></div>\n  </div>\n  <!-- end sortbar -->\n  <!-- 一行 -->\n  <div class=\"ucards\">\n    <div class=\"ucard\">\n      <div class=\"ucard_mt\">\n        <a href=\"###\" class=\"ucard_user\">\n          <div class=\"ucard_user_avator\">\n            <img src=\"/assets/images/portrait/80/01.jpg\" alt=\"\"/>\n            <div class=\"avatordecs\">推荐</div>\n          </div>\n          <div class=\"ucard_user_cont\">\n            <div class=\"cuth\"><span class=\"name\">做你的狼嚎</span></div>\n            <div class=\"cutd\">\n              <div class=\"cutdcont\">\n\t\t\t\t\t\t\t\t<span class=\"icotags\">\n\t\t\t\t\t\t\t\t\t<span class=\"female icotag\"><span class=\"icotag_text\">26</span></span>\n\t\t\t\t\t\t\t\t\t<span class=\"lv icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"phone icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"user icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"award icotag\"></span>\n\t\t\t\t\t\t\t\t</span>\n              </div>\n              <span class=\"itm\"><i class=\"local_sico sico\"></i>8.33km</span>\n            </div>\n          </div>\n        </a>\n      </div>\n      <div class=\"ucard_mc\">\n        <div class=\"cutpic3\">\n\t\t\t\t\t<span class=\"cutpicitm\"><div class=\"cutpicinner\">\n\t\t\t\t\t\t<img src=\"/assets/images/pic/cutpic3/01.jpg\" alt=\"\"/>\n\t\t\t\t\t\t<div class=\"picover\">\n\t\t\t\t\t\t\t<div class=\"picover_center\"><i class=\"play_otherico otherico\"></i></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div></span>\n          <span class=\"cutpicitm\"><div class=\"cutpicinner\"><img src=\"/assets/images/pic/cutpic3/02.jpg\" alt=\"\"/></div></span>\n          <span class=\"cutpicitm\"><div class=\"cutpicinner\"><img src=\"/assets/images/pic/cutpic3/03.jpg\" alt=\"\"/></div></span>\n        </div>\n        <div class=\"ucard_artdp\">\n          <div class=\"ucard_artdp_dt\">男士SPA</div>\n          <p class=\"ucard_artdp_p\">专业男士spa，手法一流，保证让您满意，要做spa的朋友可以联系我哦~</p>\n        </div>\n      </div>\n      <div class=\"ucard_tools\">\n        <a href=\"###\" class=\"ucardbtn\"><i class=\"alarm_mico mico\"></i>上线提醒</a>\n        <span class=\"ucardbtn\"><i class=\"coin_mico mico\"></i>打赏TA</span>\n        <a href=\"###\" class=\"ucardbtn\"><i class=\"money_mico mico\"></i>充值返现</a>\n        <a href=\"###\" class=\"primarybtn mbtn\"><i class=\"love_mico mico\"></i>约TA</a>\n      </div>\n    </div>\n    <div class=\"ucard\">\n      <div class=\"ucard_mt\">\n        <a href=\"###\" class=\"ucard_user\">\n          <div class=\"ucard_user_avator\">\n            <img src=\"/assets/images/portrait/80/01.jpg\" alt=\"\"/>\n            <div class=\"avatordecs\">推荐</div>\n          </div>\n          <div class=\"ucard_user_cont\">\n            <div class=\"cuth\"><span class=\"name\">做你的狼嚎</span></div>\n            <div class=\"cutd\">\n              <div class=\"cutdcont\">\n\t\t\t\t\t\t\t\t<span class=\"icotags\">\n\t\t\t\t\t\t\t\t\t<span class=\"female icotag\"><span class=\"icotag_text\">26</span></span>\n\t\t\t\t\t\t\t\t\t<span class=\"lv icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"phone icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"user icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"award icotag\"></span>\n\t\t\t\t\t\t\t\t</span>\n              </div>\n              <span class=\"itm\"><i class=\"local_sico sico\"></i>8.33km</span>\n            </div>\n          </div>\n        </a>\n      </div>\n      <div class=\"ucard_mc\">\n        <div class=\"cutpic3\">\n          <span class=\"cutpicitm\"><div class=\"cutpicinner\"><img src=\"/assets/images/pic/cutpic3/01.jpg\" alt=\"\"/></div></span>\n          <span class=\"cutpicitm\"><div class=\"cutpicinner\"><img src=\"/assets/images/pic/cutpic3/02.jpg\" alt=\"\"/></div></span>\n          <span class=\"cutpicitm\"><div class=\"cutpicinner\"><img src=\"/assets/images/pic/cutpic3/03.jpg\" alt=\"\"/></div></span>\n        </div>\n        <div class=\"ucard_artdp\">\n          <div class=\"ucard_artdp_dt\">男士SPA</div>\n          <p class=\"ucard_artdp_p\">专业男士spa，手法一流，保证让您满意，要做spa的朋友可以联系我哦~</p>\n        </div>\n      </div>\n      <div class=\"ucard_tools\">\n        <a href=\"###\" class=\"ucardbtn\"><i class=\"alarm_mico mico\"></i>上线提醒</a>\n        <span class=\"ucardbtn\"><i class=\"coin_mico mico\"></i>455928</span>\n        <a href=\"###\" class=\"ucardbtn\"><i class=\"money_mico mico\"></i>充值返现</a>\n        <a href=\"###\" class=\"primarybtn mbtn\"><i class=\"love_mico mico\"></i>约TA</a>\n      </div>\n    </div>\n    <div class=\"ucard\">\n      <div class=\"ucard_mt\">\n        <a href=\"###\" class=\"ucard_user\">\n          <div class=\"ucard_user_avator\">\n            <img src=\"/assets/images/portrait/80/01.jpg\" alt=\"\"/>\n          </div>\n          <div class=\"ucard_user_cont\">\n            <div class=\"cuth\"><span class=\"name\">做你的狼嚎</span></div>\n            <div class=\"cutd\">\n              <div class=\"cutdcont\">\n\t\t\t\t\t\t\t\t<span class=\"icotags\">\n\t\t\t\t\t\t\t\t\t<span class=\"female icotag\"><span class=\"icotag_text\">26</span></span>\n\t\t\t\t\t\t\t\t\t<span class=\"lv icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"phone icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"user icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"award icotag\"></span>\n\t\t\t\t\t\t\t\t</span>\n              </div>\n              <span class=\"itm\"><i class=\"local_sico sico\"></i>8.33km</span>\n            </div>\n          </div>\n        </a>\n      </div>\n      <div class=\"ucard_mc\">\n        <div class=\"cutpic2\">\n          <span class=\"cutpicitm\"><div class=\"cutpicinner\"><img src=\"/assets/images/pic/cutpic2/01.jpg\" alt=\"\"/></div></span>\n          <span class=\"cutpicitm\"><div class=\"cutpicinner\"><img src=\"/assets/images/pic/cutpic2/02.jpg\" alt=\"\"/></div></span>\n        </div>\n        <div class=\"ucard_artdp\">\n          <div class=\"ucard_artdp_dt\">男士SPA</div>\n          <p class=\"ucard_artdp_p\">专业男士spa，手法一流，保证让您满意，要做spa的朋友可以联系我哦~</p>\n        </div>\n      </div>\n      <div class=\"ucard_tools\">\n        <a href=\"###\" class=\"ucardbtn\"><i class=\"alarm_mico mico\"></i>上线提醒</a>\n        <span class=\"ucardbtn\"><i class=\"coin_mico mico\"></i>455928</span>\n        <a href=\"###\" class=\"ucardbtn\"><i class=\"money_mico mico\"></i>充值返现</a>\n        <a href=\"###\" class=\"primarybtn mbtn\"><i class=\"love_mico mico\"></i>约TA</a>\n      </div>\n    </div>\n    <div class=\"picadv\"><a href=\"###\" class=\"picadv_link\"><img src=\"/assets/images/pic/picadv/01.jpg\" alt=\"\"/></a></div>\n    <div class=\"ucard\">\n      <div class=\"ucard_mt\">\n        <a href=\"###\" class=\"ucard_user\">\n          <div class=\"ucard_user_avator\">\n            <img src=\"/assets/images/portrait/80/01.jpg\" alt=\"\"/>\n            <div class=\"avatordecs\">推荐</div>\n          </div>\n          <div class=\"ucard_user_cont\">\n            <div class=\"cuth\"><span class=\"name\">做你的狼嚎</span></div>\n            <div class=\"cutd\">\n              <div class=\"cutdcont\">\n\t\t\t\t\t\t\t\t<span class=\"icotags\">\n\t\t\t\t\t\t\t\t\t<span class=\"female icotag\"><span class=\"icotag_text\">26</span></span>\n\t\t\t\t\t\t\t\t\t<span class=\"lv icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"phone icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"user icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"award icotag\"></span>\n\t\t\t\t\t\t\t\t</span>\n              </div>\n              <span class=\"itm\"><i class=\"local_sico sico\"></i>8.33km</span>\n            </div>\n          </div>\n        </a>\n      </div>\n      <div class=\"ucard_mc\">\n        <div class=\"cutpic\">\n          <span class=\"cutpicitm\"><div class=\"cutpicinner\"><img src=\"/assets/images/pic/cutpic/01.jpg\" alt=\"\"/></div></span>\n        </div>\n        <div class=\"ucard_artdp\">\n          <div class=\"ucard_artdp_dt\">男士SPA</div>\n          <p class=\"ucard_artdp_p\">专业男士spa，手法一流，保证让您满意，要做spa的朋友可以联系我哦~</p>\n        </div>\n      </div>\n      <div class=\"ucard_tools\">\n        <a href=\"###\" class=\"ucardbtn\"><i class=\"alarm_mico mico\"></i>上线提醒</a>\n        <span class=\"ucardbtn\"><i class=\"coin_mico mico\"></i>455928</span>\n        <a href=\"###\" class=\"ucardbtn\"><i class=\"money_mico mico\"></i>充值返现</a>\n        <a href=\"###\" class=\"primarybtn mbtn\"><i class=\"love_mico mico\"></i>约TA</a>\n      </div>\n    </div>\n    <div class=\"ucard\">\n      <div class=\"ucard_mt\">\n        <a href=\"###\" class=\"ucard_user\">\n          <div class=\"ucard_user_avator\">\n            <img src=\"/assets/images/portrait/80/02.jpg\" alt=\"\"/>\n          </div>\n          <div class=\"ucard_user_cont\">\n            <div class=\"cuth\"><span class=\"name\">家电维修</span></div>\n            <div class=\"cutd\">\n              <div class=\"cutdcont\">\n\t\t\t\t\t\t\t\t<span class=\"icotags\">\n\t\t\t\t\t\t\t\t\t<span class=\"male icotag\"><span class=\"icotag_text\">26</span></span>\n\t\t\t\t\t\t\t\t\t<span class=\"lv icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"phone icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"user icotag\"></span>\n\t\t\t\t\t\t\t\t\t<span class=\"award icotag\"></span>\n\t\t\t\t\t\t\t\t</span>\n              </div>\n              <span class=\"itm\"><i class=\"local_sico sico\"></i>8.33km</span>\n            </div>\n          </div>\n        </a>\n      </div>\n      <div class=\"ucard_mc\">\n        <div class=\"ucard_artdp\">\n          <div class=\"ucard_artdp_dt\">家电维修</div>\n          <p class=\"ucard_artdp_p\">从事专业维修10年，经验更丰富，技术更有保证，多收取一丝一评，不夸大电器故障，只做良心维修。</p>\n          <div class=\"textags\">\n            <span class=\"textag\">冰箱</span>\n            <span class=\"textag\">热水器</span>\n            <span class=\"textag\">电视机</span>\n          </div>\n        </div>\n      </div>\n      <div class=\"ucard_tools\">\n        <a href=\"###\" class=\"ucardbtn\"><i class=\"alarm_mico mico\"></i>上线提醒</a>\n        <span class=\"ucardbtn\"><i class=\"coin_mico mico\"></i>455928</span>\n        <a href=\"###\" class=\"ucardbtn\"><i class=\"money_mico mico\"></i>充值返现</a>\n        <a href=\"###\" class=\"primarybtn mbtn\"><i class=\"love_mico mico\"></i>约TA</a>\n      </div>\n    </div>\n  </div>\n  <!-- end 一行 -->\n</div>\n<!-- end 一行 -->\n<!--end 中间-->\n<!-- 底部 -->\n<div class=\"fbottom\">\n  <nav class=\"fnavlist\">\n    <a href=\"index.html\" class=\"on nearby fnavitem\">附近</a>\n    <a href=\"###\" class=\"demand fnavitem\">需求管理</a>\n    <a href=\"###\" class=\"add fnavitem\"></a>\n    <a href=\"skill.html\" class=\"skill fnavitem\">技能管理<span class=\"ntnum\">3</span></a>\n    <a href=\"club.html\" class=\"user fnavitem\">个人中心<span class=\"ntdot\"></span></a>\n  </nav>\n</div>\n<!--end 底部-->\n\n<!-- fadenews -->\n<ul class=\"fadenews\" id=\"fadenews\">\n  <li class=\"fadenews_item\">\n    <div class=\"fadenews_photo\"><img src=\"/assets/images/portrait/50/01.jpg\" alt=\"\"/></div>\n    <p class=\"fadenews_text\">李宇*充值\n      <ins>50</ins>\n      元获得了\n      <ins>5</ins>\n      元...\n    </p>\n  </li>\n  <li class=\"fadenews_item\">\n    <div class=\"fadenews_photo\"><img src=\"/assets/images/portrait/50/01.jpg\" alt=\"\"/></div>\n    <p class=\"fadenews_text\">李宇*充值\n      <ins>51</ins>\n      元获得了\n      <ins>5</ins>\n      元李宇*充值\n      <ins>51</ins>\n      元获得了\n      <ins>5</ins>\n      元李宇*充值\n      <ins>51</ins>\n      元获得了\n      <ins>5</ins>\n      元李宇*充值\n      <ins>51</ins>\n      元获得了\n      <ins>5</ins>\n      元\n    </p>\n  </li>\n  <li class=\"fadenews_item\">\n    <div class=\"fadenews_photo\"><img src=\"/assets/images/portrait/50/01.jpg\" alt=\"\"/></div>\n    <p class=\"fadenews_text\">李宇*充值\n      <ins>52</ins>\n      元获得了\n      <ins>5</ins>\n      元...\n    </p>\n  </li>\n  <li class=\"fadenews_item\">\n    <div class=\"fadenews_photo\"><img src=\"/assets/images/portrait/50/01.jpg\" alt=\"\"/></div>\n    <p class=\"fadenews_text\">李宇*充值\n      <ins>53</ins>\n      元获得了\n      <ins>5</ins>\n      元...\n    </p>\n  </li>\n  <li class=\"fadenews_item\">\n    <div class=\"fadenews_photo\"><img src=\"/assets/images/portrait/50/01.jpg\" alt=\"\"/></div>\n    <p class=\"fadenews_text\">李宇*充值\n      <ins>54</ins>\n      元获得了\n      <ins>5</ins>\n      元...\n    </p>\n  </li>\n  <li class=\"fadenews_item\">\n    <div class=\"fadenews_photo\"><img src=\"/assets/images/portrait/50/01.jpg\" alt=\"\"/></div>\n    <p class=\"fadenews_text\">李宇*充值\n      <ins>55</ins>\n      元获得了\n      <ins>5</ins>\n      元...\n    </p>\n  </li>\n  <li class=\"fadenews_item\">\n    <div class=\"fadenews_photo\"><img src=\"/assets/images/portrait/50/01.jpg\" alt=\"\"/></div>\n    <p class=\"fadenews_text\">李宇*充值\n      <ins>56</ins>\n      元获得了\n      <ins>5</ins>\n      元...\n    </p>\n  </li>\n</ul>\n<!-- end fadenews -->\n\n<!-- ftools -->\n<nav class=\"ftools\">\n  <a href=\"###\" class=\"join ftoolsitem\"></a>\n  <a href=\"#\" class=\"gotop ftoolsitem\"></a>\n</nav>\n<!-- end ftools -->\n\n\n<script src=\"/assets/js/TouchSlide.js\"></script>\n<script src=\"/assets/js/tool.js\"></script>\n"

/***/ }),

/***/ "./src/app/home/home.component.ts":
/*!****************************************!*\
  !*** ./src/app/home/home.component.ts ***!
  \****************************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var HomeComponent = /** @class */ (function () {
    function HomeComponent() {
    }
    HomeComponent.prototype.ngOnInit = function () {
    };
    HomeComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-home',
            template: __webpack_require__(/*! ./home.component.html */ "./src/app/home/home.component.html"),
            styles: [__webpack_require__(/*! ./home.component.css */ "./src/app/home/home.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\Users\lq\Desktop\datebyweb\frontend\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map