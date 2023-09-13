package com.mbj.compose_movieapp.features.feed.domain.usecase

import com.mbj.compose_movieapp.features.common.entity.CategoryEntity
import com.mbj.compose_movieapp.features.common.entity.EntityWrapper
import com.mbj.compose_movieapp.features.feed.domain.enum.SortOrder

interface IGetFeedCategoryUseCase {
    suspend operator fun invoke(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>

}
