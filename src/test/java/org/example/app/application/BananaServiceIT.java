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
import org.example.app.infrastructure.persistence.BananaRepositoryFactory;
import org.example.app.infrastructure.persistence.RepositoryTypeEnum;
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
    public void init() {
        settings = new Settings();
        bananaService = new BananaService(settings, new BananaRepositoryFactory());
    }
    
    @Test
    public void test() {
        // test with jdbc
        settings.setRepositoryType(RepositoryTypeEnum.JDBC);
        assertEquals("JDBC", bananaService.findBananaById(Long.MIN_VALUE).getMessage());
        
        // test with json
        settings.setRepositoryType(RepositoryTypeEnum.JSON);
        assertEquals("JSON", bananaService.findBananaById(Long.MIN_VALUE).getMessage());
    }
    
}
