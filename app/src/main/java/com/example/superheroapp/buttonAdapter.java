package com.example.superheroapp;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class buttonAdapter extends RecyclerView.Adapter<buttonAdapter.buttonViewHolder>{

    private String[] data;
    public buttonAdapter(String[] data){
        this.data=data;
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
                String heroid= URLEncoder.encode(dashboard.et.getText().toString());
                switch (position){
                    case 0:
                        task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/powerstats");
                        break;
                    case 1:
                        task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/biography");
                        break;
                    case 2:
                        task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/appearance");
                        break;
                    case 3:
                        task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/work");
                        break;
                    case 4:
                        task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/connections");
                        break;
                    case 5:
                        task.execute("https://www.superheroapi.com/api.php/2981895095389199/"+heroid+"/image");
                        break;
                }
            }
        });
    }
    public class fetchData extends AsyncTask<String,Void,String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            dashboard.tv.setText(s);


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
        protected String doInBackground(String... strings) {
            String str="";
            URL url;

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
                return str;
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

    public interface OnButtonClick extends View.OnClickListener {
        void onButtonClicked(Context context);
    }
}
