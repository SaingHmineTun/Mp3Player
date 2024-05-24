package it.saimao.mp3player;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    static final List<Data> mySongs = List.of(
            new Data("Athen Cho Swe", R.drawable.athen_cho_swe, R.raw.tmk3),
            new Data("Phyu Phyu Kyaw Thein", R.drawable.phyu_phyu_kyaw_thein, R.raw.tmk7),
            new Data("R Zarni", R.drawable.r_zarni, R.raw.tmk11));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onSelectSong(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        if (view.getId() == R.id.cv_atcs) {
            intent.putExtra("artist_index", 0);
            intent.putExtra("artist", mySongs.get(0));
        } else if (view.getId() == R.id.cv_ppkt) {
            intent.putExtra("artist", mySongs.get(1));
            intent.putExtra("artist_index", 1);

        } else if (view.getId() == R.id.cv_rzn) {
            intent.putExtra("artist", mySongs.get(2));
            intent.putExtra("artist_index", 2);
        }
        startActivity(intent);
    }
}