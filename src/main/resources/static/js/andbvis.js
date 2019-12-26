var map, geolocation;
var danadw;
var latitude;
//加载地图，调用浏览器定位服务

map = new AMap.Map('container', {

    resizeEnable: true

});
map.plugin('AMap.Geolocation', function() {

    geolocation = new AMap.Geolocation({

        enableHighAccuracy: true, //是否使用高精度定位，默认:true

        timeout: 10000, //超过10秒后停止定位，默认：无穷大

        buttonOffset: new AMap.Pixel(10, 20), //定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)

        zoomToAccuracy: true, //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false

        buttonPosition: 'RB'

    });

    map.addControl(geolocation);

    geolocation.getCurrentPosition();

    AMap.event.addListener(geolocation, 'complete', onComplete); //返回定位信息

    AMap.event.addListener(geolocation, 'error', onError); //返回定位出错信息

});

//解析定位结果

function onComplete(data) {
    /*data.position.getLat()J*/
    /*data.position.getLng()*/
    danadw = data.position.getLat();
    latitude = data.position.getLng();
    $("#init").val("初始化成功")
}

// 解析定位错误信息

function onError(data) {

    console.log('定位失败');
    layui.use('layer',function () {
        var layer = layui.layer;
        layer.msg("初始化失败,请更换浏览器试试吧,IE绝对可以哦。小众众")
    })
    
    $("#init").val("初始化失败,请更换浏览器试试吧,IE绝对可以哦。")

}


function  addSha() {
        /*alert(">>>>>>>"+$("#title").val()+">>>>>>"+$("#content").val()+">>>>>>>>>>>>>>>>>>"+$("#img_site").val()+">>>>>"+danadw+">>>>"+latitude)*/
        location.href='addShars/'+$("#title").val()+"/"+$("#content").val()+"/"+$("#img_site").val()+"/"+danadw+"/"+latitude
}