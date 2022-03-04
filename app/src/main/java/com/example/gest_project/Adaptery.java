package com.example.gest_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adaptery extends ArrayAdapter<Model> {
    private Context context;
    private List<Model> listData;
    private LayoutInflater inflater;

    public Adaptery(Context mcontext, List<Model>listData){
        super(mcontext,R.layout.item_post,listData);
        this.context = mcontext;
        this.listData = listData;
        inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Model getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }



    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        convertView = inflater.inflate(R.layout.item_post, null);

        Model model = getItem(position);

        String NamePro = model.getProj();
        String ChefPro = model.getChef();
        String DescPro = model.getDescription();
        int IdPro = model.getId();
        int ImagePro = model.getImg();

        /*if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_post,parent,false);
        }*/

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView project_name = convertView.findViewById(R.id.nom);
        TextView the_description = convertView.findViewById(R.id.descrip);
        TextView chef_pro = convertView.findViewById(R.id.boss);
        TextView identifiant = convertView.findViewById(R.id.id);



        imageView.setImageResource(ImagePro);
        project_name.setText(NamePro);
        the_description.setText(DescPro);
        chef_pro.setText(ChefPro);
        identifiant.setId(IdPro);

        return convertView;
    }

    /*
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_post, null);

        Model model = getItem(i);
        String project_name = model.getProj();
        String the_description = model.getDescription();
        String chef_pro = model.getChef();
        int identifiant = model.getId();

        ImageView itemIconView = view.findViewById(R.id.image);
        //String ressourceName = "item_" +memonic+ "_icon";
        //int resID = context.getResources().getIdentifier(ressourceName, "drawable", context.getPackageName());
        //itemIconView.setImageResource(resID);

        TextView textName = view.findViewById(R.id.nom);
        textName.setText(project_name);

        TextView textChef = view.findViewById(R.id.boss);
        textChef.setText(chef_pro);

        TextView textDescrip = view.findViewById(R.id.descrip);
        textDescrip.setText(the_description);

        TextView textImage = view.findViewById(R.id.id);
        textImage.setText(identifiant);

        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( context,it.class);
                context.startActivity(intent);
            }
        });*/

    }
