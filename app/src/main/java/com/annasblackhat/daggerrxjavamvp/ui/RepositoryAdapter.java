package com.annasblackhat.daggerrxjavamvp.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.annasblackhat.daggerrxjavamvp.BR;
import com.annasblackhat.daggerrxjavamvp.databinding.ListItemRepositoryBinding;
import com.annasblackhat.daggerrxjavamvp.model.Repository;

import java.util.List;

/**
 * Created by Gideon on 28/02/2017.
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolderRepository> {

    private List<Repository> repositoryList;

    public RepositoryAdapter(List<Repository> repositoryList) {
        this.repositoryList = repositoryList;
    }

    @Override
    public ViewHolderRepository onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemRepositoryBinding binding = ListItemRepositoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolderRepository(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolderRepository holder, int position) {
        holder.viewDataBinding.setVariable(BR.repo, repositoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    class ViewHolderRepository extends RecyclerView.ViewHolder{

        private ViewDataBinding viewDataBinding;

        public ViewHolderRepository(View itemView) {
            super(itemView);
            viewDataBinding = DataBindingUtil.bind(itemView);
        }
    }
}
