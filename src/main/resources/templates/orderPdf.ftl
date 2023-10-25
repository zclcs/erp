<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>
    <style>
        body,
        div,
        dl,
        dt,
        dd,
        ul,
        ol,
        li,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6,
        input,
        button,
        textarea,
        p,
        blockquote,
        th,
        td,
        form,
        pre {
            margin: 0;
            padding: 0;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
        }

        a:active,
        a:hover {
            outline: 0
        }

        img {
            display: inline-block;
            border: none;
            vertical-align: middle;
        }

        li {
            list-style: none;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        h1,
        h2,
        h3,
        h4 {
            font-weight: 700;
        }

        h5,
        h6 {
            font-weight: 500;
            font-size: 100%;
        }

        button,
        input,
        select,
        textarea {
            font-size: 100%;
        }

        input,
        button,
        textarea,
        select,
        optgroup,
        option {
            font-family: inherit;
            font-size: inherit;
            font-style: inherit;
            font-weight: inherit;
            outline: 0;
        }

        pre {
            white-space: pre-wrap;
            white-space: -moz-pre-wrap;
            white-space: -pre-wrap;
            white-space: -o-pre-wrap;
            word-wrap: break-word;
        }

        /** 初始化全局标签 **/
        body {
            line-height: 1.6;
            color: #333;
            color: rgba(0, 0, 0, .85);
            font: 14px Helvetica Neue, Helvetica, PingFang SC, Tahoma, Arial, sans-serif;
        }

        hr {
            height: 0;
            line-height: 0;
            margin: 10px 0;
            padding: 0;
            border: none;
            border-bottom: 1px solid #eee;
            clear: both;
            overflow: hidden;
            background: none;
        }

        a {
            color: #333;
            text-decoration: none;
        }

        a:hover {
            color: #777;
        }

        a cite {
            font-style: normal;
            *cursor: pointer;
        }

        /** 基础通用 **/
        .layui-border-box,
        .layui-border-box * {
            box-sizing: border-box;
        }

        /* 消除第三方ui可能造成的冲突 */
        .layui-box,
        .layui-box * {
            box-sizing: content-box;
        }

        .layui-clear {
            clear: both;
            *zoom: 1;
        }

        .layui-clear:after {
            content: '\20';
            clear: both;
            *zoom: 1;
            display: block;
            height: 0;
        }

        .layui-clear-space {
            word-spacing: -5px;
        }

        .layui-inline {
            position: relative;
            display: inline-block;
            *display: inline;
            *zoom: 1;
            vertical-align: middle;
        }

        /* 三角形 */
        .layui-edge {
            position: relative;
            display: inline-block;
            vertical-align: middle;
            width: 0;
            height: 0;
            border-width: 6px;
            border-style: dashed;
            border-color: transparent;
            overflow: hidden;
        }

        .layui-edge-top {
            top: -4px;
            border-bottom-color: #999;
            border-bottom-style: solid;
        }

        .layui-edge-right {
            border-left-color: #999;
            border-left-style: solid;
        }

        .layui-edge-bottom {
            top: 2px;
            border-top-color: #999;
            border-top-style: solid;
        }

        .layui-edge-left {
            border-right-color: #999;
            border-right-style: solid;
        }

        /* 单行溢出省略 */
        .layui-elip {
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }

        /* 屏蔽选中 */
        .layui-unselect,
        .layui-icon,
        .layui-disabled {
            -moz-user-select: none;
            -webkit-user-select: none;
            -ms-user-select: none;
        }

        /* 禁用 */
        .layui-disabled,
        .layui-disabled:hover {
            color: #d2d2d2 !important;
            cursor: not-allowed !important;
        }

        /* 纯圆角 */
        .layui-circle {
            border-radius: 100%;
        }

        .layui-show {
            display: block !important;
        }

        .layui-hide {
            display: none !important;
        }

        .layui-show-v {
            visibility: visible !important;
        }

        .layui-hide-v {
            visibility: hidden !important;
        }

        .layui-icon {
            font-family: "layui-icon" !important;
            font-size: 16px;
            font-style: normal;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        /* font-class */
        .layui-icon-leaf:before {
            content: "\e701";
        }

        .layui-icon-folder:before {
            content: "\eabe";
        }

        .layui-icon-folder-open:before {
            content: "\eac1";
        }

        .layui-icon-gitee:before {
            content: "\e69b";
        }

        .layui-icon-github:before {
            content: "\e6a7"
        }

        .layui-icon-disabled:before {
            content: "\e6cc"
        }

        .layui-icon-moon:before {
            content: "\e6c2"
        }

        .layui-icon-error:before {
            content: "\e693"
        }

        .layui-icon-success:before {
            content: "\e697"
        }

        .layui-icon-question:before {
            content: "\e699"
        }

        .layui-icon-lock:before {
            content: "\e69a"
        }

        .layui-icon-eye:before {
            content: "\e695"
        }

        .layui-icon-eye-invisible:before {
            content: "\e696"
        }

        .layui-icon-backspace:before {
            content: "\e694"
        }

        .layui-icon-tips-fill:before {
            content: "\eb2e"
        }

        .layui-icon-test:before {
            content: "\e692"
        }

        .layui-icon-clear:before {
            content: "\e788"
        }

        .layui-icon-heart-fill:before {
            content: "\e68f"
        }

        .layui-icon-light:before {
            content: "\e748"
        }

        .layui-icon-music:before {
            content: "\e690"
        }

        .layui-icon-time:before {
            content: "\e68d"
        }

        .layui-icon-ie:before {
            content: "\e7bb"
        }

        .layui-icon-firefox:before {
            content: "\e686"
        }

        .layui-icon-at:before {
            content: "\e687"
        }

        .layui-icon-bluetooth:before {
            content: "\e689"
        }

        .layui-icon-chrome:before {
            content: "\e68a"
        }

        .layui-icon-edge:before {
            content: "\e68b"
        }

        .layui-icon-heart:before {
            content: "\e68c"
        }

        .layui-icon-key:before {
            content: "\e683"
        }

        .layui-icon-android:before {
            content: "\e684"
        }

        .layui-icon-mike:before {
            content: "\e6dc"
        }

        .layui-icon-mute:before {
            content: "\e685"
        }

        .layui-icon-gift:before {
            content: "\e627"
        }

        .layui-icon-windows:before {
            content: "\e67f"
        }

        .layui-icon-ios:before {
            content: "\e680"
        }

        .layui-icon-logout:before {
            content: "\e682"
        }

        .layui-icon-wifi:before {
            content: "\e7e0"
        }

        .layui-icon-rss:before {
            content: "\e808"
        }

        .layui-icon-email:before {
            content: "\e618"
        }

        .layui-icon-reduce-circle:before {
            content: "\e616"
        }

        .layui-icon-transfer:before {
            content: "\e691"
        }

        .layui-icon-service:before {
            content: "\e626"
        }

        .layui-icon-addition:before {
            content: "\e624"
        }

        .layui-icon-subtraction:before {
            content: "\e67e"
        }

        .layui-icon-slider:before {
            content: "\e714"
        }

        .layui-icon-print:before {
            content: "\e66d"
        }

        .layui-icon-export:before {
            content: "\e67d"
        }

        .layui-icon-cols:before {
            content: "\e610"
        }

        .layui-icon-screen-full:before {
            content: "\e622"
        }

        .layui-icon-screen-restore:before {
            content: "\e758"
        }

        .layui-icon-rate-half:before {
            content: "\e6c9"
        }

        .layui-icon-rate-solid:before {
            content: "\e67a"
        }

        .layui-icon-rate:before {
            content: "\e67b"
        }

        .layui-icon-cellphone:before {
            content: "\e678"
        }

        .layui-icon-vercode:before {
            content: "\e679"
        }

        .layui-icon-login-weibo:before {
            content: "\e675"
        }

        .layui-icon-login-qq:before {
            content: "\e676"
        }

        .layui-icon-login-wechat:before {
            content: "\e677"
        }

        .layui-icon-username:before {
            content: "\e66f"
        }

        .layui-icon-password:before {
            content: "\e673"
        }

        .layui-icon-refresh-3:before {
            content: "\e9aa"
        }

        .layui-icon-auz:before {
            content: "\e672"
        }

        .layui-icon-shrink-right:before {
            content: "\e668"
        }

        .layui-icon-spread-left:before {
            content: "\e66b"
        }

        .layui-icon-snowflake:before {
            content: "\e6b1"
        }

        .layui-icon-tips:before {
            content: "\e702"
        }

        .layui-icon-note:before {
            content: "\e66e"
        }

        .layui-icon-senior:before {
            content: "\e674"
        }

        .layui-icon-refresh-1:before {
            content: "\e666"
        }

        .layui-icon-refresh:before {
            content: "\e669"
        }

        .layui-icon-flag:before {
            content: "\e66c"
        }

        .layui-icon-theme:before {
            content: "\e66a"
        }

        .layui-icon-notice:before {
            content: "\e667"
        }

        .layui-icon-console:before {
            content: "\e665"
        }

        .layui-icon-website:before {
            content: "\e7ae"
        }

        .layui-icon-face-surprised:before {
            content: "\e664"
        }

        .layui-icon-set:before {
            content: "\e716"
        }

        .layui-icon-template:before {
            content: "\e663"
        }

        .layui-icon-app:before {
            content: "\e653"
        }

        .layui-icon-template-1:before {
            content: "\e656"
        }

        .layui-icon-home:before {
            content: "\e68e"
        }

        .layui-icon-female:before {
            content: "\e661"
        }

        .layui-icon-male:before {
            content: "\e662"
        }

        .layui-icon-tread:before {
            content: "\e6c5"
        }

        .layui-icon-praise:before {
            content: "\e6c6"
        }

        .layui-icon-rmb:before {
            content: "\e65e"
        }

        .layui-icon-more:before {
            content: "\e65f"
        }

        .layui-icon-camera:before {
            content: "\e660"
        }

        .layui-icon-cart-simple:before {
            content: "\e698"
        }

        .layui-icon-face-cry:before {
            content: "\e69c"
        }

        .layui-icon-face-smile:before {
            content: "\e6af"
        }

        .layui-icon-survey:before {
            content: "\e6b2"
        }

        .layui-icon-read:before {
            content: "\e705"
        }

        .layui-icon-location:before {
            content: "\e715"
        }

        .layui-icon-dollar:before {
            content: "\e659"
        }

        .layui-icon-diamond:before {
            content: "\e735"
        }

        .layui-icon-return:before {
            content: "\e65c"
        }

        .layui-icon-camera-fill:before {
            content: "\e65d"
        }

        .layui-icon-fire:before {
            content: "\e756"
        }

        .layui-icon-more-vertical:before {
            content: "\e671"
        }

        .layui-icon-cart:before {
            content: "\e657"
        }

        .layui-icon-star-fill:before {
            content: "\e658"
        }

        .layui-icon-prev:before {
            content: "\e65a"
        }

        .layui-icon-next:before {
            content: "\e65b"
        }

        .layui-icon-upload:before {
            content: "\e67c"
        }

        .layui-icon-upload-drag:before {
            content: "\e681"
        }

        .layui-icon-user:before {
            content: "\e770"
        }

        .layui-icon-file-b:before {
            content: "\e655"
        }

        .layui-icon-component:before {
            content: "\e857"
        }

        .layui-icon-find-fill:before {
            content: "\e670"
        }

        .layui-icon-loading:before {
            content: "\e63d"
        }

        .layui-icon-loading-1:before {
            content: "\e63e"
        }

        .layui-icon-add-1:before {
            content: "\e654"
        }

        .layui-icon-pause:before {
            content: "\e651"
        }

        .layui-icon-play:before {
            content: "\e652"
        }

        .layui-icon-video:before {
            content: "\e6ed"
        }

        .layui-icon-headset:before {
            content: "\e6fc"
        }

        .layui-icon-voice:before {
            content: "\e688"
        }

        .layui-icon-speaker:before {
            content: "\e645"
        }

        .layui-icon-fonts-del:before {
            content: "\e64f"
        }

        .layui-icon-fonts-html:before {
            content: "\e64b"
        }

        .layui-icon-fonts-code:before {
            content: "\e64e"
        }

        .layui-icon-fonts-strong:before {
            content: "\e62b"
        }

        .layui-icon-unlink:before {
            content: "\e64d"
        }

        .layui-icon-picture:before {
            content: "\e64a"
        }

        .layui-icon-link:before {
            content: "\e64c"
        }

        .layui-icon-face-smile-b:before {
            content: "\e650"
        }

        .layui-icon-align-center:before {
            content: "\e647"
        }

        .layui-icon-align-right:before {
            content: "\e648"
        }

        .layui-icon-align-left:before {
            content: "\e649"
        }

        .layui-icon-fonts-u:before {
            content: "\e646"
        }

        .layui-icon-fonts-i:before {
            content: "\e644"
        }

        .layui-icon-tabs:before {
            content: "\e62a"
        }

        .layui-icon-circle:before {
            content: "\e63f"
        }

        .layui-icon-radio:before {
            content: "\e643"
        }

        .layui-icon-share:before {
            content: "\e641"
        }

        .layui-icon-edit:before {
            content: "\e642"
        }

        .layui-icon-delete:before {
            content: "\e640"
        }

        .layui-icon-engine:before {
            content: "\e628"
        }

        .layui-icon-chart-screen:before {
            content: "\e629"
        }

        .layui-icon-chart:before {
            content: "\e62c"
        }

        .layui-icon-table:before {
            content: "\e62d"
        }

        .layui-icon-tree:before {
            content: "\e62e"
        }

        .layui-icon-upload-circle:before {
            content: "\e62f"
        }

        .layui-icon-templeate-1:before {
            content: "\e630"
        }

        .layui-icon-util:before {
            content: "\e631"
        }

        .layui-icon-layouts:before {
            content: "\e632"
        }

        .layui-icon-prev-circle:before {
            content: "\e633"
        }

        .layui-icon-carousel:before {
            content: "\e634"
        }

        .layui-icon-code-circle:before {
            content: "\e635"
        }

        .layui-icon-water:before {
            content: "\e636"
        }

        .layui-icon-date:before {
            content: "\e637"
        }

        .layui-icon-layer:before {
            content: "\e638"
        }

        .layui-icon-fonts-clear:before {
            content: "\e639"
        }

        .layui-icon-dialogue:before {
            content: "\e63a"
        }

        .layui-icon-cellphone-fine:before {
            content: "\e63b"
        }

        .layui-icon-form:before {
            content: "\e63c"
        }

        .layui-icon-file:before {
            content: "\e621"
        }

        .layui-icon-triangle-r:before {
            content: "\e623"
        }

        .layui-icon-triangle-d:before {
            content: "\e625"
        }

        .layui-icon-set-sm:before {
            content: "\e620"
        }

        .layui-icon-add-circle:before {
            content: "\e61f"
        }

        .layui-icon-layim-download:before {
            content: "\e61e"
        }

        .layui-icon-layim-uploadfile:before {
            content: "\e61d"
        }

        .layui-icon-404:before {
            content: "\e61c"
        }

        .layui-icon-about:before {
            content: "\e60b"
        }

        .layui-icon-layim-theme:before {
            content: "\e61b"
        }

        .layui-icon-down:before {
            content: "\e61a"
        }

        .layui-icon-up:before {
            content: "\e619"
        }

        .layui-icon-circle-dot:before {
            content: "\e617"
        }

        .layui-icon-set-fill:before {
            content: "\e614"
        }

        .layui-icon-search:before {
            content: "\e615"
        }

        .layui-icon-friends:before {
            content: "\e612"
        }

        .layui-icon-group:before {
            content: "\e613"
        }

        .layui-icon-reply-fill:before {
            content: "\e611"
        }

        .layui-icon-menu-fill:before {
            content: "\e60f"
        }

        .layui-icon-face-smile-fine:before {
            content: "\e60c"
        }

        .layui-icon-picture-fine:before {
            content: "\e60d"
        }

        .layui-icon-log:before {
            content: "\e60e"
        }

        .layui-icon-list:before {
            content: "\e60a"
        }

        .layui-icon-release:before {
            content: "\e609"
        }

        .layui-icon-add-circle-fine:before {
            content: "\e608"
        }

        .layui-icon-ok:before {
            content: "\e605"
        }

        .layui-icon-help:before {
            content: "\e607"
        }

        .layui-icon-chat:before {
            content: "\e606"
        }

        .layui-icon-top:before {
            content: "\e604"
        }

        .layui-icon-right:before {
            content: "\e602"
        }

        .layui-icon-left:before {
            content: "\e603"
        }

        .layui-icon-star:before {
            content: "\e600"
        }

        .layui-icon-download-circle:before {
            content: "\e601"
        }

        .layui-icon-close:before {
            content: "\1006"
        }

        .layui-icon-close-fill:before {
            content: "\1007"
        }

        .layui-icon-ok-circle:before {
            content: "\1005"
        }


        /* 基本布局 */
        .layui-main {
            position: relative;
            width: 1160px;
            margin: 0 auto;
        }

        .layui-header {
            position: relative;
            z-index: 1000;
            height: 60px;
        }

        .layui-header a:hover {
            transition: all .5s;
            -webkit-transition: all .5s;
        }

        .layui-side {
            position: fixed;
            left: 0;
            top: 0;
            bottom: 0;
            z-index: 999;
            width: 200px;
            overflow-x: hidden;
        }

        .layui-side-scroll {
            position: relative;
            width: 220px;
            height: 100%;
            overflow-x: hidden;
        }

        .layui-body {
            position: relative;
            left: 200px;
            right: 0;
            top: 0;
            bottom: 0;
            z-index: 900;
            width: auto;
            box-sizing: border-box;
        }

        /* 后台框架大布局 */
        .layui-layout-body {
            overflow-x: hidden;
        }

        .layui-layout-admin .layui-header {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            background-color: #23292e;
        }

        .layui-layout-admin .layui-side {
            top: 60px;
            width: 200px;
            overflow-x: hidden;
        }

        .layui-layout-admin .layui-body {
            position: absolute;
            top: 60px;
            padding-bottom: 44px;
        }

        .layui-layout-admin .layui-main {
            width: auto;
            margin: 0 15px;
        }

        .layui-layout-admin .layui-footer {
            position: fixed;
            left: 200px;
            right: 0;
            bottom: 0;
            z-index: 990;
            height: 44px;
            line-height: 44px;
            padding: 0 15px;
            box-shadow: -1px 0 4px rgb(0 0 0 / 12%);
            background-color: #fafafa;
        }

        .layui-layout-admin .layui-logo {
            position: absolute;
            left: 0;
            top: 0;
            width: 200px;
            height: 100%;
            line-height: 60px;
            text-align: center;
            color: #16baaa;
            font-size: 16px;
            box-shadow: 0 1px 2px 0 rgb(0 0 0 / 15%);
        }

        .layui-layout-admin .layui-header .layui-nav {
            background: none;
        }

        .layui-layout-left {
            position: absolute !important;
            left: 200px;
            top: 0;
        }

        .layui-layout-right {
            position: absolute !important;
            right: 0;
            top: 0;
        }


        /* 栅格布局 */
        .layui-container {
            position: relative;
            margin: 0 auto;
            box-sizing: border-box;
        }

        .layui-fluid {
            position: relative;
            margin: 0 auto;
            padding: 0 15px;
        }

        .layui-row:before,
        .layui-row:after {
            content: "";
            display: block;
            clear: both;
        }

        .layui-col-xs1,
        .layui-col-xs2,
        .layui-col-xs3,
        .layui-col-xs4,
        .layui-col-xs5,
        .layui-col-xs6,
        .layui-col-xs7,
        .layui-col-xs8,
        .layui-col-xs9,
        .layui-col-xs10,
        .layui-col-xs11,
        .layui-col-xs12,
        .layui-col-sm1,
        .layui-col-sm2,
        .layui-col-sm3,
        .layui-col-sm4,
        .layui-col-sm5,
        .layui-col-sm6,
        .layui-col-sm7,
        .layui-col-sm8,
        .layui-col-sm9,
        .layui-col-sm10,
        .layui-col-sm11,
        .layui-col-sm12,
        .layui-col-md1,
        .layui-col-md2,
        .layui-col-md3,
        .layui-col-md4,
        .layui-col-md5,
        .layui-col-md6,
        .layui-col-md7,
        .layui-col-md8,
        .layui-col-md9,
        .layui-col-md10,
        .layui-col-md11,
        .layui-col-md12,
        .layui-col-lg1,
        .layui-col-lg2,
        .layui-col-lg3,
        .layui-col-lg4,
        .layui-col-lg5,
        .layui-col-lg6,
        .layui-col-lg7,
        .layui-col-lg8,
        .layui-col-lg9,
        .layui-col-lg10,
        .layui-col-lg11,
        .layui-col-lg12,
        .layui-col-xl1,
        .layui-col-xl2,
        .layui-col-xl3,
        .layui-col-xl4,
        .layui-col-xl5,
        .layui-col-xl6,
        .layui-col-xl7,
        .layui-col-xl8,
        .layui-col-xl9,
        .layui-col-xl10,
        .layui-col-xl11,
        .layui-col-xl12 {
            position: relative;
            display: block;
            box-sizing: border-box;
        }

        .layui-col-xs1,
        .layui-col-xs2,
        .layui-col-xs3,
        .layui-col-xs4,
        .layui-col-xs5,
        .layui-col-xs6,
        .layui-col-xs7,
        .layui-col-xs8,
        .layui-col-xs9,
        .layui-col-xs10,
        .layui-col-xs11,
        .layui-col-xs12 {
            float: left;
        }

        .layui-col-xs1 {
            width: 8.33333333%;
        }

        .layui-col-xs2 {
            width: 16.66666667%;
        }

        .layui-col-xs3 {
            width: 25%;
        }

        .layui-col-xs4 {
            width: 33.33333333%;
        }

        .layui-col-xs5 {
            width: 41.66666667%;
        }

        .layui-col-xs6 {
            width: 50%;
        }

        .layui-col-xs7 {
            width: 58.33333333%;
        }

        .layui-col-xs8 {
            width: 66.66666667%;
        }

        .layui-col-xs9 {
            width: 75%;
        }

        .layui-col-xs10 {
            width: 83.33333333%;
        }

        .layui-col-xs11 {
            width: 91.66666667%;
        }

        .layui-col-xs12 {
            width: 100%;
        }

        .layui-col-xs-offset1 {
            margin-left: 8.33333333%;
        }

        .layui-col-xs-offset2 {
            margin-left: 16.66666667%;
        }

        .layui-col-xs-offset3 {
            margin-left: 25%;
        }

        .layui-col-xs-offset4 {
            margin-left: 33.33333333%;
        }

        .layui-col-xs-offset5 {
            margin-left: 41.66666667%;
        }

        .layui-col-xs-offset6 {
            margin-left: 50%;
        }

        .layui-col-xs-offset7 {
            margin-left: 58.33333333%;
        }

        .layui-col-xs-offset8 {
            margin-left: 66.66666667%;
        }

        .layui-col-xs-offset9 {
            margin-left: 75%;
        }

        .layui-col-xs-offset10 {
            margin-left: 83.33333333%;
        }

        .layui-col-xs-offset11 {
            margin-left: 91.66666667%;
        }

        .layui-col-xs-offset12 {
            margin-left: 100%;
        }

        /* 超小屏幕 */
        @media screen and (max-width: 767.98px) {
            .layui-container {
                padding: 0 15px;
            }

            .layui-hide-xs {
                display: none !important;
            }

            .layui-show-xs-block {
                display: block !important;
            }

            .layui-show-xs-inline {
                display: inline !important;
            }

            .layui-show-xs-inline-block {
                display: inline-block !important;
            }
        }

        /* 小型屏幕 */
        @media screen and (min-width: 768px) {
            .layui-container {
                width: 720px;
            }

            .layui-hide-sm {
                display: none !important;
            }

            .layui-show-sm-block {
                display: block !important;
            }

            .layui-show-sm-inline {
                display: inline !important;
            }

            .layui-show-sm-inline-block {
                display: inline-block !important;
            }

            .layui-col-sm1,
            .layui-col-sm2,
            .layui-col-sm3,
            .layui-col-sm4,
            .layui-col-sm5,
            .layui-col-sm6,
            .layui-col-sm7,
            .layui-col-sm8,
            .layui-col-sm9,
            .layui-col-sm10,
            .layui-col-sm11,
            .layui-col-sm12 {
                float: left;
            }

            .layui-col-sm1 {
                width: 8.33333333%;
            }

            .layui-col-sm2 {
                width: 16.66666667%;
            }

            .layui-col-sm3 {
                width: 25%;
            }

            .layui-col-sm4 {
                width: 33.33333333%;
            }

            .layui-col-sm5 {
                width: 41.66666667%;
            }

            .layui-col-sm6 {
                width: 50%;
            }

            .layui-col-sm7 {
                width: 58.33333333%;
            }

            .layui-col-sm8 {
                width: 66.66666667%;
            }

            .layui-col-sm9 {
                width: 75%;
            }

            .layui-col-sm10 {
                width: 83.33333333%;
            }

            .layui-col-sm11 {
                width: 91.66666667%;
            }

            .layui-col-sm12 {
                width: 100%;
            }

            /* 列偏移 */
            .layui-col-sm-offset1 {
                margin-left: 8.33333333%;
            }

            .layui-col-sm-offset2 {
                margin-left: 16.66666667%;
            }

            .layui-col-sm-offset3 {
                margin-left: 25%;
            }

            .layui-col-sm-offset4 {
                margin-left: 33.33333333%;
            }

            .layui-col-sm-offset5 {
                margin-left: 41.66666667%;
            }

            .layui-col-sm-offset6 {
                margin-left: 50%;
            }

            .layui-col-sm-offset7 {
                margin-left: 58.33333333%;
            }

            .layui-col-sm-offset8 {
                margin-left: 66.66666667%;
            }

            .layui-col-sm-offset9 {
                margin-left: 75%;
            }

            .layui-col-sm-offset10 {
                margin-left: 83.33333333%;
            }

            .layui-col-sm-offset11 {
                margin-left: 91.66666667%;
            }

            .layui-col-sm-offset12 {
                margin-left: 100%;
            }
        }

        /* 中型屏幕 */
        @media screen and (min-width: 992px) {
            .layui-container {
                width: 960px;
            }

            .layui-hide-md {
                display: none !important;
            }

            .layui-show-md-block {
                display: block !important;
            }

            .layui-show-md-inline {
                display: inline !important;
            }

            .layui-show-md-inline-block {
                display: inline-block !important;
            }

            .layui-col-md1,
            .layui-col-md2,
            .layui-col-md3,
            .layui-col-md4,
            .layui-col-md5,
            .layui-col-md6,
            .layui-col-md7,
            .layui-col-md8,
            .layui-col-md9,
            .layui-col-md10,
            .layui-col-md11,
            .layui-col-md12 {
                float: left;
            }

            .layui-col-md1 {
                width: 8.33333333%;
            }

            .layui-col-md2 {
                width: 16.66666667%;
            }

            .layui-col-md3 {
                width: 25%;
            }

            .layui-col-md4 {
                width: 33.33333333%;
            }

            .layui-col-md5 {
                width: 41.66666667%;
            }

            .layui-col-md6 {
                width: 50%;
            }

            .layui-col-md7 {
                width: 58.33333333%;
            }

            .layui-col-md8 {
                width: 66.66666667%;
            }

            .layui-col-md9 {
                width: 75%;
            }

            .layui-col-md10 {
                width: 83.33333333%;
            }

            .layui-col-md11 {
                width: 91.66666667%;
            }

            .layui-col-md12 {
                width: 100%;
            }

            /* 列偏移 */
            .layui-col-md-offset1 {
                margin-left: 8.33333333%;
            }

            .layui-col-md-offset2 {
                margin-left: 16.66666667%;
            }

            .layui-col-md-offset3 {
                margin-left: 25%;
            }

            .layui-col-md-offset4 {
                margin-left: 33.33333333%;
            }

            .layui-col-md-offset5 {
                margin-left: 41.66666667%;
            }

            .layui-col-md-offset6 {
                margin-left: 50%;
            }

            .layui-col-md-offset7 {
                margin-left: 58.33333333%;
            }

            .layui-col-md-offset8 {
                margin-left: 66.66666667%;
            }

            .layui-col-md-offset9 {
                margin-left: 75%;
            }

            .layui-col-md-offset10 {
                margin-left: 83.33333333%;
            }

            .layui-col-md-offset11 {
                margin-left: 91.66666667%;
            }

            .layui-col-md-offset12 {
                margin-left: 100%;
            }
        }

        /* 大型屏幕 */
        @media screen and (min-width: 1200px) {
            .layui-container {
                width: 1150px;
            }

            .layui-hide-lg {
                display: none !important;
            }

            .layui-show-lg-block {
                display: block !important;
            }

            .layui-show-lg-inline {
                display: inline !important;
            }

            .layui-show-lg-inline-block {
                display: inline-block !important;
            }

            .layui-col-lg1,
            .layui-col-lg2,
            .layui-col-lg3,
            .layui-col-lg4,
            .layui-col-lg5,
            .layui-col-lg6,
            .layui-col-lg7,
            .layui-col-lg8,
            .layui-col-lg9,
            .layui-col-lg10,
            .layui-col-lg11,
            .layui-col-lg12 {
                float: left;
            }

            .layui-col-lg1 {
                width: 8.33333333%;
            }

            .layui-col-lg2 {
                width: 16.66666667%;
            }

            .layui-col-lg3 {
                width: 25%;
            }

            .layui-col-lg4 {
                width: 33.33333333%;
            }

            .layui-col-lg5 {
                width: 41.66666667%;
            }

            .layui-col-lg6 {
                width: 50%;
            }

            .layui-col-lg7 {
                width: 58.33333333%;
            }

            .layui-col-lg8 {
                width: 66.66666667%;
            }

            .layui-col-lg9 {
                width: 75%;
            }

            .layui-col-lg10 {
                width: 83.33333333%;
            }

            .layui-col-lg11 {
                width: 91.66666667%;
            }

            .layui-col-lg12 {
                width: 100%;
            }

            /* 列偏移 */
            .layui-col-lg-offset1 {
                margin-left: 8.33333333%;
            }

            .layui-col-lg-offset2 {
                margin-left: 16.66666667%;
            }

            .layui-col-lg-offset3 {
                margin-left: 25%;
            }

            .layui-col-lg-offset4 {
                margin-left: 33.33333333%;
            }

            .layui-col-lg-offset5 {
                margin-left: 41.66666667%;
            }

            .layui-col-lg-offset6 {
                margin-left: 50%;
            }

            .layui-col-lg-offset7 {
                margin-left: 58.33333333%;
            }

            .layui-col-lg-offset8 {
                margin-left: 66.66666667%;
            }

            .layui-col-lg-offset9 {
                margin-left: 75%;
            }

            .layui-col-lg-offset10 {
                margin-left: 83.33333333%;
            }

            .layui-col-lg-offset11 {
                margin-left: 91.66666667%;
            }

            .layui-col-lg-offset12 {
                margin-left: 100%;
            }
        }

        /* 超大屏幕 */
        @media screen and (min-width: 1400px) {
            .layui-container {
                width: 1330px;
            }

            .layui-hide-xl {
                display: none !important;
            }

            .layui-show-xl-block {
                display: block !important;
            }

            .layui-show-xl-inline {
                display: inline !important;
            }

            .layui-show-xl-inline-block {
                display: inline-block !important;
            }

            .layui-col-xl1,
            .layui-col-xl2,
            .layui-col-xl3,
            .layui-col-xl4,
            .layui-col-xl5,
            .layui-col-xl6,
            .layui-col-xl7,
            .layui-col-xl8,
            .layui-col-xl9,
            .layui-col-xl10,
            .layui-col-xl11,
            .layui-col-xl12 {
                float: left;
            }

            .layui-col-xl1 {
                width: 8.33333333%;
            }

            .layui-col-xl2 {
                width: 16.66666667%;
            }

            .layui-col-xl3 {
                width: 25%;
            }

            .layui-col-xl4 {
                width: 33.33333333%;
            }

            .layui-col-xl5 {
                width: 41.66666667%;
            }

            .layui-col-xl6 {
                width: 50%;
            }

            .layui-col-xl7 {
                width: 58.33333333%;
            }

            .layui-col-xl8 {
                width: 66.66666667%;
            }

            .layui-col-xl9 {
                width: 75%;
            }

            .layui-col-xl10 {
                width: 83.33333333%;
            }

            .layui-col-xl11 {
                width: 91.66666667%;
            }

            .layui-col-xl12 {
                width: 100%;
            }

            /* 列偏移 */
            .layui-col-xl-offset1 {
                margin-left: 8.33333333%;
            }

            .layui-col-xl-offset2 {
                margin-left: 16.66666667%;
            }

            .layui-col-xl-offset3 {
                margin-left: 25%;
            }

            .layui-col-xl-offset4 {
                margin-left: 33.33333333%;
            }

            .layui-col-xl-offset5 {
                margin-left: 41.66666667%;
            }

            .layui-col-xl-offset6 {
                margin-left: 50%;
            }

            .layui-col-xl-offset7 {
                margin-left: 58.33333333%;
            }

            .layui-col-xl-offset8 {
                margin-left: 66.66666667%;
            }

            .layui-col-xl-offset9 {
                margin-left: 75%;
            }

            .layui-col-xl-offset10 {
                margin-left: 83.33333333%;
            }

            .layui-col-xl-offset11 {
                margin-left: 91.66666667%;
            }

            .layui-col-xl-offset12 {
                margin-left: 100%;
            }
        }

        /* 列间隔 */
        .layui-col-space1 {
            margin: -0.5px;
        }

        .layui-col-space1 > * {
            padding: 0.5px;
        }

        .layui-col-space2 {
            margin: -1px;
        }

        .layui-col-space2 > * {
            padding: 1px;
        }

        .layui-col-space4 {
            margin: -2px;
        }

        .layui-col-space4 > * {
            padding: 2px;
        }

        .layui-col-space5 {
            margin: -2.5px;
        }

        .layui-col-space5 > * {
            padding: 2.5px;
        }

        .layui-col-space6 {
            margin: -3px;
        }

        .layui-col-space6 > * {
            padding: 3px;
        }

        .layui-col-space8 {
            margin: -4px;
        }

        .layui-col-space8 > * {
            padding: 4px;
        }

        .layui-col-space10 {
            margin: -5px;
        }

        .layui-col-space10 > * {
            padding: 5px;
        }

        .layui-col-space12 {
            margin: -6px;
        }

        .layui-col-space12 > * {
            padding: 6px;
        }

        .layui-col-space14 {
            margin: -7px;
        }

        .layui-col-space14 > * {
            padding: 7px;
        }

        .layui-col-space15 {
            margin: -7.5px;
        }

        .layui-col-space15 > * {
            padding: 7.5px;
        }

        .layui-col-space16 {
            margin: -8px;
        }

        .layui-col-space16 > * {
            padding: 8px;
        }

        .layui-col-space18 {
            margin: -9px;
        }

        .layui-col-space18 > * {
            padding: 9px;
        }

        .layui-col-space20 {
            margin: -10px;
        }

        .layui-col-space20 > * {
            padding: 10px;
        }

        .layui-col-space22 {
            margin: -11px;
        }

        .layui-col-space22 > * {
            padding: 11px;
        }

        .layui-col-space24 {
            margin: -12px;
        }

        .layui-col-space24 > * {
            padding: 12px;
        }

        .layui-col-space25 {
            margin: -12.5px;
        }

        .layui-col-space25 > * {
            padding: 12.5px;
        }

        .layui-col-space26 {
            margin: -13px;
        }

        .layui-col-space26 > * {
            padding: 13px;
        }

        .layui-col-space28 {
            margin: -14px;
        }

        .layui-col-space28 > * {
            padding: 14px;
        }

        .layui-col-space30 {
            margin: -15px;
        }

        .layui-col-space30 > * {
            padding: 15px;
        }

        .layui-col-space32 {
            margin: -16px;
        }

        .layui-col-space32 > * {
            padding: 16px;
        }


        /* 内边距  */
        .layui-padding-1 {
            padding: 4px !important;
        }

        .layui-padding-2 {
            padding: 8px !important;
        }

        .layui-padding-3 {
            padding: 16px !important;
        }

        .layui-padding-4 {
            padding: 32px !important;
        }

        .layui-padding-5 {
            padding: 48px !important;
        }

        /* 外边距  */
        .layui-margin-1 {
            margin: 4px !important;
        }

        .layui-margin-2 {
            margin: 8px !important;
        }

        .layui-margin-3 {
            margin: 16px !important;
        }

        .layui-margin-4 {
            margin: 32px !important;
        }

        .layui-margin-5 {
            margin: 48px !important;
        }


        /*
 * 页面元素
 */

        .layui-btn,
        .layui-input,
        .layui-select,
        .layui-textarea,
        .layui-upload-button {
            outline: none;
            -webkit-appearance: none;
            transition: all .3s;
            -webkit-transition: all .3s;
            box-sizing: border-box;
        }

        /* 引用 */
        .layui-elem-quote {
            margin-bottom: 10px;
            padding: 15px;
            line-height: 1.8;
            border-left: 5px solid #16b777;
            border-radius: 0 2px 2px 0;
            background-color: #fafafa;
        }

        .layui-quote-nm {
            border-style: solid;
            border-width: 1px;
            border-left-width: 5px;
            background: none;
        }

        /* 字段集合 */
        .layui-elem-field {
            margin-bottom: 10px;
            padding: 0;
            border-width: 1px;
            border-style: solid;
        }

        .layui-elem-field legend {
            margin-left: 20px;
            padding: 0 10px;
            font-size: 20px;
        }

        .layui-field-title {
            margin: 16px 0;
            border-width: 0;
            border-top-width: 1px;
        }

        .layui-field-box {
            padding: 15px;
        }

        .layui-field-title .layui-field-box {
            padding: 10px 0;
        }

        /* 进度条 */
        .layui-progress {
            position: relative;
            height: 6px;
            border-radius: 20px;
            background-color: #eee;
        }

        .layui-progress-bar {
            position: absolute;
            left: 0;
            top: 0;
            width: 0;
            max-width: 100%;
            height: 6px;
            border-radius: 20px;
            text-align: right;
            background-color: #16b777;
            transition: all .3s;
            -webkit-transition: all .3s;
        }

        .layui-progress-big,
        .layui-progress-big .layui-progress-bar {
            height: 18px;
            line-height: 18px;
        }

        .layui-progress-text {
            position: relative;
            top: -20px;
            line-height: 18px;
            font-size: 12px;
            color: #5F5F5F
        }

        .layui-progress-big .layui-progress-text {
            position: static;
            padding: 0 10px;
            color: #fff;
        }


        /*
 * 面板
 */


        /* 折叠面板 */
        .layui-collapse {
            border-width: 1px;
            border-style: solid;
            border-radius: 2px;
        }

        .layui-colla-item,
        .layui-colla-content {
            border-top-width: 1px;
            border-top-style: solid;
        }

        .layui-colla-item:first-child {
            border-top: none;
        }

        .layui-colla-title {
            position: relative;
            height: 42px;
            line-height: 42px;
            padding: 0 15px 0 35px;
            color: #333;
            background-color: #fafafa;
            cursor: pointer;
            font-size: 14px;
            overflow: hidden;
        }

        .layui-colla-content {
            display: none;
            padding: 10px 15px;
            line-height: 1.6;
            color: #5F5F5F;
        }

        .layui-colla-icon {
            position: absolute;
            left: 15px;
            top: 0;
            font-size: 14px;
        }

        /* 卡片面板 */
        .layui-card {
            margin-bottom: 15px;
            border-radius: 2px;
            background-color: #fff;
            box-shadow: 0 1px 2px 0 rgba(0, 0, 0, .05);
        }

        .layui-card:last-child {
            margin-bottom: 0;
        }

        .layui-card-header {
            position: relative;
            height: 42px;
            line-height: 42px;
            padding: 0 15px;
            border-bottom: 1px solid #f8f8f8;
            color: #333;
            border-radius: 2px 2px 0 0;
            font-size: 14px;
        }

        .layui-card-body {
            position: relative;
            padding: 10px 15px;
            line-height: 24px;
        }

        .layui-card-body[pad15] {
            padding: 15px;
        }

        .layui-card-body[pad20] {
            padding: 20px;
        }

        .layui-card-body .layui-table {
            margin: 5px 0;
        }

        .layui-card .layui-tab {
            margin: 0;
        }

        /* 常规面板 */
        .layui-panel {
            position: relative;
            border-width: 1px;
            border-style: solid;
            border-radius: 2px;
            box-shadow: 1px 1px 4px rgb(0 0 0 / 8%);
            background-color: #fff;
            color: #5F5F5F;
        }

        /* 窗口面板 */
        .layui-panel-window {
            position: relative;
            padding: 15px;
            border-radius: 0;
            border-top: 5px solid #eee;
            background-color: #fff;
        }

        /* 其它辅助 */
        .layui-auxiliar-moving {
            position: fixed;
            left: 0;
            right: 0;
            top: 0;
            bottom: 0;
            width: 100%;
            height: 100%;
            background: none;
            z-index: 9999999999;
        }

        .layui-scrollbar-hide {
            overflow: hidden !important;
        }


        /*
 * 默认主题
 */


        /* 背景颜色 */
        .layui-bg-red {
            background-color: #ff5722 !important;
            color: #fff !important;
        }

        /*赤*/
        .layui-bg-orange {
            background-color: #ffb800 !important;
            color: #fff !important;
        }

        /*橙*/
        .layui-bg-green {
            background-color: #16baaa !important;
            color: #fff !important;
        }

        /*绿*/
        .layui-bg-cyan {
            background-color: #2f4056 !important;
            color: #fff !important;
        }

        /*藏青*/
        .layui-bg-blue {
            background-color: #1e9fff !important;
            color: #fff !important;
        }

        /*蓝*/
        .layui-bg-purple {
            background-color: #a233c6 !important;
            color: #fff !important;
        }

        /*紫*/
        .layui-bg-black {
            background-color: #2f363c !important;
            color: #fff !important;
        }

        /*深*/
        .layui-bg-gray {
            background-color: #fafafa !important;
            color: #5F5F5F !important;
        }

        /*浅*/

        /* 边框 */
        .layui-border,
        .layui-quote-nm,
        .layui-elem-field,
        .layui-collapse,
        .layui-panel,
        .layui-colla-item,
        .layui-colla-content,
        .layui-badge-rim,
        .layui-tab-title,
        .layui-tab-title .layui-this:after,
        .layui-tab-bar,
        .layui-tab-card,
        .layui-input,
        .layui-textarea,
        .layui-select,
        .layui-input-split,
        .layui-form-pane .layui-form-label,
        .layui-form-pane .layui-form-item[pane] {
            border-color: #eee;
        }

        .layui-border {
            border-width: 1px;
            border-style: solid;
            color: #5F5F5F !important;
        }

        .layui-border-red {
            border-width: 1px;
            border-style: solid;
            border-color: #ff5722 !important;
            color: #ff5722 !important;
        }

        .layui-border-orange {
            border-width: 1px;
            border-style: solid;
            border-color: #ffb800 !important;
            color: #ffb800 !important;
        }

        .layui-border-green {
            border-width: 1px;
            border-style: solid;
            border-color: #16baaa !important;
            color: #16baaa !important;
        }

        .layui-border-cyan {
            border-width: 1px;
            border-style: solid;
            border-color: #2f4056 !important;
            color: #2f4056 !important;
        }

        .layui-border-blue {
            border-width: 1px;
            border-style: solid;
            border-color: #1e9fff !important;
            color: #1e9fff !important;
        }

        .layui-border-purple {
            border-width: 1px;
            border-style: solid;
            border-color: #a233c6 !important;
            color: #a233c6 !important;
        }

        .layui-border-black {
            border-width: 1px;
            border-style: solid;
            border-color: #2f363c !important;
            color: #2f363c !important;
        }

        /* 背景边框 */
        .layui-timeline-item:before {
            background-color: #eee;
        }

        /* 文本区域 */
        .layui-text {
            line-height: 1.8;
            font-size: 14px;
        }

        .layui-text h1,
        .layui-text h2,
        .layui-text h3,
        .layui-text h4,
        .layui-text h5,
        .layui-text h6 {
            color: #3A3A3A;
        }

        .layui-text h1 {
            font-size: 32px;
        }

        .layui-text h2 {
            font-size: 24px;
        }

        .layui-text h3 {
            font-size: 18px;
        }

        .layui-text h4 {
            font-size: 16px;
        }

        .layui-text h5 {
            font-size: 14px;
        }

        .layui-text h6 {
            font-size: 13px;
        }

        .layui-text ul,
        .layui-text ol {
            padding-left: 15px;
        }

        .layui-text ul li {
            margin-top: 5px;
            list-style-type: disc;
        }

        .layui-text ol li {
            margin-top: 5px;
            list-style-type: decimal;
        }

        .layui-text-em,
        .layui-word-aux {
            color: #999 !important;
            padding-left: 5px !important;
            padding-right: 5px !important;
        }

        .layui-text p {
            margin: 15px 0;
        }

        .layui-text p:first-child {
            margin-top: 0;
        }

        .layui-text p:last-child {
            margin-bottom: 0;
        }

        .layui-text a:not(.layui-btn) {
            color: #01AAED;
        }

        .layui-text a:not(.layui-btn):hover {
            text-decoration: underline;
        }

        .layui-text blockquote:not(.layui-elem-quote) {
            padding: 5px 15px;
            border-left: 5px solid #eee;
        }

        .layui-text pre > code:not(.layui-code) {
            padding: 15px;
            font-family: "Courier New", Consolas, "Lucida Console";
        }

        /* 字体大小 */
        .layui-font-12 {
            font-size: 12px !important;
        }

        .layui-font-13 {
            font-size: 13px !important;
        }

        .layui-font-14 {
            font-size: 14px !important;
        }

        .layui-font-16 {
            font-size: 16px !important;
        }

        .layui-font-18 {
            font-size: 18px !important;
        }

        .layui-font-20 {
            font-size: 20px !important;
        }

        .layui-font-22 {
            font-size: 22px !important;
        }

        .layui-font-24 {
            font-size: 24px !important;
        }

        .layui-font-26 {
            font-size: 26px !important;
        }

        .layui-font-28 {
            font-size: 28px !important;
        }

        .layui-font-30 {
            font-size: 30px !important;
        }

        .layui-font-32 {
            font-size: 32px !important;
        }

        /* 字体颜色 */
        .layui-font-red {
            color: #ff5722 !important;
        }

        /*赤*/
        .layui-font-orange {
            color: #ffb800 !important;
        }

        /*橙*/
        .layui-font-green {
            color: #16baaa !important;
        }

        /*绿*/
        .layui-font-cyan {
            color: #2f4056 !important;
        }

        /*藏青*/
        .layui-font-blue {
            color: #01AAED !important;
        }

        /*蓝*/
        .layui-font-purple {
            color: #a233c6 !important;
        }

        /*紫*/
        .layui-font-black {
            color: #000 !important;
        }

        /*深*/
        .layui-font-gray {
            color: #c2c2c2 !important;
        }

        /*浅*/


        /*
 * 按钮
 */

        .layui-btn {
            display: inline-block;
            vertical-align: middle;
            height: 38px;
            line-height: 38px;
            border: 1px solid transparent;
            padding: 0 18px;
            background-color: #16baaa;
            color: #fff;
            white-space: nowrap;
            text-align: center;
            font-size: 14px;
            border-radius: 2px;
            cursor: pointer;
            -moz-user-select: none;
            -webkit-user-select: none;
            -ms-user-select: none;
        }

        .layui-btn:hover {
            opacity: 0.8;
            filter: alpha(opacity=80);
            color: #fff;
        }

        .layui-btn:active {
            opacity: 1;
            filter: alpha(opacity=100);
        }

        .layui-btn + .layui-btn {
            margin-left: 10px;
        }

        /* 按钮容器 */
        .layui-btn-container {
            word-spacing: -5px;
        }

        .layui-btn-container .layui-btn {
            margin-right: 10px;
            margin-bottom: 10px;
            word-spacing: normal;
        }

        .layui-btn-container .layui-btn + .layui-btn {
            margin-left: 0;
        }

        .layui-table .layui-btn-container .layui-btn {
            margin-bottom: 9px;
        }


        /* 圆角 */
        .layui-btn-radius {
            border-radius: 100px;
        }

        .layui-btn .layui-icon {
            padding: 0 2px;
            vertical-align: middle \0;
            vertical-align: bottom;
        }

        /* 原始 */
        .layui-btn-primary {
            border-color: #d2d2d2;
            background: none;
            color: #5F5F5F;
        }

        .layui-btn-primary:hover {
            border-color: #16baaa;
            color: #333;
        }

        /* 百搭 */
        .layui-btn-normal {
            background-color: #1e9fff;
        }

        /* 暖色 */
        .layui-btn-warm {
            background-color: #ffb800;
        }

        /* 警告 */
        .layui-btn-danger {
            background-color: #ff5722;
        }

        /* 选中 */
        .layui-btn-checked {
            background-color: #16b777;
        }

        /* 禁用 */
        .layui-btn-disabled,
        .layui-btn-disabled:hover,
        .layui-btn-disabled:active {
            border-color: #eee !important;
            background-color: #FBFBFB !important;
            color: #d2d2d2 !important;
            cursor: not-allowed !important;
            opacity: 1;
        }

        /* 大型 */
        .layui-btn-lg {
            height: 44px;
            line-height: 44px;
            padding: 0 25px;
            font-size: 16px;
        }

        /* 小型 */
        .layui-btn-sm {
            height: 30px;
            line-height: 30px;
            padding: 0 10px;
            font-size: 12px;
        }

        /* 超小 */
        .layui-btn-xs {
            height: 22px;
            line-height: 22px;
            padding: 0 5px;
            font-size: 12px;
        }

        .layui-btn-xs i {
            font-size: 12px !important;
        }

        /* 按钮组 */
        .layui-btn-group {
            display: inline-block;
            vertical-align: middle;
            font-size: 0;
        }

        .layui-btn-group .layui-btn {
            margin-left: 0 !important;
            margin-right: 0 !important;
            border-left: 1px solid rgba(255, 255, 255, .5);
            border-radius: 0;
        }

        .layui-btn-group .layui-btn-primary {
            border-left: none;
        }

        .layui-btn-group .layui-btn-primary:hover {
            border-color: #d2d2d2;
            color: #16baaa;
        }

        .layui-btn-group .layui-btn:first-child {
            border-left: none;
            border-radius: 2px 0 0 2px;
        }

        .layui-btn-group .layui-btn-primary:first-child {
            border-left: 1px solid #d2d2d2;
        }

        .layui-btn-group .layui-btn:last-child {
            border-radius: 0 2px 2px 0;
        }

        .layui-btn-group .layui-btn + .layui-btn {
            margin-left: 0;
        }

        .layui-btn-group + .layui-btn-group {
            margin-left: 10px;
        }

        /* 流体 */
        .layui-btn-fluid {
            width: 100%;
        }

        /** 表单 **/
        .layui-input,
        .layui-textarea,
        .layui-select {
            height: 38px;
            line-height: 1.3;
            line-height: 38px \9;
            border-width: 1px;
            border-style: solid;
            background-color: #fff;
            color: rgba(0, 0, 0, .85);
            border-radius: 2px;
        }

        .layui-input::-webkit-input-placeholder,
        .layui-textarea::-webkit-input-placeholder,
        .layui-select::-webkit-input-placeholder {
            line-height: 1.3;
        }

        .layui-input,
        .layui-textarea {
            display: block;
            width: 100%;
            padding-left: 10px;
        }

        .layui-input:hover,
        .layui-textarea:hover {
            border-color: #d2d2d2 !important;
        }

        .layui-input:focus,
        .layui-textarea:focus {
            border-color: #16b777 !important;
            box-shadow: 0 0 0 3px rgba(22, 183, 119, 0.08);
        }

        .layui-textarea {
            position: relative;
            min-height: 100px;
            height: auto;
            line-height: 20px;
            padding: 6px 10px;
            resize: vertical;
        }

        .layui-input[disabled],
        .layui-textarea[disabled] {
            background-color: #fafafa;
        }

        .layui-select {
            padding: 0 10px;
        }

        .layui-form select,
        .layui-form input[type=checkbox],
        .layui-form input[type=radio] {
            display: none;
        }

        .layui-form *[lay-ignore] {
            display: initial;
        }

        .layui-form-item {
            position: relative;
            margin-bottom: 15px;
            clear: both;
            *zoom: 1;
        }

        .layui-form-item:after {
            content: '\20';
            clear: both;
            *zoom: 1;
            display: block;
            height: 0;
        }

        .layui-form-label {
            position: relative;
            float: left;
            display: block;
            padding: 9px 15px;
            width: 80px;
            font-weight: 400;
            line-height: 20px;
            text-align: right;
        }

        .layui-form-label-col {
            display: block;
            float: none;
            padding: 9px 0;
            line-height: 20px;
            text-align: left;
        }

        .layui-form-item .layui-inline {
            margin-bottom: 5px;
            margin-right: 10px;
        }

        .layui-input-block,
        .layui-input-inline {
            position: relative;
        }

        .layui-input-block {
            margin-left: 110px;
            min-height: 36px;
        }

        .layui-input-inline {
            display: inline-block;
            vertical-align: middle;
        }

        .layui-form-item .layui-input-inline {
            float: left;
            width: 190px;
            margin-right: 10px;
        }

        .layui-form-text .layui-input-inline {
            width: auto;
        }

        /* 分割块 */
        .layui-form-mid {
            position: relative;
            float: left;
            display: block;
            padding: 9px 0 !important;
            line-height: 20px;
            margin-right: 10px;
        }

        /* 警告条 */
        .layui-form-danger:focus,
        .layui-form-danger + .layui-form-select .layui-input {
            border-color: #ff5722 !important;
            box-shadow: 0 0 0 3px rgba(255, 87, 34, 0.08);
        }


        /* 输入框点缀  */
        .layui-input-prefix,
        .layui-input-suffix,
        .layui-input-split,
        .layui-input-suffix .layui-input-affix {
            position: absolute;
            right: 0;
            top: 0;
            padding: 0 10px;
            width: 35px;
            height: 100%;
            text-align: center;
            transition: all .3s;
            box-sizing: border-box;
        }

        .layui-input-prefix {
            left: 0;
            border-radius: 2px 0 0 2px;
        }

        .layui-input-suffix {
            right: 0;
            border-radius: 0 2px 2px 0;
        }

        .layui-input-split {
            border-width: 1px;
            border-style: solid;
        }

        .layui-input-prefix .layui-icon,
        .layui-input-suffix .layui-icon,
        .layui-input-split .layui-icon {
            position: relative;
            font-size: 16px;
            color: #5F5F5F;
            transition: all .3s;
        }

        /* 输入框前后置容器 */
        .layui-input-group {
            position: relative;
            display: table;
            box-sizing: border-box;
        }

        .layui-input-group > * {
            display: table-cell;
            vertical-align: middle;
            position: relative;
        }

        .layui-input-group .layui-input {
            padding-right: 15px;
        }

        .layui-input-group > .layui-input-prefix {
            width: auto;
            border-right: 0;
        }

        .layui-input-group > .layui-input-suffix {
            width: auto;
            border-left: 0;
        }

        .layui-input-group .layui-input-split {
            white-space: nowrap;
        }

        /* 输入框前后缀容器 */
        .layui-input-wrap {
            position: relative;
            line-height: 38px;
        }

        .layui-input-wrap .layui-input {
            padding-right: 35px;;
        }

        .layui-input-wrap .layui-input::-ms-clear,
        .layui-input-wrap .layui-input::-ms-reveal {
            display: none;
        }

        .layui-input-wrap .layui-input-prefix + .layui-input,
        .layui-input-wrap .layui-input-prefix ~ * .layui-input {
            padding-left: 35px;
        }

        .layui-input-wrap .layui-input-split + .layui-input,
        .layui-input-wrap .layui-input-split ~ * .layui-input {
            padding-left: 45px;
        }

        .layui-input-wrap .layui-input-prefix ~ .layui-form-select {
            position: static;
        }

        .layui-input-wrap .layui-input-prefix,
        .layui-input-wrap .layui-input-suffix,
        .layui-input-wrap .layui-input-split {
            pointer-events: none;
        }

        .layui-input-wrap .layui-input:hover + .layui-input-split {
            border-color: #d2d2d2;
        }

        .layui-input-wrap .layui-input:focus + .layui-input-split {
            border-color: #16b777;
        }

        .layui-input-wrap .layui-input.layui-form-danger:focus + .layui-input-split {
            border-color: #ff5722;
        }

        .layui-input-wrap .layui-input-prefix.layui-input-split {
            border-width: 0;
            border-right-width: 1px;
        }

        /* 输入框动态点缀  */
        .layui-input-affix {
            line-height: 38px;
        }

        .layui-input-suffix .layui-input-affix {
            right: auto;
            left: -35px;
        }

        .layui-input-affix .layui-icon {
            color: rgba(0, 0, 0, .8);
            pointer-events: auto !important;
            cursor: pointer;
        }

        .layui-input-affix .layui-icon-clear {
            color: rgba(0, 0, 0, .3);
        }

        .layui-input-affix .layui-icon:hover {
            color: rgba(0, 0, 0, .6);
        }

        /* 数字输入框动态点缀  */
        .layui-input-wrap .layui-input-number {
            width: 24px;
            padding: 0;
        }

        .layui-input-wrap .layui-input-number .layui-icon {
            position: absolute;
            right: 0;
            width: 100%;
            height: 50%;
            line-height: normal;
            font-size: 12px;
        }

        .layui-input-wrap .layui-input-number .layui-icon:before {
            position: absolute;
            left: 50%;
            top: 50%;
            margin-top: -6px;
            margin-left: -6px;
        }

        .layui-input-wrap .layui-input-number .layui-icon-up {
            top: 0;
            border-bottom: 1px solid #eee;
        }

        .layui-input-wrap .layui-input-number .layui-icon-down {
            bottom: 0;
        }

        .layui-input-wrap .layui-input-number .layui-icon:hover {
            font-weight: 700;
        }

        .layui-input-wrap .layui-input[type="number"]::-webkit-outer-spin-button,
        .layui-input-wrap .layui-input[type="number"]::-webkit-inner-spin-button {
            -webkit-appearance: none !important;
        }

        .layui-input-wrap .layui-input[type="number"] {
            -moz-appearance: textfield;
        }


        /* 下拉选择 */
        .layui-form-select {
            position: relative;
            color: #5F5F5F;
        }

        .layui-form-select .layui-input {
            padding-right: 30px;
            cursor: pointer;
        }

        .layui-form-select .layui-edge {
            position: absolute;
            right: 10px;
            top: 50%;
            margin-top: -3px;
            cursor: pointer;
            border-width: 6px;
            border-top-color: #c2c2c2;
            border-top-style: solid;
            transition: all .3s;
            -webkit-transition: all .3s;
        }

        .layui-form-select dl {
            display: none;
            position: absolute;
            left: 0;
            top: 42px;
            padding: 5px 0;
            z-index: 899;
            min-width: 100%;
            border: 1px solid #eee;
            max-height: 300px;
            overflow-y: auto;
            background-color: #fff;
            border-radius: 2px;
            box-shadow: 1px 1px 4px rgb(0 0 0 / 8%);
            box-sizing: border-box;
        }

        .layui-form-select dl dt,
        .layui-form-select dl dd {
            padding: 0 10px;
            line-height: 36px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .layui-form-select dl dt {
            font-size: 12px;
            color: #999;
        }

        .layui-form-select dl dd {
            cursor: pointer;
        }

        .layui-form-select dl dd:hover {
            background-color: #f8f8f8;
            -webkit-transition: .5s all;
            transition: .5s all;
        }

        .layui-form-select .layui-select-group dd {
            padding-left: 20px;
        }

        .layui-form-select dl dd.layui-select-tips {
            padding-left: 10px !important;
            color: #999;
        }

        .layui-form-select dl dd.layui-this {
            background-color: #f8f8f8;
            color: #16b777;
            font-weight: 700;
        }

        /*.layui-form-select dl dd.layui-this{background-color: #f8f8f8; color: #16b777; font-weight: 700;}*/
        .layui-form-select dl dd.layui-disabled {
            background-color: #fff;
        }

        .layui-form-selected dl {
            display: block;
        }

        .layui-form-selected .layui-edge {
            margin-top: -9px;
            -webkit-transform: rotate(180deg);
            transform: rotate(180deg);
        }

        .layui-form-selected .layui-edge {
            margin-top: -3px \0;
        }

        :root .layui-form-selected .layui-edge {
            margin-top: -9px \0/ IE9;
        }

        .layui-form-selectup dl {
            top: auto;
            bottom: 42px;
        }

        .layui-select-none {
            margin: 5px 0;
            text-align: center;
            color: #999;
        }

        .layui-select-disabled .layui-disabled {
            border-color: #eee !important;
        }

        .layui-select-disabled .layui-edge {
            border-top-color: #d2d2d2
        }

        /* 复选框 */
        .layui-form-checkbox {
            position: relative;
            display: inline-block;
            vertical-align: middle;
            height: 30px;
            line-height: 30px;
            margin-right: 10px;
            padding-right: 30px;
            background-color: #fff;
            cursor: pointer;
            font-size: 0;
            -webkit-transition: .1s linear;
            transition: .1s linear;
            box-sizing: border-box;
        }

        .layui-form-checkbox:hover {
        }

        .layui-form-checkbox > * {
            display: inline-block;
            vertical-align: middle;
        }

        .layui-form-checkbox > div {
            padding: 0 11px;
            font-size: 14px;
            border-radius: 2px 0 0 2px;
            background-color: #d2d2d2;
            color: #fff;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }

        .layui-form-checkbox > div > .layui-icon {
            line-height: normal
        }

        .layui-form-checkbox:hover > div {
            background-color: #c2c2c2;
        }

        .layui-form-checkbox > i {
            position: absolute;
            right: 0;
            top: 0;
            width: 30px;
            height: 100%;
            border: 1px solid #d2d2d2;
            border-left: none;
            border-radius: 0 2px 2px 0;
            color: #fff;
            color: rgba(255, 255, 255, 0);
            font-size: 20px;
            text-align: center;
            box-sizing: border-box;
        }

        .layui-form-checkbox:hover > i {
            border-color: #c2c2c2;
            color: #c2c2c2;
        }

        .layui-form-checked,
        .layui-form-checked:hover {
            border-color: #16b777;
        }

        .layui-form-checked > div,
        .layui-form-checked:hover > div {
            background-color: #16b777;
        }

        .layui-form-checked > i,
        .layui-form-checked:hover > i {
            color: #16b777;
        }

        .layui-form-item .layui-form-checkbox {
            margin-top: 4px;
        }

        .layui-form-checkbox.layui-checkbox-disabled > div {
            background-color: #eee !important;
        }

        .layui-form *[lay-checkbox] {
            display: none;
        }

        /* 复选框-默认风格 */
        .layui-form-checkbox[lay-skin="primary"] {
            height: auto !important;
            line-height: normal !important;
            min-width: 18px;
            min-height: 18px;
            border: none !important;
            margin-right: 0;
            padding-left: 24px;
            padding-right: 0;
            background: none;
        }

        .layui-form-checkbox[lay-skin="primary"] > div {
            margin-top: -1px;
            padding-left: 0;
            padding-right: 15px;
            line-height: 18px;
            background: none;
            color: #5F5F5F;
        }

        .layui-form-checkbox[lay-skin="primary"] > i {
            right: auto;
            left: 0;
            width: 16px;
            height: 16px;
            line-height: 14px;
            border: 1px solid #d2d2d2;
            font-size: 12px;
            border-radius: 2px;
            background-color: #fff;
            -webkit-transition: .1s linear;
            transition: .1s linear;
        }

        .layui-form-checkbox[lay-skin="primary"]:hover > i {
            border-color: #16b777;
            color: #fff;
        }

        .layui-form-checked[lay-skin="primary"] > i {
            border-color: #16b777 !important;
            background-color: #16b777;
            color: #fff;
        }

        .layui-checkbox-disabled[lay-skin="primary"] > div {
            background: none !important;
        }

        .layui-form-checked.layui-checkbox-disabled[lay-skin="primary"] > i {
            background: #eee !important;
            border-color: #eee !important;
        }

        .layui-checkbox-disabled[lay-skin="primary"]:hover > i {
            border-color: #d2d2d2;
        }

        .layui-form-item .layui-form-checkbox[lay-skin="primary"] {
            margin-top: 10px;
        }

        .layui-form-checkbox[lay-skin="primary"] > .layui-icon-indeterminate {
            border-color: #16b777;
        }

        .layui-form-checkbox[lay-skin="primary"] > .layui-icon-indeterminate:before {
            content: '';
            display: inline-block;
            vertical-align: middle;
            position: relative;
            width: 50%;
            height: 1px;
            margin: -1px auto 0;
            background-color: #16b777;
        }

        /* 复选框-开关风格 */
        .layui-form-switch {
            position: relative;
            display: inline-block;
            vertical-align: middle;
            height: 24px;
            line-height: 22px;
            min-width: 44px;
            padding: 0 5px;
            margin-top: 8px;
            border: 1px solid #d2d2d2;
            border-radius: 20px;
            cursor: pointer;
            box-sizing: border-box;
            background-color: #fff;
            -webkit-transition: .1s linear;
            transition: .1s linear;
        }

        .layui-form-switch > i {
            position: absolute;
            left: 5px;
            top: 3px;
            width: 16px;
            height: 16px;
            border-radius: 20px;
            background-color: #d2d2d2;
            -webkit-transition: .1s linear;
            transition: .1s linear;
        }

        .layui-form-switch > div {
            position: relative;
            top: 0;
            margin-left: 21px;
            padding: 0 !important;
            text-align: center !important;
            color: #999 !important;
            font-style: normal !important;
            font-size: 12px;
        }

        .layui-form-onswitch {
            border-color: #16b777;
            background-color: #16b777;
        }

        .layui-form-onswitch > i {
            left: 100%;
            margin-left: -21px;
            background-color: #fff;
        }

        .layui-form-onswitch > div {
            margin-left: 0;
            margin-right: 21px;
            color: #fff !important;
        }

        .layui-checkbox-disabled {
            border-color: #eee !important;
        }

        .layui-checkbox-disabled > div {
            color: #c2c2c2 !important;
        }

        .layui-checkbox-disabled > i {
            border-color: #eee !important;
        }

        .layui-checkbox-disabled:hover > i {
            color: #fff !important;
        }

        /* 单选框 */
        .layui-form-radio {
            display: inline-block;
            vertical-align: middle;
            line-height: 28px;
            margin: 6px 10px 0 0;
            padding-right: 10px;
            cursor: pointer;
            font-size: 0;
        }

        .layui-form-radio > * {
            display: inline-block;
            vertical-align: middle;
            font-size: 14px;
        }

        .layui-form-radio > i {
            margin-right: 8px;
            font-size: 22px;
            color: #c2c2c2;
        }

        .layui-form-radioed,
        .layui-form-radioed > i,
        .layui-form-radio:hover > * {
            color: #16b777;
        }

        .layui-radio-disabled > i {
            color: #eee !important;
        }

        .layui-radio-disabled > * {
            color: #c2c2c2 !important;
        }

        .layui-form *[lay-radio] {
            display: none;
        }

        /* 表单方框风格 */
        .layui-form-pane .layui-form-label {
            width: 110px;
            padding: 8px 15px;
            height: 38px;
            line-height: 20px;
            border-width: 1px;
            border-style: solid;
            border-radius: 2px 0 0 2px;
            text-align: center;
            background-color: #fafafa;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            box-sizing: border-box;
        }

        .layui-form-pane .layui-input-inline {
            margin-left: -1px;
        }

        .layui-form-pane .layui-input-block {
            margin-left: 110px;
            left: -1px;
        }

        .layui-form-pane .layui-input {
            border-radius: 0 2px 2px 0;
        }

        .layui-form-pane .layui-form-text .layui-form-label {
            float: none;
            width: 100%;
            border-radius: 2px;
            box-sizing: border-box;
            text-align: left;
        }

        .layui-form-pane .layui-form-text .layui-input-inline {
            display: block;
            margin: 0;
            top: -1px;
            clear: both;
        }

        .layui-form-pane .layui-form-text .layui-input-block {
            margin: 0;
            left: 0;
            top: -1px;
        }

        .layui-form-pane .layui-form-text .layui-textarea {
            min-height: 100px;
            border-radius: 0 0 2px 2px;
        }

        .layui-form-pane .layui-form-checkbox {
            margin: 4px 0 4px 10px;
        }

        .layui-form-pane .layui-form-switch,
        .layui-form-pane .layui-form-radio {
            margin-top: 6px;
            margin-left: 10px;
        }

        .layui-form-pane .layui-form-item[pane] {
            position: relative;
            border-width: 1px;
            border-style: solid;
        }

        .layui-form-pane .layui-form-item[pane] .layui-form-label {
            position: absolute;
            left: 0;
            top: 0;
            height: 100%;
            border-width: 0px;
            border-right-width: 1px;
        }

        .layui-form-pane .layui-form-item[pane] .layui-input-inline {
            margin-left: 110px;
        }

        /** 表单响应式 **/
        @media screen and (max-width: 450px) {
            .layui-form-item .layui-form-label {
                text-overflow: ellipsis;
                overflow: hidden;
                white-space: nowrap;
            }

            .layui-form-item .layui-inline {
                display: block;
                margin-right: 0;
                margin-bottom: 20px;
                clear: both;
            }

            .layui-form-item .layui-inline:after {
                content: '\20';
                clear: both;
                display: block;
                height: 0;
            }

            .layui-form-item .layui-input-inline {
                display: block;
                float: none;
                left: -3px;
                width: auto !important;
                margin: 0 0 10px 112px;
            }

            .layui-form-item .layui-input-inline + .layui-form-mid {
                margin-left: 110px;
                top: -5px;
                padding: 0;
            }

            .layui-form-item .layui-form-checkbox {
                margin-right: 5px;
                margin-bottom: 5px;
            }
        }

        /** 分页 **/
        .layui-laypage {
            display: inline-block;
            *display: inline;
            *zoom: 1;
            vertical-align: middle;
            margin: 10px 0;
            font-size: 0;
        }

        .layui-laypage > a:first-child,
        .layui-laypage > a:first-child em {
            border-radius: 2px 0 0 2px;
        }

        .layui-laypage > a:last-child,
        .layui-laypage > a:last-child em {
            border-radius: 0 2px 2px 0;
        }

        .layui-laypage > *:first-child {
            margin-left: 0 !important;
        }

        .layui-laypage > *:last-child {
            margin-right: 0 !important;
        }

        .layui-laypage a,
        .layui-laypage span,
        .layui-laypage input,
        .layui-laypage button,
        .layui-laypage select {
            border: 1px solid #eee;
        }

        .layui-laypage a,
        .layui-laypage span {
            display: inline-block;
            *display: inline;
            *zoom: 1;
            vertical-align: middle;
            padding: 0 15px;
            height: 28px;
            line-height: 28px;
            margin: 0 -1px 5px 0;
            background-color: #fff;
            color: #333;
            font-size: 12px;
        }

        .layui-laypage a[data-page] {
            color: #333;
        }

        .layui-laypage a {
            text-decoration: none !important;
            cursor: pointer;
        }

        .layui-laypage a:hover {
            color: #16baaa;
        }

        .layui-laypage em {
            font-style: normal;
        }

        .layui-laypage .layui-laypage-spr {
            color: #999;
            font-weight: 700;
        }

        .layui-laypage .layui-laypage-curr {
            position: relative;
        }

        .layui-laypage .layui-laypage-curr em {
            position: relative;
            color: #fff;
        }

        .layui-laypage .layui-laypage-curr .layui-laypage-em {
            position: absolute;
            left: -1px;
            top: -1px;
            padding: 1px;
            width: 100%;
            height: 100%;
            background-color: #16baaa;
        }

        .layui-laypage-em {
            border-radius: 2px;
        }

        .layui-laypage-prev em,
        .layui-laypage-next em {
            font-family: Sim sun;
            font-size: 16px;
        }

        .layui-laypage .layui-laypage-count,
        .layui-laypage .layui-laypage-limits,
        .layui-laypage .layui-laypage-refresh,
        .layui-laypage .layui-laypage-skip {
            margin-left: 10px;
            margin-right: 10px;
            padding: 0;
            border: none;
        }

        .layui-laypage .layui-laypage-limits,
        .layui-laypage .layui-laypage-refresh {
            vertical-align: top;
        }

        .layui-laypage .layui-laypage-refresh i {
            font-size: 18px;
            cursor: pointer;
        }

        .layui-laypage select {
            height: 22px;
            padding: 3px;
            border-radius: 2px;
            cursor: pointer;
        }

        .layui-laypage .layui-laypage-skip {
            height: 30px;
            line-height: 30px;
            color: #999;
        }

        .layui-laypage input,
        .layui-laypage button {
            height: 30px;
            line-height: 30px;
            border-radius: 2px;
            vertical-align: top;
            background-color: #fff;
            box-sizing: border-box;
        }

        .layui-laypage input {
            display: inline-block;
            width: 40px;
            margin: 0 10px;
            padding: 0 3px;
            text-align: center;
        }

        .layui-laypage input:focus,
        .layui-laypage select:focus {
            border-color: #16baaa !important;
        }

        .layui-laypage button {
            margin-left: 10px;
            padding: 0 10px;
            cursor: pointer;
        }

        /** 流加载 **/
        .layui-flow-more {
            margin: 10px 0;
            text-align: center;
            color: #999;
            font-size: 14px;
            clear: both;
        }

        .layui-flow-more a {
            height: 32px;
            line-height: 32px;
        }

        .layui-flow-more a * {
            display: inline-block;
            vertical-align: top;
        }

        .layui-flow-more a cite {
            padding: 0 20px;
            border-radius: 3px;
            background-color: #eee;
            color: #333;
            font-style: normal;
        }

        .layui-flow-more a cite:hover {
            opacity: 0.8;
        }

        .layui-flow-more a i {
            font-size: 30px;
            color: #737383;
        }

        /** 表格 **/
        .layui-table {
            width: 100%;
            margin: 10px 0;
            background-color: #fff;
            color: #5F5F5F;
        }

        .layui-table tr {
            transition: all .3s;
            -webkit-transition: all .3s;
        }

        .layui-table th {
            text-align: left;
            font-weight: 600;
        }

        .layui-table thead tr,
        .layui-table-header,
        .layui-table-tool,
        .layui-table-total,
        .layui-table-total tr,
        .layui-table-patch {
        }

        .layui-table-mend {
            background-color: #fff;
        }

        .layui-table-hover,
        .layui-table-click,
        .layui-table[lay-even] tbody tr:nth-child(even) {
            background-color: #f8f8f8;
        }

        .layui-table-checked {
            background-color: #dbfbf0;
        }

        .layui-table-checked.layui-table-hover,
        .layui-table-checked.layui-table-click {
            background-color: #abf8dd;
        }


        .layui-table th,
        .layui-table td,
        .layui-table[lay-skin="line"],
        .layui-table[lay-skin="row"],
        .layui-table-view,
        .layui-table-tool,
        .layui-table-header,
        .layui-table-col-set,
        .layui-table-total,
        .layui-table-page,
        .layui-table-fixed-r,
        .layui-table-mend,
        .layui-table-tips-main,
        .layui-table-grid-down {
            border-width: 1px;
            border-style: solid;
            border-color: #eee;
        }

        .layui-table th,
        .layui-table td {
            position: relative;
            padding: 9px 15px;
            min-height: 20px;
            line-height: 20px;
            font-size: 14px;
        }

        .layui-table[lay-skin="line"] th,
        .layui-table[lay-skin="line"] td {
            border-width: 0;
            border-bottom-width: 1px;
        }

        .layui-table[lay-skin="row"] th,
        .layui-table[lay-skin="row"] td {
            border-width: 0;
            border-right-width: 1px;
        }

        .layui-table[lay-skin="nob"] th,
        .layui-table[lay-skin="nob"] td {
            border: none;
        }

        .layui-table img {
            max-width: 100px;
        }

        /* 大表格 */
        .layui-table[lay-size="lg"] th,
        .layui-table[lay-size="lg"] td {
            padding-top: 15px;
            padding-right: 30px;
            padding-bottom: 15px;
            padding-left: 30px;
        }

        .layui-table-view .layui-table[lay-size="lg"] .layui-table-cell {
            height: 50px;
            line-height: 40px;
        }

        /* 小表格 */
        .layui-table[lay-size="sm"] th,
        .layui-table[lay-size="sm"] td {
            padding-top: 0px;
            padding-right: 10px;
            padding-bottom: 0px;
            padding-left: 10px;
            font-size: 12px;
        }

        .layui-table-view .layui-table[lay-size="sm"] .layui-table-cell {
            height: 30px;
            line-height: 20px;
            padding-top: 5px;
            padding-left: 11px;
            padding-right: 11px;
        }

        /* 数据表格 */
        .layui-table[lay-data],
        .layui-table[lay-options] {
            display: none;
        }

        .layui-table-box {
            position: relative;
            overflow: hidden;
        }

        .layui-table-view {
            clear: both;
        }

        .layui-table-view .layui-table {
            position: relative;
            width: auto;
            margin: 0;
            border: 0;
            border-collapse: separate;
        }

        .layui-table-view .layui-table[lay-skin="line"] {
            border-width: 0;
            border-right-width: 1px;
        }

        .layui-table-view .layui-table[lay-skin="row"] {
            border-width: 0;
            border-bottom-width: 1px;
        }

        .layui-table-view .layui-table th,
        .layui-table-view .layui-table td {
            padding: 0;
            border-top: none;
            border-left: none;
        }

        .layui-table-view .layui-table th [lay-event],
        .layui-table-view .layui-table th.layui-unselect .layui-table-cell span {
            cursor: pointer;
        }

        .layui-table-view .layui-table th span,
        .layui-table-view .layui-table td {
            cursor: default;
        }

        .layui-table-view .layui-table td[data-edit] {
            cursor: text;
        }

        .layui-table-view .layui-table td[data-edit]:hover:after {
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            box-sizing: border-box;
            border: 1px solid #16B777;
            pointer-events: none;
            content: "";
        }

        .layui-table-view .layui-form-checkbox[lay-skin="primary"] i {
            width: 18px;
            height: 18px;
            line-height: 16px;
        }

        .layui-table-view .layui-form-radio {
            line-height: 0;
            padding: 0;
        }

        .layui-table-view .layui-form-radio > i {
            margin: 0;
            font-size: 20px;
        }

        .layui-table-init {
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            text-align: center;
            z-index: 199;
        }

        .layui-table-init .layui-icon {
            position: absolute;
            left: 50%;
            top: 50%;
            margin: -15px 0 0 -15px;
            font-size: 30px;
            color: #c2c2c2;
        }

        .layui-table-header {
            border-width: 0;
            border-bottom-width: 1px;
            overflow: hidden;
        }

        .layui-table-header .layui-table {
            margin-bottom: -1px;
        }

        .layui-table-column {
            position: relative;
            width: 100%;
            min-height: 41px;
            padding: 8px 16px;
            border-width: 0;
            border-bottom-width: 1px;
        }

        .layui-table-column .layui-btn-container {
            margin-bottom: -8px;
        }

        .layui-table-column .layui-btn-container .layui-btn {
            margin-right: 8px;
            margin-bottom: 8px;
        }

        .layui-table-tool .layui-inline[lay-event] {
            position: relative;
            width: 26px;
            height: 26px;
            padding: 5px;
            line-height: 16px;
            margin-right: 10px;
            text-align: center;
            color: #333;
            border: 1px solid #ccc;
            cursor: pointer;
            -webkit-transition: .5s all;
            transition: .5s all;
        }

        .layui-table-tool .layui-inline[lay-event]:hover {
            border: 1px solid #999;
        }

        .layui-table-tool-temp {
            padding-right: 120px;
        }

        .layui-table-tool-self {
            position: absolute;
            right: 17px;
            top: 10px;
        }

        .layui-table-tool .layui-table-tool-self .layui-inline[lay-event] {
            margin: 0 0 0 10px;
        }

        .layui-table-tool-panel {
            position: absolute;
            top: 29px;
            left: -1px;
            z-index: 399;
            padding: 5px 0 !important;
            min-width: 150px;
            min-height: 40px;
            border: 1px solid #d2d2d2;
            text-align: left;
            overflow-y: auto;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, .12);
        }

        .layui-table-tool-panel li {
            padding: 0 10px;
            margin: 0 !important;
            line-height: 30px;
            list-style-type: none !important;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            -webkit-transition: .5s all;
            transition: .5s all;
        }

        .layui-table-tool-panel li .layui-form-checkbox[lay-skin="primary"] {
            width: 100%;
        }

        .layui-table-tool-panel li:hover {
            background-color: #f8f8f8;
        }

        .layui-table-tool-panel li .layui-form-checkbox[lay-skin="primary"] {
            padding-left: 28px;
        }

        .layui-table-tool-panel li .layui-form-checkbox[lay-skin="primary"] i {
            position: absolute;
            left: 0;
            top: 0;
        }

        .layui-table-tool-panel li .layui-form-checkbox[lay-skin="primary"] span {
            padding: 0;
        }

        .layui-table-tool .layui-table-tool-self .layui-table-tool-panel {
            left: auto;
            right: -1px;
        }

        .layui-table-col-set {
            position: absolute;
            right: 0;
            top: 0;
            width: 20px;
            height: 100%;
            border-width: 0;
            border-left-width: 1px;
            background-color: #fff;
        }

        .layui-table-sort {
            width: 10px;
            height: 20px;
            margin-left: 5px;
            cursor: pointer !important;
        }

        .layui-table-sort .layui-edge {
            position: absolute;
            left: 5px;
            border-width: 5px;
        }

        .layui-table-sort .layui-table-sort-asc {
            top: 3px;
            border-top: none;
            border-bottom-style: solid;
            border-bottom-color: #b2b2b2;
        }

        .layui-table-sort .layui-table-sort-asc:hover {
            border-bottom-color: #5F5F5F;
        }

        .layui-table-sort .layui-table-sort-desc {
            bottom: 5px;
            border-bottom: none;
            border-top-style: solid;
            border-top-color: #b2b2b2;
        }

        .layui-table-sort .layui-table-sort-desc:hover {
            border-top-color: #5F5F5F;
        }

        .layui-table-sort[lay-sort="asc"] .layui-table-sort-asc {
            border-bottom-color: #000;
        }

        .layui-table-sort[lay-sort="desc"] .layui-table-sort-desc {
            border-top-color: #000;
        }

        .layui-table-cell {
            height: 38px;
            line-height: 28px;
            padding: 6px 15px;
            position: relative;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            box-sizing: border-box;
        }

        .layui-table-cell .layui-form-checkbox[lay-skin="primary"] {
            top: -1px;
            padding: 0;
        }

        .layui-table-cell .layui-form-checkbox[lay-skin="primary"] > div {
            padding-left: 24px;
        }

        .layui-table-cell .layui-table-link {
            color: #01AAED;
        }

        .layui-table-cell .layui-btn {
            vertical-align: inherit;
        }

        .layui-table-cell[align="center"] {
            -webkit-box-pack: center;
        }

        .layui-table-cell[align="right"] {
            -webkit-box-pack: end;
        }

        .laytable-cell-checkbox,
        .laytable-cell-radio,
        .laytable-cell-space,
        .laytable-cell-numbers {
            text-align: center;
            -webkit-box-pack: center;
        }

        .layui-table-body {
            position: relative;
            overflow: auto;
            margin-right: -1px;
            margin-bottom: -1px;
        }

        .layui-table-body .layui-none {
            line-height: 26px;
            padding: 30px 15px;
            text-align: center;
            color: #999;
        }

        .layui-table-fixed {
            position: absolute;
            left: 0;
            top: 0;
            z-index: 101;
        }

        .layui-table-fixed .layui-table-body {
            overflow: hidden;
        }

        .layui-table-fixed-l {
            box-shadow: 1px 0 8px rgba(0, 0, 0, .08);
        }

        .layui-table-fixed-r {
            left: auto;
            right: -1px;
            border-width: 0;
            border-left-width: 1px;
            box-shadow: -1px 0 8px rgba(0, 0, 0, .08);
        }

        .layui-table-fixed-r .layui-table-header {
            position: relative;
            overflow: visible;
        }

        .layui-table-mend {
            position: absolute;
            right: -49px;
            top: 0;
            height: 100%;
            width: 50px;
            border-width: 0;
            border-left-width: 1px;
        }

        .layui-table-tool {
            position: relative;
            width: 100%;
            min-height: 50px;
            line-height: 30px;
            padding: 10px 15px;
            border-width: 0;
            border-bottom-width: 1px;
            /*box-shadow: 0 1px 8px 0 rgb(0 0 0 / 8%);*/
        }

        .layui-table-tool .layui-btn-container {
            margin-bottom: -10px;
        }

        .layui-table-total {
            margin-bottom: -1px;
            border-width: 0;
            border-top-width: 1px;
            overflow: hidden;
        }


        .layui-table-page {
            border-width: 0;
            border-top-width: 1px;
            margin-bottom: -1px;
            white-space: nowrap;
            overflow: hidden;
        }

        .layui-table-page > div {
            height: 26px;
        }

        .layui-table-page .layui-laypage {
            margin: 0;
        }

        .layui-table-page .layui-laypage a,
        .layui-table-page .layui-laypage span {
            height: 26px;
            line-height: 26px;
            margin-bottom: 10px;
            border: none;
            background: none;
        }

        .layui-table-page .layui-laypage a,
        .layui-table-page .layui-laypage span.layui-laypage-curr {
            padding: 0 12px;
        }

        .layui-table-page .layui-laypage span {
            margin-left: 0;
            padding: 0;
        }

        .layui-table-page .layui-laypage .layui-laypage-prev {
            margin-left: -11px !important;
        }

        .layui-table-page .layui-laypage .layui-laypage-curr .layui-laypage-em {
            left: 0;
            top: 0;
            padding: 0;
        }

        .layui-table-page .layui-laypage input,
        .layui-table-page .layui-laypage button {
            height: 26px;
            line-height: 26px;
        }

        .layui-table-page .layui-laypage input {
            width: 40px;
        }

        .layui-table-page .layui-laypage button {
            padding: 0 10px;
        }

        .layui-table-page select {
            height: 18px;
        }

        .layui-table-pagebar {
            float: right;
            line-height: 23px;
        }

        .layui-table-pagebar .layui-btn-sm {
            margin-top: -1px;
        }

        .layui-table-pagebar .layui-btn-xs {
            margin-top: 2px;
        }

        .layui-table-view select[lay-ignore] {
            display: inline-block;
        }

        .layui-table-patch .layui-table-cell {
            padding: 0;
            width: 30px;
        }

        .layui-table-edit {
            position: absolute;
            left: 0;
            top: 0;
            z-index: 189;
            min-width: 100%;
            min-height: 100%;
            padding: 5px 14px;
            border-radius: 0;
            box-shadow: 1px 1px 20px rgba(0, 0, 0, .15);
            background-color: #fff;
        }

        .layui-table-edit:focus {
            border-color: #16b777 !important;
        }

        input.layui-input.layui-table-edit {
            height: 100%;
        }

        select.layui-table-edit {
            padding: 0 0 0 10px;
            border-color: #d2d2d2;
        }

        .layui-table-view .layui-form-switch,
        .layui-table-view .layui-form-checkbox,
        .layui-table-view .layui-form-radio {
            top: 0;
            margin: 0;
        }

        .layui-table-view .layui-form-checkbox {
            top: -1px;
            height: 26px;
            line-height: 26px;
        }

        .layui-table-view .layui-form-checkbox i {
            height: 26px;
        }

        /* 展开溢出的单元格 */
        .layui-table-grid .layui-table-cell {
            overflow: visible;
        }

        .layui-table-grid-down {
            position: absolute;
            top: 0;
            right: 0;
            width: 24px;
            height: 100%;
            padding: 5px 0;
            border-width: 0;
            border-left-width: 1px;
            text-align: center;
            background-color: #fff;
            color: #999;
            cursor: pointer;
        }

        .layui-table-grid-down .layui-icon {
            position: absolute;
            top: 50%;
            left: 50%;
            margin: -8px 0 0 -8px;
            font-size: 14px;
        }

        .layui-table-grid-down:hover {
            background-color: #fbfbfb;
        }

        /* 单元格多行展开风格  */
        .layui-table-expanded {
            height: 95px;
        }

        .layui-table-expanded .layui-table-cell,
        .layui-table-view .layui-table[lay-size="sm"] .layui-table-expanded .layui-table-cell,
        .layui-table-view .layui-table[lay-size="lg"] .layui-table-expanded .layui-table-cell {
            height: auto;
            max-height: 94px;
            white-space: normal;
            text-overflow: clip;
        }

        .layui-table-cell-c {
            position: absolute;
            bottom: -10px;
            right: 50%;
            margin-right: -9px;
            width: 20px;
            height: 20px;
            line-height: 18px;
            cursor: pointer;
            text-align: center;
            background-color: #fff;
            border: 1px solid #eee;
            border-radius: 50%;
            z-index: 1000;
            transition: 0.3s all;
            font-size: 14px;
        }

        .layui-table-cell-c:hover {
            border-color: #16b777;
        }

        .layui-table-expanded td:hover .layui-table-cell {
            overflow: auto;
        }

        /* 单元格 TIPS 展开风格  */
        body .layui-table-tips .layui-layer-content {
            background: none;
            padding: 0;
            box-shadow: 0 1px 6px rgba(0, 0, 0, .12);
        }

        .layui-table-tips-main {
            margin: -49px 0 0 -1px;
            max-height: 150px;
            padding: 8px 15px;
            font-size: 14px;
            overflow-y: scroll;
            background-color: #fff;
            color: #5F5F5F;
        }

        .layui-table-tips-c {
            position: absolute;
            right: -3px;
            top: -13px;
            width: 20px;
            height: 20px;
            padding: 3px;
            cursor: pointer;
            background-color: #5F5F5F;
            border-radius: 50%;
            color: #fff;
        }

        .layui-table-tips-c:hover {
            background-color: #777;
        }

        .layui-table-tips-c:before {
            position: relative;
            right: -2px;
        }


        /** 树表 **/
        .layui-table-tree-nodeIcon {
            max-width: 20px;
        }

        .layui-table-tree-nodeIcon > * {
            width: 100%;
        }

        .layui-table-tree-flexIcon,
        .layui-table-tree-nodeIcon {
            margin-right: 2px;
        }

        .layui-table-tree-flexIcon {
            cursor: pointer;
        }

        /** 文件上传 **/
        .layui-upload-file {
            display: none !important;
            opacity: .01;
            filter: Alpha(opacity=1);
        }

        .layui-upload-list {
            margin: 11px 0;
        }

        .layui-upload-choose {
            max-width: 200px;
            padding: 0 10px;
            color: #999;
            font-size: 14px;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }

        .layui-upload-drag {
            position: relative;
            display: inline-block;
            padding: 30px;
            border: 1px dashed #e2e2e2;
            background-color: #fff;
            text-align: center;
            cursor: pointer;
            color: #999;
        }

        .layui-upload-drag .layui-icon {
            font-size: 50px;
            color: #16baaa;
        }

        .layui-upload-drag[lay-over] {
            border-color: #16baaa
        }

        .layui-upload-form {
            display: inline-block;
        }

        .layui-upload-iframe {
            position: absolute;
            width: 0;
            height: 0;
            border: 0;
            visibility: hidden
        }

        .layui-upload-wrap {
            position: relative;
            display: inline-block;
            vertical-align: middle;
        }

        .layui-upload-wrap .layui-upload-file {
            display: block !important;
            position: absolute;
            left: 0;
            top: 0;
            z-index: 10;
            font-size: 100px;
            width: 100%;
            height: 100%;
            opacity: .01;
            filter: Alpha(opacity=1);
            cursor: pointer;
        }

        .layui-btn-container .layui-upload-choose {
            padding-left: 0;
        }


        /* 基础菜单元素 */
        .layui-menu {
            position: relative;
            margin: 5px 0;
            background-color: #fff;
            box-sizing: border-box;
        }

        .layui-menu * {
            box-sizing: border-box;
        }

        .layui-menu li,
        .layui-menu-body-title,
        .layui-menu-body-title a {
            padding: 5px 15px;
            color: initial
        }

        .layui-menu li {
            position: relative;
            margin: 0 0 1px;
            line-height: 26px;
            color: rgba(0, 0, 0, .8);
            font-size: 14px;
            white-space: nowrap;
            cursor: pointer;
            transition: all .3s;
        }

        .layui-menu li:hover {
            background-color: #f8f8f8;
        }

        .layui-menu li.layui-disabled,
        .layui-menu li.layui-disabled * {
            background: none !important;
            color: #d2d2d2 !important;
            cursor: not-allowed !important;
        }

        .layui-menu-item-parent:hover > .layui-menu-body-panel {
            display: block;
            animation-name: layui-fadein;
            animation-duration: 0.3s;
            animation-fill-mode: both;
            animation-delay: .2s;
        }

        .layui-menu-item-parent > .layui-menu-body-title,
        .layui-menu-item-group > .layui-menu-body-title {
            padding-right: 38px;
        }

        .layui-menu .layui-menu-item-group:hover,
        .layui-menu .layui-menu-item-none:hover,
        .layui-menu .layui-menu-item-divider:hover {
            background: none;
            cursor: default;
        }

        .layui-menu .layui-menu-item-group > ul {
            margin: 5px 0 -5px;
        }

        .layui-menu .layui-menu-item-group > .layui-menu-body-title {
            color: rgba(0, 0, 0, .35);
            user-select: none;
        }

        .layui-menu .layui-menu-item-none {
            color: rgba(0, 0, 0, .35);
            cursor: default;
        }

        .layui-menu .layui-menu-item-none {
            text-align: center;
        }

        .layui-menu .layui-menu-item-divider {
            margin: 5px 0;
            padding: 0;
            height: 0;
            line-height: 0;
            border-bottom: 1px solid #eee;
            overflow: hidden;
        }

        .layui-menu .layui-menu-item-up:hover,
        .layui-menu .layui-menu-item-down:hover {
            cursor: pointer;
        }

        .layui-menu .layui-menu-item-up > .layui-menu-body-title {
            color: rgba(0, 0, 0, .8);
        }

        .layui-menu .layui-menu-item-up > ul {
            visibility: hidden;
            height: 0;
            overflow: hidden;
        }

        .layui-menu .layui-menu-item-down > .layui-menu-body-title > .layui-icon-down {
            transform: rotate(180deg);
        }

        .layui-menu .layui-menu-item-up > .layui-menu-body-title > .layui-icon-up {
            transform: rotate(-180deg);
        }

        .layui-menu .layui-menu-item-up > .layui-menu-body-title:hover > .layui-icon,
        .layui-menu .layui-menu-item-down:hover > .layui-menu-body-title > .layui-icon {
            color: rgba(0, 0, 0, 1);
        }

        .layui-menu .layui-menu-item-down > ul {
            visibility: visible;
            height: auto;
        }

        .layui-menu .layui-menu-item-checked,
        .layui-menu .layui-menu-item-checked2 {
            background-color: #f8f8f8 !important;
            color: #16b777;
        }

        .layui-menu .layui-menu-item-checked a,
        .layui-menu .layui-menu-item-checked2 a {
            color: #16b777;
        }

        .layui-menu .layui-menu-item-checked:after {
            position: absolute;
            right: -1px;
            top: 0;
            bottom: 0;
            border-right: 3px solid #16b777;
            content: "";
        }

        .layui-menu-body-title {
            position: relative;
            margin: -5px -15px;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .layui-menu-body-title a {
            display: block;
            margin: -5px -15px;
            color: rgba(0, 0, 0, .8);
        }

        .layui-menu-body-title a:hover {
            transition: all .3s;
        }

        .layui-menu-body-title > .layui-icon {
            position: absolute;
            right: 15px;
            top: 50%;
            margin-top: -6px;
            line-height: normal;
            font-size: 14px;
            transition: all .2s;
            -webkit-transition: all .2s;
        }

        .layui-menu-body-title > .layui-icon:hover {
            transition: all .3s;
        }

        .layui-menu-body-title > .layui-icon-right {
            right: 14px;
        }

        .layui-menu-body-panel {
            display: none;
            position: absolute;
            top: -7px;
            left: 100%;
            z-index: 1000;
            margin-left: 13px;
            padding: 5px 0;
        }

        .layui-menu-body-panel:before {
            content: "";
            position: absolute;
            width: 20px;
            left: -16px;
            top: 0;
            bottom: 0;
        }

        .layui-menu-body-panel-left {
            left: auto;
            right: 100%;
            margin: 0 13px 0;
        }

        .layui-menu-body-panel-left:before {
            left: auto;
            right: -16px;
        }

        .layui-menu-lg li {
            line-height: 32px;
        }

        .layui-menu-lg li:hover,
        .layui-menu-lg .layui-menu-body-title a:hover {
            background: none;
            color: #16b777;
        }

        .layui-menu-lg li .layui-menu-body-panel {
            margin-left: 14px
        }

        .layui-menu-lg li .layui-menu-body-panel-left {
            margin: 0 15px 0;
        }


        /* 下拉菜单 */
        .layui-dropdown {
            position: absolute;
            left: -999999px;
            top: -999999px;
            z-index: 77777777;
            margin: 5px 0;
            min-width: 100px;
        }

        .layui-dropdown:before {
            content: "";
            position: absolute;
            width: 100%;
            height: 6px;
            left: 0;
            top: -6px;
        }

        .layui-dropdown-shade {
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            _height: expression(document.body.offsetHeight+"px");
            position: fixed;
            _position: absolute;
            pointer-events: auto;
        }

        /** 导航菜单 **/
        .layui-nav {
            position: relative;
            padding: 0 15px;
            background-color: #2f363c;
            color: #fff;
            border-radius: 2px;
            font-size: 0;
            box-sizing: border-box;
        }

        .layui-nav * {
            font-size: 14px;
        }

        .layui-nav .layui-nav-item {
            position: relative;
            display: inline-block;
            *display: inline;
            *zoom: 1;
            margin-top: 0;
            list-style: none;
            vertical-align: middle;
            line-height: 60px;
        }

        .layui-nav .layui-nav-item a {
            display: block;
            padding: 0 20px;
            color: #fff;
            color: rgba(255, 255, 255, .7);
            transition: all .3s;
            -webkit-transition: all .3s;
        }

        .layui-nav-bar,
        .layui-nav .layui-this:after {
            content: "";
            position: absolute;
            left: 0;
            top: 0;
            width: 0;
            height: 3px;
            background-color: #16b777;
            transition: all .2s;
            -webkit-transition: all .2s;
            pointer-events: none;
        }

        .layui-nav-bar {
            z-index: 1000;
        }

        .layui-nav[lay-bar="disabled"] .layui-nav-bar {
            display: none;
        }

        .layui-nav[lay-bar="disabled"].layui-this:after {
        }

        .layui-nav .layui-this a,
        .layui-nav .layui-nav-item a:hover {
            color: #fff;
            text-decoration: none;
        }

        .layui-nav .layui-this:after {
            top: auto;
            bottom: 0;
            width: 100%;
        }

        .layui-nav-img {
            width: 30px;
            height: 30px;
            margin-right: 10px;
            border-radius: 50%;
        }

        .layui-nav .layui-nav-more {
            position: absolute;
            top: 0;
            right: 3px;
            left: auto !important;
            margin-top: 0;
            font-size: 12px;
            cursor: pointer;
            transition: all .2s;
            -webkit-transition: all .2s;
        }

        .layui-nav .layui-nav-mored,
        .layui-nav-expand > a .layui-nav-more,
        .layui-nav-itemed > a .layui-nav-more {
            transform: rotate(180deg);
        }


        .layui-nav-child {
            display: none;
            position: absolute;
            left: 0;
            top: 65px;
            min-width: 100%;
            line-height: 36px;
            padding: 5px 0;
            box-shadow: 0 2px 4px rgba(0, 0, 0, .12);
            border: 1px solid #eee;
            background-color: #fff;
            z-index: 100;
            border-radius: 2px;
            white-space: nowrap;
            box-sizing: border-box;
        }

        .layui-nav .layui-nav-child a {
            color: #5F5F5F;
            color: rgba(0, 0, 0, .8);
        }

        .layui-nav .layui-nav-child a:hover {
            background-color: #f8f8f8;
            color: rgba(0, 0, 0, .8);
        }

        .layui-nav-child dd {
            margin: 1px 0;
            position: relative;
        }

        .layui-nav-child dd.layui-this {
            background-color: #f8f8f8;
            color: #000;
        }

        .layui-nav-child dd.layui-this:after {
            display: none;
        }

        .layui-nav-child-r {
            left: auto;
            right: 0;
        }

        .layui-nav-child-c {
            text-align: center;
        }

        /* 垂直导航菜单 */
        .layui-nav.layui-nav-tree {
            width: 200px;
            padding: 0;
        }

        .layui-nav-tree .layui-nav-item {
            display: block;
            width: 100%;
            line-height: 40px;
        }

        .layui-nav-tree .layui-nav-item a {
            position: relative;
            height: 40px;
            line-height: 40px;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }

        .layui-nav-tree .layui-nav-item > a {
            padding-top: 5px;
            padding-bottom: 5px;
        }

        .layui-nav-tree .layui-nav-more {
            right: 15px;
        }

        .layui-nav-tree .layui-nav-item > a .layui-nav-more {
            padding: 5px 0;
        }

        .layui-nav-tree .layui-nav-bar {
            width: 5px;
            height: 0;
        }

        .layui-side .layui-nav-tree .layui-nav-bar {
            width: 2px;
        }

        .layui-nav-tree .layui-this,
        .layui-nav-tree .layui-this > a,
        .layui-nav-tree .layui-this > a:hover,
        .layui-nav-tree .layui-nav-child dd.layui-this,
        .layui-nav-tree .layui-nav-child dd.layui-this a {
            background-color: #16baaa;
            color: #fff;
        }

        .layui-nav-tree .layui-this:after {
            display: none;
        }

        .layui-nav-tree .layui-nav-title a,
        .layui-nav-tree .layui-nav-title a:hover,
        .layui-nav-itemed > a {
            color: #fff !important;
        }

        .layui-nav-tree .layui-nav-bar {
            background-color: #16baaa;
        }

        .layui-nav-tree .layui-nav-child {
            position: relative;
            z-index: 0;
            top: 0;
            border: none;
            background-color: rgba(0, 0, 0, .3);
            box-shadow: none;
        }

        .layui-nav-tree .layui-nav-child dd {
            margin: 0;
        }

        .layui-nav-tree .layui-nav-child a {
            color: #fff;
            color: rgba(255, 255, 255, .7);
        }

        .layui-nav-tree .layui-nav-child a:hover {
            background: none;
            color: #fff;
        }

        /* 垂直导航 - 展开状态 */
        .layui-nav-itemed > .layui-nav-child,
        .layui-nav-itemed > .layui-nav-child > .layui-this > .layui-nav-child {
            display: block;
        }

        /* 垂直导航 - 侧边 */
        .layui-nav-side {
            position: fixed;
            top: 0;
            bottom: 0;
            left: 0;
            overflow-x: hidden;
            z-index: 999;
        }

        /* 导航浅色背景 */
        .layui-nav.layui-bg-gray .layui-nav-item a,
        .layui-nav-tree.layui-bg-gray a {
            color: #373737;
            color: rgba(0, 0, 0, .8);
        }

        .layui-nav-tree.layui-bg-gray {
            padding: 6px 0;
        }

        .layui-nav-tree.layui-bg-gray .layui-nav-itemed > a {
            color: #000 !important;
        }

        .layui-nav.layui-bg-gray .layui-this a {
            color: #16b777;
        }

        .layui-nav-tree.layui-bg-gray .layui-nav-child {
            padding-left: 11px;
            background: none;
        }

        .layui-nav-tree.layui-bg-gray .layui-nav-item > a {
            padding-top: 0;
            padding-bottom: 0;
        }

        .layui-nav-tree.layui-bg-gray .layui-nav-item > a .layui-nav-more {
            padding: 0;
        }

        .layui-nav-tree.layui-bg-gray .layui-this,
        .layui-nav-tree.layui-bg-gray .layui-this > a,
        .layui-nav-tree.layui-bg-gray .layui-nav-child dd.layui-this,
        .layui-nav-tree.layui-bg-gray .layui-nav-child dd.layui-this a {
            background: none !important;
            color: #16b777 !important;
            font-weight: 700;
        }

        .layui-nav-tree.layui-bg-gray .layui-nav-bar {
            background-color: #16b777;
        }


        /** 面包屑 **/
        .layui-breadcrumb {
            visibility: hidden;
            font-size: 0;
        }

        .layui-breadcrumb > * {
            font-size: 14px;
        }

        .layui-breadcrumb a {
            color: #999 !important;
        }

        .layui-breadcrumb a:hover {
            color: #16b777 !important;
        }

        .layui-breadcrumb a cite {
            color: #5F5F5F;
            font-style: normal;
        }

        .layui-breadcrumb span[lay-separator] {
            margin: 0 10px;
            color: #999;
        }

        /** Tab 选项卡 **/
        .layui-tab {
            margin: 10px 0;
            text-align: left !important;
        }

        .layui-tab[overflow] > .layui-tab-title {
            overflow: hidden;
        }

        .layui-tab .layui-tab-title {
            position: relative;
            left: 0;
            height: 40px;
            white-space: nowrap;
            font-size: 0;
            border-bottom-width: 1px;
            border-bottom-style: solid;
            transition: all .2s;
            -webkit-transition: all .2s;
        }

        .layui-tab .layui-tab-title li {
            display: inline-block;
            *display: inline;
            *zoom: 1;
            vertical-align: middle;
            font-size: 14px;
            transition: all .2s;
            -webkit-transition: all .2s;
        }

        .layui-tab .layui-tab-title li {
            position: relative;
            line-height: 40px;
            min-width: 65px;
            margin: 0;
            padding: 0 15px;
            text-align: center;
            cursor: pointer;
        }

        .layui-tab .layui-tab-title li a {
            display: block;
            padding: 0 15px;
            margin: 0 -15px;
        }

        .layui-tab-title .layui-this {
            color: #000;
        }

        .layui-tab-title .layui-this:after {
            position: absolute;
            left: 0;
            top: 0;
            content: "";
            width: 100%;
            height: 41px;
            border-width: 1px;
            border-style: solid;
            border-bottom-color: #fff;
            border-radius: 2px 2px 0 0;
            box-sizing: border-box;
            pointer-events: none;
        }

        .layui-tab-bar {
            position: absolute;
            right: 0;
            top: 0;
            z-index: 10;
            width: 30px;
            height: 39px;
            line-height: 39px;
            border-width: 1px;
            border-style: solid;
            border-radius: 2px;
            text-align: center;
            background-color: #fff;
            cursor: pointer;
        }

        .layui-tab-bar .layui-icon {
            position: relative;
            display: inline-block;
            top: 3px;
            transition: all .3s;
            -webkit-transition: all .3s;
        }

        .layui-tab-item {
            display: none;
        }

        .layui-tab-more {
            padding-right: 30px;
            height: auto !important;
            white-space: normal !important;
        }

        .layui-tab-more li.layui-this:after {
            border-bottom-color: #eee;
            border-radius: 2px;
        }

        .layui-tab-more .layui-tab-bar .layui-icon {
            top: -2px;
            top: 3px \0;
            -webkit-transform: rotate(180deg);
            transform: rotate(180deg);
        }

        :root .layui-tab-more .layui-tab-bar .layui-icon {
            top: -2px \0/ IE9;
        }

        .layui-tab-content {
            padding: 15px 0;
        }

        /* Tab 关闭 */
        .layui-tab-title li .layui-tab-close {
            position: relative;
            display: inline-block;
            width: 18px;
            height: 18px;
            line-height: 20px;
            margin-left: 8px;
            top: 1px;
            text-align: center;
            font-size: 14px;
            color: #c2c2c2;
            transition: all .2s;
            -webkit-transition: all .2s;
        }

        .layui-tab-title li .layui-tab-close:hover {
            border-radius: 2px;
            background-color: #ff5722;
            color: #fff;
        }

        /* Tab 简洁风格 */
        .layui-tab-brief > .layui-tab-title .layui-this {
            color: #16baaa;
        }

        .layui-tab-brief > .layui-tab-title .layui-this:after,
        .layui-tab-brief > .layui-tab-more li.layui-this:after {
            border: none;
            border-radius: 0;
            border-bottom: 2px solid #16b777;
        }

        .layui-tab-brief[overflow] > .layui-tab-title .layui-this:after {
            top: -1px;
        }

        /* Tab 卡片风格 */
        .layui-tab-card {
            border-width: 1px;
            border-style: solid;
            border-radius: 2px;
            box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .1);
        }

        .layui-tab-card > .layui-tab-title {
            background-color: #fafafa;
        }

        .layui-tab-card > .layui-tab-title li {
            margin-right: -1px;
            margin-left: -1px;
        }

        .layui-tab-card > .layui-tab-title .layui-this {
            background-color: #fff;
        }

        .layui-tab-card > .layui-tab-title .layui-this:after {
            border-top: none;
            border-width: 1px;
            border-bottom-color: #fff;
        }

        .layui-tab-card > .layui-tab-title .layui-tab-bar {
            height: 40px;
            line-height: 40px;
            border-radius: 0;
            border-top: none;
            border-right: none;
        }

        .layui-tab-card > .layui-tab-more .layui-this {
            background: none;
            color: #16b777;
        }

        .layui-tab-card > .layui-tab-more .layui-this:after {
            border: none;
        }

        /* 时间线 */
        .layui-timeline {
            padding-left: 5px;
        }

        .layui-timeline-item {
            position: relative;
            padding-bottom: 20px;
        }

        .layui-timeline-axis {
            position: absolute;
            left: -5px;
            top: 0;
            z-index: 10;
            width: 20px;
            height: 20px;
            line-height: 20px;
            background-color: #fff;
            color: #16b777;
            border-radius: 50%;
            text-align: center;
            cursor: pointer;
        }

        .layui-timeline-axis:hover {
            color: #ff5722;
        }

        .layui-timeline-item:before {
            content: "";
            position: absolute;
            left: 5px;
            top: 0;
            z-index: 0;
            width: 1px;
            height: 100%;
        }

        .layui-timeline-item:first-child:before {
            display: block;
        }

        .layui-timeline-item:last-child:before {
            display: none;
        }

        .layui-timeline-content {
            padding-left: 25px;;
        }

        .layui-timeline-title {
            position: relative;
            margin-bottom: 10px;
            line-height: 22px;
        }

        /* 小徽章 */
        .layui-badge,
        .layui-badge-dot,
        .layui-badge-rim {
            position: relative;
            display: inline-block;
            padding: 0 6px;
            font-size: 12px;
            text-align: center;
            background-color: #ff5722;
            color: #fff;
            border-radius: 2px;
        }

        .layui-badge {
            height: 18px;
            line-height: 18px;
        }

        .layui-badge-dot {
            width: 8px;
            height: 8px;
            padding: 0;
            border-radius: 50%;
        }

        .layui-badge-rim {
            height: 18px;
            line-height: 18px;
            border-width: 1px;
            border-style: solid;
            background-color: #fff;
            color: #5F5F5F;
        }

        .layui-btn .layui-badge,
        .layui-btn .layui-badge-dot {
            margin-left: 5px;
        }

        .layui-nav .layui-badge,
        .layui-nav .layui-badge-dot {
            position: absolute;
            top: 50%;
            margin: -5px 6px 0;
        }

        .layui-nav .layui-badge {
            margin-top: -10px;
        }

        .layui-tab-title .layui-badge,
        .layui-tab-title .layui-badge-dot {
            left: 5px;
            top: -2px;
        }

        /* carousel 轮播 */
        .layui-carousel {
            position: relative;
            left: 0;
            top: 0;
            background-color: #f8f8f8;
        }

        .layui-carousel > *[carousel-item] {
            position: relative;
            width: 100%;
            height: 100%;
            overflow: hidden;
        }

        .layui-carousel > *[carousel-item]:before {
            position: absolute;
            content: '\e63d';
            left: 50%;
            top: 50%;
            width: 100px;
            line-height: 20px;
            margin: -10px 0 0 -50px;
            text-align: center;
            color: #c2c2c2;
            font-family: "layui-icon" !important;
            font-size: 30px;
            font-style: normal;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        .layui-carousel > *[carousel-item] > * {
            display: none;
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: #f8f8f8;
            transition-duration: .3s;
            -webkit-transition-duration: .3s;
        }

        .layui-carousel-updown > * {
            -webkit-transition: .3s ease-in-out up;
            transition: .3s ease-in-out up;
        }

        .layui-carousel-arrow {
            display: none \0;
            opacity: 0;
            position: absolute;
            left: 10px;
            top: 50%;
            margin-top: -18px;
            width: 36px;
            height: 36px;
            line-height: 36px;
            text-align: center;
            font-size: 20px;
            border: none 0;
            border-radius: 50%;
            background-color: rgba(0, 0, 0, .2);
            color: #fff;
            -webkit-transition-duration: .3s;
            transition-duration: .3s;
            cursor: pointer;
        }

        .layui-carousel-arrow[lay-type="add"] {
            left: auto !important;
            right: 10px;
        }

        .layui-carousel[lay-arrow="always"] .layui-carousel-arrow {
            opacity: 1;
            left: 20px;
        }

        .layui-carousel[lay-arrow="always"] .layui-carousel-arrow[lay-type="add"] {
            right: 20px;
        }

        .layui-carousel[lay-arrow="none"] .layui-carousel-arrow {
            display: none;
        }

        .layui-carousel-arrow:hover,
        .layui-carousel-ind ul:hover {
            background-color: rgba(0, 0, 0, .35);
        }

        .layui-carousel:hover .layui-carousel-arrow {
            display: block \0;
            opacity: 1;
            left: 20px;
        }

        .layui-carousel:hover .layui-carousel-arrow[lay-type="add"] {
            right: 20px;
        }

        .layui-carousel-ind {
            position: relative;
            top: -35px;
            width: 100%;
            line-height: 0 !important;
            text-align: center;
            font-size: 0;
        }

        .layui-carousel[lay-indicator="outside"] {
            margin-bottom: 30px;
        }

        .layui-carousel[lay-indicator="outside"] .layui-carousel-ind {
            top: 10px;
        }

        .layui-carousel[lay-indicator="outside"] .layui-carousel-ind ul {
            background-color: rgba(0, 0, 0, .5);
        }

        .layui-carousel[lay-indicator="none"] .layui-carousel-ind {
            display: none;
        }

        .layui-carousel-ind ul {
            display: inline-block;
            padding: 5px;
            background-color: rgba(0, 0, 0, .2);
            border-radius: 10px;
            -webkit-transition-duration: .3s;
            transition-duration: .3s;
        }

        .layui-carousel-ind ul li {
            display: inline-block;
            width: 10px;
            height: 10px;
            margin: 0 3px;
            font-size: 14px;
            background-color: #eee;
            background-color: rgba(255, 255, 255, .5);
            border-radius: 50%;
            cursor: pointer;
            -webkit-transition-duration: .3s;
            transition-duration: .3s;
        }

        .layui-carousel-ind ul li:hover {
            background-color: rgba(255, 255, 255, .7);
        }

        .layui-carousel-ind ul li.layui-this {
            background-color: #fff;
        }

        .layui-carousel > *[carousel-item] > .layui-this,
        .layui-carousel > *[carousel-item] > .layui-carousel-prev,
        .layui-carousel > *[carousel-item] > .layui-carousel-next {
            display: block
        }

        .layui-carousel > *[carousel-item] > .layui-this {
            left: 0;
        }

        .layui-carousel > *[carousel-item] > .layui-carousel-prev {
            left: -100%;
        }

        .layui-carousel > *[carousel-item] > .layui-carousel-next {
            left: 100%;
        }

        .layui-carousel > *[carousel-item] > .layui-carousel-prev.layui-carousel-right,
        .layui-carousel > *[carousel-item] > .layui-carousel-next.layui-carousel-left {
            left: 0;
        }

        .layui-carousel > *[carousel-item] > .layui-this.layui-carousel-left {
            left: -100%;
        }

        .layui-carousel > *[carousel-item] > .layui-this.layui-carousel-right {
            left: 100%;
        }

        /* 上下切换 */
        .layui-carousel[lay-anim="updown"] .layui-carousel-arrow {
            left: 50% !important;
            top: 20px;
            margin: 0 0 0 -18px;
        }

        .layui-carousel[lay-anim="updown"] .layui-carousel-arrow[lay-type="add"] {
            top: auto !important;
            bottom: 20px;
        }

        .layui-carousel[lay-anim="updown"] .layui-carousel-ind {
            position: absolute;
            top: 50%;
            right: 20px;
            width: auto;
            height: auto;
        }

        .layui-carousel[lay-anim="updown"] .layui-carousel-ind ul {
            padding: 3px 5px;
        }

        .layui-carousel[lay-anim="updown"] .layui-carousel-ind li {
            display: block;
            margin: 6px 0;
        }

        .layui-carousel[lay-anim="updown"] > *[carousel-item] > * {
            left: 0 !important;
        }

        .layui-carousel[lay-anim="updown"] > *[carousel-item] > .layui-this {
            top: 0;
        }

        .layui-carousel[lay-anim="updown"] > *[carousel-item] > .layui-carousel-prev {
            top: -100%;
        }

        .layui-carousel[lay-anim="updown"] > *[carousel-item] > .layui-carousel-next {
            top: 100%;
        }

        .layui-carousel[lay-anim="updown"] > *[carousel-item] > .layui-carousel-prev.layui-carousel-right,
        .layui-carousel[lay-anim="updown"] > *[carousel-item] > .layui-carousel-next.layui-carousel-left {
            top: 0;
        }

        .layui-carousel[lay-anim="updown"] > *[carousel-item] > .layui-this.layui-carousel-left {
            top: -100%;
        }

        .layui-carousel[lay-anim="updown"] > *[carousel-item] > .layui-this.layui-carousel-right {
            top: 100%;
        }

        /* 渐显切换 */
        .layui-carousel[lay-anim="fade"] > *[carousel-item] > * {
            left: 0 !important;
        }

        .layui-carousel[lay-anim="fade"] > *[carousel-item] > .layui-carousel-prev,
        .layui-carousel[lay-anim="fade"] > *[carousel-item] > .layui-carousel-next {
            opacity: 0;
        }

        .layui-carousel[lay-anim="fade"] > *[carousel-item] > .layui-carousel-prev.layui-carousel-right,
        .layui-carousel[lay-anim="fade"] > *[carousel-item] > .layui-carousel-next.layui-carousel-left {
            opacity: 1;
        }

        .layui-carousel[lay-anim="fade"] > *[carousel-item] > .layui-this.layui-carousel-left,
        .layui-carousel[lay-anim="fade"] > *[carousel-item] > .layui-this.layui-carousel-right {
            opacity: 0
        }

        /** fixbar **/
        .layui-fixbar {
            position: fixed;
            right: 16px;
            bottom: 16px;
            z-index: 999999;
        }

        .layui-fixbar li {
            width: 50px;
            height: 50px;
            line-height: 50px;
            margin-bottom: 1px;
            text-align: center;
            cursor: pointer;
            font-size: 30px;
            background-color: #9F9F9F;
            color: #fff;
            border-radius: 2px;
            opacity: 0.95;
        }

        .layui-fixbar li:hover {
            opacity: 0.85;
        }

        .layui-fixbar li:active {
            opacity: 1;
        }

        .layui-fixbar .layui-fixbar-top {
            display: none;
            font-size: 40px;
        }

        /** 表情面板 **/
        body .layui-util-face {
            border: none;
            background: none;
        }

        body .layui-util-face .layui-layer-content {
            padding: 0;
            background-color: #fff;
            color: #5F5F5F;
            box-shadow: none
        }

        .layui-util-face .layui-layer-TipsG {
            display: none;
        }

        .layui-util-face ul {
            position: relative;
            width: 372px;
            padding: 10px;
            border: 1px solid #D9D9D9;
            background-color: #fff;
            box-shadow: 0 0 20px rgba(0, 0, 0, .2);
        }

        .layui-util-face ul li {
            cursor: pointer;
            float: left;
            border: 1px solid #e8e8e8;
            height: 22px;
            width: 26px;
            overflow: hidden;
            margin: -1px 0 0 -1px;
            padding: 4px 2px;
            text-align: center;
        }

        .layui-util-face ul li:hover {
            position: relative;
            z-index: 2;
            border: 1px solid #eb7350;
            background: #fff9ec;
        }

        /** 代码文本修饰 **/
        .layui-code {
            display: block;
            position: relative;
            padding: 15px;
            line-height: 20px;
            border: 1px solid #eee;
            border-left-width: 6px;
            background-color: #fff;
            color: #333;
            font-family: "Courier New", Consolas, "Lucida Console";
            font-size: 12px;
        }

        /** 穿梭框 **/
        .layui-transfer-box,
        .layui-transfer-header,
        .layui-transfer-search {
            border-width: 0;
            border-style: solid;
            border-color: #eee
        }

        .layui-transfer-box {
            position: relative;
            display: inline-block;
            vertical-align: middle;
            border-width: 1px;
            width: 200px;
            height: 360px;
            border-radius: 2px;
            background-color: #fff;
        }

        .layui-transfer-box .layui-form-checkbox {
            width: 100%;
            margin: 0 !important;
        }

        .layui-transfer-header {
            height: 38px;
            line-height: 38px;
            padding: 0 11px;
            border-bottom-width: 1px;
        }

        .layui-transfer-search {
            position: relative;
            padding: 11px;
            border-bottom-width: 1px;
        }

        .layui-transfer-search .layui-input {
            height: 32px;
            padding-left: 30px;
            font-size: 12px;
        }

        .layui-transfer-search .layui-icon-search {
            position: absolute;
            left: 20px;
            top: 50%;
            line-height: normal;
            margin-top: -8px;
            color: #5F5F5F;
        }

        .layui-transfer-active {
            margin: 0 15px;
            display: inline-block;
            vertical-align: middle;
        }

        .layui-transfer-active .layui-btn {
            display: block;
            margin: 0;
            padding: 0 15px;
            background-color: #16b777;
            border-color: #16b777;
            color: #fff;
        }

        .layui-transfer-active .layui-btn-disabled {
            background-color: #FBFBFB;
            border-color: #eee;
            color: #d2d2d2;
        }

        .layui-transfer-active .layui-btn:first-child {
            margin-bottom: 15px;
        }

        .layui-transfer-active .layui-btn .layui-icon {
            margin: 0;
            font-size: 14px !important;
        }

        .layui-transfer-data {
            padding: 5px 0;
            overflow: auto;
        }

        .layui-transfer-data li {
            height: 32px;
            line-height: 32px;
            margin-top: 0 !important;
            padding: 0 11px;
            list-style-type: none !important;
        }

        .layui-transfer-data li:hover {
            background-color: #f8f8f8;
            transition: .5s all;
        }

        .layui-transfer-data .layui-none {
            padding: 15px 11px;
            text-align: center;
            color: #999;
        }

        /** 评分组件 **/
        .layui-rate,
        .layui-rate * {
            display: inline-block;
            vertical-align: middle;
        }

        .layui-rate {
            padding: 11px 6px 11px 0;
            font-size: 0;
        }

        .layui-rate li {
            margin-top: 0 !important;
        }

        .layui-rate li i.layui-icon {
            font-size: 20px;
            color: #ffb800;
        }

        .layui-rate li i.layui-icon {
            margin-right: 5px;
            transition: all .3s;
            -webkit-transition: all .3s;
        }

        .layui-rate li i:hover {
            cursor: pointer;
            transform: scale(1.12);
            -webkit-transform: scale(1.12);
        }

        .layui-rate[readonly] li i:hover {
            cursor: default;
            transform: scale(1);
        }

        /** 颜色选择器 **/
        .layui-colorpicker {
            width: 38px;
            height: 38px;
            border: 1px solid #eee;
            padding: 5px;
            border-radius: 2px;
            line-height: 24px;
            display: inline-block;
            cursor: pointer;
            transition: all .3s;
            -webkit-transition: all .3s;
            box-sizing: border-box;
        }

        .layui-colorpicker:hover {
            border-color: #d2d2d2;
        }

        .layui-colorpicker.layui-colorpicker-lg {
            width: 44px;
            height: 44px;
            line-height: 30px;
        }

        .layui-colorpicker.layui-colorpicker-sm {
            width: 30px;
            height: 30px;
            line-height: 20px;
            padding: 3px;
        }

        .layui-colorpicker.layui-colorpicker-xs {
            width: 22px;
            height: 22px;
            line-height: 16px;
            padding: 1px;
        }

        .layui-colorpicker-trigger-bgcolor {
            display: block;
            background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAMCAIAAADZF8uwAAAAGUlEQVQYV2M4gwH+YwCGIasIUwhT25BVBADtzYNYrHvv4gAAAABJRU5ErkJggg==);
            border-radius: 2px;
        }

        .layui-colorpicker-trigger-span {
            display: block;
            height: 100%;
            box-sizing: border-box;
            border: 1px solid rgba(0, 0, 0, .15);
            border-radius: 2px;
            text-align: center;
        }

        .layui-colorpicker-trigger-i {
            display: inline-block;
            color: #FFF;
            font-size: 12px;
        }

        .layui-colorpicker-trigger-i.layui-icon-close {
            color: #999;
        }

        .layui-colorpicker-main {
            position: absolute;
            left: -999999px;
            top: -999999px;
            z-index: 77777777;
            width: 280px;
            margin: 5px 0;
            padding: 7px;
            background: #FFF;
            border: 1px solid #d2d2d2;
            border-radius: 2px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, .12);
        }

        .layui-colorpicker-main-wrapper {
            height: 180px;
            position: relative;
        }

        .layui-colorpicker-basis {
            width: 260px;
            height: 100%;
            position: relative;
        }

        .layui-colorpicker-basis-white {
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            background: linear-gradient(90deg, #FFF, hsla(0, 0%, 100%, 0));
        }

        .layui-colorpicker-basis-black {
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            background: linear-gradient(0deg, #000, transparent);
        }

        .layui-colorpicker-basis-cursor {
            width: 10px;
            height: 10px;
            border: 1px solid #FFF;
            border-radius: 50%;
            position: absolute;
            top: -3px;
            right: -3px;
            cursor: pointer;
        }

        .layui-colorpicker-side {
            position: absolute;
            top: 0;
            right: 0;
            width: 12px;
            height: 100%;
            background: linear-gradient(#F00, #FF0, #0F0, #0FF, #00F, #F0F, #F00);
        }

        .layui-colorpicker-side-slider {
            width: 100%;
            height: 5px;
            box-shadow: 0 0 1px #888888;
            box-sizing: border-box;
            background: #FFF;
            border-radius: 1px;
            border: 1px solid #f0f0f0;
            cursor: pointer;
            position: absolute;
            left: 0;
        }

        .layui-colorpicker-main-alpha {
            display: none;
            height: 12px;
            margin-top: 7px;
            background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAMCAIAAADZF8uwAAAAGUlEQVQYV2M4gwH+YwCGIasIUwhT25BVBADtzYNYrHvv4gAAAABJRU5ErkJggg==)
        }

        .layui-colorpicker-alpha-bgcolor {
            height: 100%;
            position: relative;
        }

        .layui-colorpicker-alpha-slider {
            width: 5px;
            height: 100%;
            box-shadow: 0 0 1px #888888;
            box-sizing: border-box;
            background: #FFF;
            border-radius: 1px;
            border: 1px solid #f0f0f0;
            cursor: pointer;
            position: absolute;
            top: 0;
        }

        .layui-colorpicker-main-pre {
            padding-top: 7px;
            font-size: 0;
        }

        .layui-colorpicker-pre {
            width: 20px;
            height: 20px;
            border-radius: 2px;
            display: inline-block;
            margin-left: 6px;
            margin-bottom: 7px;
            cursor: pointer;
        }

        .layui-colorpicker-pre:nth-child(11n+1) {
            margin-left: 0;
        }

        .layui-colorpicker-pre-isalpha {
            background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAMCAIAAADZF8uwAAAAGUlEQVQYV2M4gwH+YwCGIasIUwhT25BVBADtzYNYrHvv4gAAAABJRU5ErkJggg==)
        }

        .layui-colorpicker-pre.layui-this {
            box-shadow: 0 0 3px 2px rgba(0, 0, 0, .15);
        }

        .layui-colorpicker-pre > div {
            height: 100%;
            border-radius: 2px;
        }

        .layui-colorpicker-main-input {
            text-align: right;
            padding-top: 7px;
        }

        .layui-colorpicker-main-input .layui-btn-container .layui-btn {
            margin: 0 0 0 10px;
        }

        .layui-colorpicker-main-input div.layui-inline {
            float: left;
            margin-right: 10px;
            font-size: 14px;
        }

        .layui-colorpicker-main-input input.layui-input {
            width: 150px;
            height: 30px;
            color: #5F5F5F;
        }

        /** 滑块 **/
        .layui-slider {
            height: 4px;
            background: #eee;
            border-radius: 3px;
            position: relative;
            cursor: pointer;
        }

        .layui-slider-bar {
            border-radius: 3px;
            position: absolute;
            height: 100%;
        }

        .layui-slider-step {
            position: absolute;
            top: 0;
            width: 4px;
            height: 4px;
            border-radius: 50%;
            background: #FFF;
            -webkit-transform: translateX(-50%);
            transform: translateX(-50%);
        }

        .layui-slider-wrap {
            width: 36px;
            height: 36px;
            position: absolute;
            top: -16px;
            -webkit-transform: translateX(-50%);
            transform: translateX(-50%);
            z-index: 10;
            text-align: center;
        }

        .layui-slider-wrap-btn {
            width: 12px;
            height: 12px;
            border-radius: 50%;
            background: #FFF;
            display: inline-block;
            vertical-align: middle;
            cursor: pointer;
            transition: 0.3s;
        }

        .layui-slider-wrap:after {
            content: "";
            height: 100%;
            display: inline-block;
            vertical-align: middle;
        }

        .layui-slider-wrap-btn:hover,
        .layui-slider-wrap-btn.layui-slider-hover {
            transform: scale(1.2);
        }

        .layui-slider-wrap-btn.layui-disabled:hover {
            transform: scale(1) !important;
        }

        .layui-slider-tips {
            position: absolute;
            top: -42px;
            z-index: 77777777;
            white-space: nowrap;
            display: none;
            -webkit-transform: translateX(-50%);
            transform: translateX(-50%);
            color: #FFF;
            background: #000;
            border-radius: 3px;
            height: 25px;
            line-height: 25px;
            padding: 0 10px;
        }

        .layui-slider-tips:after {
            content: "";
            position: absolute;
            bottom: -12px;
            left: 50%;
            margin-left: -6px;
            width: 0;
            height: 0;
            border-width: 6px;
            border-style: solid;
            border-color: #000 transparent transparent transparent;
        }

        .layui-slider-input {
            width: 70px;
            height: 32px;
            border: 1px solid #eee;
            border-radius: 3px;
            font-size: 16px;
            line-height: 32px;
            position: absolute;
            right: 0;
            top: -14px;
            box-sizing: border-box;
        }

        .layui-slider-input-btn {
            position: absolute;
            top: 0;
            right: 0;
            width: 20px;
            height: 100%;
            border-left: 1px solid #eee;
        }

        .layui-slider-input-btn i {
            cursor: pointer;
            position: absolute;
            right: 0;
            bottom: 0;
            width: 20px;
            height: 50%;
            font-size: 12px;
            line-height: 16px;
            text-align: center;
            color: #999;
        }

        .layui-slider-input-btn i:first-child {
            top: 0;
            border-bottom: 1px solid #eee;
        }

        .layui-slider-input-txt {
            height: 100%;
            font-size: 14px;
        }

        .layui-slider-input-txt input {
            height: 100%;
            border: none;
            padding-right: 21px;
        }

        .layui-slider-input-btn i:hover {
            color: #16baaa;
        }

        /*垂直滑块*/
        .layui-slider-vertical {
            width: 4px;
            margin-left: 33px;
        }

        .layui-slider-vertical .layui-slider-bar {
            width: 4px;
        }

        .layui-slider-vertical .layui-slider-step {
            top: auto;
            left: 0px;
            -webkit-transform: translateY(50%);
            transform: translateY(50%);
        }

        .layui-slider-vertical .layui-slider-wrap {
            top: auto;
            left: -16px;
            -webkit-transform: translateY(50%);
            transform: translateY(50%);
        }

        .layui-slider-vertical .layui-slider-tips {
            top: auto;
            left: 2px;
        }

        @media \0screen {
            .layui-slider-wrap-btn {
                margin-left: -20px;
            }

            .layui-slider-vertical .layui-slider-wrap-btn {
                margin-left: 0;
                margin-bottom: -20px;
            }

            .layui-slider-vertical .layui-slider-tips {
                margin-left: -8px;
            }

            .layui-slider > span {
                margin-left: 8px;
            }
        }

        /** 树组件 **/
        .layui-tree {
            line-height: 22px;
        }

        .layui-tree .layui-form-checkbox {
            margin: 0 !important;
        }

        .layui-tree-set {
            width: 100%;
            position: relative;
        }

        .layui-tree-pack {
            display: none;
            padding-left: 20px;
            position: relative;
        }

        .layui-tree-line .layui-tree-pack {
            padding-left: 27px;
        }

        .layui-tree-line .layui-tree-set .layui-tree-set:after {
            content: "";
            position: absolute;
            top: 14px;
            left: -9px;
            width: 17px;
            height: 0;
            border-top: 1px dotted #c0c4cc;
        }

        .layui-tree-entry {
            position: relative;
            padding: 3px 0;
            height: 26px;
            white-space: nowrap;
        }

        .layui-tree-entry:hover {
            background-color: #eee;
        }

        .layui-tree-line .layui-tree-entry:hover {
            background-color: rgba(0, 0, 0, 0);
        }

        .layui-tree-line .layui-tree-entry:hover .layui-tree-txt {
            color: #999;
            text-decoration: underline;
            transition: 0.3s;
        }

        .layui-tree-main {
            display: inline-block;
            vertical-align: middle;
            cursor: pointer;
            padding-right: 10px;
        }

        .layui-tree-line .layui-tree-set:before {
            content: "";
            position: absolute;
            top: 0;
            left: -9px;
            width: 0;
            height: 100%;
            border-left: 1px dotted #c0c4cc;
        }

        .layui-tree-line .layui-tree-set.layui-tree-setLineShort:before {
            height: 13px;
        }

        .layui-tree-line .layui-tree-set.layui-tree-setHide:before {
            height: 0;
        }

        .layui-tree-iconClick {
            display: inline-block;
            vertical-align: middle;
            position: relative;
            height: 20px;
            line-height: 20px;
            margin: 0 10px;
            color: #c0c4cc;
        }

        .layui-tree-icon {
            height: 14px;
            line-height: 12px;
            width: 14px;
            text-align: center;
            border: 1px solid #c0c4cc;
        }

        .layui-tree-iconClick .layui-icon {
            font-size: 18px;
        }

        .layui-tree-icon .layui-icon {
            font-size: 12px;
            color: #5F5F5F;
        }

        .layui-tree-iconArrow {
            padding: 0 5px;
        }

        .layui-tree-iconArrow:after {
            content: "";
            position: absolute;
            left: 4px;
            top: 3px;
            z-index: 100;
            width: 0;
            height: 0;
            border-width: 5px;
            border-style: solid;
            border-color: transparent transparent transparent #c0c4cc;
            transition: 0.5s;
        }

        .layui-tree-spread > .layui-tree-entry .layui-tree-iconClick > .layui-tree-iconArrow:after {
            transform: rotate(90deg) translate(3px, 4px);
        }

        .layui-tree-txt {
            display: inline-block;
            vertical-align: middle;
            color: #555;
        }

        .layui-tree-search {
            margin-bottom: 15px;
            color: #5F5F5F;
        }

        .layui-tree-btnGroup {
            visibility: hidden;
            display: inline-block;
            vertical-align: middle;
            position: relative;
        }

        .layui-tree-btnGroup .layui-icon {
            display: inline-block;
            vertical-align: middle;
            padding: 0 2px;
            cursor: pointer;
        }

        .layui-tree-btnGroup .layui-icon:hover {
            color: #999;
            transition: 0.3s;
        }

        .layui-tree-entry:hover .layui-tree-btnGroup {
            visibility: visible;
        }

        .layui-tree-editInput {
            position: relative;
            display: inline-block;
            vertical-align: middle;
            height: 20px;
            line-height: 20px;
            padding: 0;
            border: none;
            background-color: rgba(0, 0, 0, 0.05);
        }

        .layui-tree-emptyText {
            text-align: center;
            color: #999;
        }


        /** 动画 **/
        .layui-anim {
            -webkit-animation-duration: 0.3s;
            -webkit-animation-fill-mode: both;
            animation-duration: 0.3s;
            animation-fill-mode: both;
        }

        .layui-anim.layui-icon {
            display: inline-block;
        }

        .layui-anim-loop {
            -webkit-animation-iteration-count: infinite;
            animation-iteration-count: infinite;
        }

        .layui-trans,
        .layui-trans a {
            transition: all .2s;
            -webkit-transition: all .2s;
        }

        .layui-anim-rotate {
            -webkit-animation-name: layui-rotate;
            animation-name: layui-rotate;
            -webkit-animation-duration: 1s;
            animation-duration: 1s;
            -webkit-animation-timing-function: linear;
            animation-timing-function: linear;
        }

        .layui-anim-up {
            -webkit-animation-name: layui-up;
            animation-name: layui-up;
        }

        .layui-anim-upbit {
            -webkit-animation-name: layui-upbit;
            animation-name: layui-upbit;
        }

        .layui-anim-down {
            animation-name: layui-down;
        }

        .layui-anim-downbit {
            animation-name: layui-downbit;
        }

        .layui-anim-scale {
            -webkit-animation-name: layui-scale;
            animation-name: layui-scale
        }

        .layui-anim-scaleSpring {
            -webkit-animation-name: layui-scale-spring;
            animation-name: layui-scale-spring
        }

        .layui-anim-scalesmall {
            animation-name: layui-scalesmall
        }

        .layui-anim-scalesmall-spring {
            animation-name: layui-scalesmall-spring
        }

        .layui-anim-fadein {
            -webkit-animation-name: layui-fadein;
            animation-name: layui-fadein;
        }

        .layui-anim-fadeout {
            -webkit-animation-name: layui-fadeout;
            animation-name: layui-fadeout
        }

        .layui-table th {
            text-align: center;
        }
    </style>
</head>

<body>
<div class="layui-container">
    <div class="layui-row">
        <h1 style="text-align: center;">${title}</h1>
        <div class="layui-row">
            <div class="layui-col-md-offset-3 layui-col-md-6">
                <table class="layui-table" lay-size="sm" lay-skin="nob" style="text-align: center;">
                    <tbody>
                    <tr>
                        <td style="text-align: left;">购货单位：${companyName}</td>
                        <td>日期：${deliveryDate}</td>
                        <td style="text-align: right;">电话：${phone}</td>
                    <tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="layui-col-md-offset-3 layui-col-md-6">
            <table class="layui-table" lay-size="sm" style="text-align: center;">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>产品</th>
                    <th>规格型号/桶</th>
                    <th>桶数</th>
                    <th>重量</th>
                    <th>单价</th>
                    <th>金额</th>
                    <th>备注</th>
                </tr>
                </thead>
                <tbody>
                <#list ordersList as order>
                    <tr>
                        <td>${order.productName!}</td>
                        <td>${order.specificationString!}</td>
                        <td>${order.number!}</td>
                        <td>${order.weightString!}</td>
                        <td>${order.price!}</td>
                        <td>${order.amount!}</td>
                        <td>&nbsp;${order.remark!}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-md-offset-3 layui-col-md-6">
            <table class="layui-table" lay-size="sm" lay-skin="nob" style="text-align: left;">
                <tbody>
                <tr>
                    <td>合计（大写）：${bigTotalAmount}</td>
                    <td></td>
                    <td></td>
                    <td>合计（小写）：${smallTotalAmount}</td>
                <tr>
                <tr>
                    <td>当次送货（）只</td>
                    <td>当次退桶（）只</td>
                    <td>当初欠桶（）只</td>
                    <td>累计欠桶（）只</td>
                <tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-md-offset-3 layui-col-md-6">
            <table class="layui-table" lay-size="sm" lay-skin="nob" style="text-align: center;">
                <tbody>
                <tr>
                    <td style="font-size: 8px; text-align: left;">
                        <p>说明：购货单位向供货方购销以上产品，约定共同遵守如下责任条款：</p>
                        <p>
                            1.购货方保证按合同约定凭签收依据付清全部货款，如汇款需汇入供货方指定账号，逾期不付清货款按拖欠付款金额千分之五按日向供货方支付逾期利息到付清为止，已验收合格入库不得以不合格为由拒付货款或提起质量异议，双方检验标准不一有异议时以国家质检结果为准，检验结果符合约定标准检验及相关费用由购货方承担
                        </p>
                        <p>2.应回收周转桶（ ）个，购货方欠以签收桶欠条为准，日后不得已经手人离职为由不退桶</p>
                        <p>
                            3.一经签收送货单、合同等，未经供货方同意购货方单方取消或终止，拖延执行，逾期付款等视为违约，需支付合同未履行总金额20%违约金，违约导致追溯产生的费用包括但不限于，律师费、诉讼费、差旅费、财产担保费等均由违约方承担。
                        </p>
                        <p>4.本条款是双方签订后生效，如有纠纷无法协商以货地广州人民法院诉讼解决</p>
                    </td>
                <tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-md-offset-3 layui-col-md-6">
            <table class="layui-table" lay-size="sm" lay-skin="nob" style="text-align: center;">
                <tbody>
                <tr>
                    <td style="text-align: left;">开单人：${salesman}</td>
                    <td style="text-align: left;">收货代表：</td>
                <tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>