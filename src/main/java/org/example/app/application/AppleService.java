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

import org.example.app.domain.model.Apple;
import org.example.app.infrastructure.persistence.AppleRepositoryFactory;

/**
 *
 * @author Stefan Heimberg <kontakt@stefanheimberg.ch>
 */
public class AppleService {

    private final Settings settings;
    private final AppleRepositoryFactory appleRepositoryFactory;
    
    public AppleService(final Settings settings, final AppleRepositoryFactory appleRepositoryFactory) {
        this.settings = settings;
        this.appleRepositoryFactory = appleRepositoryFactory;
    }

    public Apple findAppleById(final Long bananaId) {
        return appleRepositoryFactory
                .create(settings.getRepositoryType())
                .get(bananaId);
    }

}
