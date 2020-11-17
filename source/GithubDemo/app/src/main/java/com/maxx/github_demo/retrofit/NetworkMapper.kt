package com.maxx.github_demo.retrofit

import com.maxx.github_demo.model.Commit
import com.maxx.github_demo.retrofit.model.GetCommitResponseItem
import com.maxx.github_demo.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<GetCommitResponseItem, Commit> {
    override fun mapFromEntity(entity: GetCommitResponseItem): Commit {
        val authorName = entity.commit.author.name
        val date = entity.commit.author.date
        val commitMessage = entity.commit.message

        return Commit(
            authorName = authorName,
            date = date,
            commitMessage = commitMessage
        )
    }

    fun mapFromEntityList(entities: ArrayList<GetCommitResponseItem>): List<Commit> {
        return entities.map {
            mapFromEntity(it)
        }
    }

}