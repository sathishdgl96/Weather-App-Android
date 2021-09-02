package com.smetutorials.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherRVAdapter extends RecyclerView.Adapter<WeatherRVAdapter.ViewHolder>

{
    private Context context;
    private ArrayList<WeatherRVModel> weatherRVModelArrayList;

    public WeatherRVAdapter(Context context, ArrayList<WeatherRVModel> weatherRVModelArrayList) {
        this.context = context;
        this.weatherRVModelArrayList = weatherRVModelArrayList;
    }

    @NonNull
    @Override
    public WeatherRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.weather_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherRVAdapter.ViewHolder holder, int position) {
        WeatherRVModel modal=weatherRVModelArrayList.get(position);
        holder.temperatureTv.setText(modal.getTemperature()+"°c");
        Picasso.get().load("https:".concat(modal.getIcon())).into(holder.conditionIV);
        holder.windTv.setText(modal.getWindSpeed()+"km/h");
        SimpleDateFormat input=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat output=new SimpleDateFormat("hh:mm aa");
        try
        {
            Date t=input.parse(modal.getTime());
            holder.timeTv.setText(output.format(t));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return weatherRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView windTv,temperatureTv,timeTv;
        private ImageView conditionIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            windTv=itemView.findViewById(R.id.idTvWindSpeed);
            temperatureTv=itemView.findViewById(R.id.idTVTemperature);
            timeTv=itemView.findViewById(R.id.idTVTime);
            conditionIV=itemView.findViewById(R.id.idTVCondition);
        }
    }
}
