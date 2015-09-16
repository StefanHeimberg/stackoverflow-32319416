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

import org.example.app.infrastructure.persistence.BananaRepositoryFactory;
import org.example.app.infrastructure.persistence.RepositoryTypeEnum;
import org.example.app.infrastructure.persistence.jdbc.JdbcBananaRepository;
import org.example.app.infrastructure.persistence.json.JsonBananaRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Stefan Heimberg <kontakt@stefanheimberg.ch>
 */
public class BananaServiceIT {

    private Settings settings;
    private BananaService bananaService;

    @Before
    public void injectDependencies() {
        settings = new Settings();
        final JdbcBananaRepository jdbcBananaRepository = new JdbcBananaRepository();
        final JsonBananaRepository jsonBananaRepository = new JsonBananaRepository();
        final BananaRepositoryFactory bananaRepositoryFactory = new BananaRepositoryFactory(jdbcBananaRepository, jsonBananaRepository);
        bananaService = new BananaService(settings, bananaRepositoryFactory);
    }

    @Test
    public void test_findBananaById() {
        // test with jdbc
        settings.setRepositoryType(RepositoryTypeEnum.JDBC);
        assertEquals("JDBC-331", bananaService.findBananaById(331l).getMessage());

        // test with json
        settings.setRepositoryType(RepositoryTypeEnum.JSON);
        assertEquals("JSON-841", bananaService.findBananaById(841l).getMessage());
    }
    
    @Test
    public void test_getApples() {
        // test with jdbc
        settings.setRepositoryType(RepositoryTypeEnum.JDBC);
        assertEquals(2, bananaService.getBananas().size());
        
        // test with json
        settings.setRepositoryType(RepositoryTypeEnum.JSON);
        assertEquals(3, bananaService.getBananas().size());
    }

}
