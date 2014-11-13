package com.example.antpagetest;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
/**
 * 		获取渠道号， 以及批量打包、添加渠道号
 * 		
 * 		运行builddd.xml
 * 
 * 		生成.apk在release文件夹下面
 * 		
 * 		修改local.properties  market_channels=，，，添加渠道 证书路径、密码等信息
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView tv = (TextView) findViewById(R.id.tv);
		Button btn = (Button) findViewById(R.id.btn);
		
		btn.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s = getChanel(MainActivity.this);
				tv.setText(s);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//获取渠道号
	public static String getChanel(Context ctx){  
        String CHANNELID="000000";  
        try {  
               ApplicationInfo  ai = ctx.getPackageManager().getApplicationInfo(  
                       ctx.getPackageName(), PackageManager.GET_META_DATA);  
               Object value = ai.metaData.get("CHANNEL");
               log(value.toString());
               if (value != null) {  
                   CHANNELID= value.toString();
               }  
           } catch (Exception e) {  
               //  
           }  
          
        return CHANNELID;  
    }  
	

	public static void log ( String s )
	{
		Log.w("MYUTIL", s);
	}
	
}
