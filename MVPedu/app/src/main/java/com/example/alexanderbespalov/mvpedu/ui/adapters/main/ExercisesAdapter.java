package com.example.alexanderbespalov.mvpedu.ui.adapters.main;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.model.main.Exercise;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by alexander.bespalov on 22.06.2017.
 */

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ExerciseItemHolder>  {

    private final RealmResults<Exercise> exercises;

    public ExercisesAdapter(RealmResults<Exercise> exercises) {
        this.exercises = exercises;
        this.exercises.addChangeListener(myExercises -> notifyDataSetChanged());
    }

    @Override
    public ExerciseItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View root = layoutInflater.inflate(R.layout.item_exercise, parent, false);
        return new ExerciseItemHolder(root);
    }

    @Override
    public void onBindViewHolder(ExerciseItemHolder holder, int position) {
        Exercise currentItem = exercises.get(position);
        holder.name.setText(currentItem.getName());
        holder.description.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ExerciseItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_exercise_name) TextView name;
        @BindView(R.id.tv_exercise_description) TextView description;
        @BindView(R.id.root_exerciselist_item) ViewGroup container;

        public ExerciseItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        Exercise exercise = exercises.get(this.getAdapterPosition());
            Intent i = null;
            try {
                i = new Intent(view.getContext(), Class.forName(exercise.getClassName()));
            } catch (ClassNotFoundException e) {e.printStackTrace();}
            startActivity(view.getContext(), i, null);
        }
    }
}
