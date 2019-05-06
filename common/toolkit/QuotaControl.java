package com.kddi.android.UtaPass.sqa_espresso.common.toolkit;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class QuotaControl {
    private String API_GET_QUOTA = "http://utapass-myuta-console.shawnpeng.voyager.kk-box.com/bin/quota-creater.php";
    private String API_GET_MSNO = "http://console.wesleyliao.voyager.kk-box.com/api/mybox_user.php?msno=&uid=YPAU%3A%3A";
    private String API_REVOKE_ALL_QUOTA = "http://utapass-myuta-console.shawnpeng.voyager.kk-box.com/bin/quota-revoke-all.php";

    private String msno;

    public QuotaControl( String auid ){
        HashMap map = new HashMap();

        map.put( "08068775827", "338089643018" );
        map.put( "07021406916", "338084817420" );
        map.put( "07036330654", "338082603024" );
        map.put( "07036329884", "338083985037" );
        map.put( "07036361873", "338084662818" );

        this.msno = map.get( auid ).toString();
    }

    public String getAuID(){
        return this.msno;
    }

    public void get20Quota() {
        getQuota( this.msno, "20");
    }

    public void getQuota( String msno, String quota ){
        OkHttpClient client = new OkHttpClient();

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
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void revokeAllQuota(){
        OkHttpClient client = new OkHttpClient();

        FormBody formBody = new FormBody.Builder()
                .add("msno", this.getAuID() )
                .build();

        Request request = new Request.Builder()
                .url( this.API_REVOKE_ALL_QUOTA )
                .post(formBody) // 使用post連線
                .build();

        try {
            client.newCall(request).execute();
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
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
