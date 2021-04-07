package com.example.superheroapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class buttonAdapter extends RecyclerView.Adapter<buttonAdapter.buttonViewHolder>{

    private String[] data;
    private TextView mtv;
    private TextView mtv1;
    private ImageView miv;
    private LinearLayout mparent;
    public buttonAdapter(String[] data, TextView tv, TextView tv1, ImageView iv, LinearLayout parent){
        this.data=data;
        mtv=tv;
        mtv1=tv1;
        miv=iv;
        mparent=parent;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    @NonNull
    @Override
    public buttonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.button,parent,false);
        return new buttonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull buttonAdapter.buttonViewHolder holder, int position) {
        String title=data[position];
        holder.bt.setText(title);
            holder.bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //dashboard.tv.setText(""+position);
                    fetchData task=new fetchData();
                    String heroid= URLEncoder.encode(id_dashboard.et.getText().toString());
                    if(isNumeric(heroid)){
                        switch (position){
                            case 0:
                                task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/powerstats", ""+position);
                                break;
                            case 1:
                                task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/biography", ""+position );
                                break;
                            case 2:
                                task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/appearance", ""+position);
                                break;
                            case 3:
                                task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/work", ""+position);
                                break;
                            case 4:
                                task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/connections", ""+position);
                                break;
                            case 5:
                                task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/image", ""+position);
                                break;
                        }
                    }else{
                        task.execute("https://www.superheroapi.com/api.php/2981895095389199/search/"+heroid,""+position);
                    }
                    InputMethodManager mgr=(InputMethodManager) mtv.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    mgr.hideSoftInputFromWindow(id_dashboard.et.getWindowToken(),0);

                }
            });

    }
    public class fetchData extends AsyncTask<String,Void, Pair<String, Integer>> {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        protected void onPostExecute(Pair<String, Integer> output) {
            super.onPostExecute(output);

//            String response = "";
//            String id = "";
//            String name = "";
//            String output = "";
//            try {
//                JSONObject root = new JSONObject(s);
//                response = root.getString("response");
//                id = root.getString("id");
//                name = root.getString("name");
//                output = response + " " + id + " " + name;
//            } catch (JSONException e) {
//                e.printStackTrace();
//                output = "Exception";
//            }
 //           ===================================================

//            String customJsON = "{\n" +
//                    "\t\"status\" : 200,\n" +
//                    "\t\"id\" : \"JSj#@123AsaW\",\n" +
//                    "\t\"data\" : {\n" +
//                    "\t\t\"name\" : \"Delhi\",\n" +
//                    "\t\t\"AQI\" : 129,\n" +
//                    "\t\t\"places\" : [\"Qutub Minar\", \"Akshardham\", \"Hauz Khas\"]\n" +
//                    "\t}\n" +
//                    "}";
//
//            StringBuilder output = new StringBuilder();
//            try {
//                JSONObject root = new JSONObject(customJsON);
//                JSONObject data = root.getJSONObject("data");
//                JSONArray places = data.getJSONArray("places");
//                int length = places.length();
//
//                for(int i = 0; i< length; i++)
//                    output.append(" ").append(places.get(i));
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//                output = new StringBuilder("Exception");
//            }
//            =========================================

            String data = output.first;
            Integer position = output.second;

            Gson gson = new Gson();
            String s=id_dashboard.et.getText().toString();
            if(s.length()!=0 && isNumeric(s)){
                mparent.removeAllViews();
                if(Integer.parseInt(s)>731 || Integer.parseInt(s)<1){
                    mparent.removeAllViews();
                    mtv.setText("");
                    miv.setImageDrawable(null);
                    mtv1.setText("HeroId entered by you is invalid");
                }else{
                    switch (position){
                        case 0:
                            PowerStats stats = gson.fromJson(data, PowerStats.class);
                            mtv1.setText("================\nID : "+stats.getId()+"\n"+"NAME : "+stats.getName());
                            miv.setImageDrawable(null);
                            mtv.setText(stats.toString());
                            break;
                        case 1:
                            Biography bio = gson.fromJson(data, Biography.class);
                            mtv1.setText("================\nID : "+bio.getId()+"\n"+"NAME : "+bio.getName());
                            miv.setImageDrawable(null);
                            mtv.setText(bio.toString());
                            break;
                        case 2:
                            Appearance app = gson.fromJson(data, Appearance.class);
                            mtv1.setText("================\nID : "+app.getId()+"\n"+"NAME : "+app.getName());
                            miv.setImageDrawable(null);
                            mtv.setText(app.toString());
                            break;
                        case 3:
                            Work wo = gson.fromJson(data, Work.class);
                            mtv1.setText("================\nID : "+wo.getId()+"\n"+"NAME : "+wo.getName());
                            mtv.setText(wo.toString());
                            miv.setImageDrawable(null);
                            break;
                        case 4:
                            Connection con = gson.fromJson(data, Connection.class);
                            mtv1.setText("================\nID : "+con.getId()+"\n"+"NAME : "+con.getName());
                            mtv.setText(con.toString());
                            miv.setImageDrawable(null);
                            break;
                        case 5:
                            Image img = gson.fromJson(data, Image.class);
                            mtv1.setText("================\nID : "+img.getId()+"\n"+"NAME : "+img.getName());
                            //mtv.setText(stats.toString());
                            mtv.setText("");
                            Glide.with(miv.getContext()).load(img.getUrl()).into(miv);
                            break;
                    }
                }
            }else if(s.length()!=0){
//                Type all=new TypeToken<ArrayList<AllData>>(){}.getType();
//                ArrayList<AllData> allData = gson.fromJson(data,all);
//                NewData newData = new NewData(allData);
//
                mtv.setText("");
                mtv1.setText("");
                miv.setImageDrawable(null);
                String chk="";
                try {
                    JSONObject json=new JSONObject(data);
                    chk=json.getString("response");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                mtv1.setText(chk);
                if(chk.equals("success")){
                    NewData mainData = new Gson().fromJson(data, NewData.class);

                    mparent.removeAllViews();
                    switch (position){
                        case 0:
                            for (int i = 0; i < mainData.getResults().size(); i++) {
                                TextView tv = new TextView(mtv.getContext());
                                tv.setText("================\nId : "+mainData.getResults().get(i).getId()+"\nName : "+mainData.getResults().get(i).getName());
                                tv.setTextSize(40);
                                TextView tv1 = new TextView(mtv.getContext());
                                tv1.setText("\n"+mainData.getResults().get(i).getStats().toString());
                                tv1.setTextSize(24);
                                mparent.addView(tv);
                                mparent.addView(tv1);
                            }
                            break;
                        case 1:
                            for (int i = 0; i < mainData.getResults().size(); i++) {
                                TextView tv = new TextView(mtv.getContext());
                                tv.setText("================\nId : "+mainData.getResults().get(i).getId()+"\nName : "+mainData.getResults().get(i).getName());
                                tv.setTextSize(40);
                                TextView tv1 = new TextView(mtv.getContext());
                                tv1.setText("\n"+mainData.getResults().get(i).getBiograph().toString());
                                tv1.setTextSize(24);
                                mparent.addView(tv);
                                mparent.addView(tv1);
                            }
                            break;
                        case 2:
                            for (int i = 0; i < mainData.getResults().size(); i++) {
                                TextView tv = new TextView(mtv.getContext());
                                tv.setText("================\nId : "+mainData.getResults().get(i).getId()+"\nName : "+mainData.getResults().get(i).getName());
                                tv.setTextSize(40);
                                TextView tv1 = new TextView(mtv.getContext());
                                tv1.setText("\n"+mainData.getResults().get(i).getAppe().toString());
                                tv1.setTextSize(24);
                                mparent.addView(tv);
                                mparent.addView(tv1);
                            }
                            break;
                        case 3:
                            for (int i = 0; i < mainData.getResults().size(); i++) {
                                TextView tv = new TextView(mtv.getContext());
                                tv.setText("================\nId : "+mainData.getResults().get(i).getId()+"\nName : "+mainData.getResults().get(i).getName());
                                tv.setTextSize(40);
                                TextView tv1 = new TextView(mtv.getContext());
                                tv1.setText("\n"+mainData.getResults().get(i).getWor().toString());
                                tv1.setTextSize(24);
                                mparent.addView(tv);
                                mparent.addView(tv1);
                            }
                            break;
                        case 4:
                            for (int i = 0; i < mainData.getResults().size(); i++) {
                                TextView tv = new TextView(mtv.getContext());
                                tv.setText("================\nId : "+mainData.getResults().get(i).getId()+"\nName : "+mainData.getResults().get(i).getName());
                                tv.setTextSize(40);
                                TextView tv1 = new TextView(mtv.getContext());
                                tv1.setText("\n"+mainData.getResults().get(i).getConnn().toString());
                                tv1.setTextSize(24);
                                mparent.addView(tv);
                                mparent.addView(tv1);
                            }
                            break;
                        case 5:

                            for (int i = 0; i < mainData.getResults().size(); i++) {
                                TextView tv = new TextView(mtv.getContext());
                                tv.setText("================\nId : "+mainData.getResults().get(i).getId()+"\nName : "+mainData.getResults().get(i).getName()+"\n");
                                tv.setTextSize(40);
                                mparent.addView(tv);
                                try {
                                    ImageView iv = new ImageView(miv.getContext());
                                    String url=mainData.getResults().get(i).getImgs().getUrl();
                                    Glide.with(miv.getContext()).load(url).into(iv);
                                    mparent.addView(iv);
                                } catch (Exception e) {
                                    tv.setText(e.toString());
                                }
                            }
                            break;
                    }
//                NewData newData = new NewData(allData);
//
//                for (int i = 0; i < newData.getResults().size(); i++) {
//                    TextView tv = new TextView(mtv.getContext());
//                    tv.setText(newData.getResults().get(i).getName());
//                    mparent.addView(tv);
//                }

                }else{
                    mtv.setText("");
                    mtv1.setText("");
                    miv.setImageDrawable(null);
                    mparent.removeAllViews();
                    mtv1.setText("HeroName entered by you is not in list try by some other name");
                }

                //mtv.setText(data);
            }else{
                mtv1.setText("Enter HeroId or HeroName");
            }
//


//            String message="";
//            JSONArray ja= null;
//            try {
//                ja = new JSONArray(s);
//                JSONObject jo= (JSONObject) ja.get(0);
//                //message="name : "+jo.get("name")++"\n"
//                message="response : "+jo.get("response")+"\n"+
//                        "name : "+jo.get("name")+"\n";
//
//                dashboard.tv.setText(message);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        }

        @Override
        protected Pair<String, Integer> doInBackground(String... strings) {
            String str="";
            URL url;
            Integer position = Integer.parseInt(strings[1]);
            try{
                url=new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);
                int data=reader.read();

                while(data != -1)
                {
                    char ch=(char)data;
                    str+=ch;
                    data=reader.read();
                }
                return new Pair(str, position);
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }
    @Override
    public int getItemCount() {
        return data.length;
    }

//    public class buttonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        Button bt;
//        TextView tv;
//        public buttonViewHolder(View itemView){
//            super(itemView);
//            bt=itemView.findViewById(R.id.but);
//            bt.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            int position=this.getAdapterPosition();
//            Toast.makeText(v.getContext(),"position pressed is"+position,Toast.LENGTH_SHORT).show();
//            tv=itemView.findViewById(R.id.tv);
//            tv.setText(""+position);
//        }
//    }
    public class buttonViewHolder extends RecyclerView.ViewHolder{
        Button bt;
        TextView tv;
        public buttonViewHolder(View itemView){
            super(itemView);
            bt=itemView.findViewById(R.id.but);
            tv=itemView.findViewById(R.id.tv);
        }
    }

//    public interface OnButtonClick extends View.OnClickListener {
//        void onButtonClicked(Context context);
//    }
}
