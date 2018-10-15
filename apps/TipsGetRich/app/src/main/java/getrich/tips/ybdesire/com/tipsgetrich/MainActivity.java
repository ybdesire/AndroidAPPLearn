package getrich.tips.ybdesire.com.tipsgetrich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init and load banner ad
        MobileAds.initialize(this, "ca-app-pub-8100413825150401~9396888732");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8100413825150401/1718543413");

        //content to display
        String[] tab_names = getResources().getStringArray(R.array.tabs_names);
        String[] strs = new String[tab_names.length];

        for(int i=0;i<tab_names.length;i++)
        {
            strs[i] = tab_names[i];
        }


        // display at the listview
        ListView lv = (ListView) findViewById(R.id.lv);//得到ListView对象的引用 /*为ListView设置Adapter来绑定数据*/
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs));

        // click listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //点击后在标题上显示点击了第几行
                setTitle("你点击了第"+arg2+"行");
                mInterstitialAd.loadAd(new AdRequest.Builder().build());

                // start another acitvity with parameters
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle b = new Bundle();
                b.putInt("page", arg2); //Your key-value
                intent.putExtras(b); //Put your key-value
                startActivity(intent);
            }
        });


    }
}
