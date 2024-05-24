package it.saimao.mp3player;

import static it.saimao.mp3player.HomeActivity.mySongs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.RawResourceDataSource;
import androidx.media3.exoplayer.ExoPlayer;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private TextView tvArtist;
    private ImageView ivArtist;
    private Button btPrev, btPause, btNext;

    private int artistIndex;
    private Data data;

    private static ExoPlayer exoPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initDataFromIntent();
        initUi();
        initPlayer();
        initListeners();
    }

    private void initDataFromIntent() {
        if (getIntent() != null) {
            artistIndex = getIntent().getIntExtra("artist_index", 0);
            data = (Data) getIntent().getSerializableExtra("artist");
        }
    }

    private void initListeners() {
        btNext.setOnClickListener(v -> {
            if (artistIndex == mySongs.size() - 1) {
                artistIndex = 0;
            } else {
                artistIndex++;
            }
            data = mySongs.get(artistIndex);
            updatePlayer();
        });

        btPrev.setOnClickListener(v -> {
            if (artistIndex == 0) {
                artistIndex = mySongs.size() - 1;
            } else {
                artistIndex--;
            }
            data = mySongs.get(artistIndex);
            updatePlayer();
        });

        btPause.setOnClickListener(v -> {
            if (exoPlayer.isPlaying()) {
                exoPlayer.pause();
                btPause.setText(getResources().getString(R.string.play));
            } else {
                exoPlayer.play();
                btPause.setText(getResources().getString(R.string.pause));
            }
        });

    }

    private void initPlayer() {

        if (exoPlayer == null)
            exoPlayer = new ExoPlayer.Builder(this).build();
        updatePlayer();

    }

    @OptIn(markerClass = UnstableApi.class)
    private void updatePlayer() {
        tvArtist.setText(data.artistName());
        ivArtist.setImageResource(data.artistPhoto());
        Uri song = RawResourceDataSource.buildRawResourceUri(data.artistSong());

        exoPlayer.setMediaItem(MediaItem.fromUri(song));
        exoPlayer.prepare();
        exoPlayer.play();
    }

    private void initUi() {
        tvArtist = findViewById(R.id.tv_artist);
        ivArtist = findViewById(R.id.iv_artist);
        btNext = findViewById(R.id.bt_next);
        btPause = findViewById(R.id.bt_pause);
        btPrev = findViewById(R.id.bt_previous);
    }
}

/*
How to send data from one activity to another!
 */
/*
2 Activity
1 -> 5 songs (Song List Activity)
R Zarni -> (Song Activity)
*/



















