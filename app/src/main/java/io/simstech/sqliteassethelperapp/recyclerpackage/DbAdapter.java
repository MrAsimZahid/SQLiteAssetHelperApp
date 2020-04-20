package io.simstech.sqliteassethelperapp.recyclerpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.simstech.sqliteassethelperapp.R;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.DbViewHolder> {

    ArrayList<DbModelClass> objDbModelClassArrayList;
    public DbAdapter(ArrayList<DbModelClass> objDbModelClassArrayList)
    {
        this.objDbModelClassArrayList = objDbModelClassArrayList;
    }

    @NonNull
    @Override
    public DbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleRow= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row,parent,false);
         return new DbViewHolder(singleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull DbViewHolder holder, int position) {
        DbModelClass objDbModelClass=objDbModelClassArrayList.get(position);
        holder.imageDesTV.setText(objDbModelClass.getImageDec());

        holder.ourImageIV.setImageBitmap(objDbModelClass.getOurImage());

    }

    @Override
    public int getItemCount() {
        return objDbModelClassArrayList.size();
    }

    public static class DbViewHolder extends RecyclerView.ViewHolder
    {
        TextView imageDesTV; ImageView ourImageIV;

        public DbViewHolder(@NonNull View itemView) {
            super(itemView);

            imageDesTV=itemView.findViewById(R.id.sr_imageDes);
            ourImageIV=itemView.findViewById(R.id.sr_image);
        }
    }

}
