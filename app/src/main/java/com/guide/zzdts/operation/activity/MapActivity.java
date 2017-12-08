package com.guide.zzdts.operation.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.guide.zzdts.operation.R;
import com.guide.zzdts.operation.data.LocationInformation;

public class MapActivity extends AppCompatActivity {
    MapView mapView = null;
    TextView textView_mapType;
    DrawerLayout drawerLayout = null;
    LinearLayout drawer_child = null;
    LinearLayout linearLayout_satellite;
    LinearLayout linearLayout_2D_plan;
    LinearLayout linearLayout_3D_plan;
    TextView textView_textView_traffic_no_selected;
    TextView textView_traffic_selected;
    TextView textView_location;
    BaiduMap baiduMap = null;
    MyLocationData myLocationData = null;
    LocationInformation locationInformation;
    public double locationLatitude;
    public double locationLongitude;
    public LocationClient locationClient = null;
    private boolean isFirstLocate = true;
    public MyLocationListener myLocationListener = new MyLocationListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("MapActivity","执行");
        SDKInitializer.initialize(getApplicationContext());
        /**
         * 注册的监听类
         */
        locationClient = new LocationClient(getApplicationContext());
        locationClient.registerLocationListener(new MyLocationListener());
        Log.e("MapActivity","注册");
        setContentView(R.layout.activity_map);
        mapView = (MapView) findViewById(R.id.mapView);
        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);
        textView_mapType = (TextView) findViewById(R.id.textView_mapType);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer_child = (LinearLayout) findViewById(R.id.drawer_child);
        linearLayout_satellite = (LinearLayout) findViewById(R.id.linearLayout_satellite);
        linearLayout_2D_plan = (LinearLayout) findViewById(R.id.linearLayout_2D_plan);
        linearLayout_3D_plan = (LinearLayout) findViewById(R.id.linearLayout_3D_plan);
        textView_textView_traffic_no_selected = (TextView) findViewById(R.id.textView_traffic_no_selected);
        textView_traffic_selected = (TextView) findViewById(R.id.textView_traffic_selected);
        textView_location = (TextView) findViewById(R.id.textView_location);
        /**
         *点击mapType侧滑DrawerLayout
         */
        textView_mapType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        changeMapType();
        showTrafficCondition();
        initLocation();
    }
    /**
     * 点击显示交通状况并改变图标显示
     */
    public void showTrafficCondition(){
        textView_textView_traffic_no_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baiduMap.setTrafficEnabled(true);
                textView_textView_traffic_no_selected.setVisibility(View.GONE);
                textView_traffic_selected.setVisibility(View.VISIBLE);
            }
        });
        textView_traffic_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baiduMap.setTrafficEnabled(false);
                textView_textView_traffic_no_selected.setVisibility(View.VISIBLE);
                textView_traffic_selected.setVisibility(View.GONE);
            }
        });
    }
    /**
     * 设置地图类型切换监听
     */
    public void changeMapType(){
        linearLayout_satellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
            }
        });
        linearLayout_2D_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
            }
        });
        linearLayout_3D_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
            }
        });
    }
    /**
     * 初始定位到我的位置
     */
    private void autoLocationMine(BDLocation bdLocation){
        if (isFirstLocate) {
            LatLng latLng = new LatLng(bdLocation.getLatitude(),bdLocation.getLongitude());
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(latLng);
            baiduMap.animateMapStatus(update);
            update = MapStatusUpdateFactory.zoomTo(16f);
            baiduMap.animateMapStatus(update);
            isFirstLocate = false;
        }
        MyLocationData locationData = new MyLocationData.Builder().latitude(bdLocation.getLatitude()).longitude(bdLocation.getLongitude()).build();
        baiduMap.setMyLocationData(locationData);
        Log.e("MapActivity","auto");

    }
    /**
     * 点击定位图标定位到自己目前位置
     */
