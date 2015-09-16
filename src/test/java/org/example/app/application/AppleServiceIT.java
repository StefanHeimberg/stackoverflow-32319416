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

import org.example.app.infrastructure.persistence.AppleRepositoryFactory;
import org.example.app.infrastructure.persistence.RepositoryTypeEnum;
import org.example.app.infrastructure.persistence.jdbc.JdbcAppleRepository;
import org.example.app.infrastructure.persistence.json.JsonAppleRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Stefan Heimberg <kontakt@stefanheimberg.ch>
 */
public class AppleServiceIT {
    
    private Settings settings;
    private AppleService appleService;
    
    @Before
    public void injectDependencies() {
        settings = new Settings();
        final JdbcAppleRepository jdbcAppleRepository = new JdbcAppleRepository();
        final JsonAppleRepository jsonAppleRepository = new JsonAppleRepository();
        final AppleRepositoryFactory appleRepositoryFactory = new AppleRepositoryFactory(jdbcAppleRepository, jsonAppleRepository);
        appleService = new AppleService(settings, appleRepositoryFactory);
    }
    
    @Test
    public void test_findAppleById() {
        // test with jdbc
        settings.setRepositoryType(RepositoryTypeEnum.JDBC);
        assertEquals("JDBC-135", appleService.findAppleById(135l).getMessage());
        
        // test with json
        settings.setRepositoryType(RepositoryTypeEnum.JSON);
        assertEquals("JSON-243", appleService.findAppleById(243l).getMessage());
    }
    
    @Test
    public void test_getApples() {
        // test with jdbc
        settings.setRepositoryType(RepositoryTypeEnum.JDBC);
        assertEquals(2, appleService.getApples().size());
        
        // test with json
        settings.setRepositoryType(RepositoryTypeEnum.JSON);
        assertEquals(3, appleService.getApples().size());
    }
    
}
