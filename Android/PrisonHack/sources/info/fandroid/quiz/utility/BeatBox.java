package info.fandroid.quiz.utility;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.SoundPool;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final int MAX_SOUNDS = 5;
    private static final String SOUNDS_FOLDER = "all_sounds";
    private AssetManager mAssets;
    private SoundPool mSoundPool;
    private List<SoundUtilities> mSounds = new ArrayList();

    public BeatBox(Context context) {
        this.mAssets = context.getAssets();
        this.mSoundPool = new SoundPool(5, 3, 0);
        loadSounds();
    }

    private void loadSounds() {
        try {
            for (String str : this.mAssets.list(SOUNDS_FOLDER)) {
                try {
                    SoundUtilities soundUtilities = new SoundUtilities("all_sounds/" + str);
                    load(soundUtilities);
                    this.mSounds.add(soundUtilities);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException unused) {
        }
    }

    private void load(SoundUtilities soundUtilities) throws IOException {
        soundUtilities.setSoundId(Integer.valueOf(this.mSoundPool.load(this.mAssets.openFd(soundUtilities.getAssetPath()), 1)));
    }

    public void play(SoundUtilities soundUtilities) {
        Integer soundId = soundUtilities.getSoundId();
        if (soundId != null) {
            this.mSoundPool.play(soundId.intValue(), 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public void release() {
        this.mSoundPool.release();
    }

    public List<SoundUtilities> getSounds() {
        return this.mSounds;
    }
}
