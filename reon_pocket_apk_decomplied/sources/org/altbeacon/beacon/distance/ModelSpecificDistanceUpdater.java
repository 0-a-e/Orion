package org.altbeacon.beacon.distance;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
import org.altbeacon.beacon.BuildConfig;

public class ModelSpecificDistanceUpdater extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "ModelSpecificDistanceUpdater";
    private Exception exception = null;
    private CompletionHandler mCompletionHandler;
    private Context mContext;
    private DistanceConfigFetcher mDistanceConfigFetcher;
    private String response = null;
    private String urlString = null;

    interface CompletionHandler {
        void onComplete(String str, Exception exc, int i);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute() {
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voidArr) {
        this.mDistanceConfigFetcher.request();
        CompletionHandler completionHandler = this.mCompletionHandler;
        if (completionHandler == null) {
            return null;
        }
        completionHandler.onComplete(this.mDistanceConfigFetcher.getResponseString(), this.mDistanceConfigFetcher.getException(), this.mDistanceConfigFetcher.getResponseCode());
        return null;
    }

    public ModelSpecificDistanceUpdater(Context context, String str, CompletionHandler completionHandler) {
        this.mContext = context;
        this.mDistanceConfigFetcher = new DistanceConfigFetcher(str, getUserAgentString());
        this.mCompletionHandler = completionHandler;
    }

    private String getUserAgentString() {
        return "Android Beacon Library;" + getVersion() + ";" + getPackage() + ";" + getInstallId() + ";" + getModel();
    }

    private String getPackage() {
        return this.mContext.getPackageName();
    }

    private String getModel() {
        return AndroidModel.forThisDevice().toString();
    }

    private String getInstallId() {
        return Settings.Secure.getString(this.mContext.getContentResolver(), "android_id");
    }

    private String getVersion() {
        return BuildConfig.VERSION_NAME;
    }
}
