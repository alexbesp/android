package com.example.alexanderbespalov.mvpedu.ui.adapters.main;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.models.main.Exercise;
import com.example.alexanderbespalov.mvpedu.models.main.ExercisesStorage;
import com.example.alexanderbespalov.mvpedu.presentation.presenter.main.MainPresenter;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by alexander.bespalov on 22.06.2017.
 */

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ExerciseItemHolder> {

    private List<Exercise> exerciseList;

    public ExercisesAdapter() {
        exerciseList = ExercisesStorage.getInstance().getExerciseList();
    }

    @Override
    public ExerciseItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View root = layoutInflater.inflate(R.layout.item_exercise, parent, false);
        return new ExerciseItemHolder(root);
    }

    @Override
    public void onBindViewHolder(ExerciseItemHolder holder, int position) {
        Exercise currentItem = exerciseList.get(position);
        holder.name.setText(currentItem.getName());
        holder.description.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
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
        Exercise exercise = exerciseList.get(this.getAdapterPosition());
            Intent i = new Intent(view.getContext(), exercise.getCls());
            startActivity(view.getContext(), i, null);
        }
    }
}
