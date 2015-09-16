package org.example.app.application;

import org.example.app.infrastructure.persistence.RepositoryTypeEnum;

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

/**
 *
 * @author Stefan Heimberg <kontakt@stefanheimberg.ch>
 */
public class Settings {
    
    private RepositoryTypeEnum repositoryType;

    public Settings() {
        init();
    }
    
    private void init() {
        // Default is JDBC
        repositoryType = RepositoryTypeEnum.JDBC;
    }

    public RepositoryTypeEnum getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(RepositoryTypeEnum repositoryType) {
        this.repositoryType = repositoryType;
    }
    
}
