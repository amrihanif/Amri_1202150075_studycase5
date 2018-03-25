package com.example.amrihanif.amri_1202150075_studycase5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Amri hanif on 24/03/2018.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private Context context;
    private List<ModelToDo> item;
    int id;

    public ToDoAdapter(Context context, List<ModelToDo> item, int id) {
        this.context = context;
        this.item = item;
        this.id = id;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(context).inflate(R.layout.listadapter,parent,false);
        ViewHolder model = new ViewHolder(V);
        return  model;
    }

    @Override
    public void onBindViewHolder(ToDoAdapter.ViewHolder holder, int position) {
        ModelToDo model = item.get(position);
        holder.namaTodo.setText(model.getNameTodo());
        holder.description.setText(model.getDescription());
        holder.priority.setText(model.getPriority());
        holder.eView.setCardBackgroundColor(context.getResources().getColor(this.id));
    }

    public ModelToDo getItem(int position){
        return item.get(position);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView namaTodo, description, priority;
        public CardView eView;
        public ViewHolder(View itemView) {
            super(itemView);

            namaTodo = itemView.findViewById(R.id.todoName);
            description = itemView.findViewById(R.id.todoDesc);
            priority = itemView.findViewById(R.id.todoPriority);
            eView = itemView.findViewById(R.id.card);
        }
    }
    public void remove(int i){
        item.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, item.size());
    }
}
