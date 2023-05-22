/*
 * Copyright (c) 2023 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.sync.api.engine

interface SyncablePlugin {

    /**
     * Used by the SyncClient to get all the updates from each syncable feature
     * since a specific time
     * This data that will be sent to the Sync API
     */
    fun getChanges(since: String): SyncChanges

    /**
     * Used by the SyncClient to get the modifiedSince data per feature
     * When calling /GET to receive data we need to pass one since parameter per model we request
     * This data that will be sent to the Sync API
     */
    fun getModifiedSince(): String

    /**
     * Changes from Sync Client have been received
     * Each feature is responsible for merging and solving conflicts
     */
    fun syncChanges(
        changes: List<SyncChanges>,
        conflictResolution: SyncConflictResolution,
    ): SyncMergeResult<Boolean>

    /**
     * Sync Feature has been disabled / device has been removed
     * This is an opportunity for Features to do some local cleanup if needed
     */
    fun onSyncDisabled()

    enum class SyncConflictResolution {
        DEDUPLICATION,
        REMOTE_WINS,
        LOCAL_WINS,
        TIMESTAMP,
    }
}
