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
import org.example.app.domain.model.Banana;
import org.example.app.domain.repository.BananaRepository;

/**
 *
 * @author Stefan Heimberg <kontakt@stefanheimberg.ch>
 */
public class JsonBananaRepository implements BananaRepository {

    private static final Logger LOG = Logger.getLogger(JsonBananaRepository.class.getName());

    @Override
    public Banana get(final Long bananaId) {
        LOG.info("json get");

        // ... read in from the appropriate json-file and map the resultset to instance of banana
        return new Banana("JSON-" + bananaId);
    }

    @Override
    public List<Banana> getAll() {

        // ... read in from the appropriate json-file and map the resultset to instance of banana
        
        return Arrays.asList(new Banana("JSON-1"), new Banana("JSON-2"), new Banana("JSON-3"));
    }

}
