package com.daimajia.slider.demo;

import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderLayout.Transformer;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

public class MainActivity extends ActionBarActivity implements
		BaseSliderView.OnSliderClickListener {

	private SliderLayout mDemoSlider;
	/*private Handler mHandler;
	private Timer mTimer;
	private MyTimerTask mTimerTask;*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDemoSlider = (SliderLayout) findViewById(R.id.slider);

		HashMap<String, String> url_maps = new HashMap<String, String>();
		url_maps.put(
				"Hannibal",
				"http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
		url_maps.put("Big Bang Theory",
				"http://tvfiles.alphacoders.com/100/hdclearart-10.png");
		url_maps.put("House of Cards",
				"http://cdn3.nflximg.net/images/3093/2043093.jpg");
		url_maps.put(
				"Game of Thrones",
				"http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

		HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
		file_maps.put("Hannibal", R.drawable.hannibal);
		file_maps.put("Big Bang Theory", R.drawable.bigbang);
		file_maps.put("House of Cards", R.drawable.house);
		file_maps.put("Game of Thrones", R.drawable.game_of_thrones);

		for (String name : file_maps.keySet()) {
			TextSliderView textSliderView = new TextSliderView(this);
			// initialize a SliderLayout
			textSliderView.description(name).image(file_maps.get(name))
					.setScaleType(BaseSliderView.ScaleType.Fit)
					.setOnSliderClickListener(this);

			// add your extra information
			textSliderView.getBundle().putString("extra", name);

			mDemoSlider.addSlider(textSliderView);
		}
		//
	/*	 mHandler = new Handler(){
	         public void handleMessage(Message message){
	          Log.i("timer", "message what = " + message.what);
	         
	           //createRandomNumber();	         
	          
	         }
	        };
	        
		mTimer = new Timer(true);
		if (mTimer != null) {
			if (mTimerTask != null) {
				mTimerTask.cancel(); // ��ԭ����Ӷ������Ƴ�
			}

			mTimerTask = new MyTimerTask(); // �½�һ������
			mTimer.schedule(mTimerTask, 3000);
		}*/
			
		mDemoSlider.setPresetTransformer((int) (System.currentTimeMillis()%(Transformer.values().length)));
		//mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
		mDemoSlider
				.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
		mDemoSlider.setCustomAnimation(new DescriptionAnimation());
		mDemoSlider.setDuration(4000);
		ListView l = (ListView) findViewById(R.id.transformers);
		l.setAdapter(new TransformerAdapter(this));
		l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				mDemoSlider.setPresetTransformer(((TextView) view).getText()
						.toString());
				Toast.makeText(MainActivity.this,
						((TextView) view).getText().toString(),
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	@Override
	public void onSliderClick(BaseSliderView slider) {
		Toast.makeText(this, slider.getBundle().get("extra") + "",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_custom_indicator:
			mDemoSlider
					.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
			break;
		case R.id.action_custom_child_animation:
			mDemoSlider.setCustomAnimation(new ChildAnimationExample());
			break;
		case R.id.action_restore_default:
			mDemoSlider
					.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
			mDemoSlider.setCustomAnimation(new DescriptionAnimation());
			break;
		case R.id.action_github:
			Intent browserIntent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://github.com/daimajia/AndroidImageSlider"));
			startActivity(browserIntent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/*class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Log.i("timer", "run...");
			Random rd = new Random();
			//int n = rd.nextInt(100)%(Transformer.values().length);
			int n = (int) (System.currentTimeMillis()%(Transformer.values().length));
			
			mDemoSlider.setPresetTransformer(n);
			Message msg = mHandler.obtainMessage(0);
			   msg.sendToTarget();
		}
	}*/
}
