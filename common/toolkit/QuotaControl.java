package com.kddi.android.UtaPass.sqa_espresso.common.toolkit;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class QuotaControl {
    private String API_GET_MSNO = "http://console.wesleyliao.voyager.kk-box.com/api/mybox_user.php?msno=&uid=YPAU%3A%3A";
    private String API_GET_QUOTA = "http://utapass-myuta-console.shawnpeng.voyager.kk-box.com/bin/quota-creater.php";
    private String API_REVOKE_ALL_QUOTA = "http://utapass-myuta-console.shawnpeng.voyager.kk-box.com/bin/quota-revoke-all.php";

    private String msno;

    public QuotaControl( String auid ){
        this.msno = auid;
    }

    public String getMSNO(){
        return this.msno;
    }

    public OkHttpClient okHttpClient(){
        return new OkHttpClient();
    }

    public void getQuota( String msno, String quota ){

        FormBody formBody = new FormBody.Builder()
                .add("msno", msno )
                .add("valid_at", "100")
                .add("number", quota )
                .build();

        Request request = new Request.Builder()
                .url( this.API_GET_QUOTA )
                .post(formBody) // 使用post連線
                .build();

        try {
            this.okHttpClient().newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void get10Quota() {
        getQuota( this.getMSNO(), "10");
    }

    public void revokeAllQuota(){
        FormBody formBody = new FormBody.Builder()
                .add("msno", this.getMSNO() )
                .build();

        Request request = new Request.Builder()
                .url( this.API_REVOKE_ALL_QUOTA )
                .post(formBody) // 使用post連線
                .build();

        try {
            this.okHttpClient().newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getmsno( String auid ){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url( this.API_GET_QUOTA + auid )
                .build();

        try {
            this.okHttpClient().newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