//    private void location(final BDLocation bdLocation){
//        textView_location.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("MapActivity","点击");
//                baiduMap.setMyLocationEnabled(true);
//                locationClient.start();
////                locationClient.requestLocation();
//                initLocation();
//                MyLocationData lo = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(bdLocation.getLatitude()).longitude(bdLocation.getLongitude()).build();
//                baiduMap.setMyLocationData(lo);
//                MyLocationConfiguration locationConfiguration = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL,true, BitmapDescriptorFactory.fromResource(R.mipmap.location_mine));
//                baiduMap.setMyLocationConfiguration(locationConfiguration);
//            }
//        });
//    }
    /**
     * 调用LocationClientOption类，设置定位SDK定位方式。
     */
    private void initLocation(){
        LocationClientOption locationClientOption = new LocationClientOption();
        //设置定位精度
        locationClientOption.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
        //设置定位结果坐标系
        locationClientOption.setCoorType("bd09ll");
        int span =1000;
        locationClientOption.setScanSpan(span);
        locationClientOption.setIsNeedAddress(true);
        locationClientOption.setOpenGps(true);
        locationClientOption.setIsNeedLocationDescribe(true);
        locationClientOption.setIsNeedLocationPoiList(true);
        locationClientOption.setIgnoreKillProcess(false);
        locationClient.setLocOption(locationClientOption);
    }
    /**
     * 定位监听类,获取定位位置各项信息
     */
    public class MyLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
//            myLocationData = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100)
//                    .latitude(locationLatitude).longitude(locationLongitude).build();
            if (bdLocation.getLocType() == BDLocation.TypeGpsLocation || bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                autoLocationMine(bdLocation);
            }
//            location(bdLocation);
            Log.e("MapActivity", String.valueOf(locationLatitude));
//            locationInformation = new LocationInformation(radius,locationLatitude,locationLongitude,locType);
        }
        /**
         * 回调定位诊断信息，开发者可以根据相关信息解决定位遇到的一些问题
         * 自动回调，相同的diagnosticType只会回调一次
         * @param locType           当前定位类型
         * @param diagnosticType    诊断类型（1~9）
         * @param diagnosticMessage 具体的诊断信息释义
         */
        public void onLocDiagnosticMessage(int locType, int diagnosticType, String diagnosticMessage) {

            if (diagnosticType == LocationClient.LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS) {

                //建议打开GPS

            } else if (diagnosticType == LocationClient.LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI) {

                //建议打开wifi，不必连接，这样有助于提高网络定位精度！

            } else if (diagnosticType == LocationClient.LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION) {

                //定位权限受限，建议提示用户授予APP定位权限！

            } else if (diagnosticType == LocationClient.LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET) {

                //网络异常造成定位失败，建议用户确认网络状态是否异常！

            } else if (diagnosticType == LocationClient.LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE) {

                //手机飞行模式造成定位失败，建议用户关闭飞行模式后再重试定位！

            } else if (diagnosticType == LocationClient.LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI) {

                //无法获取任何定位依据，建议用户打开wifi或者插入sim卡重试！

            } else if (diagnosticType == LocationClient.LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH) {

                //无法获取有效定位依据，建议用户打开手机设置里的定位开关后重试！

            } else if (diagnosticType == LocationClient.LOC_DIAGNOSTIC_TYPE_SERVER_FAIL) {

                //百度定位服务端定位失败
                //建议反馈location.getLocationID()和大体定位时间到loc-bugs@baidu.com

            } else if (diagnosticType == LocationClient.LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN) {

                //无法获取有效定位依据，但无法确定具体原因
                //建议检查是否有安全软件屏蔽相关定位权限
                //或调用LocationClient.restart()重新启动后重试！

            }
        }

    }
    /**
     * 在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationClient.stop();
        mapView.onDestroy();
        baiduMap.setMyLocationEnabled(false);
    }
    /**
     * 在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }
    /**在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，
     * 保存地图当前的状态
    */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
