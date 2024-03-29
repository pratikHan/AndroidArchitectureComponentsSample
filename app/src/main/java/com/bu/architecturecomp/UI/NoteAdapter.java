package com.bu.architecturecomp.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bu.architecturecomp.DebugX.Loggers;
import com.bu.architecturecomp.R;
import com.bu.architecturecomp.Room.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private final String TAG = "NodeAdapter";

    List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Loggers.show(TAG,"OncreateViewHolder","T");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item,parent,false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Loggers.show(TAG,"OnBindViewHolder","T");
            Note currentNote = notes.get(position);
            holder.textViewTitle.setText(currentNote.getTitle());
            holder.textViewDescription.setText(currentNote.getDescription());
            holder.textViewPriority.setText(String.valueOf(currentNote.getPriority()));

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;


        public NoteHolder(View itemView){
            super(itemView);

            Loggers.show("NoteHolder","C","T");
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority=itemView.findViewById(R.id.text_view_priority);

        }
    }
}
