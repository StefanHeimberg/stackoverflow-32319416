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
package org.example.app.infrastructure.persistence.json;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.example.app.domain.model.Apple;
import org.example.app.domain.repository.AppleRepository;

/**
 *
 * @author Stefan Heimberg <kontakt@stefanheimberg.ch>
 */
public class JsonAppleRepository implements AppleRepository {

    private static final Logger LOG = Logger.getLogger(JsonAppleRepository.class.getName());

    @Override
    public Apple get(final Long appleId) {
        LOG.info("json get");

        // ... read in from the appropriate json-file and map the resultset to instance of apple
        
        return new Apple("JSON-" + appleId);
    }

    @Override
    public List<Apple> getAll() {
        return Arrays.asList(new Apple("JSON-1"), new Apple("JSON-2"), new Apple("JSON-3"));
    }

}
