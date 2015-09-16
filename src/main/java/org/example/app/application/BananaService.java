/*
 * Copyright 2015 Stefan Heimberg <kontakt@stefanheimberg.ch>.
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
package org.example.app.application;

import org.example.app.domain.model.Banana;
import org.example.app.infrastructure.persistence.BananaRepositoryFactory;

/**
 *
 * @author Stefan Heimberg <kontakt@stefanheimberg.ch>
 */
public class BananaService {
    
    private final Settings settings;
    private final BananaRepositoryFactory bananaRepositoryFactory;

    public BananaService(final Settings settings, final BananaRepositoryFactory bananaRepositoryFactory) {
        this.settings = settings;
        this.bananaRepositoryFactory = bananaRepositoryFactory;
    }
    
    public Banana findBananaById(final Long bananaId) {
        return bananaRepositoryFactory
                .create(settings.getRepositoryType())
                .get(bananaId);
    }
    
}
