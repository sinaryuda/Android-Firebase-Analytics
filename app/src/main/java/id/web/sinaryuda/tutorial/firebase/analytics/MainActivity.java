package id.web.sinaryuda.tutorial.firebase.analytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAnalytics = FirebaseAnalytics.getInstance(MainActivity.this);

        ImageButton mobilPertama = (ImageButton)findViewById(R.id.mobil_pertama);
        ImageButton mobilKedua = (ImageButton)findViewById(R.id.mobil_kedua);
        ImageButton mobilKetiga = (ImageButton)findViewById(R.id.mobil_ketiga);
        assert mobilPertama != null;
        mobilPertama.setOnClickListener(this);
        assert mobilKedua != null;
        mobilKedua.setOnClickListener(this);
        assert mobilKetiga != null;
        mobilKetiga.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int getImageIdMobil = view.getId();
        String getNamaImage = null;
        if(view instanceof ImageButton){
            ImageButton clickedImage = (ImageButton) view;
            getNamaImage = clickedImage.getTag().toString();
        }
        Toast.makeText(MainActivity.this, "Anda memilih pada " + getNamaImage, Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(getImageIdMobil));
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, getNamaImage);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}
