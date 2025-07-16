package org.altbeacon.beacon.distance;

import android.content.Context;
import android.os.AsyncTask;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.altbeacon.beacon.distance.ModelSpecificDistanceUpdater;
import org.altbeacon.beacon.logging.LogManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ModelSpecificDistanceCalculator implements DistanceCalculator {
    private static final String CONFIG_FILE = "model-distance-calculations.json";
    private static final String TAG = "ModelSpecificDistanceCalculator";
    private Context mContext;
    private AndroidModel mDefaultModel;
    /* access modifiers changed from: private */
    public DistanceCalculator mDistanceCalculator;
    private final ReentrantLock mLock;
    private AndroidModel mModel;
    Map<AndroidModel, DistanceCalculator> mModelMap;
    /* access modifiers changed from: private */
    public String mRemoteUpdateUrlString;
    /* access modifiers changed from: private */
    public AndroidModel mRequestedModel;

    public ModelSpecificDistanceCalculator(Context context, String str) {
        this(context, str, AndroidModel.forThisDevice());
    }

    public ModelSpecificDistanceCalculator(Context context, String str, AndroidModel androidModel) {
        this.mRemoteUpdateUrlString = null;
        this.mLock = new ReentrantLock();
        this.mRequestedModel = androidModel;
        this.mRemoteUpdateUrlString = str;
        this.mContext = context;
        loadModelMap();
        this.mDistanceCalculator = findCalculatorForModelWithLock(androidModel);
    }

    public AndroidModel getModel() {
        return this.mModel;
    }

    public AndroidModel getRequestedModel() {
        return this.mRequestedModel;
    }

    public double calculateDistance(int i, double d) {
        DistanceCalculator distanceCalculator = this.mDistanceCalculator;
        if (distanceCalculator != null) {
            return distanceCalculator.calculateDistance(i, d);
        }
        LogManager.w(TAG, "distance calculator has not been set", new Object[0]);
        return -1.0d;
    }

    /* access modifiers changed from: package-private */
    public DistanceCalculator findCalculatorForModelWithLock(AndroidModel androidModel) {
        this.mLock.lock();
        try {
            return findCalculatorForModel(androidModel);
        } finally {
            this.mLock.unlock();
        }
    }

    private DistanceCalculator findCalculatorForModel(AndroidModel androidModel) {
        LogManager.d(TAG, "Finding best distance calculator for %s, %s, %s, %s", androidModel.getVersion(), androidModel.getBuildNumber(), androidModel.getModel(), androidModel.getManufacturer());
        Map<AndroidModel, DistanceCalculator> map = this.mModelMap;
        AndroidModel androidModel2 = null;
        if (map == null) {
            LogManager.d(TAG, "Cannot get distance calculator because modelMap was never initialized", new Object[0]);
            return null;
        }
        int i = 0;
        for (AndroidModel next : map.keySet()) {
            if (next.matchScore(androidModel) > i) {
                i = next.matchScore(androidModel);
                androidModel2 = next;
            }
        }
        if (androidModel2 != null) {
            LogManager.d(TAG, "found a match with score %s", Integer.valueOf(i));
            LogManager.d(TAG, "Finding best distance calculator for %s, %s, %s, %s", androidModel2.getVersion(), androidModel2.getBuildNumber(), androidModel2.getModel(), androidModel2.getManufacturer());
            this.mModel = androidModel2;
        } else {
            this.mModel = this.mDefaultModel;
            LogManager.w(TAG, "Cannot find match for this device.  Using default", new Object[0]);
        }
        return this.mModelMap.get(this.mModel);
    }

    private void loadModelMap() {
        boolean z;
        if (this.mRemoteUpdateUrlString != null) {
            z = loadModelMapFromFile();
            if (!z) {
                requestModelMapFromWeb();
            }
        } else {
            z = false;
        }
        if (!z) {
            loadDefaultModelMap();
        }
        this.mDistanceCalculator = findCalculatorForModelWithLock(this.mRequestedModel);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        org.altbeacon.beacon.logging.LogManager.e(r1, TAG, "Cannot update distance models from online database at %s with JSON: %s", r9.mRemoteUpdateUrlString, r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073 A[SYNTHETIC, Splitter:B:35:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0078 A[SYNTHETIC, Splitter:B:39:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007e A[SYNTHETIC, Splitter:B:44:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0083 A[SYNTHETIC, Splitter:B:48:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x008a A[SYNTHETIC, Splitter:B:56:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x008f A[SYNTHETIC, Splitter:B:60:0x008f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean loadModelMapFromFile() {
        /*
            r9 = this;
            java.lang.String r0 = "ModelSpecificDistanceCalculator"
            java.io.File r1 = new java.io.File
            android.content.Context r2 = r9.mContext
            java.io.File r2 = r2.getFilesDir()
            java.lang.String r3 = "model-distance-calculations.json"
            r1.<init>(r2, r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 1
            r4 = 0
            r5 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x0066, all -> 0x0063 }
            r6.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x0066, all -> 0x0063 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0061 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0061 }
            r8.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0061 }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0061 }
        L_0x0026:
            java.lang.String r5 = r7.readLine()     // Catch:{ FileNotFoundException -> 0x005d, IOException -> 0x005a, all -> 0x0057 }
            if (r5 == 0) goto L_0x0035
            r2.append(r5)     // Catch:{ FileNotFoundException -> 0x005d, IOException -> 0x005a, all -> 0x0057 }
            java.lang.String r5 = "\n"
            r2.append(r5)     // Catch:{ FileNotFoundException -> 0x005d, IOException -> 0x005a, all -> 0x0057 }
            goto L_0x0026
        L_0x0035:
            r7.close()     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            r6.close()     // Catch:{ Exception -> 0x003b }
        L_0x003b:
            java.lang.String r1 = r2.toString()     // Catch:{ JSONException -> 0x0043 }
            r9.buildModelMapWithLock(r1)     // Catch:{ JSONException -> 0x0043 }
            return r3
        L_0x0043:
            r1 = move-exception
            java.lang.String r5 = r9.mRemoteUpdateUrlString
            java.lang.String r2 = r2.toString()
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r4] = r5
            r6[r3] = r2
            java.lang.String r2 = "Cannot update distance models from online database at %s with JSON: %s"
            org.altbeacon.beacon.logging.LogManager.e(r1, r0, r2, r6)
            return r4
        L_0x0057:
            r0 = move-exception
            r5 = r7
            goto L_0x007c
        L_0x005a:
            r2 = move-exception
            r5 = r7
            goto L_0x0068
        L_0x005d:
            r5 = r7
            goto L_0x0088
        L_0x005f:
            r0 = move-exception
            goto L_0x007c
        L_0x0061:
            r2 = move-exception
            goto L_0x0068
        L_0x0063:
            r0 = move-exception
            r6 = r5
            goto L_0x007c
        L_0x0066:
            r2 = move-exception
            r6 = r5
        L_0x0068:
            java.lang.String r7 = "Cannot open distance model file %s"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x005f }
            r3[r4] = r1     // Catch:{ all -> 0x005f }
            org.altbeacon.beacon.logging.LogManager.e(r2, r0, r7, r3)     // Catch:{ all -> 0x005f }
            if (r5 == 0) goto L_0x0076
            r5.close()     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            if (r6 == 0) goto L_0x007b
            r6.close()     // Catch:{ Exception -> 0x007b }
        L_0x007b:
            return r4
        L_0x007c:
            if (r5 == 0) goto L_0x0081
            r5.close()     // Catch:{ Exception -> 0x0081 }
        L_0x0081:
            if (r6 == 0) goto L_0x0086
            r6.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0086:
            throw r0
        L_0x0087:
            r6 = r5
        L_0x0088:
            if (r5 == 0) goto L_0x008d
            r5.close()     // Catch:{ Exception -> 0x008d }
        L_0x008d:
            if (r6 == 0) goto L_0x0092
            r6.close()     // Catch:{ Exception -> 0x0092 }
        L_0x0092:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.distance.ModelSpecificDistanceCalculator.loadModelMapFromFile():boolean");
    }

    /* access modifiers changed from: private */
    public boolean saveJson(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.mContext.openFileOutput(CONFIG_FILE, 0);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused) {
                }
            }
            LogManager.i(TAG, "Successfully saved new distance model file", new Object[0]);
            return true;
        } catch (Exception e) {
            LogManager.w(e, TAG, "Cannot write updated distance model to local storage", new Object[0]);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused2) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    private void requestModelMapFromWeb() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            LogManager.w(TAG, "App has no android.permission.INTERNET permission.  Cannot check for distance model updates", new Object[0]);
        } else {
            new ModelSpecificDistanceUpdater(this.mContext, this.mRemoteUpdateUrlString, new ModelSpecificDistanceUpdater.CompletionHandler() {
                public void onComplete(String str, Exception exc, int i) {
                    if (exc != null) {
                        LogManager.w(ModelSpecificDistanceCalculator.TAG, "Cannot updated distance models from online database at %s", exc, ModelSpecificDistanceCalculator.this.mRemoteUpdateUrlString);
                    } else if (i != 200) {
                        LogManager.w(ModelSpecificDistanceCalculator.TAG, "Cannot updated distance models from online database at %s due to HTTP status code %s", ModelSpecificDistanceCalculator.this.mRemoteUpdateUrlString, Integer.valueOf(i));
                    } else {
                        LogManager.d(ModelSpecificDistanceCalculator.TAG, "Successfully downloaded distance models from online database", new Object[0]);
                        try {
                            ModelSpecificDistanceCalculator.this.buildModelMapWithLock(str);
                            if (ModelSpecificDistanceCalculator.this.saveJson(str)) {
                                boolean unused = ModelSpecificDistanceCalculator.this.loadModelMapFromFile();
                                ModelSpecificDistanceCalculator modelSpecificDistanceCalculator = ModelSpecificDistanceCalculator.this;
                                DistanceCalculator unused2 = modelSpecificDistanceCalculator.mDistanceCalculator = modelSpecificDistanceCalculator.findCalculatorForModelWithLock(modelSpecificDistanceCalculator.mRequestedModel);
                                LogManager.i(ModelSpecificDistanceCalculator.TAG, "Successfully updated distance model with latest from online database", new Object[0]);
                            }
                        } catch (JSONException e) {
                            LogManager.w(e, ModelSpecificDistanceCalculator.TAG, "Cannot parse json from downloaded distance model", new Object[0]);
                        }
                    }
                }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public void buildModelMapWithLock(String str) throws JSONException {
        this.mLock.lock();
        try {
            buildModelMap(str);
        } finally {
            this.mLock.unlock();
        }
    }

    private void buildModelMap(String str) throws JSONException {
        ModelSpecificDistanceCalculator modelSpecificDistanceCalculator = this;
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONObject(str).getJSONArray("models");
        int i = 0;
        while (i < jSONArray.length()) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            boolean z = jSONObject.has("default") ? jSONObject.getBoolean("default") : false;
            double d = jSONObject.getDouble("coefficient1");
            Double valueOf = Double.valueOf(d);
            double d2 = jSONObject.getDouble("coefficient2");
            Double valueOf2 = Double.valueOf(d2);
            double d3 = jSONObject.getDouble("coefficient3");
            Double valueOf3 = Double.valueOf(d3);
            String string = jSONObject.getString("version");
            JSONArray jSONArray2 = jSONArray;
            String string2 = jSONObject.getString("build_number");
            int i2 = i;
            String string3 = jSONObject.getString("model");
            String string4 = jSONObject.getString("manufacturer");
            valueOf.getClass();
            valueOf2.getClass();
            valueOf3.getClass();
            CurveFittedDistanceCalculator curveFittedDistanceCalculator = new CurveFittedDistanceCalculator(d, d2, d3);
            AndroidModel androidModel = new AndroidModel(string, string2, string3, string4);
            hashMap.put(androidModel, curveFittedDistanceCalculator);
            modelSpecificDistanceCalculator = this;
            if (z) {
                modelSpecificDistanceCalculator.mDefaultModel = androidModel;
            }
            i = i2 + 1;
            jSONArray = jSONArray2;
        }
        modelSpecificDistanceCalculator.mModelMap = hashMap;
    }

    private void loadDefaultModelMap() {
        try {
            buildModelMap(stringFromFilePath(CONFIG_FILE));
        } catch (Exception e) {
            this.mModelMap = new HashMap();
            LogManager.e(e, TAG, "Cannot build model distance calculations", new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String stringFromFilePath(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "/"
            java.lang.String r1 = "Cannot load resource at "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            java.lang.Class<org.altbeacon.beacon.distance.ModelSpecificDistanceCalculator> r4 = org.altbeacon.beacon.distance.ModelSpecificDistanceCalculator.class
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r5.<init>(r0)     // Catch:{ all -> 0x007d }
            r5.append(r8)     // Catch:{ all -> 0x007d }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x007d }
            java.io.InputStream r4 = r4.getResourceAsStream(r5)     // Catch:{ all -> 0x007d }
            if (r4 != 0) goto L_0x0039
            java.lang.Class r5 = r7.getClass()     // Catch:{ all -> 0x0037 }
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ all -> 0x0037 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0037 }
            r6.<init>(r0)     // Catch:{ all -> 0x0037 }
            r6.append(r8)     // Catch:{ all -> 0x0037 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0037 }
            java.io.InputStream r4 = r5.getResourceAsStream(r0)     // Catch:{ all -> 0x0037 }
            goto L_0x0039
        L_0x0037:
            r8 = move-exception
            goto L_0x007f
        L_0x0039:
            if (r4 == 0) goto L_0x006b
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x0037 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = "UTF-8"
            r0.<init>(r4, r1)     // Catch:{ all -> 0x0037 }
            r8.<init>(r0)     // Catch:{ all -> 0x0037 }
            java.lang.String r0 = r8.readLine()     // Catch:{ all -> 0x0067 }
        L_0x004b:
            if (r0 == 0) goto L_0x005a
            r2.append(r0)     // Catch:{ all -> 0x0067 }
            r0 = 10
            r2.append(r0)     // Catch:{ all -> 0x0067 }
            java.lang.String r0 = r8.readLine()     // Catch:{ all -> 0x0067 }
            goto L_0x004b
        L_0x005a:
            r8.close()
            if (r4 == 0) goto L_0x0062
            r4.close()
        L_0x0062:
            java.lang.String r8 = r2.toString()
            return r8
        L_0x0067:
            r0 = move-exception
            r3 = r8
            r8 = r0
            goto L_0x007f
        L_0x006b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0037 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0037 }
            r2.<init>(r1)     // Catch:{ all -> 0x0037 }
            r2.append(r8)     // Catch:{ all -> 0x0037 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x0037 }
            r0.<init>(r8)     // Catch:{ all -> 0x0037 }
            throw r0     // Catch:{ all -> 0x0037 }
        L_0x007d:
            r8 = move-exception
            r4 = r3
        L_0x007f:
            if (r3 == 0) goto L_0x0084
            r3.close()
        L_0x0084:
            if (r4 == 0) goto L_0x0089
            r4.close()
        L_0x0089:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.distance.ModelSpecificDistanceCalculator.stringFromFilePath(java.lang.String):java.lang.String");
    }
}
