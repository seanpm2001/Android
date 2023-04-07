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

package com.duckduckgo.savedsites.impl.sync

import com.duckduckgo.sync.api.SyncChanges
import com.duckduckgo.sync.api.SyncMergeResult
import com.duckduckgo.sync.api.SyncMerger

class SavedSitesSyncMerger(): SyncMerger {
    override fun merge(changes: SyncChanges): SyncMergeResult<Boolean> {
        TODO("Not yet implemented")
    }
}
