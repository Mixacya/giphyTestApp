package com.gettyimage.gettyimagetestapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gettyimage.gettyimagetestapp.R;
import com.gettyimage.gettyimagetestapp.rest.dto.Data;
import com.gettyimage.gettyimagetestapp.ui.viewholder.EmptyViewHolder;
import com.gettyimage.gettyimagetestapp.ui.viewholder.GifViewHolder;

import java.util.List;

public class GifAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_EMPTY = 0;
    private static final int VIEW_TYPE_CONTENT = 1;

    private final List<Data> items;

    public GifAdapter(final List<Data> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        if (i == VIEW_TYPE_CONTENT) {
            final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gif, viewGroup, false);
            return new GifViewHolder(view);
        }
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_empty, viewGroup, false);
        return new EmptyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int i) {
        if (holder instanceof GifViewHolder) {
            ((GifViewHolder) holder).bindImageObject(items.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return items.size() > 0 ? items.size() : 1;
    }

    @Override
    public int getItemViewType(final int position) {
        if (items.size() > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
