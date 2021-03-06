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
package org.example.app.infrastructure.persistence.jdbc;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.example.app.domain.model.Banana;
import org.example.app.domain.repository.BananaRepository;

/**
 *
 * @author Stefan Heimberg <kontakt@stefanheimberg.ch>
 */
public class JdbcBananaRepository implements BananaRepository {
    
    private static final Logger LOG = Logger.getLogger(JdbcBananaRepository.class.getName());
    
    @Override
    public Banana get(final Long bananaId) {
        LOG.info("jdbc get");
        
        // ... query the database and map the resultset to instance of banana
        
        return new Banana("JDBC-" + bananaId);
    }

    @Override
    public List<Banana> getAll() {
        
        // ... query the database and map the resultset to instance of banana
        
        return Arrays.asList(new Banana("JDBC-1"), new Banana("JDBC-2"));
    }

}
