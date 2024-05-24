package it.saimao.mp3player;

import android.os.Parcelable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/*
Private State
Getter/Setter
Constructor
toString
equals and hash
 */
public record Data (
        String artistName,
        Integer artistPhoto,
        Integer artistSong
) implements Serializable {
}
