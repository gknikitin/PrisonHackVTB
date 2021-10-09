package info.fandroid.quiz.utility;

public class SoundUtilities {
    private String mAssetPath;
    private String mName;
    private Integer mSoundId;

    public SoundUtilities(String str) {
        this.mAssetPath = str;
        String[] split = str.split("/");
        this.mName = split[split.length - 1].replace(".wav", "");
    }

    public String getAssetPath() {
        return this.mAssetPath;
    }

    public String getName() {
        return this.mName;
    }

    public Integer getSoundId() {
        return this.mSoundId;
    }

    public void setSoundId(Integer num) {
        this.mSoundId = num;
    }
}
