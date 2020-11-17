package com.maxx.github_demo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxx.github_demo.databinding.AdapterCommitBinding
import com.maxx.github_demo.model.Commit

class CommitAdapter(private val commitList: List<Commit>) :
    RecyclerView.Adapter<CommitAdapter.CommitHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitHolder {
        val itemBinding =
            AdapterCommitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommitHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CommitHolder, position: Int) {
        val paymentBean = commitList[position]
        holder.bind(paymentBean)
    }

    override fun getItemCount(): Int = commitList.size

    class CommitHolder(private val itemBinding: AdapterCommitBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(commit: Commit) {
            itemBinding.apply {
                authorNameTextView.text = commit.authorName
                dateTextView.text = commit.date
                messageTextView.text = commit.commitMessage
            }
        }
    }
}